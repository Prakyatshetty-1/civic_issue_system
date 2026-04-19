package com.civic.javacivic.controller;

import com.civic.javacivic.dto.AssignDTO;
import com.civic.javacivic.model.*;
import com.civic.javacivic.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AdminController {

    private final ComplaintRepository complaintRepository;
    private final DepartmentRepository departmentRepository;

    @GetMapping("/complaints")
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        return ResponseEntity.ok(complaintRepository.findAll());
    }

    @PutMapping("/assign/{complaintId}")
    public ResponseEntity<?> assignDepartment(
            @PathVariable Long complaintId,
            @RequestBody AssignDTO dto) {

        Complaint complaint = complaintRepository.findById(complaintId)
            .orElseThrow(() -> new RuntimeException("Complaint not found"));

        Department dept = departmentRepository.findByName(dto.getDepartmentName())
            .orElseThrow(() -> new RuntimeException("Department not found"));

        complaint.setDepartment(dept);
        complaint.setStatus(Complaint.Status.ASSIGNED);
        complaint.setAdminComment(dto.getAdminComment());
        complaintRepository.save(complaint);

        return ResponseEntity.ok(Map.of("message", "Complaint assigned successfully"));
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<?> updateStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {

        Complaint complaint = complaintRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Complaint not found"));

        complaint.setStatus(Complaint.Status.valueOf(body.get("status")));
        if (body.containsKey("adminComment")) {
            complaint.setAdminComment(body.get("adminComment"));
        }
        complaintRepository.save(complaint);

        return ResponseEntity.ok(Map.of("message", "Status updated"));
    }
}

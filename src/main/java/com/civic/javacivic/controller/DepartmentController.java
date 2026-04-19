package com.civic.javacivic.controller;

import com.civic.javacivic.model.*;
import com.civic.javacivic.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DepartmentController {

    private final ComplaintRepository complaintRepository;
    private final UserRepository userRepository;

    @GetMapping("/complaints")
    public ResponseEntity<List<Complaint>> getDeptComplaints(Authentication auth) {
        User user = userRepository.findByEmail(auth.getName()).orElseThrow();
        return ResponseEntity.ok(
            complaintRepository.findByDepartment(user.getDepartment())
        );
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<?> updateStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body,
            Authentication auth) {

        User deptAdmin = userRepository.findByEmail(auth.getName()).orElseThrow();

        Complaint complaint = complaintRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Complaint not found"));

        // Security: ensure complaint belongs to this department
        if (complaint.getDepartment() == null || !complaint.getDepartment().getId().equals(deptAdmin.getDepartment().getId())) {
            return ResponseEntity.status(403).body(Map.of("error", "Access denied"));
        }

        complaint.setStatus(Complaint.Status.valueOf(body.get("status")));
        if (body.containsKey("adminComment")) {
            complaint.setAdminComment(body.get("adminComment"));
        }
        complaintRepository.save(complaint);

        return ResponseEntity.ok(Map.of("message", "Status updated"));
    }
}

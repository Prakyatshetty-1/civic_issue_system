package com.civic.javacivic.controller;

import com.civic.javacivic.dto.ComplaintDTO;
import com.civic.javacivic.model.*;
import com.civic.javacivic.repository.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final ComplaintRepository complaintRepository;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    @PostMapping("/complaints")
    public ResponseEntity<?> createComplaint(
            @Valid @RequestBody ComplaintDTO dto,
            Authentication auth) {

        User user = userRepository.findByEmail(auth.getName())
            .orElseThrow();

        Complaint complaint = new Complaint();
        complaint.setCategory(dto.getCategory());
        complaint.setDescription(dto.getDescription());
        complaint.setAddress(dto.getAddress());
        complaint.setImageUrl(dto.getImageUrl());
        complaint.setStatus(Complaint.Status.ASSIGNED); // Automatically assigned
        complaint.setUser(user);

        // Auto-assignment logic based on Category
        Department.DepartmentName deptName = mapCategoryToDepartment(dto.getCategory());
        Department department = departmentRepository.findByName(deptName)
                .orElseThrow(() -> new RuntimeException("Department not found: " + deptName));
        
        complaint.setDepartment(department);

        complaintRepository.save(complaint);
        return ResponseEntity.ok(Map.of("message", "Complaint submitted and assigned to " + deptName));
    }

    private Department.DepartmentName mapCategoryToDepartment(Complaint.Category category) {
        return switch (category) {
            case POTHOLE, ROAD_DAMAGE -> Department.DepartmentName.ROADS_INFRASTRUCTURE;
            case GARBAGE, DRAINAGE, SEWAGE_BLOCKAGE -> Department.DepartmentName.SANITATION;
            case STREETLIGHT, ELECTRICAL_FAULT -> Department.DepartmentName.ELECTRICITY;
            case WATER_LEAKAGE, WATER_SUPPLY_ISSUE -> Department.DepartmentName.WATER;
            case PUBLIC_PROPERTY_DAMAGE -> Department.DepartmentName.PUBLIC_WORKS;
        };
    }

    @GetMapping("/complaints")
    public ResponseEntity<List<Complaint>> getMyComplaints(Authentication auth) {
        User user = userRepository.findByEmail(auth.getName())
            .orElseThrow();
        return ResponseEntity.ok(complaintRepository.findByUser(user));
    }
}

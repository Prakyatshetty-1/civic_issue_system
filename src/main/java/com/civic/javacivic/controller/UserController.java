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
        complaint.setStatus(Complaint.Status.OPEN);
        complaint.setUser(user);

        complaintRepository.save(complaint);
        return ResponseEntity.ok(Map.of("message", "Complaint submitted successfully"));
    }

    @GetMapping("/complaints")
    public ResponseEntity<List<Complaint>> getMyComplaints(Authentication auth) {
        User user = userRepository.findByEmail(auth.getName())
            .orElseThrow();
        return ResponseEntity.ok(complaintRepository.findByUser(user));
    }
}

package com.civic.javacivic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(length = 1000, nullable = false)
    private String description;

    @Column(nullable = false)
    private String address;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.OPEN;

    @Column(length = 500)
    private String adminComment;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "password"})
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Department department;

    public enum Category {
        POTHOLE, ROAD_DAMAGE, GARBAGE, DRAINAGE, SEWAGE_BLOCKAGE, 
        STREETLIGHT, ELECTRICAL_FAULT, WATER_LEAKAGE, 
        WATER_SUPPLY_ISSUE, PUBLIC_PROPERTY_DAMAGE
    }

    public enum Status {
        OPEN, ASSIGNED, IN_PROGRESS, PENDING_RESOLUTION, RESOLVED
    }
}

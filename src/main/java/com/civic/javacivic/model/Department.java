package com.civic.javacivic.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private DepartmentName name;

    public enum DepartmentName {
        SANITATION, WATER, ELECTRICITY, ROADS_INFRASTRUCTURE, PUBLIC_WORKS
    }
}

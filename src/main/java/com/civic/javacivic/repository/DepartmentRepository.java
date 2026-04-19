package com.civic.javacivic.repository;

import com.civic.javacivic.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(Department.DepartmentName name);
}

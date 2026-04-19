package com.civic.javacivic.repository;

import com.civic.javacivic.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByUser(User user);
    List<Complaint> findByDepartment(Department department);
    List<Complaint> findByStatus(Complaint.Status status);
}

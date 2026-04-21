package com.civic.javacivic.config;

import com.civic.javacivic.model.Department;
import com.civic.javacivic.model.User;
import com.civic.javacivic.repository.DepartmentRepository;
import com.civic.javacivic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // 1. Seed Departments
        seedDepartments();

        // 2. Seed Admin and Dept Admins
        seedUsers();
    }

    private void seedDepartments() {
        for (Department.DepartmentName name : Department.DepartmentName.values()) {
            if (departmentRepository.findByName(name).isEmpty()) {
                Department dept = new Department();
                dept.setName(name);
                departmentRepository.save(dept);
            }
        }
    }

    private void seedUsers() {
        // Main Admin
        if (userRepository.findByEmail("admin@civic.com").isEmpty()) {
            User admin = new User();
            admin.setName("Main Admin");
            admin.setEmail("admin@civic.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(User.Role.ROLE_MAIN_ADMIN);
            userRepository.save(admin);
        }

        // Dept Admins
        createDeptAdmin("Sanitation Admin", "sanitation@civic.com", "dept123", Department.DepartmentName.SANITATION);
        createDeptAdmin("Water Admin", "water@civic.com", "dept123", Department.DepartmentName.WATER);
        createDeptAdmin("Electricity Admin", "electricity@civic.com", "dept123", Department.DepartmentName.ELECTRICITY);
        createDeptAdmin("Roads Admin", "roads@civic.com", "dept123", Department.DepartmentName.ROADS_INFRASTRUCTURE);
        createDeptAdmin("Public Works Admin", "publicworks@civic.com", "dept123", Department.DepartmentName.PUBLIC_WORKS);
    }

    private void createDeptAdmin(String name, String email, String password, Department.DepartmentName deptName) {
        if (userRepository.findByEmail(email).isEmpty()) {
            Department dept = departmentRepository.findByName(deptName)
                    .orElseThrow(() -> new RuntimeException("Dept not found: " + deptName));
            
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole(User.Role.ROLE_DEPT_ADMIN);
            user.setDepartment(dept);
            userRepository.save(user);
        }
    }
}

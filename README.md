# Civic Issue Reporting System (JavaCivic)

A full-stack web application for civil grievance redressal, enabling citizens to report issues (potholes, sanitation, infrastructure) and track their resolution progress. Built with Spring Boot and modern web technologies.

## Architecture Overview

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                           JavaCivic Architecture                            │
├─────────────────────────────────────────────────────────────────────────────┤
│                                                                             │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐     │
│  │   Admin      │  │ Department   │  │    User      │  │   Public     │     │
│  │  Dashboard   │  │  Dashboard   │  │ Dashboard    │  │  Views       │     │
│  └──────────────┘  └──────────────┘  └──────────────┘  └──────────────┘     |
│         │                 │                  │                  │           │
│         └─────────────────┴──────────────────┴──────────────────┘           │
│                           │                                                 │
│                  ┌────────▼────────┐                                        │
│                  │  Web Frontend   │  (Thymeleaf + Bootstrap)               │
│                  └────────┬────────┘                                        │
│                           │                                                 │
│         ┌─────────────────┼─────────────────┐                               │
│         │                 │                 │                               │
│  ┌──────▼──────┐  ┌──────▼──────┐  ┌──────▼──────┐                          │
│  │ Auth        │  │ Complaint   │  │  User       │                          │
│  │ Controller  │  │ Controller  │  │ Controller  │                          │
│  └──────┬──────┘  └──────┬──────┘  └──────┬──────┘                          │
│         │                 │                 │                               │
│  ┌──────▼──────┐  ┌──────▼──────┐  ┌──────▼──────┐                          │
│  │ AuthService │  │ Complaint   │  │ UserService │                          │
│  └──────┬──────┘  └──────┬──────┘  └──────┬──────┘                          │
│         │                 │                 │                               │
│  ┌──────▼──────┐  ┌──────▼──────┐  ┌──────▼──────┐                          │
│  │ UserRepository│ │ ComplaintRepo│ │ DeptRepo    │                         │
│  └─────────────┘  └─────────────┘  └─────────────┘                          │
│                                                                             │
│  ┌──────────────────────────────────────────────────────┐                   │
│  │                   JWT Security Layer                   │                 │
│  │  Authentication → JwtFilter → UserDetailsServiceImpl │                   │
│  └──────────────────────────────────────────────────────┘                   │
└─────────────────────────────────────────────────────────────────────────────┘
```

## Features

### For Citizens (Users)
- **Register/Login** - Secure authentication with JWT tokens
- **Report Issues** - Submit complaints across 10+ categories (potholes, water, electricity, etc.)
- **Track Status** - Real-time updates on complaint resolution progress
- **Role-Based Access** - Different experiences based on user role (user/dept-admin/main-admin)

### For Department Officials
- **Complaint Queue** - View all complaints assigned to their department
- **Update Status** - Mark complaints as in-progress, resolved, or rejected
- **Assign Complaints** - Redistribute complaints within department team

### For Administrators
- **System Overview** - Dashboard with aggregate statistics
- **User Management** - Create and manage user accounts
- **Department Assignment** - Assign complaints to appropriate departments
- **System Configuration** - Manage departments and system settings

## Project Structure

```
src/main/java/com/civic/javacivic/
├── JavacivicApplication.java          # Main Spring Boot application
├── config/
│   ├── DataInitializer.java           # Seed departments and admin users
│   └── SecurityConfig.java            # Spring Security configuration
├── controller/
│   ├── AuthController.java            # Login/Registration endpoints
│   ├── UserController.java            # User complaint operations
│   ├── AdminController.java           # Admin operations
│   └── DepartmentController.java      # Department-specific operations
├── service/
│   └── AuthService.java               # Authentication logic
├── repository/
│   ├── UserRepository.java            # User data access
│   ├── DepartmentRepository.java      # Department data access
│   └── ComplaintRepository.java       # Complaint data access
├── model/
│   ├── User.java                      # User entity
│   ├── Department.java                # Department entity
│   └── Complaint.java                 # Complaint entity
├── dto/
│   ├── RegisterRequest.java           # Registration input
│   ├── LoginRequest.java              # Login input
│   ├── ComplaintDTO.java              # Complaint data transfer
│   └── AssignDTO.java                 # Assignment input
└── security/
    ├── JwtUtil.java                   # JWT token generation/validation
    ├── UserDetailsServiceImpl.java    # User details loading
    └── JwtFilter.java                 # JWT request filter
```

## Technology Stack

| Layer | Technology |
|-------|------------|
| Backend | Spring Boot 3.5.13, Spring Data JPA, Spring Security |
| Frontend | HTML5, Bootstrap 5, JavaScript (Vanilla) |
| Database | H2 (development), PostgreSQL (production) |
| Authentication | JWT (JSON Web Tokens) |
| Build | Maven |

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.8+

### Build and Run

```bash
# Build the project
mvn clean package

# Run the application
mvn spring-boot:run

# Access the application
# Main: http://localhost:8080
# Login: http://localhost:8080/login.html
# Register: http://localhost:8080/register.html
```

### Default Credentials (auto-seeded)

| Role | Email | Password |
|------|-------|----------|
| Main Admin | admin@javacivic.com | admin123 |
| Department Admin | dept@javacivic.com | dept123 |
| User | user@javacivic.com | user123 |

## Database Schema

### User
- id, name, email, password, role, department_id, created_at

### Department
- id, name, description, created_at

### Complaint
- id, title, description, category, status, user_id, department_id, created_at, updated_at

## Authentication Flow

```
1. User submits credentials → AuthController
2. AuthService validates → Generates JWT token
3. Token stored in localStorage
4. JwtFilter intercepts requests
5. Token validated → User loaded → Request processed
```

## Key Design Decisions

1. **JWT Authentication** - Stateless authentication for scalability
2. **Role-Based Access Control** - Three-tier access (user, dept-admin, main-admin)
3. **Department Assignment** - Complaints routed to relevant departments automatically
4. **Status Tracking** - Complaint states: pending, in-progress, resolved, rejected
5. **Categorization** - 10+ complaint categories for efficient routing

## Future Enhancements

- Email notifications for status updates
- File upload for complaint evidence
- Analytics dashboard for trend analysis
- Mobile app for iOS/Android
- Chat integration for user-department communication

## License

MIT License

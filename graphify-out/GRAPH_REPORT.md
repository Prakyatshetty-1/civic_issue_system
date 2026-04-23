# Graph Report - .  (2026-04-23)

## Corpus Check
- 55 files · ~91,732 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 168 nodes · 234 edges · 26 communities detected
- Extraction: 72% EXTRACTED · 28% INFERRED · 0% AMBIGUOUS · INFERRED: 66 edges (avg confidence: 0.78)
- Token cost: 0 input · 0 output

## Community Hubs (Navigation)
- [[_COMMUNITY_Complaint Management|Complaint Management]]
- [[_COMMUNITY_Department Operations|Department Operations]]
- [[_COMMUNITY_Authentication UI|Authentication UI]]
- [[_COMMUNITY_Auth Services|Auth Services]]
- [[_COMMUNITY_Security Core|Security Core]]
- [[_COMMUNITY_Authentication Flow|Authentication Flow]]
- [[_COMMUNITY_Admin Operations|Admin Operations]]
- [[_COMMUNITY_Auth DTOs|Auth DTOs]]
- [[_COMMUNITY_Security Configuration|Security Configuration]]
- [[_COMMUNITY_JWT Filter Flow|JWT Filter Flow]]
- [[_COMMUNITY_User Complaint API|User Complaint API]]
- [[_COMMUNITY_Test Configuration|Test Configuration]]
- [[_COMMUNITY_Registration DTO|Registration DTO]]
- [[_COMMUNITY_Login DTO|Login DTO]]
- [[_COMMUNITY_Documentation|Documentation]]
- [[_COMMUNITY_Design Prototypes|Design Prototypes]]
- [[_COMMUNITY_User Features|User Features]]
- [[_COMMUNITY_Admin Features|Admin Features]]
- [[_COMMUNITY_System Designs|System Designs]]
- [[_COMMUNITY_API Utilities|API Utilities]]
- [[_COMMUNITY_Role Admin|Role Admin]]
- [[_COMMUNITY_Role Dept|Role Dept]]
- [[_COMMUNITY_Role User|Role User]]
- [[_COMMUNITY_Help Documentation|Help Documentation]]
- [[_COMMUNITY_Department Queue|Department Queue]]
- [[_COMMUNITY_Reporting UI|Reporting UI]]

## God Nodes (most connected - your core abstractions)
1. `Complaint` - 11 edges
2. `UserRepository` - 10 edges
3. `Require Authentication Guard` - 9 edges
4. `Department` - 9 edges
5. `User` - 9 edges
6. `AuthService` - 9 edges
7. `DataInitializer` - 8 edges
8. `JwtUtil` - 7 edges
9. `getName()` - 7 edges
10. `ComplaintRepository` - 7 edges

## Surprising Connections (you probably didn't know these)
- `Logout Function` --references--> `Handle Login`  [INFERRED]
  src/main/resources/static/js/auth.js → src/main/resources/static/login.html
- `Getting Started` --references--> `contextLoads`  [EXTRACTED]
  README.md → src/test/java/com/civic/javacivic/JavacivicApplicationTests.java
- `Handle Login` --conceptually_related_to--> `Generate Token`  [INFERRED]
  src/main/resources/static/login.html → src/main/java/com/civic/javacivic/security/JwtUtil.java
- `Handle Register` --conceptually_related_to--> `Generate Token`  [INFERRED]
  src/main/resources/static/register.html → src/main/java/com/civic/javacivic/security/JwtUtil.java
- `Handle Login` --calls--> `Get Token from Storage`  [EXTRACTED]
  src/main/resources/static/login.html → src/main/resources/static/js/auth.js

## Hyperedges (group relationships)
- **Authentication Flow Components** — jwtutil_generatetoken, jwtutil_isvalid, jwtfilter_dofilterinternal, userdetailsserviceimpl_loaduserbyusername, authjs_gettoken, authjs_requireauth, login_html_handlelogin, register_html_handleregister [INFERRED 0.85]
- **Role-Based Access Control** — role_main_admin, role_dept_admin, role_user, login_html_redirectbyrole, index_html_redirectbyrole, authjs_getrole [INFERRED 0.80]
- **User Authenticated Pages** — user_dashboard_html, user_report_html, user_mycomplaints_html, authjs_requireauth [INFERRED 0.78]
- **Authentication Flow** — authcontroller, authservice, userrepository, loginrequest, registerrequest [INFERRED 0.85]
- **Complaint Lifecycle Management** — complaint, complaint_repository, usercontroller, admincontroller, departmentcontroller [INFERRED 0.88]
- **Application Data Seeding** — datainitializer, userrepository, department_repository, securityconfig [INFERRED 0.82]
- **Dashboard Pages** — civicpulse_landing_page_code, user_dashboard_sovereign_saas_code, admin_operations_sovereign_saas_code, department_queue_sovereign_saas_code [INFERRED 0.85]

## Communities

### Community 0 - "Complaint Management"
Cohesion: 0.14
Nodes (20): AdminController, UpdateStatus, AssignDTO, Complaint, Category, ComplaintRepository, Status, ComplaintDTO (+12 more)

### Community 1 - "Department Operations"
Cohesion: 0.16
Nodes (5): getName(), ComplaintRepository, DataInitializer, DepartmentController, UserController

### Community 2 - "Authentication UI"
Cohesion: 0.11
Nodes (21): Admin Complaints Page, Admin Dashboard Page, Admin Notifications Page, Get Name from Storage, Get Role from Storage, Get Token from Storage, Logout Function, Require Authentication Guard (+13 more)

### Community 3 - "Auth Services"
Cohesion: 0.14
Nodes (14): AuthController, AuthService, CommandLineRunner, DataInitializer, Main, SecurityConfig, FilterChain, User (+6 more)

### Community 4 - "Security Core"
Cohesion: 0.21
Nodes (4): JavacivicApplication, JwtFilter, JwtUtil, OncePerRequestFilter

### Community 5 - "Authentication Flow"
Cohesion: 0.22
Nodes (7): apiFetch(), getEmail(), getRole(), getToken(), logout(), requireAuth(), AuthService

### Community 6 - "Admin Operations"
Cohesion: 0.22
Nodes (4): AdminController, Assign, AssignDTO, Department

### Community 7 - "Auth DTOs"
Cohesion: 0.33
Nodes (7): AuthController, Login, Register, Login, Register, LoginRequest, RegisterRequest

### Community 8 - "Security Configuration"
Cohesion: 0.4
Nodes (1): SecurityConfig

### Community 9 - "JWT Filter Flow"
Cohesion: 0.6
Nodes (5): JWT Filter Do Filter Internal, Extract Email, Get Claims, Is Valid Token, Load User by Username

### Community 10 - "User Complaint API"
Cohesion: 0.5
Nodes (2): Complaint, ComplaintDTO

### Community 11 - "Test Configuration"
Cohesion: 0.67
Nodes (1): JavacivicApplicationTests

### Community 12 - "Registration DTO"
Cohesion: 1.0
Nodes (1): RegisterRequest

### Community 13 - "Login DTO"
Cohesion: 1.0
Nodes (1): LoginRequest

### Community 14 - "Documentation"
Cohesion: 2.0
Nodes (2): contextLoads, Getting Started

### Community 15 - "Design Prototypes"
Cohesion: 1.0
Nodes (2): CivicPulse Landing Page, Login Page Dark Mode

### Community 16 - "User Features"
Cohesion: 1.0
Nodes (2): Issue Detail Sovereign SaaS, My Reports Sovereign SaaS

### Community 17 - "Admin Features"
Cohesion: 1.0
Nodes (2): Admin Operations Sovereign SaaS, User Dashboard Sovereign SaaS

### Community 18 - "System Designs"
Cohesion: 1.0
Nodes (2): Civic Ledger Design, Slate Urban Design

### Community 19 - "API Utilities"
Cohesion: 1.0
Nodes (1): Authenticated API Fetch

### Community 20 - "Role Admin"
Cohesion: 1.0
Nodes (1): Main Admin Role

### Community 21 - "Role Dept"
Cohesion: 1.0
Nodes (1): Department Admin Role

### Community 22 - "Role User"
Cohesion: 1.0
Nodes (1): User Role

### Community 23 - "Help Documentation"
Cohesion: 1.0
Nodes (1): civic_issue_system

### Community 24 - "Department Queue"
Cohesion: 1.0
Nodes (1): Department Queue Sovereign SaaS

### Community 25 - "Reporting UI"
Cohesion: 1.0
Nodes (1): Report Issue Sovereign SaaS

## Knowledge Gaps
- **34 isolated node(s):** `RegisterRequest`, `LoginRequest`, `Logout Function`, `Authenticated API Fetch`, `Redirect by Role` (+29 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **Thin community `Security Configuration`** (5 nodes): `SecurityConfig.java`, `SecurityConfig`, `.authManager()`, `.filterChain()`, `.passwordEncoder()`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `User Complaint API`** (4 nodes): `Complaint`, `ComplaintDTO`, `UserController.java`, `Complaint.java`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Test Configuration`** (3 nodes): `JavacivicApplicationTests`, `.contextLoads()`, `JavacivicApplicationTests.java`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Registration DTO`** (2 nodes): `RegisterRequest.java`, `RegisterRequest`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Login DTO`** (2 nodes): `LoginRequest`, `LoginRequest.java`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Documentation`** (2 nodes): `contextLoads`, `Getting Started`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Design Prototypes`** (2 nodes): `CivicPulse Landing Page`, `Login Page Dark Mode`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `User Features`** (2 nodes): `Issue Detail Sovereign SaaS`, `My Reports Sovereign SaaS`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Admin Features`** (2 nodes): `Admin Operations Sovereign SaaS`, `User Dashboard Sovereign SaaS`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `System Designs`** (2 nodes): `Civic Ledger Design`, `Slate Urban Design`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `API Utilities`** (1 nodes): `Authenticated API Fetch`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Role Admin`** (1 nodes): `Main Admin Role`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Role Dept`** (1 nodes): `Department Admin Role`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Role User`** (1 nodes): `User Role`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Help Documentation`** (1 nodes): `civic_issue_system`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Department Queue`** (1 nodes): `Department Queue Sovereign SaaS`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.
- **Thin community `Reporting UI`** (1 nodes): `Report Issue Sovereign SaaS`
  Too small to be a meaningful cluster - may be noise or needs more connections extracted.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `AuthService` connect `Auth Services` to `Security Core`, `Auth DTOs`?**
  _High betweenness centrality (0.122) - this node is a cross-community bridge._
- **Why does `User` connect `Auth Services` to `Complaint Management`, `Authentication Flow`?**
  _High betweenness centrality (0.081) - this node is a cross-community bridge._
- **Why does `Complaint` connect `Complaint Management` to `Auth Services`, `Admin Operations`?**
  _High betweenness centrality (0.071) - this node is a cross-community bridge._
- **Are the 5 inferred relationships involving `Complaint` (e.g. with `CreateComplaint` and `Assign`) actually correct?**
  _`Complaint` has 5 INFERRED edges - model-reasoned connections that need verification._
- **What connects `RegisterRequest`, `LoginRequest`, `Logout Function` to the rest of the system?**
  _34 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Complaint Management` be split into smaller, more focused modules?**
  _Cohesion score 0.14 - nodes in this community are weakly interconnected._
- **Should `Authentication UI` be split into smaller, more focused modules?**
  _Cohesion score 0.11 - nodes in this community are weakly interconnected._
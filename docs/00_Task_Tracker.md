Task ID: GBR-001
Title: Initial Project Structure
Objective:
Create the base directory structure for the Green Basket Retail project.
------------------------------------------------------------------
✅ Task Status
Task ID: GBR-002
Task: Create Project Charter
Status: ✅ Completed
--------------------------------------------------------------------
Task ID: GBR-004
Title: Verify Development Environment
Status: ✅ Completed
Deliverables: Verified Git, Java, JDK, Maven, and JAVA_HOME
Lesson Learned: Always verify the environment before starting development.
--------------------------------------------------------------------------
## GBR-005

### Title
Initialize Git Repository

### Objective
Initialize Git version control for the Green Basket Retail project.

### Status
✅ Completed

### Deliverables

- Initialized Git repository
- Created hidden `.git` directory
- Verified repository status

### Business Reason

Version control enables tracking of every project change from the beginning of development.

### Lessons Learned

- `git init` converts a normal folder into a Git repository.
- The `.git` folder stores the complete repository history and configuration.

## GBR-006

### Title
Create .gitignore

### Objective
Configure Git to ignore unnecessary files and directories.

### Status
✅ Completed

### Deliverables

- Created `.gitignore`
- Added standard ignore rules for Java/Maven projects
- Verified ignored files using `git status`

### Business Reason

Prevent unnecessary files from being tracked, keeping the repository clean and maintainable.

### Lessons Learned

- `.gitignore` prevents Git from tracking files that are generated automatically or are specific to a developer's local environment.

## GBR-007

### Title
Create Initial Git Commit

### Objective
Create the first commit to establish the initial project history.

### Status
✅ Completed

### Deliverables

- Staged project files
- Configured Git author information
- Created the first commit
- Verified commit using `git log`

### Business Reason

Creating an initial commit establishes the project's baseline, allowing all future changes to be tracked and compared.

### Lessons Learned

- `git add` stages changes for commit.
- `git commit` creates a permanent snapshot in Git history.
- Git requires author information (`user.name` and `user.email`) before creating commits.

## GBR-008

### Title
Create GitHub Repository

### Objective
Create a public GitHub repository for the Green Basket Retail project.

### Status
✅ Completed

### Deliverables

- Created public GitHub repository
- Repository initialized without README, .gitignore, or License

### Business Reason

Provides a centralized remote repository for collaboration, backup, and future CI/CD integration.

### Lessons Learned

- Git and GitHub are different technologies with different responsibilities.
- Create an empty remote repository when a local Git repository already exists.
## GBR-009

### Title
Configure Remote Repository

### Objective
Connect the local Git repository to the remote GitHub repository.

### Status
✅ Completed (Part 1)

### Deliverables

- Added remote repository using `git remote add origin`
- Verified remote configuration using `git remote -v`

### Business Reason

A remote repository enables collaboration, backup, and integration with CI/CD pipelines.

### Lessons Learned

- A remote connects a local repository to a remote repository.
- `origin` is the default alias for the primary remote.
- Each Git repository maintains its own remote configuration.
## GBR-010

### Title
Push Local Repository to GitHub

### Objective
Push the local Git repository to the remote GitHub repository and establish upstream tracking.

### Status
✅ Completed

### Deliverables

- Renamed branch to `main`
- Pushed first commit to GitHub
- Established upstream tracking
- Verified repository on GitHub

### Business Reason

Publishing the repository enables collaboration, remote backup, code review, and CI/CD integration.

### Lessons Learned

- `git push -u origin main` pushes the local branch and sets the upstream relationship.
- After the first push, `git push` and `git pull` are sufficient.
## GBR-011

### Title
Create Standard Maven Project Structure

### Objective
Create the standard Maven directory structure for the Green Basket Retail application.

### Status
✅ Completed

### Deliverables

- Created `src/main/java`
- Created `src/main/resources`
- Created `src/main/webapp`
- Created `src/test/java`

### Business Reason

A standard project structure improves maintainability and allows development, build, and deployment tools to work consistently.

### Lessons Learned

- Maven follows a standard project layout.
- Standardization improves collaboration and troubleshooting.
- Build and deployment tools rely on this structure.
## GBR-012

### Title
Create Maven Project Configuration (`pom.xml`)

### Objective
Create the initial Maven project configuration file.

### Status
✅ Completed

### Deliverables

- Created `pom.xml`
- Added project metadata
- Configured WAR packaging
- Validated the Maven project successfully

### Business Reason

The `pom.xml` file provides Maven with the information required to build, package, and manage the application.

### Lessons Learned

- Maven always starts by reading `pom.xml`.
- The packaging type determines the output artifact.
- Without `pom.xml`, Maven cannot build the project.

Task ID: GBR-013

Title: Clean Tomcat Deployment Environment

Objective:
Remove previous deployment artifacts from Tomcat before redeploying the application to avoid stale files and cached data.

Status:
✅ Completed
Task ID: GBR-014

Title: Deploy Green Basket Retail on Apache Tomcat

Objective:
Build the application using Maven and deploy the generated WAR file on Apache Tomcat.

Status:
✅ Completed
Task ID: GBR-015

Title: Create Login Servlet

Objective:
Create the first backend servlet to handle login requests from the login page.

Status:
✅ Completed
Task ID: GBR-016

Title: Connect Login Page to LoginServlet

Objective:
Connect the login page with the backend servlet using an HTTP POST request.

Status:
✅ Completed
Task ID: GBR-018

Title:
Implement Login Validation

Objective:
Validate user credentials using temporary hardcoded authentication and allow access only for valid users.

Status:
✅ Completed

Task ID: GBR-020

Title:
Develop Dashboard Module

Objective:
Create the application dashboard and redirect authenticated users from the login page to the dashboard.

Status:
✅ Completed (Once you merge feature/dashboard into main.)
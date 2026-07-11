# Decision Log

---

## DEC-001

### Date
11 July 2026

### Decision
Project documentation will be maintained in Markdown (.md) format.

### Reason
Markdown is easy to maintain, integrates well with Git, renders automatically on GitHub, and is the industry standard for technical documentation.

### Alternatives Considered
- Microsoft Word (.docx)
- PDF

### Final Decision
Markdown will be the primary documentation format.
Word/PDF will be generated only when required.

### Approved By
Tech Lead

---

## DEC-002

### Date
11 July 2026

### Decision
Create project documentation before starting development.

### Reason
A well-documented project is easier to understand, maintain, and explain during interviews.

### Alternatives Considered
- Start coding immediately
- Document at the end of the project

### Final Decision
Documentation will be created and updated throughout the project lifecycle.

### Approved By
Tech Lead
--------------------------------------------------------
Decision ID: DEC-003

Decision:
Verify all required development tools before initializing the project.

Reason:
A verified environment reduces setup issues and ensures a smooth development process.

Final Decision:
Development will only begin after successful environment verification.
-------------------------------------------------------
## DEC-005

### Date
11 July 2026

### Decision
Initialize Git before application development.

### Reason
Every change should be tracked from the beginning of the project.

### Alternatives Considered

- Initialize Git after coding
- Use ZIP backups

### Final Decision

Git will be initialized before writing application code.

### Approved By

Tech Lead
## DEC-006

### Date
11 July 2026

### Decision

Use a `.gitignore` file from the beginning of the project.

### Reason

To exclude build artifacts, IDE settings, log files, and operating system files from version control.

### Alternatives Considered

- Track all files
- Create `.gitignore` later

### Final Decision

Maintain a project-specific `.gitignore` from the start of development.

### Approved By

Tech Lead

## DEC-007

### Date
11 July 2026

### Decision

Configure Git author identity before creating commits.

### Reason

Every commit should clearly identify its author, ensuring accountability and traceability.

### Alternatives Considered

- Skip author configuration
- Configure only per repository

### Final Decision

Use global Git configuration for user name and email on the development machine.

### Approved By

Tech Lead

## DEC-008

### Date
11 July 2026

### Decision

Create the GitHub repository without initializing it.

### Reason

The project already contains a local Git repository with documentation and history. Creating additional files on GitHub could lead to unnecessary merge conflicts.

### Final Decision

Use an empty GitHub repository and push the existing local repository.

### Approved By

Tech Lead

## DEC-009

### Date
11 July 2026

### Decision

Use `origin` as the remote alias for the GitHub repository.

### Reason

`origin` is the industry-standard alias for the primary remote repository, improving consistency across development teams.

### Final Decision

The Green Basket Retail repository will use `origin` as its primary remote.

### Approved By

Tech Lead

## DEC-010

### Date
11 July 2026

### Decision

Rename the default branch to `main` before the first push.

### Reason

Modern Git projects and enterprise environments use `main` as the standard default branch.

### Final Decision

Use `main` as the primary branch for the Green Basket Retail project.

### Approved By

Tech Lead
## DEC-011

### Date
11 July 2026

### Decision

Adopt the standard Maven project directory structure.

### Reason

Using the Maven standard improves maintainability, compatibility with build tools, and consistency across the development team.

### Final Decision

The Green Basket Retail project will follow the standard Maven directory layout.

### Approved By

Tech Lead
## DEC-012

### Date
11 July 2026

### Decision

Use Maven as the build tool and configure the project using `pom.xml`.

### Reason

Maven standardizes the build process and integrates seamlessly with Jenkins, dependency management, and deployment workflows.

### Final Decision

The Green Basket Retail application will use Maven with WAR packaging.

### Approved By

Tech Lead
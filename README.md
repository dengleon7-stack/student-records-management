# University Student Records Management

A Java Swing desktop application for managing student records. It has a menu bar
(Registration, Course Management, Examination Results, Finance, Help), a student
table, and a right-click pop-up menu (`JPopupMenu`) for record-specific actions.

## Project structure

```
student-records-management/
├── .vscode/              # VS Code run configuration
├── src/
│   ├── Main.java                 # starts the application
│   ├── StudentRecordsFrame.java  # main window: puts everything together
│   ├── StudentTablePanel.java    # the student table
│   ├── StudentActions.java       # shared actions used by menus and pop-up
│   ├── RegistrationMenu.java     # "Registration" menu
│   ├── CourseMenu.java           # "Course Management" menu
│   ├── ResultsMenu.java          # "Examination Results" menu
│   ├── FinanceMenu.java          # "Finance" menu
│   ├── HelpMenu.java             # "Help" menu
│   └── StudentPopupMenu.java     # right-click pop-up menu
└── README.md
```

Each menu is its own class, so developers working on different menus edit
different files and do not collide with each other.

## Branching strategy

`main` is the stable branch and always compiles and runs. All new work happens on
a feature branch created from `main`, named `feature/<area>-<description>`.

| Branch | Works on |
|---|---|
| `feature/student-registration-menu` | `RegistrationMenu.java` |
| `feature/course-management-menu` | `CourseMenu.java` |
| `feature/examination-results-menu` | `ResultsMenu.java` |
| `feature/finance-menu` | `FinanceMenu.java` |
| `feature/help-services-menu` | `HelpMenu.java` |
| `feature/popup-menu` | `StudentPopupMenu.java` |

A feature branch is merged back into `main` only when it is finished and working.

## Running the application

Requires Java 17 or newer.

**In VS Code:** open this folder, install the *Extension Pack for Java*, open
`src/Main.java` and click **Run** above `main`.

**From a terminal:**

```bash
javac -d out src/*.java
java -cp out Main
```

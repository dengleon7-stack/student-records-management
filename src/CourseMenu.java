import javax.swing.*;

// "Course Management" menu: manage courses, register courses.
// Branch: feature/course-management-menu
public class CourseMenu extends JMenu {

    public CourseMenu(StudentActions actions) {
        super("Course Management");

        JMenuItem manageCourses = new JMenuItem("Manage Courses");
        JMenuItem registerCourses = new JMenuItem("Register Courses");

        manageCourses.addActionListener(e ->
                actions.showMessage("Course Management selected."));
        registerCourses.addActionListener(e ->
                actions.showSelectedStudent("Register Courses"));

        add(manageCourses);
        add(registerCourses);
    }
}

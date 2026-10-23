import javax.swing.*;
import java.awt.*;

// The main window. It puts the menu bar, heading, table and status line together.
// Each menu and the right-click pop-up live in their own classes.
public class StudentRecordsFrame extends JFrame {

    public StudentRecordsFrame() {
        setTitle("University Student Records Management");
        setSize(900, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        StudentTablePanel students = new StudentTablePanel();
        StudentActions actions = new StudentActions(this, students);

        // 1. Menu bar
        setJMenuBar(createMenuBar(actions));

        // 2. Student records table
        add(students, BorderLayout.CENTER);

        // 3. Right-click pop-up menu on the table
        new StudentPopupMenu(actions).attachTo(students.getTable());

        // 4. Heading and instructions
        add(createHeaderPanel(), BorderLayout.NORTH);

        // 5. Status line
        JLabel status = new JLabel(
                " Ready | Use the menu bar or right-click a student.");
        add(status, BorderLayout.SOUTH);
    }

    private JMenuBar createMenuBar(StudentActions actions) {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new RegistrationMenu(actions));
        menuBar.add(new CourseMenu(actions));
        menuBar.add(new ResultsMenu(actions));
        menuBar.add(new FinanceMenu(actions));
        menuBar.add(new HelpMenu(actions));
        return menuBar;
    }

    private JPanel createHeaderPanel() {
        JLabel heading = new JLabel(
                "University Student Records", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel instruction = new JLabel(
                "Right-click a student record to display quick actions.",
                SwingConstants.CENTER);

        JPanel top = new JPanel(new GridLayout(2, 1, 5, 5));
        top.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        top.add(heading);
        top.add(instruction);
        return top;
    }
}

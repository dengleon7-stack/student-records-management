import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

// "Registration" menu: register a student, view student records.
// Branch: feature/student-registration-menu
public class RegistrationMenu extends JMenu {

    public RegistrationMenu(StudentActions actions) {
        super("Registration");

        JMenuItem registerStudent = new JMenuItem("Register Student");
        JMenuItem viewRecords = new JMenuItem("View Student Records");

        // Keyboard shortcut: Ctrl+N
        registerStudent.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));

        registerStudent.addActionListener(e ->
                actions.showMessage("Student Registration selected."));
        viewRecords.addActionListener(e ->
                actions.showMessage("Student Records selected."));

        add(registerStudent);
        add(viewRecords);
    }
}

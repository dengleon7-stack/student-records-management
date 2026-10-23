import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;

// Shared actions used by the menus and the pop-up menu:
// showing messages, showing the selected student, and deactivating a record.
public class StudentActions {

    private final Component parent;
    private final StudentTablePanel students;

    public StudentActions(Component parent, StudentTablePanel students) {
        this.parent = parent;
        this.students = students;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(parent, message);
    }

    // Display information about the selected student
    public void showSelectedStudent(String action) {
        int row = students.getTable().getSelectedRow();
        if (row < 0) {
            showMessage("Please select a student record first.");
            return;
        }

        DefaultTableModel model = students.getModel();
        String id = model.getValueAt(row, 0).toString();
        String name = model.getValueAt(row, 1).toString();
        String programme = model.getValueAt(row, 2).toString();
        String year = model.getValueAt(row, 3).toString();
        String status = model.getValueAt(row, 4).toString();

        if (action.equals("View Profile")) {
            showMessage(
                    "Student Profile\nID: " + id +
                            "\nName: " + name +
                            "\nProgramme: " + programme +
                            "\nYear: " + year +
                            "\nStatus: " + status);
        } else {
            showMessage(action + " selected for " + name +
                    " (" + id + ").");
        }
    }

    public void deactivateSelectedStudent() {
        int row = students.getTable().getSelectedRow();

        if (row >= 0) {
            DefaultTableModel model = students.getModel();
            String name = model.getValueAt(row, 1).toString();

            int choice = JOptionPane.showConfirmDialog(
                    parent,
                    "Deactivate " + name + "'s record?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION
            );
            if (choice == JOptionPane.YES_OPTION) {
                model.setValueAt("Inactive", row, 4);
                JOptionPane.showMessageDialog(
                        parent, "Student record deactivated.");
            }
        }
    }
}

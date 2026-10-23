import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// The right-click pop-up menu for a student record (JPopupMenu).
// Branch: feature/popup-menu
public class StudentPopupMenu extends JPopupMenu {

    public StudentPopupMenu(StudentActions actions) {
        JMenuItem viewProfile = new JMenuItem("View Profile");
        JMenuItem popupRegister = new JMenuItem("Register Courses");
        JMenuItem popupPrint = new JMenuItem("Print Transcript");
        JMenuItem deactivate = new JMenuItem("Deactivate Record");

        add(viewProfile);
        add(popupRegister);
        add(popupPrint);
        addSeparator();
        add(deactivate);

        viewProfile.addActionListener(e ->
                actions.showSelectedStudent("View Profile"));
        popupRegister.addActionListener(e ->
                actions.showSelectedStudent("Register Courses"));
        popupPrint.addActionListener(e ->
                actions.showSelectedStudent("Print Transcript"));
        deactivate.addActionListener(e ->
                actions.deactivateSelectedStudent());
    }

    // Show this pop-up when a student row in the table is right-clicked
    public void attachTo(JTable table) {
        table.addMouseListener(new MouseAdapter() {
            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    int row = table.rowAtPoint(e.getPoint());
                    if (row >= 0) {
                        table.setRowSelectionInterval(row, row);
                        StudentPopupMenu.this.show(table, e.getX(), e.getY());
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }
        });
    }
}

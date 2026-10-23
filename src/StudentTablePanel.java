import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// The student records table, inside a scroll pane.
public class StudentTablePanel extends JScrollPane {

    private static final String[] COLUMNS = {
            "Student ID", "Full Name", "Programme", "Year", "Status"
    };

    private final JTable table;
    private final DefaultTableModel model;

    public StudentTablePanel() {
        Object[][] data = {
                {"24/463/BIT", "Amina Deng", "BIT", "Year 2", "Active"},
                {"24/463/BIT", "Amina Deng", "BIT", "Year 2", "Active"},
                {"24/463/BIT", "Amina Deng", "BIT", "Year 2", "Active"},
                {"24/991/BSCS-M", "Peter John", "BIT", "Year 3", "Active"},
                {"24/003/BSCS", "Mary James", "Computer Science", "Year 1", "Active"},
                {"23/775/BIT", "Daniel Awer", "BIT", "Year 4", "Active"}
        };

        model = new DefaultTableModel(data, COLUMNS) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(28);

        setViewportView(table);
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}

import javax.swing.SwingUtilities;

// Entry point of the application. It only opens the main window.
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRecordsFrame().setVisible(true));
    }
}

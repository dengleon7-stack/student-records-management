import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

// "Examination Results" menu: view results, print transcript.
// Branch: feature/examination-results-menu
public class ResultsMenu extends JMenu {

    public ResultsMenu(StudentActions actions) {
        super("Examination Results");

        JMenuItem viewResults = new JMenuItem("View Results");
        JMenuItem printTranscript = new JMenuItem("Print Transcript");

        // Keyboard shortcut: Ctrl+P
        printTranscript.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));

        viewResults.addActionListener(e ->
                actions.showSelectedStudent("View Examination Results"));
        printTranscript.addActionListener(e ->
                actions.showSelectedStudent("Print Transcript"));

        add(viewResults);
        add(printTranscript);
    }
}

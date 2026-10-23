import javax.swing.*;

// "Help" menu: help guide, about.
// Branch: feature/help-services-menu
public class HelpMenu extends JMenu {

    public HelpMenu(StudentActions actions) {
        super("Help");

        JMenuItem helpGuide = new JMenuItem("Help Guide");
        JMenuItem about = new JMenuItem("About");

        helpGuide.addActionListener(e ->
                actions.showMessage("Right-click a student record for quick actions."));
        about.addActionListener(e ->
                actions.showMessage("University Student Records Management System."));

        add(helpGuide);
        add(about);
    }
}

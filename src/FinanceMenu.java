import javax.swing.*;

// "Finance" menu: fee statement, make payment.
// Branch: feature/finance-menu
public class FinanceMenu extends JMenu {

    public FinanceMenu(StudentActions actions) {
        super("Finance");

        JMenuItem feeStatement = new JMenuItem("Fee Statement");
        JMenuItem makePayment = new JMenuItem("Make Payment");

        feeStatement.addActionListener(e ->
                actions.showMessage("Fee Statement selected."));
        makePayment.addActionListener(e ->
                actions.showMessage("Make Payment selected."));

        add(feeStatement);
        add(makePayment);
    }
}

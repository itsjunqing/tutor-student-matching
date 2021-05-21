package view.contract;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import entity.Utility;
import lombok.Getter;
import model.contract.ContractConfirmModel;
import stream.Contract;
import view.ViewUtility;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

@Getter
public class ContractConfirmView {

    private ContractConfirmModel contractConfirmModel;
    private JPanel mainPanel;
    private JButton confirmSignButton;
    private JComboBox contractDuration;
    private JLabel errorLabel;
    private JScrollPane scrollPane;
    private JLabel contractDurationLabel;
    private JFrame frame;

    public ContractConfirmView(ContractConfirmModel contractConfirmModel) {
        this.contractConfirmModel = contractConfirmModel;

        frame = new JFrame();
        frame.setContentPane(this.mainPanel);
        displayView();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void dispose() {
        this.frame.dispose();
    }

    private void displayView() {
        Contract contract = contractConfirmModel.getContract();
        JTable table1 = getTable(contract);
        this.scrollPane.setViewportView(table1);
        // add the array of: {3, 6, 12, 24} into the dropdown list
        for (int d = 3; d < 25; d = d * 2) {
            contractDuration.addItem(d);
        }
        contractDuration.setSelectedIndex(1); // set to 6 months default
    }

    private JTable getTable(Contract contract) {
        int confirmationType = contractConfirmModel.getType();
        String[] nameDescription;
        if (confirmationType == ViewUtility.STUDENT_CODE) {
            nameDescription = new String[]{"Tutor Name", Utility.getFullName(contract.getSecondPartyId())};
        } else {
            nameDescription = new String[]{"Student Name", Utility.getFullName(contract.getFirstPartyId())};
        }

        String[][] rec = {
                nameDescription,
                {"Subject", Utility.getSubjectName(contract.getSubjectId())},
                {"Number Of Sessions", contract.getLessonInfo().getNumberOfSessions().toString()},
                {"Day & Time", contract.getLessonInfo().getTime() + " " + contract.getLessonInfo().getDay()},
                {"Duration", contract.getLessonInfo().getDuration().toString() + " hour(s)"},
                {"Total Contract Price", "$" + contract.getPaymentInfo().getTotalPrice()}};

        String[] col = {"", ""};
        JTable contractTable = new JTable(rec, col);
        contractTable.setPreferredScrollableViewportSize(new Dimension(400, 40));
        return contractTable;
    }

    public int getContractDuration() {
        return Integer.parseInt(contractDuration.getSelectedItem().toString());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(3, 5, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Arial", Font.BOLD, 24, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Contract Finalization");
        panel1.add(label1, new GridConstraints(0, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scrollPane = new JScrollPane();
        panel1.add(scrollPane, new GridConstraints(1, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        contractDuration = new JComboBox();
        panel1.add(contractDuration, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        contractDurationLabel = new JLabel();
        Font contractDurationLabelFont = this.$$$getFont$$$(null, -1, -1, contractDurationLabel.getFont());
        if (contractDurationLabelFont != null) contractDurationLabel.setFont(contractDurationLabelFont);
        contractDurationLabel.setText("Contract Duration:");
        panel1.add(contractDurationLabel, new GridConstraints(2, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel1.add(spacer2, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        confirmSignButton = new JButton();
        confirmSignButton.setText("Confirm/Sign");
        panel2.add(confirmSignButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel2.add(spacer3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        panel2.add(spacer4, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        errorLabel = new JLabel();
        errorLabel.setText("");
        mainPanel.add(errorLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}

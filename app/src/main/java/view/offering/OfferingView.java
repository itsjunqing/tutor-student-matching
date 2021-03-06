package view.offering;

import lombok.Getter;
import model.offering.OfferingModel;
import stream.Bid;
import view.ViewUtility;
import view.ViewTemplate;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class OfferingView extends ViewTemplate {

    private OfferingModel offeringModel;
    private JComboBox bidSelection;
    private JButton refreshButton;
    private JButton viewOffersButton;
    private JButton subscribeOfferButton;

    public OfferingView(OfferingModel offeringModel) {
        this.offeringModel = offeringModel;
        initViewTemplate("Tutor Offering View", JFrame.DISPOSE_ON_CLOSE);
    }

    protected void updateView() {
        if (contentPanel != null) {
            contentPanel.removeAll();
        } else {
            contentPanel = new JPanel();
            contentPanel.setLayout(new BorderLayout());
            mainPanel.add(contentPanel);
        }

        JPanel mainList = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 100;
        gbc.weighty = 100;
        mainList.add(new JPanel(), gbc);

        JScrollPane jScrollPane = new JScrollPane(mainList);
        jScrollPane.getVerticalScrollBar().setUnitIncrement(15);
        jScrollPane.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
        contentPanel.add(jScrollPane);

        List<Bid> bidList = getBidList();

        int bidSize = bidList.size();
        for (Bid b: bidList) {
            // Code to generate an open contract panel
            JPanel panel = new JPanel();
            JTable table = ViewUtility.BidAndOfferTable.buildTutorTable(b, bidSize);
            bidSize -= 1;
            ViewUtility.resizeColumns(table);
            table.setBounds(10, 10, 500, 100);
            panel.add(table);

            panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
            GridBagConstraints gbc1 = new GridBagConstraints();
            gbc1.gridwidth = GridBagConstraints.REMAINDER;
            gbc1.gridheight = 2;
            gbc1.weightx = 1;
            gbc1.fill = GridBagConstraints.HORIZONTAL;
            mainList.add(panel, gbc1, 0);
        }
    }

    protected void createButtons() {
        if (buttonPanel != null) {
            buttonPanel.removeAll();
        } else {
            buttonPanel = new JPanel();
            buttonPanel.setLayout(new BorderLayout());
            mainPanel.add(buttonPanel);
        }

        JPanel mainList = new JPanel(new GridBagLayout());
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridwidth = GridBagConstraints.REMAINDER;
        gbc2.gridheight = 3;
        gbc2.weightx = 1;

        // add refresh button
        refreshButton = new JButton("Refresh");
        panel.add(refreshButton, gbc2);

        int bidSize = getBidList().size();

        // add bid selection menu
        bidSelection = new JComboBox<>();
        for (int i = 1; i < bidSize + 1; i++) {
            bidSelection.addItem(i);
        }
        panel.add(bidSelection, gbc2);

        // add view offers button
        viewOffersButton = new JButton("View Offers");
        panel.add(viewOffersButton, gbc2);

        subscribeOfferButton = new JButton("Subscribe to bids");
        panel.add(subscribeOfferButton, gbc2);

        errorLabel = new JLabel();
        errorLabel.setForeground(new Color(-4521974));
        errorLabel.setHorizontalAlignment(0);
        errorLabel.setHorizontalTextPosition(0);
        errorLabel.setText(offeringModel.getErrorText());
        panel.add(errorLabel);

        panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridwidth = GridBagConstraints.REMAINDER;
        gbc1.gridheight = 100;
        gbc1.weightx = 100;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        mainList.add(panel, gbc1, 0);
        buttonPanel.add(mainList, BorderLayout.CENTER);
    }

    protected void refreshButtons(){
        // refreshing jcombobox
        bidSelection.removeAllItems();
        int bidSize = getBidList().size();
        for (int i = 1; i < bidSize + 1; i++) {
            bidSelection.addItem(i);
        }
        // refreshing jlabel
        errorLabel.setText(offeringModel.getErrorText());
    }

    private List<Bid> getBidList() {
        List<Bid> bidList = new ArrayList<>(offeringModel.getBidsOnGoing());
        Collections.reverse(bidList);
        return bidList;
    }

    public int getBidNumber() throws NullPointerException {
        return Integer.parseInt(bidSelection.getSelectedItem().toString());
    }

}

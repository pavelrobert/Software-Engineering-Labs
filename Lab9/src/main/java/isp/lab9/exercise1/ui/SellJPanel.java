package isp.lab9.exercise1.ui;

/**
 * todo: implement - it should look similar to the 'Buy' panel
 */

import isp.lab9.exercise1.services.UserPortfolio;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SellJPanel extends JPanel {
    private StockMarketJFrame frame;
    private UserPortfolio portfolio;

    public SellJPanel(StockMarketJFrame frame) {
        portfolio = frame.getPortfolio();
        this.frame = frame;
        initComponents();
    }

    public SellJPanel() {

    }


    private void initComponents() {
        setLayout(new GridLayout(2, 2));

        JPanel sellPanel = new JPanel();
        sellPanel.setLayout(new GridLayout(10, 2));

        JLabel availableSharesLabel = new JLabel("Total shares:");
        JTextField availableSharesTextField = new JTextField();
        availableSharesTextField.setEditable(false);

        JComboBox<String> symbolComboBox = new JComboBox<>();
        String symbol = (String) symbolComboBox.getSelectedItem();
        int totalShares = portfolio.getShares().getOrDefault(symbol, 0);

        availableSharesTextField.setText(Integer.toString(totalShares));

        JLabel symbolLabel = new JLabel("Symbol:");
        symbolComboBox = new JComboBox<>();
        symbolComboBox.setModel(new DefaultComboBoxModel(getOwnedSymbols()));

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityTextField = new JTextField();

        JLabel earningLabel = new JLabel("Total earnings:");
        JTextField earningTextField = new JTextField();
        earningTextField.setEditable(false);

        JButton earningButton = new JButton("Get earnings");
        JComboBox<String> finalSymbolComboBox = symbolComboBox;
        earningButton.addActionListener(e ->
                calculateTotalEarningsActionPerformed(finalSymbolComboBox, quantityTextField, earningTextField));

        JButton sellButton = new JButton("Sell");
        JComboBox<String> finalSymbolComboBox1 = symbolComboBox;
        sellButton.addActionListener(e ->
                sellStocks(finalSymbolComboBox1, earningTextField, quantityTextField));

        sellPanel.add(availableSharesLabel);
        sellPanel.add(availableSharesTextField);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(symbolLabel);
        sellPanel.add(symbolComboBox);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(quantityLabel);
        sellPanel.add(quantityTextField);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(earningLabel);
        sellPanel.add(earningTextField);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(earningButton);
        sellPanel.add(sellButton);

        add(sellPanel);
        add(new JPanel()); // empty cell in the grid
        add(new JPanel()); // empty cell in the grid
        add(new JPanel()); // empty cell in the grid
    }

    private String[] getOwnedSymbols() {
        return portfolio.getShares().keySet().toArray(new String[0]);
    }


    private void sellStocks(JComboBox<String> symbolComboBox,
                            JTextField totalEarnings,
                            JTextField quantity) {

        String symbol = (String) symbolComboBox.getSelectedItem();
        int stockQuantity = Integer.parseInt(quantity.getText());

        if (portfolio.getShares().containsKey(symbol)) {
            int availableShares = portfolio.getShares().get(symbol);
            if (stockQuantity <= availableShares) {
                BigDecimal stockPrice;
                try {
                    stockPrice = frame.getMarketService().getStockPrice(symbol);
                    BigDecimal earnings = stockPrice.multiply(new BigDecimal(stockQuantity));
                    portfolio.setCash(portfolio.getCash().add(earnings));
                    portfolio.getShares().put(symbol, availableShares - stockQuantity);
                    frame.setPortfolio(portfolio);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this,
                            ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Insufficient shares available for selling.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private void calculateTotalEarningsActionPerformed(JComboBox<String> symbolComboBox,
                                                       JTextField quantityTextField,
                                                       JTextField totalEarningsTextField) {
        try {
            String symbol = (String) symbolComboBox.getSelectedItem();
            BigDecimal stockPrice = frame.getMarketService().getStockPrice(symbol);

            try {
                int quantity = Integer.parseInt(quantityTextField.getText());
                DecimalFormat formatter = new DecimalFormat("#,##0.##");
                totalEarningsTextField.setText(
                        formatter.format(stockPrice.multiply(new BigDecimal(quantity))));
            } catch (NumberFormatException e) {
                totalEarningsTextField.setText("Invalid quantity value!");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

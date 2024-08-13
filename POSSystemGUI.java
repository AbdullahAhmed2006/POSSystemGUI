import javax.swing.*;
import java.awt.*;

public class POSSystemGUI extends JFrame {

    public POSSystemGUI() {
        setTitle("POS System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(60, 63, 65));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(new Color(43, 43, 43));
        tabbedPane.setForeground(Color.WHITE);
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 14));

        tabbedPane.add("Products", createProductPanel());
        tabbedPane.add("Customers", createCustomerPanel());
        tabbedPane.add("Sales", createSalesPanel());
        tabbedPane.add("Reports", createReportPanel());

        add(tabbedPane, BorderLayout.CENTER);
        setVisible(true);
    }

    private JPanel createProductPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(43, 43, 43));

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBackground(new Color(43, 43, 43));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel productIdLabel = new JLabel("Product ID:");
        JTextField productIdField = new JTextField();
        styleLabel(productIdLabel);
        styleTextField(productIdField);

        JLabel productNameLabel = new JLabel("Product Name:");
        JTextField productNameField = new JTextField();
        styleLabel(productNameLabel);
        styleTextField(productNameField);

        JLabel retailPriceLabel = new JLabel("Retail Price:");
        JTextField retailPriceField = new JTextField();
        styleLabel(retailPriceLabel);
        styleTextField(retailPriceField);

        JLabel wholesalePriceLabel = new JLabel("Wholesale Price:");
        JTextField wholesalePriceField = new JTextField();
        styleLabel(wholesalePriceLabel);
        styleTextField(wholesalePriceField);

        JLabel availabilityLabel = new JLabel("Available:");
        JCheckBox availabilityCheckBox = new JCheckBox();
        styleLabel(availabilityLabel);
        styleCheckBox(availabilityCheckBox);

        JButton addProductButton = new JButton("Add Product");
        styleButton(addProductButton);

        inputPanel.add(productIdLabel);
        inputPanel.add(productIdField);
        inputPanel.add(productNameLabel);
        inputPanel.add(productNameField);
        inputPanel.add(retailPriceLabel);
        inputPanel.add(retailPriceField);
        inputPanel.add(wholesalePriceLabel);
        inputPanel.add(wholesalePriceField);
        inputPanel.add(availabilityLabel);
        inputPanel.add(availabilityCheckBox);

        panel.add(inputPanel, BorderLayout.NORTH);

        JTable productTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(productTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createCustomerPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(43, 43, 43));

        // Add components for managing customers
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBackground(new Color(43, 43, 43));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel customerNameLabel = new JLabel("Customer Name:");
        JTextField customerNameField = new JTextField();
        styleLabel(customerNameLabel);
        styleTextField(customerNameField);

        JLabel customerTypeLabel = new JLabel("Customer Type:");
        String[] customerTypes = {"Regular", "Premium"};
        JComboBox<String> customerTypeComboBox = new JComboBox<>(customerTypes);
        styleLabel(customerTypeLabel);
        styleComboBox(customerTypeComboBox);

        JButton addCustomerButton = new JButton("Add Customer");
        styleButton(addCustomerButton);

        inputPanel.add(customerNameLabel);
        inputPanel.add(customerNameField);
        inputPanel.add(customerTypeLabel);
        inputPanel.add(customerTypeComboBox);

        panel.add(inputPanel, BorderLayout.NORTH);

        JTable customerTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(customerTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createSalesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(43, 43, 43));

        // Add components for processing sales
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBackground(new Color(43, 43, 43));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel selectProductLabel = new JLabel("Select Product:");
        JComboBox<String> productComboBox = new JComboBox<>();
        styleLabel(selectProductLabel);
        styleComboBox(productComboBox);

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField();
        styleLabel(quantityLabel);
        styleTextField(quantityField);

        JLabel customerTypeLabel = new JLabel("Customer Type:");
        String[] customerTypes = {"Regular", "Premium"};
        JComboBox<String> customerTypeComboBox = new JComboBox<>(customerTypes);
        styleLabel(customerTypeLabel);
        styleComboBox(customerTypeComboBox);

        JButton processSaleButton = new JButton("Process Sale");
        styleButton(processSaleButton);

        inputPanel.add(selectProductLabel);
        inputPanel.add(productComboBox);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);
        inputPanel.add(customerTypeLabel);
        inputPanel.add(customerTypeComboBox);

        panel.add(inputPanel, BorderLayout.NORTH);

        // Text area to display sale receipt
        JTextArea receiptArea = new JTextArea();
        receiptArea.setEditable(false);
        receiptArea.setBackground(new Color(60, 63, 65));
        receiptArea.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(receiptArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createReportPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(43, 43, 43));

        // Add components for generating reports
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBackground(new Color(43, 43, 43));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel startDateLabel = new JLabel("Start Date:");
        JTextField startDateField = new JTextField("YYYY-MM-DD");
        styleLabel(startDateLabel);
        styleTextField(startDateField);

        JLabel endDateLabel = new JLabel("End Date:");
        JTextField endDateField = new JTextField("YYYY-MM-DD");
        styleLabel(endDateLabel);
        styleTextField(endDateField);

        JButton generateReportButton = new JButton("Generate Report");
        styleButton(generateReportButton);

        inputPanel.add(startDateLabel);
        inputPanel.add(startDateField);
        inputPanel.add(endDateLabel);
        inputPanel.add(endDateField);

        panel.add(inputPanel, BorderLayout.NORTH);

        // Text area to display reports
        JTextArea reportArea = new JTextArea();
        reportArea.setEditable(false);
        reportArea.setBackground(new Color(60, 63, 65));
        reportArea.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(reportArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void styleLabel(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 12));
    }

    private void styleTextField(JTextField textField) {
        textField.setBackground(new Color(69, 73, 74));
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.WHITE);
        textField.setFont(new Font("Arial", Font.PLAIN, 12));
        textField.setBorder(BorderFactory.createLineBorder(new Color(99, 101, 103)));
    }

    private void styleComboBox(JComboBox<String> comboBox) {
        comboBox.setBackground(new Color(69, 73, 74));
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
    }

    private void styleCheckBox(JCheckBox checkBox) {
        checkBox.setBackground(new Color(43, 43, 43));
        checkBox.setForeground(Color.WHITE);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(99, 101, 103));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(129, 131, 133)));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(POSSystemGUI::new);
    }
}

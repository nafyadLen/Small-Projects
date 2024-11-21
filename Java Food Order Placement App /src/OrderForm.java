import javax.swing.*;

public class OrderForm {
    private JComboBox<String> baseComboBox;
    private JCheckBox[] toppingCheckBoxes;
    private JComboBox<String> sauceComboBox;
    private JComboBox<String> carbComboBox;
    private JButton orderButton;
    private JTextArea outputTextArea;
    private JPanel mainPanel;

    private double total_price = 0.0;
    private String toppings = "";

    public OrderForm() {
        baseComboBox = new JComboBox<>();
        sauceComboBox = new JComboBox<>();
        carbComboBox = new JComboBox<>();
        orderButton = new JButton("Order");
        outputTextArea = new JTextArea(10, 30);
        toppingCheckBoxes = new JCheckBox[8];

        toppingCheckBoxes[0] = new JCheckBox("Feta cheese");
        toppingCheckBoxes[1] = new JCheckBox("Onions");
        toppingCheckBoxes[2] = new JCheckBox("Salsa");
        toppingCheckBoxes[3] = new JCheckBox("Olives");
        toppingCheckBoxes[4] = new JCheckBox("Corn");
        toppingCheckBoxes[5] = new JCheckBox("Black Beans");
        toppingCheckBoxes[6] = new JCheckBox("Salad");
        toppingCheckBoxes[7] = new JCheckBox("Pickles");

        orderButton.addActionListener(e -> processOrder());

        mainPanel = new JPanel();
        mainPanel.add(new JLabel("Base:"));
        mainPanel.add(baseComboBox);
        mainPanel.add(new JLabel("Carbs:"));
        mainPanel.add(carbComboBox);
        for (JCheckBox checkBox : toppingCheckBoxes) {
            mainPanel.add(checkBox);
        }
        mainPanel.add(new JLabel("Sauce:"));
        mainPanel.add(sauceComboBox);
        mainPanel.add(orderButton);
        mainPanel.add(new JLabel("Output:"));
        mainPanel.add(outputTextArea);

        String[] bases = {"Falafel", "Beef", "Chicken", "Shrimp"};
        String[] sauces = {"Hot chili", "Tahini", "Buffalo", "Mayo", "Ranch", "Taziki", "Mint yogurt"};
        String[] carbs = {"Salad", "Rice"};
        baseComboBox.setModel(new DefaultComboBoxModel<>(bases));
        carbComboBox.setModel(new DefaultComboBoxModel<>(carbs));
        sauceComboBox.setModel(new DefaultComboBoxModel<>(sauces));
    }

    private void processOrder() {
        total_price = 0.0;
        toppings = "";

        String selectedBase = (String) baseComboBox.getSelectedItem();
        String carbPrice = (String) carbComboBox.getSelectedItem();

        switch (selectedBase) {
            case "Falafel":
                total_price += 7.99;
                break;
            case "Beef":
                total_price += 9.99;
                break;
            case "Chicken":
                total_price += 8.99;
                break;
            case "Shrimp":
                total_price += 9.99;
                break;
            default:
                break;
        }

        if (carbPrice.equalsIgnoreCase("Salad")) {
            total_price += 0.50;
        }

        int toppingCount = 0;
        for (int i = 0; i < toppingCheckBoxes.length; i++) {
            if (toppingCheckBoxes[i].isSelected()) {
                toppings += toppingCheckBoxes[i].getText() + ", ";
                toppingCount++;

                if (toppingCount > 4) {
                    total_price += 0.60;
                }
            }
        }

        // Calculate tax (10%)
        double tax = 0.10 * total_price;
        total_price += tax;

        String selectedSauce = (String) sauceComboBox.getSelectedItem();

        toppings += "and " + carbPrice;

        String output = "Total price with tax is $" + total_price + " toppings are " + toppingCount + ": " + toppings;
        outputTextArea.setText(output);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class homeoptions {
    private JComboBox<String> sqftRangeComboBox;
    private JRadioButton floor1RadioButton;
    private JRadioButton floor2RadioButton;
    private JRadioButton floor3RadioButton;
    private JCheckBox basementCheckBox;
    private JCheckBox atticCheckBox;
    private JRadioButton garage0RadioButton;
    private JRadioButton garage1RadioButton;
    private JRadioButton garage2RadioButton;
    private JRadioButton garage3RadioButton;
    private JComboBox<String> roomsComboBox;
    private JComboBox<String> bathroomsComboBox;
    private JComboBox<String> lotSizeComboBox;
    private JButton SEARCHFORHOMESButton;
    // Other UI components...

    private List<Homes> homesList;
    private JComboBox sqft;
    private JComboBox rooms;
    private JComboBox bathrooms;
    private JPanel Homes;

    public homeoptions() {
        homesList = new ArrayList<>();

        // Populate the homesList with the information provided
        homesList.add(new Homes(1800, 3, 2.5, 1, "Basement", 0.2, 2));
        homesList.add(new Homes(3200, 4, 3, 2, "Attic", 0.2, 3));
        homesList.add(new Homes(2500, 5, 2.5, 3, "Both", 0.1, 1));
        // ... add information for the remaining homes

        SEARCHFORHOMESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get user input from UI components
                int selectedSqftRange = getSelectedSqftRange(sqftRangeComboBox.getSelectedItem().toString());
                int selectedRooms = Integer.parseInt(roomsComboBox.getSelectedItem().toString());
                double selectedBathrooms = Double.parseDouble(bathroomsComboBox.getSelectedItem().toString());
                boolean isFloor1Selected = floor1RadioButton.isSelected();
                boolean isFloor2Selected = floor2RadioButton.isSelected();
                boolean isFloor3Selected = floor3RadioButton.isSelected();
                boolean hasBasement = basementCheckBox.isSelected();
                boolean hasAttic = atticCheckBox.isSelected();
                int selectedGarageCapacity = getSelectedGarageCapacity();
                double selectedLotSize = getSelectedLotSize(lotSizeComboBox.getSelectedItem().toString());

                // Match user preferences to a home
                Homes matchedHome = findMatchedHome(selectedSqftRange, selectedRooms, selectedBathrooms,
                        isFloor1Selected, isFloor2Selected, isFloor3Selected,
                        hasBasement, hasAttic, selectedGarageCapacity, selectedLotSize);

                // Display the matched home or take any other actions...
                JOptionPane.showMessageDialog(null, "The matched home is: " + matchedHome);
            }
        });
    }

    private int getSelectedSqftRange(String selectedRange) {
        // Implement logic to convert selected range to a single value
        // For simplicity, this example returns the lower limit of the range
        switch (selectedRange) {
            case "1500 - 2500 sqft":
                return 1500;
            case "2500 - 3500 sqft":
                return 2500;
            case "3500 - 4500 sqft":
                return 3500;
            case "4500 - 5500 sqft":
                return 4500;
            default:
                return 0;
        }
    }

    private int getSelectedGarageCapacity() {
        if (garage0RadioButton.isSelected()) {
            return 0;
        } else if (garage1RadioButton.isSelected()) {
            return 1;
        } else if (garage2RadioButton.isSelected()) {
            return 2;
        } else if (garage3RadioButton.isSelected()) {
            return 3;
        } else {
            return 0;
        }
    }

    private double getSelectedLotSize(String selectedLotSize) {
        // Implement logic to convert selected lot size to a single value
        // For simplicity, this example returns the lower limit of the range
        switch (selectedLotSize) {
            case "0.1 Acres":
                return 0.1;
            case "0.2 Acres":
                return 0.2;
            default:
                return 0.0;
        }
    }

    private void findClosestMatchingHome() {
        int userSqft = Integer.parseInt(sqftField.getText());
        double userLotSize = Double.parseDouble(lotSizeField.getText());

        Home closestMatch = null;
        double minDifference = Double.MAX_VALUE;

        for (Homes home : homesList) {
            double difference = home.estimateDifference(userSqft, userLotSize);
            if (difference < minDifference) {
                minDifference = difference;
                closestMatch = home;
            }
        }

        if (closestMatch != null) {
            JOptionPane.showMessageDialog(null, "Closest matching home estimated price: $" + closestMatch.estimatePrice());
        } else {
            JOptionPane.showMessageDialog(null, "No matches found.");
        }
    }
}
   /* private Homes findMatchedHome(int selectedSqftRange, int selectedRooms, double selectedBathrooms,
                                  boolean isFloor1Selected, boolean isFloor2Selected, boolean isFloor3Selected,
                                  boolean hasBasement, boolean hasAttic, int selectedGarageCapacity, double selectedLotSize) {

        for (Homes home : homesList) {
            if (home.sqft >= selectedSqftRange &&
                    home.rooms_no == selectedRooms &&
                    home.bathrooms_no == selectedBathrooms &&
                    ((isFloor1Selected && home.floors_no == 1) ||
                            (isFloor2Selected && home.floors_no == 2) ||
                            (isFloor3Selected && home.floors_no == 3)) &&
                    ((hasBasement && home.base_attic.contains("Basement")) ||
                            (hasAttic && home.base_attic.contains("Attic"))) &&
                    home.cars_garage == selectedGarageCapacity &&
                    home.lot_size >= selectedLotSize) {
                return home;
            }
        }
        // Return null if no match is found
        return null;
    }

}


//

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class HomeOptions {
    private JComboBox sqftans;
    private JComboBox roomans;
    private JComboBox bathroomsans;
    private JRadioButton floorans;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JCheckBox basementCheckBox;
    private JCheckBox atticCheckBox;
    private JRadioButton a01AcresRadioButton;
    private JRadioButton a02AcresRadioButton;
    private JRadioButton a0RadioButton;
    private JRadioButton a1RadioButton1;
    private JRadioButton a2RadioButton1;
    private JRadioButton a3RadioButton1;
    private JButton SEARCHFORHOMESButton;
    private JLabel sqft_q;
    private JLabel floor_q;
    private JLabel home_title;
    private JLabel rooms_q;
    private JLabel bathrooms_q;

    private List<Homes> homesList;

    public HomeOptions() {
        SEARCHFORHOMESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Homes> results = new ArrayList<>();

                // Replace with the actual components for your form
                JTextField form_sqft_ans = new JTextField();
                JTextField formid = new JTextField();
                JTextField form_name = new JTextField();
                JTextField form_sqftans = new JTextField();
                JTextField form_roomsans = new JTextField();
                JTextField formzipcode = new JTextField();

                String stID = "someID"; // Replace with the actual value

                // Iterate through homesList
                for (Homes house : homesList) {
                    if (form_sqft_ans.getText().isEmpty() && formid.getText().equals(stID)) {
                        // Conditions for sqft_ans being empty and formid equals stID
                    } else if (form_name.getText().isEmpty() && house.getSqft().contains(form_sqftans.getText())
                            && house.getRoomsNo().equals(form_roomsans.getText())
                            && house.getZipcode() == Integer.parseInt(formzipcode.getText())) {
                        results.add(house);
                    }
                }

                JOptionPane.showMessageDialog(null, "Homes similar to your inputs: " + results.toString());
            }
        });
    }

    public static void main(String[] args) {
        // Instantiate the HomeOptions class
        HomeOptions homeOptions = new HomeOptions();
        // Initialize homesList
        homeOptions.homesList = new ArrayList<>();
        // Add a sample home to homesList
        homeOptions.homesList.add(new Homes(1, 2, 3, 4, "base", 8, 9));
    }

    private void performSearch(String selectedSqft, String selectedRoom, String selectedBathroom,
                               FloorState selectedFloorState, boolean isBasementSelected, boolean isAtticSelected) {
        List<Homes> results = new ArrayList<>();

        // Iterate through your list of homes and filter based on the selected options
        for (Homes home : homesList) {
            // Check if the home meets the selected criteria
            if (checkCriteria(home, selectedSqft, selectedRoom, selectedBathroom,
                    selectedFloorState, isBasementSelected, isAtticSelected)) {
                results.add(home);
            }
        }

        // Display or process the results (for this example, let's print them)
        for (Homes result : results) {
            System.out.println("Matching Home: " + result);
        }
    }

    private boolean checkCriteria(Homes home, String selectedSqft, String selectedRoom, String selectedBathroom,
                                  String floor selectedFloorState, boolean isBasementSelected, boolean isAtticSelected) {
        // Implement your specific criteria here
        boolean sqftMatch = home.getSqft().equals(selectedSqft);
        boolean roomMatch = home.getRoomsNo().equals(selectedRoom);
        boolean bathroomMatch = home.getBathrooms().equals(selectedBathroom);
        //boolean floorMatch = (selectedFloor.getFloors == null) || (home.getFloors() == selectedFloorState.ordinal() + 1);
        boolean basementMatch = !isBasementSelected || home.hasBasement();
        boolean atticMatch = !isAtticSelected || home.hasAttic();

        // Adjust the criteria based on your needs

        return sqftMatch && roomMatch && bathroomMatch && basementMatch && atticMatch;
    }

}
*/
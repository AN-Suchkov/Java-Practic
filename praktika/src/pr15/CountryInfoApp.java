package pr15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CountryInfoApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Выбор страны");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        Map<String, String> countryInfo = new HashMap<>();
        countryInfo.put("Россия", "Столица: Москва\nНаселение: ~146 млн.");
        countryInfo.put("США", "Столица: Вашингтон\nНаселение: ~331 млн.");
        countryInfo.put("Китай", "Столица: Пекин\nНаселение: ~1.4 млрд.");
        countryInfo.put("Германия", "Столица: Берлин\nНаселение: ~83 млн.");
        countryInfo.put("Япония", "Столица: Токио\nНаселение: ~126 млн.");

        String[] countries = countryInfo.keySet().toArray(new String[0]);
        JComboBox<String> countryComboBox = new JComboBox<>(countries);

        JTextArea countryDetails = new JTextArea(5, 30);
        countryDetails.setEditable(false);
        countryDetails.setLineWrap(true);
        countryDetails.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(countryDetails);

        countryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCountry = (String) countryComboBox.getSelectedItem();
                countryDetails.setText(countryInfo.get(selectedCountry));
            }
        });

        frame.add(new JLabel("Выберите страну:"));
        frame.add(countryComboBox);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}

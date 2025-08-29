package pr15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountryInfoApp2 {
    private JFrame frame;
    private JComboBox<String> countryComboBox;
    private JTextArea infoArea;

    public CountryInfoApp2() {
        // Создаем главное окно
        frame = new JFrame("Информация о странах");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(null);

        // Названия стран
        String[] countries = {
                "Франция", "Япония", "Италия", "Австралия", "Бразилия"
        };

        // Создаем ComboBox для выбора страны
        countryComboBox = new JComboBox<>(countries);
        countryComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        countryComboBox.setBounds(150, 50, 200, 40);  // Положение и размеры
        frame.add(countryComboBox);

        // Создаем область для текста с информацией
        infoArea = new JTextArea();
        infoArea.setFont(new Font("Courier New", Font.PLAIN, 16));
        infoArea.setEditable(false);
        infoArea.setBounds(50, 120, 400, 300);  // Положение и размеры
        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);
        frame.add(infoArea);

        // Обработчик события для ComboBox
        countryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCountry = (String) countryComboBox.getSelectedItem();
                String info = getCountryInfo(selectedCountry);
                infoArea.setText(info);
            }
        });

        // Инициализация с информацией о первой выбранной стране
        infoArea.setText(getCountryInfo((String) countryComboBox.getSelectedItem()));

        frame.setVisible(true);
    }

    // Метод для получения информации о стране
    private String getCountryInfo(String country) {
        switch (country) {
            case "Франция":
                return "Франция — страна в Западной Европе, известная своей культурой, искусством и кухней.";
            case "Япония":
                return "Япония — островное государство в Восточной Азии, знаменитое своей технологией и традициями.";
            case "Италия":
                return "Италия — страна в Южной Европе, знаменитая своим искусством, историей и кухней.";
            case "Австралия":
                return "Австралия — страна и континент, известная своей природой, животными и прекрасными пляжами.";
            case "Бразилия":
                return "Бразилия — страна в Южной Америке, известная карнавала, футболом и тропическими лесами.";
            default:
                return "Информация о стране не найдена.";
        }
    }

    public static void main(String[] args) {
        new CountryInfoApp2();
    }
}

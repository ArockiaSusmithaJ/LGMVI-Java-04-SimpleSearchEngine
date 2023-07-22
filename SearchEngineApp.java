import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SearchEngineApp extends JFrame {

    private JTextField searchField;
    private JButton searchButton;
    private JTextArea resultArea;

    private Map<String, String> countryToCapital;

    public SearchEngineApp() {
        setTitle("Country Search Engine");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize the data (countries and their capitals)
        countryToCapital = new HashMap<>();
        countryToCapital.put("USA", "Washington, D.C.");
        countryToCapital.put("Canada", "Ottawa");
        countryToCapital.put("United Kingdom", "London");
        countryToCapital.put("France", "Paris");
        countryToCapital.put("Germany", "Berlin");
        // Add more countries and capitals here...

        initComponents();
    }

    private void initComponents() {
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Search Country:"));
        panel.add(searchField);
        panel.add(searchButton);

        JScrollPane scrollPane = new JScrollPane(resultArea);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });
    }

    private void performSearch() {
        String searchTerm = searchField.getText().trim();
        resultArea.setText("");

        for (Map.Entry<String, String> entry : countryToCapital.entrySet()) {
            String country = entry.getKey();
            String capital = entry.getValue();

            if (country.toLowerCase().contains(searchTerm.toLowerCase())) {
                resultArea.append(country + " - " + capital + "\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SearchEngineApp app = new SearchEngineApp();
            app.setVisible(true);
        });
    }
}

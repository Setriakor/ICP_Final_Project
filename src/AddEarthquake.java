import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The AddEarthquake class contains the code that allows a user to input information about
 * an earthquake in the AddEarthquake form and add it to a database
 */

public class AddEarthquake extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    public JPanel panel;
    private JButton addEarthquakeButton;
    private JTextField textField5;
    static JFrame frame;

    public AddEarthquake() {
        addEarthquakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double magnitude= Double.parseDouble(textField1.getText());
                String lat= textField2.getText();
                String lon= textField3.getText();
                String year= textField4.getText();
                String observatory= textField5.getText();
                Earthquake quake= new Earthquake(magnitude,lat,lon,year);
                MonitoringGUI.database.addEarthquake(quake,observatory);
                JOptionPane.showMessageDialog(null,"Added Earthquake to "+observatory,
                        "Added Earthquake",JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("AddEarthquake");
        frame.setContentPane(new AddEarthquake().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

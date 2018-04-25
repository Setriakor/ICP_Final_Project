import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The MonitoringGUI class contains the code for the action listeners for the buttons on the
 * MonitoringGUI form. This class employs the same functionality as the MonitoringIO class and
 * can be used to add an earthquake, add an observatory, view the observatory with the largest average magnitude,
 * view the earthquake with largest magnitude, view a list of earthquakes with a
 * magnitude greater than a number specified by the user, and exit the program
 * @author Setriakor Addom Ohemaa Akoto
 */
public class MonitoringGUI extends JFrame{
    private JButton addEarthquakeButton;
    private JButton addObservatoryButton;
    private JButton viewAverageEarthquakeButton;
    private JButton viewLargestMagnitudeEarthquakeButton;
    private JPanel panel;
    private JButton viewEarthquakesButton;
    private JButton exitButton;
    public JFrame frame;

    static Database database= new Database();
    static Monitoring monitor=database.monitor();

    /**
     * The Constructor for the MonitoringGUI class that contains the action listeners for the buttons on the form
     */
    public MonitoringGUI() {
        addEarthquakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("AddEarthquake");
                frame.setContentPane(new AddEarthquake().panel);
                AddEarthquake.frame=frame;
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setPreferredSize(new Dimension(400,400));
                frame.setVisible(true);

            }
        });
        addObservatoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("AddObservatory");
                AddObservatory.frame= frame;
                frame.setContentPane(new AddObservatory().panel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        viewAverageEarthquakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(monitor.getLargestEarthquake());
                String observe= monitor.getObserveAveLarg().toString();
                JOptionPane.showMessageDialog(null,"The Observatory with the largest average earthquake magnitude is: "+observe,
                        "Largest Average Magnitude Observatory",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        viewLargestMagnitudeEarthquakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String earthquake= monitor.getLargestEarthquake();
                JOptionPane.showMessageDialog(null,"The Earthquake with the largest magnitude ever is: "+earthquake,
                        "Largest Earthquake Ever",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        viewEarthquakesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double mag= Double.parseDouble(JOptionPane.showInputDialog("Enter Magnitude: "));
                String earthquakes= monitor.listOfEarthquakes(mag);
                JOptionPane.showMessageDialog(null,"Earthquakes with a magnitude higher than "+mag+": "+earthquakes,
                        "List of Earthquakes",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Thank You",
                        "Exit",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MonitoringGUI");
        frame.setContentPane(new MonitoringGUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        frame.pack();
        frame.setVisible(true);
    }
}

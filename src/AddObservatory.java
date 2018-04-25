import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The AddObservatory class contains the code that allows a user to input information about
 * an observatory in the AddObservatory form and add it to a database
 */
public class AddObservatory extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    public JPanel panel;
    private JButton addObservatoryButton;
    Database database= new Database();
    static JFrame frame;

    public AddObservatory() {
        addObservatoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= textField1.getText();
                String country= textField2.getText();
                String year= textField3.getText();
                int area= Integer.parseInt(textField4.getText());
                database.addObservatory(name, country,year,area);
                JOptionPane.showMessageDialog(null,"Added Observatory "+name+" located in "+country,
                        "Added Observatory",JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {

        frame.setContentPane(new AddObservatory().panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

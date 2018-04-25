import java.util.Scanner;

/**
 * A MonitoringIO class that contains a main method to run a program that
 * allows users to input commands that allow them to add an earthquake,
 * add an observatory, view the observatory with the largest average magnitude,
 * view the earthquake with largest magnitude, view a list of earthquakes with a
 * magnitude greater than a number specified by the user, and exit the program
 * @author Setriakor Addom and Ohemaa Akoto
 */
public class MonitoringIO {

    public static final String ADD_EARTHQUAKE = "add earthquake";
    public static final String ADD_OBSERVATORY = "add observatory";
    public static final String VIEW_AVE_EARTHQUAKE = "average magnitude";
    public static final String VIEW_MAGNITUDE = "largest magnitude";
    public static final String VIEW_EARTHQUAKES = "view earthquakes";
    public static final String EXIT = "exit";

    /**
     * A static method that prints out the list of user input commands and what they do
     */
    public static void printMenu() {
        System.out.println("List of Commands: ");
        System.out.println("Type " + "'" + ADD_EARTHQUAKE + "'" + " to: add earthquake event");
        System.out.println("Type " + "'" + ADD_OBSERVATORY + "'" + " to: create new observatory");
        System.out.println("Type '" + VIEW_AVE_EARTHQUAKE + "' to: view observatory with the largest average earthquake magnitude");
        System.out.println("Type '" + VIEW_MAGNITUDE + "' to: view largest magnitude earthquake");
        System.out.println("Type '" + VIEW_EARTHQUAKES + "' to: view earthquakes with a magnitude grater than a given number");
        System.out.println("Type '"+EXIT + "' : End the program");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command;

        Monitoring monitor = new Monitoring();

        do {
            printMenu();
            System.out.println("Please enter command: ");
            command = scan.next();
            String command1= scan.nextLine();
            command+=command1;

            if (command.equalsIgnoreCase(ADD_EARTHQUAKE)) {
                if (monitor.list.size() != 0) {
                    System.out.println("Enter the latitude coordinates: ");
                    String lat = scan.nextLine();
                    System.out.println("Enter the longitude coordinates: ");
                    String lon = scan.nextLine();
                    System.out.println("Enter earthquake magnitude: ");
                    double magnitude = scan.nextDouble();
                    System.out.println("Enter year in which earthquake occurred: ");
                    String year = scan.next();
                    Earthquake quake = new Earthquake(magnitude, lat,lon, year);
                    System.out.println("Enter the name of the observatory that recorded the earthquake: ");
                    System.out.println(monitor.toString());
                    String observatory = scan.next();
                    for (int i = 0; i < monitor.list.size(); i++) {
                        if (monitor.list.get(i).name.equalsIgnoreCase(observatory)) {
                            monitor.list.get(i).addEarthquake(quake);
                            System.out.println("Successfully added earthquake to observatory " + observatory + "'s records");
                            break;
                        } else if(i==monitor.list.size()-1) {
                            System.out.println("There is no observatory with that name");
                        }
                    }
                } else {
                    System.out.println("There are no observatories added. Please add an observatory before adding an earthquake");
                    System.out.println();
                }
            } else if (command.equalsIgnoreCase(ADD_OBSERVATORY)) {
                System.out.println("Enter Observatory name: ");
                String name = scan.next();
                System.out.println("Enter country Observatory is located in: ");
                String country = scan.next();
                System.out.println("Enter year in which Observatory started recording earthquakes: ");
                String year = scan.next();
                System.out.println("Enter area covered by Observatory: ");
                int area = scan.nextInt();
                monitor.addObservatory(name, country, year, area);
                System.out.println("The observatory "+name+" located in "+country+" has been added");
            } else if (command.equalsIgnoreCase(VIEW_AVE_EARTHQUAKE)) {
                System.out.println("The Observatory with the largest average earthquake magnitude: ");
                System.out.println(monitor.getObserveAveLarg());
            } else if (command.equalsIgnoreCase(VIEW_MAGNITUDE)) {
                System.out.println("The earthquake with the largest magnitude is:");
                System.out.println(monitor.getLargestEarthquake().toString());
            } else if (command.equalsIgnoreCase(VIEW_EARTHQUAKES)) {
                System.out.println("Enter magnitude: ");
                double mag = scan.nextDouble();
                System.out.println("The earthquakes with a magnitude greater than " + mag + " are: ");
                System.out.println(monitor.listOfEarthquakes(mag));
            }else if(command.equalsIgnoreCase(EXIT)){
                System.out.println("Program ended");
            } else {
                System.out.println("That is not a valid command");
            }

        } while (!command.equalsIgnoreCase(EXIT));
    }
}

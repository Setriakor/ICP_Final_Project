import java.sql.*;

/**
 * The Database class creates a connection to a database and contains methods that allow
 * a user to save earthquake and observatory data to a database and retrieve the data. It contains
 * a method that recreates a Monitoring object from the database by retrieving earthquake and observatory
 * information from the database and recreating earthquake and observatory objects to store in the
 * Monitoring object
 * @author Setriakor Addom and Ohemaa Akoto
 */
public class Database {
    Connection con;
    PreparedStatement pst; //This is new thing right!
    ResultSet rs;
    Statement state;
    Monitoring monitor= new Monitoring();

    /**
     * The Constructor predefines the details for the new Database object
     */
    public Database() {
        try{

            //MAKE SURE YOU KEEP THE mysql_connector.jar file in java/lib folder
            //ALSO SET THE CLASSPATH
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/monitoring","root","");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    /**
     * Recreates a Monitoring object by looping through the database and collecting information on
     * the earthquakes and databases and reconstructing the objects to insert into the monitor
     * @return a monitoring object with all the earthquake and observatory information present in the database
     */
    public Monitoring monitor(){
        try {

            pst=con.prepareStatement("SELECT * FROM observatories");
            ResultSet rs= pst.executeQuery();

            while(rs.next()){
                String name = rs.getString(1);
                String country= rs.getString(2);
                String year= rs.getString(3);
                int area= Integer.parseInt(rs.getString(4));
                monitor.addObservatory(name, country, year, area);
            }

            pst= con.prepareStatement("SELECT * FROM earthquakes");
            rs= pst.executeQuery();

            while(rs.next()) {
                double magnitude = Double.parseDouble(rs.getString(1));
                String lat = rs.getString(2);
                String lon = rs.getString(3);
                String year = rs.getString(5);
                String observatory = rs.getString(6);

                Earthquake quake = new Earthquake(magnitude, lat, lon, year);
                for (int i = 0; i < monitor.list.size(); i++) {
                    if (monitor.list.get(i).name.equalsIgnoreCase(observatory)) {
                        monitor.list.get(i).addEarthquake(quake);
                        System.out.println("Successfully added earthquake to observatory " + observatory + "'s records");
                        break;
                    }
                }
            }

        }catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return monitor;
    }

    /**
     * Adds an observatory to the database and the Monitoring object by accepting the details for an observatory class
     * as parameters
     * @param name the name of the observatory
     * @param country the country the observatory is located in
     * @param year the year the observatory started recording
     * @param area the area the observatory covers
     */
    public void addObservatory(String name, String country, String year, int area){
        try {
            pst=con.prepareStatement("INSERT INTO observatories (name, country, year,area)" +
                            "Values(?,?,?,?)");
            pst.setString(1,name);
            pst.setString(2,country);
            pst.setString(3,year);
            pst.setString(4,Integer.toString(area));
            pst.executeUpdate();
            monitor.addObservatory(name,country,year,area);
        }catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds an earthquake to the database and the Monitoring object
     * @param quake the earthquake to be added to the database
     * @param observatory the name of the observatory that recorded the earthquake
     */
    public void addEarthquake(Earthquake quake, String observatory){
        try {
            pst=con.prepareStatement("INSERT INTO earthquakes (magnitude, latitude, longitude,position,year,observatory)" +
                    "Values(?,?,?,?,?,?)");
            pst.setString(1,Double.toString(quake.getMagnitude()));
            pst.setString(2,quake.getLat());
            pst.setString(3,quake.getLon());
            pst.setString(4,quake.getPosition());
            pst.setString(5,quake.getYear());
            pst.setString(6,observatory);
            pst.executeUpdate();
            for (int i = 0; i < monitor.list.size(); i++) {
                if (monitor.list.get(i).name.equalsIgnoreCase(observatory)) {
                    monitor.list.get(i).addEarthquake(quake);
                    System.out.println("Successfully added earthquake to observatory " + observatory + "'s records");
                    break;
                }
            }
        }catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }


}

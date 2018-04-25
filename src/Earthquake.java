
/**The Earthquake Class describes an "Earthquake" Object:
 * The purpose of this class is to model and earthquake and has
 * instance variable magnitude, position, lat, lon, and year
 * There is a single constructor takes in magnitude , position , lat, lon, and year
 * The class also has accessor and mutator methods for the instance variables
 * @author Setriakor Addom and Ohemaa Akoto
 */
public class Earthquake {

    double magnitude;
    String position;
    String lat;
    String lon;
    String year;

    /**
     *Constructor for Earthquake Class
     * @param magnitude the magnitude of the earthquake
     * @param lat the latitude coordinates of the earthquake
     * @param lon the longitude coordinates of the earthquake
     * @param year the year in which the earthquake event occurred
     */
    public Earthquake(double magnitude, String lat, String lon, String year) {
        this.magnitude = magnitude;
        this.lat=lat;
        this.lon=lon;
        position="The position of this earthquake is Latitude: "+lat+", Longitude: "+lon;
        this.year = year;
    }

    /**
     * Returns the latitude of coordinates of the earthquake
     * @return the latitude of coordinates of the earthquake
     */
    public String getLat() {
        return lat;
    }

    /**
     * Returns the longitude of coordinates of the earthquake
     * @return the longitude of coordinates of the earthquake
     */
    public String getLon() {
        return lon;
    }

    /**
     * Returns the magnitude of the earthquake
     * @return the magnitude of the earthquake
     */
    public double getMagnitude() {
        return magnitude;
    }

    /**
     *Returns the position of the earthquake
     * @return the position of the earthquake
     */
    public String getPosition() {
        return position;
    }

    /**
     * Returns the year the earthquake occurred
     * @return the year instance variable
     */
    public String getYear() {
        return year;
    }

    /**
     * Sets the magnitude of the earthquake object
     * @param magnitude the magnitude of the earthquake
     */
    public void setMagnitude(int magnitude) {
        this.magnitude = magnitude;
    }

    /**
     * Sets the position of the earthquake
     * @param position sets the position of the earthquake
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Sets the year the earthquake occurred
     * @param year the year instance variable
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     *Returns a string representation of the Earthquake object
     */
    @Override
    public String toString() {
        return "Earthquake{" +
                "magnitude=" + magnitude +
                ", position='" + position + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}

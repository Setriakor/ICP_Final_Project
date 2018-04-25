import java.util.ArrayList;

/**
 * The Observatory class describes an "Observatory" object:
 * The purpose of this class is to model and observatory that is used to
 * record earthquake events and store them and has instance variables
 * name, country, yearStarted, and areaCovered. The class also hass accessor
 * and mutator methods for the variables
 * @author Setriakor Addom and Ohemaa Akoto
 */
public class Observatory {

    String name;
    String country;
    String yearStarted;
    int areaCovered;
    ArrayList<Earthquake> list= new ArrayList<>();

    Earthquake largestMag= new Earthquake(0,"","","");
    double sumMag=0;

    /**
     * A Constructor for the Observatory class
     * @param name the name of the observatory
     * @param country the country the observatory is located in
     * @param yearStarted the year the observatory started recording
     * @param areaCovered the area the observatory covers
     */
    public Observatory(String name, String country, String yearStarted, int areaCovered) {
        this.name = name;
        this.country = country;
        this.yearStarted = yearStarted;
        this.areaCovered = areaCovered;
    }


    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getYearStarted() {
        return yearStarted;
    }

    public int getAreaCovered() {
        return areaCovered;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setYearStarted(String yearStarted) {
        this.yearStarted = yearStarted;
    }

    public void setAreaCovered(int areaCovered) {
        this.areaCovered = areaCovered;
    }

    /**
     * Adds an earthquake objects to the list in the Observatory
     * @param quake the earthquake object to be added to the list
     */
    public void addEarthquake( Earthquake quake){
        list.add(quake);
        sumMag+=quake.getMagnitude();
        if(quake.getMagnitude()> largestMag.getMagnitude())
            largestMag=quake;
    }

    /**
     * Returns the earthquake with the largest magnitude in the Observatory
     * @return the earthquake with the largest magnitude
     */
    public Earthquake getLargestMag(){
        return largestMag;
    }

    /**
     * Returns the average magnitude of all the earthquakes in the observatory
     * @return the average magnitude of all the earthquakes in the observatory
     */
    public double getAverageMagnitude(){
        if (list.size() !=0)
            return sumMag/list.size();
        else
            return 0;
    }

    /**
     * Returns a string that contains the details of all the earthquakes recorded by the observatory
     * that have a magnitude greater than the number the user specifies
     * @param mag the magnitude that is the minimum bar for the earthquakes to be returned
     * @return a string representation of all the earthquakes in the observatory
     */
    public String listOfEarthquakes(double mag){
        ArrayList<Earthquake> rList= new ArrayList<>();
        for (int i= 0; i<list.size();i++){
            if(list.get(i).getMagnitude()>mag)
                rList.add(list.get(i));
        }
        if(rList.size()==0)
            return "There are no earthquakes with a magnitude greater than "+ mag;
        else
            return rList.toString();
    }

    /**
     * Returns a String reprsentation of the observatory class
     * @return a string containing the details of the observatory
     */
    @Override
    public String toString() {
        return "Observatory{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", yearStarted='" + yearStarted + '\'' +
                ", areaCovered=" + areaCovered +
                ", AveMag=" + sumMag/list.size() +
                '}';
    }
}

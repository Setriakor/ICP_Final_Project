import java.util.ArrayList;

/**
 * A Monitoring Class describes a monitor object:
 * The purpose of this class is to keep track of all the observatories
 * created and store them. It contains a list that is used to contain the
 * observatory objects
 * @author Setriakor Addom and Ohemaa Akoto
 */
public class Monitoring {

    ArrayList<Observatory> list = new ArrayList<>();
    double largestAveMag=0;
    Earthquake largestMag= new Earthquake(0,"","","");
    Observatory observeAveLarg;

    /**
     * A Constructor for the class that has no parameters
     */
    public Monitoring() {
    }

    /**
     * Adds an observatory object to the class by accepting the details for an observatory class
     * as parameters and creating the observatory object then adding it the the list
     * @param name the name of the observatory
     * @param country the country the observatory is located in
     * @param yearStarted the year the observatory started recording
     * @param areaCovered the area the observatory covers
     */
    public void addObservatory(String name, String country, String yearStarted, int areaCovered){
        Observatory observatory= new Observatory(name, country, yearStarted, areaCovered);
        list.add(observatory);
        if(observatory.getLargestMag().getMagnitude()>largestMag.getMagnitude())
            largestMag=observatory.getLargestMag();
        if(observatory.getAverageMagnitude()>largestAveMag) {
            largestAveMag = observatory.getAverageMagnitude();
            observeAveLarg=observatory;
        }
    }

    /**
     * Returns a String containing a list of observatory names
     * @return a String containing a list of observatory names
     */
    @Override
    public String toString() {
        String names="";
        for(int i=0;i<list.size();i++)
            names+=list.get(i).getName()+", ";
        return "List of Observatories: " +names;
    }

    /**
     * Returns a string that contains the details of all the earthquakes recorded by all the observatories
     * in the monitor that have a magnitude greater than the number the user specifies
     * @param mag the magnitude that is the minimum bar for the earthquakes to be returned
     * @return a string representation of all the earthquakes in the monitoring class
     */
    public String listOfEarthquakes(double mag){
        String earthquakes="";
        for(int i=0;i<list.size();i++){
            if(!list.get(i).listOfEarthquakes(mag).equals("There are no earthquakes with a magnitude greater than "+ mag))
                earthquakes+=list.get(i).listOfEarthquakes(mag);
        }
        if(earthquakes.equals(""))
            return "There are no earthquakes with a magnitude greater than "+ mag;
        else
            return earthquakes;
    }

    /**
     * Return the observatory with the largest average magnitude
     * @return an observatory object that has the largest average magnitude
     */
    public Observatory getObserveAveLarg() {
        for (int i=0;i<list.size();i++){
            if(list.get(i).getAverageMagnitude()>largestAveMag)
                observeAveLarg=list.get(i);
        }
        return observeAveLarg;
    }

    /**
     * Return the earthquake with the largest magnitude ever recorded
     * @return a string representation of the earthquake with the largest magnitude
     */
    public String getLargestEarthquake(){
        for(int i=0;i<list.size();i++){
            if (list.get(i).getLargestMag().getMagnitude()>largestMag.getMagnitude())
                largestMag=list.get(i).getLargestMag();
        }
        return largestMag.toString();
    }
}

 import java.util.*;

/**
 * Represents various States and their respective cities.
 *
 * @author Nishad
 * @version 03/22
 * @author Period - 6
 *
 * @author Assignment - TestSem2CollectionsStates
 *
 * @author Sources - me, myself, and I
 */
public class States
{
    private Map<String, Set<String>> theMap;

    public States()
    {
        theMap = new TreeMap<String, Set<String>>();
    }

    // postcondition: Information from theCity
    // has been added to theMap
    public void addCityToMap(CityInfo theCity)
    {
        if (!theMap.containsKey(theCity.state())) {
            Set<String> set = new TreeSet<String>();
            set.add(theCity.city());
            theMap.put(theCity.state(), set);
        }
        else {
            theMap.get(theCity.state()).add(theCity.city()); 
        }
    }

    public void printOneState(String theState)
    {
        // not allowed since output is specified without the "[...]"
        // System.out.println(theState + " " + theMap.get(theState));
        
        String str = theState;

        for (String city : theMap.get(theState)) {
            str += " " + city;
        }

        System.out.println(str);
    }

    public void printAllStates()
    {
        String str = "";
        for (String state : theMap.keySet()) {
            str += state;

            for (String city : theMap.get(state)) {
                str += " " + city;
            }

            str += "\n";
        }

        System.out.println(str);
    }

    //*************************************************************
    // For test purposes only
    // not to be used in solution implementation
    public Map<String, Set<String>> getTheMap()
    {
        return theMap;
    }
}

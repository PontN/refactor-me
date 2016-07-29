import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;


/**Changed by Nicolas.
 * @author Hugh Glykod
 */


public class Restaurant {


    private String name;
    private Map<DayOfWeek,OpeningHour> openDayHour = new HashMap<>();

    //Getteur Seteur
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Map<DayOfWeek, OpeningHour> getOpenDayHour() {return openDayHour;}
    public void setOpenDayHour(Map<DayOfWeek, OpeningHour> openDayHour) {this.openDayHour = openDayHour;}


    //Constructor
    public Restaurant(String name, Map<DayOfWeek, OpeningHour> openDayHour) {
        this.name = name;
        this.openDayHour = openDayHour;
    }


    //Method which represents if Restaurant is Open with one parameter day.
    public boolean isOpen(DayOfWeek day){
        if (LocalTime.now().isAfter(LocalTime.parse(openDayHour.get(day).getOpenHour()))
                && LocalTime.now().isBefore(LocalTime.parse(openDayHour.get(day).getCloseHour())));
        return true;
    }
}
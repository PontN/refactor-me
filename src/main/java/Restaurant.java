import java.time.*;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Hugh Glykod
 * @author Nicolas.
 */


public class Restaurant {

    private String name;
    private Map<DayOfWeek, OpeningHour> openDayHour = new HashMap<>();
    private Clock clockNow;


    //Getteur Seteur
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<DayOfWeek, OpeningHour> getOpenDayHour() {
        return openDayHour;
    }

    public void setOpenDayHour(Map<DayOfWeek, OpeningHour> openDayHour) {
        this.openDayHour = openDayHour;
    }

    public Clock getClockNow() {return clockNow;}

    public void setClockNow(Clock clockNow) {this.clockNow = clockNow;}


    //Constructor
    public Restaurant(String name, Map<DayOfWeek, OpeningHour> openDayHour) {
        this.name = name;
        this.openDayHour = openDayHour;
        clockNow = Clock.systemDefaultZone();
    }


    //Method which represents if Restaurant is Open with 2 parameters (day and clock)
    // You can set clock by the real clock, just by recalling clocknow in Restaurant constructor.
    public boolean isOpen(DayOfWeek day, Clock clock) {
        if (LocalTime.now(clock).isAfter(LocalTime.parse(openDayHour.get(day).getOpenHour()))
                && LocalTime.now(clock).isBefore(LocalTime.parse(openDayHour.get(day).getCloseHour()))) {
            return true;
        } else return false;
    }
}
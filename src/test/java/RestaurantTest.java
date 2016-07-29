import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import static java.time.Clock.systemDefaultZone;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * @author Hugh Glykod
 * @author Nicolas
 */
public class RestaurantTest {

    private Map<DayOfWeek, OpeningHour> openDayHour = new HashMap<>();

    @Test
    public void testClockNow() {

        Restaurant r1 = new Restaurant("Big boobs coffee", openDayHour);
        assertNotNull(r1.getClockNow());
    }


    @Test
    public void testRestaurantIsOpenWithClockFixedOpen() {
        openDayHour.put(DayOfWeek.MONDAY, new OpeningHour("09:00", "18:00"));
        openDayHour.put(DayOfWeek.TUESDAY, new OpeningHour("09:00", "18:00"));
        openDayHour.put(DayOfWeek.WEDNESDAY, new OpeningHour("09:00", "18:00"));
        openDayHour.put(DayOfWeek.THURSDAY, new OpeningHour("09:00", "18:00"));
        openDayHour.put(DayOfWeek.FRIDAY, new OpeningHour("09:00", "18:00"));
        openDayHour.put(DayOfWeek.SATURDAY, new OpeningHour("09:00", "18:00"));
        openDayHour.put(DayOfWeek.SUNDAY, new OpeningHour("00:00", "00:00"));


        Restaurant r1 = new Restaurant("La frite a Dédé ", openDayHour);
        Clock clockFixedShouldOpen = Clock.fixed(Instant.parse("2016-01-01T12:00:00Z"), ZoneId.systemDefault());
        assertTrue(r1.isOpen(DayOfWeek.SATURDAY, clockFixedShouldOpen));
    }


    @Test
    public void testRestaurantIsOpenWithClockFixedClose() {
        openDayHour.put(DayOfWeek.MONDAY, new OpeningHour("09:00", "18:00"));
        openDayHour.put(DayOfWeek.TUESDAY, new OpeningHour("09:00", "18:00"));
        openDayHour.put(DayOfWeek.WEDNESDAY, new OpeningHour("09:00", "18:00"));
        openDayHour.put(DayOfWeek.THURSDAY, new OpeningHour("09:00", "18:00"));
        openDayHour.put(DayOfWeek.FRIDAY, new OpeningHour("09:00", "18:00"));
        openDayHour.put(DayOfWeek.SATURDAY, new OpeningHour("09:00", "18:00"));
        openDayHour.put(DayOfWeek.SUNDAY, new OpeningHour("00:00", "00:00"));


        Restaurant r1 = new Restaurant("Mcdo", openDayHour);

        Clock clockFixedShouldClose = Clock.fixed(Instant.parse("2016-01-01T00:00:00Z"), ZoneId.systemDefault());
        assertFalse(r1.isOpen(DayOfWeek.SUNDAY, clockFixedShouldClose));
        assertFalse(r1.isOpen(DayOfWeek.FRIDAY, clockFixedShouldClose));
    }
}
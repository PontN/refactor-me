/**
 * Created by Nicolas on 29/07/2016.
 */
public class OpeningHour {

    private String openHour;
    private String closeHour;


    public String getOpenHour() {return openHour;}
    public void setOpenHour(String openHour) {this.openHour = openHour;}

    public String getCloseHour() {return closeHour;}
    public void setCloseHour(String closeHour) {this.closeHour = closeHour;}


    public OpeningHour(String openHour, String closeHour) {
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

}

/**
 * Created by Nicolas on 29/07/2016.
 */
public class OpeningHour {

    private String openHour;
    private String closeHour;

    //Getteur Seteur
    public String getOpenHour() {return openHour;}

    public void setOpenHour(String openHour) {this.openHour = openHour;}

    public String getCloseHour() {return closeHour;}

    public void setCloseHour(String closeHour) {this.closeHour = closeHour;}

    //Constructor
    public OpeningHour(String openHour, String closeHour) {
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

}

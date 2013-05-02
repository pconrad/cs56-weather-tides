/**

   An object to represent a TidePrediction

   @author P. Conrad
   @version CS56 S13 UCSB

 */

public class TidePrediction {

    /** Construct a Tide Prediction object 

       @param date Date in format YYYY/MM/DD
       @param time Time in format HH:MM AM  (AM=AM or PM)
       @param levelInCm tide level in cm
       @param tideTypeHorL  H for High Tide, L for Low Tide
    */

    public TidePrediction(String date_YYYYMMDD, 
			  String time_hhmmAP,
			  double levelInCm,
			  char tideTypeHorL) {
	// @ stub
    }

    public Calendar getTideTime() {  return null; }
    public char getTideType() { return '?'; }
    public double getLevel() { return -42.0; }
}
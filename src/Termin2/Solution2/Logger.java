package Termin2.Solution2;

/**
 * Created by alan on 21/04/15.
 */
public class Logger {
    private static boolean LOG_MODE = true;

    static public void log(String message){
        if (LOG_MODE){
            java.util.Date now = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
            String output = "[" + sdf.format(now) + "] : ";
            output += message;
            System.err.println(output);
        }
    }
}

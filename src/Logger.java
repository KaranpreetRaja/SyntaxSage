import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {


    private static final String LOG_FILE_NAME = "application.log"; //log file name, change if needed

    

    public static void log(String methodName, String message) {
        try {
            FileWriter fw = new FileWriter(LOG_FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String log = String.format("%s [%s]: %s", methodName, dateFormat.format(new Date()), message);
            bw.write(log);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("There was an error (oopsies) writing to log file: " + e.getMessage());
        }
    }
}

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    protected int num = 1;
    private static Logger logger = null;

    public void log(String msg){
        String DateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        System.out.println("[" + DateTime + " " + num++ + "] >>> " + msg);
    }

    private Logger() {}

    public static Logger getInstance(){
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

}

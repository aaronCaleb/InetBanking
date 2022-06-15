package inetbanking.utilities;

import org.apache.log4j.Logger;

public class Log {

    //Initialise log4j logs
    public static Logger Log = Logger.getLogger(Log.class.getName());

    public static void startTestCase(String sTestCaseName){
        Log.info("================================"+sTestCaseName+"TEST START===================");
    }

    public static void endTestCase(String sTestCaseName){
        Log.info("================================"+sTestCaseName+"TEST END=====================");
    }

    public static void info(String message){
        Log.info(message);
    }

    public static void warn(String message) {
        Log.warn(message);
    }

    public static void error(String message) {
        Log.error(message);
    }

    public static void debug(String message) {
        Log.debug(message);

    }

}

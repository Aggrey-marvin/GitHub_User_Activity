package app;

import java.util.Map;
import java.util.HashMap;

public class CommandLine {
    public Map<String, String> parseCommandLineArgs(String [] args) {
        Map<String, String> result =  new HashMap<String, String>();
        if (args.length > 1) {
            result.put("success", "0");
            result.put("error", "Too many arguments" );
            return result;
        } else if (args.length < 1) {
            result.put("success", "0");
            result.put("error", "Too few arguments" );
            return result;
        } else {
            result.put("success", "1");
            result.put("username", args[0]);
            return result;
        }
    }
}

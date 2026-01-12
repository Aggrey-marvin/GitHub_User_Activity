import java.util.Map;
import app.CommandLine;
import app.UserActivity;
import app.Username;

public class Main {
    public static void main(String[] args) {
        System.out.println("Github User Activity");
        System.out.println("************************");
        
        CommandLine commandLine = new CommandLine();
        Map<String, String> result = commandLine.parseCommandLineArgs(args);

        if (result.get("success").equals("1")){
            String username = result.get("username");
            Username usernameVerifier = new Username();
            Boolean usernameValid = usernameVerifier.verifyUserName(username);
            
            if (usernameValid == true) {
                // Make api call
                UserActivity userActivity = new UserActivity();
                userActivity.getUserActivity(username);

                // Format the result & pring the result
                
            } else {
                System.out.println("The username " + username + " is invalid");
            }
        } else {
            System.out.println(result.get("error"));
        }
    }
}

import java.util.Map;
import app.CommandLine; 
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
            System.out.println(usernameValid);
        } else {
            System.out.println(result.get("error"));
        }
    }
}

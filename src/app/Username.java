package app;

import java.net.http.HttpResponse;

public class Username {
    public Boolean verifyUserName(String username) {
        APICaller caller = new APICaller();
        HttpResponse<String> response = caller.makeAPICall("https://api.github.com/users/" + username);

        String responseUsername = extractValue(response.body(), "login");

        if (response.statusCode() == 200 && responseUsername.equals((username))) {
            return true;
        } else {
            return false;
        }
    }

    public String extractValue(String jsonString, String key) {
        String searchKey = "\"" + key + "\":";
        int keyPosition = jsonString.indexOf(searchKey);
        if (keyPosition == -1) return null;

        int openQuote = jsonString.indexOf("\"", keyPosition + searchKey.length()) + 1;
        int closeQuote = jsonString.indexOf("\"", openQuote);

        return jsonString.substring(openQuote, closeQuote);
    }
}

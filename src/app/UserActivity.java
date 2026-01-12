package app;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class UserActivity {
    public void getUserActivity(String username) {
        APICaller caller = new APICaller();
        HttpResponse<String> response = caller.makeAPICall("https://api.github.com/users/" + username + "/events");

        JSONArray events = new JSONArray(response.body());

        ArrayList<EventType> createdEventTypes = new ArrayList<EventType>();

        for (int i = 0; i < events.length(); i++) {
            JSONObject event = events.getJSONObject(i);
            String type = event.getString("type");
            String repoName = event.getJSONObject("repo").getString("name");

            EventType eventType = checkEventCreated(createdEventTypes, type, repoName);

            if (eventType == null) {
                eventType = new EventType(type, 1, repoName);
                createdEventTypes.add(eventType);
            } else {
                eventType.incrementOcurrences(i);
            }
            
        }

        for (EventType event: createdEventTypes) {
            System.out.println("-> " + event.getOccurences() + " " + event.getName() + " to " + event.getRepository());
        }
    }

    private EventType checkEventCreated(ArrayList<EventType> events, String eventType, String repoName) {
        for(EventType event: events) {
            if (event.getName().equals(eventType) && event.getRepository().equals(repoName)) {
                return event;
            }
        }
        return null;
    }
}

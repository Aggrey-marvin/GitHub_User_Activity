package app;

public class EventType {
    private String name;
    private int occurences;
    private String repository;
    
    public EventType(String name, int occurences, String repository) {
        this.name = name;
        this.occurences = occurences;
        this.repository = repository;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOccurences() {
        return occurences;
    }

    public void incrementOcurrences(int occurences) {
        this.occurences++;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    
}

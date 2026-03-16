package ro.uaic.info.model;

import java.util.HashMap;
import java.util.Map;

public class Resource {
    private String id;
    private String title;
    private String location;
    private Map<String, Object> tags = new HashMap<>();

    public Resource(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public void addTag(String key, Object value) {
        tags.put(key, value);
    }

    public String getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Resource{id='" + id + "', title='" + title + "', tags=" + tags + "}";
    }
}
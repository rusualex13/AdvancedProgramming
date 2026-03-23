package com.biblio.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Aceasta este clasa de bază pentru toate resursele (cărți, articole, etc.)
 */
public abstract class Resource implements Serializable {
    private String id;
    private String title;
    private String location; // Cale pe disc (ex: D:/books/..) sau URL (https://..)

    // O hartă pentru proprietăți extra (an, autor, descriere)
    private Map<String, Object> tags = new HashMap<>();

    public Resource(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    // Metodă pentru a adăuga proprietăți extra (an, autor etc.)
    public void addTag(String key, Object value) {
        tags.put(key, value);
    }

    public Object getTag(String key) {
        return tags.get(key);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Resource{" + "id='" + id + '\'' + ", title='" + title + '\'' + '}';
    }
}
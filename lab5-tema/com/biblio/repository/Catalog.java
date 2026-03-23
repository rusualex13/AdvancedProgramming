package com.biblio.repository;

import com.biblio.model.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private List<Resource> resources = new ArrayList<>();

    public void add(Resource res) {
        resources.add(res);
    }

    public Resource findById(String id) {
        return resources.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Resource> getResources() {
        return resources;
    }
}
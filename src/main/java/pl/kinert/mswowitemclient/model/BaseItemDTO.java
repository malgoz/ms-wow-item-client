package pl.kinert.mswowitemclient.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class BaseItemDTO {
    @JsonAlias({"display_name", "name"})
    private String name;
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

package com.github.ggerrietts.people.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ggerrietts.people.api.FreePerson;
import io.dropwizard.Configuration;

import java.util.List;

public class AppConfig extends Configuration {
    private List<FreePerson> people;

    @JsonProperty
    public List<FreePerson> getPeople() {
        return people;
    }

    @JsonProperty
    public void setPeople(List<FreePerson> people) {
        this.people = people;
    }

}

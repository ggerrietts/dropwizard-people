package com.github.ggerrietts.people.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ggerrietts.people.api.Person;
import io.dropwizard.Configuration;

import java.util.List;

public class AppConfig extends Configuration {
    private List<Person> people;

    @JsonProperty
    public List<Person> getPeople() {
        return people;
    }

    @JsonProperty
    public void setPeople(List<Person> people) {
        this.people = people;
    }

}

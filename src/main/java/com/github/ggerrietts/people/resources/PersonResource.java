package com.github.ggerrietts.people.resources;

import com.codahale.metrics.annotation.Timed;
import com.github.ggerrietts.people.api.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {
    private final List<Person> people;

    public PersonResource(List<Person> people) {
        this.people = people;
    }

    @GET
    @Timed
    public List<Person> getPersons() {
        return this.people;
    }
}

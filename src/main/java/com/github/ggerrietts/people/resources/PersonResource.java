package com.github.ggerrietts.people.resources;

import com.codahale.metrics.annotation.Timed;
import com.github.ggerrietts.people.api.FreePerson;
import com.github.ggerrietts.people.api.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {
    private final AtomicLong counter;
    private final List<Person> people;

    public PersonResource(List<FreePerson> rawPeople) {
        this.counter = new AtomicLong();
        List<Person> cookedPeople = new ArrayList<>();

        for (FreePerson r : rawPeople) {
            long id = this.counter.incrementAndGet();
            Person p = new Person(id,r.getName(), r.getEmail());
        }


        this.people = cookedPeople;
    }

    @GET
    @Timed
    public List<Person> getPersons() {
        return this.people;
    }
}

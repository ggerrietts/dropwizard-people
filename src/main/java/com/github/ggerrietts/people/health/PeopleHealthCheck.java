package com.github.ggerrietts.people.health;

import com.codahale.metrics.health.HealthCheck;
import com.github.ggerrietts.people.api.Person;

import java.util.List;

public class PeopleHealthCheck extends HealthCheck {
    private final List<Person> people;

    public PeopleHealthCheck(List<Person> people){
        this.people = people;
    }

    @Override
    protected Result check() throws Exception {
        if (this.people.size() == 0) {
            return Result.unhealthy("no people in configuration");
        }
        return Result.healthy();
    }
}

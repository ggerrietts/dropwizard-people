package com.github.ggerrietts.people.api;

import org.hibernate.validator.constraints.Length;

public class Person {
    private long id;

    @Length(max=255)
    private String name;

    @Length(max=255)
    private String email;

    public Person() {
        // Jackson deserialization
    }

    public Person(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

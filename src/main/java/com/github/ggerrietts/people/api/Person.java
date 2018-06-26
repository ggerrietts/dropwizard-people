package com.github.ggerrietts.people.api;

import org.hibernate.validator.constraints.Length;

import java.util.concurrent.atomic.AtomicLong;

public class Person {
    private final static AtomicLong counter = new AtomicLong();
    private long id;

    @Length(max=255)
    private String name;

    @Length(max=255)
    private String email;

    public static void resetCounter() {
        // for testing, basically
        counter.set(0);
    }

    public Person() {
        // Jackson deserialization
        this.id = this.counter.incrementAndGet();
    }

    // for creating from
    public Person(String name, String email) {
        this.id = this.counter.incrementAndGet();
        this.name = name;
        this.email = email;
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

    @Override
    public String toString() {
        return "Person{" + "id=" + id + " name=" + name + " email=" + email + "}";
    }
}

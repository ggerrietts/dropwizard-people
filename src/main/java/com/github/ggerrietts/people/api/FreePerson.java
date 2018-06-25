package com.github.ggerrietts.people.api;

import org.hibernate.validator.constraints.Length;

/* "I am not a number! I am a free man!"
 *                 -- Number Six
 */
public class FreePerson {
    @Length(max=255)
    private String name;

    @Length(max=255)
    private String email;

    public FreePerson() {
        // Jackson deserialization
    }

    public FreePerson(long id, String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

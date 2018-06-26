package com.github.ggerrietts.people.api;

import static io.dropwizard.testing.FixtureHelpers.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Before;
import org.junit.Test;


public class PersonTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Before
    public void setUp() throws Exception {
        Person.resetCounter();
    }

    @Test
    public void serializesToJson() throws Exception {
        final Person person = new Person(1, "Jack", "jack@example.com");
        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(
                        fixture("fixtures/person.json"),
                        Person.class));

        assertThat(MAPPER.writeValueAsString(person)).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJson() throws Exception {
        Person expected = new Person(1, "Jack", "jack@example.com");
        Person received = MAPPER.readValue(fixture("fixtures/person.json"), Person.class);
        assertThat(received).isEqualToComparingFieldByField(expected);
    }
}

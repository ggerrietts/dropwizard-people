package com.github.ggerrietts.people.resources;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.ggerrietts.people.api.Person;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonResourceTest {
    private static final Person[] rawPersons = {new Person(1, "Jack", "jack@example.org")};
    private static final List<Person> cfg = new ArrayList<>(Arrays.asList(rawPersons));

    private final String expected = "[{\"id\":1,\"name\":\"Jack\",\"email\":\"jack@example.org\"}]";

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PersonResource(cfg))
            .build();

    @Before
    public void setUp() throws Exception {
        Person.resetCounter();
    }

    @Test
    public void testGetPeople() {
        assertThat(resources.target("/person").request().get(String.class)).isEqualTo(expected);
    }

}

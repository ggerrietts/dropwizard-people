package com.github.ggerrietts.people.config;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ggerrietts.people.api.Person;
import com.google.common.io.Resources;
import io.dropwizard.configuration.YamlConfigurationFactory;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.jersey.validation.Validators;
import org.junit.Before;
import org.junit.Test;

import javax.validation.Validator;
import java.io.File;

public class AppConfigTest {
    private final ObjectMapper objectMapper = Jackson.newObjectMapper();
    private final Validator validator = Validators.newValidator();
    private final YamlConfigurationFactory<AppConfig> factory =
            new YamlConfigurationFactory<>(AppConfig.class, validator, objectMapper, "dw");

    @Before
    public void setUp() throws Exception {
        Person.resetCounter();
    }

    @Test
    public void testAppConfigIsPeople() throws Exception {
        final File yml = new File(Resources.getResource("yaml/test-people.yml").toURI());
        final AppConfig ac = factory.build(yml);
        Person p = ac.getPeople().get(0);
        Person e = new Person(1, "Gwen", "gwen@example.org");
        assertThat(p).isEqualToComparingFieldByField(e);
    }
}
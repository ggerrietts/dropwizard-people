package com.github.ggerrietts.people.config;

import com.github.ggerrietts.people.health.PeopleHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.github.ggerrietts.people.resources.PersonResource;

public class AppService extends Application<AppConfig> {
    public static void main(String[] args) throws Exception{
        new AppService().run(args);
    }

    @Override
    public void run(AppConfig appConfig, Environment environment) throws Exception {
        final PersonResource res = new PersonResource(appConfig.getPeople());
        final PeopleHealthCheck hc = new PeopleHealthCheck(appConfig.getPeople());

        environment.healthChecks().register("people", hc);
        environment.jersey().register(res);
    }

    @Override
    public String getName() {
        return "dropwizard-people";
    }

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap) {

    }
}

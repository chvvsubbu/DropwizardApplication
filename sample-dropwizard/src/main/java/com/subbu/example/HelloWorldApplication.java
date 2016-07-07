package com.subbu.example;

import javax.ws.rs.client.Client;

import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.subbu.resources.FriendsResource;
import com.subbu.resources.HelloWorldResource;
import com.subbu.resources.RestResource;
import com.subbu.dataresource.UserResource;
import com.subbu.healthcheck.TemplateHealthCheck;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
   
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
    	final HelloWorldResource resource = new HelloWorldResource(
    	        configuration.getTemplate(),
    	        configuration.getDefaultName()
    	    );
    	final FriendsResource resource2 = new FriendsResource(
    	        configuration.getTemplate(),
    	        configuration.getDefaultName(), new UserResource()
    	    );
    	
    	final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration())
                .build("subbu");

    	
    	final TemplateHealthCheck healthCheck =
    	        new TemplateHealthCheck(configuration.getTemplate());
    	    environment.healthChecks().register("template", healthCheck);
    	    environment.jersey().register(resource);
    	    environment.jersey().register(resource2);
    	    
    }

}
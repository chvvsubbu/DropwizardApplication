package com.subbu.healthcheck;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {
    private final String template;
    public static String saying = "UP";

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        //final String saying = String.format(template, "TEST");
        
        if (!saying.equalsIgnoreCase("UP")) {
            //return Result.unhealthy("template doesn't include a name");
            return Result.unhealthy("System down");
        }
        
        return Result.healthy();
    }
}
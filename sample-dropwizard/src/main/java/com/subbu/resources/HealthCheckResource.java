package com.subbu.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.codahale.metrics.annotation.Timed;
import com.subbu.healthcheck.TemplateHealthCheck;

@Path("/api")
public class HealthCheckResource {
	
	@GET
    @Timed
    @Path("/down")
    public String down() {
		TemplateHealthCheck.saying = "DOWN";
        return TemplateHealthCheck.saying;
    }
	
	@GET
    @Timed
    @Path("/up")
    public String up() {
		TemplateHealthCheck.saying = "UP";
        return TemplateHealthCheck.saying;
    }
}

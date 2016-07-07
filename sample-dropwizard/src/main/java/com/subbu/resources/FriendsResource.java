package com.subbu.resources;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.subbu.api.College;
import com.subbu.api.Saying;
import com.subbu.api.User;
import com.subbu.api.UserPersonalInfo;
import com.subbu.dataresource.UserResource;

@Path("/fb")
@Produces(MediaType.APPLICATION_JSON)
public class FriendsResource {

	private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    private UserResource userResource;

    public FriendsResource(String template, String defaultName, UserResource userResource) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
        this.userResource = userResource;
    }
	 @POST
	 @Timed
	 public Response sayHello(@QueryParam("name") String name, @QueryParam("age")Integer age ) {
	      User user = new User(name, age);
	      userResource.createProfile(user);
	      return Response.ok().build();
	 }
	 
	 @GET
	 @Timed
	 @Path("/{id}")
	 public Response GetUserProfile(@PathParam("id") String id) {
		  Long longId = new Long(id);
	      User user = userResource.getProfile(longId);
		  return Response.ok(user).build();
	 }
	 
	 
	 @POST
	 @Timed
	 @Path("/{id}/friendRequest/{friendId}")
	 public Response friendRequest(@PathParam("id") String id, @PathParam("friendId") String friendId) {
		 
		 return Response.ok().build();
		 //		 TODO
//	      User user = new User(name, age);
//	      userResource.createProfile(user);
	 }
	 
	 @POST
	 @Timed
	 @Path("/update/personalinfo/{id}")
	 public Response update(@PathParam("id") String id, UserPersonalInfo userProfileInfo) {


		 Long longId = new Long(id);
	      User user = userResource.getProfile(longId);
	      user.setAge(userProfileInfo.getAge());
	      user.setCurrentCity(userProfileInfo.getCurrentCity());
	      user.setMobileNumber(userProfileInfo.getMobileNumber());
	      user.setLangauges(userProfileInfo.getLangauges());
	      // FIXME Change All The Value.
	      try{
	      userResource.update(user);
	      }catch(Exception e) {
	    	  Response.serverError();
	      }
	      return Response.ok().build();
	 }
	 
	 @POST
	 @Timed
	 @Path("/update/colleges/{id}")
	 public void update(@PathParam("id") String id, List<College> colleges) {
//		 TODO
	 }
	 
}

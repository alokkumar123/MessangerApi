package org.alok.java.msg.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.alok.java.msg.model.Message;
import org.alok.java.msg.model.Profile;
import org.alok.java.msg.service.ProfileService;

@Path("/profiles") 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getAllProfiles(){
		 return profileService.getAllProfiles();
	}
	
	@POST
	public Profile addMessage(Profile profile){
		return profileService.addProfile(profile);
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getMessage(@PathParam("profileName") String profileName){
		return profileService.getPdofileName(profileName);
		
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateMessage(@PathParam("profileName") String profileName, Profile profile){
		profile.setProfileName(profileName);
		return profileService.updateProfileName(profile);
	}
	
	
	
	@DELETE
	@Path("/{profileName}")
	public void deleteMessage(@PathParam("profileName") String profileName){
		 profileService.removePfroflie(profileName);
		
	}
	
	
}

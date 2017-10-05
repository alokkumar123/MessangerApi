package org.alok.java.msg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.alok.java.msg.database.DataBaseClass;
import org.alok.java.msg.model.Profile;

public class ProfileService {

	private static Map<String,Profile> profiles = DataBaseClass.getProfiles();
	
	
	public ProfileService(){
		profiles.put("AlokP1", new Profile(1L,"Alok Profile","Alok","Kumar"));
	}

	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getPdofileName(String profileName){
		return profiles.get(profileName);

	}

	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}


	public Profile updateProfileName(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removePfroflie(String profileName){
		return profiles.remove(profileName);

	}
}

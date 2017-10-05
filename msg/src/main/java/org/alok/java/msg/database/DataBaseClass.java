package org.alok.java.msg.database;

import java.util.HashMap;
import java.util.Map;

import org.alok.java.msg.model.Comment;
import org.alok.java.msg.model.Message;
import org.alok.java.msg.model.Profile;

public class DataBaseClass {
	
	private static Map<Long, Message>  messages  = new HashMap<>();
	private static Map <String, Profile> profiles = new HashMap<>();
	private static Map<Long,Comment > comments = new HashMap<>();
	
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}

	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
	
	/*public static Map<Long, Comment> getComments(){
		return comments;
	}*/

}

package org.alok.java.msg.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DataBindingException;

import org.alok.java.msg.database.DataBaseClass;
import org.alok.java.msg.exception.DataNotFoundException;
import org.alok.java.msg.model.Message;

public class MessageSerivce {

	private static Map<Long,Message> messages = DataBaseClass.getMessages();


	public MessageSerivce(){
		messages.put(1L, new Message(1, "Hello World!", "Alok"));
		messages.put(2L, new Message(2, "Hello India!", "Kumar"));
		messages.put(3L, new Message(3, "Hello India!!!!", "Kumarrrrrrr"));
	}

	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}


	public List<Message> getAllMessagesForYear(int year){

		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message: messages.values()){
			if(cal.get(Calendar.YEAR)==year){
				messagesForYear.add(message);
			}
		}
		//System.out.println("messg: "+messagesForYear);
		return messagesForYear;
	}

	public List<Message> getAllMessagePaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start+size>list.size()) 
			return new ArrayList<Message>();
		return list.subList(start, start+size);
	}

	public Message getMessage(long id){
		Message message =messages.get(id);
		if(message == null){
			throw new DataNotFoundException("Message id "+ id + " not found");
		}else
			return message;
	}


	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}


	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;

	}


	public Message removeMessage(long id){
		return messages.remove(id);
	}

	/*public List<Message> gelAllMessages(){

		Message m1= new Message(1L, "Hello World!", "Alok");
		Message m2= new Message(2L, "Hello India!", "kumar");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;

	}*/
}

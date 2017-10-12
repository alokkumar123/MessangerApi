package org.alok.java.msg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.alok.java.msg.database.DataBaseClass;
import org.alok.java.msg.model.Comment;
import org.alok.java.msg.model.ErrorMessage;
import org.alok.java.msg.model.Message;

public class CommentService {

	private Map<Long,Message> messages  = DataBaseClass.getMessages();

	/*public CommentService(){
		messages.put(1L,new Message(1,"Comment1","Alok C"));
		messages.put(1L,new Message(2,"Comment2","Kumar C"));
	}*/

	public List<Comment> getAllComments(long messagId){
		Map<Long ,Comment> comments = messages.get(messagId).getComments();
		return new ArrayList<Comment>(comments.values());
	}

	public Comment getComment(long messageId,long commentId){
		
		ErrorMessage errorMessage = new ErrorMessage("Not found Comments", 404, "check my link this");
		 Response response = Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
		
		Message message = messages.get(messageId);

		if(message ==null){
			throw new NotFoundException(response);	
		}

		Map<Long, Comment> comments = messages.get(messageId).getComments();

		Comment comment = comments.get(commentId);
		
		if(comment ==null){
			throw new NotFoundException(response);
		}
		
		return comments.get(commentId);
	}

	public Comment addComment(long messageId,Comment comment){
		Map<Long, Comment >comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(),comment);
		return comment;

	}

	public Comment updateComment(long messageId,Comment comment){
		Map<Long, Comment >comments = messages.get(messageId).getComments();
		if(comment.getId()<=0){
			return null;
		}
		comments.put(comment.getId(),comment);
		return comment;
	}


	public Comment removeComment(long messageId,long commentId){
		Map<Long, Comment >comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}



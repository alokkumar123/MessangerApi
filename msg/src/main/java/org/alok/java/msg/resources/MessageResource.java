package org.alok.java.msg.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.alok.java.msg.model.Message;
import org.alok.java.msg.resources.beans.MessageFilterBeans;
import org.alok.java.msg.service.MessageSerivce;

@Path("/messages") 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {


	MessageSerivce messageService = new MessageSerivce();

	@GET
	public List<Message> getMessage(@BeanParam MessageFilterBeans filterBeans){
		if(filterBeans.getYear()>0){
			return messageService.getAllMessagesForYear(filterBeans.getYear());
		}
		if(filterBeans.getStart()>0&& filterBeans.getSize()>0){
			return messageService.getAllMessagePaginated(filterBeans.getStart(), filterBeans.getSize());
		}
		return messageService.getAllMessages();

	}


	@POST
	public Response addMessage(Message message){
		messageService.addMessage(message);
		Response.status(Status.CREATED).entity(message).build();
		
		optimizer for eclipse
		//return messageService.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message){
		message.setId(messageId);
		return messageService.updateMessage(message);
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId){
		return messageService.getMessage(messageId);

	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long messageId){
		messageService.removeMessage(messageId);

	}

	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
}
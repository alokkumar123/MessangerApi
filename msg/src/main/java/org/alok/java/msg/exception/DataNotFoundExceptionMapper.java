package org.alok.java.msg.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.alok.java.msg.model.ErrorMessage;

@Provider // Provider Annotation register this class in JAX-RS
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 404, "check my link");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}

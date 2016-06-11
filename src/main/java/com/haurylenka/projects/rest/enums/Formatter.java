package com.haurylenka.projects.rest.enums;

import java.util.List;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haurylenka.projects.rest.beans.Customer;
import com.haurylenka.projects.rest.exceptions.FormatterException;

public enum Formatter {

	JSON {
		@Override
		public ResponseBuilder format(Object obj) throws FormatterException {
			try {
				ObjectMapper mapper = new ObjectMapper();
				mapper.setSerializationInclusion(Include.NON_NULL);
				String output = mapper.writerWithDefaultPrettyPrinter()
						.writeValueAsString(obj);
				return Response.ok(output, "application/json");
			} catch (JsonProcessingException e) {
				throw new FormatterException("Json formatting exception", e);
			}
		}
	}, 
	
	XML {
		@Override
		public ResponseBuilder format(Object obj) throws FormatterException {
			if (obj instanceof List<?>) {
				List<Customer> customers = (List<Customer>) obj;
				GenericEntity<List<Customer>> entity = 
						new GenericEntity<List<Customer>>(customers) {};
				return Response.ok(entity, "application/xml");
			}
			return Response.ok(obj, "application/xml");
		}
	};
	
	public abstract ResponseBuilder format(Object obj) throws FormatterException;
	
}

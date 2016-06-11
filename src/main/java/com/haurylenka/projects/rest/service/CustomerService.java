package com.haurylenka.projects.rest.service;

import javax.servlet.ServletContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.haurylenka.projects.rest.beans.Customer;
import com.haurylenka.projects.rest.enums.Formatter;
import com.haurylenka.projects.rest.exceptions.CustomerDAOException;
import com.haurylenka.projects.rest.exceptions.FormatterException;
import com.haurylenka.projects.rest.exceptions.RequestProcessException;
import com.haurylenka.projects.rest.exceptions.RestImplLoadException;
import com.haurylenka.projects.rest.interfaces.CustomerDAO;

@Path("/customer")
public class CustomerService {
	
	@Context
	private ServletContext servletContext;;

	@GET
	@Path("/{format}/{code}")
	public Response getCustomers(@PathParam("format") String format, 
			@PathParam("code") String code) {
		Command command = new GetCustomers(code);
		return processRequest(format, command);
	}

	@GET
	@Path("/{format}/{code}/{id : \\d+}")
	public Response getCustomer(@PathParam("format") String format, 
			@PathParam("code") String code, @PathParam("id") int id) {
		Command command = new GetCustomer(code, id);
		return processRequest(format, command);
	}
	
	@POST
	@Path("/{format}/{code}/{email : (.+)?}/{phone : (.+)?}")
	public Response addCustomer(@PathParam("format") String format, 
			@PathParam("code") String code, @PathParam("email") String email, 
			@PathParam("phone") String phone) {
		Command command = new AddCustomer(code, email, phone);
		return processRequest(format, command);
	}
	
	@PUT
	@Path("/{format}/{code}/{id : \\d+}/{email : (.+)?}/{phone : (.+)?}")
	public Response updateCustomer(@PathParam("format") String format, 
			@PathParam("code") String code, @PathParam("id") int id, 
			@PathParam("email") String email, @PathParam("phone") String phone) {
		Command command = new UpdateCustomer(code, id, email, phone);
		return processRequest(format, command);
	}
	
	@DELETE
	@Path("/{format}/{code}/{id : \\d+}")
	public Response deleteCustomer(@PathParam("format") String format,
			@PathParam("code") String code, @PathParam("id") int id) {
		Command command = new DeleteCustomer(code, id);
		return processRequest(format, command);
	}
	
	private Response processRequest(String format, Command command) {
		try {
			Formatter formatter = Formatter.valueOf(format.toUpperCase());
			CustomerDAO custDAO = getCustomerDAOImpl();
			Object output = command.doProcessRequest(custDAO);
			ResponseBuilder response = formatter.format(output);
			return response.build();
		} catch (RestImplLoadException 
				| FormatterException 
				| RequestProcessException e) {
			return Response.status(
					Response.Status.INTERNAL_SERVER_ERROR).build();
		} catch (IllegalArgumentException e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	private CustomerDAO getCustomerDAOImpl() throws RestImplLoadException {
		try {
			String customerDAOImplName = 
					servletContext.getInitParameter("customerDAOImpl");
			Class<?> clazz = Class.forName(customerDAOImplName);
			return (CustomerDAO) clazz.newInstance();
		} catch (ClassNotFoundException 
				| InstantiationException 
				| IllegalAccessException e) {
			throw new RestImplLoadException(
					"Unable to obtain a CustomerDAO implementation", e);
		}
	}
	
	private interface Command {
		Object doProcessRequest(CustomerDAO custDAO) 
				throws RequestProcessException;
	}
	
	private static class GetCustomers implements Command {
		private String code;
		
		public GetCustomers(String code) {
			this.code = code;
		}

		@Override
		public Object doProcessRequest(CustomerDAO custDAO) 
				throws RequestProcessException {
			try {
				return custDAO.getCustomers(code);
			} catch (CustomerDAOException e) {
				throw new RequestProcessException(
						"Unable to process the get customers request", e);
			}
		}
	}
	
	private static class GetCustomer implements Command {
		private String code;
		private int id;
		
		public GetCustomer(String code, int id) {
			this.code = code;
			this.id = id;
		}

		@Override
		public Object doProcessRequest(CustomerDAO custDAO) 
				throws RequestProcessException {
			try {
				return custDAO.getCustomer(code, id);
			} catch (CustomerDAOException e) {
				throw new RequestProcessException(
						"Unable to process the get customer request", e);
			}
		}
	}
	
	private static class AddCustomer implements Command {
		private String code;
		private String email;
		private String phone;

		public AddCustomer(String code, String email, String phone) {
			this.code = code;
			this.email = email;
			this.phone = phone;
		}

		@Override
		public Object doProcessRequest(CustomerDAO custDAO) 
				throws RequestProcessException {
			try {
				Customer customer = new Customer();
				customer.setEmail(email);
				customer.setPhone(phone);
				return custDAO.addCustomer(code, customer);
			} catch (CustomerDAOException e) {
				throw new RequestProcessException(
						"Unable to process the add customer request", e);
			}
		}
	}
	
	private static class UpdateCustomer implements Command {
		private String code;
		private int id;
		private String email;
		private String phone;

		public UpdateCustomer(String code, int id, String email, 
							String phone) {
			this.code = code;
			this.id = id;
			this.email = email;
			this.phone = phone;
		}

		@Override
		public Object doProcessRequest(CustomerDAO custDAO) 
				throws RequestProcessException {
			try {
				Customer customer = new Customer();
				customer.setId(id);
				customer.setEmail(email);
				customer.setPhone(phone);
				return custDAO.updateCustomer(code, customer);
			} catch (CustomerDAOException e) {
				throw new RequestProcessException(
						"Unable to process the update customer request", e);
			}
		}
	}
	
	private static class DeleteCustomer implements Command {
		private String code;
		private int id;

		public DeleteCustomer(String code, int id) {
			this.code = code;
			this.id = id;
		}

		@Override
		public Object doProcessRequest(CustomerDAO custDAO) 
				throws RequestProcessException {
			try {
				return custDAO.deleteCustomer(code, id);
			} catch (CustomerDAOException e) {
				throw new RequestProcessException(
						"Unable to process the update customer request", e);
			}
		}
	}
	
}

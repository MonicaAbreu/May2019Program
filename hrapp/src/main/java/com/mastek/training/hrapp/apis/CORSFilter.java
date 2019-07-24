package com.mastek.training.hrapp.apis;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

//filter is used to set all CORS Policy rules for each response
public class CORSFilter implements ContainerResponseFilter {

	@Override
	//will be called for request from external source
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		
		MultivaluedMap<String, Object> headers = responseContext.getHeaders();
		
		//add all access control headers for each request
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Controll-Allow-Methods", "GET POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type");
	}

}

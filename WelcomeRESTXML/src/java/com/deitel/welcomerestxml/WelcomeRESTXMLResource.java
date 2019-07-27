/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deitel.welcomerestxml;

import java.io.StringWriter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXB;

/**
 * REST Web Service
 *
 * @author SERKANNAS
 */
@Path("welcome")
public class WelcomeRESTXMLResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WelcomeRESTXMLResource
     */
    public WelcomeRESTXMLResource() {
    }

    /**
     * Retrieves representation of an instance of com.deitel.welcomerestxml.WelcomeRESTXMLResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path( "{name}" ) 
    @Produces(MediaType.APPLICATION_XML)
    public String getXml( @PathParam( "name" ) String name ) {
        String message = "Welcome to JAX-RS web services with REST and " +
                "XML, " + name + "!"; // our welcome message
        StringWriter writer = new StringWriter();
        JAXB.marshal( message, writer ); // marshal String as XML
        return writer.toString(); // return XML as String
    }

    /**
     * PUT method for updating or creating an instance of WelcomeRESTXMLResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}

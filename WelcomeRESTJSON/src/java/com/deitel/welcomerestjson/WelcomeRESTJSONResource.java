/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deitel.welcomerestjson;

import com.google.gson.Gson; // converts POJO to JSON and back again
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author SERKANNAS
 */
@Path("welcome")
public class WelcomeRESTJSONResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WelcomeRESTJSONResource
     */
    public WelcomeRESTJSONResource() {
    }

    /**
     * Retrieves representation of an instance of com.deitel.welcomerestjson.WelcomeRESTJSONResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path( "{name}" ) // takes name as a path parameter
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson( @PathParam( "name" ) String name ) {
        TextMessage message = new TextMessage(); // create wrapper object
      message.setMessage( String.format( "%s, %s!",
         "Welcome to JAX-RS web services with REST and JSON", name ) );

      return new Gson().toJson( message ); // return JSON-wrapped message
    }
    
    class TextMessage {
        private String message; // message we're sending

        // returns the message
        public String getMessage() {
           return message;
        } // end method getMessage

        // sets the message
        public void setMessage( String value ) {
           message = value;
        } // end method setMessage
    } // end class TextMessage   

    /**
     * PUT method for updating or creating an instance of WelcomeRESTJSONResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}

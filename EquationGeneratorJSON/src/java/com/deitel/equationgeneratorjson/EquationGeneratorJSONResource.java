/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deitel.equationgeneratorjson;

import com.google.gson.Gson; // converts POJO to JSON and back again
import java.util.Random;
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
@Path("equation")
public class EquationGeneratorJSONResource {

    static Random randomObject = new Random(); // random number generator

    /**
     * Creates a new instance of EquationGeneratorJSONResource
     */
    public EquationGeneratorJSONResource() {
    }

    /**
     * Retrieves representation of an instance of com.deitel.equationgeneratorjson.EquationGeneratorJSONResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path( "{operation}/{level}" )
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson( @PathParam( "operation" ) String operation,
      @PathParam( "level" ) int level ) {
        // compute minimum and maximum values for the numbers
        int minimum = ( int ) Math.pow( 10, level - 1 );
        int maximum = ( int ) Math.pow( 10, level );

        // create the numbers on the left-hand side of the equation
        int first = randomObject.nextInt( maximum - minimum ) + minimum;
        int second = randomObject.nextInt( maximum - minimum ) + minimum;

        // create Equation object and return result
        Equation equation = new Equation( first, second, operation );
        return new Gson().toJson( equation ); // convert to JSON and return
    }

    /**
     * PUT method for updating or creating an instance of EquationGeneratorJSONResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}

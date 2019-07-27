/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deitel.equationgeneratorxml;

import java.io.StringWriter;
import java.util.Random;
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
@Path( "equation" )
public class EquationGeneratorXMLResource {

    private static Random randomObject = new Random();
    /**
     * Creates a new instance of EquationGeneratorXMLResource
     */
    public EquationGeneratorXMLResource() {
    }

    /**
     * Retrieves representation of an instance of com.deitel.equationgeneratorxml.EquationGeneratorXMLResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path( "{operation}/{level}" )
    @Produces(MediaType.APPLICATION_XML)
    public String getXml( @PathParam( "operation" ) String operation,
      @PathParam( "level" ) int level ) {
        // compute minimum and maximum values for the numbers
        int minimum = ( int ) Math.pow( 10, level - 1 );
        int maximum = ( int ) Math.pow( 10, level );

        // create the numbers on the left-hand side of the equation
        int first = randomObject.nextInt( maximum - minimum ) + minimum;
        int second = randomObject.nextInt( maximum - minimum ) + minimum;

        // create Equation object and marshal it into XML
        Equation equation = new Equation( first, second, operation );
        StringWriter writer = new StringWriter(); // XML output here
        JAXB.marshal( equation, writer ); // write Equation to StringWriter
        return writer.toString(); // return XML string
    }

    /**
     * PUT method for updating or creating an instance of EquationGeneratorXMLResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}

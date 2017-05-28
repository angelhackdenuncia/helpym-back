/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpym.services;

import com.helpym.entities.Denuncia;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author ecarrillo
 */
@Path("denuncias")
public class DenunciaService {

    public DenunciaService() {
    }
        

    @Path("put")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putDenuncia(Denuncia in){
        
        Denuncia denuncia= new Denuncia();
        in.setDescripcion("test");
        return Response.ok().entity(in).build();
    }
     

    @Path("post")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postDenuncia(Denuncia in){
        
        Denuncia denuncia= new Denuncia();
        in.setDescripcion("test");
        return Response.ok().entity(in).build();
    }    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Denuncia getDenuncia(){
        Denuncia test= new Denuncia();
        test.setDescripcion("Prueba");
        return test;
    }
    
     
}

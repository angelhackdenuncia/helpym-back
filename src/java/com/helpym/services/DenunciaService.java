/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpym.services;

import ai.api.model.AIResponse;
import com.helpym.ai.AiQuery;
import com.helpym.dao.DenunciaDao;
import com.helpym.dao.RecomendacionDao;
import com.helpym.entities.Denuncia;
import com.helpym.entities.Recomendacion;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
        
        Recomendacion recomendacionRespose = new Recomendacion();
        
        AiQuery test= new AiQuery();
        AIResponse respuesta = test.getRecomendacion(in.getDescripcion());
        recomendacionRespose.setRecomendacion(respuesta.getResult().getFulfillment().getSpeech());                
        DenunciaDao dao = new DenunciaDao();
        
        in.setTipDenuncia(respuesta.getResult().getMetadata().getIntentName());
        if (respuesta.getResult().getParameters().get("tipo_agresion")!=null){
            in.setTipDAgresion(respuesta.getResult().getParameters().get("tipo_agresion").getAsString());
        }
        
        
        int idDenuncia = dao.insertDenuncia(in);         
        
        RecomendacionDao recDao= new RecomendacionDao();
        int idRecomendacion=recDao.insertRecomendacionLogAI(idDenuncia, recomendacionRespose.getRecomendacion());                 
        recomendacionRespose.setIdRecomendacion(idRecomendacion);        
        return Response.ok().entity(recomendacionRespose).build();
    }
     

    @Path("post")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postDenuncia(Denuncia in){
        
       return this.putDenuncia(in);
    }    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Denuncia getDenuncia(){
        Denuncia test= new Denuncia();
        test.setDescripcion("Prueba");
        test.setLatitud(1.0);
        test.setLongitud(2.0);
        return test;
    }
    
     
}

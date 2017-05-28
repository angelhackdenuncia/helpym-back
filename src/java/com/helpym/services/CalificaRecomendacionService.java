/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpym.services;

import com.helpym.dao.RecomendacionDao;
import com.helpym.entities.CalificaRecomendacion;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ecarrillo
 */
@Path("calificaRecomendacion")
public class CalificaRecomendacionService {
    
    @Path("put")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putDenuncia(CalificaRecomendacion in){        
        RecomendacionDao recoDao = new RecomendacionDao();
        if(recoDao.updateRecomendacionLogAI(in)){
            //updateCalificacionMotorAI();
            return Response.ok().build();
        }else{
            return Response.serverError().build();
        }
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpym.ai;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.glassfish.jersey.client.internal.LocalizationMessages;

/**
 *
 * @author ecarrillo
 */
public class AiQuery {
   
    public AIResponse getRecomendacion(String descDenuncia){       
        try {
            AIConfiguration configuration = new AIConfiguration("276ce3e6ab3f426785678f8376bbf0ab");            
            AIDataService dataService = new AIDataService(configuration);                                                                       
            AIRequest request = new AIRequest(descDenuncia);            
            AIResponse response = dataService.request(request);            
            if (response.getStatus().getCode() == 200) {
                System.out.println(response.getResult().getFulfillment().getSpeech());
                return response;
            } else {
                System.err.println(response.getStatus().getErrorDetails());
            }
        } catch (AIServiceException ex) {
            Logger.getLogger(AiQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

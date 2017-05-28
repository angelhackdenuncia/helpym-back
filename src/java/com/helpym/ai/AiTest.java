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
public class AiTest {
   
    public String recomendacion(){
    
        try {
            AIConfiguration configuration = new AIConfiguration("276ce3e6ab3f426785678f8376bbf0ab");
            
            AIDataService dataService = new AIDataService(configuration);
            
            String line="He visto un maltrato familiar en la calle 100 con 7ma";
            
            
            
            
            AIRequest request = new AIRequest(line);
            
            AIResponse response = dataService.request(request);
            
            if (response.getStatus().getCode() == 200) {
                System.out.println(response.getResult().getFulfillment().getSpeech());
                return response.getResult().getFulfillment().getSpeech();
            } else {
                System.err.println(response.getStatus().getErrorDetails());
            }
            
                     
            System.out.println("See ya!");
        } catch (AIServiceException ex) {
            Logger.getLogger(AiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

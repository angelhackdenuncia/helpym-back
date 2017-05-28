/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpym.dao;

import com.helpym.entities.CalificaRecomendacion;
import com.helpym.util.DatasourseResolver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author ecarrillo
 */
public class RecomendacionDao {

    public int insertRecomendacionLogAI( int IdDenuncia,String recomen){
        Connection conn=null;
        int idRecomendacion=0;
        try {
            
            
            DataSource ds = DatasourseResolver.getDataSource();                      
            conn = ds.getConnection();
            
	    String query = "INSERT INTO helpym.Logs_Motor_AI (id_Denuncia, Respuesta_AI) VALUES (?, ?)";
            PreparedStatement pstm = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, IdDenuncia);
            pstm.setString(2,recomen);           
            
            pstm.executeUpdate();
            ResultSet rs= pstm.getGeneratedKeys();
            // Store and return result of the query
            if (rs.next()) {
                System.out.println("Id Log Recomendaciones: "+rs.getInt(1));
                idRecomendacion =rs.getInt(1);
            }
        } catch (SQLException e) {
                System.err.println(e.getMessage());
        } finally {
                // Release connection back to the pool
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DenunciaDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                conn = null; // prevent any future access
        }
        
        return idRecomendacion;
    }
    
    public boolean updateRecomendacionLogAI( CalificaRecomendacion calificacion){
        
        boolean updateOK = false;
        Connection conn=null;
        int idRecomendacion=0;
        try {
            
            
            DataSource ds = DatasourseResolver.getDataSource();                      
            conn = ds.getConnection();
            
	    String query = "INSERT INTO helpym.Logs_Motor_AI (id_Denuncia, Respuesta_AI) VALUES (?, ?)";
            PreparedStatement pstm = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            //pstm.setInt(1, IdDenuncia);
            //pstm.setString(2,recomen);           
            
            pstm.executeUpdate();
            ResultSet rs= pstm.getGeneratedKeys();
            // Store and return result of the query
            if (rs.next()) {
                System.out.println("Id Log Recomendaciones: "+rs.getInt(1));
                idRecomendacion =rs.getInt(1);
            }
        } catch (SQLException e) {
                System.err.println(e.getMessage());
        } finally {
                // Release connection back to the pool
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DenunciaDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                conn = null; // prevent any future access
        }
        
        return updateOK;
    }
    
}

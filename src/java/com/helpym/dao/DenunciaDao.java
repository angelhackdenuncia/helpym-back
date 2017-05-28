/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpym.dao;

import com.helpym.entities.Denuncia;
import com.helpym.util.DatasourseResolver;
import java.sql.Connection;
import java.sql.Date;

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
public class DenunciaDao {
    public int insertDenuncia(Denuncia denuncia){
        int denunciaId=0;
        Connection conn=null;
        try {
            
            
            DataSource ds = DatasourseResolver.getDataSource();            
            System.out.println("Datasource" + ds);            
            conn = ds.getConnection();
            
	    String query = "INSERT INTO helpym.Denuncias (Denuncia,Fecha_Denuncia) VALUES (?,?)";
            PreparedStatement pstm = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, denuncia.getDescripcion());
            pstm.setDate(2,new Date(new java.util.Date().getTime()) );
            pstm.executeUpdate();
            ResultSet rs= pstm.getGeneratedKeys();
            // Store and return result of the query
            if (rs.next()) {
                System.out.println("Id: "+rs.getInt(1));
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
        
        return denunciaId;
    }
}

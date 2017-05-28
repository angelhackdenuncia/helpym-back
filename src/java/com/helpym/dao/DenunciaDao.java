/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpym.dao;

import com.helpym.entities.Denuncia;
import com.helpym.util.DatasourseResolver;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;
import org.glassfish.jersey.internal.util.Base64;

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
            conn = ds.getConnection();
            
	    String query = "INSERT INTO helpym.Denuncias (Denuncia,Fecha_Denuncia, Latitud, Longitud, Direccion,Imagen) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, denuncia.getDescripcion());
            pstm.setDate(2,new Date(new java.util.Date().getTime()) );
            
            if(denuncia.getLatitud()!=null){
                pstm.setDouble(3, denuncia.getLatitud());
            }else{
                pstm.setNull(3,Types.DOUBLE);
            }
            
            if(denuncia.getLongitud()!=null){
                pstm.setDouble(4, denuncia.getLongitud());
            }else{
                pstm.setNull(4,Types.DOUBLE);
            }

            if(denuncia.getDireccion()!=null){
                pstm.setString(5, denuncia.getDireccion());
            }else{
                pstm.setNull(5,Types.VARCHAR);
            }   
            
            if(denuncia.getImagen()!=null){
                byte[] base64decodedBytes = Base64.decode(denuncia.getImagen().getBytes());
                InputStream input = new ByteArrayInputStream(base64decodedBytes);
                pstm.setBinaryStream(6, input, (int) base64decodedBytes.length);
            }else{
                pstm.setNull(6,Types.BLOB);
            }             
            
            pstm.executeUpdate();
            ResultSet rs= pstm.getGeneratedKeys();
            // Store and return result of the query
            if (rs.next()) {
                System.out.println("Id: "+rs.getInt(1));
                denunciaId = rs.getInt(1);
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

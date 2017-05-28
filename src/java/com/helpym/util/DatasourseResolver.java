/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpym.util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ecarrillo
 */
public  class DatasourseResolver {
    private static DataSource datasource;

    private DatasourseResolver() {
    }
    
    public static DataSource getDataSource(){
    if(datasource==null){
        try {
            /**
             * Get initial context that has references to all configurations and
             * resources defined for this web application.
             */
            Context initialContext = new InitialContext();
            
            /**
             * Get Context object for all environment naming (JNDI), such as
             * Resources configured for this web application.
             */
            Context environmentContext = (Context) initialContext
                    .lookup("java:comp/env");
            /**
             * Name of the Resource we want to access.
             */
            String dataResourceName = "jdbc/helpym";
            /**
             * Get the data source for the MySQL to request a connection.
             */
             datasource = (DataSource) environmentContext        
                    .lookup(dataResourceName);
        } catch (NamingException ex) {
            Logger.getLogger(DatasourseResolver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return datasource;
    }
    
}

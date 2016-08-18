/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.zoig.services;

import com.dev.zoig.beans.TransactionBean;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONArray;

/**
 *
 * @author user
 */
public interface TransactionsService {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public TransactionBean getTransactionById(Long transaction_id);   
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public JSONArray getTransactionsByType(String type);
    
    @GET
    @Produces({MediaType.APPLICATION_JSON}) 
    public String getSumByParentId(Long transaction_id);
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response putTransactionInArray(Long transaction_id,TransactionBean transaction);
    
    
}

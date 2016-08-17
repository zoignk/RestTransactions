/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.zoig.services;

import com.dev.zoig.beans.TransactionBean;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    public List<Long> getTransactionsByType(String type);
    
    @GET
    @Produces({MediaType.APPLICATION_JSON}) 
    public Double getSumByParentId(Long transaction_id);
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public void putTransactionInArray(TransactionBean transaction);
    
    
}

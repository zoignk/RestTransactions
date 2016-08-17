/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.zoig.services;

import com.dev.zoig.beans.TransactionBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author user
 */
@Path("/transactionservice")
public class TransactionServiceImpl implements TransactionsService{

    Map<Long,TransactionBean> transactionMap = new HashMap<>();
    
        public Map<Long, TransactionBean> getTransactionList() {
        return transactionMap;
    }
    
    @Override
    @GET
    @Path("transaction/{transaction_id}")
    @Produces({MediaType.APPLICATION_JSON}) 
    public TransactionBean getTransactionById(@PathParam("transaction_id")Long transaction_id) {
        transactionMap.put(1l, new TransactionBean(54.56, "Type1", 1l));
        return transactionMap.get(transaction_id);
    }

    @Override
    @GET
    @Path("types/{type}")
    @Produces({MediaType.APPLICATION_JSON}) 
    public List<Long> getTransactionsByType(@PathParam("type")String type) {
        List<Long> listResult = new ArrayList<>();
        for (Long key : transactionMap.keySet()) {
            if(transactionMap.get(key).getType().equalsIgnoreCase(type))
                listResult.add(key);
        }
        return listResult;
    }

    @Override
    @GET
    @Path("sum/{transaction_id}")
    @Produces({MediaType.APPLICATION_JSON}) 
    public Double getSumByParentId(@PathParam("transaction_id")Long transaction_id) {
        Double sum = 0.0;
        for (Long key : transactionMap.keySet()) {
            if(transactionMap.get(key).getParent_id() == transaction_id)
                sum += transactionMap.get(key).getAmount();
        }
        return sum;
    }
            


    @Override
    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON}) 
    @Produces({MediaType.APPLICATION_JSON}) 
    public void putTransactionInArray( TransactionBean transaction) {
        transactionMap.put(2l, transaction);
    }
    
    
}

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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONArray;

/**
 *
 * @author user
 */
@Path("/transactionservice")
public class TransactionServiceImpl implements TransactionsService{

    public static final Map<Long,TransactionBean> transactionMap = new HashMap<>();
    
    /**
     *
     * Returns transaction for specified transaction_id in JSON format.
     * 
     * @param transaction_id
     * @return
     */
    @Override
    @GET
    @Path("transaction/{transaction_id}")
    @Produces({MediaType.APPLICATION_JSON}) 
    public TransactionBean getTransactionById(@PathParam("transaction_id")Long transaction_id) {
        
        return transactionMap.get(transaction_id);
    }

    /**
     *
     * Returns every transaction of specified type. Using JSONArray to show how
     * to convert any Collection to JSON format.
     * 
     * @param type
     * @return
     */
    @Override
    @GET
    @Path("types/{type}")
    @Produces({MediaType.APPLICATION_JSON}) 
    public JSONArray getTransactionsByType(@PathParam("type")String type) {

        List<Long> listResult = new ArrayList<>();
        for (Long key : transactionMap.keySet()) {
            if(transactionMap.get(key).getType().equalsIgnoreCase(type))
                listResult.add(key);
        }
        
        JSONArray arrayResult = new JSONArray(listResult);
        return arrayResult;
    }

    /**
     *
     * Finds every transaction with specified parent_id and calculates sum for
     * amounts.
     * 
     * @param transaction_id
     * @return
     */
    @Override
    @GET
    @Path("sum/{transaction_id}")
    @Produces({MediaType.APPLICATION_JSON}) 
    public String getSumByParentId(@PathParam("transaction_id")Long transaction_id) {
        transactionMap.put(1l, new TransactionBean(54.56, "Type1", 1l));
        transactionMap.put(2l, new TransactionBean(54.56, "Type1", 1l));
        Double sum = 0.0;
        for (Long key : transactionMap.keySet()) {
            if(transactionMap.get(key).getParent_id().equals(transaction_id))
                sum += transactionMap.get(key).getAmount();
        }
        return"{\"sum\":"+sum+"}";
    }
            
    /**
     *
     * Adding new transaction to map.
     * 
     * 
     * @param transaction_id
     * @param transaction
     * @return
     */
    @Override
    @PUT
    @Path("/add/{transaction_id}")
    @Consumes({MediaType.APPLICATION_JSON}) 
    @Produces({MediaType.APPLICATION_JSON}) 
    public Response putTransactionInArray(@PathParam("transaction_id")Long transaction_id, TransactionBean transaction) {
        //TODO: Check for duplicate keys
        transactionMap.put(transaction_id, transaction); 
        return Response.status(200).type(MediaType.APPLICATION_JSON).build();
    }
    
    public static void initMap() {
        
        TransactionBean firstTransaction = new TransactionBean(150.50, "insurance", 1L);
        TransactionServiceImpl.transactionMap.put(1L, firstTransaction);
        TransactionBean secondTransaction = new TransactionBean(20.00, "insurance", 1L);
        TransactionServiceImpl.transactionMap.put(2L, secondTransaction);
        TransactionBean thirdTransaction = new TransactionBean(1000.25, "car", 1L);
        TransactionServiceImpl.transactionMap.put(3L, thirdTransaction);
        TransactionBean fourthTransaction = new TransactionBean(122.32, "car", 1L);
        TransactionServiceImpl.transactionMap.put(4L, fourthTransaction);
    }
    
    
}

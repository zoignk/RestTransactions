/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.zoig.beans;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@XmlRootElement
public class TransactionBean {

    Double amount;
    String type;
    Long parent_id;
    
    public TransactionBean() {
        
    }

    public TransactionBean(Double amount, String type, Long parent_id) {

        this.amount = amount;
        this.type = type;
        this.parent_id = parent_id;
    }
    
    



    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }
    
    
}

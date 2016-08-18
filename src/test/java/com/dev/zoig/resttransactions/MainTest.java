
package com.dev.zoig.resttransactions;

import com.dev.zoig.beans.TransactionBean;
import com.dev.zoig.services.TransactionServiceImpl;
import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.core.header.MediaTypes;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.Response;
import junit.framework.TestCase;


public class MainTest extends TestCase {

    private HttpServer httpServer;
    
    private WebResource r;

    public MainTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        TransactionServiceImpl.initMap();
        
        //start the Grizzly2 web container 
        httpServer = Main.startServer();

        // create the client
        Client c = Client.create();
        r = c.resource(Main.BASE_URI);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

        httpServer.stop();
    }

    
     /**
     * Test to see that transactionMap contains transaction with transaction_id = 1
     */
    public void testGetById() {
        TransactionBean responseTransaction = r.path("transactionservice/transaction/1").get(TransactionBean.class);
        assertTrue(TransactionServiceImpl.transactionMap.containsValue(responseTransaction));
    }
    

}

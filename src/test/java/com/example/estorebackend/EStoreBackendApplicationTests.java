package com.example.estorebackend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class EStoreBackendApplicationTests {

    @LocalServerPort
    private int port;
	
    @Autowired
    private TestRestTemplate restTemplate;
	
	@DisplayName("Test1 - Fetch Admin Accounts")
    @Test
    void testAdminAccounts() throws Exception {
	    Map response = restTemplate.getForObject(new URL("http://localhost:"+port+"/adminauth/get").toString(), Map.class);
	    System.out.println("RESPONSE 1: "+response);
	    assertEquals(true, response.get("message").toString().contains("Admins Fetched Successfully"));
    }
	
	@DisplayName("Test2 - Fetch User Accounts")
    @Test
    void testUserAccounts() throws Exception {
	    Map response = restTemplate.getForObject(new URL("http://localhost:"+port+"/users/get").toString(), Map.class);
	    System.out.println("RESPONSE 2: "+response);
	    assertEquals(true, response.get("message").toString().contains("Users Fetched Successfully"));
    }
	
	@DisplayName("Test3 - Fetch Orders")
    @Test
    void testOrders() throws Exception {
	    Map response = restTemplate.getForObject(new URL("http://localhost:"+port+"/orders/get").toString(), Map.class);
	    System.out.println("RESPONSE 3: "+response);
	    assertEquals(true, response.get("message").toString().contains("Orders Fetched Successfully"));
    }
	
	@DisplayName("Test4 - Fetch Products")
    @Test
    void testProducts() throws Exception {
	    Map response = restTemplate.getForObject(new URL("http://localhost:"+port+"/products/get").toString(), Map.class);
	    System.out.println("RESPONSE 4: "+response);
	    assertEquals(true, response.get("message").toString().contains("Products Fetched Successfully"));
    }

}

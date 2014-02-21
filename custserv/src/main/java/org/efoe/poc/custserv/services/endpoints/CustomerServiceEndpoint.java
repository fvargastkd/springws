/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.efoe.poc.custserv.services.endpoints;

import com.customer.service.CustomerRequestDocument;
import com.customer.service.CustomerRequestDocument.CustomerRequest;
import com.customer.service.CustomerResponseDocument;
import com.customer.service.CustomerResponseDocument.CustomerResponse;
import com.customer.service.CustomerResponseDocument.CustomerResponse.Address;
import org.efoe.poc.custserv.domain.Customer;
import org.efoe.poc.custserv.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


/**
 *
 * @author Emmanuel
 */
@Endpoint
public class CustomerServiceEndpoint {
    
    private static final String NAMESPACE_URI = "http://www.customer.com/service";
    private static final String LOCAL_PART = "CustomerRequest";
    
    @Autowired
    private CustomerService custService;
    
    public void setCustomerService(CustomerService service){
        this.custService = service;
    }
    
    @PayloadRoot(localPart=LOCAL_PART, namespace = NAMESPACE_URI)
    @ResponsePayload
    public CustomerResponseDocument getCustomer(CustomerRequestDocument reqDoc){
        CustomerResponseDocument respDoc = CustomerResponseDocument.Factory.newInstance();
        CustomerRequest req = reqDoc.getCustomerRequest();
        CustomerResponse resp = CustomerResponse.Factory.newInstance();
        String ssn = reqDoc.getCustomerRequest().getSsn();
        Customer cust = custService.getCustomer(ssn);
        resp.setFirstName(cust.getFirstName());
        resp.setLastName(cust.getLastName());
        resp.setSsn(cust.getSsn());
        Address a = Address.Factory.newInstance();
        a.setStreet(cust.getAddress().getStreet());
        a.setCity(cust.getAddress().getCity());
        a.setState(cust.getAddress().getState());
        resp.setAddress(a);
        
        respDoc.setCustomerResponse(resp);
        
        return respDoc;
    }
}

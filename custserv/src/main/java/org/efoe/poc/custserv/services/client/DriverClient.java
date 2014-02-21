/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.efoe.poc.custserv.services.client;


import com.customer.service.CustomerRequestDocument;
import com.customer.service.CustomerResponseDocument;
import org.efoe.poc.custserv.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 *
 * @author Emmanuel
 */
public class DriverClient {
    
    private static WebServiceTemplate template;
    
    public static void getCustomer(String ssn, WebServiceTemplate t){
        CustomerResponseDocument respDoc = null;
        CustomerRequestDocument reqDoc = CustomerRequestDocument.Factory.newInstance();
        CustomerRequestDocument.CustomerRequest req = CustomerRequestDocument.CustomerRequest.Factory.newInstance();
        req.setSsn(ssn);
        
        reqDoc.setCustomerRequest(req);
        respDoc = (CustomerResponseDocument)t.marshalSendAndReceive(reqDoc);
                /*.marshalSendAndReceive(quote,new WebServiceMessageCallback() {
             @Override
             public void doWithMessage(WebServiceMessage message) {
                 ((SoapMessage)message).setSoapAction("http://www.webserviceX.NET/GetQuote");
             }
         });*/
        //return resp.getGetQuoteResponse().getGetQuoteResult();
        System.out.println(respDoc.getCustomerResponse().getFirstName());
        System.out.println(respDoc.getCustomerResponse().getLastName());
        System.out.println(respDoc.getCustomerResponse().getSsn());
        System.out.println(respDoc.getCustomerResponse().getAddress().getStreet());
        System.out.println(respDoc.getCustomerResponse().getAddress().getCity());
        System.out.println(respDoc.getCustomerResponse().getAddress().getState());
        
    }
    
    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        
        //WebServiceClient client = new WebServiceClient();
        template = context.getBean(WebServiceTemplate.class);
        //System.out.println(client.getQuote("UNH"));
        getCustomer("111111111", template);
        
    }
}

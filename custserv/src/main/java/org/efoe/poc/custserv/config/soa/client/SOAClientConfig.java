/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.efoe.poc.custserv.config.soa.client;

import org.apache.ws.security.WSSConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.xmlbeans.XmlBeansMarshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

/**
 *
 * @author Emmanuel
 */
@Configuration
public class SOAClientConfig {
    
    private static final String ENDPOINT = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    
    @Bean(name="template")
    public WebServiceTemplate template(){
        WebServiceTemplate template = new WebServiceTemplate();
        template.setDefaultUri(ENDPOINT);
        template.setMarshaller(marshaller());
        template.setUnmarshaller(marshaller());
        template.setMessageSender(messageSender());
        template.setMessageFactory(messageFactory());
        ClientInterceptor[] interceptors = new ClientInterceptor[2];
        interceptors[0] = wss4jInterceptor();
        interceptors[1] = messageInterceptor();
        template.setInterceptors(interceptors);
        return template;
    }
    
    @Bean
    public XmlBeansMarshaller marshaller(){
        XmlBeansMarshaller marshaller = new XmlBeansMarshaller();
        return marshaller;
    }
    
    @Bean
    public HttpComponentsMessageSender messageSender(){
        HttpComponentsMessageSender ms = new HttpComponentsMessageSender();
        return ms;
    }
    
    @Bean
    public SaajSoapMessageFactory messageFactory(){
        SaajSoapMessageFactory mf = new SaajSoapMessageFactory();
        mf.setSoapVersion(SoapVersion.SOAP_12);
        return mf;
    }
    
    @Bean
    public Wss4jSecurityInterceptor wss4jInterceptor(){
        Wss4jSecurityInterceptor wss4j = new Wss4jSecurityInterceptor();
        wss4j.setSecurementActions("UsernameToken");
        wss4j.setValidateResponse(false);
        wss4j.setSecurementUsername(USERNAME);
        wss4j.setSecurementPassword(PASSWORD);
        wss4j.setSecurementPasswordType("PasswordText");
        wss4j.setSecurementUsernameTokenElements("Nonce Created");
        //wss4j.setValidationCallbackHandlers(null);
        return wss4j;
    }
    
    @Bean
    public SOAPMessageInterceptor messageInterceptor(){
        SOAPMessageInterceptor smi = new SOAPMessageInterceptor();
        return smi;
    }
}

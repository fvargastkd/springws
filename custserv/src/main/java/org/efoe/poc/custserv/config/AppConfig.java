/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.efoe.poc.custserv.config;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.xmlbeans.XmlBeansMarshaller;
import org.springframework.ws.client.support.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.server.endpoint.adapter.GenericMarshallingMethodEndpointAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;
import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j.callback.SimplePasswordValidationCallbackHandler;

/**
 *
 * @author Emmanuel
 */
@Configuration
@ImportResource("classpath:ws-servlet.xml")
public class AppConfig {

    /*
    @Bean(name = "marshallPayloadMethodProcessor")
    public GenericMarshallingMethodEndpointAdapter marshallPayloadMethodProcessor() {
        GenericMarshallingMethodEndpointAdapter gm = new GenericMarshallingMethodEndpointAdapter();
        gm.setMarshaller(marshaller());
        gm.setUnmarshaller(marshaller());
        return gm;
    }

    @Bean(name = "marshaller")
    public XmlBeansMarshaller marshaller() {
        return new XmlBeansMarshaller();
    }

    //@Bean
    public Wsdl11Definition custService() {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setLocationUri("/ws/services/custservice");
        definition.setTargetNamespace("http://www.customer.com/service");
        definition.setPortTypeName("CustomerService");
        definition.setSchemaCollection(schemaCollection());
        return definition;
    }

    //@Bean
    public Resource[] schemaResources() {
        return new ClassPathResource[]{new ClassPathResource("/schemas/Customer.xsd")};
    }

    //@Bean
    public XsdSchemaCollection schemaCollection() {
        CommonsXsdSchemaCollection collection = new CommonsXsdSchemaCollection();
        collection.setXsds(schemaResources());
        collection.setInline(true);
        return collection;
    }
    
    //@Bean
    public PayloadValidatingInterceptor validatingInterceptor(){
        PayloadValidatingInterceptor pvi = new PayloadValidatingInterceptor();
        pvi.setSchema(schemaResources()[0]);
        pvi.setValidateRequest(true);
        pvi.setValidateResponse(true);
        return pvi;
    }
    
    //@Bean
    public Wss4jSecurityInterceptor wss4jSecurityInterceptor() {
        Wss4jSecurityInterceptor wss4j = new Wss4jSecurityInterceptor();
        wss4j.setValidationActions("UsernameToken");
        wss4j.setSecurementActions("Timestamp UsernameToken");
        wss4j.setTimestampPrecisionInMilliseconds(true);
        wss4j.setSecurementUsername("mojo");
        wss4j.setSecurementPassword("mojopass");
        wss4j.setSecurementPasswordType("PasswordText");
        wss4j.setSecurementUsernameTokenElements("Nonce Created");
        wss4j.setValidationCallbackHandler(callbackHandler());
        return wss4j;
    }
    
    public SimplePasswordValidationCallbackHandler callbackHandler(){
        SimplePasswordValidationCallbackHandler cb = new SimplePasswordValidationCallbackHandler();
        Properties users = new Properties();
        users.setProperty("admin", "secret");
        users.setProperty("user", "pass");
        cb.setUsers(users);
        return cb;
    }
    */
}

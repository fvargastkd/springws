/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.efoe.poc.custserv.config.soa.client;

import org.efoe.poc.custserv.utils.LoggerUtil;
import org.efoe.poc.custserv.utils.XMLPrettyPrinter;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;

/**
 *
 * @author Emmanuel
 */
public class SOAPMessageInterceptor implements ClientInterceptor {

    @Override
    public boolean handleRequest(MessageContext mc) throws WebServiceClientException {
        LoggerUtil.logDebug(SOAPMessageInterceptor.class,"\n\n".concat(XMLPrettyPrinter.printSoapMessage(mc, mc.getRequest())));
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext mc) throws WebServiceClientException {
        LoggerUtil.logDebug(SOAPMessageInterceptor.class,"\n\n".concat(XMLPrettyPrinter.printSoapMessage(mc, mc.getResponse())));
        return true;
    }

    @Override
    public boolean handleFault(MessageContext mc) throws WebServiceClientException {
        return true;
    }
    
}

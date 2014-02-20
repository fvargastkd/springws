/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.efoe.poc.custserv.utils;

import java.io.IOException;
import java.io.StringWriter;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.context.MessageContext;

/**
 *
 * @author Emmanuel
 */
public class XMLPrettyPrinter {
    
    private static final int DEFAULT_INDENT = 2;
    
    public static String printSoapMessage(MessageContext mc, WebServiceMessage message){
        Transformer transformer = null;
        StreamResult result = null;
        
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            result = new StreamResult(new StringWriter());
            Source s = (Source)message.getPayloadSource();
            transformer.transform(s, result);
        }
        catch(TransformerException e){
            e.printStackTrace();
        }
        return "\n\n".concat(prettyPrint(result.getWriter().toString()));
    }
    
    private static String prettyPrint(String xmlDoc){
        StringWriter sw = new StringWriter();
        XmlObject doc = null;
        try{
            doc = XmlObject.Factory.parse(xmlDoc, (new XmlOptions()).setLoadLineNumbers());
        }
        catch(XmlException e){
            
        }
        return sw.getBuffer().toString();
    }
}

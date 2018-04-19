package com.siniswift.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-04-02T15:12:50.036+08:00
 * Generated source version: 3.2.4
 *
 */
@WebService(targetNamespace = "http://webservice.siniswift.com/", name = "SyncWebService")
@XmlSeeAlso({ObjectFactory.class})
public interface SyncWebService {

    @WebMethod
    @RequestWrapper(localName = "sync", targetNamespace = "http://webservice.siniswift.com/", className = "com.siniswift.client.Sync")
    @ResponseWrapper(localName = "syncResponse", targetNamespace = "http://webservice.siniswift.com/", className = "com.siniswift.client.SyncResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String sync(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
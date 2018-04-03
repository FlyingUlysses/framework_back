
package com.siniswift.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.siniswift.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Sync_QNAME = new QName("http://webservice.siniswift.com/", "sync");
    private final static QName _SyncResponse_QNAME = new QName("http://webservice.siniswift.com/", "syncResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.siniswift.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Sync }
     * 
     */
    public Sync createSync() {
        return new Sync();
    }

    /**
     * Create an instance of {@link SyncResponse }
     * 
     */
    public SyncResponse createSyncResponse() {
        return new SyncResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sync }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.siniswift.com/", name = "sync")
    public JAXBElement<Sync> createSync(Sync value) {
        return new JAXBElement<Sync>(_Sync_QNAME, Sync.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SyncResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.siniswift.com/", name = "syncResponse")
    public JAXBElement<SyncResponse> createSyncResponse(SyncResponse value) {
        return new JAXBElement<SyncResponse>(_SyncResponse_QNAME, SyncResponse.class, null, value);
    }

}

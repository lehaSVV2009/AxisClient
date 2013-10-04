/**
 * HandBookServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kadet;

public class HandBookServiceLocator extends org.apache.axis.client.Service implements kadet.HandBookService {

    public HandBookServiceLocator() {
    }


    public HandBookServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HandBookServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HandBook
    private java.lang.String HandBook_address = "http://localhost:8080/services/example/HandBook";

    public java.lang.String getHandBookAddress() {
        return HandBook_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HandBookWSDDServiceName = "HandBook";

    public java.lang.String getHandBookWSDDServiceName() {
        return HandBookWSDDServiceName;
    }

    public void setHandBookWSDDServiceName(java.lang.String name) {
        HandBookWSDDServiceName = name;
    }

    public kadet.HandBook_PortType getHandBook() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HandBook_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHandBook(endpoint);
    }

    public kadet.HandBook_PortType getHandBook(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            kadet.HandBookSoapBindingStub _stub = new kadet.HandBookSoapBindingStub(portAddress, this);
            _stub.setPortName(getHandBookWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHandBookEndpointAddress(java.lang.String address) {
        HandBook_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (kadet.HandBook_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                kadet.HandBookSoapBindingStub _stub = new kadet.HandBookSoapBindingStub(new java.net.URL(HandBook_address), this);
                _stub.setPortName(getHandBookWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("HandBook".equals(inputPortName)) {
            return getHandBook();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://example", "HandBookService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://example", "HandBook"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HandBook".equals(portName)) {
            setHandBookEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

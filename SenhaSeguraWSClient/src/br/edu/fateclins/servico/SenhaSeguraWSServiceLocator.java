/**
 * SenhaSeguraWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.edu.fateclins.servico;

public class SenhaSeguraWSServiceLocator extends org.apache.axis.client.Service implements br.edu.fateclins.servico.SenhaSeguraWSService {

    public SenhaSeguraWSServiceLocator() {
    }


    public SenhaSeguraWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SenhaSeguraWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SenhaSeguraWS
    private java.lang.String SenhaSeguraWS_address = "http://localhost:8080/SenhaSeguraWS/services/SenhaSeguraWS";

    public java.lang.String getSenhaSeguraWSAddress() {
        return SenhaSeguraWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SenhaSeguraWSWSDDServiceName = "SenhaSeguraWS";

    public java.lang.String getSenhaSeguraWSWSDDServiceName() {
        return SenhaSeguraWSWSDDServiceName;
    }

    public void setSenhaSeguraWSWSDDServiceName(java.lang.String name) {
        SenhaSeguraWSWSDDServiceName = name;
    }

    public br.edu.fateclins.servico.SenhaSeguraWS getSenhaSeguraWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SenhaSeguraWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSenhaSeguraWS(endpoint);
    }

    public br.edu.fateclins.servico.SenhaSeguraWS getSenhaSeguraWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.edu.fateclins.servico.SenhaSeguraWSSoapBindingStub _stub = new br.edu.fateclins.servico.SenhaSeguraWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getSenhaSeguraWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSenhaSeguraWSEndpointAddress(java.lang.String address) {
        SenhaSeguraWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.edu.fateclins.servico.SenhaSeguraWS.class.isAssignableFrom(serviceEndpointInterface)) {
                br.edu.fateclins.servico.SenhaSeguraWSSoapBindingStub _stub = new br.edu.fateclins.servico.SenhaSeguraWSSoapBindingStub(new java.net.URL(SenhaSeguraWS_address), this);
                _stub.setPortName(getSenhaSeguraWSWSDDServiceName());
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
        if ("SenhaSeguraWS".equals(inputPortName)) {
            return getSenhaSeguraWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servico.fateclins.edu.br", "SenhaSeguraWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servico.fateclins.edu.br", "SenhaSeguraWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SenhaSeguraWS".equals(portName)) {
            setSenhaSeguraWSEndpointAddress(address);
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

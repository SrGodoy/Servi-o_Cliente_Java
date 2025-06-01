/**
 * SenhaSeguraWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.edu.fateclins.servico;

public interface SenhaSeguraWS extends java.rmi.Remote {
    public java.lang.String gerarSenhaSegura(int tamanho, boolean usarNumeros, boolean usarEspeciais) throws java.rmi.RemoteException;
    public java.lang.String saudacao() throws java.rmi.RemoteException;
}

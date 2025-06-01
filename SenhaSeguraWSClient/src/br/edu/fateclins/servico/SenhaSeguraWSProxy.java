package br.edu.fateclins.servico;

public class SenhaSeguraWSProxy implements br.edu.fateclins.servico.SenhaSeguraWS {
  private String _endpoint = null;
  private br.edu.fateclins.servico.SenhaSeguraWS senhaSeguraWS = null;
  
  public SenhaSeguraWSProxy() {
    _initSenhaSeguraWSProxy();
  }
  
  public SenhaSeguraWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initSenhaSeguraWSProxy();
  }
  
  private void _initSenhaSeguraWSProxy() {
    try {
      senhaSeguraWS = (new br.edu.fateclins.servico.SenhaSeguraWSServiceLocator()).getSenhaSeguraWS();
      if (senhaSeguraWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)senhaSeguraWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)senhaSeguraWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (senhaSeguraWS != null)
      ((javax.xml.rpc.Stub)senhaSeguraWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.edu.fateclins.servico.SenhaSeguraWS getSenhaSeguraWS() {
    if (senhaSeguraWS == null)
      _initSenhaSeguraWSProxy();
    return senhaSeguraWS;
  }
  
  public java.lang.String gerarSenhaSegura(int tamanho, boolean usarNumeros, boolean usarEspeciais) throws java.rmi.RemoteException{
    if (senhaSeguraWS == null)
      _initSenhaSeguraWSProxy();
    return senhaSeguraWS.gerarSenhaSegura(tamanho, usarNumeros, usarEspeciais);
  }
  
  public java.lang.String saudacao() throws java.rmi.RemoteException{
    if (senhaSeguraWS == null)
      _initSenhaSeguraWSProxy();
    return senhaSeguraWS.saudacao();
  }
  
  
}
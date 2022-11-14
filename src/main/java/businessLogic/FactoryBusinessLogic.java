package businessLogic;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;

public class FactoryBusinessLogic {
	
	public BLFacade getBusinessLogic(boolean modo) {
		BLFacade interfaz = null;
		
		if (modo) {
			ConfigXML c=ConfigXML.getInstance();
			String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";
			 
			try {
				URL url;
				url = new URL(serviceName);
				QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
				Service service = Service.create(url, qname);
				interfaz = service.getPort(BLFacade.class);

			}catch (MalformedURLException e) {
				System.out.println("Error al crear la logica de negocio remota");			
			}	 

		}else {	
			interfaz = new BLFacadeImplementation(false);
		}
		return interfaz;
	}


}
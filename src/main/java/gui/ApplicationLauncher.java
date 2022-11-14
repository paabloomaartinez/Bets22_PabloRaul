package gui;

import java.awt.Color;


import java.util.Locale;

import javax.swing.UIManager;


import businessLogic.FactoryBusinessLogic;

import businessLogic.BLFacade;
import configuration.ConfigXML;

public class ApplicationLauncher { 
	
	
	
	public static void main(String[] args) {

		ConfigXML c=ConfigXML.getInstance();
	
		System.out.println(c.getLocale());
		
		Locale.setDefault(new Locale(c.getLocale()));
		
		System.out.println("Locale: "+Locale.getDefault());
		
		MainGUI a=new MainGUI();
		a.setVisible(false);
		
		MainUserGUI b = new MainUserGUI(); 
		b.setVisible(true);


		try {
			
			boolean modo = false;
			
			FactoryBusinessLogic factory = new FactoryBusinessLogic();
			BLFacade interfaz = factory.getBusinessLogic(modo);
			
			
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			
			MainGUI.setBussinessLogic(interfaz);
				
				
		}catch(Exception e) {
			a.jLabelSelectOption.setText("Error: "+e.toString());
			a.jLabelSelectOption.setForeground(Color.RED);	
			
			System.out.println("Error in ApplicationLauncher: "+e.toString());	
				 
		} 		

	}

}

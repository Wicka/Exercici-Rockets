package Fase3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Principal {

	public static void main(String[] args) {		
		
		List <Rocket> listRockets = new ArrayList<Rocket>();					//DECLARO LA LISTA DE LOS COHETES		
				
		Rocket rocket1 = new Rocket("32WESSDS", 0);								//INSTANCIA  COHETE 1
		Rocket rocket2 = new Rocket("LDSFJA32", 0);								//INSTANCINA COHETE 2

		int potAct=0;
								
		Propeller propeller11 = new Propeller ("01", 10, potAct);			//INSTANCIA PROPULSORES
		Propeller propeller12 = new Propeller ("02", 30, potAct);
		Propeller propeller13 = new Propeller ("03", 80, potAct);
		
			
		rocket1.addPropeller(propeller11);										//AÑADO 3 PROPULSORES AL COHETE 1
		rocket1.addPropeller(propeller12);
		rocket1.addPropeller(propeller13);
		
		
		Propeller propeller21 = new Propeller ("01", 30, potAct);			//INSTANCIA PROPULSORES
		Propeller propeller22 = new Propeller ("02", 40, potAct);
		Propeller propeller23 = new Propeller ("03", 50, potAct);

		Propeller propeller24 = new Propeller ("04", 50, potAct);			//INSTANCIA DE OTROS TRES PROPULSORES
		Propeller propeller25 = new Propeller ("05", 30, potAct);
		Propeller propeller26 = new Propeller ("06", 10, potAct);
		
			
		rocket2.addPropeller(propeller21);										//AÑADO 6 PROPULSORES AL COHETE 2
		rocket2.addPropeller(propeller22);
		rocket2.addPropeller(propeller23);
		rocket2.addPropeller(propeller24);
		rocket2.addPropeller(propeller25);
		rocket2.addPropeller(propeller26);
					
		listRockets.add(rocket1);												//AÑADO LOS COHETES A LA LISTA DE COHETES
		listRockets.add(rocket2);
		
		for (Rocket rocket : listRockets) {										//RECORRO LA LISTA PARA MOSTRAR CADA COHETE
				
			System.out.println("\n Rocket Code : " + rocket.getIdRocket());
				
			System.out.println("\n Propellers : \n");
				
			for (Propeller propeller : rocket.getPropellers()) {				//RECORRO CADA PROPULSOR DE CADA COHETE
					
				System.out.println(propeller);
					
			}
		}
		
		
		rocket1.start();
		
	/*	try {
			
			rocket1.join();
		} catch (InterruptedException e) {		e.printStackTrace();
		}
		*/
		
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		rocket2.start();
		
	/*	try {
			rocket2.join();
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}*/
			
	
	
						
	}	
	
}

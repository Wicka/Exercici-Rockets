package Fase1;

import java.util.ArrayList;
import java.util.List;


public class Principal {

	public static void main(String[] args) {		
		
		String code="";
		
		List <Rocket> listRockets = new ArrayList<Rocket>();					//DECLARO LA LISTA DE LOS COHETES		
				
		Rocket rocket1 = new Rocket("LDSFJA32");								//INSTANCIA  COHETE 1
		Rocket rocket2 = new Rocket("ABNTED83");								//INSTANCINA COHETE 2
	
		int iCont;
		
		for (iCont=1; iCont<=3; iCont++) {										//BUCLE PARA CREAR LOS 3 PROPULSORES
			
			code="0"+ iCont;													//GENERO UN CODIGO POR CADA PROPULSOR
			
			Propeller propeller = new Propeller (code);							//INSTANCIA PROPULSORES
			rocket1.addPropeller(propeller);									//AÑADO PROPULSOR  AL COHETE 1
				
		}
		
		
			
			for (iCont=1; iCont<=6; iCont++) {									//BUCLE PARA CREAR LOS 6 PROPULSORES
			
			code="0"+ iCont;													//GENERO UN CODIGO POR CADA PROPULSOR
			
			Propeller propeller = new Propeller (code);							//INSTANCIA PROPULSORES
			rocket2.addPropeller(propeller);									//AÑADO PROPULSOR AL COHETE 2
				
		}
					
		listRockets.add(rocket1);												//AÑADO LOS COHETES A LA LISTA DE COHETES
		listRockets.add(rocket2);
		
		for (Rocket rocket : listRockets) {										//RECORRO LA LISTA PARA MOSTRAR CADA COHETE
				
			
			System.out.println("\n Rocket codigo : " + rocket.getIdRocket());
				
			System.out.println("\n Numbers of Propellers : " + rocket.getPropellers().size());
				
			
		}
		
	}		
	
}

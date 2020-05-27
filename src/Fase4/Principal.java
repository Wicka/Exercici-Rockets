package Fase4;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Principal {

	public static void main(String[] args) {		
		
		int option=-1;
		Scanner sc = new Scanner(System.in);
		int state=0;
		
		List <Rocket> listRockets = new ArrayList<Rocket>();					//DECLARO LA LISTA DE LOS COHETES		
		int environment =0;
		
			
		listRockets= createRockets(listRockets);
				
		menuPrincipal();
		
		do {
			do {
				
				try {
					
					option=Integer.parseInt(sc.next());
				}catch(Exception e) {
					
					System.out.println(("You must enter a number please"));
				}
				
				
				if (option !=0 && option !=1 && option !=2 && option !=3) {
					
					System.out.println("Please enter a menu option ( 1 / 2 / 3 / 0 )");
				}
				
			}while(option !=0 && option !=1 && option !=2 && option !=3);
			
			
			switch (option) {
				case 1:
					viewParameters(listRockets);
					pressAnyKeyToContinue();
					menuPrincipal();
			
					break;
				case 2:
					testingRockets(listRockets,option);	
					pressAnyKeyToContinue();
					menuPrincipal();
			
				break;
				case 3:
					testingRockets(listRockets,option);	
					pressAnyKeyToContinue();
					menuPrincipal();
			
				break;
				case 0:
					System.out.println("Thanks for use this program...BYE BYE");
				break;
				default:
				break;
					
			}
				
		}while(option!=0);
						
	}

	
	private static void testingRockets(List<Rocket> listRockets, int environment) {
		
		int vInitial=0;
		int vTarget=0;
		int optionV=-1;
		boolean check=false;
		Scanner sc = new Scanner(System.in);
		
		if (environment==2) {		//NORMAL CONDITIONS 
			
			
			for (Rocket rocket : listRockets) {
				
					rocket.speedMaximun(environment);
					
					ThreadRocket runRocket = new ThreadRocket(rocket, environment);
					runRocket.run();
			}
				
			
		}else {						//SPACE CONDITIONS
			
			menuSpeedUp();
			do {
				do {
					
					try {
						
						optionV=Integer.parseInt(sc.next());
					}catch(Exception e) {
						
						System.out.println(("You must enter a number please"));
					}
					
					
					if (optionV !=4 && optionV !=1 && optionV !=2 && optionV !=3) {
						
						System.out.println("Please enter a menu option ( 1 / 2 / 3 / 4)");
					}
					
				}while(optionV !=4 && optionV !=1 && optionV !=2 && optionV !=3);
				
				
				
				switch (optionV) {
				
				case 1:					
					vInitial=SpeedInsert();
					System.out.println("Initial Speed: " + vInitial + " - "+ vTarget);
					menuSpeedUp();											
				break;
				
				case 2:
					vTarget=SpeedInsert();
					System.out.println("Initial Speed: " + vInitial + " -- Initial Speed:  "+ vTarget);					
					menuSpeedUp();															
				break;
				
				case 3:
					check=checkingSpedds(vInitial,vTarget);
					if (check==true) {						
						verifyTopSpeed(listRockets,environment,vInitial,vTarget);
						menuSpeedUp();						
					}else {
						System.out.println("You must enter almost Speed Target");
					}
					menuSpeedUp();	
				break;
				
				case 4:
					menuPrincipal();
				break;
				
				default:
				break;
						
				}
				
			
				
			}while(optionV!=4);
			
		}
		
	}

	private static void verifyTopSpeed(List<Rocket> listRockets, int environment,int vInitial,int vTarget) {
		
		for (Rocket rocket2 : listRockets) {
			
			rocket2.speedMaximun(environment);
			
			State state = rocket2.getState();
			
			if (state.name()=="NEW") {
				
				ThreadRocket runRocket = new ThreadRocket(rocket2, environment);
				runRocket.run();
				
			}else {
				System.out.println("Error hilos su estado es " + state);
			}
			
	//		rocket2.setRun(false);

			double speedMax= rocket2.speedMaximun(vInitial);
			
			if (vTarget>speedMax) {
				System.out.println("NO es posible alcanzar esa velocidad con el Rocket " + rocket2.getIdRocket());
			}					
	
		}
		
		
	}


	private static boolean checkingSpedds(int vInitial, int vTarget) {
		boolean check=true;
			if (vInitial<0 || vTarget<= 0) {
				check=false;
			}
	
		return check;
	}

	
	
	private static int SpeedInsert() {
		int entry=0;
		Scanner sc = new Scanner(System.in);
		do {
			
			try {
				System.out.println("Insert the Speed : ");
				entry=Integer.parseInt(sc.next());
				
			}catch(Exception e) {
				
				System.out.println(("You must enter a number please"));
				entry=-1;
			}
			
			
			if (entry <0) {
				
				System.out.println("Please enter a real Speed up to zero");
			}
			
		}while(entry <0);
		
		return entry;
	}
	
	

	private static void viewParameters(List<Rocket> listRockets) {
		for (Rocket rocket : listRockets) {										//RECORRO LA LISTA PARA MOSTRAR CADA COHETE
			
			System.out.println("\n Rocket Code : " + rocket.getIdRocket());
				
			System.out.println("\n Propellers : \n");
				
			for (Propeller propeller : rocket.getPropellers()) {				//RECORRO CADA PROPULSOR DE CADA COHETE
					
				System.out.println(propeller);
					
			}
		}
	
		
	}

	private static List<Rocket> createRockets(List<Rocket> listRockets) {
	
		int potAct=0;

		Rocket rocket1 = new Rocket("32WESSDS");								//INSTANCIA  COHETE 1
	
								
			Propeller propeller11 = new Propeller ("01", 10, potAct);			//INSTANCIA PROPULSORES
			Propeller propeller12 = new Propeller ("02", 30, potAct);
			Propeller propeller13 = new Propeller ("03", 80, potAct);
			
				
			rocket1.addPropeller(propeller11);										//AÑADO 3 PROPULSORES AL COHETE 1
			rocket1.addPropeller(propeller12);
			rocket1.addPropeller(propeller13);
				
			Rocket rocket2 = new Rocket("LDSFJA32");								//INSTANCINA COHETE 2

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
		
		return listRockets;
	}
	

	private static void menuPrincipal() {
		System.out.println("---------------------------------------- MENU PRINCIPAL -----------------------------------------------------------------\n");
		System.out.println(" 1. View Rockets Parameters.");
		System.out.println(" 2. Testing Rockets in Normal Conditions.");
		System.out.println(" 3. Testing Rockets in Space Conditions");		
		System.out.println(" 0. Exit to Program");
		
	}

	private static void menuSpeedUp() {
		
		System.out.println("---------------------------------------- MENU SPACE ROCKET -----------------------------------------------------------------\n");
		System.out.println(" 1. Indicates the initial speed. Otherwise it will be 0. ");
		System.out.println(" 2. Indicates the target speed.");
		System.out.println(" 3. Start. (Remember you must enter The Target Speed)");		
		System.out.println(" 4. Back to Menu Principal");
	}	
	
	static public void pressAnyKeyToContinue()
    { 
        String seguir;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Press Enter key to continue...");
        try
          {
           seguir = teclado.nextLine();
          }   
       catch(Exception e)
        {}  
   }
}

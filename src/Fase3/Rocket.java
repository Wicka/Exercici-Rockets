package Fase3;

import java.util.ArrayList;
import java.util.List;

public class Rocket extends Thread {
	
	private String idRocket;
	private int speed;
	private List <Propeller> Propellers;
	
	
	public Rocket(String id, int speed) {
		
		this.idRocket=id;
		this.speed=speed;
		this.Propellers=new ArrayList <Propeller>();
	}
	
	
	
	
	public int getSpeed() {
		return speed;
	}




	public void setSpeed(int speed) {
		this.speed = speed;
	}




	public void addPropeller(Propeller propeller) {
		
		this.Propellers.add(propeller);
	}
	
	
	public String getIdRocket() {
		return idRocket;
	}
	public void setIdRocket(String idRocket) {
		this.idRocket = idRocket;
	}
	public List <Propeller> getPropellers() {
		return Propellers;
	}
	public void setPropellers(List <Propeller> Propellers) {
		this.Propellers = Propellers;
	}


	public void putOnSpeed () {		
		
		System.out.println("\n -------------------------------------------------------------------------------------------- Start Put On Speed -----------Rocket " + this.getIdRocket());
		
			
		for (Propeller propeller : Propellers) {
			
			int current;
			
			current=propeller.getCurrentPower();
			
			System.out.print("\n Rocket " + this.getIdRocket() + "  Propeller " + propeller.getCode() + " Power " + propeller.getCurrentPower()+ " ");
			
		
			for (int i=current; i<= propeller.getMaxPower(); i++) {
				
				
				try {
					
					System.out.print("/" );
					
					propeller.setCurrentPower(i);
						
					Thread.sleep(50);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}		
				
			}
			
			System.out.print("  Power " + propeller.getCurrentPower()+ " ");
			
			
		}
	
		System.out.println("\n ------------------------------------------------------------------------------------ Maximun Speed ---------------------------------Rocket " + this.getIdRocket());

		
	}
	
	public void backAway () {
		
		System.out.println("\n -------------------------------------------------------------------------------------------- Start Back Away -----------Rocket " + this.getIdRocket());
		
		
		for (Propeller propeller : Propellers) {
			
			int current;
			int i;
			current=propeller.getCurrentPower();
			
			System.out.print("\n Rocket " + this.getIdRocket() + "  Propeller " + propeller.getCode() + " Power " + propeller.getCurrentPower()+ " ");
			
	
			
		//	System.out.print("\n Rocket " + this.getIdRocket() + "  Propeller " + propeller.getCode() + " ( "+ propeller.getCurrentPower() + " ) ");
			
			for ( i=current; i>= 0; i--) {
				
				
				try {
					
					System.out.print("'\'" );
					
					propeller.setCurrentPower(i);
					
						
					Thread.sleep(50);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}		
				
			}
			
			System.out.print("  Power " + propeller.getCurrentPower()+ " ");
				
		}
		
		System.out.println("\n ------------------------------------------------------------------------------------ Stop -------------------------------------------Rocket " + this.getIdRocket());
	//System.out.println("\n ---------------------------------------------------------------------\n");

		
	}
	

	



	@Override
	public String toString() {
		return "Rocket [idRocket=" + idRocket + ", Propellers=" + Propellers + "]";
	}




	@Override
	public void run() {
		
		putOnSpeed ();
		
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	
		
		backAway ();
		
	}
	

}

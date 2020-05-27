package Fase4;

import java.util.ArrayList;
import java.util.List;

public class ThreadRocket implements Runnable {
	
	private Rocket rock;
	private int environment; 
	
	public ThreadRocket (Rocket rock, int environment) {
		
		this.rock=rock;	
		this.environment= environment;
	}

	@Override
	public void run() {
		
		putOnSpeed ();
		backAway();
	}
	
	
public void putOnSpeed () {		
		
		System.out.println("\n -------------------------------------------------------------------------------------------- Start Put On Speed -----------Rocket " + this.rock.getIdRocket());
		System.out.println(" Speed Maximun Rocket " +  this.rock.getIdRocket() + " " + this.rock.getSpeedMax());
		
			
		for (Propeller propeller : this.rock.getPropellers()) {
			
			int current;
			
			current=propeller.getCurrentPower();
			
			System.out.print("\n Rocket " + this.rock.getIdRocket() + "  Propeller " + propeller.getCode() + " Power " + propeller.getCurrentPower()+ " ");
			
		
			for (int i=current; i<= propeller.getMaxPower(); i++) {
				
				
				try {
					
					System.out.print("/" );
					
					propeller.setCurrentPower(i);
						
					Thread.sleep(30);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}		
				
			}
			
			System.out.print("  Power " + propeller.getCurrentPower()+ " ");
			
			
		}
	
		System.out.println("\n ------------------------------------------------------------------------------------ Maximun Speed ---------------------------------Rocket " + this.rock.getIdRocket());

		
	}


public void backAway () {
	
	System.out.println("\n -------------------------------------------------------------------------------------------- Start Back Away -----------Rocket " + this.rock.getIdRocket());
	
	
	for (Propeller propeller : this.rock.getPropellers()) {
		
		int current;
		int i;
		current=propeller.getCurrentPower();
		
		System.out.print("\n Rocket " + this.rock.getIdRocket() + "  Propeller " + propeller.getCode() + " Power " + propeller.getCurrentPower()+ " ");
		
		for ( i=current; i>= 0; i--) {
			
			
			try {
				
				System.out.print("'\'" );
				
				propeller.setCurrentPower(i);
				
					
				Thread.sleep(30);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}		
			
		}
		
		System.out.print("  Power " + propeller.getCurrentPower()+ " ");
			
	}
	
	System.out.println("\n ------------------------------------------------------------------------------------ Stop -------------------------------------------Rocket " + this.rock.getIdRocket());
	//this.stop();
	System.out.println("Estado del hilo al terminar en run " + Thread.currentThread().isInterrupted());

	
}
	
	

}

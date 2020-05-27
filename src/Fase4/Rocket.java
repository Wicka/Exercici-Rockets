package Fase4;

import java.util.ArrayList;
import java.util.List;

public class Rocket extends Thread {
	
	private String idRocket;
	private int speed;
	private double speedMax;
	private boolean run;
	
	public double getSpeedMax() {
		return speedMax;
	}




	public void setSpeedMax(double speedMax) {
		this.speedMax = speedMax;
	}




	private List <Propeller> Propellers;
	
	
	public Rocket(String id) {
		
		this.idRocket=id;
		this.speed=0;
		this.Propellers=new ArrayList <Propeller>();
		this.speedMax=speedMaximun(0);
		this.run=true;

	}
	
	
	
	
	public boolean isRun() {
		return run;
	}




	public void setRun(boolean run) {
		this.run = run;
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
	
	public double speedMaximun(int environment) {
		
		int maxPower=0;
	
		final double g=9.8066;
		double speedIni=this.getSpeed();
		
		for (Propeller propeller : Propellers) {
			
			maxPower=maxPower + propeller.getMaxPower();
		}
		
		if (environment==2) {			
		
			speedMax=Math.round((  Math.sqrt( (g*maxPower)/(2*Math.PI) ) * 3600/1852 ) *100)/100;					// NORMAL CONDITIONS (WATER)			
			this.setSpeedMax(speedMax);
			
		}else {
			
			speedMax=Math.round( (( speedIni + 100 * Math.sqrt(maxPower) ) *100)/100);					// SPACE CONDITIONS 
			this.setSpeedMax(speedMax);

		}
		
		return speedMax;
	}

	@Override
	public String toString() {
		return "Rocket [idRocket=" + idRocket + ", Propellers=" + Propellers + "]";
	}




	@Override
	public void run() {
		
		System.out.println("Estado del hilo al entrar en run " + Thread.currentThread().isInterrupted());

		System.out.println("Estado del hilo al terminar en run " + Thread.currentThread().isInterrupted());

	}

}

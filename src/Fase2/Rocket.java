package Fase2;

import java.util.ArrayList;
import java.util.List;

public class Rocket {
	
	private String idRocket;
	private List <Propeller> Propellers;
	
	
	public Rocket(String id) {
		
		this.idRocket=id;
		this.Propellers=new ArrayList <Propeller>();
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




	@Override
	public String toString() {
		return "Rocket [idRocket=" + idRocket + ", Propellers=" + Propellers + "]";
	}
	

}

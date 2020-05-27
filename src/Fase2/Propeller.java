package Fase2;


public class Propeller {
	

	private String code;
	private int maxPower;
	
	
	public Propeller ( String code, int maxPower){
		
		this.code=code;
		this.setMaxPower(maxPower);	
			
	}

		
	public int getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}


	@Override
	public String toString() {
		return "Propeller [maxPower = " + maxPower + "]";
	}
	
	

}

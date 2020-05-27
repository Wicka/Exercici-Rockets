package Fase4;


public class Propeller{
	

	private String code;
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private int maxPower;
	private int currentPower;
	
	public Propeller ( String code, int maxPower, int currentPower){
		
		this.code=code;
		this.setMaxPower(maxPower);
		this.setCurrentPower(currentPower);
			
	}

	public int getCurrentPower() {
		return currentPower;
	}

	public void setCurrentPower(int currentPower) {
		this.currentPower = currentPower;
	}

	
	public int getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}
	
	@Override
	public String toString() {
		return "Propeller [" + code + ", maxPower= " + maxPower + ", current = " + currentPower + " ]";
	}
	
	
}

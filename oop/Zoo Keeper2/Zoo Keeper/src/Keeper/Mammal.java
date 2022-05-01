package Keeper;

public class Mammal {
	private int energyLevel;
	
	public Mammal(int energyLevel) {
		super();
		this.energyLevel = energyLevel;
	}

	
	
	public void displayEnergy() {
		System.out.println("The Energy is :"+ energyLevel);
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

}
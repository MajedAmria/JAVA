package Keeper;

public class Bat extends Mammal {
	
	public Bat(int energyLevel) {
		super(energyLevel);

	}
	
	public void fly() {
		System.out.println("sound of a bat taking off ");
		this.setEnergyLevel(this.getEnergyLevel()-50);
	}
	
	public void eatHumans() {
		System.out.println("so- well, never mind");
		this.setEnergyLevel(this.getEnergyLevel()+25);
	}
	
	public void attackTown() {
		System.out.println("sound of a town on fire ");
		this.setEnergyLevel(this.getEnergyLevel()-100);
	}
}

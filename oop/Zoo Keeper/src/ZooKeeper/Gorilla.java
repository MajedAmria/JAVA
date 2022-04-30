package ZooKeeper;

public class Gorilla extends Mammal {
	

	public Gorilla(int energyLevel) {
		super(energyLevel);
		// TODO Auto-generated constructor stub
	}
	public void throwSomething() {
		System.out.println("Gorilla is throwing now the enerdy level will incresing ");
		this.setEnergyLevel(this.getEnergyLevel()+5);
	}
	public void eatBananas() {
		System.out.println("Gorilla is eating Banana now");
		this.setEnergyLevel(this.getEnergyLevel()+10);
	}
	public void climb() {
		System.out.println("Gorilla is climbing now");
		this.setEnergyLevel(this.getEnergyLevel()-10);
	}
}

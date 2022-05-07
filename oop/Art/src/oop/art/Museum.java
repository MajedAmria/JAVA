package oop.art;

public class Museum {

	public static void main(String[] args) {
		Painting paint1 = new Painting("1", "2", "3", "4");
		Sculpture scu2 = new Sculpture("monalesa", "bicaso", "just Sculpture", "hummer");
		
		paint1.viewArt();

		scu2.viewArt();
	
	}

}

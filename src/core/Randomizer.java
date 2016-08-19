package core;

public class Randomizer {
	/*
	 * random(int border) returns a random integer within the interval [0, border-1]
	 */
	
	private static double compute_random(int border) {
		return Math.random()*border;
	}	
	
	public static int random(int border) {
		return (int) compute_random(border);
	}
}

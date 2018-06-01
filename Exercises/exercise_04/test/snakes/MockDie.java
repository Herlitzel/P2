package snakes;

import java.util.Random;

public class MockDie implements IDie{
	
	private static int mockDieInstanceCount = 0;
	
	private int rollCount = 0;
	
	private int wishedValue = 0;
	private boolean realDie = false;
	private int faces;
	
	public MockDie() {
		mockDieInstanceCount++;
	}
	
	public void makeItRealDie(int faces) {
		this.faces = faces;
		realDie = true;
	}
	
	@Override
	public int roll() {
		rollCount++;
		if(!realDie)
			return wishedValue;
		Random rand = new Random();
		return rand.nextInt(faces);
		
	}
	
	//Get and Set methods
	public void setValue(int v) {
		wishedValue = v;
		}
	
	public int getInstanceCount() {
		return mockDieInstanceCount;
	}
	
	public int getRollCount() {
		return rollCount;
	}

}

package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		
	}
	
	public double exponentiate(double a, double b) {
		return Math.pow(a, b);
	}
	
	
	public int randomNumberSquared() {
		int num = getRandomInt();
		return num * num;
	}

	int getRandomInt() {
		Random num = new Random();
		return num.nextInt(10) + 1;
	}

}

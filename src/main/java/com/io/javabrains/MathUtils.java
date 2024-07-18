package com.io.javabrains;

public class MathUtils {
	public static final double E = 2.7182;	 //Doğal Logaritmik Taban
	public static final double PI= 3.141592653589793;
	
	public int addition(int a,int b){
		return a+b;
	}
	public int subtraction(int a,int b) {
		return a-b;
	}
	public int division(int pay,int payda) {
		return (pay/payda);
	}
	public int multiplication(int a,int b) {
		return a*b;
	}
	
	public int factorial(int a) {
		int i;
		int factorial=1;
		
		if(a==0||a==1)return 1;
		
		for(i=1;i<=a;i++) {
			factorial *=i;
		}
		return factorial;
	}
	public int power(int base,int exponent) {
		int sonuc=1;
		int i;
		
		if(exponent ==0)return 1;
		
		for(i=1;i<=exponent;i++) {
			sonuc*=base;
		}
		return sonuc;
	}
	
	public double circleArea(int radius) {
		return PI * radius*radius;
	}
}

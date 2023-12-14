package com.jacaranda.model;

import java.util.Objects;

public class Calculator {

	
	private double num1;
	private double num2;
	private char operator;
	

	


	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public char getOperator() {
		return operator;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}

	public double getResult() throws Exception {
		double result = 0;
		if(this.operator=='+') {
			result = this.num1+this.num2;
		}else if(this.operator=='-') {
			result = this.num1-this.num2;
		}else if(this.operator=='*') {
			result = this.num1*this.num2;
		}else if(this.operator=='/') {
			result = this.num1/this.num2;
		}else {
			throw new Exception("No se puede calcular");
		}
		
		return result;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(num1, num2, operator);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculator other = (Calculator) obj;
		return Double.doubleToLongBits(num1) == Double.doubleToLongBits(other.num1)
				&& Double.doubleToLongBits(num2) == Double.doubleToLongBits(other.num2) && operator == other.operator;
	}
	
	
	
	
}

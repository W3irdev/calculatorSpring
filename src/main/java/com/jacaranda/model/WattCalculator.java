package com.jacaranda.model;

import java.util.Objects;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class WattCalculator {

	@NotNull
	private double volts;
	@NotNull
	@Min(value = 0, message = "Debe ser mayor 0")
	private double amps;
	public double getVolts() {
		return volts;
	}
	public void setVolts(double volts) throws Exception {
		try {
			this.volts = volts;			
		}catch (Exception e) {
			throw new Exception("El valor no es correcto");
		}
	}
	public double getAmps() {
		return amps;
	}
	public void setAmps(double amps) throws Exception {
		try {
			this.amps = amps;
		}catch (Exception e) {
			throw new Exception("El valor no es correcto");
		}
	}
	@Override
	public int hashCode() {
		return Objects.hash(amps, volts);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WattCalculator other = (WattCalculator) obj;
		return Double.doubleToLongBits(amps) == Double.doubleToLongBits(other.amps)
				&& Double.doubleToLongBits(volts) == Double.doubleToLongBits(other.volts);
	}

	
	public String getWattios() {
		return "El resultado es "+this.volts*this.amps+" W.";
		
	}
	
}

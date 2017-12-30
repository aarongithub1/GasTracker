package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gas_tracker")
public class Gas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="num_gallons")
	private double numGallons;
	
	@Column(name="price_per_gallon")
	private double pricePerGallon;
	
	@Column(name="miles_driven")
	private double milesDriven;
	
	@Column(name="miles_per_gallon")
	private double mpg;
	
	
	// getters/setters
	public int getId() {
		return id;
	}

	public double getNumGallons() {
		return numGallons;
	}

	public void setNumGallons(double numGallons) {
		this.numGallons = numGallons;
	}

	public double getPricePerGallon() {
		return pricePerGallon;
	}

	public void setPricePerGallon(double pricePerGallon) {
		this.pricePerGallon = pricePerGallon;
	}

	public double getMilesDriven() {
		return milesDriven;
	}

	public void setMilesDriven(double milesDriven) {
		this.milesDriven = milesDriven;
	}

	public double getMpg() {
		return mpg;
	}

	public void setMpg(double mpg) {
		this.mpg = mpg;
	}
	
	// toString
	@Override
	public String toString() {
		return "gas [id=" + id + ", numGallons=" + numGallons + ", pricePerGallon=" + pricePerGallon + ", milesDriven="
				+ milesDriven + ", mpg=" + mpg + "]";
	}
	
	
	
}

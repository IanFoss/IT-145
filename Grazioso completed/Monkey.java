//Class creation inheriting from RescueAnimal
//Has fields unique to this class
public class Monkey extends RescueAnimal {
	private String tailLength;
	private String height;
	private String bodyLength;
	private String species;
	
	//Default constructor
	public Monkey(String name, String gender, String age,
			      String weight, String acquisitionDate, String acquisitionCountry,
			      String trainingStatus, String reserved, String inServiceCountry,
			      String tailLength, String height, String bodyLength, String species) {
			        setName(name);
			        setGender(gender);
			        setAge(age);
			        setWeight(weight);
			        setAcquisitionDate(acquisitionDate);
			        setAcquisitionLocation(acquisitionCountry);
			        setTrainingStatus(trainingStatus);
			        setReserved(reserved);
			        setInServiceCountry(inServiceCountry);
			        setTailLength(tailLength);
			        setHeight(height);
			        setBodyLength(bodyLength);
			        setSpecies(species);
			    }

	
	//Accessors and Mutators for fields
	public void setTailLength(String tailLength) {
		this.tailLength = tailLength;
	}
	
	public String getTailLength() {
		return tailLength;
	}
	
	public void setHeight(String height) {
		this.height = height;
	}
	
	public String getHeight () {
		return height;
	}
	
	public void setBodyLength(String bodyLength) {
		this.bodyLength = bodyLength;
	}
	
	public String getBodyLength() {
		return bodyLength;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public String getSpecies() {
		return species;
	}
	
}

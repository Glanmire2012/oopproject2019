package list;

public class Procedure {
	String procedureName;
	String procedureDescription;
	Double price;
	
	public Procedure(String procedureName, String procedureDescription, Double price) {
		this.price = price;
		this.procedureDescription = procedureDescription;
		this.procedureName = procedureName;
	}

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	public String getProcedureDescription() {
		return procedureDescription;
	}

	public void setProcedureDescription(String procedureDescription) {
		this.procedureDescription = procedureDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}

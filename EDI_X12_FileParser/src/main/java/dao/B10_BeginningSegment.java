package dao;

public class B10_BeginningSegment {
	
	private String B1001_referenceIdentifier;
	
	private String B1002_shipmentIdentifier;
	
	private String B1003_carrierCode;
	
	
	public String getB1001_referenceIdentifier() {
		return B1001_referenceIdentifier;
	}

	
	public void setB1001_referenceIdentifier(String b1001_referenceIdentifier) {
		B1001_referenceIdentifier = b1001_referenceIdentifier;
	}

	
	public String getB1002_shipmentIdentifier() {
		return B1002_shipmentIdentifier;
	}

	
	public void setB1002_shipmentIdentifier(String b1002_shipmentIdentifier) {
		B1002_shipmentIdentifier = b1002_shipmentIdentifier;
	}

	
	public String getB1003_carrierCode() {
		return B1003_carrierCode;
	}

	public void setB1003_carrierCode(String b1003_carrierCode) {
		B1003_carrierCode = b1003_carrierCode;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "B1001: " + B1001_referenceIdentifier + ", B1002: " + B1002_shipmentIdentifier 
				+ "B1003: " + B1003_carrierCode;
	}
}

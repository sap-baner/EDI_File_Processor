package dao;

public class L11_ReferenceNumber {
	private String L1101_referenceIdentification;
	private String L1102_referenceIdentificationQuaifier;
	public String getL1101_referenceIdentification() {
		return L1101_referenceIdentification;
	}
	public void setL1101_referenceIdentification(
			String l1101_referenceIdentification) {
		L1101_referenceIdentification = l1101_referenceIdentification;
	}
	public String getL1102_referenceIdentificationQuaifier() {
		return L1102_referenceIdentificationQuaifier;
	}
	public void setL1102_referenceIdentificationQuaifier(
			String l1102_referenceIdentificationQuaifier) {
		L1102_referenceIdentificationQuaifier = l1102_referenceIdentificationQuaifier;
	}
	
	@Override 
	public String toString() {
		return "L1101: " + L1101_referenceIdentification + ", L1102: " + L1102_referenceIdentificationQuaifier;
	}
}

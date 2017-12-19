package dao;

import java.util.List;

public class ST_TransactionSetHeader {

	
	private String ST01_transactionSetIdCode;
	
	private String ST02_transactionSetControlNumber;
	
	private B10_BeginningSegment B10_beginningSegment;
	private List<L11_ReferenceNumber> listL11_referenceNumber;
	
	public String getST01_transactionSetIdCode() {
		return ST01_transactionSetIdCode;
	}

	
	public void setST01_transactionSetIdCode(String sT01_transactionSetIdCode) {
		ST01_transactionSetIdCode = sT01_transactionSetIdCode;
	}

	
	public String getST02_transactionSetControlNumber() {
		return ST02_transactionSetControlNumber;
	}

	
	public void setST02_transactionSetControlNumber(String sT02_transactionSetControlNumber) {
		ST02_transactionSetControlNumber = sT02_transactionSetControlNumber;
	}


	public B10_BeginningSegment getB10_beginningSegment() {
		return B10_beginningSegment;
	}


	public void setB10_beginningSegment(B10_BeginningSegment b10_beginningSegment) {
		B10_beginningSegment = b10_beginningSegment;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ST01: " + ST01_transactionSetIdCode + ", ST02: " + ST02_transactionSetControlNumber ;
	}
	
}

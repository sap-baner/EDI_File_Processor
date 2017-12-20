package dao;

import java.util.ArrayList;
import java.util.List;

public class ST_TransactionSetHeader {

	
	private String ST01_transactionSetIdCode;
	
	private String ST02_transactionSetControlNumber;
	
	private B10_BeginningSegment B10_beginningSegment;
	private List<L11_ReferenceNumber> listL11_referenceNumber = new ArrayList<L11_ReferenceNumber>();
	private G62_DateTime G62_dateTime;
	
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

	public L11_ReferenceNumber getL11_referenceNumber(int index) {
		return listL11_referenceNumber.get(index);
	}


	public void addL11_referenceNumber(L11_ReferenceNumber l11_referenceNumber) {
		this.listL11_referenceNumber.add(l11_referenceNumber);
	}


	public G62_DateTime getG62_dateTime() {
		return G62_dateTime;
	}


	public void setG62_dateTime(G62_DateTime g62_dateTime) {
		G62_dateTime = g62_dateTime;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String op = "ST01: " + ST01_transactionSetIdCode + ", ST02: " + ST02_transactionSetControlNumber 
				+ ", B10: {" + B10_beginningSegment.toString() + "}"
				+ "\n" + ", L11 list size = " + listL11_referenceNumber.size();
		
		op = op + "\n" + "L11 list: {";
		for(L11_ReferenceNumber l11: listL11_referenceNumber) {
			op = op + "\n " + l11.toString();
		}
		op = op + "\n";
		return op;
				
	}
	
}

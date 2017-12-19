package dao;

import java.util.ArrayList;
import java.util.List;

public class ShipmentStatusMessage {
	private ISA_InterchangeControlHeader ISA_interchangControlHeader;
	private GS_FunctionalGroupHeader GS_functionalGroupHeader;
	private List<ST_TransactionSetHeader> listST_transactionSetHeader = new ArrayList<ST_TransactionSetHeader>();
	public ISA_InterchangeControlHeader getISA_interchangControlHeader() {
		return ISA_interchangControlHeader;
	}
	public void setISA_interchangControlHeader(
			ISA_InterchangeControlHeader iSA_interchangControlHeader) {
		ISA_interchangControlHeader = iSA_interchangControlHeader;
	}
	public GS_FunctionalGroupHeader getGS_functionalGroupHeader() {
		return GS_functionalGroupHeader;
	}
	public void setGS_functionalGroupHeader(
			GS_FunctionalGroupHeader gS_functionalGroupHeader) {
		GS_functionalGroupHeader = gS_functionalGroupHeader;
	}
	public ST_TransactionSetHeader getST_transactionSetHeader(int index) {
		return listST_transactionSetHeader.get(index);
	}
	public void addST_transactionSetHeader(
			ST_TransactionSetHeader ST_transactionSetHeader) {
		this.listST_transactionSetHeader.add(ST_transactionSetHeader);
	}
	
	public String toString() {
		String op =  "ISA: " + ISA_interchangControlHeader.toString() 
				+ "\n" + "GS: " + GS_functionalGroupHeader.toString()
				+ "\n" + "ST list length : " + listST_transactionSetHeader.size();
		op = op + "\n" + "ST list: {";
		for(ST_TransactionSetHeader st : listST_transactionSetHeader) {
			op = op + "\n" + "ST: " + st.toString() + ",";
		}
		op = op + "\n" + "}";
		return op;
	}
	
}

package com.ct.parser.strategy;

import java.lang.reflect.Method;
import java.util.Properties;

import dao.B10_BeginningSegment;
import dao.L11_ReferenceNumber;
import dao.ST_TransactionSetHeader;
import dao.ShipmentStatusMessage;

public class L11ParsingStrategy implements ParsingStrategy {
	
	String fieldName = null;
	@Override
	public ShipmentStatusMessage parse(Properties rules, String[] tokens, ShipmentStatusMessage msg) throws Exception {
		Class cls = ShipmentStatusMessage.class;
		Method method = null;
		String methodName = null;
		String mainToken = tokens[0];
		L11_ReferenceNumber thisPojo = null;
		for(int i=0;i<tokens.length;i++) {
			if(i==0) {
				fieldName = rules.getProperty(mainToken);
				cls = ST_TransactionSetHeader.class;
				ST_TransactionSetHeader stObj = msg.getST_transactionSetHeader_LastElement();
				methodName = "add" + fieldName;
				thisPojo = new L11_ReferenceNumber();
				Parser.involkeMethod(cls, stObj, methodName, L11_ReferenceNumber.class, thisPojo);
			} else {
				cls = L11_ReferenceNumber.class;
				fieldName = rules.getProperty(Parser.formPropertyKeyToLookFor(i, mainToken));
				methodName = "set" + fieldName;
				Parser.involkeMethod(cls, thisPojo, methodName, String.class, tokens[i]);
			}
		}
		
		return msg;
	}
}

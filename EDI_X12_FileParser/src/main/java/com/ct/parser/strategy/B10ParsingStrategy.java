package com.ct.parser.strategy;

import java.lang.reflect.Method;
import java.util.Properties;

import dao.B10_BeginningSegment;
import dao.ST_TransactionSetHeader;
import dao.ShipmentStatusMessage;

public class B10ParsingStrategy implements ParsingStrategy {
	
	String fieldName = null;
	@Override
	public ShipmentStatusMessage parse(Properties rules, String[] tokens, ShipmentStatusMessage msg) throws Exception {
		Class cls = ShipmentStatusMessage.class;
		Method method = null;
		String methodName = null;
		String mainToken = tokens[0];
		B10_BeginningSegment thisPojo = null;
		for(int i=0;i<tokens.length;i++) {
			if(i==0) {
				fieldName = rules.getProperty(mainToken);
				cls = ST_TransactionSetHeader.class;
				ST_TransactionSetHeader stObj = msg.getST_transactionSetHeader_LastElement();
				methodName = "set" + fieldName;
				thisPojo = new B10_BeginningSegment();
				Parser.involkeMethod(cls, stObj, methodName, B10_BeginningSegment.class, thisPojo);
			} else {
				cls = B10_BeginningSegment.class;
//				if(i<10) {
//					fieldName = rules.getProperty(mainToken + "0" + i + "");
//				} else {
//					fieldName = rules.getProperty(mainToken + i + "");
//				}	
				fieldName = rules.getProperty(Parser.formPropertyKeyToLookFor(i, mainToken));
				methodName = "set" + fieldName;
				Parser.involkeMethod(cls, thisPojo, methodName, String.class, tokens[i]);
			}
		}
		
		return msg;
	}
}

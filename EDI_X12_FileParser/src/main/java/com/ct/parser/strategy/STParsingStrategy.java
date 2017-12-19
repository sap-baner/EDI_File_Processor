package com.ct.parser.strategy;

import java.lang.reflect.Method;
import java.util.Properties;

import dao.ST_TransactionSetHeader;
import dao.ShipmentStatusMessage;

public class STParsingStrategy implements ParsingStrategy {
	
	String fieldName = null;
	@Override
	public ShipmentStatusMessage parse(Properties rules, String[] tokens, ShipmentStatusMessage msg) throws Exception {
		Class cls = ShipmentStatusMessage.class;
		Method method = null;
		String methodName = null;
		String mainToken = tokens[0];
		ST_TransactionSetHeader thisPojo = null;
		for(int i=0;i<tokens.length;i++) {
			if(i==0) {
				fieldName = rules.getProperty(mainToken);
				methodName = "add" + fieldName;
				thisPojo = new ST_TransactionSetHeader();
				Parser.involkeMethod(cls, msg, methodName, ST_TransactionSetHeader.class, thisPojo);
			} else {
				cls = ST_TransactionSetHeader.class;
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

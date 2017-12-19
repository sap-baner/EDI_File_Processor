package com.ct.parser.strategy;

import java.lang.reflect.Method;
import java.util.Properties;

import dao.ISA_InterchangeControlHeader;
import dao.ShipmentStatusMessage;

public class ISAParsingStrategy implements ParsingStrategy {
	
	String fieldName = null;
	@Override
	public ShipmentStatusMessage parse(Properties rules, String[] tokens, ShipmentStatusMessage msg) throws Exception {
		Class cls = ShipmentStatusMessage.class;
		Method method = null;
		String methodName = null;
		String mainToken = tokens[0];
		ISA_InterchangeControlHeader thisPojo = null;
		for(int i=0;i<tokens.length;i++) {
			if(i==0) {
				fieldName = rules.getProperty(mainToken);
				methodName = "set" + fieldName;
				thisPojo = new ISA_InterchangeControlHeader();
				Parser.involkeMethod(cls, msg, methodName, ISA_InterchangeControlHeader.class, thisPojo);
			} else {
				cls = ISA_InterchangeControlHeader.class;
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

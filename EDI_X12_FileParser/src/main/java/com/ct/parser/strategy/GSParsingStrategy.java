package com.ct.parser.strategy;

import java.lang.reflect.Method;
import java.util.Properties;

import dao.GS_FunctionalGroupHeader;
import dao.ShipmentStatusMessage;

public class GSParsingStrategy implements ParsingStrategy {
	
	String fieldName = null;
	@Override
	public ShipmentStatusMessage parse(Properties rules, String[] tokens, ShipmentStatusMessage msg) throws Exception {
		Class cls = ShipmentStatusMessage.class;
		Method method = null;
		String methodName = null;
		String mainToken = tokens[0];
		GS_FunctionalGroupHeader thisPojo = null;
		for(int i=0;i<tokens.length;i++) {
			if(i==0) {
				fieldName = rules.getProperty(mainToken);
				methodName = "set" + fieldName;
				thisPojo = new GS_FunctionalGroupHeader();
				Parser.involkeMethod(cls, msg, methodName, GS_FunctionalGroupHeader.class, thisPojo);
			} else {
				cls = GS_FunctionalGroupHeader.class;
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

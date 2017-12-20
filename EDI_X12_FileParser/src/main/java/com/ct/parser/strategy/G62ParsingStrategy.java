package com.ct.parser.strategy;

import java.lang.reflect.Method;
import java.util.Properties;

import dao.B10_BeginningSegment;
import dao.G62_DateTime;
import dao.ST_TransactionSetHeader;
import dao.ShipmentStatusMessage;

public class G62ParsingStrategy implements ParsingStrategy {
	
	String fieldName = null;
	@Override
	public ShipmentStatusMessage parse(Properties rules, String[] tokens, ShipmentStatusMessage msg) throws Exception {
		Class cls = ShipmentStatusMessage.class;
		Method method = null;
		String methodName = null;
		String mainToken = tokens[0];
		G62_DateTime thisPojo = null;
		for(int i=0;i<tokens.length;i++) {
			if(i==0) {
				fieldName = rules.getProperty(mainToken);
				cls = ST_TransactionSetHeader.class;
				ST_TransactionSetHeader stObj = msg.getST_transactionSetHeader_LastElement();
				methodName = "set" + fieldName;
				thisPojo = new G62_DateTime();
				Parser.involkeMethod(cls, stObj, methodName, G62_DateTime.class, thisPojo);
			} else {
				cls = G62_DateTime.class;
				fieldName = rules.getProperty(Parser.formPropertyKeyToLookFor(i, mainToken));
				methodName = "set" + fieldName;
				Parser.involkeMethod(cls, thisPojo, methodName, String.class, tokens[i]);
			}
		}
		
		return msg;
	}
}

package com.ct.parser.filereader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import dao.GS_FunctionalGroupHeader;
import dao.ISA_InterchangeControlHeader;
import dao.ST_TransactionSetHeader;
import dao.ShipmentStatusMessage;

public class FileParser {
	
	
	public static void parseDocument(Properties rules, String line, ShipmentStatusMessage msg) throws Exception{
		
//		System.out.println(line);
		String[] tokens = getTokens(line);
//		System.out.println("tokens: " + tokens); 
		String mainToken = tokens[0];
		FileParser.Parser parser = null;
		if("ISA".equals(mainToken)) {
			parser = new FileParser.Parser(new ISAParsingStrategy());
		}
		else if("GS".equals(mainToken)) {
			parser = new FileParser.Parser(new GSParsingStrategy());
		}
		else if("ST".equals(mainToken)) {
			parser = new FileParser.Parser(new STParsingStrategy());
		}
		if(parser!=null) {
			parser.parse(rules, tokens, msg);
		}
	}
	
	private static String[] getTokens(String line) {
		if(line==null) {
			line = "";
		}
		return line.split("~");
		 
	}
	
	private static class Parser {
		private ParsingStrategy parsingStrategy;
		
		public Parser(ParsingStrategy parsingStrategy) {
			this.parsingStrategy = parsingStrategy;
		}

		public ShipmentStatusMessage parse(Properties rules, String[] tokens, ShipmentStatusMessage msg) throws Exception{
			return parsingStrategy.parse(rules, tokens, msg);
		}
		
		public static void involkeMethod(Class involkingClass, Object involkingObj, String methodName, Class paramClass, Object paramObject) {
			try {
				Method method = involkingClass.getMethod(methodName, paramClass);
				method.invoke(involkingObj, paramObject);
			}catch(NoSuchMethodException e) {
				System.out.println(methodName + "() - this method is not found by reflection API");
			} catch (IllegalAccessException e) {
				
			} catch (IllegalArgumentException e) {
				
			} catch (InvocationTargetException e) {
				
			}
			
		}
	}
	
	private static interface ParsingStrategy {
		ShipmentStatusMessage parse(Properties rules, String[] tokens, ShipmentStatusMessage msg) throws Exception ;
	}
	
	private static class ISAParsingStrategy implements ParsingStrategy {
		
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
					if(i<10) {
						fieldName = rules.getProperty(mainToken + "0" + i + "");
					} else {
						fieldName = rules.getProperty(mainToken + i + "");
					}	
					methodName = "set" + fieldName;
					Parser.involkeMethod(cls, thisPojo, methodName, String.class, tokens[i]);
				}
			}
			
			return msg;
		}
	}
	
	private static class GSParsingStrategy implements ParsingStrategy {
		
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
					if(i<10) {
						fieldName = rules.getProperty(mainToken + "0" + i + "");
					} else {
						fieldName = rules.getProperty(mainToken + i + "");
					}	
					methodName = "set" + fieldName;
					Parser.involkeMethod(cls, thisPojo, methodName, String.class, tokens[i]);
				}
			}
			
			return msg;
		}
	}
	
	private static class STParsingStrategy implements ParsingStrategy {
		
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
					if(i<10) {
						fieldName = rules.getProperty(mainToken + "0" + i + "");
					} else {
						fieldName = rules.getProperty(mainToken + i + "");
					}	
					methodName = "set" + fieldName;
					Parser.involkeMethod(cls, thisPojo, methodName, String.class, tokens[i]);
				}
			}
			
			return msg;
		}
	}
}

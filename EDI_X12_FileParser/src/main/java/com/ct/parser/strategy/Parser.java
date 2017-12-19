package com.ct.parser.strategy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import dao.ShipmentStatusMessage;

public class Parser {
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
	
	public static String formPropertyKeyToLookFor(int index, String mainToken) {
		String key = null;
		if(index<10) {
			key = mainToken + "0" + index + "";
		} else {
			key = mainToken + index + "";
		}	
		return key;
	}
}

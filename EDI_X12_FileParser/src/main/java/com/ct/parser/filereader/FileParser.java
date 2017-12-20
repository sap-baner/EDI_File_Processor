package com.ct.parser.filereader;

import java.util.Properties;

import com.ct.parser.strategy.B10ParsingStrategy;
import com.ct.parser.strategy.G62ParsingStrategy;
import com.ct.parser.strategy.GSParsingStrategy;
import com.ct.parser.strategy.ISAParsingStrategy;
import com.ct.parser.strategy.L11ParsingStrategy;
import com.ct.parser.strategy.Parser;
import com.ct.parser.strategy.STParsingStrategy;

import dao.ShipmentStatusMessage;

public class FileParser {
	
	public static void parseDocument(Properties rules, String line, ShipmentStatusMessage msg) throws Exception{

		String[] tokens = getTokens(line);
		String mainToken = tokens[0];
		Parser parser = null;
		if("ISA".equals(mainToken)) {
			parser = new Parser(new ISAParsingStrategy());
		}
		else if("GS".equals(mainToken)) {
			parser = new Parser(new GSParsingStrategy());
		}
		else if("ST".equals(mainToken)) {
			parser = new Parser(new STParsingStrategy());
		}
		else if("B10".equals(mainToken)) {
			parser = new Parser(new B10ParsingStrategy());
		} 
		else if("L11".equals(mainToken)) {
			parser = new Parser(new L11ParsingStrategy());
		}
		else if("G62".equals(mainToken)) {
			parser = new Parser(new G62ParsingStrategy());
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
	
	
}

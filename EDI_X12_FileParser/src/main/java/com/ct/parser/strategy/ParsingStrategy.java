package com.ct.parser.strategy;

import java.util.Properties;

import dao.ShipmentStatusMessage;

public interface ParsingStrategy {
	ShipmentStatusMessage parse(Properties rules, String[] tokens, ShipmentStatusMessage msg) throws Exception ;
}

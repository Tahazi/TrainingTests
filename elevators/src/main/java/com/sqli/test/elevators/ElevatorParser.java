package com.sqli.test.elevators;

import java.util.LinkedHashMap;

public class ElevatorParser {
	private static final String SPLITER = ":";
	private static final Integer ID_INDEX = 0;
	private static final Integer FLOOR_INDEX = 1;

	public LinkedHashMap<String, Elevator> parse(String[] elevators) {
		LinkedHashMap<String, Elevator> elevatorsMap = new LinkedHashMap<>();
		for (String elevator : elevators) {
			elevatorsMap.put(parseId(elevator), parseFloor(elevator));
		}
		return elevatorsMap;
	}

	private Elevator parseFloor(String elevator) {
		return new Elevator(Integer.parseInt(elevator.split(SPLITER)[FLOOR_INDEX]));
	}

	private String parseId(String elevator) {
		return elevator.split(SPLITER)[ID_INDEX];
	}
}

package com.sqli.test.elevators;

public class DirectionParser {

	public Direction parse(String direction) {
		switch (direction) {
		case "UP" :
			return Direction.UP;
		case "DOWN":
			return Direction.DOWN;
		default : throw new IllegalArgumentException("Unexisting Direction");
		}
	}

}

package com.sqli.test.elevators;

public class Elevator {
	private Integer currentFloor;
	private Direction direction;
	
	public Elevator(Integer currentFloor) {
		super();
		this.currentFloor = currentFloor;
		this.direction = Direction.RESTING;
	}

	public Integer getDistanceFrom(Integer floorRequested, int numberOfFloors) {
		if(isAboveAndUP(floorRequested)) return (numberOfFloors * 2 - floorRequested - currentFloor);
		if(isAboveAndDownOrResting(floorRequested)) return currentFloor - floorRequested  ;
		if(isBelowAndDown(floorRequested)) return  currentFloor + floorRequested;
		if(isBelowAndUpOrResting(floorRequested)) return  floorRequested - currentFloor;
		throw new IllegalArgumentException("this case doesn't exist");
	}


	private boolean isBelowAndUpOrResting(Integer floorRequested) {
		return (currentFloor < floorRequested && (direction == Direction.UP || direction == Direction.RESTING) ) ;
	}

	private boolean isBelowAndDown(int floorRequested) {
		return (currentFloor < floorRequested && direction == Direction.DOWN );
	}

	private boolean isAboveAndDownOrResting(int floorRequested) {
		return (currentFloor > floorRequested && (direction == Direction.DOWN || direction == Direction.RESTING));
	}

	private boolean isAboveAndUP(int floorRequested) {
		return (currentFloor > floorRequested && direction == Direction.UP);
	}

	public void changeDirection(Direction direction) {
		this.direction = direction;
	}
	
	public boolean isDirectionStopped() {
		return this.direction==Direction.STOPPED ;
	}
	
	public void stopAt(Integer floor) {
		this.currentFloor = floor;
		this.direction = Direction.STOPPED;
	}

}

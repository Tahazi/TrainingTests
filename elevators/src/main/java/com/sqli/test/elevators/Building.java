package com.sqli.test.elevators;

import java.util.LinkedHashMap;
import java.util.Map;

public class Building {
	private int numberOfFloors;
	private LinkedHashMap<String,Elevator> elevatorByFloor;
	private ElevatorParser elevatorParser;
	private DirectionParser directionParser;

    /**
     * @param numberOfFloors: the number of floors in the building
     * @param elevators: an array of descriptions of the elevators of the building. 
     *                   A description has the following format "[elevator_id]:[elevator_current_floor]".
     */
    public Building(int numberOfFloors, String... elevators) {
    		this.elevatorParser = new ElevatorParser();
		this.directionParser = new DirectionParser();
		this.elevatorByFloor = elevatorParser.parse(elevators);
		this.numberOfFloors = numberOfFloors;
    }

    /**
     * Request an elevator at floor zero.
     * @return the id of the elevator that should serve the request.
     */
    public String requestElevator() {
    		int defaultRequestedFloor = numberOfFloors;
		return this.requestElevator(defaultRequestedFloor);
    }

    /**
     * Request an elevator at floor indicate by the {@code floor} param.
     * @param floor : the floor where the request is made.
     * @return the id of the elevator that should serve the request.
     */
    public String requestElevator(int floor) {
    	Integer maximumDistance = 2*numberOfFloors; // The longest distance is equal the maximal course back and forth
		Integer shortestDistance = maximumDistance;
		String elevatorId= this.elevatorByFloor.keySet().stream().findFirst().get();
		for (Map.Entry<String, Elevator> elevator : elevatorByFloor.entrySet()) {
			if(elevator.getValue().isDirectionStopped()) continue;
			Integer distance = elevator.getValue().getDistanceFrom(floor,numberOfFloors);
			if(distance< shortestDistance ) {
				shortestDistance = distance;
				elevatorId = elevator.getKey();
			}
		}
		return elevatorId;
    }

    /**
     * Request the elevator with the id {@code elevatorId} to stop at the floor indicated by the {@code floor} param.
     * @param elevatorId : the id of the elevator to whom give the order.
     * @param floor : the floor at which the elevator should stop
     */
    public void stopAt(String elevatorId, int floor) {
    		elevatorByFloor.get(elevatorId).stopAt(floor);
    }

    /**
     * Move the elevator with the id {@code elevatorId} in the direction indicated by the {@code direction} param.
     * @param elevatorId : the id of the elevator to move.
     * @param direction : the direction to go. Can be "UP" or "DOWN".
     */
    public void move(String elevatorId, String direction) {
    	this.elevatorByFloor.get(elevatorId).changeDirection(this.directionParser.parse(direction));
    }

}

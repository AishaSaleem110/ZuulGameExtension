package zuul.Enums;

/**
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * This class represents Enumerated Types for the Directions/Exits for a Room within the zuul game application
 * *
 *
 * @author Aisha Saleem
 * @version 2021.10.25
 */

public enum Direction {

    NORTH("north"),
    EAST("east"),
    SOUTH("south"),
    WEST("west"),
    UNKNOWN("?");

    private String directionString;

    Direction(String directionString) {

        this.directionString = directionString;

    }

    public static Direction getDirectionEnum(String directionString) {
        for (Direction direction : Direction.values()) {
            if (direction.toString().equals(directionString)) {
                return direction;
            }
        }
        return Direction.UNKNOWN;
    }

    @Override
    public String toString() {
        return directionString;
    }

}

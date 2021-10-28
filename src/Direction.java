import java.util.HashMap;

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

    @Override
    public String toString() {
        return directionString;
    }


    public static Direction getDirectionEnum(String directionString) {
        for (Direction direction : Direction.values()) {
            if (direction.toString().equals(directionString)) {
                return direction;
            }
        }
        return Direction.UNKNOWN;
    }

}

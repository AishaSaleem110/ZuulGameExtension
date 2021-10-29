package zuul;

public class ComputerControlledPlayer extends Player {

    public ComputerControlledPlayer(Room currentRoom, int playerId) {
        super(currentRoom, playerId);
    }

    @Override
    String move(Direction direction) {
        return null;
    }

    @Override
    String look() {
        return null;
    }

    @Override
    String take(String item) {
        return null;
    }

    @Override
    String drop(String item) {
        return null;
    }

    @Override
    String give(String item, String whom) {
        return null;
    }
}

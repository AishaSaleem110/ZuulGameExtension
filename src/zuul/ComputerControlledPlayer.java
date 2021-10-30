package zuul;

public class ComputerControlledPlayer extends Player {

    public ComputerControlledPlayer(Room currentRoom, int playerId) {
        super(currentRoom, playerId);
    }

    @Override
    public String move(Direction direction) {
        return null;
    }

    @Override
    public String look() {
        return null;
    }

    @Override
    public String take(String item) {
        return null;
    }

    @Override
    public String drop(String item) {
        return null;
    }

    @Override
    public String give(String item, String whom) {
        return null;
    }
}

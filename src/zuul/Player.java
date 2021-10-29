package zuul;

public abstract class Player {
    Room currentRoom;
    int playerId;

    public Player() {
    }

    public Player(Room currentRoom, int playerId) {
        this.currentRoom = currentRoom;
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }


    public String getPlayerLocationInfo() {

        StringBuilder locationString=new StringBuilder();
        return locationString.append("Player")
                .append(getPlayerId())
                .append(System.lineSeparator())
                .append(getCurrentRoom().toString()).toString();
    }

    abstract String move(Direction direction);
    abstract String look();
    abstract String take(String itemDesc);
    abstract String drop(String itemDesc);
    abstract String give(String itemDesc, String whom);




}

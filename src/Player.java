public abstract class Player {
    Room currentRoom;
    int playerId;
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


   abstract String move(Direction direction);
    abstract String look();
    abstract String take(String itemDesc);
    abstract String drop(String itemDesc);
    abstract String give(String itemDesc, String whom);


}

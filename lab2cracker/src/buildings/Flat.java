package buildings;

public class Flat {
    private float space;
    private int rooms;

    public Flat() {
        this.space = 50;
        this.rooms = 2;
    }

    public Flat(float space) {
        this.space = space;
        this.rooms = 2;
    }

    public Flat(float space, int rooms) {
        this.space = space;
        this.rooms = rooms;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public float getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }
}
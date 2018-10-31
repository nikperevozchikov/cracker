package buildings;

public class Flat {
    private float space;
    private int roomsCount;
    private static final float DEFAULT_SPACE = 50;
    private static final int DEFAULT_ROOMSCOUNT = 2;

    public Flat() {
        this(DEFAULT_ROOMSCOUNT, DEFAULT_SPACE);

    }

    public Flat(float space) {
        this(DEFAULT_ROOMSCOUNT, space);
    }

    public Flat( int roomsCount, float space) {
        this.space = space;
        this.roomsCount = roomsCount;
    }
    @Override
    public String toString() {
        StringBuffer st = new StringBuffer();
        st.append("roomsCount: ").append(roomsCount).append(" ");
        st.append("space: ").append(space);
        System.out.println();
        return st.toString();}

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public float getSpace() {
        return space;
    }

    public void setSpace(float space) {
        this.space = space;
    }



}
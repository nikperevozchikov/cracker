package buildings;

public class Flat {
    private float space;
    private int roomsCount; //todo roomsСount более полно отражает суть
    private static final float DEFAULT_SPACE = 50;
    private static final int DEFAULT_ROOMSCOUNT = 2;

    //todo не нужно доблировать код в конструкторах. Стандартное правило - конструктор с меньшим числом параметров вызывает конструктор с большим числом параметров
    public Flat() {
        this(DEFAULT_ROOMSCOUNT, DEFAULT_SPACE); //todo литералы в коде - отстой. Вынеси 50 и 2 в константы класса и дай им нормальные имена.

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
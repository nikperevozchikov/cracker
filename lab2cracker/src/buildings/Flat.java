package buildings;

public class Flat {
    private float space;
    private int rooms; //todo roomsСount более полно отражает суть

    //todo не нужно доблировать код в конструкторах. Стандартное правило - конструктор с меньшим числом параметров вызывает конструктор с большим числом параметров
    public Flat() {
        this.space = 50; //todo литералы в коде - отстой. Вынеси 50 и 2 в константы класса и дай им нормальные имена.
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
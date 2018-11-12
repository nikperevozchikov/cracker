package buildings;


public class DwellingFloor {
    private int size;
    private Flat flats[];

    public DwellingFloor(int size) {
        flats = new Flat[size];

    }

    public DwellingFloor(Flat[] flats) {
        this.flats = new Flat[flats.length];
        for (int i = 0; i < flats.length; i++) {
            if (flats[i] != null) {
                this.flats[size] = flats[i];
                size++;
            }
        }
    }
    public int getSize()                  //количество квартир на этаже
    {
        return size;
    }
    public float totalSpace()                    //общая площадь квартир этажа
    {
        float sum4 = 0; //todo имя локальной переменной, значение которой возвращается в качестве результата работы функции обычно такое-же как имя функции
        for (int i = 0; i < size; i++)
            sum4 += flats[i].getSpace();

        return sum4;
    }
    public int roomsCountTotal()                //общее количество комнат этажа
    {
        int sum5 = flats[0].getRoomsCount(); //todo имя локальной переменной, значение которой возвращается в качестве результата работы функции обычно такое-же как имя функции
        for (int i = 1; i < size; i++) {
            sum5 += flats[i].getRoomsCount();
        }
        return sum5;
    }

    public Flat[] getFlats()                //метод получения массива квартир этажа
    {
        return flats;
    }

    public Flat getFlat(int number)                //метод получения объекта квартиры по номеру на этаже
    {
        return flats[number];
    }

    public void setFlat(int number, Flat newFlat)        //метод изменения квартиры по ее номеру на этаже
    {
        flats[number] = newFlat;
    }
    private Flat[] expandFlats() {
        Flat[] newFlats = new Flat[flats.length * 2];
        System.arraycopy(flats, 0, newFlats, 0, flats.length);
        //for (int i = 0; i < flats.length; i++ ) {
          //  newFlats[i] = flats[i];
        //}
        return newFlats;

    }

    public void addFlat(int number, Flat Flat) {
        if (number > 0 && number < size) {
            if (size == flats.length) {
                flats = expandFlats();
            }
            System.arraycopy(flats, number, flats, number + 1, size - number);
            flats[number] = Flat;
            size++;
        }
    }
    public void delFlat(int number) {
        if ( number >= 0&& number < size) {
            System.arraycopy(flats, number + 1, flats, number, size - number - 1);
            size--;
            flats[size] = null;
        }
    }

   /* public void addFlat(int number, Flat flat)        //добавление новой  квартиры на этаже
    {
        if (number > flats.length) {
            Flat tmp[] = new Flat[number];
            for (int i = 0; i < flats.length; i++) {
                tmp[i] = new Flat();
            }
            for (int i = 0; i < flats.length; i++) {
                tmp[i] = flats[i];
            }
            tmp[number - 1] = flat;
            flats = tmp;
        } else {
            Flat tmp[] = new Flat[flats.length + 1];
            if (number == 0) {
                tmp[number] = flat;
                for (int i = 0; i < flats.length; i++) {
                    tmp[i + 1] = flats[i];
                }
            } else {
                for (int i = 0; i < number; i++) {
                    tmp[i] = flats[i];
                }
                tmp[number] = flat;
                for (int i = number + 1; i < tmp.length; i++) {
                    tmp[i] = flats[i];
                }
            }
            flats = tmp;
        }
    }*/

   /* public void delFlat(int number)            //удаление квартиры по номеру на этаже
    {
        Flat tmp[] = new Flat[flats.length - 1];
        if (number == 0) {
            for (int i = 0; i < flats.length - 1; i++) {
                tmp[i] = flats[i + 1];
            }
        } else {
            for (int i = 0; i < number; i++) {
                tmp[i] = flats[i];
            }
            for (int i = number; i < tmp.length; i++) {
                tmp[i] = flats[i + 1];
            }
        }
        flats = tmp;
    }*/

    public Flat getBestSpace()            //наибольшая кватира по площади на этаже
    {
        Flat maxspace = flats[0]; //todo имя локальной переменной, значение которой возвращается в качестве результата работы функции обычно такое-же как имя функции
        for (int i = 0; i < size; i++) {
            if (maxspace.getSpace() < flats[i].getSpace())
                maxspace = flats[i];
        }
        return maxspace;
    }
}

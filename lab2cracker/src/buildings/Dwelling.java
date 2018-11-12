package buildings;


public class Dwelling {
    private DwellingFloor[] floors;
    private int size;

    public Dwelling(int countFloors, int[] countFlats) {
        if (countFloors == countFlats.length) {
            floors = new DwellingFloor[countFloors];
            for (int i = 0; i < floors.length; i++) {
                floors[i] = new DwellingFloor(countFlats[i]);
            }
        }
    }
    public Dwelling(DwellingFloor[] floors) {
        this.floors = new DwellingFloor[floors.length];
        for (int i = 0; i < floors.length; i++) {
            if (floors[i] != null) {
                this.floors[size] = floors[i];
                size++;
            }
        }
    }
    public int getSize()        //общее количество этажей дома
    {
        return size;
    }
    public int flatsCountTotal()   // общее количество квартир дома
    {
        int sum1 = 0;
        for (int i = 0; i < size; i++) {
            sum1 += floors[i].getSize();
        }
        return sum1;
    }
    public float totalSpace() // общая площадь квартир дома
    {
        float sum2 = 0; //todo имя локальной переменной, значение которой возвращается в качестве результата работы функции обычно такое-же как имя функции
        for (int i = 0; i < size; i++) {
            sum2 += floors[i].totalSpace();
        }
        return sum2;
    }
    public int roomsCountTotal()    //общее количество комнат дома
    {
        int sum3 = 0; //todo имя локальной переменной, значение которой возвращается в качестве результата работы функции обычно такое-же как имя функции
        for (int i = 0; i < size; i++) {
           sum3 += floors[i].roomsCountTotal();
        }
        return sum3;
    }

    public DwellingFloor[] getFloors()  //получение массива этажей дома
    {
        return floors;
    }

    public DwellingFloor getFloor(int number)   //получение объекта этажа по номеру в доме
    {
        return floors[number];
    }

    public void setFloor(int number, DwellingFloor floor)  //изменение этажа по номеру в доме
    {
        this.floors[number] = floor;
    }

    private DwellingFloorFlatNumberDTO getDwellingFloorFlatNumber(int number) {
        int numFlat = 0;
        for (int i = 0; i < size; i++) {
            if (numFlat <= number && number < numFlat + floors[i].getSize()) {
                return new DwellingFloorFlatNumberDTO(i, number - numFlat);
            }
            numFlat += floors[i].getSize();
        }
        return null;
    }

    public Flat getFlat(int number) {
        DwellingFloorFlatNumberDTO dwellingFloorFlatNumber = getDwellingFloorFlatNumber(number);
        return floors[dwellingFloorFlatNumber.numberFloor].getFlat(dwellingFloorFlatNumber.numberFlat);
    }

    public void setFlat(int number, Flat flat) {
        DwellingFloorFlatNumberDTO dwellingFloorFlatNumber = getDwellingFloorFlatNumber(number);
        floors[dwellingFloorFlatNumber.numberFloor].setFlat(dwellingFloorFlatNumber.numberFlat, flat);
    }

    public void addFlat(int number, Flat fFlat) {
        DwellingFloorFlatNumberDTO dwellingFloorFlatNumber = getDwellingFloorFlatNumber(number);
        floors[dwellingFloorFlatNumber.numberFloor].addFlat(dwellingFloorFlatNumber.numberFlat, fFlat);
    }

    public void delFlat(int number) {
        DwellingFloorFlatNumberDTO dwellingFloorFlatNumber = getDwellingFloorFlatNumber(number);
        floors[dwellingFloorFlatNumber.numberFloor].delFlat(dwellingFloorFlatNumber.numberFlat);
    }


   /* public Flat getGlobalFlat(int number)    //получение объекта квартиры по номеру в доме
    {
        int dwel = 0;
        for (int i = 0; i < floors.length; i++) {
            for (int j = 0; j < floors[i].getCntRooms(); j++) {
                if (number == (dwel + j)) {
                    return floors[i].getFlat(j);
                }

            }
            dwel += floors[i].getCntRooms();
        }
        return null;

    }

    public void setGlobalFlat(int number, Flat flat)        //метод изменения объекта квартиры по ее номеру в доме и ссылке типа квартиры
    {
        int dwel = 0;
        for (int i = 0; i < floors.length; i++) {
            for (int j = 0; j < floors[i].getCntRooms(); j++) {
                if (number == (dwel + j)) {
                    flat = floors[i].getFlat(j);
                }
            }
            dwel += floors[i].getCntRooms();
        }

    }*/

   /* public void addFlatGlobal(int number, Flat flat)        //добавление квартиры по будущему номеру и ссылке на квартиру
    {
        int dwel = 0;
        for (int i = 0; i < floors.length; i++) {
            for (int j = 0; j < floors[i].getCntRooms(); j++) {
                if (number == (dwel + j)) {
                    this.floors[i].addFlat(j, flat);
                }

            }
            dwel += floors[i].getCntRooms();
        }
    }

    public void delFlatGlobal(int number)   //удалелние квартиры по номеру в доме
    {
        int dwel = 0;
        for (int i = 0; i < floors.length; i++) {
            for (int j = 0; j < floors[i].getCntRooms(); j++) {
                if (number == (dwel + j)) {
                    this.floors[i].delFlat(j);
                }

            }
            dwel += floors[i].getCntRooms();
        }
    }*/

    public Flat getBestSpace()                    //самая большая площадь по всему дому
    {
        Flat maxmaxspace = floors[0].getBestSpace(); //todo имя локальной переменной, значение которой возвращается в качестве результата работы функции обычно такое-же как имя функции
        for (int i = 0; i < size; i++) {
            Flat fl = floors[i].getBestSpace(); //todo не fl а currentBestSpace
            if (maxmaxspace.getSpace() < fl.getSpace())
                maxmaxspace = fl;
        }
        return maxmaxspace;
    }
    public Flat[] SortFlat() {
        Flat tmp[] = new Flat[flatsCountTotal()]; //todo не tmp а flats
        int index=0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < floors[i].getSize(); j++) {
                tmp[index] = floors[i].getFlat(j);
                index++;
            }
        }
        for (int i = 0; i < tmp.length; i++)
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[i].getSpace() < tmp[j].getSpace()) {
                    Flat tmp_f = tmp[i];
                    tmp[i] = tmp[j];
                    tmp[j] = tmp_f;
                }

            }
        return tmp;
    }


}
package buildings;


public class Dwelling {
    private DwellingFloor[] floors;
    private int size;

    public Dwelling(int countFloors, int[] countFlats) {
        if (countFloors == countFlats.length) {
            floors = new DwellingFloor[countFloors];

        }
    }

    public Dwelling(DwellingFloor[] dfloors) {
        floors = new DwellingFloor[dfloors.length];
        for (int i = 0; i < floors.length; i++) {
            if (dfloors[i] != null) {
                floors[size] = dfloors[i];
                size++;
            }
        }
    }

    public int getCountFloors()        //общее количество этажей дома
    {
        return size;
    }

    public int getAllFlatsCount()   // общее количество квартир дома
    {
        int allcountflats = 0;
        for (int i = 0; i < size; i++) {
            allcountflats += floors[i].getSize();
        }
        return allcountflats;
    }

    public float getAllFlatsSpace() // общая площадь квартир дома
    {
        float allcountflatsspace = 0;
        for (int i = 0; i < size; i++) {
            allcountflatsspace += floors[i].getSpace();
        }
        return allcountflatsspace;
    }

    public int getAllRooms()    //общее количество комнат дома
    {
        int allcountrooms = 0;
        for (int i = 0; i < size; i++) {
            allcountrooms += floors[i].getCntRooms();
        }
        return allcountrooms;
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
        Flat maxmaxspace = floors[0].getBestSpace();
        for (int i = 0; i < size; i++) {
            if (maxmaxspace.getSpace() < floors[i].getBestSpace().getSpace())
                maxmaxspace = floors[i].getBestSpace();
        }
        return maxmaxspace;
    }

    public Flat[] getSortFlat() {
        Flat tmp[] = new Flat[getAllFlatsCount()];
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
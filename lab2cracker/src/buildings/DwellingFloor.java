package buildings;



public class DwellingFloor {

    private Flat flats[];

    public DwellingFloor(int count)
    {
        flats = new Flat[count];
        for(int i=0; i<count; i++)
        {
            flats[i] = new Flat();
        }
    }

    public DwellingFloor(Flat[] flats)
    {
        this.flats = new Flat[flats.length];
        for(int i=0; i<flats.length; i++)
        {
            this.flats[i]=flats[i];
        }
    }

    public int getCount()                  //количество квартир на этаже
    {
        return flats.length;
    }

    public float getSpace()					//общая площадь квартир этажа
    {
        float allspace = 0;
        for (int i=0; i<flats.length; i++)
        {
            allspace+=flats[i].getSpace();
        }
        return allspace;
    }

    public int getCntRooms()				//общее количество комнат этажа
    {
        int allrooms = flats[0].getRooms();
        for (int i=1; i<flats.length; i++)
        {
            allrooms+=flats[i].getRooms();
        }
        return allrooms;
    }

    public Flat[] getFlats()				//метод получения массива квартир этажа
    {
        return flats;
    }

    public Flat getFlat(int number)				//метод получения объекта квартиры по номеру на этаже
    {
        return flats[number];
    }

    public void setFlat(int number, Flat flat)		//метод изменения квартиры по ее номеру на этаже
    {
        this.flats[number] = flat;
    }

    public void addFlat(int number, Flat flat)		//добавление новой  квартиры на этаже
    {
        if(number>flats.length) {
            Flat tmp[]= new Flat[number];
            for(int i=0; i<flats.length; i++)
            {
                tmp[i] = new Flat();
            }
            for(int i=0; i<flats.length; i++)
            {
                tmp[i] = flats[i];
            }
            tmp[number-1] = flat;
            flats = tmp;
        }
        else
        {
            Flat tmp[]= new Flat[flats.length + 1];
            if(number == 0) {
                tmp[number] = flat;
                for (int i = 0; i < flats.length; i++) {
                    tmp[i+1] = flats[i];
                }
            }
            else {
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
    }

    public void delFlat(int number)			//удаление квартиры по номеру на этаже
    {
        Flat tmp[] = new Flat[flats.length - 1];
        if(number==0)
        {
            for(int i = 0; i<flats.length-1; i++)
            {
                tmp[i]= flats[i+1];
            }
        }
        else
        {
            for(int i = 0; i < number; i++) {
                tmp[i] = flats[i];
            }
            for(int i = number; i < tmp.length; i++) {
                tmp[i] = flats[i+1];
            }
        }
        flats = tmp;
    }

    public Flat getBestSpace()			//наибольшая кватира по площади на этаже
    {
        Flat maxspace = flats[0];
        for (int i = 1; i<flats.length; i++)
        {
            if (maxspace.getSpace() < flats[i].getSpace())
                maxspace = flats[i];
        }
        return maxspace;
    }
}

package buildings;


public class Dwelling
{
    private DwellingFloor floors[];

    public Dwelling(int countFloors, DwellingFloor[] floor )
    {
        floors = new DwellingFloor[countFloors];
        for (int i=0; i<countFloors; i++)
        {
            floors[i] = floor[i];
        }
    }

    public Dwelling(DwellingFloor[] floors)
    {
        this.floors = new DwellingFloor[floors.length];
        for	(int i = 0; i< floors.length; i++)
        {
            this.floors[i] = floors[i];
        }
    }

    public int getCountFloors()		//общее количество этажей дома
    {
        return floors.length;
    }

    public int getAllFlatsCount()   // общее количество квартир дома
    {
        int allcountflats = 0;
        for(int i=0; i<floors.length; i++)
        {
            allcountflats+=floors[i].getCount();
        }
        return allcountflats;
    }

    public float getAllFlatsSpace() // общая площадь квартир дома
    {
        float allcountflatsspace = 0;
        for(int i=0; i<floors.length; i++)
        {
            allcountflatsspace+=floors[i].getSpace();
        }
        return allcountflatsspace;
    }

    public int getAllRooms()  	//общее количество комнат дома
    {
        int allcountrooms = 0;
        for(int i=0; i<floors.length; i++)
        {
            allcountrooms+=floors[i].getCntRooms();
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

    public void setFloor (int number, DwellingFloor floor)  //изменение этажа по номеру в доме
    {
        this.floors[number] = floor;
    }

    public Flat getGlobalFlat(int number)    //получение объекта квартиры по номеру в доме
    {
        int dwel = 0;
        for(int i=0; i<floors.length; i++)
        {
            for(int j=0; j<floors[i].getCntRooms(); j++)
            {
                if (number==(dwel+j))
                {
                    return floors[i].getFlat(j);
                }

            }
            dwel+=floors[i].getCntRooms();
        }
        return null;

    }

    public void setGlobalFlat(int number, Flat flat)  		//метод изменения объекта квартиры по ее номеру в доме и ссылке типа квартиры
    {
        int dwel = 0;
        for(int i=0; i<floors.length; i++)
        {
            for(int j=0; j<floors[i].getCntRooms(); j++)
            {
                if (number==(dwel+j))
                {
                    flat = floors[i].getFlat(j);
                }
            }
            dwel+=floors[i].getCntRooms();
        }

    }

    public void addFlatGlobal (int number, Flat flat) 		//добавление квартиры по будущему номеру и ссылке на квартиру
    {
        int dwel = 0;
        for(int i=0; i<floors.length; i++)
        {
            for(int j=0; j<floors[i].getCntRooms(); j++)
            {
                if (number==(dwel+j))
                {
                    this.floors[i].addFlat(j, flat);
                }

            }
            dwel+=floors[i].getCntRooms();
        }
    }

    public void delFlatGlobal (int number)   //удалелние квартиры по номеру в доме
    {
        int dwel = 0;
        for(int i=0; i<floors.length; i++)
        {
            for(int j=0; j<floors[i].getCntRooms(); j++)
            {
                if (number==(dwel+j))
                {
                    this.floors[i].delFlat(j);
                }

            }
            dwel+=floors[i].getCntRooms();
        }
    }

    public Flat getBestSpace()					//самая большая площадь по всему дому
    {
        Flat maxmaxspace = floors[0].getBestSpace();
        for(int i = 1; i<floors.length; i++)
        {
            if(maxmaxspace.getSpace()<floors[i].getBestSpace().getSpace())
                maxmaxspace = floors[i].getBestSpace();
        }
        return maxmaxspace;
    }

    public Flat[] getSortFlat()
    {
        Flat tmp[] = new Flat[this.getAllFlatsCount()];
        for(int i =0; i<tmp.length; i++)
        {
            tmp[i] = this.getGlobalFlat(i);
        }
        for(int i=0; i<tmp.length; i++)
            for(int j=0; j<tmp.length-1; j++)
            {
                if(tmp[j].getSpace()<tmp[j+1].getSpace())
                {
                    Flat tmp_f = tmp[j];
                    tmp[j] = tmp[j+1];
                    tmp[j+1] = tmp_f;
                }

            }
        return tmp;
    }







}

package buildings;

public class Main
{
    public static void main (String [] arg)
    {

        DwellingFloor[] floors = new DwellingFloor[10];

        for(int i=0; i<floors.length; i++)
        {
            Flat flats[] = new Flat[1+i];
            for(int j = 0; j<flats.length; j++)
            {
                flats[j] = new Flat(i*j+15, i*j+1);
            }
            floors[i] = new DwellingFloor(flats);
        }

        Dwelling dwelling = new Dwelling(floors);
        Flat flat_max = new Flat(999999, 44);
        System.out.println("Max area "+dwelling.getBestSpace().getSpace());
        dwelling.addFlatGlobal (1, flat_max);
        System.out.println("Max area "+dwelling.getBestSpace().getSpace());



    }
}

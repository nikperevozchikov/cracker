
package buildings;

public class Main {

    public static void main(String[] arg) {
        Flat[] flats = new Flat[3];
        flats[0] = new Flat();
        flats[0].setSpace(150);
        flats[1] = new Flat();
        flats[2] = new Flat();
        flats[2].setSpace(190);

        DwellingFloor floor = new DwellingFloor(flats);
        floor.addFlat(0, new Flat());
        floor.addFlat(1, new Flat());
       System.out.println(floor.totalSpace());
        System.out.println(floor.roomsCountTotal());
        Flat[] flatss = new Flat[3];
        flatss[0] = new Flat(1, 20);
        flatss[1] = new Flat(2, 60);
        DwellingFloor floorr = new DwellingFloor(flatss);
        DwellingFloor[] floors = new DwellingFloor[3];
        floors[0] = floor;
        floors[1] = floorr;

        Dwelling dwelling = new Dwelling(floors);
        dwelling.addFlat(5, new Flat(4, 160));
        dwelling.delFlat(3);
        System.out.println(dwelling.FlatsCountTotal());
        System.out.println(dwelling.roomsCountTotal());
        System.out.println(dwelling.totalSpace());

        System.out.println(dwelling.getBestSpace());


        System.out.println(floor.getBestSpace());

        System.out.println(dwelling.getFlat(3));
        Flat[] flatsss = dwelling.SortFlat();
        for (int i = 0; i < flatsss.length; i++)
            System.out.println(flatsss[i]);

         /*DwellingFloor[] floors = new DwellingFloor[10];
        for (int i = 0; i < floors.length; i++) {
            Flat flats[] = new Flat[1 + i];
            for (int j = 0; j < flats.length; j++) {
                flats[j] = new Flat(i * j + 15, i * j + 1);
            }
            floors[i] = new DwellingFloor(flats);
        }

        Dwelling dwelling = new Dwelling(floors);
        Flat flat_max = new Flat(999999, 44);
        //System.out.println("Max area " + dwelling.getBestSpace().getSpace());
        dwelling.addFlat(1, flat_max);
        System.out.println("Max area " + dwelling.getBestSpace().getSpace());*/


    }
}

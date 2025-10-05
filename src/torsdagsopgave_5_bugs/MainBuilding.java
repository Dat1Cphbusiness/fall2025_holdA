package torsdagsopgave_5_bugs;

import java.util.ArrayList;

public class MainBuilding {

    public static void main(String[] args) {
        Room room1 = new Room(3, 2);
        Room room2 = new Room(5, 4);
        Room room3 = new Room(2, 1);

        ArrayList<Room> roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);

        Building building = new Building(roomList, 2);

        System.out.println("Total lamps: " + countLampsInBuilding(building));
        System.out.println("Total windows: " + countWindowsInBuilding(building));
        System.out.println("Total rooms: " + countRoomsInBuilding(building));
        System.out.println("Is normal building: " + isNormal(building));

        Building abnormalBuilding = new Building(roomList, 5);
        System.out.println("Is abnormal building normal: " + isNormal(abnormalBuilding));
    }

    public static int countLampsInBuilding(Building building) {
        int totalLamps = 0;
        for (int i = 0; i < building.getRooms().size(); i++) {
            totalLamps += building.getRooms().get(i).getNumberOfLamps();
        }
        return totalLamps;
    }

    public static int countWindowsInBuilding(Building building) {
        int totalWindows = 0;
        for (Room room : building.getRooms()) {
            totalWindows += room.getNumberOfWindows();
        }
        return totalWindows;
    }

    public static int countRoomsInBuilding(Building building) {
        int count = 0;
        for (Room room : building.getRooms()) {
            count++;
        }
        return count;
    }

    public static boolean isNormal(Building building) {
        if (building.getNumberOfFloors() <= building.getRooms().size()) {
            return true;
        } else {
            return false;
        }
    }
}
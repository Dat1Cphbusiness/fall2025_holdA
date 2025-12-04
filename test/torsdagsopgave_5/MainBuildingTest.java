package torsdagsopgave_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainBuildingTest {

    Building building;

    @BeforeEach
    public void setUp(){
        Room room1 = new Room(3, 2);
        Room room2 = new Room(5, 4);
        Room room3 = new Room(2, 1);

        ArrayList<Room> roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);

        building = new Building(roomList, 2);
    }

    @Test
    void addRoomsToBuilding(){
        assertEquals(3, building.getRooms().size());
        Room room = new Room(4, 5);
        building.addRoom(room);
        assertEquals(4,building.getRooms().size());
    }

    @Test
    void countLampsInBuilding() {
        assertEquals(10, MainBuilding.countLampsInBuilding(building));
    }

    @Test
    void countWindowsInBuilding() {

    }

    @org.junit.jupiter.api.Test
    void countRoomsInBuilding() {
    }

    @org.junit.jupiter.api.Test
    void isNormal() {
    }
}
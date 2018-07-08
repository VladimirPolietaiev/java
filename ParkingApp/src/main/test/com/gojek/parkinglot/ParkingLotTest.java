package com.gojek.parkinglot;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {

    @Test
    public void createParkingLot_true( ) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("12");
        assertEquals(12, parkingLot.availableSlotList.size());
    }

    @Test
    public void createParkingLot_false( ) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("13");
        assertNotEquals(12, parkingLot.availableSlotList.size());
    }

    @Test
    public void createParkingLot_checkMapNotNull( ) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("12");
        assertNotNull(parkingLot.map1);
    }

    @Test
    public void createParkingLot_checkMapNull( ) {
        ParkingLot parkingLot = new ParkingLot();
//        parkingLot.createParkingLot("12");
        assertNull(parkingLot.map1);
    }

//...........parkTest............//

    @Test
    public void park_True( ) {
        ParkingLot parkingLot = new ParkingLot();
//        String regNo;
//        String color;
        parkingLot.createParkingLot("3");
        assertEquals(0, parkingLot.map1.size());
        assertEquals(0, parkingLot.map2.size());
        assertEquals(0, parkingLot.map3.size());
        int sizeBefore = parkingLot.availableSlotList.size();
        parkingLot.park("12313", "red");
        int sizeAfter = parkingLot.availableSlotList.size();
//        ParkingLot.Car car = (ParkingLot.Car) parkingLot.map1.get("1");

//        assertEquals("1", parkingLot.map2.get("regNo")); //slot
        assertEquals((sizeBefore - 1), sizeAfter);

        assertEquals(1, parkingLot.map1.size());
        assertEquals(1, parkingLot.map2.size());
        assertEquals(1, parkingLot.map3.size());

        assertTrue(parkingLot.map2.containsKey("12313"));
        assertTrue(parkingLot.map3.containsKey("red"));


    }

    @Test
    public void park_checkMapNull( ) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park("12", "blue");

        assertNull(parkingLot.map1);
    }

//    public void park_slotNull() {
//        ParkingLot parkingLot = new ParkingLot();
//        parkingLot.park("12","blue");
//        assertNull(parkingLot.map1.get(1));
//    }

    //////////leaveTest/////////

    @Test
    public void leaveTest_False( ) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("10");
        parkingLot.park("12232", "blue");
        parkingLot.park("435", "red");
        parkingLot.park("462", "black");
        parkingLot.park("22222", "white");
        parkingLot.park("2522", "blue");

        String slotNumber = parkingLot.map2.get("435");
        parkingLot.leave(slotNumber);

        assertFalse(parkingLot.map1.containsKey(slotNumber));
        assertTrue(parkingLot.availableSlotList.contains(Integer.parseInt(slotNumber)));
        assertFalse(parkingLot.map2.containsKey("435"));
    }


    /////////// test status //////////
    @Test
    public void statusTest_MAX_SIZE_NotNull( ) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("5");
        parkingLot.park("12232", "blue");
        parkingLot.park("435", "red");
        parkingLot.park("462", "black");
        parkingLot.park("22222", "white");
        parkingLot.park("2522", "blue");

        assertNotNull(parkingLot.MAX_SIZE);

    }

    @Test
    public void statusTest_map1_NotNull( ) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("5");
        parkingLot.park("12232", "blue");
        parkingLot.park("435", "red");
        parkingLot.park("462", "black");
        parkingLot.park("22222", "white");
        parkingLot.park("2522", "blue");

        assertNotNull(parkingLot.map1.size());
    }

    ////////getRegistrationNumbersFromColor/////////
    @Test
    public void getRegistrationNumbersFromColorTest_True_Color( ) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("5");
        parkingLot.park("12232", "blue");
        parkingLot.park("435", "red");
        parkingLot.park("462", "black");
        parkingLot.park("22222", "white");
        parkingLot.park("2522", "blue");

        parkingLot.getRegistrationNumbersFromColor("blue");

        assertTrue(parkingLot.map3.containsKey("blue"));
    }

    @Test
    public void getRegistrationNumbersFromColorTest_NotNull_Map3( ) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("5");
        parkingLot.park("12232", "blue");
        parkingLot.park("435", "red");
        parkingLot.park("462", "black");
        parkingLot.park("22222", "white");
        parkingLot.park("2522", "blue");

        parkingLot.getRegistrationNumbersFromColor("blue");

        assertNotNull(parkingLot.map3.size());

    }

    @Test
    public void getRegistrationNumbersFromColorTest_Equals_Color( ) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("5");
        parkingLot.park("12232", "blue");
        parkingLot.park("435", "red");
        parkingLot.park("462", "black");
        parkingLot.park("22222", "white");
        parkingLot.park("2522", "blue");

        parkingLot.getRegistrationNumbersFromColor("blue");

        assertEquals("12232",parkingLot.map3.get("blue").get(0));
    }

    @Test
    public void getRegistrationNumbersFromColorTest_False_Color( ) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("5");
        parkingLot.park("12232", "blue");
        parkingLot.park("435", "red");
        parkingLot.park("462", "black");
        parkingLot.park("22222", "white");
        parkingLot.park("2522", "blue");

        parkingLot.getRegistrationNumbersFromColor("blue");

        assertFalse(parkingLot.map3.containsKey("green"));
    }

    ///////getSlotNumbersFromColor////////
    @Test
    public void getSlotNumbersFromColorTest_True_Color( ) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("5");
        parkingLot.park("12232", "blue");
        parkingLot.park("435", "red");
        parkingLot.park("462", "black");
        parkingLot.park("22222", "white");
        parkingLot.park("2522", "blue");

        parkingLot.getSlotNumbersFromColor("blue");

        assertTrue(parkingLot.map3.containsKey("blue"));
    }

    @Test
    public void getSlotNumbersFromColorTest_False_Color( ) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("5");
        parkingLot.park("12232", "blue");
        parkingLot.park("435", "red");
        parkingLot.park("462", "black");
        parkingLot.park("22222", "white");
        parkingLot.park("2522", "blue");

        parkingLot.getSlotNumbersFromColor("blue");

        assertFalse(parkingLot.map3.containsKey("green"));
    }

    @Test
    public void getSlotNumbersFromColorTest_Equals_Color_First() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("5");
        parkingLot.park("12232", "blue");
        parkingLot.park("435", "red");
        parkingLot.park("462", "black");
        parkingLot.park("22222", "white");
        parkingLot.park("2522", "blue");

        parkingLot.getSlotNumbersFromColor("blue");
        String regNoFirst = parkingLot.map3.get("blue").get(0);

        assertEquals("1",parkingLot.map2.get(regNoFirst));
    }



}
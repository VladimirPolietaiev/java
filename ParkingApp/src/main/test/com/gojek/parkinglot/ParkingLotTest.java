package com.gojek.parkinglot;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {

    @Test
    public void createParkingLot_true() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("12");
        assertEquals(12, parkingLot.availableSlotList.size());
    }

    @Test
    public void createParkingLot_false() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("13");
        assertNotEquals(12, parkingLot.availableSlotList.size());
    }

    @Test
    public void createParkingLot_checkMapNotNull() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.createParkingLot("12");
        assertNotNull(parkingLot.map1);
    }

    @Test
    public void createParkingLot_checkMapNull() {
        ParkingLot parkingLot = new ParkingLot();
//        parkingLot.createParkingLot("12");
        assertNull(parkingLot.map1);
    }

//...........parkTest............//

//    @Test
//    public void park_True() {
//        ParkingLot parkingLot = new ParkingLot();
//
//        parkingLot.park("regNo","color");
//
//
//        assertEquals("regno", parkingLot.park("regno","color"));
//    }

//    @Test
//    public void park_checkMapNull() {
//        ParkingLot parkingLot = new ParkingLot();
//        parkingLot.park("12","blue");
//        assertNull(parkingLot.map1);
//    }

//    public void park_slotNull() {
//        ParkingLot parkingLot = new ParkingLot();
//        parkingLot.park("12","blue");
//        assertNull(parkingLot.map1.get(1));
//    }

    //////////leaveTest/////////

    @Test
    public void leaveTest_true() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.leave("12");
        assertEquals("12", parkingLot.map1.size());
    }

}
package com.example.lv4;

import static org.junit.jupiter.api.Assertions.*;

class LaptopDaoSerializableFileTest {


    public void testGetLaptop(){
        Laptop myLaptop = new Laptop("HP", "Pavilion", 899.99, 8, 1000, 256, "i5", "NVIDIA", 15.6);
        String brend= "HP";
        assertEquals(brend, myLaptop.getBrend());
    }

    public void testDodajLaptopUListu() {
    }

    public void testNapuniListu() {
    }

    public void testVratiPodatkeIzDatoteke() {
    }

    public void testDodajLaptopUFile() {
    }
}
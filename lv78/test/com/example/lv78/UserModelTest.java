package com.example.lv78;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class UserModelTest {
    @Test
    void Test1() {
        //napuni metoda
        UserModel users = new UserModel();
        users.napuni();
        assertEquals("Tyler",users.getTrenutniUser().getIme());
    }
    @Test
    void Test2() {
        //provjeravanje dodavanja novog Usera
        UserModel users = new UserModel();
        users.napuni();
        User newGuy = new User("John","Lennnon","yuh","snubnose","peace");
        users.addUser(newGuy);
        assertEquals(4,users.size());
    }
    @Test
    void Test3() {
        //provjeravanje trenutnogKorisnika
        UserModel users = new UserModel();
        users.napuni();
        User newGuy = new User("John","Lennnon","yuh","snubnose","peace");
        users.setTrenutniUser(newGuy);
        assertEquals(newGuy,users.getTrenutniUser());
    }

}
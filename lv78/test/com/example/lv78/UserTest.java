package com.example.lv78;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void Test1() {
        //equals metoda
        User user1 = new User("Tyler","Joseph", "tylerj@gmail.com", "MAIN_SINGER", "joshyouareoutoftheband");
        User user2 = new User("Tyler","Joseph", "tylerj@gmail.com", "MAIN_SINGER", "joshyouareoutoftheband");
        assertEquals(user1,user2);
    }
    @Test
    void Test2() {
        //equals metoda
        User user1 = new User("Tyler","Joseph", "tylerj@gmail.com", "MAIN_SINGER", "joshyouareoutoftheband");
        User user2 = new User("Josh","Dun", "joshd@gmail.com", "JUST_A_DRUMMER", "nomorebackflipsforhoty");
        assertNotEquals(user1,user2);
    }
}
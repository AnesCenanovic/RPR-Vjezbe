package com.example.lv78;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserModel {
    private ObservableList<User> users = FXCollections.observableArrayList();
    private ObjectProperty<User> trenutniUser = new SimpleObjectProperty<>();

    public ObjectProperty<User> trenutniUserProperty() {
        return trenutniUser;
    }

    public User getTrenutniUser() {
        return trenutniUser.get();
    }

    public void setTrenutniUser(User k) {
        trenutniUser.set(k);
    }

    public ObservableList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        boolean userExists = false;
        for (User existingUser : users) {
            System.out.println("Comparing: " + existingUser + " with " + user);
            if (existingUser == user) {
                userExists = true;
                break;
            }
        }

        if (!userExists) {
            System.out.println("Adding user: " + user);
            users.add(user);
        }
    }
    void napuni() {
        users.add(new User("Tyler","Joseph", "tylerj@gmail.com", "MAIN_SINGER", "joshyouareoutoftheband"));
        users.add(new User("Josh","Dun", "joshd@gmail.com", "JUST_A_DRUMMER", "nomorebackflipsforhoty"));
        users.add(new User("Ned","Bayou", "nedb@gmail.com", "WEIRD_ANTLER_MONSTER_THING", "sokeepnedbayou"));
        setTrenutniUser(users.get(0));
    }
    int size(){
        return users.size();
    }

}

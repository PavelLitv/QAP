package guru.qa.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    private final int id;
    private final String userName;
    private final int icqNumber;
    private final byte[] passwordHash;
    private final List<User> contactList;

    public User(String userName, int icqNumber, byte[] passwordHash) {
        this.id = 0;
        this.userName = userName;
        this.icqNumber = icqNumber;
        this.passwordHash = passwordHash;
        this.contactList = new ArrayList<>();
    }

    public User(int id, String userName, int icqNumber, byte[] passwordHash) {
        this.id = id;
        this.userName = userName;
        this.icqNumber = icqNumber;
        this.passwordHash = passwordHash;
        contactList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getIcqNumber() {
        return icqNumber;
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public List<User> getContactList() {
        return contactList;
    }

    public User addUsersToContactList(User... users) {
        this.contactList.addAll(Arrays.asList(users));

        return this;
    }
}

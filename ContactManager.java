package api.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ContactManager {
    private HashMap<String, String> contacts;

    public ContactManager() {
        contacts = new HashMap<>();
    }

    public boolean add(String name, String phone) {
        if (name == null || phone == null) {
            return false;
        }

        if (contacts.containsKey(name)) {
            return false;
        }

        contacts.put(name, phone);
        return true;
    }

    public String find(String name) {
        if (name == null) {
            return null;
        }

        return contacts.get(name);
    }

    public boolean delete(String name) {
        if (name == null || !contacts.containsKey(name)) {
            return false;
        }

        contacts.remove(name);
        return true;
    }

    public ArrayList<String> show() {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>(contacts.keySet());

        Collections.sort(names);

        for (String name : names) {
            result.add(name + " " + contacts.get(name));
        }

        return result;
    }
}
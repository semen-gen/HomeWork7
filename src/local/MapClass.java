package local;

import java.util.*;

public class MapClass {

    private final static HashMap<String, String> users;

    static {
        users = new HashMap<>();
    }


    public static void register(String nikName, String name) {
        if (!users.containsKey(nikName)) {
            addUser(nikName, name);
            System.out.println("Создан пользователь с логином " + nikName);
        }
        else {
            System.out.println("Логин " + nikName + " занят");
        }
    }

    public static void unRegister(String nikName) {
        if (users.containsKey(nikName)) {
            delUser(nikName);
            System.out.println("Пользователь с логином " + nikName + " удалён");
        }
        else {
            System.out.println("Такого пользователя не существует");
        }
    }

    public static HashMap<String, String> getUsers() {
        return users;
    }


    private static void addUser(String nikName, String name) {
        users.put(nikName, name);
    }

    private static void delUser(String nikName) {
        users.remove(nikName);
    }

}

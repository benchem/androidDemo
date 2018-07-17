package team.benchem.activitydemo.entity;

import java.util.UUID;

public class Employee {

    private final String id;
    private final String number;
    private final String name;

    public Employee(String number, String name) {
        this.id = UUID.randomUUID().toString();
        this.number = number;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}

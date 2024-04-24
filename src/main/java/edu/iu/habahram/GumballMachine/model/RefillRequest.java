package edu.iu.habahram.GumballMachine.model;

public class RefillRequest {
    private String id;
    private int count;

    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


package com.example.SimpleAPI.person;

public class StatusDTO {
    private int count;
    private int avg;

    public StatusDTO(int count, int avg) {
        this.count = count;
        this.avg = avg;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }
}

package com.example.SimpleAPI.person;

public class StatusDTO {
    private Long count;
    private Double avg;

    public StatusDTO(Long count, Double avg) {
        this.count = count;
        this.avg = avg;
    }


    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }
}

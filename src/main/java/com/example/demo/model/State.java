package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "state", schema = "lgd")
public class State {

    @Id
    @Column(name = "state_code")
    private Integer stateCode;

    @Column(name = "state_name_english")
    private String stateNameEnglish;

    public State() {}

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateNameEnglish() {
        return stateNameEnglish;
    }

    public void setStateNameEnglish(String stateNameEnglish) {
        this.stateNameEnglish = stateNameEnglish;
    }
}
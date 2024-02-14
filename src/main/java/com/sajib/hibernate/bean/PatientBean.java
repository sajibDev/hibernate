package com.sajib.hibernate.bean;

import lombok.Data;

@Data
public class PatientBean {

    private String patientName;
    private Integer patientAge;

    public PatientBean(String patientName, Integer patientAge) {
        this.patientName = patientName;
        this.patientAge = patientAge;
    }
}

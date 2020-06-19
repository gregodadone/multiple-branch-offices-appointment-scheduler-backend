package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BranchOffice {
    @Id
    @GeneratedValue
    private long id;
    private String province; //state
    private String city;
    private String district;
    private String phoneNumber;
    private boolean enabled;
    private String name;
    private LocalTime openingTime;
    private LocalTime closingTime;
}

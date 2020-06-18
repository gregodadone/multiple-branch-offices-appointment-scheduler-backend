package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BranchOffice {
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

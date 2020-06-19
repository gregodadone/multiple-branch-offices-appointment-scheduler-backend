package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BranchOffice extends BaseEntity {

    @Column
    private String province; //state

    @Column
    private String city;

    @Column
    private String district;

    @Column
    private String phoneNumber;

    @Column
    private boolean enabled;

    @Column
    private String name;

    @Column
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss", timezone = "UTC")
    @JsonFormat(pattern = "hh:mm:ss")
    private LocalTime openingTime;

    @Column
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss", timezone = "UTC")
    @JsonFormat(pattern = "hh:mm:ss")
    private LocalTime closingTime;
}

package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BranchOffice extends BaseEntity {

    @Column
    @ApiModelProperty(value = "Province or state", example = "Chaco", required = true, position = 1)
    private String province; //state

    @Column
    @ApiModelProperty(value = "City or town", example = "Resistencia", required = true, position = 2)
    private String city;

    @Column
    @ApiModelProperty(value = "District or section", example = "Villa Centenario", required = true, position = 3)
    private String district;

    @Column
    @ApiModelProperty(value = "Phone Number", example = "+543624000000", position = 4)
    private String phoneNumber;

    @Column
    @ApiModelProperty(value = "Branch Office name", example = "Sucursal Villa Centenario", required = true, position = 5)
    private String name;

    @Column
    @ApiModelProperty(value = "Is branch office working?", example = "true", required = true, position = 6)
    private boolean enabled;

    @Column
    @ApiModelProperty(value = "Opening hour", example = "09:00:00", required = true, position = 7)
    private LocalTime openingTime;

    @Column
    @ApiModelProperty(value = "Closing hour", example = "18:00:00", required = true, position = 8)
    private LocalTime closingTime;
}

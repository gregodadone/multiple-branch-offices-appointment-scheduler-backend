package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BranchOffice extends BaseEntity {

    @ManyToOne
    @ApiModelProperty(value = "District or section", required = true, position = 3)
    private District district;

    @Column
    @Digits(fraction = 0, integer = 10)
    @ApiModelProperty(value = "Phone Number", example = "3624000000", position = 4)
    private String phoneNumber;

    @Column
    @ApiModelProperty(value = "Branch Office name", example = "Sucursal Villa Centenario", required = true, position = 5)
    private String name;

    @Column
    @ColumnDefault("true")
    @ApiModelProperty(value = "Is branch office working?", example = "true", required = true, position = 6)
    private boolean enabled;

    @Column
    @NotEmpty
    @ApiModelProperty(value = "Opening hour", example = "09:00:00", required = true, position = 7)
    private LocalTime openingTime;

    @Column
    @NotEmpty
    @ApiModelProperty(value = "Closing hour", example = "18:00:00", required = true, position = 8)
    private LocalTime closingTime;
}

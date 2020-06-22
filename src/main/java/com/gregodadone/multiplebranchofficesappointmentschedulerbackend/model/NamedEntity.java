package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class NamedEntity extends BaseEntity {
    @Column
    @NotEmpty
    private String name;
}

package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Turn extends BaseEntity {

    @Column
    private LocalDate date;

    @Column
    private LocalTime time;

    @Column
    private String reason;

    @Column
    private boolean cancelled;

    @Column
    private LocalDate cancellationDate;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Post post;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private BranchOffice branchOffice;
}

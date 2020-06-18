package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turn {
    private long id;
    private LocalDate date;
    private LocalTime time;
    private String reason;
    private int userId;
    private String phoneNumber;
    private boolean cancelled;
    private LocalDate cancellationDate;
    private Post post;
    private BranchOffice branchOffice;
}

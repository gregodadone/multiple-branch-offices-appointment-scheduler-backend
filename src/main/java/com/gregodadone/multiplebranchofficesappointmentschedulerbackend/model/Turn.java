package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turn {
    private long id;
    private Date date;
    private Time time;
    private String reason;
    private int userId;
    private String phoneNumber;
    private boolean cancelled;
    private Date cancellationDate;
    private Post post;
    private BranchOffice branchOffice;
}

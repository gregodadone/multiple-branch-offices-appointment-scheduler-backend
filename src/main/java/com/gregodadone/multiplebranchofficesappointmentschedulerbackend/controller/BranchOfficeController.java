package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gregodadone.multiplebranchofficesappointmentschedulerbackend.constants.Paths.BRANCH_OFFICES_PATH;

@RestController
@RequestMapping(BRANCH_OFFICES_PATH)
public class BranchOfficeController {

    @PostMapping("")
    public void addBranchOffice() {

    }
}

package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.controller;

import com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model.BranchOffice;
import com.gregodadone.multiplebranchofficesappointmentschedulerbackend.service.BranchOfficeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gregodadone.multiplebranchofficesappointmentschedulerbackend.constants.Paths.BRANCH_OFFICES_PATH;

@RestController
@RequestMapping(BRANCH_OFFICES_PATH)
public class BranchOfficeController {

    private final BranchOfficeService branchOfficeService;

    public BranchOfficeController(BranchOfficeService branchOfficeService) {
        this.branchOfficeService = branchOfficeService;
    }

    @PostMapping("")
    public void addBranchOffice(@RequestBody BranchOffice branchOffice) {
        branchOfficeService.addBranchOffice(branchOffice);
    }
}

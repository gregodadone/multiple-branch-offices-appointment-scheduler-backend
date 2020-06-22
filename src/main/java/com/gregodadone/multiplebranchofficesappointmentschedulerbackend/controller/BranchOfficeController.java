package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.controller;

import com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model.BranchOffice;
import com.gregodadone.multiplebranchofficesappointmentschedulerbackend.service.BranchOfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.gregodadone.multiplebranchofficesappointmentschedulerbackend.constants.Paths.BRANCH_OFFICES_PATH;

@RestController
@RequestMapping(BRANCH_OFFICES_PATH)
public class BranchOfficeController {

    private final BranchOfficeService branchOfficeService;

    public BranchOfficeController(BranchOfficeService branchOfficeService) {
        this.branchOfficeService = branchOfficeService;
    }

    @PostMapping
    public void addBranchOffice(@RequestBody BranchOffice branchOffice) {
        branchOfficeService.addBranchOffice(branchOffice);
    }

    @GetMapping("/{branchOfficeId}")
    public ResponseEntity<BranchOffice> getBranchOfficeById(@PathVariable(name = "branchOfficeId") long id) {
        Optional<BranchOffice> branchOffice = branchOfficeService.getBranchOfficeById(id);
        return branchOffice.map(office -> new ResponseEntity<>(office, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

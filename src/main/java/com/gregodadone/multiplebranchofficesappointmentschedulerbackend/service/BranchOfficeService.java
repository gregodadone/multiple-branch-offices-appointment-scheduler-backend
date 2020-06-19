package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.service;

import com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model.BranchOffice;
import com.gregodadone.multiplebranchofficesappointmentschedulerbackend.repository.BranchOfficeRepository;
import org.springframework.stereotype.Service;

@Service
public class BranchOfficeService {

    private final BranchOfficeRepository repository;

    public BranchOfficeService(BranchOfficeRepository repository) {
        this.repository = repository;
    }

    public void addBranchOffice(BranchOffice branchOffice) {
        repository.save(branchOffice);
    }
}

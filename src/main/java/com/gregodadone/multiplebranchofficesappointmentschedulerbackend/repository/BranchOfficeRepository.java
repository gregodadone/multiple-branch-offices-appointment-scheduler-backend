package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.repository;

import com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model.BranchOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchOfficeRepository extends JpaRepository<BranchOffice, Long> {
}

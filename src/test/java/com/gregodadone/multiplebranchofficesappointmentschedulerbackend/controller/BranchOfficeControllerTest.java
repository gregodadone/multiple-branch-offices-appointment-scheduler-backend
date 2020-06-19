package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.controller;

import com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model.BranchOffice;
import com.gregodadone.multiplebranchofficesappointmentschedulerbackend.repository.BranchOfficeRepository;
import org.joda.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static com.gregodadone.multiplebranchofficesappointmentschedulerbackend.constants.Paths.BRANCH_OFFICES_PATH;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class BranchOfficeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BranchOfficeRepository branchOfficeRepository;

    @BeforeEach
    public void before() {
        branchOfficeRepository.deleteAll();
    }

    @Test
    public void postBranchOffice_whenValid_shouldReturnOk() {
        BranchOffice branchOffice = createBranchOffice();

        ResponseEntity<Object> responseEntity
                = restTemplate.postForEntity(BRANCH_OFFICES_PATH, branchOffice, Object.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void postBranchOffice_whenValid_shouldSaveToDB() {
        BranchOffice branchOffice = createBranchOffice();
        restTemplate.postForEntity(BRANCH_OFFICES_PATH, branchOffice, Object.class);
        assertThat(branchOfficeRepository.count()).isEqualTo(1);
    }

    private BranchOffice createBranchOffice() {
        return BranchOffice.builder()
                .province("Chaco")
                .city("Resistencia")
                .district("Villa Centenario")
                .name("Office 1")
                .enabled(true)
                .phoneNumber("3624321123")
                .openingTime(LocalTime.parse("09:00:00"))
                .closingTime(LocalTime.parse("18:00:00"))
                .build();
    }
}

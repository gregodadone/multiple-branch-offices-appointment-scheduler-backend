package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.controller;

import com.gregodadone.multiplebranchofficesappointmentschedulerbackend.model.BranchOffice;
import com.gregodadone.multiplebranchofficesappointmentschedulerbackend.repository.BranchOfficeRepository;
import com.gregodadone.multiplebranchofficesappointmentschedulerbackend.utils.JsonConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalTime;

import static com.gregodadone.multiplebranchofficesappointmentschedulerbackend.constants.Paths.BRANCH_OFFICES_PATH;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
public class BranchOfficeControllerTest {

    private static final String PROVINCE = "Chaco";
    private static final String CITY = "Resistencia";
    private static final String DISTRICT = "Villa Centenario";
    private static final String OFFICE_NAME = "Office 1";
    private static final String PHONE_NUMBER = "3624321123";
    private static final LocalTime OPENING_TIME = LocalTime.parse("09:00:00");
    private static final LocalTime CLOSING_TIME = LocalTime.parse("18:00:00");
    private static final boolean ENABLED = true;

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

    @Test
    public void getBranchOffice_whenValidRequest_shouldReturnOk() {
        restTemplate.postForEntity(BRANCH_OFFICES_PATH, createBranchOffice(), Object.class);
        long id = branchOfficeRepository.findAll().get(0).getId();

        ResponseEntity<BranchOffice> branchOfficeEntity
                = restTemplate.getForEntity(BRANCH_OFFICES_PATH + "/" + id, BranchOffice.class);

        assertThat(branchOfficeEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void getBranchOffice_whenValidRequest_shouldReturnBranchOffice() {
        restTemplate.postForEntity(BRANCH_OFFICES_PATH, createBranchOffice(), Object.class);
        long id = branchOfficeRepository.findAll().get(0).getId();

        ResponseEntity<BranchOffice> branchOfficeEntity
                = restTemplate.getForEntity(BRANCH_OFFICES_PATH + "/" + id, BranchOffice.class);

        BranchOffice branchOffice = branchOfficeEntity.getBody();
        assertThat(branchOffice).isNotNull();
        assertThat(branchOffice.getId()).isEqualTo(id);
        assertThat(branchOffice.getProvince()).isEqualTo(PROVINCE);
        assertThat(branchOffice.getCity()).isEqualTo(CITY);
        assertThat(branchOffice.getDistrict()).isEqualTo(DISTRICT);
        assertThat(branchOffice.getName()).isEqualTo(OFFICE_NAME);
        assertThat(branchOffice.getPhoneNumber()).isEqualTo(PHONE_NUMBER);
        assertThat(branchOffice.isEnabled()).isEqualTo(ENABLED);
        assertThat(branchOffice.getOpeningTime()).isEqualTo(OPENING_TIME);
        assertThat(branchOffice.getClosingTime()).isEqualTo(CLOSING_TIME);
    }

    @Test
    public void getBranchOffice_whenBranchOfficeDoesNotExists_shouldReturnNotFound() {
        ResponseEntity<BranchOffice> branchOfficeEntity
                = restTemplate.getForEntity(BRANCH_OFFICES_PATH + "/" + 1, BranchOffice.class);

        assertThat(branchOfficeEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    private BranchOffice createBranchOffice() {
        return BranchOffice.builder()
                .province(PROVINCE)
                .city(CITY)
                .district(DISTRICT)
                .name(OFFICE_NAME)
                .enabled(ENABLED)
                .phoneNumber(PHONE_NUMBER)
                .openingTime(OPENING_TIME)
                .closingTime(CLOSING_TIME)
                .build();
    }
}

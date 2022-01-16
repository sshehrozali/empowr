package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AdminControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private DatabaseRepository databaseRepository;

    @Mock
    private PerformanceRepository performanceRepository;

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private AdminController adminController;

    Data EMPLOYEE_DATA_1 = new Data(1, "Hasan", true);
    Data EMPLOYEE_DATA_2 = new Data(2, "Urwa", true);

    Performance EMPLOYEE_PERFORMANCE_1 = new Performance(1, "Hasan has done Excellent Job this month", "");
    Performance EMPLOYEE_PERFORMANCE_2 = new Performance(2, "Urwa has contributed her skills so much this month", "");

    Feedback EMPLOYEE_FEEDBACK_1 = new Feedback(1, "I Know Hasan and he is excellent perogramer");

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void getallEmployeesData_success() throws Exception {
        List<Data> employeedata = new ArrayList<>();
        employeedata.add(EMPLOYEE_DATA_1);
        employeedata.add(EMPLOYEE_DATA_2);

        Mockito.when(databaseRepository.findAll()).thenReturn(employeedata);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/employee/all")
                .contentType(MediaType.APPLICATION_JSON));
    }
}

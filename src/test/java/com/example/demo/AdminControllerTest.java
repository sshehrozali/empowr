package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

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

    
}

package com.awapi;



        import com.awapi.controller.ShipwreckController;
        import com.awapi.model.Shipwreck;
        import com.awapi.repository.ShipwreckRepository;
        import com.fasterxml.jackson.databind.JsonNode;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import org.junit.Before;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.MockitoAnnotations;
        import org.springframework.boot.test.SpringApplicationConfiguration;
        import org.springframework.http.HttpStatus;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

        import java.util.List;

//HamCrest --
        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.hamcrest.Matchers.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest()
public class ShipwreckController_WebIntegrationTest {

    public void listAll_Test() throws IOException {
        RestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/api/v1/shipwrecks");

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response.getBody());

        assertThat(responseJson.isMissingNode(), is(false));
        assertThat(responseJson.toString(), equalTo("[]"));



    }




}

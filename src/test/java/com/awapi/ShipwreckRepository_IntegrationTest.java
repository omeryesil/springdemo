package com.awapi;


import com.awapi.controller.ShipwreckController;
import com.awapi.model.Shipwreck;
import com.awapi.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//HamCrest --
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class ShipwreckRepository_IntegrationTest {

    // ---------- Mockito Settings --------------------------------------
    @InjectMocks
    private ShipwreckController _sc;

    @Mock
    private ShipwreckRepository _shipwreckRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void findAll_Test(){
        List<Shipwreck> wrecks = _shipwreckRepository.findAll();

        assertThat (wrecks.size(), is(greaterThanOrEqualTo(0)));

    }
}

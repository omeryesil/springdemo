// JUnit and Mockito and HamCrest tests ----------------------------------------------

package com.awapi;

import com.awapi.controller.ShipwreckController;
import com.awapi.model.Shipwreck;
import com.awapi.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

//Mockito ---
import static org.mockito.Mockito.*;

//HamCrest --
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by yesiome on 9/1/2016.
 */

public class ShipwreckController_Test {

    // ---------- Mockito Settings --------------------------------------
    @InjectMocks
    private ShipwreckController _sc;

    @Mock
    private ShipwreckRepository _shipwreckRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    // end of Mockito Settings -------------------------------------------

    @Test
    public void get_Test() {
        Shipwreck sw = new Shipwreck();
        sw.setId(1L);
        //when we call _shipwreckRepository we return sw
        when(_shipwreckRepository.findOne(1L)).thenReturn(sw);

        Shipwreck wreck = _sc.get(1L);
        //check if Mockite has been used or not.
        verify(_shipwreckRepository).findOne(1L);

        //assertEquals(1L, wreck.getId().longValue());   //replaced with HamCrest, below, code, which is more readable
        assertThat (wreck.getId(), is(1L));
    }
}

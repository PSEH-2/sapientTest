package com.sapient.service;

import com.sapient.exception.ApplicationException;
import com.sapient.hello.Application;
import com.sapient.model.League;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class FootBallApiTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private FootBallApi footBallApi;

    @Test(expected = ApplicationException.class)
    public void testGetLeagueIdNull() throws Exception {
        String countryName = "England";
        Mockito.when(restTemplate.getForObject(any(), any())).thenReturn(null);
        footBallApi.getLeagueId(countryName);
    }

}
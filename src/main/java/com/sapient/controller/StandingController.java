package com.sapient.controller;

import com.sapient.model.Standing;
import com.sapient.model.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sapient.service.StandingService;

@RestController
@RequestMapping(value = "/standings")
public class StandingController {

    @Autowired
    private StandingService standingService;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/get", method = RequestMethod.POST)
    public ResponseEntity<Standing> getStandings(@RequestBody TeamDTO teamDTO) throws Exception {

        Standing standing = standingService.getStanding(teamDTO);
        return new ResponseEntity<>(standing, HttpStatus.OK);
    }
}

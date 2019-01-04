package com.sapient.service;

import com.sapient.model.Standing;
import com.sapient.model.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandingService {

    @Autowired
    private FootBallApi footBallApi;

    public Standing getStanding(TeamDTO teamDTO) throws Exception {

        String leagueId = footBallApi.getLeagueId(teamDTO.getCountryName());
        Standing standing = footBallApi.getStandings(leagueId, teamDTO.getTeamName(), teamDTO.getLeagueName());
        return standing;
    }
}

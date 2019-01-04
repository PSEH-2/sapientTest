package com.sapient.service;

import com.sapient.model.Standing;
import com.sapient.model.TeamDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StandingServiceTest {

    @Mock
    private FootBallApi footBallApi;

    @InjectMocks
    private StandingService standingService;

    @Test
    public void testGetStanding() throws Exception {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setCountryName("England");
        teamDTO.setTeamName("team1");
        teamDTO.setLeagueName("league1");

        String leagueId = "123";
        Mockito.when(footBallApi.getLeagueId(teamDTO.getCountryName())).thenReturn(leagueId);

        Standing standing = new Standing();
        standing.setLeague_id(leagueId);
        Mockito.when(footBallApi.getStandings(leagueId, teamDTO.getTeamName(), teamDTO.getLeagueName())).thenReturn(standing);

        Standing standing1 = standingService.getStanding(teamDTO);

        Assert.assertEquals(leagueId, standing1.getLeague_id());
    }
}
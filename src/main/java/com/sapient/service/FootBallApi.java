package com.sapient.service;

import com.sapient.exception.ApplicationException;
import com.sapient.model.League;
import com.sapient.model.Standing;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FootBallApi {

    private RestTemplate restTemplate;

    public FootBallApi() {
        restTemplate = new RestTemplate();
    }

    private static final String apiKey = "&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
    private static final String apiUrlFormat = "https://apifootball.com/api/?action=%s";

    public static final String API_URL = "";

    public String getLeagueId(String countryName) throws Exception {
        String apiUrl = String.format(apiUrlFormat + apiKey, "get_leagues");
        System.out.println(apiUrl);
        League[] leagues = restTemplate.getForObject(apiUrl, League[].class);
        if (leagues == null) {
            throw new ApplicationException("League not found");
        }

        for (League league : leagues) {
            if (league.getCountry_name().equals(countryName)) {
                return league.getLeague_id();
            }
        }
        throw new ApplicationException("League not found");
    }

    public Standing getStandings(String leagueId, String teamName, String leagueName) throws ApplicationException {

        String apiUrl = String.format(apiUrlFormat + "&league_id=%s" + apiKey, "get_standings", leagueId);
        Standing[] standings = restTemplate.getForObject(apiUrl, Standing[].class);
        if(standings == null) {
            throw new ApplicationException("Standing not found");
        }

        for(Standing standing : standings) {
            if(standing.getTeam_name().equals(teamName) && standing.getLeague_name().equals(leagueName)) {
                return standing;
            }
        }

        throw new ApplicationException("Standing not found");

    }
}

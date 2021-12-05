package com.example.monitorowaniejednostekmorskich.track;

import com.example.monitorowaniejednostekmorskich.token.TokenRequestService;
import com.example.monitorowaniejednostekmorskich.track.model.Point;
import com.example.monitorowaniejednostekmorskich.track.model.Track;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TrackService {

    private final TokenRequestService tokenRequest;

    public TrackService(TokenRequestService tokenRequest) throws URISyntaxException {
        this.tokenRequest = tokenRequest;
    }

    //    @EventListener(ApplicationReadyEvent.class) // uruchamia metodę przy starcie aplikacji
    public List<Point> getTracks() throws URISyntaxException {
        URI url = new URI("https://www.barentswatch.no/bwapi/v2/geodata/ais/openpositions?Xmin=10.09094&Xmax=10.67047&Ymin=63.3989&Ymax=63.58645");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        String token = "Bearer " + tokenRequest.getToken();
        httpHeaders.add("Authorization", token);
        HttpEntity<Track[]> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Track[]> responseEntity = restTemplate.exchange("https://www.barentswatch.no/bwapi/v2/geodata/ais/openpositions?Xmin=10.09094&Xmax=10.67047&Ymin=63.3989&Ymax=63.58645",
                HttpMethod.GET,
                httpEntity,
                Track[].class);

        return Stream.of(responseEntity.getBody()).map(track -> new Point(
                        track.getGeometry().getCoordinates().get(0),
                        track.getGeometry().getCoordinates().get(1),
                        track.getName(),
                        track.getDestination()))
                .collect(Collectors.toList());
    }
}


package com.example.monitorowaniejednostekmorskich.model;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TrackService {


    @EventListener(ApplicationReadyEvent.class) // uruchamia metodę przy starcie aplikacji
    public List<Point> getTracks() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization",
                "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjBCM0I1NEUyRkQ5OUZCQkY5NzVERDMxNDBDREQ4OEI1QzA5RkFDRjMiLCJ0eXAiOiJhdCtqd3QiLCJ4NXQiOiJDenRVNHYyWi03LVhYZE1VRE4ySXRjQ2ZyUE0ifQ.eyJuYmYiOjE2MzgyNTc3OTgsImV4cCI6MTYzODI2MTM5OCwiaXNzIjoiaHR0cHM6Ly9pZC5iYXJlbnRzd2F0Y2gubm8iLCJhdWQiOiJhcGkiLCJjbGllbnRfaWQiOiJ1bXlrYW5pbkBnbWFpbC5jb206dW15a2FuaW4iLCJzY29wZSI6WyJhcGkiXX0.oD2yCbS9rk6WlYxV2JLzyfHf0YYPZCwA5ZPs_7TrbH75JI03ZjbutcCPgGVS6jQL5OynBJDMGY-9rfhzm9IdAYhXDndreVXywLVxon5cNhZtdiWu9PdL7CJrmc0g8VXWbeZAbMcY9rM0umrkf6558JLnYuSbMglUpbwYSnGyPUsunzIrRGKQJl4mwhhin8qsrEfVP-ypJFqpHFkqvFtuCmkSAw-9UwOcg4Uq-EvwNSyZouGKqH9D35zLdb5qNMalcweppmtS3XLFBuezrLZhxDv0ugs__WD_oOyDfTFsEta_1Ky4eDhNSIMrmQAq4G0RaSBh032bMy99cYzYlpLOXyHpr9iPGSTmiDNrSdfZald6pgGNkvWj6WksAdS4sg0oerIogCruA4cD0aP8Ck44pi4IVjysaFAimweBT71sqkPelCVMdXbuVLmUaVUJraMHZz36aL7M6_n9FZXb2jyiQkaFsVtQhPM51aG8fWBj4qeJhw9cMNUO0bTG8gf-HyPQSUWjZEhYo93XpmWHzWp16cv3FpxG1kV25JYdyDMdCZAWR9ImtuisUFX44S4zKUW6w3w_FfIJ8NdBi_pYwpEw9PD6PCiCUb6H8QXrfiz8EVkuRPShreDz6T0Nx3mP-u9EosKL6YmzcQmveNatUIuMhTBQJ5BPis1HMcgmhm_Pyvo");
        HttpEntity<Track[]> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Track[]> responseEntity = restTemplate.exchange("https://www.barentswatch.no/bwapi/v2/geodata/ais/openpositions?Xmin=10.09094&Xmax=10.67047&Ymin=63.3989&Ymax=63.58645",
                HttpMethod.GET, httpEntity, Track[].class);

        return Stream.of(responseEntity.getBody()).map(track -> new Point(
                track.getGeometry().getCoordinates().get(0),
                track.getGeometry().getCoordinates().get(1),
                track.getName(),
                track.getDestination()))
                .collect(Collectors.toList());
    }
}

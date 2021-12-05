package com.example.monitorowaniejednostekmorskich;

import com.example.monitorowaniejednostekmorskich.track.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URISyntaxException;

@Controller
public class MapController {

    private final TrackService trackService;

    public MapController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public String getMap(Model model) throws URISyntaxException {
        model.addAttribute("tracks", trackService.getTracks());
        return "map";
    }
}

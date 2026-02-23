package com.example.Valentine.Controller;

import com.example.Valentine.Model.LoveScoreRequest;
import com.example.Valentine.Service.LoveScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/love-score")
@CrossOrigin(origins = "*")
public class LoveScoreController {

    private final LoveScoreService service;

    public LoveScoreController(LoveScoreService service) {
        this.service = service;
    }

    @PostMapping("/calculate")
    public Map<String, Object> calculateLoveScore(
            @RequestBody LoveScoreRequest request) {

        int score = service.calculateScore(
                request.getName1(),
                request.getName2()
        );

        String message = service.getLoveMessage(score);

        Map<String, Object> response = new HashMap<>();
        response.put("name1", request.getName1());
        response.put("name2", request.getName2());
        response.put("score", score);
        response.put("message", message);

        return response;
    }
}

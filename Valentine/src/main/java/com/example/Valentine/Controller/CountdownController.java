package com.example.Valentine.Controller;
import com.example.Valentine.Service.CountdownService;
import com.example.Valentine.Model.CountdownMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.Map;


@RestController
@RequestMapping("/api/countdown")
@CrossOrigin(origins = "*")
public class CountdownController {

    private final CountdownService service;

    public CountdownController(CountdownService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createCountdown(
            @RequestBody CountdownMessage message) {

        CountdownMessage saved = service.createCountdown(message);

        String link = "/countdown/" + saved.getId();

        Map<String, String> response = new HashMap<>();
        response.put("id", saved.getId().toString());
        response.put("link", link);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountdownMessage> getCountdown(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getCountdown(id));
    }
}

package com.example.Valentine.Controller;
import com.example.Valentine.Model.DateIdeaResponse;
import com.example.Valentine.Model.DateIdeaRequest;
import com.example.Valentine.Service.DateIdeaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/date-idea")
@CrossOrigin(origins = "*")
public class DateIdeaController {

    private final DateIdeaService dateIdeaService;

    public DateIdeaController(DateIdeaService dateIdeaService) {
        this.dateIdeaService = dateIdeaService;
    }

    @PostMapping("/generate")
    public DateIdeaResponse generateIdea(@RequestBody DateIdeaRequest request) {

        return dateIdeaService.generateIdea(
                request.getYears(),
                request.getMonths(),
                request.getDistanceType()
        );
    }
}

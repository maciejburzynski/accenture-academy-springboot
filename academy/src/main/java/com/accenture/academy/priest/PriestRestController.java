package com.accenture.academy.priest;

import com.accenture.academy.church.ChurchNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/priests")
public class PriestRestController {

    private final PriestService priestService;

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    PriestDao getPriestById(@PathVariable Long id) {
        return priestService.getPriestById(id);
    }
}

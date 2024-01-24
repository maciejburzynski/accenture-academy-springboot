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

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void addPriest(@RequestBody PriestDto priestDto) {
        priestService.addPriest(priestDto);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    PriestDao getPriestById(@PathVariable Long id) {
        return priestService.getPriestById(id);
    }
}

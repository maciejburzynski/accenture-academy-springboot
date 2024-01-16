package com.accenture.academy.priest;

import com.accenture.academy.church.ChurchNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/priests")
public class PriestRestController {

    private final PriestService priestService;

    @GetMapping(path = "/{id}")
    ResponseEntity<?> getPriestById(@PathVariable Long id) {
        return ResponseEntity.ok(priestService.getPriestById(id));
    }
}

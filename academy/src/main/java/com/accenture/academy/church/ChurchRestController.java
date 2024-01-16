package com.accenture.academy.church;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/churches")
@RequiredArgsConstructor
class ChurchRestController {

    private final ChurchService churchService;

    @GetMapping
    List<ChurchDao> getAllChurches() {
        return churchService.getAllChurches();
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<?> getChurchById(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(churchService.getChurchById(id));
        } catch (ChurchNotFoundException exception) {
            return ResponseEntity
                    .status(404)
                    .body(exception.getMessage());
        }
    }

    @PostMapping
    void addChurch(@RequestBody ChurchDto churchDto) {
        churchService.addChurch(churchDto);
    }
}

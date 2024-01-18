package com.accenture.academy.church;

import jakarta.servlet.http.Cookie;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/churches")
@RequiredArgsConstructor
class ChurchRestController {

    private final ChurchService churchService;

    @GetMapping
    List<ChurchDao> getAllChurches(@RequestParam(required = false) Optional<String> name) {
        if(name.isPresent()){
            return churchService.getAllByName(name);
        }
        return churchService.getAllChurches();
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<?> getChurchById(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(200)
                    .header("eluwina","byku")
                    .body(churchService.getChurchById(id));
        } catch (ChurchNotFoundException exception) {
            return ResponseEntity
                    .status(404)
                    .body(exception.getMessage());
        }
    }

    @PostMapping
    void addChurch(@RequestBody @Valid ChurchDto churchDto) {
        churchService.addChurch(churchDto);
    }


    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateChurch(@RequestBody ChurchDto churchDto, @PathVariable Long id){
        churchService.update(churchDto, id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteChurchById(@PathVariable Long id){
        churchService.deleteById(id);
    }

}

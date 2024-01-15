package com.accenture.academy.church;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/churches")
@RequiredArgsConstructor
class ChurchRestController {

    private final ChurchService churchService;

    @GetMapping
    List<ChurchDao> getAllChurches(){
        return churchService.getAllChurches();
    }
    @PostMapping
    void addChurch(@RequestBody ChurchDto churchDto){
        churchService.addChurch(churchDto);
    }
}

package com.accenture.academy.parish;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ParishRestController {
    private final ParishService parishService;

    @GetMapping
    List<ParishDao> getAllParishes() {
        return parishService.getAllParishes();
    }


    @PostMapping
    void addParish(@RequestBody ParishDto parishDto){
        parishService.addParish(parishDto);
    }



}

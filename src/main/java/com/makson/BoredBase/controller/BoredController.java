package com.makson.BoredBase.controller;

import com.makson.BoredBase.dto.BoredDto;
import com.makson.BoredBase.service.BoredService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BoredController {
    private final BoredService boredService;

    @GetMapping("/get/{i}")
    public ResponseEntity<List<String>> getActivities(@PathVariable(name = "i") int activitiesCount) {
        List<String> activities = boredService.getActivities(activitiesCount)
                .stream()
                .filter(boredDto -> boredDto.getPrice()==0.2)
                .map(BoredDto::getActivity)
                .collect(Collectors.toList());
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }
    @GetMapping("/get")
    @CrossOrigin
    public ResponseEntity<String> getBoredDto() {
        return boredService.getBoredDto().map(BoredDto::getActivity)
                .map(activity -> new ResponseEntity<>(activity, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

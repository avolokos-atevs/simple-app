package com.example.simpleapp.controller;

import com.example.simpleapp.domain.SimplePojo;
import com.example.simpleapp.service.SimpleService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class SimpleController {
    private final SimpleService simpleService;

    @ApiOperation(value = "Receive a string with an array of strings, " +
            "wrapped into json, extract it from json and store in memory.")
    @PostMapping("/")
    public ResponseEntity<String> addStringArrayToMemory(@RequestBody SimplePojo objects) {
        simpleService.addStringArrayToMemory(objects);
        return ResponseEntity.ok(objects.getStrings() + " Added to List");
    }

    @ApiOperation(value = "Receive a string and return json with array of strings, containing received string.")
    @GetMapping(value = "/{search}")
    public ResponseEntity<List<String>> getListByString(@PathVariable("search") String searchString) {
        return ResponseEntity.ok(simpleService.getListByString(searchString));
    }

    @ApiOperation(value = "Return amount of strings in the internal storage")
    @GetMapping("/")
    public ResponseEntity<String> getCount() {
        return ResponseEntity.ok(simpleService.getCount() + " elements are in memory now");
    }

    @ApiOperation(value = "Return all strings in the internal storage")
    @GetMapping("/all")
    public ResponseEntity<List<String>> getAll() {
        return ResponseEntity.ok(simpleService.getAll());
    }
}

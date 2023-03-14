package ru.rsreu.kibamba.linter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rsreu.kibamba.linter.model.Dorm;
import ru.rsreu.kibamba.linter.service.DormService;

import java.util.List;

@RestController
@RequestMapping("/dorms")
public class DormController {

    private DormService dormService;

    @Autowired
    public DormController(DormService dormService){
        this.dormService = dormService;
    }

    @GetMapping
    public ResponseEntity<List<Dorm>> getAll(){
        return ResponseEntity.ok(dormService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dorm> getById(@PathVariable long id){
        return ResponseEntity.ok(dormService.getById(id));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Dorm dorm){
        dormService.add(dorm);
        return new ResponseEntity(HttpStatus.OK);
    }
}

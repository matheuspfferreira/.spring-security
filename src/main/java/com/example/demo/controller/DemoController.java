package com.example.demo.controller;

import com.example.demo.entity.DemoEntity;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/demos")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/{id}")
    public ResponseEntity<DemoEntity> getReferenceById(@PathVariable Long id) {
        return ResponseEntity.ok().body(demoService.getReferenceById(id));
    }

    @PostMapping
    public ResponseEntity<DemoEntity> save(@RequestBody DemoEntity demoEntity) {
        DemoEntity request = demoService.save(demoEntity);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }
}

package com.example.demo.service;

import com.example.demo.entity.DemoEntity;
import com.example.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    public DemoEntity getReferenceById(Long id) {
        return demoRepository.getReferenceById(id);
    }

    public DemoEntity save(DemoEntity demoEntity) {
        return demoRepository.save(demoEntity);
    }
}

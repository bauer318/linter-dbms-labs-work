package ru.rsreu.kibamba.linter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rsreu.kibamba.linter.model.Dorm;
import ru.rsreu.kibamba.linter.repository.DormRepository;

import java.util.List;

@Service
public class DormServiceImpl implements DormService {

    private final DormRepository dormRepository;
    @Autowired
    public DormServiceImpl(DormRepository dormRepository){
        this.dormRepository = dormRepository;
    }
    @Override
    public void add(Dorm dorm) {
        dormRepository.save(dorm);
    }

    @Override
    public Dorm getById(long id) {
        return dormRepository.findById(id).orElseThrow(()->new RuntimeException());
    }

    @Override
    public List<Dorm> getAll() {
        return dormRepository.findAll();
    }
}

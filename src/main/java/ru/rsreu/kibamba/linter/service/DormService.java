package ru.rsreu.kibamba.linter.service;

import ru.rsreu.kibamba.linter.model.Dorm;

import java.util.List;

public interface DormService {
    void add(Dorm dorm);

    Dorm getById(long id);

    List<Dorm> getAll();
}

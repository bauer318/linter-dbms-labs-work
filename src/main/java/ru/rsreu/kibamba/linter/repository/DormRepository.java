package ru.rsreu.kibamba.linter.repository;

import ru.rsreu.kibamba.linter.model.Dorm;

import java.util.List;
import java.util.Optional;

public interface DormRepository {
    Optional<Dorm> findById(long id);

    void save(Dorm dorm);

    List<Dorm> findAll();

}

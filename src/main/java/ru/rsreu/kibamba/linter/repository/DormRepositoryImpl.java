package ru.rsreu.kibamba.linter.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.rsreu.kibamba.linter.model.Dorm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class DormRepositoryImpl implements DormRepository{
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public DormRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Dorm> findById(long id) {
        Dorm dorm = jdbcTemplate.queryForObject("SELECT dorm_number,dorm_address, telephone FROM dorms WHERE dorm_number =?", this::mapRowToDorm,id);
        return Optional.ofNullable(dorm);
    }

    @Override
    public void save(Dorm dorm) {
        jdbcTemplate.update("INSERT INTO dorms(dorm_number,dorm_address, telephone) VALUES (?,?,?)",
                dorm.getNumber(),dorm.getAddress(), dorm.getTelephone());
    }

    @Override
    public List<Dorm> findAll() {
        return jdbcTemplate.query("SELECT dorm_number, dorm_address, telephone FROM dorms",this::mapRowToDorm);
    }

    private Dorm mapRowToDorm(ResultSet resultSet, int rowNumber) throws SQLException{
        return new Dorm(
                resultSet.getLong("dorm_number"),
                resultSet.getString("dorm_address"),
                resultSet.getString("telephone")
        );
    }
}

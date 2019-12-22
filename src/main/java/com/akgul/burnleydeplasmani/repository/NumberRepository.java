package com.akgul.burnleydeplasmani.repository;

import com.akgul.burnleydeplasmani.model.Number;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NumberRepository extends MongoRepository<Number, Integer> {
    Number findByValue(Integer numberValue);
    Number findFirstByOrderByValueDesc();
    Number findFirstByOrderByValueAsc();
    List<Number> findAllByOrderByValueDesc();
    List<Number> findAllByOrderByValueAsc();
    void deleteByValue(Integer numberValue);
}

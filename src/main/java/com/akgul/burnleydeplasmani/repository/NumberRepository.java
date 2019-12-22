package com.akgul.burnleydeplasmani.repository;

import com.akgul.burnleydeplasmani.model.Number;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NumberRepository extends MongoRepository<Number, String> {
    Number findByValue(int value);
}

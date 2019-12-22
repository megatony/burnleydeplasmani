package com.akgul.burnleydeplasmani.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.ZonedDateTime;

@Getter
@Setter
public class Number {

    @Id
    private String id;

    @JsonProperty("number")
    @Indexed(unique = true)
    private int value;

    @JsonProperty("insert_time")
    private ZonedDateTime insertTime;

    public Number(int value) {
        this.value = value;
        this.insertTime = ZonedDateTime.now();
    }

    @Override
    public String toString() {
        return "Number{" +
                "id='" + id + '\'' +
                ", value=" + value +
                ", insertTime=" + insertTime.toString() +
                '}';
    }
}

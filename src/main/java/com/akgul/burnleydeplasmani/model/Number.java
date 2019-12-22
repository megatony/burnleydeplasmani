package com.akgul.burnleydeplasmani.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Document(collection = "number")
public class Number {
    private static final String NUMBER_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Id
    @JsonIgnore
    private String id;

    @JsonProperty("number")
    @Indexed(unique = true)
    private Integer value;

    @JsonProperty("insert_time")
    @JsonFormat(pattern = NUMBER_DATE_FORMAT)
    private LocalDateTime insertTime;

    public Number(Integer value) {
        this.value = value;
        this.insertTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Number{" +
                "id='" + id + '\'' +
                ", value=" + value +
                ", insertTime=" + insertTime.format(DateTimeFormatter.ofPattern(NUMBER_DATE_FORMAT)) +
                '}';
    }
}

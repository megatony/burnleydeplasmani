package com.akgul.burnleydeplasmani.controller;

import com.akgul.burnleydeplasmani.model.Number;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NumberControllerTest {
    @Mock
    private NumberController controller;

    @Test
    public void shouldInsertNumber() {
        Number number = new Number(3);
        when(controller.insertNumber(number.getValue())).thenReturn(number);
        Assert.assertEquals(controller.insertNumber(number.getValue()).getValue(), Integer.valueOf(3));
    }

    @Test
    public void shouldGetNumber() {
        Number number = new Number(3);
        when(controller.getNumber(3)).thenReturn(number);
        Assert.assertEquals(controller.getNumber(3), number);
    }

    @Test
    public void shouldGetMaximumNumber() {
        Number number3 = new Number(3);
        Number number4 = new Number(4);
        Number number5 = new Number(5);

        when(controller.insertNumber(number3.getValue())).thenReturn(number3);
        controller.insertNumber(number3.getValue());
        when(controller.insertNumber(number4.getValue())).thenReturn(number4);
        controller.insertNumber(number4.getValue());
        when(controller.insertNumber(number5.getValue())).thenReturn(number5);
        controller.insertNumber(number5.getValue());

        when(controller.getMaximumNumber()).thenReturn(number5);
        Assert.assertEquals(controller.getMaximumNumber(), number5);
    }

    @Test
    public void shouldGetMinimumNumber() {
        Number number3 = new Number(3);
        Number number4 = new Number(4);
        Number number5 = new Number(5);

        when(controller.insertNumber(number3.getValue())).thenReturn(number3);
        controller.insertNumber(number3.getValue());
        when(controller.insertNumber(number4.getValue())).thenReturn(number4);
        controller.insertNumber(number4.getValue());
        when(controller.insertNumber(number5.getValue())).thenReturn(number5);
        controller.insertNumber(number5.getValue());

        when(controller.getMinimumNumber()).thenReturn(number3);
        Assert.assertEquals(controller.getMinimumNumber(), number3);
    }

    @Test
    public void shouldDeleteNumber() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Value 3 deleted from DB.");
        when(controller.deleteNumber(3)).thenReturn(response);
        Assert.assertEquals(controller.deleteNumber(3), response);
    }

    @Test
    public void shouldNotDeleteWhenNumberNotExist() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Value 33 not found at DB.");
        when(controller.deleteNumber(33)).thenReturn(response);
        Assert.assertEquals(controller.deleteNumber(33), response);
    }

    @Test
    public void shouldGetAllValuesAscending() {
        Number number3 = new Number(3);
        Number number4 = new Number(4);
        Number number5 = new Number(5);

        ArrayList<Number> numbers = new ArrayList<>();
        numbers.add(number4);
        numbers.add(number3);
        numbers.add(number5);

        numbers.sort(Comparator.comparingInt(Number::getValue));

        when(controller.getAllNumbersAscending()).thenReturn(numbers);
        Assert.assertEquals(controller.getAllNumbersAscending().get(0), number3);
    }

    @Test
    public void shouldGetAllValuesDescending() {
        Number number3 = new Number(3);
        Number number4 = new Number(4);
        Number number5 = new Number(5);

        ArrayList<Number> numbers = new ArrayList<>();
        numbers.add(number4);
        numbers.add(number3);
        numbers.add(number5);

        numbers.sort(Comparator.comparingInt(Number::getValue).reversed());

        when(controller.getAllNumbersDescending()).thenReturn(numbers);
        Assert.assertEquals(controller.getAllNumbersDescending().get(0), number5);
    }

    @Test
    public void shouldDateFormatValid() {
        Number number = new Number(3);
        LocalDateTime insertTime = LocalDateTime.parse("2010-03-18 12:21:48", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        number.setInsertTime(insertTime);

        Assert.assertEquals(number.toString(), "Number{id='null', value=3, insertTime=2010-03-18 12:21:48}");
    }
}

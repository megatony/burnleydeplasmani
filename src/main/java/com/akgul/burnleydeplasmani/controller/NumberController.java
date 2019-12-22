package com.akgul.burnleydeplasmani.controller;

import com.akgul.burnleydeplasmani.model.Number;
import com.akgul.burnleydeplasmani.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/number")
public class NumberController {

    @Autowired
    private NumberRepository repository;

    @RequestMapping(value = "/{number}", method = RequestMethod.POST)
    public Number insertNumber(@PathVariable(value = "number") int numberValue) {
        Number number = new Number(numberValue);
        return repository.insert(number);
    }

    @RequestMapping(value = "/{number}", method = RequestMethod.GET)
    public @ResponseBody
    Number getNumber(@PathVariable(value = "number") int value) {
        return repository.findByValue(value);
    }

    @RequestMapping(value = "/maximum", method = RequestMethod.GET)
    public @ResponseBody
    Number getMaximumNumber() {
        return repository.findFirstByOrderByValueDesc();
    }

    @RequestMapping(value = "/minimum", method = RequestMethod.GET)
    public @ResponseBody
    Number getMinimumNumber() {
        return repository.findFirstByOrderByValueAsc();
    }

    @RequestMapping(value = "/{number}", method = RequestMethod.DELETE)
    public @ResponseBody Map<String, String> deleteNumber(@PathVariable(value = "number") int value) {
        Map<String, String> response = new HashMap<>();

        if (repository.findByValue(value) == null) {
            response.put("message", "Value " + value + " not found at DB.");
            return response;
        }

        repository.deleteByValue(value);
        response.put("message", "Value " + value + " deleted from DB.");

        return response;
    }

    @RequestMapping(value = {"/", "/ascending"}, method = RequestMethod.GET)
    public @ResponseBody List<Number> getAllNumbersAscending() {
        return repository.findAllByOrderByValueAsc();
    }

    @RequestMapping(value = "/descending", method = RequestMethod.GET)
    public List<Number> getAllNumbersDescending() {
        return repository.findAllByOrderByValueDesc();
    }


}

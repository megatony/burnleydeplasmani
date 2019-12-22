package com.akgul.burnleydeplasmani.controller;

import com.akgul.burnleydeplasmani.model.Number;
import com.akgul.burnleydeplasmani.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController(value = "/number")
public class NumberController {

    @Autowired
    private NumberRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Number insertNumber(@RequestBody Number number) {
        return number;
    }

    @RequestMapping(value = "/{number}", method = RequestMethod.GET)
    public @ResponseBody Number getNumber(@PathVariable(value = "number") int value) {
        return null;
    }

    @RequestMapping(value = "/maximum", method = RequestMethod.GET)
    public @ResponseBody Number getMaximumNumber() {
        return null;
    }

    @RequestMapping(value = "/minimum", method = RequestMethod.GET)
    public @ResponseBody Number getMinimumNumber() {
        return null;
    }

    @RequestMapping(value = "/{number}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteNumber(@PathVariable(value = "number") int value) {
        return null;
    }

    @RequestMapping(value = {"/", "/ascending"}, method = RequestMethod.GET)
    public @ResponseBody ArrayList<Number> getAllNumbersAscending() {
        return null;
    }

    @RequestMapping(value = "/descending", method = RequestMethod.GET)
    public ArrayList<Number> getAllNumbersDescending() {
        return null;
    }


}

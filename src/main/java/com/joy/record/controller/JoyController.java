package com.joy.record.controller;

import com.joy.record.model.Joy;
import com.joy.record.service.JoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/joy")
public class JoyController {

    @Autowired
    private JoyService joyService;


    @GetMapping("/selectJoyList")
    public List<Joy> selectJoyList(@RequestParam HashMap<String, Object> param) {
        return joyService.selectJoyList(param);
    }

    @PostMapping("/insertJoy")
    public HashMap<String, Object> insertJoy(@RequestParam HashMap<String, Object> param) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", joyService.insertJoy(param));
        return result;
    }

    @PutMapping("/updateJoy")
    public HashMap<String, Object> updateJoy(@RequestParam HashMap<String, Object> param) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", joyService.updateJoy(param));
        return result;
    }

    @PutMapping("/deleteJoy")
    public HashMap<String, Object> deleteJoy(@RequestParam HashMap<String, Object> param) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", joyService.deleteJoy(param));
        return result;
    }
}

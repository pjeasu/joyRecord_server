package com.joy.record.controller;

import com.joy.record.model.Joy;
import com.joy.record.service.JoyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/joy")
public class JoyController {

    @Autowired
    private JoyService joyService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/selectJoyList")
    public List<Joy> selectJoyList(@RequestParam HashMap<String, Object> param) {

        logger.info("=======================selectJoyList");
        logger.info(String.valueOf(param));


        return joyService.selectJoyList(param);
    }

    @PostMapping("/insertJoy")
    public HashMap<String, Object> insertJoy(@RequestParam HashMap<String, Object> param) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", joyService.insertJoy(param));
        return result;
    }

    @PutMapping("/updateJoy")
    public HashMap<String, Object> updateJoy(@RequestBody HashMap<String, Object> param) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", joyService.updateJoy(param));
        return result;
    }

    @GetMapping("/selectJoyCount")
    public List<Joy> selectJoyCount(@RequestParam HashMap<String, Object> param) {
        logger.info("=======================selectJoyCount");
        logger.info(String.valueOf(param));

        return joyService.selectJoyCount(param);
    }

    @GetMapping("/selectJoyCountMonth")
    public List<Joy> selectJoyCountMonth(@RequestParam HashMap<String, Object> param) {
        return joyService.selectJoyCountMonth(param);
    }


}

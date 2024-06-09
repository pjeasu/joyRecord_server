package com.joy.record.controller;

import com.joy.record.model.Joy;
import com.joy.record.service.MemberJoyRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class MemberJoyRController {

    @Autowired
    private MemberJoyRService memberJoyRService;


    @GetMapping("/selectMemberJoyRList")
    public List<Joy> selectMemberJoyRList(@RequestParam HashMap<String, Object> param) {
        return memberJoyRService.selectMemberJoyRList(param);
    }


    @PostMapping("/insertMemberJoyR")
    public HashMap<String, Object> insertMemberJoyR(@RequestParam HashMap<String, Object> param) {
        System.out.println("insertMemberJoyR");
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", memberJoyRService.insertMemberJoyR(param));
        System.out.println(result);
        return result;
    }

    @PutMapping("/updateMemberJoyR")
    public HashMap<String, Object> updateMemberJoyR(@RequestParam HashMap<String, Object> param) {
        System.out.println("updateMemberJoyR");
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", memberJoyRService.updateMemberJoyR(param));
        return result;
    }

    @DeleteMapping("/deleteMemberJoyR")
    public HashMap<String, Object> deleteMemberJoyR(@RequestParam HashMap<String, Object> param) {
        System.out.println("deleteMemberJoyR");
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", memberJoyRService.deleteMemberJoyR(param));
        return result;
    }
}

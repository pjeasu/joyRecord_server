package com.joy.record.controller;

import com.joy.record.model.Board;
import com.joy.record.model.BoardFileR;
import com.joy.record.service.BoardFileRService;
import com.joy.record.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/boardFileR")
public class BoardFileRController {

    @Autowired
    private BoardFileRService boardFileRService;


    @GetMapping("/selectBoardFile")
    public List<BoardFileR> selectBoardFile(@RequestParam HashMap<String, Object> param) {
        return boardFileRService.selectBoardFile(param);
    }

}
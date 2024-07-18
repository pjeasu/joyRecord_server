package com.joy.record.controller;

import com.joy.record.model.Board;
import com.joy.record.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    @Autowired
    private BoardService boardService;


    @GetMapping("/selectBoardList")
    public List<Board> selectBoardList(@RequestParam HashMap<String, Object> param) {
        return boardService.selectBoardList(param);
    }

    @GetMapping("/selectBoardOne")
    public Board selectBoardOne(@RequestParam HashMap<String, Object> param) {
        return boardService.selectBoardOne(param);
    }

    @PostMapping("/insertBoard")
    public HashMap<String, Object> insertBoard(@RequestParam HashMap<String, Object> param) {
        return boardService.insertBoard(param);
    }
    @PutMapping("/updateBoard")
    public HashMap<String, Object> updateBoard(@RequestBody HashMap<String, Object> param) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", boardService.updateBoard(param));
        return result;
    }


    @PutMapping("/deleteBoard")
    public HashMap<String, Object> deleteBoard(@RequestParam HashMap<String, Object> param) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", boardService.deleteBoard(param));
        return result;
    }
}

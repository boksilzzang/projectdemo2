package com.example.projectdemo.controller;

import com.example.projectdemo.dto.CommentDTO;
import com.example.projectdemo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/write")
    public ResponseEntity save(@ModelAttribute CommentDTO commentDTO) {
        Long saveResult = commentService.save(commentDTO);
        if(saveResult != null) {
            // 작성 성공하면 댓글 목록을 가져와서 리턴
            List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getPostNo());
            return new ResponseEntity<>(commentDTOList, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("해당 게시글이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }
    }



}

package com.example.projectdemo.service;

import com.example.projectdemo.dto.CommentDTO;
import com.example.projectdemo.entity.BoardEntity;
import com.example.projectdemo.entity.CommentEntity;
import com.example.projectdemo.repository.BoardRepository;
import com.example.projectdemo.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    public Long save(CommentDTO commentDTO) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(commentDTO.getPostNo());
        if (optionalBoardEntity.isPresent()) {
            BoardEntity boardEntity = optionalBoardEntity.get();
            CommentEntity commentEntity = CommentEntity.toSaveEntity(commentDTO, boardEntity);
            return commentRepository.save(commentEntity).getCmId();
        } else {
            return null;
        }
    }

    public List<CommentDTO> findAll(Long postNo) {
        BoardEntity boardEntity = boardRepository.findById(postNo).get();
        List<CommentEntity> commentEntityList = commentRepository.findAllByBoardEntityOrderByCmIdDesc(boardEntity);

        List<CommentDTO> commentDTOList = new ArrayList<>();
        for(CommentEntity commentEntity : commentEntityList){
            CommentDTO commentDTO = CommentDTO.toCommentDTO(commentEntity, postNo);
            commentDTOList.add(commentDTO);
        }
        return commentDTOList;
    }
}

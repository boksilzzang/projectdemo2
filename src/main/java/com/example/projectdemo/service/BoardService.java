package com.example.projectdemo.service;

import com.example.projectdemo.dto.BoardDTO;
import com.example.projectdemo.entity.BoardEntity;
import com.example.projectdemo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();

        List<BoardDTO> boardDTOList = new ArrayList<>();

        // entity -> DTO
        for(BoardEntity boardEntity : boardEntityList){
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }
    @Transactional
    public BoardDTO findById(Long postNo) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(postNo);
        BoardEntity boardEntity = optionalBoardEntity.get();
        BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity);
        return boardDTO;
    }

    public Long save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        BoardEntity savedEntity = boardRepository.save(boardEntity);

        return savedEntity.getPostNo();
    }

    public BoardDTO update(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toUpdateEntity(boardDTO);
        boardRepository.save(boardEntity); //update쿼리 수행

        return findById(boardDTO.getPostNo());
    }

    public void delete(Long postNo) {
        boardRepository.deleteById(postNo);
    }
    @Transactional
    public void updateViews(Long postNo) {
        boardRepository.updateViews(postNo);
    }
}

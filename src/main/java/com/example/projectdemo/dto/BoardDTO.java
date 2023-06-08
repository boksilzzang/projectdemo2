package com.example.projectdemo.dto;

import com.example.projectdemo.entity.BoardEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor//기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
public class BoardDTO {
    private Long postNo;
    private Long category;
    private String title;
    private String content;
    private String author;
    private LocalDateTime postDate;
    private int views;
    private String link;

//    private MultipartFile boardFile;
//    private String originalFileName;
//    private String storedFileName;

    public static BoardDTO toBoardDTO(BoardEntity boardEntity) {
        BoardDTO boardDTO = new BoardDTO();

        boardDTO.setPostNo(boardEntity.getPostNo());
        boardDTO.setCategory(boardEntity.getCategory());
        boardDTO.setTitle(boardEntity.getTitle());
        boardDTO.setContent(boardEntity.getContent());
        boardDTO.setAuthor(boardEntity.getAuthor());
        boardDTO.setPostDate(boardEntity.getPostDate());
        boardDTO.setViews(boardEntity.getViews());
        boardDTO.setLink(boardEntity.getLink());

//        boardDTO.setOriginalFileName(boardEntity.getOriginFileName());
//        boardDTO.setStoredFileName(boardEntity.getStoredFileName());

        return boardDTO;
    }
}

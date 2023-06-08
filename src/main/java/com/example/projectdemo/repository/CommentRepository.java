package com.example.projectdemo.repository;

import com.example.projectdemo.entity.BoardEntity;
import com.example.projectdemo.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findAllByBoardEntityOrderByCmIdDesc(BoardEntity boardEntity);


}

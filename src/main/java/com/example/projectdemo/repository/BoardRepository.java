package com.example.projectdemo.repository;

import com.example.projectdemo.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    // update board_table set board_views = board_views+1 where id=?

    @Modifying
    @Query(value="update BoardEntity  b set b.views=b.views+1 where b.postNo=:postNo")
    void updateViews(@Param("postNo") Long postNo);
}

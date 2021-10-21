package com.example.music_db.repository;

import com.example.music_db.model.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

    @Query("SELECT a FROM AlbumEntity a ORDER BY a.copies DESC")
    List<AlbumEntity> findAllAlbumsAndSortThemByNumberOfCopiesInDesc();


}

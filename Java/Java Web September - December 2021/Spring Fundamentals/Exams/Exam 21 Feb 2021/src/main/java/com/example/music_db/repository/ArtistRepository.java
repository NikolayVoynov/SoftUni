package com.example.music_db.repository;

import com.example.music_db.model.entity.ArtistEntity;
import com.example.music_db.model.entity.enums.ArtistNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {

    Optional<ArtistEntity> findByName(ArtistNameEnum artistNameEnum);
}

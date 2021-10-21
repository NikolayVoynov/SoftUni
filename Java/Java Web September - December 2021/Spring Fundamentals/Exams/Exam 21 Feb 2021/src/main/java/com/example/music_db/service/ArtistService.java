package com.example.music_db.service;

import com.example.music_db.model.entity.ArtistEntity;
import com.example.music_db.model.entity.enums.ArtistNameEnum;

public interface ArtistService {
    void initArtists();


    ArtistEntity findByArtistNameEnum(ArtistNameEnum artistNameEnum);
}

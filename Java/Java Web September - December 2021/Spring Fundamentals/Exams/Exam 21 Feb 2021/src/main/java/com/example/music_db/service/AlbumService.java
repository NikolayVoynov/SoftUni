package com.example.music_db.service;

import com.example.music_db.model.entity.AlbumEntity;
import com.example.music_db.model.service.AlbumServiceModel;
import com.example.music_db.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void addAlbum(AlbumServiceModel albumServiceModel);

    List<AlbumViewModel> findAllAlbumsOrderedByCopiesInDescOrder();

    void deleteAlbum(Long id);
}

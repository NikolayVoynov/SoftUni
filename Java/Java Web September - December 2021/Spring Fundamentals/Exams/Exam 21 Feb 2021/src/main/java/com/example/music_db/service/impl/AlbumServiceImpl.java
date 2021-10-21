package com.example.music_db.service.impl;

import com.example.music_db.model.entity.AlbumEntity;
import com.example.music_db.model.service.AlbumServiceModel;
import com.example.music_db.model.view.AlbumViewModel;
import com.example.music_db.repository.AlbumRepository;
import com.example.music_db.sec.CurrentUser;
import com.example.music_db.service.AlbumService;
import com.example.music_db.service.ArtistService;
import com.example.music_db.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ArtistService artistService;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper,
                            CurrentUser currentUser, UserService userService,
                            ArtistService artistService) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.artistService = artistService;
    }

    @Override
    public void addAlbum(AlbumServiceModel albumServiceModel) {

        AlbumEntity albumEntity = modelMapper.map(albumServiceModel, AlbumEntity.class);
        albumEntity.setAddedFrom(userService.findById(currentUser.getId()));
        albumEntity.setArtist(artistService.findByArtistNameEnum(albumServiceModel.getArtist()));
        albumEntity.setGenre(albumServiceModel.getGenre());

        albumRepository.save(albumEntity);
    }

    @Override
    public List<AlbumViewModel> findAllAlbumsOrderedByCopiesInDescOrder() {
        return albumRepository.findAllAlbumsAndSortThemByNumberOfCopiesInDesc()
                .stream()
                .map(albumEntity -> modelMapper.map(albumEntity,AlbumViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAlbum(Long id) {

        albumRepository.deleteById(id);
    }
}

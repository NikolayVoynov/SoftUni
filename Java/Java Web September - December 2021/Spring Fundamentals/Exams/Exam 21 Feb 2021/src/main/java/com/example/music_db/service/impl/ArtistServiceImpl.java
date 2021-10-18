package com.example.music_db.service.impl;

import com.example.music_db.model.entity.ArtistCareerInfo;
import com.example.music_db.model.entity.ArtistEntity;
import com.example.music_db.model.entity.enums.ArtistNameEnum;
import com.example.music_db.repository.ArtistRepository;
import com.example.music_db.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void initArtists() {

        if (artistRepository.count() != 0) {
            return;
        }

        Arrays.stream(ArtistNameEnum.values())
                .forEach(artistNameEnum -> {
                    ArtistEntity artistEntity = new ArtistEntity();
                    artistEntity.setName(artistNameEnum);
                    switch (artistNameEnum) {
                        case Queen -> artistEntity.setCareerInformation(ArtistCareerInfo.QUEEN_CAREER);
                        case Metallica -> artistEntity.setCareerInformation(ArtistCareerInfo.METALLICA_CAREER);
                        case Madonna -> artistEntity.setCareerInformation(ArtistCareerInfo.MADONNA_CAREER);
                    }

                    artistRepository.save(artistEntity);
                });
    }
}

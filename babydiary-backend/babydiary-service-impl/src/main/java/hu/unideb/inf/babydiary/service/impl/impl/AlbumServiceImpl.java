package hu.unideb.inf.babydiary.service.impl.impl;

import hu.unideb.inf.babydiary.commons.pojo.request.AlbumRequest;
import hu.unideb.inf.babydiary.persistence.entity.AlbumEntity;
import hu.unideb.inf.babydiary.persistence.repository.AlbumRepository;
import hu.unideb.inf.babydiary.service.api.domain.Album;
import hu.unideb.inf.babydiary.service.api.service.AlbumService;
import hu.unideb.inf.babydiary.service.impl.converter.album.AlbumEntityListToAlbumListConverter;
import hu.unideb.inf.babydiary.service.impl.converter.album.AlbumEntityToAlbumConverter;
import hu.unideb.inf.babydiary.service.impl.converter.album.AlbumRequestToAlbumConverter;
import hu.unideb.inf.babydiary.service.impl.converter.album.AlbumToAlbumEntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRequestToAlbumConverter fromRequest;

    private final AlbumToAlbumEntityConverter toAlbumEntityConverter;

    private final AlbumEntityToAlbumConverter toAlbumConverter;

    private final AlbumEntityListToAlbumListConverter toAlbumListConverter;

    private final AlbumRepository albumRepository;

    @Override
    public void saveAlbum(AlbumRequest albumRequest) {
        Album album = fromRequest.convert(albumRequest);
        assert album != null;
        AlbumEntity albumEntity = toAlbumEntityConverter.convert(album);
        assert albumEntity != null;
        albumRepository.save(albumEntity);
    }

    @Override
    public void deleteAlbum(Long id) {
    }

    @Override
    public Album findAlbumById(Long id) {
        AlbumEntity albumEntity = albumRepository.getOne(id);
        return toAlbumConverter.convert(albumEntity);
    }

    @Override
    public List<Album> findAllAlbum() {
        List<AlbumEntity> albumEntities = albumRepository.findAll();
        return toAlbumListConverter.convert(albumEntities);
    }
}

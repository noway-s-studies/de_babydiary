package hu.unideb.inf.babydiary.service.impl.converter.album;

import hu.unideb.inf.babydiary.persistence.entity.AlbumEntity;
import hu.unideb.inf.babydiary.service.api.domain.Album;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AlbumEntityListToAlbumListConverter implements Converter<List<AlbumEntity>, List<Album>> {

    private final AlbumEntityToAlbumConverter toAlbumConverter;

    @Override
    public List<Album> convert(List<AlbumEntity> albumEntities) {
        return albumEntities.stream().map(toAlbumConverter::convert).collect(Collectors.toList());
    }
}

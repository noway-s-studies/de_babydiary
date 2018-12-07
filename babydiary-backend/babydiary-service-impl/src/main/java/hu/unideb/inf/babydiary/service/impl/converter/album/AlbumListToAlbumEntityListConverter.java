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
public class AlbumListToAlbumEntityListConverter implements Converter<List<Album>, List<AlbumEntity>> {

    private final AlbumToAlbumEntityConverter toAlbumEntityConverter;

    @Override
    public List<AlbumEntity> convert(List<Album> albums) {
        return albums.stream().map(toAlbumEntityConverter::convert).collect(Collectors.toList());
    }
}

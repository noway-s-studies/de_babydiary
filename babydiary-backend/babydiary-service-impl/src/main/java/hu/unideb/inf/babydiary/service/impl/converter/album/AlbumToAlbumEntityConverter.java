package hu.unideb.inf.babydiary.service.impl.converter.album;

import hu.unideb.inf.babydiary.persistence.entity.AlbumEntity;
import hu.unideb.inf.babydiary.service.api.domain.Album;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AlbumToAlbumEntityConverter implements Converter<Album, AlbumEntity> {

    @Override
    public AlbumEntity convert(Album album) {
        return AlbumEntity.builder()
                .id(album.getId())
                .name(album.getName())
                .link(album.getLink())
                .build();
    }
}

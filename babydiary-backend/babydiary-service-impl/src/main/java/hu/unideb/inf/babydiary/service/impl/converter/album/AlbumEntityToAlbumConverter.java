package hu.unideb.inf.babydiary.service.impl.converter.album;

import hu.unideb.inf.babydiary.persistence.entity.AlbumEntity;
import hu.unideb.inf.babydiary.service.api.domain.Album;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AlbumEntityToAlbumConverter implements Converter<AlbumEntity, Album> {

    @Override
    public Album convert(AlbumEntity albumEntity) {
        return Album.builder()
                .id(albumEntity.getId())
                .name(albumEntity.getName())
                .link(albumEntity.getLink())
                .build();
    }
}

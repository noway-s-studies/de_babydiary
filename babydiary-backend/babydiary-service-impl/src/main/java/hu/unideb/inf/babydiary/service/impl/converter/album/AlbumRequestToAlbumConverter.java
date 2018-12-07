package hu.unideb.inf.babydiary.service.impl.converter.album;

import hu.unideb.inf.babydiary.commons.pojo.request.AlbumRequest;
import hu.unideb.inf.babydiary.service.api.domain.Album;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AlbumRequestToAlbumConverter implements Converter<AlbumRequest, Album> {

    @Override
    public Album convert(AlbumRequest albumRequest) {
        return Album.builder()
                .link(albumRequest.getLink())
                .name(albumRequest.getName())
                .build();
    }
}

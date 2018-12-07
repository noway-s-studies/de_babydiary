package hu.unideb.inf.babydiary.service.impl.converter.album;

import hu.unideb.inf.babydiary.service.api.domain.Album;
import hu.unideb.inf.babydiary.service.api.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AlbumIdListToAlbumListConverter implements Converter<List<Long>, List<Album>> {

    private final AlbumService albumService;

    @Override
    public List<Album> convert(List<Long> longs) {
        return longs.stream().map(albumService::findAlbumById).collect(Collectors.toList());
    }
}

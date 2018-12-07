package hu.unideb.inf.babydiary.service.impl.converter.child;

import hu.unideb.inf.babydiary.commons.pojo.request.ChildRequest;
import hu.unideb.inf.babydiary.service.api.domain.Child;
import hu.unideb.inf.babydiary.service.impl.converter.album.AlbumIdListToAlbumListConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChildRequestToChildConverter implements Converter<ChildRequest, Child> {

    private final AlbumIdListToAlbumListConverter toAlbumListConverter;

    @Override
    public Child convert(ChildRequest childRequest) {
        return Child.builder()
                .firstName(childRequest.getFirstName())
                .lastName(childRequest.getLastName())
                .sex(childRequest.getSex())
                .conception(childRequest.getConception())
                .birthday(childRequest.getBirthday())
                .albums(toAlbumListConverter.convert(childRequest.getAlbumIds()))
                .build();
    }
}

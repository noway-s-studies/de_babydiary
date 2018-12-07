package hu.unideb.inf.babydiary.service.impl.converter.child;

import hu.unideb.inf.babydiary.persistence.entity.ChildEntity;
import hu.unideb.inf.babydiary.service.api.domain.Child;
import hu.unideb.inf.babydiary.service.impl.converter.album.AlbumEntityListToAlbumListConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChildEntityToChildConverter implements Converter<ChildEntity, Child> {

    private final AlbumEntityListToAlbumListConverter toAlbumConverter;

    @Override
    public Child convert(ChildEntity childEntity) {
        return Child.builder()
                .id(childEntity.getId())
                .firstName(childEntity.getFirstName())
                .lastName(childEntity.getLastName())
                .sex(childEntity.getSex())
                .height(childEntity.getHeight())
                .weight(childEntity.getWeight())
                .conception(childEntity.getConception())
                .birthday(childEntity.getBirthday())
                .albums(toAlbumConverter.convert(childEntity.getAlbums()))
                .build();
    }
}

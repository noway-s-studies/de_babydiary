package hu.unideb.inf.babydiary.service.impl.converter.child;

import hu.unideb.inf.babydiary.persistence.entity.ChildEntity;
import hu.unideb.inf.babydiary.service.api.domain.Child;
import hu.unideb.inf.babydiary.service.impl.converter.album.AlbumListToAlbumEntityListConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ChildToChildEntityConverter implements Converter<Child, ChildEntity> {

    private final AlbumListToAlbumEntityListConverter toAlbumEntityConverter;

    @Override
    public ChildEntity convert(Child child) {
        return ChildEntity.builder()
                .id(child.getId())
                .firstName(child.getFirstName())
                .lastName(child.getLastName())
                .sex(child.getSex())
                .height(child.getHeight())
                .weight(child.getWeight())
                .conception(child.getConception())
                .birthday(child.getBirthday())
                .albums(toAlbumEntityConverter.convert(child.getAlbums()))
                .build();
    }
}

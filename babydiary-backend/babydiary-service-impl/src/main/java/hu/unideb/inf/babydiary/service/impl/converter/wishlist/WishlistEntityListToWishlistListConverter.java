package hu.unideb.inf.babydiary.service.impl.converter.wishlist;

import hu.unideb.inf.babydiary.persistence.entity.WishlistEntity;
import hu.unideb.inf.babydiary.service.api.domain.Wishlist;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WishlistEntityListToWishlistListConverter implements Converter<List<WishlistEntity>, List<Wishlist>> {

    private final WishlistEntityToWishlistConverter wishlistConverter;

    @Override
    public List<Wishlist> convert(List<WishlistEntity> wishlistEntities) {
        return wishlistEntities.stream().map(wishlistConverter::convert).collect(Collectors.toList());
    }
}

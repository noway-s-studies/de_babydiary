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
public class WishlistListToWishlistEntityListConverter implements Converter<List<Wishlist>, List<WishlistEntity>> {

    private final WishlistToWishlistEntityConverter toWishlistEntityConverter;

    @Override
    public List<WishlistEntity> convert(List<Wishlist> wishlists) {
        return wishlists.stream().map(toWishlistEntityConverter::convert).collect(Collectors.toList());
    }
}

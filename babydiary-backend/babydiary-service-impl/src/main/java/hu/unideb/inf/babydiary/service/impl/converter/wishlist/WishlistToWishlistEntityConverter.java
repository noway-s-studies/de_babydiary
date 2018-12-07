package hu.unideb.inf.babydiary.service.impl.converter.wishlist;

import hu.unideb.inf.babydiary.persistence.entity.WishlistEntity;
import hu.unideb.inf.babydiary.service.api.domain.Wishlist;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WishlistToWishlistEntityConverter implements Converter<Wishlist, WishlistEntity> {

    @Override
    public WishlistEntity convert(Wishlist wishlist) {
        return WishlistEntity.builder()
                .id(wishlist.getId())
                .item(wishlist.getItem())
                .price(wishlist.getPrice())
                .build();
    }
}

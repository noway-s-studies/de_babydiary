package hu.unideb.inf.babydiary.service.impl.converter.wishlist;

import hu.unideb.inf.babydiary.persistence.entity.WishlistEntity;
import hu.unideb.inf.babydiary.service.api.domain.Wishlist;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WishlistEntityToWishlistConverter implements Converter<WishlistEntity, Wishlist> {

    @Override
    public Wishlist convert(WishlistEntity wishlistEntity) {
        return Wishlist.builder()
                .id(wishlistEntity.getId())
                .item(wishlistEntity.getItem())
                .price(wishlistEntity.getPrice())
                .build();
    }
}

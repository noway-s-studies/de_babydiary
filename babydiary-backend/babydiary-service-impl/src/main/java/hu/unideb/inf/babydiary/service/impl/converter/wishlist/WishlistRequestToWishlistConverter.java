package hu.unideb.inf.babydiary.service.impl.converter.wishlist;

import hu.unideb.inf.babydiary.commons.pojo.request.WishlistRequest;
import hu.unideb.inf.babydiary.service.api.domain.Wishlist;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WishlistRequestToWishlistConverter implements Converter<WishlistRequest, Wishlist> {

    @Override
    public Wishlist convert(WishlistRequest wishlistRequest) {
        return Wishlist.builder()
                .item(wishlistRequest.getItem())
                .price(wishlistRequest.getPrice())
                .build();
    }
}

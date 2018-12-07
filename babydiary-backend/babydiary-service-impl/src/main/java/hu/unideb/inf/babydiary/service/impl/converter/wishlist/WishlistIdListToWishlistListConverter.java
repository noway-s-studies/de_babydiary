package hu.unideb.inf.babydiary.service.impl.converter.wishlist;

import hu.unideb.inf.babydiary.service.api.domain.Wishlist;
import hu.unideb.inf.babydiary.service.api.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WishlistIdListToWishlistListConverter implements Converter<List<Long>, List<Wishlist>> {

    private final WishListService wishListService;

    @Override
    public List<Wishlist> convert(List<Long> longs) {
        return longs.stream().map(wishListService::findWishlistById).collect(Collectors.toList());
    }
}

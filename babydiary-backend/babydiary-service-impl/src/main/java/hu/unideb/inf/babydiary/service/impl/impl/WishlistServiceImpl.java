package hu.unideb.inf.babydiary.service.impl.impl;

import hu.unideb.inf.babydiary.commons.pojo.request.WishlistRequest;
import hu.unideb.inf.babydiary.persistence.entity.WishlistEntity;
import hu.unideb.inf.babydiary.persistence.repository.WishlistRepository;
import hu.unideb.inf.babydiary.service.api.domain.Wishlist;
import hu.unideb.inf.babydiary.service.api.service.WishListService;
import hu.unideb.inf.babydiary.service.impl.converter.wishlist.WishlistEntityListToWishlistListConverter;
import hu.unideb.inf.babydiary.service.impl.converter.wishlist.WishlistEntityToWishlistConverter;
import hu.unideb.inf.babydiary.service.impl.converter.wishlist.WishlistRequestToWishlistConverter;
import hu.unideb.inf.babydiary.service.impl.converter.wishlist.WishlistToWishlistEntityConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishListService {

    private final WishlistRequestToWishlistConverter fromRequest;

    private final WishlistToWishlistEntityConverter toWishlistEntityConverter;

    private final WishlistEntityToWishlistConverter toWishlistConverter;

    private final WishlistEntityListToWishlistListConverter toWishlistListConverter;

    private final WishlistRepository wishlistRepository;

    @Override
    public void saveWishList(WishlistRequest wishlistRequest) {
        Wishlist wishlist = fromRequest.convert(wishlistRequest);
        assert wishlist != null;
        WishlistEntity wishlistEntity = toWishlistEntityConverter.convert(wishlist);
        assert wishlistEntity != null;
        wishlistRepository.save(wishlistEntity);
    }

    @Override
    public Wishlist findWishlistById(Long id) {
        WishlistEntity wishlistEntity = wishlistRepository.getOne(id);
        return toWishlistConverter.convert(wishlistEntity);
    }

    @Override
    public List<Wishlist> findAll() {
        List<WishlistEntity> wishlistEntities = wishlistRepository.findAll();
        return toWishlistListConverter.convert(wishlistEntities);
    }
}

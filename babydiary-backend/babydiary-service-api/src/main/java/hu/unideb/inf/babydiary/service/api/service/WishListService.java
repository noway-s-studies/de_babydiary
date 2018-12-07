package hu.unideb.inf.babydiary.service.api.service;

import hu.unideb.inf.babydiary.commons.pojo.request.WishlistRequest;
import hu.unideb.inf.babydiary.service.api.domain.Wishlist;

import java.util.List;

public interface WishListService {

    void saveWishList(WishlistRequest wishlistRequest);

    Wishlist findWishlistById(Long id);

    List<Wishlist> findAll();
}

package hu.unideb.inf.babydiary.backend.rest;

import hu.unideb.inf.babydiary.commons.pojo.request.WishlistRequest;
import hu.unideb.inf.babydiary.service.api.domain.Wishlist;
import hu.unideb.inf.babydiary.service.api.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static hu.unideb.inf.babydiary.commons.pojo.path.WishListPath.*;

@RestController
@RequiredArgsConstructor
public class WishlistRestController {

    private final WishListService wishListService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = WISHLIST_ADD, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity responseEntity(@RequestBody WishlistRequest wishlistRequest) {
        wishListService.saveWishList(wishlistRequest);
        return ResponseEntity.ok(wishlistRequest);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = WISHLIST_GETONE)
    public ResponseEntity<?> getAlbumBy(@PathVariable Long id) {
        Wishlist wishlist = wishListService.findWishlistById(id);
        return ResponseEntity.accepted().body(wishlist);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = WISHLIST_GETALL)
    public ResponseEntity<?> getAll() {
        List<Wishlist> wishlists = wishListService.findAll();
        return ResponseEntity.accepted().body(wishlists);
    }

}

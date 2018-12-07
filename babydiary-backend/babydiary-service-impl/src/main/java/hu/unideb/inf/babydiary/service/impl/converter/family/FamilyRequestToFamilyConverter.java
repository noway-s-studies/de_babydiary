package hu.unideb.inf.babydiary.service.impl.converter.family;

import hu.unideb.inf.babydiary.commons.pojo.request.FamilyRequest;
import hu.unideb.inf.babydiary.service.api.domain.Family;
import hu.unideb.inf.babydiary.service.impl.converter.appointment.AppointmentIdsListToAppointmentListConverter;
import hu.unideb.inf.babydiary.service.impl.converter.child.ChildIdsListToChildListConverter;
import hu.unideb.inf.babydiary.service.impl.converter.user.UserIdListToUserListConverter;
import hu.unideb.inf.babydiary.service.impl.converter.wishlist.WishlistIdListToWishlistListConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FamilyRequestToFamilyConverter implements Converter<FamilyRequest, Family> {

    private final UserIdListToUserListConverter toUserListConverter;

    private final ChildIdsListToChildListConverter toChildListConverter;

    private final WishlistIdListToWishlistListConverter toWishlistListConverter;

    private final AppointmentIdsListToAppointmentListConverter toAppointmentListConverter;

    @Override
    public Family convert(FamilyRequest familyRequest) {
        return Family.builder()
                .familyName(familyRequest.getFamilyName())
                .users(toUserListConverter.convert(familyRequest.getUsersIds()))
                .children(toChildListConverter.convert(familyRequest.getChildrenIds()))
                .wishlists(toWishlistListConverter.convert(familyRequest.getWishlistIds()))
                .appointments(toAppointmentListConverter.convert(familyRequest.getAppointmentIds()))
                .build();
    }
}

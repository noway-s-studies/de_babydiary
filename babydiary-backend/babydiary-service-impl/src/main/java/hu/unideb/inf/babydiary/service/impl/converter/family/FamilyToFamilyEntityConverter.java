package hu.unideb.inf.babydiary.service.impl.converter.family;

import hu.unideb.inf.babydiary.persistence.entity.FamilyEntity;
import hu.unideb.inf.babydiary.service.api.domain.Family;
import hu.unideb.inf.babydiary.service.impl.converter.appointment.AppointmentListToAppointmentEntityListConverter;
import hu.unideb.inf.babydiary.service.impl.converter.child.ChildListToChildEntityListConverter;
import hu.unideb.inf.babydiary.service.impl.converter.user.UserListToUserEntityConverter;
import hu.unideb.inf.babydiary.service.impl.converter.wishlist.WishlistListToWishlistEntityListConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FamilyToFamilyEntityConverter implements Converter<Family, FamilyEntity> {

    private final UserListToUserEntityConverter toUserEntityConverter;

    private final ChildListToChildEntityListConverter toChildEntityListConverter;

    private final WishlistListToWishlistEntityListConverter toWishlistEntityListConverter;

    private final AppointmentListToAppointmentEntityListConverter toAppointmentEntityListConverter;

    @Override
    public FamilyEntity convert(Family family) {
        return FamilyEntity.builder()
                .id(family.getId())
                .familyName(family.getFamilyName())
                .users(toUserEntityConverter.convert(family.getUsers()))
                .children(toChildEntityListConverter.convert(family.getChildren()))
                .wishlists(toWishlistEntityListConverter.convert(family.getWishlists()))
                .appointments(toAppointmentEntityListConverter.convert(family.getAppointments()))
                .build();
    }
}

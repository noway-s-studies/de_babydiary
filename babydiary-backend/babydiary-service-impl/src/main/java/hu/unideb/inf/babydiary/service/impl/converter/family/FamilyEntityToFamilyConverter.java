package hu.unideb.inf.babydiary.service.impl.converter.family;

import hu.unideb.inf.babydiary.persistence.entity.FamilyEntity;
import hu.unideb.inf.babydiary.service.api.domain.Family;
import hu.unideb.inf.babydiary.service.impl.converter.appointment.AppointmentEntityListToAppointmentListConverter;
import hu.unideb.inf.babydiary.service.impl.converter.child.ChildEntityListToChildListConverter;
import hu.unideb.inf.babydiary.service.impl.converter.user.UserEntityListToUserListConverter;
import hu.unideb.inf.babydiary.service.impl.converter.wishlist.WishlistEntityListToWishlistListConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class FamilyEntityToFamilyConverter implements Converter<FamilyEntity, Family> {

    private final UserEntityListToUserListConverter toUserListConverter;
    private final ChildEntityListToChildListConverter toChildListConverter;
    private final WishlistEntityListToWishlistListConverter toWishlistListConverter;
    private final AppointmentEntityListToAppointmentListConverter toAppointmentListConverter;

    @Override
    public Family convert(FamilyEntity familyEntity) {
        return Family.builder()
                .id(familyEntity.getId())
                .familyName(familyEntity.getFamilyName())
                .users(toUserListConverter.convert(familyEntity.getUsers().isEmpty()?Collections.emptyList():familyEntity.getUsers()))
                .children(toChildListConverter.convert(familyEntity.getChildren()))
                .wishlists(toWishlistListConverter.convert(familyEntity.getWishlists()))
                .appointments(toAppointmentListConverter.convert(familyEntity.getAppointments()))
                .build();
    }
}

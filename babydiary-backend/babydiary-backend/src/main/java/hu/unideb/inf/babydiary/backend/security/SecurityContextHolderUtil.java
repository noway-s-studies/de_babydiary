package hu.unideb.inf.babydiary.backend.security;

import hu.unideb.inf.babydiary.service.api.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextHolderUtil {

    public static User getUser() {
        return ((BabyDiaryUserDetails) SecurityContextHolder
                .getContext().getAuthentication()
                .getPrincipal()).getUser();
    }
}

package hu.unideb.inf.babydiary.commons.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FamilyRequest {
    private String familyName;
    private List<Long> usersIds;
    private List<Long> childrenIds;
    private List<Long> wishlistIds;
    private List<Long> appointmentIds;
}

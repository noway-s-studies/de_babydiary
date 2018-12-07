package hu.unideb.inf.babydiary.commons.pojo.request;

import hu.unideb.inf.babydiary.commons.pojo.enumeration.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChildRequest {

    private String firstName;

    private String lastName;

    private Sex sex;

    private LocalDate conception;

    private LocalDate birthday;

    private List<Long> albumIds;
}

package hu.unideb.inf.babydiary.commons.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FunfactRequest {

    private String food;

    private String music;

    private String skills;

    private String text;

    private int week;

}

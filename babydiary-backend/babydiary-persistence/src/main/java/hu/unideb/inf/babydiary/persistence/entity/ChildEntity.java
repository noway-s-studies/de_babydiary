package hu.unideb.inf.babydiary.persistence.entity;

import hu.unideb.inf.babydiary.commons.pojo.enumeration.Sex;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static hu.unideb.inf.babydiary.commons.pojo.table.ColumnName.ChildColumnName.*;
import static hu.unideb.inf.babydiary.commons.pojo.table.ColumnName.SexColumnName.COLUMN_NAME_SEX;
import static hu.unideb.inf.babydiary.commons.pojo.table.TableName.TABLE_NAME_CHILD;
import static javax.persistence.EnumType.STRING;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = TABLE_NAME_CHILD)
public class ChildEntity extends BaseEntity<Long> {

    @Column(name = COLUMN_NAME_BIRTHDAY)
    private LocalDate birthday;

    @Column(name = COLUMN_NAME_CHILD_FIRSTNAME)
    private String firstName;

    @Column(name = COLUMN_NAME_CHILD_LASTNAME)
    private String lastName;

    @Column(name = COLUMN_NAME_SEX)
    @Enumerated(value = STRING)
    private Sex sex;

    @Column(name = COLUMN_NAME_CONCEPTION)
    private LocalDate conception;

    @Column(name = COLUMN_NAME_HEIGHT)
    private int height;

    @Column(name = COLUMN_NAME_WEIGHT)
    private int weight;

    @ManyToOne
    private FamilyEntity family;

    @OneToMany
    private List<AlbumEntity> albums;

    @Builder
    public ChildEntity(Long id, LocalDate birthday, String firstName, String lastName, Sex sex, LocalDate conception, int height, int weight, List<AlbumEntity> albums) {
        super(id);
        this.birthday = birthday;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.conception = conception;
        this.height = height;
        this.weight = weight;
        this.albums = albums;
    }
}

package hu.unideb.inf.babydiary.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

import static hu.unideb.inf.babydiary.commons.pojo.table.ColumnName.AppointmentColumnName.COLUMN_NAME_APPOINTMENT_ID;
import static hu.unideb.inf.babydiary.commons.pojo.table.ColumnName.FamilyColumnName.COLUMN_NAME_FAMILYNAME;
import static hu.unideb.inf.babydiary.commons.pojo.table.ColumnName.FamilyColumnName.COLUMN_NAME_FAMILY_ID;
import static hu.unideb.inf.babydiary.commons.pojo.table.ColumnName.ReferencedColumnName.REFERENCED_COLUMN_NAME_ID;
import static hu.unideb.inf.babydiary.commons.pojo.table.ColumnName.UserColumnName.COLUMN_NAME_USER_ID;
import static hu.unideb.inf.babydiary.commons.pojo.table.TableName.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = TABLE_NAME_FAMILY)
public class FamilyEntity extends BaseEntity<Long>{

    @Column(name = COLUMN_NAME_FAMILYNAME)
    private String familyName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = TABLE_NAME_FAMILY_HAS_USER,
            joinColumns = @JoinColumn(name = COLUMN_NAME_USER_ID, referencedColumnName = REFERENCED_COLUMN_NAME_ID),
            inverseJoinColumns = @JoinColumn(name = COLUMN_NAME_FAMILY_ID, referencedColumnName = REFERENCED_COLUMN_NAME_ID))
    private List<UserEntity> users;

    @OneToMany
    private List<ChildEntity> children;

    @OneToMany
    private  List<WishlistEntity> wishlists;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = TABLE_NAME_FAMILY_HAS_APPOINTMENTS,
            joinColumns = @JoinColumn(name = COLUMN_NAME_APPOINTMENT_ID, referencedColumnName = REFERENCED_COLUMN_NAME_ID),
            inverseJoinColumns = @JoinColumn(name = COLUMN_NAME_FAMILY_ID, referencedColumnName = REFERENCED_COLUMN_NAME_ID))
    private List<AppointmentEntity> appointments;

    @Builder
    public FamilyEntity(Long id, String familyName, List<UserEntity> users, List<ChildEntity> children, List<WishlistEntity> wishlists, List<AppointmentEntity> appointments) {
        super(id);
        this.familyName = familyName;
        this.users = users;
        this.children = children;
        this.wishlists = wishlists;
        this.appointments = appointments;
    }
}

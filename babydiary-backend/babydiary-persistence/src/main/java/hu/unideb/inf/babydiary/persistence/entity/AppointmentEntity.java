package hu.unideb.inf.babydiary.persistence.entity;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static hu.unideb.inf.babydiary.commons.pojo.table.ColumnName.AppointmentColumnName.*;
import static hu.unideb.inf.babydiary.commons.pojo.table.TableName.TABLE_NAME_APPOINTMENT;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = TABLE_NAME_APPOINTMENT)
public class AppointmentEntity extends BaseEntity<Long>{

    @Column(name = COLUMN_NAME_ADDRESS)
    private String address;

    @Column(name = COLUMN_NAME_LOCATION)
    private String location;

    @Column(name = COLUMN_NAME_DESCRIPTION)
    private String description;

    @Column(name = COLUMN_NAME_PRIO)
    private int prio;

    @Column(name = COLUMN_NAME_DATE)
    private LocalDate date;

    @Column(name = COLUMN_NAME_TIME)
    private LocalDateTime time;

    @ManyToMany(mappedBy = "appointments", fetch = FetchType.LAZY)
    private List<FamilyEntity> families;

    @Builder
    public AppointmentEntity(Long id, String address, String location, String description, int prio, LocalDate date, LocalDateTime time) {
        super(id);
        this.address = address;
        this.location = location;
        this.description = description;
        this.prio = prio;
        this.date = date;
        this.time = time;
    }
}

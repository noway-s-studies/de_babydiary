package hu.unideb.inf.babydiary.persistence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static hu.unideb.inf.babydiary.commons.pojo.table.ColumnName.AlbumColumnName.COLUMN_NAME_NAME;
import static hu.unideb.inf.babydiary.commons.pojo.table.ColumnName.AlbumColumnName.COLUMN_NAME_SIZE;
import static hu.unideb.inf.babydiary.commons.pojo.table.TableName.TABLE_NAME_ALBUM;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = TABLE_NAME_ALBUM)
public class AlbumEntity extends BaseEntity<Long> {

    @Column(name = COLUMN_NAME_NAME)
    private String name;

    @Column(name = COLUMN_NAME_SIZE)
    private String link;

    @ManyToOne
    private ChildEntity childEntity;

    @Builder
    public AlbumEntity(Long id, String name, String link) {
        super(id);
        this.name = name;
        this.link = link;
    }
}

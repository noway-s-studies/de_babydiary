package hu.unideb.inf.babydiary.persistence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static hu.unideb.inf.babydiary.commons.pojo.table.ColumnName.WishListColumnName.COLUMN_NAME_ITEM;
import static hu.unideb.inf.babydiary.commons.pojo.table.ColumnName.WishListColumnName.COLUMN_NAME_PRICE;
import static hu.unideb.inf.babydiary.commons.pojo.table.TableName.TABLE_NAME_WISHLIST;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = TABLE_NAME_WISHLIST)
public class WishlistEntity extends BaseEntity<Long> {

    @Column(name = COLUMN_NAME_ITEM)
    private String item;

    @Column(name = COLUMN_NAME_PRICE)
    private int price;

    @ManyToOne
    private FamilyEntity family;

    @Builder
    public WishlistEntity(Long id, String item, int price) {
        super(id);
        this.item = item;
        this.price = price;
    }
}

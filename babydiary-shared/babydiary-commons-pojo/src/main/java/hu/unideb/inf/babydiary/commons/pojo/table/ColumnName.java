package hu.unideb.inf.babydiary.commons.pojo.table;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ColumnName {

    public static final class UserColumnName {

        public static final String COLUMN_NAME_USER_ID = "user_id";

        public static final String COLUMN_NAME_USERNAME = "username";

        public static final String COLUMN_NAME_PASSWORD = "password";

        public static final String COLUMN_NAME_EMAIL = "email";

        public static final String COLUMN_NAME_USER_FIRSTNAME = "user_firstname";

        public static final String COLUMN_NAME_USER_LASTNAME = "user_lastname";

        public static final String COLUMN_NAME_USER_ROLE = "user_role";

    }

    public static final class FamilyColumnName {

        public static final String COLUMN_NAME_FAMILY_ID = "family_id";

        public static final String COLUMN_NAME_FAMILYNAME = "familyname";
    }

    public static final class ChildColumnName {

        public static final String COLUMN_NAME_CHILD_ID = "child_id";

        public static final String COLUMN_NAME_BIRTHDAY = "birthday";

        public static final String COLUMN_NAME_HEIGHT = "height";

        public static final String COLUMN_NAME_WEIGHT = "weight";

        public static final String COLUMN_NAME_CONCEPTION = "conception";

        public static final String COLUMN_NAME_CHILD_FIRSTNAME = "child_firstname";

        public static final String COLUMN_NAME_CHILD_LASTNAME = "child_lastname";
    }

    public static final class FunfactColumnName {

        public static final String COLUMN_NAME_FUNFACT_ID = "funfact_id";

        public static final String COLUMN_NAME_WEEK = "week";

        public static final String COLUMN_NAME_TEXT = "text";

        public static final String COLUMN_NAME_MUSIC = "music";

        public static final String COLUMN_NAME_SKILLS = "skills";

        public static final String COLUMN_NAME_FOOD = "food";
    }

    public static final class WishListColumnName {

        public static final String COLUMN_NAME_WISHLIST_ID = "wishlist_id";

        public static final String COLUMN_NAME_ITEM = "item";

        public static final String COLUMN_NAME_PRICE = "price";
    }

    public static final class AlbumColumnName {

        public static final String COLUMN_NAME_ALBUM_ID = "album_id";

        public static final String COLUMN_NAME_NAME = "name";

        public static final String COLUMN_NAME_TYPE = "type";

        public static final String COLUMN_NAME_SIZE = "size";

        public static final String COLUMN_NAME_DATE = "date";
    }

    public static final class AppointmentColumnName {

        public static final String COLUMN_NAME_APPOINTMENT_ID = "appointment_id";

        public static final String COLUMN_NAME_ADDRESS = "address";

        public static final String COLUMN_NAME_LOCATION = "location";

        public static final String COLUMN_NAME_DESCRIPTION = "description";

        public static final String COLUMN_NAME_PRIO = "prio";

        public static final String COLUMN_NAME_DATE = "date";

        public static final String COLUMN_NAME_TIME = "time";
    }

    public static final class SexColumnName{

        public static final String COLUMN_NAME_SEX = "sex";

    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class ReferencedColumnName{

        public static final String REFERENCED_COLUMN_NAME_ID = "id";

    }
}

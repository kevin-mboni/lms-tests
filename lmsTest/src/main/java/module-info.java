module lms.main.lmsTest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens lms.main.lms to javafx.fxml;
    exports lms.main.lmstest
            ;
}

//module lms.main.lmsTest {
//    requires javafx.controls;
//    requires javafx.fxml;
//    requires java.sql;
//
//    opens lms.main.lmstest to javafx.fxml;
//    exports lms.main.lmstest;
//}

//module lms.main.lmsTest {
//    requires javafx.controls;
//    requires javafx.fxml;
//    requires java.sql;
//
//    opens lms.main.lmstest.controllers to javafx.fxml;
//    exports lms.main.lmstest;
//}

module lms.main.lmsTest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.testfx.junit5;
    requires org.mockito;
    requires net.bytebuddy;

    opens lms.main.lmstest.controllers to javafx.fxml, org.testfx.junit5;
    exports lms.main.lmstest;
}




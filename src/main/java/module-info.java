module com.passgen.strongpasswordgenerator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.passgen.strongpasswordgenerator to javafx.fxml;
    exports com.passgen.strongpasswordgenerator;
}
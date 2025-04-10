module FoundationCode {
	requires javafx.controls;
	requires java.sql;
	requires junit;
	requires org.junit.jupiter.api;
    requires javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
}

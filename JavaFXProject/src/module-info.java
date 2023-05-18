/**
 * 
 */
/**
 * @author vhavh
 *
 */
	
	module JavaFXProject {
		requires javafx.controls;
		requires javafx.graphics;
		requires javafx.fxml;
		requires java.desktop;
		requires java.sql;
	
		
		
		opens br.com.importar.dados to 
			javafx.graphics, javafx.controls, javafx.media, javafx.fxml;
		
	}
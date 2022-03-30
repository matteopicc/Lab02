package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary alienDictionary = new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtTraduzione;

    @FXML
    void doTranslate(ActionEvent event) {
    	txtTraduzione.clear();
    	String riga = txtParola.getText().toLowerCase();
    	if(riga==null || riga.length()==0) {
    		txtTraduzione.setText("Inserisci una o due parole");
    		return;
    	}
    	StringTokenizer st = new StringTokenizer(riga," ");
    	if(!st.hasMoreTokens()) {
    		txtTraduzione.setText("Inserisci una o due parole");
    		return;
    	}
    	
    	String alienWord  = st.nextToken();
    	
    	if(st.hasMoreTokens()) {
    		String translation = st.nextToken();
    		
    		if(!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
    			txtTraduzione.setText("Inserire solo caratteri alfabetici");
    			return;
    		}
    		alienDictionary.addWord(alienWord, translation);
    		txtTraduzione.setText("La parola : "+alienWord +" è stata aggiunta, con traduzione "+translation);
    	}
    	
    	else {
    		if(!alienWord.matches("[a-zA-Z?]*")) {
    			txtTraduzione.setText("Inserire solo caratteri alfabetici o punto interrogativo");
    			return;
    		}
    		String translation;
    		
    		if(alienWord.matches("[a-zA-Z?]*") && !alienWord.matches("[a-zA-Z]*")) {
    			translation = alienDictionary.translateWordWildCard(alienWord);
    		}
    		else {
    			translation = alienDictionary.translateWord(alienWord);
    		}
    		
    		if(translation!= null) {
    			txtTraduzione.setText(translation);
    		}
    		else {
    			txtTraduzione.setText("La parola cercata non è presente");
    		}
    	}
    	
    	

    }

    @FXML
    void handleReset(ActionEvent event) {
    	alienDictionary.doReset();
    	txtParola.clear();
    	txtTraduzione.clear();

    }

    @FXML
    void initialize() {
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTraduzione != null : "fx:id=\"txtTraduzione\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}

 
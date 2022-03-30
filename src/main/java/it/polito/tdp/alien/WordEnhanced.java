package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WordEnhanced {
	private String alienWord;
	private List<String> translations;
	
	//Costruttore completo
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translations = new ArrayList<String>();
		this.translations.add(translation);
	}
	
	
    //Costruttore solo con parola
	public WordEnhanced(String alienWord) {
		this.alienWord = alienWord;
		this.translations= new ArrayList<String>();
	}


	@Override
	public int hashCode() {
		return Objects.hash(alienWord);
	}

   //Metodo equals(parole uguali)
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if(alienWord==null) {
			if(other.alienWord!=null) {
				return false;
			 }	
		}
		else if(!alienWord.equals(other.alienWord)) {
				return false;
			}
		return true;
	
	}

	public String getTranslation() {
		String s = "";
		for(String t:translations) {
			s+= t+"\n";
		}
		return s;
	}


	public void setTranslation(String translation) {
		if(!translations.contains(translation)) {
			translations.add(translation);
		}
	}


	public String getAlienWord() {
		return alienWord;
	}


	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}


	public boolean compareWild(String alienWord2) {
		if(alienWord.matches(alienWord2)) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

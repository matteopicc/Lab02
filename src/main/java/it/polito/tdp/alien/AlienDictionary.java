package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<WordEnhanced>dictionary;

	public AlienDictionary() {
		dictionary=new ArrayList<WordEnhanced>();
	}
	
	public void doReset() {
		dictionary.clear();
	}
	
	public void addWord(String alienWord,String translation) {
		WordEnhanced w = new WordEnhanced(alienWord);
		if(dictionary.contains(w)) {
			dictionary.get(dictionary.indexOf(w)).setTranslation(translation);
			return;
		}
		w.setTranslation(translation);
		dictionary.add(w);
	}
	
	public String translateWord(String alienWord) {
		WordEnhanced w = new WordEnhanced(alienWord);
		if(dictionary.contains(w)) {
			return dictionary.get(dictionary.indexOf(w)).getTranslation();
		}
		return null;
	}

	public String translateWordWildCard(String alienWord) {
		
		alienWord = alienWord.replaceAll("\\?",".");// il punto perche equivale ad ogni lettera possibile
		
		int matchCounter =0;// per vedere quante volte la parola viene trovata
		
		StringBuilder sb = new StringBuilder();
		
		for(WordEnhanced w:dictionary) {
			if(w.compareWild(alienWord)) {
				matchCounter++;
				sb.append(w.getTranslation()+"\n");
			}
		}
		
		if(matchCounter!=0) {
			return sb.toString();
		}
		else {
			return null;
		}
		
	}

}

package org.miage.m2sid.openlp.openlp.domain;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;  

import opennlp.tools.postag.POSModel; 
import opennlp.tools.postag.POSSample; 
import opennlp.tools.postag.POSTaggerME; 
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.InvalidFormatException;  

public class Generator { 
	
	
	 private InputStream inputStream = getClass().getResourceAsStream("/en-pos-maxent.bin");  
     //Loading Parts of speech-maxent model       
     private POSModel model; 
     //Instantiating POSTaggerME class 
     private POSTaggerME tagger; 
     private String sentence;    
     //Tokenizing the sentence using WhitespaceTokenizer class  
     private WhitespaceTokenizer whitespaceTokenizer; 
     private String[] tokens; 
     //Generating tags 
     private String[] tags;
     //Instantiating the POSSample class 
     private POSSample sample; 
     
     
     public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	public POSModel getModel() {
		return model;
	}


	public void setModel(POSModel model) {
		this.model = model;
	}


	public POSTaggerME getTagger() {
		return tagger;
	}


	public void setTagger(POSTaggerME tagger) {
		this.tagger = tagger;
	}


	public String getSentence() {
		return sentence;
	}


	public void setSentence(String sentence) {
		this.sentence = sentence;
	}


	public WhitespaceTokenizer getWhitespaceTokenizer() {
		return whitespaceTokenizer;
	}


	public void setWhitespaceTokenizer(WhitespaceTokenizer whitespaceTokenizer) {
		this.whitespaceTokenizer = whitespaceTokenizer;
	}


	public String[] getTokens() {
		return tokens;
	}


	public void setTokens(String[] tokens) {
		this.tokens = tokens;
	}


	public String[] getTags() {
		return tags;
	}


	public void setTags(String[] tags) {
		this.tags = tags;
	}


	public POSSample getSample() {
		return sample;
	}


	public void setSample(POSSample sample) {
		this.sample = sample;
	}


	public Generator(String s){
  
    	 inputStream = getClass().getResourceAsStream("/en-pos-maxent.bin");  
         //Loading Parts of speech-maxent model       
         try {
			model = new POSModel(inputStream);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
         //Instantiating POSTaggerME class 
         tagger = new POSTaggerME(model); 
         sentence = s;
         //Tokenizing the sentence using WhitespaceTokenizer class  
         whitespaceTokenizer= WhitespaceTokenizer.INSTANCE; 
         tokens = whitespaceTokenizer.tokenize(sentence); 
         //Generating tags 
         tags = tagger.tag(tokens);
         //Instantiating the POSSample class 
         sample = new POSSample(tokens, tags); 
     }
 
}  
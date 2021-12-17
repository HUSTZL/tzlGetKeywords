package HUST.Chinese.Lexical.Analysis.System;

public class Term {
	//
	String word = "";
	String pos = "";

	public Term(String word, String pos) {
		// TODO Auto-generated constructor stub
		this.setWord(word);
		this.setPos(pos);
	}

	//
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	//
	public String toString() {
		return word + "/" + pos;
	}
}

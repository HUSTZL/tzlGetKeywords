package HUST.Standford;

import java.util.LinkedList;

import HUST.Chinese.Lexical.Analysis.System.Term;
import HUST.Semantic.Role.Labeling.Phrase;

public class Segment {
	Phrase[] phrases;
	String state;

	public Segment(Phrase[] phrases, String state) {
		this.phrases = phrases;
		this.state = state;
	}

	public Phrase[] getPhrases() {
		return phrases;
	}

	public void setPhrases(Phrase[] phrases) {
		this.phrases = phrases;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean contains(String[] words) {
		//
		boolean result = false;
		//
		for (Phrase phrase : phrases) {
			for (Term term : phrase.getTerms()) {
				for (String word : words) {
					if (term.getWord().equals(word)) {
						result = true;
						return result;
					}
				}
			}
		}
		//
		return result;
	}

	public boolean containsPos(String pos) {
		//
		boolean result = false;
		//
		for (Phrase phrase : phrases) {
			for (Term term : phrase.getTerms()) {
				if (term.getPos().equals(pos)) {
					result = true;
					return result;
				}

			}
		}
		//
		return result;
	}

	public Segment concat(Segment segment) {
		//
		LinkedList<Phrase> list = new LinkedList<Phrase>();
		for (Phrase phrase : this.getPhrases()) {
			list.addLast(phrase);
		}
		for (Phrase phrase : segment.getPhrases()) {
			list.addLast(phrase);
		}
		//
		Segment result = new Segment(list.toArray(new Phrase[0]), "");
		//
		return result;
	}

	public String toString() {
		String result = "";
		for (Phrase ph : this.getPhrases()) {
			result = result + ph.toString() + "\r\n";
		}
		return this.state + ":" + result;
	}

	public String toStringOnlyCC() {
		String result = "";
		for (Phrase ph : this.getPhrases()) {
			result = result + ph.toStringOnlyCC();
		}
		return result;
	}
}

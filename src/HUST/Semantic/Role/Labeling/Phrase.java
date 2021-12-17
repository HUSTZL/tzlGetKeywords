package HUST.Semantic.Role.Labeling;

import HUST.Chinese.Lexical.Analysis.System.Term;

public class Phrase {

	Term[] terms;

	String label = "";

	public Phrase(Term[] terms, String label) {
		this.terms = terms;
		this.label = label;
	}

	public Term[] getTerms() {
		return terms;
	}

	public void setTerms(Term[] terms) {
		this.terms = terms;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Term getLastTerm() {
		return terms[terms.length - 1];
	}

	public Term getCoreTerm() {
		Term result = null;
		for (int x = terms.length - 1; x >= 0; x--) {
			String pos = terms[x].getPos();
			if (pos.contains("a") || pos.contains("d") || pos.contains("mq") || pos.contains("n") || pos.contains("v")
					|| pos.contains("t")) {
				if (pos.contains("u1de")) {
					continue;
				}
				result = terms[x];
				break;
			}
		}
		//
		if (this.label.equals("N")) {
			for (int x = terms.length - 1; x >= 0; x--) {
				String pos = terms[x].getPos();
				if (pos.contains("n") || pos.contains("r")) {
					result = terms[x];
					break;
				}
			}
			//
			if (terms.length == 1) {
				result = terms[0];
			}
		}
		if (result == null) {
			result = terms[terms.length - 1];
		}
		//
		return result;
	}

	public String toString() {
		String result = "";
		for (Term term : this.getTerms()) {
			result = result + term.getWord() + ",";
		}
		return result + "/" + this.getCoreTerm() + "/" + this.getLabel();
	}

	public String toStringOnlyCC() {
		String result = "";
		for (Term term : this.getTerms()) {
			result = result + term.getWord();
		}
		return result;
	}

	public boolean IsSubjectNr() {
		//
		boolean result = false;
		//
		String lastWord = terms[terms.length - 1].getWord();
		String lastPos = terms[terms.length - 1].getPos();
		//
		if (lastWord.equals("龙珠")) {
			System.out.print("");
		}
		//
		String preLastWord = "";
		String preLastPos = "";
		//
		if (this.terms.length > 1) {
			preLastWord = terms[terms.length - 2].getWord();
			preLastPos = terms[terms.length - 2].getPos();
		}
		//
		if (lastPos.equals(SRLVar.nr)
				//
				|| lastPos.equals(SRLVar.no)
				//
				|| lastPos.equals(SRLVar.nrgx)
				//
				|| lastPos.equals(SRLVar.nrsf)) {
			result = true;
		}
		// 法师/no 们/k
		else if (lastWord.length() == 1
				//
				&&
				//
				(preLastPos.equals(SRLVar.nr)
						//
						|| preLastPos.equals(SRLVar.no)
						//
						|| preLastPos.equals(SRLVar.nrgx)
						//
						|| lastPos.equals(SRLVar.nrsf))) {
			result = true;
		}
		// 刘/nr 龙珠/n
		else if (lastWord.length() == 2
				//
				&& preLastWord.length() == 1
				//
				&& preLastPos.equals(SRLVar.nr)) {
			result = true;
		}
		//
		return result;
	}

	public boolean IsSubjectNs() {
		//
		boolean result = false;
		//
		String lastPos = terms[terms.length - 1].getPos();
		//
		if (lastPos.equals(SRLVar.ns)) {
			result = true;
		}
		//
		return result;
	}

	public boolean IsSubjectNt() {
		//
		boolean result = false;
		//
		String lastPos = terms[terms.length - 1].getPos();
		//
		if (lastPos.equals(SRLVar.nt)
				//
				|| lastPos.equals(SRLVar.nttc)) {
			result = true;
		}
		//
		return result;
	}

	public boolean IsSubjectNr_Ns_Nt() {
		//
		boolean result = false;
		//
		if (IsSubjectNr()
				//
				|| IsSubjectNs()
				//
				|| IsSubjectNt()) {
			result = true;
		}
		//
		return result;
	}
}

package HUST.Semantic.Role.Labeling;

public class Score {
	String word;

	double total = -1;

	double hasSubject = -1;

	double V_x = -1;

	double hasObject = -1;

	double x_V = -1;

	double end = -1;

	String fixSubject = "";

	String fixObject = "";

	public Score(String word, int total, int hasSubject, int V_x, int hasObject, int x_V, int end, String fixSubject,
			String fixObject) {
		this.word = word;
		this.total = total * 1.0 + 0.5;
		this.hasSubject = hasSubject * 1.0 + 0.5;
		this.V_x = V_x * 1.0 + 0.5;
		this.hasObject = hasObject * 1.0 + 0.5;
		this.x_V = x_V * 1.0 + 0.5;
		this.end = end * 1.0 + 0.5;
		//
		this.fixSubject = fixSubject;
		this.fixObject = fixObject;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getHasSubject() {
		return hasSubject;
	}

	public void setHasSubject(double hasSubject) {
		this.hasSubject = hasSubject;
	}

	public double getV_x() {
		return V_x;
	}

	public void setV_x(double v_x) {
		V_x = v_x;
	}

	public double getHasObject() {
		return hasObject;
	}

	public void setHasObject(double hasObject) {
		this.hasObject = hasObject;
	}

	public double getX_V() {
		return x_V;
	}

	public void setX_V(double x_V) {
		this.x_V = x_V;
	}

	public double getEnd() {
		return end;
	}

	public void setEnd(double end) {
		this.end = end;
	}

	public String getFixSubject() {
		return fixSubject;
	}

	public void setFixSubject(String fixSubject) {
		this.fixSubject = fixSubject;
	}

	public String getFixObject() {
		return fixObject;
	}

	public void setFixObject(String fixObject) {
		this.fixObject = fixObject;
	}

	public String toString() {
		return "word_" + this.getWord() + "_total_" + this.getTotal() + "_subject_" + this.getHasSubject() + "_Vx_"
				+ this.getV_x() + "_object_" + this.getHasObject() + "_xV_" + this.getX_V() + "_end_" + this.end;
	}
}

package HUST.Chinese.Lexical.Analysis.System;

import java.util.LinkedList;
import java.util.regex.Pattern;

import HUST.Semantic.Role.Labeling.SRLVar;

public class ICTMainDetails {

	public static void main(String[] args) {
	}

	// TODO Auto-generated method stub

	public static Term[] _2_1(String[] slips) {
		//
		LinkedList<Term> result = new LinkedList<Term>();
		//
		for (int i = 0; i < slips.length; i++) {
			String word = slips[i];
			String pos = "";
			//
			Pattern pattern = Pattern.compile("[0-9]*");
			//
			String IPRegEx = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
			Pattern IP = Pattern.compile(IPRegEx);
			//
			String HostRegEx = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
					+ "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";
			Pattern Host = Pattern.compile(HostRegEx, Pattern.CASE_INSENSITIVE);
			//
			String MD5RegEx = "[a-fA-F0-9]{32,32}";
			Pattern MD5 = Pattern.compile(MD5RegEx, Pattern.CASE_INSENSITIVE);
			//
			if (WordList.getPoses().containsKey(word)) {
				pos = WordList.getPoses().get(word);
			} else if (IP.matcher(word).matches()) {
				pos = "ip";
			} else if (Host.matcher(word).matches()) {
				pos = "host";
			} else if (MD5.matcher(word).matches()) {
				pos = "md5";
			} else if (pattern.matcher(word).matches()) {
				pos = SRLVar.m;
			}
			// else if (word.equals("《") || word.equals("》")) {
			// pos = SRLVar.m;
			// }
			//
			Term term = new Term(word, pos);
			//
			result.addLast(term);
		}
		//
		return result.toArray(new Term[0]);

	}

	public static Term[] _2_2_addStartAndEnd(Term[] terms) {
		//
		LinkedList<Term> list = new LinkedList<Term>();
		list.addLast(new Term("start", "start"));
		for (Term term : terms) {
			list.addLast(term);
		}
		list.addLast(new Term("end", "end"));
		terms = list.toArray(new Term[0]);
		//
		return terms;
	}

	public static Term[] _2_3(Term[] terms) {
		for (Term term : terms) {
			/**
			 * c
			 */
			if ("/、/同/和/及/与/以及/".contains("/" + term.getWord() + "/")) {
				term.setPos(SRLVar.cand);
			}
			/**
			 * d
			 */
			if (term.getPos().equals("dg")) {
				term.setPos(SRLVar.adverb);
			}
			/**
			 * p
			 */
			// ba
			if (term.getWord().equals("把") && term.getPos().equals(SRLVar.p)) {
				term.setPos(SRLVar.ba);
			}
			// bei
			if ("/被/遭/惨遭/".contains("/" + term.getWord() + "/")) {
				term.setPos(SRLVar.bei);
			}
			// jiang
			if (term.getWord().equals("将")) {
				term.setPos(SRLVar.jiang);
			}
			// p
			if (term.getWord().equals("为")) {
				term.setPos(SRLVar.p);
			}
			//
			/**
			 * q
			 */
			// if ("/种/个/项/名/元/".contains("/" + term.getWord() + "/") &&
			// term.getPos().equals(SRLVar.quantifier)) {
			// term.setPos(SRLVar.qn);
			// }
			/**
			 * r
			 */
			if ("/什么/".contains("/" + term.getWord() + "/")) {
				term.setPos(SRLVar.rir);
			}
			/**
			 * u
			 */
			if (term.getWord().equals("的")) {
				term.setPos(SRLVar.u1de);
			}
			if (term.getWord().equals("之") && term.getPos().equals(SRLVar.u)) {
				term.setPos(SRLVar.u1de);
			}
			if (term.getWord().equals("地")) {
				term.setPos(SRLVar.u2de);
			}
			if (term.getWord().equals("得")) {
				term.setPos(SRLVar.u3de);
			}
			/**
			 * w
			 */
			if ("/_/—/#/".contains("/" + term.getWord() + "/")) {
				term.setPos(SRLVar.en);
			}
			/**
			 * null
			 */
			if (term.getPos().equals("null")) {
				if (term.getWord().matches("^[a-zA-Z]*")) {
					term.setPos(SRLVar.en);
				}
			}
		}
		// 2
		for (int i = 1; i < terms.length; i++) {
			Term t1 = terms[i - 1];
			Term t2 = terms[i];
			//
			// 开始:start/start,START,
			// 谓语:休闲/v,V,
			// 宾语:旅游/vn,N,好/a,AN,去处/n,N,
			// 结束:end/end,END,
			if (t1.getWord().equals("休闲") && t2.getWord().equals("旅游")) {
				terms[i - 1].setPos(t1.getPos() + "_n");
				terms[i].setPos(t2.getPos() + "_n");
			}
			if (t1.getWord().equals("收费") && t2.getWord().equals("项目")) {
				terms[i - 1].setPos(t1.getPos() + "_n");
				terms[i].setPos(t2.getPos() + "_n");
			}
			if (t1.getWord().equals("排队") && t2.getWord().equals("时间")) {
				terms[i - 1].setPos(t1.getPos() + "_n");
				terms[i].setPos(t2.getPos() + "_n");
			}
			//
			if (t1.getPos().equals("v_n") && t2.getWord().equals("了")) {
				terms[i - 1].setPos("v");
			}
			if (t1.getPos().equals("p_v") && t2.getWord().equals("了")) {
				terms[i - 1].setPos("v");
			}
		}
		// 4
		for (int i = 3; i < terms.length; i++) {
			Term t1 = terms[i - 3];
			Term t2 = terms[i - 2];
			Term t3 = terms[i - 1];
			Term t4 = terms[i];
			//
			if (t1.getPos().equals(SRLVar.adjective)
					//
					&& t2.getPos().equals(SRLVar.u1de)
					//
					&& t3.getPos().equals(SRLVar.verb)
					//
					&& t4.getPos().equals("end")) {
				terms[i - 1].setPos("v_n");
			}
			//
			// 谓语:表演/v,V,
			// 状语D:很/d,ADV,
			// 谓语:精彩/a,AV,
			// 结束:end/end,END,
			if (t1.getPos().equals(SRLVar.verb)
					//
					&& t2.getPos().equals(SRLVar.adverb)
					//
					&& t3.getPos().equals(SRLVar.adjective)
					//
					&& t4.getPos().equals("end")) {
				terms[i - 3].setPos("vn");
			}
		}

		//
		return terms;
	}

	

	public static Term[] _4_1(Term[] terms) {
		for (int i = 1; i < terms.length; i++) {
			Term t1 = terms[i - 1];
			Term t2 = terms[i];
			//
			if (t1 == null || t2 == null) {
				continue;
			}
			//
			if (t1.getWord().equals("小") && WordList.getSurnames().containsKey(t2.getWord())) {
				t1.setWord(t1.getWord() + t2.getWord());
				t1.setPos("nr");
				//
				terms[i - 1] = t1;
				terms[i] = null;
			}
		}
		//
		LinkedList<Term> list = new LinkedList<Term>();
		for (Term term : terms) {
			if (term == null) {
				continue;
			}
			list.addLast(term);
		}
		terms = list.toArray(new Term[0]);
		//
		return terms;
	}

	public static Term[] _4_2(Term[] terms) {
		for (int i = 2; i < terms.length; i++) {
			Term t1 = terms[i - 2];
			Term t2 = terms[i - 1];
			Term t3 = terms[i];
			//
			if (t1 == null || t2 == null || t3 == null) {
				continue;
			}
			//
			if (t1.getWord().length() == 2 && t1.getPos().equals(SRLVar.nr)
			//
					&& t2.getWord().length() == 1 && !t2.getPos().equals(SRLVar.adverb)
					//
					&& t3.getPos().equals(SRLVar.verb)) {
				t1.setWord(t1.getWord() + t2.getWord());
				t1.setPos(SRLVar.nr);
				//
				terms[i - 2] = t1;
				terms[i - 1] = null;
			}
		}
		//
		LinkedList<Term> list = new LinkedList<Term>();
		for (Term term : terms) {
			if (term == null) {
				continue;
			}
			list.addLast(term);
		}
		terms = list.toArray(new Term[0]);
		//
		return terms;
	}

	// 《》
	public static Term[] _5_1(Term[] terms) {
		//
		int start = 0;
		while (true) {
			//
			int index1 = -1;
			int index2 = -1;
			//
			for (int i = start; i < terms.length; i++) {
				if (terms[i].getWord().equals("《")) {
					index1 = i;
				}
			}
			for (int i = start; i < terms.length; i++) {
				if (terms[i].getWord().equals("》")) {
					index2 = i;
				}
			}
			//
			if (index1 > -1 && index2 > index1) {
				start = index2;
				boolean bk = true;
				for (int i = index1 + 1; i < index2; i++) {
					if (terms[i].getPos().startsWith(SRLVar.wi)) {
						bk = false;
						break;

					}
				}
				if (bk == false) {
					continue;
				}
				for (int i = index1; i <= index2; i++) {
					terms[i].setPos("bk");
				}
				//

			} else {
				break;
			}
		}
		//
		for (int i = 1; i < terms.length; i++) {
			//
			Term t1 = terms[i - 1];
			Term t2 = terms[i];
			//
			if (t1 == null || t2 == null) {
				continue;
			}
			//
			if (t1.getPos().equals("bk")
					//
					&& t2.getPos().equals("bk")) {
				terms[i - 1] = null;
				terms[i].setWord(t1.getWord() + t2.getWord());
				terms[i].setPos("bk");
			}
		}
		//
		LinkedList<Term> list = new LinkedList<Term>();
		for (Term term : terms) {
			if (term != null) {
				list.addLast(term);
			}
		}
		terms = list.toArray(new Term[0]);
		//
		return terms;
	}

	// 11.11=11.11
	public static Term[] _5_2(Term[] terms) {
		// 数字合并，以及1%情况
		for (int i = 1; i < terms.length; i++) {
			//
			Term t1 = terms[i - 1];
			Term t2 = terms[i];
			//
			if (t1 == null || t2 == null) {
				continue;
			}
			//
			if (t1.getPos().equals(SRLVar.m)
					//
					&& (t2.getPos().equals(SRLVar.m) || t2.getWord().equals("%"))) {
				terms[i - 1] = null;
				terms[i].setWord(t1.getWord() + t2.getWord());
				terms[i].setPos(SRLVar.m);
			}
		}
		//
		LinkedList<Term> list = new LinkedList<Term>();
		for (Term term : terms) {
			if (term != null) {
				list.addLast(term);
			}
		}
		terms = list.toArray(new Term[0]);
		// 处理1.1及1/1情况
		for (int i = 2; i < terms.length; i++) {
			//
			Term t1 = terms[i - 2];
			Term t2 = terms[i - 1];
			Term t3 = terms[i];
			//
			if (t1 == null || t2 == null || t3 == null) {
				continue;
			}
			//
			if (t1.getPos().equals(SRLVar.m)
					//
					&& (t2.getWord().equals(".") || t2.getWord().equals("/"))
					//
					&& t3.getPos().equals(SRLVar.m)) {
				terms[i - 2] = null;
				terms[i - 1] = null;
				terms[i].setWord(t1.getWord() + t2.getWord() + t3.getWord());
				terms[i].setPos(SRLVar.m);
			}
		}
		//
		list = new LinkedList<Term>();
		for (Term term : terms) {
			if (term != null) {
				list.addLast(term);
			}
		}
		terms = list.toArray(new Term[0]);
		//
		return terms;
	}

	// 好+1n=n
	public static Term[] _5_3(Term[] terms) {
		for (int i = 0; i < terms.length - 1; i++) {
			//
			Term t1 = terms[i];
			Term t2 = terms[i + 1];
			//
			if (t1 == null || t2 == null) {
				continue;
			}
			//
			if (t1.getWord().equals("好")
					//
					&& t2.getPos().equals(SRLVar.noun)
					//
					&& t2.getWord().length() == 1) {
				terms[i].setWord(t1.getWord() + t2.getWord());
				terms[i].setPos(SRLVar.noun);
				terms[i + 1] = null;
			}
		}
		//
		LinkedList<Term> list = new LinkedList<Term>();
		for (Term term : terms) {
			if (term != null) {
				list.addLast(term);
			}
		}
		terms = list.toArray(new Term[0]);
		//
		return terms;
	}

	// 1v+过=2v
	public static Term[] _5_4(Term[] terms) {
		for (int i = 0; i < terms.length - 1; i++) {
			//
			Term t1 = terms[i];
			Term t2 = terms[i + 1];
			//
			if (t1 == null || t2 == null) {
				continue;
			}
			//
			if (t1.getWord().length() == 1
					//
					&& t1.getPos().equals(SRLVar.verb)
					//
					&& t2.getWord().equals("过")) {
				terms[i].setWord(t1.getWord() + t2.getWord());
				terms[i].setPos(SRLVar.verb);
				terms[i + 1] = null;
			}
		}
		//
		LinkedList<Term> list = new LinkedList<Term>();
		for (Term term : terms) {
			if (term != null) {
				list.addLast(term);
			}
		}
		terms = list.toArray(new Term[0]);
		//
		return terms;
	}

	// nz+nttc+no=no
	public static Term[] _5_5(Term[] terms) {
		for (int i = 0; i < terms.length - 2; i++) {
			//
			Term t1 = terms[i];
			Term t2 = terms[i + 1];
			Term t3 = terms[i + 2];
			//
			if (t1 == null || t2 == null || t3 == null) {
				continue;
			}
			//
			if (t1.getPos().equals("nz")
					//
					&& t2.getPos().equals("nttc")
					//
					&& t3.getPos().equals("no")) {
				terms[i].setWord(t1.getWord() + t2.getWord() + t3.getWord());
				terms[i].setPos("no");
				terms[i + 1] = null;
				terms[i + 2] = null;
			}
		}
		//
		LinkedList<Term> list = new LinkedList<Term>();
		for (Term term : terms) {
			if (term != null) {
				list.addLast(term);
			}
		}
		terms = list.toArray(new Term[0]);
		//
		return terms;
	}

	// nz+no=no
	public static Term[] _5_6(Term[] terms) {
		for (int i = 0; i < terms.length - 1; i++) {
			//
			Term t1 = terms[i];
			Term t2 = terms[i + 1];
			//
			if (t1 == null || t2 == null) {
				continue;
			}
			//
			if (t1.getPos().equals("nz")
					//
					&& t2.getPos().equals("no")) {
				terms[i].setWord(t1.getWord() + t2.getWord());
				terms[i].setPos("no");
				terms[i + 1] = null;
			}
		}
		//
		LinkedList<Term> list = new LinkedList<Term>();
		for (Term term : terms) {
			if (term != null) {
				list.addLast(term);
			}
		}
		terms = list.toArray(new Term[0]);
		//
		return terms;
	}

	public static Term[] _5_7(Term[] terms) {
		//
		for (int i = 0; i < terms.length; i++) {
			Term t = terms[i];
			if (t.getWord().length() == 1) {
				char c = t.getWord().charAt(0);
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
					terms[i].setPos("en");
				}
			}
		}
		//
		for (int i = 0; i < terms.length - 1; i++) {
			//
			Term t1 = terms[i];
			Term t2 = terms[i + 1];
			//
			if (t1 == null || t2 == null) {
				continue;
			}
			//

			if (t1.getPos().equals("en") && t2.getPos().equals("en")) {
				terms[i] = null;
				terms[i + 1].setWord(t1.getWord() + t2.getWord());
				terms[i + 1].setPos("en");
			}
		}
		//
		LinkedList<Term> list = new LinkedList<Term>();
		for (Term term : terms) {
			if (term != null) {
				list.addLast(term);
			}
		}
		terms = list.toArray(new Term[0]);
		//
		return terms;
	}

	//
	public static Term[] _5_8_时间合并(Term[] terms) {
		// 年月日
		for (int i = 0; i < terms.length - 5; i++) {
			Term t0 = terms[i];
			Term t1 = terms[i + 1];
			Term t2 = terms[i + 2];
			Term t3 = terms[i + 3];
			Term t4 = terms[i + 4];
			Term t5 = terms[i + 5];
			//
			if (t0 == null || t1 == null || t2 == null || t3 == null || t4 == null || t5 == null) {
				continue;
			}
			//
			if (t0.getPos().equals("m")
					//
					& t1.getWord().equals("年")
					//
					&& t2.getPos().equals("m")
					//
					&& t3.getWord().equals("月")
					//
					&& t4.getPos().equals("m")
					//
					&& t5.getWord().equals("日")) {
				String word = t0.getWord() + t1.getWord() + t2.getWord() + t3.getWord() + t4.getWord() + t5.getWord();
				String pos = "t";
				//
				terms[i] = terms[i + 1] = terms[i + 2] = terms[i + 3] = terms[i + 4] = null;
				//
				t5.setWord(word);
				t5.setPos(pos);
			}
		}
		// 年月
		for (int i = 0; i < terms.length - 5; i++) {
			Term t0 = terms[i];
			Term t1 = terms[i + 1];
			Term t2 = terms[i + 2];
			Term t3 = terms[i + 3];
			//
			if (t0 == null || t1 == null || t2 == null || t3 == null) {
				continue;
			}
			//
			if (t0.getPos().equals("m")
					//
					& t1.getWord().equals("年")
					//
					&& t2.getPos().equals("m")
					//
					&& t3.getWord().equals("月")) {
				String word = t0.getWord() + t1.getWord() + t2.getWord() + t3.getWord();
				String pos = "t";
				//
				terms[i] = terms[i + 1] = terms[i + 2] = null;
				//
				t3.setWord(word);
				t3.setPos(pos);
			}
		}
		// 月日
		for (int i = 0; i < terms.length - 3; i++) {
			Term t0 = terms[i];
			Term t1 = terms[i + 1];
			Term t2 = terms[i + 2];
			Term t3 = terms[i + 3];
			//
			if (t0 == null || t1 == null || t2 == null || t3 == null) {
				continue;
			}
			//
			if (t0.getPos().equals("m")
					//
					& t1.getWord().equals("月")
					//
					&& t2.getPos().equals("m")
					//
					&& t3.getWord().equals("日")) {
				String word = t0.getWord() + t1.getWord() + t2.getWord() + t3.getWord();
				String pos = "t";
				//
				terms[i] = terms[i + 1] = terms[i + 2] = null;
				//
				t3.setWord(word);
				t3.setPos(pos);
			}
		}
		// x个月
		for (int i = 0; i < terms.length - 2; i++) {
			Term t0 = terms[i];
			Term t1 = terms[i + 1];
			Term t2 = terms[i + 2];
			//
			if (t0 == null || t1 == null || t2 == null) {
				continue;
			}
			//
			if (t0.getPos().equals("m")
					//
					& t1.getWord().equals("个")
					//
					&& t2.getWord().equals("月")) {
				String word = t0.getWord() + t1.getWord() + t2.getWord();
				String pos = "t";
				//
				terms[i] = terms[i + 1] = null;
				//
				t2.setWord(word);
				t2.setPos(pos);
			}
		}
		// 百年或年或月或日
		for (int i = 0; i < terms.length - 1; i++) {
			Term t0 = terms[i];
			Term t1 = terms[i + 1];
			//
			if (t0 == null || t1 == null) {
				continue;
			}
			//
			if (t0.getPos().equals("m")
					//
					&& (t1.getWord().equals("百年") || t1.getWord().equals("年") || t1.getWord().equals("月")
							|| t1.getWord().equals("日"))) {
				String word = t0.getWord() + t1.getWord();
				String pos = "t";
				//
				terms[i] = null;
				//
				t1.setWord(word);
				t1.setPos(pos);
			}
		}
		// 20多年或20多天
		for (int i = 0; i < terms.length - 1; i++) {
			Term t0 = terms[i];
			Term t1 = terms[i + 1];
			//
			if (t0 == null || t1 == null) {
				continue;
			}
			//
			String word0 = t0.getWord();
			//
			if (t0.getPos().equals("m")
					//
					&& (word0.endsWith("0") || word0.endsWith("十"))
					//
					&& (t1.getWord().equals("多年") || t1.getWord().equals("多天"))) {
				String word = t0.getWord() + t1.getWord();
				String pos = "t";
				//
				terms[i] = null;
				//
				t1.setWord(word);
				t1.setPos(pos);
			}
		}
		//
		LinkedList<Term> list = new LinkedList<Term>();
		for (Term term : terms) {
			if (term != null) {
				list.addLast(term);
			}
		}
		terms = list.toArray(new Term[0]);
		//
		return terms;
	}
}

package HUST.Semantic.Role.Labeling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.LinkedList;

import HUST.Chinese.Lexical.Analysis.System.Term;

public class SRLTool {

	//
	private static Hashtable<String, Score> ht = null;

	//
	// public static Phrase[] _3_VNdeN_Rules(Phrase[] phrases) {
	// /**
	// * */
	// // rank1, V+N+de+"时候/方式/方法/..."
	// // 感谢/v 世界/n 的/u 方式/n
	// // 抢/v 篮板/n 的/uj 时候/n
	// // rank2, 固定搭配
	// // 游览/v 苏州/ns 的/u 游客/nrsf 们/k
	// // rank3, 单方面存在nr_ns_nt
	// // 侦破/v 案件/n 的/u 警察/no
	// // rank4, 都含或者都不含
	// /**
	// * */
	// // rank 1
	// // 感谢/v 世界/n 的/u 方式/n
	// for (int i = 0; i < phrases.length - 3; i++) {
	// if (phrases[i].getLabel().equals(Var._V)
	// //
	// && phrases[i + 1].getLabel().equals(Var._N)
	// //
	// && phrases[i + 2].getLabel().equals(Var._U1De)
	// //
	// && phrases[i + 3].getLabel().equals(Var._N)
	// //
	// && "/时候/行为/方式/方法/事件/案件/情况/".contains("/" + phrases[i +
	// 3].getLastTerm().getWord() + "/")) {
	// // phrases[i].setPhPos(Var._N);
	// // phrases[i + 2].setPhPos(Var._N);
	// phrases[i].setLabel(Var._AN);
	// phrases[i + 1].setLabel(Var._AN);
	// }
	// }
	// // rank 3中情况1
	// // 展现/v 金主/nrsf 的/u 实力/n
	// for (int i = 0; i < phrases.length - 3; i++) {
	// if (phrases[i].getLabel().equals(Var._V)
	// //
	// && phrases[i + 1].getLabel().equals(Var._N)
	// //
	// && phrases[i + 1].IsSubjectNr_Ns_Nt()
	// //
	// && phrases[i + 2].getLabel().equals(Var._U1De)
	// //
	// && phrases[i + 3].getLabel().equals(Var._N)
	// //
	// && !phrases[i + 3].IsSubjectNr_Ns_Nt()) {
	// // phrases[i + 2].setPhPos(Var._N);
	// phrases[i + 1].setLabel(Var._AN);
	// }
	// }
	// // rank 3中情况2
	// // 侦破/v 案件/n 的/u 警察/no
	// // 一直/d 关注/v 此案/r 进展/vn 的/u 美国/ns 律师/no 刘/nr 龙珠/nz 向/p 南都/ns 记者/no 表示/v
	// for (int i = 0; i < phrases.length - 3; i++) {
	// //
	// if (phrases[i].getLabel().equals(Var._V)
	// //
	// && phrases[i + 1].getLabel().equals(Var._N)
	// //
	// && !phrases[i + 1].IsSubjectNr_Ns_Nt()
	// //
	// && phrases[i + 2].getLabel().equals(Var._U1De)
	// //
	// && phrases[i + 3].getLabel().equals(Var._N)
	// //
	// && phrases[i + 3].IsSubjectNr_Ns_Nt()) {
	// // phrases[i].setPhPos(Var._N);
	// // phrases[i + 2].setPhPos(Var._N);
	// phrases[i].setLabel(Var._AN);
	// phrases[i + 1].setLabel(Var._AN);
	// }
	// }
	// // rank 4中情况1
	// // V+Nr_Ns_Nt+de+Nr_Ns_Nt
	// // 感谢/v 佛光山/n 的/u 法师/no 们/k 为/v 我们/r 祈福/v
	// for (int i = 0; i < phrases.length - 3; i++) {
	// //
	// if (phrases[i].getLabel().equals(Var._V)
	// //
	// && phrases[i + 1].getLabel().equals(Var._N)
	// //
	// && phrases[i + 1].IsSubjectNr_Ns_Nt()
	// //
	// && phrases[i + 2].getLabel().equals(Var._U1De)
	// //
	// && phrases[i + 3].getLabel().equals(Var._N)
	// //
	// && phrases[i + 3].IsSubjectNr_Ns_Nt()) {
	// phrases[i + 1].setLabel(Var._AN);
	// // phrases[i + 2].setPhPos(Var._N);
	// }
	// }
	// // rank 4中情况2
	// // V+!Nr_Ns_Nt+de+!Nr_Ns_Nt
	// // 维护/v 党章/n 的/uj 严肃性/n
	// for (int i = 0; i < phrases.length - 3; i++) {
	// if (phrases[i].getLabel().equals(Var._V)
	// //
	// && phrases[i + 1].getLabel().equals(Var._N)
	// //
	// && !phrases[i + 1].IsSubjectNr_Ns_Nt()
	// //
	// && phrases[i + 2].getLabel().equals(Var._U1De)
	// //
	// && phrases[i + 3].getLabel().equals(Var._N)
	// //
	// && !phrases[i + 3].IsSubjectNr_Ns_Nt()) {
	// phrases[i + 1].setLabel(Var._AN);
	// // phrases[i + 2].setPhPos(Var._N);
	// }
	// }
	// //
	// return phrases;
	// }

	public static Phrase[] _1_VorP_Rules(Phrase[] phrases) {
		/**
		 * 为
		 */
		for (int i = 0; i < phrases.length; i++) {
			if (phrases[i].getLabel().equals(SRLVar._P) && phrases[i].getLastTerm().getWord().equals("为")) {
				//
				boolean hasVerbInRight = false;
				for (int j = i; j < phrases.length; j++) {
					if (phrases[j].getLabel().equals(SRLVar._V)) {
						hasVerbInRight = true;
					}
				}
				// 内容/n 为/p 罗世海/nr 女儿经/n 核查/vn 为/v_p 贫困户/n 家庭/n
				for (int j = i + 1; j < phrases.length; j++) {
					if (phrases[j].getTerms().length == 1 && phrases[j].getLastTerm().getWord().equals("为")) {
						hasVerbInRight = false;
					}
				}
				// 内容/n 为/p 罗世海/nr 女儿经/n 核查/vn 为/v_p 贫困户/n 家庭/n
				for (int j = 0; j < i; j++) {
					if (phrases[j].getTerms().length == 1 && phrases[j].getLastTerm().getWord().equals("为")) {
						hasVerbInRight = false;
					}
				}
				//
				if (!hasVerbInRight) {
					phrases[i].setLabel(SRLVar._V);
				}
			}
		}
		/**
		 * 将
		 */
		for (int i = 0; i < phrases.length; i++) {
			if (phrases[i].getLabel().equals(SRLVar._Jiang)
					//
					&& i + 1 < phrases.length) {
				if (phrases[i + 1].getLabel().equals(SRLVar._V)
						//
						|| phrases[i + 1].getLabel().equals(SRLVar._VJ)
						//
						|| phrases[i + 1].getLabel().equals(SRLVar._VZ)) {
					phrases[i].setLabel(SRLVar._D);
				} else {
					phrases[i].setLabel(SRLVar._Ba);
				}
			}
		}
		//
		return phrases;
	}

	public static Phrase[] _2_P_Rules(Phrase[] phrases, int step) {
		//
		for (int i = 0; i < phrases.length - 1; i++) {
			if (phrases[i].getLabel().equals(SRLVar._P)) {

				/**
				 * */
				if (step == 1) {
					//
					if ("/以/由/".contains("/" + phrases[i].getLastTerm().getWord() + "/")) {
						int stop = SRLTool._3_1_indexOfFirst_Pone_End(phrases, i, 1);
						//
						if (stop == -1) {
							stop = SRLTool._3_1_indexOfFirst_Pone_End(phrases, i, 100);
						}
						//
						if (stop == -1) {
							stop = phrases.length;
						}
						//
						for (int j = i + 1; j < stop; j++) {
							phrases[j].setLabel(SRLVar._PD);
						}
					}
				}
				/**
				 * */
				if (step == 2) {
					//
					if (!"/以/由/".contains("/" + phrases[i].getLastTerm().getWord() + "/")) {
						int stop = SRLTool._3_2_indexOfFirst_Ptwo_End(phrases, i, 2);
						//
						if (stop == -1) {
							stop = SRLTool._3_2_indexOfFirst_Ptwo_End(phrases, i, 200);
						}
						//
						if (stop == -1) {
							//
							// 最后的END还是END而不是PD
							stop = phrases.length - 1;
						}
						//
						for (int j = i + 1; j < stop; j++) {
							phrases[j].setLabel(SRLVar._PD);
						}
					}
				}
			}
		}
		//
		return phrases;
	}

	public static int _3_1_indexOfFirst_Pone_End(Phrase[] phrases, int start, int step) {
		/**
		 * */
		int result = SRLTool._3_x_indexOfFirst_P_End(phrases, start, step);
		return result;
	}

	public static int _3_2_indexOfFirst_Ptwo_End(Phrase[] phrases, int start, int step) {
		/**
		 * */
		int result = SRLTool._3_x_indexOfFirst_P_End(phrases, start, step);
		/**
		 * */
		//
		// 在/p 投标/v 或/c 购买/v 招标文件/n 前/f
		if (result != -1
				//
				&& phrases[result].getLabel().equals(SRLVar._V)
				//
				&& result > 2
				//
				&& phrases[result - 1].getLabel().equals(SRLVar._C)
				//
				&& phrases[result - 2].getLabel().equals(SRLVar._V)) {
			result = -1;
		}
		//
		// 好像/v 之前/f 也/d 有/v 教育/vn 机构/nttc 在/p 洽谈/v
		if (start == phrases.length - 3
				//
				&& phrases[phrases.length - 2].getLabel().equals(SRLVar._V)) {
			result = start;
		}
		//
		return result;
	}

	private static int _3_x_indexOfFirst_P_End(Phrase[] phrases, int start, int step) {
		//
		int result = -1;
		//
		String[][] rules = null;
		if (step == 1) {
			rules = SRLRule.POne_Rules;
		}
		if (step == 2) {
			rules = SRLRule.PTwo_Rules;
		}
		//
		if (step == 100) {
			rules = SRLRule.P_Rules_100;
		}
		//
		if (step == 200) {
			rules = SRLRule.P_Rules_200;
		}

		/**
		 * */
		for (int i = start + 1; i < phrases.length; i++) {
			//
			if (result != -1) {
				break;
			}
			//
			for (int j = 0; j < rules.length; j = j + 2) {
				String[] rule = rules[j];
				//
				if (i == 5 && j == 10 && step == 200) {
					System.out.print("");
				}
				//
				//
				if (i + rule.length / 2 - 1 >= phrases.length) {
					continue;
				}
				//
				boolean flag = true;
				//
				for (int x = 0; x < rule.length / 2; x++) {
					//
					if (rule[x + rule.length / 2].equals(SRLVar._0与词性不等)) {
						if (phrases[i + x].getLabel().equals(rule[x])) {
							//
							flag = false;
						}
					}
					//
					if (rule[x + rule.length / 2].equals(SRLVar._0与词性相等)) {
						if (!phrases[i + x].getLabel().equals(rule[x])) {
							//
							flag = false;
						}
					}
					//
					if (rule[x + rule.length / 2].equals(SRLVar._0与词汇不等)) {
						if (phrases[i + x].getTerms().length == 1
								//
								&& rule[x].contains("/" + phrases[i + x].getLastTerm().getWord() + "/")) {
							//
							flag = false;
						}
					}
					//
					if (rule[x + rule.length / 2].equals(SRLVar._0与词汇相等)) {
						if (phrases[i + x].getTerms().length != 1
								//
								|| !rule[x].contains("/" + phrases[i + x].getLastTerm().getWord() + "/")) {
							//
							flag = false;
						}
					}
				}
				// 查看是否满足条件
				if (flag) {
					// 如果p到这里之间全是v，则不合法
					// 对于/p 要/v 上班/v 要/v 送娃/v 上学/v 的/u 家长/n 略/d 辛苦/a
					// 为了/p 能/v 按时/d 起床/v
					boolean allVerb = true;
					for (int x = start + 1; x <= i; x++) {
						if (!phrases[x].getLastTerm().getPos().equals("v")
								&& !phrases[x].getLastTerm().getPos().equals("d")) {
							allVerb = false;
						}
					}
					if (start + 1 >= i) {
						allVerb = false;
					}
					if (allVerb) {
						continue;
					}
					//
					if (i == 3) {
						System.out.print("");
					}
					//
					if (i + Integer.parseInt(rules[j + 1][0]) == phrases.length - 1) {
						continue;
					} else {
						result = i + Integer.parseInt(rules[j + 1][0]);
					}
					//
					break;
				}
			}
		} /**
			 * */
		//
		return result;
	}

	public static Phrase[] _4_fix_x_V_x_End(Phrase[] phrases) throws IOException {
		//
		Hashtable<String, Score> ht = _get_ht_Vs();
		// 从右往左
		for (int i = phrases.length - 1; i >= 0; i--) {
			// 遇到动词
			if (phrases[i].getLabel().equals(SRLVar._V) || phrases[i].getLabel().equals(SRLVar._VZ)) {
				// 判断该动词是否在表中
				Score score = ht.get(phrases[i].getLastTerm().getWord().replaceAll("“", "").replaceAll("”", ""));
				// 不在，继续检查
				if (score == null) {
					continue;
				}
				// 在，继续
				// 该动词的固定主语和固定宾语
				String fixSubject = score.getFixSubject();
				String fixObject = score.getFixObject();
				//
				if (fixSubject.length() > 0 || fixObject.length() > 0) {
					System.out.print("");
				}
				// 从当前动词的右边开始
				for (int start = i + 1; start < phrases.length; start++) {
					Phrase p = phrases[start];
					for (int t = 0; t < p.getTerms().length; t++) {
						// 寻找固定宾语，且为名词性
						if (score.getFixObject().contains("/" + p.getTerms()[t].getWord() + "/")
								//
								&& p.getTerms()[t].getPos().contains("n")) {
							//
							if (p.getLabel().equals(SRLVar._V) || p.getLabel().equals(SRLVar._VZ)) {
								continue;
							}
							// 找到，则从动词右边到该搭配为止，动词变VJN
							for (int x = i + 1; x < start; x++) {
								if (phrases[x].getLabel().equals(SRLVar._V)) {
									phrases[x].setLabel(SRLVar._VJN);
								}
							}
						}
					}

				}
			}
		}
		//

		//
		return phrases;
	}

	public static Phrase[] _4_x_V_x_V_x_End(Phrase[] phrases) throws IOException {
		//
		Hashtable<String, Score> ht = _get_ht_Vs();
		//
		int i1 = SRLTool.indexOfFirstVerbPhrase(phrases, 0);
		int i2 = SRLTool.indexOfLastVerbPhrase(phrases, phrases.length - 1);

		//
		if (i1 >= 0 && i2 >= 0
				&& ht.containsKey(phrases[i1].getLastTerm().getWord().replaceAll("“", "").replaceAll("”", ""))
				//
				&& ht.containsKey(phrases[i2].getLastTerm().getWord().replaceAll("“", "").replaceAll("”", ""))) {
			//
			Score s1 = ht.get(phrases[i1].getLastTerm().getWord());
			Score s2 = ht.get(phrases[i2].getLastTerm().getWord());
			//
			int c1 = 0;
			int c2 = 0;
			// 1
			if (s1.getTotal() > s2.getTotal()) {
				c1++;
			} else {
				c2++;
			}
			// 2
			if (i2 == phrases.length - 2) {
				if (s1.getEnd() / s1.getTotal() < s2.getEnd() / s2.getTotal()) {
					c2++;
				} else {
					c1++;
				}
			} else {
				if (s1.getEnd() / s1.getTotal() < s2.getEnd() / s2.getTotal()) {
					c1++;
				} else {
					c2++;
				}
			}
			// 3
			if (s1.getX_V() / s1.getHasObject() > s2.getV_x() / s2.getHasSubject() + 0.1) {
				c1++;
			} else if (s1.getX_V() / s1.getHasObject() + 0.1 < s2.getV_x() / s2.getHasSubject()) {
				c2++;
			}
			// 4
			if (s1.getHasObject() / s1.getTotal() > s2.getHasSubject() / s2.getTotal()) {
				c1++;
			} else {
				c2++;
			}
			//
			int t1 = 0;
			int t2 = 0;
			if (s1.getEnd() / s1.getTotal() < 0.4 && s1.getHasObject() / s1.getTotal() > 0.6) {
				t1 = 2;
			}
			if (i2 != phrases.length - 2 && s2.getEnd() / s2.getTotal() < 0.4
					&& s2.getHasSubject() / s2.getTotal() > 0.6) {
				t2 = 2;
			}
			//
			if (c1 >= 3 && t2 != 2) {
				phrases[i1].setLabel(SRLVar._VZ);
				phrases[i2].setLabel(SRLVar._VJ);
				// System.out.println(s1.toString());
			}
			if (c2 >= 3 && t1 != 2) {
				phrases[i1].setLabel(SRLVar._VJ);
				phrases[i2].setLabel(SRLVar._VZ);
				// System.out.println(s2.toString());
			}
			//
		}
		//
		return phrases;
	}

	public static Phrase[] _4_x_V_fix_V_x_End(Phrase[] phrases) throws IOException {

		// 定位两个动词
		int i1 = SRLTool.indexOfFirstVerbPhrase(phrases, 0);
		int i2 = SRLTool.indexOfLastVerbPhrase(phrases, phrases.length - 1);
		//
		if (i1 == -1 || i2 == -1) {
			return phrases;
		}
		// 第一个动词的固定搭配
		Score s1 = ht.get(phrases[i1].getLastTerm().getWord().replaceAll("“", "").replaceAll("”", ""));
		if (s1 == null) {
			return phrases;
		}
		if (s1.getFixObject().length() == 0) {
			return phrases;
		}
		//
		for (int start = i1 + 1; start < i2; start++) {
			Phrase p = phrases[start];
			for (int t = 0; t < p.getTerms().length; t++) {
				// 寻找固定宾语，且为名词性
				if (s1.getFixObject().contains("/" + p.getTerms()[t].getWord() + "/")
						//
						&& p.getTerms()[t].getPos().contains("n")) {
					//
					if (p.getLabel().equals(SRLVar._V) || p.getLabel().equals(SRLVar._VZ)) {
						return phrases;
					}
					// 找到，则从i2位置动词变VZ
					phrases[i2].setLabel(SRLVar._VZ);
					return phrases;
				}
			}
		}
		// 第二个动词的固定搭配
		Score s2 = ht.get(phrases[i2].getLastTerm().getWord().replaceAll("“", "").replaceAll("”", ""));
		if (s2 == null) {
			return phrases;
		}
		if (s2.getFixSubject().length() == 0) {
			return phrases;
		}
		//
		// 最新/a 应对/v 暴力/n 催收/v 方法/n (含网贷和信用卡)/en
		// 催收/v, 作谓语时的总数=15, 句末=4, 有主语=14, 主语含谓语=7, 主语不含谓语=7, 主语中有人=0, 有宾语=8,
		// 宾语含谓语=3, 宾语不含谓语=5, 宾语中有人=0, 主[暴力/n], 宾[]
		for (int start = i1 + 1; start < i2; start++) {
			Phrase p = phrases[start];
			for (int t = 0; t < p.getTerms().length; t++) {
				// 寻找固定宾语，且为名词性
				if (s2.getFixSubject().contains("/" + p.getTerms()[t].getWord() + "/")
						//
						&& p.getTerms()[t].getPos().contains("n")) {
					//
					if (p.getLabel().equals(SRLVar._V) || p.getLabel().equals(SRLVar._VZ)) {
						return phrases;
					}
					// 找到，则从i1位置动词变VZ
					phrases[i1].setLabel(SRLVar._VZ);
					return phrases;
				}
			}
		}
		//
		return phrases;
	}

	public static Phrase[] _5_singleWord(Phrase[] phrases) {
		/**
		 * */
		/**
		 * */
		// "等"的词性
		for (int i = 0; i < phrases.length - 1; i++) {
			Term[] terms = phrases[i].getTerms();
			if (terms.length != 1) {
				continue;
			}
			if (terms[0].getWord().equals(SRLVar.等)) {
				Phrase p = phrases[i + 1];
				Term[] ts = p.getTerms();
				Term t = ts[ts.length - 1];
				if (t.getWord().equals("方面")) {
					phrases[i].getTerms()[0].setPos(SRLVar.u);
					phrases[i].setLabel(SRLVar._U);
				}
			}
		}
		//
		return phrases;
	}

	public static Phrase[] _x_updatePhrasesPosesWithAllRules(Phrase[] phrases, int clock) {
		//
		int counter = phrases.length;
		//
		for (int times = 0; times < counter; times++) {
			// v-or-p,之后为1
			// p-pd,之后为2
			// v-n-de-n,之后为3
			// VVs,之后为4
			//
			if (clock == 4) {
				System.out.print("");
			}
			//
			/**
			 * */
			if (clock >= 0) {
				/**
				 * 放在这里的，都是与依赖于整句而非单个词性，或者不依赖于V的，或者对V下手的
				 */
				//
				phrases = SRLTool._x_1_Phrase_2in1(phrases, SRLRule._0_1__Phrase_2in1_Rules);
				//
				phrases = SRLTool._x_3_runPhrase_Phrase_Regex(phrases, SRLRule._0_1_common_Regex_Rules);
				//
				phrases = SRLTool._x_2_runPhrase_Phrase(phrases, SRLRule._0_2_common__Rules);
				//
				// phrases = SRLTool._x_2_runPhrase_Phrase(phrases,
				// SRLRule._0_4_common_Phrase_Phrase_Rules);

			}
			/**
			 * */
			if (clock >= 1) {
				// 区分了P和V之后
				//
				phrases = SRLTool._x_2_runPhrase_Phrase(phrases, SRLRule._1_1_after_VorP_Phrase_Phrase_Rules);
				phrases = SRLTool._x_3_runPhrase_Phrase_Regex(phrases,
						SRLRule._1_5_after_VorP_Phrase_Phrase_Regex_Rules);
				//
			}
			/**
			 * */
			if (clock >= 2) {
				// P-PD之后
				// phrases = Util._x_2_runPhrase_Phrase(phrases,
				// Rule._2_1_after_Pphrase_One_Phrase_Phrase_Rules);
			}
			/**
			 * */
			if (clock >= 3) {
				// VNdeN之后
				phrases = SRLTool._x_2_runPhrase_Phrase(phrases, SRLRule._3_1_after_Pphrase_Two_Phrase_Phrase_Rules);
				//
				phrases = SRLTool._x_1_Phrase_2in1(phrases, SRLRule._3_5_after_Pphrase_phrase_Phrase_2_1_Rules);
				//
				phrases = SRLTool._x_2_runPhrase_Phrase(phrases, SRLRule._3_9_final_Phrase_Phrase_Rules);
			}
			/**
			 * */
			if (clock >= 4) {
				//
				phrases = SRLTool._x_2_runPhrase_Phrase(phrases, SRLRule._4_5_after_VVs_Phrase_Rules);
			}
		}
		//
		return phrases;
	}

	private static Phrase[] _x_1_Phrase_2in1(Phrase[] phrases, String[][] rules) {
		/**
		 * */
		//
		for (String[] rule : rules) {
			//
			for (int i = 1; i < phrases.length; i++) {
				//
				if (phrases[i - 1] == null || phrases[i] == null) {
					continue;
				}
				//
				if (phrases[i - 1].getLabel().equals(rule[0])
						//
						&& phrases[i].getLabel().equals(rule[1])) {
					LinkedList<Term> list = new LinkedList<Term>();
					for (Term term : phrases[i - 1].getTerms()) {
						list.addLast(term);
					}
					for (Term term : phrases[i].getTerms()) {
						list.addLast(term);
					}
					phrases[i - 1] = new Phrase(list.toArray(new Term[0]), rule[2]);
					phrases[i] = null;
				}
			}
			//
			LinkedList<Phrase> list = new LinkedList<Phrase>();
			for (int i = 0; i < phrases.length; i++) {
				if (phrases[i] != null) {
					list.addLast(phrases[i]);
				}
			}
			phrases = list.toArray(new Phrase[0]);
			//
		}
		//
		return phrases;
	}

	private static Phrase[] _x_2_runPhrase_Phrase(Phrase[] phrases, String[][] rules) {
		/**
		 * */
		for (String[] rule : rules) {
			//
			String[] rule1 = new String[rule.length / 2];
			String[] rule2 = new String[rule.length / 2];
			for (int i = 0; i < rule1.length; i++) {
				rule1[i] = rule[i];
			}
			for (int i = 0; i < rule2.length; i++) {
				rule2[i] = rule[i + rule.length / 2];
			}
			//
			for (int i = 0; i < phrases.length; i++) {
				boolean flag = true;
				// debug
				if (i == 4 && rule[0].equals(SRLVar._PD)) {
					System.out.print("");
				}
				// end of debug
				for (int x = 0; x < rule1.length; x++) {
					if (rule1[x].contains("/")) {
						if (!rule1[x].contains("/" + phrases[i + x].getLabel() + "/")) {
							flag = false;
							break;
						}
					} else {
						if (i + x >= phrases.length) {
							flag = false;
							break;
						}
						if (!rule1[x].equals(phrases[i + x].getLabel())) {
							flag = false;
							break;
						}
					}
				}
				if (flag) {
					for (int x = 0; x < rule2.length; x++) {
						//
						if (rule2[x].length() > 0) {
							phrases[i + x].setLabel(rule2[x]);
						}
					}
				}
			}
		}
		//
		return phrases;
	}

	private static Phrase[] _x_3_runPhrase_Phrase_Regex(Phrase[] phrases, String[][] rules) {
		/**
		 * */
		for (int counter = 0; counter < rules.length; counter++) {
			//
			String[] rule = rules[counter];
			//
			for (int i = 0; i < phrases.length - rule.length / 4 + 1; i++) {
				boolean flag = true;
				for (int x = 0; x < rule.length / 4; x++) {
					//
					if (rule[x + rule.length / 2].equals(SRLVar._0与词性不等)) {
						if (phrases[i + x].getLabel().equals(rule[x])) {
							//
							flag = false;
						}
					}
					//
					if (rule[x + rule.length / 2].equals(SRLVar._0与词性相等)) {
						if (!phrases[i + x].getLabel().equals(rule[x])) {
							//
							flag = false;
						}
					}
					//
					if (rule[x + rule.length / 2].equals(SRLVar._0与词汇不等)) {
						if (phrases[i + x].getTerms().length == 1
								//
								&& rule[x].contains("/" + phrases[i + x].getLastTerm().getWord() + "/")) {
							//
							flag = false;
						}
					}
					//
					if (rule[x + rule.length / 2].equals(SRLVar._0与词汇相等)) {
						if (phrases[i + x].getTerms().length != 1
								//
								|| !rule[x].contains("/" + phrases[i + x].getLastTerm().getWord() + "/")) {
							//
							flag = false;
						}
					}
				}
				// 查看是否满足条件
				if (flag) {
					// 如满足,则开始更新
					for (int x = 0; x < rule.length / 4; x++) {
						//
						if (rule[x + rule.length / 2 + rule.length / 4].equals(SRLVar._1不变)) {
							// do nothing
						}
						//
						if (rule[x + rule.length / 2 + rule.length / 4].equals(SRLVar._1改词性)) {
							phrases[i + x].setLabel(rule[x + rule.length / 4]);
						}
						// 改词汇
						// if (rule[x + rule.length / 2 + rule.length /
						// 4].equals(Rule._1改词汇)) {
						// if (phrases[i + x].getTerms().length == 1) {
						// phrases[i + x].getLastTerm().setWord("");
						// }
						// }
					}
				}
			}
		}
		//
		return phrases;
	}

	private static Hashtable<String, Score> _get_ht_Vs() throws IOException {
		//
		if (SRLTool.ht != null) {
			return ht;
		}
		//
		long start = System.currentTimeMillis();
		//
		// 发布/v, 总数=318, 句末=96, 有主语=313, 主语是个名词=121, 主语为句子=162, 主语中有N=4,
		// 有宾语=222, 宾语是个名词=31, 宾语为句子=154, 宾语中有N=3
		File file = new File("d:\\Vs.txt");
		FileInputStream fis = new FileInputStream(file.getAbsolutePath());
		InputStreamReader isr = new InputStreamReader(fis, "utf8");
		BufferedReader br = new BufferedReader(isr);
		//
		String line = null;
		//
		ht = new Hashtable<String, Score>();
		//
		while ((line = br.readLine()) != null) {
			//
			if (line.length() < 4) {
				continue;
			}
			// 拿到单词本身
			String word = line.split("/v, ")[0];
			// 拿到单词出现总数
			int total = Integer.parseInt(line.split("作谓语时的总数=")[1].split(",")[0]);
			// 拿到有主语的总数
			int hasSubject = Integer.parseInt(line.split("有主语=")[1].split(",")[0]);
			// 拿到左边有谓语的数目
			int V_x = Integer.parseInt(line.split("主语含谓语=")[1].split(",")[0]);
			// 拿到有宾语的总数
			int hasObject = Integer.parseInt(line.split("有宾语=")[1].split(",")[0]);
			// 拿到右边有谓语的数目
			int x_V = Integer.parseInt(line.split("宾语含谓语=")[1].split(",")[0]);
			// 拿到句末的数目
			int end = Integer.parseInt(line.split("句末=")[1].split(",")[0]);
			// 拿到主语固定搭配
			String[] s1 = line.split("主\\[")[1].split("\\], ")[0].split(", ");
			// 拿到宾语固定搭配
			String[] s2 = line.split("宾\\[")[1].split("\\], ")[0].split(", ");
			//
			for (int i = 0; i < s1.length; i++) {
				s1[i] = s1[i].split("/")[0];
			}
			//
			for (int i = 0; i < s2.length; i++) {
				s2[i] = s2[i].split("/")[0];
			}
			//
			if (s1.length > 0 || s2.length > 0) {
				System.out.print("");
			}
			//
			String fixSubject = "";
			for (int i = 0; i < s1.length; i++) {
				fixSubject = fixSubject + "/" + s1[i];
			}
			if (fixSubject.length() > 0) {
				fixSubject = fixSubject + "/";
			}
			//
			String fixObject = "";
			for (int i = 0; i < s2.length; i++) {
				fixObject = fixObject + "/" + s2[i];
			}
			if (fixObject.length() > 0) {
				fixObject = fixObject + "/";
			}
			//
			Score score = new Score(word, total, hasSubject, V_x, hasObject, x_V, end, fixSubject, fixObject);
			//
			ht.put(word, score);
		}
		//
		System.out.println(System.currentTimeMillis() - start);
		//
		isr.close();
		br.close();
		//
		return ht;
	}

	private static int indexOfFirstVerbPhrase(Phrase[] phrases, int start) {
		for (int i = start; i < phrases.length; i++) {
			if (phrases[i].getLabel().equals(SRLVar._V)) {
				return i;
			}
		}
		//
		return -1;
	}

	private static int indexOfLastVerbPhrase(Phrase[] phrases, int end) {
		for (int i = end; i >= 0; i--) {
			if (phrases[i].getLabel().equals(SRLVar._V)) {
				return i;
			}
		}
		//
		return -1;
	}
}

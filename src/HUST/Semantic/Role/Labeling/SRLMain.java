package HUST.Semantic.Role.Labeling;

import java.io.IOException;
import java.util.LinkedList;

import HUST.Chinese.Lexical.Analysis.System.ICTMain;
import HUST.Chinese.Lexical.Analysis.System.ICTTool;
import HUST.Chinese.Lexical.Analysis.System.Term;

public class SRLMain {

	public static void main(String[] args) throws IOException {
		//
		// String[] inputs = new String[] { "央行/nt 连续/ad 6日/tl 净/d 回笼/v 资金/n",
		// //
		// "住/v 安乡县深柳镇/ns 紫/a 珑/x 小区/n 茉莉/n 轩/n 5-B/en",
		// //
		// "他/r 已经/d 好/a 了/u",
		// //
		// "双方/n 将/d 在/p 投资银行/n 、/w 资产/n 管理/vn 、/w 营销/vn 推广/vn 等/v 多/a 方面/n 开展/v
		// 广泛/a 、/w 深入/a 的/u 合作/vn ，/w",
		// //
		// "天马/ns 发债/v 上市/ns 能/v 赚/v 多少/ria",
		// //
		// };
		//
		// for (String input : inputs) {
		// Phrase[] phrases = SRLMain.run(input);
		// //
		// System.out.println(input);
		// System.out.println(SRLMain.printPhrases(phrases));
		// }

		// TODO Auto-generated method stub
		String[] records = new String[] {
				//
				"完成之后建筑也是庄严和谐",
				//
				"周二的雾天来的",
				//
				"门票确实小贵",
				//
				"竹海相比山水园要稍微凉快一些，不过这个天依然是热的吃不消。竹海的消费如下：小火车一人30元，看熊猫等一人80元，去那个什么最高峰又是一人80元，竹筏一艘200元，如果你只出了80元的门票，嗯，那你就看看竹子吧。", };

		//
		for (String record : records) {
			//
			String[] sentences = ICTTool.record2Sentences(record);
			for (String sentence : sentences) {
				//
				String[] clauses = ICTTool.sentence2Clauses(sentence);
				for (String clause : clauses) {
					//
					Term[] terms = ICTMain.runClause(clause);
					//
					String tokens = "";
					for (Term t : terms) {
						if (t.getPos().equals("start")) {
							continue;
						}
						if (t.getPos().equals("end")) {
							continue;
						}
						tokens = tokens + t + " ";
					}
					tokens = tokens.trim();
					System.out.println(tokens);
					// 从分词词性标注到组块
					Phrase[] phrases = SRLMain.run(terms);
					//
					System.out.println(SRLMain.printPhrases(phrases));
					System.out.println();
				}
			}

		}

	}

	public static Phrase[] run(Term[] terms) throws IOException {
		//
		Phrase[] phrases = _1_terms2Phrses(terms);
		//
		phrases = _2_reSetPhraseLabel(phrases);
		//
		phrases = _3_reSetWordPosAndPhraseLabel(phrases);
		//
		phrases = _2_reSetPhraseLabel(phrases);
		//
		return phrases;
	}

	private static Phrase[] _1_terms2Phrses(Term[] terms) {
		//
		LinkedList<Phrase> list = new LinkedList<Phrase>();
		for (Term term : terms) {
			Term[] tmp = new Term[1];
			tmp[0] = term;
			Phrase phrase = new Phrase(tmp, tmp[0].getPos());
			list.add(phrase);
		}
		Phrase[] phrases = list.toArray(new Phrase[0]);
		//
		String[][] rules = SRLRule.TermPos2PhraseLabel_Rules;
		for (String[] rule : rules) {
			//
			for (Phrase phrase : phrases) {
				if (phrase.getTerms()[0].getPos().equals(rule[0])) {
					phrase.setLabel(rule[1]);
				}
			}
		}
		//
		for (Phrase phrase : phrases) {
			if (phrase.getLabel().equals(SRLVar._V)) {
				if (SRLRule.mainPrecicts.contains("/" + phrase.getLastTerm().getWord() + "/")) {
					phrase.setLabel(SRLVar._VZ);
				}
			}
		}
		//
		for (Phrase phrase : phrases) {
			//
			if (phrase.getTerms()[0].getPos().startsWith("n")) {
				phrase.setLabel(SRLVar._N);
			}
			//
			if (phrase.getTerms()[0].getPos().equals(SRLVar.ns)
					//
					|| phrase.getTerms()[0].getPos().equals(SRLVar.nt)
					//
					|| phrase.getTerms()[0].getPos().equals(SRLVar.nttc)
					//
					|| phrase.getTerms()[0].getPos().equals(SRLVar.nz)) {
				phrase.setLabel(SRLVar._NE);
			}

			//
			if (phrase.getLabel().equals(SRLVar._R)) {
				phrase.setLabel(SRLVar._N);
			}
			//
			if (phrase.getLabel().equals(SRLVar._J)) {
				phrase.setLabel(SRLVar._N);
			}
		}
		//
		return phrases;
	}

	private static Phrase[] _2_reSetPhraseLabel(Phrase[] phrases) throws IOException {
		/**
		* */
		// update
		phrases = SRLTool._x_updatePhrasesPosesWithAllRules(phrases, 0);
		/**
		* */
		// V or P
		phrases = SRLTool._1_VorP_Rules(phrases);
		/**
		* */
		// update
		phrases = SRLTool._x_updatePhrasesPosesWithAllRules(phrases, 1);
		/**
		* */
		// VVs
		// phrases = Util._4_VVs(phrases, 1);
		/**
		* */
		// P1_PD
		phrases = SRLTool._2_P_Rules(phrases, 1);
		/**
		* */
		// update
		phrases = SRLTool._x_updatePhrasesPosesWithAllRules(phrases, 2);
		/**
		* */
		// P2_PD
		phrases = SRLTool._2_P_Rules(phrases, 2);
		/**
		* */
		// update
		phrases = SRLTool._x_updatePhrasesPosesWithAllRules(phrases, 2);
		/**
		* */
		// VNdeN
		// phrases = SRLTool._3_VNdeN_Rules(phrases);
		/**
		* */
		// update
		// phrases = SRLTool._x_updatePhrasesPosesWithAllRules(phrases, 3);
		/**
		 * Vs
		 */
		//
		// 固定搭配
		phrases = SRLTool._4_fix_x_V_x_End(phrases);
		//
		int counter = 0;
		for (int i = 0; i < phrases.length; i++) {
			if (phrases[i].getLabel().equals(SRLVar._V)) {
				counter++;
			}
		}

		//
		if (counter == 2) {
			// 通过4项打分，这四项都不是硬标准
			phrases = SRLTool._4_x_V_x_V_x_End(phrases);
			// v1+v1固定搭配+v2=v1+固定搭配+vz
			// v1+v2固定搭配+v2=vz+固定搭配+v2
			phrases = SRLTool._4_x_V_fix_V_x_End(phrases);
		}
		//
		/**
		* */
		// update
		phrases = SRLTool._x_updatePhrasesPosesWithAllRules(phrases, 4);
		//
		phrases = SRLTool._5_singleWord(phrases);
		//
		return phrases;
	}

	private static Phrase[] _3_reSetWordPosAndPhraseLabel(Phrase[] phrases) {
		// TODO Auto-generated method stub
		for (int i = 0; i < phrases.length; i++) {
			for (int j = 2; j < phrases.length; j++) {
				//
				Phrase p1 = phrases[j - 2];
				Phrase p2 = phrases[j - 1];
				Phrase p3 = phrases[j];
				//
				if (p1.getLabel().equals(SRLVar._V)
						//
						&& p2.getTerms().length == 1
						&& (p2.getTerms()[0].getPos().startsWith("v_") || p2.getTerms()[0].getPos().endsWith("_v")
								|| p2.getTerms()[0].getPos().contains("_v_"))
						//
						&& (p3.getLabel().equals(SRLVar._AV) || p3.getLabel().equals(SRLVar._ADV))) {
					phrases[j - 2].setLabel(SRLVar._N);
					phrases[j - 1].setLabel(SRLVar._N);
				}
			}
			for (int j = 1; j < phrases.length; j++) {
				//
				Phrase p1 = phrases[j - 1];
				Phrase p2 = phrases[j];
				//
				if (p1.getTerms().length == 1 && (p1.getTerms()[0].getPos().startsWith("v_")
						|| p1.getTerms()[0].getPos().endsWith("_v") || p1.getTerms()[0].getPos().contains("_v_"))
				//
						&& (p2.getLabel().equals(SRLVar._AV) || p2.getLabel().equals(SRLVar._ADV))) {
					phrases[j - 1].setLabel(SRLVar._N);
				}
			}
		}
		//
		return phrases;
	}

	public static String printPhrases(Phrase[] phrases) {
		String output = "";
		for (int i = 1; i < phrases.length - 1; i++) {
			Term[] terms = phrases[i].getTerms();
			for (int j = 0; j < terms.length; j++) {
				output = output + terms[j].getWord();
			}
			output = output + "/[" + phrases[i].getCoreTerm() + "]/" + phrases[i].getLabel() + " ";
		}
		//
		return output;
	}

}

package HUST.Standford;

import java.io.IOException;
import java.util.LinkedList;

import HUST.Chinese.Lexical.Analysis.System.ICTMain;
import HUST.Chinese.Lexical.Analysis.System.ICTTool;
import HUST.Chinese.Lexical.Analysis.System.Term;
import HUST.Semantic.Role.Labeling.Phrase;
import HUST.Semantic.Role.Labeling.SRLMain;
import HUST.Semantic.Role.Labeling.SRLVar;

public class StanMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String[] records = new String[] {
				//
				"腾讯御见威胁情报中心近日检测到该组织利用英国信息服务提供商IHS Markitwjz公司的邮箱账号向罗马尼亚外交部发送钓鱼邮件进行定向攻击。在攻击技术利用方面，该组织使用了最新的白利用技术，白利用程序为证书管理程序certutil.exe。此外，该组织还使用了最新的后门技术，利用UserInitMprLogonScript注册表键值来实现开机自启动。本次攻击中使用的木马为Carberp银行木马的变种，在隐藏网络行为及保护胜利果实方面做出了优化。此前，该组织也曾使用钓鱼邮件及Carberp变种木马对美国政府机构进行攻击。",
				//
				// "有图为证",
				//
				// "不能带食物.一下车就被服务震惊了，当时下大雨，店家居然举着一把大伞来接我们，很感动。点菜的时候老板娘也会推荐实惠的套餐。鱼头汤非常鲜美，感觉很新鲜，竹笋很嫩，但最惊艳的还是附赠的一盘小番茄，新鲜甘甜，超级好吃。我们一说好吃，老板娘又给洗了一盆让带走，超级棒！给开了温泉联系单，比我们住的本酒店的前台报价更便宜。有机会还要来?",
				//
				// "比较方便，学生票凭证件是可以半价的，这里说明没写，当天也不方便退票，我们一大帮子小孩都没享受到优惠。。。",
				//
				// "今天冒着酷署光临贵店，尝试的饭菜和服务水平，感觉菜品一般，与描述菜谱不太相符，小笋炒肉丝，肉丝一点也没有，时蔬就是凉拌黄瓜，服务环境还可以。",
				//
				// "吊桥有趣味",
				//
		};

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
					LinkedList<Term> list = new LinkedList<Term>();
					for (Term t : terms) {
						//
						if (t.getPos().equals("w")) {
							continue;
						}
						if (t.getPos().equals("wi")) {
							continue;
						}
						//
						list.addLast(t);
					}
					terms = list.toArray(new Term[0]);
					//
					String tokens = "";
					for (Term t : terms) {
						if (t.getPos().equals("start")) {
							continue;
						}
						if (t.getPos().equals("end")) {
							continue;
						}
						//
						tokens = tokens + t + " ";
					}
					tokens = tokens.trim();
					System.out.println(tokens);
					//
					Phrase[] phrases = SRLMain.run(terms);
					//
					System.out.println(SRLMain.printPhrases(phrases));
					//
					Segment[] segments = StanMain.run(phrases);
					//
					System.out.println(StanMain.output(segments));
					//
					System.out.println();
				}
			}

		}

		// Phrase[] phrases = SRLMain.run(input);
		// String result = StanMain.run(phrases);
		// System.out.print(input + "\r\n");
		// System.out.print(SRLMain.printPhrases(phrases) + "\r\n");
		// System.out.print(result);

	}

	public static Segment[] run(Phrase[] phrases) {
		//
		Segment[] segments = StanMain._1_phrases2segment(phrases);
		//
		segments = StanMain._2_SingleElement1(segments);
		//
		segments = StanMain._3_MergeSameNeighbor(segments);
		//
		// segments = StanMain._MergeWithRule(segments);
		//
		// segments = StanMain._3_MergeSameNeighbor(segments);
		//
		segments = StanMain._5_MutilElementWithRules(segments);
		//
		segments = StanMain._3_MergeSameNeighbor(segments);
		//
		// segments = StanMain._3_SingleElement2(segments);
		//
		// segments = StanMain._3_MergeSameNeighbor(segments);
		//
		segments = StanMain._5_MutilElementWithRules(segments);
		//
		segments = StanMain._3_MergeSameNeighbor(segments);
		//
		segments = StanMain._4_SubjectElement(segments);
		//
		segments = StanMain._5_MutilElementWithRules(segments);
		//
		segments = StanMain._3_MergeSameNeighbor(segments);
		//
		return segments;
	}

	private static Segment[] _3_MergeSameNeighbor(Segment[] segments) {
		//
		int counter = 0;
		//
		while (true) {
			//
			for (int i = 1; i < segments.length; i++) {
				//
				Segment seg1 = segments[i - 1];
				Segment seg2 = segments[i];
				if (seg1 == null || seg2 == null) {
					continue;
				}
				//
				String state1 = segments[i - 1].getState();
				String state2 = segments[i].getState();
				if (state1.length() == 0 || state2.length() == 0) {
					continue;
				}
				//
				// 相等，则合并
				if (state1.equals(state2)) {
					Phrase[] phrases = new Phrase[seg1.getPhrases().length + seg2.getPhrases().length];
					//
					for (int k = 0; k < seg1.getPhrases().length; k++) {
						phrases[k] = seg1.getPhrases()[k];
					}
					//
					for (int k = 0; k < seg2.getPhrases().length; k++) {
						phrases[k + seg1.getPhrases().length] = seg2.getPhrases()[k];
					}
					//
					segments[i - 1].setPhrases(phrases);
					segments[i] = null;
				}
			}
			//
			LinkedList<Segment> list = new LinkedList<Segment>();
			for (Segment seg : segments) {
				if (seg != null) {
					list.addLast(seg);
					//
				}

			}
			segments = list.toArray(new Segment[0]);
			//
			if (counter++ >= segments.length) {
				break;
			}
		}
		//

		return segments;
	}

	private static Segment[] _MergeWithRule(Segment[] segments) {
		//
		for (int i = 2; i < segments.length; i++) {
			if (segments[i - 2].getState().length() == 0
					//
					&& segments[i - 2].getPhrases()[segments[i - 2].getPhrases().length - 1].getLastTerm().getPos()
							.equals(SRLVar.verb)
					//
					&& segments[i - 1].getState().length() == 0
					//
					&& segments[i - 1].getPhrases().length == 1
					//
					&& segments[i - 1].getPhrases()[0].getLabel().equals(SRLVar._U1De)
					//
					&& (segments[i].getState().equals(StanRule._主谓语) || segments[i].getState().equals(StanRule._谓语))) {
				segments[i - 2].setState(StanRule._宾语);
				segments[i - 1].setState(StanRule._宾语);
			}
		}
		//
		return segments;
	}

	private static Segment[] _1_phrases2segment(Phrase[] phrases) {
		//
		LinkedList<Segment> list = new LinkedList<Segment>();
		//
		for (Phrase ph : phrases) {
			Phrase[] tmp = new Phrase[1];
			tmp[0] = ph;
			Segment seg = new Segment(tmp, "");
			list.add(seg);
		}
		//
		return list.toArray(new Segment[0]);
		//
	}

	private static Segment[] _2_SingleElement1(Segment[] segments) {
		/**
		 * 首先把能标注成分的都标注了
		 */
		//
		for (int i = 0; i < segments.length; i++) {
			//
			if (segments[i].getState().length() > 0) {
				continue;
			}
			// 冒号也可以是视为主谓语
			if (segments[i].getPhrases()[0].getTerms()[0].getWord().equals("：")) {
				segments[i].setState(StanRule._主谓语);
			}
			if (segments[i].getPhrases()[0].getTerms()[0].getWord().equals(":")) {
				segments[i].setState(StanRule._主谓语);
			}
			//
			String str = segments[i].getPhrases()[0].getLabel();
			//
			if (str.equals(SRLVar.START)) {
				segments[i].setState("开始");
			}
			if (str.equals(SRLVar.END)) {
				segments[i].setState("结束");
			}
			//
			if (str.equals(SRLVar._AV2B)) {
				segments[i].setState(StanRule._宾语);
			}
			//
			if (str.equals(SRLVar._ADV)) {
				segments[i].setState(StanRule._状语D);
			}
			if (str.equals(SRLVar._AV)) {
				segments[i].setState(StanRule._谓语);
			}
			if (str.equals(SRLVar._AVEnd)) {
				segments[i].setState(StanRule._谓语补语);
			}
			//
			if (str.equals(SRLVar._Ba)) {
				segments[i].setState(StanRule._动宾倒置);
			}
			//
			if (str.equals(SRLVar._Bei)) {
				segments[i].setState(StanRule._主宾倒置);
			}
			//
			if (str.equals(SRLVar._C)) {
				segments[i].setState(StanRule._连接词);
			}
			//
			if (str.equals(SRLVar._DV)) {
				segments[i].setState(StanRule._状语D);
			}
			if (str.equals(SRLVar._TG)) {
				segments[i].setState(StanRule._状语T);
			}
			if (str.equals(SRLVar._TL)) {
				segments[i].setState(StanRule._状语T);
			}
			if (str.equals(SRLVar._TDV)) {
				segments[i].setState(StanRule._状语T);
			}
			//
			if (str.equals(SRLVar._N_LCAnd_RCAnd)) {
				segments[i].setState(StanRule._宾语);
			}
			//
			if (str.equals(SRLVar._IV)) {
				segments[i].setState(StanRule._谓语);
			}
			//
			if (str.startsWith("RI")) {
				segments[i].setState(StanRule._疑问词);
			}
			//
			if (str.equals(SRLVar._V)) {
				if (segments[i].getPhrases().length == 1
						//
						&& segments[i].getPhrases()[0].getTerms().length == 1
						//
						&& StanRule.mainPrecicts
								.contains("/" + segments[i].getPhrases()[0].getTerms()[0].getWord() + "/")) {
					segments[i].setState(StanRule._主谓语);
				} else {
					segments[i].setState(StanRule._谓语);
				}
			}
			//
			if (str.equals(SRLVar._VEnd)) {
				segments[i].setState(StanRule._谓语补语);
			}
			//
			if (str.equals(SRLVar._VZ)) {
				segments[i].setState(StanRule._主谓语);
			}
			//
			if (str.equals(SRLVar._VJ)) {
				segments[i].setState(StanRule._谓语);
			}
			//
			if (str.equals(SRLVar._VJN)) {
				segments[i].setState(StanRule._宾语);
			}
			//
			if (str.equals(SRLVar._ZY)) {
				segments[i].setState(StanRule._状语);
			}
			//
		}
		//
		for (int i = 0; i < segments.length - 1; i++) {
			if (segments[i].getPhrases().length == 1
					//
					&& segments[i].getPhrases()[0].getTerms().length == 1
					//
					&& segments[i].getPhrases()[0].getLabel().equals(SRLVar._P)
					//
					&& segments[i + 1].getPhrases()[0].getLabel().equals(SRLVar._PD)) {
				segments[i].setState(StanRule._状语P);
				segments[i + 1].setState(StanRule._状语P);
			}
		}
		//
		if (segments[segments.length - 1].getPhrases().length == 1
				//
				&& segments[segments.length - 1].getPhrases()[0].getTerms().length == 1
				//
				&& segments[segments.length - 1].getPhrases()[0].getLabel().equals(SRLVar._WI)
				//
				&& segments[segments.length - 1].getState().length() == 0) {
			segments[segments.length - 1].setState(StanRule._符号);
		}
		//
		if (segments[segments.length - 2].getPhrases()[0].getLabel().equals(SRLVar._Y)) {
			segments[segments.length - 2].setState(StanRule._语气词);
		}
		//
		return segments;
		//
	}

	private static Segment[] _5_MutilElementWithRules(Segment[] segments) {

		/**
		 * rule
		 */
		for (int i = 0; i < segments.length; i++) {
			//
			for (int j = 0; j < StanRule.rules.length; j = j + 2) {
				//
				String[] rule1 = StanRule.rules[j];
				String[] rule2 = StanRule.rules[j + 1];
				if (rule2.length == 0) {
					rule2 = new String[rule1.length];
					for (int k = 0; k < rule2.length; k++) {
						rule2[k] = new String(StanRule._宾语);
					}
				}
				//
				if (rule1[0].equals(SRLVar.START)) {
					System.out.print("");
				}
				//
				// debug
				if (i == 1
						//
						&& rule1.length == 3
						//
						&& rule1[0].equals(SRLVar._N)
						//
						&& rule1[1].equals(SRLVar._AN)
						//
						&& rule1[2].equals(SRLVar._N)) {
					System.out.print("");
				}
				// end of debug
				//
				boolean isHere = true;
				//
				if (i + rule1.length > segments.length) {
					continue;
				}
				//
				for (int k = 0; k < rule1.length; k++) {
					//
					if (!rule1[k].equals(segments[i + k].getPhrases()[0].getLabel())) {
						isHere = false;
						break;
					}
					// 已有
					if (segments[i + k].getState().length() > 0 && !segments[i + k].getState().equals(StanRule.开始)) {
						isHere = false;
						break;
					}
				}
				//
				if (i > 1 && segments[i - 1].getState().length() == 0) {
					isHere = false;
				}
				if (i + rule2.length - 1 < segments.length - 1 && segments[i + rule2.length].getState().length() == 0) {
					isHere = false;
				}
				//
				if (isHere) {

					//
					for (int k = 0; k < rule2.length; k++) {
						segments[i + k].setState(rule2[k]);
					}
					//
					System.out.print("");
				}
				//
			}
		}
		/**
		 * regex_rule
		 */
		for (int i = 0; i < segments.length; i++) {
			//
			for (int j = 0; j < StanRule.regex_rules.length; j = j + 3) {
				//
				Object[] tmp1 = StanRule.regex_rules[j];
				String[] rule1 = new String[tmp1.length];
				for (int k = 0; k < rule1.length; k++) {
					rule1[k] = (String) tmp1[k];
				}
				//
				Object[] tmp2 = StanRule.regex_rules[j + 1];
				Integer[] rule2 = new Integer[tmp2.length];
				for (int k = 0; k < rule2.length; k++) {
					rule2[k] = (Integer) tmp2[k];
				}
				//
				Object[] tmp3 = StanRule.regex_rules[j + 2];
				String[] rule3 = new String[tmp3.length];
				for (int k = 0; k < rule3.length; k++) {
					rule3[k] = (String) tmp3[k];
				}
				//
				if (rule2[0] == -1 && rule2.length == 5) {
					System.out.print("");
				}
				//
				boolean isHere = true;
				//
				if (i + rule1.length > segments.length) {
					continue;
				}
				//
				if (segments[i].getState().length() == 0
						//
						|| segments[i + rule1.length - 1].getState().length() == 0) {
					continue;
				}
				//
				for (int k = 0; k < rule1.length; k++) {
					//
					if (rule2[k] != -1) {
						//
						if (!rule1[k].equals(segments[i + k].getPhrases()[0].getLabel())) {
							isHere = false;
							break;
						}
					} else {
						if (rule1[k].equals(segments[i + k].getPhrases()[0].getLabel())) {
							isHere = false;
							break;
						}
					}
				}
				//
				// for (int k = 0; k < rule2.length; k++) {
				// //
				// if (!rule2[k].equals(segments[i + k].getState())) {
				// isHere = false;
				// break;
				// }
				// }
				//
				if (isHere) {
					for (int k = 0; k < rule3.length; k++) {
						if (rule3[k].length() > 0) {
							segments[i + k].setState(rule3[k]);
						}
					}
					//
					System.out.print("");
				}
				//
			}
		}
		//
		return segments;

	}

	private static Segment[] _3_SingleElement2(Segment[] segments) {
		/**
		 * 首先把能标注成分的都标注了
		 */
		//
		for (int i = 0; i < segments.length; i++) {
			//
			String str = segments[i].getPhrases()[0].getLabel();
			//
			// if (str.equals(Var._C)) {
			// segments[i].setState(ParserRule._连接词);
			// }
			//
			if (str.equals(SRLVar._CAnd)) {
				segments[i].setState(StanRule._并列词);
			}

		}
		//
		return segments;
		//
	}

	private static Segment[] _4_SubjectElement(Segment[] segments) {
		/**
		 * 谓语之前的宾语变主语
		 */
		int firstWY = segments.length - 1;
		for (int i = 0; i < segments.length; i++) {
			if (segments[i].getState().contains(StanRule._谓语) || segments[i].getState().contains(StanRule._主谓语)) {
				firstWY = i;
				break;
			}
		}
		for (int i = 0; i < firstWY; i++) {
			if (segments[i].getState().equals(StanRule._宾语)) {
				segments[i].setState(StanRule._主语);
			}
			if (segments[i].getState().equals(StanRule._宾语1)) {
				segments[i].setState(StanRule._主语1);
			}
			if (segments[i].getState().equals(StanRule._宾语2)) {
				segments[i].setState(StanRule._主语2);
			}
		}
		/**
		 * 主谓语左右的状语补语都要表明是主谓语的
		 */
		for (int i = 1; i < segments.length; i++) {
			//
			// if (segments[i - 1].getState().equals(StanRule._状语) &&
			// segments[i].getState().contains(StanRule._主谓语)) {
			// segments[i - 1].setState((StanRule._主谓语 + StanRule._状语));
			// }
			// if (segments[i - 1].getState().equals(StanRule._状语D) &&
			// segments[i].getState().contains(StanRule._主谓语)) {
			// segments[i - 1].setState((StanRule._主谓语 + StanRule._状语D));
			// }
			// if (segments[i - 1].getState().equals(StanRule._状语P) &&
			// segments[i].getState().contains(StanRule._主谓语)) {
			// segments[i - 1].setState((StanRule._主谓语 + StanRule._状语P));
			// }
			// if (segments[i - 1].getState().equals(StanRule._状语T) &&
			// segments[i].getState().contains(StanRule._主谓语)) {
			// segments[i - 1].setState((StanRule._主谓语 + StanRule._状语T));
			// }
			//
			if (segments[i - 1].getState().contains(StanRule._主谓语) && segments[i].getState().equals(StanRule._谓语补语)) {
				segments[i].setState((StanRule._主谓语补语));
			}
		}
		/**
		 * 确定唯一主谓语
		 */
		int counterZWY = 0;

		for (int i = 1; i < segments.length; i++) {
			if (segments[i].getState().equals(StanRule._主谓语)) {
				counterZWY++;
			}
		}
		// 唯一主谓语之前部分都是主语
		if (counterZWY == 1) {
			int firstZWY = 0;
			for (int i = 1; i < segments.length; i++) {
				if (segments[i].getState().contains(StanRule._主谓语)) {
					firstZWY = i;
					break;
				}
			}
			//
			// 唯一主谓语之前有谓语，则之前部分都是主语。
			int firstWY_before_ZWY = 0;
			//
			for (int i = 0; i < firstZWY; i++) {
				if (segments[i].getState().equals(StanRule._谓语)) {
					firstWY_before_ZWY = i;
					break;
				}
			}
			//
			if (firstWY_before_ZWY > 0) {
				for (int i = 1; i < firstZWY; i++) {
					if (segments[i].getState().contains(StanRule._主谓语)) {
						continue;
					}
					if (segments[i].getState().length() == 0) {
						continue;
					}
					// segments[i].setState((StanRule._主语 +
					// segments[i].getState()));
				}
			}
			//////////
			// 唯一主谓语之后，以及下一个谓语之前部分都是主语。宾语主语。
			int firstWY_after_ZWY = 0;
			for (int i = firstZWY + 1; i < segments.length; i++) {
				if (segments[i].getState().equals(StanRule._谓语)) {
					firstWY_after_ZWY = i;
					break;
				}
			}
			//
			for (int i = firstZWY + 1; i < firstWY_after_ZWY; i++) {
				// if (segments[i].getState().equals(StanRule._宾语)) {
				// segments[i].setState(StanRule._主语);
				// }
				// if (segments[i].getState().equals(StanRule._宾语1)) {
				// segments[i].setState(StanRule._主语1);
				// }
				// if (segments[i].getState().equals(StanRule._宾语2)) {
				// segments[i].setState(StanRule._主语2);
				// }
			}
			//
			if (firstWY_after_ZWY > 0) {
				for (int i = firstZWY + 1; i < segments.length - 1; i++) {
					if (segments[i].getState().contains(StanRule._主谓语)) {
						continue;
					}
					if (segments[i].getState().length() == 0) {
						continue;
					}
					// segments[i].setState((StanRule._宾语 +
					// segments[i].getState()));
				}
			}
		}
		//
		return segments;
	}

	public static String output(Segment[] segments) {
		/**
		* */
		//
		String result = "";
		//
		for (int i = 0; i < segments.length; i++) {
			if (segments[i].getState().length() > 0) {
				result = result + segments[i].getState() + ":";
			} else {
				result = result + "未知成分:";
			}
			//
			for (Phrase ph : segments[i].getPhrases()) {
				for (Term term : ph.getTerms()) {
					result = result + term.getWord() + "/" + term.getPos() + ",";
				}
				result = result + ph.getLabel() + ",";
			}
			result = result + "\r\n";
		}
		result = result + "\r\n";
		//
		return result;
	}

}

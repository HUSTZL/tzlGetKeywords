package HUST.Chinese.Lexical.Analysis.System;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.LinkedList;

import HUST.Semantic.Role.Labeling.SRLVar;

public class ICTMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] records = new String[] {
				//
				// "据2019年1月18日商务部公共商务信息服务2019年1月17日发布的商务预报显示，猪肉价格持续回落，平均批发价格为每公斤20.92元，环比下降0.4%，同比下降3.6%。这场去年出现的疫情，如今也跟着大家一起跨年而来，继续影响着市场。"
				// ,

				"丁磊养了7年的味央猪开卖了!价格每斤49元左右 - 养猪..._中国养猪网	http://www.baidu.com/link?url=O-cQzr7KVBm2fnSIu0js4-jREUEaCqt4DSD9H3hvMUCz5WP-JbFHyH8qU2HtbMBrUhJN9dY21apzdIIKoem2KK	2016年12月15日 -	中国养猪网	2016年12月15日 - 3款猪肉定期配送服务,即3350元的全年至味配送、1950元的半年品味配送和...此次味央猪正式面市,距离2009年2月底丁磊在广东省“两会”上抛出爆炸性的...	中国养猪网 - 百度快照	https://cambrian-images.cdn.bcebos.com/02948bc7566866dbf4df4199cd9eaaa8_1562079189612544.jpeg@w_100,h_100	https://ss0.baidu.com/73F1bjeh1BF3odCf/it/u=3710438940,3137168031&fm=85&s=F53489730A16CE8A9FD0E9D6010050E0	中国养猪网",
				//
				"国军的精锐在楚云飞眼里却是五万头猪, 看74军历史才觉..._网易订阅	http://www.baidu.com/link?url=8cGxGTlDxJMJsycddePnYAB80JdGp9H5G5PXhNZVFbn2Tkcwar680wsiVLlw3BDGPZO2z12jo6IFFXdTTzyKUH74FQvbof335PT2WMhtuVK	2018年10月3日 -	网易新闻	2018年10月3日 - 国军的精锐在楚云飞眼里却是五万头猪, 看74军历史才觉得说得对 ...这就不得不说到74军的眼变暖历史了,它建立于1937年 9月,抗日战争时期更...	网易新闻 - 百度快照	https://cambrian-images.cdn.bcebos.com/fc7e536c0a625d413dcd7afd5f89643c_1577845684365623.jpeg@w_100,h_100	https://ss0.baidu.com/73F1bjeh1BF3odCf/it/u=194518734,945195854&fm=85&s=201054D94053A3D4101C8939030080C2	网易新闻",
				//
				" - 1979年对越自卫反击战结束后,越南领导人黎笋视察越北战区。视察时黎笋惊讶得半天...(十六)被杀死或抢走的猪:总数三十万五千头中的二十四万四千头被杀死或抢走,...	", };

		//
		for (String record : records) {
			// 将一条记录转为词项数组
			Term[] result = runRecord(record);
			//
			String tokens = "";
			for (Term t : result) {
				if (t.getPos().equals("start")) {
					continue;
				}
				if (t.getPos().equals("end")) {
					continue;
				}
				//
				tokens = tokens + t + " ";
			}
			//
			tokens = tokens.trim();
			System.out.println(tokens);
		}
	}

	public static String fenci(String str) {
		Term[] result = runRecord(str);
		//
		String tokens = "";
		for (Term t : result) {
			if (t.getPos().equals("start")) {
				continue;
			}
			if (t.getPos().equals("end")) {
				continue;
			}
			//
			tokens = tokens + t.getWord() + " ";
		}
		//
		tokens = tokens.trim();
		// System.out.println(tokens);
		return tokens;
	}

	public static Term[] runRecord(String record) {
		//
		LinkedList<Term> list = new LinkedList<Term>();
		// 一个句子最长1350个字符？

		// 将记录转为句子集合
		String[] sentences = ICTTool.record2Sentences(record);
		//
		for (String sentence : sentences) {
			// 将整句转分句
			String[] clauses = ICTTool.sentence2Clauses(sentence);
			//
			for (int step = 0; step < clauses.length; step++) {
				//
				String clause = clauses[step];
				// 对分句分词
				Term[] terms = runClause(clause);
				//
				for (Term term : terms) {
					list.addLast(term);
				}
			}
		}
		//
		return list.toArray(new Term[0]);
	}

	public static Term[] runClause(String clause) {

		// 正向分词
		String[] slips1 = _1_GetForwardSlips(clause);
		// 逆向分词
		String[] slips2 = _1_GetReverseSlips(clause);
		// 得到词性
		Term[] terms1 = _2_getGrammarTerms(slips1);
		Term[] terms2 = _2_getGrammarTerms(slips2);
		// 修订词性
		terms1 = _2_X2_resetPos(terms1);
		terms2 = _2_X2_resetPos(terms2);
		/**
		 * 在这里是否可以处理多词性？将一个terms转为多个terms，然后逐个评分
		 */
		LinkedList<Term[]> list1 = _3_oneClauseMultiPos_2_MultiClauseOnePos(terms1);
		LinkedList<Term[]> list2 = _3_oneClauseMultiPos_2_MultiClauseOnePos(terms2);
		LinkedList<Term[]> list = new LinkedList<Term[]>();
		for (Term[] terms : list1) {
			list.addLast(terms);
		}
		for (Term[] terms : list2) {
			list.addLast(terms);
		}
		Term[][] array = list.toArray(new Term[0][]);
		//
		int[] singleSlipScores = new int[array.length];
		int[] grammarSocres = new int[array.length];
		int[] baiduSocres = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			Term[] terms = array[i];
			// 针对实体进行处理，因为实体无法穷尽，需用一些规则来合并
			terms = _4_getEntityTerms(terms);
			// 词项合并，碎片合并为完整词项
			terms = _5_termMerger(terms);
			// 除一些特例外，单字应减分，也就是尽量避免出现单字
			singleSlipScores[i] = _6_GetSingleSlipScore(terms);
			// 不合理的词性组合，减分；合理的词性组合，加分
			grammarSocres[i] = _7_getGrammarScore(terms);
			// 根据词项在大规模语料库出现频率来计分
			baiduSocres[i] = _8_getbaiduScore(terms);
			//
			array[i] = terms;

		}
		// 最终计分结果
		Term[] result = _9_getFinalTerm(array, singleSlipScores, grammarSocres, baiduSocres);
		//
		return result;
	}

	private static Term[] _2_X2_resetPos(Term[] terms) {
		// 2
		for (int i = 0; i < terms.length - 1; i++) {
			Term t0 = terms[i];
			Term t1 = terms[i + 1];
			//
			String word0 = t0.getWord();
			String word1 = t1.getWord();
			//
			String pos0 = t0.getPos();
			String pos1 = t1.getPos();
			//
			if (pos0.equals("i") && pos1.equals("d")) {
				terms[i].setPos("d");
			}
			//
			if (pos0.equals("i") && pos1.equals("v")) {
				terms[i].setPos("d");
			}
			//
			if (pos0.equals("vn") && word1.equals("了")) {
				terms[i].setPos("v");
			}
		}
		//
		return terms;
	}

	private static String[] _1_GetForwardSlips(String clause) {
		LinkedList<String> result = new LinkedList<String>();
		//
		int max = 7;
		//
		String temp = new String(clause);
		//
		temp = temp.replaceAll("丨s丨b丨", "丨s丨b丨丨w丨j丨z丨");
		String[] slips = temp.split("丨w丨j丨z丨");
		for (String slip : slips) {
			//
			if (slip.endsWith("丨s丨b丨")) {
				result.addLast(slip.replaceAll("丨s丨b丨", ""));
				continue;
			}
			//
			while (slip.length() > 0) {
				for (int i = max; i > 0; i--) {
					//
					if (slip.length() < i) {
						continue;
					}
					//
					if (slip.substring(0, i).equals("AAAA级")) {
						System.out.print("");
					}
					//
					if (WordList.getBaiduNews().containsKey(slip.substring(0, i))
							//
							|| i == 1) {
						// System.out.print(tmp.substring(0, i) + "_");
						result.addLast(new String(slip.substring(0, i)));
						slip = slip.substring(i, slip.length());
						//
						break;
					}
				}
			}
		}

		//
		return result.toArray(new String[0]);
	}

	private static String[] _1_GetReverseSlips(String clause) {
		LinkedList<String> result = new LinkedList<String>();
		//
		int max = 7;
		//
		String temp = new String(clause);
		//
		temp = temp.replaceAll("丨s丨b丨", "丨s丨b丨丨w丨j丨z丨");
		String[] slips = temp.split("丨w丨j丨z丨");
		for (int counter = slips.length - 1; counter >= 0; counter--) {
			String slip = slips[counter];
			//
			if (slip.endsWith("丨s丨b丨")) {
				result.addFirst(slip.replaceAll("丨s丨b丨", ""));
				continue;
			}
			//
			while (slip.length() > 0) {
				for (int i = max; i > 0; i--) {
					//
					if (slip.length() < i) {
						continue;
					}
					//
					if (WordList.getBaiduNews().containsKey(slip.substring(slip.length() - i, slip.length()))
							//
							|| i == 1) {
						// System.out.print(tmp.substring(0, i) + "_");
						result.addFirst(new String(slip.substring(slip.length() - i, slip.length())));
						slip = slip.substring(0, slip.length() - i);
						//
						break;
					}
				}
			}
		}
		//
		return result.toArray(new String[0]);
	}

	private static Term[] _2_getGrammarTerms(String[] slips) {
		// 标注词性，包括数字词性
		Term[] terms = ICTMainDetails._2_1(slips);
		//
		terms = ICTMainDetails._2_2_addStartAndEnd(terms);
		// 词性重置
		terms = ICTMainDetails._2_3(terms);
		// 多词性消除歧义
		// terms = ICTMainDetails._2_4(terms);
		//
		return terms;
	}

	public static LinkedList<Term[]> _3_oneClauseMultiPos_2_MultiClauseOnePos(Term[] terms) {
		//
		LinkedList<Term[]> list = new LinkedList<Term[]>();
		// 计算出总共有多少种可能性
		int times = 1;
		for (Term term : terms) {
			if (term.getPos().contains("_")) {
				times = times * term.getPos().split("_").length;
			}
		}
		// 单纯复制times次？
		for (int i = 0; i < times; i++) {
			Term[] candidate = new Term[terms.length];
			for (int j = 0; j < terms.length; j++) {
				candidate[j] = new Term(terms[j].getWord(), terms[j].getPos());
			}
			list.addLast(candidate);
		}
		// 然后在特定位置，为其在多个词性候选中选定一个。并保证所有可能都在list中
		int counter = 1;
		for (int i = 0; i < terms.length; i++) {
			Term term = terms[i];
			String[] poses = term.getPos().split("_");
			if (poses.length == 1) {
				continue;
			}

			for (int j = 0; j < list.size(); j++) {

				list.get(j)[i].setPos(poses[j / counter % poses.length]);
			}
			counter = counter * poses.length;
		}
		//
		return list;
	}

	private static Term[] _4_getEntityTerms(Term[] terms) {
		// 小+nr1=nr2
		terms = ICTMainDetails._4_1(terms);
		// nr2+n1(!d)+v=nr3+v
		terms = ICTMainDetails._4_2(terms);
		//
		return terms;
	}

	private static Term[] _5_termMerger(Term[] terms) {
		// 书名号范围合并，《》
		terms = ICTMainDetails._5_1(terms);
		// 阿拉伯数字合并，11.11=11.11
		terms = ICTMainDetails._5_2(terms);
		// 好+单字n=n
		terms = ICTMainDetails._5_3(terms);
		// 单字v+过=v
		terms = ICTMainDetails._5_4(terms);
		// nz+nttc+no=no
		terms = ICTMainDetails._5_5(terms);
		// nz+no=no
		terms = ICTMainDetails._5_6(terms);
		// 英文合并，H+i=Hi
		terms = ICTMainDetails._5_7(terms);
		// !n+2n+1n+!n=!n+3n+!n
		// terms = ICTMainDetails._4_11(terms);
		// 日期时间的处理，12/m 月/n 29/m 日/n=12月29日/t
		terms = ICTMainDetails._5_8_时间合并(terms);
		//
		return terms;
	}

	private static int _6_GetSingleSlipScore(Term[] terms) {
		int score = 0;
		for (int i = 0; i < terms.length; i++) {
			Term term = terms[i];
			// 只计算单字
			if (term.getWord().length() != 1) {
				continue;
			}
			// 遇到这些词性或者词项以外的单字，减分
			if (term.getPos().equals(SRLVar.adjective)
					//
					|| term.getPos().equals(SRLVar.c)
					//
					|| term.getPos().equals(SRLVar.cand)
					//
					|| term.getPos().equals(SRLVar.fang_wei)
					/**
					 * */
					// be
					|| term.getWord().equals("是")
					// d
					|| term.getWord().equals("也")
					//
					|| term.getWord().equals("很")
					// f
					|| term.getWord().equals("上")
					// p
					|| term.getWord().equals("被")
					// u
					|| term.getWord().equals("的")
					// v
					|| term.getWord().equals("不")
					//
					|| term.getWord().equals("没")
					//
					|| term.getWord().equals("有")
					//
					|| term.getWord().equals("会")) {
				continue;
			} else {
				score = score - 1;
			}
			// 单字动词，减分
			if (term.getPos().equals(SRLVar.verb)) {
				score = score - 1;
			}
		}
		return score;
	}

	private static int _7_getGrammarScore(Term[] terms) {
		// TODO Auto-generated method stub
		int score = 0;
		//
		for (int i = 1; i < terms.length; i++) {
			//
			Term t1 = terms[i - 1];
			Term t2 = terms[i];
			// d+n不合理
			if (t1.getPos().equals(SRLVar.adverb) && t2.getPos().equals(SRLVar.noun)) {
				score = score - 1;
			}
		}
		//
		String yesRule1 = "_aj_an_da_dd_dv_mq_";
		yesRule1 = "";
		String yesRule3 = "_a的_";
		// 朋友/nrgx 特别/d 喜欢/v 这/r 道/v_n 菜/n ，/w 全部/m 吃/v 完/v 了/u
		// 老板/nrsf 人/n 特别/d 好/a ，/w 帮/q_v 我们/r 忙前忙后/v 的/u
		String noRule1 = "_dn_dncs_drir_qr_dr_";
		String noRule2 = "_之vg_";
		//
		for (int j = 1; j < terms.length; j++) {
			//
			Term t1 = terms[j - 1];
			Term t2 = terms[j];
			//
			if (yesRule1.contains("_" + t1.getPos() + t2.getPos() + "_")) {
				score = score + 1;
			}
			if (noRule1.contains("_" + t1.getPos() + t2.getPos() + "_")) {
				score = score - 1;
			}
		}
		//
		return score;
	}

	private static int _8_getbaiduScore(Term[] terms) {
		int score = 0;
		for (int i = 0; i < terms.length; i++) {
			if (WordList.getBaiduNews().containsKey(terms[i].getWord())) {
				int tmp = WordList.getBaiduNews().get(terms[i].getWord());
				score = score + tmp;
			}

		}
		return score;
	}

	private static Term[] _9_getFinalTerm(Term[][] array, int[] singleSlipScores, int[] grammarSocres,
			int[] baiduSocres) {
		// 先计算百度分数，将高分值的放在前面
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (baiduSocres[i] < baiduSocres[j]) {
					//
					int tmp_baidu = baiduSocres[i];
					baiduSocres[i] = baiduSocres[j];
					baiduSocres[j] = tmp_baidu;
					//
					int tmp_single = singleSlipScores[i];
					singleSlipScores[i] = singleSlipScores[j];
					singleSlipScores[j] = tmp_single;
					//
					int tmp_grammer = grammarSocres[i];
					grammarSocres[i] = grammarSocres[j];
					grammarSocres[j] = tmp_grammer;
					//
					Term[] tmp_terms = array[i];
					array[i] = array[j];
					array[j] = tmp_terms;
				}
			}
		}
		// 再计算singleSlipScores+grammarScores分值，将高分值的放在前面
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (singleSlipScores[i] + grammarSocres[i] < singleSlipScores[j] + grammarSocres[j]) {
					//
					int tmp_baidu = baiduSocres[i];
					baiduSocres[i] = baiduSocres[j];
					baiduSocres[j] = tmp_baidu;
					//
					int tmp_single = singleSlipScores[i];
					singleSlipScores[i] = singleSlipScores[j];
					singleSlipScores[j] = tmp_single;
					//
					int tmp_grammer = grammarSocres[i];
					grammarSocres[i] = grammarSocres[j];
					grammarSocres[j] = tmp_grammer;
					//
					Term[] tmp_terms = array[i];
					array[i] = array[j];
					array[j] = tmp_terms;
					//
				}
			}
		}
		//
		return array[0];
	}
}

class WordList {
	private static Hashtable<String, Integer> baiduNews = new Hashtable<String, Integer>();

	private static Hashtable<String, String> poses = new Hashtable<String, String>();

	private static Hashtable<String, String> surnames = new Hashtable<String, String>();

	private static void init() {
		try {
			init1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void init1() throws IOException {
		//
		if (baiduNews.size() != 0 && poses.size() != 0) {
			return;
		}
		/**
		 * 词组的百度新闻次数及词性
		 */
		/**
		 * 名人名
		 */
		/**
		 * 专有名
		 */
		String[] dics = { "D:\\计算机资源\\词库\\BigDic.dic", "D:\\计算机资源\\词库\\名人名.dic", "D:\\计算机资源\\词库\\专有名.dic" };
		for (String dic : dics) {
			FileInputStream fis = new FileInputStream(dic);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				//
				if (line.contains("#")) {
					continue;
				}
				if (line.length() < 5) {
					// continue;
				}
				String[] slips = line.split("\t");
				//
				if (dic.contains("BigDic") && slips[2].endsWith("nr")) {
					continue;
				}
				//
				baiduNews.put(slips[0], Integer.parseInt(slips[1]));
				//
				poses.put(slips[0], slips[2]);
			}
			br.close();
			isr.close();
			fis.close();
		}

		/**
		 * 未收录词组的词性
		 */
		FileInputStream fis = new FileInputStream("D:\\计算机资源\\词库\\未收录词组.dic");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			//
			if (line.contains("#")) {
				continue;
			}
			if (line.length() < 3) {
				continue;
			}
			String[] slips = line.split("丨");
			//
			baiduNews.put(slips[0], 0);
			//
			poses.put(slips[0], slips[1]);
		}
		//
		br.close();
		isr.close();
		fis.close();
		/**
		 * 单字词性
		 */
		fis = new FileInputStream("D:\\计算机资源\\词库\\dic1.dic");
		isr = new InputStreamReader(fis, "UTF-8");
		br = new BufferedReader(isr);
		line = null;
		while ((line = br.readLine()) != null) {
			//
			if (line.contains("#")) {
				continue;
			}
			String[] slips = line.split(",");
			poses.put(slips[0], slips[1]);
		}
		br.close();
		isr.close();
		fis.close();

		/**
		 * */
		String[] symbols_wi = ICTTool.symbols_wi;
		//
		String[] symbols_w = ICTTool.symbols_comma.split("_");
		//
		String[] symbols_wbk = ICTTool.symbols_wbk;
		//
		for (int i = 0; i < symbols_wi.length; i++) {
			String symbol = symbols_wi[i];
			poses.put(symbol, SRLVar.wi);
		}
		for (int i = 0; i < symbols_w.length; i++) {
			String symbol = symbols_w[i];
			poses.put(symbol, SRLVar.w);
		}
		for (int i = 0; i < symbols_wbk.length; i++) {
			String symbol = symbols_wbk[i];
			poses.put(symbol, "wbk");
		}
		/**
		 * 百家姓
		 */
		fis = new FileInputStream("D:\\计算机资源\\词库\\bjx.dic");
		isr = new InputStreamReader(fis, "UTF-8");
		br = new BufferedReader(isr);
		line = null;
		while ((line = br.readLine()) != null) {
			//
			if (line.contains("#")) {
				continue;
			}
			surnames.put(line, line);
		}
		br.close();
		isr.close();
		fis.close();

	}

	public static Hashtable<String, Integer> getBaiduNews() {
		if (baiduNews.size() == 0) {
			init();
		}
		return baiduNews;
	}

	public static void setBaiduNews(Hashtable<String, Integer> baiduNews) {
		WordList.baiduNews = baiduNews;
	}

	public static Hashtable<String, String> getPoses() {
		if (poses.size() == 0) {
			init();
		}
		return poses;
	}

	public static void setPoses(Hashtable<String, String> poses) {
		WordList.poses = poses;
	}

	public static Hashtable<String, String> getSurnames() {
		if (surnames.size() == 0) {
			init();
		}
		return surnames;
	}

	public static void setSurnames(Hashtable<String, String> surnames) {
		WordList.surnames = surnames;
	}
}
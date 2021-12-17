package HUST.Chinese.Lexical.Analysis.System;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ICTTool {

	public static String[] symbols_wi = {
			//
			"!", "?",
			//
			"！", "？", "。", };
	public static String symbols_full_stop = "_!_！_?_？_。_";
	public static String symbols_comma =

			//
			"_…_._ _\"_*_" +
			//
					"“_”_" +
					// 英文符号
					"+_\"_~_(_)_[_]_-_:_;_,_" +
					// 中文符号
					"，_、_～_（_）_【_】_—_：_；_";

	public static String[] symbols_wbk = {
			//
			"《", "》", };

	public static int max_ClauseLen = 128;

	public static String[] record2Sentences(String record) {
		/**
		 * 先识别IP、Host、MD5
		 */
		LinkedList<String> IP_Host_MD5 = new LinkedList<String>();
		// IP
		String IPRegEx = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
		Pattern p = Pattern.compile(IPRegEx);
		Matcher m = p.matcher(record);
		while (m.find()) {
			String result = m.group();
			IP_Host_MD5.addLast(result);

		}
		// Host
		String HostRegEx = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
				+ "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";
		p = Pattern.compile(HostRegEx, Pattern.CASE_INSENSITIVE);
		m = p.matcher(record);
		while (m.find()) {
			String result = m.group();
			IP_Host_MD5.addLast(result);
		}
		// MD5
		String MD5RegEx = "[a-fA-F0-9]{32,32}";
		p = Pattern.compile(MD5RegEx, Pattern.CASE_INSENSITIVE);
		m = p.matcher(record);
		while (m.find()) {
			String result = m.group();
			IP_Host_MD5.addLast(result);
		}
		//
		for (String info : IP_Host_MD5) {

			try {
				record = record.replaceAll(info, "丨w丨j丨z丨" + info + "丨s丨b丨");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}

		}
		/**
		 * 按照句子边界标点，切分句子
		 */
		LinkedList<String> list = new LinkedList<String>();
		String current = "";
		String symbols = ICTTool.symbols_full_stop;
		//
		for (int i = 0; i < record.length(); i++) {
			char c = record.charAt(i);
			//
			current = current + c;
			//
			if (symbols.contains("_" + c + "_")) {
				list.addLast(current);
				current = "";
			}
		}
		list.addLast(current);
		//
		String[] result = list.toArray(new String[0]);
		list.clear();
		for (String str : result) {
			if (str.length() > 0) {
				list.addLast(str);
			}
		}
		//
		result = list.toArray(new String[0]);
		//
		return result;
	}

	public static String[] sentence2Clauses(String sentence) {
		//
		LinkedList<String> clause_list = new LinkedList<String>();
		//
		String current = "";
		String symbols = ICTTool.symbols_comma + "_" + ICTTool.symbols_full_stop;
		//
		for (int i = 0; i < sentence.length(); i++) {
			char c0 = sentence.charAt(i);
			char c1 = (i + 1) < sentence.length() ? sentence.charAt(i + 1) : '\0';
			//
			current = current + c0;
			//
			if (current.contains("丨w丨j丨z丨") && !current.contains("丨s丨b丨")) {
				continue;
			}
			//
			if (symbols.contains("_" + c0 + "_")) {
				char c = current.length() >= 2 ? current.charAt(current.length() - 2) : '\0';
				// ？？？
				// 小数/IP
				if (c != '\0' && Character.isDigit(c) && c0 == '.' && c1 != '\0' && Character.isDigit(c1)) {
					continue;
				}
				// 英文单词
				if (c != '\0' && ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) && c0 == ' ' && c1 != '\0'
						&& ((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z'))) {
					continue;
				}
				// 域名
				if (c != '\0' && ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) && c0 == '.' && c1 != '\0'
						&& ((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z'))) {
					continue;
				}
				clause_list.addLast(current);
				current = "";
			}
		}
		//
		clause_list.addLast(current);
		//
		LinkedList<String> list = new LinkedList<String>();
		// 如果分句过长，则人为截断
		for (String clause : clause_list) {
			if (clause.length() < 1) {
				continue;
			}
			if (clause.length() <= max_ClauseLen) {
				list.addLast(clause);
			} else {
				for (int i = 0; i < clause.length() / max_ClauseLen; i = i + 1) {
					list.addLast(clause.substring(i * max_ClauseLen, i * max_ClauseLen + max_ClauseLen));
				}
				list.addLast(clause.substring(clause.length() / max_ClauseLen * max_ClauseLen));
				//
			}
		}
		//
		String[] result = list.toArray(new String[0]);
		//
		return result;
	}

}

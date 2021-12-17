package HUST.Semantic.Role.Labeling;

public class SRLRule {

	public static String mainPrecicts =
			// b
			"/不是/表示/帮助/比如/包含/包括"
					// c
					+ "/成为/存在/承蒙/承认"
					// d
					+ "/担心"
					// f
					+ "/发现/克服"
					// g
					+ "/感觉/告诉"
					// h
					+ "/获/获得/获取/会"
					// j
					+ "/具有/进行/觉得/相信/接受/决定/就是/均获/进入"
					// k
					+ "/开始/看见/看到/考虑/看起来/可/看/恳求"
					// l
					+ "/利用"
					// m
					+ "/没//没有/面临"
					// n
					+ "/能想到/能"
					// p
					+ "/判"
					// q
					+ "/请教/请/确认/确保"
					// r
					+ "/认为/认识到"
					// s
					+ "/是/是不是/说/煞是/使得/实为/申请"
					// t
					+ "/听到/提醒/听候/停止"
					// x
					+ "/希望/喜欢/想要/宣布/想/想到/宣称/需要"
					// y
					+ "/有/有着/意味着/以为/要求/有/迎来/允诺/引/扬言/要"
					// z
					+ "/做出/知道/找出/指控/证明/致使/在于/作为/致/准备"
					//
					+ "/";

	public static String[][] TermPos2PhraseLabel_Rules = {
			//
			{ SRLVar.adjective, SRLVar._A },
			//
			{ SRLVar.ad, SRLVar._AD },
			//
			{ SRLVar.ag, SRLVar._AG },
			//
			{ SRLVar.an, SRLVar._AN },
			//
			{ SRLVar.b, SRLVar._B },
			//
			{ SRLVar.b_vn, SRLVar._B },
			//
			{ SRLVar.c, SRLVar._C },
			//
			{ SRLVar.cand, SRLVar._CAnd },
			//
			{ SRLVar.adverb, SRLVar._D },
			//
			{ SRLVar.e, SRLVar._E },
			//
			{ SRLVar.en, SRLVar._N },
			//
			{ SRLVar.fang_wei, SRLVar._F },
			//
			{ SRLVar.f_v, SRLVar._F_V },
			//
			{ SRLVar.h, SRLVar._H },
			//
			{ SRLVar.i, SRLVar._I },
			//
			{ SRLVar.j, SRLVar._J },
			//
			{ SRLVar.k, SRLVar._K },
			//
			{ SRLVar.m, SRLVar._M },
			//
			{ SRLVar.mq, SRLVar._MQ },
			//
			{ SRLVar.vn, SRLVar._N },
			//
			{ SRLVar.p, SRLVar._P },
			//
			{ SRLVar.quantifier, SRLVar._Q },
			//
			{ SRLVar.qn, SRLVar._QN },
			//
			{ SRLVar.pronoun, SRLVar._R },
			//
			{ SRLVar.ri, SRLVar._RI },
			//
			{ SRLVar.ria, SRLVar._RIA },
			//
			{ SRLVar.ric, SRLVar._RIC },
			//
			{ SRLVar.rid, SRLVar._RID },
			//
			{ SRLVar.rir, SRLVar._RIR },
			//
			{ SRLVar.s, SRLVar._S },
			//
			{ SRLVar.t, SRLVar._T },
			//
			{ SRLVar.tg, SRLVar._TG },
			//
			{ SRLVar.tl, SRLVar._TL },
			//
			{ SRLVar.u, SRLVar._U },
			//
			{ SRLVar.u1de, SRLVar._U1De },
			//
			{ SRLVar.u2de, SRLVar._U2De },
			//
			{ SRLVar.u3de, SRLVar._U3De },
			//
			{ SRLVar.verb, SRLVar._V },
			//
			{ SRLVar.vmax, SRLVar._VMax },
			//
			{ SRLVar.wi, SRLVar._WI },
			//
			{ SRLVar.x, SRLVar._X },
			//
			{ SRLVar.y, SRLVar._Y },
			//
			{ SRLVar.z, SRLVar._Z },
			/**
			 * */
			{ SRLVar.bei, SRLVar._Bei },
			//
			{ SRLVar.ba, SRLVar._Ba },
			//
			{ SRLVar.jiang, SRLVar._Jiang },
			/**
			 * */
			//
			{ "start", SRLVar.START, },
			//
			{ "end", SRLVar.END, },
			//
	};

	public static String[][] _0_1__Phrase_2in1_Rules = {
			//
			{ SRLVar._A, SRLVar._A, SRLVar._A },
			//
			{ SRLVar._A, SRLVar._U2De, SRLVar._D },
			//
			{ SRLVar._AN, SRLVar._AN, SRLVar._AN },
			//
			{ SRLVar._AG, SRLVar._AG, SRLVar._AG },
			//
			{ SRLVar._B, SRLVar._U1De, SRLVar._A },
			//
			{ SRLVar._D, SRLVar._U1De, SRLVar._D },
			//
			{ SRLVar._D, SRLVar._U2De, SRLVar._D },
			//
			{ SRLVar._F, SRLVar._F, SRLVar._F },
			//
			{ SRLVar._I, SRLVar._U1De, SRLVar._AU1De },
			//
			{ SRLVar._I, SRLVar._U2De, SRLVar._D },
			//
			{ SRLVar._M, SRLVar._Q, SRLVar._MQ },
			//
			{ SRLVar._M, SRLVar._QN, SRLVar._MQN },
			//
			{ SRLVar._MQ, SRLVar._MQ, SRLVar._MQ },
			//
			{ SRLVar._N, SRLVar._N, SRLVar._N },
			//
			{ SRLVar._NE, SRLVar._NE, SRLVar._NE },
			//
			{ SRLVar._NE, SRLVar._N, SRLVar._N },
			//
			{ SRLVar._PD, SRLVar._F, SRLVar._PD },
			//
			{ SRLVar._PD, SRLVar._PD, SRLVar._PD },
			//
			{ SRLVar._R, SRLVar._Q, SRLVar._RQ },
			//
			{ SRLVar._T, SRLVar._T, SRLVar._T },
			//
			{ SRLVar._T, SRLVar._U1De, SRLVar._A },
			//
			// 主政/n 财政厅/nttc 9年/tl 的/u “财神爷”/n 落马/v
			// ×
			// 已经/DV 离去/V 100多年的/A 他/R
			// { Var._TL, Var._U1De, Var._A },
			//
			// 对于/p 要/v 上班/v 要/v 送娃/v 上学/v 的/u 家长/n 略/d 辛苦/a
			{ SRLVar._V, SRLVar._VG, SRLVar._V },
			//
			{ SRLVar._Z, SRLVar._U1De, SRLVar._A },
			//
			{ SRLVar._ZY, SRLVar._ZY, SRLVar._ZY },
			//
			// 他/r 在/p 曼联/nz 真/d_n 的/u 不可或缺/n
			{ SRLVar._d_n, SRLVar._U1De, SRLVar._A },
			//
	};

	public static String[][] _0_1_common_Regex_Rules = {
			/**
			 * A
			 */
			// 他/r 已经/d 好/a 了/u
			// 他/R 已经/ADV 好/AV 了/AVEnd
			{ SRLVar._A, "/了/点/",
					//
					SRLVar._AV, SRLVar._AVEnd,
					//
					SRLVar._0与词性相等, SRLVar._0与词汇相等,
					//
					SRLVar._1改词性, SRLVar._1改词性, },
			/**
			 * C
			 */
			//
			// 无/V 可疑/A 之/U 处/N
			// !Cand+A+U1De+N=!A+N+N+N
			// { SRLVar._CAnd, SRLVar._A, SRLVar._U1De, SRLVar._N,
			// //
			// "", SRLVar._N, SRLVar._N, "",
			// //
			// SRLVar._0与词性不等, SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词性相等,
			// //
			// SRLVar._1不变, SRLVar._1改词性, SRLVar._1改词性, SRLVar._1不变, },

			/**
			 * J
			 */
			//
			// 北航/N 今年/T 将/Ba 把/Ba 区块链/N 纳入/V 本科生/N 培养/V 计划/N
			//
			{ "/将/", SRLVar._Ba,
					//
					SRLVar._DV, SRLVar._Ba,
					//
					SRLVar._0与词汇相等, SRLVar._0与词性相等,
					//
					SRLVar._1改词性, SRLVar._1不变, },
			//
			// 机动车/N 不/DV 礼让/V 将/Ba 被/Bei 曝光/V
			{ "/将/", SRLVar._Bei, SRLVar._V,
					//
					SRLVar._DV, SRLVar._Bei, SRLVar._V,
					//
					SRLVar._0与词汇相等, SRLVar._0与词性相等, SRLVar._0与词性相等,
					//
					SRLVar._1改词性, SRLVar._1不变, SRLVar._1不变, },
			//
			// 将/Ba 专门/DV 考核/V 银行小微企业/N 贷款/V 利率/N
			{ "/将/", SRLVar._DV,
					//
					SRLVar._DV, SRLVar._DV,
					//
					SRLVar._0与词汇相等, SRLVar._0与词性相等,
					//
					SRLVar._1改词性, SRLVar._1不变, },
			//
			// 韩国共同民主党议员/N 将/Ba 在/P 韩国/PD 提议/V 《区块链产业振兴基本法》/N 以/P
			// 监管/PD
			{ "/将/", SRLVar._P, SRLVar._PD, SRLVar._V,
					//
					SRLVar._DV, SRLVar._P, SRLVar._PD, SRLVar._V,
					//
					SRLVar._0与词汇相等, SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词性相等,
					//
					SRLVar._1改词性, SRLVar._1不变, SRLVar._1不变, SRLVar._1不变, },
			//
			//
			{ "/将/", SRLVar._V,
					//
					SRLVar._DV, SRLVar._V,
					//
					SRLVar._0与词汇相等, SRLVar._0与词性相等,
					//
					SRLVar._1改词性, SRLVar._1不变, },
			/**
			 * N
			 */
			//
			// N+/或/兼/与/和/与/及/以及/同/+N = N+N+N
			{ SRLVar._N, "/或/兼/与/和/与/同/", SRLVar._N,
					//
					"", SRLVar._CAnd, "",
					//
					SRLVar._0与词性相等, SRLVar._0与词汇相等, SRLVar._0与词性相等,
					//
					SRLVar._1不变, SRLVar._1改词性, SRLVar._1不变, },
			/**
			 * S
			 */
			//
			// 与/CAnd 丈夫/N 争吵/TDV 后/TDV 跑到/V 公园/N 寻短见/V
			{ SRLVar.START, SRLVar._CAnd, SRLVar._N, SRLVar._V, "/后/",
					//
					SRLVar.START, SRLVar._P, SRLVar._PD, SRLVar._PD, SRLVar._PD,
					//
					SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词汇相等,
					//
					SRLVar._1不变, SRLVar._1改词性, SRLVar._1改词性, SRLVar._1改词性, SRLVar._1改词性, },
			//
			// 起床/v 后/f 经常/d 做/v 3/m 件/q 事/n
			{ SRLVar.START, SRLVar._V, "/后/", SRLVar._DV,
					//
					SRLVar.START, SRLVar._P, SRLVar._PD, SRLVar._DV,
					//
					SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词汇相等, SRLVar._0与词性相等,
					//
					SRLVar._1不变, SRLVar._1改词性, SRLVar._1改词性, SRLVar._1不变, },
			//
			// 起床/V 后/F 的/U1De 第一件事/N
			{ SRLVar.START, SRLVar._V, "/后/", SRLVar._U1De,
					//
					SRLVar.START, SRLVar._N, SRLVar._N, SRLVar._U1De,
					//
					SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词汇相等, SRLVar._0与词性相等,
					//
					SRLVar._1不变, SRLVar._1改词性, SRLVar._1改词性, SRLVar._1不变, },
			/**
			 * V
			 */

			//
			// VEnd+了=VEnd+VEnd
			{ SRLVar._VEnd, "/了/",
					//
					"", SRLVar._VEnd,
					//
					SRLVar._0与词性相等, SRLVar._0与词汇相等,
					//
					SRLVar._1不变, SRLVar._1改词性, },
			//
			// V+不+了 = V+VEnd+VEnd
			{ SRLVar._N, "/不/", "/了/",
					//
					"", SRLVar._VEnd, SRLVar._VEnd,
					//
					SRLVar._0与词性相等, SRLVar._0与词汇相等, SRLVar._0与词汇相等,
					//
					SRLVar._1不变, SRLVar._1改词性, SRLVar._1改词性, },
			//
			//
			// { Var._V, Var._F, Var.END,
			// //
			// Var._V, Var._VEnd, Var.END,
			// //
			// Var._0与词性相等, Var._0与词性相等, Var._0与词性相等,
			// //
			// Var._1不变, Var._1改词性, Var._1不变, },
			//

			//
	};

	public static String[][] _0_2_common__Rules = {
			/**
			 * A
			 */

			//
			// 矫情/A 又/ADV 做作/AV
			{ SRLVar._A, SRLVar._ADV, SRLVar._AV, SRLVar.END,
					//
					SRLVar._AV, "", "", "", },
			//
			{ SRLVar._A, SRLVar._CAnd, var2s(new String[] { SRLVar._ADV, SRLVar._AV, }),
					//
					SRLVar._AV, "", "", },
			//
			{ SRLVar._A, SRLVar._D, SRLVar.END,
					//
					SRLVar._AV, SRLVar._AVEnd, "", },
			//
			// 风景/N 不错/A 哦/E
			{ SRLVar._A, SRLVar._E, SRLVar.END,
					//
					SRLVar._AV, "", "", },
			//
			{ SRLVar._A, SRLVar._N,
					//
					SRLVar._AN, SRLVar._N },
			//
			// 人/N 多/A 的/U1De 很/D
			{ SRLVar._A, SRLVar._U1De, SRLVar._D, SRLVar.END,
					//
					SRLVar._AV, SRLVar._AVEnd, SRLVar._AVEnd, "", },
			//
			// 导游/N 蛮/D 好/A 的/U1De
			{ SRLVar._A, SRLVar._U1De, SRLVar.END,
					//
					SRLVar._AV, "", "", },
			//
			{ SRLVar._A, SRLVar._U1De, SRLVar._N,
					//
					SRLVar._AN, "", "", },
			//
			// 住/v 安乡县深柳镇/ns 紫/a 珑/x 小区/n 茉莉/n 轩/n 5-B/en
			// 住/V 安乡县深柳镇/NE 紫/AN 珑小区茉莉轩5-B/N
			{ SRLVar._A, SRLVar._X, SRLVar._N,
					//
					"", SRLVar._N, "", },
			//
			{ SRLVar._A, SRLVar._Y, SRLVar.END,
					//
					SRLVar._AV, "", "", },
			//
			{ SRLVar._A, var2s(new String[] { SRLVar._AV, SRLVar.END, }),
					//
					SRLVar._AV, "", },
			//
			{ SRLVar._A, var2s(new String[] { SRLVar._V, SRLVar._VZ, }),
					//
					SRLVar._DV, "", },
			/**
			 * AD
			 */
			//
			// 央行/nt 连续/ad 6日/tl 净/d 回笼/v 资金/n
			// 央行/NE 连续/ADV 6日/TDV 净/DV 回笼/V 资金/N
			{ SRLVar._AD, SRLVar._TL, SRLVar._DV,
					//
					SRLVar._ADV, SRLVar._TDV, "", },
			/**
			 * B
			 */
			//
			{ SRLVar._B, SRLVar._AV,
					//
					SRLVar._ADV, "", },
			//
			// 最/DV 被/Bei 高估/AN 的/U1De 四位球员/N
			{ SRLVar._Bei, SRLVar._V, SRLVar._U1De, SRLVar._N, SRLVar.END,
					//
					SRLVar._AN, SRLVar._AN, "", "", "", },
			/**
			 * C
			 */
			//
			// 为/P 保证UTM防火墙/PD 升级/V 服务/V 和/CAnd 中间/F 库服务器售后服务/N
			{ SRLVar._CAnd, SRLVar._F, SRLVar._N,
					//
					"", SRLVar._AN, "", },
			/**
			 * D
			 */
			//
			{ SRLVar._D, SRLVar._AN,
					//
					SRLVar._DN, "", },
			//
			{ SRLVar._D, var2s(new String[] { SRLVar._Bei, SRLVar._P, }),
					//
					SRLVar._DV, "", },
			//
			// 最/DV 被/Bei 高估/AN 的/U1De 四位球员/N
			{ SRLVar._D, SRLVar._VZ,
					//
					SRLVar._DV, "", },
			//
			// 他/r 已经/d 好/a 了/u
			// 他/R 已经/ADV 好/AV 了/AVEnd
			{ SRLVar._D, var2s(new String[] { SRLVar._ADV, SRLVar._AV, }),
					//
					SRLVar._ADV, "", },
			/**
			 * I
			 */
			//
			// 《鸡毛飞上天》张恪维/N 致/VZ 殷桃/N 家破人亡/I 引/V 网友/N 申讨/V
			{ SRLVar._I, var2s(new String[] { SRLVar.END, SRLVar._VZ, }),
					//
					SRLVar._IV, "", },
			/**
			 * J
			 */
			//
			{ SRLVar._Jiang, SRLVar._N,
					//
					SRLVar._P, "", },
			/**
			 * M
			 */
			// 民船/n 整/m 建制/n 跨海/vn 投送/v
			// ?
			// { Var._M, Var._N, Var._N, Var._N },

			//
			{ SRLVar._MQ, SRLVar._U1De, SRLVar._N,
					//
					SRLVar._N, "", "", },
			/**
			 * N
			 */
			//
			// 名称/N, 、/CAnd, 说明/V, 、/CAnd, 文件夹/N, 、/CAnd
			{ SRLVar._N, SRLVar._CAnd, SRLVar._V, SRLVar._CAnd, SRLVar._N, SRLVar._CAnd,
					//
					"", "", SRLVar._N, "", "", "", },
			//
			// 与/c 丈夫/nrgx 争吵/v 后/f 跑到/v 公园/ncs 寻短见/v
			// ?
			// 哈市/N 高级/AN 专家/N 退休/V 后/F 可/V 延聘/V
			// { Var._N, Var._V, Var._F, Var._V,
			// //
			// Var._N, Var._TDV, Var._TDV, Var._V, },
			//
			// 空军/N 某部/RQ 成功/A 运用/V 民船/N
			{ SRLVar._N, var2s(new String[] { SRLVar._K, SRLVar._RQ, }),
					//
					"", SRLVar._N },
			//
			// 周琦第2次/N 打/V 季后赛/N
			// { Var._N, Var._MQ, Var._N, Var._N, },
			//
			// 学而思/n 通过/v 这/r 两/m 个/q 环节/n 来/v 考察/v 老师/no 的/u “内功”/en 和/c
			// “外功”/en
			// 每/N 台/Q 电视标配3D眼镜/N 3/M 副/B
			{ SRLVar._N, var2s(new String[] { SRLVar._F, SRLVar._MQ, SRLVar._Q, }), SRLVar._N,
					//
					"", SRLVar._N, "", },
			//
			// ?
			// 又/DV 引渡/V 回国5名犯罪嫌疑人/N
			// { Var._N, Var._MQN, Var._N, Var._N, Var._N, Var._N, },
			//
			// 这些/r 数字/n 的/u 意义/n 不仅/c 在于/v 见证/n 了/u 学而思/n 的/u 发展/v
			{ SRLVar._N, SRLVar._U1De, SRLVar._V, SRLVar.END,
					//
					"", "", SRLVar._N, "", },
			/**
			 * P
			 */
			//
			// 为/p 坚决/a 打/v 好/a 防范/v 化解/v 资本/n 市场/n 重大/a 风险/n 攻坚战/n 做出/v 努力/a
			// 。/w
			// 并/c 于/p 当晚/t 分娩/v 出/v 一/m 死婴/n
			// 后/f 在/p 8月5日/t 流产/v
			{ SRLVar._P, SRLVar._DV, SRLVar._V,
					//
					"", SRLVar._D, SRLVar._N, },
			//
			{ SRLVar._P, SRLVar._S,
					//
					"", SRLVar._PD, },
			/**
			 * PD
			 */
			//
			// 关于/P 对原产/PD 于/P 美国/PD 、/CAnd 欧盟/N_LCAnd_RCAnd 和/CAnd 新加坡/NE
			// 的/U1De 进口/V 卤/N
			{ SRLVar._PD, SRLVar._CAnd, var2s(new String[] { SRLVar._N_LCAnd_RCAnd, SRLVar._NE, }),
					//
					"", SRLVar._PD, SRLVar._PD, },
			//
			// 脱模剂/N 在/P RIM工艺中/PD 的/U1De 应用/V
			{ SRLVar._PD, SRLVar._U1De, SRLVar._V, SRLVar.END,
					//
					"", "", SRLVar._N, "", },
			//
			// 关于/P 对原产/PD 于/P 美国/PD 、/CAnd 欧盟/N_LCAnd_RCAnd 和/CAnd 新加坡/NE
			// 的/U1De 进口/V 卤/N
			{ SRLVar._PD, SRLVar._CAnd, SRLVar._NE, SRLVar._U1De, SRLVar._V, SRLVar._N,
					//
					"", SRLVar._PD, SRLVar._PD, SRLVar._PD, SRLVar._PD, SRLVar._PD, },
			/**
			 * R
			 */
			//
			{ SRLVar._RQ, SRLVar._N,
					//
					SRLVar._N, "", },
			/**
			 * S
			 */
			//
			// 港珠澳大桥/N 通车/V 前后/VEnd
			{ SRLVar.START, SRLVar._N, SRLVar._V, SRLVar._F, SRLVar.END,
					//
					"", SRLVar._ZY, SRLVar._ZY, SRLVar._ZY, "", },
			/**
			 * T
			 */
			//
			// 营业员/N 半天/T 后/F 才/DV 发现/V 中计/VJ
			// 电影《计中计》/N 5月/T 前/F 上映/V
			{ SRLVar._T, SRLVar._F, var2s(new String[] { SRLVar._DV, SRLVar._V, }),
					//
					SRLVar._TDV, SRLVar._TDV, "", },
			/**
			 * U
			 */
			//
			// 14年的/A 坚守/V 终于/DV 摘掉/V ‘/W 千年/T 老二/N ’/W 的/U1De 帽子/N
			{ SRLVar._U1De, SRLVar._V, SRLVar._DV, SRLVar._V,
					//
					"", SRLVar._N, "", "", },
			//////////
			//
			{ var2s(new String[] { SRLVar._B, SRLVar._MQ, }), SRLVar._N,
					//
					SRLVar._N, "", },
			//
			// 双方/n 将/d 在/p 投资银行/n 、/w 资产/n 管理/vn 、/w 营销/vn 推广/vn 等/v 多/a 方面/n
			// 开展/v 广泛/a 、/w 深入/a 的/u 合作/vn ，/w
			// 双方/N 将/DV 在/P 投资银行、资产管理、营销推广/PD 等/V 多/AN 方面/N 开展/V 广泛/A 、/CAnd
			// 深入/AN 的/U1De 合作/N ，/W
			{ var2s(new String[] { SRLVar._V }), SRLVar._A, SRLVar._CAnd, SRLVar._AN,
					//
					"", SRLVar._AN, SRLVar._AN, "", },
			//////////
	};
	// public static String[][] _0_4_common_Phrase_Phrase_Rules = {
	// /**
	// * A
	// */
	// //
	//
	// /**
	// * B
	// */
	// //
	//
	// /**
	// * D
	// */
	// //
	// // 最/DV 被/Bei 高估/AN 的/U1De 四位球员/N
	// { Var._D, Var._VZ,
	// //
	// Var._DV, "", },
	// /**
	// * N
	// */
	// //
	// // 与/c 丈夫/nrgx 争吵/v 后/f 跑到/v 公园/ncs 寻短见/v
	// // ?
	// // 哈市/N 高级/AN 专家/N 退休/V 后/F 可/V 延聘/V
	// // { Var._N, Var._V, Var._F, Var._V,
	// // //
	// // Var._N, Var._TDV, Var._TDV, Var._V, },
	// /**
	// * PD
	// */
	// //
	// // 脱模剂/N 在/P RIM工艺中/PD 的/U1De 应用/V
	// { Var._PD, Var._U1De, Var._V, Var.END,
	// //
	// "", "", Var._N, "", },
	// //
	// // 关于/P 对原产/PD 于/P 美国/PD 、/CAnd 欧盟/N_LCAnd_RCAnd 和/CAnd 新加坡/NE
	// // 的/U1De 进口/V 卤/N
	// { Var._PD, Var._CAnd, Var._NE, Var._U1De, Var._V, Var._N,
	// //
	// "", Var._PD, Var._PD, Var._PD, Var._PD, Var._PD, },
	// /**
	// * U
	// */
	// //
	// // 14年的/A 坚守/V 终于/DV 摘掉/V ‘/W 千年/T 老二/N ’/W 的/U1De 帽子/N
	// //
	// { Var._U1De, Var._V, Var._DV, Var._V,
	// //
	// "", Var._N, "", "", },
	//
	// //////////
	// };

	public static String[][] _1_1_after_VorP_Phrase_Phrase_Rules = {
			/**
			 * A
			 */
			//
			// 常州/N 暴躁/A 男/B 被/Bei 拘留/V ,/W
			{ SRLVar._A, SRLVar._B, SRLVar._Bei,
					//
					SRLVar._N, SRLVar._N, SRLVar._Bei, },
			//
			{ SRLVar._A, SRLVar._B, SRLVar._V,
					//
					SRLVar._N, SRLVar._N, SRLVar._V, },
			//
			{ SRLVar._A, SRLVar._DV,
					//
					SRLVar._DV, SRLVar._DV },
			//
			{ SRLVar._A, SRLVar._U1De, SRLVar._V,
					//
					SRLVar._DV, SRLVar._DV, SRLVar._V, },
			//
			// 以/p 逻辑/n 严谨/a 著称/v
			// { Var._A, Var._V, Var._DV, Var._V },
			/**
			 * AD
			 */
			//
			// 6架军机/N 连续/AD 被/Bei 俄防空系统/N 击落/V
			{ SRLVar._AD, var2s(new String[] { SRLVar._Bei, SRLVar._V, }),
					//
					SRLVar._DV, "", },
			/**
			 * B
			 */
			//
			{ SRLVar._B, SRLVar._V,
					//
					SRLVar._DV, SRLVar._V },
			/**
			 * C
			 */
			//
			// // 、/CAnd 正负/N 偏移/V 小/A 、/CAnd 功能/N 完备/A 、/CAnd 故障率/N 低/A
			// { Var._CAnd, Var._N, Var._V, Var._A, Var._CAnd, Var._N, Var._A,
			// Var._CAnd, Var._N, Var._A, Var.END,
			// //
			// Var._CAnd, Var._N, Var._N, Var._A, Var._CAnd, Var._N, Var._A,
			// Var._CAnd, Var._N, Var._A, Var.END, },
			{ SRLVar._CAnd, SRLVar._N, SRLVar._V, SRLVar._A, SRLVar._CAnd, SRLVar._N, SRLVar._A, SRLVar._CAnd,
					SRLVar._N, SRLVar._AV, SRLVar.END,
					//
					SRLVar._CAnd, SRLVar._N, SRLVar._N, SRLVar._A, SRLVar._CAnd, SRLVar._N, SRLVar._A, SRLVar._CAnd,
					SRLVar._N, SRLVar._A, SRLVar.END, },
			/**
			 * D
			 */
			//
			{ SRLVar._D, var2s(new String[] { SRLVar._DV, SRLVar._V, }),
					//
					SRLVar._DV, "", },
			/**
			 * M
			 */
			//
			// 下/f 一/m 个/q 是/v 谁/r
			// { Var._MQN, Var._V,
			// //
			// Var._N, Var._N },
			/**
			 * N
			 */
			//
			{ SRLVar._N, SRLVar._F, SRLVar._U1De, SRLVar._N,
					//
					SRLVar._N, SRLVar._N, SRLVar._U1De, SRLVar._N, },
			//
			{ SRLVar._N, SRLVar._T, SRLVar._N,
					//
					SRLVar._N, SRLVar._N, SRLVar._N, },
			//
			// 资金/N 到位/V 或/C 资金来源/N 落实/V
			{ SRLVar._N, SRLVar._V, SRLVar._C, SRLVar._N, SRLVar._V,
					//
					SRLVar._N, SRLVar._N, SRLVar._C, SRLVar._N, SRLVar._N, },
			//
			// ×
			// 但/C 苹果/N 和/CAnd 华为/AN 的/U1De 表现/N 还/ADV 不错/AV
			// { Var._N, Var._U1De, Var._N, Var._AN, Var._U1De, Var._N, },
			//
			/**
			 * S
			 */
			//
			{ SRLVar.START, SRLVar._F, var2s(new String[] { SRLVar._DV, SRLVar._V, }),
					//
					"", SRLVar._DV, "", },
			/**
			 * T
			 */
			//
			{ SRLVar._T, var2s(new String[] { SRLVar._DV, SRLVar._V, }),
					//
					SRLVar._TDV, "", },
			/**
			 * U
			 */
			//
			{ SRLVar._U1De, SRLVar._S,
					//
					SRLVar._U1De, SRLVar._N },
			/**
			 * V
			 */
			//
			{ SRLVar._V, SRLVar._F, SRLVar._TL, SRLVar._F,
					//
					SRLVar._V, SRLVar._VEnd, SRLVar._TL, SRLVar._F, },

			//////////
	};

	public static String[][] _1_5_after_VorP_Phrase_Phrase_Regex_Rules = {
			/**
			 * 这里顺序不好轻易变啊，不然会只处理局部
			 */
			/**
			 * B
			 */
			//
			{ "/比较/", SRLVar._AV,
					//
					SRLVar._ADV, "",
					//
					SRLVar._0与词汇相等, SRLVar._0与词性相等,
					//
					SRLVar._1改词性, SRLVar._1不变, },
			/**
			 * P
			 */
			//
			// 自/P 发布之日/PD 起/V 三个/MQN 工作日/N 内/F
			{ SRLVar._P, SRLVar._PD, "/起/", SRLVar._MQN, SRLVar._N, "/内/",
					//
					SRLVar._P, SRLVar._PD, SRLVar._PD, SRLVar._PD, SRLVar._PD, SRLVar._PD,
					//
					SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词汇相等, SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词汇相等,
					//
					SRLVar._1不变, SRLVar._1不变, SRLVar._1改词性, SRLVar._1改词性, SRLVar._1改词性, SRLVar._1改词性, },
			/**
			 * V
			 */
			// 成交/V 公告/N 发布/V 后/F 3个/MQN 工作日/N 内/F 签署/V 合同/N
			{ SRLVar._V, SRLVar._F, SRLVar._MQN,
					//
					SRLVar._V, SRLVar._VEnd, SRLVar._MQN,
					//
					SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词性相等,
					//
					SRLVar._1不变, SRLVar._1改词性, SRLVar._1不变, },
			//
			{ SRLVar._V, SRLVar._N, SRLVar._U1De, SRLVar._N,
					//
					"", "", SRLVar._N, "",
					//
					SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词性相等,
					//
					SRLVar._1不变, SRLVar._1不变, SRLVar._1改词性, SRLVar._1不变, },
			//
			// 签订/V 合同/N 后/F 15日/TL 内/F
			{ SRLVar._V, SRLVar._N, "/后/", SRLVar._TL, "/内/",
					//
					SRLVar._P, SRLVar._PD, SRLVar._PD, SRLVar._PD, SRLVar._PD,
					//
					SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词汇相等, SRLVar._0与词性相等, SRLVar._0与词汇相等,
					//
					SRLVar._1改词性, SRLVar._1改词性, SRLVar._1改词性, SRLVar._1改词性, SRLVar._1改词性, },
			// 潮州潮枫路/N 一/M 超载/V 大货车/N 压塌/V 路面后侧翻/N
			{ SRLVar._V, SRLVar._N, "/后/", SRLVar._V,
					//
					SRLVar._P, SRLVar._PD, SRLVar._PD, SRLVar._V,
					//
					SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词汇相等, SRLVar._0与词性相等,
					//
					SRLVar._1改词性, SRLVar._1改词性, SRLVar._1改词性, SRLVar._1不变, },
			//
			// V+/好/成/完/着/了/=V+VEnd
			{ SRLVar._V, "/好/成/完/着/了/得/完/于/",
					//
					SRLVar._V, SRLVar._VEnd,
					//
					SRLVar._0与词性相等, SRLVar._0与词汇相等,
					//
					SRLVar._1不变, SRLVar._1改词性, },
			//
			// V+/好/成/完/着/了/=V+VEnd
			{ SRLVar._VZ, "/好/成/完/着/了/得/完/于/",
					//
					SRLVar._VZ, SRLVar._VEnd,
					//
					SRLVar._0与词性相等, SRLVar._0与词汇相等,
					//
					SRLVar._1不变, SRLVar._1改词性, },
			//
			// V+/过/+U1De=N+N+U1De
			// 在他一生遭遇过的危险中，这样的句子里，“遭遇”不作为“在”的范围的终结
			{ SRLVar._V, "/过/中/出来/", SRLVar._U1De,
					//
					SRLVar._AN, SRLVar._AN, SRLVar._U1De,
					//
					SRLVar._0与词性相等, SRLVar._0与词汇相等, SRLVar._0与词性相等,
					//
					SRLVar._1改词性, SRLVar._1改词性, SRLVar._1不变, },
			//
			// 男子/N 喝醉/V 后/F 躺倒/V 路中央/N
			{ SRLVar._V, "/后/", SRLVar._V,
					//
					SRLVar._DV, SRLVar._DV, SRLVar._V,
					//
					SRLVar._0与词性相等, SRLVar._0与词汇相等, SRLVar._0与词性相等,
					//
					SRLVar._1改词性, SRLVar._1改词性, SRLVar._1不变, },
			/**
			 * Y
			 */
			//
			{ "/要/", SRLVar._V, "/要/", SRLVar._V, SRLVar._U1De,
					//
					"", SRLVar._VG, SRLVar._VG, SRLVar._VG, "",
					//
					SRLVar._0与词汇相等, SRLVar._0与词性相等, SRLVar._0与词汇相等, SRLVar._0与词性相等, SRLVar._0与词性相等,
					//
					SRLVar._1不变, SRLVar._1改词性, SRLVar._1改词性, SRLVar._1改词性, SRLVar._1不变, },
			//
			// 对于/p 要/v 上班/v 要/v 送娃/v 上学/v 的/u 家长/n 略/d 辛苦/a
			{ "/要/", SRLVar._V, SRLVar._U1De,
					//
					"", SRLVar._VG, "",
					//
					SRLVar._0与词汇相等, SRLVar._0与词性相等, SRLVar._0与词性相等,
					//
					SRLVar._1不变, SRLVar._1改词性, SRLVar._1不变, },

			////////
	};

	public static String[][] _3_1_after_Pphrase_Two_Phrase_Phrase_Rules = {
			/**
			 * A
			 */
			//
			{ var2s(new String[] { SRLVar._A, SRLVar._D, }), SRLVar._P, SRLVar._PD,
					//
					SRLVar._DV, "", "", },
			/**
			 * D
			 */
			//
			/**
			 * N
			 */
			//
			{ SRLVar._N, SRLVar._F, SRLVar._U1De, SRLVar._N,
					//
					SRLVar._N, SRLVar._N, SRLVar._N, SRLVar._N, },
			//
			{ SRLVar._N, SRLVar._S,
					//
					SRLVar._N, SRLVar._N },
			/**
			 * U
			 */
			//
			// 的/U1De 思考/V 和/CAnd
			{ SRLVar._U1De, SRLVar._V, SRLVar._CAnd,
					//
					SRLVar._U1De, SRLVar._N, SRLVar._CAnd, },
			/**
			 * T
			 */
			//
			{ SRLVar._T, SRLVar._P, SRLVar._PD,
					//
					SRLVar._TDV, SRLVar._P, SRLVar._PD, },
			//
			/**
			 * 4_4
			 */

			//
	};

	public static String[][] _3_5_after_Pphrase_phrase_Phrase_2_1_Rules = {
			//
			{ SRLVar._PD, SRLVar._F, SRLVar._PD },
			//
			{ SRLVar._PD, SRLVar._S, SRLVar._PD },
			//
	};

	public static String[][] _3_9_final_Phrase_Phrase_Rules = {

			/**
			 * D
			 */
			//
			// 东部/F 疯狂/A 抢/V 七/M 却/D 凉/A 透/V 了/VEnd 心/N
			{ SRLVar._D, SRLVar._A, SRLVar._V,
					//
					SRLVar._DV, SRLVar._DV, SRLVar._V, },
			/**
			 * N
			 */
			//
			// 70余小时/TL 顺利/A 抵岸/V
			// { Var._N, Var._A, Var._V, Var._N, Var._DV, Var._N, },
			//
			// 助/V 缓解/V 疲劳/AV
			{ SRLVar._N, SRLVar._CAnd, SRLVar._V, SRLVar.END,
					//
					SRLVar._N, SRLVar._CAnd, SRLVar._N, SRLVar.END, },
			/**
			 * 
			 * /** T
			 */
			//
			// 70余小时/TL 顺利/A 抵岸/V
			{ SRLVar._TL, SRLVar._A, SRLVar._V,
					//
					SRLVar._TDV, SRLVar._DV, SRLVar._N, },
			/**
			 * V
			 */
			//
			// 助/V 缓解/V 疲劳/AV
			{ SRLVar._V, SRLVar._AV, SRLVar.END,
					//
					SRLVar._V, SRLVar._AV2B, SRLVar.END, },
			//
			// 未来/T 几天雨水/N 不断/DV 出门/VJ 记得/V 带/V 把/Ba 伞/N
			{ SRLVar._V, SRLVar._Ba, SRLVar._N, SRLVar.END,
					//
					SRLVar._V, SRLVar._Q, SRLVar._Q, SRLVar.END, },
			//
			// { var2s(new String[] { SRLVar._V, SRLVar._VZ, }), SRLVar._U1De,
			// //
			// SRLVar._N, "", },
			//
			{ var2s(new String[] { SRLVar._V, SRLVar._VZ, }), SRLVar._U1De,
					//
					SRLVar._N, SRLVar._N, },
			//
			// 被/Bei 弃绝/VJZ 的/U1De 滇缅孤军/N
			{ SRLVar._VJZ, SRLVar._U1De, SRLVar._N, SRLVar._U1De, },
			//
			// 为/P 保证UTM防火墙/PD 升级/V 服务/V 和/CAnd 中间/F 库服务器售后服务/N
			//
			{ SRLVar._V, SRLVar._CAnd, SRLVar._N, SRLVar.END,
					//
					SRLVar._N, SRLVar._CAnd, SRLVar._N, SRLVar.END, },
			//
			/**
			 * S
			 */
			//
			// 现场/S 公示/V 楼层单元/N
			{ SRLVar.START, SRLVar._S, SRLVar._V,
					//
					SRLVar.START, SRLVar._DV, SRLVar._V, },
			//
			/**
			 * 2_2
			 */
			//
			{ SRLVar._CAnd, SRLVar._N_RCAnd,
					//
					SRLVar._CAnd, SRLVar._N_LCAnd_RCAnd, },
			//
			{ SRLVar._N_LCAnd, SRLVar._CAnd,
					//
					SRLVar._N_LCAnd_RCAnd, SRLVar._CAnd, },
			//
			/**
			 * 3_3
			 */
			//
			{ SRLVar._MQN, SRLVar._S, SRLVar._N,
					//
					SRLVar._N, SRLVar._N, SRLVar._N, },
			//
			{ SRLVar._PD, SRLVar._N, SRLVar._F,
					//
					SRLVar._PD, SRLVar._PD, SRLVar._PD, },
			//
			// 我们/r 在/p 初一/t_n 都/d 要/v 学/v 些/q 什么/r 呢/y
			// { Var._V, Var._Q, Var._N, Var._V, Var._N, Var._N, },
			//
			{ SRLVar._CAnd, SRLVar._N, SRLVar._CAnd,
					//
					SRLVar._CAnd, SRLVar._N_LCAnd_RCAnd, SRLVar._CAnd, },
			//
			// 银行互联网金融idc机房/N 设计/V 、/CAnd 装修/V 、/CAnd 配电/V 、/CAnd 消防/B 、/CAnd
			// 综合布线/N_LCAnd_RCAnd 、/CAnd 防雷接地/N_LCAnd_RCAnd 、/CAnd
			// 暖通/N_LCAnd_RCAnd 、/CAnd 环境监控/N 等/U 工程/N
			{ SRLVar._CAnd, SRLVar._B, SRLVar._CAnd, SRLVar._N_LCAnd_RCAnd,
					//
					SRLVar._CAnd, SRLVar._N, SRLVar._CAnd, SRLVar._N_LCAnd_RCAnd, },
			//
			{ SRLVar._V, SRLVar._CAnd, var2s(new String[] { SRLVar._N_LCAnd_RCAnd, SRLVar._N_RCAnd, }),
					//
					SRLVar._N, "", "", },
			//
			/**
			 * 4_4
			 */
			//

			//
			// 2/M ．/W 健全/V 有奖/N 举报/V 和/CAnd 舆情监测制度/N
			{ SRLVar._V, SRLVar._CAnd, SRLVar._N, SRLVar.END,
					//
					SRLVar._N, SRLVar._CAnd, SRLVar._N, SRLVar.END, },
			//
			/**
			 * 5_5
			 */
			//

			//
			// 还/DV 包括/V 室外/S 交通/N 、/CAnd 管网/N_LCAnd_RCAnd 、/CAnd 消防/DV 设计/V
			// 、/CAnd 水池泵房/N （生活及消防）/B 、/CAnd 污水处理站/N_LCAnd_RCAnd 及/CAnd
			// 热力机房设计/N
			{ SRLVar._CAnd, SRLVar._N, SRLVar._B, SRLVar._CAnd, SRLVar._N_LCAnd_RCAnd,
					//
					SRLVar._CAnd, SRLVar._N, SRLVar._N, SRLVar._CAnd, SRLVar._N_LCAnd_RCAnd, },
			//
			{ SRLVar._N_LCAnd_RCAnd, SRLVar._CAnd, SRLVar._N, SRLVar._V, SRLVar.END,
					//
					SRLVar._N_LCAnd_RCAnd, SRLVar._CAnd, SRLVar._N, SRLVar._N, SRLVar.END, },
			//
			// 主要/DV 做/V 好人员管理培训/N 、/CAnd 专题制作/N_LCAnd_RCAnd 、/CAnd
			// 公共关系建设/N_LCAnd_RCAnd 、/CAnd 传播效果反馈/N_LCAnd_RCAnd 、/CAnd
			// 相关网络舆情监测/N_LCAnd_RCAnd 、/CAnd 舆情预警/N_LCAnd_RCAnd 、/CAnd 综合/V 研判/N
			// 、/CAnd 舆情/N 应对/V 等/U 相关/N 服务/V 。/W
			{ SRLVar._N_LCAnd_RCAnd, SRLVar._CAnd, SRLVar._V, SRLVar._N, SRLVar._CAnd,
					//
					SRLVar._N_LCAnd_RCAnd, SRLVar._CAnd, SRLVar._N, SRLVar._N, SRLVar._CAnd, },
			//
			/**
			 * 6_6
			 */
			//
			// 3年/tl 专业/N 支持/V 和/CAnd 关键/AN 任务/N
			{ SRLVar._N, SRLVar._V, SRLVar._CAnd, SRLVar._AN, SRLVar._N, SRLVar.END,
					//
					SRLVar._N, SRLVar._N, SRLVar._CAnd, SRLVar._AN, SRLVar._N, SRLVar.END, },
			//
			// 包括/V 舆情分析/N 、/CAnd 风险画像/N_LCAnd_RCAnd 、/CAnd 统计分析/N_LCAnd_RCAnd
			// 、/CAnd 互动/V 交流/N 、/CAnd 流媒体路演/N_LCAnd_RCAnd 和/CAnd 移动/N 端/V 服务/V
			// 等/V 模块/N
			{ SRLVar._N_LCAnd_RCAnd, SRLVar._CAnd, SRLVar._V, SRLVar._N, SRLVar._CAnd, SRLVar._N_LCAnd_RCAnd,
					//
					SRLVar._N_LCAnd_RCAnd, SRLVar._CAnd, SRLVar._N, SRLVar._N, SRLVar._CAnd, SRLVar._N_LCAnd_RCAnd, },
			//
			/**
			 * 8_8
			 */
			//
			// 包括/V 远程的/AN 开关机/N 、/CAnd 重启/V 、/CAnd 更新/V Firmware/N
			{ SRLVar._AN, SRLVar._N, SRLVar._CAnd, SRLVar._V, SRLVar._CAnd, SRLVar._V, SRLVar._N, SRLVar.END,
					//
					SRLVar._AN, SRLVar._N, SRLVar._CAnd, SRLVar._N, SRLVar._N, SRLVar._N, SRLVar._N, SRLVar.END, },
			////
	};
	public static String[][] _4_5_after_VVs_Phrase_Rules = {
			/**
			 * 
			 */
			//
			// { Var._V, Var._VZ, Var._DV, Var._VZ, },
			//
			// 上海/N 今年/TDV 将/DV 研究/VJ 制订/VZ 《不可移动文物升降级管理办法》/N
			//
			// 宁夏空气质量从/N 略有/DV 恶化/VZ 转为/VZ 改善/VJ
			// { Var._DV, Var._VJ, Var._VZ, Var._DV, Var._VZ, Var._VZ, },
			//
			{ SRLVar._VZ, SRLVar._V, SRLVar.END,
					//
					SRLVar._VZ, SRLVar._VJN, SRLVar.END, },
			// ////////
	};
	public static String[][] POne_Rules = {
			/**
			 * 以and由
			 */
			/**
			 * D
			 */
			//
			// 由/p 谈判/vn 响应人/n 自行/d 承担/v
			{ SRLVar._DV, SRLVar._V, SRLVar.END,
					//
					SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词性相等 },
			{ "0", },
			/**
			 * V
			 */
			//
			// 由/p 发布者/n 负责/v
			{ SRLVar._V, SRLVar.END,
					//
					SRLVar._0与词性相等, SRLVar._0与词性相等 },
			{ "0", },
			//
			// 以/p 被告人/nrsf 李纯/n 为首/v 的/u 一/m 帮/q 人/n
			// 由/p 李纯/n 、/w 张威/n 驾驶/v 的/u 两/m 台/q 小车/n
			{ SRLVar._V, SRLVar._U1De,
					//
					SRLVar._0与词性相等, SRLVar._0与词性相等 },
			{ "2", },
			/**
			 * P
			 */
			//
			{ SRLVar._P, SRLVar._0与词性相等 }, { "0", },
			/**
			 * U
			 */
			//
			// 以/p 招标/vn 代理/vn 机构/nttc 或/c 招标人/n 的/u 解释/v 为/p 准/a
			// 以/p 逻辑/n 严谨/a 著称/v
			{ SRLVar._U1De, SRLVar._V,
					//
					SRLVar._0与词性不等, SRLVar._0与词性相等 },
			{ "1" },
			//////////
	};

	public static String[][] P_Rules_100 = {
			//
			{ SRLVar._Bei, SRLVar._0与词性相等, }, { "0", },
			//
			{ SRLVar.END, SRLVar._0与词性相等, }, { "0", },
			//
			{ SRLVar._V, SRLVar.END, SRLVar._0与词性相等, SRLVar._0与词性相等, }, { "-1", },
			//
			{ SRLVar._V, SRLVar._0与词性相等, }, { "0", },
			//
			{ SRLVar._P, SRLVar._0与词性相等 }, { "0", },
			//////////
	};

	public static String[][] PTwo_Rules = {
			/**
			 * 以and...
			 */
			/**
			 * A
			 */
			//
			{ SRLVar._AV, SRLVar._0与词性相等 }, { "0", },
			//
			{ SRLVar._ADV, SRLVar._0与词性相等 }, { "0", },
			//
			{ SRLVar._AV, SRLVar._0与词性相等 }, { "0", },
			/**
			 * C
			 */
			//
			// 以/p 被告人/nrsf 张铮/n 为首/v 的/u 一/m 帮/v 人/n 与/c 以/p 被告人/nrsf 李纯/n
			// 为首/v 的/u
			// 一/m 帮/v 人/n 因为/c 在/p 本县/r 深柳镇金水桥/ns 刘国华/nr 、/w 尹/nr 腊/ng 炎/k
			// （另案处理）/en 等人/d 开设/v 的/u 赌场/ncs 内/f 为/v 争抢/v 放高利贷/n 而/c 发生/v
			// 矛盾/an
			{ SRLVar._C, SRLVar._P,
					//
					SRLVar._0与词性相等, SRLVar._0与词性相等 },
			{ "0", },
			//
			// 请/v 在/p 课后/t 或者/c 不要/d 陪/v 孩子/n 在/p 课堂/ncs 上好/b 不好/a
			{ SRLVar._C, SRLVar._DV,
					//
					SRLVar._0与词性相等, SRLVar._0与词性相等 },
			{ "0", },
			//
			// 在/p 会计/no 基础/n 、/w 内部/f 控制/v 、/w 信息/n 披露/v 等/v 方面/n 涉嫌/v
			// 违反/v 发行/v 条件/n 等/u 众多/m 问题/n
			// 招标人/n 不/d 对/p 邮寄/v 过程/n 中/f 的/u 遗失/v 负责/v
			{ SRLVar._CAnd, SRLVar._F, SRLVar._U1De,
					//
					SRLVar._0与词性不等, SRLVar._0与词性相等, SRLVar._0与词性不等, },
			{ "2", },
			//
			// 两/m 个/q 家长/n 在/p 课堂/ncs 上/f_v 聚/v 在/p 后面/f 窃窃私语/i
			{ SRLVar._CAnd, SRLVar._F_V, SRLVar._U1De,
					//
					SRLVar._0与词性不等, SRLVar._0与词性相等, SRLVar._0与词性不等, },
			{ "2", },
			/**
			 * D
			 */
			//
			{ SRLVar._DV, SRLVar._0与词性相等 }, { "0", },
			/**
			 * I
			 */
			//
			{ SRLVar._IV, SRLVar._0与词性相等 }, { "0", },
			/**
			 * P
			 */
			//
			{ SRLVar._P, SRLVar._0与词性相等 }, { "0", },
			//
			// 父亲/nrgx 说/v 警察/no 已经/d 堵/v 在/p 门口/s 了/u
			{ SRLVar._PD, SRLVar._0与词性相等 }, { "0", },
			/**
			 * S
			 */
			//
			{ SRLVar._S, SRLVar._0与词性相等 }, { "0", },
			/**
			 * U
			 */
			//
			// 致力/v 于/p 使/p 孩子们/n 的/u 学习/v 变得/v 更/d 有趣/a 、/w 更/d 高效/b
			// 在/p 投标/v 或/c 购买/v 招标文件/n 前/f
			{ SRLVar._U1De, SRLVar._V, SRLVar._C,
					//
					SRLVar._0与词性不等, SRLVar._0与词性相等, SRLVar._0与词性不等, },
			{ "1" },
			/**
			 * V
			 */
			//
			// 在/p 投标/v 或/c 购买/v 招标文件/n 前/f
			{ SRLVar._V, SRLVar._C, SRLVar._V, SRLVar._N, SRLVar._F,
					//
					SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词性相等, SRLVar._0与词性相等, },
			{ "5", },
			//
			// 中印/N 在/P 洞朗/PD 对峙/V 后/F 明显/DV 缓和/V
			{ SRLVar._V, SRLVar._F,
					//
					SRLVar._0与词性相等, SRLVar._0与词性相等, },
			{ "2", },
			//////////

	};

	public static String[][] P_Rules_200 = {
			//
			{ SRLVar._Bei, SRLVar._0与词性相等, }, { "0", },
			//
			// ×
			// 两/m 个/q 家长/n 在/p 课堂/ncs 上/f_v 聚/v 在/p 后面/f 窃窃私语/i
			// 两/m 个/q 家长/n 在/p 课堂/ncs 上/f_v 聚/v 在/p 后面/f 角落/n 窃窃私语/i
			// { Var._F,
			// //
			// Var._0与词性相等, },
			// { "1", },
			//
			{ SRLVar._NE,
					//
					SRLVar._0与词性相等, },
			{ "1", },
			//
			// 林更新/nr 忆起/v 小时候/n 在/p 沈阳/ns 住/v 过/n 的/u 大院/n
			{ SRLVar._NE,
					//
					SRLVar._0与词性相等, },
			{ "1", },
			//
			// 他/R 在/P 曼联真的不可或缺/PD
			{ SRLVar._NE,
					//
					SRLVar._0与词性相等, },
			{ "1", },
			//
			// 想/v 在/p 悠然/ad 居/v_n 上/f_v 新/a_n 三/m 英语/nz 的/u 家长/n 们/k
			{ SRLVar._F_V, SRLVar._0与词性相等 }, { "0" },

			//
			{ SRLVar.END, SRLVar._0与词性相等 }, { "0" },
			//////////
	};

	private static String var2s(String[] vars) {
		String result = "/";
		//
		for (String var : vars) {
			result = result + var + "/";
		}
		//
		return result;
	}
}

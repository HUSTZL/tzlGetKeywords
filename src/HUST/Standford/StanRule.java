package HUST.Standford;

import HUST.Semantic.Role.Labeling.SRLVar;

public class StanRule {

	//
	public static String _定语 = "定语";
	public static String _主语 = "主语";
	public static String _主语1 = "主语1";
	public static String _主语2 = "主语2";
	public static String _状语 = "状语";
	public static String _状语D = "状语D";
	public static String _状语P = "状语P";
	public static String _状语T = "状语T";
	public static String _主谓语 = "主谓语";
	public static String _谓语 = "谓语";
	public static String _主谓语补语 = "主谓语补语";
	public static String _谓语补语 = "谓语补语";
	public static String _主宾倒置 = "主宾倒置";
	public static String _动宾倒置 = "动宾倒置";
	public static String _宾语 = "宾语";
	public static String _宾语1 = "宾语1";
	public static String _宾语2 = "宾语2";
	public static String _宾语3 = "宾语3";
	private static String _宾语等 = "宾语等";
	private static String _宾语总 = "宾语总";
	public static String _并列词 = "并列词";
	public static String _连接词 = "连接词";
	public static String _语气词 = "语气词";
	public static String _疑问词 = "疑问词";
	public static String _符号 = "符号";
	public static String _未知成分 = "未知成分";
	//
	public static String 开始 = "开始";
	public static String 结束 = "结束";
	//
	public static String mainPrecicts =
			// b
			"/不是/表示/帮助/比如/包含/包括"
					// c
					+ "/成为/存在/承蒙"
					// d
					+ "/担心"
					// f
					+ "/发现"
					// g
					+ "/感觉"
					// h
					+ "/获/获得"
					// j
					+ "/具有/进行/觉得/相信/接受/决定/就是/均获/进入"
					// k
					+ "/开始/看见/看到/考虑/看起来/可/看/恳求"
					// m
					+ "/没有/面临"
					// n
					+ "/能想到"
					// p
					+ "/判"
					// q
					+ "/请教/请/确认"
					// r
					+ "/认为/认识到"
					// s
					+ "/是/是不是/说/煞是/使得/实为/申请"
					// t
					+ "/听到/提醒/听候/停止"
					// x
					+ "/希望/喜欢/想要/宣布/想/想到/宣称/需要"
					// y
					+ "/有着/意味着/以为/要求/有/迎来"
					// z
					+ "/做出/知道/找出/指控/证明/致使/在于/作为/致"
					//
					+ "/";

	// 如何压缩规则

	public static String[][] rules = {
			/**
			 * A
			 */
			//
			// 广泛/A 、/CAnd 深入的合作/N
			{ SRLVar._A, SRLVar._CAnd, SRLVar._N, }, {},
			//
			// 网友/N 表示/V 细心/A 又/DN 谨慎/AN 的/U1De 姑娘/N
			{ SRLVar._A, SRLVar._DN, SRLVar._AN, SRLVar._U1De, SRLVar._N },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 回笼/V 资金/N 近/A 56亿元/MQ
			{ SRLVar._A, SRLVar._MQ, }, { StanRule._定语, StanRule._宾语, },
			//
			// 最大/A 5个/MQN usb端口/N
			{ SRLVar._A, SRLVar._MQN, SRLVar._N, }, { StanRule._定语, StanRule._宾语, StanRule._宾语, },
			//
			{ SRLVar._A, SRLVar._N, }, { StanRule._定语, StanRule._宾语, },
			//
			{ SRLVar._A, SRLVar._TL, SRLVar._N, }, {},
			/**
			 * AD
			 */
			//
			{ SRLVar._AD, SRLVar._N, }, { StanRule._定语, StanRule._宾语, },
			/**
			 * AN
			 */
			//
			{ SRLVar._AN, }, {},
			//
			{ SRLVar._AN, SRLVar._N, }, { StanRule._定语, StanRule._宾语, },
			//
			// 新/AN 服务器/N 、/CAnd
			{ SRLVar._AN, SRLVar._N, SRLVar._CAnd, }, { StanRule._定语, StanRule._宾语, StanRule._并列词, },
			//
			// 新/AN 生儿双水平无创呼吸机/N 、/CAnd 高级/AN 呼吸机/N
			{ SRLVar._AN, SRLVar._N, SRLVar._CAnd, SRLVar._AN, SRLVar._N, },
			{ StanRule._定语, StanRule._宾语1, StanRule._并列词, StanRule._定语, StanRule._宾语2, },
			//
			// 具体/AN 要求/N 及/CAnd 项目情况/N
			{ SRLVar._AN, SRLVar._N, SRLVar._CAnd, SRLVar._N, },
			{ StanRule._宾语1, StanRule._宾语1, StanRule._并列词, StanRule._宾语2, },
			//
			// 新/AN 生儿双水平无创呼吸机/N 一套/MQ
			{ SRLVar._AN, SRLVar._N, SRLVar._MQ, }, {},
			//
			{ SRLVar._AN, SRLVar._N, SRLVar._U, }, {},
			//
			// 权威机关颁发/AN 的/U1De ISO-9000系列/AN 的/U1De 认证书/N
			{ SRLVar._AN, SRLVar._U1De, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 周杰伦/AN 的/U1De 歌曲/N 出现过/AN 的/U1De 经典/AN 歌词/N
			{ SRLVar._AN, SRLVar._U1De, SRLVar._N, SRLVar._AN, SRLVar._U1De, SRLVar._AN, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 具备/AN 的/U1De 主要资格条件/N
			{ SRLVar._AN, SRLVar._U1De, SRLVar._N, }, { StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 双方/N 将/DV 在/P 投资银行、资产管理、营销推广/PD 等/V 多/AN 方面/N 开展/V 广泛、深入/AN
			// 的/U1De 合作/N ，/W
			{ SRLVar._AN, SRLVar._U1De, SRLVar._N, SRLVar._WI, }, { StanRule._定语, StanRule._定语, StanRule._宾语, "", },
			//
			// 本工程/AN 的/U1De 方案设计/N 、/CAnd
			{ SRLVar._AN, SRLVar._U1De, SRLVar._N, SRLVar._CAnd, },
			{ StanRule._定语, StanRule._定语, StanRule._宾语, StanRule._并列词, },
			//
			// 良好/AN 的/U1De 商业信誉/N 和/CAnd 健全/AN 的/U1De 财务会计制度/N
			{ SRLVar._AN, SRLVar._U1De, SRLVar._N, SRLVar._CAnd, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._宾语1, StanRule._并列词, StanRule._定语, StanRule._定语, StanRule._宾语2, },
			//
			// 过低/AN 的/U1De 价格/N 、/CAnd 夸张/AN 的/U1De 描述/N 、/CAnd 私人银行账户/N 等/U
			{ SRLVar._AN, SRLVar._U1De, SRLVar._N, SRLVar._CAnd, SRLVar._AN, SRLVar._U1De, SRLVar._N, SRLVar._CAnd,
					SRLVar._N, SRLVar._U, },
			{ StanRule._定语, StanRule._定语, StanRule._宾语1, StanRule._并列词, StanRule._定语, StanRule._定语, StanRule._宾语2,
					StanRule._并列词, StanRule._宾语3, StanRule._宾语3, },
			//
			// 本站/AN 的/U1De 观点/N 和/CAnd 立场/N
			{ SRLVar._AN, SRLVar._U1De, SRLVar._N, SRLVar._CAnd, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._宾语1, StanRule._并列词, StanRule._宾语2, },
			//
			// 山东泰开电力电子有限公司/AN 的/U1De 控制电缆/N 等/U
			{ SRLVar._AN, SRLVar._U1De, SRLVar._N, SRLVar._U, },
			{ StanRule._定语, StanRule._定语, StanRule._宾语, StanRule._宾语等, },
			//
			// 新池/AN 的/U1De 名称/N 等/U 信息/N
			{ SRLVar._AN, SRLVar._U1De, SRLVar._N, SRLVar._U, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._宾语, StanRule._宾语等, StanRule._宾语总, },
			/**
			 * AG
			 */
			//
			// 伪/AG 纪录片形式/N 增强/V 惊悚/V 感/vg
			{ SRLVar._AG, SRLVar._N, }, {},
			/**
			 * AU1DE
			 */
			//
			// 司空见惯的/AU1DE 商业手段/N
			{ SRLVar._AU1De, SRLVar._N, }, { StanRule._定语, StanRule._宾语, },
			/**
			 * C
			 */
			//
			{ SRLVar._C, }, { StanRule._连接词, },
			//
			// 或/C 建设部颁发/AN 的/U1De 电梯安装工程专业/N
			{ SRLVar._C, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._连接词, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 且/C 许可证/AN 的/U1De 经营范围/N 中/F
			{ SRLVar._C, SRLVar._AN, SRLVar._U1De, SRLVar._N, SRLVar._F, },
			{ StanRule._连接词, StanRule._定语, StanRule._定语, StanRule._宾语, StanRule._宾语, },
			/**
			 * CAnd
			 */
			//
			{ SRLVar._CAnd, }, { StanRule._并列词, },
			//
			// 和/CAnd 关键/AN 任务/N
			{ SRLVar._CAnd, SRLVar._AN, SRLVar._N, }, { StanRule._并列词, StanRule._定语, StanRule._宾语, },
			//
			// 及/CAnd 服务/AN 的/U1De 投标人/N
			{ SRLVar._CAnd, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._并列词, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			{ SRLVar._CAnd, SRLVar._N, }, { StanRule._并列词, StanRule._宾语, },
			//
			// 和/CAnd 部分项目招标文件/N 等/U
			{ SRLVar._CAnd, SRLVar._N, SRLVar._U, }, { StanRule._并列词, StanRule._宾语, StanRule._宾语, },
			//
			// 、/CAnd 温度/N 等/U 信息/N
			{ SRLVar._CAnd, SRLVar._N, SRLVar._U, SRLVar._N, },
			{ StanRule._并列词, StanRule._宾语, StanRule._宾语等, StanRule._宾语总, },
			/**
			 * D
			 */
			{ SRLVar._D, }, { StanRule._状语D, },
			//
			//
			{ SRLVar._D, SRLVar._AN, SRLVar._N }, { StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 凡/D 符合资格要求/AN 的/U1De 投标人/N
			{ SRLVar._D, SRLVar._AN, SRLVar._U1De, SRLVar._N },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 仅/D 2/M 国/N 可/VZ 向/P 全球任一战区/PD 投送/V 战术/N 支援/V 武器/N
			// END/EN
			{ SRLVar._D, SRLVar._M, SRLVar._N, }, {},
			//
			// 就/D 一个/MQ 破/AN 公园/N
			{ SRLVar._D, SRLVar._MQ, SRLVar._AN, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			/**
			 * DN
			 */
			//
			// 散布/V 不/DN 实/AN 图文/N 判/VZ 赔/VJN
			{ SRLVar._DN, SRLVar._AN, SRLVar._N, }, {},
			//
			// 正/DN 高/AN 职称/N 高级/AN 专家/N 可/V 一次性/DV 延聘/V
			{ SRLVar._DN, SRLVar._AN, SRLVar._N, SRLVar._AN, SRLVar._N, }, {},
			//
			// 再/DN 窄/AN 的/U1De 家/N
			{ SRLVar._DN, SRLVar._AN, SRLVar._U1De, SRLVar._N },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			/**
			 * F
			 */
			//
			// 以下/F 品牌/AN 的/U1De 电梯/N
			{ SRLVar._F, SRLVar._AN, SRLVar._U1De, SRLVar._N },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 以下/F 项目/N
			{ SRLVar._F, SRLVar._N, }, {},
			//
			// 以下/F 情形/N 之/U1De 一/M
			{ SRLVar._F, SRLVar._N, SRLVar._U1De, SRLVar._M }, {},
			//
			// 以上/F 所/U 展示/AN 的/U1De 信息/N
			{ SRLVar._F, SRLVar._U, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 附近/F 的/U1De AP/N
			{ SRLVar._F, SRLVar._U1De, SRLVar._N, }, { StanRule._定语, StanRule._定语, StanRule._宾语, },
			/**
			 * H
			 */
			//
			// 非/H 示范段/AN 的/U1De 13条市政道路/N
			{ SRLVar._H, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 非/H 金融机构/N 不得/V 借此/V 开展/V 资/N 管/V
			{ SRLVar._H, SRLVar._N, }, {},
			/**
			 * M
			 */
			//
			{ SRLVar._M, SRLVar._AN, SRLVar._N, }, {},
			//
			{ SRLVar._M, SRLVar._CAnd, }, { StanRule._宾语, StanRule._宾语, },
			//
			// 6/M 、/CAnd 近/AN 三年同类/N 或/CAnd 相关项目业绩/N
			{ SRLVar._M, SRLVar._CAnd, SRLVar._AN, SRLVar._N, SRLVar._CAnd, SRLVar._N, },
			{ StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, },
			//
			// 3/M 、/CAnd 投标人授权/AN 的/U1De 委托代理人/N
			{ SRLVar._M, SRLVar._CAnd, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 1/M 、/CAnd 投标单位/N
			{ SRLVar._M, SRLVar._CAnd, SRLVar._N, }, { StanRule._宾语, StanRule._宾语, StanRule._宾语, },
			//
			// 日本/N 成立/V 2100/M 人水陆机动团/N
			{ SRLVar._M, SRLVar._N, }, {},
			// 开始:start/start,START,
			// 谓语:不值/v,V,
			// 未知成分:160/m,M,
			// 未知成分:的/u1de,U1De,
			// 未知成分:门票/n,N,
			// 结束:end/end,END,
			{ SRLVar._M, SRLVar._U1De, SRLVar._N, }, {},
			//
			// 6/M ．/W 其他主要资格要求（详细要求具体见招标文件）/N
			{ SRLVar._M, SRLVar._WI, SRLVar._N, }, {},
			/**
			 * MQ
			 */
			//
			// 深夜/t 南北/f 高架/vn 越野车/ncp 折返/v 18/m 次/q
			// { Var._MQ, }, { ParserRule._宾语, },
			//
			{ SRLVar._MQ, SRLVar._AN, SRLVar._N, }, { StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 9家/MQ 新/AN 三板/N 公司/NE 及/CAnd 相关主体/N 被/Bei 股/N 转/V 采取/V 自律监管措施/N
			{ SRLVar._MQ, SRLVar._AN, SRLVar._N, SRLVar._NE, }, {},
			//
			// 这/N 真是/V 一个/MQ 很/DN 差/AN 的/U1De 景点/N
			{ SRLVar._MQ, SRLVar._DN, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 三位/MQ 国民党/NE 投诚/V 上将/N 屈死/V “文革”/N
			{ SRLVar._MQ, SRLVar._NE, }, {},
			//
			// 千株/MQ 千年/T 古树/N 聚生/V
			{ SRLVar._MQ, SRLVar._T, SRLVar._N, }, {},

			/**
			 * MQN
			 */
			//
			// 2个/MQN
			{ SRLVar._MQN, }, {},
			//
			// 2个/MQN 全高/AN 的/U1De pci插槽/N
			{ SRLVar._MQN, SRLVar._AN, SRLVar._U1De, SRLVar._N },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 一个/MQN 或/C 多个/MQN 网络/N
			{ SRLVar._MQN, SRLVar._C, SRLVar._MQN, SRLVar._N },
			{ StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, },
			//
			// 2个/MQN 500w热插拔冗余电源/N
			{ SRLVar._MQN, SRLVar._N, }, {},
			//
			// 2个/MQN 10gb/N 或/CAnd 10gbbase/N
			{ SRLVar._MQN, SRLVar._N, SRLVar._CAnd, SRLVar._N, },
			{ StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, },
			//
			// 3个/MQN 工作日/N 内/F
			{ SRLVar._MQN, SRLVar._N, SRLVar._F, }, { StanRule._宾语, StanRule._宾语, StanRule._宾语, },
			/**
			 * N
			 */
			//
			{ SRLVar._N, }, {},
			//
			// 永仁县/N 卫生/AN 和/CAnd 计划生育局/N
			{ SRLVar._N, SRLVar._A, SRLVar._CAnd, SRLVar._N, },
			{ StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, },
			//
			// 手机NFC/N 近/A 场/Q 通信模块/N
			{ SRLVar._N, SRLVar._A, SRLVar._Q, SRLVar._N, },
			{ StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, },
			//
			// 技术/N 详细/AD 评审表/N
			{ SRLVar._N, SRLVar._AD, SRLVar._N, }, {},
			//
			// 商丘/N 古/AN 文化旅游区画舫游船/N 正式/A 开航/V
			{ SRLVar._N, SRLVar._AN, SRLVar._N, }, {},
			//
			// 央企债务风险/N 安全/AN 可控/V
			{ SRLVar._N, SRLVar._AN, }, {},
			//
			// 采购人/N 对本项目做出/AN 的/U1De 商务条款要求/N
			{ SRLVar._N, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 增值税/N 一般/AN 纳税人/N
			{ SRLVar._N, SRLVar._AN, SRLVar._N, }, {},
			//
			// 独立法人资格/N 且/C 营业执照经营范围/N 内/F
			{ SRLVar._N, SRLVar._C, SRLVar._N, SRLVar._F, }, {},
			//
			// 邮资50元人民币/N 或/C 40美元/MQ
			{ SRLVar._N, SRLVar._C, SRLVar._M, SRLVar._Q, }, {},
			//
			// 没有/DV 处于/V 被/Bei 有权/V 机关/N 吊销/V 营业执照/N 、/CAnd 吊销/V 资质/N 、/CAnd
			// 停业/V 整顿/V 、/CAnd 取消/V 投标/V 资格/N 以及/CAnd 财产/N 被/Bei 接管/V 、/CAnd
			// 冻结/V 或/C 进入/V 破产/V 程序/N 等/U 。/W
			{ SRLVar._N, SRLVar._CAnd, }, { StanRule._宾语, StanRule._并列词, },
			//
			// 相关证件/N 、/CAnd 业绩/AN 的/U1De 原件/N
			{ SRLVar._N, SRLVar._CAnd, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._定语, StanRule._并列词, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 营业执照/N 、/CAnd 具有独立法人资格/AN 的/U1De 电梯制造商/N 或/CAnd
			{ SRLVar._N, SRLVar._CAnd, SRLVar._AN, SRLVar._U1De, SRLVar._N, SRLVar._CAnd },
			{ StanRule._定语, StanRule._并列词, StanRule._定语, StanRule._定语, StanRule._宾语, StanRule._并列词, },
			//
			// 维修许可证（电梯）c级/N 及/CAnd 以上/F 资质/N 和/CAnd 南通市质量技术监督局备案的电梯/N
			{ SRLVar._N, SRLVar._CAnd, SRLVar._F, SRLVar._N, SRLVar._CAnd, SRLVar._N, },
			{ StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, },
			//
			// 五台电梯/N 及/CAnd 以上/F 的/U1De 业绩/N
			{ SRLVar._N, SRLVar._CAnd, SRLVar._F, SRLVar._U1De, SRLVar._N, },
			{ StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, },
			//
			// 有奖举报/N 和/CAnd 舆情监测制度/N
			{ SRLVar._N, SRLVar._CAnd, SRLVar._N, }, { StanRule._宾语1, StanRule._并列词, StanRule._宾语2, },
			//
			// 用户名/N 和/CAnd 密码/N 并/C
			{ SRLVar._N, SRLVar._CAnd, SRLVar._N, SRLVar._C, },
			{ StanRule._宾语1, StanRule._并列词, StanRule._宾语2, StanRule._连接词, },
			//
			// 儿科/N 、/CAnd 妇产科设备/N 一批/MQ
			{ SRLVar._N, SRLVar._CAnd, SRLVar._N, SRLVar._MQ, },
			{ StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, },
			//
			// 代理商/N 、/CAnd 经销商/N 等/U
			{ SRLVar._N, SRLVar._CAnd, SRLVar._N, SRLVar._U, },
			{ StanRule._宾语1, StanRule._并列词, StanRule._宾语2, StanRule._宾语2, },
			//
			// 但/C 苹果/N 和/CAnd 华为/AN 的/U1De 表现/N 还/ADV 不错/AV
			{ SRLVar._N, SRLVar._CAnd, SRLVar._N, SRLVar._U1De, SRLVar._N }, {},
			//
			// 其属性/N 和/CAnd 当前/T 状态/N
			{ SRLVar._N, SRLVar._CAnd, SRLVar._T, SRLVar._N, },
			{ StanRule._宾语1, StanRule._并列词, StanRule._定语, StanRule._宾语2, },
			//
			// 产品/N 和/CAnd 服务/V 内容/N 应/V 满足/V 工业级UPS电源/N
			{ SRLVar._N, SRLVar._CAnd, SRLVar._V, }, { StanRule._宾语, StanRule._并列词, StanRule._宾语, },
			//
			// 母亲/AN 的/U1De 叮嘱/N 与/CAnd 思念/V
			{ SRLVar._N, SRLVar._CAnd, SRLVar._V, SRLVar.END, },
			{ StanRule._宾语, StanRule._并列词, StanRule._宾语, StanRule.结束, },
			//
			// 昔日/T 盐碱荒滩/N 成/V 河北/N 又/D 一/M 海滨/S 旅游/N
			{ SRLVar._N, SRLVar._D, SRLVar._M, SRLVar._S, SRLVar._N, }, {},
			//
			// 本工程造价/N 约/D 12万元/MQ
			{ SRLVar._N, SRLVar._D, SRLVar._MQ, }, {},
			//
			// 价格/N 更/DN 有利/AN 位置/N
			{ SRLVar._N, SRLVar._DN, SRLVar._AN, SRLVar._N, }, {},
			//
			{ SRLVar._N, SRLVar._F, }, {},
			//
			// 南和县祥和路/N 以东/F 、/CAnd 商业大街/N 北侧/F 、/CAnd 三中家属院/N 西侧/F
			{ SRLVar._N, SRLVar._F, SRLVar._CAnd, SRLVar._N, SRLVar._F, SRLVar._CAnd, SRLVar._N, SRLVar._F, },
			{ StanRule._宾语1, StanRule._宾语1, StanRule._并列词, StanRule._宾语2, StanRule._宾语2, StanRule._并列词, StanRule._宾语3,
					StanRule._宾语3, },
			//
			// 赛/N 后/F 一/M 言论/N 惹恼/V 勇士球迷/N
			{ SRLVar._N, SRLVar._F, SRLVar._M, SRLVar._N, }, {},
			//
			// 中国品牌/N 里/F 哪/ri 款新车/N 隔音/V 和/CAnd 舒适/AN 表现/N 最好/AV
			//
			{ SRLVar._N, SRLVar._F, SRLVar._RI, SRLVar._N, }, {},
			//
			// 口蹄疫/N 非/H 结构蛋白抗体elisa试剂盒/N
			{ SRLVar._N, SRLVar._H, SRLVar._N, }, {},
			//
			// 呼吸机/N 1/M 、/CAnd 呼吸机/N 2/M 、/CAnd 呼吸机/N 3/M
			{ SRLVar._N, SRLVar._M, SRLVar._CAnd, SRLVar._N, SRLVar._M, SRLVar._CAnd, SRLVar._N, SRLVar._M, },
			{ StanRule._宾语1, StanRule._宾语1, StanRule._并列词, StanRule._宾语1, StanRule._宾语1, StanRule._并列词, StanRule._宾语1,
					StanRule._宾语1, },
			//
			// 开始:start/start,START,
			// 连接词:但/c,C,
			// 未知成分:我们/r,N,
			// 未知成分:一/m,M,
			// 未知成分:行人/n,N,
			// 状语D:很/d,DV,
			// 谓语:尽兴/v,V,
			// 结束:end/end,END,
			{ SRLVar._N, SRLVar._M, SRLVar._N, }, {},
			//
			// 附件/N 5/M ．/W 投标人/N 的/U1De 基本/AN 资格要求/N
			{ SRLVar._N, SRLVar._M, SRLVar._WI, SRLVar._N, SRLVar._U1De, SRLVar._AN, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 复印件/N 1份/MQ
			{ SRLVar._N, SRLVar._MQ, }, { StanRule._宾语, StanRule._宾语, },
			//
			// 铁板/N 20个/MQN
			{ SRLVar._N, SRLVar._MQN, }, {},
			//
			{ SRLVar._N, SRLVar._NE, }, {},
			//
			// 王者/N 荣耀/NE 最新/AN 射手/N 排名/V
			{ SRLVar._N, SRLVar._NE, SRLVar._AN, SRLVar._N, }, {},
			//
			// 印度/NE 北部/F 一辆汽车/N 跌入/V 冲沟/V
			{ SRLVar._N, SRLVar._NE, SRLVar._F, SRLVar._N, }, {},
			//
			// 连云港东海董/N 马庄村/NE 大量/M 杨树/N 遭/Bei 无/V 証/un 砍伐/V
			{ SRLVar._N, SRLVar._NE, SRLVar._M, SRLVar._N, }, {},
			//
			// 项目预算金额/N （元）/Q
			{ SRLVar._N, SRLVar._Q, }, {},
			//
			// 每/N 台/Q 价格/N
			{ SRLVar._N, SRLVar._Q, SRLVar._N, }, {},
			//
			// 招标文件每/N 套/Q 售价/N 500元/MQ
			{ SRLVar._N, SRLVar._Q, SRLVar._N, SRLVar._MQ, }, {},
			//
			// 故宫博物院/N 2016年/T 第二批/MQ
			{ SRLVar._N, SRLVar._T, SRLVar._MQ, }, {},
			//
			// 项目/N 所/U 需/AN 的/U1De 下列货物/N
			{ SRLVar._N, SRLVar._U, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 营销推广/N 等/U 多方面/N
			{ SRLVar._N, SRLVar._U, SRLVar._N, }, {},
			//
			// 技术参数要求/N 等/U 方面/N 所/U 需求/AN 的/U1De 文件/N
			{ SRLVar._N, SRLVar._U, SRLVar._N, SRLVar._U, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 您/N 的/U1De 详细/AD 联系方式/N
			{ SRLVar._N, SRLVar._U1De, SRLVar._AD, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._宾语, StanRule._宾语, },
			//
			// 最终用户/N 的/U1De 有效/AN 联系人/N
			{ SRLVar._N, SRLVar._U1De, SRLVar._AN, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._宾语, StanRule._宾语, },
			//
			// 申请/N 的/U1De 最多/AN 标段/N 数/M
			{ SRLVar._N, SRLVar._U1De, SRLVar._AN, SRLVar._N, SRLVar._M, },
			{ StanRule._定语, StanRule._定语, StanRule._宾语, StanRule._宾语, StanRule._宾语, },
			//
			// 报价/N 的/U1De 2%/M
			{ SRLVar._N, SRLVar._U1De, SRLVar._M, }, { StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 反应呼吸机档次高低/N 的/U1De 一个/MQN 重要/AN 指标/N 之/U1De 一/M
			{ SRLVar._N, SRLVar._U1De, SRLVar._MQN, SRLVar._AN, SRLVar._N, SRLVar._U1De, SRLVar._M, },
			{ StanRule._定语, StanRule._定语, StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, },
			//
			// 人生/N 的/U1De 第一个/MQN 100万/M
			{ SRLVar._N, SRLVar._U1De, SRLVar._MQN, SRLVar._M, },
			{ StanRule._定语, StanRule._定语, StanRule._宾语, StanRule._宾语, },
			//
			{ SRLVar._N, SRLVar._U1De, SRLVar._MQN, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._宾语, StanRule._宾语, },
			//
			// 开始:start/start,START,
			// 未知成分:天目湖/ns,镇上/n,N,
			// 未知成分:的/u1de,U1De,
			// 未知成分:物价/n,N,
			// 未知成分:和/cand,CAnd,
			// 未知成分:酒店/ncs,N,
			// 状语D:真/a,DV,
			// 主谓语:不是/v,VZ,
			// 未知成分:一般/a,A,
			// 未知成分:的/u1de,U1De,
			// 谓语:贵/a,AV,
			// 结束:end/end,END,
			{ SRLVar._N, SRLVar._U1De, SRLVar._N, SRLVar._CAnd, SRLVar._N, }, {},
			//
			// 深入/A 挖掘/V 马克思主义/N 的/U1De 当代/T 价值(新书评介)/N
			{ SRLVar._N, SRLVar._U1De, SRLVar._T, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._宾语, StanRule._宾语, },
			/**
			 * NE
			 */
			//
			{ SRLVar._NE, }, {},
			//
			// 恒大/NT 最强/A 2/M 外援/N 未能/V 上场/V
			{ SRLVar._NE, SRLVar._A, SRLVar._M, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 成/V 了/VEnd 重庆/NE 最美/A 古镇/NE
			{ SRLVar._NE, SRLVar._A, SRLVar._NE, }, { StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 揭秘/V 中国/NE "最深"/A 地下/S 金库/N
			{ SRLVar._NE, SRLVar._A, SRLVar._S, SRLVar._N, }, {},
			//
			// 平安/NE 好/AN 医生/N 正式/DV 登陆/V 港交所/N
			{ SRLVar._NE, SRLVar._AN, SRLVar._N, }, {},
			//
			// 山东半岛/NS 众/ag 景区/N “抱团”/V 邀/V 湖南/NS 客/N
			{ SRLVar._NE, SRLVar._AG, SRLVar._N, }, {},
			//
			// 印度/NE 北部/F 强风暴雨/N 造成/VZ 至少/D 97/M 人/N 遇难/VJ
			{ SRLVar._NE, SRLVar._F, SRLVar._N, }, {},
			//
			// 非洲/NE 第三/M 大/AN 牧牛国/N
			{ SRLVar._NE, SRLVar._M, SRLVar._AN, SRLVar._N, }, {},
			//
			// 河南/N 9/M 单位/N 荣膺/V 2017年/TDV 度/V 全国青年/N 安全/AN 生产示范岗/N
			//
			{ SRLVar._NE, SRLVar._M, SRLVar._N, }, {},
			//
			// 巴西/NE 19岁/MQ 新星/NE 嫌弃/V 中超/N
			{ SRLVar._NE, SRLVar._MQ, SRLVar._NE, }, {},
			//
			// 信阳/NE 一名/MQN 重症患儿/N 急需/V 转院/V
			{ SRLVar._NE, SRLVar._MQN, SRLVar._N, }, {},
			//
			// 江苏/NE 这个/R 县营商环境评价一年/N 跃升/V 90位/MQ
			{ SRLVar._NE, SRLVar._R, SRLVar._N, }, {},
			//
			// 龙兴/NE 岛上/S 空气/N 很/ADV 好/AV
			{ SRLVar._NE, SRLVar._N, SRLVar._N, }, {},
			/**
			 * P
			 */
			//
			// 在/P 以上/F 网站/N 上/F
			{ SRLVar._P, SRLVar._F, SRLVar._N, SRLVar._F, },
			{ StanRule._状语P, StanRule._状语P, StanRule._状语P, StanRule._状语P, },
			//
			// 按/P 规定/PD
			{ SRLVar._P, SRLVar._PD, }, { StanRule._状语P, StanRule._状语P, },
			/**
			 * Q
			 */
			//
			{ SRLVar._Q, SRLVar._N, }, {},
			//
			{ SRLVar._QN, SRLVar._N, }, {},
			/**
			 * R
			 */
			//
			{ SRLVar._R, }, {},
			//
			{ SRLVar._RI, }, {},
			//
			{ SRLVar._RIA, }, {},
			//
			// 这些/R 专业/AN 的/U1De 大学生/N 要/V 被/Bei 国家/N “拔尖”/A 培养/V
			//
			{ SRLVar._R, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 看/VZ 这/R 几个/M 配置/N
			{ SRLVar._R, SRLVar._M, SRLVar._N, }, {},
			//
			{ SRLVar._R, SRLVar._MQ, }, {},
			//
			{ SRLVar._R, SRLVar._MQN, }, {},
			//
			{ SRLVar._R, SRLVar._N, }, {},
			//
			{ SRLVar._R, SRLVar._U1De, SRLVar._N, }, { StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 临沂人/N 赶紧/DV 定格住/V 你/R 的/U1De 青春/NE
			{ SRLVar._R, SRLVar._U1De, SRLVar._NE, }, { StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 这场/RQ 春天的/AN 会议/N 影响/V 了/VEnd 40年/T
			{ SRLVar._RQ, SRLVar._AN, SRLVar._N, }, { StanRule._定语, StanRule._定语, StanRule._宾语, },
			/**
			 * S
			 */
			//
			{ SRLVar._S, }, {},
			//
			// 国内/S 合格/AN 的/U1De 投标人/N
			{ SRLVar._S, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 网上/S 电子政府采购/N
			{ SRLVar._S, SRLVar._N, }, {},
			//
			// 赞/V 当地/S 声音/N 好听/AN 的/U1De 导游小哥/N
			{ SRLVar._S, SRLVar._N, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 国内/S 首个/MQN 5G电话/N 拨通/V
			{ SRLVar._S, SRLVar._MQN, SRLVar._N, }, {},
			//
			{ SRLVar._S, SRLVar._U1De, SRLVar._N, }, { StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 岛上/s 高山/ns 居然/d 还有/v 自动扶梯/ncp 免去/v 登山/v 的/u1de 辛苦/a
			{ SRLVar.START, SRLVar._S, SRLVar._NE, }, { StanRule.开始, StanRule._定语, StanRule._宾语, },
			/**
			 * T
			 */
			//
			// 全天/T 幸运/AN 飞艇计划网站/N
			{ SRLVar._T, SRLVar._AN, SRLVar._N, }, { StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 考古学家/N 发现/VZ 4000年/T 前/F 饭盒/N
			{ SRLVar._T, SRLVar._F, SRLVar._N, }, { StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 致/V 今日/T 武汉多趟列车/N 停运/V 或/C 晚点/VZ 折返/VJ
			{ SRLVar._T, SRLVar._N, }, { StanRule._状语T, StanRule._宾语, },
			//
			// 2018年/T 监理工程师《合同管理》/N 合同履行中/AN 的/U1De 抗辩权/N
			{ SRLVar._T, SRLVar._N, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._状语T, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 5年/tl 或/C 以上/F 的/U1De 技术支持/N
			{ SRLVar._TL, SRLVar._C, SRLVar._F, SRLVar._U1De, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 5年/tl 或/C 以上/F 的/U1De 技术支持/N
			{ SRLVar._TL, SRLVar._F, }, { StanRule._状语T, StanRule._状语T, },
			/**
			 * U
			 */
			//
			// 所/U 配置/AN 的/U1De 软件产品/N
			{ SRLVar._U, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, },
			//
			// 等/U 与/CAnd 之/U1De 相关内容/N
			{ SRLVar._U, SRLVar._CAnd, SRLVar._U1De, SRLVar._N, }, {},
			//
			{ SRLVar._U, SRLVar._N, }, {},

			//////////

			//
			// 景观工程(景观工程)/N_LCAnd_RCAnd 、/CAnd 芒洲/N 北/F 次/Q 干路景观工程/N ；/W
			{ StanRule._宾语 + "/" + SRLVar._N_LCAnd_RCAnd, SRLVar._CAnd, SRLVar._N, SRLVar._F, SRLVar._Q, SRLVar._N, },
			{ StanRule._并列词, StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, },
			//
			// 税务登记证/N_LCAnd_RCAnd 、/CAnd 组织机构代码证三证/N 齐全/AN 的/U1De 法人/N 或/CAnd
			// 三证/N 齐全/AN 的/U1De 其他组织/N
			{ StanRule._宾语 + "/" + SRLVar._N_LCAnd_RCAnd, SRLVar._CAnd, SRLVar._N, SRLVar._AN, SRLVar._U1De, SRLVar._N,
					SRLVar._CAnd, SRLVar._N, SRLVar._AN, SRLVar._U1De, SRLVar._N, },
			{ StanRule._并列词, StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语,
					StanRule._宾语, StanRule._宾语, StanRule._宾语, },
			//
			// 2018年/T 广州王府井燃气报警系统/N
			{ SRLVar.START, SRLVar._T, SRLVar._N, }, { StanRule.开始, StanRule._状语T, StanRule._宾语, },
			//
			// 或/C 互为母公司/N 、/CAnd 子公司/N_LCAnd_RCAnd
			{ SRLVar._C, SRLVar._N, SRLVar._CAnd, StanRule._宾语 + "/" + SRLVar._N_LCAnd_RCAnd, },
			{ StanRule._连接词, StanRule._宾语, StanRule._并列词, },
			//
			// 北/F 片区防洪/N 及/CAnd 景观工程(景观工程)/N_LCAnd_RCAnd
			{ SRLVar._F, SRLVar._N, SRLVar._CAnd, StanRule._宾语 + "/" + SRLVar._N_LCAnd_RCAnd, },
			{ StanRule._宾语, StanRule._宾语, StanRule._并列词, },
			//
			// 系统24小时/N 的/U1De 正常/AN 监视/N 和/CAnd 30分钟的报警/N_LCAnd_RCAnd
			{ SRLVar._N, SRLVar._U1De, SRLVar._AN, SRLVar._N, SRLVar._CAnd,
					StanRule._宾语 + "/" + SRLVar._N_LCAnd_RCAnd, },
			{ StanRule._定语, StanRule._定语, StanRule._宾语, StanRule._宾语, StanRule._并列词, },
			//
			// 消防报警系统主机/N 等/U
			{ SRLVar._N, SRLVar._U, SRLVar.END, }, { StanRule._宾语, StanRule._宾语, StanRule.结束, },
			/**
			 * _
			 */
			// 能/v 给/p 国内/s 视频/n 产业/n 什么/rin_ria 启示/vn
			{ SRLVar._N, SRLVar._rin_ria, SRLVar._N, }, { StanRule._宾语, StanRule._宾语2, StanRule._宾语2, },
			//
			//
			//////////
	};

	//
	public static Object[][] regex_rules = {
			//
			// 周琦第2次/N 打/V 季后赛/N
			{ SRLVar.START, SRLVar._N, SRLVar._MQ, SRLVar._V }, { 0, 1, 2, 0, },
			{ StanRule.开始, StanRule._宾语, StanRule._状语, StanRule._谓语, },
			//
			// 35岁/MQ 成/V 了/VEnd 封疆大吏/N
			{ SRLVar.START, SRLVar._MQ, SRLVar._V }, { 0, 1, 0 }, { StanRule.开始, StanRule._宾语, StanRule._谓语, },
			//
			// 长/AN 翅膀/N 的/U1De “老鼠”/N 飞入/V 鸟友镜头/N
			{ SRLVar._CAnd, SRLVar._AN, SRLVar._N, SRLVar._U1De, SRLVar._N, SRLVar.START }, { -1, 1, 2, 3, 4, -1 },
			{ "", StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, "", },
			//
			// 68岁/MQ 老/AN 木匠/N 的/U1De 担忧/N
			{ SRLVar._CAnd, SRLVar._MQ, SRLVar._AN, SRLVar._N, SRLVar._U1De, SRLVar._N, SRLVar.START },
			{ -1, 1, 2, 3, 4, 5, -1 },
			{ "", StanRule._定语, StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, "", },
			//
			// 一家/MQ 有效/AN 的/U1De 代理商/N
			{ SRLVar._CAnd, SRLVar._MQ, SRLVar._AN, SRLVar._U1De, SRLVar._N, SRLVar.START }, { -1, 1, 2, 3, 4, -1 },
			{ "", StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, "", },
			//
			// 品学兼优/N 、/CAnd 长相/N 甜美/A 的/U1De 她/R
			{ SRLVar._CAnd, SRLVar._N, SRLVar._A, SRLVar._U1De, SRLVar._R, SRLVar.START }, { -1, 1, 2, 3, 4, -1 },
			{ "", StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, "", },
			//
			// 英国伯恩茅斯/N 大学/NE 的/U1De “博学节”/N 办到/V 杭州/NE 啦/Y
			{ SRLVar._CAnd, SRLVar._N, SRLVar._NE, SRLVar._U1De, SRLVar._N, SRLVar.START }, { -1, 1, 2, 3, 4, -1 },
			{ "", StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, "", },
			// 关乎/V 角色/N 自身/R 的/U1De 战力/N
			{ SRLVar._CAnd, SRLVar._N, SRLVar._R, SRLVar._U1De, SRLVar._N, SRLVar.START }, { -1, 1, 2, 3, 4, -1 },
			{ "", StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, "", },
			//
			// 他/R 却/DV 沉迷/V 于/VEnd 女人/N 的/U1De 体香/N
			{ SRLVar._CAnd, SRLVar._N, SRLVar._U1De, SRLVar._N, SRLVar.START }, { -1, 1, 2, 3, -1 },
			{ "", StanRule._定语, StanRule._定语, StanRule._宾语, "", },
			{ SRLVar._CAnd, SRLVar._N, SRLVar._U1De, SRLVar._NE, SRLVar.START }, { -1, 1, 2, 3, -1 },
			{ "", StanRule._定语, StanRule._定语, StanRule._宾语, "", },
			//
			// 走/V 好/VEnd 科技攻关/N 的/U1De 自强/N 之/U1De 路/N
			{ SRLVar._CAnd, SRLVar._N, SRLVar._U1De, SRLVar._N, SRLVar._U1De, SRLVar._N, SRLVar.START },
			{ -1, 1, 2, 3, 4, 5, -1 },
			{ "", StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, StanRule._宾语, "", },
			//
			// 胳膊/N 没/DV 伸直/V 就/DV 能/VZ 摸/V 到/V 隔壁楼/NE 的/U1De 墙/N
			{ SRLVar._CAnd, SRLVar._NE, SRLVar._U1De, SRLVar._N, SRLVar.START }, { -1, 1, 2, 3, -1 },
			{ "", StanRule._定语, StanRule._定语, StanRule._宾语, "", },
			//
			// 担忧/V 一个/MQN 产业/N 的/U1De 衰颓/N
			{ SRLVar._CAnd, SRLVar._MQN, SRLVar._N, SRLVar._U1De, SRLVar._AN, SRLVar._N, SRLVar.START },
			{ -1, 1, 2, 3, 4, 5, -1 },
			{ "", StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, StanRule._宾语, "", },
			//
			// 一切/R 开始/N 的/U1De 地方/N
			{ SRLVar._CAnd, SRLVar._R, SRLVar._N, SRLVar._U1De, SRLVar._N, SRLVar.START }, { -1, 1, 2, 3, 4, -1 },
			{ "", StanRule._定语, StanRule._定语, StanRule._定语, StanRule._宾语, "", },
			//
			// 看/VZ 完/V 他/R 的/U1De 2018/M 个人计划/N
			{ SRLVar._CAnd, SRLVar._R, SRLVar._U1De, SRLVar._M, SRLVar._N, SRLVar.START }, { -1, 1, 2, 3, 4, -1 },
			{ "", StanRule._定语, StanRule._定语, StanRule._宾语, StanRule._宾语, "", },
			//
			// 垂钓/V 触碰/V 高压线电击/N 身亡/V 谁/RI 之/U1De 责/N
			{ SRLVar._CAnd, SRLVar._RI, SRLVar._U1De, SRLVar._N, SRLVar.START }, { -1, 1, 2, 3, -1 },
			{ "", StanRule._定语, StanRule._定语, StanRule._宾语, "", },
			//
			// 致/V 今日/T 武汉多趟列车/N 停运/V 或/C 晚点/VZ 折返/VJ
			{ SRLVar._V, SRLVar._C, SRLVar._VZ }, { 0, 1, 0 }, { StanRule._谓语, StanRule._连接词, StanRule._谓语, },
			//
			// 粮油作物机耕率/N 超/V 90%/M
			{ SRLVar._V, SRLVar._M, SRLVar.END }, { 0, 1, 0 }, { StanRule._谓语, StanRule._宾语, StanRule.结束, },
			//
			// 深夜/T 南北/F 高架越野车/N 折返/V 18次/MQ
			{ SRLVar._V, SRLVar._MQ, SRLVar.END }, { 0, 1, 0 }, { StanRule._谓语, StanRule._谓语补语, StanRule.结束, },
			//
			// 我/R 省430万台农机/N 备战/V 三秋/T
			{ SRLVar._V, SRLVar._T, SRLVar.END }, { 0, 1, 0 }, { StanRule._谓语, StanRule._谓语补语, StanRule.结束, },
			//
			// 免试/VJ 延聘/VZ 两年/T
			{ SRLVar._VZ, SRLVar._T, SRLVar.END }, { 0, 1, 0 }, { StanRule._主谓语, StanRule._谓语补语, StanRule.结束, },

			//////////
	};

}

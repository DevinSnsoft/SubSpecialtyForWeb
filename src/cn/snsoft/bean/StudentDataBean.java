package cn.snsoft.bean;


/**
 * 
 * @copyright ：神农大学生软件创新中心 版权所有 (c) 2016
 * 
 * @author Mr. Soldier
 * 
 * @version 1.0
 * 
 * @date 2016年7月9日 下午2:30:45
 * 
 * @Description TODO
 *	学生的个人详细信息
 */
public class StudentDataBean {
	private String password;	//密码
	private String studentId;	//学号
	private String name;		//姓名
	private String pingyin;		//姓名拼音
	private String englishName;//英文姓名
	private String usedName;	//曾用名
	private String IdNumber;	//身份证号
	private String sex;			//性别
	private String type;		//学生类别
	private String specialType;//特殊学生类型
	private String state;		//学籍状态
	private String shouFeiLeiXing;//收费类别
	private String minZu;		//民族
	private String jiGuan;		//籍贯
	private String birthday;	//出生日期
	private String zhengZhiMianMao; //政治面貌
	private String kaoQu;		//考区
	private String biYeZhongXue; //毕业中学
	private String gaoKaoZongFen; //高考总分
	private String luQuHao;       //录取号
	private String kaoShengHao;    //高考考生号
	private String yuZhong;			//入学考试语种
	private String address;			//通讯地址
	private String youBian;			//邮编
	private String jiaZhangXinXi;	//家长信息
	private String ruXueRiQi;		//入学日期
	private String xiSuo;			//系所
	private String zhuanYe;			//专业
	private String zhuanYeFangXiang;//专业方向
	private String nianJi;		//年级
	private String banJi;		//班级
	private String shiFouYouXueJi;	//是否有学籍
	private String shiFouYouGuoJiaXueJi; //是否有国家学籍
	private String xiaoQu;     //校区
	private String yiDongFou;	//异动否
	private String waiYuYuZhong; //外语语种
	private String suSheDiZhi;		//宿舍地址
	private String yinCaiShiJiao;   //因材施教
	private String peiYangCengCi;	//培养层次
	private String peiYangFangShi;	//培养方式
	private String fenLiuFangXiang;	//分流方向
	private String shiFouLiXiao;	//是否离校
	private String beiZhu;			//备注
	private String beiZhu1;			//备注1
	private String beiZhu2;			//备注2
	private String beiZhu3;			//备注3
	
	public StudentDataBean(){
		
	}
	
	public StudentDataBean(String studentId, String name, String pingyin,
			String englishName, String usedName, String idNumber, String sex,
			String type, String specialType, String state,
			String shouFeiLeiXing, String minZu, String jiGuan,
			String birthday, String zhengZhiMianMao, String kaoQu,
			String biYeZhongXue, String gaoKaoZongFen, String luQuHao,
			String kaoShengHao, String yuZhong, String address, String youBian,
			String jiaZhangXinXi, String ruXueRiQi, String xiSuo,
			String zhuanYe, String zhuanYeFangXiang, String nianJi,
			String banJi, String shiFouYouXueJi, String shiFouYouGuoJiaXueJi,
			String xiaoQu, String yiDongFou, String waiYuYuZhong,
			String suSheDiZhi, String yinCaiShiJiao, String peiYangCengCi,
			String peiYangFangShi, String fenLiuFangXiang, String shiFouLiXiao,
			String beiZhu, String beiZhu1, String beiZhu2, String beiZhu3) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.pingyin = pingyin;
		this.englishName = englishName;
		this.usedName = usedName;
		this.IdNumber = idNumber;
		this.sex = sex;
		this.type = type;
		this.specialType = specialType;
		this.state = state;
		this.shouFeiLeiXing = shouFeiLeiXing;
		this.minZu = minZu;
		this.jiGuan = jiGuan;
		this.birthday = birthday;
		this.zhengZhiMianMao = zhengZhiMianMao;
		this.kaoQu = kaoQu;
		this.biYeZhongXue = biYeZhongXue;
		this.gaoKaoZongFen = gaoKaoZongFen;
		this.luQuHao = luQuHao;
		this.kaoShengHao = kaoShengHao;
		this.yuZhong = yuZhong;
		this.address = address;
		this.youBian = youBian;
		this.jiaZhangXinXi = jiaZhangXinXi;
		this.ruXueRiQi = ruXueRiQi;
		this.xiSuo = xiSuo;
		this.zhuanYe = zhuanYe;
		this.zhuanYeFangXiang = zhuanYeFangXiang;
		this.nianJi = nianJi;
		this.banJi = banJi;
		this.shiFouYouXueJi = shiFouYouXueJi;
		this.shiFouYouGuoJiaXueJi = shiFouYouGuoJiaXueJi;
		this.xiaoQu = xiaoQu;
		this.yiDongFou = yiDongFou;
		this.waiYuYuZhong = waiYuYuZhong;
		this.suSheDiZhi = suSheDiZhi;
		this.yinCaiShiJiao = yinCaiShiJiao;
		this.peiYangCengCi = peiYangCengCi;
		this.peiYangFangShi = peiYangFangShi;
		this.fenLiuFangXiang = fenLiuFangXiang;
		this.shiFouLiXiao = shiFouLiXiao;
		this.beiZhu = beiZhu;
		this.beiZhu1 = beiZhu1;
		this.beiZhu2 = beiZhu2;
		this.beiZhu3 = beiZhu3;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPingyin() {
		return pingyin;
	}
	public void setPingyin(String pingyin) {
		this.pingyin = pingyin;
	}
	
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	
	
	public String getUsedName() {
		return usedName;
	}
	public void setUsedName(String usedName) {
		this.usedName = usedName;
	}
	
	
	public String getIdNumber() {
		return IdNumber;
	}
	public void setIdNumber(String idNumber) {
		IdNumber = idNumber;
	}
	
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getSpecialType() {
		return specialType;
	}
	public void setSpecialType(String specialType) {
		this.specialType = specialType;
	}
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	public String getShouFeiLeiXing() {
		return shouFeiLeiXing;
	}
	public void setShouFeiLeiXing(String shouFeiLeiXing) {
		this.shouFeiLeiXing = shouFeiLeiXing;
	}
	
	
	public String getMinZu() {
		return minZu;
	}
	public void setMinZu(String minZu) {
		this.minZu = minZu;
	}
	
	
	public String getJiGuan() {
		return jiGuan;
	}
	public void setJiGuan(String jiGuan) {
		this.jiGuan =jiGuan;
	}
	
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
	public String getZhengZhiMianMao() {
		return zhengZhiMianMao;
	}
	public void setZhengZhiMianMao(String zhengZhiMianMao) {
		this.zhengZhiMianMao = zhengZhiMianMao;
	}
	
	
	public String getKaoQu() {
		return kaoQu;
	}
	public void setKaoQu(String kaoQu) {
		this.kaoQu = kaoQu;
	}
	
	
	public String getBiYeZhongXue() {
		return biYeZhongXue;
	}
	public void setBiYeZhongXue(String biYeZhongXue) {
		this.biYeZhongXue = biYeZhongXue;
	}
	
	
	public String getGaoKaoZongFen() {
		return gaoKaoZongFen;
	}
	public void setGaoKaoZongFen(String gaoKaoZongFen) {
		this.gaoKaoZongFen = gaoKaoZongFen;
	}
	
	
	public String getLuQuHao() {
		return luQuHao;
	}
	public void setLuQuHao(String luQuHao) {
		this.luQuHao = luQuHao;
	}
	
	
	public String getKaoShengHao() {
		return kaoShengHao;
	}
	public void setKaoShengHao(String kaoShengHao) {
		this.kaoShengHao = kaoShengHao;
	}
	
	
	public String getYuZhong() {
		return yuZhong;
	}
	public void setYuZhong(String yuZhong) {
		this.yuZhong = yuZhong;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getYouBian() {
		return youBian;
	}
	public void setYouBian(String youBian) {
		this.youBian = youBian;
	}
	
	
	public String getJiaZhangXinXi() {
		return jiaZhangXinXi;
	}
	public void setJiaZhangXinXi(String jiaZhangXinXi) {
		this.jiaZhangXinXi = jiaZhangXinXi;
	}
	
	
	public String getRuXueRiQi() {
		return ruXueRiQi;
	}
	public void setRuXueRiQi(String ruXueRiQi) {
		this.ruXueRiQi = ruXueRiQi;
	}
	public String getXiSuo() {
		return xiSuo;
	}
	public void setXiSuo(String xiSuo) {
		this.xiSuo = xiSuo;
	}
	
	
	public String getZhuanYe() {
		return zhuanYe;
	}
	public void setZhuanYe(String zhuanYe) {
		this.zhuanYe = zhuanYe;
	}
	
	
	public String getZhuanYeFangXiang() {
		return zhuanYeFangXiang;
	}
	public void setZhuanYeFangXiang(String zhuanYeFangXiang) {
		this.zhuanYeFangXiang = zhuanYeFangXiang;
	}
	
	
	public String getNianJi() {
		return nianJi;
	}
	public void setNianJi(String nianJi) {
		this.nianJi = nianJi;
	}
	
	
	public String getBanJi() {
		return banJi;
	}
	public void setBanJi(String banJi) {
		this.banJi = banJi;
	}
	
	
	public String getShiFouYouXueJi() {
		return shiFouYouXueJi;
	}
	public void setShiFouYouXueJi(String shiFouYouXueJi) {
		this.shiFouYouXueJi = shiFouYouXueJi;
	}
	
	
	public String getShiFouYouGuoJiaXueJi() {
		return shiFouYouGuoJiaXueJi;
	}
	public void setShiFouYouGuoJiaXueJi(String shiFouYouGuoJiaXueJi) {
		this.shiFouYouGuoJiaXueJi = shiFouYouGuoJiaXueJi;
	}
	
	
	public String getXiaoQu() {
		return xiaoQu;
	}
	public void setXiaoQu(String xiaoQu) {
		this.xiaoQu = xiaoQu;
	}
	
	
	public String getYiDongFou() {
		return yiDongFou;
	}
	public void setYiDongFou(String yiDongFou) {
		this.yiDongFou = yiDongFou;
	}
	
	
	public String getWaiYuYuZhong() {
		return waiYuYuZhong;
	}
	public void setWaiYuYuZhong(String waiYuYuZhong) {
		this.waiYuYuZhong = waiYuYuZhong;
	}
	
	
	public String getSuSheDiZhi() {
		return suSheDiZhi;
	}
	public void setSuSheDiZhi(String suSheDiZhi) {
		this.suSheDiZhi = suSheDiZhi;
	}
	
	
	public String getYinCaiShiJiao() {
		return yinCaiShiJiao;
	}
	public void setYinCaiShiJiao(String yinCaiShiJiao) {
		this.yinCaiShiJiao = yinCaiShiJiao;
	}
	
	
	public String getPeiYangCengCi() {
		return peiYangCengCi;
	}
	public void setPeiYangCengCi(String peiYangCengCi) {
		this.peiYangCengCi = peiYangCengCi;
	}
	
	
	public String getPeiYangFangShi() {
		return peiYangFangShi;
	}
	public void setPeiYangFangShi(String peiYangFangShi) {
		this.peiYangFangShi = peiYangFangShi;
	}
	
	
	public String getFenLiuFangXiang() {
		return fenLiuFangXiang;
	}
	public void setFenLiuFangXiang(String fenLiuFangXiang) {
		this.fenLiuFangXiang = fenLiuFangXiang;
	}
	
	
	public String getShiFouLiXiao() {
		return shiFouLiXiao;
	}
	public void setShiFouLiXiao(String shiFouLiXiao) {
		this.shiFouLiXiao = shiFouLiXiao;
	}
	
	
	public String getBeiZhu() {
		return beiZhu;
	}
	public void setBeiZhu(String beiZhu) {
		this.beiZhu = beiZhu;
	}
	
	
	public String getBeiZhu1() {
		return beiZhu1;
	}
	public void setBeiZhu1(String beiZhu1) {
		this.beiZhu1 = beiZhu1;
	}
	
	
	public String getBeiZhu2() {
		return beiZhu2;
	}
	public void setBeiZhu2(String beiZhu2) {
		this.beiZhu2 = beiZhu2;
	}
	
	
	public String getBeiZhu3() {
		return beiZhu3;
	}
	public void setBeiZhu3(String beiZhu3) {
		this.beiZhu3 = beiZhu3;
	}
	
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}

	@Override
	public String toString() {
		return "StudentDataBean [password=" + password + ", studentId="
				+ studentId + ", name=" + name + ", pingyin=" + pingyin
				+ ", englishName=" + englishName + ", usedName=" + usedName
				+ ", IdNumber=" + IdNumber + ", sex=" + sex + ", type=" + type
				+ ", specialType=" + specialType + ", state=" + state
				+ ", shouFeiLeiXing=" + shouFeiLeiXing + ", minZu=" + minZu
				+ ", jiGuan=" + jiGuan + ", birthday=" + birthday
				+ ", zhengZhiMianMao=" + zhengZhiMianMao + ", kaoQu=" + kaoQu
				+ ", biYeZhongXue=" + biYeZhongXue + ", gaoKaoZongFen="
				+ gaoKaoZongFen + ", luQuHao=" + luQuHao + ", kaoShengHao="
				+ kaoShengHao + ", yuZhong=" + yuZhong + ", address=" + address
				+ ", youBian=" + youBian + ", jiaZhangXinXi=" + jiaZhangXinXi
				+ ", ruXueRiQi=" + ruXueRiQi + ", xiSuo=" + xiSuo
				+ ", zhuanYe=" + zhuanYe + ", zhuanYeFangXiang="
				+ zhuanYeFangXiang + ", nianJi=" + nianJi + ", banJi=" + banJi
				+ ", shiFouYouXueJi=" + shiFouYouXueJi
				+ ", shiFouYouGuoJiaXueJi=" + shiFouYouGuoJiaXueJi
				+ ", xiaoQu=" + xiaoQu + ", yiDongFou=" + yiDongFou
				+ ", waiYuYuZhong=" + waiYuYuZhong + ", suSheDiZhi="
				+ suSheDiZhi + ", yinCaiShiJiao=" + yinCaiShiJiao
				+ ", peiYangCengCi=" + peiYangCengCi + ", peiYangFangShi="
				+ peiYangFangShi + ", fenLiuFangXiang=" + fenLiuFangXiang
				+ ", shiFouLiXiao=" + shiFouLiXiao + ", beiZhu=" + beiZhu
				+ ", beiZhu1=" + beiZhu1 + ", beiZhu2=" + beiZhu2
				+ ", beiZhu3=" + beiZhu3 + "]";
	}
}

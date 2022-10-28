package com.epaper;

public class Epaper_Bean {
	int qno;
	String qname;
	String opt1;
	String opt2;
	String opt3;
	String opt4;
	String ans;
	public Epaper_Bean() {
		System.out.println("default constructor");
	}
	public Epaper_Bean(String qname, String opt1, String opt2, String opt3, String opt4, String ans) {
		super();
		this.qno = qno;
		this.qname = qname;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.ans = ans;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public String getOpt1() {
		return opt1;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	public String getOpt2() {
		return opt2;
	}

	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}

	public String getOpt3() {
		return opt3;
	}

	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}

	public String getOpt4() {
		return opt4;
	}

	@Override
	public String toString() {
		return "Epaper_Bean [qno=" + qno + ", qname=" + qname + ", opt1=" + opt1 + ", opt2=" + opt2 + ", opt3=" + opt3
				+ ", opt4=" + opt4 + ", ans=" + ans + "]";
	}

	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}
	
	
}

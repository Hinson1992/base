package com.sxt.pojo;

public class StockInfo {
	private String id;
	private String spname;
	private String cd;
	private String dw;
	private String gg;
	private String bz;
	private String memo;
	private String gysname;
	private String ph;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getGg() {
		return gg;
	}
	public void setGg(String gg) {
		this.gg = gg;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getGysname() {
		return gysname;
	}
	public void setGysname(String gysname) {
		this.gysname = gysname;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bz == null) ? 0 : bz.hashCode());
		result = prime * result + ((cd == null) ? 0 : cd.hashCode());
		result = prime * result + ((dw == null) ? 0 : dw.hashCode());
		result = prime * result + ((gg == null) ? 0 : gg.hashCode());
		result = prime * result + ((gysname == null) ? 0 : gysname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((memo == null) ? 0 : memo.hashCode());
		result = prime * result + ((ph == null) ? 0 : ph.hashCode());
		result = prime * result + ((spname == null) ? 0 : spname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockInfo other = (StockInfo) obj;
		if (bz == null) {
			if (other.bz != null)
				return false;
		} else if (!bz.equals(other.bz))
			return false;
		if (cd == null) {
			if (other.cd != null)
				return false;
		} else if (!cd.equals(other.cd))
			return false;
		if (dw == null) {
			if (other.dw != null)
				return false;
		} else if (!dw.equals(other.dw))
			return false;
		if (gg == null) {
			if (other.gg != null)
				return false;
		} else if (!gg.equals(other.gg))
			return false;
		if (gysname == null) {
			if (other.gysname != null)
				return false;
		} else if (!gysname.equals(other.gysname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (memo == null) {
			if (other.memo != null)
				return false;
		} else if (!memo.equals(other.memo))
			return false;
		if (ph == null) {
			if (other.ph != null)
				return false;
		} else if (!ph.equals(other.ph))
			return false;
		if (spname == null) {
			if (other.spname != null)
				return false;
		} else if (!spname.equals(other.spname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StockInfo [id=" + id + ", spname=" + spname + ", cd=" + cd
				+ ", dw=" + dw + ", gg=" + gg + ", bz=" + bz + ", memo=" + memo
				+ ", gysname=" + gysname + ", ph=" + ph + "]";
	}

	
}

package com.sxt.pojo;

public class KcInfo {
private String id;
private String name;
private String cd;
private String dw;
private String gg;
private String bz;
private String dj;
private String sl;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public String getDj() {
	return dj;
}
public void setDj(String dj) {
	this.dj = dj;
}
public String getSl() {
	return sl;
}
public void setSl(String sl) {
	this.sl = sl;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((bz == null) ? 0 : bz.hashCode());
	result = prime * result + ((cd == null) ? 0 : cd.hashCode());
	result = prime * result + ((dj == null) ? 0 : dj.hashCode());
	result = prime * result + ((dw == null) ? 0 : dw.hashCode());
	result = prime * result + ((gg == null) ? 0 : gg.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((sl == null) ? 0 : sl.hashCode());
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
	KcInfo other = (KcInfo) obj;
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
	if (dj == null) {
		if (other.dj != null)
			return false;
	} else if (!dj.equals(other.dj))
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
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (sl == null) {
		if (other.sl != null)
			return false;
	} else if (!sl.equals(other.sl))
		return false;
	return true;
}
@Override
public String toString() {
	return "KcInfo [id=" + id + ", name=" + name + ", cd=" + cd + ", dw=" + dw
			+ ", gg=" + gg + ", bz=" + bz + ", dj=" + dj + ", sl=" + sl + "]";
}



}

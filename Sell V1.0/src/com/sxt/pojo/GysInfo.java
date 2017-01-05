package com.sxt.pojo;

public class GysInfo {
	private String id;
	private String name;
	private String dz;
	private String tel;
	private String lxr;
	private String yhzh;
	private String yb;
	private String email;
	private String bz;
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
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public String getYhzh() {
		return yhzh;
	}
	public void setYhzh(String yhzh) {
		this.yhzh = yhzh;
	}
	public String getYb() {
		return yb;
	}
	public void setYb(String yb) {
		this.yb = yb;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bz == null) ? 0 : bz.hashCode());
		result = prime * result + ((dz == null) ? 0 : dz.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lxr == null) ? 0 : lxr.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((yb == null) ? 0 : yb.hashCode());
		result = prime * result + ((yhzh == null) ? 0 : yhzh.hashCode());
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
		GysInfo other = (GysInfo) obj;
		if (bz == null) {
			if (other.bz != null)
				return false;
		} else if (!bz.equals(other.bz))
			return false;
		if (dz == null) {
			if (other.dz != null)
				return false;
		} else if (!dz.equals(other.dz))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lxr == null) {
			if (other.lxr != null)
				return false;
		} else if (!lxr.equals(other.lxr))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (yb == null) {
			if (other.yb != null)
				return false;
		} else if (!yb.equals(other.yb))
			return false;
		if (yhzh == null) {
			if (other.yhzh != null)
				return false;
		} else if (!yhzh.equals(other.yhzh))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GysInfo [id=" + id + ", name=" + name + ", dz=" + dz
				+ ", tel=" + tel + ", lxr=" + lxr + ", yhzh=" + yhzh + ", yb="
				+ yb + ", email=" + email + ", bz=" + bz + "]";
	}
	
}

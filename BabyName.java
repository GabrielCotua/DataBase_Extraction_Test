
public class BabyNames {
	String uuid;
	String ID;
	String nm;
	String gndr;
	int cnt;
	int rnk;
	int brth_yr;
	public BabyNames( String uuid, String ID, String nm, int cnt, int rnk, String gndr, int brth_yr) {
		this.uuid = uuid;
		this.ID = ID;
		this.nm = nm;
		this.cnt = cnt;
		this.rnk = rnk;
		this.gndr = gndr;
		this.brth_yr = brth_yr;
		
	}
public String getUuid() {
		return uuid;
	}
public String getId() {
		return ID;
	}
public String getNm() {
		return nm;
	}
public int getCnt() {
		return cnt;
	}
public int getRnk() {
		return rnk;
	}
public int getBrth_yr() {
		return brth_yr;
	}
public String getGndr() {
		return gndr;
	}

}

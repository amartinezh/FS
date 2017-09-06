package domain.fs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(ConbsmlPK.class)
@Table(name = "conbsml", schema = "fs")
public class Conbsml {
	
	//private static final long serialVersionUID = -9068113467850707780L;
	
	@Id
	@Column(name = "ccia")
	private String ccia; 
	
	@Id
	@Column(name = "cline")
	private String cline; 
	
	@Column(name = "cdesc")
	private String cdesc; 
	
	@Id
	@Column(name = "cyear")
	private String cyear; 
	
	@Id
	@Column(name = "cpers")
	private String cpers; 
	
	@Column(name = "cvalm")
	private String cvalm; 
	
	@Column(name = "cvalma")
	private String cvalma; 
	
	@Column(name = "cvalaa")
	private String cvalaa;

	public String getCcia() {
		return ccia;
	}

	public void setCcia(String ccia) {
		this.ccia = ccia;
	}

	public String getCline() {
		return cline;
	}

	public void setCline(String cline) {
		this.cline = cline;
	}

	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	public String getCyear() {
		return cyear;
	}

	public void setCyear(String cyear) {
		this.cyear = cyear;
	}

	public String getCpers() {
		return cpers;
	}

	public void setCpers(String cpers) {
		this.cpers = cpers;
	}

	public String getCvalm() {
		return cvalm;
	}

	public void setCvalm(String cvalm) {
		this.cvalm = cvalm;
	}

	public String getCvalma() {
		return cvalma;
	}

	public void setCvalma(String cvalma) {
		this.cvalma = cvalma;
	}

	public String getCvalaa() {
		return cvalaa;
	}

	public void setCvalaa(String cvalaa) {
		this.cvalaa = cvalaa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccia == null) ? 0 : ccia.hashCode());
		result = prime * result + ((cdesc == null) ? 0 : cdesc.hashCode());
		result = prime * result + ((cline == null) ? 0 : cline.hashCode());
		result = prime * result + ((cpers == null) ? 0 : cpers.hashCode());
		result = prime * result + ((cvalaa == null) ? 0 : cvalaa.hashCode());
		result = prime * result + ((cvalm == null) ? 0 : cvalm.hashCode());
		result = prime * result + ((cvalma == null) ? 0 : cvalma.hashCode());
		result = prime * result + ((cyear == null) ? 0 : cyear.hashCode());
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
		Conbsml other = (Conbsml) obj;
		if (ccia == null) {
			if (other.ccia != null)
				return false;
		} else if (!ccia.equals(other.ccia))
			return false;
		if (cdesc == null) {
			if (other.cdesc != null)
				return false;
		} else if (!cdesc.equals(other.cdesc))
			return false;
		if (cline == null) {
			if (other.cline != null)
				return false;
		} else if (!cline.equals(other.cline))
			return false;
		if (cpers == null) {
			if (other.cpers != null)
				return false;
		} else if (!cpers.equals(other.cpers))
			return false;
		if (cvalaa == null) {
			if (other.cvalaa != null)
				return false;
		} else if (!cvalaa.equals(other.cvalaa))
			return false;
		if (cvalm == null) {
			if (other.cvalm != null)
				return false;
		} else if (!cvalm.equals(other.cvalm))
			return false;
		if (cvalma == null) {
			if (other.cvalma != null)
				return false;
		} else if (!cvalma.equals(other.cvalma))
			return false;
		if (cyear == null) {
			if (other.cyear != null)
				return false;
		} else if (!cyear.equals(other.cyear))
			return false;
		return true;
	}
}

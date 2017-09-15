package domain.fs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(ConpgmlPK.class)
@Table(name = "conpgml", schema = "fs")
public class Conpgml {
	
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
	
	@Column(name = "cvalp")
	private String cvalp; 
	
	@Column(name = "cvar1")
	private String cvar1;
	
	@Column(name = "cvalmya")
	private String cvalmya; 
	
	@Column(name = "cvar2")
	private String cvar2;
	
	@Column(name = "cvalma")
	private String cvalma; 
	
	@Column(name = "cvar3")
	private String cvar3;

	@Column(name = "op")
	private String op;

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

	public String getCvalp() {
		return cvalp;
	}

	public void setCvalp(String cvalp) {
		this.cvalp = cvalp;
	}

	public String getCvar1() {
		return cvar1;
	}

	public void setCvar1(String cvar1) {
		this.cvar1 = cvar1;
	}

	public String getCvalmya() {
		return cvalmya;
	}

	public void setCvalmya(String cvalmya) {
		this.cvalmya = cvalmya;
	}

	public String getCvar2() {
		return cvar2;
	}

	public void setCvar2(String cvar2) {
		this.cvar2 = cvar2;
	}

	public String getCvalma() {
		return cvalma;
	}

	public void setCvalma(String cvalma) {
		this.cvalma = cvalma;
	}

	public String getCvar3() {
		return cvar3;
	}

	public void setCvar3(String cvar3) {
		this.cvar3 = cvar3;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccia == null) ? 0 : ccia.hashCode());
		result = prime * result + ((cdesc == null) ? 0 : cdesc.hashCode());
		result = prime * result + ((cline == null) ? 0 : cline.hashCode());
		result = prime * result + ((cpers == null) ? 0 : cpers.hashCode());
		result = prime * result + ((cvalm == null) ? 0 : cvalm.hashCode());
		result = prime * result + ((cvalma == null) ? 0 : cvalma.hashCode());
		result = prime * result + ((cvalmya == null) ? 0 : cvalmya.hashCode());
		result = prime * result + ((cvalp == null) ? 0 : cvalp.hashCode());
		result = prime * result + ((cvar1 == null) ? 0 : cvar1.hashCode());
		result = prime * result + ((cvar2 == null) ? 0 : cvar2.hashCode());
		result = prime * result + ((cvar3 == null) ? 0 : cvar3.hashCode());
		result = prime * result + ((cyear == null) ? 0 : cyear.hashCode());
		result = prime * result + ((op == null) ? 0 : op.hashCode());
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
		Conpgml other = (Conpgml) obj;
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
		if (cvalmya == null) {
			if (other.cvalmya != null)
				return false;
		} else if (!cvalmya.equals(other.cvalmya))
			return false;
		if (cvalp == null) {
			if (other.cvalp != null)
				return false;
		} else if (!cvalp.equals(other.cvalp))
			return false;
		if (cvar1 == null) {
			if (other.cvar1 != null)
				return false;
		} else if (!cvar1.equals(other.cvar1))
			return false;
		if (cvar2 == null) {
			if (other.cvar2 != null)
				return false;
		} else if (!cvar2.equals(other.cvar2))
			return false;
		if (cvar3 == null) {
			if (other.cvar3 != null)
				return false;
		} else if (!cvar3.equals(other.cvar3))
			return false;
		if (cyear == null) {
			if (other.cyear != null)
				return false;
		} else if (!cyear.equals(other.cyear))
			return false;
		if (op == null) {
			if (other.op != null)
				return false;
		} else if (!op.equals(other.op))
			return false;
		return true;
	}
}

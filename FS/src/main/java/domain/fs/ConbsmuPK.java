package domain.fs;

import java.io.Serializable;

import javax.persistence.Column;

public class ConbsmuPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column
	private String ccia;
	
	@Column
	private String cline;
	
	@Column
	private String cyear;
	
	@Column
	private String cpers;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccia == null) ? 0 : ccia.hashCode());
		result = prime * result + ((cline == null) ? 0 : cline.hashCode());
		result = prime * result + ((cpers == null) ? 0 : cpers.hashCode());
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
		ConbsmuPK other = (ConbsmuPK) obj;
		if (ccia == null) {
			if (other.ccia != null)
				return false;
		} else if (!ccia.equals(other.ccia))
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
		if (cyear == null) {
			if (other.cyear != null)
				return false;
		} else if (!cyear.equals(other.cyear))
			return false;
		return true;
	}
}

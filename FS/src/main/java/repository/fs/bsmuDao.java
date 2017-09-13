package repository.fs;

import java.util.List;

import domain.fs.Conbsmu;

public interface bsmuDao {
	public List<Conbsmu> list(String cia, String m, String y);
}
package repository.fs;

import java.util.List;

import domain.fs.Conbsml;
import domain.session.session;

public interface bsmlDao {
	public List<Conbsml> list(String cia);
}
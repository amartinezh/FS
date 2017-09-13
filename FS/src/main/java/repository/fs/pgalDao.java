package repository.fs;

import java.util.List;

import domain.fs.Conpgal;

public interface pgalDao {
	public List<Conpgal> list(String cia, String m, String y);
}
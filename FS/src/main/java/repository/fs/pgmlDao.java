package repository.fs;

import java.util.List;

import domain.fs.Conpgml;

public interface pgmlDao {
	public List<Conpgml> list(String cia, String m, String y);
}
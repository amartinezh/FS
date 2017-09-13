package repository.fs;

import java.util.List;

import domain.fs.Conpgau;

public interface pgauDao {
	public List<Conpgau> list(String cia, String m, String y);
}
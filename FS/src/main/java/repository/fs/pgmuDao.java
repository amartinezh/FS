package repository.fs;

import java.util.List;

import domain.fs.Conpgmu;

public interface pgmuDao {
	public List<Conpgmu> list(String cia, String m, String y);
}
package service.fs;

import java.util.List;

import domain.fs.Conpgal;

public interface pgalService {
	public List<Conpgal> list(String cia, String m, String y);
}

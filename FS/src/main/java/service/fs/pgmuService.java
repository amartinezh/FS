package service.fs;

import java.util.List;

import domain.fs.Conpgmu;

public interface pgmuService {
	public List<Conpgmu> list(String cia, String m, String y);
}

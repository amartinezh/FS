package service.fs;

import java.util.List;

import domain.fs.Conpgau;

public interface pgauService {
	public List<Conpgau> list(String cia, String m, String y);
}

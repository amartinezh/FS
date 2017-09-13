package service.fs;

import java.util.List;

import domain.fs.Conpgml;;

public interface pgmlService {
	public List<Conpgml> list(String cia, String m, String y);
}

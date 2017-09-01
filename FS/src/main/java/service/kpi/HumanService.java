package service.kpi;

import java.util.List;

import domain.fs.reporteHuman;
import domain.session.session;

public interface HumanService {
	public List<reporteHuman> listHuman(session ses);
	public List<reporteHuman> listHumanMonth(session ses);
	public List<reporteHuman> listHumanQuarterly(session ses);
}

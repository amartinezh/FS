package repository.kpi;

import java.util.List;

import domain.fs.reporteFinance;
//import domain.kpi.Reporte;
import domain.session.session;

public interface FinancesDao {

	public List<reporteFinance> listFinance(session ses);
	public List<reporteFinance> listFinanceMonth(session ses);
	public List<reporteFinance> listFinanceQuarterly(session ses);
}

package dataModel;

import java.util.List;
import java.util.Map;

import org.business.teste.App;
import org.business.teste.service.IAppService;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class AppLazyList extends LazyDataModel<App> {

	private static final long serialVersionUID = 1L;

	private List<App> apps;

	IAppService appService;
	
	public AppLazyList(IAppService appService) {
		this.appService = appService;
	}

	@Override
	public List<App> load(int initPosition, int totalRows, String field, SortOrder orderType, Map<String, String> filters) {

		this.apps = this.appService.findWithPagination(initPosition, totalRows);
		if (getRowCount() <= 0) {
			setRowCount(this.appService.countAll());
		}

		setPageSize(totalRows);
		return this.apps;
	}

	@Override
	public App getRowData(String rowKey) {
		for (App app : apps) {
			if (rowKey.equals(String.valueOf(app.getId()))) {
				return app;
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(App app) {
		return app.getId();
	}

	@Override
	public void setRowIndex(int rowIndex) {
		if (rowIndex == -1 || getPageSize() == 0) {
			super.setRowIndex(-1);
		} else {
			super.setRowIndex(rowIndex % getPageSize());
		}
	}

}

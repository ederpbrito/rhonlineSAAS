package br.com.rhonline.multitenant;

import static br.com.rhonline.multitenant.MultiTenantConstants.DEFAULT_TENANT_ID;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;;

@Component
public class DataSourceBasedMultiTenantConnectionProviderImp extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	DataSource defaultDS;
	
	@Autowired
	ApplicationContext context;
	
	static Map<String, DataSource> map = new HashMap<>();
	
	boolean init = false;
	
	public void load() {map.put(DEFAULT_TENANT_ID, defaultDS);}	
	
	@Override
	protected DataSource selectAnyDataSource() {
		
		return null;
	}

	@Override
	protected DataSource selectDataSource(String tenantIdentifier) {
		if(!init) {
			init = true;
			TenantDataSource tenantDataSource = context.getBean(TenantDataSource.class);
			map.putAll(tenantDataSource.getAll());
		}
		return map.get(tenantIdentifier);
	}

}

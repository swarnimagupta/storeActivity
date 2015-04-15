/**
 * 
 */
package com.acc.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import org.apache.commons.collections.CollectionUtils;

import com.acc.dao.StoreActivityDao;
import com.acc.model.StoreActivityModel;


/**
 * @author swapnil.a.pandey
 * 
 */
public class StoreActivityDaoImpl extends AbstractItemDao implements StoreActivityDao
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.dao.StoreActivityDao#getStoreDataForCustomer(java.lang.String)
	 */
	@Override
	public StoreActivityModel getStoreDataForCustomer(final String customerId)
	{
		final FlexibleSearchQuery flexibleQuery = new FlexibleSearchQuery("select {pk} from {StoreActivity} where {customerId}='"
				+ customerId + "'");
		final SearchResult<StoreActivityModel> result = getFlexibleSearchService().search(flexibleQuery);
		return result != null && CollectionUtils.isNotEmpty(result.getResult()) ? result.getResult().get(0)
				: new StoreActivityModel();

	}

}
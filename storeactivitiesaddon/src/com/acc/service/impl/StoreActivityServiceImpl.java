/**
 * 
 */
package com.acc.service.impl;

import javax.annotation.Resource;

import com.acc.dao.StoreActivityDao;
import com.acc.model.StoreActivityModel;
import com.acc.service.StoreActivityService;


/**
 * @author swapnil.a.pandey
 * 
 */
public class StoreActivityServiceImpl implements StoreActivityService
{
	@Resource(name = "storeActivityDao")
	private StoreActivityDao storeActivityDao;

	/**
	 * @return the storeActivityDao
	 */
	public StoreActivityDao getStoreActivityDao()
	{
		return storeActivityDao;
	}

	/**
	 * @param storeActivityDao
	 *           the storeActivityDao to set
	 */
	public void setStoreActivityDao(final StoreActivityDao storeActivityDao)
	{
		this.storeActivityDao = storeActivityDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.StoreActivityService#getStoreDataForCustomer(java.lang.String)
	 */
	@Override
	public StoreActivityModel getStoreDataForCustomer(final String customerId)
	{
		// YTODO Auto-generated method stub
		return storeActivityDao.getStoreDataForCustomer(customerId);
	}

}

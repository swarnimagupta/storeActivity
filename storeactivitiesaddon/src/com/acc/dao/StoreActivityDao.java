/**
 * 
 */
package com.acc.dao;

import com.acc.model.StoreActivityModel;


/**
 * @author swapnil.a.pandey
 * 
 */
public interface StoreActivityDao
{
	public StoreActivityModel getStoreDataForCustomer(final String customerId);
}

/**
 * 
 */
package com.acc.facade;

import com.acc.data.StoreActivityData;


/**
 * @author swapnil.a.pandey
 * 
 */
public interface StoreActivityFacade
{
	public StoreActivityData getStoreDataForCustomer(String customerId);
}

/**
 * 
 */
package com.acc.facade;

import java.util.Date;

import com.acc.data.StoreActivityData;


/**
 * @author swapnil.a.pandey
 * 
 */
public interface StoreActivityFacade
{
	public StoreActivityData getStoreDataForCustomer(String customerId);

	public Date customerEntryTime(final String customerId);

	public Date CustomerExitTime(final String customerId);

	public StoreActivityData calculateTimeSpentInStore(final String customerId);

}

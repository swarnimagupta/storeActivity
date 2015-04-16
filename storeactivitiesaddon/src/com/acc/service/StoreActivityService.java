/**
 * 
 */
package com.acc.service;

import java.util.Date;

import com.acc.model.StoreActivityModel;


/**
 * @author swapnil.a.pandey
 * 
 */
public interface StoreActivityService
{
	public StoreActivityModel getStoreDataForCustomer(String customerId);

	public Date customerEntryTime(final String customerId);

	public Date CustomerExitTime(final String customerId);

	public StoreActivityModel calculateTimeSpentInStore(final String customerId);


}

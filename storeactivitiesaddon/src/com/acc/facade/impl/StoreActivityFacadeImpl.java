/**
 * 
 */
package com.acc.facade.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.util.Date;

import javax.annotation.Resource;

import com.acc.data.StoreActivityData;
import com.acc.facade.StoreActivityFacade;
import com.acc.model.StoreActivityModel;
import com.acc.service.StoreActivityService;


/**
 * @author swapnil.a.pandey
 * 
 */
public class StoreActivityFacadeImpl implements StoreActivityFacade
{
	@Resource(name = "storeActivityService")
	private StoreActivityService storeActivityService;
	@Resource(name = "storeActivityConverter")
	private Converter<StoreActivityModel, StoreActivityData> storeActivityConverter;


	/**
	 * @return the storeActivityService
	 */
	public StoreActivityService getStoreActivityService()
	{
		return storeActivityService;
	}


	/**
	 * @param storeActivityService
	 *           the storeActivityService to set
	 */
	public void setStoreActivityService(final StoreActivityService storeActivityService)
	{
		this.storeActivityService = storeActivityService;
	}


	/**
	 * @return the storeActivityConverter
	 */
	public Converter<StoreActivityModel, StoreActivityData> getStoreActivityConverter()
	{
		return storeActivityConverter;
	}


	/**
	 * @param storeActivityConverter
	 *           the storeActivityConverter to set
	 */
	public void setStoreActivityConverter(final Converter<StoreActivityModel, StoreActivityData> storeActivityConverter)
	{
		this.storeActivityConverter = storeActivityConverter;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.facade.StoreActivityFacade#getStoreDataForCustomer(java.lang.String)
	 */
	@Override
	public StoreActivityData getStoreDataForCustomer(final String customerId)
	{

		return storeActivityConverter.convert(storeActivityService.getStoreDataForCustomer(customerId));
	}

	@Override
	public Date customerEntryTime(final String customerId)
	{
		return storeActivityService.customerEntryTime(customerId);
	}

	@Override
	public Date CustomerExitTime(final String customerId)
	{
		return storeActivityService.CustomerExitTime(customerId);

	}

	@Override
	public StoreActivityData calculateTimeSpentInStore(final String customerId)
	{
		return storeActivityConverter.convert(storeActivityService.calculateTimeSpentInStore(customerId));

	}



}

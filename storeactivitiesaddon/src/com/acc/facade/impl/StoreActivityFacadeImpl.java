/**
 * 
 */
package com.acc.facade.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;

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
	@Resource(name = "beaconConverter")
	private Converter<StoreActivityModel, StoreActivityData> StoreActivityConverter;

	/**
	 * @return the storeActivityConverter
	 */
	public Converter<StoreActivityModel, StoreActivityData> getStoreActivityConverter()
	{
		return StoreActivityConverter;
	}

	/**
	 * @param storeActivityConverter
	 *           the storeActivityConverter to set
	 */
	public void setStoreActivityConverter(final Converter<StoreActivityModel, StoreActivityData> storeActivityConverter)
	{
		StoreActivityConverter = storeActivityConverter;
	}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.facade.StoreActivityFacade#getStoreDataForCustomer(java.lang.String)
	 */
	@Override
	public StoreActivityData getStoreDataForCustomer(final String customerId)
	{

		return StoreActivityConverter.convert(storeActivityService.getStoreDataForCustomer(customerId));
	}

}

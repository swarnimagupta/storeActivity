/**
 * 
 */
package com.acc.populator;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import com.acc.data.StoreActivityData;
import com.acc.model.StoreActivityModel;


/**
 * @author swapnil.a.pandey
 * 
 */
public class StoreActivityPopulator implements Populator<StoreActivityModel, StoreActivityData>

{

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void populate(final StoreActivityModel source, final StoreActivityData target) throws ConversionException
	{

		if (null != source)
		{
			target.setCustomerId(source.getCustomerId());
			target.setStoreEntryTime(source.getStoreEntryTime());
			target.setStoreExitTime(source.getStoreExitTime());
			target.setStoreId(source.getStoreId());
			target.setStoreVisitDate(source.getStoreVisitDate());
			target.setTimeSpentInStore(source.getTimeSpentInStore());
		}
	}

}

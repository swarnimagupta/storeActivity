/**
 *
 */
package com.acc.populator;

import de.hybris.platform.commercefacades.user.converters.populator.CustomerPopulator;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.acc.enums.DeviceTypeCode;


/**
 * @author swarnima.gupta
 *
 */
public class CustomerDeviceTypePopulator extends CustomerPopulator
{
	@Override
	public void populate(final CustomerModel source, final CustomerData target)
	{
		super.populate(source, target);
		if (source != null && target != null)
		{
			if (CollectionUtils.isNotEmpty(source.getDeviceTypeCode()))
			{
				final List<String> deviceTypes = new ArrayList<String>();
				for (final DeviceTypeCode deviceType : source.getDeviceTypeCode())
				{
					deviceTypes.add(deviceType.toString());
				}
				target.setDeviceType(deviceTypes);
			}
		}
	}
}

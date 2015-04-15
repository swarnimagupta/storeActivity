/**
 *
 */
package com.acc.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import com.acc.dao.BeaconTypeDao;
import com.acc.enums.BeaconType;
import com.acc.model.BeaconModel;


/**
 * @author swarnima.gupta
 *
 */
public class BeaconTypeDaoImpl extends AbstractItemDao implements BeaconTypeDao
{
	private static final Logger LOG = Logger.getLogger(BeaconTypeDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.dao.BeaconTypeDao#getBeaconType(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<BeaconType> getBeaconType(final String beaconId, final String majorId, final String minorId)
	{
		final FlexibleSearchQuery flexibleQuery = new FlexibleSearchQuery(
				"select {pk} from {Beacon} where {id}=?id and {majorId}=?majorId and {minorId}=?minorId");
		flexibleQuery.addQueryParameter(BeaconModel.ID, beaconId);
		flexibleQuery.addQueryParameter(BeaconModel.MAJORID, majorId);
		flexibleQuery.addQueryParameter(BeaconModel.MINORID, minorId);
		final SearchResult<BeaconModel> result = getFlexibleSearchService().search(flexibleQuery);
		LOG.info("*****inside BeaconTypeDaoImpl***getBeaconType***" + result);
		List<BeaconType> beaconTypes = null;
		if (CollectionUtils.isNotEmpty(result.getResult()))
		{
			final BeaconModel beacon = result.getResult().get(0);
			beaconTypes = beacon.getBeaconType();
		}
		return beaconTypes;
	}

}

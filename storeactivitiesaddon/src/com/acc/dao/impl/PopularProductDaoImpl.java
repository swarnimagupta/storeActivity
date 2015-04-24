/**
 * 
 */
package com.acc.dao.impl;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.acc.dao.PopularProductDao;
import com.acc.model.BeaconModel;


/**
 * @author swapnil.a.pandey
 * 
 */

public class PopularProductDaoImpl extends AbstractItemDao implements PopularProductDao
{
	private static final Logger LOG = Logger.getLogger(PopularProductDaoImpl.class);

	@Autowired
	private CatalogVersionService catalogVersionService;
	@Autowired
	UserService userService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.dao.PopularProductDao#getPopularProducts(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<BeaconModel> getPopularProducts(final String beaconId, final String majorId, final String minorId)
	{
		LOG.info("beaconid+++++++++++++" + beaconId);
		LOG.info("majorId+++++++++++++" + majorId);
		LOG.info("minorId+++++++++++++" + minorId);
		final FlexibleSearchQuery flexibleQuery = new FlexibleSearchQuery(
				"select {b.pk} from {beacon as b join product as p on {b.id} = {p.beaconId}} where {b.id}=?beaconId and  {b.majorId}=?majorId and {b.minorId}=?minorId ORDER BY {p.popularityCount} DESC ");

		flexibleQuery.addQueryParameter(BeaconModel.ID, beaconId);
		flexibleQuery.addQueryParameter(BeaconModel.MAJORID, majorId);
		flexibleQuery.addQueryParameter(BeaconModel.MINORID, minorId);
		flexibleQuery.addQueryParameter(ProductModel.BEACONID, beaconId);


		catalogVersionService.setSessionCatalogVersion("electronicsProductCatalog", "Online");
		flexibleQuery.setUser(userService.getAdminUser());
		final SearchResult<BeaconModel> result = getFlexibleSearchService().search(flexibleQuery);
		LOG.info("*****inside PopularProductDaoImpl******" + result.getResult().get(0).getProduct());
		List<BeaconModel> beaconProducts = null;
		if (CollectionUtils.isNotEmpty(result.getResult()))
		{
			beaconProducts = result.getResult();
		}

		return beaconProducts;
	}



}

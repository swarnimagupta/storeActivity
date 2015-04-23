/**
 * 
 */
package com.acc.service.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;

import com.acc.dao.PopularProductDao;
import com.acc.model.BeaconModel;
import com.acc.service.PopularProductService;


/**
 * @author swapnil.a.pandey
 * 
 */
public class PopularProductServiceImpl implements PopularProductService
{
	@Resource(name = "popularProductDao")
	PopularProductDao popularProductDao;
	@Resource(name = "modelService")
	ModelService modelService;
	private static final String MAX_NO_OF_POPULAR_PRODUCTS = "storeactivitydata.number.of.popular.products";

	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @param modelService
	 *           the modelService to set
	 */
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	/**
	 * @return the popularProductDao
	 */
	public PopularProductDao getPopularProductDao()
	{
		return popularProductDao;
	}

	/**
	 * @param popularProductDao
	 *           the popularProductDao to set
	 */
	public void setPopularProductDao(final PopularProductDao popularProductDao)
	{
		this.popularProductDao = popularProductDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.PopularProductService#getPopularProducts(java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<BeaconModel> getPopularProducts(final String beaconId, final String majorId, final String minorId)
	{
		// YTODO Auto-generated method stub
		final List<BeaconModel> beaconProducts = popularProductDao.getPopularProducts(beaconId, majorId, minorId);
		if (null != beaconProducts)
		{
			for (final BeaconModel model : beaconProducts)
			{


				if (CollectionUtils.isNotEmpty(model.getProduct()))
				{
					for (final ProductModel productModel : model.getProduct())
					{
						final int popularityCount = productModel.getPopularityCount().intValue() + 1;
						productModel.setPopularityCount(new Integer(popularityCount));
						modelService.save(productModel);
					}

					//	if (beaconProducts.size()beaconId.get<=(Config.getParameter(MAX_NO_OF_POPULAR_PRODUCTS));
				}
			}
		}
		return beaconProducts;
	}
}

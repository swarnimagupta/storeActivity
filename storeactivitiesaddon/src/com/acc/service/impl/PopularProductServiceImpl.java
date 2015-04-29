/**
 * 
 */
package com.acc.service.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.util.Config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.acc.dao.PopularProductDao;
import com.acc.model.BeaconModel;
import com.acc.service.PopularProductService;


/**
 * @author swapnil.a.pandey
 * 
 */
public class PopularProductServiceImpl implements PopularProductService
{
	private static final Logger LOG = Logger.getLogger(PopularProductServiceImpl.class);

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

		LOG.info("inside PopularProductServiceImpl++++++++");

		final int value = 1;
		// YTODO Auto-generated method stub
		final List<BeaconModel> beaconProducts = popularProductDao.getPopularProducts(beaconId, majorId, minorId);
		final List<BeaconModel> beaconList = new ArrayList<BeaconModel>();
		if (null != beaconProducts)
		{
			
			for (final BeaconModel model : beaconProducts)
			{
				
				if (CollectionUtils.isNotEmpty(model.getProduct()))
				{
					for (final ProductModel productModel : model.getProduct())
					{
						if (productModel.getPopularityCount() == 0)
						{
							productModel.setPopularityCount(value);
							LOG.info("****going into if loop");
						}
						else
						{
							int popularityCount = productModel.getPopularityCount();
							final int LatestpopularityCount = ++popularityCount;
							productModel.setPopularityCount(LatestpopularityCount);
							modelService.save(productModel);

						}

					}
					if (Integer.valueOf(model.getProduct().size()).intValue() > (Integer.valueOf(Config
							.getParameter(MAX_NO_OF_POPULAR_PRODUCTS)).intValue()))

					{
						
						model.getProduct().subList(0, Integer.valueOf(Config.getParameter(MAX_NO_OF_POPULAR_PRODUCTS)).intValue());
						beaconList.add(model);
					}
				}
			}
		}

		return beaconList;

	}
}

/**
 * 
 */
package com.acc.facade.impl;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;

import com.acc.facade.PopularProductFacade;
import com.acc.model.BeaconModel;
import com.acc.service.PopularProductService;


/**
 * @author swapnil.a.pandey
 * 
 */
public class PopularProductFacadeImpl implements PopularProductFacade
{
	@Resource(name = "popularProductService")
	PopularProductService popularProductService;

	/**
	 * @return the popularProductService
	 */
	public PopularProductService getPopularProductService()
	{
		return popularProductService;
	}

	/**
	 * @param popularProductService
	 *           the popularProductService to set
	 */
	public void setPopularProductService(final PopularProductService popularProductService)
	{
		this.popularProductService = popularProductService;
	}

	@Resource(name = "productConverter")
	private Converter<ProductModel, ProductData> productConverter;

	/**
	 * @return the productConverter
	 */
	public Converter<ProductModel, ProductData> getProductConverter()
	{
		return productConverter;
	}

	/**
	 * @param productConverter
	 *           the productConverter to set
	 */
	public void setProductConverter(final Converter<ProductModel, ProductData> productConverter)
	{
		this.productConverter = productConverter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.facade.PopularProductFacade#getPopularProducts(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<ProductData> getPopularProducts(final String beaconId, final String majorId, final String minorId)
	{
		List<ProductData> productData = new ArrayList<ProductData>();
		final List<BeaconModel> beaconProducts = popularProductService.getPopularProducts(beaconId, majorId, minorId);
		for (final BeaconModel model : beaconProducts)
		{
			productData = convert(model.getProduct());

		}
		return productData;

	}

	private List<ProductData> convert(final List<ProductModel> productDataList)
	{
		final List<ProductData> productData = new ArrayList<ProductData>();
		if (CollectionUtils.isNotEmpty(productDataList))
		{
			for (final ProductModel productModel : productDataList)
			{

				productData.add(productConverter.convert(productModel));
			}
		}
		return productData;
	}

}

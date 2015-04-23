/**
 * 
 */
package com.acc.facade;

import de.hybris.platform.commercefacades.product.data.ProductData;

import java.util.List;


/**
 * @author swapnil.a.pandey
 * 
 */
public interface PopularProductFacade
{
	public List<ProductData> getPopularProducts(String beaconId, String majorId, String minorId);
}

/**
 * 
 */
package com.acc.service;

import java.util.List;

import com.acc.model.BeaconModel;


/**
 * @author swapnil.a.pandey
 * 
 */
public interface PopularProductService
{
	public List<BeaconModel> getPopularProducts(String beaconId, String majorId, String minorId);

}

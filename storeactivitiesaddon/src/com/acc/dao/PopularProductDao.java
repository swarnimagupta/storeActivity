/**
 * 
 */
package com.acc.dao;

import java.util.List;

import com.acc.model.BeaconModel;


/**
 * @author swapnil.a.pandey
 * 
 */
public interface PopularProductDao
{
	public List<BeaconModel> getPopularProducts(String beaconId, String majorId, String minorId);

}

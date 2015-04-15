/**
 *
 */
package com.acc.dao;

import java.util.List;

import com.acc.enums.BeaconType;


/**
 * @author swarnima.gupta
 *
 */
public interface BeaconTypeDao
{
	public List<BeaconType> getBeaconType(String beaconId, String majorId, String minorId);
}

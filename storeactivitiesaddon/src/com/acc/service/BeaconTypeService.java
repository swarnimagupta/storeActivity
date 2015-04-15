/**
 *
 */
package com.acc.service;

import java.util.List;

import com.acc.enums.BeaconType;


/**
 * @author swarnima.gupta
 *
 */
public interface BeaconTypeService
{
	public List<BeaconType> getBeaconType(String beaconId, String majorId, String minorId);
}

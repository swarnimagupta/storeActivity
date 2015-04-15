/**
 *
 */
package com.acc.facade;

import java.util.List;

import com.acc.enums.BeaconType;


/**
 * @author swarnima.gupta
 *
 */
public interface BeaconTypeFacade
{
	public List<BeaconType> getBeaconType(String beaconId, String majorId, String minorId);
}

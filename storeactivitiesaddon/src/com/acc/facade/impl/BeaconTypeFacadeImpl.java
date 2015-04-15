/**
 *
 */
package com.acc.facade.impl;

import java.util.List;

import com.acc.enums.BeaconType;
import com.acc.facade.BeaconTypeFacade;
import com.acc.service.BeaconTypeService;


/**
 * @author swarnima.gupta
 *
 */
public class BeaconTypeFacadeImpl implements BeaconTypeFacade
{

	private BeaconTypeService beaconTypeService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.facade.BeaconTypeFacade#getBeaconType(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<BeaconType> getBeaconType(final String beaconId, final String majorId, final String minorId)
	{
		// YTODO Auto-generated method stub
		return getBeaconTypeService().getBeaconType(beaconId, majorId, minorId);
	}

	/**
	 * @return the beaconTypeService
	 */
	public BeaconTypeService getBeaconTypeService()
	{
		return beaconTypeService;
	}

	/**
	 * @param beaconTypeService
	 *           the beaconTypeService to set
	 */
	public void setBeaconTypeService(final BeaconTypeService beaconTypeService)
	{
		this.beaconTypeService = beaconTypeService;
	}


}

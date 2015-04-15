/**
 *
 */
package com.acc.service.impl;

import java.util.List;

import com.acc.dao.BeaconTypeDao;
import com.acc.enums.BeaconType;
import com.acc.service.BeaconTypeService;


/**
 * @author swarnima.gupta
 *
 */
public class BeaconTypeServiceImpl implements BeaconTypeService
{

	private BeaconTypeDao beaconTypeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.BeaconTypeService#getBeaconType(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<BeaconType> getBeaconType(final String beaconId, final String majorId, final String minorId)
	{
		return getBeaconTypeDao().getBeaconType(beaconId, majorId, minorId);
	}

	/**
	 * @return the beaconTypeDao
	 */
	public BeaconTypeDao getBeaconTypeDao()
	{
		return beaconTypeDao;
	}

	/**
	 * @param beaconTypeDao
	 *           the beaconTypeDao to set
	 */
	public void setBeaconTypeDao(final BeaconTypeDao beaconTypeDao)
	{
		this.beaconTypeDao = beaconTypeDao;
	}

}

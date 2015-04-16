/**
 * 
 */
package com.acc.service.impl;

import de.hybris.platform.servicelayer.model.ModelService;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.acc.controller.StoreActivityController;
import com.acc.dao.StoreActivityDao;
import com.acc.data.StoreCustomerStatusData;
import com.acc.model.StoreActivityModel;
import com.acc.service.StoreActivityService;


/**
 * @author swapnil.a.pandey
 * 
 */
public class StoreActivityServiceImpl implements StoreActivityService
{
	private static final Logger LOG = Logger.getLogger(StoreActivityController.class);

	@Resource(name = "storeActivityDao")
	private StoreActivityDao storeActivityDao;
	@Resource(name = "modelService")
	private ModelService modelService;

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
	 * @return the storeActivityDao
	 */
	public StoreActivityDao getStoreActivityDao()
	{
		return storeActivityDao;
	}

	/**
	 * @param storeActivityDao
	 *           the storeActivityDao to set
	 */
	public void setStoreActivityDao(final StoreActivityDao storeActivityDao)
	{
		this.storeActivityDao = storeActivityDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acc.service.StoreActivityService#getStoreDataForCustomer(java.lang.String)
	 */
	@Override
	public StoreActivityModel getStoreDataForCustomer(final String customerId)
	{
		// YTODO Auto-generated method stub

		return storeActivityDao.getStoreDataForCustomer(customerId);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Date customerEntryTime(final String customerId)
	{

		LOG.info("::::::: in customerEntryTime method:::::::");

		final StoreCustomerStatusData customerStatus = new StoreCustomerStatusData();
		final StoreActivityModel storeActivityModel = storeActivityDao.getStoreDataForCustomer(customerId);
		if (null == storeActivityModel.getStoreEntryTime())
		{
			storeActivityModel.setStoreEntryTime(new Date());

			modelService.save(storeActivityModel);
			LOG.info("::::::: customerEntryTime3 :::::::" + storeActivityModel.getStoreEntryTime());

			customerStatus.setStatus("CustomerEntered");
		}

		return storeActivityModel.getStoreEntryTime();

	}

	@SuppressWarnings("deprecation")
	@Override
	public Date CustomerExitTime(final String customerId)
	{
		LOG.info("::::::: in customerExitTime method:::::::");

		final StoreCustomerStatusData customerStatus = new StoreCustomerStatusData();
		final StoreActivityModel storeActivityModel = storeActivityDao.getStoreDataForCustomer(customerId);

		if (storeActivityModel.getStoreEntryTime() != null && null == storeActivityModel.getStoreExitTime())
		{

			storeActivityModel.setStoreExitTime(new Date());
			modelService.save(storeActivityModel);
			customerStatus.setStatus("CustomerEntered");
			LOG.info("::::::: CustomerExitTime2 :::::::" + storeActivityModel.getStoreExitTime());


		}
		return storeActivityModel.getStoreExitTime();
	}

	@Override
	public StoreActivityModel calculateTimeSpentInStore(final String customerId)
	{
		LOG.info("::::::: in calculateTimeSpentInStore method:::::::");

		final StoreActivityModel storeActivityModel = storeActivityDao.getStoreDataForCustomer(customerId);

		if (null != storeActivityModel.getStoreEntryTime() && null != storeActivityModel.getStoreExitTime())
		{
			@SuppressWarnings("deprecation")
			final int timeSpentInStore = CustomerExitTime(customerId).getMinutes() - customerEntryTime(customerId).getMinutes();
			storeActivityModel.setTimeSpentInStore(String.valueOf((timeSpentInStore)));
			//modelService.save(storeActivityModel);
			LOG.info("::::::: calculateTimeSpentInStore :::::::" + storeActivityModel.getTimeSpentInStore());
		}
		return storeActivityModel;
	}





}

/**
 * 
 */
package com.acc.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acc.data.StoreActivityData;
import com.acc.data.StoreCustomerStatusData;
import com.acc.facade.StoreActivityFacade;



/**
 * @author swapnil.a.pandey
 * 
 */
@Controller
@RequestMapping(value = "/v1/{baseSiteId}/StoreActivity")
public class StoreActivityController

{
	private static final Logger LOG = Logger.getLogger(StoreActivityController.class);
	private static final String STORE_ID = "storeId";
	private static final String CUSTOMER_ID = "customerId";
	private static final String STORE_VISIT_DATE = "storeVisitDate";
	@Autowired
	private StoreActivityFacade storeActivityFacade;

	@RequestMapping(value = "/knowCustomerStatus", method = RequestMethod.POST)
	@ResponseBody
	public StoreCustomerStatusData knowCustomerStatus(final HttpServletRequest request) throws IOException, ParseException

	{
		LOG.info("::::::: in knowCustomerStatus POST request method :::::::");
		final StringBuffer sbuf = getJsonBodyString(request);
		LOG.info("::::::: json object string is :::::::" + sbuf);
		final StoreCustomerStatusData customerStatus = new StoreCustomerStatusData();
		if (StringUtils.isNotEmpty(sbuf.toString()))
		{
			final JSONParser parser = new JSONParser();
			final JSONObject obj = (JSONObject) parser.parse(sbuf.toString());
			final String storeId = String.valueOf((obj.get(STORE_ID)));
			final String customerId = String.valueOf(obj.get(CUSTOMER_ID));
			//final String storeVisitDate = String.valueOf(obj.get(STORE_VISIT_DATE));
			final StoreActivityData storeActivityData = storeActivityFacade.getStoreDataForCustomer(customerId);
			if (storeActivityData.getStoreId() == storeId && storeActivityFacade.customerEntryTime(customerId) != null
					&& storeActivityFacade.CustomerExitTime(customerId) == null)
			{
				LOG.info("::::::: customerEntryTime1 :::::::" + storeActivityFacade.customerEntryTime(customerId));

				customerStatus.setStatus("CustomerEntered");
			}

			if (storeActivityData.getStoreId() == storeId && storeActivityFacade.customerEntryTime(customerId) != null
					&& storeActivityFacade.CustomerExitTime(customerId) != null)
			{
				LOG.info("::::::: customerEntryTime2 :::::::" + storeActivityFacade.customerEntryTime(customerId));
				LOG.info("::::::: CustomerExitTime1 :::::::" + storeActivityFacade.CustomerExitTime(customerId));

				customerStatus.setStatus("CustomerExited");
				storeActivityFacade.calculateTimeSpentInStore(customerId);
				LOG.info("::::::: calculateTimeSpentInStore ::controller:::::"
						+ storeActivityFacade.calculateTimeSpentInStore(customerId));

			}

		}
		return customerStatus;

	}


	private StringBuffer getJsonBodyString(final HttpServletRequest request) throws IOException, UnsupportedEncodingException
	{
		final ServletInputStream input = request.getInputStream();
		final byte[] buf = new byte[201];
		final StringBuffer sbuf = new StringBuffer();
		int result;
		do
		{
			result = input.readLine(buf, 0, buf.length);
			if (result != -1)
			{
				sbuf.append(new String(buf, 0, result, "UTF-8"));
			}
			else
			{
				break;
			}
		}
		while (result == buf.length);
		return sbuf;
	}
}

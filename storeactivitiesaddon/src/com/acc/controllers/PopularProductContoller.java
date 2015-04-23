/**
 * 
 */
package com.acc.controllers;

import de.hybris.platform.commercefacades.product.data.ProductData;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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

import com.acc.facade.PopularProductFacade;


/**
 * @author swapnil.a.pandey
 * 
 */
@Controller
@RequestMapping(value = "/v1/{baseSiteId}/GetPopularProduct")
public class PopularProductContoller
{
	private static final Logger LOG = Logger.getLogger(PopularProductContoller.class);
	private static final String BEACON_ID = "beaconId";
	private static final String MAJOR_ID = "majorId";
	private static final String MINOR_ID = "minorId";


	@Autowired
	PopularProductFacade popularProductFacade;

	@RequestMapping(value = "/maxpopularity", method = RequestMethod.POST)
	@ResponseBody
	public List<ProductData> getPopularProducts(final HttpServletRequest request) throws IOException, ParseException
	{
		List<ProductData> data = new ArrayList<ProductData>();
		LOG.info("::::::: in PopularProductContoller POST request method :::::::");
		final StringBuffer sbuf = getJsonBodyString(request);
		LOG.info("::::::: json object string is :::::::" + sbuf);
		if (StringUtils.isNotEmpty(sbuf.toString()))
		{
			final JSONParser parser = new JSONParser();
			final JSONObject obj = (JSONObject) parser.parse(sbuf.toString());
			final String beaconId = String.valueOf(obj.get(BEACON_ID));
			final String majorId = String.valueOf(obj.get(MAJOR_ID));
			final String minorId = String.valueOf(obj.get(MINOR_ID));


			data = popularProductFacade.getPopularProducts(beaconId, majorId, minorId);

			//Config.getParameter(MAX_NO_OF_POPULAR_PRODUCTS)


		}
		return data;

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

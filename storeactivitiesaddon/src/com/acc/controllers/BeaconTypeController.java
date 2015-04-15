/**
 *
 */
package com.acc.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
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

import com.acc.data.WebserviceResponseData;
import com.acc.enums.BeaconType;
import com.acc.facade.BeaconTypeFacade;


/**
 * @author swarnima.gupta
 *
 */
@Controller
@RequestMapping(value = "/v1/{baseSiteId}/getBeaconType")
public class BeaconTypeController
{
	private static final Logger LOG = Logger.getLogger(BeaconTypeController.class);

	@Autowired
	private BeaconTypeFacade beaconTypeFacade;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public WebserviceResponseData getBeaconType(final HttpServletRequest request) throws UnsupportedEncodingException,
			IOException, ParseException
	{
		LOG.info("::::::: in getBeaconType POST request method :::::::");
		final StringBuffer sbuf = getJsonBodyString(request);
		LOG.info("::::::: json object string is :::::::" + sbuf);
		final WebserviceResponseData responseData = new WebserviceResponseData();
		if (StringUtils.isNotEmpty(sbuf.toString()))
		{
			final JSONParser parser = new JSONParser();
			final JSONObject obj = (JSONObject) parser.parse(sbuf.toString());
			final List<BeaconType> response = beaconTypeFacade.getBeaconType(String.valueOf(obj.get("beaconId")),
					String.valueOf(obj.get("majorId")), String.valueOf(obj.get("minorId")));
			if (CollectionUtils.isNotEmpty(response))
			{
				final StringBuilder types = new StringBuilder();
				for (final BeaconType beaconType : response)
				{
					if (StringUtils.isNotEmpty(types.toString()))
					{
						types.append(",");
					}
					types.append(beaconType.getCode());
				}
				responseData.setResponse(types.toString());
			}
		}
		return responseData;
	}

	/**
	 * @param request
	 * @return StringBuffer
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("unused")
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

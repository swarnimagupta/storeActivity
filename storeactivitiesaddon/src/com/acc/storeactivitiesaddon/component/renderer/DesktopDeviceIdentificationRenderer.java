/**
 *
 */
package com.acc.storeactivitiesaddon.component.renderer;

import de.hybris.platform.addonsupport.renderer.impl.DefaultAddOnCMSComponentRenderer;
import de.hybris.platform.cms2lib.model.components.DesktopDeviceIdentificationComponentModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.PageContext;

import org.apache.log4j.Logger;

import com.acc.enums.DeviceTypeCode;


/**
 * @author swarnima.gupta
 *
 */
public class DesktopDeviceIdentificationRenderer<C extends DesktopDeviceIdentificationComponentModel> extends
		DefaultAddOnCMSComponentRenderer<C>
{
	private static final Logger LOG = Logger.getLogger(DesktopDeviceIdentificationRenderer.class);

	private UserService userService;

	private ModelService modelService;

	@Override
	protected Map<String, Object> getVariablesToExpose(final PageContext pageContext, final C component)
	{
		LOG.info("inside device identification component renderer");
		final CustomerModel customer = (CustomerModel) getUserService().getCurrentUser();
		if (null != customer && !"anonymous".equals(customer.getUid()))
		{
			final List<DeviceTypeCode> deviceTypeCodes = customer.getDeviceTypeCode();
			final List<DeviceTypeCode> newDeviceTypeCodes = new ArrayList<DeviceTypeCode>();
			for (final DeviceTypeCode deviceTypeCode : deviceTypeCodes)
			{
				newDeviceTypeCodes.add(deviceTypeCode);
			}
			if (!newDeviceTypeCodes.contains(DeviceTypeCode.APP001))
			{
				newDeviceTypeCodes.add(DeviceTypeCode.APP001);
			}
			customer.setDeviceTypeCode(newDeviceTypeCodes);
			getModelService().save(customer);
		}
		final Map<String, Object> variables = new HashMap<String, Object>();
		return variables;
	}

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
	 * @return the userService
	 */
	public UserService getUserService()
	{
		return userService;
	}

	/**
	 * @param userService
	 *           the userService to set
	 */
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}


}

/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Apr 13, 2015 11:12:38 AM                    ---
 * ----------------------------------------------------------------
 */
package com.acc.jalo;

import com.acc.constants.StoreactivitiesaddonConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem StoreActivity}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedStoreActivity extends GenericItem
{
	/** Qualifier of the <code>StoreActivity.storeExitTime</code> attribute **/
	public static final String STOREEXITTIME = "storeExitTime";
	/** Qualifier of the <code>StoreActivity.storeVisitDate</code> attribute **/
	public static final String STOREVISITDATE = "storeVisitDate";
	/** Qualifier of the <code>StoreActivity.storeId</code> attribute **/
	public static final String STOREID = "storeId";
	/** Qualifier of the <code>StoreActivity.timeSpentInStore</code> attribute **/
	public static final String TIMESPENTINSTORE = "timeSpentInStore";
	/** Qualifier of the <code>StoreActivity.storeEntryTime</code> attribute **/
	public static final String STOREENTRYTIME = "storeEntryTime";
	/** Qualifier of the <code>StoreActivity.customerId</code> attribute **/
	public static final String CUSTOMERID = "customerId";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(STOREEXITTIME, AttributeMode.INITIAL);
		tmp.put(STOREVISITDATE, AttributeMode.INITIAL);
		tmp.put(STOREID, AttributeMode.INITIAL);
		tmp.put(TIMESPENTINSTORE, AttributeMode.INITIAL);
		tmp.put(STOREENTRYTIME, AttributeMode.INITIAL);
		tmp.put(CUSTOMERID, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreActivity.customerId</code> attribute.
	 * @return the customerId
	 */
	public String getCustomerId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CUSTOMERID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreActivity.customerId</code> attribute.
	 * @return the customerId
	 */
	public String getCustomerId()
	{
		return getCustomerId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreActivity.customerId</code> attribute. 
	 * @param value the customerId
	 */
	public void setCustomerId(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CUSTOMERID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreActivity.customerId</code> attribute. 
	 * @param value the customerId
	 */
	public void setCustomerId(final String value)
	{
		setCustomerId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreActivity.storeEntryTime</code> attribute.
	 * @return the storeEntryTime
	 */
	public Date getStoreEntryTime(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, STOREENTRYTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreActivity.storeEntryTime</code> attribute.
	 * @return the storeEntryTime
	 */
	public Date getStoreEntryTime()
	{
		return getStoreEntryTime( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreActivity.storeEntryTime</code> attribute. 
	 * @param value the storeEntryTime
	 */
	public void setStoreEntryTime(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, STOREENTRYTIME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreActivity.storeEntryTime</code> attribute. 
	 * @param value the storeEntryTime
	 */
	public void setStoreEntryTime(final Date value)
	{
		setStoreEntryTime( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreActivity.storeExitTime</code> attribute.
	 * @return the storeExitTime
	 */
	public Date getStoreExitTime(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, STOREEXITTIME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreActivity.storeExitTime</code> attribute.
	 * @return the storeExitTime
	 */
	public Date getStoreExitTime()
	{
		return getStoreExitTime( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreActivity.storeExitTime</code> attribute. 
	 * @param value the storeExitTime
	 */
	public void setStoreExitTime(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, STOREEXITTIME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreActivity.storeExitTime</code> attribute. 
	 * @param value the storeExitTime
	 */
	public void setStoreExitTime(final Date value)
	{
		setStoreExitTime( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreActivity.storeId</code> attribute.
	 * @return the storeId - store unique id
	 */
	public String getStoreId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, STOREID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreActivity.storeId</code> attribute.
	 * @return the storeId - store unique id
	 */
	public String getStoreId()
	{
		return getStoreId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreActivity.storeId</code> attribute. 
	 * @param value the storeId - store unique id
	 */
	public void setStoreId(final SessionContext ctx, final String value)
	{
		setProperty(ctx, STOREID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreActivity.storeId</code> attribute. 
	 * @param value the storeId - store unique id
	 */
	public void setStoreId(final String value)
	{
		setStoreId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreActivity.storeVisitDate</code> attribute.
	 * @return the storeVisitDate
	 */
	public Date getStoreVisitDate(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, STOREVISITDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreActivity.storeVisitDate</code> attribute.
	 * @return the storeVisitDate
	 */
	public Date getStoreVisitDate()
	{
		return getStoreVisitDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreActivity.storeVisitDate</code> attribute. 
	 * @param value the storeVisitDate
	 */
	public void setStoreVisitDate(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, STOREVISITDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreActivity.storeVisitDate</code> attribute. 
	 * @param value the storeVisitDate
	 */
	public void setStoreVisitDate(final Date value)
	{
		setStoreVisitDate( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreActivity.timeSpentInStore</code> attribute.
	 * @return the timeSpentInStore
	 */
	public Date getTimeSpentInStore(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, TIMESPENTINSTORE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>StoreActivity.timeSpentInStore</code> attribute.
	 * @return the timeSpentInStore
	 */
	public Date getTimeSpentInStore()
	{
		return getTimeSpentInStore( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreActivity.timeSpentInStore</code> attribute. 
	 * @param value the timeSpentInStore
	 */
	public void setTimeSpentInStore(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, TIMESPENTINSTORE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>StoreActivity.timeSpentInStore</code> attribute. 
	 * @param value the timeSpentInStore
	 */
	public void setTimeSpentInStore(final Date value)
	{
		setTimeSpentInStore( getSession().getSessionContext(), value );
	}
	
}

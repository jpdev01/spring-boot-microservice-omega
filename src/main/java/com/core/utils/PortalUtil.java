package com.core.utils;

import com.core.backend.entity.Language;
import com.core.backend.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.Port;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PortalUtil
{

	private static final Log log = LogFactory.getLog(PortalUtil.class);
	private static final ThreadLocal<HttpServletRequest> currentRequestLocal = new ThreadLocal<HttpServletRequest>();
	private static final String USER = "currentUser";
	private static Language systemLanguage = null;

	public static void setCurrentRequest(final HttpServletRequest request)
	{
		currentRequestLocal.set(request);
		//baseURLLocal.set(loadBaseURL());
	}


	public static HttpSession getCurrentSession()
	{
		final HttpServletRequest request = currentRequestLocal.get();
		if (request != null)
		{
			return request.getSession(true);
		}
		return null;
	}

	public static void setCurrentUser(User currentUser)
	{
		HttpSession session = getCurrentSession();
		if (session != null)
		{
			session.setAttribute(USER, currentUser);
		}
	}

	public static User getCurrentUser()
	{
		HttpSession session = getCurrentSession();
		if (session != null)
		{
			return (User) session.getAttribute(USER);
		}
		return null;
	}

	public static void setSystemLanguage(Language language)
	{
		PortalUtil.systemLanguage = language;
	}

	public static Language getSystemLanguage()
	{
		return systemLanguage;
	}
}

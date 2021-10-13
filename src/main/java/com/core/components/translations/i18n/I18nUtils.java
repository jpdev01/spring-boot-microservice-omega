package com.core.components.translations.i18n;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClient;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;
import com.core.utils.PortalUtil;
import com.core.backend.entity.Language;
import com.core.backend.entity.User;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18nUtils
{
	public static final Locale DEFAULT_LOCALE = new Locale("pt", "BR");

	public static String getString(String message)
	{
		// FIXME quando nao tiver aquela traducao, trazer o codigo.
		ResourceBundle bundle = ResourceBundle.getBundle("i18n", getCurrentLocale());
		return bundle.getString(message);
	}

	public static Language getCurrentLanguage()
	{
		User currentUser = PortalUtil.getCurrentUser();
		if(currentUser != null)
		{
			Language language = currentUser.getLanguage();
			if(language == null)
			{
				return I18nUtils.getSystemLanguage();
			}
			return currentUser.getLanguage();
		}
		String languageByLocale = DEFAULT_LOCALE.getLanguage();
		if("pt".equals(DEFAULT_LOCALE.getLanguage()))
		{
			languageByLocale = "PT_BR";
		}
		return Language.valueOf(DEFAULT_LOCALE.getLanguage());
	}


	public static Locale getCurrentLocale()
	{
		return new Locale(getStringLanguage(), getCurrentCountry());
	}

	public static String getStringLanguage()
	{
		Language language = getCurrentLanguage();
		if(Language.PR_BR.equals(language))
		{
			return "pt";
		}
		else if(Language.EN_US.equals(language))
		{
			return "en";
		}
		return "pt";
	}

	public static String getCurrentCountry()
	{
		//fixme validar se isso nao pode ser guardado no banco, criando uma entidade language
		String language = getCurrentLanguage().name();
		if(language.equals(Language.PR_BR))
		{
			return "br";
		}
		else if(language.equals(Language.EN_US))
		{
			return "us";
		}
		else
		{
			return "en";
		}
	}

	public static String awsTranslate()
	{
		// Create credentials using a provider chain. For more information, see
		// https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
		//  FIXME iniciar credencial
		AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();

		AmazonTranslate translate = AmazonTranslateClient.builder()
			.withCredentials(new AWSStaticCredentialsProvider(awsCreds.getCredentials()))
			.withRegion(getAwsRegion())
			.build();

		TranslateTextRequest request = new TranslateTextRequest()
			.withText("Hello, world")
			.withSourceLanguageCode("en")
			.withTargetLanguageCode("es");
		TranslateTextResult result  = translate.translateText(request);
		System.out.println(result.getTranslatedText());
		return null;
	}

	private static Regions getAwsRegion()
	{
		Language language = getCurrentLanguage();
		if(language.equals(Language.PR_BR))
		{
			return Regions.SA_EAST_1;
		}
		else if(language.equals(Language.EN_US))
		{
			return Regions.GovCloud;
		}
		return Regions.SA_EAST_1;
	}

	public static Language getSystemLanguage()
	{
		//FIXME Implementar
		return Language.PR_BR;
	}
}

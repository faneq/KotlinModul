package com.example.library.base.module;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.library.base.network.intercept.CookiesManager;
import com.example.library.base.network.intercept.HttpLoggingInterceptor;
import com.example.library.base.network.utils.AppConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.cache.InternalCache;


@Module
public class RetrofitModule {
    private final Context context;

    public RetrofitModule(Context context) {
        this.context = context;
    }

    @Provides
    public Gson provideGson() {
        return new GsonBuilder().
                serializeNulls().
                create();
    }

    @Provides
    public OkHttpClient provideOkhttpClient(Cache cache, CacheInterceptor cacheInterceptor, CookiesManager cookiesManager) {

        X509TrustManager xtm = new X509TrustManager() {
            @SuppressLint("TrustAllX509TrustManager")
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @SuppressLint("TrustAllX509TrustManager")
            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };

        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL");

            sslContext.init(null, new TrustManager[]{xtm}, new SecureRandom());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        HostnameVerifier DO_NOT_VERIFY = (s, sslSession) -> true;

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .cache(cache)//添加缓存
//                .addInterceptor(mHeaderInterceptor)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(cacheInterceptor)
                .sslSocketFactory(sslContext.getSocketFactory())
                .hostnameVerifier(DO_NOT_VERIFY).readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS)
//                .cookieJar(cookiesManager)
                .build();

    }

    @Provides
    public CacheInterceptor providesCacheInterceptor() {
        return new CacheInterceptor((InternalCache) context);
    }


    @Provides
    public Cache provideCache() {
        return new Cache(context.getExternalFilesDir(AppConfig.DEFAULT_JOSN_CACHE), AppConfig.DEFAULT_CACHE_SIZE);
    }

    @Provides
    public CookiesManager providesCookies() {
        return new CookiesManager();
    }

    /**
     * 增加头部信息的拦截器
     */
    private Interceptor mHeaderInterceptor = chain -> {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.108 Safari/537.36 2345Explorer/8.0.0.13547");
        builder.addHeader("Cache-Control", "max-age=0");
        builder.addHeader("Upgrade-Insecure-Requests", "1");
        builder.addHeader("X-Requested-With", "XMLHttpRequest");
        builder.addHeader("Cookie", "uuid=\"w:f2e0e469165542f8a3960f67cb354026\"; __tasessionId=4p6q77g6q1479458262778; csrftoken=7de2dd812d513441f85cf8272f015ce5; tt_webid=36385357187");
        return chain.proceed(builder.build());
    };

}

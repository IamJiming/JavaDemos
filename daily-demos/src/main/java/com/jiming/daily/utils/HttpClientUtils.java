package com.jiming.daily.utils;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import com.jiming.daily.exception.service.ServiceException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ParseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

/**
 * 功能：Http 工具类
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
@SuppressWarnings("all")
public class HttpClientUtils {

    private static SSLConnectionSocketFactory sslsf = null;
    private static PoolingHttpClientConnectionManager cm = null;
    private static RequestConfig requestConfig;

    public HttpClientUtils() {
    }

    public static String doGet(String uri) {
        return doGet(uri, (Map)null, (Integer)null);
    }

    public static String doGet(String uri, String charset) {
        return doGet(uri, (Map)null, (Integer)null, charset);
    }

    public static String doGet(String uri, Integer retryCount) {
        return doGet(uri, (Map)null, retryCount);
    }

    public static String doGetWithHeader(String uri, Map<String, String> header) {
        return doGet(uri, header, (Integer)null);
    }

    public static <T> T getForObject(String uri, Class<T> clazz) {
        return JsonUtils.parseObject(doGet(uri), clazz);
    }

    public static String doGet(String uri, Map<String, String> header, Integer retryCount) {
        return doGet(uri, header, retryCount, "UTF-8");
    }

    public static String doGet(String uri, Map<String, String> header, Integer retryCount, String charset) {
        String content = null;
        CloseableHttpClient httpClient = getCloseableHttpClient(false, retryCount);
        HttpGet httpGet = new HttpGet(uri);
        if (header != null && !header.isEmpty()) {
            Iterator var7 = header.entrySet().iterator();

            while(var7.hasNext()) {
                Entry<String, String> entry = (Entry)var7.next();
                httpGet.addHeader((String)entry.getKey(), (String)entry.getValue());
            }
        }

        httpGet.setConfig(getRequestConfig());
        content = doRequest(httpClient, httpGet, charset);
        return content;
    }

    public static String doPost(String uri, Map<String, Object> params) {
        return doPost(uri, (Map)params, (Integer)null);
    }

    public static String doPostWithHead(String uri, Map<String, Object> params, Map<String, String> header) {
        return doPost(uri, (Map)params, (Map)header, (Integer)null);
    }

    public static String doPost(String uri, Map<String, Object> params, Integer retryCount) {
        return doPost(uri, (Map)params, (Map)null, retryCount);
    }

    public static String doPost(String uri, Map<String, Object> params, Map<String, String> header, Integer retryCount) {
        String content = null;
        CloseableHttpClient httpClient = getCloseableHttpClient(false, retryCount);
        HttpPost httpPost = new HttpPost(uri);
        if (header != null && !header.isEmpty()) {
            Iterator var7 = header.entrySet().iterator();

            while(var7.hasNext()) {
                Entry<String, String> map = (Entry)var7.next();
                httpPost.addHeader((String)map.getKey(), (String)map.getValue());
            }
        }

        List<NameValuePair> nameValuePairList = new ArrayList();
        Set<String> keySet = params.keySet();
        Iterator var9 = keySet.iterator();

        while(var9.hasNext()) {
            String key = (String)var9.next();
            nameValuePairList.add(new BasicNameValuePair(key, String.valueOf(params.get(key))));
        }

        var9 = null;

        UrlEncodedFormEntity entity;
        try {
            entity = new UrlEncodedFormEntity(nameValuePairList, "UTF-8");
        } catch (UnsupportedEncodingException var11) {
            throw new ServiceException(var11);
        }

        httpPost.setEntity(entity);
        httpPost.setConfig(getRequestConfig());
        content = doRequest(httpClient, httpPost);
        return content;
    }

    public static String doPost(String uri, String postData) {
        return doPost(uri, (String)postData, (HttpClientUtils.ContentTypeEnum)HttpClientUtils.ContentTypeEnum.JSON, (Integer)null);
    }

    public static String doPost(String uri, String postData, Map<String, String> header) {
        return doPost(uri, postData, HttpClientUtils.ContentTypeEnum.JSON, header, (Integer)null);
    }

    public static <T> T postForObject(String uri, String postData, Class<T> clazz) {
        return JsonUtils.parseObject(doPost(uri, postData), clazz);
    }

    public static String doPost(String uri, String postData, HttpClientUtils.ContentTypeEnum contentType, Integer retryCount) {
        return doPost(uri, postData, contentType, (Map)null, retryCount);
    }

    public static String doPost(String uri, String postData, HttpClientUtils.ContentTypeEnum contentType, Map<String, String> header, Integer retryCount) {
        String content = null;
        CloseableHttpClient httpClient = getCloseableHttpClient(false, retryCount);
        HttpPost httpPost = new HttpPost(uri);
        if (header != null && !header.isEmpty()) {
            Iterator var8 = header.entrySet().iterator();

            while(var8.hasNext()) {
                Entry<String, String> map = (Entry)var8.next();
                httpPost.addHeader((String)map.getKey(), (String)map.getValue());
            }
        }

        StringEntity postEntity = new StringEntity(postData, "UTF-8");
        postEntity.setContentType(contentType.getContentTypeValue());
        httpPost.setEntity(postEntity);
        httpPost.setConfig(getRequestConfig());
        content = doRequest(httpClient, httpPost);
        return content;
    }

    public static String doGetSsl(String uri) {
        return doGetSsl(uri, (Integer)null);
    }

    public static String doGetSsl(String uri, Integer retryCount) {
        String content = null;
        CloseableHttpClient httpClient = getCloseableHttpClient(true, retryCount);
        HttpGet httpGet = new HttpGet(uri);
        httpGet.setConfig(getRequestConfig());
        content = doRequest(httpClient, httpGet);
        return content;
    }

    public static String doPostSsl(String uri, Map<String, Object> params) {
        return doPostSsl(uri, params, (Integer)null);
    }

    public static String doPostSsl(String uri, Map<String, Object> params, Integer retryCount) {
        String content = null;
        CloseableHttpClient httpClient = getCloseableHttpClient(true, retryCount);
        HttpPost httpPost = new HttpPost(uri);
        List<NameValuePair> nameValuePairList = new ArrayList();
        Set<String> keySet = params.keySet();
        Iterator var8 = keySet.iterator();

        while(var8.hasNext()) {
            String key = (String)var8.next();
            nameValuePairList.add(new BasicNameValuePair(key, String.valueOf(params.get(key))));
        }

        var8 = null;

        UrlEncodedFormEntity entity;
        try {
            entity = new UrlEncodedFormEntity(nameValuePairList, "UTF-8");
        } catch (UnsupportedEncodingException var10) {
            throw new ServiceException(var10);
        }

        httpPost.setEntity(entity);
        httpPost.setConfig(getRequestConfig());
        content = doRequest(httpClient, httpPost);
        return content;
    }

    private static String doRequest(CloseableHttpClient httpClient, HttpUriRequest request, String charset) {
        CloseableHttpResponse response = null;
        String var4;
        try {
            response = httpClient.execute(request);
            var4 = praseResponse(response, charset);
        } catch (Exception var13) {
            throw new ServiceException(var13);
        } finally {
            try {
                request = null;
                httpClient.close();
            } catch (IOException var12) {
            }

        }
        return var4;
    }

    private static String doRequest(CloseableHttpClient httpClient, HttpUriRequest request) {
        return doRequest(httpClient, request, "UTF-8");
    }

    private static CloseableHttpClient getCloseableHttpClient(boolean isSsl, Integer retryCount) {
        HttpClientBuilder hcb = getHttpClientBuilder();
        if (retryCount != null && retryCount > 0) {
            hcb.setRetryHandler(getHttpRequestRetryHandler(retryCount));
        }
        if (isSsl) {
            hcb.setSSLSocketFactory(sslsf);
        }
        return hcb.build();
    }

    private static HttpClientBuilder getHttpClientBuilder() {
        return HttpClients.custom().setConnectionManager(cm).setConnectionManagerShared(true);
    }

    private static RequestConfig getRequestConfig() {
        return requestConfig;
    }

    private static void init() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        SSLContextBuilder builder = new SSLContextBuilder();
        builder.loadTrustMaterial((KeyStore)null, new TrustStrategy() {
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        });
        sslsf = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1.1", "TLSv1", "TLSv1.2"}, (String[])null, NoopHostnameVerifier.INSTANCE);
        RegistryBuilder rb = RegistryBuilder.create().register("http", new PlainConnectionSocketFactory()).register("https", sslsf);
        Registry<ConnectionSocketFactory> registry = rb.build();
        cm = new PoolingHttpClientConnectionManager(registry);
        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(200);
        requestConfig = RequestConfig.custom().setConnectTimeout(50000).setConnectionRequestTimeout(10000).setSocketTimeout(50000).build();
    }

    private static HttpRequestRetryHandler getHttpRequestRetryHandler(final Integer retryCount) {
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                if (executionCount >= retryCount) {
                    return false;
                } else if (exception instanceof NoHttpResponseException) {
                    return true;
                } else if (exception instanceof SSLHandshakeException) {
                    return false;
                } else if (exception instanceof InterruptedIOException) {
                    return false;
                } else if (exception instanceof UnknownHostException) {
                    return false;
                } else if (exception instanceof ConnectTimeoutException) {
                    return false;
                } else if (exception instanceof SSLException) {
                    return false;
                } else {
                    HttpClientContext clientContext = HttpClientContext.adapt(context);
                    HttpRequest request = clientContext.getRequest();
                    return !(request instanceof HttpEntityEnclosingRequest);
                }
            }
        };
        return httpRequestRetryHandler;
    }

    private static String praseResponse(CloseableHttpResponse response, String charset) {
        String content = "";
        if (response != null) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try {
                    content = EntityUtils.toString(entity, charset);
                } catch (IOException | ParseException var12) {
                    throw new ServiceException(var12);
                } finally {
                    try {
                        response.close();
                    } catch (IOException var11) {
                    }

                }
            }
        }
        return content;
    }

    static {
        try {
            init();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException var1) {
            throw new ServiceException(var1);
        }
    }

    public static enum ContentTypeEnum {
        JSON("application/json"),
        XML("application/xml");

        private String contentTypeValue;

        private ContentTypeEnum(String contentTypeValue) {
            this.contentTypeValue = contentTypeValue;
        }

        public String getContentTypeValue() {
            return this.contentTypeValue;
        }

    }
}

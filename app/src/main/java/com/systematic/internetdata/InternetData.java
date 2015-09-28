package com.systematic.internetdata;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
//import org.apache.http.impl.client.;

import java.util.ArrayList;
import java.util.List;


public class InternetData extends ActionBarActivity {

    private EditText txtStudent, txtCourse;
    private Button btnPost,btnGet;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        txtStudent =(EditText) findViewById(R.id.txtStudent);
        txtCourse =(EditText) findViewById(R.id.txtCourse);
        btnPost =(Button) findViewById(R.id.btnPost);
        btnGet =(Button) findViewById(R.id.btnGet);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnGet.setOnClickListener(getMethod);
        btnPost.setOnClickListener(postMethod);
    }


    private View.OnClickListener getMethod = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            WebConnectionTask task = new WebConnectionTask();
            task.execute(new String[] { "GET" });
        }
    };

    private View.OnClickListener postMethod = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            WebConnectionTask task = new WebConnectionTask();
            task.execute(new String[] { "POST" });
        }
    };

    private class WebConnectionTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String strResult = "";
            String url = "";
            switch (params[0]) {
                case "GET":
                    String pUrl2 ="https://reserve.cdn-apple.com/HK/zh_HK/reserve/iPhone/availability?channel=1&appleCare=N&iPP=N&partNumber=MKQL2ZP/A&returnURL=http%3A%2F%2Fwww.apple.com%2Fhk%2Fshop%2Fbuy-iphone%2Fiphone6s&store=R428";

                /* init client */
                DefaultHttpClient http = null;
                CookieStore httpCookieStore = new BasicCookieStore();
                HttpClientBuilder builder = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore);

/* do stuff */
                HttpGet httpRequest = new HttpGet(pUrl2);

                try {
                    HttpResponse httpResponse2 = null;
                    httpResponse2 = http.execute(httpRequest);

/* check cookies */
                    CookieStore cookieStore3 = http.getCookieStore();
                //httpCookieStore.getCookies();
                    List<Cookie> cookies2 = cookieStore3.getCookies();
                    //List<Cookie> cookies2 = httpCookieStore.getCookies();


                    for (int i=0; i<cookies2.size();i++) {

                        //if (cookies.get(i).getName().toString().equals("abc")) {
                        Log.e("cookie name is: " ,cookies2.get(i).getName().toString());
                        Log.e("cookie is: " ,cookies2.get(i).getValue().toString());
                        //}
                    }
                } catch (Throwable error) {throw new RuntimeException(error);}
                    break;
                /*
                case "GET":
                    String finalStudent = txtStudent.getText().toString().replace(" ", "+");
                    String finalCourse = txtCourse.getText().toString().replace(" ", "+");
                    url = "http://www.systematic.com.hk/android/response.php?student=" +
                            finalStudent + "&course=" + finalCourse;
                    HttpGet httpGetRequest = new HttpGet(url);
                    try {
                        HttpResponse httpResponse = new DefaultHttpClient().execute(httpGetRequest);
                        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                            strResult = EntityUtils.toString(httpResponse.getEntity());
                        } else {
                            strResult = "Error Response: " +
                                        httpResponse.getStatusLine().toString();
                        }
                    } catch (Exception e) {
                        strResult = e.getMessage().toString();
                        e.printStackTrace();
                    }
                    break;
                    */

                case "POST":
                    String pUrl ="https://reserve.cdn-apple.com/HK/zh_HK/reserve/iPhone/availability?channel=1&appleCare=N&iPP=N&partNumber=MKQL2ZP/A&returnURL=http%3A%2F%2Fwww.apple.com%2Fhk%2Fshop%2Fbuy-iphone%2Fiphone6s&store=R428";

                    //cookie test 3+
                    /*
                    DefaultHttpClient httpclient = new DefaultHttpClient();
                    CookieStore lCS = new BasicCookieStore();

                    Log.e("Fdfa","diu");
                    if (CookieManager.getInstance().getCookie(pUrl) != null) {
                        String cookieString = CookieManager.getInstance().getCookie(pUrl);
                        Log.e("fuck","cookieString");
                        String[] urlCookieArray = cookieString.split(";");
                        for (int i = 0; i < urlCookieArray.length; i++) {
                            strResult += urlCookieArray[i];
                            //System.out.println(urlCookieArray[i]);
                            //String[] singleCookie = urlCookieArray[i].split("=");
                            //Cookie urlCookie = new BasicClientCookie(singleCookie[0], singleCookie[1]);
                            //lCS.addCookie(urlCookie);
                        }

                    }
                    */
                    //cookie test 3-


                    //HttpClient client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();

                    //url = "https://reserve.cdn-apple.com/HK/zh_HK/reserve/iPhone/availability?channel=1&appleCare=N&iPP=N&partNumber=MKQL2ZP/A&returnURL=http%3A%2F%2Fwww.apple.com%2Fhk%2Fshop%2Fbuy-iphone%2Fiphone6s&store=R499";
                    url ="https://reserve.cdn-apple.com/HK/zh_HK/reserve/iPhone/availability?channel=1&appleCare=N&iPP=N&partNumber=MKQL2ZP/A&returnURL=http%3A%2F%2Fwww.apple.com%2Fhk%2Fshop%2Fbuy-iphone%2Fiphone6s&store=R428";

                    //cookie test2 +

                    DefaultHttpClient httpclient = new DefaultHttpClient();
                    CookieStore cookieStore = httpclient.getCookieStore();
                    BasicClientCookie cookie = new BasicClientCookie("dims", "sWa44j1e3NlY5BSo9z4ofjb75PaK4Vpjt3Q9cUVlOrlve7FZ14xUC550iakAxw63UYOKES5jfzmkqQ32SCXC_J4yy2XCxUC541jlS7spjt3Q9cUVlOrXTAxw63UYOKES5jfzmkqR7bhpfw8QRUybYb3tG13VFwKgrmUsc8kHtgRvw0BpUMnGWQsnlihtbJbSy29XXTneNufuyPBDjaY2ftckuyPB884akHGOg4147NTlNISIHrur_D.RdPPg1wWF9kmFxTnx9MsFr9felpLY_n_nHDwdfs.xLB.Tf1idrNtG.pN4t23f282pA1zCpUeCSFQ_KpN__ISWHGY6TjJvDOhhMETcouU.UyMDMC9mKlCjtxTdqRnQPiTxGdotzwZJRMQEjiCEkNzLvRSz_vjPSnur9mt.yzYEzpJckQPiIhgjeHNDSw6bzSwezcmoz5Rz4NhzelQttyUshugcCdDvurOaiy2UnpXM3IvIIE0HlByrkFJEnYbQhrb_GGEOpBSGpUPSbB5qfXlAmjJvDOhhM4XM0oGN_tvfvCSnBNle.BNlYCa1nkBMfs.9Ut");
                    cookie.setDomain("reserve.cdn-apple.com");
                    cookie.setPath("/HK/zh_HK/reserve/iPhone/");
                    cookieStore.addCookie(cookie);
                    httpclient.setCookieStore(cookieStore);

                    BasicClientCookie cookie2 = new BasicClientCookie("s_pathLength", "hk%3D1%2C" );
                    cookie2.setDomain(".cdn-apple.com");
                    cookie2.setPath("/");
                    cookieStore.addCookie(cookie2);

                    BasicClientCookie cookie3 = new BasicClientCookie("s_orientationHeight", "527" );
                    cookie3.setDomain(".cdn-apple.com");
                    cookie3.setPath("/");
                    cookieStore.addCookie(cookie3);

                    BasicClientCookie cookie4 = new BasicClientCookie("s_cc", "true" );
                    cookie4.setDomain(".cdn-apple.com");
                    cookie4.setPath("/");
                    cookieStore.addCookie(cookie4);

                    BasicClientCookie cookie5 = new BasicClientCookie("s_fid", "2C39797A21675F14-2933D518442C4BE1" );
                    cookie5.setDomain(".cdn-apple.com");
                    cookie5.setPath("/");
                    cookieStore.addCookie(cookie5);

                    BasicClientCookie cookie6 = new BasicClientCookie("s_ppv", "ireserve%2520check%2520availability%2520%2528hk%2529%2C40%2C21%2C527%2C100%3A2%7C200%3A2%7C300%3A%3E%7C400%3A%3E%7C500%3A%3E%7C600%3A%3E" );
                    cookie6.setDomain(".cdn-apple.com");
                    cookie6.setPath("/");
                    cookieStore.addCookie(cookie6);

                    BasicClientCookie cookie7 = new BasicClientCookie("s_orientation", "%5B%5BB%5D%5D");
                    cookie7.setDomain(".cdn-apple.com");
                    cookie7.setPath("/");
                    cookieStore.addCookie(cookie7);

                    BasicClientCookie cookie8 = new BasicClientCookie("s_invisit_n2_hk", "0");
                    cookie8.setDomain(".cdn-apple.com");
                    cookie8.setPath("/");
                    cookieStore.addCookie(cookie8);
                    
                    BasicClientCookie cookie9 = new BasicClientCookie("s_vnum_n2_hk", "0%7C6");
                    cookie9.setDomain(".cdn-apple.com");
                    cookie9.setPath("/");
                    cookieStore.addCookie(cookie9);

                    BasicClientCookie cookie10 = new BasicClientCookie("s_sq", "%5B%5BB%5D%5D");
                    cookie10.setDomain(".cdn-apple.com");
                    cookie10.setPath("/");
                    cookieStore.addCookie(cookie10);

                    BasicClientCookie cookie11 = new BasicClientCookie("s_fid", "4F9A564389A20266-0B2A9A0740D4AEEC");
                    cookie11.setDomain(".apple.com");
                    cookie11.setPath("/");
                    cookieStore.addCookie(cookie11);

                    BasicClientCookie cookie12 = new BasicClientCookie("s_pathLength", "homepage%3D1%2C");
                    cookie12.setDomain(".apple.com");
                    cookie12.setPath("/");
                    cookieStore.addCookie(cookie12);

                    BasicClientCookie cookie13 = new BasicClientCookie("s_invisit_n2_hk", "3");
                    cookie13.setDomain(".apple.com");
                    cookie13.setPath("/");
                    cookieStore.addCookie(cookie13);


                    BasicClientCookie cookie14 = new BasicClientCookie("s_vnum_n2_hk", "3%7C1");
                    cookie14.setDomain(".apple.com");
                    cookie14.setPath("/");
                    cookieStore.addCookie(cookie14);

                    BasicClientCookie cookie15 = new BasicClientCookie("s_ppv", "apple%2520-%2520index%2Ftab%2520%2528hk%2529%2C53%2C53%2C659%2C");
                    cookie15.setDomain(".apple.com");
                    cookie15.setPath("/");
                    cookieStore.addCookie(cookie15);

                    BasicClientCookie cookie16 = new BasicClientCookie("dslang", "HK-ZH");
                    cookie16.setDomain(".apple.com");
                    cookie16.setPath("/");
                    cookieStore.addCookie(cookie16);

                    BasicClientCookie cookie17 = new BasicClientCookie("site", "HKG");
                    cookie17.setDomain(".apple.com");
                    cookie17.setPath("/");
                    cookieStore.addCookie(cookie17);

                    BasicClientCookie cookie18 = new BasicClientCookie("s_vi", "[CS]v1|2B03DE5285012E71-6000011020018B11[CE]");
                    cookie18.setDomain(".apple.com");
                    cookie18.setPath("/");
                    cookieStore.addCookie(cookie18);

                    httpclient.setCookieStore(cookieStore);
                    // Prepare a request object
                    HttpPost httpPostRequest = new HttpPost(url);
                    List<NameValuePair> urlParams = new ArrayList<NameValuePair>();
                    //urlParams.add(new BasicNameValuePair("student", txtStudent.getText().toString()));
                    //urlParams.add(new BasicNameValuePair("course", txtCourse.getText().toString()));
                    urlParams.add(new BasicNameValuePair("selectedStore", "R499"));
                    urlParams.add(new BasicNameValuePair("selectedProduct", "MKQL2ZP/A"));
                    urlParams.add(new BasicNameValuePair("returnURL", "http://www.apple.com/hk/shop/buy-iphone/iphone6s"));

                    urlParams.add(new BasicNameValuePair("channel", "1"));
                    urlParams.add(new BasicNameValuePair("sourceID", ""));
                    urlParams.add(new BasicNameValuePair("_eventId", "next"));
                    urlParams.add(new BasicNameValuePair("language",""));

                    urlParams.add(new BasicNameValuePair("p_ie", ""));
                    urlParams.add(new BasicNameValuePair("_flowExecutionKey", ""));

                    urlParams.add(new BasicNameValuePair("appleCare", "N"));
                    urlParams.add(new BasicNameValuePair("carrier", ""));
                    urlParams.add(new BasicNameValuePair("channel", "1"));
                    urlParams.add(new BasicNameValuePair("iPP", "N"));
                    urlParams.add(new BasicNameValuePair("execution","e1s1"));
                    urlParams.add(new BasicNameValuePair("appIdKey","db0114b11bdc2a139e5adff448a1d7325febef288258f0dc131d6ee9afe63df3"));
                    urlParams.add(new BasicNameValuePair("language","HK-ZH"));
                    urlParams.add(new BasicNameValuePair("p_left","AAAAAARuuLOsX6SDOmFvN6nGCZ7mKkGpuoxp7MYOnbQE/oH7yQ=="));
                    urlParams.add(new BasicNameValuePair("path", "/HK/zh_HK/reserve/iPhone?execution=e1s1&p_left=AAAAAARuuLOsX6SDOmFvN6nGCZ7mKkGpuoxp7MYOnbQE%2FoH7yQ%3D%3D&_eventId=next"));
                    urlParams.add(new BasicNameValuePair("rv","3"));

                    CookieStore lCS = new BasicCookieStore();
                    HttpContext localContext = new BasicHttpContext();
                    httpclient.setCookieStore(cookieStore);
                    localContext.setAttribute(ClientContext.COOKIE_STORE, lCS);

                    try {
                        httpPostRequest.setEntity(new UrlEncodedFormEntity(urlParams, HTTP.UTF_8));
                        HttpResponse httpResponse = httpclient.execute(httpPostRequest, localContext);
                        //HttpResponse httpResponse = new DefaultHttpClient().execute(httpPostRequest,localContext);
                        if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                            strResult = EntityUtils.toString(httpResponse.getEntity());
                        } else {
                            strResult = "Error Response: " +
                                    httpResponse.getStatusLine().toString();
                        }
                    } catch (Exception e) {
                        strResult = e.getMessage().toString();
                        e.printStackTrace();
                    }
                    /*
                    // Execute the request
                    try {
                        HttpResponse response = httpclient.execute(httpget);

                    // Examine the response status
                    //Log.e("Http request response is: " ,response.getStatusLine());
                    strResult = response.getStatusLine().toString();
                    }
                    catch (Exception e) {

                        e.printStackTrace();
                    }
                    */
                    List<Cookie> cookies = cookieStore.getCookies();


                    for (int i=0; i<cookies.size();i++) {

                        //if (cookies.get(i).getName().toString().equals("abc")) {
                            Log.e("cookie is: " ,cookies.get(i).getValue().toString());
                        //}
                    }

                    //cooke test 2-
                    //cookie test +
                    /*
                    DefaultHttpClient httpclient = new DefaultHttpClient();
                    //Log.d("Loop ","fdfa");
                    //HttpGet httpget = new HttpGet("https://portal.sun.com/portal/dt");
                    HttpGet httpget = new HttpGet(url);
                    try {
                        HttpResponse response = httpclient.execute(httpget);

                    HttpEntity entity = response.getEntity();
                    //strResult = response.getStatusLine().toString();
                    Log.e("Login form get: ", response.getStatusLine().toString());

                    if (entity != null) {
                        entity.consumeContent();
                    }
                    }
                    catch (Exception e) {
                        strResult = e.getMessage().toString();
                        e.printStackTrace();
                    }
                    //System.out.println("Initial set of cookies:");
                    List<Cookie> cookies = httpclient.getCookieStore().getCookies();
                    if (cookies.isEmpty()) {
                        //System.out.println("None");
                        strResult += "No cookie";
                    } else {
                        for (int i = 0; i < cookies.size(); i++) {
                          //  Log.e("- diu",cookies.get(i).toString());
                            strResult += " " + cookies.get(i).toString();
                        }
                    }
                    */
                    //cookie test -

                    /*
                    HttpPost httpPostRequest = new HttpPost(url);
                    List<NameValuePair> urlParams = new ArrayList<NameValuePair>();
                    //urlParams.add(new BasicNameValuePair("student", txtStudent.getText().toString()));
                    //urlParams.add(new BasicNameValuePair("course", txtCourse.getText().toString()));
                    urlParams.add(new BasicNameValuePair("selectedStore", "R499"));
                    urlParams.add(new BasicNameValuePair("selectedProduct", "MKQL2ZP/A"));
                    urlParams.add(new BasicNameValuePair("returnURL", "http://www.apple.com/hk/shop/buy-iphone/iphone6s"));

                    urlParams.add(new BasicNameValuePair("channel", "1"));
                    urlParams.add(new BasicNameValuePair("sourceID", ""));
                    urlParams.add(new BasicNameValuePair("_eventId", "next"));
                    urlParams.add(new BasicNameValuePair("language",""));
                    */

                    /*
                    urlParams.add(new BasicNameValuePair("dims", "sWa44j1e3NlY5BSo9z4ofjb75PaK4Vpjt3Q9cUVlOrlve7FZ14xUC550iakAxw63UYOKES5jfzmkqQ32SCXC_J4yy2XCxUC541jl\n" +
                            "S7spjt3Q9cUVlOrXTAxw63UYOKES5jfzmkqR7bhpfw8QRUybYb3tG13VFwKgrmUsc8kHtgRvw0BpUMnGWQsnlihtbJbSy29XXTneNufuyPBDjaY2ftckuyPB884akHGOg4147NFHxOF02UfTJs0m_dekAm4\n" +
                            ".f282pvEodUW2Reif6KPDMDMC7vaCU.6elV2pNKpDv6975f.j7N_NO7TdNMtTnwBhp0iKMKXLKCq485BSuxIgtaqpRxuYIdw0ztR\n" +
                            "tRof8M3qzbpubOnChetvp5bIbzmGGlSgyysoz0YxQhlryMixdrEfRfAZ2vyBzzKHY0hetDqmyd8VtrkTUxrmfyYAIwOnwKXryf4jbbtzXremVqZvjfSaPvsCzEL8RGEhCBw4A3nvU00FzDDSirTTK43xbJlp6KxdqRkQPiA3j9xIgtaqpRL8R6G4XMbijgprBlY5c\n" +
                            ".lY5BqNAE.lTjV.95o"));
                            */
                    /*
                    urlParams.add(new BasicNameValuePair("p_ie", ""));
                    urlParams.add(new BasicNameValuePair("_flowExecutionKey", ""));

                    urlParams.add(new BasicNameValuePair("appleCare", "N"));
                    urlParams.add(new BasicNameValuePair("carrier", ""));
                    urlParams.add(new BasicNameValuePair("channel", "1"));
                    urlParams.add(new BasicNameValuePair("iPP", "N"));
                    urlParams.add(new BasicNameValuePair("execution","e1s1"));
                    urlParams.add(new BasicNameValuePair("appIdKey","db0114b11bdc2a139e5adff448a1d7325febef288258f0dc131d6ee9afe63df3"));
                    urlParams.add(new BasicNameValuePair("language","HK-ZH"));
                    urlParams.add(new BasicNameValuePair("p_left","AAAAAARuuLOsX6SDOmFvN6nGCZ7mKkGpuoxp7MYOnbQE/oH7yQ=="));
                    urlParams.add(new BasicNameValuePair("path","/HK/zh_HK/reserve/iPhone?execution=e1s1&p_left=AAAAAARuuLOsX6SDOmFvN6nGCZ7mKkGpuoxp7MYOnbQE%2FoH7yQ%3D%3D&_eventId=next"));
                    urlParams.add(new BasicNameValuePair("rv","3"));
                    try {
                        httpPostRequest.setEntity(new UrlEncodedFormEntity(urlParams, HTTP.UTF_8));
                        HttpResponse httpResponse = new DefaultHttpClient().execute(httpPostRequest);
                        if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                            strResult = EntityUtils.toString(httpResponse.getEntity());
                        } else {
                            strResult = "Error Response: " +
                                    httpResponse.getStatusLine().toString();
                        }
                    } catch (Exception e) {
                        strResult = e.getMessage().toString();
                        e.printStackTrace();
                    }
                    */

                /*
                case "POST":
                    url = "http://www.systematic.com.hk/android/response.php";
                    HttpPost httpPostRequest = new HttpPost(url);
                    List<NameValuePair> urlParams = new ArrayList<NameValuePair>();
                    urlParams.add(new BasicNameValuePair("student", txtStudent.getText().toString()));
                    urlParams.add(new BasicNameValuePair("course", txtCourse.getText().toString()));
                    try {
                        httpPostRequest.setEntity(new UrlEncodedFormEntity(urlParams, HTTP.UTF_8));
                        HttpResponse httpResponse = new DefaultHttpClient().execute(httpPostRequest);
                        if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                            strResult = EntityUtils.toString(httpResponse.getEntity());
                        } else {
                            strResult = "Error Response: " +
                                        httpResponse.getStatusLine().toString();
                        }
                    } catch (Exception e) {
                        strResult = e.getMessage().toString();
                        e.printStackTrace();
                    }
                */

            }
            return strResult;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            txtResult.setText(result);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_internet_data, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

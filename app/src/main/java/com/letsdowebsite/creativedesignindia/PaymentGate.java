package com.letsdowebsite.creativedesignindia;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PaymentGate extends Activity {
    private ArrayList<String> post_val = new ArrayList<String>();
    private String post_Data="";
    WebView webView ;
    final Activity activity = this;
    private String tag = "PaymentGate";
    private String hash,hashSequence;

    String merchant_key="dlKTkP";
    String salt="JoqFVdj0";
    String action1 ="";
    String base_url="https://secure.payu.in/_payment";
    int error=0;
    String hashString="";
    Map<String, String> params;
    String txnid ="";

    Handler mHandler = new Handler();


    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        final ProgressDialog progressDialog = new ProgressDialog(activity);
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        webView = new WebView(this);
        setContentView(webView);

        post_val.add("key");
        post_val.add("dlKTkP");
        post_val.add("txnid");
        post_val.add("5d59dae66618a14f5020");
        post_val.add("amount");
        post_val.add("9999.00");
        post_val.add("productinfo");

        post_val.add("{paymentParts:[{name:abc,description:abcd,value:500,isRequired:true,settlementEvent:EmailConfirmation}], paymentIdentifiers:[{field:CompletionDate, value:25/06/2015}]}");
        post_val.add("firstname");
        post_val.add("pqrs");
        post_val.add("email");
        post_val.add("");
        post_val.add("phone");
        post_val.add("");
        post_val.add("surl");
        post_val.add("");
        post_val.add("furl");
        post_val.add("");
        post_val.add("hash");
        post_val.add("");
        post_val.add("provider");
        post_val.add("payu_paisa");
        Log.d(tag, "post_val: "+post_val);
        params= new HashMap<String, String>();
        for(int i = 0;i<post_val.size();){
            params.put(post_val.get(i), post_val.get(i+1));

            i+=2;
        }

        if(empty(params.get("txnid"))){
            Random rand = new Random();
            String rndm = Integer.toString(rand.nextInt())+(System.currentTimeMillis() / 1000L);
            txnid=hashCal("SHA-256",rndm).substring(0,20);
            popup("txnid : " + txnid);
            System.out.println("......txnid...... " + txnid);
        } else {
            txnid=params.get("txnid");
            System.out.println("....else.......txnid...... " + txnid);
        }

        //String udf2 = txnid;
        String txn="abcd";
        hash="";
        String hashSequence = "key|txnid|amount|productinfo|firstname|email|udf1|udf2|udf3|udf4|udf5|udf6|udf7|udf8|udf9|udf10";
        if(empty(params.get("hash")) && params.size()>0) {
            if( empty(params.get("key"))
                    || empty(params.get("txnid"))
                    || empty(params.get("amount"))
                    || empty(params.get("firstname"))
                    || empty(params.get("email"))
                    || empty(params.get("phone"))
                    || empty(params.get("productinfo"))
                    || empty(params.get("surl"))
                    || empty(params.get("furl"))
                    || empty(params.get("service_provider"))

            ) {
                String[] hashVarSeq = hashSequence.split("\\|");
                for (int i = 0; i < hashVarSeq.length; i++) {
                    System.out.println("<<<<<>>>>>>>> " + hashVarSeq[i]);
                }

                for(String part : hashVarSeq)
                {
                    hashString= (empty(params.get(part))) ? hashString.concat("") : hashString.concat(params.get(part));
                    hashString=hashString.concat("|");
                    System.out.println("??????? " + hashString);
                }
                hashString=hashString.concat(salt);


                hash=hashCal("SHA-512",hashString);
                System.out.println(hashString + " /////~~~~~~ " + hash);
                action1=base_url.concat("/_payment");
            }
        }
        else if(!empty(params.get("hash")))
        {
            hash=params.get("hash");
            action1=base_url.concat("/_payment");
            System.out.println("!!!!!!!!HASHHHHHHH!!!!!! " + hash);
        }

        webView.setWebViewClient(new WebViewClient(){


            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                // TODO Auto-generated method stub
                System.out.println(">>>>>>>>>>>>>>onReceivedError>>>>>>>>>>>>>>>>>>");
                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onReceivedSslError(WebView view,
                                           SslErrorHandler handler, SslError error) {
                // TODO Auto-generated method stub
                System.out.println(">>>>>>>>>>>>>>onReceivedSslError>>>>>>>>>>>>>>>>>>");
                Toast.makeText(activity, "SslError! " +  error, Toast.LENGTH_SHORT).show();
                handler.proceed();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                System.out.println(">>>>>>>>>>>>>>shouldOverrideUrlLoading>>>>>>>>>>>>>>>>>>");
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // TODO Auto-generated method stub
                super.onPageFinished(view, url);
                System.out.println(">>>>>>>>>>>>>>onPageFinished>>>>>>>>>>>>>>>>>>");
            }


        });


        webView.setVisibility(0);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setCacheMode(2);
        webView.getSettings().setDomStorageEnabled(true);
        webView.clearHistory();
        webView.clearCache(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setUseWideViewPort(false);
        webView.getSettings().setLoadWithOverviewMode(false);

        webView.addJavascriptInterface(new PayUJavaScriptInterface(activity), "PayUMoney");
        Map<String, String> mapParams = new HashMap<String, String>();
        mapParams.put("key",merchant_key);
        mapParams.put("hash", PaymentGate.this.hash);
        mapParams.put("txnid",(empty(PaymentGate.this.params.get("txnid"))) ? "" : PaymentGate.this.params.get("txnid"));
        Log.d(tag, "txnid: "+ PaymentGate.this.params.get("txnid"));
        mapParams.put("service_provider","payu_paisa");

        mapParams.put("amount",(empty(PaymentGate.this.params.get("amount"))) ? "" : PaymentGate.this.params.get("amount"));
        mapParams.put("firstname",(empty(PaymentGate.this.params.get("firstname"))) ? "" : PaymentGate.this.params.get("firstname"));
        mapParams.put("email",(empty(PaymentGate.this.params.get("email"))) ? "" : PaymentGate.this.params.get("email"));
        mapParams.put("phone",(empty(PaymentGate.this.params.get("phone"))) ? "" : PaymentGate.this.params.get("phone"));

        mapParams.put("productinfo",(empty(PaymentGate.this.params.get("productinfo"))) ? "" : PaymentGate.this.params.get("productinfo"));
        mapParams.put("surl",(empty(PaymentGate.this.params.get("surl"))) ? "" : PaymentGate.this.params.get("surl"));
        mapParams.put("furl",(empty(PaymentGate.this.params.get("furl"))) ? "" : PaymentGate.this.params.get("furl"));
        mapParams.put("lastname",(empty(PaymentGate.this.params.get("lastname"))) ? "" : PaymentGate.this.params.get("lastname"));

        mapParams.put("address1",(empty(PaymentGate.this.params.get("address1"))) ? "" : PaymentGate.this.params.get("address1"));
        mapParams.put("address2",(empty(PaymentGate.this.params.get("address2"))) ? "" : PaymentGate.this.params.get("address2"));
        mapParams.put("city",(empty(PaymentGate.this.params.get("city"))) ? "" : PaymentGate.this.params.get("city"));
        mapParams.put("state",(empty(PaymentGate.this.params.get("state"))) ? "" : PaymentGate.this.params.get("state"));

        mapParams.put("country",(empty(PaymentGate.this.params.get("country"))) ? "" : PaymentGate.this.params.get("country"));
        mapParams.put("zipcode",(empty(PaymentGate.this.params.get("zipcode"))) ? "" : PaymentGate.this.params.get("zipcode"));
        mapParams.put("udf1",(empty(PaymentGate.this.params.get("udf1"))) ? "" : PaymentGate.this.params.get("udf1"));
        mapParams.put("udf2",(empty(PaymentGate.this.params.get("udf2"))) ? "" : PaymentGate.this.params.get("udf2"));

        mapParams.put("udf3",(empty(PaymentGate.this.params.get("udf3"))) ? "" : PaymentGate.this.params.get("udf3"));
        mapParams.put("udf4",(empty(PaymentGate.this.params.get("udf4"))) ? "" : PaymentGate.this.params.get("udf4"));
        mapParams.put("udf5",(empty(PaymentGate.this.params.get("udf5"))) ? "" : PaymentGate.this.params.get("udf5"));
        mapParams.put("pg",(empty(PaymentGate.this.params.get("pg"))) ? "" : PaymentGate.this.params.get("pg"));
        webview_ClientPost(webView, action1, mapParams.entrySet());

    }
    public class PayUJavaScriptInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        PayUJavaScriptInterface(Context c) {
            mContext = c;
        }


        public void success(long id, final String paymentId) {

            mHandler.post(new Runnable() {

                public void run() {

                    mHandler = null;

                    Intent intent = new Intent(PaymentGate.this, MainActivity.class);

                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

                    intent.putExtra("result", "success");

                    intent.putExtra("paymentId", paymentId);

                    startActivity(intent);

                    finish();

                }

            });

        }

    }
    public void webview_ClientPost(WebView webView, String url, Collection< Map.Entry<String, String>> postData){
        StringBuilder sb = new StringBuilder();

        sb.append("<html><head></head>");
        sb.append("<body onload='form1.submit()'>");
        sb.append(String.format("<form id='form1' action='%s' method='%s'>", url, "post"));
        for (Map.Entry<String, String> item : postData) {
            sb.append(String.format("<input name='%s' type='hidden' value='%s' />", item.getKey(), item.getValue()));
        }
        sb.append("</form></body></html>");
        Log.d(tag, "webview_ClientPost called");
        webView.loadData(sb.toString(), "text/html", "utf-8");
    }


    public void success(long id, final String paymentId) {

        mHandler.post(new Runnable() {

            public void run() {

                mHandler = null;

                Intent intent = new Intent(PaymentGate.this, MainActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

                intent.putExtra(SyncStateContract.Constants.ACCOUNT_NAME, "success");

                intent.putExtra(SyncStateContract.Constants._ID, paymentId);

                startActivity(intent);

                finish();

            }

        });

    }


    public boolean empty(String s)
    {
        if(s== null || s.trim().equals(""))
            return true;
        else
            return false;
    }

    public String hashCal(String type, String str){
        byte[] hashseq=str.getBytes();
        StringBuffer hexString = new StringBuffer();
        try{
            MessageDigest algorithm = MessageDigest.getInstance(type);
            algorithm.reset();
            algorithm.update(hashseq);
            byte messageDigest[] = algorithm.digest();



            for (int i=0;i<messageDigest.length;i++) {
                String hex= Integer.toHexString(0xFF & messageDigest[i]);
                if(hex.length()==1) hexString.append("0");
                hexString.append(hex);
            }

        }catch(NoSuchAlgorithmException nsae){ }

        return hexString.toString();


    }

    public void popup(String msg) {
        Toast.makeText(PaymentGate.this, "" + msg, Toast.LENGTH_LONG).show();
    }


}
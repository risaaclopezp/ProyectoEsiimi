package com.losgangnamstyle.proyectoesiimi.extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public abstract class cAsyncTask extends AsyncTask<String, Integer, String> {
 
        public static final int POST_TASK = 1;
        public static final int GET_TASK = 2;
        public static final int PUT_TASK = 3;
        public static final int DELETE_TASK = 4;
         
        private static final String TAG = "cAsyncTask";
 
        // connection timeout, in milliseconds (waiting to connect)
        private static final int CONN_TIMEOUT = 3000;
         
        // socket timeout, in milliseconds (waiting for data)
        private static final int SOCKET_TIMEOUT = 5000;
         
        private int taskType = GET_TASK;
        private Context mContext = null;
        private String processMessage = "Processing...";
 
        //private ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        private JSONObject dato = new JSONObject();
        
        protected ProgressDialog pDlg = null;
 
        public cAsyncTask(int taskType, Context mContext, String processMessage) {
 
            this.taskType = taskType;
            this.mContext = mContext;
            this.processMessage = processMessage;
        }
 
        public void addNameValuePair(String name, String value) {
 
            //params.add(new BasicNameValuePair(name, value));
            try {
				dato.put(name, value);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
 
        @SuppressWarnings("deprecation")
		private void showProgressDialog() {
             
            pDlg = new ProgressDialog(mContext);
            pDlg.setMessage(processMessage);
            pDlg.setProgressDrawable(mContext.getWallpaper());
            pDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDlg.setCancelable(false);
            pDlg.show();
 
        }
 
        @Override
        protected void onPreExecute() {
 
            
            showProgressDialog();
 
        }
 
        protected String doInBackground(String... urls) {
 
            String url = urls[0];
            String result = "";
 
            HttpResponse response = doResponse(url);
 
            if (response == null) {
                return result;
            } else {
 
                try {
 
                    result = inputStreamToString(response.getEntity().getContent());
 
                } catch (IllegalStateException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);
 
                } catch (IOException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);
                }
 
            }
            return result;
        }
 
        
         
        // Establish connection and socket (data retrieval) timeouts
        private HttpParams getHttpParams() {
             
            HttpParams htpp = new BasicHttpParams();
             
            HttpConnectionParams.setConnectionTimeout(htpp, CONN_TIMEOUT);
            HttpConnectionParams.setSoTimeout(htpp, SOCKET_TIMEOUT);
             
            return htpp;
        }
         
        public HttpResponse doResponse(String url) {
             
            
            DefaultHttpClient httpclient = new DefaultHttpClient(getHttpParams());

            HttpResponse response = null;
 
            try {
                switch (taskType) {
 
                case POST_TASK:
                {
                	HttpPost httpPost = new HttpPost(url);
                	httpPost.setHeader("content-type", "application/json");
                	httpPost.setHeader("Accept", "application/json");
                	
                	StringEntity entity = new StringEntity(dato.toString());

                	try {
                	    httpPost.setEntity(entity);
                	    response = httpclient.execute(httpPost);
                	} catch (ClientProtocolException e) {
                	    Log.e(TAG, "ClientProtocolException: " + e);
                	} catch (IOException e) {
                	    Log.e(TAG, "IOException: " + e);
                	}
                        
                    break;
                }
                case GET_TASK:
                {
                    HttpGet httpget = new HttpGet(url);
                    httpget.setHeader("content-type", "application/json");
                    httpget.setHeader("Accept", "application/json");
                    
                    try {
                	    response = httpclient.execute(httpget);
                	} catch (ClientProtocolException e) {
                	    Log.e(TAG, "ClientProtocolException: " + e);
                	} catch (IOException e) {
                	    Log.e(TAG, "IOException: " + e);
                	}
                    break;
                }
                case PUT_TASK:
                {
                	HttpPut httpPut = new HttpPut(url);
                	httpPut.setHeader("content-type", "application/json");
            	    httpPut.setHeader("Accept", "application/json");
            	    
            	    StringEntity entity = new StringEntity(dato.toString());
            	    
            	    try {
                	    httpPut.setEntity(entity);
                	    response = httpclient.execute(httpPut);
                	} catch (ClientProtocolException e) {
                	    Log.e(TAG, "ClientProtocolException: " + e);
                	} catch (IOException e) {
                	    Log.e(TAG, "IOException: " + e);
                	}
            	    break;
                }
                case DELETE_TASK:
                {
                	HttpDelete httpDelete = new HttpDelete(url);
                	httpDelete.setHeader("content-type", "application/json");
            	    httpDelete.setHeader("Accept", "application/json");
            	    
            	    try {
                	    response = httpclient.execute(httpDelete);
                	} catch (ClientProtocolException e) {
                	    Log.e(TAG, "ClientProtocolException: " + e);
                	} catch (IOException e) {
                	    Log.e(TAG, "IOException: " + e);
                	}
                }
                }
            } catch (Exception e) {
 
                Log.e(TAG, e.getLocalizedMessage()+"No entro", e);
 
            }
 
            return response;
        }
         
        public String inputStreamToString(InputStream is) {
 
            String line = "";
            StringBuilder total = new StringBuilder();
 
            // Wrap a BufferedReader around the InputStream
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
 
            try {
                // Read response until the end
                while ((line = rd.readLine()) != null) {
                    total.append(line);
                }
            } catch (IOException e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
            }
 
            // Return full string
            return total.toString();
        }
        
        protected abstract void onPostExecute(String response);
 
    }


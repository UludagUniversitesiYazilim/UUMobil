package com.example.berkay.uumobil.DataOperations;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.berkay.uumobil.MainActivity;
import com.uumobilGet.ConnectWebPersonal;
import com.uumobilGet.PageLinks;

public final class BackgroundProcces extends AsyncTask<RequestFrom, String, Object> {
    private ConnectWebPersonal personalConnection;
    private boolean finished;
    private Context context;
    private MainActivity activtiy;
    private WriteDb DBOperations;
    private String username;
    private String password;
    ProgressDialog progressDialog;

    public BackgroundProcces(Context context) {
        this.context = context;
        DBOperations = new WriteDb(this.context);
    }

    public BackgroundProcces(Context context, MainActivity activity, String username, String password){
        this.context = context;
        this.username = username;
        this.password = password;
        this.activtiy = activity;
        DBOperations = new WriteDb(this.context);
    }

    private ConnectWebPersonal connect(String username, String password){
        if (this.personalConnection == null) {
            Log.d("TAG", username);
            Log.d("TAG", password);
            this.personalConnection = new ConnectWebPersonal(PageLinks.LOGIN.getUrl(),
                    username,
                    password);
            return this.personalConnection;
        }
        else
            return this.personalConnection;
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        finished = false;
        progressDialog = new ProgressDialog(activtiy);
        progressDialog.setMessage("Yükleniyor...");
        progressDialog.show();
        // İnternet varlığı kontrolü ve bağlantının
        // hazır olup olmadığı kontrolü yapılacak.
    }

    @Override
    protected Object doInBackground(RequestFrom... requestFroms) {
        final String TAG = "BackProc/doInBackground";
        publishProgress("Uzak sunucuya giriş yapılıyor");
        ConnectWebPersonal connection = connect(username, password);
        Log.i(TAG, "Uzak sunucuya giriş yapıldı");
        publishProgress("Kişisel veriler alınıyor");
        DBOperations.writePersonal(connection);
        publishProgress("Sınav sonuçları alınıyor");
        DBOperations.writeResults(connection);
        publishProgress("Yemek listesi alınıyor");
        DBOperations.writeFoodList();
        publishProgress("Transkript alınıyor");
        DBOperations.writeTranscript(connection);

        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        progressDialog.setMessage(values[0]);
    }

    @Override
    protected void onPostExecute(Object o) {
        DBOperations.closeDB();
        finished = true;
        progressDialog.dismiss();
    }

}

package com.cemalyaver.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences; //preferences için bir nesne tanımlıyorum.
    SharedPreferences.Editor editor; //preferences içerisine bilgi girmek için tanımlama


    EditText editAdi;
    EditText editSoyadi;
    Button btnKaydet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = preferences.edit();
        editAdi=(EditText) findViewById(R.id.editAdi);
        editSoyadi=(EditText) findViewById(R.id.editSoyadi);
        String adibilgisi=preferences.getString("adi", "Ad Girin");
//ad bilgisi kayıtlıysa adibilgisi değişkenine yazılacak, değilse Ad girin stringi aktarılacak. Yani varsayılan değer.
        String soyadiBilgisi= preferences.getString("soyadi", "Soyad girin");
//soyad bilgisi kayıtlıysa soyadibilgisi değişkenine yazılacak, değilse Soyad girin stringi aktarılacak. Yani varsayılan değer.

        editAdi.setText(adibilgisi);
//editAdi nesnesine adibilgisini yazdırıyoruz.
        editSoyadi.setText(soyadiBilgisi);
//editSoyadi nesnesine soyadibilgisini yazdırıyoruz.
        btnKaydet=(Button)findViewById(R.id.btnKaydet);
//değer atamaları yapılıyor.
        btnKaydet.setOnClickListener(new View.OnClickListener() {
            //butona tıklanınca kayıt işlemi yapılacak.
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                editor.putString("adi", editAdi.getText().toString());
                editor.putString("soyadi", editSoyadi.getText().toString());
                editor.commit();
//bilgileri ekle ve kaydet
            }
        });
    }
}

package com.example.fructus.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    EditText etText;
    Button btnSave, btnLoad;

    SharedPreferences sPref;

    final String SAVED_TEXT = "saved_text";


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Находим View
        etText = (EditText) findViewById(R.id.etText);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        sPref = getSharedPreferences("Text",MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        etText.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
            default:
                break;
        }
    }

    //Метод сохранения текста
    void saveText() {

        /*//Получаем обьект SharedPreferences который позволяет работать с данными
        sPref = getSharedPreferences("Text",MODE_PRIVATE);             //MODE_PRIVATE данные доступны только в приложении
        Editor ed = sPref.edit();                                      //обьект для изменения данных
        ed.putString(SAVED_TEXT, etText.getText().toString());         //метод для сохранения текста
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();*/
    }

    //Метод загруски
    void loadText() {
        /*sPref = getSharedPreferences("Text",MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        etText.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public void onDestroy(){

        sPref = getSharedPreferences("Text",MODE_PRIVATE);             //MODE_PRIVATE данные доступны только в приложении
        Editor ed = sPref.edit();                                      //обьект для изменения данных
        ed.putString(SAVED_TEXT, etText.getText().toString());         //метод для сохранения текста
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();

        super.onDestroy();
    }
}
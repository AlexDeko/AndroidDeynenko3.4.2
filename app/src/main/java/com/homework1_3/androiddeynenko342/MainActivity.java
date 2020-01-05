package com.homework1_3.androiddeynenko342;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Indent.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        final Spinner spinner = findViewById(R.id.spinner);
        final Spinner spinnerIndent = findViewById(R.id.spinnerIndent);
        final ArrayAdapter<CharSequence> adapterLanguages = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);
        adapterLanguages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterLanguages);
        final ArrayAdapter<CharSequence> adapterIndent = ArrayAdapter.createFromResource(this,
                R.array.indent, android.R.layout.simple_spinner_item);
        adapterIndent.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIndent.setAdapter(adapterIndent);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int language,
                                       long languages) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinnerIndent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int indent,
                                       long indents) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = spinner.getSelectedItem().toString();
                String itemIndent = spinnerIndent.getSelectedItem().toString();
                Locale locale;
                Configuration config = new Configuration();
                switch (item){
                    case "Русский":
                        locale = new Locale("ru");
                        config.setLocale(locale);
                        getResources().updateConfiguration(config,
                                getBaseContext().getResources().getDisplayMetrics());
                        break;
                    case "English":
                        locale = new Locale("en");
                        config.setLocale(locale);
                        getResources().updateConfiguration(config,
                                getBaseContext().getResources().getDisplayMetrics());
                        break;
                }
                switch (itemIndent){
                    case "Маленький":
                        Indent.changeToTheme(MainActivity.this, Indent.THEME_LITTLE);
                        break;
                    case "Средний":
                        Indent.changeToTheme(MainActivity.this, Indent.THEME_MIDDLE);
                        break;
                    case "Большой":
                        Indent.changeToTheme(MainActivity.this, Indent.THEME_BIG);
                        break;
                }
                recreate();
            }
        });
    }
}

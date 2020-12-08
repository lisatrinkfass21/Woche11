package net.ubung.reduce2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText etZaehler = findViewById(R.id.zaehler);
        EditText etNenner = findViewById(R.id.nenner);
        String zaehler = etZaehler.getText().toString();
        String nenner = etNenner.getText().toString();
        int za;
        int ne;
        try {
            za = Integer.parseInt(zaehler);
            ne = Integer.parseInt(nenner);
        } catch (Exception e) {
            za = 0;
            ne = 0;
        }
        int teiler = findggt(za, ne);
        int neuerZähler = za / teiler;
        int neuerNenner = ne / teiler;
        etZaehler.setText(String.valueOf(neuerZähler));
        etNenner.setText(String.valueOf(neuerNenner));

    }

    private int findggt(int za, int ne) {
        int h = (za > ne) ? za : ne;

        for (int i = h; i > 1; i--) {
            if ((za % i) == 0 && (ne % i) == 0) {
                return i;
            }
        }

        return 1;//keine gem. teiler außer 1
    }


}

package hali.dephant.dephanvn.pnd_cau1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.sqrt;


public class MainActivity extends AppCompatActivity {

    private EditText edtNhapa, edtNhapb, edtNhapc;
    private TextView txtNghiem, txtNghiem1, txtNghiem2;
    private Button btnGiai, btnThoat;

    private float a, b, c, x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNhapa = (EditText) findViewById(R.id.edt_Nhana);
        edtNhapb = (EditText) findViewById(R.id.edt_Nhapb);
        edtNhapc = (EditText) findViewById(R.id.edt_Nhapc);
        btnGiai= (Button) findViewById(R.id.btn_Giai);
        btnThoat= (Button) findViewById(R.id.btn_Thoat);
        txtNghiem = (TextView) findViewById(R.id.txt_Nghiem);
        txtNghiem1 = (TextView) findViewById(R.id.txt_Nghiem1);
        txtNghiem2 = (TextView) findViewById(R.id.txt_Nghiem2);

        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a = Float.parseFloat(edtNhapa.getText().toString());
                b = Float.parseFloat(edtNhapb.getText().toString());
                c = Float.parseFloat(edtNhapc.getText().toString());

                float delta;

                delta = b*b -4*a*c;

                if(delta>0){
                    delta = (float) sqrt(delta);
                    x1 = (-b + delta) / (2*a);
                    x2 = (-b - delta) / (2*a);

                    txtNghiem.setText("Phương trình:" + a+ "X^2 + " + b +"X + " + c + " = 0 có nghiệm");
                    txtNghiem1.setText("x1 = " + x1);
                    txtNghiem2.setText("x2 = " + x2);
                    Log.d("DePhan", "1" );

                }
                else if(delta == 0){
                    x1 = x2 = -b/(2*a);

                    txtNghiem.setText("Phương trình" + a+"X^2" + b+"X " + c + "= 0 có nghiệm");
                    txtNghiem1.setText("X1= "+ x1);
                    Log.d("DePhan", "2" );
                }
                else
                 {
                    txtNghiem.setText("Phương trình" + a + "X^2" + b + "X " + c + "= 0 vô nghiệm");
                    Log.d("DePhan", "3");
                }
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Good bye: DePhan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

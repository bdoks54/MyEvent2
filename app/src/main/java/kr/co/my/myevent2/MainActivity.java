package kr.co.my.myevent2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button birthDatePicker, specifiedDatePicker;
    Button showbio;
    EditText txtbirthdate, txtthedate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showComponent();
    }
    public void showComponent() {
        //layout에 있는 컴포넌트 객체 생성
        birthDatePicker = findViewById(R.id.birthDatePicker);
        specifiedDatePicker = findViewById(R.id.specifiedDatePicker);
        showbio = findViewById(R.id.showbio);
        txtbirthdate = findViewById(R.id.txtbirthdate);
        txtthedate = findViewById(R.id.txtthedate);

        birthDatePicker.setOnClickListener(new MyBioClicks());
        specifiedDatePicker.setOnClickListener(new MyBioClicks());
        showbio.setOnClickListener(new MyBioClicks());
    }

    class MyBioClicks implements View.OnClickListener{
        @Override
        public void onClick(View v){
            if(v==birthDatePicker){
                txtbirthdate.setText("Hello");
                //MainActivity.this.txtbirthdate.setText("Hello");
            }else if(v==specifiedDatePicker){
                txtthedate.setText(new Date().toString());
            }else if(v==showbio){
                String st = String.format("%s! 오늘은 %s다.",txtbirthdate.getText(),txtthedate.getText());
                txtbirthdate.setText("");
                txtthedate.setText("");
                Toast.makeText(getBaseContext(),st,Toast.LENGTH_LONG).show();
            }
        }
    }

}
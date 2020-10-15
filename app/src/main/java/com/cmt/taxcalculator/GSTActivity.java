package com.cmt.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class GSTActivity extends AppCompatActivity {
   
    Button gstCalcBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gst);

         final EditText Amt = findViewById(R.id.amount);
         final EditText perc = findViewById(R.id.percent);
         final EditText res1 = findViewById(R.id.gst);
           final EditText res2 = findViewById(R.id.gstamount);
         
         gstCalcBtn=findViewById(R.id.btn_gstcal);


	 gstCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = Amt.getText().toString();
                String s2 = perc.getText().toString();

                if (TextUtils.isEmpty(s1)) {
                    Amt.setError("Enter the Amount");
                    Amt.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(s2)) {
                    perc.setError("Enter the GST percentage");
                    perc.requestFocus();
                    return;
                }
		float a = Float.parseFloat(s1);

 		  float p = Float.parseFloat(s2);
                
		float gamt= calgstamt(a,p);
               
                float tamt= caltamt(a,gamt);
         
             res1.setText(String.valueOf(gamt));
	     res2.setText(String.valueOf(tamt));
}
});
}

public float calgstamt(float a,float p)
{
   return (a*(p/100));
}

public float caltamt(float a,float gamt)
{
   return (a+gamt);
}

}


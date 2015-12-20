package com.example.praveen.activity_int;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Praveen on 8/20/2015.
 */
public class DetailActivity extends Activity {


    private Button mRetButton=null;
    private Button mPerButton=null;
    private Spinner mSpinner=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_detail);

mPerButton=(Button) findViewById(R.id.performButton);
         mSpinner =(Spinner)findViewById(R.id.SpinnerSelection);


        mRetButton=(Button) findViewById(R.id.ReturnSecondActivity);

        mRetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent =new Intent();
                String mySelection=mSpinner.getSelectedItem().toString();
                returnIntent.putExtra("keyForReturn",mySelection);
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });

    mPerButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position=mSpinner.getSelectedItemPosition();
            Intent impli=null;
            switch(position)
            {
                case 0:
                    break;
                case 1:
                    impli=new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://djmaza.info"));
                    break;
                case 2:

                    impli=new Intent(Intent.ACTION_DIAL,
                            Uri.parse("tel:8561852121"));
                    break;
                case 3:
          impli=new Intent(Intent.ACTION_VIEW,
                  Uri.parse("geo:26.966122,75.79047"));
                    break;
                case 4:
                    impli=new Intent("android.media.action.IMAGE_CAPTURE");

                     break;
                case 5:
                    impli=new Intent(Intent.ACTION_EDIT,
                            Uri.parse( "content://contacts/people/1"));
                    break;

            }
            if(impli != null)
            {


                startActivity(impli);
            }




        }
    });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

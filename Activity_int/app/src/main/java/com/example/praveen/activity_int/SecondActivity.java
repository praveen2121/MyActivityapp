package com.example.praveen.activity_int;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Praveen on 8/20/2015.
 */
public class SecondActivity extends Activity {

    public static final int DETAIL_REQUEST = 1 ;

    private Button nButton=null;

    private Button mdetailButton=null;
    private TextView mSelect=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mSelect=(TextView)findViewById(R.id.Selection);
        nButton=(Button)findViewById(R.id.button1);
        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),FirstActivity.class);
                startActivity(i);
            }
        });

        mdetailButton=(Button)findViewById(R.id.goDetailActivity);
        mdetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(v.getContext(),DetailActivity.class);
                i.putExtra("KeyForsending","Some data from Second Activity");
                startActivityForResult(i,DETAIL_REQUEST);
            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK && requestCode==DETAIL_REQUEST){

            if(data.hasExtra("keyForReturn")){
                String myValue=data.getExtras().getString("keyForReturn");

              mSelect.setText(myValue);
            }
        }
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

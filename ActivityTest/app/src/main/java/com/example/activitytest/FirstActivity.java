package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> 38f0918ff0717e3837eb822692f1fb53c097e2b8
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fitst_layout);
        Button button1=(Button) findViewById(R.id.button_l);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                Intent intent=new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

=======
                Toast t=Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT);
                t.show();
            }
        });
>>>>>>> 38f0918ff0717e3837eb822692f1fb53c097e2b8
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}

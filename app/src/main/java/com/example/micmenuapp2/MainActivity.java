package com.example.micmenuapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView imgv;
TextView txtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab=getSupportActionBar();

        ab.setTitle("AI");
        ab.setSubtitle("Artificial Intelligence");
        ab.setIcon(R.drawable.pc);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);

        imgv=findViewById(R.id.imageView);
        registerForContextMenu(imgv);
    }
    public void txtv_click(View v)
    {
        Toast.makeText(this, "popup", Toast.LENGTH_SHORT).show();
        txtv=findViewById(R.id.textView);
        PopupMenu ppm=new PopupMenu(this,txtv);
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.micpopup,ppm.getMenu());
        ppm.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.miccontext,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item)
    {
        Toast.makeText(this, "context", Toast.LENGTH_SHORT).show();
        switch (item.getItemId())
        {
            case R.id.ai1:imgv.setImageResource(R.drawable.ai_1);
                            break;
            case R.id.ai2:imgv.setImageResource(R.drawable.ai_2);
                break;
            case R.id.ai3:imgv.setImageResource(R.drawable.ai_3);
                break;
            default:imgv.setImageResource(R.drawable.ai_3);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.micoptions,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        Toast.makeText(this,item.getTitle() , Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
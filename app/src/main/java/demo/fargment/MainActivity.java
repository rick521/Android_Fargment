package demo.fargment;

import static android.graphics.Color.GRAY;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import demo.fargment.Fragment_class.*;


public class MainActivity extends AppCompatActivity {

    private View find, mine;
    private View classify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = MainActivity.this.getWindow();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//实现状态栏文字颜色为暗色
        window.setStatusBarColor(Color.parseColor("#FAFAFA"));

        find = findViewById(R.id.discover);
        classify = findViewById(R.id.classify);
        mine = findViewById(R.id.user);
        change(new Search());
        find.setSelected(true);
        //mine.setSelected(false);
        //classify.setSelected(false);


        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change(new Search());
                find.setSelected(true);
                mine.setSelected(false);
                classify.setSelected(false);
            }
        });

        classify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change(new Classify());
                find.setSelected(false);
                mine.setSelected(false);
                classify.setSelected(true);
            }
        });
        mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change(new Mine());
                find.setSelected(false);
                classify.setSelected(false);
                mine.setSelected(true);
            }
        });

    }


    private void change(Fragment fragment) {
        FragmentManager FRAGMENT_MANAGER = getSupportFragmentManager();
        FragmentTransaction TRANSACTION = FRAGMENT_MANAGER.beginTransaction();
        TRANSACTION.replace(R.id.frg_layout, fragment);
        TRANSACTION.commit();
    }


}

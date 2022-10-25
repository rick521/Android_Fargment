package demo.fargment.Fragment_class;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import demo.fargment.MainActivity;
import demo.fargment.R;

public class Classify extends Fragment implements View.OnTouchListener {
    private View root;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.classify, container, false);
            Button btn = root.findViewById(R.id.btn);
            //btn.setOnClickListener((View.OnClickListener) this);
            btn.setOnTouchListener(this);
        }
        return root;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        /*按下操作*/
        ScaleAnimation animation;
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            animation = new ScaleAnimation(1.0f, 0.97f, 1.0f, 0.97f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(100);
            animation.setFillAfter(true);
            view.startAnimation(animation);
        }
        /*抬起操作*/
        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            animation = new ScaleAnimation(0.97f, 1.0f, 0.97f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(100);
            animation.setFillAfter(true);
            view.startAnimation(animation);
        }
        return false;
    }

}
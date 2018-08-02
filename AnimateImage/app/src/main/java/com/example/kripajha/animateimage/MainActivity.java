package com.example.kripajha.animateimage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnTouchListener {

    Animation shake;
    ImageView ball, transform;

    //implementing android Canvas
    Canvas canvas;
    Paint paint;
    Bitmap bitmap;
    Bitmap bmp;

    double imageWidth;
    double imageHeight;
    int c = 0;
    double cursorWidth;
    double circleX, circleY, circleLeftY, circleLeftX, circleRadius;

    boolean isWhiteBalancePickerOpen = false;
    AnimationDrawable animationDrawable;

    ImageView cursor;
    ImageView image;

    View parent;
    GestureDetector gestureDetector;

    TextView r, g, b;
    double cursorX, cursorY, cHeight, cWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        gestureDetector = new GestureDetector(this, new singelTapGesture());
//        r = findViewById(R.id.r);
//        g = findViewById(R.id.g);
//        b = findViewById(R.id.b);

        parent = findViewById(R.id.objects);

        cursor = findViewById(R.id.cursor);
        image = findViewById(R.id.foot);

        parent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Log.d("onGlobalLayout ", "Targeting ");
                calculate();
            }
        });


//        bmp = Bitmap.createBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.foot));

        bmp = ((BitmapDrawable) image.getDrawable()).getBitmap();


//        cursor.setOnTouchListener(this);

        image.setOnTouchListener(this);


//        image.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                double x = motionEvent.getX() + circleLeftX;
//                double y = motionEvent.getY() + circleLeftY;
//
//                //setting View Visible
//                cursor.setVisibility(View.VISIBLE);
//
//                if (checkIfInside(x, y, circleRadius)) {
//
//
//                    if (x > 0 && y > 0) {
//                        //pixel of the cursor
//                        int pixel = bitmap.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());
//
//                        //taking out RGB of the pixel
//                        int redValue = Color.red(pixel);
//                        int blueValue = Color.blue(pixel);
//                        int greenValue = Color.green(pixel);
//
//                        parent.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
//                    }
//                    Log.d("Inside circle ", " Done ");
//
//                    x -= 50;
//                    y -= 50;
////                    cursor.setVisibility(View.VISIBLE);
//                    cursor.setX((float) x);
//                    cursor.setY((float) y);
//                } else {
////                    cursor.setVisibility(View.INVISIBLE);
//                    Log.d("OutSide circle ", "Done");
//                }
//                return true;
//            }
//        });

    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView image = (ImageView) view;
        Bitmap bmp = ((BitmapDrawable) image.getDrawable()).getBitmap();
        double x = motionEvent.getX();
        double y = motionEvent.getY();


        Log.d("lets see ", "onTouch: x: " + image.getX() + " , y: " + image.getY());

        if (gestureDetector.onTouchEvent(motionEvent)) {

            Log.d("Gesture ", "detected");
            if (!isWhiteBalancePickerOpen) {
                openWhiteBalancePicker();
//                image.invalidate();
//                image.requestLayout();
                isWhiteBalancePickerOpen = true;
            } else {
                closeWhiteBalancePicker();
//                image.invalidate();
//                image.requestLayout();
                isWhiteBalancePickerOpen = false;
            }
            return true;

        } else {
//            Log.e("after ", "width " + bmp.getWidth() + " height " + bmp.getHeight());
            if (y > 0 && x > 0 && x < image.getWidth() && y < image.getHeight()) {
                //Get color at point of touch
                int color = bmp.getPixel((int) x, (int) y);
                if (color == Color.TRANSPARENT) {
                    Log.d("Touch ", "outside  the semi-circle" + "x :" + x + "y :" + y);
                    return true;
                } else {
//                    image.setImageBitmap(bmp);
                    x += image.getX();
                    y += image.getY();

                    Log.d("Touch ", "inside  the semi-circle" + "x :" + x + "y :" + y);
//                r.setText("" + Color.red(color));
//                g.setText("" + Color.green(color));
//                b.setText("" + Color.blue(color));
                    //image.setImageBitmap(bmp);
                    Log.e("after ", "x " + image.getX() + " height " + image.getY());

                    parent.setBackgroundColor(color);
                    cursor.setX((float) x - (float) cursorX);
                    cursor.setY((float) y - (float) cursorY);

                    return true;
                }
            }

            return true;
        }
    }


    private void calculate() {
        cursorX = cursor.getWidth() / 2.0;
        cursorY = cursor.getHeight() / 2.0;
//        Log.e("Before ", "x " + image.getX() + " height " + image.getY());
        Log.e("Before ", "width " + bmp.getWidth() + " height " + bmp.getHeight());

    }

    private boolean checkIfInside(double x, double y, double r) {

        Log.d("touch Location ", "x: " + x + " y: " + y + " <dis> " + r);
        double d = Math.abs(Math.sqrt(Math.pow(x - circleX, 2) + Math.pow(y - circleY, 2)));

        Log.d("Dis :" + d, "Rad : " + r);

        if (d <= r) {
            return true;
        } else {
            return false;
        }
    }

    private static class SampleView extends View {

        // CONSTRUCTOR
        public SampleView(Context context) {
            super(context);
            setFocusable(true);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.CYAN);
            Paint p = new Paint();
            // smooths
            p.setAntiAlias(true);
            p.setColor(Color.RED);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(4.5f);
            // opacity
            //p.setAlpha(0x80); //
            canvas.drawCircle(50, 50, 30, p);
        }

    }

    private void circleEnlarge() {

        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(image, "scaleX", 2.5f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(image, "scaleY", 2.5f);
        scaleDownX.setDuration(500);
        scaleDownY.setDuration(500);

        AnimatorSet scaleDown = new AnimatorSet();
        AnimatorSet moveUp = new AnimatorSet();

        scaleDown.play(scaleDownX).with(scaleDownY);


        scaleDown.start();
        moveUp.start();
    }

    private void circleContract() {

        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(image, "scaleX", 0.7f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(image, "scaleY", 0.7f);
        scaleDownX.setDuration(500);
        scaleDownY.setDuration(500);

        AnimatorSet scaleDown = new AnimatorSet();
        AnimatorSet moveUp = new AnimatorSet();

        scaleDown.play(scaleDownX).with(scaleDownY);

        scaleDown.start();
        moveUp.start();
    }


    public void openWhiteBalancePicker() {
        cursor.setVisibility(View.VISIBLE);
        ObjectAnimator anim = ObjectAnimator.ofFloat(image, "scaleX", 3f);
        anim.setDuration(500);
        anim.start();

        ObjectAnimator anim2 = ObjectAnimator.ofFloat(image, "scaleY", 3f);
        anim2.setDuration(500);
        anim2.start();
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(image, "translationX", 120f);
        anim3.setDuration(500);
        anim3.start();

    }

    public void closeWhiteBalancePicker() {
        cursor.setVisibility(View.GONE);
        ObjectAnimator anim = ObjectAnimator.ofFloat(image, "scaleX", 1f);
        anim.setDuration(500);
        anim.start();

        ObjectAnimator anim2 = ObjectAnimator.ofFloat(image, "scaleY", 1f);
        anim2.setDuration(500);
        anim2.start();

        ObjectAnimator anim3 = ObjectAnimator.ofFloat(image, "translationX", 0f);
        anim3.setDuration(500);
        anim3.start();


    }

    static class singelTapGesture extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return true;
        }
    }
}



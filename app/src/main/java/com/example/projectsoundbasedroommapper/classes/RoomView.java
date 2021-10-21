package com.example.projectsoundbasedroommapper.classes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class RoomView extends View {

    private Paint paintCircle, paintBox, paintPerson;
    //private Path pathBoundary;
    private static float[] updatedMagnetometerReading;
    private static float[] updatedAccelerometerReading;

    private ArrayList<XYCoordinates> objectCoordinates;

    private float x_value;
    private float z_value;

    public RoomView(Context context) {
        super(context);
        init();
    }

    public RoomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public RoomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public static void updateCircles(float[] magnetometerReading, float[] accelerometerReading) {
        updatedMagnetometerReading = magnetometerReading;
        updatedAccelerometerReading = accelerometerReading;
    }

    public void init(){
        paintCircle = new Paint();
        paintPerson = new Paint();
        paintBox = new Paint();
        paintCircle.setColor(Color.BLUE);
        paintCircle.setStyle(Paint.Style.FILL);
        paintCircle.setStrokeWidth(5);
        paintPerson.setColor(Color.RED);
        paintPerson.setStyle(Paint.Style.FILL);
        paintPerson.setStrokeWidth(5);
        paintBox.setColor(Color.GRAY);
        paintBox.setStyle(Paint.Style.STROKE);
        paintBox.setStrokeWidth(5);

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        //TODO
        float my_x_pos = canvas.getWidth()/2;
        float my_z_pos = canvas.getHeight()/2;
        x_value = my_x_pos;

        if(updatedMagnetometerReading != null && updatedAccelerometerReading != null) {
            // Peker nord,
            // Magnet 0:Nord, Magnet 1:East, Magnet 2:Up
            if (updatedMagnetometerReading[0] > (-20) && updatedMagnetometerReading[0] < 20 && updatedMagnetometerReading[1] >= 15) {
                Log.d("PEKER", "Nord");
            } // Peker sør
            else if (updatedMagnetometerReading[0] > (-20) && updatedMagnetometerReading[0] < 20 && updatedMagnetometerReading[1] <= (-15)) {
                Log.d("PEKER", "Sør");
            } // Peker øst
            else if (updatedMagnetometerReading[0] < (-17) && updatedMagnetometerReading[1] > (-15) && updatedMagnetometerReading[1] < 15) {
                Log.d("PEKER", "Øst");
            }// Peker vest
            else if (updatedMagnetometerReading[0] > 17 && updatedMagnetometerReading[1] > (-15) && updatedMagnetometerReading[1] < 15) {
                Log.d("PEKER", "Vest");
            }

//            if (updatedAccelerometerReading[0] < 3 && updatedAccelerometerReading[1] > (-0.500) && updatedMagnetometerReading[1] < 0.500 ) {
//                Log.d("PEKER", "Telefon skjermen peker til taket");
//            } else if ((updatedAccelerometerReading[0] == 3.142) && (updatedAccelerometerReading[1] > 0.500) ) {
//                Log.d("PEKER", "Telefon skjermen peker på gulvet");
//            } else if ((updatedAccelerometerReading[0] == 3.142) && (updatedAccelerometerReading[2] == (-3.142)) ) {
//                Log.d("PEKER", "Telefon topp peker opp ");
        }

        if (z_value != 0.0){
            canvas.drawCircle(x_value, x_value + (z_value*20), 70, paintCircle);
        }
        canvas.drawCircle(my_x_pos, my_z_pos, 40, paintPerson);

        canvas.drawRect(20, 100, canvas.getWidth()-30, canvas.getHeight()-100, paintBox);

    }

    public float getX_value() {
        return x_value;
    }

    public void setX_value(float x_value) {
        this.x_value = x_value;
    }

    public float getZ_value() {
        return z_value;
    }

    public void setZ_value(float z_value) {
        this.z_value = z_value;
    }

}

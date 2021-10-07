package com.example.projectsoundbasedroommapper.classes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class RoomView extends View {


    private Paint paintCircle, paintBox, paintPerson;
    //private Path pathBoundary;


    private ArrayList<XZCoordinates> objectCoordinates;



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

    public void init(){
        paintCircle = new Paint();
        paintPerson = new Paint();
        paintBox = new Paint();
        paintCircle.setColor(Color.BLUE);
        paintCircle.setStyle(Paint.Style.STROKE);
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

        float my_x_pos = canvas.getWidth()/2;
        float my_z_pos = canvas.getHeight()/2;

        canvas.drawCircle(my_x_pos, my_z_pos, 40, paintPerson);

        canvas.drawRect(20, 100, canvas.getWidth()-30, canvas.getHeight()-100, paintBox);

    }
}

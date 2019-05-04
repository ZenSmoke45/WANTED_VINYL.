package com.example.nekit.wanted_vinyl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MainWindow extends View {
    public MainWindow (Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(112,183,181));
        canvas.drawPaint(paint);

        paint.setAntiAlias(true);

    }
}

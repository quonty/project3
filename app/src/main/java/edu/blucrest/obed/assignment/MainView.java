package edu.blucrest.obed.assignment;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class MainView extends View {
    public MainView(Context context) {
        super(context);
        init(null, 0);
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public MainView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

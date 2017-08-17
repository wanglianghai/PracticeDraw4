package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    int p1Width;
    int p1Height;
    int p2Width;
    int p2Height;

    int bitmapWidth;
    int bitmapHeight;

    private Camera mCamera = new Camera();

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);


        bitmapWidth = bitmap.getWidth();
        bitmapHeight = bitmap.getHeight();
        p1Width = point1.x + bitmapWidth / 2;
        p1Height = point1.y + bitmapHeight / 2;
        p2Width = point2.x + bitmapWidth / 2;
        p2Height = point2.y + bitmapHeight / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mCamera.save();
        canvas.save();
        mCamera.rotateX(30);
        canvas.translate(p1Width, p1Height);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();
        canvas.drawBitmap(bitmap, - bitmapWidth / 2,  - bitmapHeight / 2, paint);
        canvas.restore();


        mCamera.save();
        canvas.save();
        mCamera.rotateY(30);
        canvas.translate(p2Width, p2Height);
        mCamera.applyToCanvas(canvas);

        canvas.drawBitmap(bitmap, - bitmapWidth / 2,  - bitmapHeight / 2, paint);
        canvas.restore(); mCamera.restore();
    }
}

package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice11CameraRotateView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    private Matrix mMatrix = new Matrix();

    Camera camera = new Camera();

    private Camera mCamera = new Camera();

    public Practice11CameraRotateView(Context context) {
        super(context);
    }

    public Practice11CameraRotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11CameraRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        mMatrix.postSkew(0, -0.5f, point2.x, point2.y);

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        mMatrix.postScale(0.6f, 0.4f, point2.x + bitmapWidth / 2, point2.y + bitmapHeight / 2);
        mMatrix.postTranslate(point1.x - point2.x, point1.y - point2.y);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.save();
        camera.save();
        camera.rotateX(30);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
      //  camera.save();
       // camera.rotateY(30);
       // camera.applyToCanvas(canvas);
       // camera.restore();

        canvas.restore();
        /*canvas.save();
        mCamera.save();
        mCamera.setLocation(0, 0, -12);
        mCamera.rotateX(30);
        mCamera.applyToCanvas(canvas);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();
        mCamera.restore();

        canvas.save();
        canvas.concat(mMatrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();*/
    }
}

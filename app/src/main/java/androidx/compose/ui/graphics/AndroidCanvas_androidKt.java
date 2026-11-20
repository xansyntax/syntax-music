package androidx.compose.ui.graphics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidCanvas_androidKt {
    public static final android.graphics.Canvas EmptyCanvas = new android.graphics.Canvas();

    public static final AndroidCanvas ActualCanvas(AndroidImageBitmap androidImageBitmap) {
        AndroidCanvas androidCanvas = new AndroidCanvas();
        androidCanvas.internalCanvas = new android.graphics.Canvas(ColorKt.asAndroidBitmap(androidImageBitmap));
        return androidCanvas;
    }

    public static final android.graphics.Canvas getNativeCanvas(Canvas canvas) {
        canvas.getClass();
        return ((AndroidCanvas) canvas).internalCanvas;
    }
}

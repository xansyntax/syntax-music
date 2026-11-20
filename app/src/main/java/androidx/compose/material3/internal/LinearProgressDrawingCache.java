package androidx.compose.material3.internal;

import android.graphics.PathMeasure;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPathMeasure;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.drawscope.Stroke;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LinearProgressDrawingCache {
    public float currentIndicatorTrackGapSize;
    public float[] currentProgressFractions;
    public Stroke currentStroke;
    public float currentStrokeCapWidth;
    public Stroke currentTrackStroke;
    public final AndroidPath fullProgressPath;
    public final AndroidPathMeasure pathMeasure;
    public float progressPathScale;
    public AndroidPath[] progressPathsToDraw;
    public final AndroidPath trackPathToDraw;
    public float currentWavelength = -1.0f;
    public float currentAmplitude = -1.0f;
    public long currentSize = 9205357640488583168L;
    public float currentWaveOffset = -1.0f;

    public LinearProgressDrawingCache() {
        Stroke stroke = new Stroke(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0, 0, 31);
        this.currentStroke = stroke;
        this.currentTrackStroke = stroke;
        this.progressPathScale = 1.0f;
        this.fullProgressPath = AndroidPath_androidKt.Path();
        this.pathMeasure = new AndroidPathMeasure(new PathMeasure());
        this.trackPathToDraw = AndroidPath_androidKt.Path();
    }
}

package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EdgeEffectWrapper {
    public EdgeEffect bottomEffect;
    public EdgeEffect bottomEffectNegation;
    public final Context context;
    public final int glowColor;
    public EdgeEffect leftEffect;
    public EdgeEffect leftEffectNegation;
    public EdgeEffect rightEffect;
    public EdgeEffect rightEffectNegation;
    public long size = 0;
    public EdgeEffect topEffect;
    public EdgeEffect topEffectNegation;

    public EdgeEffectWrapper(Context context, int i) {
        this.context = context;
        this.glowColor = i;
    }

    public static boolean isAnimating(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !edgeEffect.isFinished();
    }

    public static boolean isStretched(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !((Build.VERSION.SDK_INT >= 31 ? Api31Impl.getDistance(edgeEffect) : 0.0f) == CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public final EdgeEffect createEdgeEffect(Orientation orientation) {
        int i = Build.VERSION.SDK_INT;
        Context context = this.context;
        EdgeEffect edgeEffectCreate = i >= 31 ? Api31Impl.create(context) : new GlowEdgeEffectCompat(context);
        edgeEffectCreate.setColor(this.glowColor);
        if (!IntSize.m810equalsimpl0(this.size, 0L)) {
            long j = this.size;
            if (orientation == Orientation.Vertical) {
                edgeEffectCreate.setSize((int) (j >> 32), (int) (j & 4294967295L));
                return edgeEffectCreate;
            }
            edgeEffectCreate.setSize((int) (4294967295L & j), (int) (j >> 32));
        }
        return edgeEffectCreate;
    }

    public final EdgeEffect getOrCreateBottomEffect() {
        EdgeEffect edgeEffect = this.bottomEffect;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectCreateEdgeEffect = createEdgeEffect(Orientation.Vertical);
        this.bottomEffect = edgeEffectCreateEdgeEffect;
        return edgeEffectCreateEdgeEffect;
    }

    public final EdgeEffect getOrCreateLeftEffect() {
        EdgeEffect edgeEffect = this.leftEffect;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectCreateEdgeEffect = createEdgeEffect(Orientation.Horizontal);
        this.leftEffect = edgeEffectCreateEdgeEffect;
        return edgeEffectCreateEdgeEffect;
    }

    public final EdgeEffect getOrCreateRightEffect() {
        EdgeEffect edgeEffect = this.rightEffect;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectCreateEdgeEffect = createEdgeEffect(Orientation.Horizontal);
        this.rightEffect = edgeEffectCreateEdgeEffect;
        return edgeEffectCreateEdgeEffect;
    }

    public final EdgeEffect getOrCreateTopEffect() {
        EdgeEffect edgeEffect = this.topEffect;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectCreateEdgeEffect = createEdgeEffect(Orientation.Vertical);
        this.topEffect = edgeEffectCreateEdgeEffect;
        return edgeEffectCreateEdgeEffect;
    }
}

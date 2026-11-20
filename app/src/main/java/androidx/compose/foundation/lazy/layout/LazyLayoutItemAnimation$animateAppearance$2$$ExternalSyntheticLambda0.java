package androidx.compose.foundation.lazy.layout;

import android.app.PendingIntent;
import androidx.compose.animation.core.Animatable;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LazyLayoutItemAnimation$animateAppearance$2$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ GraphicsLayer f$0;
    public final /* synthetic */ LazyLayoutItemAnimation f$1;

    public /* synthetic */ LazyLayoutItemAnimation$animateAppearance$2$$ExternalSyntheticLambda0(GraphicsLayer graphicsLayer, LazyLayoutItemAnimation lazyLayoutItemAnimation, byte b) {
        this.$r8$classId = b;
        this.f$0 = graphicsLayer;
        this.f$1 = lazyLayoutItemAnimation;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws PendingIntent.CanceledException {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        LazyLayoutItemAnimation lazyLayoutItemAnimation = this.f$1;
        GraphicsLayer graphicsLayer = this.f$0;
        Animatable animatable = (Animatable) obj;
        switch (b) {
            case 0:
                graphicsLayer.setAlpha(((Number) animatable.getValue()).floatValue());
                lazyLayoutItemAnimation.onLayerPropertyChanged.invoke();
                break;
            default:
                graphicsLayer.setAlpha(((Number) animatable.getValue()).floatValue());
                lazyLayoutItemAnimation.onLayerPropertyChanged.invoke();
                break;
        }
        return unit;
    }
}

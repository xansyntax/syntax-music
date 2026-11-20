package androidx.compose.ui.graphics;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import androidx.appcompat.view.menu.StandardMenuPopup;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.graphics.layer.GraphicsLayerV23;
import androidx.compose.ui.graphics.layer.GraphicsLayerV29;
import androidx.compose.ui.graphics.layer.GraphicsViewLayer;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.graphics.layer.view.ViewLayerContainer;
import androidx.compose.ui.platform.AndroidComposeView;
import com.yalantis.ucrop.R;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidGraphicsContext implements GraphicsContext {
    public static boolean isRenderNodeCompatible = true;
    public final AnonymousClass1 componentCallback;
    public boolean componentCallbackRegistered;
    public final Object lock = new Object();
    public final AndroidComposeView ownerView;
    public ViewLayerContainer viewLayerContainer;

    public AndroidGraphicsContext(AndroidComposeView androidComposeView) {
        this.ownerView = androidComposeView;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.componentCallback = anonymousClass1;
        if (androidComposeView.isAttachedToWindow()) {
            Context context = androidComposeView.getContext();
            if (!this.componentCallbackRegistered) {
                context.getApplicationContext().registerComponentCallbacks(anonymousClass1);
                this.componentCallbackRegistered = true;
            }
        }
        androidComposeView.addOnAttachStateChangeListener(new StandardMenuPopup.AnonymousClass2((byte) 2, this));
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public final GraphicsLayer createGraphicsLayer() {
        GraphicsLayerImpl graphicsViewLayer;
        GraphicsLayerImpl graphicsLayerV29;
        GraphicsLayer graphicsLayer;
        synchronized (this.lock) {
            try {
                AndroidComposeView androidComposeView = this.ownerView;
                int i = Build.VERSION.SDK_INT;
                if (i >= 29) {
                    CanvasZHelper.getUniqueDrawingId(androidComposeView);
                }
                if (i >= 29) {
                    graphicsLayerV29 = new GraphicsLayerV29();
                } else {
                    if (isRenderNodeCompatible) {
                        try {
                            graphicsViewLayer = new GraphicsLayerV23(this.ownerView, new CanvasHolder(), new CanvasDrawScope());
                        } catch (Throwable unused) {
                            isRenderNodeCompatible = false;
                            graphicsViewLayer = new GraphicsViewLayer(obtainViewLayerContainer(this.ownerView));
                        }
                    } else {
                        graphicsViewLayer = new GraphicsViewLayer(obtainViewLayerContainer(this.ownerView));
                    }
                    graphicsLayerV29 = graphicsViewLayer;
                }
                graphicsLayer = new GraphicsLayer(graphicsLayerV29);
            } catch (Throwable th) {
                throw th;
            }
        }
        return graphicsLayer;
    }

    public final DrawChildContainer obtainViewLayerContainer(AndroidComposeView androidComposeView) {
        ViewLayerContainer viewLayerContainer = this.viewLayerContainer;
        if (viewLayerContainer != null) {
            return viewLayerContainer;
        }
        ViewLayerContainer viewLayerContainer2 = new ViewLayerContainer(androidComposeView.getContext());
        viewLayerContainer2.setClipChildren(false);
        viewLayerContainer2.setClipToPadding(false);
        viewLayerContainer2.setTag(R.id.hide_graphics_layer_in_inspector_tag, Boolean.TRUE);
        androidComposeView.addView(viewLayerContainer2, -1);
        this.viewLayerContainer = viewLayerContainer2;
        return viewLayerContainer2;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public final void releaseGraphicsLayer(GraphicsLayer graphicsLayer) {
        synchronized (this.lock) {
            if (!graphicsLayer.isReleased) {
                graphicsLayer.isReleased = true;
                graphicsLayer.discardContentIfReleasedAndHaveNoParentLayerUsages();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.AndroidGraphicsContext$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements ComponentCallbacks2 {
        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int i) {
        }
    }
}

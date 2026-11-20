package androidx.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EdgeToEdge {
    public static EdgeToEdgeApi26 Impl;
    public static final int DefaultLightScrim = Color.argb(230, 255, 255, 255);
    public static final int DefaultDarkScrim = Color.argb(128, 27, 27, 27);

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2) {
        View decorView = componentActivity.getWindow().getDecorView();
        decorView.getClass();
        EdgeToEdgeApi26 edgeToEdgeApi28 = Impl;
        if (edgeToEdgeApi28 == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 35) {
                edgeToEdgeApi28 = new EdgeToEdgeApi35();
            } else if (i >= 30) {
                edgeToEdgeApi28 = new EdgeToEdgeApi30();
            } else if (i >= 29) {
                edgeToEdgeApi28 = new EdgeToEdgeApi29();
            } else {
                edgeToEdgeApi28 = i >= 28 ? new EdgeToEdgeApi28() : new EdgeToEdgeApi26();
            }
            Impl = edgeToEdgeApi28;
        }
        EdgeToEdgeApi26 edgeToEdgeApi26 = edgeToEdgeApi28;
        final EdgeToEdge$$ExternalSyntheticLambda0 edgeToEdge$$ExternalSyntheticLambda0 = new EdgeToEdge$$ExternalSyntheticLambda0(edgeToEdgeApi26, systemBarStyle, systemBarStyle2, componentActivity, decorView, (byte) 0);
        ViewGroup viewGroup = (ViewGroup) decorView;
        int i2 = 0;
        while (true) {
            if (!(i2 < viewGroup.getChildCount())) {
                final Context context = viewGroup.getContext();
                View view = new View(context) { // from class: androidx.activity.EdgeToEdge$enableEdgeToEdge$1$2
                    @Override // android.view.View
                    public final void onConfigurationChanged(Configuration configuration) {
                        configuration.getClass();
                        edgeToEdge$$ExternalSyntheticLambda0.run();
                    }
                };
                view.setTag(edgeToEdgeApi26);
                view.setVisibility(8);
                view.setWillNotDraw(true);
                viewGroup.addView(view);
                break;
            }
            int i3 = i2 + 1;
            View childAt = viewGroup.getChildAt(i2);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            if (childAt.getTag() instanceof EdgeToEdgeApi26) {
                break;
            } else {
                i2 = i3;
            }
        }
        edgeToEdge$$ExternalSyntheticLambda0.run();
        Window window = componentActivity.getWindow();
        window.getClass();
        edgeToEdgeApi26.adjustLayoutInDisplayCutoutMode(window);
    }
}

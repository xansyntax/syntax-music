package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.R;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LocalOnBackPressedDispatcherOwner {
    public static final StaticProvidableCompositionLocal LocalOnBackPressedDispatcherOwner = new StaticProvidableCompositionLocal(new ScrollKt$$ExternalSyntheticLambda0((byte) 4), (byte) 1);

    public static OnBackPressedDispatcherOwner getCurrent(Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) gapComposer.consume(LocalOnBackPressedDispatcherOwner);
        Object obj = null;
        if (onBackPressedDispatcherOwner == null) {
            gapComposer.startReplaceGroup(1208426157);
            View view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
            view.getClass();
            while (true) {
                if (view == null) {
                    onBackPressedDispatcherOwner = null;
                    break;
                }
                Object tag = view.getTag(R.id.view_tree_on_back_pressed_dispatcher_owner);
                OnBackPressedDispatcherOwner onBackPressedDispatcherOwner2 = tag instanceof OnBackPressedDispatcherOwner ? (OnBackPressedDispatcherOwner) tag : null;
                if (onBackPressedDispatcherOwner2 != null) {
                    onBackPressedDispatcherOwner = onBackPressedDispatcherOwner2;
                    break;
                }
                Object parentOrViewTreeDisjointParent = DatabaseDao_Impl.AnonymousClass17.getParentOrViewTreeDisjointParent(view);
                view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
            }
        } else {
            gapComposer.startReplaceGroup(1208423708);
        }
        gapComposer.end(false);
        if (onBackPressedDispatcherOwner != null) {
            gapComposer.startReplaceGroup(1208423789);
            gapComposer.end(false);
            return onBackPressedDispatcherOwner;
        }
        gapComposer.startReplaceGroup(1208428160);
        for (Context baseContext = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext); baseContext instanceof ContextWrapper; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof OnBackPressedDispatcherOwner) {
                obj = baseContext;
                break;
            }
        }
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner3 = (OnBackPressedDispatcherOwner) obj;
        gapComposer.end(false);
        return onBackPressedDispatcherOwner3;
    }
}

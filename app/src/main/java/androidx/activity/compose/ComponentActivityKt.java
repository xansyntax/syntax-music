package androidx.activity.compose;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.ViewModelKt;
import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ComponentActivityKt {
    public static final ViewGroup.LayoutParams DefaultActivityContentLayoutParams = new ViewGroup.LayoutParams(-2, -2);

    public static void setContent$default(ComponentActivity componentActivity, ComposableLambdaImpl composableLambdaImpl) {
        View childAt = ((ViewGroup) componentActivity.getWindow().getDecorView().findViewById(R.id.content)).getChildAt(0);
        ComposeView composeView = childAt instanceof ComposeView ? (ComposeView) childAt : null;
        if (composeView != null) {
            composeView.setParentCompositionContext(null);
            composeView.setContent(composableLambdaImpl);
            return;
        }
        ComposeView composeView2 = new ComposeView(componentActivity);
        composeView2.setParentCompositionContext(null);
        composeView2.setContent(composableLambdaImpl);
        View decorView = componentActivity.getWindow().getDecorView();
        if (ViewModelKt.get(decorView) == null) {
            decorView.setTag(com.yalantis.ucrop.R.id.view_tree_lifecycle_owner, componentActivity);
        }
        if (ViewModelKt.m835get(decorView) == null) {
            decorView.setTag(com.yalantis.ucrop.R.id.view_tree_view_model_store_owner, componentActivity);
        }
        if (UtilsKt.get(decorView) == null) {
            decorView.setTag(com.yalantis.ucrop.R.id.view_tree_saved_state_registry_owner, componentActivity);
        }
        componentActivity.setContentView(composeView2, DefaultActivityContentLayoutParams);
    }
}

package androidx.compose.material3;

import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.activity.ComponentDialog;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupLayout;
import androidx.core.view.WindowInsetsControllerCompat$Impl26;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;
import androidx.core.view.WindowInsetsControllerCompat$Impl35;
import androidx.datastore.core.AtomicInt;
import androidx.lifecycle.ViewModelKt;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.yalantis.ucrop.R;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.UUID;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ModalBottomSheetDialogWrapper extends ComponentDialog {
    public final View composeView;
    public long contentColor;
    public final ModalBottomSheetDialogLayout dialogLayout;
    public Function0 onDismissRequest;
    public ModalBottomSheetProperties properties;

    public ModalBottomSheetDialogWrapper(Function0 function0, ModalBottomSheetProperties modalBottomSheetProperties, long j, View view, LayoutDirection layoutDirection, Density density, UUID uuid) {
        super(new ContextThemeWrapper(view.getContext(), R.style.EdgeToEdgeFloatingDialogWindowTheme), 0);
        this.onDismissRequest = function0;
        this.properties = modalBottomSheetProperties;
        this.contentColor = j;
        this.composeView = view;
        Window window = getWindow();
        if (window == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Dialog has no window");
            throw null;
        }
        window.requestFeature(1);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        MathKt.setDecorFitsSystemWindows(window, false);
        ModalBottomSheetDialogLayout modalBottomSheetDialogLayout = new ModalBottomSheetDialogLayout(getContext());
        modalBottomSheetDialogLayout.setTag(R.id.compose_view_saveable_id_tag, "Dialog:" + uuid);
        modalBottomSheetDialogLayout.setClipChildren(false);
        modalBottomSheetDialogLayout.setElevation(density.mo81toPx0680j_4(8.0f));
        modalBottomSheetDialogLayout.setOutlineProvider(new PopupLayout.AnonymousClass2((byte) 1));
        this.dialogLayout = modalBottomSheetDialogLayout;
        setContentView(modalBottomSheetDialogLayout);
        modalBottomSheetDialogLayout.setTag(R.id.view_tree_lifecycle_owner, ViewModelKt.get(view));
        modalBottomSheetDialogLayout.setTag(R.id.view_tree_view_model_store_owner, ViewModelKt.m835get(view));
        modalBottomSheetDialogLayout.setTag(R.id.view_tree_saved_state_registry_owner, UtilsKt.get(view));
        m306updateParameters9LQNqLg(this.onDismissRequest, this.properties, this.contentColor, layoutDirection);
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (zOnTouchEvent) {
            this.onDismissRequest.invoke();
        }
        return zOnTouchEvent;
    }

    /* JADX INFO: renamed from: updateParameters-9LQNqLg, reason: not valid java name */
    public final void m306updateParameters9LQNqLg(Function0 function0, ModalBottomSheetProperties modalBottomSheetProperties, long j, LayoutDirection layoutDirection) {
        int i;
        LifecyclesKt windowInsetsControllerCompat$Impl30;
        this.onDismissRequest = function0;
        this.properties = modalBottomSheetProperties;
        this.contentColor = j;
        modalBottomSheetProperties.getClass();
        ViewGroup.LayoutParams layoutParams = this.composeView.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        boolean z = (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
        Window window = getWindow();
        window.getClass();
        window.setFlags(z ? 8192 : -8193, 8192);
        int iOrdinal = layoutDirection.ordinal();
        if (iOrdinal == 0) {
            i = 0;
        } else {
            if (iOrdinal != 1) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            i = 1;
        }
        this.dialogLayout.setLayoutDirection(i);
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setLayout(-1, -1);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setSoftInputMode(Build.VERSION.SDK_INT >= 30 ? 48 : 16);
        }
        Window window4 = getWindow();
        window4.getClass();
        Window window5 = getWindow();
        window5.getClass();
        AtomicInt atomicInt = new AtomicInt(window5.getDecorView());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 35) {
            windowInsetsControllerCompat$Impl30 = new WindowInsetsControllerCompat$Impl35(window4, atomicInt);
        } else {
            windowInsetsControllerCompat$Impl30 = i2 >= 30 ? new WindowInsetsControllerCompat$Impl30(window4, atomicInt) : new WindowInsetsControllerCompat$Impl26(window4, atomicInt);
        }
        windowInsetsControllerCompat$Impl30.setAppearanceLightStatusBars(!ULong.m1869equalsimpl0(j, 0L) && ((double) ColorKt.m494luminance8_81llA(j)) <= 0.5d);
        windowInsetsControllerCompat$Impl30.setAppearanceLightNavigationBars(!ULong.m1869equalsimpl0(j, 0L) && ((double) ColorKt.m494luminance8_81llA(j)) <= 0.5d);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
    }
}

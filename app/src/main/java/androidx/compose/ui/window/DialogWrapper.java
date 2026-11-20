package androidx.compose.ui.window;

import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelKt;
import coil3.util.UtilsKt;
import com.yalantis.ucrop.R;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DialogWrapper extends ComponentDialog {
    public final View composeView;
    public final DialogLayout dialogLayout;
    public boolean isPressOutside;
    public Function0 onDismissRequest;
    public DialogProperties properties;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogWrapper(Function0 function0, DialogProperties dialogProperties, View view, LayoutDirection layoutDirection, Density density, UUID uuid) {
        super(new ContextThemeWrapper(view.getContext(), dialogProperties.decorFitsSystemWindows ? R.style.DialogWindowTheme : R.style.FloatingDialogWindowTheme), 0);
        byte b = 0;
        this.onDismissRequest = function0;
        this.properties = dialogProperties;
        this.composeView = view;
        Window window = getWindow();
        if (window == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Dialog has no window");
            throw null;
        }
        DialogProperties dialogProperties2 = this.properties;
        Window window2 = getWindow();
        if (window2 != null) {
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.type = dialogProperties2.windowType;
            window2.setAttributes(attributes);
        }
        window.requestFeature(1);
        this.properties.getClass();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        MathKt.setDecorFitsSystemWindows(window, this.properties.decorFitsSystemWindows);
        window.setGravity(17);
        if (!this.properties.decorFitsSystemWindows) {
            window.addFlags(65792);
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                Api28Impl.INSTANCE.setLayoutInDisplayCutout(attributes2);
            }
            if (i >= 30) {
                Api30Impl api30Impl = Api30Impl.INSTANCE;
                api30Impl.setFitInsetsSides(attributes2, 0);
                api30Impl.setFitInsetsTypes(attributes2, 0);
            }
            window.setAttributes(attributes2);
        }
        DialogLayout dialogLayout = new DialogLayout(getContext(), window);
        setTitle(this.properties.windowTitle);
        dialogLayout.setTag(R.id.compose_view_saveable_id_tag, "Dialog:" + uuid);
        dialogLayout.setClipChildren(false);
        dialogLayout.setElevation(density.mo81toPx0680j_4(8.0f));
        dialogLayout.setOutlineProvider(new PopupLayout.AnonymousClass2((byte) 4));
        this.dialogLayout = dialogLayout;
        View decorView = window.getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup != null) {
            _init_$disableClipping(viewGroup);
        }
        setContentView(dialogLayout);
        dialogLayout.setTag(R.id.view_tree_lifecycle_owner, ViewModelKt.get(view));
        dialogLayout.setTag(R.id.view_tree_view_model_store_owner, ViewModelKt.m835get(view));
        dialogLayout.setTag(R.id.view_tree_saved_state_registry_owner, UtilsKt.get(view));
        updateParameters(this.onDismissRequest, this.properties, layoutDirection, density);
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        DialogWrapper$$ExternalSyntheticLambda0 dialogWrapper$$ExternalSyntheticLambda0 = new DialogWrapper$$ExternalSyntheticLambda0(this, b);
        onBackPressedDispatcher.getClass();
        onBackPressedDispatcher.addCallback(new FragmentManager.AnonymousClass1(dialogWrapper$$ExternalSyntheticLambda0), this);
    }

    public static final void _init_$disableClipping(ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        if (viewGroup instanceof DialogLayout) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
            if (viewGroup2 != null) {
                _init_$disableClipping(viewGroup2);
            }
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!this.properties.dismissOnBackPress || !keyEvent.isTracking() || keyEvent.isCanceled() || i != 111) {
            return super.onKeyUp(i, keyEvent);
        }
        this.onDismissRequest.invoke();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0086  */
    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        View childAt;
        int iRoundToInt;
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (!this.properties.dismissOnClickOutside) {
            actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
            }
            this.isPressOutside = false;
            return zOnTouchEvent;
        }
        DialogLayout dialogLayout = this.dialogLayout;
        dialogLayout.getClass();
        if (Math.abs(motionEvent.getX()) <= Float.MAX_VALUE && Math.abs(motionEvent.getY()) <= Float.MAX_VALUE && (childAt = dialogLayout.getChildAt(0)) != null) {
            int left = childAt.getLeft() + dialogLayout.getLeft();
            int width = childAt.getWidth() + left;
            int top = childAt.getTop() + dialogLayout.getTop();
            int height = childAt.getHeight() + top;
            int iRoundToInt2 = MathKt.roundToInt(motionEvent.getX());
            if (left <= iRoundToInt2 && iRoundToInt2 <= width && top <= (iRoundToInt = MathKt.roundToInt(motionEvent.getY())) && iRoundToInt <= height) {
                actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0 || actionMasked == 1 || actionMasked == 3) {
                    this.isPressOutside = false;
                    return zOnTouchEvent;
                }
            }
        }
        int actionMasked2 = motionEvent.getActionMasked();
        if (actionMasked2 == 0) {
            this.isPressOutside = true;
            return true;
        }
        if (actionMasked2 != 1) {
            if (actionMasked2 == 3) {
                this.isPressOutside = false;
                return zOnTouchEvent;
            }
        } else if (this.isPressOutside) {
            this.onDismissRequest.invoke();
            this.isPressOutside = false;
            return true;
        }
        return zOnTouchEvent;
    }

    public final void updateParameters(Function0 function0, DialogProperties dialogProperties, LayoutDirection layoutDirection, Density density) {
        int i;
        this.onDismissRequest = function0;
        this.properties = dialogProperties;
        dialogProperties.getClass();
        boolean zIsFlagSecureEnabled = AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView);
        Window window = getWindow();
        window.getClass();
        window.setFlags(zIsFlagSecureEnabled ? 8192 : -8193, 8192);
        int iOrdinal = layoutDirection.ordinal();
        int i2 = 0;
        if (iOrdinal == 0) {
            i = 0;
        } else {
            if (iOrdinal != 1) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            i = 1;
        }
        DialogLayout dialogLayout = this.dialogLayout;
        dialogLayout.setLayoutDirection(i);
        boolean z = dialogProperties.decorFitsSystemWindows;
        boolean z2 = dialogProperties.usePlatformDefaultWidth;
        Window window2 = dialogLayout.window;
        boolean z3 = (dialogLayout.hasCalledSetLayout && z2 == dialogLayout.usePlatformDefaultWidth && z == dialogLayout.decorFitsSystemWindows) ? false : true;
        dialogLayout.usePlatformDefaultWidth = z2;
        dialogLayout.decorFitsSystemWindows = z;
        if (z3) {
            WindowManager.LayoutParams attributes = window2.getAttributes();
            int i3 = z2 ? -2 : -1;
            if (i3 != attributes.width || !dialogLayout.hasCalledSetLayout) {
                window2.setLayout(i3, -2);
                dialogLayout.hasCalledSetLayout = true;
            }
        }
        setCanceledOnTouchOutside(dialogProperties.dismissOnClickOutside);
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setBackgroundDrawableResource(android.R.color.transparent);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 31) {
                if (!Float.isNaN(Float.NaN)) {
                    DialogApi31Impl.INSTANCE.setBlurBehindRadius(window3, density.mo75roundToPx0680j_4(Float.NaN));
                }
                if (!Float.isNaN(Float.NaN)) {
                    DialogApi31Impl.setBackgroundBlurRadius(window3, density.mo75roundToPx0680j_4(Float.NaN));
                }
            }
            if (!Float.isNaN(Float.NaN)) {
                window3.setDimAmount(Float.NaN);
            }
            if (!z) {
                i2 = i4 < 31 ? 16 : 48;
            }
            window3.setSoftInputMode(i2);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
    }
}

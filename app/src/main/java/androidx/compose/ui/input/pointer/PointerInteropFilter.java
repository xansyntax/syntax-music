package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidViewHolder$$ExternalSyntheticLambda4;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PointerInteropFilter implements Modifier.Element {
    public boolean disallowIntercept;
    public AndroidViewHolder$$ExternalSyntheticLambda4 onTouchEvent;
    public final Dispatcher pointerInputFilter = new Dispatcher(this);
    public CallsKt$await$2$1 requestDisallowInterceptTouchEvent;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DispatchToViewState {
        public static final /* synthetic */ DispatchToViewState[] $VALUES;
        public static final DispatchToViewState Dispatching;
        public static final DispatchToViewState NotDispatching;
        public static final DispatchToViewState Unknown;

        static {
            DispatchToViewState dispatchToViewState = new DispatchToViewState("Unknown", 0);
            Unknown = dispatchToViewState;
            DispatchToViewState dispatchToViewState2 = new DispatchToViewState("Dispatching", 1);
            Dispatching = dispatchToViewState2;
            DispatchToViewState dispatchToViewState3 = new DispatchToViewState("NotDispatching", 2);
            NotDispatching = dispatchToViewState3;
            $VALUES = new DispatchToViewState[]{dispatchToViewState, dispatchToViewState2, dispatchToViewState3};
        }

        public static DispatchToViewState valueOf(String str) {
            return (DispatchToViewState) Enum.valueOf(DispatchToViewState.class, str);
        }

        public static DispatchToViewState[] values() {
            return (DispatchToViewState[]) $VALUES.clone();
        }
    }

    public final Function1 getOnTouchEvent() {
        AndroidViewHolder$$ExternalSyntheticLambda4 androidViewHolder$$ExternalSyntheticLambda4 = this.onTouchEvent;
        if (androidViewHolder$$ExternalSyntheticLambda4 != null) {
            return androidViewHolder$$ExternalSyntheticLambda4;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onTouchEvent");
        throw null;
    }
}

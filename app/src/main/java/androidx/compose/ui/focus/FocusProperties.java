package androidx.compose.ui.focus;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface FocusProperties {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion {
        public static final Rect UnsetFocusRect = new Rect(Float.NaN, Float.NaN, Float.NaN, Float.NaN);
    }

    boolean getCanFocus();

    void setCanFocus(boolean z);

    default void setDown(FocusRequester focusRequester) {
    }

    default void setFocusRect(Rect rect) {
    }

    default void setNext(FocusRequester focusRequester) {
    }

    default void setOnEnter(FocusGroupPropertiesNode$$ExternalSyntheticLambda0 focusGroupPropertiesNode$$ExternalSyntheticLambda0) {
    }

    default void setOnExit(FocusGroupPropertiesNode$$ExternalSyntheticLambda0 focusGroupPropertiesNode$$ExternalSyntheticLambda0) {
    }

    default void setPrevious(FocusRequester focusRequester) {
    }
}

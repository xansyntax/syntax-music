package androidx.compose.ui.focus;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusPropertiesImpl implements FocusProperties {
    public boolean canFocus;
    public FocusRequester down;
    public FocusRequester end;
    public Rect focusRect;
    public FocusRequester left;
    public FocusRequester next;
    public Function1 onEnter;
    public Function1 onExit;
    public FocusRequester previous;
    public FocusRequester right;
    public FocusRequester start;
    public FocusRequester up;

    @Override // androidx.compose.ui.focus.FocusProperties
    public final boolean getCanFocus() {
        return this.canFocus;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final void setCanFocus(boolean z) {
        this.canFocus = z;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final void setDown(FocusRequester focusRequester) {
        this.down = focusRequester;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final void setFocusRect(Rect rect) {
        this.focusRect = rect;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final void setNext(FocusRequester focusRequester) {
        this.next = focusRequester;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final void setOnEnter(FocusGroupPropertiesNode$$ExternalSyntheticLambda0 focusGroupPropertiesNode$$ExternalSyntheticLambda0) {
        this.onEnter = focusGroupPropertiesNode$$ExternalSyntheticLambda0;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final void setOnExit(FocusGroupPropertiesNode$$ExternalSyntheticLambda0 focusGroupPropertiesNode$$ExternalSyntheticLambda0) {
        this.onExit = focusGroupPropertiesNode$$ExternalSyntheticLambda0;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final void setPrevious(FocusRequester focusRequester) {
        this.previous = focusRequester;
    }
}

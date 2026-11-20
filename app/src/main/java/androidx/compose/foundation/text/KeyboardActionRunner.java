package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class KeyboardActionRunner {
    public FocusOwner focusManager;
    public KeyboardActions keyboardActions;
    public final SoftwareKeyboardController keyboardController;

    public KeyboardActionRunner(SoftwareKeyboardController softwareKeyboardController) {
        this.keyboardController = softwareKeyboardController;
    }

    public final KeyboardActions getKeyboardActions() {
        KeyboardActions keyboardActions = this.keyboardActions;
        if (keyboardActions != null) {
            return keyboardActions;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        throw null;
    }

    /* JADX INFO: renamed from: runAction-KlQnJC8, reason: not valid java name */
    public final boolean m197runActionKlQnJC8(int i) {
        Function1 function1;
        SoftwareKeyboardController softwareKeyboardController;
        if (i == 7) {
            function1 = getKeyboardActions().onDone;
        } else {
            if (i == 2 || i == 6 || i == 5) {
                getKeyboardActions();
            } else if (i == 3) {
                function1 = getKeyboardActions().onSearch;
            } else if (i == 4) {
                getKeyboardActions();
            } else if (i != 1 && i != 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("invalid ImeAction");
                return false;
            }
            function1 = null;
        }
        if (function1 != null) {
            function1.invoke(this);
            return true;
        }
        if (i == 6) {
            FocusOwner focusOwner = this.focusManager;
            if (focusOwner != null) {
                ((FocusOwnerImpl) focusOwner).m412moveFocusaToIllA(1, true);
                return true;
            }
            Intrinsics.throwUninitializedPropertyAccessException("focusManager");
            throw null;
        }
        if (i != 5) {
            if (i != 7 || (softwareKeyboardController = this.keyboardController) == null) {
                return false;
            }
            ((DelegatingSoftwareKeyboardController) softwareKeyboardController).hide();
            return true;
        }
        FocusOwner focusOwner2 = this.focusManager;
        if (focusOwner2 != null) {
            ((FocusOwnerImpl) focusOwner2).m412moveFocusaToIllA(2, true);
            return true;
        }
        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        throw null;
    }
}

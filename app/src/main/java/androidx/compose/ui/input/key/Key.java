package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Key {
    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m579equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getKey-ZmokQxo, reason: not valid java name */
    public static final long m580getKeyZmokQxo(android.view.KeyEvent keyEvent) {
        return ((long) keyEvent.getKeyCode()) << 32;
    }

    /* JADX INFO: renamed from: getType-ZmokQxo, reason: not valid java name */
    public static final int m581getTypeZmokQxo(android.view.KeyEvent keyEvent) {
        int action = keyEvent.getAction();
        if (action != 0) {
            return action != 1 ? 0 : 1;
        }
        return 2;
    }

    public static final Modifier onKeyEvent(Modifier modifier, Function1 function1) {
        return modifier.then(new KeyInputElement(function1, null));
    }

    public static final Modifier onPreviewKeyEvent(Modifier modifier, Function1 function1) {
        return modifier.then(new KeyInputElement(null, function1));
    }
}

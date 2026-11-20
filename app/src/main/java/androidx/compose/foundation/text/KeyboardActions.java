package androidx.compose.foundation.text;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class KeyboardActions {
    public static final KeyboardActions Default = new KeyboardActions(null, null, 63);
    public final Function1 onDone;
    public final Function1 onSearch;

    public KeyboardActions(Function1 function1, Function1 function2, int i) {
        function1 = (i & 1) != 0 ? null : function1;
        function2 = (i & 16) != 0 ? null : function2;
        this.onDone = function1;
        this.onSearch = function2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardActions)) {
            return false;
        }
        KeyboardActions keyboardActions = (KeyboardActions) obj;
        return this.onDone == keyboardActions.onDone && this.onSearch == keyboardActions.onSearch;
    }

    public final int hashCode() {
        Function1 function1 = this.onDone;
        int iHashCode = (function1 != null ? function1.hashCode() : 0) * 923521;
        Function1 function2 = this.onSearch;
        return (iHashCode + (function2 != null ? function2.hashCode() : 0)) * 31;
    }
}

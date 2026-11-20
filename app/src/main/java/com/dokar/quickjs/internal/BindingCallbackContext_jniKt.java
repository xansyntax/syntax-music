package com.dokar.quickjs.internal;

import com.dokar.quickjs.QuickJs;
import java.util.Iterator;
import kotlin.collections.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BindingCallbackContext_jniKt {
    public static final ThreadLocal bindingCallbackStack = new ThreadLocal();

    public static final boolean isInBindingCallback(QuickJs quickJs) {
        ArrayDeque arrayDeque = (ArrayDeque) bindingCallbackStack.get();
        if (arrayDeque == null || arrayDeque.isEmpty()) {
            return false;
        }
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            if (((QuickJs) it.next()) == quickJs) {
                return true;
            }
        }
        return false;
    }
}

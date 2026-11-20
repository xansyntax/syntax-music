package androidx.lifecycle.viewmodel;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelInitializer {
    public final ClassReference clazz;
    public final Function1 initializer;

    public ViewModelInitializer(ClassReference classReference, Function1 function1) {
        function1.getClass();
        this.clazz = classReference;
        this.initializer = function1;
    }
}

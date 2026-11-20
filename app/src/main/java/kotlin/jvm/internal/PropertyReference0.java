package kotlin.jvm.internal;

import kotlin.reflect.KProperty0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class PropertyReference0 extends PropertyReference implements KProperty0 {
    @Override // kotlin.reflect.KProperty0
    public final Object getDelegate() {
        return ((KProperty0) getReflected()).getDelegate();
    }

    @Override // kotlin.reflect.KProperty, kotlin.reflect.KProperty0
    public final KProperty0.Getter getGetter() {
        return ((KProperty0) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.KProperty0, kotlin.jvm.functions.Function0
    public final Object invoke() {
        return get();
    }
}

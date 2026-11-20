package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class PropertyReference1 extends PropertyReference implements KProperty1 {
    @Override // kotlin.jvm.internal.CallableReference
    public KCallable computeReflected() {
        Reflection.factory.getClass();
        return this;
    }

    @Override // kotlin.reflect.KProperty1
    public Object getDelegate(Object obj) {
        return ((KProperty1) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.reflect.KProperty, kotlin.reflect.KProperty0
    public KProperty1.Getter getGetter() {
        return ((KProperty1) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.KProperty1, kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return get(obj);
    }
}

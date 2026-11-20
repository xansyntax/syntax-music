package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements KMutableProperty0 {
    @Override // kotlin.jvm.internal.CallableReference
    public final KCallable computeReflected() {
        Reflection.factory.getClass();
        return this;
    }

    @Override // kotlin.reflect.KProperty0
    public final Object getDelegate() {
        return ((KMutableProperty0) getReflected()).getDelegate();
    }

    @Override // kotlin.reflect.KProperty, kotlin.reflect.KProperty0
    public final KProperty0.Getter getGetter() {
        return ((KMutableProperty0) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty, kotlin.reflect.KMutableProperty0
    public final KMutableProperty0.Setter getSetter() {
        return ((KMutableProperty0) getReflected()).getSetter();
    }

    @Override // kotlin.reflect.KMutableProperty0, kotlin.reflect.KProperty0, kotlin.jvm.functions.Function0
    public final Object invoke() {
        return get();
    }
}

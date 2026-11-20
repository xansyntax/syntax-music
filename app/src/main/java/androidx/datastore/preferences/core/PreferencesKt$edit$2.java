package androidx.datastore.preferences.core;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferencesKt$edit$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function2 $transform;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PreferencesKt$edit$2(Function2 function2, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Function2 function2 = this.$transform;
        switch (b) {
            case 0:
                PreferencesKt$edit$2 preferencesKt$edit$2 = new PreferencesKt$edit$2(function2, continuation, (byte) 0);
                preferencesKt$edit$2.L$0 = obj;
                return preferencesKt$edit$2;
            case 1:
                PreferencesKt$edit$2 preferencesKt$edit$3 = new PreferencesKt$edit$2(function2, continuation, (byte) 1);
                preferencesKt$edit$3.L$0 = obj;
                return preferencesKt$edit$3;
            default:
                PreferencesKt$edit$2 preferencesKt$edit$4 = new PreferencesKt$edit$2(function2, continuation, (byte) 2);
                preferencesKt$edit$4.L$0 = obj;
                return preferencesKt$edit$4;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((PreferencesKt$edit$2) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((PreferencesKt$edit$2) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((PreferencesKt$edit$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Function2 function2 = this.$transform;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    MutablePreferences mutablePreferences = new MutablePreferences(new LinkedHashMap(((MutablePreferences) this.L$0).asMap()), false);
                    this.L$0 = mutablePreferences;
                    this.label = true;
                    return function2.invoke(mutablePreferences, this) == coroutineSingletons ? coroutineSingletons : mutablePreferences;
                }
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                MutablePreferences mutablePreferences2 = (MutablePreferences) this.L$0;
                ResultKt.throwOnFailure(obj);
                return mutablePreferences2;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    MutablePreferences mutablePreferences3 = (MutablePreferences) this.L$0;
                    this.label = true;
                    obj = function2.invoke(mutablePreferences3, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                MutablePreferences mutablePreferences4 = (MutablePreferences) obj;
                mutablePreferences4.getClass();
                ((AtomicBoolean) mutablePreferences4.frozen.delegate).set(true);
                return mutablePreferences4;
            default:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    this.label = true;
                    if (function2.invoke(coroutineScope, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }
}

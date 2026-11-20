package com.metrolist.music.ui.utils;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences$Key;
import com.metrolist.music.utils.UtilsKt;
import dev.chrisbanes.haze.RenderScriptBlurEffect$updateSurface$2$4;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2 implements MutableState {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ Preferences$Key $key;
    public final /* synthetic */ State $state;

    /* JADX INFO: renamed from: com.metrolist.music.ui.utils.ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Preferences$Key $key;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Enum $value;
        public boolean label;

        /* JADX INFO: renamed from: com.metrolist.music.ui.utils.ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class C00091 extends SuspendLambda implements Function2 {
            public final /* synthetic */ Preferences$Key $key;
            public final /* synthetic */ byte $r8$classId;
            public final /* synthetic */ Enum $value;
            public /* synthetic */ Object L$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ C00091(Preferences$Key preferences$Key, Enum r2, Continuation continuation, byte b) {
                super(2, continuation);
                this.$r8$classId = b;
                this.$key = preferences$Key;
                this.$value = r2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                switch (this.$r8$classId) {
                    case 0:
                        C00091 c00091 = new C00091(this.$key, this.$value, continuation, (byte) 0);
                        c00091.L$0 = obj;
                        return c00091;
                    case 1:
                        C00091 c00092 = new C00091(this.$key, this.$value, continuation, (byte) 1);
                        c00092.L$0 = obj;
                        return c00092;
                    case 2:
                        C00091 c00093 = new C00091(this.$key, this.$value, continuation, (byte) 2);
                        c00093.L$0 = obj;
                        return c00093;
                    case 3:
                        C00091 c00094 = new C00091(this.$key, this.$value, continuation, (byte) 3);
                        c00094.L$0 = obj;
                        return c00094;
                    case 4:
                        C00091 c00095 = new C00091(this.$key, this.$value, continuation, (byte) 4);
                        c00095.L$0 = obj;
                        return c00095;
                    case 5:
                        C00091 c00096 = new C00091(this.$key, this.$value, continuation, (byte) 5);
                        c00096.L$0 = obj;
                        return c00096;
                    case 6:
                        C00091 c00097 = new C00091(this.$key, this.$value, continuation, (byte) 6);
                        c00097.L$0 = obj;
                        return c00097;
                    case 7:
                        C00091 c00098 = new C00091(this.$key, this.$value, continuation, (byte) 7);
                        c00098.L$0 = obj;
                        return c00098;
                    case 8:
                        C00091 c00099 = new C00091(this.$key, this.$value, continuation, (byte) 8);
                        c00099.L$0 = obj;
                        return c00099;
                    default:
                        C00091 c000910 = new C00091(this.$key, this.$value, continuation, (byte) 9);
                        c000910.L$0 = obj;
                        return c000910;
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                byte b = this.$r8$classId;
                Unit unit = Unit.INSTANCE;
                MutablePreferences mutablePreferences = (MutablePreferences) obj;
                Continuation continuation = (Continuation) obj2;
                switch (b) {
                    case 0:
                        ((C00091) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 1:
                        ((C00091) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 2:
                        ((C00091) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 3:
                        ((C00091) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 4:
                        ((C00091) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 5:
                        ((C00091) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 6:
                        ((C00091) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 7:
                        ((C00091) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 8:
                        ((C00091) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    default:
                        ((C00091) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                }
                return unit;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                byte b = this.$r8$classId;
                Unit unit = Unit.INSTANCE;
                Enum r2 = this.$value;
                Preferences$Key preferences$Key = this.$key;
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                switch (b) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 2:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 3:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 4:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 5:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 6:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 7:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 8:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    default:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                }
                return unit;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Context context, Preferences$Key preferences$Key, Enum r3, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$context = context;
            this.$key = preferences$Key;
            this.$value = r3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 1);
                case 2:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 2);
                case 3:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 3);
                case 4:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 4);
                case 5:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 5);
                case 6:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 6);
                case 7:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 7);
                case 8:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 8);
                default:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 9);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
            }
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            Enum r2 = this.$value;
            Preferences$Key preferences$Key = this.$key;
            Context context = this.$context;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            byte b2 = 1;
            Continuation continuation = null;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        C00091 c00091 = new C00091(preferences$Key, r2, continuation, (byte) 0);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00091, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 1:
                    boolean z2 = this.label;
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        C00091 c00092 = new C00091(preferences$Key, r2, continuation, b2);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00092, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 2:
                    boolean z3 = this.label;
                    if (!z3) {
                        ResultKt.throwOnFailure(obj);
                        C00091 c00093 = new C00091(preferences$Key, r2, continuation, (byte) 2);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00093, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 3:
                    boolean z4 = this.label;
                    if (!z4) {
                        ResultKt.throwOnFailure(obj);
                        C00091 c00094 = new C00091(preferences$Key, r2, continuation, (byte) 3);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00094, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z4) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 4:
                    boolean z5 = this.label;
                    if (!z5) {
                        ResultKt.throwOnFailure(obj);
                        C00091 c00095 = new C00091(preferences$Key, r2, continuation, (byte) 4);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00095, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z5) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 5:
                    boolean z6 = this.label;
                    if (!z6) {
                        ResultKt.throwOnFailure(obj);
                        C00091 c00096 = new C00091(preferences$Key, r2, continuation, (byte) 5);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00096, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z6) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 6:
                    boolean z7 = this.label;
                    if (!z7) {
                        ResultKt.throwOnFailure(obj);
                        C00091 c00097 = new C00091(preferences$Key, r2, continuation, (byte) 6);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00097, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z7) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 7:
                    boolean z8 = this.label;
                    if (!z8) {
                        ResultKt.throwOnFailure(obj);
                        C00091 c00098 = new C00091(preferences$Key, r2, continuation, (byte) 7);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00098, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z8) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 8:
                    boolean z9 = this.label;
                    if (!z9) {
                        ResultKt.throwOnFailure(obj);
                        C00091 c00099 = new C00091(preferences$Key, r2, continuation, (byte) 8);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00099, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z9) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                default:
                    boolean z10 = this.label;
                    if (!z10) {
                        ResultKt.throwOnFailure(obj);
                        C00091 c000910 = new C00091(preferences$Key, r2, continuation, (byte) 9);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000910, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z10) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        }
    }

    public ShowMediaInfoKt$ShowMediaInfo$$inlined$rememberEnumPreference$2(MutableState mutableState, CoroutineScope coroutineScope, Context context, Preferences$Key preferences$Key) {
        this.$state = mutableState;
        this.$coroutineScope = coroutineScope;
        this.$context = context;
        this.$key = preferences$Key;
    }

    @Override // androidx.compose.runtime.MutableState
    public final Object component1() {
        return (Enum) this.$state.getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    public final Function1 component2() {
        return new RenderScriptBlurEffect$updateSurface$2$4((byte) 21, this);
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return (Enum) this.$state.getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    public final void setValue(Object obj) {
        Enum r3 = (Enum) obj;
        r3.getClass();
        AwaitKt.launch$default(this.$coroutineScope, null, null, new AnonymousClass1(this.$context, this.$key, r3, null, (byte) 0), 3);
    }
}

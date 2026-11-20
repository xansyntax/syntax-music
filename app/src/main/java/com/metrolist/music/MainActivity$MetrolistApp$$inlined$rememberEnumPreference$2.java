package com.metrolist.music;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences$Key;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.utils.UtilsKt;
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
public final class MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2 implements MutableState {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ Preferences$Key $key;
    public final /* synthetic */ State $state;

    /* JADX INFO: renamed from: com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Preferences$Key $key;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Enum $value;
        public boolean label;

        /* JADX INFO: renamed from: com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class C00051 extends SuspendLambda implements Function2 {
            public final /* synthetic */ Preferences$Key $key;
            public final /* synthetic */ byte $r8$classId;
            public final /* synthetic */ Enum $value;
            public /* synthetic */ Object L$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ C00051(Preferences$Key preferences$Key, Enum r2, Continuation continuation, byte b) {
                super(2, continuation);
                this.$r8$classId = b;
                this.$key = preferences$Key;
                this.$value = r2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                switch (this.$r8$classId) {
                    case 0:
                        C00051 c00051 = new C00051(this.$key, this.$value, continuation, (byte) 0);
                        c00051.L$0 = obj;
                        return c00051;
                    case 1:
                        C00051 c00052 = new C00051(this.$key, this.$value, continuation, (byte) 1);
                        c00052.L$0 = obj;
                        return c00052;
                    case 2:
                        C00051 c00053 = new C00051(this.$key, this.$value, continuation, (byte) 2);
                        c00053.L$0 = obj;
                        return c00053;
                    case 3:
                        C00051 c00054 = new C00051(this.$key, this.$value, continuation, (byte) 3);
                        c00054.L$0 = obj;
                        return c00054;
                    case 4:
                        C00051 c00055 = new C00051(this.$key, this.$value, continuation, (byte) 4);
                        c00055.L$0 = obj;
                        return c00055;
                    case 5:
                        C00051 c00056 = new C00051(this.$key, this.$value, continuation, (byte) 5);
                        c00056.L$0 = obj;
                        return c00056;
                    case 6:
                        C00051 c00057 = new C00051(this.$key, this.$value, continuation, (byte) 6);
                        c00057.L$0 = obj;
                        return c00057;
                    case 7:
                        C00051 c00058 = new C00051(this.$key, this.$value, continuation, (byte) 7);
                        c00058.L$0 = obj;
                        return c00058;
                    case 8:
                        C00051 c00059 = new C00051(this.$key, this.$value, continuation, (byte) 8);
                        c00059.L$0 = obj;
                        return c00059;
                    case 9:
                        C00051 c000510 = new C00051(this.$key, this.$value, continuation, (byte) 9);
                        c000510.L$0 = obj;
                        return c000510;
                    case 10:
                        C00051 c000511 = new C00051(this.$key, this.$value, continuation, (byte) 10);
                        c000511.L$0 = obj;
                        return c000511;
                    case 11:
                        C00051 c000512 = new C00051(this.$key, this.$value, continuation, (byte) 11);
                        c000512.L$0 = obj;
                        return c000512;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        C00051 c000513 = new C00051(this.$key, this.$value, continuation, (byte) 12);
                        c000513.L$0 = obj;
                        return c000513;
                    case 13:
                        C00051 c000514 = new C00051(this.$key, this.$value, continuation, (byte) 13);
                        c000514.L$0 = obj;
                        return c000514;
                    case 14:
                        C00051 c000515 = new C00051(this.$key, this.$value, continuation, (byte) 14);
                        c000515.L$0 = obj;
                        return c000515;
                    case 15:
                        C00051 c000516 = new C00051(this.$key, this.$value, continuation, (byte) 15);
                        c000516.L$0 = obj;
                        return c000516;
                    case 16:
                        C00051 c000517 = new C00051(this.$key, this.$value, continuation, (byte) 16);
                        c000517.L$0 = obj;
                        return c000517;
                    case 17:
                        C00051 c000518 = new C00051(this.$key, this.$value, continuation, (byte) 17);
                        c000518.L$0 = obj;
                        return c000518;
                    case 18:
                        C00051 c000519 = new C00051(this.$key, this.$value, continuation, (byte) 18);
                        c000519.L$0 = obj;
                        return c000519;
                    case 19:
                        C00051 c000520 = new C00051(this.$key, this.$value, continuation, (byte) 19);
                        c000520.L$0 = obj;
                        return c000520;
                    case 20:
                        C00051 c000521 = new C00051(this.$key, this.$value, continuation, (byte) 20);
                        c000521.L$0 = obj;
                        return c000521;
                    case 21:
                        C00051 c000522 = new C00051(this.$key, this.$value, continuation, (byte) 21);
                        c000522.L$0 = obj;
                        return c000522;
                    case 22:
                        C00051 c000523 = new C00051(this.$key, this.$value, continuation, (byte) 22);
                        c000523.L$0 = obj;
                        return c000523;
                    case 23:
                        C00051 c000524 = new C00051(this.$key, this.$value, continuation, (byte) 23);
                        c000524.L$0 = obj;
                        return c000524;
                    case 24:
                        C00051 c000525 = new C00051(this.$key, this.$value, continuation, (byte) 24);
                        c000525.L$0 = obj;
                        return c000525;
                    case 25:
                        C00051 c000526 = new C00051(this.$key, this.$value, continuation, (byte) 25);
                        c000526.L$0 = obj;
                        return c000526;
                    case 26:
                        C00051 c000527 = new C00051(this.$key, this.$value, continuation, (byte) 26);
                        c000527.L$0 = obj;
                        return c000527;
                    case 27:
                        C00051 c000528 = new C00051(this.$key, this.$value, continuation, (byte) 27);
                        c000528.L$0 = obj;
                        return c000528;
                    case 28:
                        C00051 c000529 = new C00051(this.$key, this.$value, continuation, (byte) 28);
                        c000529.L$0 = obj;
                        return c000529;
                    default:
                        C00051 c000530 = new C00051(this.$key, this.$value, continuation, (byte) 29);
                        c000530.L$0 = obj;
                        return c000530;
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
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 1:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 2:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 3:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 4:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 5:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 6:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 7:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 8:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 9:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 10:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 11:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 13:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 14:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 15:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 16:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 17:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 18:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 19:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 20:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 21:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 22:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 23:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 24:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 25:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 26:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 27:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 28:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    default:
                        ((C00051) create(mutablePreferences, continuation)).invokeSuspend(unit);
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
                    case 9:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 10:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 11:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 13:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 14:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 15:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 16:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 17:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 18:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 19:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 20:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 21:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 22:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 23:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 24:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 25:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 26:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 27:
                        ResultKt.throwOnFailure(obj);
                        mutablePreferences.set(preferences$Key, r2.name());
                        break;
                    case 28:
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
                case 9:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 9);
                case 10:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 10);
                case 11:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 11);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 12);
                case 13:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 13);
                case 14:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 14);
                case 15:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 15);
                case 16:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 16);
                case 17:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 17);
                case 18:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 18);
                case 19:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 19);
                case 20:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 20);
                case 21:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 21);
                case 22:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 22);
                case 23:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 23);
                case 24:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 24);
                case 25:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 25);
                case 26:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 26);
                case 27:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 27);
                case 28:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 28);
                default:
                    return new AnonymousClass1(this.$context, this.$key, this.$value, continuation, (byte) 29);
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
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;
                case 17:
                    break;
                case 18:
                    break;
                case 19:
                    break;
                case 20:
                    break;
                case 21:
                    break;
                case 22:
                    break;
                case 23:
                    break;
                case 24:
                    break;
                case 25:
                    break;
                case 26:
                    break;
                case 27:
                    break;
                case 28:
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
                        C00051 c00051 = new C00051(preferences$Key, r2, continuation, (byte) 0);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00051, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00051 c00052 = new C00051(preferences$Key, r2, continuation, b2);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00052, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00051 c00053 = new C00051(preferences$Key, r2, continuation, (byte) 2);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00053, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00051 c00054 = new C00051(preferences$Key, r2, continuation, (byte) 3);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00054, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00051 c00055 = new C00051(preferences$Key, r2, continuation, (byte) 4);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00055, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00051 c00056 = new C00051(preferences$Key, r2, continuation, (byte) 5);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00056, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00051 c00057 = new C00051(preferences$Key, r2, continuation, (byte) 6);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00057, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00051 c00058 = new C00051(preferences$Key, r2, continuation, (byte) 7);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00058, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00051 c00059 = new C00051(preferences$Key, r2, continuation, (byte) 8);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00059, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z9) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 9:
                    boolean z10 = this.label;
                    if (!z10) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000510 = new C00051(preferences$Key, r2, continuation, (byte) 9);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000510, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z10) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 10:
                    boolean z11 = this.label;
                    if (!z11) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000511 = new C00051(preferences$Key, r2, continuation, (byte) 10);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000511, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z11) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 11:
                    boolean z12 = this.label;
                    if (!z12) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000512 = new C00051(preferences$Key, r2, continuation, (byte) 11);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000512, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z12) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    boolean z13 = this.label;
                    if (!z13) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000513 = new C00051(preferences$Key, r2, continuation, (byte) 12);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000513, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z13) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 13:
                    boolean z14 = this.label;
                    if (!z14) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000514 = new C00051(preferences$Key, r2, continuation, (byte) 13);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000514, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z14) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 14:
                    boolean z15 = this.label;
                    if (!z15) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000515 = new C00051(preferences$Key, r2, continuation, (byte) 14);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000515, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z15) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 15:
                    boolean z16 = this.label;
                    if (!z16) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000516 = new C00051(preferences$Key, r2, continuation, (byte) 15);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000516, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z16) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 16:
                    boolean z17 = this.label;
                    if (!z17) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000517 = new C00051(preferences$Key, r2, continuation, (byte) 16);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000517, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z17) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 17:
                    boolean z18 = this.label;
                    if (!z18) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000518 = new C00051(preferences$Key, r2, continuation, (byte) 17);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000518, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z18) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 18:
                    boolean z19 = this.label;
                    if (!z19) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000519 = new C00051(preferences$Key, r2, continuation, (byte) 18);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000519, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z19) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 19:
                    boolean z20 = this.label;
                    if (!z20) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000520 = new C00051(preferences$Key, r2, continuation, (byte) 19);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000520, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z20) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 20:
                    boolean z21 = this.label;
                    if (!z21) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000521 = new C00051(preferences$Key, r2, continuation, (byte) 20);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000521, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z21) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 21:
                    boolean z22 = this.label;
                    if (!z22) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000522 = new C00051(preferences$Key, r2, continuation, (byte) 21);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000522, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z22) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 22:
                    boolean z23 = this.label;
                    if (!z23) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000523 = new C00051(preferences$Key, r2, continuation, (byte) 22);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000523, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z23) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 23:
                    boolean z24 = this.label;
                    if (!z24) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000524 = new C00051(preferences$Key, r2, continuation, (byte) 23);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000524, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z24) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 24:
                    boolean z25 = this.label;
                    if (!z25) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000525 = new C00051(preferences$Key, r2, continuation, (byte) 24);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000525, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z25) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 25:
                    boolean z26 = this.label;
                    if (!z26) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000526 = new C00051(preferences$Key, r2, continuation, (byte) 25);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000526, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z26) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 26:
                    boolean z27 = this.label;
                    if (!z27) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000527 = new C00051(preferences$Key, r2, continuation, (byte) 26);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000527, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z27) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 27:
                    boolean z28 = this.label;
                    if (!z28) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000528 = new C00051(preferences$Key, r2, continuation, (byte) 27);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000528, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z28) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 28:
                    boolean z29 = this.label;
                    if (!z29) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000529 = new C00051(preferences$Key, r2, continuation, (byte) 28);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000529, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z29) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                default:
                    boolean z30 = this.label;
                    if (!z30) {
                        ResultKt.throwOnFailure(obj);
                        C00051 c000530 = new C00051(preferences$Key, r2, continuation, (byte) 29);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000530, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z30) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        }
    }

    public MainActivity$MetrolistApp$$inlined$rememberEnumPreference$2(MutableState mutableState, CoroutineScope coroutineScope, Context context, Preferences$Key preferences$Key) {
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
        return new CallsKt$await$2$1((byte) 8, this);
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

package com.metrolist.music.ui.screens.search;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences$Key;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
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
public final class SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2 implements MutableState {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ Preferences$Key $key;
    public final /* synthetic */ State $state;

    /* JADX INFO: renamed from: com.metrolist.music.ui.screens.search.SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Preferences$Key $key;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Enum $value;
        public boolean label;

        /* JADX INFO: renamed from: com.metrolist.music.ui.screens.search.SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class C00081 extends SuspendLambda implements Function2 {
            public final /* synthetic */ Preferences$Key $key;
            public final /* synthetic */ byte $r8$classId;
            public final /* synthetic */ Enum $value;
            public /* synthetic */ Object L$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ C00081(Preferences$Key preferences$Key, Enum r2, Continuation continuation, byte b) {
                super(2, continuation);
                this.$r8$classId = b;
                this.$key = preferences$Key;
                this.$value = r2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                switch (this.$r8$classId) {
                    case 0:
                        C00081 c00081 = new C00081(this.$key, this.$value, continuation, (byte) 0);
                        c00081.L$0 = obj;
                        return c00081;
                    case 1:
                        C00081 c00082 = new C00081(this.$key, this.$value, continuation, (byte) 1);
                        c00082.L$0 = obj;
                        return c00082;
                    case 2:
                        C00081 c00083 = new C00081(this.$key, this.$value, continuation, (byte) 2);
                        c00083.L$0 = obj;
                        return c00083;
                    case 3:
                        C00081 c00084 = new C00081(this.$key, this.$value, continuation, (byte) 3);
                        c00084.L$0 = obj;
                        return c00084;
                    case 4:
                        C00081 c00085 = new C00081(this.$key, this.$value, continuation, (byte) 4);
                        c00085.L$0 = obj;
                        return c00085;
                    case 5:
                        C00081 c00086 = new C00081(this.$key, this.$value, continuation, (byte) 5);
                        c00086.L$0 = obj;
                        return c00086;
                    case 6:
                        C00081 c00087 = new C00081(this.$key, this.$value, continuation, (byte) 6);
                        c00087.L$0 = obj;
                        return c00087;
                    case 7:
                        C00081 c00088 = new C00081(this.$key, this.$value, continuation, (byte) 7);
                        c00088.L$0 = obj;
                        return c00088;
                    case 8:
                        C00081 c00089 = new C00081(this.$key, this.$value, continuation, (byte) 8);
                        c00089.L$0 = obj;
                        return c00089;
                    case 9:
                        C00081 c000810 = new C00081(this.$key, this.$value, continuation, (byte) 9);
                        c000810.L$0 = obj;
                        return c000810;
                    case 10:
                        C00081 c000811 = new C00081(this.$key, this.$value, continuation, (byte) 10);
                        c000811.L$0 = obj;
                        return c000811;
                    case 11:
                        C00081 c000812 = new C00081(this.$key, this.$value, continuation, (byte) 11);
                        c000812.L$0 = obj;
                        return c000812;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        C00081 c000813 = new C00081(this.$key, this.$value, continuation, (byte) 12);
                        c000813.L$0 = obj;
                        return c000813;
                    case 13:
                        C00081 c000814 = new C00081(this.$key, this.$value, continuation, (byte) 13);
                        c000814.L$0 = obj;
                        return c000814;
                    case 14:
                        C00081 c000815 = new C00081(this.$key, this.$value, continuation, (byte) 14);
                        c000815.L$0 = obj;
                        return c000815;
                    case 15:
                        C00081 c000816 = new C00081(this.$key, this.$value, continuation, (byte) 15);
                        c000816.L$0 = obj;
                        return c000816;
                    case 16:
                        C00081 c000817 = new C00081(this.$key, this.$value, continuation, (byte) 16);
                        c000817.L$0 = obj;
                        return c000817;
                    case 17:
                        C00081 c000818 = new C00081(this.$key, this.$value, continuation, (byte) 17);
                        c000818.L$0 = obj;
                        return c000818;
                    case 18:
                        C00081 c000819 = new C00081(this.$key, this.$value, continuation, (byte) 18);
                        c000819.L$0 = obj;
                        return c000819;
                    case 19:
                        C00081 c000820 = new C00081(this.$key, this.$value, continuation, (byte) 19);
                        c000820.L$0 = obj;
                        return c000820;
                    case 20:
                        C00081 c000821 = new C00081(this.$key, this.$value, continuation, (byte) 20);
                        c000821.L$0 = obj;
                        return c000821;
                    case 21:
                        C00081 c000822 = new C00081(this.$key, this.$value, continuation, (byte) 21);
                        c000822.L$0 = obj;
                        return c000822;
                    case 22:
                        C00081 c000823 = new C00081(this.$key, this.$value, continuation, (byte) 22);
                        c000823.L$0 = obj;
                        return c000823;
                    case 23:
                        C00081 c000824 = new C00081(this.$key, this.$value, continuation, (byte) 23);
                        c000824.L$0 = obj;
                        return c000824;
                    case 24:
                        C00081 c000825 = new C00081(this.$key, this.$value, continuation, (byte) 24);
                        c000825.L$0 = obj;
                        return c000825;
                    case 25:
                        C00081 c000826 = new C00081(this.$key, this.$value, continuation, (byte) 25);
                        c000826.L$0 = obj;
                        return c000826;
                    case 26:
                        C00081 c000827 = new C00081(this.$key, this.$value, continuation, (byte) 26);
                        c000827.L$0 = obj;
                        return c000827;
                    case 27:
                        C00081 c000828 = new C00081(this.$key, this.$value, continuation, (byte) 27);
                        c000828.L$0 = obj;
                        return c000828;
                    case 28:
                        C00081 c000829 = new C00081(this.$key, this.$value, continuation, (byte) 28);
                        c000829.L$0 = obj;
                        return c000829;
                    default:
                        C00081 c000830 = new C00081(this.$key, this.$value, continuation, (byte) 29);
                        c000830.L$0 = obj;
                        return c000830;
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
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 1:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 2:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 3:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 4:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 5:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 6:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 7:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 8:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 9:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 10:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 11:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 13:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 14:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 15:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 16:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 17:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 18:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 19:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 20:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 21:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 22:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 23:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 24:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 25:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 26:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 27:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    case 28:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
                        break;
                    default:
                        ((C00081) create(mutablePreferences, continuation)).invokeSuspend(unit);
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
                        C00081 c00081 = new C00081(preferences$Key, r2, continuation, (byte) 0);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00081, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c00082 = new C00081(preferences$Key, r2, continuation, b2);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00082, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c00083 = new C00081(preferences$Key, r2, continuation, (byte) 2);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00083, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c00084 = new C00081(preferences$Key, r2, continuation, (byte) 3);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00084, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c00085 = new C00081(preferences$Key, r2, continuation, (byte) 4);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00085, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c00086 = new C00081(preferences$Key, r2, continuation, (byte) 5);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00086, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c00087 = new C00081(preferences$Key, r2, continuation, (byte) 6);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00087, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c00088 = new C00081(preferences$Key, r2, continuation, (byte) 7);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00088, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c00089 = new C00081(preferences$Key, r2, continuation, (byte) 8);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c00089, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000810 = new C00081(preferences$Key, r2, continuation, (byte) 9);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000810, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000811 = new C00081(preferences$Key, r2, continuation, (byte) 10);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000811, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000812 = new C00081(preferences$Key, r2, continuation, (byte) 11);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000812, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000813 = new C00081(preferences$Key, r2, continuation, (byte) 12);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000813, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000814 = new C00081(preferences$Key, r2, continuation, (byte) 13);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000814, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000815 = new C00081(preferences$Key, r2, continuation, (byte) 14);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000815, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000816 = new C00081(preferences$Key, r2, continuation, (byte) 15);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000816, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000817 = new C00081(preferences$Key, r2, continuation, (byte) 16);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000817, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000818 = new C00081(preferences$Key, r2, continuation, (byte) 17);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000818, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000819 = new C00081(preferences$Key, r2, continuation, (byte) 18);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000819, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000820 = new C00081(preferences$Key, r2, continuation, (byte) 19);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000820, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000821 = new C00081(preferences$Key, r2, continuation, (byte) 20);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000821, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000822 = new C00081(preferences$Key, r2, continuation, (byte) 21);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000822, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000823 = new C00081(preferences$Key, r2, continuation, (byte) 22);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000823, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000824 = new C00081(preferences$Key, r2, continuation, (byte) 23);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000824, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000825 = new C00081(preferences$Key, r2, continuation, (byte) 24);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000825, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000826 = new C00081(preferences$Key, r2, continuation, (byte) 25);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000826, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000827 = new C00081(preferences$Key, r2, continuation, (byte) 26);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000827, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000828 = new C00081(preferences$Key, r2, continuation, (byte) 27);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000828, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000829 = new C00081(preferences$Key, r2, continuation, (byte) 28);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000829, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                        C00081 c000830 = new C00081(preferences$Key, r2, continuation, (byte) 29);
                        this.label = true;
                        return UtilsKt.safeDataStoreEdit(context, c000830, this) == coroutineSingletons ? coroutineSingletons : unit;
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

    public SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2(MutableState mutableState, CoroutineScope coroutineScope, Context context, Preferences$Key preferences$Key) {
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
        return new RenderScriptBlurEffect$updateSurface$2$4((byte) 3, this);
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

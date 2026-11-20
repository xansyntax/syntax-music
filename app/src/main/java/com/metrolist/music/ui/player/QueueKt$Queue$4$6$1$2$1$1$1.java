package com.metrolist.music.ui.player;

import android.content.Context;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.datastore.preferences.core.MutablePreferences;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.utils.UtilsKt;
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
public final class QueueKt$Queue$4$6$1$2$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState $sleepTimerValue$delegate;
    public boolean label;

    /* JADX INFO: renamed from: com.metrolist.music.ui.player.QueueKt$Queue$4$6$1$2$1$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ ParcelableSnapshotMutableFloatState $sleepTimerValue$delegate;
        public /* synthetic */ Object L$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$sleepTimerValue$delegate = parcelableSnapshotMutableFloatState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$sleepTimerValue$delegate, continuation, (byte) 0);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                case 1:
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1(this.$sleepTimerValue$delegate, continuation, (byte) 1);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                case 2:
                    AnonymousClass1 anonymousClass3 = new AnonymousClass1(this.$sleepTimerValue$delegate, continuation, (byte) 2);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                default:
                    AnonymousClass1 anonymousClass4 = new AnonymousClass1(this.$sleepTimerValue$delegate, continuation, (byte) 3);
                    anonymousClass4.L$0 = obj;
                    return anonymousClass4;
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
                    ((AnonymousClass1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                    break;
                case 1:
                    ((AnonymousClass1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                    break;
                case 2:
                    ((AnonymousClass1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                    break;
                default:
                    ((AnonymousClass1) create(mutablePreferences, continuation)).invokeSuspend(unit);
                    break;
            }
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.$sleepTimerValue$delegate;
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    mutablePreferences.set(PreferenceKeysKt.SleepTimerDefaultKey, new Float(parcelableSnapshotMutableFloatState.getFloatValue()));
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    mutablePreferences.set(PreferenceKeysKt.SleepTimerDefaultKey, new Float(parcelableSnapshotMutableFloatState.getFloatValue()));
                    break;
                case 2:
                    ResultKt.throwOnFailure(obj);
                    mutablePreferences.set(PreferenceKeysKt.SleepTimerDefaultKey, new Float(parcelableSnapshotMutableFloatState.getFloatValue()));
                    break;
                default:
                    ResultKt.throwOnFailure(obj);
                    mutablePreferences.set(PreferenceKeysKt.SleepTimerDefaultKey, new Float(parcelableSnapshotMutableFloatState.getFloatValue()));
                    break;
            }
            return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueueKt$Queue$4$6$1$2$1$1$1(Context context, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$context = context;
        this.$sleepTimerValue$delegate = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.$sleepTimerValue$delegate;
        Context context = this.$context;
        switch (b) {
            case 0:
                return new QueueKt$Queue$4$6$1$2$1$1$1(context, parcelableSnapshotMutableFloatState, continuation, (byte) 0);
            case 1:
                return new QueueKt$Queue$4$6$1$2$1$1$1(context, parcelableSnapshotMutableFloatState, continuation, (byte) 1);
            case 2:
                return new QueueKt$Queue$4$6$1$2$1$1$1(context, parcelableSnapshotMutableFloatState, continuation, (byte) 2);
            default:
                return new QueueKt$Queue$4$6$1$2$1$1$1(context, parcelableSnapshotMutableFloatState, continuation, (byte) 3);
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
        }
        return ((QueueKt$Queue$4$6$1$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.$sleepTimerValue$delegate;
        Context context = this.$context;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        byte b2 = 1;
        Continuation continuation = null;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(parcelableSnapshotMutableFloatState, continuation, (byte) 0);
                    this.label = true;
                    return UtilsKt.safeDataStoreEdit(context, anonymousClass1, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1(parcelableSnapshotMutableFloatState, continuation, b2);
                    this.label = true;
                    return UtilsKt.safeDataStoreEdit(context, anonymousClass2, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                    AnonymousClass1 anonymousClass3 = new AnonymousClass1(parcelableSnapshotMutableFloatState, continuation, (byte) 2);
                    this.label = true;
                    return UtilsKt.safeDataStoreEdit(context, anonymousClass3, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z3) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass1 anonymousClass4 = new AnonymousClass1(parcelableSnapshotMutableFloatState, continuation, (byte) 3);
                    this.label = true;
                    return UtilsKt.safeDataStoreEdit(context, anonymousClass4, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z4) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}

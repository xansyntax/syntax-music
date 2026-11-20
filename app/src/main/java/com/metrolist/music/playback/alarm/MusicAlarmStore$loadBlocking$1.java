package com.metrolist.music.playback.alarm;

import android.content.Context;
import android.widget.Toast;
import com.metrolist.music.recognition.MusicRecognitionService;
import com.yalantis.ucrop.R;
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
public final class MusicAlarmStore$loadBlocking$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicAlarmStore$loadBlocking$1(Context context, boolean z, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 1;
        this.$context = context;
        this.label = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new MusicAlarmStore$loadBlocking$1(this.$context, continuation, (byte) 0);
            case 1:
                return new MusicAlarmStore$loadBlocking$1(this.$context, this.label, continuation);
            case 2:
                return new MusicAlarmStore$loadBlocking$1(this.$context, continuation, (byte) 2);
            case 3:
                return new MusicAlarmStore$loadBlocking$1(this.$context, continuation, (byte) 3);
            default:
                return new MusicAlarmStore$loadBlocking$1(this.$context, continuation, (byte) 4);
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
                return ((MusicAlarmStore$loadBlocking$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 1:
                ((MusicAlarmStore$loadBlocking$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 2:
                return ((MusicAlarmStore$loadBlocking$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 3:
                return ((MusicAlarmStore$loadBlocking$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            default:
                return ((MusicAlarmStore$loadBlocking$1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        MusicAlarmStore musicAlarmStore = MusicAlarmStore.INSTANCE;
        Unit unit = Unit.INSTANCE;
        Context context = this.$context;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    Object objLoad = musicAlarmStore.load(context, this);
                    return objLoad == coroutineSingletons ? coroutineSingletons : objLoad;
                }
                if (z) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                ResultKt.throwOnFailure(obj);
                Toast.makeText(context, this.label ? R.string.error_podcast_unsubscribe : R.string.error_podcast_subscribe, 0).show();
                return unit;
            case 2:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    MusicRecognitionService musicRecognitionService = MusicRecognitionService.INSTANCE;
                    this.label = true;
                    return MusicRecognitionService.recognize(context, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    MusicRecognitionService musicRecognitionService2 = MusicRecognitionService.INSTANCE;
                    this.label = true;
                    return MusicRecognitionService.recognize(context, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                    this.label = true;
                    Object objLoad2 = musicAlarmStore.load(context, this);
                    return objLoad2 == coroutineSingletons ? coroutineSingletons : objLoad2;
                }
                if (z4) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MusicAlarmStore$loadBlocking$1(Context context, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$context = context;
    }
}

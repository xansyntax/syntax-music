package com.metrolist.music.recognition;

import com.metrolist.music.viewmodels.ArtistViewModel;
import com.metrolist.shazamkit.models.RecognitionStatus;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RecognitionForegroundService$startRecognition$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ RecognitionForegroundService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecognitionForegroundService$startRecognition$1(RecognitionForegroundService recognitionForegroundService, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = recognitionForegroundService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        RecognitionForegroundService recognitionForegroundService = this.this$0;
        switch (b) {
            case 0:
                return new RecognitionForegroundService$startRecognition$1(recognitionForegroundService, continuation, (byte) 0);
            default:
                return new RecognitionForegroundService$startRecognition$1(recognitionForegroundService, continuation, (byte) 1);
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
                ((RecognitionForegroundService$startRecognition$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            default:
                return ((RecognitionForegroundService$startRecognition$1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        RecognitionForegroundService recognitionForegroundService = this.this$0;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ReadonlyStateFlow readonlyStateFlow = MusicRecognitionService.recognitionStatus;
                ArtistViewModel.AnonymousClass1.AnonymousClass2 anonymousClass2 = new ArtistViewModel.AnonymousClass1.AnonymousClass2((byte) 7, recognitionForegroundService);
                this.label = true;
                if (readonlyStateFlow.$$delegate_0.collect(anonymousClass2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    MusicRecognitionService musicRecognitionService = MusicRecognitionService.INSTANCE;
                    this.label = true;
                    obj = MusicRecognitionService.recognize(recognitionForegroundService, this);
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
                RecognitionStatus recognitionStatus = (RecognitionStatus) obj;
                if ((recognitionStatus instanceof RecognitionStatus.Error) && !(MusicRecognitionService.recognitionStatus.$$delegate_0.getValue() instanceof RecognitionStatus.Error)) {
                    int i = RecognitionForegroundService.$r8$clinit;
                    recognitionForegroundService.renderStatus(recognitionStatus);
                }
                return Unit.INSTANCE;
        }
    }
}

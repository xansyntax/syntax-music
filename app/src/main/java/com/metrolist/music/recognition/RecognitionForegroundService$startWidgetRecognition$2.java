package com.metrolist.music.recognition;

import com.metrolist.shazamkit.models.RecognitionResult;
import com.metrolist.shazamkit.models.RecognitionStatus;
import com.yalantis.ucrop.R;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RecognitionForegroundService$startWidgetRecognition$2 extends SuspendLambda implements Function2 {
    public byte label;
    public final /* synthetic */ RecognitionForegroundService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecognitionForegroundService$startWidgetRecognition$2(RecognitionForegroundService recognitionForegroundService, Continuation continuation) {
        super(2, continuation);
        this.this$0 = recognitionForegroundService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RecognitionForegroundService$startWidgetRecognition$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((RecognitionForegroundService$startWidgetRecognition$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x009b A[PHI: r8
      0x009b: PHI (r8v10 kotlinx.coroutines.StandaloneCoroutine) = (r8v4 kotlinx.coroutines.StandaloneCoroutine), (r8v19 kotlinx.coroutines.StandaloneCoroutine) binds: [B:53:0x00c9, B:45:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
    
        if (r6.saveWidgetSuccess(r9, r8) == r7) goto L43;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        StandaloneCoroutine standaloneCoroutine;
        byte b;
        byte b2 = this.label;
        RecognitionForegroundService recognitionForegroundService = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (b2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    MusicRecognitionService musicRecognitionService = MusicRecognitionService.INSTANCE;
                    this.label = (byte) 1;
                    obj = MusicRecognitionService.recognize(recognitionForegroundService, this);
                    if (obj == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b2 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (b2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                standaloneCoroutine = recognitionForegroundService.pulseJob;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel(null);
                }
                recognitionForegroundService.updateAllWidgets();
                recognitionForegroundService.stopForeground(1);
                recognitionForegroundService.stopSelf();
                return Unit.INSTANCE;
                RecognitionStatus recognitionStatus = (RecognitionStatus) obj;
                if (recognitionStatus == null) {
                    b = -1;
                } else if (recognitionStatus instanceof RecognitionStatus.Success) {
                    b = 0;
                } else if (recognitionStatus instanceof RecognitionStatus.NoMatch) {
                    b = 1;
                } else {
                    b = recognitionStatus instanceof RecognitionStatus.Error ? (byte) 2 : (byte) -2;
                }
                if (b == 0) {
                    RecognitionResult result = ((RecognitionStatus.Success) recognitionStatus).getResult();
                    this.label = (byte) 2;
                    int i = RecognitionForegroundService.$r8$clinit;
                } else if (b == 1) {
                    String message = ((RecognitionStatus.NoMatch) recognitionStatus).getMessage();
                    int i2 = RecognitionForegroundService.$r8$clinit;
                    recognitionForegroundService.saveWidgetFailure(4, message);
                } else if (b != 2) {
                    int i3 = RecognitionForegroundService.$r8$clinit;
                    recognitionForegroundService.getSharedPreferences("recognizer_widget_prefs", 0).edit().putInt("state", 0).apply();
                } else {
                    String message2 = ((RecognitionStatus.Error) recognitionStatus).getMessage();
                    int i4 = RecognitionForegroundService.$r8$clinit;
                    recognitionForegroundService.saveWidgetFailure(5, message2);
                }
                standaloneCoroutine = recognitionForegroundService.pulseJob;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel(null);
                }
            } catch (CancellationException e) {
                throw e;
            } catch (Exception e2) {
                Timber.Forest.getClass();
                ConnectionPool.e$1(new Object[0]);
                String message3 = e2.getMessage();
                if (message3 == null) {
                    message3 = recognitionForegroundService.getString(R.string.widget_recognizer_error);
                    message3.getClass();
                }
                int i5 = RecognitionForegroundService.$r8$clinit;
                recognitionForegroundService.saveWidgetFailure(5, message3);
                standaloneCoroutine = recognitionForegroundService.pulseJob;
                if (standaloneCoroutine != null) {
                }
            }
            recognitionForegroundService.updateAllWidgets();
            recognitionForegroundService.stopForeground(1);
            recognitionForegroundService.stopSelf();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            StandaloneCoroutine standaloneCoroutine2 = recognitionForegroundService.pulseJob;
            if (standaloneCoroutine2 != null) {
                standaloneCoroutine2.cancel(null);
            }
            recognitionForegroundService.updateAllWidgets();
            recognitionForegroundService.stopForeground(1);
            recognitionForegroundService.stopSelf();
            throw th;
        }
    }
}

package com.metrolist.music.recognition;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioResampler {
    public static final AudioResampler INSTANCE = new AudioResampler();

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: resample-0E7RQCE, reason: not valid java name */
    public final Object m1452resample0E7RQCE(DecodedAudio decodedAudio, int i, ContinuationImpl continuationImpl) {
        AudioResampler$resample$1 audioResampler$resample$1;
        if (continuationImpl instanceof AudioResampler$resample$1) {
            audioResampler$resample$1 = (AudioResampler$resample$1) continuationImpl;
            int i2 = audioResampler$resample$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                audioResampler$resample$1.label = i2 - Integer.MIN_VALUE;
            } else {
                audioResampler$resample$1 = new AudioResampler$resample$1(this, continuationImpl);
            }
        } else {
            audioResampler$resample$1 = new AudioResampler$resample$1(this, continuationImpl);
        }
        Object objWithContext = audioResampler$resample$1.result;
        int i3 = audioResampler$resample$1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AudioResampler$resample$2 audioResampler$resample$2 = new AudioResampler$resample$2(decodedAudio, i, null);
            audioResampler$resample$1.label = 1;
            objWithContext = AwaitKt.withContext(defaultScheduler, audioResampler$resample$2, audioResampler$resample$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return ((Result) objWithContext).value;
    }
}

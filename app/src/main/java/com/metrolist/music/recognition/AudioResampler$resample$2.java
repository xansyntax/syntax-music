package com.metrolist.music.recognition;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioResampler$resample$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ DecodedAudio $decodedAudio;
    public final /* synthetic */ short $outputSampleRate;
    public /* synthetic */ Object L$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AudioResampler$resample$2(DecodedAudio decodedAudio, int i, Continuation continuation) {
        super(2, continuation);
        this.$decodedAudio = decodedAudio;
        this.$outputSampleRate = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AudioResampler$resample$2 audioResampler$resample$2 = new AudioResampler$resample$2(this.$decodedAudio, this.$outputSampleRate, continuation);
        audioResampler$resample$2.L$0 = obj;
        return audioResampler$resample$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((AudioResampler$resample$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object failure;
        short s;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(obj);
        DecodedAudio decodedAudio = this.$decodedAudio;
        char c = decodedAudio.sampleRate;
        byte[] bArr = decodedAudio.data;
        char c2 = decodedAudio.sampleRate;
        char c3 = this.$outputSampleRate;
        if (c == c3) {
            Timber.Forest.tag("AudioResampler");
            ConnectionPool.d(new Integer(c3));
            return new Result(decodedAudio);
        }
        try {
            Timber.Forest.tag("AudioResampler");
            ConnectionPool.d(new Integer(c2), new Integer(c3), new Integer(bArr.length));
            int length = bArr.length / 2;
            short[] sArr = new short[length];
            ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
            double d = ((double) c3) / ((double) c2);
            int i = (int) (((double) length) * d);
            short[] sArr2 = new short[i];
            int i2 = 0;
            while (i2 < i) {
                AwaitKt.ensureActive(coroutineScope.getCoroutineContext());
                double d2 = ((double) i2) / d;
                int i3 = (int) d2;
                double d3 = d2 - ((double) i3);
                int i4 = i3 + 1;
                if (i4 < length) {
                    s = (short) ((((double) sArr[i4]) * d3) + ((1.0d - d3) * ((double) sArr[i3])));
                } else {
                    s = sArr[i3];
                }
                sArr2[i2] = s;
                i2++;
                length = length;
            }
            int i5 = i * 2;
            byte[] bArr2 = new byte[i5];
            ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(sArr2);
            Timber.Forest.tag("AudioResampler");
            ConnectionPool.d(new Integer(i5), new Integer(c3), new Integer(1));
            failure = new DecodedAudio(bArr2, c3);
        } catch (Exception e) {
            Timber.Forest.tag("AudioResampler");
            ConnectionPool.e$1(new Object[0]);
            AwaitKt.ensureActive(coroutineScope.getCoroutineContext());
            failure = new Result.Failure(e);
        }
        return new Result(failure);
    }
}

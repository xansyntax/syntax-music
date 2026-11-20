package com.metrolist.music.eq.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.BaseAudioProcessor;
import com.metrolist.music.eq.data.ParametricEQ;
import com.metrolist.music.eq.data.ParametricEQBand;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.uuid.UuidKt;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CustomEqualizerAudioProcessor extends BaseAudioProcessor {
    public int channelCount;
    public boolean equalizerEnabled;
    public List filters;
    public ParametricEQ pendingProfile;
    public double preampGain;
    public int sampleRate;

    public final void createFilters(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            ParametricEQBand parametricEQBand = (ParametricEQBand) obj;
            if (parametricEQBand.enabled && parametricEQBand.frequency < ((double) this.sampleRate) / 2.0d) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            ParametricEQBand parametricEQBand2 = (ParametricEQBand) obj2;
            arrayList2.add(new BiquadFilter(this.sampleRate, parametricEQBand2.frequency, parametricEQBand2.gain, parametricEQBand2.q, parametricEQBand2.filterType));
        }
        this.filters = arrayList2;
        Timber.Forest.tag("CustomEqualizerAudioProcessor");
        this.filters.size();
        list.size();
        ConnectionPool.d(new Object[0]);
    }

    public final synchronized void disable() {
        this.equalizerEnabled = false;
        this.filters = EmptyList.INSTANCE;
        this.preampGain = 1.0d;
        this.pendingProfile = null;
        Timber.Forest.tag("CustomEqualizerAudioProcessor");
        ConnectionPool.d(new Object[0]);
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i;
        if (audioFormat.encoding != 2 || (i = audioFormat.channelCount) > 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        this.sampleRate = audioFormat.sampleRate;
        this.channelCount = i;
        ConnectionPool connectionPool = Timber.Forest;
        connectionPool.tag("CustomEqualizerAudioProcessor");
        ConnectionPool.d(new Object[0]);
        ParametricEQ parametricEQ = this.pendingProfile;
        if (parametricEQ != null) {
            this.preampGain = Math.pow(10.0d, parametricEQ.preamp / 20.0d);
            createFilters(parametricEQ.bands);
            this.equalizerEnabled = true;
            this.pendingProfile = null;
            connectionPool.tag("CustomEqualizerAudioProcessor");
            this.filters.size();
            ConnectionPool.d(new Object[0]);
        }
        return audioFormat;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void onFlush(AudioProcessor.StreamMetadata streamMetadata) {
        streamMetadata.getClass();
        Iterator it = this.filters.iterator();
        while (it.hasNext()) {
            ((BiquadFilter) it.next()).reset();
        }
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void onReset() {
        this.sampleRate = 0;
        this.channelCount = 0;
        Iterator it = this.filters.iterator();
        while (it.hasNext()) {
            ((BiquadFilter) it.next()).reset();
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void queueInput(ByteBuffer byteBuffer) {
        int i;
        int i2;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferReplaceOutputBuffer = replaceOutputBuffer(byteBuffer.remaining());
            byteBufferReplaceOutputBuffer.getClass();
            if (!this.equalizerEnabled || this.filters.isEmpty()) {
                byteBufferReplaceOutputBuffer.put(byteBuffer);
            } else {
                int i3 = 2;
                int iRemaining = (byteBuffer.remaining() / 2) / this.channelCount;
                int i4 = 0;
                while (i4 < iRemaining) {
                    int i5 = this.channelCount;
                    double d = 32768.0d;
                    if (i5 == 1) {
                        i = iRemaining;
                        i2 = i4;
                        double d2 = ((double) byteBuffer.getShort()) / 32768.0d;
                        for (BiquadFilter biquadFilter : this.filters) {
                            double d3 = biquadFilter.b0 * d2;
                            double d4 = biquadFilter.b1;
                            double d5 = biquadFilter.x1L;
                            double d6 = (biquadFilter.b2 * biquadFilter.x2L) + (d4 * d5) + d3;
                            double d7 = biquadFilter.a1;
                            double d8 = biquadFilter.y1L;
                            double d9 = (d6 - (d7 * d8)) - (biquadFilter.a2 * biquadFilter.y2L);
                            biquadFilter.x2L = d5;
                            biquadFilter.x1L = d2;
                            biquadFilter.y2L = d8;
                            biquadFilter.y1L = d9;
                            d2 = d9;
                        }
                        byteBufferReplaceOutputBuffer.putShort((short) UuidKt.coerceIn(d2 * this.preampGain * 32768.0d, -32768.0d, 32767.0d));
                    } else if (i5 != i3) {
                        i = iRemaining;
                        i2 = i4;
                    } else {
                        double d10 = ((double) byteBuffer.getShort()) / 32768.0d;
                        double d11 = ((double) byteBuffer.getShort()) / 32768.0d;
                        for (BiquadFilter biquadFilter2 : this.filters) {
                            double d12 = biquadFilter2.b0;
                            int i6 = i4;
                            double d13 = biquadFilter2.b1;
                            double d14 = d;
                            double d15 = biquadFilter2.x1L;
                            int i7 = iRemaining;
                            double d16 = biquadFilter2.b2;
                            double d17 = (biquadFilter2.x2L * d16) + (d13 * d15) + (d12 * d10);
                            double d18 = biquadFilter2.a1;
                            double d19 = biquadFilter2.y1L;
                            double d20 = biquadFilter2.a2;
                            double d21 = (d17 - (d18 * d19)) - (biquadFilter2.y2L * d20);
                            biquadFilter2.x2L = d15;
                            biquadFilter2.x1L = d10;
                            biquadFilter2.y2L = d19;
                            biquadFilter2.y1L = d21;
                            double d22 = biquadFilter2.x1R;
                            double d23 = (biquadFilter2.x2R * d16) + (d13 * d22) + (d12 * d11);
                            double d24 = biquadFilter2.y1R;
                            double d25 = (d23 - (d18 * d24)) - (biquadFilter2.y2R * d20);
                            biquadFilter2.x2R = d22;
                            biquadFilter2.x1R = d11;
                            biquadFilter2.y2R = d24;
                            biquadFilter2.y1R = d25;
                            d11 = d25;
                            d10 = d21;
                            iRemaining = i7;
                            i4 = i6;
                            d = d14;
                        }
                        i = iRemaining;
                        i2 = i4;
                        double d26 = d;
                        byteBufferReplaceOutputBuffer.putShort((short) UuidKt.coerceIn(d10 * this.preampGain * d26, -32768.0d, 32767.0d));
                        byteBufferReplaceOutputBuffer.putShort((short) UuidKt.coerceIn(d11 * this.preampGain * d26, -32768.0d, 32767.0d));
                    }
                    i4 = i2 + 1;
                    iRemaining = i;
                    i3 = 2;
                }
            }
            byteBufferReplaceOutputBuffer.flip();
        }
    }
}

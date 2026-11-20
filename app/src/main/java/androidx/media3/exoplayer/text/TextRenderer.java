package androidx.media3.exoplayer.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.compose.ui.platform.WeakCache;
import androidx.datastore.core.AtomicInt;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SimpleSubtitleDecoder$1;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.cea.Cea608Decoder;
import androidx.media3.extractor.text.cea.Cea708Decoder;
import androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda35;
import androidx.sqlite.SQLite;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextRenderer extends BaseRenderer implements Handler.Callback {
    public final CueDecoder cueDecoder;
    public final DecoderInputBuffer cueDecoderInputBuffer;
    public CuesResolver cuesResolver;
    public byte decoderReplacementState;
    public long finalStreamEndPositionUs;
    public final WeakCache formatHolder;
    public boolean inputStreamEnded;
    public long lastRendererPositionUs;
    public SimpleSubtitleDecoder$1 nextSubtitle;
    public int nextSubtitleEventIndex;
    public SubtitleInputBuffer nextSubtitleInputBuffer;
    public final ExoPlayerImpl.ComponentListener output;
    public final Handler outputHandler;
    public boolean outputStreamEnded;
    public Format streamFormat;
    public SimpleSubtitleDecoder$1 subtitle;
    public SubtitleDecoder subtitleDecoder;
    public final SubtitleDecoderFactory subtitleDecoderFactory;
    public boolean waitingForKeyFrame;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextRenderer(ExoPlayerImpl.ComponentListener componentListener, Looper looper) {
        Handler handler;
        super(3);
        AtomicInt atomicInt = SubtitleDecoderFactory.DEFAULT;
        this.output = componentListener;
        if (looper == null) {
            handler = null;
        } else {
            String str = Util.DEVICE_DEBUG_INFO;
            handler = new Handler(looper, this);
        }
        this.outputHandler = handler;
        this.subtitleDecoderFactory = atomicInt;
        this.cueDecoder = new CueDecoder((byte) 0);
        this.cueDecoderInputBuffer = new DecoderInputBuffer(1);
        this.formatHolder = new WeakCache((byte) 22, false);
        this.finalStreamEndPositionUs = -9223372036854775807L;
        this.lastRendererPositionUs = -9223372036854775807L;
    }

    public final void assertLegacyDecodingEnabledIfRequired() {
        boolean z = Objects.equals(this.streamFormat.sampleMimeType, "application/cea-608") || Objects.equals(this.streamFormat.sampleMimeType, "application/x-mp4-cea-608") || Objects.equals(this.streamFormat.sampleMimeType, "application/cea-708");
        String str = this.streamFormat.sampleMimeType;
        if (z) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(SQLite.lenientFormat("Legacy decoding is disabled, can't handle %s samples (expected %s).", str, "application/x-media3-cues"));
    }

    public final void clearOutput() {
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        CueGroup cueGroup = new CueGroup(RegularImmutableList.EMPTY, getPresentationTimeUs$1(this.lastRendererPositionUs));
        Handler handler = this.outputHandler;
        if (handler != null) {
            handler.obtainMessage(1, cueGroup).sendToTarget();
        } else {
            invokeUpdateOutputInternal(cueGroup);
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final String getName() {
        return "TextRenderer";
    }

    public final long getNextEventTime() {
        if (this.nextSubtitleEventIndex == -1) {
            return Long.MAX_VALUE;
        }
        this.subtitle.getClass();
        if (this.nextSubtitleEventIndex >= this.subtitle.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.subtitle.getEventTime(this.nextSubtitleEventIndex);
    }

    public final long getPresentationTimeUs$1(long j) {
        UtilsKt.checkState(j != -9223372036854775807L);
        return j - this.streamOffsetUs;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            invokeUpdateOutputInternal((CueGroup) message.obj);
            return true;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m();
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0050  */
    /* JADX WARN: Code duplicated, block: B:24:0x0056  */
    /* JADX WARN: Code duplicated, block: B:27:0x0075  */
    public final void initSubtitleDecoder() {
        SubtitleDecoder delegatingSubtitleDecoder;
        byte b = 1;
        this.waitingForKeyFrame = true;
        Format format = this.streamFormat;
        format.getClass();
        CueDecoder cueDecoder = (CueDecoder) ((AtomicInt) this.subtitleDecoderFactory).delegate;
        String str = format.sampleMimeType;
        int i = format.accessibilityChannel;
        if (str != null) {
            switch (str.hashCode()) {
                case 930165504:
                    b = !str.equals("application/x-mp4-cea-608") ? (byte) -1 : (byte) 0;
                    break;
                case 1566015601:
                    if (!str.equals("application/cea-608")) {
                        b = -1;
                    }
                    break;
                case 1566016562:
                    b = !str.equals("application/cea-708") ? (byte) -1 : (byte) 2;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                case 1:
                    delegatingSubtitleDecoder = new Cea608Decoder(str, i);
                    break;
                case 2:
                    delegatingSubtitleDecoder = new Cea708Decoder(i, format.initializationData);
                    break;
                default:
                    if (cueDecoder.supportsFormat(format)) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m("Attempted to create decoder for unsupported MIME type: ", str));
                        return;
                    }
                    SubtitleParser subtitleParserCreate = cueDecoder.create(format);
                    subtitleParserCreate.getClass().getSimpleName().concat("Decoder");
                    delegatingSubtitleDecoder = new DelegatingSubtitleDecoder(subtitleParserCreate);
                    break;
                    break;
            }
        } else if (cueDecoder.supportsFormat(format)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m("Attempted to create decoder for unsupported MIME type: ", str));
            return;
        } else {
            SubtitleParser subtitleParserCreate2 = cueDecoder.create(format);
            subtitleParserCreate2.getClass().getSimpleName().concat("Decoder");
            delegatingSubtitleDecoder = new DelegatingSubtitleDecoder(subtitleParserCreate2);
        }
        this.subtitleDecoder = delegatingSubtitleDecoder;
        delegatingSubtitleDecoder.setOutputStartTimeUs(this.lastResetPositionUs);
    }

    public final void invokeUpdateOutputInternal(CueGroup cueGroup) {
        RegularImmutableList regularImmutableList = cueGroup.cues;
        ExoPlayerImpl.ComponentListener componentListener = this.output;
        ExoPlayerImpl.this.listeners.sendEvent(27, new MediaSessionStub$$ExternalSyntheticLambda35(regularImmutableList, (byte) 1));
        ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
        exoPlayerImpl.currentCueGroup = cueGroup;
        exoPlayerImpl.listeners.sendEvent(27, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 6, cueGroup));
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final boolean isReady() {
        Format format = this.streamFormat;
        if (format != null) {
            if (Objects.equals(format.sampleMimeType, "application/x-media3-cues")) {
                CuesResolver cuesResolver = this.cuesResolver;
                cuesResolver.getClass();
                if (cuesResolver.getNextCueChangeTimeUs(this.lastRendererPositionUs) == Long.MIN_VALUE) {
                    try {
                        SampleStream sampleStream = this.stream;
                        sampleStream.getClass();
                        sampleStream.maybeThrowError();
                        return true;
                    } catch (IOException unused) {
                        return false;
                    }
                }
            } else {
                if (this.outputStreamEnded) {
                    return false;
                }
                if (this.inputStreamEnded) {
                    SimpleSubtitleDecoder$1 simpleSubtitleDecoder$1 = this.subtitle;
                    long j = this.lastRendererPositionUs;
                    if (simpleSubtitleDecoder$1 == null || simpleSubtitleDecoder$1.getEventTimeCount() <= 0 || simpleSubtitleDecoder$1.getEventTime(simpleSubtitleDecoder$1.getEventTimeCount() - 1) <= j) {
                        SimpleSubtitleDecoder$1 simpleSubtitleDecoder$2 = this.nextSubtitle;
                        long j2 = this.lastRendererPositionUs;
                        if ((simpleSubtitleDecoder$2 == null || simpleSubtitleDecoder$2.getEventTimeCount() <= 0 || simpleSubtitleDecoder$2.getEventTime(simpleSubtitleDecoder$2.getEventTimeCount() - 1) <= j2) && this.nextSubtitleInputBuffer != null) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onDisabled() {
        this.streamFormat = null;
        this.finalStreamEndPositionUs = -9223372036854775807L;
        clearOutput();
        this.lastRendererPositionUs = -9223372036854775807L;
        if (this.subtitleDecoder != null) {
            releaseSubtitleBuffers();
            SubtitleDecoder subtitleDecoder = this.subtitleDecoder;
            subtitleDecoder.getClass();
            subtitleDecoder.release();
            this.subtitleDecoder = null;
            this.decoderReplacementState = (byte) 0;
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onPositionReset(long j, boolean z, boolean z2) {
        this.lastRendererPositionUs = j;
        CuesResolver cuesResolver = this.cuesResolver;
        if (cuesResolver != null) {
            cuesResolver.clear();
        }
        clearOutput();
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.finalStreamEndPositionUs = -9223372036854775807L;
        Format format = this.streamFormat;
        if (format == null || Objects.equals(format.sampleMimeType, "application/x-media3-cues")) {
            return;
        }
        if (this.decoderReplacementState == 0) {
            releaseSubtitleBuffers();
            SubtitleDecoder subtitleDecoder = this.subtitleDecoder;
            subtitleDecoder.getClass();
            subtitleDecoder.flush();
            subtitleDecoder.setOutputStartTimeUs(this.lastResetPositionUs);
            return;
        }
        releaseSubtitleBuffers();
        SubtitleDecoder subtitleDecoder2 = this.subtitleDecoder;
        subtitleDecoder2.getClass();
        subtitleDecoder2.release();
        this.subtitleDecoder = null;
        this.decoderReplacementState = (byte) 0;
        initSubtitleDecoder();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onStreamChanged(Format[] formatArr, long j, long j2, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        Format format = formatArr[0];
        this.streamFormat = format;
        if (Objects.equals(format.sampleMimeType, "application/x-media3-cues")) {
            this.cuesResolver = this.streamFormat.cueReplacementBehavior == 1 ? new MergingCuesResolver() : new Headers.Builder((byte) 1);
            return;
        }
        assertLegacyDecodingEnabledIfRequired();
        if (this.subtitleDecoder != null) {
            this.decoderReplacementState = (byte) 1;
        } else {
            initSubtitleDecoder();
        }
    }

    public final void releaseSubtitleBuffers() {
        this.nextSubtitleInputBuffer = null;
        this.nextSubtitleEventIndex = -1;
        SimpleSubtitleDecoder$1 simpleSubtitleDecoder$1 = this.subtitle;
        if (simpleSubtitleDecoder$1 != null) {
            simpleSubtitleDecoder$1.release();
            this.subtitle = null;
        }
        SimpleSubtitleDecoder$1 simpleSubtitleDecoder$2 = this.nextSubtitle;
        if (simpleSubtitleDecoder$2 != null) {
            simpleSubtitleDecoder$2.release();
            this.nextSubtitle = null;
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void render(long j, long j2) {
        boolean z;
        WeakCache weakCache;
        boolean z2;
        boolean z3;
        long eventTime;
        if (this.streamIsFinal) {
            long j3 = this.finalStreamEndPositionUs;
            if (j3 != -9223372036854775807L && j >= j3) {
                releaseSubtitleBuffers();
                this.outputStreamEnded = true;
            }
        }
        if (this.outputStreamEnded) {
            return;
        }
        Format format = this.streamFormat;
        format.getClass();
        boolean zEquals = Objects.equals(format.sampleMimeType, "application/x-media3-cues");
        Handler handler = this.outputHandler;
        WeakCache weakCache2 = this.formatHolder;
        boolean zAddCues = false;
        zAddCues = false;
        zAddCues = false;
        if (zEquals) {
            this.cuesResolver.getClass();
            if (!this.inputStreamEnded) {
                DecoderInputBuffer decoderInputBuffer = this.cueDecoderInputBuffer;
                if (readSource(weakCache2, decoderInputBuffer, 0) == -4) {
                    if (decoderInputBuffer.getFlag(4)) {
                        this.inputStreamEnded = true;
                    } else {
                        decoderInputBuffer.flip();
                        ByteBuffer byteBuffer = decoderInputBuffer.data;
                        byteBuffer.getClass();
                        long j4 = decoderInputBuffer.timeUs;
                        byte[] bArrArray = byteBuffer.array();
                        int iArrayOffset = byteBuffer.arrayOffset();
                        int iLimit = byteBuffer.limit();
                        this.cueDecoder.getClass();
                        Parcel parcelObtain = Parcel.obtain();
                        parcelObtain.unmarshall(bArrArray, iArrayOffset, iLimit);
                        parcelObtain.setDataPosition(0);
                        Bundle bundle = parcelObtain.readBundle(Bundle.class.getClassLoader());
                        parcelObtain.recycle();
                        ArrayList parcelableArrayList = bundle.getParcelableArrayList("c");
                        parcelableArrayList.getClass();
                        ImmutableList.Builder builder = ImmutableList.builder();
                        for (int i = 0; i < parcelableArrayList.size(); i++) {
                            Bundle bundle2 = (Bundle) parcelableArrayList.get(i);
                            bundle2.getClass();
                            builder.add((Object) Cue.fromBundle(bundle2));
                        }
                        CuesWithTiming cuesWithTiming = new CuesWithTiming(j4, bundle.getLong("d"), builder.build());
                        decoderInputBuffer.clear();
                        zAddCues = this.cuesResolver.addCues(cuesWithTiming, j);
                    }
                }
            }
            long nextCueChangeTimeUs = this.cuesResolver.getNextCueChangeTimeUs(this.lastRendererPositionUs);
            if (nextCueChangeTimeUs == Long.MIN_VALUE && this.inputStreamEnded && !zAddCues) {
                this.outputStreamEnded = true;
            }
            if (nextCueChangeTimeUs != Long.MIN_VALUE && nextCueChangeTimeUs <= j) {
                zAddCues = true;
            }
            if (zAddCues) {
                ImmutableList cuesAtTimeUs = this.cuesResolver.getCuesAtTimeUs(j);
                long previousCueChangeTimeUs = this.cuesResolver.getPreviousCueChangeTimeUs(j);
                CueGroup cueGroup = new CueGroup(cuesAtTimeUs, getPresentationTimeUs$1(previousCueChangeTimeUs));
                if (handler != null) {
                    handler.obtainMessage(1, cueGroup).sendToTarget();
                } else {
                    invokeUpdateOutputInternal(cueGroup);
                }
                this.cuesResolver.discardCuesBeforeTimeUs(previousCueChangeTimeUs);
            }
            this.lastRendererPositionUs = j;
            return;
        }
        assertLegacyDecodingEnabledIfRequired();
        this.lastRendererPositionUs = j;
        if (this.nextSubtitle == null) {
            SubtitleDecoder subtitleDecoder = this.subtitleDecoder;
            subtitleDecoder.getClass();
            subtitleDecoder.setPositionUs(j);
            try {
                SubtitleDecoder subtitleDecoder2 = this.subtitleDecoder;
                subtitleDecoder2.getClass();
                this.nextSubtitle = (SimpleSubtitleDecoder$1) subtitleDecoder2.dequeueOutputBuffer();
            } catch (SubtitleDecoderException e) {
                Log.e("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.streamFormat, e);
                clearOutput();
                releaseSubtitleBuffers();
                SubtitleDecoder subtitleDecoder3 = this.subtitleDecoder;
                subtitleDecoder3.getClass();
                subtitleDecoder3.release();
                this.subtitleDecoder = null;
                this.decoderReplacementState = (byte) 0;
                initSubtitleDecoder();
                return;
            }
        }
        if (this.state != 2) {
            return;
        }
        if (this.subtitle != null) {
            long nextEventTime = getNextEventTime();
            z = false;
            while (nextEventTime <= j) {
                this.nextSubtitleEventIndex++;
                nextEventTime = getNextEventTime();
                z = true;
            }
        } else {
            z = false;
        }
        SimpleSubtitleDecoder$1 simpleSubtitleDecoder$1 = this.nextSubtitle;
        if (simpleSubtitleDecoder$1 == null) {
            weakCache = weakCache2;
            z2 = z;
        } else if (simpleSubtitleDecoder$1.getFlag(4)) {
            if (!z && getNextEventTime() == Long.MAX_VALUE) {
                if (this.decoderReplacementState == 2) {
                    releaseSubtitleBuffers();
                    SubtitleDecoder subtitleDecoder4 = this.subtitleDecoder;
                    subtitleDecoder4.getClass();
                    subtitleDecoder4.release();
                    this.subtitleDecoder = null;
                    this.decoderReplacementState = (byte) 0;
                    initSubtitleDecoder();
                } else {
                    releaseSubtitleBuffers();
                    this.outputStreamEnded = true;
                }
            }
            weakCache = weakCache2;
            z2 = z;
        } else {
            weakCache = weakCache2;
            if (simpleSubtitleDecoder$1.timeUs <= j) {
                SimpleSubtitleDecoder$1 simpleSubtitleDecoder$2 = this.subtitle;
                if (simpleSubtitleDecoder$2 != null) {
                    z2 = z;
                    simpleSubtitleDecoder$2.release();
                }
                z2 = z;
                this.nextSubtitleEventIndex = simpleSubtitleDecoder$1.getNextEventTimeIndex(j);
                this.subtitle = simpleSubtitleDecoder$1;
                this.nextSubtitle = null;
                z2 = true;
            }
        }
        if (z2) {
            this.subtitle.getClass();
            int nextEventTimeIndex = this.subtitle.getNextEventTimeIndex(j);
            if (nextEventTimeIndex == 0 || this.subtitle.getEventTimeCount() == 0) {
                eventTime = this.subtitle.timeUs;
            } else {
                SimpleSubtitleDecoder$1 simpleSubtitleDecoder$3 = this.subtitle;
                eventTime = nextEventTimeIndex == -1 ? simpleSubtitleDecoder$3.getEventTime(simpleSubtitleDecoder$3.getEventTimeCount() - 1) : simpleSubtitleDecoder$3.getEventTime(nextEventTimeIndex - 1);
            }
            CueGroup cueGroup2 = new CueGroup(this.subtitle.getCues(j), getPresentationTimeUs$1(eventTime));
            if (handler != null) {
                handler.obtainMessage(1, cueGroup2).sendToTarget();
            } else {
                invokeUpdateOutputInternal(cueGroup2);
            }
        }
        if (this.decoderReplacementState == 2) {
            return;
        }
        while (!this.inputStreamEnded) {
            try {
                SubtitleInputBuffer subtitleInputBuffer = this.nextSubtitleInputBuffer;
                if (subtitleInputBuffer == null) {
                    SubtitleDecoder subtitleDecoder5 = this.subtitleDecoder;
                    subtitleDecoder5.getClass();
                    subtitleInputBuffer = (SubtitleInputBuffer) subtitleDecoder5.dequeueInputBuffer();
                    if (subtitleInputBuffer == null) {
                        return;
                    } else {
                        this.nextSubtitleInputBuffer = subtitleInputBuffer;
                    }
                }
                if (this.decoderReplacementState == 1) {
                    subtitleInputBuffer.flags = 4;
                    SubtitleDecoder subtitleDecoder6 = this.subtitleDecoder;
                    subtitleDecoder6.getClass();
                    subtitleDecoder6.queueInputBuffer(subtitleInputBuffer);
                    this.nextSubtitleInputBuffer = null;
                    this.decoderReplacementState = (byte) 2;
                    return;
                }
                int source = readSource(weakCache, subtitleInputBuffer, 0);
                if (source == -4) {
                    if (subtitleInputBuffer.getFlag(4)) {
                        this.inputStreamEnded = true;
                        this.waitingForKeyFrame = false;
                        z3 = false;
                    } else {
                        Format format2 = (Format) weakCache.referenceQueue;
                        if (format2 == null) {
                            return;
                        }
                        subtitleInputBuffer.subsampleOffsetUs = format2.subsampleOffsetUs;
                        subtitleInputBuffer.flip();
                        z3 = this.waitingForKeyFrame & (!subtitleInputBuffer.getFlag(1));
                        this.waitingForKeyFrame = z3;
                    }
                    if (!z3) {
                        SubtitleDecoder subtitleDecoder7 = this.subtitleDecoder;
                        subtitleDecoder7.getClass();
                        subtitleDecoder7.queueInputBuffer(subtitleInputBuffer);
                        this.nextSubtitleInputBuffer = null;
                    }
                } else if (source == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e2) {
                Log.e("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.streamFormat, e2);
                clearOutput();
                releaseSubtitleBuffers();
                SubtitleDecoder subtitleDecoder8 = this.subtitleDecoder;
                subtitleDecoder8.getClass();
                subtitleDecoder8.release();
                this.subtitleDecoder = null;
                this.decoderReplacementState = (byte) 0;
                initSubtitleDecoder();
                return;
            }
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final int supportsFormat(Format format) {
        boolean zEquals = Objects.equals(format.sampleMimeType, "application/x-media3-cues");
        String str = format.sampleMimeType;
        if (!zEquals) {
            AtomicInt atomicInt = (AtomicInt) this.subtitleDecoderFactory;
            atomicInt.getClass();
            if (!((CueDecoder) atomicInt.delegate).supportsFormat(format) && !Objects.equals(str, "application/cea-608") && !Objects.equals(str, "application/x-mp4-cea-608") && !Objects.equals(str, "application/cea-708")) {
                return MimeTypes.isText(str) ? BaseRenderer.create(1, 0, 0, 0) : BaseRenderer.create(0, 0, 0, 0);
            }
        }
        return BaseRenderer.create(format.cryptoType == 0 ? 4 : 2, 0, 0, 0);
    }
}

package androidx.media3.exoplayer.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.compose.ui.platform.WeakCache;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.sqlite.SQLite;
import coil3.util.UtilsKt;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {
    public final MetadataInputBuffer buffer;
    public SQLite decoder;
    public final MetadataDecoderFactory$1 decoderFactory;
    public boolean inputStreamEnded;
    public final ExoPlayerImpl.ComponentListener output;
    public final Handler outputHandler;
    public boolean outputStreamEnded;
    public long outputStreamOffsetUs;
    public Metadata pendingMetadata;
    public long subsampleOffsetUs;

    public MetadataRenderer(ExoPlayerImpl.ComponentListener componentListener, Looper looper) {
        Handler handler;
        super(5);
        this.output = componentListener;
        if (looper == null) {
            handler = null;
        } else {
            String str = Util.DEVICE_DEBUG_INFO;
            handler = new Handler(looper, this);
        }
        this.outputHandler = handler;
        this.decoderFactory = MetadataDecoderFactory$1.DEFAULT;
        this.buffer = new MetadataInputBuffer(1);
        this.outputStreamOffsetUs = -9223372036854775807L;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0040  */
    public final void decodeWrappedMetadata(Metadata metadata, ArrayList arrayList) {
        int i = 0;
        while (true) {
            Metadata.Entry[] entryArr = metadata.entries;
            if (i >= entryArr.length) {
                return;
            }
            Format wrappedMetadataFormat = entryArr[i].getWrappedMetadataFormat();
            if (wrappedMetadataFormat != null) {
                MetadataDecoderFactory$1 metadataDecoderFactory$1 = this.decoderFactory;
                if (metadataDecoderFactory$1.supportsFormat(wrappedMetadataFormat)) {
                    SQLite sQLiteCreateDecoder = metadataDecoderFactory$1.createDecoder(wrappedMetadataFormat);
                    byte[] wrappedMetadataBytes = entryArr[i].getWrappedMetadataBytes();
                    wrappedMetadataBytes.getClass();
                    MetadataInputBuffer metadataInputBuffer = this.buffer;
                    metadataInputBuffer.clear();
                    metadataInputBuffer.ensureSpaceForWrite(wrappedMetadataBytes.length);
                    ByteBuffer byteBuffer = metadataInputBuffer.data;
                    String str = Util.DEVICE_DEBUG_INFO;
                    byteBuffer.put(wrappedMetadataBytes);
                    metadataInputBuffer.flip();
                    Metadata metadataDecode = sQLiteCreateDecoder.decode(metadataInputBuffer);
                    if (metadataDecode != null) {
                        decodeWrappedMetadata(metadataDecode, arrayList);
                    }
                } else {
                    arrayList.add(entryArr[i]);
                }
            } else {
                arrayList.add(entryArr[i]);
            }
            i++;
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final String getName() {
        return "MetadataRenderer";
    }

    public final long getPresentationTimeUs(long j) {
        UtilsKt.checkState(j != -9223372036854775807L);
        UtilsKt.checkState(this.outputStreamOffsetUs != -9223372036854775807L);
        return j - this.outputStreamOffsetUs;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            invokeRendererInternal((Metadata) message.obj);
            return true;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m();
        return false;
    }

    public final void invokeRendererInternal(Metadata metadata) {
        ExoPlayerImpl.ComponentListener componentListener = this.output;
        ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
        MediaMetadata mediaMetadata = exoPlayerImpl.staticAndDynamicMediaMetadata;
        ListenerSet listenerSet = exoPlayerImpl.listeners;
        MediaMetadata.Builder builderBuildUpon = mediaMetadata.buildUpon();
        int i = 0;
        while (true) {
            Metadata.Entry[] entryArr = metadata.entries;
            if (i >= entryArr.length) {
                break;
            }
            entryArr[i].populateMediaMetadata(builderBuildUpon);
            i++;
        }
        exoPlayerImpl.staticAndDynamicMediaMetadata = new MediaMetadata(builderBuildUpon);
        MediaMetadata mediaMetadataBuildUpdatedMediaMetadata = exoPlayerImpl.buildUpdatedMediaMetadata();
        if (!mediaMetadataBuildUpdatedMediaMetadata.equals(exoPlayerImpl.mediaMetadata)) {
            exoPlayerImpl.mediaMetadata = mediaMetadataBuildUpdatedMediaMetadata;
            listenerSet.queueEvent(14, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 7, componentListener));
        }
        listenerSet.queueEvent(28, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 8, metadata));
        listenerSet.flushEvents();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onDisabled() {
        this.pendingMetadata = null;
        this.decoder = null;
        this.outputStreamOffsetUs = -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onPositionReset(long j, boolean z, boolean z2) {
        this.pendingMetadata = null;
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onStreamChanged(Format[] formatArr, long j, long j2, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        this.decoder = this.decoderFactory.createDecoder(formatArr[0]);
        Metadata metadata = this.pendingMetadata;
        if (metadata != null) {
            long j3 = metadata.presentationTimeUs;
            long j4 = (this.outputStreamOffsetUs + j3) - j2;
            if (j3 != j4) {
                metadata = new Metadata(j4, metadata.entries);
            }
            this.pendingMetadata = metadata;
        }
        this.outputStreamOffsetUs = j2;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void render(long j, long j2) {
        boolean z = true;
        while (z) {
            if (!this.inputStreamEnded && this.pendingMetadata == null) {
                MetadataInputBuffer metadataInputBuffer = this.buffer;
                metadataInputBuffer.clear();
                WeakCache weakCache = this.formatHolder;
                weakCache.clear();
                int source = readSource(weakCache, metadataInputBuffer, 0);
                if (source == -4) {
                    if (metadataInputBuffer.getFlag(4)) {
                        this.inputStreamEnded = true;
                    } else if (metadataInputBuffer.timeUs >= this.lastResetPositionUs) {
                        metadataInputBuffer.subsampleOffsetUs = this.subsampleOffsetUs;
                        metadataInputBuffer.flip();
                        SQLite sQLite = this.decoder;
                        String str = Util.DEVICE_DEBUG_INFO;
                        Metadata metadataDecode = sQLite.decode(metadataInputBuffer);
                        if (metadataDecode != null) {
                            ArrayList arrayList = new ArrayList(metadataDecode.entries.length);
                            decodeWrappedMetadata(metadataDecode, arrayList);
                            if (!arrayList.isEmpty()) {
                                this.pendingMetadata = new Metadata(getPresentationTimeUs(metadataInputBuffer.timeUs), (Metadata.Entry[]) arrayList.toArray(new Metadata.Entry[0]));
                            }
                        }
                    }
                } else if (source == -5) {
                    Format format = (Format) weakCache.referenceQueue;
                    format.getClass();
                    this.subsampleOffsetUs = format.subsampleOffsetUs;
                }
            }
            Metadata metadata = this.pendingMetadata;
            if (metadata == null || metadata.presentationTimeUs > getPresentationTimeUs(j)) {
                z = false;
            } else {
                Metadata metadata2 = this.pendingMetadata;
                Handler handler = this.outputHandler;
                if (handler != null) {
                    handler.obtainMessage(1, metadata2).sendToTarget();
                } else {
                    invokeRendererInternal(metadata2);
                }
                this.pendingMetadata = null;
                z = true;
            }
            if (this.inputStreamEnded && this.pendingMetadata == null) {
                this.outputStreamEnded = true;
            }
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final int supportsFormat(Format format) {
        if (this.decoderFactory.supportsFormat(format)) {
            return BaseRenderer.create(format.cryptoType == 0 ? 4 : 2, 0, 0, 0);
        }
        return BaseRenderer.create(0, 0, 0, 0);
    }
}

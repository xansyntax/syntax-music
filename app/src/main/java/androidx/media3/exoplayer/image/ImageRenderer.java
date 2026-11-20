package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import android.os.Trace;
import androidx.compose.ui.platform.WeakCache;
import androidx.media3.common.Format;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import androidx.media3.exoplayer.ExoPlayerImplInternal$$ExternalSyntheticLambda4;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.navigation.internal.NavContext;
import coil3.util.UtilsKt;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageRenderer extends BaseRenderer {
    public boolean codecNeedsInitialization;
    public int currentTileIndex;
    public BitmapFactoryImageDecoder decoder;
    public final NavContext decoderFactory;
    public byte decoderReinitializationState;
    public int firstFrameState;
    public final DecoderInputBuffer flagsOnlyBuffer;
    public ExoPlayerImplInternal$$ExternalSyntheticLambda4 imageMetadataListener;
    public DecoderInputBuffer inputBuffer;
    public Format inputFormat;
    public boolean inputStreamEnded;
    public long largestQueuedPresentationTimeUs;
    public long lastProcessedOutputBufferTimeUs;
    public TileInfo nextTileInfo;
    public Bitmap outputBitmap;
    public boolean outputStreamEnded;
    public OutputStreamInfo outputStreamInfo;
    public final ArrayDeque pendingOutputStreamChanges;
    public boolean readyToOutputTiles;
    public TileInfo tileInfo;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class OutputStreamInfo {
        public static final OutputStreamInfo UNSET = new OutputStreamInfo(-9223372036854775807L, -9223372036854775807L);
        public final long previousStreamLastBufferTimeUs;
        public final long streamOffsetUs;

        public OutputStreamInfo(long j, long j2) {
            this.previousStreamLastBufferTimeUs = j;
            this.streamOffsetUs = j2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TileInfo {
        public long presentationTimeUs;
        public Object tileBitmap;
        public int tileIndex;
    }

    public ImageRenderer(NavContext navContext) {
        super(4);
        this.decoderFactory = navContext;
        this.flagsOnlyBuffer = new DecoderInputBuffer(0);
        this.outputStreamInfo = OutputStreamInfo.UNSET;
        this.pendingOutputStreamChanges = new ArrayDeque();
        this.largestQueuedPresentationTimeUs = -9223372036854775807L;
        this.lastProcessedOutputBufferTimeUs = -9223372036854775807L;
        this.decoderReinitializationState = (byte) 0;
        this.firstFrameState = 1;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x008a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x008c  */
    /* JADX WARN: Code duplicated, block: B:47:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00da  */
    /* JADX WARN: Code duplicated, block: B:55:0x00df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00e1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:68:0x0105  */
    /* JADX WARN: Code duplicated, block: B:77:0x013d  */
    /* JADX WARN: Code duplicated, block: B:79:0x0156  */
    public final boolean drainOutput(long j) throws ExoPlaybackException {
        boolean z;
        TileInfo tileInfo;
        boolean z2;
        int i;
        ExoPlayerImplInternal$$ExternalSyntheticLambda4 exoPlayerImplInternal$$ExternalSyntheticLambda4;
        int i2;
        int i3;
        Format format;
        ExoPlayerImplInternal exoPlayerImplInternal;
        Bitmap bitmapCreateBitmap;
        Bitmap bitmap = this.outputBitmap;
        if ((bitmap == null || this.tileInfo != null) && (this.firstFrameState != 0 || this.state == 2)) {
            ArrayDeque arrayDeque = this.pendingOutputStreamChanges;
            if (bitmap == null) {
                this.decoder.getClass();
                BitmapFactoryImageDecoder.AnonymousClass1 anonymousClass1 = (BitmapFactoryImageDecoder.AnonymousClass1) this.decoder.dequeueOutputBuffer();
                if (anonymousClass1 != null) {
                    if (!anonymousClass1.getFlag(4)) {
                        UtilsKt.checkNotNull(anonymousClass1.bitmap, "Non-EOS buffer came back from the decoder without bitmap.");
                        this.outputBitmap = anonymousClass1.bitmap;
                        anonymousClass1.release();
                        if (this.readyToOutputTiles && this.outputBitmap != null && this.tileInfo != null) {
                            this.inputFormat.getClass();
                            Format format2 = this.inputFormat;
                            int i4 = format2.tileCountHorizontal;
                            int i5 = format2.tileCountVertical;
                            z = ((i4 != 1 && i5 == 1) || i4 == -1 || i5 == -1) ? false : true;
                            tileInfo = this.tileInfo;
                            if (((Bitmap) tileInfo.tileBitmap) == null) {
                                if (z) {
                                    int i6 = tileInfo.tileIndex;
                                    this.outputBitmap.getClass();
                                    int width = this.outputBitmap.getWidth();
                                    Format format3 = this.inputFormat;
                                    format3.getClass();
                                    int i7 = width / format3.tileCountHorizontal;
                                    int height = this.outputBitmap.getHeight();
                                    Format format4 = this.inputFormat;
                                    format4.getClass();
                                    int i8 = height / format4.tileCountVertical;
                                    int i9 = this.inputFormat.tileCountHorizontal;
                                    bitmapCreateBitmap = Bitmap.createBitmap(this.outputBitmap, (i6 % i9) * i7, (i6 / i9) * i8, i7, i8);
                                } else {
                                    bitmapCreateBitmap = this.outputBitmap;
                                    bitmapCreateBitmap.getClass();
                                }
                                tileInfo.tileBitmap = bitmapCreateBitmap;
                            }
                            ((Bitmap) this.tileInfo.tileBitmap).getClass();
                            long j2 = this.tileInfo.presentationTimeUs - j;
                            if (this.state == 2) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            i = this.firstFrameState;
                            if (i != 0) {
                                if (i != 1) {
                                    z2 = true;
                                } else {
                                    if (i == 3) {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                        return false;
                                    }
                                    z2 = false;
                                }
                            }
                            if (!z2 || j2 < 30000) {
                                exoPlayerImplInternal$$ExternalSyntheticLambda4 = this.imageMetadataListener;
                                if (exoPlayerImplInternal$$ExternalSyntheticLambda4 != null) {
                                    long j3 = this.outputStreamInfo.streamOffsetUs;
                                    this.inputFormat.getClass();
                                    exoPlayerImplInternal = exoPlayerImplInternal$$ExternalSyntheticLambda4.f$0;
                                    if (exoPlayerImplInternal.seekIsPendingWhileScrubbing) {
                                        exoPlayerImplInternal.handler.obtainMessage(37).sendToTarget();
                                    }
                                }
                                long j4 = this.outputStreamInfo.streamOffsetUs;
                                TileInfo tileInfo2 = this.tileInfo;
                                tileInfo2.getClass();
                                long j5 = tileInfo2.presentationTimeUs;
                                this.lastProcessedOutputBufferTimeUs = j5;
                                while (!arrayDeque.isEmpty() && j5 >= ((OutputStreamInfo) arrayDeque.peek()).previousStreamLastBufferTimeUs) {
                                    this.outputStreamInfo = (OutputStreamInfo) arrayDeque.removeFirst();
                                }
                                this.firstFrameState = 3;
                                if (z) {
                                    TileInfo tileInfo3 = this.tileInfo;
                                    tileInfo3.getClass();
                                    i2 = tileInfo3.tileIndex;
                                    Format format5 = this.inputFormat;
                                    format5.getClass();
                                    i3 = format5.tileCountVertical;
                                    format = this.inputFormat;
                                    format.getClass();
                                    if (i2 == (i3 * format.tileCountHorizontal) - 1) {
                                        this.outputBitmap = null;
                                    }
                                } else {
                                    this.outputBitmap = null;
                                }
                                this.tileInfo = this.nextTileInfo;
                                this.nextTileInfo = null;
                                return true;
                            }
                        }
                    } else {
                        if (this.decoderReinitializationState == 3) {
                            releaseDecoderResources();
                            this.inputFormat.getClass();
                            maybeInitCodec();
                            return false;
                        }
                        anonymousClass1.release();
                        if (arrayDeque.isEmpty()) {
                            this.outputStreamEnded = true;
                            return false;
                        }
                    }
                }
            } else if (this.readyToOutputTiles) {
                this.inputFormat.getClass();
                Format format6 = this.inputFormat;
                int i10 = format6.tileCountHorizontal;
                int i11 = format6.tileCountVertical;
                if (i10 != 1) {
                }
                tileInfo = this.tileInfo;
                if (((Bitmap) tileInfo.tileBitmap) == null) {
                    if (z) {
                        int i12 = tileInfo.tileIndex;
                        this.outputBitmap.getClass();
                        int width2 = this.outputBitmap.getWidth();
                        Format format7 = this.inputFormat;
                        format7.getClass();
                        int i13 = width2 / format7.tileCountHorizontal;
                        int height2 = this.outputBitmap.getHeight();
                        Format format8 = this.inputFormat;
                        format8.getClass();
                        int i14 = height2 / format8.tileCountVertical;
                        int i15 = this.inputFormat.tileCountHorizontal;
                        bitmapCreateBitmap = Bitmap.createBitmap(this.outputBitmap, (i12 % i15) * i13, (i12 / i15) * i14, i13, i14);
                    } else {
                        bitmapCreateBitmap = this.outputBitmap;
                        bitmapCreateBitmap.getClass();
                    }
                    tileInfo.tileBitmap = bitmapCreateBitmap;
                }
                ((Bitmap) this.tileInfo.tileBitmap).getClass();
                long j6 = this.tileInfo.presentationTimeUs - j;
                if (this.state == 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                i = this.firstFrameState;
                if (i != 0) {
                    if (i != 1) {
                        z2 = true;
                    } else {
                        if (i == 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m();
                            return false;
                        }
                        z2 = false;
                    }
                }
                if (!z2) {
                }
                exoPlayerImplInternal$$ExternalSyntheticLambda4 = this.imageMetadataListener;
                if (exoPlayerImplInternal$$ExternalSyntheticLambda4 != null) {
                    long j7 = this.outputStreamInfo.streamOffsetUs;
                    this.inputFormat.getClass();
                    exoPlayerImplInternal = exoPlayerImplInternal$$ExternalSyntheticLambda4.f$0;
                    if (exoPlayerImplInternal.seekIsPendingWhileScrubbing) {
                        exoPlayerImplInternal.handler.obtainMessage(37).sendToTarget();
                    }
                }
                long j8 = this.outputStreamInfo.streamOffsetUs;
                TileInfo tileInfo4 = this.tileInfo;
                tileInfo4.getClass();
                long j9 = tileInfo4.presentationTimeUs;
                this.lastProcessedOutputBufferTimeUs = j9;
                while (!arrayDeque.isEmpty()) {
                    this.outputStreamInfo = (OutputStreamInfo) arrayDeque.removeFirst();
                }
                this.firstFrameState = 3;
                if (z) {
                    TileInfo tileInfo5 = this.tileInfo;
                    tileInfo5.getClass();
                    i2 = tileInfo5.tileIndex;
                    Format format9 = this.inputFormat;
                    format9.getClass();
                    i3 = format9.tileCountVertical;
                    format = this.inputFormat;
                    format.getClass();
                    if (i2 == (i3 * format.tileCountHorizontal) - 1) {
                        this.outputBitmap = null;
                    }
                } else {
                    this.outputBitmap = null;
                }
                this.tileInfo = this.nextTileInfo;
                this.nextTileInfo = null;
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0030 A[PHI: r3
      0x0030: PHI (r3v3 androidx.media3.decoder.DecoderInputBuffer) = (r3v2 androidx.media3.decoder.DecoderInputBuffer), (r3v13 androidx.media3.decoder.DecoderInputBuffer) binds: [B:15:0x0021, B:17:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:21:0x0038  */
    /* JADX WARN: Code duplicated, block: B:23:0x0049  */
    /* JADX WARN: Code duplicated, block: B:25:0x0051  */
    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    /* JADX WARN: Code duplicated, block: B:32:0x005d  */
    /* JADX WARN: Code duplicated, block: B:36:0x006e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0079  */
    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    /* JADX WARN: Code duplicated, block: B:41:0x007e  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:47:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:52:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:60:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:75:0x0100  */
    /* JADX WARN: Code duplicated, block: B:80:0x0108  */
    /* JADX WARN: Code duplicated, block: B:83:0x0119  */
    /* JADX WARN: Code duplicated, block: B:85:0x011e  */
    /* JADX WARN: Code duplicated, block: B:87:0x012f  */
    /* JADX WARN: Code duplicated, block: B:88:0x0132  */
    /* JADX WARN: Code duplicated, block: B:91:0x013e  */
    public final boolean feedInputBuffer(long j) {
        DecoderInputBuffer decoderInputBuffer;
        int source;
        ByteBuffer byteBuffer;
        DecoderInputBuffer decoderInputBuffer2;
        boolean z;
        DecoderInputBuffer decoderInputBuffer3;
        long j2;
        boolean z2;
        TileInfo tileInfo;
        boolean z3;
        Format format;
        boolean z4;
        boolean z5;
        Format format2;
        int i;
        DecoderInputBuffer decoderInputBuffer4;
        if (!this.readyToOutputTiles || this.tileInfo == null) {
            WeakCache weakCache = this.formatHolder;
            weakCache.clear();
            BitmapFactoryImageDecoder bitmapFactoryImageDecoder = this.decoder;
            if (bitmapFactoryImageDecoder != null && this.decoderReinitializationState != 3 && !this.inputStreamEnded) {
                DecoderInputBuffer decoderInputBuffer5 = this.inputBuffer;
                if (decoderInputBuffer5 == null) {
                    decoderInputBuffer5 = (DecoderInputBuffer) bitmapFactoryImageDecoder.dequeueInputBuffer();
                    this.inputBuffer = decoderInputBuffer5;
                    if (decoderInputBuffer5 != null) {
                        decoderInputBuffer = decoderInputBuffer5;
                        if (this.decoderReinitializationState == 2) {
                            decoderInputBuffer.flags = 4;
                            BitmapFactoryImageDecoder bitmapFactoryImageDecoder2 = this.decoder;
                            bitmapFactoryImageDecoder2.getClass();
                            bitmapFactoryImageDecoder2.queueInputBuffer(this.inputBuffer);
                            this.inputBuffer = null;
                            this.decoderReinitializationState = (byte) 3;
                            return false;
                        }
                        source = readSource(weakCache, decoderInputBuffer5, 0);
                        if (source != -5) {
                            Format format3 = (Format) weakCache.referenceQueue;
                            format3.getClass();
                            this.inputFormat = format3;
                            this.codecNeedsInitialization = true;
                            this.decoderReinitializationState = (byte) 2;
                            return true;
                        }
                        if (source != -4) {
                            this.inputBuffer.flip();
                            byteBuffer = this.inputBuffer.data;
                            if (byteBuffer != null || byteBuffer.remaining() <= 0) {
                                decoderInputBuffer2 = this.inputBuffer;
                                decoderInputBuffer2.getClass();
                                if (decoderInputBuffer2.getFlag(4)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            } else {
                                z = true;
                            }
                            if (z) {
                                DecoderInputBuffer decoderInputBuffer6 = this.inputBuffer;
                                decoderInputBuffer6.getClass();
                                decoderInputBuffer6.format = this.inputFormat;
                                BitmapFactoryImageDecoder bitmapFactoryImageDecoder3 = this.decoder;
                                bitmapFactoryImageDecoder3.getClass();
                                DecoderInputBuffer decoderInputBuffer7 = this.inputBuffer;
                                decoderInputBuffer7.getClass();
                                bitmapFactoryImageDecoder3.queueInputBuffer(decoderInputBuffer7);
                                this.currentTileIndex = 0;
                            }
                            decoderInputBuffer3 = this.inputBuffer;
                            decoderInputBuffer3.getClass();
                            if (decoderInputBuffer3.getFlag(4)) {
                                this.readyToOutputTiles = true;
                            } else {
                                int i2 = this.currentTileIndex;
                                j2 = decoderInputBuffer3.timeUs;
                                TileInfo tileInfo2 = new TileInfo();
                                tileInfo2.tileIndex = i2;
                                tileInfo2.presentationTimeUs = j2;
                                this.nextTileInfo = tileInfo2;
                                this.currentTileIndex = i2 + 1;
                                if (this.readyToOutputTiles) {
                                    this.tileInfo = this.nextTileInfo;
                                    this.nextTileInfo = null;
                                } else {
                                    if (j2 - 30000 <= j || j > 30000 + j2) {
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    tileInfo = this.tileInfo;
                                    if (tileInfo != null || tileInfo.presentationTimeUs > j || j >= j2) {
                                        z3 = false;
                                    } else {
                                        z3 = true;
                                    }
                                    format = this.inputFormat;
                                    format.getClass();
                                    if (format.tileCountHorizontal != -1 || (i = (format2 = this.inputFormat).tileCountVertical) == -1 || i2 == (i * format2.tileCountHorizontal) - 1) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if (!z2 || z3 || z4) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    this.readyToOutputTiles = z5;
                                    if (z3 || z2) {
                                        this.tileInfo = this.nextTileInfo;
                                        this.nextTileInfo = null;
                                    }
                                }
                            }
                            decoderInputBuffer4 = this.inputBuffer;
                            decoderInputBuffer4.getClass();
                            if (decoderInputBuffer4.getFlag(4)) {
                                this.inputStreamEnded = true;
                                this.inputBuffer = null;
                                return false;
                            }
                            long j3 = this.largestQueuedPresentationTimeUs;
                            DecoderInputBuffer decoderInputBuffer8 = this.inputBuffer;
                            decoderInputBuffer8.getClass();
                            this.largestQueuedPresentationTimeUs = Math.max(j3, decoderInputBuffer8.timeUs);
                            if (z) {
                                this.inputBuffer = null;
                            } else {
                                DecoderInputBuffer decoderInputBuffer9 = this.inputBuffer;
                                decoderInputBuffer9.getClass();
                                decoderInputBuffer9.clear();
                            }
                            return !this.readyToOutputTiles;
                        }
                        if (source != -3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m();
                            return false;
                        }
                    }
                } else {
                    decoderInputBuffer = decoderInputBuffer5;
                    if (this.decoderReinitializationState == 2) {
                        decoderInputBuffer.flags = 4;
                        BitmapFactoryImageDecoder bitmapFactoryImageDecoder4 = this.decoder;
                        bitmapFactoryImageDecoder4.getClass();
                        bitmapFactoryImageDecoder4.queueInputBuffer(this.inputBuffer);
                        this.inputBuffer = null;
                        this.decoderReinitializationState = (byte) 3;
                        return false;
                    }
                    source = readSource(weakCache, decoderInputBuffer5, 0);
                    if (source != -5) {
                        Format format4 = (Format) weakCache.referenceQueue;
                        format4.getClass();
                        this.inputFormat = format4;
                        this.codecNeedsInitialization = true;
                        this.decoderReinitializationState = (byte) 2;
                        return true;
                    }
                    if (source != -4) {
                        this.inputBuffer.flip();
                        byteBuffer = this.inputBuffer.data;
                        if (byteBuffer != null) {
                            decoderInputBuffer2 = this.inputBuffer;
                            decoderInputBuffer2.getClass();
                            if (decoderInputBuffer2.getFlag(4)) {
                                z = true;
                            } else {
                                z = false;
                            }
                        } else {
                            decoderInputBuffer2 = this.inputBuffer;
                            decoderInputBuffer2.getClass();
                            if (decoderInputBuffer2.getFlag(4)) {
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                        if (z) {
                            DecoderInputBuffer decoderInputBuffer10 = this.inputBuffer;
                            decoderInputBuffer10.getClass();
                            decoderInputBuffer10.format = this.inputFormat;
                            BitmapFactoryImageDecoder bitmapFactoryImageDecoder5 = this.decoder;
                            bitmapFactoryImageDecoder5.getClass();
                            DecoderInputBuffer decoderInputBuffer11 = this.inputBuffer;
                            decoderInputBuffer11.getClass();
                            bitmapFactoryImageDecoder5.queueInputBuffer(decoderInputBuffer11);
                            this.currentTileIndex = 0;
                        }
                        decoderInputBuffer3 = this.inputBuffer;
                        decoderInputBuffer3.getClass();
                        if (decoderInputBuffer3.getFlag(4)) {
                            this.readyToOutputTiles = true;
                        } else {
                            int i3 = this.currentTileIndex;
                            j2 = decoderInputBuffer3.timeUs;
                            TileInfo tileInfo3 = new TileInfo();
                            tileInfo3.tileIndex = i3;
                            tileInfo3.presentationTimeUs = j2;
                            this.nextTileInfo = tileInfo3;
                            this.currentTileIndex = i3 + 1;
                            if (this.readyToOutputTiles) {
                                this.tileInfo = this.nextTileInfo;
                                this.nextTileInfo = null;
                            } else {
                                if (j2 - 30000 <= j) {
                                    z2 = false;
                                } else {
                                    z2 = false;
                                }
                                tileInfo = this.tileInfo;
                                if (tileInfo != null) {
                                    z3 = false;
                                } else {
                                    z3 = false;
                                }
                                format = this.inputFormat;
                                format.getClass();
                                if (format.tileCountHorizontal != -1) {
                                    z4 = true;
                                } else {
                                    z4 = true;
                                }
                                if (z2) {
                                    z5 = true;
                                } else {
                                    z5 = true;
                                }
                                this.readyToOutputTiles = z5;
                                if (z3) {
                                    this.tileInfo = this.nextTileInfo;
                                    this.nextTileInfo = null;
                                } else {
                                    this.tileInfo = this.nextTileInfo;
                                    this.nextTileInfo = null;
                                }
                            }
                        }
                        decoderInputBuffer4 = this.inputBuffer;
                        decoderInputBuffer4.getClass();
                        if (decoderInputBuffer4.getFlag(4)) {
                            this.inputStreamEnded = true;
                            this.inputBuffer = null;
                            return false;
                        }
                        long j4 = this.largestQueuedPresentationTimeUs;
                        DecoderInputBuffer decoderInputBuffer12 = this.inputBuffer;
                        decoderInputBuffer12.getClass();
                        this.largestQueuedPresentationTimeUs = Math.max(j4, decoderInputBuffer12.timeUs);
                        if (z) {
                            this.inputBuffer = null;
                        } else {
                            DecoderInputBuffer decoderInputBuffer13 = this.inputBuffer;
                            decoderInputBuffer13.getClass();
                            decoderInputBuffer13.clear();
                        }
                        return !this.readyToOutputTiles;
                    }
                    if (source != -3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m();
                        return false;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public final void handleMessage(int i, Object obj) {
        if (i == 15 || i != 23) {
            return;
        }
        this.imageMetadataListener = (ExoPlayerImplInternal$$ExternalSyntheticLambda4) obj;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final boolean isReady() {
        int i = this.firstFrameState;
        if (i != 3) {
            return i == 0 && this.readyToOutputTiles;
        }
        return true;
    }

    public final void maybeInitCodec() throws ExoPlaybackException {
        if (this.codecNeedsInitialization) {
            Format format = this.inputFormat;
            format.getClass();
            int iSupportsFormat = NavContext.supportsFormat(format);
            if (iSupportsFormat != BaseRenderer.create(4, 0, 0, 0) && iSupportsFormat != BaseRenderer.create(3, 0, 0, 0)) {
                throw createRendererException(new ImageDecoderException("Provided decoder factory can't create decoder for format."), this.inputFormat, false, 4005);
            }
            BitmapFactoryImageDecoder bitmapFactoryImageDecoder = this.decoder;
            if (bitmapFactoryImageDecoder != null) {
                bitmapFactoryImageDecoder.release();
            }
            this.decoder = new BitmapFactoryImageDecoder(this.decoderFactory.context);
            this.codecNeedsInitialization = false;
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onDisabled() {
        this.inputFormat = null;
        this.outputStreamInfo = OutputStreamInfo.UNSET;
        this.pendingOutputStreamChanges.clear();
        releaseDecoderResources();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onEnabled(boolean z, boolean z2) {
        this.firstFrameState = z2 ? 1 : 0;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onPositionReset(long j, boolean z, boolean z2) {
        this.firstFrameState = Math.min(this.firstFrameState, 1);
        this.outputStreamEnded = false;
        this.inputStreamEnded = false;
        this.outputBitmap = null;
        this.tileInfo = null;
        this.nextTileInfo = null;
        this.readyToOutputTiles = false;
        this.inputBuffer = null;
        BitmapFactoryImageDecoder bitmapFactoryImageDecoder = this.decoder;
        if (bitmapFactoryImageDecoder != null) {
            bitmapFactoryImageDecoder.flush();
        }
        this.pendingOutputStreamChanges.clear();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onRelease() {
        releaseDecoderResources();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onReset() {
        releaseDecoderResources();
        this.firstFrameState = Math.min(this.firstFrameState, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        if (r2 >= r6) goto L15;
     */
    @Override // androidx.media3.exoplayer.BaseRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onStreamChanged(Format[] formatArr, long j, long j2, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        if (this.outputStreamInfo.streamOffsetUs != -9223372036854775807L) {
            ArrayDeque arrayDeque = this.pendingOutputStreamChanges;
            if (arrayDeque.isEmpty()) {
                long j3 = this.largestQueuedPresentationTimeUs;
                if (j3 != -9223372036854775807L) {
                    long j4 = this.lastProcessedOutputBufferTimeUs;
                    if (j4 != -9223372036854775807L) {
                    }
                }
            }
            arrayDeque.add(new OutputStreamInfo(this.largestQueuedPresentationTimeUs, j2));
            return;
        }
        this.outputStreamInfo = new OutputStreamInfo(-9223372036854775807L, j2);
    }

    public final void releaseDecoderResources() {
        this.inputBuffer = null;
        this.decoderReinitializationState = (byte) 0;
        this.largestQueuedPresentationTimeUs = -9223372036854775807L;
        BitmapFactoryImageDecoder bitmapFactoryImageDecoder = this.decoder;
        if (bitmapFactoryImageDecoder != null) {
            bitmapFactoryImageDecoder.release();
            this.decoder = null;
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void render(long j, long j2) throws ExoPlaybackException {
        if (this.outputStreamEnded) {
            return;
        }
        if (this.inputFormat == null) {
            WeakCache weakCache = this.formatHolder;
            weakCache.clear();
            DecoderInputBuffer decoderInputBuffer = this.flagsOnlyBuffer;
            decoderInputBuffer.clear();
            int source = readSource(weakCache, decoderInputBuffer, 2);
            if (source != -5) {
                if (source == -4) {
                    UtilsKt.checkState(decoderInputBuffer.getFlag(4));
                    this.inputStreamEnded = true;
                    this.outputStreamEnded = true;
                    return;
                }
                return;
            }
            Format format = (Format) weakCache.referenceQueue;
            format.getClass();
            this.inputFormat = format;
            this.codecNeedsInitialization = true;
        }
        if (this.decoder == null) {
            maybeInitCodec();
        }
        try {
            Trace.beginSection("drainAndFeedDecoder");
            while (drainOutput(j)) {
            }
            while (feedInputBuffer(j)) {
            }
            Trace.endSection();
        } catch (ImageDecoderException e) {
            throw createRendererException(e, null, false, 4003);
        }
    }
}

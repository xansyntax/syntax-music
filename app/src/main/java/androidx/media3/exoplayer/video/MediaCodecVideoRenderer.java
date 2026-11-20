package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.compose.ui.platform.WeakCache;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.Timeline;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.EGLSurfaceTexture;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.container.ObuParser$NotYetImplementedException;
import androidx.media3.container.ObuParser$Obu;
import androidx.media3.container.ObuParser$SequenceHeader;
import androidx.media3.container.OpusUtil;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.CodecParameters;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import androidx.media3.exoplayer.RendererConfiguration;
import androidx.media3.exoplayer.ScrubbingModeParameters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.mediacodec.LoudnessCodecController;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper.InputVideoSink;
import androidx.media3.extractor.Ac4Util$SyncFrameInfo;
import androidx.media3.extractor.VorbisUtil$Mode;
import androidx.navigation.internal.NavContext;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.materialkolor.quantize.QuantizerWu;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity$$ExternalSyntheticLambda1;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.websocket.ControlFramesKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.internal.EocdRecord;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaCodecVideoRenderer extends MediaCodecRenderer {
    public static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    public static boolean deviceNeedsSetOutputSurfaceWorkaround;
    public static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    public final CallbackWrapper av1SampleDependencyParser;
    public int buffersInCodecCount;
    public int changeFrameRateStrategy;
    public boolean codecHandlesHdr10PlusOutOfBandMetadata;
    public Ac4Util$SyncFrameInfo codecMaxValues;
    public boolean codecNeedsSetOutputSurfaceWorkaround;
    public int consecutiveDroppedFrameCount;
    public int consecutiveDroppedInputBufferCount;
    public final Context context;
    public VideoSize decodedVideoSize;
    public final boolean deviceNeedsNoPostProcessWorkaround;
    public Surface displaySurface;
    public final PriorityQueue droppedDecoderInputBufferTimestamps;
    public long droppedFrameAccumulationStartTimeMs;
    public int droppedFrames;
    public final AudioRendererEventListener$EventDispatcher eventDispatcher;
    public VideoFrameMetadataListener frameMetadataListener;
    public boolean hasSetVideoSink;
    public boolean haveReportedFirstFrameRenderedForCurrentSurface;
    public boolean isFlushRequired;
    public long lastFrameReleaseTimeNs;
    public long lastResetToKeyFramePositionUs;
    public final byte maxDroppedFramesToNotify;
    public final long minEarlyUsToDropDecoderInput;
    public int nextVideoSinkFirstFrameReleaseInstruction;
    public Size outputResolution;
    public final boolean ownsVideoSink;
    public boolean pendingVideoSinkInputStreamChange;
    public long periodDurationUs;
    public PlaceholderSurface placeholderSurface;
    public int rendererPriority;
    public VideoSize reportedVideoSize;
    public int scalingMode;
    public ScrubbingModeParameters scrubbingModeParameters;
    public long startPositionUs;
    public long totalVideoFrameProcessingOffsetUs;
    public boolean tunneling;
    public int tunnelingAudioSessionId;
    public OnFrameRenderedListener tunnelingOnFrameRenderedListener;
    public List videoEffects;
    public int videoFrameProcessingOffsetCount;
    public final VideoFrameReleaseControl videoFrameReleaseControl;
    public final VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster;
    public final EocdRecord videoFrameReleaseInfo;
    public VideoSink videoSink;

    /* JADX INFO: renamed from: androidx.media3.exoplayer.video.MediaCodecVideoRenderer$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 {
        public final /* synthetic */ int val$bufferIndex;
        public final /* synthetic */ MediaCodecAdapter val$codec;

        public AnonymousClass2(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
            this.val$codec = mediaCodecAdapter;
            this.val$bufferIndex = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public short allowedJoiningTimeMs;
        public boolean buildCalled;
        public NavContext codecAdapterFactory;
        public final Context context;
        public Handler eventHandler;
        public ExoPlayerImpl.ComponentListener eventListener;
        public byte maxDroppedFramesToNotify;

        public Builder(Context context) {
            this.context = context;
            this.codecAdapterFactory = new NavContext(context, 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class OnFrameRenderedListener implements Handler.Callback {
        public final Handler handler;

        public OnFrameRenderedListener(MediaCodecAdapter mediaCodecAdapter) {
            Handler handlerCreateHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(this);
            this.handler = handlerCreateHandlerForCurrentLooper;
            mediaCodecAdapter.setOnFrameRenderedListener(this, handlerCreateHandlerForCurrentLooper);
        }

        public final void handleFrameRendered(long j) {
            Surface surface;
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = mediaCodecVideoRenderer.eventDispatcher;
            if (this != mediaCodecVideoRenderer.tunnelingOnFrameRenderedListener || mediaCodecVideoRenderer.codec == null) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                mediaCodecVideoRenderer.pendingOutputEndOfStream = true;
                return;
            }
            try {
                mediaCodecVideoRenderer.updateOutputFormatForTime(j);
                VideoSize videoSize = mediaCodecVideoRenderer.decodedVideoSize;
                if (!videoSize.equals(VideoSize.UNKNOWN) && !videoSize.equals(mediaCodecVideoRenderer.reportedVideoSize)) {
                    mediaCodecVideoRenderer.reportedVideoSize = videoSize;
                    audioRendererEventListener$EventDispatcher.videoSizeChanged(videoSize);
                }
                mediaCodecVideoRenderer.decoderCounters.renderedOutputBufferCount++;
                VideoFrameReleaseControl videoFrameReleaseControl = mediaCodecVideoRenderer.videoFrameReleaseControl;
                boolean z = videoFrameReleaseControl.firstFrameState != 3;
                videoFrameReleaseControl.firstFrameState = 3;
                videoFrameReleaseControl.clock.getClass();
                videoFrameReleaseControl.lastReleaseRealtimeUs = Util.msToUs(SystemClock.elapsedRealtime());
                if (z && (surface = mediaCodecVideoRenderer.displaySurface) != null) {
                    Handler handler = audioRendererEventListener$EventDispatcher.handler;
                    if (handler != null) {
                        handler.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda2(audioRendererEventListener$EventDispatcher, surface, SystemClock.elapsedRealtime()));
                    }
                    mediaCodecVideoRenderer.haveReportedFirstFrameRenderedForCurrentSurface = true;
                }
                mediaCodecVideoRenderer.onProcessedOutputBuffer$1(j);
            } catch (ExoPlaybackException e) {
                mediaCodecVideoRenderer.pendingPlaybackException = e;
            }
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            int i = message.arg1;
            int i2 = message.arg2;
            String str = Util.DEVICE_DEBUG_INFO;
            handleFrameRendered(((((long) i) & 4294967295L) << 32) | (4294967295L & ((long) i2)));
            return true;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MediaCodecVideoRenderer(Builder builder) {
        Context context = builder.context;
        super(context.getApplicationContext(), 2, builder.codecAdapterFactory, 30.0f);
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.maxDroppedFramesToNotify = builder.maxDroppedFramesToNotify;
        this.videoSink = null;
        this.eventDispatcher = new AudioRendererEventListener$EventDispatcher(builder.eventHandler, builder.eventListener, (byte) 1);
        this.ownsVideoSink = this.videoSink == null;
        this.videoFrameReleaseControl = new VideoFrameReleaseControl(applicationContext, this, builder.allowedJoiningTimeMs);
        this.videoFrameReleaseInfo = new EocdRecord();
        this.deviceNeedsNoPostProcessWorkaround = "NVIDIA".equals(Build.MANUFACTURER);
        this.outputResolution = Size.UNKNOWN;
        this.scalingMode = 1;
        this.changeFrameRateStrategy = 0;
        this.decodedVideoSize = VideoSize.UNKNOWN;
        this.tunnelingAudioSessionId = 0;
        this.reportedVideoSize = null;
        this.rendererPriority = -1000;
        this.startPositionUs = -9223372036854775807L;
        this.periodDurationUs = -9223372036854775807L;
        this.av1SampleDependencyParser = new CallbackWrapper((byte) 22);
        this.droppedDecoderInputBufferTimestamps = new PriorityQueue();
        this.minEarlyUsToDropDecoderInput = -15000L;
        this.videoFrameReleaseEarlyTimeForecaster = new VideoFrameReleaseEarlyTimeForecaster();
        this.scrubbingModeParameters = null;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0124  */
    /* JADX WARN: Code duplicated, block: B:102:0x0127  */
    /* JADX WARN: Code duplicated, block: B:105:0x0130  */
    /* JADX WARN: Code duplicated, block: B:106:0x0134  */
    /* JADX WARN: Code duplicated, block: B:109:0x013d  */
    /* JADX WARN: Code duplicated, block: B:110:0x0141  */
    /* JADX WARN: Code duplicated, block: B:113:0x014a  */
    /* JADX WARN: Code duplicated, block: B:114:0x014e  */
    /* JADX WARN: Code duplicated, block: B:117:0x0157  */
    /* JADX WARN: Code duplicated, block: B:118:0x015b  */
    /* JADX WARN: Code duplicated, block: B:121:0x0164  */
    /* JADX WARN: Code duplicated, block: B:122:0x0168  */
    /* JADX WARN: Code duplicated, block: B:125:0x0171  */
    /* JADX WARN: Code duplicated, block: B:126:0x0175  */
    /* JADX WARN: Code duplicated, block: B:129:0x017e  */
    /* JADX WARN: Code duplicated, block: B:130:0x0182  */
    /* JADX WARN: Code duplicated, block: B:133:0x018b  */
    /* JADX WARN: Code duplicated, block: B:134:0x018f  */
    /* JADX WARN: Code duplicated, block: B:137:0x0198  */
    /* JADX WARN: Code duplicated, block: B:138:0x019c  */
    /* JADX WARN: Code duplicated, block: B:141:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:142:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:145:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:146:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:149:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:150:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:153:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:154:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:157:0x01de  */
    /* JADX WARN: Code duplicated, block: B:158:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:161:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:162:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:165:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:166:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:169:0x0209  */
    /* JADX WARN: Code duplicated, block: B:170:0x020d  */
    /* JADX WARN: Code duplicated, block: B:173:0x0217  */
    /* JADX WARN: Code duplicated, block: B:174:0x021b  */
    /* JADX WARN: Code duplicated, block: B:177:0x0225  */
    /* JADX WARN: Code duplicated, block: B:178:0x0229  */
    /* JADX WARN: Code duplicated, block: B:181:0x0233  */
    /* JADX WARN: Code duplicated, block: B:182:0x0237  */
    /* JADX WARN: Code duplicated, block: B:185:0x0241  */
    /* JADX WARN: Code duplicated, block: B:186:0x0245  */
    /* JADX WARN: Code duplicated, block: B:189:0x024f  */
    /* JADX WARN: Code duplicated, block: B:190:0x0253  */
    /* JADX WARN: Code duplicated, block: B:193:0x025d  */
    /* JADX WARN: Code duplicated, block: B:194:0x0261  */
    /* JADX WARN: Code duplicated, block: B:197:0x026b  */
    /* JADX WARN: Code duplicated, block: B:198:0x026f  */
    /* JADX WARN: Code duplicated, block: B:201:0x0279  */
    /* JADX WARN: Code duplicated, block: B:202:0x027d  */
    /* JADX WARN: Code duplicated, block: B:205:0x0287  */
    /* JADX WARN: Code duplicated, block: B:206:0x028b  */
    /* JADX WARN: Code duplicated, block: B:209:0x0295  */
    /* JADX WARN: Code duplicated, block: B:210:0x0299  */
    /* JADX WARN: Code duplicated, block: B:213:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:214:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:217:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:218:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:221:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:222:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:225:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:226:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:229:0x02db  */
    /* JADX WARN: Code duplicated, block: B:230:0x02df  */
    /* JADX WARN: Code duplicated, block: B:233:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:234:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:237:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:238:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:241:0x0305  */
    /* JADX WARN: Code duplicated, block: B:242:0x0309  */
    /* JADX WARN: Code duplicated, block: B:245:0x0313  */
    /* JADX WARN: Code duplicated, block: B:246:0x0317  */
    /* JADX WARN: Code duplicated, block: B:249:0x0321  */
    /* JADX WARN: Code duplicated, block: B:250:0x0325  */
    /* JADX WARN: Code duplicated, block: B:253:0x032f  */
    /* JADX WARN: Code duplicated, block: B:254:0x0333  */
    /* JADX WARN: Code duplicated, block: B:257:0x033d  */
    /* JADX WARN: Code duplicated, block: B:258:0x0341  */
    /* JADX WARN: Code duplicated, block: B:261:0x034b  */
    /* JADX WARN: Code duplicated, block: B:262:0x034f  */
    /* JADX WARN: Code duplicated, block: B:265:0x0359  */
    /* JADX WARN: Code duplicated, block: B:266:0x035d  */
    /* JADX WARN: Code duplicated, block: B:269:0x0367  */
    /* JADX WARN: Code duplicated, block: B:270:0x036b  */
    /* JADX WARN: Code duplicated, block: B:273:0x0375  */
    /* JADX WARN: Code duplicated, block: B:274:0x0379  */
    /* JADX WARN: Code duplicated, block: B:277:0x0383  */
    /* JADX WARN: Code duplicated, block: B:278:0x0387  */
    /* JADX WARN: Code duplicated, block: B:281:0x0391  */
    /* JADX WARN: Code duplicated, block: B:282:0x0395  */
    /* JADX WARN: Code duplicated, block: B:285:0x039f  */
    /* JADX WARN: Code duplicated, block: B:286:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:289:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:290:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:293:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:294:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:297:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:298:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:301:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:302:0x03db  */
    /* JADX WARN: Code duplicated, block: B:305:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:306:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:309:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:310:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:313:0x0401  */
    /* JADX WARN: Code duplicated, block: B:314:0x0405  */
    /* JADX WARN: Code duplicated, block: B:317:0x040f  */
    /* JADX WARN: Code duplicated, block: B:318:0x0413  */
    /* JADX WARN: Code duplicated, block: B:321:0x041d  */
    /* JADX WARN: Code duplicated, block: B:322:0x0421  */
    /* JADX WARN: Code duplicated, block: B:325:0x042b  */
    /* JADX WARN: Code duplicated, block: B:326:0x042f  */
    /* JADX WARN: Code duplicated, block: B:329:0x0439  */
    /* JADX WARN: Code duplicated, block: B:330:0x043d  */
    /* JADX WARN: Code duplicated, block: B:333:0x0447  */
    /* JADX WARN: Code duplicated, block: B:334:0x044b  */
    /* JADX WARN: Code duplicated, block: B:337:0x0455  */
    /* JADX WARN: Code duplicated, block: B:338:0x0459  */
    /* JADX WARN: Code duplicated, block: B:341:0x0463  */
    /* JADX WARN: Code duplicated, block: B:342:0x0467  */
    /* JADX WARN: Code duplicated, block: B:345:0x0471  */
    /* JADX WARN: Code duplicated, block: B:346:0x0475  */
    /* JADX WARN: Code duplicated, block: B:349:0x047f  */
    /* JADX WARN: Code duplicated, block: B:350:0x0483  */
    /* JADX WARN: Code duplicated, block: B:353:0x048d  */
    /* JADX WARN: Code duplicated, block: B:354:0x0491  */
    /* JADX WARN: Code duplicated, block: B:357:0x049b  */
    /* JADX WARN: Code duplicated, block: B:358:0x049f  */
    /* JADX WARN: Code duplicated, block: B:361:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:362:0x04ad  */
    /* JADX WARN: Code duplicated, block: B:365:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:366:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:369:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:370:0x04c9  */
    /* JADX WARN: Code duplicated, block: B:373:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:374:0x04d7  */
    /* JADX WARN: Code duplicated, block: B:377:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:378:0x04e5  */
    /* JADX WARN: Code duplicated, block: B:381:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:382:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:385:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:386:0x0501  */
    /* JADX WARN: Code duplicated, block: B:389:0x050b  */
    /* JADX WARN: Code duplicated, block: B:390:0x050f  */
    /* JADX WARN: Code duplicated, block: B:393:0x0519  */
    /* JADX WARN: Code duplicated, block: B:394:0x051d  */
    /* JADX WARN: Code duplicated, block: B:397:0x0527  */
    /* JADX WARN: Code duplicated, block: B:398:0x052b  */
    /* JADX WARN: Code duplicated, block: B:401:0x0535  */
    /* JADX WARN: Code duplicated, block: B:402:0x0539  */
    /* JADX WARN: Code duplicated, block: B:405:0x0543  */
    /* JADX WARN: Code duplicated, block: B:406:0x0547  */
    /* JADX WARN: Code duplicated, block: B:409:0x0551  */
    /* JADX WARN: Code duplicated, block: B:410:0x0555  */
    /* JADX WARN: Code duplicated, block: B:413:0x055f  */
    /* JADX WARN: Code duplicated, block: B:414:0x0563  */
    /* JADX WARN: Code duplicated, block: B:417:0x056d  */
    /* JADX WARN: Code duplicated, block: B:418:0x0571  */
    /* JADX WARN: Code duplicated, block: B:421:0x057b  */
    /* JADX WARN: Code duplicated, block: B:422:0x057f  */
    /* JADX WARN: Code duplicated, block: B:425:0x0589  */
    /* JADX WARN: Code duplicated, block: B:426:0x058d  */
    /* JADX WARN: Code duplicated, block: B:429:0x0597  */
    /* JADX WARN: Code duplicated, block: B:430:0x059b  */
    /* JADX WARN: Code duplicated, block: B:433:0x05a5  */
    /* JADX WARN: Code duplicated, block: B:434:0x05a9  */
    /* JADX WARN: Code duplicated, block: B:437:0x05b3  */
    /* JADX WARN: Code duplicated, block: B:438:0x05b7  */
    /* JADX WARN: Code duplicated, block: B:441:0x05c1  */
    /* JADX WARN: Code duplicated, block: B:442:0x05c5  */
    /* JADX WARN: Code duplicated, block: B:445:0x05cf  */
    /* JADX WARN: Code duplicated, block: B:446:0x05d3  */
    /* JADX WARN: Code duplicated, block: B:449:0x05dd  */
    /* JADX WARN: Code duplicated, block: B:450:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:453:0x05eb  */
    /* JADX WARN: Code duplicated, block: B:454:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:457:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:458:0x05fd  */
    /* JADX WARN: Code duplicated, block: B:461:0x0607  */
    /* JADX WARN: Code duplicated, block: B:462:0x060b  */
    /* JADX WARN: Code duplicated, block: B:465:0x0615  */
    /* JADX WARN: Code duplicated, block: B:466:0x0619  */
    /* JADX WARN: Code duplicated, block: B:469:0x0623  */
    /* JADX WARN: Code duplicated, block: B:470:0x0627  */
    /* JADX WARN: Code duplicated, block: B:473:0x0631  */
    /* JADX WARN: Code duplicated, block: B:474:0x0635  */
    /* JADX WARN: Code duplicated, block: B:477:0x063f  */
    /* JADX WARN: Code duplicated, block: B:478:0x0643  */
    /* JADX WARN: Code duplicated, block: B:481:0x064d  */
    /* JADX WARN: Code duplicated, block: B:482:0x0651  */
    /* JADX WARN: Code duplicated, block: B:485:0x065b  */
    /* JADX WARN: Code duplicated, block: B:486:0x065f  */
    /* JADX WARN: Code duplicated, block: B:489:0x066a  */
    /* JADX WARN: Code duplicated, block: B:490:0x066e  */
    /* JADX WARN: Code duplicated, block: B:493:0x0678  */
    /* JADX WARN: Code duplicated, block: B:494:0x067c  */
    /* JADX WARN: Code duplicated, block: B:497:0x0686  */
    /* JADX WARN: Code duplicated, block: B:498:0x068a  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:501:0x0694  */
    /* JADX WARN: Code duplicated, block: B:502:0x0698  */
    /* JADX WARN: Code duplicated, block: B:505:0x06a3  */
    /* JADX WARN: Code duplicated, block: B:506:0x06a7  */
    /* JADX WARN: Code duplicated, block: B:509:0x06b1  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:510:0x06b5  */
    /* JADX WARN: Code duplicated, block: B:513:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:514:0x06c3  */
    /* JADX WARN: Code duplicated, block: B:517:0x06cd  */
    /* JADX WARN: Code duplicated, block: B:518:0x06d1  */
    /* JADX WARN: Code duplicated, block: B:521:0x06db  */
    /* JADX WARN: Code duplicated, block: B:522:0x06df  */
    /* JADX WARN: Code duplicated, block: B:525:0x06ea  */
    /* JADX WARN: Code duplicated, block: B:526:0x06ee  */
    /* JADX WARN: Code duplicated, block: B:529:0x06f9  */
    /* JADX WARN: Code duplicated, block: B:530:0x06fd  */
    /* JADX WARN: Code duplicated, block: B:533:0x0707  */
    /* JADX WARN: Code duplicated, block: B:534:0x070b  */
    /* JADX WARN: Code duplicated, block: B:537:0x0715  */
    /* JADX WARN: Code duplicated, block: B:538:0x0719  */
    /* JADX WARN: Code duplicated, block: B:541:0x0723  */
    /* JADX WARN: Code duplicated, block: B:542:0x0727  */
    /* JADX WARN: Code duplicated, block: B:545:0x0732  */
    /* JADX WARN: Code duplicated, block: B:546:0x0736  */
    /* JADX WARN: Code duplicated, block: B:549:0x0740  */
    /* JADX WARN: Code duplicated, block: B:552:0x074a  */
    /* JADX WARN: Code duplicated, block: B:553:0x074d  */
    /* JADX WARN: Code duplicated, block: B:556:0x0757  */
    /* JADX WARN: Code duplicated, block: B:557:0x075a  */
    /* JADX WARN: Code duplicated, block: B:55:0x009d A[Catch: all -> 0x08c5, TRY_LEAVE, TryCatch #0 {all -> 0x08c5, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:664:0x08c0, B:52:0x0092, B:55:0x009d, B:98:0x0118, B:667:0x08c7), top: B:672:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:560:0x0764  */
    /* JADX WARN: Code duplicated, block: B:561:0x0768  */
    /* JADX WARN: Code duplicated, block: B:564:0x0772  */
    /* JADX WARN: Code duplicated, block: B:565:0x0776  */
    /* JADX WARN: Code duplicated, block: B:568:0x0780  */
    /* JADX WARN: Code duplicated, block: B:569:0x0784  */
    /* JADX WARN: Code duplicated, block: B:572:0x078e  */
    /* JADX WARN: Code duplicated, block: B:573:0x0792  */
    /* JADX WARN: Code duplicated, block: B:576:0x079c  */
    /* JADX WARN: Code duplicated, block: B:577:0x07a0  */
    /* JADX WARN: Code duplicated, block: B:580:0x07aa  */
    /* JADX WARN: Code duplicated, block: B:581:0x07ae  */
    /* JADX WARN: Code duplicated, block: B:584:0x07b8  */
    /* JADX WARN: Code duplicated, block: B:585:0x07bc  */
    /* JADX WARN: Code duplicated, block: B:588:0x07c6  */
    /* JADX WARN: Code duplicated, block: B:589:0x07ca  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:592:0x07d4  */
    /* JADX WARN: Code duplicated, block: B:593:0x07d8  */
    /* JADX WARN: Code duplicated, block: B:596:0x07e3  */
    /* JADX WARN: Code duplicated, block: B:597:0x07e7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:600:0x07f1  */
    /* JADX WARN: Code duplicated, block: B:601:0x07f5  */
    /* JADX WARN: Code duplicated, block: B:604:0x07ff  */
    /* JADX WARN: Code duplicated, block: B:605:0x0803  */
    /* JADX WARN: Code duplicated, block: B:608:0x080d  */
    /* JADX WARN: Code duplicated, block: B:609:0x0811  */
    /* JADX WARN: Code duplicated, block: B:612:0x081b  */
    /* JADX WARN: Code duplicated, block: B:613:0x081f  */
    /* JADX WARN: Code duplicated, block: B:616:0x0829  */
    /* JADX WARN: Code duplicated, block: B:617:0x082d  */
    /* JADX WARN: Code duplicated, block: B:620:0x0837  */
    /* JADX WARN: Code duplicated, block: B:621:0x083b  */
    /* JADX WARN: Code duplicated, block: B:624:0x0845  */
    /* JADX WARN: Code duplicated, block: B:625:0x0849  */
    /* JADX WARN: Code duplicated, block: B:628:0x0853  */
    /* JADX WARN: Code duplicated, block: B:629:0x0856  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:632:0x0860  */
    /* JADX WARN: Code duplicated, block: B:633:0x0862  */
    /* JADX WARN: Code duplicated, block: B:636:0x086c  */
    /* JADX WARN: Code duplicated, block: B:637:0x086e  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:640:0x0878  */
    /* JADX WARN: Code duplicated, block: B:641:0x087a  */
    /* JADX WARN: Code duplicated, block: B:644:0x0884  */
    /* JADX WARN: Code duplicated, block: B:645:0x0886  */
    /* JADX WARN: Code duplicated, block: B:648:0x0890  */
    /* JADX WARN: Code duplicated, block: B:649:0x0892  */
    /* JADX WARN: Code duplicated, block: B:652:0x089c  */
    /* JADX WARN: Code duplicated, block: B:653:0x089e  */
    /* JADX WARN: Code duplicated, block: B:656:0x08a8  */
    /* JADX WARN: Code duplicated, block: B:657:0x08aa  */
    /* JADX WARN: Code duplicated, block: B:660:0x08b4  */
    /* JADX WARN: Code duplicated, block: B:662:0x08b8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:682:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:683:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:684:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:685:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:686:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:687:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:688:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:689:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:690:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:691:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:692:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:693:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:694:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:695:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:696:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:697:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:698:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:699:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:700:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:701:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:702:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:703:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:704:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:705:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:706:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:707:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:708:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:709:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:710:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:711:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:712:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:713:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:714:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:715:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:716:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:717:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:718:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:719:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:720:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:721:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:722:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:723:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:724:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:725:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:726:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:727:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:728:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:729:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:730:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:731:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:732:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:733:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:734:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:735:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:736:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:737:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:738:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:739:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:740:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:741:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:742:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:743:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:744:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:745:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:746:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:747:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:748:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:749:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:750:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:751:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:752:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:753:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:754:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:755:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:756:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:757:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:758:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:759:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x00db  */
    /* JADX WARN: Code duplicated, block: B:760:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:761:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:762:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:763:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:764:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:765:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:766:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:767:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:768:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:769:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:770:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:771:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:772:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:773:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:774:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:775:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:776:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:777:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:778:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:779:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:780:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:781:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:782:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:783:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:784:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:785:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:786:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:787:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:788:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:789:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:790:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:791:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:792:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:793:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:794:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:795:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:796:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:797:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:798:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:799:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:800:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:801:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:802:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:803:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:804:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:805:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:806:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:807:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:808:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:809:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:810:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:811:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:812:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:813:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:814:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:815:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:816:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:817:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:818:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:819:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:820:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:821:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:822:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:823:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:824:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:825:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:826:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:827:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:828:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:829:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:830:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:90:0x0105  */
    /* JADX WARN: Code duplicated, block: B:91:0x0107  */
    /* JADX WARN: Code duplicated, block: B:94:0x0110  */
    /* JADX WARN: Code duplicated, block: B:96:0x0114  */
    /* JADX WARN: Code duplicated, block: B:98:0x0118 A[Catch: all -> 0x08c5, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x08c5, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:664:0x08c0, B:52:0x0092, B:55:0x009d, B:98:0x0118, B:667:0x08c7), top: B:672:0x000f }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        String str2;
        byte b;
        String str3;
        byte b2;
        boolean z = false;
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            try {
                if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                    int i = Build.VERSION.SDK_INT;
                    byte b3 = 28;
                    if (i <= 28) {
                        String str4 = Build.DEVICE;
                        str4.getClass();
                        switch (str4.hashCode()) {
                            case -1339091551:
                                b2 = !str4.equals("dangal") ? (byte) -1 : (byte) 0;
                                break;
                            case -1220081023:
                                b2 = !str4.equals("dangalFHD") ? (byte) -1 : (byte) 1;
                                break;
                            case -1220066608:
                                b2 = !str4.equals("dangalUHD") ? (byte) -1 : (byte) 2;
                                break;
                            case -1012436106:
                                b2 = !str4.equals("oneday") ? (byte) -1 : (byte) 3;
                                break;
                            case -760312546:
                                b2 = !str4.equals("aquaman") ? (byte) -1 : (byte) 4;
                                break;
                            case -64886864:
                                b2 = !str4.equals("magnolia") ? (byte) -1 : (byte) 5;
                                break;
                            case 3415681:
                                b2 = !str4.equals("once") ? (byte) -1 : (byte) 6;
                                break;
                            case 825323514:
                                b2 = !str4.equals("machuca") ? (byte) -1 : (byte) 7;
                                break;
                            default:
                                b2 = -1;
                                break;
                        }
                        switch (b2) {
                            default:
                                if (i <= 27 || !"HWEML".equals(Build.DEVICE)) {
                                    str2 = Build.MODEL;
                                    str2.getClass();
                                    switch (str2.hashCode()) {
                                        case -349662828:
                                            if (!str2.equals("AFTJMST12")) {
                                                b = 0;
                                            } else {
                                                b = -1;
                                            }
                                            break;
                                        case -321033677:
                                            if (!str2.equals("AFTKMST12")) {
                                                b = 1;
                                            } else {
                                                b = -1;
                                            }
                                            break;
                                        case 2006354:
                                            if (!str2.equals("AFTA")) {
                                                b = 2;
                                            } else {
                                                b = -1;
                                            }
                                            break;
                                        case 2006367:
                                            if (!str2.equals("AFTN")) {
                                                b = 3;
                                            } else {
                                                b = -1;
                                            }
                                            break;
                                        case 2006371:
                                            if (!str2.equals("AFTR")) {
                                                b = 4;
                                            } else {
                                                b = -1;
                                            }
                                            break;
                                        case 1785421873:
                                            if (!str2.equals("AFTEU011")) {
                                                b = 5;
                                            } else {
                                                b = -1;
                                            }
                                            break;
                                        case 1785421876:
                                            if (!str2.equals("AFTEU014")) {
                                                b = 6;
                                            } else {
                                                b = -1;
                                            }
                                            break;
                                        case 1798172390:
                                            if (!str2.equals("AFTSO001")) {
                                                b = 7;
                                            } else {
                                                b = -1;
                                            }
                                            break;
                                        case 2119412532:
                                            if (!str2.equals("AFTEUFF014")) {
                                                b = 8;
                                            } else {
                                                b = -1;
                                            }
                                            break;
                                        default:
                                            b = -1;
                                            break;
                                    }
                                    switch (b) {
                                        default:
                                            if (i <= 26) {
                                                str3 = Build.DEVICE;
                                                str3.getClass();
                                                switch (str3.hashCode()) {
                                                    case -2144781245:
                                                        if (!str3.equals("GIONEE_SWW1609")) {
                                                            b3 = 0;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -2144781185:
                                                        if (!str3.equals("GIONEE_SWW1627")) {
                                                            b3 = 1;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -2144781160:
                                                        if (!str3.equals("GIONEE_SWW1631")) {
                                                            b3 = 2;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -2097309513:
                                                        if (!str3.equals("K50a40")) {
                                                            b3 = 3;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -2022874474:
                                                        if (!str3.equals("CP8676_I02")) {
                                                            b3 = 4;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1978993182:
                                                        if (!str3.equals("NX541J")) {
                                                            b3 = 5;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1978990237:
                                                        if (!str3.equals("NX573J")) {
                                                            b3 = 6;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1936688988:
                                                        if (!str3.equals("PGN528")) {
                                                            b3 = 7;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1936688066:
                                                        if (!str3.equals("PGN610")) {
                                                            b3 = 8;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1936688065:
                                                        if (!str3.equals("PGN611")) {
                                                            b3 = 9;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1931988508:
                                                        if (!str3.equals("AquaPowerM")) {
                                                            b3 = 10;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1885099851:
                                                        if (!str3.equals("RAIJIN")) {
                                                            b3 = 11;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1696512866:
                                                        if (!str3.equals("XT1663")) {
                                                            b3 = 12;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1680025915:
                                                        if (!str3.equals("ComioS1")) {
                                                            b3 = 13;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1615810839:
                                                        if (!str3.equals("Phantom6")) {
                                                            b3 = 14;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1600724499:
                                                        if (!str3.equals("pacificrim")) {
                                                            b3 = 15;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1554255044:
                                                        if (!str3.equals("vernee_M5")) {
                                                            b3 = 16;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1481772737:
                                                        if (!str3.equals("panell_dl")) {
                                                            b3 = 17;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1481772730:
                                                        if (!str3.equals("panell_ds")) {
                                                            b3 = 18;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1481772729:
                                                        if (!str3.equals("panell_dt")) {
                                                            b3 = 19;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1320080169:
                                                        if (!str3.equals("GiONEE_GBL7319")) {
                                                            b3 = 20;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1217592143:
                                                        if (!str3.equals("BRAVIA_ATV2")) {
                                                            b3 = 21;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1180384755:
                                                        if (!str3.equals("iris60")) {
                                                            b3 = 22;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1139198265:
                                                        if (!str3.equals("Slate_Pro")) {
                                                            b3 = 23;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -1052835013:
                                                        if (!str3.equals("namath")) {
                                                            b3 = 24;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -993250464:
                                                        if (!str3.equals("A10-70F")) {
                                                            b3 = 25;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -993250458:
                                                        if (!str3.equals("A10-70L")) {
                                                            b3 = 26;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -965403638:
                                                        if (!str3.equals("s905x018")) {
                                                            b3 = 27;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -958336948:
                                                        if (!str3.equals("ELUGA_Ray_X")) {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -879245230:
                                                        if (!str3.equals("tcl_eu")) {
                                                            b3 = 29;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -842500323:
                                                        if (!str3.equals("nicklaus_f")) {
                                                            b3 = 30;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -821392978:
                                                        if (!str3.equals("A7000-a")) {
                                                            b3 = 31;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -797483286:
                                                        if (!str3.equals("SVP-DTV15")) {
                                                            b3 = 32;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -794946968:
                                                        if (!str3.equals("watson")) {
                                                            b3 = 33;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -788334647:
                                                        if (!str3.equals("whyred")) {
                                                            b3 = 34;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -782144577:
                                                        if (!str3.equals("OnePlus5T")) {
                                                            b3 = 35;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -575125681:
                                                        if (!str3.equals("GiONEE_CBL7513")) {
                                                            b3 = 36;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -521118391:
                                                        if (!str3.equals("GIONEE_GBL7360")) {
                                                            b3 = 37;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -430914369:
                                                        if (!str3.equals("Pixi4-7_3G")) {
                                                            b3 = 38;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -290434366:
                                                        if (!str3.equals("taido_row")) {
                                                            b3 = 39;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -282781963:
                                                        if (!str3.equals("BLACK-1X")) {
                                                            b3 = 40;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -277133239:
                                                        if (!str3.equals("Z12_PRO")) {
                                                            b3 = 41;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -173639913:
                                                        if (!str3.equals("ELUGA_A3_Pro")) {
                                                            b3 = 42;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case -56598463:
                                                        if (!str3.equals("woods_fn")) {
                                                            b3 = 43;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2126:
                                                        if (!str3.equals("C1")) {
                                                            b3 = 44;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2564:
                                                        if (!str3.equals("Q5")) {
                                                            b3 = 45;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2715:
                                                        if (!str3.equals("V1")) {
                                                            b3 = 46;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2719:
                                                        if (!str3.equals("V5")) {
                                                            b3 = 47;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 3091:
                                                        if (!str3.equals("b5")) {
                                                            b3 = 48;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 3483:
                                                        if (!str3.equals("mh")) {
                                                            b3 = 49;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 73405:
                                                        if (!str3.equals("JGZ")) {
                                                            b3 = 50;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 75537:
                                                        if (!str3.equals("M04")) {
                                                            b3 = 51;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 75739:
                                                        if (!str3.equals("M5c")) {
                                                            b3 = 52;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 76779:
                                                        if (!str3.equals("MX6")) {
                                                            b3 = 53;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 78669:
                                                        if (!str3.equals("P85")) {
                                                            b3 = 54;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 79305:
                                                        if (!str3.equals("PLE")) {
                                                            b3 = 55;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 80618:
                                                        if (!str3.equals("QX1")) {
                                                            b3 = 56;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 88274:
                                                        if (!str3.equals("Z80")) {
                                                            b3 = 57;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 98846:
                                                        if (!str3.equals("cv1")) {
                                                            b3 = 58;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 98848:
                                                        if (!str3.equals("cv3")) {
                                                            b3 = 59;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 99329:
                                                        if (!str3.equals("deb")) {
                                                            b3 = 60;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 101481:
                                                        if (!str3.equals("flo")) {
                                                            b3 = 61;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1513190:
                                                        if (!str3.equals("1601")) {
                                                            b3 = 62;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1514184:
                                                        if (!str3.equals("1713")) {
                                                            b3 = 63;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1514185:
                                                        if (!str3.equals("1714")) {
                                                            b3 = 64;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2133089:
                                                        if (!str3.equals("F01H")) {
                                                            b3 = 65;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2133091:
                                                        if (!str3.equals("F01J")) {
                                                            b3 = 66;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2133120:
                                                        if (!str3.equals("F02H")) {
                                                            b3 = 67;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2133151:
                                                        if (!str3.equals("F03H")) {
                                                            b3 = 68;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2133182:
                                                        if (!str3.equals("F04H")) {
                                                            b3 = 69;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2133184:
                                                        if (!str3.equals("F04J")) {
                                                            b3 = 70;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2436959:
                                                        if (!str3.equals("P681")) {
                                                            b3 = 71;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2463773:
                                                        if (!str3.equals("Q350")) {
                                                            b3 = 72;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2464648:
                                                        if (!str3.equals("Q427")) {
                                                            b3 = 73;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2689555:
                                                        if (!str3.equals("XE2X")) {
                                                            b3 = 74;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 3154429:
                                                        if (!str3.equals("fugu")) {
                                                            b3 = 75;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 3284551:
                                                        if (!str3.equals("kate")) {
                                                            b3 = 76;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 3351335:
                                                        if (!str3.equals("mido")) {
                                                            b3 = 77;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 3386211:
                                                        if (!str3.equals("p212")) {
                                                            b3 = 78;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 41325051:
                                                        if (!str3.equals("MEIZU_M5")) {
                                                            b3 = 79;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 51349633:
                                                        if (!str3.equals("601LV")) {
                                                            b3 = 80;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 51350594:
                                                        if (!str3.equals("602LV")) {
                                                            b3 = 81;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 55178625:
                                                        if (!str3.equals("Aura_Note_2")) {
                                                            b3 = 82;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 61542055:
                                                        if (!str3.equals("A1601")) {
                                                            b3 = 83;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 65355429:
                                                        if (!str3.equals("E5643")) {
                                                            b3 = 84;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 66214468:
                                                        if (!str3.equals("F3111")) {
                                                            b3 = 85;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 66214470:
                                                        if (!str3.equals("F3113")) {
                                                            b3 = 86;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 66214473:
                                                        if (!str3.equals("F3116")) {
                                                            b3 = 87;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 66215429:
                                                        if (!str3.equals("F3211")) {
                                                            b3 = 88;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 66215431:
                                                        if (!str3.equals("F3213")) {
                                                            b3 = 89;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 66215433:
                                                        if (!str3.equals("F3215")) {
                                                            b3 = 90;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 66216390:
                                                        if (!str3.equals("F3311")) {
                                                            b3 = 91;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 76402249:
                                                        if (!str3.equals("PRO7S")) {
                                                            b3 = 92;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 76404105:
                                                        if (!str3.equals("Q4260")) {
                                                            b3 = 93;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 76404911:
                                                        if (!str3.equals("Q4310")) {
                                                            b3 = 94;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 80963634:
                                                        if (!str3.equals("V23GB")) {
                                                            b3 = 95;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 82882791:
                                                        if (!str3.equals("X3_HK")) {
                                                            b3 = 96;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 98715550:
                                                        if (!str3.equals("i9031")) {
                                                            b3 = 97;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 101370885:
                                                        if (!str3.equals("l5460")) {
                                                            b3 = 98;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 102844228:
                                                        if (!str3.equals("le_x6")) {
                                                            b3 = 99;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 165221241:
                                                        if (!str3.equals("A2016a40")) {
                                                            b3 = 100;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 182191441:
                                                        if (!str3.equals("CPY83_I00")) {
                                                            b3 = 101;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 245388979:
                                                        if (!str3.equals("marino_f")) {
                                                            b3 = 102;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 287431619:
                                                        if (!str3.equals("griffin")) {
                                                            b3 = 103;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 307593612:
                                                        if (!str3.equals("A7010a48")) {
                                                            b3 = 104;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 308517133:
                                                        if (!str3.equals("A7020a48")) {
                                                            b3 = 105;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 316215098:
                                                        if (!str3.equals("TB3-730F")) {
                                                            b3 = 106;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 316215116:
                                                        if (!str3.equals("TB3-730X")) {
                                                            b3 = 107;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 316246811:
                                                        if (!str3.equals("TB3-850F")) {
                                                            b3 = 108;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 316246818:
                                                        if (!str3.equals("TB3-850M")) {
                                                            b3 = 109;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 407160593:
                                                        if (!str3.equals("Pixi5-10_4G")) {
                                                            b3 = 110;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 507412548:
                                                        if (!str3.equals("QM16XE_U")) {
                                                            b3 = 111;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 793982701:
                                                        if (!str3.equals("GIONEE_WBL5708")) {
                                                            b3 = 112;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 794038622:
                                                        if (!str3.equals("GIONEE_WBL7365")) {
                                                            b3 = 113;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 794040393:
                                                        if (!str3.equals("GIONEE_WBL7519")) {
                                                            b3 = 114;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 835649806:
                                                        if (!str3.equals("manning")) {
                                                            b3 = 115;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 917340916:
                                                        if (!str3.equals("A7000plus")) {
                                                            b3 = 116;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 958008161:
                                                        if (!str3.equals("j2xlteins")) {
                                                            b3 = 117;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1060579533:
                                                        if (!str3.equals("panell_d")) {
                                                            b3 = 118;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1150207623:
                                                        if (!str3.equals("LS-5017")) {
                                                            b3 = 119;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1176899427:
                                                        if (!str3.equals("itel_S41")) {
                                                            b3 = 120;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1280332038:
                                                        if (!str3.equals("hwALE-H")) {
                                                            b3 = 121;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1306947716:
                                                        if (!str3.equals("EverStar_S")) {
                                                            b3 = 122;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1349174697:
                                                        if (!str3.equals("htc_e56ml_dtul")) {
                                                            b3 = 123;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1522194893:
                                                        if (!str3.equals("woods_f")) {
                                                            b3 = 124;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1691543273:
                                                        if (!str3.equals("CPH1609")) {
                                                            b3 = 125;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1691544261:
                                                        if (!str3.equals("CPH1715")) {
                                                            b3 = 126;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1709443163:
                                                        if (!str3.equals("iball8735_9806")) {
                                                            b3 = 127;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1865889110:
                                                        if (!str3.equals("santoni")) {
                                                            b3 = 128;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1906253259:
                                                        if (!str3.equals("PB2-670M")) {
                                                            b3 = 129;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 1977196784:
                                                        if (!str3.equals("Infinix-X572")) {
                                                            b3 = 130;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2006372676:
                                                        if (!str3.equals("BRAVIA_ATV3_4K")) {
                                                            b3 = 131;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2019281702:
                                                        if (!str3.equals("DM-01K")) {
                                                            b3 = 132;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2029784656:
                                                        if (!str3.equals("HWBLN-H")) {
                                                            b3 = 133;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2030379515:
                                                        if (!str3.equals("HWCAM-H")) {
                                                            b3 = 134;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2033393791:
                                                        if (!str3.equals("ASUS_X00AD_2")) {
                                                            b3 = 135;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2047190025:
                                                        if (!str3.equals("ELUGA_Note")) {
                                                            b3 = 136;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2047252157:
                                                        if (!str3.equals("ELUGA_Prim")) {
                                                            b3 = 137;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2048319463:
                                                        if (!str3.equals("HWVNS-H")) {
                                                            b3 = 138;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    case 2048855701:
                                                        if (!str3.equals("HWWAS-H")) {
                                                            b3 = 139;
                                                        } else {
                                                            b3 = -1;
                                                        }
                                                        break;
                                                    default:
                                                        b3 = -1;
                                                        break;
                                                }
                                                switch (b3) {
                                                    default:
                                                        if (str2.equals("JSN-L21")) {
                                                        }
                                                    case 0:
                                                    case 1:
                                                    case 2:
                                                    case 3:
                                                    case 4:
                                                    case 5:
                                                    case 6:
                                                    case 7:
                                                    case 8:
                                                    case 9:
                                                    case 10:
                                                    case 11:
                                                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                                                    case 13:
                                                    case 14:
                                                    case 15:
                                                    case 16:
                                                    case 17:
                                                    case 18:
                                                    case 19:
                                                    case 20:
                                                    case 21:
                                                    case 22:
                                                    case 23:
                                                    case 24:
                                                    case 25:
                                                    case 26:
                                                    case 27:
                                                    case 28:
                                                    case 29:
                                                    case 30:
                                                    case 31:
                                                    case 32:
                                                    case 33:
                                                    case 34:
                                                    case 35:
                                                    case 36:
                                                    case 37:
                                                    case 38:
                                                    case 39:
                                                    case 40:
                                                    case 41:
                                                    case 42:
                                                    case 43:
                                                    case 44:
                                                    case 45:
                                                    case 46:
                                                    case 47:
                                                    case 48:
                                                    case 49:
                                                    case 50:
                                                    case 51:
                                                    case 52:
                                                    case 53:
                                                    case 54:
                                                    case 55:
                                                    case 56:
                                                    case 57:
                                                    case 58:
                                                    case 59:
                                                    case 60:
                                                    case 61:
                                                    case 62:
                                                    case 63:
                                                    case 64:
                                                    case 65:
                                                    case 66:
                                                    case 67:
                                                    case 68:
                                                    case UCrop.REQUEST_CROP /* 69 */:
                                                    case 70:
                                                    case 71:
                                                    case 72:
                                                    case 73:
                                                    case 74:
                                                    case 75:
                                                    case 76:
                                                    case 77:
                                                    case 78:
                                                    case 79:
                                                    case 80:
                                                    case 81:
                                                    case 82:
                                                    case 83:
                                                    case 84:
                                                    case 85:
                                                    case 86:
                                                    case 87:
                                                    case 88:
                                                    case 89:
                                                    case 90:
                                                    case 91:
                                                    case 92:
                                                    case 93:
                                                    case 94:
                                                    case 95:
                                                    case UCrop.RESULT_ERROR /* 96 */:
                                                    case 97:
                                                    case 98:
                                                    case 99:
                                                    case 100:
                                                    case 101:
                                                    case 102:
                                                    case 103:
                                                    case 104:
                                                    case 105:
                                                    case 106:
                                                    case 107:
                                                    case 108:
                                                    case 109:
                                                    case 110:
                                                    case 111:
                                                    case 112:
                                                    case 113:
                                                    case 114:
                                                    case 115:
                                                    case 116:
                                                    case 117:
                                                    case 118:
                                                    case 119:
                                                    case 120:
                                                    case 121:
                                                    case 122:
                                                    case ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE /* 123 */:
                                                    case 124:
                                                    case ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE /* 125 */:
                                                    case 126:
                                                    case 127:
                                                    case 128:
                                                    case 129:
                                                    case 130:
                                                    case 131:
                                                    case 132:
                                                    case 133:
                                                    case 134:
                                                    case 135:
                                                    case 136:
                                                    case 137:
                                                    case 138:
                                                    case 139:
                                                        z = true;
                                                        break;
                                                }
                                            }
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                        case 7:
                                        case 8:
                                            z = true;
                                            break;
                                    }
                                }
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                z = true;
                                break;
                        }
                    } else if (i <= 27) {
                        str2 = Build.MODEL;
                        str2.getClass();
                        switch (str2.hashCode()) {
                            case -349662828:
                                if (!str2.equals("AFTJMST12")) {
                                    b = 0;
                                } else {
                                    b = -1;
                                }
                                break;
                            case -321033677:
                                if (!str2.equals("AFTKMST12")) {
                                    b = 1;
                                } else {
                                    b = -1;
                                }
                                break;
                            case 2006354:
                                if (!str2.equals("AFTA")) {
                                    b = 2;
                                } else {
                                    b = -1;
                                }
                                break;
                            case 2006367:
                                if (!str2.equals("AFTN")) {
                                    b = 3;
                                } else {
                                    b = -1;
                                }
                                break;
                            case 2006371:
                                if (!str2.equals("AFTR")) {
                                    b = 4;
                                } else {
                                    b = -1;
                                }
                                break;
                            case 1785421873:
                                if (!str2.equals("AFTEU011")) {
                                    b = 5;
                                } else {
                                    b = -1;
                                }
                                break;
                            case 1785421876:
                                if (!str2.equals("AFTEU014")) {
                                    b = 6;
                                } else {
                                    b = -1;
                                }
                                break;
                            case 1798172390:
                                if (!str2.equals("AFTSO001")) {
                                    b = 7;
                                } else {
                                    b = -1;
                                }
                                break;
                            case 2119412532:
                                if (!str2.equals("AFTEUFF014")) {
                                    b = 8;
                                } else {
                                    b = -1;
                                }
                                break;
                            default:
                                b = -1;
                                break;
                        }
                        switch (b) {
                            default:
                                if (i <= 26) {
                                    str3 = Build.DEVICE;
                                    str3.getClass();
                                    switch (str3.hashCode()) {
                                        case -2144781245:
                                            if (!str3.equals("GIONEE_SWW1609")) {
                                                b3 = 0;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -2144781185:
                                            if (!str3.equals("GIONEE_SWW1627")) {
                                                b3 = 1;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -2144781160:
                                            if (!str3.equals("GIONEE_SWW1631")) {
                                                b3 = 2;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -2097309513:
                                            if (!str3.equals("K50a40")) {
                                                b3 = 3;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -2022874474:
                                            if (!str3.equals("CP8676_I02")) {
                                                b3 = 4;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1978993182:
                                            if (!str3.equals("NX541J")) {
                                                b3 = 5;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1978990237:
                                            if (!str3.equals("NX573J")) {
                                                b3 = 6;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1936688988:
                                            if (!str3.equals("PGN528")) {
                                                b3 = 7;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1936688066:
                                            if (!str3.equals("PGN610")) {
                                                b3 = 8;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1936688065:
                                            if (!str3.equals("PGN611")) {
                                                b3 = 9;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1931988508:
                                            if (!str3.equals("AquaPowerM")) {
                                                b3 = 10;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1885099851:
                                            if (!str3.equals("RAIJIN")) {
                                                b3 = 11;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1696512866:
                                            if (!str3.equals("XT1663")) {
                                                b3 = 12;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1680025915:
                                            if (!str3.equals("ComioS1")) {
                                                b3 = 13;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1615810839:
                                            if (!str3.equals("Phantom6")) {
                                                b3 = 14;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1600724499:
                                            if (!str3.equals("pacificrim")) {
                                                b3 = 15;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1554255044:
                                            if (!str3.equals("vernee_M5")) {
                                                b3 = 16;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1481772737:
                                            if (!str3.equals("panell_dl")) {
                                                b3 = 17;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1481772730:
                                            if (!str3.equals("panell_ds")) {
                                                b3 = 18;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1481772729:
                                            if (!str3.equals("panell_dt")) {
                                                b3 = 19;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1320080169:
                                            if (!str3.equals("GiONEE_GBL7319")) {
                                                b3 = 20;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1217592143:
                                            if (!str3.equals("BRAVIA_ATV2")) {
                                                b3 = 21;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1180384755:
                                            if (!str3.equals("iris60")) {
                                                b3 = 22;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1139198265:
                                            if (!str3.equals("Slate_Pro")) {
                                                b3 = 23;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -1052835013:
                                            if (!str3.equals("namath")) {
                                                b3 = 24;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -993250464:
                                            if (!str3.equals("A10-70F")) {
                                                b3 = 25;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -993250458:
                                            if (!str3.equals("A10-70L")) {
                                                b3 = 26;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -965403638:
                                            if (!str3.equals("s905x018")) {
                                                b3 = 27;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -958336948:
                                            if (!str3.equals("ELUGA_Ray_X")) {
                                                b3 = -1;
                                            }
                                            break;
                                        case -879245230:
                                            if (!str3.equals("tcl_eu")) {
                                                b3 = 29;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -842500323:
                                            if (!str3.equals("nicklaus_f")) {
                                                b3 = 30;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -821392978:
                                            if (!str3.equals("A7000-a")) {
                                                b3 = 31;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -797483286:
                                            if (!str3.equals("SVP-DTV15")) {
                                                b3 = 32;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -794946968:
                                            if (!str3.equals("watson")) {
                                                b3 = 33;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -788334647:
                                            if (!str3.equals("whyred")) {
                                                b3 = 34;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -782144577:
                                            if (!str3.equals("OnePlus5T")) {
                                                b3 = 35;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -575125681:
                                            if (!str3.equals("GiONEE_CBL7513")) {
                                                b3 = 36;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -521118391:
                                            if (!str3.equals("GIONEE_GBL7360")) {
                                                b3 = 37;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -430914369:
                                            if (!str3.equals("Pixi4-7_3G")) {
                                                b3 = 38;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -290434366:
                                            if (!str3.equals("taido_row")) {
                                                b3 = 39;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -282781963:
                                            if (!str3.equals("BLACK-1X")) {
                                                b3 = 40;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -277133239:
                                            if (!str3.equals("Z12_PRO")) {
                                                b3 = 41;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -173639913:
                                            if (!str3.equals("ELUGA_A3_Pro")) {
                                                b3 = 42;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case -56598463:
                                            if (!str3.equals("woods_fn")) {
                                                b3 = 43;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2126:
                                            if (!str3.equals("C1")) {
                                                b3 = 44;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2564:
                                            if (!str3.equals("Q5")) {
                                                b3 = 45;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2715:
                                            if (!str3.equals("V1")) {
                                                b3 = 46;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2719:
                                            if (!str3.equals("V5")) {
                                                b3 = 47;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 3091:
                                            if (!str3.equals("b5")) {
                                                b3 = 48;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 3483:
                                            if (!str3.equals("mh")) {
                                                b3 = 49;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 73405:
                                            if (!str3.equals("JGZ")) {
                                                b3 = 50;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 75537:
                                            if (!str3.equals("M04")) {
                                                b3 = 51;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 75739:
                                            if (!str3.equals("M5c")) {
                                                b3 = 52;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 76779:
                                            if (!str3.equals("MX6")) {
                                                b3 = 53;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 78669:
                                            if (!str3.equals("P85")) {
                                                b3 = 54;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 79305:
                                            if (!str3.equals("PLE")) {
                                                b3 = 55;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 80618:
                                            if (!str3.equals("QX1")) {
                                                b3 = 56;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 88274:
                                            if (!str3.equals("Z80")) {
                                                b3 = 57;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 98846:
                                            if (!str3.equals("cv1")) {
                                                b3 = 58;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 98848:
                                            if (!str3.equals("cv3")) {
                                                b3 = 59;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 99329:
                                            if (!str3.equals("deb")) {
                                                b3 = 60;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 101481:
                                            if (!str3.equals("flo")) {
                                                b3 = 61;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1513190:
                                            if (!str3.equals("1601")) {
                                                b3 = 62;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1514184:
                                            if (!str3.equals("1713")) {
                                                b3 = 63;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1514185:
                                            if (!str3.equals("1714")) {
                                                b3 = 64;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2133089:
                                            if (!str3.equals("F01H")) {
                                                b3 = 65;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2133091:
                                            if (!str3.equals("F01J")) {
                                                b3 = 66;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2133120:
                                            if (!str3.equals("F02H")) {
                                                b3 = 67;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2133151:
                                            if (!str3.equals("F03H")) {
                                                b3 = 68;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2133182:
                                            if (!str3.equals("F04H")) {
                                                b3 = 69;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2133184:
                                            if (!str3.equals("F04J")) {
                                                b3 = 70;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2436959:
                                            if (!str3.equals("P681")) {
                                                b3 = 71;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2463773:
                                            if (!str3.equals("Q350")) {
                                                b3 = 72;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2464648:
                                            if (!str3.equals("Q427")) {
                                                b3 = 73;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2689555:
                                            if (!str3.equals("XE2X")) {
                                                b3 = 74;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 3154429:
                                            if (!str3.equals("fugu")) {
                                                b3 = 75;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 3284551:
                                            if (!str3.equals("kate")) {
                                                b3 = 76;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 3351335:
                                            if (!str3.equals("mido")) {
                                                b3 = 77;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 3386211:
                                            if (!str3.equals("p212")) {
                                                b3 = 78;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 41325051:
                                            if (!str3.equals("MEIZU_M5")) {
                                                b3 = 79;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 51349633:
                                            if (!str3.equals("601LV")) {
                                                b3 = 80;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 51350594:
                                            if (!str3.equals("602LV")) {
                                                b3 = 81;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 55178625:
                                            if (!str3.equals("Aura_Note_2")) {
                                                b3 = 82;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 61542055:
                                            if (!str3.equals("A1601")) {
                                                b3 = 83;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 65355429:
                                            if (!str3.equals("E5643")) {
                                                b3 = 84;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 66214468:
                                            if (!str3.equals("F3111")) {
                                                b3 = 85;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 66214470:
                                            if (!str3.equals("F3113")) {
                                                b3 = 86;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 66214473:
                                            if (!str3.equals("F3116")) {
                                                b3 = 87;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 66215429:
                                            if (!str3.equals("F3211")) {
                                                b3 = 88;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 66215431:
                                            if (!str3.equals("F3213")) {
                                                b3 = 89;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 66215433:
                                            if (!str3.equals("F3215")) {
                                                b3 = 90;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 66216390:
                                            if (!str3.equals("F3311")) {
                                                b3 = 91;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 76402249:
                                            if (!str3.equals("PRO7S")) {
                                                b3 = 92;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 76404105:
                                            if (!str3.equals("Q4260")) {
                                                b3 = 93;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 76404911:
                                            if (!str3.equals("Q4310")) {
                                                b3 = 94;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 80963634:
                                            if (!str3.equals("V23GB")) {
                                                b3 = 95;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 82882791:
                                            if (!str3.equals("X3_HK")) {
                                                b3 = 96;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 98715550:
                                            if (!str3.equals("i9031")) {
                                                b3 = 97;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 101370885:
                                            if (!str3.equals("l5460")) {
                                                b3 = 98;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 102844228:
                                            if (!str3.equals("le_x6")) {
                                                b3 = 99;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 165221241:
                                            if (!str3.equals("A2016a40")) {
                                                b3 = 100;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 182191441:
                                            if (!str3.equals("CPY83_I00")) {
                                                b3 = 101;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 245388979:
                                            if (!str3.equals("marino_f")) {
                                                b3 = 102;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 287431619:
                                            if (!str3.equals("griffin")) {
                                                b3 = 103;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 307593612:
                                            if (!str3.equals("A7010a48")) {
                                                b3 = 104;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 308517133:
                                            if (!str3.equals("A7020a48")) {
                                                b3 = 105;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 316215098:
                                            if (!str3.equals("TB3-730F")) {
                                                b3 = 106;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 316215116:
                                            if (!str3.equals("TB3-730X")) {
                                                b3 = 107;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 316246811:
                                            if (!str3.equals("TB3-850F")) {
                                                b3 = 108;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 316246818:
                                            if (!str3.equals("TB3-850M")) {
                                                b3 = 109;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 407160593:
                                            if (!str3.equals("Pixi5-10_4G")) {
                                                b3 = 110;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 507412548:
                                            if (!str3.equals("QM16XE_U")) {
                                                b3 = 111;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 793982701:
                                            if (!str3.equals("GIONEE_WBL5708")) {
                                                b3 = 112;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 794038622:
                                            if (!str3.equals("GIONEE_WBL7365")) {
                                                b3 = 113;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 794040393:
                                            if (!str3.equals("GIONEE_WBL7519")) {
                                                b3 = 114;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 835649806:
                                            if (!str3.equals("manning")) {
                                                b3 = 115;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 917340916:
                                            if (!str3.equals("A7000plus")) {
                                                b3 = 116;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 958008161:
                                            if (!str3.equals("j2xlteins")) {
                                                b3 = 117;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1060579533:
                                            if (!str3.equals("panell_d")) {
                                                b3 = 118;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1150207623:
                                            if (!str3.equals("LS-5017")) {
                                                b3 = 119;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1176899427:
                                            if (!str3.equals("itel_S41")) {
                                                b3 = 120;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1280332038:
                                            if (!str3.equals("hwALE-H")) {
                                                b3 = 121;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1306947716:
                                            if (!str3.equals("EverStar_S")) {
                                                b3 = 122;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1349174697:
                                            if (!str3.equals("htc_e56ml_dtul")) {
                                                b3 = 123;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1522194893:
                                            if (!str3.equals("woods_f")) {
                                                b3 = 124;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1691543273:
                                            if (!str3.equals("CPH1609")) {
                                                b3 = 125;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1691544261:
                                            if (!str3.equals("CPH1715")) {
                                                b3 = 126;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1709443163:
                                            if (!str3.equals("iball8735_9806")) {
                                                b3 = 127;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1865889110:
                                            if (!str3.equals("santoni")) {
                                                b3 = 128;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1906253259:
                                            if (!str3.equals("PB2-670M")) {
                                                b3 = 129;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 1977196784:
                                            if (!str3.equals("Infinix-X572")) {
                                                b3 = 130;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2006372676:
                                            if (!str3.equals("BRAVIA_ATV3_4K")) {
                                                b3 = 131;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2019281702:
                                            if (!str3.equals("DM-01K")) {
                                                b3 = 132;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2029784656:
                                            if (!str3.equals("HWBLN-H")) {
                                                b3 = 133;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2030379515:
                                            if (!str3.equals("HWCAM-H")) {
                                                b3 = 134;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2033393791:
                                            if (!str3.equals("ASUS_X00AD_2")) {
                                                b3 = 135;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2047190025:
                                            if (!str3.equals("ELUGA_Note")) {
                                                b3 = 136;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2047252157:
                                            if (!str3.equals("ELUGA_Prim")) {
                                                b3 = 137;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2048319463:
                                            if (!str3.equals("HWVNS-H")) {
                                                b3 = 138;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        case 2048855701:
                                            if (!str3.equals("HWWAS-H")) {
                                                b3 = 139;
                                            } else {
                                                b3 = -1;
                                            }
                                            break;
                                        default:
                                            b3 = -1;
                                            break;
                                    }
                                    switch (b3) {
                                        default:
                                            if (str2.equals("JSN-L21")) {
                                            }
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                        case 7:
                                        case 8:
                                        case 9:
                                        case 10:
                                        case 11:
                                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                                        case 13:
                                        case 14:
                                        case 15:
                                        case 16:
                                        case 17:
                                        case 18:
                                        case 19:
                                        case 20:
                                        case 21:
                                        case 22:
                                        case 23:
                                        case 24:
                                        case 25:
                                        case 26:
                                        case 27:
                                        case 28:
                                        case 29:
                                        case 30:
                                        case 31:
                                        case 32:
                                        case 33:
                                        case 34:
                                        case 35:
                                        case 36:
                                        case 37:
                                        case 38:
                                        case 39:
                                        case 40:
                                        case 41:
                                        case 42:
                                        case 43:
                                        case 44:
                                        case 45:
                                        case 46:
                                        case 47:
                                        case 48:
                                        case 49:
                                        case 50:
                                        case 51:
                                        case 52:
                                        case 53:
                                        case 54:
                                        case 55:
                                        case 56:
                                        case 57:
                                        case 58:
                                        case 59:
                                        case 60:
                                        case 61:
                                        case 62:
                                        case 63:
                                        case 64:
                                        case 65:
                                        case 66:
                                        case 67:
                                        case 68:
                                        case UCrop.REQUEST_CROP /* 69 */:
                                        case 70:
                                        case 71:
                                        case 72:
                                        case 73:
                                        case 74:
                                        case 75:
                                        case 76:
                                        case 77:
                                        case 78:
                                        case 79:
                                        case 80:
                                        case 81:
                                        case 82:
                                        case 83:
                                        case 84:
                                        case 85:
                                        case 86:
                                        case 87:
                                        case 88:
                                        case 89:
                                        case 90:
                                        case 91:
                                        case 92:
                                        case 93:
                                        case 94:
                                        case 95:
                                        case UCrop.RESULT_ERROR /* 96 */:
                                        case 97:
                                        case 98:
                                        case 99:
                                        case 100:
                                        case 101:
                                        case 102:
                                        case 103:
                                        case 104:
                                        case 105:
                                        case 106:
                                        case 107:
                                        case 108:
                                        case 109:
                                        case 110:
                                        case 111:
                                        case 112:
                                        case 113:
                                        case 114:
                                        case 115:
                                        case 116:
                                        case 117:
                                        case 118:
                                        case 119:
                                        case 120:
                                        case 121:
                                        case 122:
                                        case ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE /* 123 */:
                                        case 124:
                                        case ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE /* 125 */:
                                        case 126:
                                        case 127:
                                        case 128:
                                        case 129:
                                        case 130:
                                        case 131:
                                        case 132:
                                        case 133:
                                        case 134:
                                        case 135:
                                        case 136:
                                        case 137:
                                        case 138:
                                        case 139:
                                            z = true;
                                            break;
                                    }
                                }
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                z = true;
                                break;
                        }
                    } else {
                        str2 = Build.MODEL;
                        str2.getClass();
                        switch (str2.hashCode()) {
                            case -349662828:
                                if (!str2.equals("AFTJMST12")) {
                                    b = -1;
                                } else {
                                    b = 0;
                                }
                                break;
                            case -321033677:
                                if (!str2.equals("AFTKMST12")) {
                                    b = -1;
                                } else {
                                    b = 1;
                                }
                                break;
                            case 2006354:
                                if (!str2.equals("AFTA")) {
                                    b = -1;
                                } else {
                                    b = 2;
                                }
                                break;
                            case 2006367:
                                if (!str2.equals("AFTN")) {
                                    b = -1;
                                } else {
                                    b = 3;
                                }
                                break;
                            case 2006371:
                                if (!str2.equals("AFTR")) {
                                    b = -1;
                                } else {
                                    b = 4;
                                }
                                break;
                            case 1785421873:
                                if (!str2.equals("AFTEU011")) {
                                    b = -1;
                                } else {
                                    b = 5;
                                }
                                break;
                            case 1785421876:
                                if (!str2.equals("AFTEU014")) {
                                    b = -1;
                                } else {
                                    b = 6;
                                }
                                break;
                            case 1798172390:
                                if (!str2.equals("AFTSO001")) {
                                    b = -1;
                                } else {
                                    b = 7;
                                }
                                break;
                            case 2119412532:
                                if (!str2.equals("AFTEUFF014")) {
                                    b = -1;
                                } else {
                                    b = 8;
                                }
                                break;
                            default:
                                b = -1;
                                break;
                        }
                        switch (b) {
                            default:
                                if (i <= 26) {
                                    str3 = Build.DEVICE;
                                    str3.getClass();
                                    switch (str3.hashCode()) {
                                        case -2144781245:
                                            if (!str3.equals("GIONEE_SWW1609")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 0;
                                            }
                                            break;
                                        case -2144781185:
                                            if (!str3.equals("GIONEE_SWW1627")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 1;
                                            }
                                            break;
                                        case -2144781160:
                                            if (!str3.equals("GIONEE_SWW1631")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 2;
                                            }
                                            break;
                                        case -2097309513:
                                            if (!str3.equals("K50a40")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 3;
                                            }
                                            break;
                                        case -2022874474:
                                            if (!str3.equals("CP8676_I02")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 4;
                                            }
                                            break;
                                        case -1978993182:
                                            if (!str3.equals("NX541J")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 5;
                                            }
                                            break;
                                        case -1978990237:
                                            if (!str3.equals("NX573J")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 6;
                                            }
                                            break;
                                        case -1936688988:
                                            if (!str3.equals("PGN528")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 7;
                                            }
                                            break;
                                        case -1936688066:
                                            if (!str3.equals("PGN610")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 8;
                                            }
                                            break;
                                        case -1936688065:
                                            if (!str3.equals("PGN611")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 9;
                                            }
                                            break;
                                        case -1931988508:
                                            if (!str3.equals("AquaPowerM")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 10;
                                            }
                                            break;
                                        case -1885099851:
                                            if (!str3.equals("RAIJIN")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 11;
                                            }
                                            break;
                                        case -1696512866:
                                            if (!str3.equals("XT1663")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 12;
                                            }
                                            break;
                                        case -1680025915:
                                            if (!str3.equals("ComioS1")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 13;
                                            }
                                            break;
                                        case -1615810839:
                                            if (!str3.equals("Phantom6")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 14;
                                            }
                                            break;
                                        case -1600724499:
                                            if (!str3.equals("pacificrim")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 15;
                                            }
                                            break;
                                        case -1554255044:
                                            if (!str3.equals("vernee_M5")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 16;
                                            }
                                            break;
                                        case -1481772737:
                                            if (!str3.equals("panell_dl")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 17;
                                            }
                                            break;
                                        case -1481772730:
                                            if (!str3.equals("panell_ds")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 18;
                                            }
                                            break;
                                        case -1481772729:
                                            if (!str3.equals("panell_dt")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 19;
                                            }
                                            break;
                                        case -1320080169:
                                            if (!str3.equals("GiONEE_GBL7319")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 20;
                                            }
                                            break;
                                        case -1217592143:
                                            if (!str3.equals("BRAVIA_ATV2")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 21;
                                            }
                                            break;
                                        case -1180384755:
                                            if (!str3.equals("iris60")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 22;
                                            }
                                            break;
                                        case -1139198265:
                                            if (!str3.equals("Slate_Pro")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 23;
                                            }
                                            break;
                                        case -1052835013:
                                            if (!str3.equals("namath")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 24;
                                            }
                                            break;
                                        case -993250464:
                                            if (!str3.equals("A10-70F")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 25;
                                            }
                                            break;
                                        case -993250458:
                                            if (!str3.equals("A10-70L")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 26;
                                            }
                                            break;
                                        case -965403638:
                                            if (!str3.equals("s905x018")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 27;
                                            }
                                            break;
                                        case -958336948:
                                            if (!str3.equals("ELUGA_Ray_X")) {
                                                b3 = -1;
                                            }
                                            break;
                                        case -879245230:
                                            if (!str3.equals("tcl_eu")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 29;
                                            }
                                            break;
                                        case -842500323:
                                            if (!str3.equals("nicklaus_f")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 30;
                                            }
                                            break;
                                        case -821392978:
                                            if (!str3.equals("A7000-a")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 31;
                                            }
                                            break;
                                        case -797483286:
                                            if (!str3.equals("SVP-DTV15")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 32;
                                            }
                                            break;
                                        case -794946968:
                                            if (!str3.equals("watson")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 33;
                                            }
                                            break;
                                        case -788334647:
                                            if (!str3.equals("whyred")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 34;
                                            }
                                            break;
                                        case -782144577:
                                            if (!str3.equals("OnePlus5T")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 35;
                                            }
                                            break;
                                        case -575125681:
                                            if (!str3.equals("GiONEE_CBL7513")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 36;
                                            }
                                            break;
                                        case -521118391:
                                            if (!str3.equals("GIONEE_GBL7360")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 37;
                                            }
                                            break;
                                        case -430914369:
                                            if (!str3.equals("Pixi4-7_3G")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 38;
                                            }
                                            break;
                                        case -290434366:
                                            if (!str3.equals("taido_row")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 39;
                                            }
                                            break;
                                        case -282781963:
                                            if (!str3.equals("BLACK-1X")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 40;
                                            }
                                            break;
                                        case -277133239:
                                            if (!str3.equals("Z12_PRO")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 41;
                                            }
                                            break;
                                        case -173639913:
                                            if (!str3.equals("ELUGA_A3_Pro")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 42;
                                            }
                                            break;
                                        case -56598463:
                                            if (!str3.equals("woods_fn")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 43;
                                            }
                                            break;
                                        case 2126:
                                            if (!str3.equals("C1")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 44;
                                            }
                                            break;
                                        case 2564:
                                            if (!str3.equals("Q5")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 45;
                                            }
                                            break;
                                        case 2715:
                                            if (!str3.equals("V1")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 46;
                                            }
                                            break;
                                        case 2719:
                                            if (!str3.equals("V5")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 47;
                                            }
                                            break;
                                        case 3091:
                                            if (!str3.equals("b5")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 48;
                                            }
                                            break;
                                        case 3483:
                                            if (!str3.equals("mh")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 49;
                                            }
                                            break;
                                        case 73405:
                                            if (!str3.equals("JGZ")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 50;
                                            }
                                            break;
                                        case 75537:
                                            if (!str3.equals("M04")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 51;
                                            }
                                            break;
                                        case 75739:
                                            if (!str3.equals("M5c")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 52;
                                            }
                                            break;
                                        case 76779:
                                            if (!str3.equals("MX6")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 53;
                                            }
                                            break;
                                        case 78669:
                                            if (!str3.equals("P85")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 54;
                                            }
                                            break;
                                        case 79305:
                                            if (!str3.equals("PLE")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 55;
                                            }
                                            break;
                                        case 80618:
                                            if (!str3.equals("QX1")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 56;
                                            }
                                            break;
                                        case 88274:
                                            if (!str3.equals("Z80")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 57;
                                            }
                                            break;
                                        case 98846:
                                            if (!str3.equals("cv1")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 58;
                                            }
                                            break;
                                        case 98848:
                                            if (!str3.equals("cv3")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 59;
                                            }
                                            break;
                                        case 99329:
                                            if (!str3.equals("deb")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 60;
                                            }
                                            break;
                                        case 101481:
                                            if (!str3.equals("flo")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 61;
                                            }
                                            break;
                                        case 1513190:
                                            if (!str3.equals("1601")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 62;
                                            }
                                            break;
                                        case 1514184:
                                            if (!str3.equals("1713")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 63;
                                            }
                                            break;
                                        case 1514185:
                                            if (!str3.equals("1714")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 64;
                                            }
                                            break;
                                        case 2133089:
                                            if (!str3.equals("F01H")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 65;
                                            }
                                            break;
                                        case 2133091:
                                            if (!str3.equals("F01J")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 66;
                                            }
                                            break;
                                        case 2133120:
                                            if (!str3.equals("F02H")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 67;
                                            }
                                            break;
                                        case 2133151:
                                            if (!str3.equals("F03H")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 68;
                                            }
                                            break;
                                        case 2133182:
                                            if (!str3.equals("F04H")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 69;
                                            }
                                            break;
                                        case 2133184:
                                            if (!str3.equals("F04J")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 70;
                                            }
                                            break;
                                        case 2436959:
                                            if (!str3.equals("P681")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 71;
                                            }
                                            break;
                                        case 2463773:
                                            if (!str3.equals("Q350")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 72;
                                            }
                                            break;
                                        case 2464648:
                                            if (!str3.equals("Q427")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 73;
                                            }
                                            break;
                                        case 2689555:
                                            if (!str3.equals("XE2X")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 74;
                                            }
                                            break;
                                        case 3154429:
                                            if (!str3.equals("fugu")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 75;
                                            }
                                            break;
                                        case 3284551:
                                            if (!str3.equals("kate")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 76;
                                            }
                                            break;
                                        case 3351335:
                                            if (!str3.equals("mido")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 77;
                                            }
                                            break;
                                        case 3386211:
                                            if (!str3.equals("p212")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 78;
                                            }
                                            break;
                                        case 41325051:
                                            if (!str3.equals("MEIZU_M5")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 79;
                                            }
                                            break;
                                        case 51349633:
                                            if (!str3.equals("601LV")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 80;
                                            }
                                            break;
                                        case 51350594:
                                            if (!str3.equals("602LV")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 81;
                                            }
                                            break;
                                        case 55178625:
                                            if (!str3.equals("Aura_Note_2")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 82;
                                            }
                                            break;
                                        case 61542055:
                                            if (!str3.equals("A1601")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 83;
                                            }
                                            break;
                                        case 65355429:
                                            if (!str3.equals("E5643")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 84;
                                            }
                                            break;
                                        case 66214468:
                                            if (!str3.equals("F3111")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 85;
                                            }
                                            break;
                                        case 66214470:
                                            if (!str3.equals("F3113")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 86;
                                            }
                                            break;
                                        case 66214473:
                                            if (!str3.equals("F3116")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 87;
                                            }
                                            break;
                                        case 66215429:
                                            if (!str3.equals("F3211")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 88;
                                            }
                                            break;
                                        case 66215431:
                                            if (!str3.equals("F3213")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 89;
                                            }
                                            break;
                                        case 66215433:
                                            if (!str3.equals("F3215")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 90;
                                            }
                                            break;
                                        case 66216390:
                                            if (!str3.equals("F3311")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 91;
                                            }
                                            break;
                                        case 76402249:
                                            if (!str3.equals("PRO7S")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 92;
                                            }
                                            break;
                                        case 76404105:
                                            if (!str3.equals("Q4260")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 93;
                                            }
                                            break;
                                        case 76404911:
                                            if (!str3.equals("Q4310")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 94;
                                            }
                                            break;
                                        case 80963634:
                                            if (!str3.equals("V23GB")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 95;
                                            }
                                            break;
                                        case 82882791:
                                            if (!str3.equals("X3_HK")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 96;
                                            }
                                            break;
                                        case 98715550:
                                            if (!str3.equals("i9031")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 97;
                                            }
                                            break;
                                        case 101370885:
                                            if (!str3.equals("l5460")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 98;
                                            }
                                            break;
                                        case 102844228:
                                            if (!str3.equals("le_x6")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 99;
                                            }
                                            break;
                                        case 165221241:
                                            if (!str3.equals("A2016a40")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 100;
                                            }
                                            break;
                                        case 182191441:
                                            if (!str3.equals("CPY83_I00")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 101;
                                            }
                                            break;
                                        case 245388979:
                                            if (!str3.equals("marino_f")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 102;
                                            }
                                            break;
                                        case 287431619:
                                            if (!str3.equals("griffin")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 103;
                                            }
                                            break;
                                        case 307593612:
                                            if (!str3.equals("A7010a48")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 104;
                                            }
                                            break;
                                        case 308517133:
                                            if (!str3.equals("A7020a48")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 105;
                                            }
                                            break;
                                        case 316215098:
                                            if (!str3.equals("TB3-730F")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 106;
                                            }
                                            break;
                                        case 316215116:
                                            if (!str3.equals("TB3-730X")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 107;
                                            }
                                            break;
                                        case 316246811:
                                            if (!str3.equals("TB3-850F")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 108;
                                            }
                                            break;
                                        case 316246818:
                                            if (!str3.equals("TB3-850M")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 109;
                                            }
                                            break;
                                        case 407160593:
                                            if (!str3.equals("Pixi5-10_4G")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 110;
                                            }
                                            break;
                                        case 507412548:
                                            if (!str3.equals("QM16XE_U")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 111;
                                            }
                                            break;
                                        case 793982701:
                                            if (!str3.equals("GIONEE_WBL5708")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 112;
                                            }
                                            break;
                                        case 794038622:
                                            if (!str3.equals("GIONEE_WBL7365")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 113;
                                            }
                                            break;
                                        case 794040393:
                                            if (!str3.equals("GIONEE_WBL7519")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 114;
                                            }
                                            break;
                                        case 835649806:
                                            if (!str3.equals("manning")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 115;
                                            }
                                            break;
                                        case 917340916:
                                            if (!str3.equals("A7000plus")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 116;
                                            }
                                            break;
                                        case 958008161:
                                            if (!str3.equals("j2xlteins")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 117;
                                            }
                                            break;
                                        case 1060579533:
                                            if (!str3.equals("panell_d")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 118;
                                            }
                                            break;
                                        case 1150207623:
                                            if (!str3.equals("LS-5017")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 119;
                                            }
                                            break;
                                        case 1176899427:
                                            if (!str3.equals("itel_S41")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 120;
                                            }
                                            break;
                                        case 1280332038:
                                            if (!str3.equals("hwALE-H")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 121;
                                            }
                                            break;
                                        case 1306947716:
                                            if (!str3.equals("EverStar_S")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 122;
                                            }
                                            break;
                                        case 1349174697:
                                            if (!str3.equals("htc_e56ml_dtul")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 123;
                                            }
                                            break;
                                        case 1522194893:
                                            if (!str3.equals("woods_f")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 124;
                                            }
                                            break;
                                        case 1691543273:
                                            if (!str3.equals("CPH1609")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 125;
                                            }
                                            break;
                                        case 1691544261:
                                            if (!str3.equals("CPH1715")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 126;
                                            }
                                            break;
                                        case 1709443163:
                                            if (!str3.equals("iball8735_9806")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 127;
                                            }
                                            break;
                                        case 1865889110:
                                            if (!str3.equals("santoni")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 128;
                                            }
                                            break;
                                        case 1906253259:
                                            if (!str3.equals("PB2-670M")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 129;
                                            }
                                            break;
                                        case 1977196784:
                                            if (!str3.equals("Infinix-X572")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 130;
                                            }
                                            break;
                                        case 2006372676:
                                            if (!str3.equals("BRAVIA_ATV3_4K")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 131;
                                            }
                                            break;
                                        case 2019281702:
                                            if (!str3.equals("DM-01K")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 132;
                                            }
                                            break;
                                        case 2029784656:
                                            if (!str3.equals("HWBLN-H")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 133;
                                            }
                                            break;
                                        case 2030379515:
                                            if (!str3.equals("HWCAM-H")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 134;
                                            }
                                            break;
                                        case 2033393791:
                                            if (!str3.equals("ASUS_X00AD_2")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 135;
                                            }
                                            break;
                                        case 2047190025:
                                            if (!str3.equals("ELUGA_Note")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 136;
                                            }
                                            break;
                                        case 2047252157:
                                            if (!str3.equals("ELUGA_Prim")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 137;
                                            }
                                            break;
                                        case 2048319463:
                                            if (!str3.equals("HWVNS-H")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 138;
                                            }
                                            break;
                                        case 2048855701:
                                            if (!str3.equals("HWWAS-H")) {
                                                b3 = -1;
                                            } else {
                                                b3 = 139;
                                            }
                                            break;
                                        default:
                                            b3 = -1;
                                            break;
                                    }
                                    switch (b3) {
                                        default:
                                            if (str2.equals("JSN-L21")) {
                                            }
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                        case 7:
                                        case 8:
                                        case 9:
                                        case 10:
                                        case 11:
                                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                                        case 13:
                                        case 14:
                                        case 15:
                                        case 16:
                                        case 17:
                                        case 18:
                                        case 19:
                                        case 20:
                                        case 21:
                                        case 22:
                                        case 23:
                                        case 24:
                                        case 25:
                                        case 26:
                                        case 27:
                                        case 28:
                                        case 29:
                                        case 30:
                                        case 31:
                                        case 32:
                                        case 33:
                                        case 34:
                                        case 35:
                                        case 36:
                                        case 37:
                                        case 38:
                                        case 39:
                                        case 40:
                                        case 41:
                                        case 42:
                                        case 43:
                                        case 44:
                                        case 45:
                                        case 46:
                                        case 47:
                                        case 48:
                                        case 49:
                                        case 50:
                                        case 51:
                                        case 52:
                                        case 53:
                                        case 54:
                                        case 55:
                                        case 56:
                                        case 57:
                                        case 58:
                                        case 59:
                                        case 60:
                                        case 61:
                                        case 62:
                                        case 63:
                                        case 64:
                                        case 65:
                                        case 66:
                                        case 67:
                                        case 68:
                                        case UCrop.REQUEST_CROP /* 69 */:
                                        case 70:
                                        case 71:
                                        case 72:
                                        case 73:
                                        case 74:
                                        case 75:
                                        case 76:
                                        case 77:
                                        case 78:
                                        case 79:
                                        case 80:
                                        case 81:
                                        case 82:
                                        case 83:
                                        case 84:
                                        case 85:
                                        case 86:
                                        case 87:
                                        case 88:
                                        case 89:
                                        case 90:
                                        case 91:
                                        case 92:
                                        case 93:
                                        case 94:
                                        case 95:
                                        case UCrop.RESULT_ERROR /* 96 */:
                                        case 97:
                                        case 98:
                                        case 99:
                                        case 100:
                                        case 101:
                                        case 102:
                                        case 103:
                                        case 104:
                                        case 105:
                                        case 106:
                                        case 107:
                                        case 108:
                                        case 109:
                                        case 110:
                                        case 111:
                                        case 112:
                                        case 113:
                                        case 114:
                                        case 115:
                                        case 116:
                                        case 117:
                                        case 118:
                                        case 119:
                                        case 120:
                                        case 121:
                                        case 122:
                                        case ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE /* 123 */:
                                        case 124:
                                        case ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE /* 125 */:
                                        case 126:
                                        case 127:
                                        case 128:
                                        case 129:
                                        case 130:
                                        case 131:
                                        case 132:
                                        case 133:
                                        case 134:
                                        case 135:
                                        case 136:
                                        case 137:
                                        case 138:
                                        case 139:
                                            z = true;
                                            break;
                                    }
                                }
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                z = true;
                                break;
                        }
                    }
                    deviceNeedsSetOutputSurfaceWorkaround = z;
                    evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0043  */
    public static int getCodecMaxInputSize$1(MediaCodecInfo mediaCodecInfo, Format format) {
        int i = format.width;
        int i2 = format.height;
        if (i != -1 && i2 != -1) {
            String str = format.sampleMimeType;
            str.getClass();
            if ("video/dolby-vision".equals(str)) {
                Pair codecProfileAndLevel = CodecSpecificDataUtil.getCodecProfileAndLevel(format);
                if (codecProfileAndLevel == null) {
                    str = "video/hevc";
                } else {
                    int iIntValue = ((Integer) codecProfileAndLevel.first).intValue();
                    if (iIntValue == 512 || iIntValue == 1 || iIntValue == 2) {
                        str = "video/avc";
                    } else if (iIntValue == 1024) {
                        str = "video/av01";
                    } else {
                        str = "video/hevc";
                    }
                }
            }
            switch (str) {
                case "video/3gpp":
                case "video/av01":
                case "video/mp4v-es":
                case "video/x-vnd.on2.vp8":
                    return ((i * i2) * 3) / 4;
                case "video/hevc":
                    return Math.max(2097152, ((i * i2) * 3) / 4);
                case "video/avc":
                    String str2 = Build.MODEL;
                    if (!"BRAVIA 4K 2015".equals(str2) && (!"Amazon".equals(Build.MANUFACTURER) || (!"KFSOWI".equals(str2) && (!"AFTS".equals(str2) || !mediaCodecInfo.secure)))) {
                        return ((Util.ceilDivide(i2, 16) * Util.ceilDivide(i, 16)) * 768) / 4;
                    }
                    break;
                case "video/x-vnd.on2.vp9":
                    return ((i * i2) * 3) / 8;
            }
        }
        return -1;
    }

    public static List getDecoderInfos(Context context, Format format, boolean z, boolean z2) {
        List decoderInfos;
        String str = format.sampleMimeType;
        if (str == null) {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            return RegularImmutableList.EMPTY;
        }
        if ("video/dolby-vision".equals(str) && !LifecyclesKt.doesDisplaySupportDolbyVision(context)) {
            String alternativeCodecMimeType = MediaCodecUtil.getAlternativeCodecMimeType(format);
            if (alternativeCodecMimeType == null) {
                ImmutableList.Itr itr2 = ImmutableList.EMPTY_ITR;
                decoderInfos = RegularImmutableList.EMPTY;
            } else {
                decoderInfos = MediaCodecUtil.getDecoderInfos(alternativeCodecMimeType, z, z2);
            }
            if (!decoderInfos.isEmpty()) {
                return decoderInfos;
            }
        }
        return MediaCodecUtil.getDecoderInfosSoftMatch(format, z, z2);
    }

    public static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        int i = format.maxInputSize;
        List list = format.initializationData;
        if (i == -1) {
            return getCodecMaxInputSize$1(mediaCodecInfo, format);
        }
        int size = list.size();
        int length = 0;
        for (int i2 = 0; i2 < size; i2++) {
            length += ((byte[]) list.get(i2)).length;
        }
        return format.maxInputSize + length;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2, boolean z) {
        int i;
        DecoderReuseEvaluation decoderReuseEvaluationCanReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        float f = format.frameRate;
        float f2 = format2.frameRate;
        int i2 = decoderReuseEvaluationCanReuseCodec.discardReasons;
        Ac4Util$SyncFrameInfo ac4Util$SyncFrameInfo = this.codecMaxValues;
        ac4Util$SyncFrameInfo.getClass();
        if (format2.width > ac4Util$SyncFrameInfo.sampleRate || format2.height > ac4Util$SyncFrameInfo.frameSize) {
            i2 |= 256;
        }
        if (getMaxInputSize(mediaCodecInfo, format2) > ac4Util$SyncFrameInfo.sampleCount) {
            i2 |= 64;
        }
        if (this.changeFrameRateStrategy != Integer.MIN_VALUE && (i = Build.VERSION.SDK_INT) < 31 && ((i != 30 || Build.MODEL.startsWith("MiTV")) && f != -1.0f && f2 != -1.0f && (!mediaCodecInfo.secure || !z))) {
            float fMax = Math.max(f2, f) / Math.min(f2, f);
            if (Math.abs(fMax - Math.round(fMax)) > 0.01f) {
                i2 |= 65536;
            }
        }
        int i3 = i2;
        return new DecoderReuseEvaluation(mediaCodecInfo.name, format, format2, i3 != 0 ? 0 : decoderReuseEvaluationCanReuseCodec.result, i3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final MediaCodecDecoderException createDecoderException(IllegalStateException illegalStateException, MediaCodecInfo mediaCodecInfo) {
        Surface surface = this.displaySurface;
        MediaCodecVideoDecoderException mediaCodecVideoDecoderException = new MediaCodecVideoDecoderException(illegalStateException, mediaCodecInfo);
        System.identityHashCode(surface);
        if (surface != null) {
            surface.isValid();
        }
        return mediaCodecVideoDecoderException;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void enableMayRenderStartOfStream() {
        VideoSink videoSink = this.videoSink;
        if (videoSink == null) {
            VideoFrameReleaseControl videoFrameReleaseControl = this.videoFrameReleaseControl;
            if (videoFrameReleaseControl.firstFrameState == 0) {
                videoFrameReleaseControl.firstFrameState = 1;
                return;
            }
            return;
        }
        int i = this.nextVideoSinkFirstFrameReleaseInstruction;
        if (i == 0 || i == 1) {
            this.nextVideoSinkFirstFrameReleaseInstruction = 0;
        } else {
            videoSink.allowReleaseFirstFrameBeforeStarted();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final int getCodecBufferFlags(DecoderInputBuffer decoderInputBuffer) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ((this.scrubbingModeParameters == null && !this.tunneling) || decoderInputBuffer.timeUs >= this.lastResetPositionUs || isBufferProbablyLastSample(decoderInputBuffer)) ? 0 : 32;
        }
        return 0;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        MediaCodecInfo mediaCodecInfo;
        float fMax = -1.0f;
        for (Format format2 : formatArr) {
            float f2 = format2.frameRate;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        float f3 = fMax == -1.0f ? -1.0f : fMax * f;
        if (this.scrubbingModeParameters == null || (mediaCodecInfo = this.codecInfo) == null) {
            return f3;
        }
        int i = format.width;
        int i2 = format.height;
        float f4 = -3.4028235E38f;
        if (mediaCodecInfo.isVideo) {
            float f5 = mediaCodecInfo.maxFrameRate;
            if (f5 != -3.4028235E38f && mediaCodecInfo.maxFrameRateWidth == i && mediaCodecInfo.maxFrameRateHeight == i2) {
                f4 = f5;
            } else {
                f4 = 1024.0f;
                if (!mediaCodecInfo.isVideoSizeAndRateSupportedV21(1024.0d, i, i2)) {
                    float f6 = CropImageView.DEFAULT_ASPECT_RATIO;
                    while (true) {
                        float f7 = f4 - f6;
                        if (Math.abs(f7) <= 5.0f) {
                            break;
                        }
                        float f8 = (f7 / 2.0f) + f6;
                        if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(f8, i, i2)) {
                            f6 = f8;
                        } else {
                            f4 = f8;
                        }
                    }
                    f4 = f6;
                }
                mediaCodecInfo.maxFrameRate = f4;
                mediaCodecInfo.maxFrameRateWidth = i;
                mediaCodecInfo.maxFrameRateHeight = i2;
            }
        }
        return f3 != -1.0f ? Math.max(f3, f4) : f4;
    }

    /* JADX WARN: Code duplicated, block: B:66:0x0139  */
    /* JADX WARN: Instruction removed from duplicated block: B:66:0x0139, please report this as an issue */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final QuantizerWu getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f) {
        ColorInfo colorInfo;
        int i;
        Ac4Util$SyncFrameInfo ac4Util$SyncFrameInfo;
        Point point;
        byte b;
        boolean z;
        Pair codecProfileAndLevel;
        int codecMaxInputSize$1;
        String str = mediaCodecInfo.codecMimeType;
        Format[] formatArr = this.streamFormats;
        formatArr.getClass();
        int i2 = format.width;
        float f2 = format.frameRate;
        ColorInfo colorInfo2 = format.colorInfo;
        int i3 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (maxInputSize != -1 && (codecMaxInputSize$1 = getCodecMaxInputSize$1(mediaCodecInfo, format)) != -1) {
                maxInputSize = Math.min((int) (maxInputSize * 1.5f), codecMaxInputSize$1);
            }
            ac4Util$SyncFrameInfo = new Ac4Util$SyncFrameInfo(i2, i3, maxInputSize);
            colorInfo = colorInfo2;
            i = i3;
        } else {
            int length = formatArr.length;
            int iMax = i2;
            int iMax2 = i3;
            int i4 = 0;
            boolean z2 = false;
            while (i4 < length) {
                Format format2 = formatArr[i4];
                Format[] formatArr2 = formatArr;
                if (colorInfo2 != null && format2.colorInfo == null) {
                    Format.Builder builderBuildUpon = format2.buildUpon();
                    builderBuildUpon.colorInfo = colorInfo2;
                    format2 = new Format(builderBuildUpon);
                }
                DecoderReuseEvaluation decoderReuseEvaluationCanReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
                int i5 = length;
                int i6 = format2.height;
                if (decoderReuseEvaluationCanReuseCodec.result != 0) {
                    int i7 = format2.width;
                    b = -1;
                    z2 |= i7 == -1 || i6 == -1;
                    iMax = Math.max(iMax, i7);
                    iMax2 = Math.max(iMax2, i6);
                    maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format2));
                } else {
                    b = -1;
                }
                length = i5;
                i4++;
                formatArr = formatArr2;
            }
            if (z2) {
                Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
                boolean z3 = i3 > i2;
                int i8 = z3 ? i3 : i2;
                boolean z4 = z3;
                int i9 = z3 ? i2 : i3;
                float f3 = i9 / i8;
                int i10 = 0;
                while (true) {
                    colorInfo = colorInfo2;
                    if (i10 < 9) {
                        int i11 = STANDARD_LONG_EDGE_VIDEO_PX[i10];
                        int i12 = i10;
                        int i13 = (int) (i11 * f3);
                        if (i11 > i8 && i13 > i9) {
                            if (!z4) {
                                i13 = i11;
                            }
                            if (!z4) {
                                i11 = i13;
                            }
                            int i14 = i9;
                            android.media.MediaCodecInfo.VideoCapabilities videoCapabilities = mediaCodecInfo.capabilities.getVideoCapabilities();
                            if (videoCapabilities == null) {
                                point = null;
                            } else {
                                int widthAlignment = videoCapabilities.getWidthAlignment();
                                int heightAlignment = videoCapabilities.getHeightAlignment();
                                point = new Point(Util.ceilDivide(i13, widthAlignment) * widthAlignment, Util.ceilDivide(i11, heightAlignment) * heightAlignment);
                            }
                            if (point != null) {
                                i = i3;
                                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(f2, point.x, point.y)) {
                                }
                            } else {
                                i = i3;
                            }
                            i10 = i12 + 1;
                            i3 = i;
                            colorInfo2 = colorInfo;
                            i9 = i14;
                            i8 = i8;
                        }
                        if (point != null) {
                            iMax = Math.max(iMax, point.x);
                            iMax2 = Math.max(iMax2, point.y);
                            Format.Builder builderBuildUpon2 = format.buildUpon();
                            builderBuildUpon2.width = iMax;
                            builderBuildUpon2.height = iMax2;
                            maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize$1(mediaCodecInfo, new Format(builderBuildUpon2)));
                            Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
                        }
                    }
                    i = i3;
                    point = null;
                    if (point != null) {
                        iMax = Math.max(iMax, point.x);
                        iMax2 = Math.max(iMax2, point.y);
                        Format.Builder builderBuildUpon3 = format.buildUpon();
                        builderBuildUpon3.width = iMax;
                        builderBuildUpon3.height = iMax2;
                        maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize$1(mediaCodecInfo, new Format(builderBuildUpon3)));
                        Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
                    }
                }
            } else {
                colorInfo = colorInfo2;
                i = i3;
            }
            ac4Util$SyncFrameInfo = new Ac4Util$SyncFrameInfo(iMax, iMax2, maxInputSize);
        }
        this.codecMaxValues = ac4Util$SyncFrameInfo;
        int i15 = this.tunneling ? this.tunnelingAudioSessionId : 0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", i2);
        mediaFormat.setInteger("height", i);
        Log.setCsdBuffers(mediaFormat, format.initializationData);
        if (f2 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f2);
        }
        Log.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        if (colorInfo != null) {
            ColorInfo colorInfo3 = colorInfo;
            Log.maybeSetInteger(mediaFormat, "color-transfer", colorInfo3.colorTransfer);
            Log.maybeSetInteger(mediaFormat, "color-standard", colorInfo3.colorSpace);
            Log.maybeSetInteger(mediaFormat, "color-range", colorInfo3.colorRange);
            byte[] bArr = colorInfo3.hdrStaticInfo;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(format.sampleMimeType) && (codecProfileAndLevel = CodecSpecificDataUtil.getCodecProfileAndLevel(format)) != null) {
            Log.maybeSetInteger(mediaFormat, "profile", ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", ac4Util$SyncFrameInfo.sampleRate);
        mediaFormat.setInteger("max-height", ac4Util$SyncFrameInfo.frameSize);
        Log.maybeSetInteger(mediaFormat, "max-input-size", ac4Util$SyncFrameInfo.sampleCount);
        mediaFormat.setInteger("priority", 0);
        if (f != -1.0f) {
            mediaFormat.setFloat("operating-rate", f);
        }
        if (this.deviceNeedsNoPostProcessWorkaround) {
            z = true;
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        } else {
            z = true;
        }
        if (i15 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", z);
            mediaFormat.setInteger("audio-session-id", i15);
        }
        if (Build.VERSION.SDK_INT >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.rendererPriority));
        }
        applyCodecParametersToMediaFormat(mediaFormat);
        Surface surfaceForCodec = getSurfaceForCodec(mediaCodecInfo);
        if (this.videoSink != null && !Util.isFrameDropAllowedOnSurfaceInput(this.context)) {
            mediaFormat.setInteger("allow-frame-drop", 0);
        }
        return new QuantizerWu(mediaCodecInfo, mediaFormat, format, surfaceForCodec, mediaCrypto, (LoudnessCodecController) null);
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final String getName() {
        return "MediaCodecVideoRenderer";
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0055  */
    /* JADX WARN: Code duplicated, block: B:34:0x0058  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final Surface getSurfaceForCodec(MediaCodecInfo mediaCodecInfo) {
        boolean z;
        PlaceholderSurface.PlaceholderSurfaceThread placeholderSurfaceThread;
        int i;
        RuntimeException runtimeException;
        Error error;
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            return videoSink.getInputSurface();
        }
        Surface surface = this.displaySurface;
        if (surface != null) {
            return surface;
        }
        PlaceholderSurface placeholderSurface = null;
        if (Build.VERSION.SDK_INT >= 35 && mediaCodecInfo.detachedSurfaceSupported) {
            return null;
        }
        UtilsKt.checkState(shouldUsePlaceholderSurface(mediaCodecInfo));
        PlaceholderSurface placeholderSurface2 = this.placeholderSurface;
        if (placeholderSurface2 != null && placeholderSurface2.secure != mediaCodecInfo.secure) {
            if (placeholderSurface2 != null) {
                placeholderSurface2.release();
                this.placeholderSurface = null;
            } else {
                placeholderSurface = placeholderSurface2;
            }
            placeholderSurface2 = placeholderSurface;
        }
        if (placeholderSurface2 != null) {
            return placeholderSurface2;
        }
        boolean z2 = mediaCodecInfo.secure;
        boolean z3 = false;
        if (z2) {
            if (!PlaceholderSurface.isSecureSupported()) {
                z = false;
            }
            UtilsKt.checkState(z);
            placeholderSurfaceThread = new PlaceholderSurface.PlaceholderSurfaceThread("ExoPlayer:PlaceholderSurface");
            if (z2) {
                i = PlaceholderSurface.secureMode;
            } else {
                i = 0;
            }
            placeholderSurfaceThread.start();
            Handler handler = new Handler(placeholderSurfaceThread.getLooper(), placeholderSurfaceThread);
            placeholderSurfaceThread.handler = handler;
            placeholderSurfaceThread.eglSurfaceTexture = new EGLSurfaceTexture(handler);
            synchronized (placeholderSurfaceThread) {
                placeholderSurfaceThread.handler.obtainMessage(1, i, 0).sendToTarget();
                while (placeholderSurfaceThread.surface == null && placeholderSurfaceThread.initException == null && placeholderSurfaceThread.initError == null) {
                    try {
                        placeholderSurfaceThread.wait();
                    } catch (InterruptedException unused) {
                        z3 = true;
                    }
                }
            }
            if (z3) {
                Thread.currentThread().interrupt();
            }
            runtimeException = placeholderSurfaceThread.initException;
            if (runtimeException == null) {
                throw runtimeException;
            }
            error = placeholderSurfaceThread.initError;
            if (error == null) {
                throw error;
            }
            PlaceholderSurface placeholderSurface3 = placeholderSurfaceThread.surface;
            placeholderSurface3.getClass();
            this.placeholderSurface = placeholderSurface3;
            return placeholderSurface3;
        }
        int i2 = PlaceholderSurface.secureMode;
        z = true;
        UtilsKt.checkState(z);
        placeholderSurfaceThread = new PlaceholderSurface.PlaceholderSurfaceThread("ExoPlayer:PlaceholderSurface");
        if (z2) {
            i = PlaceholderSurface.secureMode;
        } else {
            i = 0;
        }
        placeholderSurfaceThread.start();
        Handler handler2 = new Handler(placeholderSurfaceThread.getLooper(), placeholderSurfaceThread);
        placeholderSurfaceThread.handler = handler2;
        placeholderSurfaceThread.eglSurfaceTexture = new EGLSurfaceTexture(handler2);
        synchronized (placeholderSurfaceThread) {
            placeholderSurfaceThread.handler.obtainMessage(1, i, 0).sendToTarget();
            while (placeholderSurfaceThread.surface == null) {
                placeholderSurfaceThread.wait();
            }
            if (z3) {
                Thread.currentThread().interrupt();
            }
            runtimeException = placeholderSurfaceThread.initException;
            if (runtimeException == null) {
                throw runtimeException;
            }
            error = placeholderSurfaceThread.initError;
            if (error == null) {
                throw error;
            }
            PlaceholderSurface placeholderSurface4 = placeholderSurfaceThread.surface;
            placeholderSurface4.getClass();
            this.placeholderSurface = placeholderSurface4;
            return placeholderSurface4;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = decoderInputBuffer.supplementalData;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4) {
                    if (b3 == 0 || b3 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        MediaCodecAdapter mediaCodecAdapter = this.codec;
                        mediaCodecAdapter.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        mediaCodecAdapter.setParameters(bundle);
                    }
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public final void handleMessage(int i, Object obj) {
        if (i == 1) {
            setOutput(obj);
            return;
        }
        if (i == 7) {
            obj.getClass();
            VideoFrameMetadataListener videoFrameMetadataListener = (VideoFrameMetadataListener) obj;
            this.frameMetadataListener = videoFrameMetadataListener;
            VideoSink videoSink = this.videoSink;
            if (videoSink != null) {
                videoSink.setVideoFrameMetadataListener(videoFrameMetadataListener);
                return;
            }
            return;
        }
        if (i == 10) {
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            if (this.tunnelingAudioSessionId != iIntValue) {
                this.tunnelingAudioSessionId = iIntValue;
                if (this.tunneling) {
                    releaseCodec();
                    return;
                }
                return;
            }
            return;
        }
        if (i == 4) {
            obj.getClass();
            int iIntValue2 = ((Integer) obj).intValue();
            this.scalingMode = iIntValue2;
            MediaCodecAdapter mediaCodecAdapter = this.codec;
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.setVideoScalingMode(iIntValue2);
                return;
            }
            return;
        }
        if (i == 5) {
            obj.getClass();
            int iIntValue3 = ((Integer) obj).intValue();
            this.changeFrameRateStrategy = iIntValue3;
            VideoSink videoSink2 = this.videoSink;
            if (videoSink2 != null) {
                videoSink2.setChangeFrameRateStrategy(iIntValue3);
                return;
            }
            VideoFrameReleaseHelper videoFrameReleaseHelper = this.videoFrameReleaseControl.frameReleaseHelper;
            if (videoFrameReleaseHelper.changeFrameRateStrategy == iIntValue3) {
                return;
            }
            videoFrameReleaseHelper.changeFrameRateStrategy = iIntValue3;
            videoFrameReleaseHelper.updateSurfacePlaybackFrameRate(true);
            return;
        }
        if (i == 13) {
            obj.getClass();
            List list = (List) obj;
            if (list.equals(VideoFrameProcessor.REDRAW)) {
                VideoSink videoSink3 = this.videoSink;
                if (videoSink3 == null || !videoSink3.isInitialized()) {
                    return;
                }
                this.videoSink.redraw();
                return;
            }
            this.videoEffects = list;
            VideoSink videoSink4 = this.videoSink;
            if (videoSink4 != null) {
                videoSink4.setVideoEffects(list);
                return;
            }
            return;
        }
        if (i == 14) {
            obj.getClass();
            Size size = (Size) obj;
            if (size.width == 0 || size.height == 0) {
                return;
            }
            this.outputResolution = size;
            VideoSink videoSink5 = this.videoSink;
            if (videoSink5 != null) {
                Surface surface = this.displaySurface;
                surface.getClass();
                videoSink5.setOutputSurfaceInfo(surface, size);
                return;
            }
            return;
        }
        switch (i) {
            case 16:
                obj.getClass();
                this.rendererPriority = ((Integer) obj).intValue();
                MediaCodecAdapter mediaCodecAdapter2 = this.codec;
                if (mediaCodecAdapter2 != null && Build.VERSION.SDK_INT >= 35) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("importance", Math.max(0, -this.rendererPriority));
                    mediaCodecAdapter2.setParameters(bundle);
                }
                break;
            case 17:
                Surface surface2 = this.displaySurface;
                setOutput(null);
                obj.getClass();
                ((MediaCodecVideoRenderer) obj).handleMessage(1, surface2);
                break;
            case 18:
                boolean z = this.scrubbingModeParameters != null;
                ScrubbingModeParameters scrubbingModeParameters = (ScrubbingModeParameters) obj;
                this.scrubbingModeParameters = scrubbingModeParameters;
                if (z != (scrubbingModeParameters != null)) {
                    updateCodecOperatingRate(this.codecInputFormat);
                }
                break;
            default:
                super.handleMessage(i, obj);
                break;
        }
    }

    public final boolean hasSurfaceForCodec(MediaCodecInfo mediaCodecInfo) {
        if (this.videoSink != null) {
            return true;
        }
        Surface surface = this.displaySurface;
        if (surface == null || !surface.isValid()) {
            return (Build.VERSION.SDK_INT >= 35 && mediaCodecInfo.detachedSurfaceSupported) || shouldUsePlaceholderSurface(mediaCodecInfo);
        }
        return true;
    }

    public final boolean isBufferProbablyLastSample(DecoderInputBuffer decoderInputBuffer) {
        if (hasReadStreamToEnd() || decoderInputBuffer.getFlag(536870912)) {
            return true;
        }
        long j = this.periodDurationUs;
        return j == -9223372036854775807L || j - (decoderInputBuffer.timeUs - this.outputStreamInfo.streamOffsetUs) <= 100000;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final boolean isEnded() {
        if (!this.outputStreamEnded) {
            return false;
        }
        VideoSink videoSink = this.videoSink;
        return videoSink == null || videoSink.isEnded();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final boolean isReady() {
        boolean z;
        boolean zIsReady;
        if (this.inputFormat == null) {
            z = false;
        } else {
            if (hasReadStreamToEnd()) {
                zIsReady = this.streamIsFinal;
            } else {
                SampleStream sampleStream = this.stream;
                sampleStream.getClass();
                zIsReady = sampleStream.isReady();
            }
            if (!zIsReady && this.outputIndex < 0) {
                if (this.codecHotswapDeadlineMs != -9223372036854775807L) {
                    this.clock.getClass();
                    if (SystemClock.elapsedRealtime() < this.codecHotswapDeadlineMs) {
                    }
                }
                z = false;
            }
            z = true;
        }
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            return videoSink.isReady(z);
        }
        if (z && (this.codec == null || this.tunneling)) {
            return true;
        }
        return this.videoFrameReleaseControl.isReady(z);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final boolean maybeInitializeProcessingPipeline(Format format) throws ExoPlaybackException {
        VideoSink videoSink = this.videoSink;
        if (videoSink == null || videoSink.isInitialized()) {
            return true;
        }
        try {
            return this.videoSink.initialize(format);
        } catch (VideoSink.VideoSinkException e) {
            throw createRendererException(e, format, false, 7000);
        }
    }

    public final void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            this.clock.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            final long j = jElapsedRealtime - this.droppedFrameAccumulationStartTimeMs;
            final int i = this.droppedFrames;
            final AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
            Handler handler = audioRendererEventListener$EventDispatcher.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.video.VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExoPlayerImpl.ComponentListener componentListener = audioRendererEventListener$EventDispatcher.listener;
                        String str = Util.DEVICE_DEBUG_INFO;
                        DefaultAnalyticsCollector defaultAnalyticsCollector = ExoPlayerImpl.this.analyticsCollector;
                        AnalyticsListener.EventTime eventTimeGenerateEventTime = defaultAnalyticsCollector.generateEventTime((MediaSource$MediaPeriodId) defaultAnalyticsCollector.mediaPeriodQueueTracker.moments);
                        defaultAnalyticsCollector.sendEvent(eventTimeGenerateEventTime, 1018, new UCropActivity$$ExternalSyntheticLambda1(eventTimeGenerateEventTime, i, j));
                    }
                });
            }
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = jElapsedRealtime;
        }
    }

    public final void maybeSetupTunnelingForFirstFrame() {
        MediaCodecAdapter mediaCodecAdapter;
        if (this.tunneling && (mediaCodecAdapter = this.codec) != null) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListener(mediaCodecAdapter);
            if (Build.VERSION.SDK_INT >= 33) {
                Bundle bundle = new Bundle();
                bundle.putInt("tunnel-peek", 1);
                mediaCodecAdapter.setParameters(bundle);
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void onCodecError(Exception exc) {
        Log.e("MediaCodecVideoRenderer", "Video codec error", exc);
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        Handler handler = audioRendererEventListener$EventDispatcher.handler;
        if (handler != null) {
            handler.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher, (Object) exc, (byte) 1));
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void onCodecInitialized(long j, long j2, String str) {
        String str2;
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        Handler handler = audioRendererEventListener$EventDispatcher.handler;
        if (handler != null) {
            str2 = str;
            handler.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher, str2, j, j2));
        } else {
            str2 = str;
        }
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str2);
        MediaCodecInfo mediaCodecInfo = this.codecInfo;
        mediaCodecInfo.getClass();
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(mediaCodecInfo.mimeType)) {
            android.media.MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = mediaCodecInfo.capabilities.profileLevels;
            if (codecProfileLevelArr == null) {
                codecProfileLevelArr = new android.media.MediaCodecInfo.CodecProfileLevel[0];
            }
            for (android.media.MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
                if (codecProfileLevel.profile == 16384) {
                    z = true;
                    break;
                }
            }
        }
        this.codecHandlesHdr10PlusOutOfBandMetadata = z;
        maybeSetupTunnelingForFirstFrame();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void onCodecParametersChanged(CodecParameters codecParameters) {
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        Handler handler = audioRendererEventListener$EventDispatcher.handler;
        if (handler != null) {
            handler.post(new TransactionExecutor$$ExternalSyntheticLambda0((Object) audioRendererEventListener$EventDispatcher, (Object) codecParameters, (byte) 1));
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void onCodecReleased(String str) {
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        Handler handler = audioRendererEventListener$EventDispatcher.handler;
        if (handler != null) {
            handler.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher, (Object) str, (byte) 2));
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void onDisabled() {
        DecoderCounters decoderCounters;
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        this.reportedVideoSize = null;
        this.periodDurationUs = -9223372036854775807L;
        maybeSetupTunnelingForFirstFrame();
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        this.tunnelingOnFrameRenderedListener = null;
        this.isFlushRequired = true;
        byte b = 3;
        try {
            super.onDisabled();
            decoderCounters = this.decoderCounters;
            audioRendererEventListener$EventDispatcher.getClass();
            synchronized (decoderCounters) {
            }
        } finally {
            decoderCounters = this.decoderCounters;
            audioRendererEventListener$EventDispatcher.getClass();
            synchronized (decoderCounters) {
                Handler handler = audioRendererEventListener$EventDispatcher.handler;
                if (handler != null) {
                    handler.post(new TransactionExecutor$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher, decoderCounters, b));
                }
                audioRendererEventListener$EventDispatcher.videoSizeChanged(VideoSize.UNKNOWN);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.media3.exoplayer.video.MediaCodecVideoRenderer$1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onEnabled(boolean z, boolean z2) {
        VideoSink videoSink;
        this.decoderCounters = new DecoderCounters();
        RendererConfiguration rendererConfiguration = this.configuration;
        rendererConfiguration.getClass();
        boolean z3 = rendererConfiguration.tunneling;
        UtilsKt.checkState((z3 && this.tunnelingAudioSessionId == 0) ? false : true);
        if (this.tunneling != z3) {
            this.tunneling = z3;
            releaseCodec();
        }
        DecoderCounters decoderCounters = this.decoderCounters;
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        Handler handler = audioRendererEventListener$EventDispatcher.handler;
        if (handler != null) {
            handler.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher, (Object) decoderCounters, (byte) 4));
        }
        boolean z4 = this.hasSetVideoSink;
        VideoFrameReleaseControl videoFrameReleaseControl = this.videoFrameReleaseControl;
        if (!z4) {
            if (this.videoEffects != null && this.videoSink == null) {
                PlaybackVideoGraphWrapper.Builder builder = new PlaybackVideoGraphWrapper.Builder(this.context, videoFrameReleaseControl);
                builder.enablePlaylistMode = true;
                long j = this.minEarlyUsToDropDecoderInput;
                builder.lateThresholdToDropInputUs = j != -9223372036854775807L ? -j : -9223372036854775807L;
                androidx.media3.common.util.SystemClock systemClock = this.clock;
                systemClock.getClass();
                builder.clock = systemClock;
                UtilsKt.checkState(!builder.built);
                if (builder.videoGraphFactory == null) {
                    builder.videoGraphFactory = new PlaybackVideoGraphWrapper.ReflectiveSingleInputVideoGraphFactory();
                }
                PlaybackVideoGraphWrapper playbackVideoGraphWrapper = new PlaybackVideoGraphWrapper(builder);
                builder.built = true;
                if (1 >= playbackVideoGraphWrapper.totalVideoInputCount) {
                    playbackVideoGraphWrapper.totalVideoInputCount = 1;
                }
                SparseArray sparseArray = playbackVideoGraphWrapper.inputVideoSinks;
                if (sparseArray.indexOfKey(0) >= 0) {
                    videoSink = (VideoSink) sparseArray.get(0);
                } else {
                    PlaybackVideoGraphWrapper.InputVideoSink inputVideoSink = playbackVideoGraphWrapper.new InputVideoSink(playbackVideoGraphWrapper.context);
                    playbackVideoGraphWrapper.listeners.add(inputVideoSink);
                    sparseArray.put(0, inputVideoSink);
                    videoSink = inputVideoSink;
                }
                this.videoSink = videoSink;
            }
            this.hasSetVideoSink = true;
        }
        VideoSink videoSink2 = this.videoSink;
        if (videoSink2 == 0) {
            androidx.media3.common.util.SystemClock systemClock2 = this.clock;
            systemClock2.getClass();
            videoFrameReleaseControl.clock = systemClock2;
            videoFrameReleaseControl.onStreamChanged(!z2 ? 1 : 0);
            return;
        }
        videoSink2.setListener(new VideoSink.Listener() { // from class: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.1
            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public final void onFirstFrameRendered() {
                MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
                Surface surface = mediaCodecVideoRenderer.displaySurface;
                if (surface != null) {
                    AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher2 = mediaCodecVideoRenderer.eventDispatcher;
                    Handler handler2 = audioRendererEventListener$EventDispatcher2.handler;
                    if (handler2 != null) {
                        handler2.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda2(audioRendererEventListener$EventDispatcher2, surface, SystemClock.elapsedRealtime()));
                    }
                    mediaCodecVideoRenderer.haveReportedFirstFrameRenderedForCurrentSurface = true;
                }
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public final void onFrameAvailableForRendering() {
                ExoPlayerImplInternal.AnonymousClass1 anonymousClass1 = MediaCodecVideoRenderer.this.wakeupListener;
                if (anonymousClass1 != null) {
                    anonymousClass1.onWakeup();
                }
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public final void onFrameDropped() {
                MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
                if (mediaCodecVideoRenderer.displaySurface != null) {
                    mediaCodecVideoRenderer.updateDroppedBufferCounters(0, 1);
                }
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public final void onVideoSizeChanged(VideoSize videoSize) {
            }
        });
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            this.videoSink.setVideoFrameMetadataListener(videoFrameMetadataListener);
        }
        if (this.displaySurface != null && !this.outputResolution.equals(Size.UNKNOWN)) {
            this.videoSink.setOutputSurfaceInfo(this.displaySurface, this.outputResolution);
        }
        this.videoSink.setChangeFrameRateStrategy(this.changeFrameRateStrategy);
        this.videoSink.setPlaybackSpeed(this.currentPlaybackSpeed);
        List list = this.videoEffects;
        if (list != null) {
            this.videoSink.setVideoEffects(list);
        }
        this.nextVideoSinkFirstFrameReleaseInstruction = !z2 ? 1 : 0;
        this.experimentalEnableProcessedStreamChangedAtStart = true;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final DecoderReuseEvaluation onInputFormatChanged(WeakCache weakCache) {
        DecoderReuseEvaluation decoderReuseEvaluationOnInputFormatChanged = super.onInputFormatChanged(weakCache);
        Format format = (Format) weakCache.referenceQueue;
        format.getClass();
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        Handler handler = audioRendererEventListener$EventDispatcher.handler;
        if (handler != null) {
            handler.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher, format, decoderReuseEvaluationOnInputFormatChanged));
        }
        VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = this.videoFrameReleaseEarlyTimeForecaster;
        if (videoFrameReleaseEarlyTimeForecaster != null) {
            videoFrameReleaseEarlyTimeForecaster.reset();
        }
        return decoderReuseEvaluationOnInputFormatChanged;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void onOutputFormatChanged(Format format, MediaFormat mediaFormat) {
        int integer;
        int i;
        MediaCodecAdapter mediaCodecAdapter = this.codec;
        if (mediaCodecAdapter != null) {
            mediaCodecAdapter.setVideoScalingMode(this.scalingMode);
        }
        if (this.tunneling) {
            i = format.width;
            integer = format.height;
        } else {
            mediaFormat.getClass();
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            int integer2 = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            integer = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
            i = integer2;
        }
        float f = format.pixelWidthHeightRatio;
        int i2 = format.rotationDegrees;
        if (i2 == 90 || i2 == 270) {
            f = 1.0f / f;
            int i3 = integer;
            integer = i;
            i = i3;
        }
        this.decodedVideoSize = new VideoSize(f, i, integer);
        VideoSink videoSink = this.videoSink;
        if (videoSink == null || !this.pendingVideoSinkInputStreamChange) {
            this.videoFrameReleaseControl.setFrameRate(format.frameRate);
        } else {
            Format.Builder builderBuildUpon = format.buildUpon();
            builderBuildUpon.width = i;
            builderBuildUpon.height = integer;
            builderBuildUpon.pixelWidthHeightRatio = f;
            Format format2 = new Format(builderBuildUpon);
            int i4 = this.nextVideoSinkFirstFrameReleaseInstruction;
            List list = this.videoEffects;
            if (list == null) {
                ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                list = RegularImmutableList.EMPTY;
            }
            videoSink.onInputStreamChanged(format2, this.outputStreamInfo.startPositionUs, i4, list);
            this.nextVideoSinkFirstFrameReleaseInstruction = 2;
        }
        this.pendingVideoSinkInputStreamChange = false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void onPositionReset(long j, boolean z, boolean z2) {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null && !z) {
            videoSink.flush(true);
        }
        if (z2) {
            this.lastResetToKeyFramePositionUs = j;
        }
        super.onPositionReset(j, z, z2);
        VideoSink videoSink2 = this.videoSink;
        VideoFrameReleaseControl videoFrameReleaseControl = this.videoFrameReleaseControl;
        if (videoSink2 == null) {
            videoFrameReleaseControl.frameReleaseHelper.resetAdjustment();
            videoFrameReleaseControl.lastPresentationTimeUs = -9223372036854775807L;
            videoFrameReleaseControl.initialPositionUs = -9223372036854775807L;
            videoFrameReleaseControl.firstFrameState = Math.min(videoFrameReleaseControl.firstFrameState, 1);
            videoFrameReleaseControl.joiningDeadlineMs = -9223372036854775807L;
            videoFrameReleaseControl.frameReadyWithoutSurface = false;
        }
        VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = this.videoFrameReleaseEarlyTimeForecaster;
        if (videoFrameReleaseEarlyTimeForecaster != null) {
            videoFrameReleaseEarlyTimeForecaster.reset();
        }
        if (z) {
            VideoSink videoSink3 = this.videoSink;
            if (videoSink3 != null) {
                videoSink3.join(false);
            } else {
                videoFrameReleaseControl.join(false);
            }
        }
        maybeSetupTunnelingForFirstFrame();
        this.consecutiveDroppedFrameCount = 0;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void onProcessedOutputBuffer$1(long j) {
        super.onProcessedOutputBuffer$1(j);
        if (this.tunneling) {
            return;
        }
        this.buffersInCodecCount--;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void onProcessedStreamChange() {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.signalEndOfCurrentInputStream();
            long j = this.startPositionUs;
            if (j == -9223372036854775807L) {
                j = this.outputStreamInfo.startPositionUs;
                this.startPositionUs = j;
            }
            this.videoSink.setBufferTimestampAdjustmentUs(-j);
        } else {
            this.videoFrameReleaseControl.onStreamChanged(2);
        }
        this.pendingVideoSinkInputStreamChange = true;
        maybeSetupTunnelingForFirstFrame();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        CallbackWrapper callbackWrapper = this.av1SampleDependencyParser;
        if (callbackWrapper != null) {
            MediaCodecInfo mediaCodecInfo = this.codecInfo;
            mediaCodecInfo.getClass();
            if (mediaCodecInfo.mimeType.equals("video/av01") && decoderInputBuffer.getFlag(1) && (byteBuffer = decoderInputBuffer.data) != null) {
                int iPosition = byteBuffer.position();
                int iLimit = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit, iPosition + CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION));
                ByteBuffer byteBuffer2 = (ByteBuffer) callbackWrapper.mCallback;
                byteBuffer2.clear();
                byteBuffer2.put(byteBuffer);
                byteBuffer2.flip();
                byteBuffer.position(iPosition);
                byteBuffer.limit(iLimit);
            }
        }
        this.consecutiveDroppedInputBufferCount = 0;
        int codecBufferFlags = getCodecBufferFlags(decoderInputBuffer);
        if ((Build.VERSION.SDK_INT < 34 || (codecBufferFlags & 32) == 0) && !this.tunneling) {
            this.buffersInCodecCount++;
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onRelease() {
        VideoSink videoSink = this.videoSink;
        if (videoSink == null || !this.ownsVideoSink) {
            return;
        }
        videoSink.release();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onReset() {
        try {
            try {
                this.bypassEnabled = false;
                resetBypassState();
                releaseCodec();
                DrmSession drmSession = this.sourceDrmSession;
                if (drmSession != null) {
                    drmSession.release(null);
                }
                this.sourceDrmSession = null;
                this.hasSetVideoSink = false;
                this.startPositionUs = -9223372036854775807L;
                PlaceholderSurface placeholderSurface = this.placeholderSurface;
                if (placeholderSurface != null) {
                    placeholderSurface.release();
                    this.placeholderSurface = null;
                }
            } catch (Throwable th) {
                DrmSession drmSession2 = this.sourceDrmSession;
                if (drmSession2 != null) {
                    drmSession2.release(null);
                }
                this.sourceDrmSession = null;
                throw th;
            }
        } catch (Throwable th2) {
            this.hasSetVideoSink = false;
            this.startPositionUs = -9223372036854775807L;
            PlaceholderSurface placeholderSurface2 = this.placeholderSurface;
            if (placeholderSurface2 != null) {
                placeholderSurface2.release();
                this.placeholderSurface = null;
            }
            throw th2;
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onStarted() {
        this.droppedFrames = 0;
        this.clock.getClass();
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.totalVideoFrameProcessingOffsetUs = 0L;
        this.videoFrameProcessingOffsetCount = 0;
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.startRendering();
        } else {
            this.videoFrameReleaseControl.onStarted();
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onStopped() {
        maybeNotifyDroppedFrames();
        int i = this.videoFrameProcessingOffsetCount;
        if (i != 0) {
            long j = this.totalVideoFrameProcessingOffsetUs;
            AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
            Handler handler = audioRendererEventListener$EventDispatcher.handler;
            if (handler != null) {
                handler.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(i, j, audioRendererEventListener$EventDispatcher));
            }
            this.totalVideoFrameProcessingOffsetUs = 0L;
            this.videoFrameProcessingOffsetCount = 0;
        }
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.stopRendering();
        } else {
            VideoFrameReleaseControl videoFrameReleaseControl = this.videoFrameReleaseControl;
            videoFrameReleaseControl.started = false;
            videoFrameReleaseControl.joiningDeadlineMs = -9223372036854775807L;
            VideoFrameReleaseHelper videoFrameReleaseHelper = videoFrameReleaseControl.frameReleaseHelper;
            videoFrameReleaseHelper.started = false;
            VideoFrameReleaseHelper.VSyncSampler vSyncSampler = videoFrameReleaseHelper.vsyncSampler;
            if (vSyncSampler != null) {
                vSyncSampler.unregister();
            }
            videoFrameReleaseHelper.clearSurfaceFrameRate();
        }
        VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = this.videoFrameReleaseEarlyTimeForecaster;
        if (videoFrameReleaseEarlyTimeForecaster != null) {
            videoFrameReleaseEarlyTimeForecaster.reset();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void onStreamChanged(Format[] formatArr, long j, long j2, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        super.onStreamChanged(formatArr, j, j2, mediaSource$MediaPeriodId);
        updatePeriodDurationUs(mediaSource$MediaPeriodId);
        VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = this.videoFrameReleaseEarlyTimeForecaster;
        if (videoFrameReleaseEarlyTimeForecaster != null) {
            videoFrameReleaseEarlyTimeForecaster.reset();
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onTimelineChanged() {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodId;
        if (mediaSource$MediaPeriodId != null) {
            updatePeriodDurationUs(mediaSource$MediaPeriodId);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final boolean processOutputBuffer(long j, long j2, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) {
        int i4;
        mediaCodecAdapter.getClass();
        long j4 = j3 - this.outputStreamInfo.streamOffsetUs;
        int i5 = 0;
        while (true) {
            PriorityQueue priorityQueue = this.droppedDecoderInputBufferTimestamps;
            Long l = (Long) priorityQueue.peek();
            if (l == null || l.longValue() >= j3) {
                break;
            }
            i5++;
            priorityQueue.poll();
        }
        updateDroppedBufferCounters(i5, 0);
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            if (!z || z2) {
                return videoSink.handleInputFrame(j3, new AnonymousClass2(mediaCodecAdapter, i, j4));
            }
            skipOutputBuffer(mediaCodecAdapter, i);
            return true;
        }
        int frameReleaseAction = this.videoFrameReleaseControl.getFrameReleaseAction(j3, j, j2, this.outputStreamInfo.startPositionUs, z, z2, this.videoFrameReleaseInfo);
        EocdRecord eocdRecord = this.videoFrameReleaseInfo;
        VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = this.videoFrameReleaseEarlyTimeForecaster;
        if (videoFrameReleaseEarlyTimeForecaster != null && frameReleaseAction != 5 && frameReleaseAction != 4) {
            videoFrameReleaseEarlyTimeForecaster.onVideoFrameProcessed(j3, eocdRecord.entryCount);
        }
        if (frameReleaseAction == 0) {
            this.clock.getClass();
            long jNanoTime = System.nanoTime();
            VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
            if (videoFrameMetadataListener != null) {
                videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j4, jNanoTime, format, this.codecOutputMediaFormat);
            }
            renderOutputBufferV21(mediaCodecAdapter, i, jNanoTime);
            updateVideoFrameProcessingOffsetCounters(eocdRecord.entryCount);
            return true;
        }
        if (frameReleaseAction == 1) {
            long j5 = eocdRecord.centralDirectoryOffset;
            long j6 = eocdRecord.entryCount;
            if (j5 == this.lastFrameReleaseTimeNs) {
                skipOutputBuffer(mediaCodecAdapter, i);
            } else {
                VideoFrameMetadataListener videoFrameMetadataListener2 = this.frameMetadataListener;
                if (videoFrameMetadataListener2 != null) {
                    i4 = i;
                    videoFrameMetadataListener2.onVideoFrameAboutToBeRendered(j4, j5, format, this.codecOutputMediaFormat);
                } else {
                    i4 = i;
                }
                renderOutputBufferV21(mediaCodecAdapter, i4, j5);
            }
            updateVideoFrameProcessingOffsetCounters(j6);
            this.lastFrameReleaseTimeNs = j5;
            return true;
        }
        if (frameReleaseAction == 2) {
            Trace.beginSection("dropVideoBuffer");
            mediaCodecAdapter.releaseOutputBuffer(i);
            Trace.endSection();
            updateDroppedBufferCounters(0, 1);
            updateVideoFrameProcessingOffsetCounters(eocdRecord.entryCount);
            return true;
        }
        if (frameReleaseAction == 3) {
            skipOutputBuffer(mediaCodecAdapter, i);
            updateVideoFrameProcessingOffsetCounters(eocdRecord.entryCount);
            return true;
        }
        if (frameReleaseAction != 4 && frameReleaseAction != 5) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(String.valueOf(frameReleaseAction));
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void render(long j, long j2) throws ExoPlaybackException {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            try {
                videoSink.render(j, j2);
            } catch (VideoSink.VideoSinkException e) {
                throw createRendererException(e, e.format, false, 7001);
            }
        }
        super.render(j, j2);
    }

    public final void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        Surface surface;
        Trace.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, j);
        Trace.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        if (this.videoSink == null) {
            VideoSize videoSize = this.decodedVideoSize;
            boolean zEquals = videoSize.equals(VideoSize.UNKNOWN);
            AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
            if (!zEquals && !videoSize.equals(this.reportedVideoSize)) {
                this.reportedVideoSize = videoSize;
                audioRendererEventListener$EventDispatcher.videoSizeChanged(videoSize);
            }
            VideoFrameReleaseControl videoFrameReleaseControl = this.videoFrameReleaseControl;
            boolean z = videoFrameReleaseControl.firstFrameState != 3;
            videoFrameReleaseControl.firstFrameState = 3;
            videoFrameReleaseControl.clock.getClass();
            videoFrameReleaseControl.lastReleaseRealtimeUs = Util.msToUs(SystemClock.elapsedRealtime());
            if (!z || (surface = this.displaySurface) == null) {
                return;
            }
            Handler handler = audioRendererEventListener$EventDispatcher.handler;
            if (handler != null) {
                handler.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda2(audioRendererEventListener$EventDispatcher, surface, SystemClock.elapsedRealtime()));
            }
            this.haveReportedFirstFrameRenderedForCurrentSurface = true;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void renderToEndOfStream() {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.signalEndOfCurrentInputStream();
        } else {
            long j = this.outputStreamInfo.lastBufferTimeUs;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.droppedDecoderInputBufferTimestamps.clear();
        this.buffersInCodecCount = 0;
        this.consecutiveDroppedInputBufferCount = 0;
        this.isFlushRequired = false;
        CallbackWrapper callbackWrapper = this.av1SampleDependencyParser;
        if (callbackWrapper != null) {
            callbackWrapper.mExecutor = null;
            ByteBuffer byteBuffer = (ByteBuffer) callbackWrapper.mCallback;
            byteBuffer.position(byteBuffer.limit());
        }
    }

    public final void setOutput(Object obj) {
        Handler handler;
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        Surface surface2 = this.displaySurface;
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        if (surface2 == surface) {
            if (surface != null) {
                VideoSize videoSize = this.reportedVideoSize;
                if (videoSize != null) {
                    audioRendererEventListener$EventDispatcher.videoSizeChanged(videoSize);
                }
                Surface surface3 = this.displaySurface;
                if (surface3 == null || !this.haveReportedFirstFrameRenderedForCurrentSurface || (handler = audioRendererEventListener$EventDispatcher.handler) == null) {
                    return;
                }
                handler.post(new VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda2(audioRendererEventListener$EventDispatcher, surface3, SystemClock.elapsedRealtime()));
                return;
            }
            return;
        }
        this.displaySurface = surface;
        VideoSink videoSink = this.videoSink;
        VideoFrameReleaseControl videoFrameReleaseControl = this.videoFrameReleaseControl;
        if (videoSink == null) {
            videoFrameReleaseControl.setOutputSurface(surface);
        }
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        byte b = this.state;
        MediaCodecAdapter mediaCodecAdapter = this.codec;
        if (mediaCodecAdapter != null && this.videoSink == null) {
            MediaCodecInfo mediaCodecInfo = this.codecInfo;
            mediaCodecInfo.getClass();
            if (!hasSurfaceForCodec(mediaCodecInfo) || this.codecNeedsSetOutputSurfaceWorkaround) {
                releaseCodec();
                maybeInitCodecOrBypass();
            } else {
                Surface surfaceForCodec = getSurfaceForCodec(mediaCodecInfo);
                if (surfaceForCodec != null) {
                    mediaCodecAdapter.setOutputSurface(surfaceForCodec);
                } else {
                    if (Build.VERSION.SDK_INT < 35) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m();
                        return;
                    }
                    mediaCodecAdapter.detachOutputSurface();
                }
            }
        }
        if (surface != null) {
            VideoSize videoSize2 = this.reportedVideoSize;
            if (videoSize2 != null) {
                audioRendererEventListener$EventDispatcher.videoSizeChanged(videoSize2);
            }
        } else {
            this.reportedVideoSize = null;
            VideoSink videoSink2 = this.videoSink;
            if (videoSink2 != null) {
                videoSink2.clearOutputSurfaceInfo();
            }
        }
        if (b == 2) {
            VideoSink videoSink3 = this.videoSink;
            if (videoSink3 != null) {
                videoSink3.join(true);
            } else {
                videoFrameReleaseControl.join(true);
            }
        }
        maybeSetupTunnelingForFirstFrame();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void setPlaybackSpeed(float f, float f2) {
        super.setPlaybackSpeed(f, f2);
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.setPlaybackSpeed(f);
        } else {
            this.videoFrameReleaseControl.setPlaybackSpeed(f);
        }
        VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = this.videoFrameReleaseEarlyTimeForecaster;
        if (videoFrameReleaseEarlyTimeForecaster != null) {
            videoFrameReleaseEarlyTimeForecaster.setPlaybackSpeed(f);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003b  */
    /* JADX WARN: Code duplicated, block: B:90:0x013f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x0141  */
    /* JADX WARN: Code duplicated, block: B:92:0x0149  */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final boolean shouldDiscardDecoderInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        boolean z;
        ByteBuffer byteBuffer;
        int iLimit;
        ObuParser$SequenceHeader obuParser$SequenceHeader;
        VorbisUtil$Mode vorbisUtil$Mode;
        boolean z2 = false;
        if (!isBufferProbablyLastSample(decoderInputBuffer)) {
            long j = decoderInputBuffer.timeUs;
            boolean z3 = j < this.lastResetPositionUs;
            VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = this.videoFrameReleaseEarlyTimeForecaster;
            if (videoFrameReleaseEarlyTimeForecaster != null) {
                long j2 = videoFrameReleaseEarlyTimeForecaster.lastFramePresentationTimeUs;
                long j3 = j2 == -9223372036854775807L ? -9223372036854775807L : (long) (((j - j2) * videoFrameReleaseEarlyTimeForecaster.derivativeOfEarlyTime) + videoFrameReleaseEarlyTimeForecaster.lastFrameEarlyUs);
                if (j3 == -9223372036854775807L || j3 >= this.minEarlyUsToDropDecoderInput) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = false;
            }
            if ((z3 || z) && !decoderInputBuffer.getFlag(WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE)) {
                if (!decoderInputBuffer.getFlag(67108864)) {
                    CallbackWrapper callbackWrapper = this.av1SampleDependencyParser;
                    if (callbackWrapper != null) {
                        ByteBuffer byteBuffer2 = (ByteBuffer) callbackWrapper.mCallback;
                        MediaCodecInfo mediaCodecInfo = this.codecInfo;
                        mediaCodecInfo.getClass();
                        if (mediaCodecInfo.mimeType.equals("video/av01") && (byteBuffer = decoderInputBuffer.data) != null) {
                            boolean z4 = z3 || this.consecutiveDroppedInputBufferCount <= 0;
                            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                            byteBufferAsReadOnlyBuffer.flip();
                            if (byteBuffer2.hasRemaining()) {
                                callbackWrapper.updateSequenceHeaders(OpusUtil.split(byteBuffer2));
                                byteBuffer2.position(byteBuffer2.limit());
                            }
                            ArrayList arrayListSplit = OpusUtil.split(byteBufferAsReadOnlyBuffer);
                            callbackWrapper.updateSequenceHeaders(arrayListSplit);
                            int size = arrayListSplit.size() - 1;
                            int i = 0;
                            while (size >= 0) {
                                ObuParser$Obu obuParser$Obu = (ObuParser$Obu) arrayListSplit.get(size);
                                int i2 = obuParser$Obu.type;
                                if (i2 != 2 && i2 != 15) {
                                    if ((i2 == 3 && !z4) || ((i2 != 6 && i2 != 3) || (obuParser$SequenceHeader = (ObuParser$SequenceHeader) callbackWrapper.mExecutor) == null)) {
                                        break;
                                    }
                                    try {
                                        vorbisUtil$Mode = new VorbisUtil$Mode(obuParser$SequenceHeader, obuParser$Obu);
                                    } catch (ObuParser$NotYetImplementedException unused) {
                                        vorbisUtil$Mode = null;
                                    }
                                    if (vorbisUtil$Mode == null || vorbisUtil$Mode.blockFlag) {
                                        break;
                                    }
                                }
                                if (((ObuParser$Obu) arrayListSplit.get(size)).type == 6 || ((ObuParser$Obu) arrayListSplit.get(size)).type == 3) {
                                    i++;
                                }
                                size--;
                            }
                            if (i > 1 || size + 1 >= 8) {
                                iLimit = byteBufferAsReadOnlyBuffer.limit();
                            } else {
                                iLimit = size >= 0 ? ((ObuParser$Obu) arrayListSplit.get(size)).payload.limit() : byteBufferAsReadOnlyBuffer.position();
                            }
                            if (iLimit == 0) {
                                decoderInputBuffer.clear();
                            } else if (iLimit != byteBufferAsReadOnlyBuffer.limit()) {
                                Ac4Util$SyncFrameInfo ac4Util$SyncFrameInfo = this.codecMaxValues;
                                ac4Util$SyncFrameInfo.getClass();
                                if (ac4Util$SyncFrameInfo.sampleCount + iLimit < byteBufferAsReadOnlyBuffer.capacity() && !decoderInputBuffer.getFlag(1073741824)) {
                                    ByteBuffer byteBuffer3 = decoderInputBuffer.data;
                                    byteBuffer3.getClass();
                                    byteBuffer3.position(iLimit);
                                }
                            }
                        }
                    }
                    if (z2) {
                        if (z3) {
                            this.decoderCounters.skippedInputBufferCount++;
                        } else {
                            this.droppedDecoderInputBufferTimestamps.add(Long.valueOf(decoderInputBuffer.timeUs));
                            this.consecutiveDroppedInputBufferCount++;
                        }
                    }
                    return z2;
                }
                decoderInputBuffer.clear();
                z2 = true;
                if (z2) {
                    if (z3) {
                        this.decoderCounters.skippedInputBufferCount++;
                    } else {
                        this.droppedDecoderInputBufferTimestamps.add(Long.valueOf(decoderInputBuffer.timeUs));
                        this.consecutiveDroppedInputBufferCount++;
                    }
                }
                return z2;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0027  */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final boolean shouldFlushCodec() {
        boolean z;
        Format format = this.codecInputFormat;
        long j = this.periodDurationUs;
        if (j != -9223372036854775807L) {
            if (this.skippedFlushOffsetUs + 1 + j > Long.MAX_VALUE - (this.outputStreamInfo.streamOffsetUs + j)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        return this.scrubbingModeParameters == null || this.isFlushRequired || this.tunneling || (format != null && format.maxNumReorderSamples > 0) || z || this.outputStreamInfo.lastBufferTimeUs != -9223372036854775807L;
    }

    public final boolean shouldIgnoreFrame(long j, long j2, boolean z, boolean z2) {
        if (this.videoSink != null && this.ownsVideoSink) {
            j2 -= -this.startPositionUs;
        }
        if (j < -500000 && !z) {
            SampleStream sampleStream = this.stream;
            sampleStream.getClass();
            int iSkipData = sampleStream.skipData(j2 - this.streamOffsetUs);
            if (iSkipData != 0) {
                this.lastResetToKeyFramePositionUs = j2;
                DecoderCounters decoderCounters = this.decoderCounters;
                PriorityQueue priorityQueue = this.droppedDecoderInputBufferTimestamps;
                if (z2) {
                    int i = decoderCounters.skippedInputBufferCount + iSkipData;
                    decoderCounters.skippedInputBufferCount = i;
                    decoderCounters.skippedOutputBufferCount += this.buffersInCodecCount;
                    decoderCounters.skippedInputBufferCount = priorityQueue.size() + i;
                } else {
                    decoderCounters.droppedToKeyframeCount++;
                    updateDroppedBufferCounters(priorityQueue.size() + iSkipData, this.buffersInCodecCount);
                }
                if (this.codec != null) {
                    if (shouldReleaseCodecInsteadOfFlushing()) {
                        releaseCodec();
                        maybeInitCodecOrBypass();
                    } else if (shouldFlushCodec()) {
                        flushCodec();
                    } else {
                        this.hasSkippedFlushAndWaitingForQueueInputBuffer = true;
                    }
                }
                VideoSink videoSink = this.videoSink;
                if (videoSink != null) {
                    videoSink.flush(false);
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return hasSurfaceForCodec(mediaCodecInfo);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final boolean shouldReleaseCodecInsteadOfFlushing() {
        MediaCodecInfo mediaCodecInfo = this.codecInfo;
        if (this.videoSink != null && mediaCodecInfo != null) {
            String str = mediaCodecInfo.name;
            if (str.equals("c2.mtk.avc.decoder") || str.equals("c2.mtk.hevc.decoder")) {
                return true;
            }
        }
        return super.shouldReleaseCodecInsteadOfFlushing();
    }

    public final boolean shouldUsePlaceholderSurface(MediaCodecInfo mediaCodecInfo) {
        if (this.tunneling || codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name)) {
            return false;
        }
        return !mediaCodecInfo.secure || PlaceholderSurface.isSecureSupported();
    }

    public final void skipOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i) {
        Trace.beginSection("skipVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i);
        Trace.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final int supportsFormat$1(Format format) {
        boolean z;
        int i = 0;
        if (!MimeTypes.isVideo(format.sampleMimeType)) {
            return BaseRenderer.create(0, 0, 0, 0);
        }
        byte b = 1;
        boolean z2 = format.drmInitData != null;
        Context context = this.context;
        List decoderInfos = getDecoderInfos(context, format, z2, false);
        if (z2 && decoderInfos.isEmpty()) {
            decoderInfos = getDecoderInfos(context, format, false, false);
        }
        if (decoderInfos.isEmpty()) {
            return BaseRenderer.create(1, 0, 0, 0);
        }
        int i2 = format.cryptoType;
        if (i2 != 0 && i2 != 2) {
            return BaseRenderer.create(2, 0, 0, 0);
        }
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) decoderInfos.get(0);
        boolean zIsFormatSupported = mediaCodecInfo.isFormatSupported(context, format);
        if (!zIsFormatSupported) {
            int i3 = 1;
            while (true) {
                if (i3 >= decoderInfos.size()) {
                    z = true;
                    break;
                }
                MediaCodecInfo mediaCodecInfo2 = (MediaCodecInfo) decoderInfos.get(i3);
                if (mediaCodecInfo2.isFormatSupported(context, format)) {
                    z = false;
                    zIsFormatSupported = true;
                    mediaCodecInfo = mediaCodecInfo2;
                    break;
                }
                i3++;
            }
        } else {
            z = true;
            break;
        }
        int i4 = zIsFormatSupported ? 4 : 3;
        int i5 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        int i6 = mediaCodecInfo.hardwareAccelerated ? 64 : 0;
        int i7 = z ? 128 : 0;
        if ("video/dolby-vision".equals(format.sampleMimeType) && !LifecyclesKt.doesDisplaySupportDolbyVision(context)) {
            i7 = 256;
        }
        if (zIsFormatSupported) {
            List decoderInfos2 = getDecoderInfos(context, format, z2, true);
            if (!decoderInfos2.isEmpty()) {
                HashMap map = MediaCodecUtil.decoderInfosCache;
                ArrayList arrayList = new ArrayList(decoderInfos2);
                Collections.sort(arrayList, new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0(b, new TextLinkScope$$ExternalSyntheticLambda10((Object) context, (Object) format, (byte) 5)));
                MediaCodecInfo mediaCodecInfo3 = (MediaCodecInfo) arrayList.get(0);
                if (mediaCodecInfo3.isFormatSupported(context, format) && mediaCodecInfo3.isSeamlessAdaptationSupported(format)) {
                    i = 32;
                }
            }
        }
        return i4 | i5 | i | i6 | i7;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final boolean supportsResetPositionWithoutKeyFrameReset(long j) {
        if (this.largestQueuedPresentationTimeUs == -9223372036854775807L || j < this.lastResetToKeyFramePositionUs) {
            return false;
        }
        long j2 = this.lastProcessedOutputBufferTimeUs;
        return j2 == -9223372036854775807L || j > j2;
    }

    public final void updateDroppedBufferCounters(int i, int i2) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedInputBufferCount += i;
        int i3 = i + i2;
        decoderCounters.droppedBufferCount += i3;
        this.droppedFrames += i3;
        int i4 = this.consecutiveDroppedFrameCount + i3;
        this.consecutiveDroppedFrameCount = i4;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i4, decoderCounters.maxConsecutiveDroppedBufferCount);
        byte b = this.maxDroppedFramesToNotify;
        if (b <= 0 || this.droppedFrames < b) {
            return;
        }
        maybeNotifyDroppedFrames();
    }

    public final void updatePeriodDurationUs(MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        Timeline timeline = this.timeline;
        if (timeline.isEmpty()) {
            this.periodDurationUs = -9223372036854775807L;
            return;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaSource$MediaPeriodId.periodUid);
        if (indexOfPeriod == -1) {
            this.periodDurationUs = -9223372036854775807L;
        } else {
            this.periodDurationUs = timeline.getPeriod(indexOfPeriod, new Timeline.Period(), false).durationUs;
        }
    }

    public final void updateVideoFrameProcessingOffsetCounters(long j) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.totalVideoFrameProcessingOffsetUs += j;
        decoderCounters.videoFrameProcessingOffsetCount++;
        this.totalVideoFrameProcessingOffsetUs += j;
        this.videoFrameProcessingOffsetCount++;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final ArrayList getDecoderInfos(Format format, boolean z) {
        boolean z2 = this.tunneling;
        Context context = this.context;
        List decoderInfos = getDecoderInfos(context, format, z, z2);
        HashMap map = MediaCodecUtil.decoderInfosCache;
        ArrayList arrayList = new ArrayList(decoderInfos);
        Collections.sort(arrayList, new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0((byte) 1, new TextLinkScope$$ExternalSyntheticLambda10((Object) context, (Object) format, (byte) 5)));
        return arrayList;
    }
}

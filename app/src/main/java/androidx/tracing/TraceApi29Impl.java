package androidx.tracing;

import android.content.res.AssetFileDescriptor;
import android.graphics.ImageDecoder;
import android.graphics.Insets;
import android.graphics.Rect;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.os.Trace;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.view.View;
import android.view.WindowInsets;
import android.view.contentcapture.ContentCaptureSession;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatPopupWindow;
import androidx.core.graphics.TypefaceCompat$$ExternalSyntheticApiModelOutline1;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioCapabilities;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import coil3.decode.AssetMetadata;
import coil3.decode.ByteBufferMetadata;
import coil3.decode.ContentMetadata;
import coil3.decode.ImageSource;
import coil3.decode.ResourceMetadata;
import coil3.request.Options;
import coil3.util.FileSystemsKt;
import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.List;
import java.util.concurrent.Callable;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TraceApi29Impl {
    /* JADX WARN: Code duplicated, block: B:20:0x0040  */
    public static int areResolutionAndFrameRateCovered(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        boolean z;
        int i3;
        List<MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
        if (supportedPerformancePoints != null && !supportedPerformancePoints.isEmpty()) {
            TypefaceCompat$$ExternalSyntheticApiModelOutline1.m$3();
            MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint = new MediaCodecInfo.VideoCapabilities.PerformancePoint(i, i2, (int) d);
            int i4 = 0;
            while (true) {
                z = true;
                if (i4 >= supportedPerformancePoints.size()) {
                    i3 = 1;
                    break;
                }
                if (FrameworkMediaDrm$$ExternalSyntheticLambda0.m837m((Object) supportedPerformancePoints.get(i4)).covers(performancePoint)) {
                    i3 = 2;
                    break;
                }
                i4++;
            }
            if (i3 == 1 && FileSystemsKt.shouldIgnorePerformancePoints == null) {
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= 37) {
                    z = false;
                } else {
                    int iEvaluateH264RequiredSupport = evaluateH264RequiredSupport(true);
                    if (i5 < 35 ? !(evaluateH264RequiredSupport(false) != 2 || iEvaluateH264RequiredSupport == 1) : iEvaluateH264RequiredSupport != 1) {
                        z = false;
                    }
                }
                FileSystemsKt.shouldIgnorePerformancePoints = Boolean.valueOf(z);
                if (z) {
                }
            }
            return i3;
        }
        return 0;
    }

    public static void beginAsyncSection(String str) {
        Trace.beginAsyncSection(str, 0);
    }

    public static void computeFitSystemWindows(View view, Rect rect, Rect rect2) {
        Insets systemWindowInsets = view.computeSystemWindowInsets(new WindowInsets.Builder().setSystemWindowInsets(Insets.of(rect)).build(), rect2).getSystemWindowInsets();
        rect.set(systemWindowInsets.left, systemWindowInsets.top, systemWindowInsets.right, systemWindowInsets.bottom);
    }

    public static void endAsyncSection(int i, String str) {
        Trace.endAsyncSection(str, i);
    }

    public static int evaluateH264RequiredSupport(boolean z) {
        List<MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints;
        try {
            Format.Builder builder = new Format.Builder();
            builder.sampleMimeType = MimeTypes.normalizeMimeType("video/avc");
            Format format = new Format(builder);
            if (format.sampleMimeType != null) {
                RegularImmutableList decoderInfosSoftMatch = MediaCodecUtil.getDecoderInfosSoftMatch(format, z, false);
                for (int i = 0; i < decoderInfosSoftMatch.size; i++) {
                    MediaCodecInfo.VideoCapabilities videoCapabilities = ((androidx.media3.exoplayer.mediacodec.MediaCodecInfo) decoderInfosSoftMatch.get(i)).capabilities.getVideoCapabilities();
                    if (videoCapabilities != null && (supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints()) != null && !supportedPerformancePoints.isEmpty()) {
                        TypefaceCompat$$ExternalSyntheticApiModelOutline1.m$3();
                        MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint = new MediaCodecInfo.VideoCapabilities.PerformancePoint(1280, 720, 60);
                        for (int i2 = 0; i2 < supportedPerformancePoints.size(); i2++) {
                            if (FrameworkMediaDrm$$ExternalSyntheticLambda0.m837m((Object) supportedPerformancePoints.get(i2)).covers(performancePoint)) {
                                return 2;
                            }
                        }
                        return 1;
                    }
                }
            }
        } catch (MediaCodecUtil.DecoderQueryException unused) {
        }
        return 0;
    }

    public static ContentCaptureSession getContentCaptureSession(View view) {
        return view.getContentCaptureSession();
    }

    public static RegularImmutableList getDirectPlaybackSupportedEncodings(AudioAttributes audioAttributes) {
        ImmutableList.Builder builder = ImmutableList.builder();
        UnmodifiableIterator it = AudioCapabilities.ALL_SURROUND_ENCODINGS_AND_MAX_CHANNELS.keySet().iterator();
        while (true) {
            AbstractIndexedListIterator abstractIndexedListIterator = (AbstractIndexedListIterator) it;
            if (!abstractIndexedListIterator.hasNext()) {
                builder.add((Object) 2);
                return builder.build();
            }
            Integer num = (Integer) abstractIndexedListIterator.next();
            int iIntValue = num.intValue();
            if (Build.VERSION.SDK_INT >= Util.getApiLevelThatAudioFormatIntroducedAudioEncoding(iIntValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), audioAttributes.getPlatformAudioAttributes())) {
                builder.add((Object) num);
            }
        }
    }

    public static int getMaxSupportedChannelCountForPassthrough(int i, int i2, AudioAttributes audioAttributes) {
        for (int i3 = 10; i3 > 0; i3--) {
            int audioTrackChannelConfig = Util.getAudioTrackChannelConfig(i3);
            if (audioTrackChannelConfig != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(audioTrackChannelConfig).build(), audioAttributes.getPlatformAudioAttributes())) {
                return i3;
            }
        }
        return 0;
    }

    public static boolean isEnabled() {
        return Trace.isEnabled();
    }

    public static Insets of(int i, int i2, int i3, int i4) {
        return Insets.of(i, i2, i3, i4);
    }

    public static void setEpicenterBounds(AppCompatPopupWindow appCompatPopupWindow, Rect rect) {
        appCompatPopupWindow.setEpicenterBounds(rect);
    }

    public static void setIsClippedToScreen(AppCompatPopupWindow appCompatPopupWindow) {
        appCompatPopupWindow.setIsClippedToScreen(true);
    }

    public static void setTouchModal(PopupWindow popupWindow) {
        popupWindow.setTouchModal(false);
    }

    public static final ImageDecoder.Source toImageDecoderSourceOrNull(ImageSource imageSource, Options options) {
        Path pathFileOrNull;
        if (imageSource.getFileSystem() == FileSystem.SYSTEM && (pathFileOrNull = imageSource.fileOrNull()) != null) {
            return ImageDecoder.createSource(pathFileOrNull.toFile());
        }
        IntMath metadata = imageSource.getMetadata();
        if (metadata instanceof AssetMetadata) {
            return ImageDecoder.createSource(options.context.getAssets(), ((AssetMetadata) metadata).filePath);
        }
        if ((metadata instanceof ContentMetadata) && Build.VERSION.SDK_INT >= 29) {
            try {
                final AssetFileDescriptor assetFileDescriptor = ((ContentMetadata) metadata).assetFileDescriptor;
                Os.lseek(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), OsConstants.SEEK_SET);
                return ImageDecoder.createSource((Callable<AssetFileDescriptor>) new Callable() { // from class: coil3.decode.StaticImageDecoderKt$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return assetFileDescriptor;
                    }
                });
            } catch (ErrnoException unused) {
                return null;
            }
        }
        if (metadata instanceof ResourceMetadata) {
            ResourceMetadata resourceMetadata = (ResourceMetadata) metadata;
            if (resourceMetadata.packageName.equals(options.context.getPackageName())) {
                return ImageDecoder.createSource(options.context.getResources(), resourceMetadata.resId);
            }
        }
        if (metadata instanceof ByteBufferMetadata) {
            return ImageDecoder.createSource(((ByteBufferMetadata) metadata).byteBuffer);
        }
        return null;
    }

    public static final void traceValue(long j, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            Trace.setCounter(str, j);
        }
    }
}

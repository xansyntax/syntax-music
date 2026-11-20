package androidx.media3.extractor.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Trace;
import android.util.Log;
import android.view.Surface;
import androidx.compose.ui.platform.WeakCache;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.Lifecycle;
import androidx.media3.common.Format;
import androidx.media3.common.text.Cue;
import androidx.media3.decoder.Buffer;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.mediacodec.LoudnessCodecController;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.extractor.BinarySearchSeeker$SeekTimestampConverter;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.Id3Peeker;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ogg.OggSeeker;
import androidx.media3.extractor.text.dvb.DvbParser;
import androidx.media3.extractor.text.ssa.SsaParser;
import androidx.media3.extractor.text.subrip.SubripParser;
import androidx.media3.extractor.text.ttml.TtmlParser;
import androidx.media3.extractor.text.tx3g.Tx3gParser;
import androidx.media3.extractor.text.vobsub.VobsubParser;
import androidx.media3.session.MediaController;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.internal.NavContext;
import androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.materialkolor.quantize.QuantizerWu;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import kotlin.coroutines.CoroutineContext;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CueDecoder implements MediaCodecAdapter.Factory, SampleStream, BinarySearchSeeker$SeekTimestampConverter, ExtractorOutput, OggSeeker, MediaController.Listener, ProfileInstaller$DiagnosticsCallback, CoroutineContext.Key, SupportSQLiteOpenHelper.Factory {
    public static final CueDecoder UNSUPPORTED = new CueDecoder(16);
    public final /* synthetic */ byte $r8$classId;

    public CueDecoder(String str, float f, float f2) {
        this.$r8$classId = (byte) 29;
        str.getClass();
        if (f <= f2) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("min must be less than or equal to max");
        throw null;
    }

    public static NavBackStackEntry create$default(NavContext navContext, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavControllerViewModel navControllerViewModel) {
        String string = UUID.randomUUID().toString();
        string.getClass();
        navDestination.getClass();
        state.getClass();
        return new NavBackStackEntry(navContext, navDestination, bundle, state, navControllerViewModel, string, null);
    }

    public static MediaCodec createCodec(QuantizerWu quantizerWu) throws IOException {
        String str = ((MediaCodecInfo) quantizerWu.weights).name;
        Trace.beginSection("createCodec:" + str);
        MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
        Trace.endSection();
        return mediaCodecCreateByCodecName;
    }

    public static byte[] encode(ImmutableList immutableList, long j) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(immutableList.size());
        Iterator<E> it = immutableList.iterator();
        while (it.hasNext()) {
            Cue cue = (Cue) it.next();
            Bundle bundleWithoutBitmap = cue.toBundleWithoutBitmap();
            Bitmap bitmap = cue.bitmap;
            if (bitmap != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                UtilsKt.checkState(bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream));
                bundleWithoutBitmap.putByteArray(Cue.FIELD_BITMAP_BYTES, byteArrayOutputStream.toByteArray());
            }
            arrayList.add(bundleWithoutBitmap);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong("d", j);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    public SubtitleParser create(Format format) {
        switch (this.$r8$classId) {
            case 15:
                String str = format.sampleMimeType;
                List list = format.initializationData;
                if (str != null) {
                    switch (str) {
                        case "application/dvbsubs":
                            return new DvbParser(list);
                        case "application/pgs":
                            return new Dispatcher((byte) 12);
                        case "application/x-mp4-vtt":
                            return new Id3Peeker((byte) 1);
                        case "text/vtt":
                            return new WeakCache((byte) 29);
                        case "application/x-quicktime-tx3g":
                            return new Tx3gParser(list);
                        case "text/x-ssa":
                            return new SsaParser(list);
                        case "application/vobsub":
                            return new VobsubParser(list);
                        case "application/x-subrip":
                            return new SubripParser();
                        case "application/ttml+xml":
                            return new TtmlParser();
                    }
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m("Unsupported MIME type: ", str));
                return null;
            default:
                throw new IllegalStateException("This SubtitleParser.Factory doesn't support any formats.");
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Factory
    public MediaCodecAdapter createAdapter(QuantizerWu quantizerWu) throws Throwable {
        MediaCodec mediaCodecCreateCodec = null;
        try {
            mediaCodecCreateCodec = createCodec(quantizerWu);
            Trace.beginSection("configureCodec");
            Surface surface = (Surface) quantizerWu.momentsB;
            mediaCodecCreateCodec.configure((MediaFormat) quantizerWu.momentsR, surface, (MediaCrypto) quantizerWu.moments, (surface == null && ((MediaCodecInfo) quantizerWu.weights).detachedSurfaceSupported && Build.VERSION.SDK_INT >= 35) ? 8 : 0);
            Trace.endSection();
            Trace.beginSection("startCodec");
            mediaCodecCreateCodec.start();
            Trace.endSection();
            return new LoudnessCodecController(mediaCodecCreateCodec, (LoudnessCodecController) quantizerWu.cubes);
        } catch (IOException e) {
            e = e;
            if (mediaCodecCreateCodec != null) {
                mediaCodecCreateCodec.release();
            }
            throw e;
        } catch (RuntimeException e2) {
            e = e2;
            if (mediaCodecCreateCodec != null) {
                mediaCodecCreateCodec.release();
            }
            throw e;
        }
    }

    @Override // androidx.media3.extractor.ogg.OggSeeker
    public SeekMap createSeekMap() {
        return new SeekMap.Unseekable(-9223372036854775807L);
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void endTracks() {
        switch (this.$r8$classId) {
            case 8:
                throw new UnsupportedOperationException();
            default:
                return;
        }
    }

    public int getCueReplacementBehavior(Format format) {
        switch (this.$r8$classId) {
            case 15:
                String str = format.sampleMimeType;
                if (str != null) {
                    switch (str) {
                        case "application/dvbsubs":
                        case "application/pgs":
                        case "application/x-mp4-vtt":
                        case "application/x-quicktime-tx3g":
                        case "application/vobsub":
                            return 2;
                        case "text/vtt":
                        case "text/x-ssa":
                        case "application/x-subrip":
                        case "application/ttml+xml":
                            return 1;
                    }
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m("Unsupported MIME type: ", str));
                return 0;
            default:
                return 1;
        }
    }

    public int getMinimumLoadableRetryCount(int i) {
        return i == 7 ? 6 : 3;
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onResultReceived(int i, Object obj) {
        String str;
        switch (this.$r8$classId) {
            case 20:
                break;
            default:
                switch (i) {
                    case 1:
                        str = "RESULT_INSTALL_SUCCESS";
                        break;
                    case 2:
                        str = "RESULT_ALREADY_INSTALLED";
                        break;
                    case 3:
                        str = "RESULT_UNSUPPORTED_ART_VERSION";
                        break;
                    case 4:
                        str = "RESULT_NOT_WRITABLE";
                        break;
                    case 5:
                        str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                        break;
                    case 6:
                        str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                        break;
                    case 7:
                        str = "RESULT_IO_EXCEPTION";
                        break;
                    case 8:
                        str = "RESULT_PARSE_EXCEPTION";
                        break;
                    case 9:
                    default:
                        str = "";
                        break;
                    case 10:
                        str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                        break;
                    case 11:
                        str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                        break;
                }
                if (i == 6 || i == 7 || i == 8) {
                    Log.e("ProfileInstaller", str, (Throwable) obj);
                }
                break;
        }
    }

    @Override // androidx.media3.extractor.ogg.OggSeeker
    public long read(ExtractorInput extractorInput) {
        return -1L;
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public int readData(WeakCache weakCache, DecoderInputBuffer decoderInputBuffer, int i) {
        decoderInputBuffer.flags = 4;
        return -4;
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        switch (this.$r8$classId) {
            case 8:
                throw new UnsupportedOperationException();
            default:
                return;
        }
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public int skipData(long j) {
        return 0;
    }

    public boolean supportsFormat(Format format) {
        switch (this.$r8$classId) {
            case 15:
                String str = format.sampleMimeType;
                return Objects.equals(str, "text/x-ssa") || Objects.equals(str, "text/vtt") || Objects.equals(str, "application/x-mp4-vtt") || Objects.equals(str, "application/x-subrip") || Objects.equals(str, "application/x-quicktime-tx3g") || Objects.equals(str, "application/pgs") || Objects.equals(str, "application/vobsub") || Objects.equals(str, "application/dvbsubs") || Objects.equals(str, "application/ttml+xml");
            default:
                return false;
        }
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public TrackOutput track(int i, int i2) {
        switch (this.$r8$classId) {
            case 8:
                throw new UnsupportedOperationException();
            default:
                return new DiscardingTrackOutput();
        }
    }

    private final void endTracks$androidx$media3$extractor$NoOpExtractorOutput() {
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public void maybeThrowError() {
    }

    public /* synthetic */ CueDecoder(byte b) {
        this.$r8$classId = b;
    }

    private final void seekMap$androidx$media3$extractor$NoOpExtractorOutput(SeekMap seekMap) {
    }

    @Override // androidx.media3.extractor.ogg.OggSeeker
    public void startSeek(long j) {
    }

    @Override // androidx.media3.extractor.BinarySearchSeeker$SeekTimestampConverter
    public long timeUsToTargetTime(long j) {
        return j;
    }

    private final void onResultReceived$androidx$profileinstaller$ProfileInstaller$1(int i, Object obj) {
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(NavDeepLinkRequest navDeepLinkRequest) {
        return new FrameworkSQLiteOpenHelper((Context) navDeepLinkRequest.uri, (Buffer) navDeepLinkRequest.mimeType, (String) navDeepLinkRequest.action);
    }
}

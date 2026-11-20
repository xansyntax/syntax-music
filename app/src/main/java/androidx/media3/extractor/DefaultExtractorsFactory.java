package androidx.media3.extractor;

import android.net.Uri;
import androidx.compose.ui.platform.WeakCache;
import androidx.media3.common.FileTypes;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import androidx.media3.extractor.amr.AmrExtractor;
import androidx.media3.extractor.avi.AviExtractor;
import androidx.media3.extractor.avif.AvifExtractor;
import androidx.media3.extractor.bmp.BmpExtractor;
import androidx.media3.extractor.flac.FlacExtractor;
import androidx.media3.extractor.flv.FlvExtractor;
import androidx.media3.extractor.heif.HeifExtractor;
import androidx.media3.extractor.jpeg.JpegExtractor;
import androidx.media3.extractor.mkv.DefaultEbmlReader;
import androidx.media3.extractor.mkv.MatroskaExtractor;
import androidx.media3.extractor.mp3.Mp3Extractor;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.ogg.OggExtractor;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.extractor.ts.Ac3Extractor;
import androidx.media3.extractor.ts.Ac4Extractor;
import androidx.media3.extractor.ts.AdtsExtractor;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.extractor.wav.WavExtractor;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import io.ktor.http.HttpHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Dispatcher$promoteAndExecute$Effects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultExtractorsFactory implements ExtractorsFactory {
    public static final int[] DEFAULT_EXTRACTOR_ORDER = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};
    public static final WeakCache FLAC_EXTENSION_LOADER = new WeakCache(new FrameworkMediaDrm$$ExternalSyntheticLambda0((byte) 13));
    public static final WeakCache MIDI_EXTENSION_LOADER = new WeakCache(new FrameworkMediaDrm$$ExternalSyntheticLambda0((byte) 14));
    public byte codecsToParseWithinGopSampleDependencies;
    public boolean heifFlags;
    public boolean jpegFlags;
    public CueDecoder subtitleParserFactory;
    public boolean textTrackTranscodingEnabled;
    public RegularImmutableList tsSubtitleFormats;

    /* JADX WARN: Multi-variable type inference failed */
    public final void addExtractorsForFileType(int i, ArrayList arrayList) {
        switch (i) {
            case 0:
                arrayList.add(new Ac3Extractor());
                break;
            case 1:
                arrayList.add(new Ac4Extractor());
                break;
            case 2:
                arrayList.add(new AdtsExtractor());
                break;
            case 3:
                arrayList.add(new AmrExtractor());
                break;
            case 4:
                Extractor extractor = FLAC_EXTENSION_LOADER.getExtractor(0);
                if (extractor == null) {
                    arrayList.add(new FlacExtractor());
                } else {
                    arrayList.add(extractor);
                }
                break;
            case 5:
                arrayList.add(new FlvExtractor());
                break;
            case 6:
                arrayList.add(new MatroskaExtractor(new DefaultEbmlReader(), this.textTrackTranscodingEnabled ? 0 : 2, this.subtitleParserFactory));
                break;
            case 7:
                arrayList.add(new Mp3Extractor());
                break;
            case 8:
                CueDecoder cueDecoder = this.subtitleParserFactory;
                byte b = this.codecsToParseWithinGopSampleDependencies;
                int i2 = (b & 1) != 0 ? 64 : 0;
                if ((b & 2) != 0) {
                    i2 |= 128;
                }
                int i3 = (this.textTrackTranscodingEnabled ? 0 : 32) | i2;
                ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                arrayList.add(new FragmentedMp4Extractor(cueDecoder, i3, RegularImmutableList.EMPTY));
                CueDecoder cueDecoder2 = this.subtitleParserFactory;
                byte b2 = this.codecsToParseWithinGopSampleDependencies;
                int i4 = (b2 & 1) == 0 ? 0 : 32;
                if ((2 & b2) != 0) {
                    i4 |= 128;
                }
                arrayList.add(new Mp4Extractor(i4 | (this.textTrackTranscodingEnabled ? 0 : 16), cueDecoder2));
                break;
            case 9:
                arrayList.add(new OggExtractor());
                break;
            case 10:
                arrayList.add(new PsExtractor());
                break;
            case 11:
                if (this.tsSubtitleFormats == null) {
                    ImmutableList.Itr itr2 = ImmutableList.EMPTY_ITR;
                    this.tsSubtitleFormats = RegularImmutableList.EMPTY;
                }
                arrayList.add(new TsExtractor(!this.textTrackTranscodingEnabled ? 1 : 0, this.subtitleParserFactory, new TimestampAdjuster(0L), new Dispatcher$promoteAndExecute$Effects(this.tsSubtitleFormats)));
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                arrayList.add(new WavExtractor());
                break;
            case 14:
                arrayList.add(new JpegExtractor(this.jpegFlags ? 1 : 0));
                break;
            case 15:
                Extractor extractor2 = MIDI_EXTENSION_LOADER.getExtractor(new Object[0]);
                if (extractor2 != null) {
                    arrayList.add(extractor2);
                }
                break;
            case 16:
                arrayList.add(new AviExtractor(!this.textTrackTranscodingEnabled ? 1 : 0, this.subtitleParserFactory));
                break;
            case 17:
                arrayList.add(new BmpExtractor((byte) 1));
                break;
            case 18:
                arrayList.add(new AvifExtractor((byte) 1));
                break;
            case 19:
                arrayList.add(new BmpExtractor((byte) 0));
                break;
            case 20:
                arrayList.add(new HeifExtractor(this.heifFlags ? 1 : 0));
                break;
            case 21:
                arrayList.add(new AvifExtractor((byte) 0));
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:169:0x0248 A[Catch: all -> 0x024c, TRY_ENTER, TryCatch #0 {all -> 0x024c, blocks: (B:4:0x0003, B:6:0x0019, B:9:0x0020, B:169:0x0248, B:172:0x024e, B:175:0x0256, B:178:0x025c, B:181:0x0262, B:182:0x0265, B:183:0x0268, B:14:0x002d), top: B:188:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x025c A[Catch: all -> 0x024c, TryCatch #0 {all -> 0x024c, blocks: (B:4:0x0003, B:6:0x0019, B:9:0x0020, B:169:0x0248, B:172:0x024e, B:175:0x0256, B:178:0x025c, B:181:0x0262, B:182:0x0265, B:183:0x0268, B:14:0x002d), top: B:188:0x0003 }] */
    /* JADX WARN: switch over string: strings are not added: [[image/heic], [image/heif]] */
    @Override // androidx.media3.extractor.ExtractorsFactory
    public final synchronized Extractor[] createExtractors(Uri uri, Map map) {
        ArrayList arrayList;
        int i;
        int iInferFileTypeFromUri;
        int i2;
        int i3;
        try {
            int[] iArr = DEFAULT_EXTRACTOR_ORDER;
            arrayList = new ArrayList(21);
            List list = (List) map.get(HttpHeaders.ContentType);
            String str = (list == null || list.isEmpty()) ? null : (String) list.get(0);
            if (str != null) {
                String strNormalizeMimeType = MimeTypes.normalizeMimeType(str);
                strNormalizeMimeType.getClass();
                i = 20;
                switch (strNormalizeMimeType) {
                    case "audio/eac3-joc":
                    case "audio/ac3":
                    case "audio/eac3":
                        i = 0;
                        break;
                    case "video/mp2p":
                        i = 10;
                        break;
                    case "video/mp2t":
                        i = 11;
                        break;
                    case "video/webm":
                    case "audio/x-matroska":
                    case "application/webm":
                    case "audio/webm":
                    case "video/x-matroska":
                        i = 6;
                        break;
                    case "audio/amr-wb":
                    case "audio/amr":
                    case "audio/3gpp":
                        i = 3;
                        break;
                    case "image/avif":
                        i = 21;
                        break;
                    case "image/jpeg":
                        i = 14;
                        break;
                    case "image/webp":
                        i = 18;
                        break;
                    case "application/mp4":
                    case "audio/mp4":
                    case "video/mp4":
                        i = 8;
                        break;
                    case "video/x-msvideo":
                        i = 16;
                        break;
                    case "text/vtt":
                        i = 13;
                        break;
                    case "image/bmp":
                        i = 19;
                        break;
                    case "image/png":
                        i = 17;
                        break;
                    case "video/x-flv":
                        i = 5;
                        break;
                    case "audio/ac4":
                        i = 1;
                        break;
                    case "audio/ogg":
                        i = 9;
                        break;
                    case "audio/wav":
                        i = 12;
                        break;
                    case "audio/flac":
                        i = 4;
                        break;
                    case "audio/midi":
                        i = 15;
                        break;
                    case "audio/mpeg":
                        i = 7;
                        break;
                }
                if (i != -1) {
                    addExtractorsForFileType(i, arrayList);
                }
                iInferFileTypeFromUri = FileTypes.inferFileTypeFromUri(uri);
                if (iInferFileTypeFromUri != -1 && iInferFileTypeFromUri != i) {
                    addExtractorsForFileType(iInferFileTypeFromUri, arrayList);
                }
                for (i2 = 0; i2 < 21; i2++) {
                    i3 = iArr[i2];
                    if (i3 == i && i3 != iInferFileTypeFromUri) {
                        addExtractorsForFileType(i3, arrayList);
                    }
                }
            }
            i = -1;
            if (i != -1) {
                addExtractorsForFileType(i, arrayList);
            }
            iInferFileTypeFromUri = FileTypes.inferFileTypeFromUri(uri);
            if (iInferFileTypeFromUri != -1) {
                addExtractorsForFileType(iInferFileTypeFromUri, arrayList);
            }
            while (i2 < 21) {
                i3 = iArr[i2];
                if (i3 == i) {
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (Extractor[]) arrayList.toArray(new Extractor[0]);
    }

    @Override // androidx.media3.extractor.ExtractorsFactory
    public final void experimentalSetCodecsToParseWithinGopSampleDependencies() {
        synchronized (this) {
            this.codecsToParseWithinGopSampleDependencies = (byte) 3;
        }
    }

    @Override // androidx.media3.extractor.ExtractorsFactory
    public final void experimentalSetTextTrackTranscodingEnabled() {
        synchronized (this) {
            this.textTrackTranscodingEnabled = true;
        }
    }

    @Override // androidx.media3.extractor.ExtractorsFactory
    public final void setSubtitleParserFactory(CueDecoder cueDecoder) {
        synchronized (this) {
            this.subtitleParserFactory = cueDecoder;
        }
    }

    @Override // androidx.media3.extractor.ExtractorsFactory
    public final synchronized Extractor[] createExtractors() {
        return createExtractors(Uri.EMPTY, new HashMap());
    }
}

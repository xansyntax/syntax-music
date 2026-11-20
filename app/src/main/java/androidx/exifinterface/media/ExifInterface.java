package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.util.LifecyclesKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExifInterface {
    public static final Charset ASCII;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2;
    public static final int[] BITS_PER_SAMPLE_RGB;
    public static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN;
    public static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN;
    public static final boolean DEBUG = Log.isLoggable("ExifInterface", 3);
    public static final byte[] EXIF_ASCII_PREFIX;
    public static final ExifTag[] EXIF_POINTER_TAGS;
    public static final ExifTag[][] EXIF_TAGS;
    public static final Pattern GPS_TIMESTAMP_PATTERN;
    public static final byte[] HEIF_BRAND_AVIF;
    public static final byte[] HEIF_BRAND_AVIS;
    public static final byte[] HEIF_BRAND_HEIC;
    public static final byte[] HEIF_BRAND_MIF1;
    public static final byte[] HEIF_TYPE_FTYP;
    public static final byte[] IDENTIFIER_EXIF_APP1;
    public static final byte[] IDENTIFIER_XMP_APP1;
    public static final int[] IFD_FORMAT_BYTES_PER_FORMAT;
    public static final String[] IFD_FORMAT_NAMES;
    public static final byte[] JPEG_SIGNATURE;
    public static final byte[] ORF_MAKER_NOTE_HEADER_1;
    public static final byte[] ORF_MAKER_NOTE_HEADER_2;
    public static final byte[] PNG_ITXT_XMP_KEYWORD;
    public static final byte[] PNG_SIGNATURE;
    public static final Set RATIONAL_TAGS_HANDLED_AS_DECIMALS_FOR_COMPATIBILITY;
    public static final ExifTag TAG_RAF_IMAGE_SIZE;
    public static final byte[] WEBP_CHUNK_TYPE_ANIM;
    public static final byte[] WEBP_CHUNK_TYPE_ANMF;
    public static final byte[] WEBP_CHUNK_TYPE_EXIF;
    public static final byte[] WEBP_CHUNK_TYPE_VP8;
    public static final byte[] WEBP_CHUNK_TYPE_VP8L;
    public static final byte[] WEBP_CHUNK_TYPE_VP8X;
    public static final byte[] WEBP_SIGNATURE_1;
    public static final byte[] WEBP_SIGNATURE_2;
    public static final byte[] WEBP_VP8_SIGNATURE;
    public static final HashMap sExifPointerTagMap;
    public static final HashMap[] sExifTagMapsForReading;
    public static final HashMap[] sExifTagMapsForWriting;
    public boolean mAreThumbnailStripsConsecutive;
    public final AssetManager.AssetInputStream mAssetInputStream;
    public final HashMap[] mAttributes;
    public final HashSet mAttributesOffsets;
    public ByteOrder mExifByteOrder;
    public boolean mFileOnDiskContainsSeparateXmpMarker;
    public final String mFilename;
    public boolean mHasThumbnail;
    public boolean mHasThumbnailStrips;
    public final boolean mIsExifDataOnly;
    public int mMimeType;
    public int mOffsetToExifData;
    public int mOrfMakerNoteOffset;
    public int mOrfThumbnailLength;
    public int mOrfThumbnailOffset;
    public final FileDescriptor mSeekableFileDescriptor;
    public byte[] mThumbnailBytes;
    public int mThumbnailCompression;
    public int mThumbnailLength;
    public int mThumbnailOffset;
    public ExifAttribute mXmpFromSeparateMarker;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Rational {
        public final long denominator;
        public final long numerator;

        public Rational(long j, long j2) {
            if (j2 == 0) {
                this.numerator = 0L;
                this.denominator = 1L;
            } else {
                this.numerator = j;
                this.denominator = j2;
            }
        }

        public final String toString() {
            return this.numerator + "/" + this.denominator;
        }
    }

    static {
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        BITS_PER_SAMPLE_RGB = new int[]{8, 8, 8};
        BITS_PER_SAMPLE_GREYSCALE_2 = new int[]{8};
        JPEG_SIGNATURE = new byte[]{-1, -40, -1};
        HEIF_TYPE_FTYP = new byte[]{102, 116, 121, 112};
        HEIF_BRAND_MIF1 = new byte[]{109, 105, 102, 49};
        HEIF_BRAND_HEIC = new byte[]{104, 101, 105, 99};
        HEIF_BRAND_AVIF = new byte[]{97, 118, 105, 102};
        HEIF_BRAND_AVIS = new byte[]{97, 118, 105, 115};
        ORF_MAKER_NOTE_HEADER_1 = new byte[]{79, 76, 89, 77, 80, 0};
        ORF_MAKER_NOTE_HEADER_2 = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        PNG_SIGNATURE = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        PNG_ITXT_XMP_KEYWORD = "XML:com.adobe.xmp\u0000\u0000\u0000\u0000\u0000".getBytes(StandardCharsets.UTF_8);
        WEBP_SIGNATURE_1 = new byte[]{82, 73, 70, 70};
        WEBP_SIGNATURE_2 = new byte[]{87, 69, 66, 80};
        WEBP_CHUNK_TYPE_EXIF = new byte[]{69, 88, 73, 70};
        WEBP_VP8_SIGNATURE = new byte[]{-99, 1, 42};
        WEBP_CHUNK_TYPE_VP8X = "VP8X".getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_VP8L = "VP8L".getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_VP8 = "VP8 ".getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes(Charset.defaultCharset());
        IFD_FORMAT_NAMES = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        IFD_FORMAT_BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        EXIF_ASCII_PREFIX = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        ExifTag[] exifTagArr = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag(256, 3, 4, "ImageWidth"), new ExifTag(257, 3, 4, "ImageLength"), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag(273, 3, 4, "StripOffsets"), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag(278, 3, 4, "RowsPerStrip"), new ExifTag(279, 3, 4, "StripByteCounts"), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("SensorTopBorder", 4, 4), new ExifTag("SensorLeftBorder", 5, 4), new ExifTag("SensorBottomBorder", 6, 4), new ExifTag("SensorRightBorder", 7, 4), new ExifTag("ISO", 23, 3), new ExifTag("JpgFromRaw", 46, 7), new ExifTag("Xmp", 700, 1)};
        ExifTag[] exifTagArr2 = {new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("SpectralSensitivity", 34852, 2), new ExifTag("PhotographicSensitivity", 34855, 3), new ExifTag("OECF", 34856, 7), new ExifTag("SensitivityType", 34864, 3), new ExifTag("StandardOutputSensitivity", 34865, 4), new ExifTag("RecommendedExposureIndex", 34866, 4), new ExifTag("ISOSpeed", 34867, 4), new ExifTag("ISOSpeedLatitudeyyy", 34868, 4), new ExifTag("ISOSpeedLatitudezzz", 34869, 4), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", 36867, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag("OffsetTime", 36880, 2), new ExifTag("OffsetTimeOriginal", 36881, 2), new ExifTag("OffsetTimeDigitized", 36882, 2), new ExifTag("ComponentsConfiguration", 37121, 7), new ExifTag("CompressedBitsPerPixel", 37122, 5), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("SubjectDistance", 37382, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag("SubjectArea", 37396, 3), new ExifTag("MakerNote", 37500, 7), new ExifTag("UserComment", 37510, 7), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", 40961, 3), new ExifTag(40962, 3, 4, "PixelXDimension"), new ExifTag(40963, 3, 4, "PixelYDimension"), new ExifTag("RelatedSoundFile", 40964, 2), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("FlashEnergy", 41483, 5), new ExifTag("SpatialFrequencyResponse", 41484, 7), new ExifTag("FocalPlaneXResolution", 41486, 5), new ExifTag("FocalPlaneYResolution", 41487, 5), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SubjectLocation", 41492, 3), new ExifTag("ExposureIndex", 41493, 5), new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CFAPattern", 41730, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", 41987, 3), new ExifTag("DigitalZoomRatio", 41988, 5), new ExifTag("FocalLengthIn35mmFilm", 41989, 3), new ExifTag("SceneCaptureType", 41990, 3), new ExifTag("GainControl", 41991, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", 41993, 3), new ExifTag("Sharpness", 41994, 3), new ExifTag("DeviceSettingDescription", 41995, 7), new ExifTag("SubjectDistanceRange", 41996, 3), new ExifTag("ImageUniqueID", 42016, 2), new ExifTag("CameraOwnerName", 42032, 2), new ExifTag("BodySerialNumber", 42033, 2), new ExifTag("LensSpecification", 42034, 5), new ExifTag("LensMake", 42035, 2), new ExifTag("LensModel", 42036, 2), new ExifTag("Gamma", 42240, 5), new ExifTag("DNGVersion", 50706, 1), new ExifTag(50720, 3, 4, "DefaultCropSize")};
        ExifTag[] exifTagArr3 = {new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag(2, 5, 10, "GPSLatitude"), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag(4, 5, 10, "GPSLongitude"), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSatellites", 8, 2), new ExifTag("GPSStatus", 9, 2), new ExifTag("GPSMeasureMode", 10, 2), new ExifTag("GPSDOP", 11, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSSpeed", 13, 5), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSTrack", 15, 5), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSImgDirection", 17, 5), new ExifTag("GPSMapDatum", 18, 2), new ExifTag("GPSDestLatitudeRef", 19, 2), new ExifTag("GPSDestLatitude", 20, 5), new ExifTag("GPSDestLongitudeRef", 21, 2), new ExifTag("GPSDestLongitude", 22, 5), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestBearing", 24, 5), new ExifTag("GPSDestDistanceRef", 25, 2), new ExifTag("GPSDestDistance", 26, 5), new ExifTag("GPSProcessingMethod", 27, 7), new ExifTag("GPSAreaInformation", 28, 7), new ExifTag("GPSDateStamp", 29, 2), new ExifTag("GPSDifferential", 30, 3), new ExifTag("GPSHPositioningError", 31, 5)};
        ExifTag[] exifTagArr4 = {new ExifTag("InteroperabilityIndex", 1, 2)};
        ExifTag[] exifTagArr5 = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag(256, 3, 4, "ThumbnailImageWidth"), new ExifTag(257, 3, 4, "ThumbnailImageLength"), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag(273, 3, 4, "StripOffsets"), new ExifTag("ThumbnailOrientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag(278, 3, 4, "RowsPerStrip"), new ExifTag(279, 3, 4, "StripByteCounts"), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("DNGVersion", 50706, 1), new ExifTag(50720, 3, 4, "DefaultCropSize")};
        TAG_RAF_IMAGE_SIZE = new ExifTag("StripOffsets", 273, 3);
        EXIF_TAGS = new ExifTag[][]{exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5, exifTagArr, new ExifTag[]{new ExifTag("ThumbnailImage", 256, 7), new ExifTag("CameraSettingsIFDPointer", 8224, 4), new ExifTag("ImageProcessingIFDPointer", 8256, 4)}, new ExifTag[]{new ExifTag("PreviewImageStart", 257, 4), new ExifTag("PreviewImageLength", 258, 4)}, new ExifTag[]{new ExifTag("AspectFrame", 4371, 3)}, new ExifTag[]{new ExifTag("ColorSpace", 55, 3)}};
        EXIF_POINTER_TAGS = new ExifTag[]{new ExifTag("SubIFDPointer", 330, 4), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("CameraSettingsIFDPointer", 8224, 1), new ExifTag("ImageProcessingIFDPointer", 8256, 1)};
        sExifTagMapsForReading = new HashMap[10];
        sExifTagMapsForWriting = new HashMap[10];
        RATIONAL_TAGS_HANDLED_AS_DECIMALS_FOR_COMPATIBILITY = Collections.unmodifiableSet(new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance")));
        sExifPointerTagMap = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        ASCII = charsetForName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(charsetForName);
        IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            ExifTag[][] exifTagArr6 = EXIF_TAGS;
            if (i >= exifTagArr6.length) {
                HashMap map = sExifPointerTagMap;
                ExifTag[] exifTagArr7 = EXIF_POINTER_TAGS;
                map.put(Integer.valueOf(exifTagArr7[0].number), 5);
                map.put(Integer.valueOf(exifTagArr7[1].number), 1);
                map.put(Integer.valueOf(exifTagArr7[2].number), 2);
                map.put(Integer.valueOf(exifTagArr7[3].number), 3);
                map.put(Integer.valueOf(exifTagArr7[4].number), 7);
                map.put(Integer.valueOf(exifTagArr7[5].number), 8);
                Pattern.compile(".*[1-9].*");
                GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            sExifTagMapsForReading[i] = new HashMap();
            sExifTagMapsForWriting[i] = new HashMap();
            for (ExifTag exifTag : exifTagArr6[i]) {
                sExifTagMapsForReading[i].put(Integer.valueOf(exifTag.number), exifTag);
                sExifTagMapsForWriting[i].put(exifTag.name, exifTag);
            }
            i++;
        }
    }

    public ExifInterface(FileDescriptor fileDescriptor) throws Throwable {
        boolean z;
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        FileInputStream fileInputStream = null;
        if (fileDescriptor == null) {
            PathKt$$ExternalSyntheticBUOutline0.m("fileDescriptor cannot be null");
            throw null;
        }
        this.mAssetInputStream = null;
        this.mFilename = null;
        try {
            Os.lseek(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            this.mSeekableFileDescriptor = fileDescriptor;
            try {
                fileDescriptor = Os.dup(fileDescriptor);
                z = true;
            } catch (Exception e) {
                throw new IOException("Failed to duplicate file descriptor", e);
            }
        } catch (Exception unused) {
            this.mSeekableFileDescriptor = null;
            z = false;
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(fileDescriptor);
            try {
                loadAttributes(fileInputStream2);
                LifecyclesKt.closeQuietly(fileInputStream2);
                if (z) {
                    LifecyclesKt.closeFileDescriptor(fileDescriptor);
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                LifecyclesKt.closeQuietly(fileInputStream);
                if (z) {
                    LifecyclesKt.closeFileDescriptor(fileDescriptor);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Pair guessDataFormat(String str) {
        if (str.contains(",")) {
            String[] strArrSplit = str.split(",", -1);
            Pair pairGuessDataFormat = guessDataFormat(strArrSplit[0]);
            if (((Integer) pairGuessDataFormat.first).intValue() == 2) {
                return pairGuessDataFormat;
            }
            for (int i = 1; i < strArrSplit.length; i++) {
                Pair pairGuessDataFormat2 = guessDataFormat(strArrSplit[i]);
                int iIntValue = (((Integer) pairGuessDataFormat2.first).equals(pairGuessDataFormat.first) || ((Integer) pairGuessDataFormat2.second).equals(pairGuessDataFormat.first)) ? ((Integer) pairGuessDataFormat.first).intValue() : -1;
                int iIntValue2 = (((Integer) pairGuessDataFormat.second).intValue() == -1 || !(((Integer) pairGuessDataFormat2.first).equals(pairGuessDataFormat.second) || ((Integer) pairGuessDataFormat2.second).equals(pairGuessDataFormat.second))) ? -1 : ((Integer) pairGuessDataFormat.second).intValue();
                if (iIntValue == -1 && iIntValue2 == -1) {
                    return new Pair(2, -1);
                }
                if (iIntValue == -1) {
                    pairGuessDataFormat = new Pair(Integer.valueOf(iIntValue2), -1);
                } else if (iIntValue2 == -1) {
                    pairGuessDataFormat = new Pair(Integer.valueOf(iIntValue), -1);
                }
            }
            return pairGuessDataFormat;
        }
        if (!str.contains("/")) {
            try {
                try {
                    long j = Long.parseLong(str);
                    if (j < 0 || j > 65535) {
                        return j < 0 ? new Pair(9, -1) : new Pair(4, -1);
                    }
                    return new Pair(3, 4);
                } catch (NumberFormatException unused) {
                    return new Pair(2, -1);
                }
            } catch (NumberFormatException unused2) {
                Double.parseDouble(str);
                return new Pair(12, -1);
            }
        }
        String[] strArrSplit2 = str.split("/", -1);
        if (strArrSplit2.length == 2) {
            try {
                long j2 = (long) Double.parseDouble(strArrSplit2[0]);
                long j3 = (long) Double.parseDouble(strArrSplit2[1]);
                if (j2 >= 0 && j3 >= 0) {
                    if (j2 <= 2147483647L && j3 <= 2147483647L) {
                        return new Pair(10, 5);
                    }
                    return new Pair(5, -1);
                }
                return new Pair(10, -1);
            } catch (NumberFormatException unused3) {
            }
        }
        return new Pair(2, -1);
    }

    public static ByteOrder readByteOrder(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short s = byteOrderedDataInputStream.readShort();
        if (s == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$5(Integer.toHexString(s), "Invalid byte order: ");
        return null;
    }

    public final void addDefaultValuesForCompatibility() {
        String attribute = getAttribute("DateTimeOriginal");
        HashMap[] mapArr = this.mAttributes;
        if (attribute != null && getAttribute("DateTime") == null) {
            mapArr[0].put("DateTime", ExifAttribute.createString(attribute));
        }
        if (getAttribute("ImageWidth") == null) {
            mapArr[0].put("ImageWidth", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute("ImageLength") == null) {
            mapArr[0].put("ImageLength", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute("Orientation") == null) {
            mapArr[0].put("Orientation", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute("LightSource") == null) {
            mapArr[1].put("LightSource", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
    }

    public final String getAttribute(String str) {
        if (str == null) {
            PathKt$$ExternalSyntheticBUOutline0.m("tag shouldn't be null");
            return null;
        }
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            int i = exifAttribute.format;
            if (str.equals("GPSTimeStamp")) {
                if (i != 5 && i != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + i);
                    return null;
                }
                Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                if (rationalArr == null || rationalArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr));
                    return null;
                }
                Rational rational = rationalArr[0];
                Integer numValueOf = Integer.valueOf((int) (rational.numerator / rational.denominator));
                Rational rational2 = rationalArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (rational2.numerator / rational2.denominator));
                Rational rational3 = rationalArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (rational3.numerator / rational3.denominator)));
            }
            boolean zContains = RATIONAL_TAGS_HANDLED_AS_DECIMALS_FOR_COMPATIBILITY.contains(str);
            ByteOrder byteOrder = this.mExifByteOrder;
            if (!zContains) {
                return exifAttribute.getStringValue(byteOrder);
            }
            try {
                return Double.toString(exifAttribute.getDoubleValue(byteOrder));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final ExifAttribute getExifAttribute(String str) {
        ExifAttribute exifAttribute;
        int i;
        ExifAttribute exifAttribute2;
        if (str == null) {
            PathKt$$ExternalSyntheticBUOutline0.m("tag shouldn't be null");
            return null;
        }
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        if ("Xmp".equals(str) && (i = this.mMimeType) != 4 && ((i == 9 || i == 15 || i == 12 || i == 13) && (exifAttribute2 = this.mXmpFromSeparateMarker) != null)) {
            return exifAttribute2;
        }
        for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
            ExifAttribute exifAttribute3 = (ExifAttribute) this.mAttributes[i2].get(str);
            if (exifAttribute3 != null) {
                return exifAttribute3;
            }
        }
        if (!"Xmp".equals(str) || (exifAttribute = this.mXmpFromSeparateMarker) == null) {
            return null;
        }
        return exifAttribute;
    }

    public final void getHeifAttributes(final SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i) {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        int i2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 28) {
            PathKt$$ExternalSyntheticBUOutline0.m$2("Reading EXIF from HEIC files is supported from SDK 28 and above");
            return;
        }
        if (i == 15 && i3 < 31) {
            PathKt$$ExternalSyntheticBUOutline0.m$2("Reading EXIF from AVIF files is supported from SDK 31 and above");
            return;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(new MediaDataSource() { // from class: androidx.exifinterface.media.ExifInterface.1
                    public long mPosition;

                    @Override // android.media.MediaDataSource
                    public final long getSize() {
                        return -1L;
                    }

                    @Override // android.media.MediaDataSource
                    public final int readAt(long j, byte[] bArr, int i4, int i5) {
                        SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = seekableByteOrderedDataInputStream;
                        DataInputStream dataInputStream = seekableByteOrderedDataInputStream2.mDataInputStream;
                        if (i5 == 0) {
                            return 0;
                        }
                        if (j >= 0) {
                            try {
                                long j2 = this.mPosition;
                                if (j2 != j) {
                                    if (j2 < 0 || j < j2 + ((long) dataInputStream.available())) {
                                        seekableByteOrderedDataInputStream2.seek(j);
                                        this.mPosition = j;
                                    }
                                }
                                if (i5 > dataInputStream.available()) {
                                    i5 = dataInputStream.available();
                                }
                                int i6 = seekableByteOrderedDataInputStream2.read(bArr, i4, i5);
                                if (i6 >= 0) {
                                    this.mPosition += (long) i6;
                                    return i6;
                                }
                            } catch (IOException unused) {
                            }
                            this.mPosition = -1L;
                            return -1;
                        }
                        return -1;
                    }

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public final void close() {
                    }
                });
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                HashMap[] mapArr = this.mAttributes;
                if (strExtractMetadata != null) {
                    mapArr[0].put("ImageWidth", ExifAttribute.createUShort(Integer.parseInt(strExtractMetadata), this.mExifByteOrder));
                }
                if (strExtractMetadata3 != null) {
                    mapArr[0].put("ImageLength", ExifAttribute.createUShort(Integer.parseInt(strExtractMetadata3), this.mExifByteOrder));
                }
                if (strExtractMetadata2 != null) {
                    int i4 = Integer.parseInt(strExtractMetadata2);
                    if (i4 == 90) {
                        i2 = 6;
                    } else if (i4 != 180) {
                        i2 = i4 != 270 ? 1 : 8;
                    } else {
                        i2 = 3;
                    }
                    mapArr[0].put("Orientation", ExifAttribute.createUShort(i2, this.mExifByteOrder));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i5 = Integer.parseInt(strExtractMetadata4);
                    int i6 = Integer.parseInt(strExtractMetadata5);
                    if (i6 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    seekableByteOrderedDataInputStream.seek(i5);
                    byte[] bArr = new byte[6];
                    seekableByteOrderedDataInputStream.readFully(bArr);
                    int i7 = i5 + 6;
                    int i8 = i6 - 6;
                    if (!Arrays.equals(bArr, IDENTIFIER_EXIF_APP1)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i8];
                    seekableByteOrderedDataInputStream.readFully(bArr2);
                    this.mOffsetToExifData = i7;
                    readExifSegment(bArr2, 0);
                }
                String strExtractMetadata8 = mediaMetadataRetriever.extractMetadata(41);
                String strExtractMetadata9 = mediaMetadataRetriever.extractMetadata(42);
                if (strExtractMetadata8 != null && strExtractMetadata9 != null) {
                    int i9 = Integer.parseInt(strExtractMetadata8);
                    int i10 = Integer.parseInt(strExtractMetadata9);
                    long j = i9;
                    seekableByteOrderedDataInputStream.seek(j);
                    byte[] bArr3 = new byte[i10];
                    seekableByteOrderedDataInputStream.readFully(bArr3);
                    this.mXmpFromSeparateMarker = new ExifAttribute(j, bArr3, 1, i10);
                    this.mFileOnDiskContainsSeparateXmpMarker = true;
                }
                try {
                    mediaMetadataRetriever.release();
                } catch (IOException unused) {
                }
            } catch (RuntimeException e) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.", e);
            }
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
                throw th;
            } catch (IOException unused2) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x006e A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:37:0x0076  */
    /* JADX WARN: Code duplicated, block: B:38:0x0079  */
    /* JADX WARN: Code duplicated, block: B:41:0x008d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x010c A[LOOP:0: B:10:0x0023->B:56:0x010c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x0060. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x0063. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0066. Please report as an issue. */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public final void getJpegAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r20, int r21, int r22) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getJpegAttributes(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    public final int getMimeType(BufferedInputStream bufferedInputStream) throws Throwable {
        int i;
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        int i2;
        ByteOrderedDataInputStream byteOrderedDataInputStream2;
        int i3;
        int i4;
        long j;
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        int i5 = 0;
        while (true) {
            byte[] bArr2 = JPEG_SIGNATURE;
            if (i5 >= bArr2.length) {
                return 4;
            }
            if (bArr[i5] != bArr2[i5]) {
                byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
                for (int i6 = 0; i6 < bytes.length; i6++) {
                    if (bArr[i6] != bytes[i6]) {
                        ByteOrderedDataInputStream byteOrderedDataInputStream3 = null;
                        try {
                            byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
                            try {
                                try {
                                    long j2 = byteOrderedDataInputStream.readInt();
                                    byte[] bArr3 = new byte[4];
                                    byteOrderedDataInputStream.readFully(bArr3);
                                    if (Arrays.equals(bArr3, HEIF_TYPE_FTYP)) {
                                        if (j2 == 1) {
                                            j2 = byteOrderedDataInputStream.readLong();
                                            j = 16;
                                            if (j2 < 16) {
                                            }
                                            byteOrderedDataInputStream.close();
                                            i = 0;
                                            i2 = 0;
                                        } else {
                                            j = 8;
                                        }
                                        if (j2 > 5000) {
                                            j2 = 5000;
                                        }
                                        long j3 = j2 - j;
                                        if (j3 < 8) {
                                            byteOrderedDataInputStream.close();
                                            i = 0;
                                            i2 = 0;
                                        } else {
                                            byte[] bArr4 = new byte[4];
                                            long j4 = 0;
                                            boolean z = false;
                                            boolean z2 = false;
                                            boolean z3 = false;
                                            while (true) {
                                                if (j4 < j3 / 4) {
                                                    try {
                                                        byteOrderedDataInputStream.readFully(bArr4);
                                                        if (j4 != 1) {
                                                            i = 0;
                                                            try {
                                                                if (Arrays.equals(bArr4, HEIF_BRAND_MIF1)) {
                                                                    z = true;
                                                                } else if (Arrays.equals(bArr4, HEIF_BRAND_HEIC)) {
                                                                    z2 = true;
                                                                } else if (Arrays.equals(bArr4, HEIF_BRAND_AVIF) || Arrays.equals(bArr4, HEIF_BRAND_AVIS)) {
                                                                    z3 = true;
                                                                }
                                                                if (!z) {
                                                                    continue;
                                                                } else if (z2) {
                                                                    byteOrderedDataInputStream.close();
                                                                    i2 = 12;
                                                                } else if (z3) {
                                                                    byteOrderedDataInputStream.close();
                                                                    i2 = 15;
                                                                }
                                                            } catch (Exception unused) {
                                                                if (byteOrderedDataInputStream != null) {
                                                                    byteOrderedDataInputStream.close();
                                                                }
                                                                i2 = i;
                                                            }
                                                        }
                                                        j4++;
                                                    } catch (EOFException unused2) {
                                                        i = 0;
                                                        byteOrderedDataInputStream.close();
                                                        i2 = i;
                                                    }
                                                } else {
                                                    i = 0;
                                                }
                                                byteOrderedDataInputStream.close();
                                                i2 = i;
                                            }
                                        }
                                    } else {
                                        byteOrderedDataInputStream.close();
                                        i = 0;
                                        i2 = 0;
                                    }
                                } catch (Exception unused3) {
                                    i = 0;
                                }
                            } catch (Throwable th) {
                                th = th;
                                byteOrderedDataInputStream3 = byteOrderedDataInputStream;
                                if (byteOrderedDataInputStream3 != null) {
                                    byteOrderedDataInputStream3.close();
                                }
                                throw th;
                            }
                        } catch (Exception unused4) {
                            i = 0;
                            byteOrderedDataInputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (i2 != 0) {
                            return i2;
                        }
                        try {
                            byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(bArr);
                            try {
                                ByteOrder byteOrder = readByteOrder(byteOrderedDataInputStream2);
                                this.mExifByteOrder = byteOrder;
                                byteOrderedDataInputStream2.mByteOrder = byteOrder;
                                short s = byteOrderedDataInputStream2.readShort();
                                i3 = (s == 20306 || s == 21330) ? 1 : i;
                                byteOrderedDataInputStream2.close();
                            } catch (Exception unused5) {
                                if (byteOrderedDataInputStream2 != null) {
                                    byteOrderedDataInputStream2.close();
                                }
                                i3 = i;
                            } catch (Throwable th3) {
                                th = th3;
                                byteOrderedDataInputStream3 = byteOrderedDataInputStream2;
                                if (byteOrderedDataInputStream3 != null) {
                                    byteOrderedDataInputStream3.close();
                                }
                                throw th;
                            }
                        } catch (Exception unused6) {
                            byteOrderedDataInputStream2 = null;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        if (i3 != 0) {
                            return 7;
                        }
                        try {
                            ByteOrderedDataInputStream byteOrderedDataInputStream4 = new ByteOrderedDataInputStream(bArr);
                            try {
                                ByteOrder byteOrder2 = readByteOrder(byteOrderedDataInputStream4);
                                this.mExifByteOrder = byteOrder2;
                                byteOrderedDataInputStream4.mByteOrder = byteOrder2;
                                i4 = byteOrderedDataInputStream4.readShort() != 85 ? i : 1;
                                byteOrderedDataInputStream4.close();
                            } catch (Exception unused7) {
                                byteOrderedDataInputStream3 = byteOrderedDataInputStream4;
                                if (byteOrderedDataInputStream3 != null) {
                                    byteOrderedDataInputStream3.close();
                                }
                                i4 = i;
                            } catch (Throwable th5) {
                                th = th5;
                                byteOrderedDataInputStream3 = byteOrderedDataInputStream4;
                                if (byteOrderedDataInputStream3 != null) {
                                    byteOrderedDataInputStream3.close();
                                }
                                throw th;
                            }
                        } catch (Exception unused8) {
                        } catch (Throwable th6) {
                            th = th6;
                        }
                        if (i4 != 0) {
                            return 10;
                        }
                        int i7 = i;
                        while (true) {
                            byte[] bArr5 = PNG_SIGNATURE;
                            if (i7 >= bArr5.length) {
                                return 13;
                            }
                            if (bArr[i7] != bArr5[i7]) {
                                int i8 = i;
                                while (true) {
                                    byte[] bArr6 = WEBP_SIGNATURE_1;
                                    if (i8 >= bArr6.length) {
                                        int i9 = i;
                                        while (true) {
                                            byte[] bArr7 = WEBP_SIGNATURE_2;
                                            if (i9 >= bArr7.length) {
                                                return 14;
                                            }
                                            if (bArr[bArr6.length + i9 + 4] != bArr7[i9]) {
                                                break;
                                            }
                                            i9++;
                                        }
                                    } else {
                                        if (bArr[i8] != bArr6[i8]) {
                                            break;
                                        }
                                        i8++;
                                    }
                                }
                                return i;
                            }
                            i7++;
                        }
                    }
                }
                return 9;
            }
            i5++;
        }
    }

    public final void getOrfAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        int i;
        int i2;
        getRawAttributes(seekableByteOrderedDataInputStream);
        HashMap[] mapArr = this.mAttributes;
        ExifAttribute exifAttribute = (ExifAttribute) mapArr[1].get("MakerNote");
        if (exifAttribute != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.bytes);
            seekableByteOrderedDataInputStream2.mByteOrder = this.mExifByteOrder;
            byte[] bArr = ORF_MAKER_NOTE_HEADER_1;
            byte[] bArr2 = new byte[bArr.length];
            seekableByteOrderedDataInputStream2.readFully(bArr2);
            seekableByteOrderedDataInputStream2.seek(0L);
            byte[] bArr3 = ORF_MAKER_NOTE_HEADER_2;
            byte[] bArr4 = new byte[bArr3.length];
            seekableByteOrderedDataInputStream2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                seekableByteOrderedDataInputStream2.seek(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                seekableByteOrderedDataInputStream2.seek(12L);
            }
            readImageFileDirectory(seekableByteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[7].get("PreviewImageStart");
            ExifAttribute exifAttribute3 = (ExifAttribute) mapArr[7].get("PreviewImageLength");
            if (exifAttribute2 != null && exifAttribute3 != null) {
                mapArr[5].put("JPEGInterchangeFormat", exifAttribute2);
                mapArr[5].put("JPEGInterchangeFormatLength", exifAttribute3);
            }
            ExifAttribute exifAttribute4 = (ExifAttribute) mapArr[8].get("AspectFrame");
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i3 = iArr[2];
                int i4 = iArr[0];
                if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                    return;
                }
                int i5 = (i3 - i4) + 1;
                int i6 = (i - i2) + 1;
                if (i5 < i6) {
                    int i7 = i5 + i6;
                    i6 = i7 - i6;
                    i5 = i7 - i6;
                }
                ExifAttribute exifAttributeCreateUShort = ExifAttribute.createUShort(i5, this.mExifByteOrder);
                ExifAttribute exifAttributeCreateUShort2 = ExifAttribute.createUShort(i6, this.mExifByteOrder);
                mapArr[0].put("ImageWidth", exifAttributeCreateUShort);
                mapArr[0].put("ImageLength", exifAttributeCreateUShort2);
            }
        }
    }

    public final void getPngAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            Objects.toString(byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.mByteOrder = ByteOrder.BIG_ENDIAN;
        int i = byteOrderedDataInputStream.mPosition;
        byteOrderedDataInputStream.skipFully(PNG_SIGNATURE.length);
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (z && z2) {
                break;
            }
            try {
                int i2 = byteOrderedDataInputStream.readInt();
                int i3 = byteOrderedDataInputStream.readInt();
                int i4 = byteOrderedDataInputStream.mPosition;
                int i5 = i4 + i2 + 4;
                int i6 = i4 - i;
                if (i6 == 16 && i3 != 1229472850) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appear as the first chunk");
                }
                if (i3 == 1229278788) {
                    break;
                }
                if (i3 == 1700284774 && !z) {
                    this.mOffsetToExifData = i6;
                    byte[] bArr = new byte[i2];
                    byteOrderedDataInputStream.readFully(bArr);
                    int i7 = byteOrderedDataInputStream.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(i3 >>> 24);
                    crc32.update(i3 >>> 16);
                    crc32.update(i3 >>> 8);
                    crc32.update(i3);
                    crc32.update(bArr);
                    if (((int) crc32.getValue()) != i7) {
                        throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i7 + ", calculated CRC value: " + crc32.getValue());
                    }
                    readExifSegment(bArr, 0);
                    validateImages();
                    setThumbnailData(new ByteOrderedDataInputStream(bArr));
                    z = true;
                } else if (i3 == 1767135348 && !z2) {
                    byte[] bArr2 = PNG_ITXT_XMP_KEYWORD;
                    if (i2 >= bArr2.length) {
                        int length = bArr2.length;
                        byte[] bArr3 = new byte[length];
                        byteOrderedDataInputStream.readFully(bArr3);
                        if (Arrays.equals(bArr3, bArr2)) {
                            int i8 = byteOrderedDataInputStream.mPosition - i;
                            int i9 = i2 - length;
                            byte[] bArr4 = new byte[i9];
                            byteOrderedDataInputStream.readFully(bArr4);
                            this.mXmpFromSeparateMarker = new ExifAttribute(i8, bArr4, 1, i9);
                            z2 = true;
                        }
                    }
                }
                byteOrderedDataInputStream.skipFully(i5 - byteOrderedDataInputStream.mPosition);
            } catch (EOFException e) {
                throw new IOException("Encountered corrupt PNG file.", e);
            }
        }
        this.mFileOnDiskContainsSeparateXmpMarker = z2;
    }

    public final void getRafAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            Objects.toString(byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.skipFully(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        byteOrderedDataInputStream.readFully(bArr);
        byteOrderedDataInputStream.readFully(bArr2);
        byteOrderedDataInputStream.readFully(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        int i3 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i2];
        byteOrderedDataInputStream.skipFully(i - byteOrderedDataInputStream.mPosition);
        byteOrderedDataInputStream.readFully(bArr4);
        getJpegAttributes(new ByteOrderedDataInputStream(bArr4), i, 5);
        byteOrderedDataInputStream.skipFully(i3 - byteOrderedDataInputStream.mPosition);
        byteOrderedDataInputStream.mByteOrder = ByteOrder.BIG_ENDIAN;
        int i4 = byteOrderedDataInputStream.readInt();
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int unsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (unsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short s = byteOrderedDataInputStream.readShort();
                short s2 = byteOrderedDataInputStream.readShort();
                ExifAttribute exifAttributeCreateUShort = ExifAttribute.createUShort(s, this.mExifByteOrder);
                ExifAttribute exifAttributeCreateUShort2 = ExifAttribute.createUShort(s2, this.mExifByteOrder);
                HashMap[] mapArr = this.mAttributes;
                mapArr[0].put("ImageLength", exifAttributeCreateUShort);
                mapArr[0].put("ImageWidth", exifAttributeCreateUShort2);
                return;
            }
            byteOrderedDataInputStream.skipFully(unsignedShort2);
        }
    }

    public final void getRawAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        parseTiffHeaders(seekableByteOrderedDataInputStream);
        readImageFileDirectory(seekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 5);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 4);
        validateImages();
        if (this.mMimeType == 8) {
            HashMap[] mapArr = this.mAttributes;
            ExifAttribute exifAttribute = (ExifAttribute) mapArr[1].get("MakerNote");
            if (exifAttribute != null) {
                SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.bytes);
                seekableByteOrderedDataInputStream2.mByteOrder = this.mExifByteOrder;
                seekableByteOrderedDataInputStream2.skipFully(6);
                readImageFileDirectory(seekableByteOrderedDataInputStream2, 9);
                ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[9].get("ColorSpace");
                if (exifAttribute2 != null) {
                    mapArr[1].put("ColorSpace", exifAttribute2);
                }
            }
        }
    }

    public final void getRw2Attributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            Objects.toString(seekableByteOrderedDataInputStream);
        }
        getRawAttributes(seekableByteOrderedDataInputStream);
        HashMap[] mapArr = this.mAttributes;
        ExifAttribute exifAttribute = (ExifAttribute) mapArr[0].get("JpgFromRaw");
        if (exifAttribute != null) {
            getJpegAttributes(new ByteOrderedDataInputStream(exifAttribute.bytes), (int) exifAttribute.bytesOffset, 5);
        }
        ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[0].get("ISO");
        ExifAttribute exifAttribute3 = (ExifAttribute) mapArr[1].get("PhotographicSensitivity");
        if (exifAttribute2 == null || exifAttribute3 != null) {
            return;
        }
        mapArr[1].put("PhotographicSensitivity", exifAttribute2);
    }

    public final boolean getStandaloneAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        byte[] bArr = IDENTIFIER_EXIF_APP1;
        byte[] bArr2 = new byte[bArr.length];
        seekableByteOrderedDataInputStream.readFully(bArr2);
        if (!Arrays.equals(bArr2, bArr)) {
            Log.w("ExifInterface", "Given data is not EXIF-only.");
            return false;
        }
        byte[] bArrCopyOf = new byte[1024];
        int i = 0;
        while (true) {
            if (i == bArrCopyOf.length) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length * 2);
            }
            int i2 = seekableByteOrderedDataInputStream.mDataInputStream.read(bArrCopyOf, i, bArrCopyOf.length - i);
            if (i2 == -1) {
                byte[] bArrCopyOf2 = Arrays.copyOf(bArrCopyOf, i);
                this.mOffsetToExifData = bArr.length;
                readExifSegment(bArrCopyOf2, 0);
                return true;
            }
            i += i2;
            seekableByteOrderedDataInputStream.mPosition += i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0067  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    public final byte[] getThumbnailBytes() throws Throwable {
        FileDescriptor fileDescriptor;
        InputStream fileInputStream;
        InputStream inputStream = null;
        if (this.mHasThumbnail) {
            byte[] bArr = this.mThumbnailBytes;
            if (bArr != null) {
                return bArr;
            }
            try {
                fileInputStream = this.mAssetInputStream;
                if (fileInputStream != null) {
                    try {
                        if (!fileInputStream.markSupported()) {
                            LifecyclesKt.closeQuietly(fileInputStream);
                            return null;
                        }
                        fileInputStream.reset();
                        fileDescriptor = null;
                        try {
                            ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(fileInputStream);
                            byteOrderedDataInputStream.skipFully(this.mThumbnailOffset + this.mOffsetToExifData);
                            byte[] bArr2 = new byte[this.mThumbnailLength];
                            byteOrderedDataInputStream.readFully(bArr2);
                            this.mThumbnailBytes = bArr2;
                            LifecyclesKt.closeQuietly(fileInputStream);
                            if (fileDescriptor != null) {
                                LifecyclesKt.closeFileDescriptor(fileDescriptor);
                            }
                            return bArr2;
                        } catch (Exception unused) {
                        } catch (Throwable th) {
                            th = th;
                            inputStream = fileInputStream;
                            LifecyclesKt.closeQuietly(inputStream);
                            if (fileDescriptor != null) {
                                LifecyclesKt.closeFileDescriptor(fileDescriptor);
                            }
                            throw th;
                        }
                    } catch (Exception unused2) {
                        fileDescriptor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileDescriptor = null;
                        inputStream = fileInputStream;
                        LifecyclesKt.closeQuietly(inputStream);
                        if (fileDescriptor != null) {
                            LifecyclesKt.closeFileDescriptor(fileDescriptor);
                        }
                        throw th;
                    }
                    LifecyclesKt.closeQuietly(fileInputStream);
                    if (fileDescriptor != null) {
                        LifecyclesKt.closeFileDescriptor(fileDescriptor);
                    }
                } else {
                    String str = this.mFilename;
                    if (str != null) {
                        fileInputStream = new FileInputStream(str);
                        fileDescriptor = null;
                        ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(fileInputStream);
                        byteOrderedDataInputStream2.skipFully(this.mThumbnailOffset + this.mOffsetToExifData);
                        byte[] bArr3 = new byte[this.mThumbnailLength];
                        byteOrderedDataInputStream2.readFully(bArr3);
                        this.mThumbnailBytes = bArr3;
                        LifecyclesKt.closeQuietly(fileInputStream);
                        if (fileDescriptor != null) {
                            LifecyclesKt.closeFileDescriptor(fileDescriptor);
                        }
                        return bArr3;
                    }
                    FileDescriptor fileDescriptorDup = Os.dup(this.mSeekableFileDescriptor);
                    try {
                        Os.lseek(fileDescriptorDup, 0L, OsConstants.SEEK_SET);
                        fileDescriptor = fileDescriptorDup;
                        fileInputStream = new FileInputStream(fileDescriptorDup);
                        ByteOrderedDataInputStream byteOrderedDataInputStream3 = new ByteOrderedDataInputStream(fileInputStream);
                        byteOrderedDataInputStream3.skipFully(this.mThumbnailOffset + this.mOffsetToExifData);
                        byte[] bArr4 = new byte[this.mThumbnailLength];
                        byteOrderedDataInputStream3.readFully(bArr4);
                        this.mThumbnailBytes = bArr4;
                        LifecyclesKt.closeQuietly(fileInputStream);
                        if (fileDescriptor != null) {
                            LifecyclesKt.closeFileDescriptor(fileDescriptor);
                        }
                        return bArr4;
                    } catch (Exception unused3) {
                        fileDescriptor = fileDescriptorDup;
                        fileInputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileDescriptor = fileDescriptorDup;
                        LifecyclesKt.closeQuietly(inputStream);
                        if (fileDescriptor != null) {
                            LifecyclesKt.closeFileDescriptor(fileDescriptor);
                        }
                        throw th;
                    }
                }
            } catch (Exception unused4) {
                fileInputStream = null;
                fileDescriptor = null;
            } catch (Throwable th4) {
                th = th4;
                fileDescriptor = null;
            }
        }
        return null;
    }

    public final void getWebpAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            Objects.toString(byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.mByteOrder = ByteOrder.LITTLE_ENDIAN;
        byteOrderedDataInputStream.skipFully(WEBP_SIGNATURE_1.length);
        int i = byteOrderedDataInputStream.readInt() + 8;
        byte[] bArr = WEBP_SIGNATURE_2;
        byteOrderedDataInputStream.skipFully(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                byteOrderedDataInputStream.readFully(bArr2);
                int i2 = byteOrderedDataInputStream.readInt();
                int i3 = length + 8;
                if (Arrays.equals(WEBP_CHUNK_TYPE_EXIF, bArr2)) {
                    byte[] bArrCopyOfRange = new byte[i2];
                    byteOrderedDataInputStream.readFully(bArrCopyOfRange);
                    byte[] bArr3 = IDENTIFIER_EXIF_APP1;
                    if (LifecyclesKt.startsWith(bArrCopyOfRange, bArr3)) {
                        bArrCopyOfRange = Arrays.copyOfRange(bArrCopyOfRange, bArr3.length, i2);
                    }
                    this.mOffsetToExifData = i3;
                    readExifSegment(bArrCopyOfRange, 0);
                    setThumbnailData(new ByteOrderedDataInputStream(bArrCopyOfRange));
                    return;
                }
                if (i2 % 2 == 1) {
                    i2++;
                }
                length = i3 + i2;
                if (length == i) {
                    return;
                }
                if (length > i) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                byteOrderedDataInputStream.skipFully(i2);
            } catch (EOFException e) {
                throw new IOException("Encountered corrupt WebP file.", e);
            }
        }
    }

    public final void handleThumbnailFromJfif(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap map) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) map.get("JPEGInterchangeFormat");
        ExifAttribute exifAttribute2 = (ExifAttribute) map.get("JPEGInterchangeFormatLength");
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
        if (this.mMimeType == 7) {
            intValue += this.mOrfMakerNoteOffset;
        }
        if (intValue <= 0 || intValue2 <= 0) {
            return;
        }
        this.mHasThumbnail = true;
        if (this.mFilename == null && this.mAssetInputStream == null && this.mSeekableFileDescriptor == null) {
            byte[] bArr = new byte[intValue2];
            byteOrderedDataInputStream.skipFully(intValue);
            byteOrderedDataInputStream.readFully(bArr);
            this.mThumbnailBytes = bArr;
        }
        this.mThumbnailOffset = intValue;
        this.mThumbnailLength = intValue2;
    }

    public final boolean isThumbnail(HashMap map) {
        ExifAttribute exifAttribute = (ExifAttribute) map.get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) map.get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.getIntValue(this.mExifByteOrder) <= 512 && exifAttribute2.getIntValue(this.mExifByteOrder) <= 512;
    }

    public final void loadAttributes(InputStream inputStream) throws Throwable {
        boolean z = DEBUG;
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            try {
                try {
                    this.mAttributes[i] = new HashMap();
                } catch (Throwable th) {
                    addDefaultValuesForCompatibility();
                    if (z) {
                        printAttributes();
                    }
                    throw th;
                }
            } catch (IOException | UnsupportedOperationException e) {
                if (z) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file (ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                addDefaultValuesForCompatibility();
                if (z) {
                    printAttributes();
                    return;
                }
                return;
            }
        }
        boolean z2 = this.mIsExifDataOnly;
        if (!z2) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.mMimeType = getMimeType(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        int i2 = this.mMimeType;
        if (i2 == 4 || i2 == 9 || i2 == 13 || i2 == 14) {
            ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
            int i3 = this.mMimeType;
            if (i3 == 4) {
                getJpegAttributes(byteOrderedDataInputStream, 0, 0);
            } else if (i3 == 13) {
                getPngAttributes(byteOrderedDataInputStream);
            } else if (i3 == 9) {
                getRafAttributes(byteOrderedDataInputStream);
            } else if (i3 == 14) {
                getWebpAttributes(byteOrderedDataInputStream);
            }
        } else {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(inputStream);
            if (!z2) {
                int i4 = this.mMimeType;
                if (i4 == 12 || i4 == 15) {
                    getHeifAttributes(seekableByteOrderedDataInputStream, i4);
                } else if (i4 == 7) {
                    getOrfAttributes(seekableByteOrderedDataInputStream);
                } else if (i4 == 10) {
                    getRw2Attributes(seekableByteOrderedDataInputStream);
                } else {
                    getRawAttributes(seekableByteOrderedDataInputStream);
                }
            } else if (!getStandaloneAttributes(seekableByteOrderedDataInputStream)) {
                addDefaultValuesForCompatibility();
                if (z) {
                    printAttributes();
                    return;
                }
                return;
            }
            seekableByteOrderedDataInputStream.seek(this.mOffsetToExifData);
            setThumbnailData(seekableByteOrderedDataInputStream);
        }
        addDefaultValuesForCompatibility();
        if (z) {
            printAttributes();
        }
    }

    public final void parseTiffHeaders(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        ByteOrder byteOrder = readByteOrder(seekableByteOrderedDataInputStream);
        this.mExifByteOrder = byteOrder;
        seekableByteOrderedDataInputStream.mByteOrder = byteOrder;
        int unsignedShort = seekableByteOrderedDataInputStream.readUnsignedShort();
        int i = this.mMimeType;
        if (i != 7 && i != 10 && unsignedShort != 42) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$5(Integer.toHexString(unsignedShort), "Invalid start code: ");
            return;
        }
        int i2 = seekableByteOrderedDataInputStream.readInt();
        if (i2 < 8) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3(IntIntPair$$ExternalSyntheticOutline0.m(i2, "Invalid first Ifd offset: "));
            return;
        }
        int i3 = i2 - 8;
        if (i3 > 0) {
            seekableByteOrderedDataInputStream.skipFully(i3);
        }
    }

    public final void printAttributes() throws Throwable {
        int i = 0;
        while (true) {
            HashMap[] mapArr = this.mAttributes;
            if (i >= mapArr.length) {
                return;
            }
            mapArr[i].size();
            for (Map.Entry entry : mapArr[i].entrySet()) {
                ExifAttribute exifAttribute = (ExifAttribute) entry.getValue();
                exifAttribute.toString();
                exifAttribute.getStringValue(this.mExifByteOrder);
            }
            i++;
        }
    }

    public final void readExifSegment(byte[] bArr, int i) throws IOException {
        SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(bArr);
        parseTiffHeaders(seekableByteOrderedDataInputStream);
        readImageFileDirectory(seekableByteOrderedDataInputStream, i);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x019c  */
    /* JADX WARN: Code duplicated, block: B:19:0x0077  */
    public final void readImageFileDirectory(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i) throws IOException {
        boolean z;
        HashMap[] mapArr;
        HashMap[] mapArr2;
        ExifTag exifTag;
        long j;
        int i2;
        boolean z2;
        HashMap[] mapArr3;
        ExifTag exifTag2;
        int unsignedShort;
        long j2;
        int i3;
        Integer numValueOf = Integer.valueOf(seekableByteOrderedDataInputStream.mPosition);
        HashSet hashSet = this.mAttributesOffsets;
        hashSet.add(numValueOf);
        short s = seekableByteOrderedDataInputStream.readShort();
        if (s <= 0) {
            return;
        }
        short s2 = 0;
        while (true) {
            z = DEBUG;
            mapArr = this.mAttributes;
            if (s2 >= s) {
                break;
            }
            int unsignedShort2 = seekableByteOrderedDataInputStream.readUnsignedShort();
            int unsignedShort3 = seekableByteOrderedDataInputStream.readUnsignedShort();
            int i4 = seekableByteOrderedDataInputStream.readInt();
            short s3 = s2;
            long j3 = ((long) seekableByteOrderedDataInputStream.mPosition) + 4;
            ExifTag exifTag3 = (ExifTag) sExifTagMapsForReading[i].get(Integer.valueOf(unsignedShort2));
            if (z) {
                String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", Integer.valueOf(i), Integer.valueOf(unsignedShort2), exifTag3 != null ? exifTag3.name : null, Integer.valueOf(unsignedShort3), Integer.valueOf(i4));
            }
            if (exifTag3 != null && unsignedShort3 > 0) {
                int[] iArr = IFD_FORMAT_BYTES_PER_FORMAT;
                if (unsignedShort3 < iArr.length) {
                    byte b = exifTag3.primaryFormat;
                    if (b == 7 || unsignedShort3 == 7 || b == unsignedShort3 || (i2 = exifTag3.secondaryFormat) == unsignedShort3 || (((b == 4 || i2 == 4) && unsignedShort3 == 3) || (((b == 9 || i2 == 9) && unsignedShort3 == 8) || ((b == 12 || i2 == 12) && unsignedShort3 == 11)))) {
                        if (unsignedShort3 == 7) {
                            unsignedShort3 = b;
                        }
                        mapArr2 = mapArr;
                        exifTag = exifTag3;
                        j = ((long) i4) * ((long) iArr[unsignedShort3]);
                        z2 = j >= 0 && j <= 2147483647L;
                    } else {
                        if (z != 0) {
                            String str = IFD_FORMAT_NAMES[unsignedShort3];
                        }
                        exifTag = exifTag3;
                        mapArr2 = mapArr;
                        j = 0;
                    }
                } else {
                    exifTag = exifTag3;
                    mapArr2 = mapArr;
                    j = 0;
                }
            } else {
                exifTag = exifTag3;
                mapArr2 = mapArr;
                j = 0;
            }
            if (z2) {
                if (j > 4) {
                    int i5 = seekableByteOrderedDataInputStream.readInt();
                    if (this.mMimeType == 7) {
                        mapArr3 = mapArr2;
                        exifTag2 = exifTag;
                        if ("MakerNote".equals(exifTag2.name)) {
                            this.mOrfMakerNoteOffset = i5;
                        } else {
                            if (i == 6 && "ThumbnailImage".equals(exifTag2.name)) {
                                this.mOrfThumbnailOffset = i5;
                                this.mOrfThumbnailLength = i4;
                                ExifAttribute exifAttributeCreateUShort = ExifAttribute.createUShort(6, this.mExifByteOrder);
                                unsignedShort2 = unsignedShort2;
                                ExifAttribute exifAttributeCreateULong = ExifAttribute.createULong(this.mOrfThumbnailOffset, this.mExifByteOrder);
                                ExifAttribute exifAttributeCreateULong2 = ExifAttribute.createULong(this.mOrfThumbnailLength, this.mExifByteOrder);
                                mapArr3[4].put("Compression", exifAttributeCreateUShort);
                                mapArr3[4].put("JPEGInterchangeFormat", exifAttributeCreateULong);
                                mapArr3[4].put("JPEGInterchangeFormatLength", exifAttributeCreateULong2);
                            }
                            seekableByteOrderedDataInputStream.seek(i5);
                        }
                    } else {
                        mapArr3 = mapArr2;
                        exifTag2 = exifTag;
                    }
                    seekableByteOrderedDataInputStream.seek(i5);
                } else {
                    mapArr3 = mapArr2;
                    unsignedShort2 = unsignedShort2;
                    exifTag2 = exifTag;
                    i4 = i4;
                }
                Integer num = (Integer) sExifPointerTagMap.get(Integer.valueOf(unsignedShort2));
                if (num != null) {
                    if (unsignedShort3 != 3) {
                        if (unsignedShort3 == 4) {
                            j2 = ((long) seekableByteOrderedDataInputStream.readInt()) & 4294967295L;
                        } else if (unsignedShort3 == 8) {
                            unsignedShort = seekableByteOrderedDataInputStream.readShort();
                        } else if (unsignedShort3 == 9 || unsignedShort3 == 13) {
                            unsignedShort = seekableByteOrderedDataInputStream.readInt();
                        } else {
                            j2 = -1;
                        }
                        if (z) {
                            String.format("Offset: %d, tagName: %s", Long.valueOf(j2), exifTag2.name);
                        }
                        if (j2 > 0 && (((i3 = seekableByteOrderedDataInputStream.mLength) == -1 || j2 < i3) && !hashSet.contains(Integer.valueOf((int) j2)))) {
                            seekableByteOrderedDataInputStream.seek(j2);
                            readImageFileDirectory(seekableByteOrderedDataInputStream, num.intValue());
                        }
                        seekableByteOrderedDataInputStream.seek(j3);
                    } else {
                        unsignedShort = seekableByteOrderedDataInputStream.readUnsignedShort();
                    }
                    j2 = unsignedShort;
                    if (z) {
                        String.format("Offset: %d, tagName: %s", Long.valueOf(j2), exifTag2.name);
                    }
                    if (j2 > 0) {
                        seekableByteOrderedDataInputStream.seek(j2);
                        readImageFileDirectory(seekableByteOrderedDataInputStream, num.intValue());
                    }
                    seekableByteOrderedDataInputStream.seek(j3);
                } else {
                    int i6 = seekableByteOrderedDataInputStream.mPosition + this.mOffsetToExifData;
                    byte[] bArr = new byte[(int) j];
                    seekableByteOrderedDataInputStream.readFully(bArr);
                    ExifAttribute exifAttribute = new ExifAttribute(i6, bArr, unsignedShort3, i4);
                    HashMap map = mapArr3[i];
                    String str2 = exifTag2.name;
                    map.put(str2, exifAttribute);
                    if ("DNGVersion".equals(str2)) {
                        this.mMimeType = 3;
                    }
                    if ((("Make".equals(str2) || "Model".equals(str2)) && exifAttribute.getStringValue(this.mExifByteOrder).contains("PENTAX")) || ("Compression".equals(str2) && exifAttribute.getIntValue(this.mExifByteOrder) == 65535)) {
                        this.mMimeType = 8;
                    }
                    if (seekableByteOrderedDataInputStream.mPosition != j3) {
                        seekableByteOrderedDataInputStream.seek(j3);
                    }
                }
            } else {
                seekableByteOrderedDataInputStream.seek(j3);
            }
            s2 = (short) (s3 + 1);
            s = s;
        }
        int i7 = seekableByteOrderedDataInputStream.readInt();
        if (z) {
            String.format("nextIfdOffset: %d", Integer.valueOf(i7));
        }
        long j4 = i7;
        if (j4 <= 0 || hashSet.contains(Integer.valueOf(i7))) {
            return;
        }
        seekableByteOrderedDataInputStream.seek(j4);
        if (mapArr[4].isEmpty()) {
            readImageFileDirectory(seekableByteOrderedDataInputStream, 4);
        } else if (mapArr[5].isEmpty()) {
            readImageFileDirectory(seekableByteOrderedDataInputStream, 5);
        }
    }

    public final void removeAttribute(String str) {
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            this.mAttributes[i].remove(str);
        }
    }

    public final void replaceInvalidTags(int i, String str, String str2) {
        HashMap[] mapArr = this.mAttributes;
        if (mapArr[i].isEmpty() || mapArr[i].get(str) == null) {
            return;
        }
        HashMap map = mapArr[i];
        map.put(str2, (ExifAttribute) map.get(str));
        mapArr[i].remove(str);
    }

    public final void saveJpegAttributes(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) throws IOException {
        byte b;
        byte[] bArr;
        if (DEBUG) {
            Objects.toString(bufferedInputStream);
            Objects.toString(bufferedOutputStream);
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bufferedInputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(bufferedOutputStream, ByteOrder.BIG_ENDIAN);
        if (byteOrderedDataInputStream.readByte() != -1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Invalid marker");
            return;
        }
        byteOrderedDataOutputStream.writeByte(-1);
        if (byteOrderedDataInputStream.readByte() != -40) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Invalid marker");
            return;
        }
        byteOrderedDataOutputStream.writeByte(-40);
        byteOrderedDataOutputStream.writeByte(-1);
        byteOrderedDataOutputStream.writeByte(-31);
        this.mOffsetToExifData = writeExifSegment(byteOrderedDataOutputStream);
        ExifAttribute exifAttribute = this.mXmpFromSeparateMarker;
        byte[] bArr2 = IDENTIFIER_XMP_APP1;
        if (exifAttribute != null) {
            byteOrderedDataOutputStream.write(-1);
            byteOrderedDataOutputStream.writeByte(-31);
            byteOrderedDataOutputStream.writeUnsignedShort(bArr2.length + 2 + this.mXmpFromSeparateMarker.bytes.length);
            byteOrderedDataOutputStream.write(bArr2);
            byteOrderedDataOutputStream.write(this.mXmpFromSeparateMarker.bytes);
            this.mFileOnDiskContainsSeparateXmpMarker = true;
        }
        byte[] bArr3 = new byte[4096];
        while (byteOrderedDataInputStream.readByte() == -1) {
            do {
                b = byteOrderedDataInputStream.readByte();
            } while (b == -1);
            if (b == -39 || b == -38) {
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(b);
                LifecyclesKt.copy(byteOrderedDataInputStream, byteOrderedDataOutputStream);
                return;
            }
            if (b != -31) {
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(b);
                int unsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                byteOrderedDataOutputStream.writeUnsignedShort(unsignedShort);
                int i = unsignedShort - 2;
                if (i < 0) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Invalid length");
                    return;
                }
                while (i > 0) {
                    int i2 = byteOrderedDataInputStream.read(bArr3, 0, Math.min(i, 4096));
                    if (i2 < 0) {
                        break;
                    }
                    byteOrderedDataOutputStream.write(bArr3, 0, i2);
                    i -= i2;
                }
            } else {
                int unsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
                int length = unsignedShort2 - 2;
                if (length < 0) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Invalid length");
                    return;
                }
                int length2 = bArr2.length;
                byte[] bArr4 = IDENTIFIER_EXIF_APP1;
                if (length >= length2) {
                    bArr = new byte[bArr2.length];
                } else {
                    bArr = length >= bArr4.length ? new byte[bArr4.length] : null;
                }
                if (bArr != null) {
                    byteOrderedDataInputStream.readFully(bArr);
                    if (LifecyclesKt.startsWith(bArr, bArr4) || LifecyclesKt.startsWith(bArr, bArr2)) {
                        byteOrderedDataInputStream.skipFully(length - bArr.length);
                    }
                }
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(b);
                byteOrderedDataOutputStream.writeUnsignedShort(unsignedShort2);
                if (bArr != null) {
                    length -= bArr.length;
                    byteOrderedDataOutputStream.write(bArr);
                }
                while (length > 0) {
                    int i3 = byteOrderedDataInputStream.read(bArr3, 0, Math.min(length, 4096));
                    if (i3 < 0) {
                        break;
                    }
                    byteOrderedDataOutputStream.write(bArr3, 0, i3);
                    length -= i3;
                }
            }
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Invalid marker");
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0029 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:19:0x004c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0062 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:32:0x0073  */
    /* JADX WARN: Code duplicated, block: B:38:0x008c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0093  */
    /* JADX WARN: Code duplicated, block: B:42:0x005d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x003d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x006e A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x00a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0078 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0027 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005b -> B:10:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0027
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final void savePngAttributes(java.io.BufferedInputStream r9, java.io.BufferedOutputStream r10) {
        /*
            r8 = this;
            boolean r0 = androidx.exifinterface.media.ExifInterface.DEBUG
            if (r0 == 0) goto La
            java.util.Objects.toString(r9)
            java.util.Objects.toString(r10)
        La:
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r0 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream
            r0.<init>(r9)
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream r9 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            r9.<init>(r10, r1)
            byte[] r10 = androidx.exifinterface.media.ExifInterface.PNG_SIGNATURE
            int r10 = r10.length
            coil3.util.LifecyclesKt.copy(r0, r9, r10)
            androidx.exifinterface.media.ExifInterface$ExifAttribute r10 = r8.mXmpFromSeparateMarker
            r1 = 1
            r2 = 0
            if (r10 != 0) goto L26
            boolean r10 = r8.mFileOnDiskContainsSeparateXmpMarker
            if (r10 == 0) goto L5b
        L26:
            r10 = r1
        L27:
            if (r1 != 0) goto L30
            if (r10 == 0) goto L2c
            goto L30
        L2c:
            coil3.util.LifecyclesKt.copy(r0, r9)
            return
        L30:
            int r3 = r0.readInt()
            int r4 = r0.readInt()
            r5 = 1229472850(0x49484452, float:820293.1)
            if (r4 != r5) goto L5d
            r9.writeInt(r3)
            r9.writeInt(r4)
            int r3 = r3 + 4
            coil3.util.LifecyclesKt.copy(r0, r9, r3)
            int r3 = r8.mOffsetToExifData
            if (r3 != 0) goto L50
            r8.writePngExifChunk(r9)
            r1 = r2
        L50:
            androidx.exifinterface.media.ExifInterface$ExifAttribute r3 = r8.mXmpFromSeparateMarker
            if (r3 == 0) goto L27
            boolean r3 = r8.mFileOnDiskContainsSeparateXmpMarker
            if (r3 != 0) goto L27
            r8.writePngXmpItxtChunk(r9)
        L5b:
            r10 = r2
            goto L27
        L5d:
            r5 = 1700284774(0x65584966, float:6.383657E22)
            if (r4 != r5) goto L6e
            if (r1 == 0) goto L6e
            r8.writePngExifChunk(r9)
            int r3 = r3 + 4
            r0.skipFully(r3)
            r1 = r2
            goto L27
        L6e:
            r5 = 1767135348(0x69545874, float:1.6044374E25)
            if (r4 != r5) goto La0
            byte[] r5 = androidx.exifinterface.media.ExifInterface.PNG_ITXT_XMP_KEYWORD
            int r6 = r5.length
            if (r3 < r6) goto La0
            int r6 = r5.length
            byte[] r7 = new byte[r6]
            r0.readFully(r7)
            int r6 = r3 - r6
            int r6 = r6 + 4
            boolean r5 = java.util.Arrays.equals(r7, r5)
            if (r5 == 0) goto L93
            androidx.exifinterface.media.ExifInterface$ExifAttribute r10 = r8.mXmpFromSeparateMarker
            if (r10 == 0) goto L8f
            r8.writePngXmpItxtChunk(r9)
        L8f:
            r0.skipFully(r6)
            goto L5b
        L93:
            r9.writeInt(r3)
            r9.writeInt(r4)
            r9.write(r7)
            coil3.util.LifecyclesKt.copy(r0, r9, r6)
            goto L27
        La0:
            r9.writeInt(r3)
            r9.writeInt(r4)
            int r3 = r3 + 4
            coil3.util.LifecyclesKt.copy(r0, r9, r3)
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.savePngAttributes(java.io.BufferedInputStream, java.io.BufferedOutputStream):void");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 6681. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final void saveWebpAttributes(java.io.BufferedInputStream r23, java.io.BufferedOutputStream r24) {
        /*
            Method dump skipped, instruction units count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.saveWebpAttributes(java.io.BufferedInputStream, java.io.BufferedOutputStream):void");
    }

    /* JADX WARN: Code duplicated, block: B:132:0x0264  */
    /* JADX WARN: Code duplicated, block: B:137:0x026f  */
    /* JADX WARN: Code duplicated, block: B:140:0x027a A[LOOP:2: B:138:0x0277->B:140:0x027a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:143:0x0298 A[LOOP:3: B:142:0x0296->B:143:0x0298, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:145:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:148:0x02c2 A[LOOP:4: B:146:0x02bf->B:148:0x02c2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:151:0x0306 A[LOOP:5: B:150:0x0304->B:151:0x0306, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:153:0x0325  */
    /* JADX WARN: Code duplicated, block: B:156:0x0335 A[LOOP:6: B:154:0x0332->B:156:0x0335, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:159:0x0354 A[LOOP:7: B:158:0x0352->B:159:0x0354, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:161:0x036a  */
    /* JADX WARN: Code duplicated, block: B:164:0x037a A[LOOP:8: B:162:0x0377->B:164:0x037a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:166:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:169:0x03bb A[LOOP:9: B:167:0x03b8->B:169:0x03bb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:171:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:174:0x03e4 A[LOOP:10: B:172:0x03e1->B:174:0x03e4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:176:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:177:0x040b  */
    public final void setAttribute(String str, String str2) {
        ExifTag exifTag;
        int[] iArr;
        HashMap[] mapArr;
        int i;
        String[] strArrSplit;
        int[] iArr2;
        int i2;
        String[] strArrSplit2;
        long[] jArr;
        int i3;
        String[] strArrSplit3;
        Rational[] rationalArr;
        int i4;
        String[] strArrSplit4;
        int length;
        int[] iArr3;
        int i5;
        ByteBuffer byteBufferWrap;
        int i6;
        String[] strArrSplit5;
        int length2;
        Rational[] rationalArr2;
        int i7;
        ByteBuffer byteBufferWrap2;
        int i8;
        String[] strArrSplit6;
        int length3;
        double[] dArr;
        int i9;
        ByteBuffer byteBufferWrap3;
        int i10;
        Rational rational;
        long j;
        long j2;
        double d;
        String strReplaceAll = str2;
        String str3 = "ISOSpeedRatings".equals(str) ? "PhotographicSensitivity" : str;
        if (strReplaceAll != null) {
            if (RATIONAL_TAGS_HANDLED_AS_DECIMALS_FOR_COMPATIBILITY.contains(str3) && !strReplaceAll.contains("/")) {
                try {
                    double d2 = Double.parseDouble(strReplaceAll);
                    long j3 = 1;
                    if (d2 >= 9.223372036854776E18d || d2 <= -9.223372036854776E18d) {
                        rational = new Rational(d2 > 0.0d ? Long.MAX_VALUE : Long.MIN_VALUE, 1L);
                    } else {
                        double dAbs = Math.abs(d2);
                        long j4 = 0;
                        long j5 = 1;
                        double d3 = dAbs;
                        long j6 = 0;
                        while (true) {
                            double d4 = d3 % 1.0d;
                            long j7 = (long) (d3 - d4);
                            j = (j7 * j3) + j6;
                            j2 = (j7 * j4) + j5;
                            d3 = 1.0d / d4;
                            d = d2;
                            if (Math.abs(dAbs - (j / j2)) <= 1.0E-8d * dAbs) {
                                break;
                            }
                            j6 = j3;
                            d2 = d;
                            j3 = j;
                            j5 = j4;
                            j4 = j2;
                        }
                        if (d < 0.0d) {
                            j = -j;
                        }
                        rational = new Rational(j, j2);
                    }
                    strReplaceAll = rational.toString();
                } catch (NumberFormatException unused) {
                    Log.w("ExifInterface", "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
            } else if (str3.equals("GPSTimeStamp")) {
                Matcher matcher = GPS_TIMESTAMP_PATTERN.matcher(strReplaceAll);
                if (!matcher.find()) {
                    Log.w("ExifInterface", "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
                strReplaceAll = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else if ("DateTime".equals(str3) || "DateTimeOriginal".equals(str3) || "DateTimeDigitized".equals(str3)) {
                boolean zFind = DATETIME_PRIMARY_FORMAT_PATTERN.matcher(strReplaceAll).find();
                boolean zFind2 = DATETIME_SECONDARY_FORMAT_PATTERN.matcher(strReplaceAll).find();
                if (strReplaceAll.length() != 19 || (!zFind && !zFind2)) {
                    Log.w("ExifInterface", "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
                if (zFind2) {
                    strReplaceAll = strReplaceAll.replaceAll("-", ServerSentEventKt.COLON);
                }
            }
        }
        boolean zEquals = "Xmp".equals(str3);
        int i11 = 12;
        int i12 = 4;
        HashMap[] mapArr2 = this.mAttributes;
        int i13 = 0;
        if (zEquals) {
            boolean z = mapArr2[0].containsKey("Xmp") || mapArr2[5].containsKey("Xmp");
            int i14 = this.mMimeType;
            char c = i14 != 4 ? (i14 == 9 || i14 == 15 || i14 == 12 || i14 == 13) ? (char) 2 : (char) 1 : (char) 3;
            if ((c == 2 && (this.mXmpFromSeparateMarker != null || !z)) || (c == 3 && !z)) {
                this.mXmpFromSeparateMarker = strReplaceAll != null ? ExifAttribute.createByte(strReplaceAll) : null;
                return;
            }
        }
        int i15 = 0;
        while (i15 < EXIF_TAGS.length) {
            if ((i15 != i12 || this.mHasThumbnail) && (exifTag = (ExifTag) sExifTagMapsForWriting[i15].get(str3)) != null) {
                int i16 = exifTag.secondaryFormat;
                byte b = exifTag.primaryFormat;
                if (strReplaceAll != null) {
                    Pair pairGuessDataFormat = guessDataFormat(strReplaceAll);
                    if (b != ((Integer) pairGuessDataFormat.first).intValue() && b != ((Integer) pairGuessDataFormat.second).intValue()) {
                        if (i16 == -1 || (i16 != ((Integer) pairGuessDataFormat.first).intValue() && i16 != ((Integer) pairGuessDataFormat.second).intValue())) {
                            if (b != 1 && b != 7) {
                                if (b != 2) {
                                    if (DEBUG) {
                                        String[] strArr = IFD_FORMAT_NAMES;
                                        String str4 = strArr[b];
                                        if (i16 != -1) {
                                            String str5 = strArr[i16];
                                        }
                                        String str6 = strArr[((Integer) pairGuessDataFormat.first).intValue()];
                                        if (((Integer) pairGuessDataFormat.second).intValue() != -1) {
                                            String str7 = strArr[((Integer) pairGuessDataFormat.second).intValue()];
                                        }
                                    }
                                }
                            }
                            i16 = b;
                            iArr = IFD_FORMAT_BYTES_PER_FORMAT;
                            switch (i16) {
                                case 1:
                                    mapArr = mapArr2;
                                    i = i13;
                                    mapArr[i15].put(str3, ExifAttribute.createByte(strReplaceAll));
                                    break;
                                case 2:
                                case 7:
                                    mapArr = mapArr2;
                                    i = i13;
                                    mapArr[i15].put(str3, ExifAttribute.createString(strReplaceAll));
                                    break;
                                case 3:
                                    mapArr = mapArr2;
                                    i = i13;
                                    strArrSplit = strReplaceAll.split(",", -1);
                                    iArr2 = new int[strArrSplit.length];
                                    while (i2 < strArrSplit.length) {
                                        iArr2[i2] = Integer.parseInt(strArrSplit[i2]);
                                    }
                                    mapArr[i15].put(str3, ExifAttribute.createUShort(iArr2, this.mExifByteOrder));
                                    break;
                                case 4:
                                    mapArr = mapArr2;
                                    i = i13;
                                    strArrSplit2 = strReplaceAll.split(",", -1);
                                    jArr = new long[strArrSplit2.length];
                                    while (i3 < strArrSplit2.length) {
                                        jArr[i3] = Long.parseLong(strArrSplit2[i3]);
                                    }
                                    mapArr[i15].put(str3, ExifAttribute.createULong(jArr, this.mExifByteOrder));
                                    break;
                                case 5:
                                    mapArr = mapArr2;
                                    i = i13;
                                    strArrSplit3 = strReplaceAll.split(",", -1);
                                    rationalArr = new Rational[strArrSplit3.length];
                                    while (i4 < strArrSplit3.length) {
                                        String[] strArrSplit7 = strArrSplit3[i4].split("/", -1);
                                        rationalArr[i4] = new Rational((long) Double.parseDouble(strArrSplit7[i]), (long) Double.parseDouble(strArrSplit7[1]));
                                    }
                                    mapArr[i15].put(str3, ExifAttribute.createURational(rationalArr, this.mExifByteOrder));
                                    break;
                                case 9:
                                    mapArr = mapArr2;
                                    i = i13;
                                    strArrSplit4 = strReplaceAll.split(",", -1);
                                    length = strArrSplit4.length;
                                    iArr3 = new int[length];
                                    while (i5 < strArrSplit4.length) {
                                        iArr3[i5] = Integer.parseInt(strArrSplit4[i5]);
                                    }
                                    HashMap map = mapArr[i15];
                                    ByteOrder byteOrder = this.mExifByteOrder;
                                    byteBufferWrap = ByteBuffer.wrap(new byte[iArr[9] * length]);
                                    byteBufferWrap.order(byteOrder);
                                    while (i6 < length) {
                                        byteBufferWrap.putInt(iArr3[i6]);
                                    }
                                    map.put(str3, new ExifAttribute(byteBufferWrap.array(), 9, length));
                                    break;
                                case 10:
                                    mapArr = mapArr2;
                                    strArrSplit5 = strReplaceAll.split(",", -1);
                                    length2 = strArrSplit5.length;
                                    rationalArr2 = new Rational[length2];
                                    i7 = i13;
                                    while (i7 < strArrSplit5.length) {
                                        String[] strArrSplit8 = strArrSplit5[i7].split("/", -1);
                                        int i17 = i7;
                                        rationalArr2[i17] = new Rational((long) Double.parseDouble(strArrSplit8[i13]), (long) Double.parseDouble(strArrSplit8[1]));
                                        i7 = i17 + 1;
                                        i13 = i13;
                                        strArrSplit5 = strArrSplit5;
                                    }
                                    i = i13;
                                    HashMap map2 = mapArr[i15];
                                    ByteOrder byteOrder2 = this.mExifByteOrder;
                                    byteBufferWrap2 = ByteBuffer.wrap(new byte[iArr[10] * length2]);
                                    byteBufferWrap2.order(byteOrder2);
                                    while (i8 < length2) {
                                        Rational rational2 = rationalArr2[i8];
                                        byteBufferWrap2.putInt((int) rational2.numerator);
                                        byteBufferWrap2.putInt((int) rational2.denominator);
                                    }
                                    map2.put(str3, new ExifAttribute(byteBufferWrap2.array(), 10, length2));
                                    break;
                                case DictionaryEntry.PRONUNCIATION /* 12 */:
                                    strArrSplit6 = strReplaceAll.split(",", -1);
                                    length3 = strArrSplit6.length;
                                    dArr = new double[length3];
                                    while (i9 < strArrSplit6.length) {
                                        dArr[i9] = Double.parseDouble(strArrSplit6[i9]);
                                    }
                                    HashMap map3 = mapArr2[i15];
                                    ByteOrder byteOrder3 = this.mExifByteOrder;
                                    byteBufferWrap3 = ByteBuffer.wrap(new byte[iArr[i11] * length3]);
                                    byteBufferWrap3.order(byteOrder3);
                                    i10 = i13;
                                    while (i10 < length3) {
                                        byteBufferWrap3.putDouble(dArr[i10]);
                                        i10++;
                                        mapArr2 = mapArr2;
                                    }
                                    mapArr = mapArr2;
                                    map3.put(str3, new ExifAttribute(byteBufferWrap3.array(), i11, length3));
                                    i = i13;
                                    break;
                            }
                        } else {
                            iArr = IFD_FORMAT_BYTES_PER_FORMAT;
                            switch (i16) {
                                case 1:
                                    mapArr = mapArr2;
                                    i = i13;
                                    mapArr[i15].put(str3, ExifAttribute.createByte(strReplaceAll));
                                    break;
                                case 2:
                                case 7:
                                    mapArr = mapArr2;
                                    i = i13;
                                    mapArr[i15].put(str3, ExifAttribute.createString(strReplaceAll));
                                    break;
                                case 3:
                                    mapArr = mapArr2;
                                    i = i13;
                                    strArrSplit = strReplaceAll.split(",", -1);
                                    iArr2 = new int[strArrSplit.length];
                                    for (i2 = i; i2 < strArrSplit.length; i2++) {
                                        iArr2[i2] = Integer.parseInt(strArrSplit[i2]);
                                    }
                                    mapArr[i15].put(str3, ExifAttribute.createUShort(iArr2, this.mExifByteOrder));
                                    break;
                                case 4:
                                    mapArr = mapArr2;
                                    i = i13;
                                    strArrSplit2 = strReplaceAll.split(",", -1);
                                    jArr = new long[strArrSplit2.length];
                                    for (i3 = i; i3 < strArrSplit2.length; i3++) {
                                        jArr[i3] = Long.parseLong(strArrSplit2[i3]);
                                    }
                                    mapArr[i15].put(str3, ExifAttribute.createULong(jArr, this.mExifByteOrder));
                                    break;
                                case 5:
                                    mapArr = mapArr2;
                                    i = i13;
                                    strArrSplit3 = strReplaceAll.split(",", -1);
                                    rationalArr = new Rational[strArrSplit3.length];
                                    for (i4 = i; i4 < strArrSplit3.length; i4++) {
                                        String[] strArrSplit9 = strArrSplit3[i4].split("/", -1);
                                        rationalArr[i4] = new Rational((long) Double.parseDouble(strArrSplit9[i]), (long) Double.parseDouble(strArrSplit9[1]));
                                    }
                                    mapArr[i15].put(str3, ExifAttribute.createURational(rationalArr, this.mExifByteOrder));
                                    break;
                                case 9:
                                    mapArr = mapArr2;
                                    i = i13;
                                    strArrSplit4 = strReplaceAll.split(",", -1);
                                    length = strArrSplit4.length;
                                    iArr3 = new int[length];
                                    for (i5 = i; i5 < strArrSplit4.length; i5++) {
                                        iArr3[i5] = Integer.parseInt(strArrSplit4[i5]);
                                    }
                                    HashMap map4 = mapArr[i15];
                                    ByteOrder byteOrder4 = this.mExifByteOrder;
                                    byteBufferWrap = ByteBuffer.wrap(new byte[iArr[9] * length]);
                                    byteBufferWrap.order(byteOrder4);
                                    for (i6 = i; i6 < length; i6++) {
                                        byteBufferWrap.putInt(iArr3[i6]);
                                    }
                                    map4.put(str3, new ExifAttribute(byteBufferWrap.array(), 9, length));
                                    break;
                                case 10:
                                    mapArr = mapArr2;
                                    strArrSplit5 = strReplaceAll.split(",", -1);
                                    length2 = strArrSplit5.length;
                                    rationalArr2 = new Rational[length2];
                                    i7 = i13;
                                    while (i7 < strArrSplit5.length) {
                                        String[] strArrSplit10 = strArrSplit5[i7].split("/", -1);
                                        int i18 = i7;
                                        rationalArr2[i18] = new Rational((long) Double.parseDouble(strArrSplit10[i13]), (long) Double.parseDouble(strArrSplit10[1]));
                                        i7 = i18 + 1;
                                        i13 = i13;
                                        strArrSplit5 = strArrSplit5;
                                    }
                                    i = i13;
                                    HashMap map5 = mapArr[i15];
                                    ByteOrder byteOrder5 = this.mExifByteOrder;
                                    byteBufferWrap2 = ByteBuffer.wrap(new byte[iArr[10] * length2]);
                                    byteBufferWrap2.order(byteOrder5);
                                    for (i8 = i; i8 < length2; i8++) {
                                        Rational rational3 = rationalArr2[i8];
                                        byteBufferWrap2.putInt((int) rational3.numerator);
                                        byteBufferWrap2.putInt((int) rational3.denominator);
                                    }
                                    map5.put(str3, new ExifAttribute(byteBufferWrap2.array(), 10, length2));
                                    break;
                                case DictionaryEntry.PRONUNCIATION /* 12 */:
                                    strArrSplit6 = strReplaceAll.split(",", -1);
                                    length3 = strArrSplit6.length;
                                    dArr = new double[length3];
                                    for (i9 = i13; i9 < strArrSplit6.length; i9++) {
                                        dArr[i9] = Double.parseDouble(strArrSplit6[i9]);
                                    }
                                    HashMap map6 = mapArr2[i15];
                                    ByteOrder byteOrder6 = this.mExifByteOrder;
                                    byteBufferWrap3 = ByteBuffer.wrap(new byte[iArr[i11] * length3]);
                                    byteBufferWrap3.order(byteOrder6);
                                    i10 = i13;
                                    while (i10 < length3) {
                                        byteBufferWrap3.putDouble(dArr[i10]);
                                        i10++;
                                        mapArr2 = mapArr2;
                                    }
                                    mapArr = mapArr2;
                                    map6.put(str3, new ExifAttribute(byteBufferWrap3.array(), i11, length3));
                                    i = i13;
                                    break;
                            }
                        }
                    } else {
                        i16 = b;
                        iArr = IFD_FORMAT_BYTES_PER_FORMAT;
                        switch (i16) {
                            case 1:
                                mapArr = mapArr2;
                                i = i13;
                                mapArr[i15].put(str3, ExifAttribute.createByte(strReplaceAll));
                                break;
                            case 2:
                            case 7:
                                mapArr = mapArr2;
                                i = i13;
                                mapArr[i15].put(str3, ExifAttribute.createString(strReplaceAll));
                                break;
                            case 3:
                                mapArr = mapArr2;
                                i = i13;
                                strArrSplit = strReplaceAll.split(",", -1);
                                iArr2 = new int[strArrSplit.length];
                                while (i2 < strArrSplit.length) {
                                    iArr2[i2] = Integer.parseInt(strArrSplit[i2]);
                                }
                                mapArr[i15].put(str3, ExifAttribute.createUShort(iArr2, this.mExifByteOrder));
                                break;
                            case 4:
                                mapArr = mapArr2;
                                i = i13;
                                strArrSplit2 = strReplaceAll.split(",", -1);
                                jArr = new long[strArrSplit2.length];
                                while (i3 < strArrSplit2.length) {
                                    jArr[i3] = Long.parseLong(strArrSplit2[i3]);
                                }
                                mapArr[i15].put(str3, ExifAttribute.createULong(jArr, this.mExifByteOrder));
                                break;
                            case 5:
                                mapArr = mapArr2;
                                i = i13;
                                strArrSplit3 = strReplaceAll.split(",", -1);
                                rationalArr = new Rational[strArrSplit3.length];
                                while (i4 < strArrSplit3.length) {
                                    String[] strArrSplit11 = strArrSplit3[i4].split("/", -1);
                                    rationalArr[i4] = new Rational((long) Double.parseDouble(strArrSplit11[i]), (long) Double.parseDouble(strArrSplit11[1]));
                                }
                                mapArr[i15].put(str3, ExifAttribute.createURational(rationalArr, this.mExifByteOrder));
                                break;
                            case 9:
                                mapArr = mapArr2;
                                i = i13;
                                strArrSplit4 = strReplaceAll.split(",", -1);
                                length = strArrSplit4.length;
                                iArr3 = new int[length];
                                while (i5 < strArrSplit4.length) {
                                    iArr3[i5] = Integer.parseInt(strArrSplit4[i5]);
                                }
                                HashMap map7 = mapArr[i15];
                                ByteOrder byteOrder7 = this.mExifByteOrder;
                                byteBufferWrap = ByteBuffer.wrap(new byte[iArr[9] * length]);
                                byteBufferWrap.order(byteOrder7);
                                while (i6 < length) {
                                    byteBufferWrap.putInt(iArr3[i6]);
                                }
                                map7.put(str3, new ExifAttribute(byteBufferWrap.array(), 9, length));
                                break;
                            case 10:
                                mapArr = mapArr2;
                                strArrSplit5 = strReplaceAll.split(",", -1);
                                length2 = strArrSplit5.length;
                                rationalArr2 = new Rational[length2];
                                i7 = i13;
                                while (i7 < strArrSplit5.length) {
                                    String[] strArrSplit12 = strArrSplit5[i7].split("/", -1);
                                    int i19 = i7;
                                    rationalArr2[i19] = new Rational((long) Double.parseDouble(strArrSplit12[i13]), (long) Double.parseDouble(strArrSplit12[1]));
                                    i7 = i19 + 1;
                                    i13 = i13;
                                    strArrSplit5 = strArrSplit5;
                                }
                                i = i13;
                                HashMap map8 = mapArr[i15];
                                ByteOrder byteOrder8 = this.mExifByteOrder;
                                byteBufferWrap2 = ByteBuffer.wrap(new byte[iArr[10] * length2]);
                                byteBufferWrap2.order(byteOrder8);
                                while (i8 < length2) {
                                    Rational rational4 = rationalArr2[i8];
                                    byteBufferWrap2.putInt((int) rational4.numerator);
                                    byteBufferWrap2.putInt((int) rational4.denominator);
                                }
                                map8.put(str3, new ExifAttribute(byteBufferWrap2.array(), 10, length2));
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                strArrSplit6 = strReplaceAll.split(",", -1);
                                length3 = strArrSplit6.length;
                                dArr = new double[length3];
                                while (i9 < strArrSplit6.length) {
                                    dArr[i9] = Double.parseDouble(strArrSplit6[i9]);
                                }
                                HashMap map9 = mapArr2[i15];
                                ByteOrder byteOrder9 = this.mExifByteOrder;
                                byteBufferWrap3 = ByteBuffer.wrap(new byte[iArr[i11] * length3]);
                                byteBufferWrap3.order(byteOrder9);
                                i10 = i13;
                                while (i10 < length3) {
                                    byteBufferWrap3.putDouble(dArr[i10]);
                                    i10++;
                                    mapArr2 = mapArr2;
                                }
                                mapArr = mapArr2;
                                map9.put(str3, new ExifAttribute(byteBufferWrap3.array(), i11, length3));
                                i = i13;
                                break;
                        }
                    }
                } else {
                    mapArr2[i15].remove(str3);
                }
                mapArr = mapArr2;
                i = i13;
            } else {
                mapArr = mapArr2;
                i = i13;
            }
            i15++;
            mapArr2 = mapArr;
            i13 = i;
            i11 = 12;
            i12 = 4;
        }
    }

    public final void setThumbnailData(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        HashMap map = this.mAttributes[4];
        ExifAttribute exifAttribute2 = (ExifAttribute) map.get("Compression");
        if (exifAttribute2 == null) {
            this.mThumbnailCompression = 6;
            handleThumbnailFromJfif(byteOrderedDataInputStream, map);
            return;
        }
        int intValue = exifAttribute2.getIntValue(this.mExifByteOrder);
        this.mThumbnailCompression = intValue;
        if (intValue != 1) {
            if (intValue == 6) {
                handleThumbnailFromJfif(byteOrderedDataInputStream, map);
                return;
            } else if (intValue != 7) {
                return;
            }
        }
        ExifAttribute exifAttribute3 = (ExifAttribute) map.get("BitsPerSample");
        if (exifAttribute3 != null) {
            int[] iArr = (int[]) exifAttribute3.getValue(this.mExifByteOrder);
            int[] iArr2 = BITS_PER_SAMPLE_RGB;
            if (!Arrays.equals(iArr2, iArr)) {
                if (this.mMimeType != 3 || (exifAttribute = (ExifAttribute) map.get("PhotometricInterpretation")) == null) {
                    return;
                }
                int intValue2 = exifAttribute.getIntValue(this.mExifByteOrder);
                if ((intValue2 != 1 || !Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) && (intValue2 != 6 || !Arrays.equals(iArr, iArr2))) {
                    return;
                }
            }
            ExifAttribute exifAttribute4 = (ExifAttribute) map.get("StripOffsets");
            ExifAttribute exifAttribute5 = (ExifAttribute) map.get("StripByteCounts");
            if (exifAttribute4 == null || exifAttribute5 == null) {
                return;
            }
            long[] jArrConvertToLongArray = LifecyclesKt.convertToLongArray(exifAttribute4.getValue(this.mExifByteOrder));
            long[] jArrConvertToLongArray2 = LifecyclesKt.convertToLongArray(exifAttribute5.getValue(this.mExifByteOrder));
            if (jArrConvertToLongArray == null || jArrConvertToLongArray.length == 0) {
                Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                return;
            }
            if (jArrConvertToLongArray2 == null || jArrConvertToLongArray2.length == 0) {
                Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                return;
            }
            if (jArrConvertToLongArray.length != jArrConvertToLongArray2.length) {
                Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                return;
            }
            long j = 0;
            for (long j2 : jArrConvertToLongArray2) {
                j += j2;
            }
            int i = (int) j;
            byte[] bArr = new byte[i];
            this.mAreThumbnailStripsConsecutive = true;
            this.mHasThumbnailStrips = true;
            this.mHasThumbnail = true;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < jArrConvertToLongArray.length; i4++) {
                int i5 = (int) jArrConvertToLongArray[i4];
                int i6 = (int) jArrConvertToLongArray2[i4];
                if (i4 < jArrConvertToLongArray.length - 1 && i5 + i6 != jArrConvertToLongArray[i4 + 1]) {
                    this.mAreThumbnailStripsConsecutive = false;
                }
                int i7 = i5 - i2;
                if (i7 < 0) {
                    return;
                }
                try {
                    byteOrderedDataInputStream.skipFully(i7);
                    int i8 = i2 + i7;
                    byte[] bArr2 = new byte[i6];
                    byteOrderedDataInputStream.readFully(bArr2);
                    i2 = i8 + i6;
                    System.arraycopy(bArr2, 0, bArr, i3, i6);
                    i3 += i6;
                } catch (EOFException unused) {
                    return;
                }
            }
            this.mThumbnailBytes = bArr;
            if (this.mAreThumbnailStripsConsecutive) {
                this.mThumbnailOffset = (int) jArrConvertToLongArray[0];
                this.mThumbnailLength = i;
            }
        }
    }

    public final void swapBasedOnImageSize(int i, int i2) {
        HashMap[] mapArr = this.mAttributes;
        if (mapArr[i].isEmpty() || mapArr[i2].isEmpty()) {
            return;
        }
        ExifAttribute exifAttribute = (ExifAttribute) mapArr[i].get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[i].get("ImageWidth");
        ExifAttribute exifAttribute3 = (ExifAttribute) mapArr[i2].get("ImageLength");
        ExifAttribute exifAttribute4 = (ExifAttribute) mapArr[i2].get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null || exifAttribute3 == null || exifAttribute4 == null) {
            return;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
        int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
        int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
        if (intValue >= intValue3 || intValue2 >= intValue4) {
            return;
        }
        HashMap map = mapArr[i];
        mapArr[i] = mapArr[i2];
        mapArr[i2] = map;
    }

    public final void updateImageSizeValues(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i) throws IOException {
        ExifAttribute exifAttributeCreateUShort;
        ExifAttribute exifAttributeCreateUShort2;
        HashMap[] mapArr = this.mAttributes;
        ExifAttribute exifAttribute = (ExifAttribute) mapArr[i].get("DefaultCropSize");
        ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[i].get("SensorTopBorder");
        ExifAttribute exifAttribute3 = (ExifAttribute) mapArr[i].get("SensorLeftBorder");
        ExifAttribute exifAttribute4 = (ExifAttribute) mapArr[i].get("SensorBottomBorder");
        ExifAttribute exifAttribute5 = (ExifAttribute) mapArr[i].get("SensorRightBorder");
        if (exifAttribute != null) {
            int i2 = exifAttribute.format;
            ByteOrder byteOrder = this.mExifByteOrder;
            if (i2 == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute.getValue(byteOrder);
                if (rationalArr == null || rationalArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr));
                    return;
                } else {
                    exifAttributeCreateUShort = ExifAttribute.createURational(new Rational[]{rationalArr[0]}, this.mExifByteOrder);
                    exifAttributeCreateUShort2 = ExifAttribute.createURational(new Rational[]{rationalArr[1]}, this.mExifByteOrder);
                }
            } else {
                int[] iArr = (int[]) exifAttribute.getValue(byteOrder);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                exifAttributeCreateUShort = ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
                exifAttributeCreateUShort2 = ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
            }
            mapArr[i].put("ImageWidth", exifAttributeCreateUShort);
            mapArr[i].put("ImageLength", exifAttributeCreateUShort2);
            return;
        }
        if (exifAttribute2 != null && exifAttribute3 != null && exifAttribute4 != null && exifAttribute5 != null) {
            int intValue = exifAttribute2.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute4.getIntValue(this.mExifByteOrder);
            int intValue3 = exifAttribute5.getIntValue(this.mExifByteOrder);
            int intValue4 = exifAttribute3.getIntValue(this.mExifByteOrder);
            if (intValue2 <= intValue || intValue3 <= intValue4) {
                return;
            }
            ExifAttribute exifAttributeCreateUShort3 = ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
            ExifAttribute exifAttributeCreateUShort4 = ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
            mapArr[i].put("ImageLength", exifAttributeCreateUShort3);
            mapArr[i].put("ImageWidth", exifAttributeCreateUShort4);
            return;
        }
        ExifAttribute exifAttribute6 = (ExifAttribute) mapArr[i].get("ImageLength");
        ExifAttribute exifAttribute7 = (ExifAttribute) mapArr[i].get("ImageWidth");
        if (exifAttribute6 == null || exifAttribute7 == null) {
            ExifAttribute exifAttribute8 = (ExifAttribute) mapArr[i].get("JPEGInterchangeFormat");
            ExifAttribute exifAttribute9 = (ExifAttribute) mapArr[i].get("JPEGInterchangeFormatLength");
            if (exifAttribute8 == null || exifAttribute9 == null) {
                return;
            }
            int intValue5 = exifAttribute8.getIntValue(this.mExifByteOrder);
            int intValue6 = exifAttribute8.getIntValue(this.mExifByteOrder);
            seekableByteOrderedDataInputStream.seek(intValue5);
            byte[] bArr = new byte[intValue6];
            seekableByteOrderedDataInputStream.readFully(bArr);
            getJpegAttributes(new ByteOrderedDataInputStream(bArr), intValue5, i);
        }
    }

    public final void validateImages() {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        HashMap[] mapArr = this.mAttributes;
        ExifAttribute exifAttribute = (ExifAttribute) mapArr[1].get("PixelXDimension");
        ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[1].get("PixelYDimension");
        if (exifAttribute != null && exifAttribute2 != null) {
            mapArr[0].put("ImageWidth", exifAttribute);
            mapArr[0].put("ImageLength", exifAttribute2);
        }
        if (mapArr[4].isEmpty() && isThumbnail(mapArr[5])) {
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        isThumbnail(mapArr[4]);
        replaceInvalidTags(0, "ThumbnailOrientation", "Orientation");
        replaceInvalidTags(0, "ThumbnailImageLength", "ImageLength");
        replaceInvalidTags(0, "ThumbnailImageWidth", "ImageWidth");
        replaceInvalidTags(5, "ThumbnailOrientation", "Orientation");
        replaceInvalidTags(5, "ThumbnailImageLength", "ImageLength");
        replaceInvalidTags(5, "ThumbnailImageWidth", "ImageWidth");
        replaceInvalidTags(4, "Orientation", "ThumbnailOrientation");
        replaceInvalidTags(4, "ImageLength", "ThumbnailImageLength");
        replaceInvalidTags(4, "ImageWidth", "ThumbnailImageWidth");
    }

    public final int writeExifSegment(ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        HashMap[] mapArr;
        int i;
        int[] iArr;
        int i2;
        ExifTag[][] exifTagArr = EXIF_TAGS;
        int[] iArr2 = new int[exifTagArr.length];
        int[] iArr3 = new int[exifTagArr.length];
        ExifTag[] exifTagArr2 = EXIF_POINTER_TAGS;
        for (ExifTag exifTag : exifTagArr2) {
            removeAttribute(exifTag.name);
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                removeAttribute("StripOffsets");
                removeAttribute("StripByteCounts");
            } else {
                removeAttribute("JPEGInterchangeFormat");
                removeAttribute("JPEGInterchangeFormatLength");
            }
        }
        int i3 = 0;
        while (true) {
            int length = exifTagArr.length;
            mapArr = this.mAttributes;
            if (i3 >= length) {
                break;
            }
            Iterator it = mapArr[i3].entrySet().iterator();
            while (it.hasNext()) {
                if (((Map.Entry) it.next()).getValue() == null) {
                    it.remove();
                }
            }
            i3++;
        }
        if (mapArr[1].isEmpty()) {
            i = 1;
        } else {
            i = 1;
            mapArr[0].put(exifTagArr2[1].name, ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (!mapArr[2].isEmpty()) {
            mapArr[r7].put(exifTagArr2[2].name, ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (!mapArr[3].isEmpty()) {
            mapArr[i].put(exifTagArr2[3].name, ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        int i4 = 4;
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                mapArr[4].put("StripOffsets", ExifAttribute.createUShort(0, this.mExifByteOrder));
                mapArr[4].put("StripByteCounts", ExifAttribute.createUShort(this.mThumbnailLength, this.mExifByteOrder));
            } else {
                mapArr[4].put("JPEGInterchangeFormat", ExifAttribute.createULong(0L, this.mExifByteOrder));
                mapArr[4].put("JPEGInterchangeFormatLength", ExifAttribute.createULong(this.mThumbnailLength, this.mExifByteOrder));
            }
        }
        int i5 = 0;
        while (true) {
            int length2 = exifTagArr.length;
            iArr = IFD_FORMAT_BYTES_PER_FORMAT;
            if (i5 >= length2) {
                break;
            }
            Iterator it2 = mapArr[i5].entrySet().iterator();
            int i6 = 0;
            while (it2.hasNext()) {
                ExifAttribute exifAttribute = (ExifAttribute) ((Map.Entry) it2.next()).getValue();
                exifAttribute.getClass();
                int i7 = iArr[exifAttribute.format] * exifAttribute.numberOfComponents;
                if (i7 > 4) {
                    i6 += i7;
                }
            }
            iArr3[i5] = iArr3[i5] + i6;
            i5++;
        }
        int size = 8;
        for (int i8 = 0; i8 < exifTagArr.length; i8++) {
            if (!mapArr[i8].isEmpty()) {
                iArr2[i8] = size;
                size = (mapArr[i8].size() * 12) + 6 + iArr3[i8] + size;
            }
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                mapArr[4].put("StripOffsets", ExifAttribute.createUShort(size, this.mExifByteOrder));
            } else {
                mapArr[4].put("JPEGInterchangeFormat", ExifAttribute.createULong(size, this.mExifByteOrder));
            }
            this.mThumbnailOffset = size;
            size += this.mThumbnailLength;
        }
        if (this.mMimeType == 4) {
            size += 8;
        }
        if (DEBUG) {
            for (int i9 = 0; i9 < exifTagArr.length; i9++) {
                String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i9), Integer.valueOf(iArr2[i9]), Integer.valueOf(mapArr[i9].size()), Integer.valueOf(iArr3[i9]), Integer.valueOf(size));
            }
        }
        if (!mapArr[i].isEmpty()) {
            mapArr[0].put(exifTagArr2[i].name, ExifAttribute.createULong(iArr2[i], this.mExifByteOrder));
        }
        if (!mapArr[r6].isEmpty()) {
            mapArr[0].put(exifTagArr2[r6].name, ExifAttribute.createULong(iArr2[2], this.mExifByteOrder));
        }
        if (!mapArr[r6].isEmpty()) {
            mapArr[i].put(exifTagArr2[r6].name, ExifAttribute.createULong(iArr2[3], this.mExifByteOrder));
        }
        int i10 = this.mMimeType;
        if (i10 == 4) {
            if (size > 65535) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m(size, "Size of exif data (", " bytes) exceeds the max size of a JPEG APP1 segment (65536 bytes)"));
                return 0;
            }
            byteOrderedDataOutputStream.writeUnsignedShort(size);
            byteOrderedDataOutputStream.write(IDENTIFIER_EXIF_APP1);
        } else if (i10 == 13) {
            byteOrderedDataOutputStream.writeInt(size);
            byteOrderedDataOutputStream.writeInt(1700284774);
        } else if (i10 == 14) {
            byteOrderedDataOutputStream.write(WEBP_CHUNK_TYPE_EXIF);
            byteOrderedDataOutputStream.writeInt(size);
        }
        int size2 = byteOrderedDataOutputStream.mOutputStream.size();
        byteOrderedDataOutputStream.writeShort(this.mExifByteOrder == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        byteOrderedDataOutputStream.mByteOrder = this.mExifByteOrder;
        byteOrderedDataOutputStream.writeUnsignedShort(42);
        byteOrderedDataOutputStream.writeUnsignedInt(8L);
        int i11 = 0;
        while (i11 < exifTagArr.length) {
            if (mapArr[i11].isEmpty()) {
                i2 = i4;
            } else {
                byteOrderedDataOutputStream.writeUnsignedShort(mapArr[i11].size());
                int size3 = (mapArr[i11].size() * 12) + iArr2[i11] + 2 + i4;
                for (Map.Entry entry : mapArr[i11].entrySet()) {
                    char c = ((ExifTag) sExifTagMapsForWriting[i11].get(entry.getKey())).number;
                    ExifAttribute exifAttribute2 = (ExifAttribute) entry.getValue();
                    exifAttribute2.getClass();
                    int i12 = exifAttribute2.numberOfComponents;
                    int i13 = exifAttribute2.format;
                    int i14 = iArr[i13] * i12;
                    byteOrderedDataOutputStream.writeUnsignedShort(c);
                    byteOrderedDataOutputStream.writeUnsignedShort(i13);
                    byteOrderedDataOutputStream.writeInt(i12);
                    if (i14 > 4) {
                        byteOrderedDataOutputStream.writeUnsignedInt(size3);
                        size3 += i14;
                    } else {
                        byteOrderedDataOutputStream.write(exifAttribute2.bytes);
                        if (i14 < 4) {
                            while (i14 < 4) {
                                byteOrderedDataOutputStream.writeByte(0);
                                i14++;
                            }
                        }
                    }
                    i4 = 4;
                }
                int i15 = i4;
                if (i11 != 0 || mapArr[i15].isEmpty()) {
                    byteOrderedDataOutputStream.writeUnsignedInt(0L);
                } else {
                    byteOrderedDataOutputStream.writeUnsignedInt(iArr2[i15]);
                }
                Iterator it3 = mapArr[i11].entrySet().iterator();
                while (it3.hasNext()) {
                    byte[] bArr = ((ExifAttribute) ((Map.Entry) it3.next()).getValue()).bytes;
                    if (bArr.length > 4) {
                        byteOrderedDataOutputStream.write(bArr, 0, bArr.length);
                    }
                }
                i2 = 4;
            }
            i11++;
            i4 = i2;
        }
        if (this.mHasThumbnail) {
            byteOrderedDataOutputStream.write(getThumbnailBytes());
        }
        if (this.mMimeType == 14 && size % 2 == i) {
            byteOrderedDataOutputStream.writeByte(0);
        }
        byteOrderedDataOutputStream.mByteOrder = ByteOrder.BIG_ENDIAN;
        return size2;
    }

    public final void writePngExifChunk(ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.mOffsetToExifData = byteOrderedDataOutputStream.mOutputStream.size() + writeExifSegment(new ByteOrderedDataOutputStream(byteArrayOutputStream, ByteOrder.BIG_ENDIAN));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteOrderedDataOutputStream.write(byteArray);
        CRC32 crc32 = new CRC32();
        crc32.update(byteArray, 4, byteArray.length - 4);
        byteOrderedDataOutputStream.writeInt((int) crc32.getValue());
    }

    public final void writePngXmpItxtChunk(ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        byteOrderedDataOutputStream.writeInt(this.mXmpFromSeparateMarker.bytes.length + 22);
        CRC32 crc32 = new CRC32();
        byteOrderedDataOutputStream.writeInt(1767135348);
        crc32.update(105);
        crc32.update(26964);
        crc32.update(6902872);
        crc32.update(1767135348);
        byte[] bArr = PNG_ITXT_XMP_KEYWORD;
        byteOrderedDataOutputStream.write(bArr);
        crc32.update(bArr);
        byteOrderedDataOutputStream.write(this.mXmpFromSeparateMarker.bytes);
        crc32.update(this.mXmpFromSeparateMarker.bytes);
        byteOrderedDataOutputStream.writeInt((int) crc32.getValue());
        this.mFileOnDiskContainsSeparateXmpMarker = true;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ByteOrderedDataOutputStream extends FilterOutputStream {
        public ByteOrder mByteOrder;
        public final DataOutputStream mOutputStream;

        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.mOutputStream = new DataOutputStream(outputStream);
            this.mByteOrder = byteOrder;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(byte[] bArr) throws IOException {
            this.mOutputStream.write(bArr);
        }

        public final void writeByte(int i) throws IOException {
            this.mOutputStream.write(i);
        }

        public final void writeInt(int i) throws IOException {
            ByteOrder byteOrder = this.mByteOrder;
            ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
            DataOutputStream dataOutputStream = this.mOutputStream;
            if (byteOrder == byteOrder2) {
                dataOutputStream.write(i & 255);
                dataOutputStream.write((i >>> 8) & 255);
                dataOutputStream.write((i >>> 16) & 255);
                dataOutputStream.write((i >>> 24) & 255);
                return;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                dataOutputStream.write((i >>> 24) & 255);
                dataOutputStream.write((i >>> 16) & 255);
                dataOutputStream.write((i >>> 8) & 255);
                dataOutputStream.write(i & 255);
            }
        }

        public final void writeShort(short s) throws IOException {
            ByteOrder byteOrder = this.mByteOrder;
            ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
            DataOutputStream dataOutputStream = this.mOutputStream;
            if (byteOrder == byteOrder2) {
                dataOutputStream.write(s & 255);
                dataOutputStream.write((s >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                dataOutputStream.write((s >>> 8) & 255);
                dataOutputStream.write(s & 255);
            }
        }

        public final void writeUnsignedInt(long j) throws IOException {
            if (j <= 4294967295L) {
                writeInt((int) j);
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("val is larger than the maximum value of a 32-bit unsigned integer");
            }
        }

        public final void writeUnsignedShort(int i) throws IOException {
            if (i <= 65535) {
                writeShort((short) i);
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("val is larger than the maximum value of a 16-bit unsigned integer");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            this.mOutputStream.write(bArr, i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class ByteOrderedDataInputStream extends InputStream implements DataInput, InputStreamRetargetInterface {
        public ByteOrder mByteOrder;
        public final DataInputStream mDataInputStream;
        public final int mLength;
        public int mPosition;
        public byte[] mSkipBuffer;

        public ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.mDataInputStream = dataInputStream;
            dataInputStream.mark(0);
            this.mPosition = 0;
            this.mByteOrder = byteOrder;
            this.mLength = inputStream instanceof ByteOrderedDataInputStream ? ((ByteOrderedDataInputStream) inputStream).mLength : -1;
        }

        @Override // java.io.InputStream
        public final int available() {
            return this.mDataInputStream.available();
        }

        @Override // java.io.InputStream
        public final void mark(int i) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public final int read() {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        @Override // java.io.DataInput
        public final boolean readBoolean() {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        @Override // java.io.DataInput
        public final byte readByte() throws IOException {
            this.mPosition++;
            int i = this.mDataInputStream.read();
            if (i >= 0) {
                return (byte) i;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final char readChar() {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        @Override // java.io.DataInput
        public final double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public final float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr) throws IOException {
            this.mPosition += bArr.length;
            this.mDataInputStream.readFully(bArr);
        }

        @Override // java.io.DataInput
        public final int readInt() throws IOException {
            this.mPosition += 4;
            DataInputStream dataInputStream = this.mDataInputStream;
            int i = dataInputStream.read();
            int i2 = dataInputStream.read();
            int i3 = dataInputStream.read();
            int i4 = dataInputStream.read();
            if ((i | i2 | i3 | i4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$5(this.mByteOrder, "Invalid byte order: ");
            return 0;
        }

        @Override // java.io.DataInput
        public final String readLine() {
            return null;
        }

        @Override // java.io.DataInput
        public final long readLong() throws IOException {
            this.mPosition += 8;
            DataInputStream dataInputStream = this.mDataInputStream;
            int i = dataInputStream.read();
            int i2 = dataInputStream.read();
            int i3 = dataInputStream.read();
            int i4 = dataInputStream.read();
            int i5 = dataInputStream.read();
            int i6 = dataInputStream.read();
            int i7 = dataInputStream.read();
            int i8 = dataInputStream.read();
            if ((i | i2 | i3 | i4 | i5 | i6 | i7 | i8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (((long) i8) << 56) + (((long) i7) << 48) + (((long) i6) << 40) + (((long) i5) << 32) + (((long) i4) << 24) + (((long) i3) << 16) + (((long) i2) << 8) + ((long) i);
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (((long) i) << 56) + (((long) i2) << 48) + (((long) i3) << 40) + (((long) i4) << 32) + (((long) i5) << 24) + (((long) i6) << 16) + (((long) i7) << 8) + ((long) i8);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$5(this.mByteOrder, "Invalid byte order: ");
            return 0L;
        }

        @Override // java.io.DataInput
        public final short readShort() throws IOException {
            this.mPosition += 2;
            DataInputStream dataInputStream = this.mDataInputStream;
            int i = dataInputStream.read();
            int i2 = dataInputStream.read();
            if ((i | i2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (short) ((i2 << 8) + i);
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (short) ((i << 8) + i2);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$5(this.mByteOrder, "Invalid byte order: ");
            return (short) 0;
        }

        @Override // java.io.DataInput
        public final String readUTF() {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        @Override // java.io.DataInput
        public final int readUnsignedByte() {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public final int readUnsignedShort() throws IOException {
            this.mPosition += 2;
            DataInputStream dataInputStream = this.mDataInputStream;
            int i = dataInputStream.read();
            int i2 = dataInputStream.read();
            if ((i | i2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (i2 << 8) + i;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (i << 8) + i2;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$5(this.mByteOrder, "Invalid byte order: ");
            return 0;
        }

        @Override // java.io.InputStream
        public final void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public final int skipBytes(int i) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public final void skipFully(int i) throws IOException {
            int i2 = 0;
            while (i2 < i) {
                int i3 = i - i2;
                DataInputStream dataInputStream = this.mDataInputStream;
                int iSkip = (int) dataInputStream.skip(i3);
                if (iSkip <= 0) {
                    if (this.mSkipBuffer == null) {
                        this.mSkipBuffer = new byte[8192];
                    }
                    iSkip = dataInputStream.read(this.mSkipBuffer, 0, Math.min(8192, i3));
                    if (iSkip == -1) {
                        throw new EOFException(IntIntPair$$ExternalSyntheticOutline0.m(i, "Reached EOF while skipping ", " bytes."));
                    }
                }
                i2 += iSkip;
            }
            this.mPosition += i2;
        }

        @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
        public /* synthetic */ long transferTo(OutputStream outputStream) {
            return DesugarInputStream.transferTo(this, outputStream);
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr, int i, int i2) throws IOException {
            this.mPosition += i2;
            this.mDataInputStream.readFully(bArr, i, i2);
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) {
            int i3 = this.mDataInputStream.read(bArr, i, i2);
            this.mPosition += i3;
            return i3;
        }

        public ByteOrderedDataInputStream(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public ByteOrderedDataInputStream(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
            this.mLength = bArr.length;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ExifAttribute {
        public final byte[] bytes;
        public final long bytesOffset;
        public final int format;
        public final int numberOfComponents;

        public ExifAttribute(long j, byte[] bArr, int i, int i2) {
            this.format = i;
            this.numberOfComponents = i2;
            this.bytesOffset = j;
            this.bytes = bArr;
        }

        public static ExifAttribute createByte(String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new ExifAttribute(new byte[]{(byte) (str.charAt(0) - '0')}, 1, 1);
            }
            byte[] bytes = str.getBytes(ExifInterface.ASCII);
            return new ExifAttribute(bytes, 1, bytes.length);
        }

        public static ExifAttribute createString(String str) {
            byte[] bytes = str.concat("\u0000").getBytes(ExifInterface.ASCII);
            return new ExifAttribute(bytes, 2, bytes.length);
        }

        public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j : jArr) {
                byteBufferWrap.putInt((int) j);
            }
            return new ExifAttribute(byteBufferWrap.array(), 4, jArr.length);
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArr.length]);
            byteBufferWrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                byteBufferWrap.putInt((int) rational.numerator);
                byteBufferWrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(byteBufferWrap.array(), 5, rationalArr.length);
        }

        public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i : iArr) {
                byteBufferWrap.putShort((short) i);
            }
            return new ExifAttribute(byteBufferWrap.array(), 3, iArr.length);
        }

        public final double getDoubleValue(ByteOrder byteOrder) throws Throwable {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (value instanceof String) {
                return Double.parseDouble((String) value);
            }
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                if (jArr.length == 1) {
                    return jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(value instanceof Rational[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            Rational[] rationalArr = (Rational[]) value;
            if (rationalArr.length != 1) {
                throw new NumberFormatException("There are more than one component");
            }
            Rational rational = rationalArr[0];
            return rational.numerator / rational.denominator;
        }

        public final int getIntValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (value instanceof String) {
                return Integer.parseInt((String) value);
            }
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(value instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) value;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public final String getStringValue(ByteOrder byteOrder) throws Throwable {
            Object value = getValue(byteOrder);
            if (value == null) {
                return null;
            }
            if (value instanceof String) {
                return (String) value;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(value instanceof Rational[])) {
                return null;
            }
            Rational[] rationalArr = (Rational[]) value;
            while (i < rationalArr.length) {
                sb.append(rationalArr[i].numerator);
                sb.append('/');
                sb.append(rationalArr[i].denominator);
                i++;
                if (i != rationalArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Code duplicated, block: B:103:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0032: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:51), block:B:17:0x0032 */
        /* JADX WARN: Type inference failed for: r13v14, types: [int[]] */
        /* JADX WARN: Type inference failed for: r13v15, types: [long[]] */
        /* JADX WARN: Type inference failed for: r13v16, types: [androidx.exifinterface.media.ExifInterface$Rational[]] */
        /* JADX WARN: Type inference failed for: r13v17, types: [int[]] */
        /* JADX WARN: Type inference failed for: r13v18, types: [int[]] */
        /* JADX WARN: Type inference failed for: r13v19, types: [androidx.exifinterface.media.ExifInterface$Rational[]] */
        /* JADX WARN: Type inference failed for: r13v20, types: [double[]] */
        /* JADX WARN: Type inference failed for: r13v21, types: [java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v22, types: [double[]] */
        public final Serializable getValue(ByteOrder byteOrder) throws Throwable {
            ByteOrderedDataInputStream byteOrderedDataInputStream;
            InputStream inputStream;
            String str;
            byte b;
            ?? r13;
            byte[] bArr = this.bytes;
            InputStream inputStream2 = null;
            try {
                try {
                    byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
                    try {
                        byteOrderedDataInputStream.mByteOrder = byteOrder;
                        int i = this.format;
                        int length = 0;
                        int i2 = this.numberOfComponents;
                        switch (i) {
                            case 1:
                            case 6:
                                if (bArr.length != 1 || (b = bArr[0]) < 0 || b > 1) {
                                    str = new String(bArr, ExifInterface.ASCII);
                                    try {
                                        byteOrderedDataInputStream.close();
                                        return str;
                                    } catch (IOException e) {
                                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e);
                                        return str;
                                    }
                                }
                                String str2 = new String(new char[]{(char) (b + 48)});
                                try {
                                    byteOrderedDataInputStream.close();
                                    return str2;
                                } catch (IOException e2) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                                    return str2;
                                }
                            case 2:
                            case 7:
                                if (i2 >= ExifInterface.EXIF_ASCII_PREFIX.length) {
                                    int i3 = 0;
                                    while (true) {
                                        byte[] bArr2 = ExifInterface.EXIF_ASCII_PREFIX;
                                        if (i3 >= bArr2.length) {
                                            length = bArr2.length;
                                        } else if (bArr[i3] == bArr2[i3]) {
                                            i3++;
                                        }
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                while (length < i2) {
                                    byte b2 = bArr[length];
                                    if (b2 == 0) {
                                        str = sb.toString();
                                        byteOrderedDataInputStream.close();
                                        return str;
                                    }
                                    if (b2 >= 32) {
                                        sb.append((char) b2);
                                    } else {
                                        sb.append('?');
                                    }
                                    length++;
                                }
                                str = sb.toString();
                                byteOrderedDataInputStream.close();
                                return str;
                            case 3:
                                r13 = new int[i2];
                                while (length < i2) {
                                    r13[length] = byteOrderedDataInputStream.readUnsignedShort();
                                    length++;
                                }
                                try {
                                    byteOrderedDataInputStream.close();
                                    return r13;
                                } catch (IOException e3) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e3);
                                    return r13;
                                }
                            case 4:
                                r13 = new long[i2];
                                while (length < i2) {
                                    r13[length] = ((long) byteOrderedDataInputStream.readInt()) & 4294967295L;
                                    length++;
                                }
                                byteOrderedDataInputStream.close();
                                return r13;
                            case 5:
                                r13 = new Rational[i2];
                                while (length < i2) {
                                    r13[length] = new Rational(((long) byteOrderedDataInputStream.readInt()) & 4294967295L, ((long) byteOrderedDataInputStream.readInt()) & 4294967295L);
                                    length++;
                                }
                                byteOrderedDataInputStream.close();
                                return r13;
                            case 8:
                                r13 = new int[i2];
                                while (length < i2) {
                                    r13[length] = byteOrderedDataInputStream.readShort();
                                    length++;
                                }
                                byteOrderedDataInputStream.close();
                                return r13;
                            case 9:
                                r13 = new int[i2];
                                while (length < i2) {
                                    r13[length] = byteOrderedDataInputStream.readInt();
                                    length++;
                                }
                                byteOrderedDataInputStream.close();
                                return r13;
                            case 10:
                                r13 = new Rational[i2];
                                while (length < i2) {
                                    r13[length] = new Rational(byteOrderedDataInputStream.readInt(), byteOrderedDataInputStream.readInt());
                                    length++;
                                }
                                byteOrderedDataInputStream.close();
                                return r13;
                            case 11:
                                r13 = new double[i2];
                                while (length < i2) {
                                    r13[length] = byteOrderedDataInputStream.readFloat();
                                    length++;
                                }
                                byteOrderedDataInputStream.close();
                                return r13;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                r13 = new double[i2];
                                while (length < i2) {
                                    r13[length] = byteOrderedDataInputStream.readDouble();
                                    length++;
                                }
                                byteOrderedDataInputStream.close();
                                return r13;
                            default:
                                try {
                                    byteOrderedDataInputStream.close();
                                    return null;
                                } catch (IOException e4) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e4);
                                    return null;
                                }
                        }
                    } catch (IOException e5) {
                        e = e5;
                        Log.w("ExifInterface", "IOException occurred during reading a value", e);
                        if (byteOrderedDataInputStream != null) {
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e6) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e7) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e7);
                        }
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
                byteOrderedDataInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                throw th;
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("(");
            sb.append(ExifInterface.IFD_FORMAT_NAMES[this.format]);
            sb.append(", data length:");
            return Fragment$5$$ExternalSyntheticOutline0.m(sb, this.bytes.length, ")");
        }

        public ExifAttribute(byte[] bArr, int i, int i2) {
            this(-1L, bArr, i, i2);
        }

        public static ExifAttribute createULong(long j, ByteOrder byteOrder) {
            return createULong(new long[]{j}, byteOrder);
        }

        public static ExifAttribute createUShort(int i, ByteOrder byteOrder) {
            return createUShort(new int[]{i}, byteOrder);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ExifTag {
        public final String name;
        public final char number;
        public final byte primaryFormat;
        public final int secondaryFormat;

        /* JADX WARN: Multi-variable type inference failed */
        public ExifTag(String str, int i, int i2) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ExifTag(int i, int i2, int i3, String str) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SeekableByteOrderedDataInputStream extends ByteOrderedDataInputStream {
        public SeekableByteOrderedDataInputStream(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.mDataInputStream.mark(Integer.MAX_VALUE);
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
                throw null;
            }
        }

        public final void seek(long j) throws IOException {
            int i = this.mPosition;
            if (i > j) {
                this.mPosition = 0;
                this.mDataInputStream.reset();
            } else {
                j -= (long) i;
            }
            skipFully((int) j);
        }

        public SeekableByteOrderedDataInputStream(byte[] bArr) {
            super(bArr);
            this.mDataInputStream.mark(Integer.MAX_VALUE);
        }
    }

    public ExifInterface(String str) throws Throwable {
        boolean z;
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        FileInputStream fileInputStream = null;
        if (str != null) {
            this.mAssetInputStream = null;
            this.mFilename = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    try {
                        Os.lseek(fileInputStream2.getFD(), 0L, OsConstants.SEEK_CUR);
                        z = true;
                    } catch (Exception unused) {
                        z = false;
                    }
                    if (z) {
                        this.mSeekableFileDescriptor = fileInputStream2.getFD();
                    } else {
                        this.mSeekableFileDescriptor = null;
                    }
                    loadAttributes(fileInputStream2);
                    LifecyclesKt.closeQuietly(fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    LifecyclesKt.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            PathKt$$ExternalSyntheticBUOutline0.m("filename cannot be null");
            throw null;
        }
    }

    public ExifInterface(InputStream inputStream) throws Throwable {
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.mFilename = null;
            this.mIsExifDataOnly = false;
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.mAssetInputStream = (AssetManager.AssetInputStream) inputStream;
                this.mSeekableFileDescriptor = null;
            } else if (inputStream instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) inputStream;
                try {
                    Os.lseek(fileInputStream.getFD(), 0L, OsConstants.SEEK_CUR);
                    this.mAssetInputStream = null;
                    this.mSeekableFileDescriptor = fileInputStream.getFD();
                } catch (Exception unused) {
                    this.mAssetInputStream = null;
                    this.mSeekableFileDescriptor = null;
                }
            } else {
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
            }
            loadAttributes(inputStream);
            return;
        }
        PathKt$$ExternalSyntheticBUOutline0.m("inputStream cannot be null");
        throw null;
    }
}

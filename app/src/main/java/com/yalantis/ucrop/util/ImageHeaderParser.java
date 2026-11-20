package com.yalantis.ucrop.util;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import coil3.util.LifecyclesKt;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ImageHeaderParser {
    private static final int EXIF_MAGIC_NUMBER = 65496;
    private static final int EXIF_SEGMENT_TYPE = 225;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int SEGMENT_SOS = 218;
    private static final int SEGMENT_START_ID = 255;
    private static final String TAG = "ImageHeaderParser";
    public static final int UNKNOWN_ORIENTATION = -1;
    private final Reader reader;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
    private static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static class RandomAccessReader {
        private final ByteBuffer data;

        public RandomAccessReader(byte[] bArr, int i) {
            this.data = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        public short getInt16(int i) {
            return this.data.getShort(i);
        }

        public int getInt32(int i) {
            return this.data.getInt(i);
        }

        public int length() {
            return this.data.remaining();
        }

        public void order(ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Reader {
        int getUInt16();

        short getUInt8();

        int read(byte[] bArr, int i);

        long skip(long j);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static class StreamReader implements Reader {
        private final InputStream is;

        public StreamReader(InputStream inputStream) {
            this.is = inputStream;
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.Reader
        public int getUInt16() {
            return (this.is.read() & ImageHeaderParser.SEGMENT_START_ID) | ((this.is.read() << 8) & 65280);
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.Reader
        public short getUInt8() {
            return (short) (this.is.read() & ImageHeaderParser.SEGMENT_START_ID);
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.Reader
        public int read(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int i3 = this.is.read(bArr, i - i2, i2);
                if (i3 == -1) {
                    break;
                }
                i2 -= i3;
            }
            return i - i2;
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.Reader
        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long jSkip = this.is.skip(j2);
                if (jSkip <= 0) {
                    if (this.is.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j2 -= jSkip;
            }
            return j - j2;
        }
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.reader = new StreamReader(inputStream);
    }

    private static int calcTagOffset(int i, int i2) {
        return (i2 * 12) + i + 2;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:? A[SYNTHETIC] */
    public static void copyExif(Context context, int i, int i2, Uri uri, Uri uri2) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptor;
        if (context == null) {
            return;
        }
        InputStream inputStream = null;
        parcelFileDescriptorOpenFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = null;
        inputStream = null;
        try {
            try {
                InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                try {
                    ExifInterface exifInterface = new ExifInterface(inputStreamOpenInputStream);
                    parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri2, "rw");
                    copyExifAttributes(exifInterface, new ExifInterface(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()), i, i2);
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e) {
                        e.getMessage();
                    }
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (IOException e2) {
                    e = e2;
                    parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                    inputStream = inputStreamOpenInputStream;
                    try {
                        e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                e3.getMessage();
                            }
                        }
                        if (parcelFileDescriptor == null) {
                        } else {
                            parcelFileDescriptor.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.getMessage();
                            }
                        }
                        if (parcelFileDescriptor != null) {
                            throw th;
                        }
                        try {
                            parcelFileDescriptor.close();
                            throw th;
                        } catch (IOException e5) {
                            e5.getMessage();
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                    inputStream = inputStreamOpenInputStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (parcelFileDescriptor != null) {
                        throw th;
                    }
                    parcelFileDescriptor.close();
                    throw th;
                }
            } catch (IOException e6) {
                e6.getMessage();
            }
        } catch (IOException e7) {
            e = e7;
            parcelFileDescriptor = null;
        } catch (Throwable th3) {
            th = th3;
            parcelFileDescriptor = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:112:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:92:0x015d A[Catch: all -> 0x0166, Exception -> 0x0169, TryCatch #18 {Exception -> 0x0169, all -> 0x0166, blocks: (B:90:0x0159, B:92:0x015d, B:99:0x017b, B:98:0x016c), top: B:140:0x0159 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x016c A[Catch: all -> 0x0166, Exception -> 0x0169, TryCatch #18 {Exception -> 0x0169, all -> 0x0166, blocks: (B:90:0x0159, B:92:0x015d, B:99:0x017b, B:98:0x016c), top: B:140:0x0159 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.io.BufferedInputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r25v0, types: [androidx.exifinterface.media.ExifInterface] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v7 */
    private static void copyExifAttributes(ExifInterface exifInterface, ExifInterface exifInterface2, int i, int i2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        ?? r14;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream3;
        Object obj;
        FileOutputStream fileOutputStream4;
        ?? bufferedInputStream = "GPSLongitude";
        String str = "GPSLongitudeRef";
        String[] strArr = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "PhotographicSensitivity", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
        for (int i3 = 0; i3 < 22; i3++) {
            String str2 = strArr[i3];
            String attribute = exifInterface.getAttribute(str2);
            if (!TextUtils.isEmpty(attribute)) {
                exifInterface2.setAttribute(str2, attribute);
            }
        }
        exifInterface2.setAttribute("ImageWidth", String.valueOf(i));
        exifInterface2.setAttribute("ImageLength", String.valueOf(i2));
        exifInterface2.setAttribute("Orientation", "0");
        int i4 = exifInterface2.mMimeType;
        if (i4 != 4 && i4 != 13 && i4 != 14) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("ExifInterface only supports saving attributes for JPEG, PNG, and WebP formats.");
            return;
        }
        if (exifInterface2.mSeekableFileDescriptor == null && exifInterface2.mFilename == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("ExifInterface does not support saving attributes for the current input.");
            return;
        }
        if (exifInterface2.mHasThumbnail && exifInterface2.mHasThumbnailStrips && !exifInterface2.mAreThumbnailStripsConsecutive) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips");
            return;
        }
        int i5 = exifInterface2.mThumbnailCompression;
        FileInputStream fileInputStream3 = null;
        FileInputStream fileInputStream4 = null;
        ?? r8 = 0;
        fileInputStream3 = null;
        exifInterface2.mThumbnailBytes = (i5 == 6 || i5 == 7) ? exifInterface2.getThumbnailBytes() : null;
        try {
            File fileCreateTempFile = File.createTempFile("temp", "tmp");
            if (exifInterface2.mFilename != null) {
                fileInputStream = new FileInputStream(exifInterface2.mFilename);
            } else {
                Os.lseek(exifInterface2.mSeekableFileDescriptor, 0L, OsConstants.SEEK_SET);
                fileInputStream = new FileInputStream(exifInterface2.mSeekableFileDescriptor);
            }
            FileInputStream fileInputStream5 = fileInputStream;
            try {
                fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    LifecyclesKt.copy(fileInputStream5, fileOutputStream);
                    LifecyclesKt.closeQuietly(fileInputStream5);
                    LifecyclesKt.closeQuietly(fileOutputStream);
                    try {
                        try {
                            try {
                                FileInputStream fileInputStream6 = new FileInputStream(fileCreateTempFile);
                                try {
                                    if (exifInterface2.mFilename != null) {
                                        fileOutputStream4 = new FileOutputStream(exifInterface2.mFilename);
                                    } else {
                                        Os.lseek(exifInterface2.mSeekableFileDescriptor, 0L, OsConstants.SEEK_SET);
                                        fileOutputStream4 = new FileOutputStream(exifInterface2.mSeekableFileDescriptor);
                                    }
                                    fileOutputStream2 = fileOutputStream4;
                                    try {
                                        bufferedInputStream = new BufferedInputStream(fileInputStream6);
                                        try {
                                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                                            try {
                                                int i6 = exifInterface2.mMimeType;
                                                if (i6 == 4) {
                                                    exifInterface2.saveJpegAttributes(bufferedInputStream, bufferedOutputStream);
                                                } else if (i6 == 13) {
                                                    exifInterface2.savePngAttributes(bufferedInputStream, bufferedOutputStream);
                                                } else if (i6 == 14) {
                                                    exifInterface2.saveWebpAttributes(bufferedInputStream, bufferedOutputStream);
                                                }
                                                LifecyclesKt.closeQuietly(bufferedInputStream);
                                                LifecyclesKt.closeQuietly(bufferedOutputStream);
                                                fileCreateTempFile.delete();
                                                exifInterface2.mThumbnailBytes = null;
                                            } catch (Exception e) {
                                                e = e;
                                                fileInputStream4 = fileInputStream6;
                                                try {
                                                    try {
                                                        fileInputStream2 = new FileInputStream(fileCreateTempFile);
                                                        try {
                                                            if (exifInterface2.mFilename != null) {
                                                                fileOutputStream3 = new FileOutputStream(exifInterface2.mFilename);
                                                            } else {
                                                                Os.lseek(exifInterface2.mSeekableFileDescriptor, 0L, OsConstants.SEEK_SET);
                                                                fileOutputStream3 = new FileOutputStream(exifInterface2.mSeekableFileDescriptor);
                                                            }
                                                            fileOutputStream2 = fileOutputStream3;
                                                            LifecyclesKt.copy(fileInputStream2, fileOutputStream2);
                                                            LifecyclesKt.closeQuietly(fileInputStream2);
                                                            LifecyclesKt.closeQuietly(fileOutputStream2);
                                                            throw new IOException("Failed to save new file", e);
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            fileInputStream4 = fileInputStream2;
                                                            throw new IOException("Failed to save new file. Original file is stored in " + fileCreateTempFile.getAbsolutePath(), e);
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            fileInputStream4 = fileInputStream2;
                                                            LifecyclesKt.closeQuietly(fileInputStream4);
                                                            LifecyclesKt.closeQuietly(fileOutputStream2);
                                                            throw th;
                                                        }
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                }
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            str = null;
                                            r8 = bufferedInputStream;
                                            r14 = str;
                                            LifecyclesKt.closeQuietly(r8);
                                            LifecyclesKt.closeQuietly(r14);
                                            if (0 == 0) {
                                                fileCreateTempFile.delete();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        obj = null;
                                        fileInputStream4 = fileInputStream6;
                                        fileInputStream2 = new FileInputStream(fileCreateTempFile);
                                        if (exifInterface2.mFilename != null) {
                                            fileOutputStream3 = new FileOutputStream(exifInterface2.mFilename);
                                        } else {
                                            Os.lseek(exifInterface2.mSeekableFileDescriptor, 0L, OsConstants.SEEK_SET);
                                            fileOutputStream3 = new FileOutputStream(exifInterface2.mSeekableFileDescriptor);
                                        }
                                        fileOutputStream2 = fileOutputStream3;
                                        LifecyclesKt.copy(fileInputStream2, fileOutputStream2);
                                        LifecyclesKt.closeQuietly(fileInputStream2);
                                        LifecyclesKt.closeQuietly(fileOutputStream2);
                                        throw new IOException("Failed to save new file", e);
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    fileOutputStream2 = null;
                                    obj = null;
                                }
                            } catch (Exception e7) {
                                e = e7;
                                fileOutputStream2 = null;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            r14 = 0;
                            LifecyclesKt.closeQuietly(r8);
                            LifecyclesKt.closeQuietly(r14);
                            if (0 == 0) {
                                fileCreateTempFile.delete();
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Exception e8) {
                    e = e8;
                    fileInputStream3 = fileInputStream5;
                    try {
                        throw new IOException("Failed to copy original file to temp file", e);
                    } catch (Throwable th6) {
                        th = th6;
                        LifecyclesKt.closeQuietly(fileInputStream3);
                        LifecyclesKt.closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream3 = fileInputStream5;
                    LifecyclesKt.closeQuietly(fileInputStream3);
                    LifecyclesKt.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
                fileOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
        } catch (Throwable th9) {
            th = th9;
            fileOutputStream = null;
        }
    }

    private static boolean handles(int i) {
        return (i & EXIF_MAGIC_NUMBER) == EXIF_MAGIC_NUMBER || i == MOTOROLA_TIFF_MAGIC_NUMBER || i == INTEL_TIFF_MAGIC_NUMBER;
    }

    private boolean hasJpegExifPreamble(byte[] bArr, int i) {
        boolean z = bArr != null && i > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
                if (i2 >= bArr2.length) {
                    break;
                }
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
                i2++;
            }
        }
        return z;
    }

    private int moveToExifSegmentAndGetLength() {
        short uInt8;
        while (this.reader.getUInt8() == SEGMENT_START_ID && (uInt8 = this.reader.getUInt8()) != SEGMENT_SOS && uInt8 != MARKER_EOI) {
            int uInt16 = this.reader.getUInt16() - 2;
            if (uInt8 == EXIF_SEGMENT_TYPE) {
                return uInt16;
            }
            long j = uInt16;
            if (this.reader.skip(j) != j) {
                return -1;
            }
        }
        return -1;
    }

    private static int parseExifSegment(RandomAccessReader randomAccessReader) {
        short int16;
        int int32;
        int i;
        int i2;
        short int17 = randomAccessReader.getInt16(6);
        ByteOrder byteOrder = (int17 != MOTOROLA_TIFF_MAGIC_NUMBER && int17 == INTEL_TIFF_MAGIC_NUMBER) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
        randomAccessReader.order(byteOrder);
        int int33 = randomAccessReader.getInt32(10) + 6;
        short int18 = randomAccessReader.getInt16(int33);
        for (int i3 = 0; i3 < int18; i3++) {
            int iCalcTagOffset = calcTagOffset(int33, i3);
            if (randomAccessReader.getInt16(iCalcTagOffset) == ORIENTATION_TAG_TYPE && (int16 = randomAccessReader.getInt16(iCalcTagOffset + 2)) >= 1 && int16 <= 12 && (int32 = randomAccessReader.getInt32(iCalcTagOffset + 4)) >= 0 && (i = int32 + BYTES_PER_FORMAT[int16]) <= 4 && (i2 = iCalcTagOffset + 8) >= 0 && i2 <= randomAccessReader.length() && i >= 0 && i + i2 <= randomAccessReader.length()) {
                return randomAccessReader.getInt16(i2);
            }
        }
        return -1;
    }

    public int getOrientation() {
        int iMoveToExifSegmentAndGetLength;
        if (handles(this.reader.getUInt16()) && (iMoveToExifSegmentAndGetLength = moveToExifSegmentAndGetLength()) != -1) {
            return parseExifSegment(new byte[iMoveToExifSegmentAndGetLength], iMoveToExifSegmentAndGetLength);
        }
        return -1;
    }

    public static void copyExif(Context context, int i, int i2, Uri uri, String str) {
        if (context == null) {
            return;
        }
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                try {
                    inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                    copyExifAttributes(new ExifInterface(inputStreamOpenInputStream), new ExifInterface(str), i, i2);
                    inputStreamOpenInputStream.close();
                } catch (Throwable th) {
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e) {
                            e.getMessage();
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e2.getMessage();
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
            }
        } catch (IOException e3) {
            e3.getMessage();
        }
    }

    private int parseExifSegment(byte[] bArr, int i) {
        if (this.reader.read(bArr, i) == i && hasJpegExifPreamble(bArr, i)) {
            return parseExifSegment(new RandomAccessReader(bArr, i));
        }
        return -1;
    }

    public static void copyExif(ExifInterface exifInterface, int i, int i2, String str) throws Throwable {
        try {
            copyExifAttributes(exifInterface, new ExifInterface(str), i, i2);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void copyExif(Context context, ExifInterface exifInterface, int i, int i2, Uri uri) {
        if (context == null) {
            return;
        }
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = null;
        try {
            try {
                try {
                    parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
                    copyExifAttributes(exifInterface, new ExifInterface(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()), i, i2);
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (Throwable th) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (IOException e) {
                            e.getMessage();
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e2.getMessage();
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
            }
        } catch (IOException e3) {
            e3.getMessage();
        }
    }
}

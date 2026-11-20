package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.TextDelegate;
import androidx.media3.extractor.text.CueDecoder;
import io.ktor.sse.ServerSentEventKt;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Encoding {
    public static final CueDecoder EMPTY_DIAGNOSTICS = new CueDecoder((byte) 20);
    public static final byte[] MAGIC_PROF = {112, 114, 111, 0};
    public static final byte[] MAGIC_PROFM = {112, 114, 109, 0};
    public static final byte[] V015_S = {48, 49, 53, 0};
    public static final byte[] V010_P = {48, 49, 48, 0};
    public static final byte[] V009_O_MR1 = {48, 48, 57, 0};
    public static final byte[] V005_O = {48, 48, 53, 0};
    public static final byte[] V001_N = {48, 48, 49, 0};
    public static final byte[] METADATA_V001_N = {48, 48, 49, 0};
    public static final byte[] METADATA_V002 = {48, 48, 50, 0};

    public static byte[] compress(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    deflaterOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            deflater.end();
            throw th3;
        }
    }

    public static byte[] createCompressibleBody(DexProfileData[] dexProfileDataArr, byte[] bArr) throws IOException {
        int i = 0;
        int length = 0;
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            length += ((((dexProfileData.numMethodIds * 2) + 7) & (-8)) / 8) + (dexProfileData.classSetSize * 2) + generateDexKey(dexProfileData.apkName, dexProfileData.dexName, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + dexProfileData.hotMethodRegionSize;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        if (Arrays.equals(bArr, V009_O_MR1)) {
            int length2 = dexProfileDataArr.length;
            while (i < length2) {
                DexProfileData dexProfileData2 = dexProfileDataArr[i];
                writeLineHeader(byteArrayOutputStream, dexProfileData2, generateDexKey(dexProfileData2.apkName, dexProfileData2.dexName, bArr));
                writeLineData(byteArrayOutputStream, dexProfileData2);
                i++;
            }
        } else {
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                writeLineHeader(byteArrayOutputStream, dexProfileData3, generateDexKey(dexProfileData3.apkName, dexProfileData3.dexName, bArr));
            }
            int length3 = dexProfileDataArr.length;
            while (i < length3) {
                writeLineData(byteArrayOutputStream, dexProfileDataArr[i]);
                i++;
            }
        }
        if (byteArrayOutputStream.size() == length) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + length);
    }

    public static boolean deleteFilesRecursively(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file2 : fileArrListFiles) {
            z = deleteFilesRecursively(file2) && z;
        }
        return z;
    }

    public static String generateDexKey(String str, String str2, byte[] bArr) {
        byte[] bArr2 = V001_N;
        boolean zEquals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = V005_O;
        Object obj = (zEquals || Arrays.equals(bArr, bArr3)) ? ServerSentEventKt.COLON : "!";
        if (str.length() <= 0) {
            if ("!".equals(obj)) {
                return str2.replace(ServerSentEventKt.COLON, "!");
            }
            if (ServerSentEventKt.COLON.equals(obj)) {
                return str2.replace("!", ServerSentEventKt.COLON);
            }
        } else {
            if (str2.equals("classes.dex")) {
                return str;
            }
            if (str2.contains("!") || str2.contains(ServerSentEventKt.COLON)) {
                if ("!".equals(obj)) {
                    return str2.replace(ServerSentEventKt.COLON, "!");
                }
                if (ServerSentEventKt.COLON.equals(obj)) {
                    return str2.replace("!", ServerSentEventKt.COLON);
                }
            } else if (!str2.endsWith(".apk")) {
                return IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(str), (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) ? ServerSentEventKt.COLON : "!", str2);
            }
        }
        return str2;
    }

    public static void noteProfileWrittenFor(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
        }
    }

    public static byte[] read(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m(i, "Not enough bytes to read: "));
                return null;
            }
            i2 += i3;
        }
        return bArr;
    }

    public static int[] readClasses(ByteArrayInputStream byteArrayInputStream, int i) {
        int[] iArr = new int[i];
        int uInt = 0;
        for (int i2 = 0; i2 < i; i2++) {
            uInt += (int) readUInt(byteArrayInputStream, 2);
            iArr[i2] = uInt;
        }
        return iArr;
    }

    public static byte[] readCompressed(FileInputStream fileInputStream, int i, int i2) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i2];
            byte[] bArr2 = new byte[2048];
            int i3 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i3 < i) {
                int i4 = fileInputStream.read(bArr2);
                if (i4 < 0) {
                    throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i + " bytes");
                }
                inflater.setInput(bArr2, 0, i4);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i2 - iInflate);
                    i3 += i4;
                } catch (DataFormatException e) {
                    throw new IllegalStateException(e.getMessage());
                }
            }
            if (i3 == i) {
                if (!inflater.finished()) {
                    throw new IllegalStateException("Inflater did not finish");
                }
                inflater.end();
                return bArr;
            }
            throw new IllegalStateException("Didn't read enough bytes during decompression. expected=" + i + " actual=" + i3);
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    public static DexProfileData[] readMeta(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] bArr3 = METADATA_V001_N;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, METADATA_V002)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unsupported meta version");
                return null;
            }
            int uInt = (int) readUInt(fileInputStream, 2);
            byte[] compressed = readCompressed(fileInputStream, (int) readUInt(fileInputStream, 4), (int) readUInt(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Content found after the end of file");
                return null;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressed);
            try {
                DexProfileData[] metadataV002Body = readMetadataV002Body(byteArrayInputStream, bArr2, uInt, dexProfileDataArr);
                byteArrayInputStream.close();
                return metadataV002Body;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(V015_S, bArr2)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            return null;
        }
        if (!Arrays.equals(bArr, bArr3)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unsupported meta version");
            return null;
        }
        int uInt2 = (int) readUInt(fileInputStream, 1);
        byte[] compressed2 = readCompressed(fileInputStream, (int) readUInt(fileInputStream, 4), (int) readUInt(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Content found after the end of file");
            return null;
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(compressed2);
        try {
            DexProfileData[] metadataForNBody = readMetadataForNBody(byteArrayInputStream2, uInt2, dexProfileDataArr);
            byteArrayInputStream2.close();
            return metadataForNBody;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static DexProfileData[] readMetadataForNBody(ByteArrayInputStream byteArrayInputStream, int i, DexProfileData[] dexProfileDataArr) {
        if (byteArrayInputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i != dexProfileDataArr.length) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Mismatched number of dex files found in metadata");
            return null;
        }
        String[] strArr = new String[i];
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int uInt = (int) readUInt(byteArrayInputStream, 2);
            iArr[i2] = (int) readUInt(byteArrayInputStream, 2);
            strArr[i2] = new String(read(byteArrayInputStream, uInt), StandardCharsets.UTF_8);
        }
        for (int i3 = 0; i3 < i; i3++) {
            DexProfileData dexProfileData = dexProfileDataArr[i3];
            if (!dexProfileData.dexName.equals(strArr[i3])) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Order of dexfiles in metadata did not match baseline");
                return null;
            }
            int i4 = iArr[i3];
            dexProfileData.classSetSize = i4;
            dexProfileData.classes = readClasses(byteArrayInputStream, i4);
        }
        return dexProfileDataArr;
    }

    public static DexProfileData[] readMetadataV002Body(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i, DexProfileData[] dexProfileDataArr) throws IOException {
        DexProfileData dexProfileData;
        if (byteArrayInputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i != dexProfileDataArr.length) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Mismatched number of dex files found in metadata");
            return null;
        }
        for (int i2 = 0; i2 < i; i2++) {
            readUInt(byteArrayInputStream, 2);
            String str = new String(read(byteArrayInputStream, (int) readUInt(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            long uInt = readUInt(byteArrayInputStream, 4);
            int uInt2 = (int) readUInt(byteArrayInputStream, 2);
            if (dexProfileDataArr.length <= 0) {
                dexProfileData = null;
                break;
            }
            int iIndexOf = str.indexOf("!");
            if (iIndexOf < 0) {
                iIndexOf = str.indexOf(ServerSentEventKt.COLON);
            }
            String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
            int i3 = 0;
            while (true) {
                if (i3 >= dexProfileDataArr.length) {
                    dexProfileData = null;
                    break;
                }
                if (dexProfileDataArr[i3].dexName.equals(strSubstring)) {
                    dexProfileData = dexProfileDataArr[i3];
                    break;
                }
                i3++;
            }
            if (dexProfileData == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Missing profile key: ".concat(str));
                return null;
            }
            dexProfileData.mTypeIdCount = uInt;
            int[] classes = readClasses(byteArrayInputStream, uInt2);
            if (Arrays.equals(bArr, V001_N)) {
                dexProfileData.classSetSize = uInt2;
                dexProfileData.classes = classes;
            }
        }
        return dexProfileDataArr;
    }

    public static DexProfileData[] readProfile(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, V010_P)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unsupported version");
            return null;
        }
        int uInt = (int) readUInt(fileInputStream, 1);
        byte[] compressed = readCompressed(fileInputStream, (int) readUInt(fileInputStream, 4), (int) readUInt(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Content found after the end of file");
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressed);
        try {
            DexProfileData[] uncompressedBody = readUncompressedBody(byteArrayInputStream, str, uInt);
            byteArrayInputStream.close();
            return uncompressedBody;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long readUInt(InputStream inputStream, int i) throws IOException {
        byte[] bArr = read(inputStream, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += ((long) (bArr[i2] & 255)) << (i2 * 8);
        }
        return j;
    }

    public static DexProfileData[] readUncompressedBody(ByteArrayInputStream byteArrayInputStream, String str, int i) throws IOException {
        int i2 = 0;
        if (byteArrayInputStream.available() == 0) {
            return new DexProfileData[0];
        }
        DexProfileData[] dexProfileDataArr = new DexProfileData[i];
        for (int i3 = 0; i3 < i; i3++) {
            int uInt = (int) readUInt(byteArrayInputStream, 2);
            int uInt2 = (int) readUInt(byteArrayInputStream, 2);
            dexProfileDataArr[i3] = new DexProfileData(str, new String(read(byteArrayInputStream, uInt), StandardCharsets.UTF_8), readUInt(byteArrayInputStream, 4), uInt2, (int) readUInt(byteArrayInputStream, 4), (int) readUInt(byteArrayInputStream, 4), new int[uInt2], new TreeMap());
        }
        int i4 = 0;
        while (i4 < i) {
            DexProfileData dexProfileData = dexProfileDataArr[i4];
            int iAvailable = byteArrayInputStream.available();
            int i5 = dexProfileData.hotMethodRegionSize;
            int i6 = dexProfileData.numMethodIds;
            TreeMap treeMap = dexProfileData.methods;
            int i7 = iAvailable - i5;
            int uInt3 = i2;
            while (byteArrayInputStream.available() > i7) {
                uInt3 += (int) readUInt(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(uInt3), 1);
                int uInt4 = (int) readUInt(byteArrayInputStream, 2);
                while (uInt4 > 0) {
                    readUInt(byteArrayInputStream, 2);
                    int uInt5 = (int) readUInt(byteArrayInputStream, 1);
                    if (uInt5 != 6 && uInt5 != 7) {
                        while (uInt5 > 0) {
                            readUInt(byteArrayInputStream, 1);
                            int i8 = i2;
                            int i9 = i4;
                            for (int uInt6 = (int) readUInt(byteArrayInputStream, 1); uInt6 > 0; uInt6--) {
                                readUInt(byteArrayInputStream, 2);
                            }
                            uInt5--;
                            i2 = i8;
                            i4 = i9;
                        }
                    }
                    uInt4--;
                    i2 = i2;
                    i4 = i4;
                }
            }
            int i10 = i2;
            int i11 = i4;
            if (byteArrayInputStream.available() != i7) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Read too much data during profile line parse");
                return null;
            }
            dexProfileData.classes = readClasses(byteArrayInputStream, dexProfileData.classSetSize);
            BitSet bitSetValueOf = BitSet.valueOf(read(byteArrayInputStream, (((i6 * 2) + 7) & (-8)) / 8));
            for (int i12 = i10; i12 < i6; i12++) {
                int i13 = bitSetValueOf.get(i12) ? 2 : i10;
                if (bitSetValueOf.get(i12 + i6)) {
                    i13 |= 4;
                }
                if (i13 != 0) {
                    Integer numValueOf = (Integer) treeMap.get(Integer.valueOf(i12));
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(i10);
                    }
                    treeMap.put(Integer.valueOf(i12), Integer.valueOf(i13 | numValueOf.intValue()));
                }
            }
            i4 = i11 + 1;
            i2 = i10;
        }
        return dexProfileDataArr;
    }

    public static boolean transcodeAndWriteBody(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        int i;
        ArrayList arrayList;
        int length;
        byte[] bArr2 = V015_S;
        int i2 = 0;
        if (!Arrays.equals(bArr, bArr2)) {
            byte[] bArr3 = V010_P;
            if (Arrays.equals(bArr, bArr3)) {
                byte[] bArrCreateCompressibleBody = createCompressibleBody(dexProfileDataArr, bArr3);
                writeUInt(byteArrayOutputStream, dexProfileDataArr.length, 1);
                writeUInt(byteArrayOutputStream, bArrCreateCompressibleBody.length, 4);
                byte[] bArrCompress = compress(bArrCreateCompressibleBody);
                writeUInt(byteArrayOutputStream, bArrCompress.length, 4);
                byteArrayOutputStream.write(bArrCompress);
                return true;
            }
            byte[] bArr4 = V005_O;
            if (Arrays.equals(bArr, bArr4)) {
                writeUInt(byteArrayOutputStream, dexProfileDataArr.length, 1);
                for (DexProfileData dexProfileData : dexProfileDataArr) {
                    int size = dexProfileData.methods.size() * 4;
                    String strGenerateDexKey = generateDexKey(dexProfileData.apkName, dexProfileData.dexName, bArr4);
                    Charset charset = StandardCharsets.UTF_8;
                    writeUInt16(byteArrayOutputStream, strGenerateDexKey.getBytes(charset).length);
                    writeUInt16(byteArrayOutputStream, dexProfileData.classes.length);
                    writeUInt(byteArrayOutputStream, size, 4);
                    writeUInt(byteArrayOutputStream, dexProfileData.dexChecksum, 4);
                    byteArrayOutputStream.write(strGenerateDexKey.getBytes(charset));
                    Iterator it = dexProfileData.methods.keySet().iterator();
                    while (it.hasNext()) {
                        writeUInt16(byteArrayOutputStream, ((Integer) it.next()).intValue());
                        writeUInt16(byteArrayOutputStream, 0);
                    }
                    for (int i3 : dexProfileData.classes) {
                        writeUInt16(byteArrayOutputStream, i3);
                    }
                }
                return true;
            }
            byte[] bArr5 = V009_O_MR1;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] bArrCreateCompressibleBody2 = createCompressibleBody(dexProfileDataArr, bArr5);
                writeUInt(byteArrayOutputStream, dexProfileDataArr.length, 1);
                writeUInt(byteArrayOutputStream, bArrCreateCompressibleBody2.length, 4);
                byte[] bArrCompress2 = compress(bArrCreateCompressibleBody2);
                writeUInt(byteArrayOutputStream, bArrCompress2.length, 4);
                byteArrayOutputStream.write(bArrCompress2);
                return true;
            }
            byte[] bArr6 = V001_N;
            if (!Arrays.equals(bArr, bArr6)) {
                return false;
            }
            writeUInt16(byteArrayOutputStream, dexProfileDataArr.length);
            for (DexProfileData dexProfileData2 : dexProfileDataArr) {
                String str = dexProfileData2.apkName;
                TreeMap treeMap = dexProfileData2.methods;
                String strGenerateDexKey2 = generateDexKey(str, dexProfileData2.dexName, bArr6);
                Charset charset2 = StandardCharsets.UTF_8;
                writeUInt16(byteArrayOutputStream, strGenerateDexKey2.getBytes(charset2).length);
                writeUInt16(byteArrayOutputStream, treeMap.size());
                writeUInt16(byteArrayOutputStream, dexProfileData2.classes.length);
                writeUInt(byteArrayOutputStream, dexProfileData2.dexChecksum, 4);
                byteArrayOutputStream.write(strGenerateDexKey2.getBytes(charset2));
                Iterator it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    writeUInt16(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                }
                for (int i4 : dexProfileData2.classes) {
                    writeUInt16(byteArrayOutputStream, i4);
                }
            }
            return true;
        }
        ArrayList arrayList2 = new ArrayList(3);
        ArrayList arrayList3 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            writeUInt16(byteArrayOutputStream2, dexProfileDataArr.length);
            int i5 = 2;
            int i6 = 2;
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                writeUInt(byteArrayOutputStream2, dexProfileData3.dexChecksum, 4);
                writeUInt(byteArrayOutputStream2, dexProfileData3.mTypeIdCount, 4);
                writeUInt(byteArrayOutputStream2, dexProfileData3.numMethodIds, 4);
                String strGenerateDexKey3 = generateDexKey(dexProfileData3.apkName, dexProfileData3.dexName, bArr2);
                Charset charset3 = StandardCharsets.UTF_8;
                int length2 = strGenerateDexKey3.getBytes(charset3).length;
                writeUInt16(byteArrayOutputStream2, length2);
                i6 = i6 + 14 + length2;
                byteArrayOutputStream2.write(strGenerateDexKey3.getBytes(charset3));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i6 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i6 + ", does not match actual size " + byteArray.length);
            }
            WritableFileSection writableFileSection = new WritableFileSection(1, false, byteArray);
            byteArrayOutputStream2.close();
            arrayList2.add(writableFileSection);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i7 = 0;
            int i8 = 0;
            while (i7 < dexProfileDataArr.length) {
                try {
                    DexProfileData dexProfileData4 = dexProfileDataArr[i7];
                    writeUInt16(byteArrayOutputStream3, i7);
                    writeUInt16(byteArrayOutputStream3, dexProfileData4.classSetSize);
                    i8 = i8 + 4 + (dexProfileData4.classSetSize * i5);
                    int[] iArr = dexProfileData4.classes;
                    int length3 = iArr.length;
                    int i9 = i2;
                    while (i2 < length3) {
                        int i10 = iArr[i2];
                        writeUInt16(byteArrayOutputStream3, i10 - i9);
                        i2++;
                        i5 = i5;
                        i9 = i10;
                    }
                    i7++;
                    i2 = 0;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream3.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            int i11 = i5;
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i8 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i8 + ", does not match actual size " + byteArray2.length);
            }
            WritableFileSection writableFileSection2 = new WritableFileSection(3, true, byteArray2);
            byteArrayOutputStream3.close();
            arrayList2.add(writableFileSection2);
            ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
            int i12 = 0;
            int i13 = 0;
            while (i12 < dexProfileDataArr.length) {
                try {
                    DexProfileData dexProfileData5 = dexProfileDataArr[i12];
                    Iterator it3 = dexProfileData5.methods.entrySet().iterator();
                    int iIntValue = 0;
                    while (it3.hasNext()) {
                        iIntValue |= ((Integer) ((Map.Entry) it3.next()).getValue()).intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                    try {
                        writeMethodBitmapForS(byteArrayOutputStream5, iIntValue, dexProfileData5);
                        byte[] byteArray3 = byteArrayOutputStream5.toByteArray();
                        byteArrayOutputStream5.close();
                        ByteArrayOutputStream byteArrayOutputStream6 = new ByteArrayOutputStream();
                        try {
                            writeMethodsWithInlineCaches(byteArrayOutputStream6, dexProfileData5);
                            byte[] byteArray4 = byteArrayOutputStream6.toByteArray();
                            byteArrayOutputStream6.close();
                            writeUInt16(byteArrayOutputStream4, i12);
                            int length4 = byteArray3.length + 2 + byteArray4.length;
                            int i14 = i13 + 6;
                            ArrayList arrayList4 = arrayList3;
                            writeUInt(byteArrayOutputStream4, length4, 4);
                            writeUInt16(byteArrayOutputStream4, iIntValue);
                            byteArrayOutputStream4.write(byteArray3);
                            byteArrayOutputStream4.write(byteArray4);
                            i13 = i14 + length4;
                            i12++;
                            arrayList3 = arrayList4;
                        } catch (Throwable th3) {
                            try {
                                byteArrayOutputStream6.close();
                                throw th3;
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                                throw th3;
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            byteArrayOutputStream5.close();
                            throw th5;
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                            throw th5;
                        }
                    }
                } catch (Throwable th7) {
                    try {
                        byteArrayOutputStream4.close();
                        throw th7;
                    } catch (Throwable th8) {
                        th7.addSuppressed(th8);
                        throw th7;
                    }
                }
            }
            ArrayList arrayList5 = arrayList3;
            byte[] byteArray5 = byteArrayOutputStream4.toByteArray();
            if (i13 != byteArray5.length) {
                throw new IllegalStateException("Expected size " + i13 + ", does not match actual size " + byteArray5.length);
            }
            WritableFileSection writableFileSection3 = new WritableFileSection(4, true, byteArray5);
            byteArrayOutputStream4.close();
            arrayList2.add(writableFileSection3);
            long size2 = 12 + ((long) (arrayList2.size() * 16));
            writeUInt(byteArrayOutputStream, arrayList2.size(), 4);
            int i15 = 0;
            while (i15 < arrayList2.size()) {
                WritableFileSection writableFileSection4 = (WritableFileSection) arrayList2.get(i15);
                int i16 = writableFileSection4.mType;
                byte[] bArr7 = writableFileSection4.mContents;
                int i17 = i11;
                if (i16 == 1) {
                    i = 0;
                } else if (i16 == i17) {
                    i = 1;
                } else if (i16 == 3) {
                    i = i17;
                } else if (i16 == 4) {
                    i = 3;
                } else {
                    if (i16 != 5) {
                        throw null;
                    }
                    i = 4;
                }
                writeUInt(byteArrayOutputStream, i, 4);
                writeUInt(byteArrayOutputStream, size2, 4);
                if (writableFileSection4.mNeedsCompression) {
                    long length5 = bArr7.length;
                    byte[] bArrCompress3 = compress(bArr7);
                    arrayList = arrayList5;
                    arrayList.add(bArrCompress3);
                    writeUInt(byteArrayOutputStream, bArrCompress3.length, 4);
                    writeUInt(byteArrayOutputStream, length5, 4);
                    length = bArrCompress3.length;
                } else {
                    arrayList = arrayList5;
                    arrayList.add(bArr7);
                    writeUInt(byteArrayOutputStream, bArr7.length, 4);
                    writeUInt(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size2 += (long) length;
                i15++;
                arrayList5 = arrayList;
                i11 = i17;
            }
            ArrayList arrayList6 = arrayList5;
            for (int i18 = 0; i18 < arrayList6.size(); i18++) {
                byteArrayOutputStream.write((byte[]) arrayList6.get(i18));
            }
            return true;
        } catch (Throwable th9) {
            try {
                byteArrayOutputStream2.close();
                throw th9;
            } catch (Throwable th10) {
                th9.addSuppressed(th10);
                throw th9;
            }
        }
    }

    public static void writeLineData(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData) throws IOException {
        writeMethodsWithInlineCaches(byteArrayOutputStream, dexProfileData);
        int i = dexProfileData.numMethodIds;
        int[] iArr = dexProfileData.classes;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            writeUInt16(byteArrayOutputStream, i4 - i3);
            i2++;
            i3 = i4;
        }
        byte[] bArr = new byte[(((i * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : dexProfileData.methods.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                int i5 = iIntValue / 8;
                bArr[i5] = (byte) (bArr[i5] | (1 << (iIntValue % 8)));
            }
            if ((iIntValue2 & 4) != 0) {
                int i6 = iIntValue + i;
                int i7 = i6 / 8;
                bArr[i7] = (byte) ((1 << (i6 % 8)) | bArr[i7]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void writeLineHeader(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData, String str) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        writeUInt16(byteArrayOutputStream, str.getBytes(charset).length);
        writeUInt16(byteArrayOutputStream, dexProfileData.classSetSize);
        writeUInt(byteArrayOutputStream, dexProfileData.hotMethodRegionSize, 4);
        writeUInt(byteArrayOutputStream, dexProfileData.dexChecksum, 4);
        writeUInt(byteArrayOutputStream, dexProfileData.numMethodIds, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void writeMethodBitmapForS(ByteArrayOutputStream byteArrayOutputStream, int i, DexProfileData dexProfileData) throws IOException {
        int i2 = dexProfileData.numMethodIds;
        byte[] bArr = new byte[(((Integer.bitCount(i & (-2)) * i2) + 7) & (-8)) / 8];
        for (Map.Entry entry : dexProfileData.methods.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            int i3 = 0;
            for (int i4 = 1; i4 <= 4; i4 <<= 1) {
                if (i4 != 1 && (i4 & i) != 0) {
                    if ((i4 & iIntValue2) == i4) {
                        int i5 = (i3 * i2) + iIntValue;
                        int i6 = i5 / 8;
                        bArr[i6] = (byte) ((1 << (i5 % 8)) | bArr[i6]);
                    }
                    i3++;
                }
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void writeMethodsWithInlineCaches(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData) throws IOException {
        int i = 0;
        for (Map.Entry entry : dexProfileData.methods.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                writeUInt16(byteArrayOutputStream, iIntValue - i);
                writeUInt16(byteArrayOutputStream, 0);
                i = iIntValue;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0162 A[Catch: all -> 0x015f, TRY_ENTER, TryCatch #38 {all -> 0x015f, blocks: (B:88:0x013e, B:90:0x014a, B:101:0x0162, B:102:0x0167), top: B:286:0x013e }] */
    /* JADX WARN: Code duplicated, block: B:108:0x0171 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x0173 A[Catch: IllegalStateException -> 0x0159, IOException -> 0x015b, FileNotFoundException -> 0x015d, TRY_LEAVE, TryCatch #33 {FileNotFoundException -> 0x015d, IOException -> 0x015b, IllegalStateException -> 0x0159, blocks: (B:86:0x0136, B:91:0x0154, B:109:0x0173, B:107:0x0170, B:106:0x016d), top: B:293:0x0136 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x0189  */
    /* JADX WARN: Code duplicated, block: B:126:0x01b3 A[Catch: all -> 0x01c1, TRY_LEAVE, TryCatch #22 {all -> 0x01c1, blocks: (B:124:0x01a7, B:126:0x01b3, B:135:0x01c4), top: B:272:0x01a7, outer: #37 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x01c4 A[Catch: all -> 0x01c1, TRY_ENTER, TRY_LEAVE, TryCatch #22 {all -> 0x01c1, blocks: (B:124:0x01a7, B:126:0x01b3, B:135:0x01c4), top: B:272:0x01a7, outer: #37 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:150:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:151:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:160:0x0211 A[Catch: all -> 0x024f, TryCatch #32 {all -> 0x024f, blocks: (B:158:0x020b, B:160:0x0211, B:161:0x0215, B:163:0x021b), top: B:278:0x020b }] */
    /* JADX WARN: Code duplicated, block: B:163:0x021b A[Catch: all -> 0x024f, TRY_LEAVE, TryCatch #32 {all -> 0x024f, blocks: (B:158:0x020b, B:160:0x0211, B:161:0x0215, B:163:0x021b), top: B:278:0x020b }] */
    /* JADX WARN: Code duplicated, block: B:229:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:233:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:240:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:278:0x020b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:286:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:0x01f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:288:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:290:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:294:0x0220 A[EDGE_INSN: B:294:0x0220->B:165:0x0220 BREAK  A[LOOP:0: B:161:0x0215->B:295:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:55:0x00eb A[Catch: all -> 0x0100, IllegalStateException -> 0x0103, IOException -> 0x0105, TRY_LEAVE, TryCatch #35 {IOException -> 0x0105, IllegalStateException -> 0x0103, blocks: (B:53:0x00e1, B:55:0x00eb, B:66:0x0107, B:67:0x010c), top: B:290:0x00e1, outer: #20 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0107 A[Catch: all -> 0x0100, IllegalStateException -> 0x0103, IOException -> 0x0105, TRY_ENTER, TryCatch #35 {IOException -> 0x0105, IllegalStateException -> 0x0103, blocks: (B:53:0x00e1, B:55:0x00eb, B:66:0x0107, B:67:0x010c), top: B:290:0x00e1, outer: #20 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x014a A[Catch: all -> 0x015f, TRY_LEAVE, TryCatch #38 {all -> 0x015f, blocks: (B:88:0x013e, B:90:0x014a, B:101:0x0162, B:102:0x0167), top: B:286:0x013e }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v25, types: [int] */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v42 */
    /* JADX WARN: Type inference failed for: r7v43 */
    /* JADX WARN: Type inference failed for: r7v44 */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v46 */
    /* JADX WARN: Type inference failed for: r7v47 */
    /* JADX WARN: Type inference failed for: r7v48 */
    /* JADX WARN: Type inference failed for: r7v49 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v51 */
    /* JADX WARN: Type inference failed for: r7v52 */
    /* JADX WARN: Type inference failed for: r7v53 */
    /* JADX WARN: Type inference failed for: r7v54 */
    /* JADX WARN: Type inference failed for: r7v55 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v16 */
    public static void writeProfile(Context context, Executor executor, ProfileInstaller$DiagnosticsCallback profileInstaller$DiagnosticsCallback, boolean z) {
        boolean z2;
        ?? OpenStreamFromAssets;
        byte[] bArr;
        DexProfileData[] profile;
        DexProfileData[] dexProfileDataArr;
        ProfileInstaller$DiagnosticsCallback profileInstaller$DiagnosticsCallback2;
        DexProfileData[] dexProfileDataArr2;
        byte[] bArr2;
        ?? r7;
        byte[] bArr3;
        ?? r8;
        boolean z3;
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        Throwable th2;
        FileChannel channel;
        FileLock fileLockTryLock;
        byte[] bArr4;
        int i;
        ?? r9;
        boolean z4;
        ?? byteArrayOutputStream;
        ?? r10;
        TextDelegate textDelegate;
        ?? r11;
        String str;
        FileInputStream fileInputStreamOpenStreamFromAssets;
        ?? r12;
        ?? r13;
        boolean z5;
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z) {
                File file = new File(filesDir, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
                if (file.exists()) {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                        try {
                            long j = dataInputStream.readLong();
                            dataInputStream.close();
                            z5 = j == packageInfo.lastUpdateTime;
                            if (z5) {
                                profileInstaller$DiagnosticsCallback.onResultReceived(2, null);
                            }
                        } catch (Throwable th3) {
                            try {
                                dataInputStream.close();
                                throw th3;
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                                throw th3;
                            }
                        }
                    } catch (IOException unused) {
                        z5 = false;
                    }
                } else {
                    z5 = false;
                }
                if (z5) {
                    context.getPackageName();
                    ProfileVerifier.writeProfileVerification(context, false);
                    return;
                }
            }
            context.getPackageName();
            File file2 = new File(new File("/data/misc/profiles/cur/0", packageName), "primary.prof");
            TextDelegate textDelegate2 = new TextDelegate(assets, executor, profileInstaller$DiagnosticsCallback, name, file2);
            byte[] bArr5 = (byte[]) textDelegate2.density;
            if (bArr5 != null) {
                if (!file2.exists()) {
                    try {
                        if (file2.createNewFile()) {
                            textDelegate2.softWrap = true;
                            OpenStreamFromAssets = textDelegate2.openStreamFromAssets(assets, "dexopt/baseline.prof");
                            bArr = MAGIC_PROF;
                            if (OpenStreamFromAssets != 0) {
                                if (Arrays.equals(bArr, read(OpenStreamFromAssets, 4))) {
                                    throw new IllegalStateException("Invalid magic");
                                }
                                profile = readProfile(OpenStreamFromAssets, read(OpenStreamFromAssets, 4), (String) textDelegate2.placeholders);
                                OpenStreamFromAssets.close();
                                textDelegate2.paragraphIntrinsics = profile;
                            }
                            dexProfileDataArr = (DexProfileData[]) textDelegate2.paragraphIntrinsics;
                            if (dexProfileDataArr != null) {
                                str = "dexopt/baseline.profm";
                                fileInputStreamOpenStreamFromAssets = textDelegate2.openStreamFromAssets(assets, "dexopt/baseline.profm");
                                r11 = str;
                                if (fileInputStreamOpenStreamFromAssets == null) {
                                    if (fileInputStreamOpenStreamFromAssets != null) {
                                        fileInputStreamOpenStreamFromAssets.close();
                                        r11 = str;
                                    }
                                    textDelegate = null;
                                    OpenStreamFromAssets = r11;
                                } else {
                                    if (Arrays.equals(MAGIC_PROFM, read(fileInputStreamOpenStreamFromAssets, 4))) {
                                        throw new IllegalStateException("Invalid magic");
                                    }
                                    byte[] bArr6 = read(fileInputStreamOpenStreamFromAssets, 4);
                                    textDelegate2.paragraphIntrinsics = readMeta(fileInputStreamOpenStreamFromAssets, bArr6, bArr5, dexProfileDataArr);
                                    fileInputStreamOpenStreamFromAssets.close();
                                    textDelegate = textDelegate2;
                                    OpenStreamFromAssets = bArr6;
                                }
                                if (textDelegate != null) {
                                    textDelegate2 = textDelegate;
                                }
                            }
                            profileInstaller$DiagnosticsCallback2 = (ProfileInstaller$DiagnosticsCallback) textDelegate2.style;
                            dexProfileDataArr2 = (DexProfileData[]) textDelegate2.paragraphIntrinsics;
                            bArr2 = (byte[]) textDelegate2.density;
                            r7 = OpenStreamFromAssets;
                            r7 = OpenStreamFromAssets;
                            if (dexProfileDataArr2 != null) {
                                byteArrayOutputStream = textDelegate2.softWrap;
                                if (byteArrayOutputStream != 0) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                    return;
                                }
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                byteArrayOutputStream.write(bArr);
                                byteArrayOutputStream.write(bArr2);
                                if (transcodeAndWriteBody(byteArrayOutputStream, bArr2, dexProfileDataArr2)) {
                                    textDelegate2.intrinsicsLayoutDirection = byteArrayOutputStream.toByteArray();
                                    byteArrayOutputStream.close();
                                    r10 = byteArrayOutputStream;
                                    textDelegate2.paragraphIntrinsics = null;
                                    r7 = r10;
                                } else {
                                    profileInstaller$DiagnosticsCallback2.onResultReceived(5, null);
                                    textDelegate2.paragraphIntrinsics = null;
                                    byteArrayOutputStream.close();
                                    r7 = byteArrayOutputStream;
                                }
                            }
                            bArr3 = (byte[]) textDelegate2.intrinsicsLayoutDirection;
                            if (bArr3 != null) {
                                if (textDelegate2.softWrap) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                    return;
                                }
                                byteArrayInputStream = new ByteArrayInputStream(bArr3);
                                fileOutputStream = new FileOutputStream((File) textDelegate2.fontFamilyResolver);
                                channel = fileOutputStream.getChannel();
                                fileLockTryLock = channel.tryLock();
                                if (fileLockTryLock != null) {
                                    if (fileLockTryLock.isValid()) {
                                        bArr4 = new byte[512];
                                        while (true) {
                                            i = byteArrayInputStream.read(bArr4);
                                            if (i > 0) {
                                                break;
                                                break;
                                            }
                                            fileOutputStream.write(bArr4, 0, i);
                                        }
                                        r9 = 1;
                                        textDelegate2.result(1, null);
                                        fileLockTryLock.close();
                                        channel.close();
                                        fileOutputStream.close();
                                        byteArrayInputStream.close();
                                        textDelegate2.intrinsicsLayoutDirection = null;
                                        textDelegate2.paragraphIntrinsics = null;
                                        z3 = true;
                                    }
                                }
                                throw new IOException("Unable to acquire a lock on the underlying file channel.");
                            }
                            z3 = false;
                            r9 = 1;
                            if (z3) {
                                noteProfileWrittenFor(packageInfo, filesDir);
                            }
                            z4 = z3;
                            r12 = r9;
                        } else {
                            textDelegate2.result(4, null);
                        }
                    } catch (IOException unused2) {
                        z2 = true;
                        textDelegate2.result(4, null);
                    }
                } else if (file2.canWrite()) {
                    textDelegate2.softWrap = true;
                    try {
                        OpenStreamFromAssets = textDelegate2.openStreamFromAssets(assets, "dexopt/baseline.prof");
                    } catch (FileNotFoundException e) {
                        profileInstaller$DiagnosticsCallback.onResultReceived(6, e);
                        OpenStreamFromAssets = 0;
                    } catch (IOException e2) {
                        profileInstaller$DiagnosticsCallback.onResultReceived(7, e2);
                        OpenStreamFromAssets = 0;
                    }
                    bArr = MAGIC_PROF;
                    try {
                        if (OpenStreamFromAssets != 0) {
                            try {
                                if (Arrays.equals(bArr, read(OpenStreamFromAssets, 4))) {
                                    throw new IllegalStateException("Invalid magic");
                                }
                                profile = readProfile(OpenStreamFromAssets, read(OpenStreamFromAssets, 4), (String) textDelegate2.placeholders);
                                try {
                                    OpenStreamFromAssets.close();
                                } catch (IOException e3) {
                                    profileInstaller$DiagnosticsCallback.onResultReceived(7, e3);
                                }
                                textDelegate2.paragraphIntrinsics = profile;
                            } catch (IOException e4) {
                                profileInstaller$DiagnosticsCallback.onResultReceived(7, e4);
                                try {
                                    OpenStreamFromAssets.close();
                                } catch (IOException e5) {
                                    profileInstaller$DiagnosticsCallback.onResultReceived(7, e5);
                                }
                                profile = null;
                            } catch (IllegalStateException e6) {
                                profileInstaller$DiagnosticsCallback.onResultReceived(8, e6);
                                OpenStreamFromAssets.close();
                                profile = null;
                            }
                        }
                        dexProfileDataArr = (DexProfileData[]) textDelegate2.paragraphIntrinsics;
                        if (dexProfileDataArr != null && (OpenStreamFromAssets = Build.VERSION.SDK_INT) >= 31) {
                            try {
                                str = "dexopt/baseline.profm";
                                fileInputStreamOpenStreamFromAssets = textDelegate2.openStreamFromAssets(assets, "dexopt/baseline.profm");
                                r11 = str;
                                if (fileInputStreamOpenStreamFromAssets == null) {
                                    try {
                                        if (Arrays.equals(MAGIC_PROFM, read(fileInputStreamOpenStreamFromAssets, 4))) {
                                            throw new IllegalStateException("Invalid magic");
                                        }
                                        byte[] bArr7 = read(fileInputStreamOpenStreamFromAssets, 4);
                                        textDelegate2.paragraphIntrinsics = readMeta(fileInputStreamOpenStreamFromAssets, bArr7, bArr5, dexProfileDataArr);
                                        fileInputStreamOpenStreamFromAssets.close();
                                        textDelegate = textDelegate2;
                                        OpenStreamFromAssets = bArr7;
                                    } catch (Throwable th5) {
                                        try {
                                            fileInputStreamOpenStreamFromAssets.close();
                                            throw th5;
                                        } catch (Throwable th6) {
                                            th5.addSuppressed(th6);
                                            throw th5;
                                        }
                                    }
                                } else {
                                    if (fileInputStreamOpenStreamFromAssets != null) {
                                        fileInputStreamOpenStreamFromAssets.close();
                                        r11 = str;
                                    }
                                    textDelegate = null;
                                    OpenStreamFromAssets = r11;
                                }
                            } catch (FileNotFoundException e7) {
                                profileInstaller$DiagnosticsCallback.onResultReceived(9, e7);
                                r11 = OpenStreamFromAssets;
                            } catch (IOException e8) {
                                profileInstaller$DiagnosticsCallback.onResultReceived(7, e8);
                                r11 = OpenStreamFromAssets;
                            } catch (IllegalStateException e9) {
                                textDelegate2.paragraphIntrinsics = null;
                                profileInstaller$DiagnosticsCallback.onResultReceived(8, e9);
                                r11 = OpenStreamFromAssets;
                            }
                            if (textDelegate != null) {
                                textDelegate2 = textDelegate;
                            }
                        }
                        profileInstaller$DiagnosticsCallback2 = (ProfileInstaller$DiagnosticsCallback) textDelegate2.style;
                        dexProfileDataArr2 = (DexProfileData[]) textDelegate2.paragraphIntrinsics;
                        bArr2 = (byte[]) textDelegate2.density;
                        r7 = OpenStreamFromAssets;
                        r7 = OpenStreamFromAssets;
                        if (dexProfileDataArr2 != null && bArr2 != null) {
                            byteArrayOutputStream = textDelegate2.softWrap;
                            if (byteArrayOutputStream != 0) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                return;
                            }
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byteArrayOutputStream.write(bArr);
                                    byteArrayOutputStream.write(bArr2);
                                    if (transcodeAndWriteBody(byteArrayOutputStream, bArr2, dexProfileDataArr2)) {
                                        profileInstaller$DiagnosticsCallback2.onResultReceived(5, null);
                                        textDelegate2.paragraphIntrinsics = null;
                                        byteArrayOutputStream.close();
                                        r7 = byteArrayOutputStream;
                                    } else {
                                        textDelegate2.intrinsicsLayoutDirection = byteArrayOutputStream.toByteArray();
                                        byteArrayOutputStream.close();
                                        r10 = byteArrayOutputStream;
                                        textDelegate2.paragraphIntrinsics = null;
                                        r7 = r10;
                                    }
                                } catch (Throwable th7) {
                                    try {
                                        byteArrayOutputStream.close();
                                        throw th7;
                                    } catch (Throwable th8) {
                                        th7.addSuppressed(th8);
                                        throw th7;
                                    }
                                }
                            } catch (IOException e10) {
                                profileInstaller$DiagnosticsCallback2.onResultReceived(7, e10);
                                r10 = byteArrayOutputStream;
                            } catch (IllegalStateException e11) {
                                profileInstaller$DiagnosticsCallback2.onResultReceived(8, e11);
                                r10 = byteArrayOutputStream;
                            }
                        }
                        bArr3 = (byte[]) textDelegate2.intrinsicsLayoutDirection;
                        if (bArr3 != null) {
                            z3 = false;
                            r9 = 1;
                        } else {
                            try {
                                if (textDelegate2.softWrap) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                    return;
                                }
                                try {
                                    try {
                                        byteArrayInputStream = new ByteArrayInputStream(bArr3);
                                        try {
                                            try {
                                                fileOutputStream = new FileOutputStream((File) textDelegate2.fontFamilyResolver);
                                                try {
                                                    try {
                                                        channel = fileOutputStream.getChannel();
                                                        try {
                                                            fileLockTryLock = channel.tryLock();
                                                            try {
                                                                try {
                                                                    if (fileLockTryLock != null) {
                                                                        try {
                                                                            if (fileLockTryLock.isValid()) {
                                                                                bArr4 = new byte[512];
                                                                                while (true) {
                                                                                    i = byteArrayInputStream.read(bArr4);
                                                                                    if (i > 0) {
                                                                                        break;
                                                                                    } else {
                                                                                        fileOutputStream.write(bArr4, 0, i);
                                                                                    }
                                                                                }
                                                                                r9 = 1;
                                                                                textDelegate2.result(1, null);
                                                                                fileLockTryLock.close();
                                                                                channel.close();
                                                                                fileOutputStream.close();
                                                                                byteArrayInputStream.close();
                                                                                textDelegate2.intrinsicsLayoutDirection = null;
                                                                                textDelegate2.paragraphIntrinsics = null;
                                                                                z3 = true;
                                                                            }
                                                                        } catch (Throwable th9) {
                                                                            th = th9;
                                                                            Throwable th10 = th;
                                                                            if (fileLockTryLock == null) {
                                                                                throw th10;
                                                                            }
                                                                            try {
                                                                                fileLockTryLock.close();
                                                                                throw th10;
                                                                            } catch (Throwable th11) {
                                                                                th10.addSuppressed(th11);
                                                                                throw th10;
                                                                            }
                                                                        }
                                                                    }
                                                                    throw new IOException("Unable to acquire a lock on the underlying file channel.");
                                                                } catch (Throwable th12) {
                                                                    th = th12;
                                                                    Throwable th13 = th;
                                                                    if (channel == null) {
                                                                        throw th13;
                                                                    }
                                                                    try {
                                                                        channel.close();
                                                                        throw th13;
                                                                    } catch (Throwable th14) {
                                                                        th13.addSuppressed(th14);
                                                                        throw th13;
                                                                    }
                                                                }
                                                            } catch (Throwable th15) {
                                                                th = th15;
                                                            }
                                                        } catch (Throwable th16) {
                                                            th = th16;
                                                        }
                                                    } catch (Throwable th17) {
                                                        th = th17;
                                                        th2 = th;
                                                        try {
                                                            fileOutputStream.close();
                                                            throw th2;
                                                        } catch (Throwable th18) {
                                                            th2.addSuppressed(th18);
                                                            throw th2;
                                                        }
                                                    }
                                                } catch (Throwable th19) {
                                                    th = th19;
                                                    th2 = th;
                                                    fileOutputStream.close();
                                                    throw th2;
                                                }
                                            } catch (Throwable th20) {
                                                th = th20;
                                                th = th;
                                                try {
                                                    byteArrayInputStream.close();
                                                    throw th;
                                                } catch (Throwable th21) {
                                                    th.addSuppressed(th21);
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th22) {
                                            th = th22;
                                            th = th;
                                            byteArrayInputStream.close();
                                            throw th;
                                        }
                                    } catch (FileNotFoundException e12) {
                                        e = e12;
                                        textDelegate2.result(6, e);
                                        r8 = r7;
                                        textDelegate2.intrinsicsLayoutDirection = null;
                                        textDelegate2.paragraphIntrinsics = null;
                                        z3 = false;
                                        r9 = r8;
                                    } catch (IOException e13) {
                                        e = e13;
                                        textDelegate2.result(7, e);
                                        r8 = r7;
                                        textDelegate2.intrinsicsLayoutDirection = null;
                                        textDelegate2.paragraphIntrinsics = null;
                                        z3 = false;
                                        r9 = r8;
                                    }
                                } catch (FileNotFoundException e14) {
                                    e = e14;
                                    r7 = 1;
                                    textDelegate2.result(6, e);
                                    r8 = r7;
                                    textDelegate2.intrinsicsLayoutDirection = null;
                                    textDelegate2.paragraphIntrinsics = null;
                                    z3 = false;
                                    r9 = r8;
                                } catch (IOException e15) {
                                    e = e15;
                                    r7 = 1;
                                    textDelegate2.result(7, e);
                                    r8 = r7;
                                    textDelegate2.intrinsicsLayoutDirection = null;
                                    textDelegate2.paragraphIntrinsics = null;
                                    z3 = false;
                                    r9 = r8;
                                }
                            } catch (Throwable th23) {
                                textDelegate2.intrinsicsLayoutDirection = null;
                                textDelegate2.paragraphIntrinsics = null;
                                throw th23;
                            }
                        }
                        if (z3) {
                            noteProfileWrittenFor(packageInfo, filesDir);
                        }
                        z4 = z3;
                        r12 = r9;
                    } catch (Throwable th24) {
                        try {
                            OpenStreamFromAssets.close();
                            throw th24;
                        } catch (IOException e16) {
                            profileInstaller$DiagnosticsCallback.onResultReceived(7, e16);
                            throw th24;
                        }
                    }
                } else {
                    textDelegate2.result(4, null);
                }
                if (z4 || !z) {
                    r13 = 0;
                } else {
                    r13 = r12;
                }
                ProfileVerifier.writeProfileVerification(context, r13);
            }
            textDelegate2.result(3, Integer.valueOf(Build.VERSION.SDK_INT));
            z2 = true;
            z4 = false;
            r12 = z2;
            if (z4) {
                r13 = 0;
            } else {
                r13 = 0;
            }
            ProfileVerifier.writeProfileVerification(context, r13);
        } catch (PackageManager.NameNotFoundException e17) {
            profileInstaller$DiagnosticsCallback.onResultReceived(7, e17);
            ProfileVerifier.writeProfileVerification(context, false);
        }
    }

    public static void writeUInt(OutputStream outputStream, long j, int i) throws IOException {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((j >> (i2 * 8)) & 255);
        }
        outputStream.write(bArr);
    }

    public static void writeUInt16(ByteArrayOutputStream byteArrayOutputStream, int i) throws IOException {
        writeUInt(byteArrayOutputStream, i, 2);
    }
}

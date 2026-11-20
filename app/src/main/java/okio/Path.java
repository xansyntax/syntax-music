package okio;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.materialkolor.dynamiccolor.ContrastCurve;
import com.materialkolor.hct.Hct;
import com.materialkolor.hct.HctSolver;
import com.materialkolor.palettes.TonalPalette;
import com.materialkolor.scheme.DynamicScheme;
import com.metrolist.innertubex.cipher.QuickJsEngine;
import com.metrolist.innertubex.cipher.RemotePlayerConfigParser;
import com.metrolist.innertubex.cipher.ZemerCipherSolver;
import com.metrolist.innertubex.cipher.ZemerCipherSolver$Companion$create$1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.net.ssl.SSLSocket;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.time.Instant;
import kotlin.uuid.UuidKt;
import okhttp3.Protocol;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okio.internal._ZlibJvmKt;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.helpers.NOPLogger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Path implements Comparable {
    public static final String DIRECTORY_SEPARATOR;
    public final ByteString bytes;

    static {
        String str = File.separator;
        str.getClass();
        DIRECTORY_SEPARATOR = str;
    }

    public Path(ByteString byteString) {
        byteString.getClass();
        this.bytes = byteString;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        Path path = (Path) obj;
        path.getClass();
        return this.bytes.compareTo(path.bytes);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Path) && Intrinsics.areEqual(((Path) obj).bytes, this.bytes);
    }

    public final ArrayList getSegmentsBytes() {
        ArrayList arrayList = new ArrayList();
        int iRootLength = okio.internal.Path.rootLength(this);
        ByteString byteString = this.bytes;
        if (iRootLength == -1) {
            iRootLength = 0;
        } else if (iRootLength < byteString.getSize$okio() && byteString.internalGet$okio(iRootLength) == 92) {
            iRootLength++;
        }
        int size$okio = byteString.getSize$okio();
        int i = iRootLength;
        while (iRootLength < size$okio) {
            if (byteString.internalGet$okio(iRootLength) == 47 || byteString.internalGet$okio(iRootLength) == 92) {
                arrayList.add(byteString.substring(i, iRootLength));
                i = iRootLength + 1;
            }
            iRootLength++;
        }
        if (i < byteString.getSize$okio()) {
            arrayList.add(byteString.substring(i, byteString.getSize$okio()));
        }
        return arrayList;
    }

    public final int hashCode() {
        return this.bytes.hashCode();
    }

    public final String name() {
        ByteString byteString = okio.internal.Path.SLASH;
        ByteString byteStringSubstring$default = this.bytes;
        int iLastIndexOf$default = ByteString.lastIndexOf$default(byteStringSubstring$default, byteString);
        if (iLastIndexOf$default == -1) {
            iLastIndexOf$default = ByteString.lastIndexOf$default(byteStringSubstring$default, okio.internal.Path.BACKSLASH);
        }
        if (iLastIndexOf$default != -1) {
            byteStringSubstring$default = ByteString.substring$default(byteStringSubstring$default, iLastIndexOf$default + 1, 0, 2);
        } else if (volumeLetter() != null && byteStringSubstring$default.getSize$okio() == 2) {
            byteStringSubstring$default = ByteString.EMPTY;
        }
        return byteStringSubstring$default.utf8();
    }

    public final Path parent() {
        ByteString byteString = okio.internal.Path.DOT;
        ByteString byteString2 = this.bytes;
        if (Intrinsics.areEqual(byteString2, byteString)) {
            return null;
        }
        ByteString byteString3 = okio.internal.Path.SLASH;
        if (Intrinsics.areEqual(byteString2, byteString3)) {
            return null;
        }
        ByteString byteString4 = okio.internal.Path.BACKSLASH;
        if (Intrinsics.areEqual(byteString2, byteString4)) {
            return null;
        }
        ByteString byteString5 = okio.internal.Path.DOT_DOT;
        byteString2.getClass();
        byteString5.getClass();
        int size$okio = byteString2.getSize$okio();
        byte[] bArr = byteString5.data;
        if (byteString2.rangeEquals(size$okio - bArr.length, byteString5, bArr.length) && (byteString2.getSize$okio() == 2 || byteString2.rangeEquals(byteString2.getSize$okio() - 3, byteString3, 1) || byteString2.rangeEquals(byteString2.getSize$okio() - 3, byteString4, 1))) {
            return null;
        }
        int iLastIndexOf$default = ByteString.lastIndexOf$default(byteString2, byteString3);
        if (iLastIndexOf$default == -1) {
            iLastIndexOf$default = ByteString.lastIndexOf$default(byteString2, byteString4);
        }
        if (iLastIndexOf$default == 2 && volumeLetter() != null) {
            if (byteString2.getSize$okio() == 3) {
                return null;
            }
            return new Path(ByteString.substring$default(byteString2, 0, 3, 1));
        }
        if (iLastIndexOf$default == 1) {
            byteString4.getClass();
            if (byteString2.rangeEquals(0, byteString4, byteString4.getSize$okio())) {
                return null;
            }
        }
        if (iLastIndexOf$default != -1 || volumeLetter() == null) {
            if (iLastIndexOf$default == -1) {
                return new Path(byteString);
            }
            return iLastIndexOf$default == 0 ? new Path(ByteString.substring$default(byteString2, 0, 1, 1)) : new Path(ByteString.substring$default(byteString2, 0, iLastIndexOf$default, 1));
        }
        if (byteString2.getSize$okio() == 2) {
            return null;
        }
        return new Path(ByteString.substring$default(byteString2, 0, 2, 1));
    }

    public final Path relativeTo(Path path) {
        path.getClass();
        ByteString byteString = path.bytes;
        int iRootLength = okio.internal.Path.rootLength(this);
        ByteString byteString2 = this.bytes;
        Path path2 = iRootLength == -1 ? null : new Path(byteString2.substring(0, iRootLength));
        int iRootLength2 = okio.internal.Path.rootLength(path);
        if (!Intrinsics.areEqual(path2, iRootLength2 == -1 ? null : new Path(byteString.substring(0, iRootLength2)))) {
            Path$$ExternalSyntheticBUOutline0.m("Paths of different roots cannot be relative to each other: ", this, " and ", path);
            return null;
        }
        ArrayList segmentsBytes = getSegmentsBytes();
        ArrayList segmentsBytes2 = path.getSegmentsBytes();
        int iMin = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        int i = 0;
        while (i < iMin && Intrinsics.areEqual(segmentsBytes.get(i), segmentsBytes2.get(i))) {
            i++;
        }
        if (i == iMin && byteString2.getSize$okio() == byteString.getSize$okio()) {
            return Companion.get(".");
        }
        if (segmentsBytes2.subList(i, segmentsBytes2.size()).indexOf(okio.internal.Path.DOT_DOT) != -1) {
            Path$$ExternalSyntheticBUOutline0.m("Impossible relative path to resolve: ", this, " and ", path);
            return null;
        }
        if (Intrinsics.areEqual(byteString, okio.internal.Path.DOT)) {
            return this;
        }
        Buffer buffer = new Buffer();
        ByteString slash = okio.internal.Path.getSlash(path);
        if (slash == null && (slash = okio.internal.Path.getSlash(this)) == null) {
            slash = okio.internal.Path.toSlash(DIRECTORY_SEPARATOR);
        }
        int size = segmentsBytes2.size();
        for (int i2 = i; i2 < size; i2++) {
            buffer.write(okio.internal.Path.DOT_DOT);
            buffer.write(slash);
        }
        int size2 = segmentsBytes.size();
        while (i < size2) {
            buffer.write((ByteString) segmentsBytes.get(i));
            buffer.write(slash);
            i++;
        }
        return okio.internal.Path.toPath(buffer, false);
    }

    public final Path resolve(String str) {
        str.getClass();
        Buffer buffer = new Buffer();
        buffer.m1915writeUtf8(str);
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(buffer, false), false);
    }

    public final File toFile() {
        return new File(this.bytes.utf8());
    }

    public final String toString() {
        return this.bytes.utf8();
    }

    public final Character volumeLetter() {
        ByteString byteString = okio.internal.Path.SLASH;
        ByteString byteString2 = this.bytes;
        if (ByteString.indexOf$default(byteString2, byteString) != -1 || byteString2.getSize$okio() < 2 || byteString2.internalGet$okio(1) != 58) {
            return null;
        }
        char cInternalGet$okio = (char) byteString2.internalGet$okio(0);
        if (('a' > cInternalGet$okio || cInternalGet$okio >= '{') && ('A' > cInternalGet$okio || cInternalGet$okio >= '[')) {
            return null;
        }
        return Character.valueOf(cInternalGet$okio);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion implements Saver, CreationExtras.Key, CoroutineContext.Key, kotlinx.io.files.FileSystem, DeferredSocketAdapter.Factory, ILoggerFactory {
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ Companion(byte b) {
            this.$r8$classId = b;
        }

        public static ArrayList alpnProtocolNames(List list) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Protocol) obj) != Protocol.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                arrayList2.add(((Protocol) obj2).protocol);
            }
            return arrayList2;
        }

        public static String buildModifiedPlayerScript$com_github_MetrolistGroup_innertubex(String str, RemotePlayerConfigParser.HardcodedPlayerConfig hardcodedPlayerConfig) {
            str.getClass();
            hardcodedPlayerConfig.getClass();
            String strM = Fragment$5$$ExternalSyntheticOutline0.m("; window._cipherSigFunc=function(sig){try{return ", StringsKt__StringsJVMKt.replace(hardcodedPlayerConfig.sigJsExpression, "INPUT", "sig", false), ";}catch(e){return null;}};window._nTransformFunc=function(n){try{return ", StringsKt__StringsJVMKt.replace(hardcodedPlayerConfig.nJsExpression, "INPUT", "n", false), ";}catch(e){return n;}}; ");
            return StringsKt.contains(str, "})(_yt_player);", false) ? StringsKt__StringsJVMKt.replace(str, "})(_yt_player);", strM.concat(" })(_yt_player);"), false) : IntIntPair$$ExternalSyntheticOutline0.m(str, "\n", strM);
        }

        public static byte[] concatLengthPrefixed(List list) {
            Buffer buffer = new Buffer();
            ArrayList arrayListAlpnProtocolNames = alpnProtocolNames(list);
            int size = arrayListAlpnProtocolNames.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayListAlpnProtocolNames.get(i);
                i++;
                String str = (String) obj;
                buffer.m1913writeByte(str.length());
                buffer.m1915writeUtf8(str);
            }
            return buffer.readByteArray(buffer.size);
        }

        /* JADX WARN: Code duplicated, block: B:66:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:68:0x00d6 A[RETURN] */
        public static ByteString decodeBase64(String str) {
            int i;
            char cCharAt;
            str.getClass();
            byte[] bArr = Base64.BASE64;
            int length = str.length();
            while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
                length--;
            }
            int i2 = (int) ((((long) length) * 6) / 8);
            byte[] bArrCopyOf = new byte[i2];
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i3 >= length) {
                    int i7 = i4 % 4;
                    if (i7 != 1) {
                        if (i7 == 2) {
                            bArrCopyOf[i6] = (byte) ((i5 << 12) >> 16);
                            i6++;
                        } else if (i7 == 3) {
                            int i8 = i5 << 6;
                            int i9 = i6 + 1;
                            bArrCopyOf[i6] = (byte) (i8 >> 16);
                            i6 += 2;
                            bArrCopyOf[i9] = (byte) (i8 >> 8);
                        }
                        if (i6 != i2) {
                            bArrCopyOf = Arrays.copyOf(bArrCopyOf, i6);
                        }
                    }
                    if (bArrCopyOf != null) {
                        return new ByteString(bArrCopyOf);
                    }
                    return null;
                }
                char cCharAt2 = str.charAt(i3);
                if ('A' <= cCharAt2 && cCharAt2 < '[') {
                    i = cCharAt2 - 'A';
                } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                    i = cCharAt2 - 'G';
                } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                    i = cCharAt2 + 4;
                } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                    i = 62;
                } else {
                    if (cCharAt2 != '/' && cCharAt2 != '_') {
                        if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                            break;
                        }
                    } else {
                        i = 63;
                    }
                    i3++;
                }
                i5 = (i5 << 6) | i;
                i4++;
                if (i4 % 4 == 0) {
                    bArrCopyOf[i6] = (byte) (i5 >> 16);
                    int i10 = i6 + 2;
                    bArrCopyOf[i6 + 1] = (byte) (i5 >> 8);
                    i6 += 3;
                    bArrCopyOf[i10] = (byte) i5;
                }
                i3++;
            }
            bArrCopyOf = null;
            if (bArrCopyOf != null) {
                return new ByteString(bArrCopyOf);
            }
            return null;
        }

        public static ByteString decodeHex(String str) {
            if (str.length() % 2 != 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) "Unexpected hex string: ".concat(str));
                return null;
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (_ZlibJvmKt.decodeHexDigit(str.charAt(i2 + 1)) + (_ZlibJvmKt.decodeHexDigit(str.charAt(i2)) << 4));
            }
            return new ByteString(bArr);
        }

        public static ByteString encodeUtf8(String str) {
            str.getClass();
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            bytes.getClass();
            ByteString byteString = new ByteString(bytes);
            byteString.utf8 = str;
            return byteString;
        }

        public static double findBestToneForChroma(double d, double d2, double d3, boolean z) {
            Hct hct = new Hct(HctSolver.solveToInt(d, d2, d3));
            double d4 = d3;
            while (true) {
                double d5 = hct.chroma;
                if (d5 >= d2 || 0.0d > d3 || d3 > 100.0d) {
                    break;
                }
                d3 += z ? -1.0d : 1.0d;
                Hct hct2 = new Hct(HctSolver.solveToInt(d, d2, d3));
                if (d5 < hct2.chroma) {
                    d4 = d3;
                    hct = hct2;
                }
            }
            return d4;
        }

        public static Instant fromEpochSeconds(long j, long j2) {
            long j3 = j2 / 1000000000;
            if ((j2 ^ 1000000000) < 0 && j3 * 1000000000 != j2) {
                j3--;
            }
            long j4 = j + j3;
            if ((j ^ j4) < 0 && (j3 ^ j) >= 0) {
                return j > 0 ? Instant.MAX : Instant.MIN;
            }
            if (j4 < -31557014167219200L) {
                return Instant.MIN;
            }
            if (j4 > 31556889864403199L) {
                return Instant.MAX;
            }
            long j5 = j2 % 1000000000;
            return new Instant(j4, (int) (j5 + ((((j5 ^ 1000000000) & ((-j5) | j5)) >> 63) & 1000000000)));
        }

        public static Path get(String str) {
            str.getClass();
            ByteString byteString = okio.internal.Path.SLASH;
            Buffer buffer = new Buffer();
            buffer.m1915writeUtf8(str);
            return okio.internal.Path.toPath(buffer, false);
        }

        public static Path get$default(File file) {
            String str = Path.DIRECTORY_SEPARATOR;
            String string = file.toString();
            string.getClass();
            return get(string);
        }

        public static ContrastCurve getContrastCurve(double d) {
            if (d == 1.5d) {
                return new ContrastCurve(1.5d, 1.5d, 3.0d, 5.5d);
            }
            if (d == 3.0d) {
                return new ContrastCurve(3.0d, 3.0d, 4.5d, 7.0d);
            }
            if (d == 4.5d) {
                return new ContrastCurve(4.5d, 4.5d, 7.0d, 11.0d);
            }
            if (d == 6.0d) {
                return new ContrastCurve(6.0d, 6.0d, 7.0d, 11.0d);
            }
            if (d == 7.0d) {
                return new ContrastCurve(7.0d, 7.0d, 11.0d, 21.0d);
            }
            if (d == 9.0d) {
                return new ContrastCurve(9.0d, 9.0d, 11.0d, 21.0d);
            }
            if (d == 11.0d) {
                return new ContrastCurve(11.0d, 11.0d, 21.0d, 21.0d);
            }
            return d == 21.0d ? new ContrastCurve(21.0d, 21.0d, 21.0d, 21.0d) : new ContrastCurve(d, d, 7.0d, 21.0d);
        }

        public static double getExpressiveNeutralChroma(Hct hct, boolean z, DynamicScheme.Platform platform) {
            int i;
            double expressiveNeutralHue = getExpressiveNeutralHue(hct);
            if (platform != DynamicScheme.Platform.PHONE) {
                i = 12;
            } else if (z) {
                i = (expressiveNeutralHue < 105.0d || expressiveNeutralHue >= 125.0d) ? 14 : 6;
            } else {
                i = 18;
            }
            return i;
        }

        public static double getExpressiveNeutralHue(Hct hct) {
            return UuidKt.getRotatedHue(hct, new double[]{0.0d, 71.0d, 124.0d, 253.0d, 278.0d, 300.0d, 360.0d}, new double[]{10.0d, 0.0d, 10.0d, 0.0d, 10.0d, 0.0d});
        }

        public static double getVibrantNeutralChroma(Hct hct, DynamicScheme.Platform platform) {
            double vibrantNeutralHue = getVibrantNeutralHue(hct);
            int i = 28;
            if (platform != DynamicScheme.Platform.PHONE && (vibrantNeutralHue < 250.0d || vibrantNeutralHue >= 270.0d)) {
                i = 20;
            }
            return i;
        }

        public static double getVibrantNeutralHue(Hct hct) {
            return UuidKt.getRotatedHue(hct, new double[]{0.0d, 38.0d, 105.0d, 140.0d, 333.0d, 360.0d}, new double[]{-14.0d, 10.0d, -14.0d, 10.0d, -14.0d});
        }

        public static ByteString of$default(byte[] bArr) {
            int length = bArr.length;
            HexFormatKt.checkOffsetAndCount(bArr.length, 0L, length);
            return new ByteString(ArraysKt.copyOfRange(bArr, 0, length));
        }

        public static double tMaxC(TonalPalette tonalPalette) {
            return tMaxC$default(tonalPalette, 0.0d, 100.0d);
        }

        public static double tMaxC$default(TonalPalette tonalPalette, double d, double d2) {
            return UuidKt.coerceIn(findBestToneForChroma(tonalPalette.hue, tonalPalette.chroma * 1.0d, 100.0d, true), d, d2);
        }

        public static double tMinC(TonalPalette tonalPalette, double d, double d2) {
            return UuidKt.coerceIn(findBestToneForChroma(tonalPalette.hue, tonalPalette.chroma, 0.0d, false), d, d2);
        }

        /* JADX WARN: Code duplicated, block: B:40:0x009f  */
        /* JADX WARN: Code duplicated, block: B:41:0x00a0 A[Catch: Exception -> 0x0042, CancellationException -> 0x0048, TryCatch #4 {CancellationException -> 0x0048, Exception -> 0x0042, blocks: (B:15:0x003d, B:53:0x00de, B:55:0x00e2, B:57:0x00e8, B:59:0x00ee, B:61:0x00f6, B:63:0x00fc, B:64:0x0103, B:22:0x0050, B:50:0x00cd, B:25:0x005b, B:47:0x00b9, B:28:0x0065, B:44:0x00a6, B:31:0x006f, B:38:0x008e, B:41:0x00a0), top: B:77:0x0022 }] */
        /* JADX WARN: Code duplicated, block: B:43:0x00a4  */
        /* JADX WARN: Code duplicated, block: B:44:0x00a6 A[Catch: Exception -> 0x0042, CancellationException -> 0x0048, PHI: r8 r9 r10
          0x00a6: PHI (r8v10 com.metrolist.innertubex.cipher.QuickJsEngine) = (r8v8 com.metrolist.innertubex.cipher.QuickJsEngine), (r8v11 com.metrolist.innertubex.cipher.QuickJsEngine) binds: [B:42:0x00a2, B:28:0x0065] A[DONT_GENERATE, DONT_INLINE]
          0x00a6: PHI (r9v5 com.metrolist.innertubex.cipher.RemotePlayerConfigParser$HardcodedPlayerConfig) = 
          (r9v3 com.metrolist.innertubex.cipher.RemotePlayerConfigParser$HardcodedPlayerConfig)
          (r9v6 com.metrolist.innertubex.cipher.RemotePlayerConfigParser$HardcodedPlayerConfig)
         binds: [B:42:0x00a2, B:28:0x0065] A[DONT_GENERATE, DONT_INLINE]
          0x00a6: PHI (r10v7 java.lang.String) = (r10v5 java.lang.String), (r10v8 java.lang.String) binds: [B:42:0x00a2, B:28:0x0065] A[DONT_GENERATE, DONT_INLINE], TryCatch #4 {CancellationException -> 0x0048, Exception -> 0x0042, blocks: (B:15:0x003d, B:53:0x00de, B:55:0x00e2, B:57:0x00e8, B:59:0x00ee, B:61:0x00f6, B:63:0x00fc, B:64:0x0103, B:22:0x0050, B:50:0x00cd, B:25:0x005b, B:47:0x00b9, B:28:0x0065, B:44:0x00a6, B:31:0x006f, B:38:0x008e, B:41:0x00a0), top: B:77:0x0022 }] */
        /* JADX WARN: Code duplicated, block: B:46:0x00b7  */
        /* JADX WARN: Code duplicated, block: B:47:0x00b9 A[Catch: Exception -> 0x0042, CancellationException -> 0x0048, PHI: r8 r9 r10
          0x00b9: PHI (r8v12 com.metrolist.innertubex.cipher.QuickJsEngine) = (r8v25 com.metrolist.innertubex.cipher.QuickJsEngine), (r8v26 com.metrolist.innertubex.cipher.QuickJsEngine) binds: [B:45:0x00b5, B:25:0x005b] A[DONT_GENERATE, DONT_INLINE]
          0x00b9: PHI (r9v7 com.metrolist.innertubex.cipher.RemotePlayerConfigParser$HardcodedPlayerConfig) = 
          (r9v5 com.metrolist.innertubex.cipher.RemotePlayerConfigParser$HardcodedPlayerConfig)
          (r9v9 com.metrolist.innertubex.cipher.RemotePlayerConfigParser$HardcodedPlayerConfig)
         binds: [B:45:0x00b5, B:25:0x005b] A[DONT_GENERATE, DONT_INLINE]
          0x00b9: PHI (r10v9 java.lang.String) = (r10v7 java.lang.String), (r10v10 java.lang.String) binds: [B:45:0x00b5, B:25:0x005b] A[DONT_GENERATE, DONT_INLINE], TryCatch #4 {CancellationException -> 0x0048, Exception -> 0x0042, blocks: (B:15:0x003d, B:53:0x00de, B:55:0x00e2, B:57:0x00e8, B:59:0x00ee, B:61:0x00f6, B:63:0x00fc, B:64:0x0103, B:22:0x0050, B:50:0x00cd, B:25:0x005b, B:47:0x00b9, B:28:0x0065, B:44:0x00a6, B:31:0x006f, B:38:0x008e, B:41:0x00a0), top: B:77:0x0022 }] */
        /* JADX WARN: Code duplicated, block: B:49:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:50:0x00cd A[Catch: Exception -> 0x0042, CancellationException -> 0x0048, PHI: r8
          0x00cd: PHI (r8v14 com.metrolist.innertubex.cipher.QuickJsEngine) = (r8v23 com.metrolist.innertubex.cipher.QuickJsEngine), (r8v24 com.metrolist.innertubex.cipher.QuickJsEngine) binds: [B:48:0x00ca, B:22:0x0050] A[DONT_GENERATE, DONT_INLINE], TryCatch #4 {CancellationException -> 0x0048, Exception -> 0x0042, blocks: (B:15:0x003d, B:53:0x00de, B:55:0x00e2, B:57:0x00e8, B:59:0x00ee, B:61:0x00f6, B:63:0x00fc, B:64:0x0103, B:22:0x0050, B:50:0x00cd, B:25:0x005b, B:47:0x00b9, B:28:0x0065, B:44:0x00a6, B:31:0x006f, B:38:0x008e, B:41:0x00a0), top: B:77:0x0022 }] */
        /* JADX WARN: Code duplicated, block: B:52:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:55:0x00e2 A[Catch: Exception -> 0x0042, CancellationException -> 0x0048, TryCatch #4 {CancellationException -> 0x0048, Exception -> 0x0042, blocks: (B:15:0x003d, B:53:0x00de, B:55:0x00e2, B:57:0x00e8, B:59:0x00ee, B:61:0x00f6, B:63:0x00fc, B:64:0x0103, B:22:0x0050, B:50:0x00cd, B:25:0x005b, B:47:0x00b9, B:28:0x0065, B:44:0x00a6, B:31:0x006f, B:38:0x008e, B:41:0x00a0), top: B:77:0x0022 }] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        public Object create(String str, RemotePlayerConfigParser.HardcodedPlayerConfig hardcodedPlayerConfig, ContinuationImpl continuationImpl) throws Exception {
            ZemerCipherSolver$Companion$create$1 zemerCipherSolver$Companion$create$1;
            Exception e;
            QuickJsEngine quickJsEngine;
            CancellationException e2;
            String str2;
            QuickJsEngine quickJsEngine2;
            Object objExecute;
            Object objExecute2;
            QuickJsEngine quickJsEngine3;
            Object objExecute3;
            QuickJsEngine quickJsEngine4;
            QuickJsEngine quickJsEngine5;
            String str3;
            if (continuationImpl instanceof ZemerCipherSolver$Companion$create$1) {
                zemerCipherSolver$Companion$create$1 = (ZemerCipherSolver$Companion$create$1) continuationImpl;
                int i = zemerCipherSolver$Companion$create$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    zemerCipherSolver$Companion$create$1.label = i - Integer.MIN_VALUE;
                } else {
                    zemerCipherSolver$Companion$create$1 = new ZemerCipherSolver$Companion$create$1(this, continuationImpl);
                }
            } else {
                zemerCipherSolver$Companion$create$1 = new ZemerCipherSolver$Companion$create$1(this, continuationImpl);
            }
            Object objCallFunction = zemerCipherSolver$Companion$create$1.result;
            int i2 = zemerCipherSolver$Companion$create$1.label;
            Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                switch (i2) {
                    case 0:
                        ResultKt.throwOnFailure(objCallFunction);
                        quickJsEngine = new QuickJsEngine();
                        try {
                            zemerCipherSolver$Companion$create$1.L$0 = str;
                            zemerCipherSolver$Companion$create$1.L$1 = hardcodedPlayerConfig;
                            zemerCipherSolver$Companion$create$1.L$2 = quickJsEngine;
                            zemerCipherSolver$Companion$create$1.label = 1;
                            if (quickJsEngine.initialize(zemerCipherSolver$Companion$create$1) != obj) {
                                str2 = str;
                                quickJsEngine2 = quickJsEngine;
                                zemerCipherSolver$Companion$create$1.L$0 = str2;
                                zemerCipherSolver$Companion$create$1.L$1 = hardcodedPlayerConfig;
                                zemerCipherSolver$Companion$create$1.L$2 = quickJsEngine2;
                                zemerCipherSolver$Companion$create$1.label = 2;
                                objExecute = quickJsEngine2.execute("if (typeof globalThis.XMLHttpRequest === \"undefined\") {\n    globalThis.XMLHttpRequest = { prototype: {} };\n}\nif (typeof URL === \"undefined\") {\n    globalThis.location = {\n        hash: \"\",\n        host: \"www.youtube.com\",\n        hostname: \"www.youtube.com\",\n        href: \"https://www.youtube.com/watch?v=yt-dlp-wins\",\n        origin: \"https://www.youtube.com\",\n        password: \"\",\n        pathname: \"/watch\",\n        port: \"\",\n        protocol: \"https:\",\n        search: \"?v=yt-dlp-wins\",\n        username: \"\",\n    };\n} else {\n    globalThis.location = new URL(\"https://www.youtube.com/watch?v=yt-dlp-wins\");\n}\nif (typeof globalThis.document === \"undefined\") {\n    globalThis.document = Object.create(null);\n}\nif (typeof globalThis.navigator === \"undefined\") {\n    globalThis.navigator = Object.create(null);\n}\nif (typeof globalThis.self === \"undefined\") {\n    globalThis.self = globalThis;\n}\nif (typeof globalThis.window === \"undefined\") {\n    globalThis.window = globalThis;\n}\nif (typeof globalThis.Intl === \"undefined\") {\n    const NumberFormat = function(locale, options) {\n        this.options = options || {};\n    };\n    NumberFormat.supportedLocalesOf = function(locales) {\n        return Array.isArray(locales) ? locales : [locales];\n    };\n    NumberFormat.prototype.format = function(value) {\n        let formatted = String(value);\n        const minimumDigits = this.options.minimumIntegerDigits || 0;\n        while (formatted.length < minimumDigits) formatted = \"0\" + formatted;\n        return formatted;\n    };\n    const DateTimeFormat = function() {};\n    DateTimeFormat.prototype.resolvedOptions = function() {\n        return { timeZone: \"UTC\" };\n    };\n    DateTimeFormat.prototype.format = function(value) {\n        return String(value);\n    };\n    globalThis.Intl = { NumberFormat, DateTimeFormat };\n}", zemerCipherSolver$Companion$create$1);
                                if (objExecute == obj) {
                                    objExecute = Unit.INSTANCE;
                                }
                                if (objExecute == obj) {
                                    zemerCipherSolver$Companion$create$1.L$0 = str2;
                                    zemerCipherSolver$Companion$create$1.L$1 = hardcodedPlayerConfig;
                                    zemerCipherSolver$Companion$create$1.L$2 = quickJsEngine2;
                                    zemerCipherSolver$Companion$create$1.label = 3;
                                    objExecute2 = quickJsEngine2.execute("globalThis._yt_player = globalThis._yt_player || {};", zemerCipherSolver$Companion$create$1);
                                    quickJsEngine3 = quickJsEngine2;
                                    if (objExecute2 != obj) {
                                        String strBuildModifiedPlayerScript$com_github_MetrolistGroup_innertubex = buildModifiedPlayerScript$com_github_MetrolistGroup_innertubex(str2, hardcodedPlayerConfig);
                                        zemerCipherSolver$Companion$create$1.L$0 = null;
                                        zemerCipherSolver$Companion$create$1.L$1 = null;
                                        zemerCipherSolver$Companion$create$1.L$2 = quickJsEngine3;
                                        zemerCipherSolver$Companion$create$1.label = 4;
                                        objExecute3 = quickJsEngine3.execute(strBuildModifiedPlayerScript$com_github_MetrolistGroup_innertubex, zemerCipherSolver$Companion$create$1);
                                        quickJsEngine4 = quickJsEngine3;
                                        if (objExecute3 == obj) {
                                            zemerCipherSolver$Companion$create$1.L$0 = null;
                                            zemerCipherSolver$Companion$create$1.L$1 = null;
                                            zemerCipherSolver$Companion$create$1.L$2 = quickJsEngine4;
                                            zemerCipherSolver$Companion$create$1.label = 5;
                                            objCallFunction = quickJsEngine4.callFunction("_nTransformFunc", "KdrqFlzJXl9EcCwlmEy", zemerCipherSolver$Companion$create$1);
                                            quickJsEngine5 = quickJsEngine4;
                                            if (objCallFunction == obj) {
                                            }
                                            str3 = (String) objCallFunction;
                                            if (str3 != null || str3.equals("KdrqFlzJXl9EcCwlmEy") || str3.length() < 5 || !ZemerCipherSolver.VALID_N_RESULT.matches(str3)) {
                                                throw new IllegalStateException("Faraday n-transform probe failed");
                                            }
                                            return new ZemerCipherSolver(quickJsEngine5);
                                        }
                                    }
                                }
                            }
                        } catch (CancellationException e3) {
                            e2 = e3;
                            zemerCipherSolver$Companion$create$1.L$0 = null;
                            zemerCipherSolver$Companion$create$1.L$1 = null;
                            zemerCipherSolver$Companion$create$1.L$2 = null;
                            zemerCipherSolver$Companion$create$1.L$3 = e2;
                            zemerCipherSolver$Companion$create$1.label = 6;
                            if (quickJsEngine.dispose(zemerCipherSolver$Companion$create$1) != obj) {
                                throw e2;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            zemerCipherSolver$Companion$create$1.L$0 = null;
                            zemerCipherSolver$Companion$create$1.L$1 = null;
                            zemerCipherSolver$Companion$create$1.L$2 = null;
                            zemerCipherSolver$Companion$create$1.L$3 = e;
                            zemerCipherSolver$Companion$create$1.label = 7;
                            if (quickJsEngine.dispose(zemerCipherSolver$Companion$create$1) != obj) {
                                throw e;
                            }
                        }
                        return obj;
                    case 1:
                        QuickJsEngine quickJsEngine6 = zemerCipherSolver$Companion$create$1.L$2;
                        hardcodedPlayerConfig = zemerCipherSolver$Companion$create$1.L$1;
                        str2 = zemerCipherSolver$Companion$create$1.L$0;
                        ResultKt.throwOnFailure(objCallFunction);
                        quickJsEngine2 = quickJsEngine6;
                        zemerCipherSolver$Companion$create$1.L$0 = str2;
                        zemerCipherSolver$Companion$create$1.L$1 = hardcodedPlayerConfig;
                        zemerCipherSolver$Companion$create$1.L$2 = quickJsEngine2;
                        zemerCipherSolver$Companion$create$1.label = 2;
                        objExecute = quickJsEngine2.execute("if (typeof globalThis.XMLHttpRequest === \"undefined\") {\n    globalThis.XMLHttpRequest = { prototype: {} };\n}\nif (typeof URL === \"undefined\") {\n    globalThis.location = {\n        hash: \"\",\n        host: \"www.youtube.com\",\n        hostname: \"www.youtube.com\",\n        href: \"https://www.youtube.com/watch?v=yt-dlp-wins\",\n        origin: \"https://www.youtube.com\",\n        password: \"\",\n        pathname: \"/watch\",\n        port: \"\",\n        protocol: \"https:\",\n        search: \"?v=yt-dlp-wins\",\n        username: \"\",\n    };\n} else {\n    globalThis.location = new URL(\"https://www.youtube.com/watch?v=yt-dlp-wins\");\n}\nif (typeof globalThis.document === \"undefined\") {\n    globalThis.document = Object.create(null);\n}\nif (typeof globalThis.navigator === \"undefined\") {\n    globalThis.navigator = Object.create(null);\n}\nif (typeof globalThis.self === \"undefined\") {\n    globalThis.self = globalThis;\n}\nif (typeof globalThis.window === \"undefined\") {\n    globalThis.window = globalThis;\n}\nif (typeof globalThis.Intl === \"undefined\") {\n    const NumberFormat = function(locale, options) {\n        this.options = options || {};\n    };\n    NumberFormat.supportedLocalesOf = function(locales) {\n        return Array.isArray(locales) ? locales : [locales];\n    };\n    NumberFormat.prototype.format = function(value) {\n        let formatted = String(value);\n        const minimumDigits = this.options.minimumIntegerDigits || 0;\n        while (formatted.length < minimumDigits) formatted = \"0\" + formatted;\n        return formatted;\n    };\n    const DateTimeFormat = function() {};\n    DateTimeFormat.prototype.resolvedOptions = function() {\n        return { timeZone: \"UTC\" };\n    };\n    DateTimeFormat.prototype.format = function(value) {\n        return String(value);\n    };\n    globalThis.Intl = { NumberFormat, DateTimeFormat };\n}", zemerCipherSolver$Companion$create$1);
                        if (objExecute == obj) {
                            objExecute = Unit.INSTANCE;
                        }
                        if (objExecute == obj) {
                            zemerCipherSolver$Companion$create$1.L$0 = str2;
                            zemerCipherSolver$Companion$create$1.L$1 = hardcodedPlayerConfig;
                            zemerCipherSolver$Companion$create$1.L$2 = quickJsEngine2;
                            zemerCipherSolver$Companion$create$1.label = 3;
                            objExecute2 = quickJsEngine2.execute("globalThis._yt_player = globalThis._yt_player || {};", zemerCipherSolver$Companion$create$1);
                            quickJsEngine3 = quickJsEngine2;
                            if (objExecute2 != obj) {
                                String strBuildModifiedPlayerScript$com_github_MetrolistGroup_innertubex2 = buildModifiedPlayerScript$com_github_MetrolistGroup_innertubex(str2, hardcodedPlayerConfig);
                                zemerCipherSolver$Companion$create$1.L$0 = null;
                                zemerCipherSolver$Companion$create$1.L$1 = null;
                                zemerCipherSolver$Companion$create$1.L$2 = quickJsEngine3;
                                zemerCipherSolver$Companion$create$1.label = 4;
                                objExecute3 = quickJsEngine3.execute(strBuildModifiedPlayerScript$com_github_MetrolistGroup_innertubex2, zemerCipherSolver$Companion$create$1);
                                quickJsEngine4 = quickJsEngine3;
                                if (objExecute3 == obj) {
                                    zemerCipherSolver$Companion$create$1.L$0 = null;
                                    zemerCipherSolver$Companion$create$1.L$1 = null;
                                    zemerCipherSolver$Companion$create$1.L$2 = quickJsEngine4;
                                    zemerCipherSolver$Companion$create$1.label = 5;
                                    objCallFunction = quickJsEngine4.callFunction("_nTransformFunc", "KdrqFlzJXl9EcCwlmEy", zemerCipherSolver$Companion$create$1);
                                    quickJsEngine5 = quickJsEngine4;
                                    if (objCallFunction == obj) {
                                    }
                                    str3 = (String) objCallFunction;
                                    if (str3 != null) {
                                        break;
                                    }
                                    throw new IllegalStateException("Faraday n-transform probe failed");
                                }
                            }
                        }
                        return obj;
                    case 2:
                        quickJsEngine2 = zemerCipherSolver$Companion$create$1.L$2;
                        hardcodedPlayerConfig = zemerCipherSolver$Companion$create$1.L$1;
                        str2 = zemerCipherSolver$Companion$create$1.L$0;
                        ResultKt.throwOnFailure(objCallFunction);
                        zemerCipherSolver$Companion$create$1.L$0 = str2;
                        zemerCipherSolver$Companion$create$1.L$1 = hardcodedPlayerConfig;
                        zemerCipherSolver$Companion$create$1.L$2 = quickJsEngine2;
                        zemerCipherSolver$Companion$create$1.label = 3;
                        objExecute2 = quickJsEngine2.execute("globalThis._yt_player = globalThis._yt_player || {};", zemerCipherSolver$Companion$create$1);
                        quickJsEngine3 = quickJsEngine2;
                        if (objExecute2 != obj) {
                            String strBuildModifiedPlayerScript$com_github_MetrolistGroup_innertubex3 = buildModifiedPlayerScript$com_github_MetrolistGroup_innertubex(str2, hardcodedPlayerConfig);
                            zemerCipherSolver$Companion$create$1.L$0 = null;
                            zemerCipherSolver$Companion$create$1.L$1 = null;
                            zemerCipherSolver$Companion$create$1.L$2 = quickJsEngine3;
                            zemerCipherSolver$Companion$create$1.label = 4;
                            objExecute3 = quickJsEngine3.execute(strBuildModifiedPlayerScript$com_github_MetrolistGroup_innertubex3, zemerCipherSolver$Companion$create$1);
                            quickJsEngine4 = quickJsEngine3;
                            if (objExecute3 == obj) {
                                zemerCipherSolver$Companion$create$1.L$0 = null;
                                zemerCipherSolver$Companion$create$1.L$1 = null;
                                zemerCipherSolver$Companion$create$1.L$2 = quickJsEngine4;
                                zemerCipherSolver$Companion$create$1.label = 5;
                                objCallFunction = quickJsEngine4.callFunction("_nTransformFunc", "KdrqFlzJXl9EcCwlmEy", zemerCipherSolver$Companion$create$1);
                                quickJsEngine5 = quickJsEngine4;
                                if (objCallFunction == obj) {
                                }
                                str3 = (String) objCallFunction;
                                if (str3 != null) {
                                    break;
                                }
                                throw new IllegalStateException("Faraday n-transform probe failed");
                            }
                        }
                        return obj;
                    case 3:
                        QuickJsEngine quickJsEngine7 = zemerCipherSolver$Companion$create$1.L$2;
                        hardcodedPlayerConfig = zemerCipherSolver$Companion$create$1.L$1;
                        str2 = zemerCipherSolver$Companion$create$1.L$0;
                        ResultKt.throwOnFailure(objCallFunction);
                        quickJsEngine3 = quickJsEngine7;
                        String strBuildModifiedPlayerScript$com_github_MetrolistGroup_innertubex4 = buildModifiedPlayerScript$com_github_MetrolistGroup_innertubex(str2, hardcodedPlayerConfig);
                        zemerCipherSolver$Companion$create$1.L$0 = null;
                        zemerCipherSolver$Companion$create$1.L$1 = null;
                        zemerCipherSolver$Companion$create$1.L$2 = quickJsEngine3;
                        zemerCipherSolver$Companion$create$1.label = 4;
                        objExecute3 = quickJsEngine3.execute(strBuildModifiedPlayerScript$com_github_MetrolistGroup_innertubex4, zemerCipherSolver$Companion$create$1);
                        quickJsEngine4 = quickJsEngine3;
                        if (objExecute3 == obj) {
                            zemerCipherSolver$Companion$create$1.L$0 = null;
                            zemerCipherSolver$Companion$create$1.L$1 = null;
                            zemerCipherSolver$Companion$create$1.L$2 = quickJsEngine4;
                            zemerCipherSolver$Companion$create$1.label = 5;
                            objCallFunction = quickJsEngine4.callFunction("_nTransformFunc", "KdrqFlzJXl9EcCwlmEy", zemerCipherSolver$Companion$create$1);
                            quickJsEngine5 = quickJsEngine4;
                            if (objCallFunction == obj) {
                            }
                            str3 = (String) objCallFunction;
                            if (str3 != null) {
                                break;
                            }
                            throw new IllegalStateException("Faraday n-transform probe failed");
                        }
                        return obj;
                    case 4:
                        QuickJsEngine quickJsEngine8 = zemerCipherSolver$Companion$create$1.L$2;
                        ResultKt.throwOnFailure(objCallFunction);
                        quickJsEngine4 = quickJsEngine8;
                        zemerCipherSolver$Companion$create$1.L$0 = null;
                        zemerCipherSolver$Companion$create$1.L$1 = null;
                        zemerCipherSolver$Companion$create$1.L$2 = quickJsEngine4;
                        zemerCipherSolver$Companion$create$1.label = 5;
                        objCallFunction = quickJsEngine4.callFunction("_nTransformFunc", "KdrqFlzJXl9EcCwlmEy", zemerCipherSolver$Companion$create$1);
                        quickJsEngine5 = quickJsEngine4;
                        if (objCallFunction == obj) {
                            return obj;
                        }
                        str3 = (String) objCallFunction;
                        if (str3 != null) {
                            break;
                        }
                        throw new IllegalStateException("Faraday n-transform probe failed");
                    case 5:
                        QuickJsEngine quickJsEngine9 = zemerCipherSolver$Companion$create$1.L$2;
                        ResultKt.throwOnFailure(objCallFunction);
                        quickJsEngine5 = quickJsEngine9;
                        str3 = (String) objCallFunction;
                        if (str3 != null) {
                            break;
                        }
                        throw new IllegalStateException("Faraday n-transform probe failed");
                    case 6:
                        CancellationException cancellationException = (CancellationException) zemerCipherSolver$Companion$create$1.L$3;
                        ResultKt.throwOnFailure(objCallFunction);
                        throw cancellationException;
                    case 7:
                        Exception exc = zemerCipherSolver$Companion$create$1.L$3;
                        ResultKt.throwOnFailure(objCallFunction);
                        throw exc;
                    default:
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                }
            } catch (CancellationException e5) {
                e2 = e5;
                quickJsEngine = str;
            } catch (Exception e6) {
                e = e6;
                quickJsEngine = str;
            }
        }

        @Override // org.slf4j.ILoggerFactory
        public Logger getLogger(String str) {
            return NOPLogger.NOP_LOGGER;
        }

        public ListBuilder list(kotlinx.io.files.Path path) throws IOException {
            path.getClass();
            File file = path.file;
            if (!file.exists()) {
                throw new FileNotFoundException(file.getAbsolutePath());
            }
            if (!file.isDirectory()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$5(file.getAbsolutePath(), "Not a directory: ");
                return null;
            }
            ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
            String[] list = file.list();
            if (list != null) {
                for (String str : list) {
                    str.getClass();
                    listBuilderCreateListBuilder.add(CollectionsKt__IterablesKt.Path(path, str));
                }
            }
            return CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
        }

        @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
        public boolean matchesSocket(SSLSocket sSLSocket) {
            return StringsKt__StringsJVMKt.startsWith(sSLSocket.getClass().getName(), "com.google.android.gms.org.conscrypt.", false);
        }

        public Instant now() {
            switch (this.$r8$classId) {
                case 8:
                    java.time.Instant instantNow = java.time.Instant.now();
                    instantNow.getClass();
                    Instant instant = Instant.MIN;
                    return fromEpochSeconds(instantNow.getEpochSecond(), instantNow.getNano());
                default:
                    Instant instant2 = Instant.MIN;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j = jCurrentTimeMillis / 1000;
                    if ((jCurrentTimeMillis ^ 1000) < 0 && j * 1000 != jCurrentTimeMillis) {
                        j--;
                    }
                    long j2 = jCurrentTimeMillis % 1000;
                    int i = (int) ((j2 + (1000 & (((j2 ^ 1000) & ((-j2) | j2)) >> 63))) * 1000000);
                    if (j < -31557014167219200L) {
                        return Instant.MIN;
                    }
                    return j > 31556889864403199L ? Instant.MAX : fromEpochSeconds(j, i);
            }
        }

        @Override // androidx.compose.runtime.saveable.Saver
        public Object restore(Object obj) {
            return new Color(((long) ((Number) obj).intValue()) << 32);
        }

        @Override // androidx.compose.runtime.saveable.Saver
        public Object save(SaveableHolder saveableHolder, Object obj) {
            long j = ((Color) obj).value;
            saveableHolder.getClass();
            return Integer.valueOf(ColorKt.m498toArgb8_81llA(j));
        }

        @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
        public SocketAdapter create(SSLSocket sSLSocket) {
            Class<?> cls = sSLSocket.getClass();
            Class<?> superclass = cls;
            while (!superclass.getSimpleName().equals("OpenSSLSocketImpl")) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
                }
            }
            return new AndroidSocketAdapter(superclass);
        }
    }
}

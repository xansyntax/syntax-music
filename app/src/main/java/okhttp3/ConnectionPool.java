package okhttp3;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.lazy.LazyListMeasureResult;
import androidx.compose.foundation.lazy.LazyListMeasuredItem;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.mkv.MatroskaExtractor;
import androidx.media3.extractor.mkv.VarintReader;
import androidx.profileinstaller.ProfileInstallReceiver;
import androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.driver.SupportSQLiteConnection;
import androidx.sqlite.driver.SupportSQLiteStatement;
import coil3.BitmapImage;
import coil3.Image;
import coil3.RealImageLoader;
import coil3.Uri;
import coil3.UriKt;
import coil3.key.UriKeyer;
import coil3.memory.MemoryCache$Key;
import coil3.memory.MemoryCache$Value;
import coil3.memory.RealMemoryCache;
import coil3.memory.RealStrongMemoryCache;
import coil3.memory.RealStrongMemoryCache$cache$1;
import coil3.memory.RealWeakMemoryCache$InternalValue;
import coil3.network.okhttp.internal.CallsKt$await$2$2$onResponse$1;
import coil3.request.CachePolicy;
import coil3.request.Disposable;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import coil3.request.Options;
import coil3.size.Dimension;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.util.Utils_androidKt;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Schema;
import com.metrolist.innertubex.extraction.TokenProvider;
import com.metrolist.innertubex.extraction.TokenProviderCapabilities;
import com.metrolist.innertubex.extraction.strategy.PoTokenProviderKind;
import com.metrolist.music.utils.InnerTubeXPlayer;
import com.metrolist.music.utils.InnerTubeXPlayer$tokenProvider$1$getPoToken$1;
import com.metrolist.music.utils.potoken.PoTokenGenerator;
import com.metrolist.music.utils.potoken.PoTokenResult;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.utils.CIOKt;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DeferredCoroutine;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.SinksKt;
import kotlinx.io.Utf8Kt;
import kotlinx.serialization.json.internal.CharsetReader;
import kotlinx.serialization.json.internal.InternalJsonReader;
import kotlinx.serialization.json.internal.InternalJsonWriter;
import kotlinx.serialization.json.internal.StringOpsKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.ExchangeFinder;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.connection.RealRoutePlanner;
import okhttp3.internal.connection.RoutePlanner$ConnectResult;
import okhttp3.internal.connection.RoutePlanner$Plan;
import okhttp3.internal.ech.EchUntrustedException;
import okio.FileSystem;
import okio.Path;
import okio.PriorityQueue;
import sh.calvin.reorderable.CollectionScrollPadding;
import sh.calvin.reorderable.ReorderableLazyListKt$toLazyCollectionItemInfo$1;
import sh.calvin.reorderable.ScrollAreaOffsets;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionPool implements ProfileInstaller$DiagnosticsCallback, SQLiteDriver, SupportSQLiteQuery, Callback, Disposable, TokenProvider, InternalJsonReader, InternalJsonWriter, ExchangeFinder {
    public Object delegate;

    public ConnectionPool(byte b) {
        switch (b) {
            case 17:
                this.delegate = new TokenProviderCapabilities(CharsKt.setOf(PoTokenProviderKind.WEB_BOTGUARD), true);
                break;
            case 18:
                MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
                this.delegate = new MutableScatterSet();
                break;
            case 19:
                this.delegate = new ConcurrentHashMap(16);
                break;
            case 23:
                this.delegate = new LinkedHashSet();
                break;
            case 26:
                this.delegate = new ThreadLocal();
                break;
            default:
                this.delegate = null;
                break;
        }
    }

    public static void d(Object... objArr) {
        for (ConnectionPool connectionPool : Timber.treeArray) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            connectionPool.getClass();
            d(objArrCopyOf);
        }
    }

    public static void d$1(Object... objArr) {
        for (ConnectionPool connectionPool : Timber.treeArray) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            connectionPool.getClass();
            d$1(objArrCopyOf);
        }
    }

    public static void e(Object... objArr) {
        for (ConnectionPool connectionPool : Timber.treeArray) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            connectionPool.getClass();
            e(objArrCopyOf);
        }
    }

    public static void e$1(Object... objArr) {
        for (ConnectionPool connectionPool : Timber.treeArray) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            connectionPool.getClass();
            e$1(objArrCopyOf);
        }
    }

    public static void i(Object... objArr) {
        for (ConnectionPool connectionPool : Timber.treeArray) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            connectionPool.getClass();
            i(objArrCopyOf);
        }
    }

    public static void v(Object... objArr) {
        for (ConnectionPool connectionPool : Timber.treeArray) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            connectionPool.getClass();
            v(objArrCopyOf);
        }
    }

    public static void w(Object... objArr) {
        for (ConnectionPool connectionPool : Timber.treeArray) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            connectionPool.getClass();
            w(objArrCopyOf);
        }
    }

    public static void w$1(Object... objArr) {
        for (ConnectionPool connectionPool : Timber.treeArray) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            connectionPool.getClass();
            w$1(objArrCopyOf);
        }
    }

    public void appendTo(StringBuilder sb, Iterator it) {
        Joiner joiner = (Joiner) this.delegate;
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            sb.append(Joiner.toString(entry.getKey()));
            sb.append("=");
            sb.append(Joiner.toString(entry.getValue()));
            while (it.hasNext()) {
                sb.append((CharSequence) joiner.separator);
                Map.Entry entry2 = (Map.Entry) it.next();
                sb.append(Joiner.toString(entry2.getKey()));
                sb.append("=");
                sb.append(Joiner.toString(entry2.getValue()));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:130:0x0297  */
    public void binaryElement(int i, int i2, ExtractorInput extractorInput) throws ParserException {
        int i3;
        byte b;
        int i4;
        int i5;
        byte b2;
        int i6;
        long j;
        int i7;
        int i8;
        int[] iArr;
        int i9;
        int i10;
        int i11;
        MatroskaExtractor matroskaExtractor = (MatroskaExtractor) this.delegate;
        VarintReader varintReader = matroskaExtractor.varintReader;
        SparseArray sparseArray = matroskaExtractor.tracks;
        ParsableByteArray parsableByteArray = matroskaExtractor.seekEntryIdBytes;
        ParsableByteArray parsableByteArray2 = matroskaExtractor.scratch;
        byte b3 = 2;
        int i12 = 0;
        if (i != 161 && i != 163) {
            if (i == 165) {
                if (matroskaExtractor.blockState != 2) {
                    return;
                }
                MatroskaExtractor.Track track = (MatroskaExtractor.Track) sparseArray.get(matroskaExtractor.blockTrackNumber);
                int i13 = matroskaExtractor.blockAdditionalId;
                ParsableByteArray parsableByteArray3 = matroskaExtractor.supplementalData;
                if (i13 != 4 || !"V_VP9".equals(track.codecId)) {
                    extractorInput.skipFully(i2);
                    return;
                } else {
                    parsableByteArray3.reset(i2);
                    extractorInput.readFully(parsableByteArray3.data, 0, i2);
                    return;
                }
            }
            if (i == 16877) {
                matroskaExtractor.assertInTrackEntry(i);
                MatroskaExtractor.Track track2 = matroskaExtractor.currentTrack;
                int i14 = track2.blockAddIdType;
                if (i14 != 1685485123 && i14 != 1685480259) {
                    extractorInput.skipFully(i2);
                    return;
                }
                byte[] bArr = new byte[i2];
                track2.dolbyVisionConfigBytes = bArr;
                extractorInput.readFully(bArr, 0, i2);
                return;
            }
            if (i == 16981) {
                matroskaExtractor.assertInTrackEntry(i);
                byte[] bArr2 = new byte[i2];
                matroskaExtractor.currentTrack.sampleStrippedBytes = bArr2;
                extractorInput.readFully(bArr2, 0, i2);
                return;
            }
            if (i == 18402) {
                byte[] bArr3 = new byte[i2];
                extractorInput.readFully(bArr3, 0, i2);
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.cryptoData = new TrackOutput.CryptoData(1, 0, 0, bArr3);
                return;
            }
            if (i == 21419) {
                Arrays.fill(parsableByteArray.data, (byte) 0);
                extractorInput.readFully(parsableByteArray.data, 4 - i2, i2);
                parsableByteArray.setPosition(0);
                matroskaExtractor.seekEntryId = (int) parsableByteArray.readUnsignedInt();
                return;
            }
            if (i == 25506) {
                matroskaExtractor.assertInTrackEntry(i);
                byte[] bArr4 = new byte[i2];
                matroskaExtractor.currentTrack.codecPrivate = bArr4;
                extractorInput.readFully(bArr4, 0, i2);
                return;
            }
            if (i != 30322) {
                throw ParserException.createForMalformedContainer(null, "Unexpected id: " + i);
            }
            matroskaExtractor.assertInTrackEntry(i);
            byte[] bArr5 = new byte[i2];
            matroskaExtractor.currentTrack.projectionData = bArr5;
            extractorInput.readFully(bArr5, 0, i2);
            return;
        }
        int i15 = 8;
        if (matroskaExtractor.blockState == 0) {
            matroskaExtractor.blockTrackNumber = (int) varintReader.readUnsignedVarint(extractorInput, false, true, 8);
            matroskaExtractor.blockTrackNumberLength = varintReader.length;
            matroskaExtractor.blockDurationUs = -9223372036854775807L;
            matroskaExtractor.blockState = (byte) 1;
            parsableByteArray2.reset(0);
        }
        MatroskaExtractor.Track track3 = (MatroskaExtractor.Track) sparseArray.get(matroskaExtractor.blockTrackNumber);
        if (track3 == null) {
            extractorInput.skipFully(i2 - matroskaExtractor.blockTrackNumberLength);
            matroskaExtractor.blockState = (byte) 0;
            return;
        }
        track3.output.getClass();
        if (matroskaExtractor.blockState == 1) {
            matroskaExtractor.readScratch(extractorInput, 3);
            int i16 = (parsableByteArray2.data[2] & 6) >> 1;
            if (i16 == 0) {
                matroskaExtractor.blockSampleCount = 1;
                int[] iArr2 = matroskaExtractor.blockSampleSizes;
                if (iArr2 == null) {
                    iArr2 = new int[1];
                } else if (iArr2.length < 1) {
                    iArr2 = new int[Math.max(iArr2.length * 2, 1)];
                }
                matroskaExtractor.blockSampleSizes = iArr2;
                iArr2[0] = (i2 - matroskaExtractor.blockTrackNumberLength) - 3;
            } else {
                matroskaExtractor.readScratch(extractorInput, 4);
                int i17 = (parsableByteArray2.data[3] & 255) + 1;
                matroskaExtractor.blockSampleCount = i17;
                int[] iArr3 = matroskaExtractor.blockSampleSizes;
                if (iArr3 == null) {
                    iArr3 = new int[i17];
                    i3 = 4;
                } else {
                    i3 = 4;
                    if (iArr3.length < i17) {
                        iArr3 = new int[Math.max(iArr3.length * 2, i17)];
                    }
                }
                matroskaExtractor.blockSampleSizes = iArr3;
                if (i16 == 2) {
                    int i18 = (i2 - matroskaExtractor.blockTrackNumberLength) - 4;
                    int i19 = matroskaExtractor.blockSampleCount;
                    Arrays.fill(iArr3, 0, i19, i18 / i19);
                } else {
                    if (i16 == 1) {
                        int i20 = 0;
                        int i21 = 0;
                        int i22 = i3;
                        while (true) {
                            i8 = matroskaExtractor.blockSampleCount - 1;
                            iArr = matroskaExtractor.blockSampleSizes;
                            if (i20 >= i8) {
                                break;
                            }
                            iArr[i20] = 0;
                            while (true) {
                                i9 = i22 + 1;
                                matroskaExtractor.readScratch(extractorInput, i9);
                                int i23 = parsableByteArray2.data[i22] & 255;
                                int[] iArr4 = matroskaExtractor.blockSampleSizes;
                                i10 = iArr4[i20] + i23;
                                iArr4[i20] = i10;
                                if (i23 != 255) {
                                    break;
                                } else {
                                    i22 = i9;
                                }
                            }
                            i21 += i10;
                            i20++;
                            i22 = i9;
                        }
                        iArr[i8] = ((i2 - matroskaExtractor.blockTrackNumberLength) - i22) - i21;
                    } else {
                        if (i16 != 3) {
                            throw ParserException.createForMalformedContainer(null, "Unexpected lacing value: " + i16);
                        }
                        int i24 = 0;
                        int i25 = 0;
                        int i26 = i3;
                        while (true) {
                            int i27 = matroskaExtractor.blockSampleCount - 1;
                            int[] iArr5 = matroskaExtractor.blockSampleSizes;
                            if (i24 >= i27) {
                                b = b3;
                                i4 = i12;
                                iArr5[i27] = ((i2 - matroskaExtractor.blockTrackNumberLength) - i26) - i25;
                                break;
                            }
                            iArr5[i24] = i12;
                            int i28 = i26 + 1;
                            matroskaExtractor.readScratch(extractorInput, i28);
                            if (parsableByteArray2.data[i26] == 0) {
                                throw ParserException.createForMalformedContainer(null, "No valid varint length mask found");
                            }
                            int i29 = i12;
                            while (true) {
                                if (i29 >= i15) {
                                    i5 = i15;
                                    b2 = b3;
                                    i6 = i12;
                                    j = 0;
                                    i7 = i28;
                                    break;
                                }
                                i5 = i15;
                                int i30 = 1 << (7 - i29);
                                i6 = i12;
                                if ((parsableByteArray2.data[i26] & i30) != 0) {
                                    i7 = i28 + i29;
                                    matroskaExtractor.readScratch(extractorInput, i7);
                                    b2 = b3;
                                    j = (~i30) & parsableByteArray2.data[i26] & 255;
                                    while (i28 < i7) {
                                        j = (j << i5) | ((long) (parsableByteArray2.data[i28] & 255));
                                        i28++;
                                    }
                                    if (i24 <= 0) {
                                        break;
                                    }
                                    j -= (1 << ((i29 * 7) + 6)) - 1;
                                    break;
                                }
                                i29++;
                                i12 = i6;
                                i15 = i5;
                            }
                            if (j < -2147483648L || j > 2147483647L) {
                                throw ParserException.createForMalformedContainer(null, "EBML lacing sample size out of range.");
                            }
                            int i31 = (int) j;
                            int[] iArr6 = matroskaExtractor.blockSampleSizes;
                            if (i24 != 0) {
                                i31 += iArr6[i24 - 1];
                            }
                            iArr6[i24] = i31;
                            i25 += i31;
                            i24++;
                            i26 = i7;
                            i12 = i6;
                            i15 = i5;
                            b3 = b2;
                        }
                    }
                    byte[] bArr6 = parsableByteArray2.data;
                    matroskaExtractor.blockTimeUs = matroskaExtractor.scaleTimecodeToUs((bArr6[1] & 255) | (bArr6[i4] << 8)) + matroskaExtractor.clusterTimecodeUs;
                    if (track3.type != 1 || (i == 163 && (parsableByteArray2.data[b] & 128) == 128)) {
                        i11 = 1;
                    } else {
                        i11 = i4;
                    }
                    matroskaExtractor.blockFlags = i11;
                    matroskaExtractor.blockState = b;
                    matroskaExtractor.blockSampleIndex = i4;
                }
            }
            b = 2;
            i4 = 0;
            byte[] bArr7 = parsableByteArray2.data;
            matroskaExtractor.blockTimeUs = matroskaExtractor.scaleTimecodeToUs((bArr7[1] & 255) | (bArr7[i4] << 8)) + matroskaExtractor.clusterTimecodeUs;
            if (track3.type != 1) {
                i11 = 1;
            } else {
                i11 = 1;
            }
            matroskaExtractor.blockFlags = i11;
            matroskaExtractor.blockState = b;
            matroskaExtractor.blockSampleIndex = i4;
        }
        if (i == 163) {
            while (true) {
                int i32 = matroskaExtractor.blockSampleIndex;
                if (i32 >= matroskaExtractor.blockSampleCount) {
                    matroskaExtractor.blockState = (byte) 0;
                    return;
                }
                matroskaExtractor.commitSampleToOutput(track3, ((long) ((matroskaExtractor.blockSampleIndex * track3.defaultSampleDurationNs) / CIOKt.DEFAULT_HTTP_POOL_SIZE)) + matroskaExtractor.blockTimeUs, matroskaExtractor.blockFlags, matroskaExtractor.writeSampleData(extractorInput, track3, matroskaExtractor.blockSampleSizes[i32], false), 0);
                matroskaExtractor.blockSampleIndex++;
            }
        } else {
            while (true) {
                int i33 = matroskaExtractor.blockSampleIndex;
                if (i33 >= matroskaExtractor.blockSampleCount) {
                    return;
                }
                int[] iArr7 = matroskaExtractor.blockSampleSizes;
                iArr7[i33] = matroskaExtractor.writeSampleData(extractorInput, track3, iArr7[i33], true);
                matroskaExtractor.blockSampleIndex++;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        SupportSQLiteStatement.RowSQLiteStatement rowSQLiteStatement = (SupportSQLiteStatement.RowSQLiteStatement) this.delegate;
        int length = rowSQLiteStatement.bindingTypes.length;
        for (int i = 1; i < length; i++) {
            int i2 = rowSQLiteStatement.bindingTypes[i];
            if (i2 == 1) {
                supportSQLiteProgram.bindLong(i, rowSQLiteStatement.longBindings[i]);
            } else if (i2 == 2) {
                supportSQLiteProgram.bindDouble(i, rowSQLiteStatement.doubleBindings[i]);
            } else if (i2 == 3) {
                String str = rowSQLiteStatement.stringBindings[i];
                str.getClass();
                supportSQLiteProgram.bindString(i, str);
            } else if (i2 == 4) {
                byte[] bArr = rowSQLiteStatement.blobBindings[i];
                bArr.getClass();
                supportSQLiteProgram.bindBlob(bArr, i);
            } else if (i2 == 5) {
                supportSQLiteProgram.bindNull(i);
            }
        }
    }

    public void evictAll() {
        Socket socket;
        RealConnectionPool realConnectionPool = (RealConnectionPool) this.delegate;
        Iterator it = realConnectionPool.connections.iterator();
        it.getClass();
        while (it.hasNext()) {
            RealConnection realConnection = (RealConnection) it.next();
            realConnection.getClass();
            synchronized (realConnection) {
                if (realConnection.calls.isEmpty()) {
                    it.remove();
                    realConnection.noNewExchanges = true;
                    socket = realConnection.javaNetSocket;
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                _UtilJvmKt.closeQuietly(socket);
            }
        }
        if (realConnectionPool.connections.isEmpty()) {
            realConnectionPool.cleanupQueue.cancelAll();
        }
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RealConnection find() throws Throwable {
        IOException iOException = null;
        while (!((RealRoutePlanner) this.delegate).call.canceled) {
            try {
                RoutePlanner$Plan routePlanner$PlanPlan = ((RealRoutePlanner) this.delegate).plan();
                if (!routePlanner$PlanPlan.isReady()) {
                    RoutePlanner$ConnectResult routePlanner$ConnectResultConnectTcp = routePlanner$PlanPlan.connectTcp();
                    if (routePlanner$ConnectResultConnectTcp.nextPlan == null && routePlanner$ConnectResultConnectTcp.throwable == null) {
                        routePlanner$ConnectResultConnectTcp = routePlanner$PlanPlan.connectTlsEtc();
                    }
                    RoutePlanner$Plan routePlanner$Plan = routePlanner$ConnectResultConnectTcp.nextPlan;
                    Throwable th = routePlanner$ConnectResultConnectTcp.throwable;
                    if (th != null) {
                        throw th;
                    }
                    if (routePlanner$Plan != null) {
                        ((RealRoutePlanner) this.delegate).deferredPlans.addFirst(routePlanner$Plan);
                    }
                }
                return routePlanner$PlanPlan.handleSuccess();
            } catch (IOException e) {
                if (iOException == null) {
                    iOException = e;
                } else {
                    ResultKt.addSuppressed(iOException, e);
                }
                if (e instanceof EchUntrustedException) {
                    throw iOException;
                }
                if (!((RealRoutePlanner) this.delegate).hasNext(null)) {
                    throw iOException;
                }
            }
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Canceled");
        return null;
    }

    public MemoryCache$Value getCacheValue(ImageRequest imageRequest, MemoryCache$Key memoryCache$Key, Size size, Scale scale) {
        MemoryCache$Value memoryCache$Value;
        boolean zIsConfigValidForHardware;
        int iAbs;
        MemoryCache$Value memoryCache$Value2;
        CachePolicy cachePolicy = imageRequest.memoryCachePolicy;
        Precision precision = imageRequest.precision;
        if (cachePolicy.readEnabled) {
            RealMemoryCache memoryCache = ((RealImageLoader) this.delegate).getMemoryCache();
            if (memoryCache != null) {
                synchronized (memoryCache.lock) {
                    try {
                        RealStrongMemoryCache.InternalValue internalValue = (RealStrongMemoryCache.InternalValue) ((LinkedHashMap) ((RealStrongMemoryCache$cache$1) memoryCache.strongMemoryCache.cache).map).get(memoryCache$Key);
                        memoryCache$Value = internalValue != null ? new MemoryCache$Value(internalValue.image, internalValue.extras) : null;
                        if (memoryCache$Value == null) {
                            PriorityQueue priorityQueue = memoryCache.weakMemoryCache;
                            ArrayList arrayList = (ArrayList) ((LinkedHashMap) priorityQueue.array).get(memoryCache$Key);
                            if (arrayList == null) {
                                memoryCache$Value = null;
                            } else {
                                int size2 = arrayList.size();
                                int i = 0;
                                while (true) {
                                    if (i >= size2) {
                                        memoryCache$Value2 = null;
                                        break;
                                    }
                                    RealWeakMemoryCache$InternalValue realWeakMemoryCache$InternalValue = (RealWeakMemoryCache$InternalValue) arrayList.get(i);
                                    Image image = (Image) realWeakMemoryCache$InternalValue.image.get();
                                    memoryCache$Value2 = image != null ? new MemoryCache$Value(image, realWeakMemoryCache$InternalValue.extras) : null;
                                    if (memoryCache$Value2 != null) {
                                        break;
                                    }
                                    i++;
                                }
                                priorityQueue.cleanUpIfNecessary();
                                memoryCache$Value = memoryCache$Value2;
                            }
                        }
                        if (memoryCache$Value != null && !memoryCache$Value.image.getShareable()) {
                            synchronized (memoryCache.lock) {
                                RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = (RealStrongMemoryCache$cache$1) memoryCache.strongMemoryCache.cache;
                                Object objRemove = ((LinkedHashMap) realStrongMemoryCache$cache$1.map).remove(memoryCache$Key);
                                if (objRemove != null) {
                                    realStrongMemoryCache$cache$1.size = realStrongMemoryCache$cache$1.getSize() - realStrongMemoryCache$cache$1.safeSizeOf(memoryCache$Key, objRemove);
                                    realStrongMemoryCache$cache$1.entryRemoved(memoryCache$Key, objRemove, null);
                                }
                                if (objRemove != null) {
                                }
                                if (((LinkedHashMap) memoryCache.weakMemoryCache.array).remove(memoryCache$Key) != null) {
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } else {
                memoryCache$Value = null;
            }
            if (memoryCache$Value != null) {
                Image image2 = memoryCache$Value.image;
                BitmapImage bitmapImage = image2 instanceof BitmapImage ? (BitmapImage) image2 : null;
                if (bitmapImage == null) {
                    zIsConfigValidForHardware = true;
                } else {
                    Bitmap.Config config = bitmapImage.bitmap.getConfig();
                    if (config == null) {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    zIsConfigValidForHardware = Splitter.isConfigValidForHardware(imageRequest, config);
                }
                if (zIsConfigValidForHardware) {
                    String str = (String) memoryCache$Key.extras.get("coil#size");
                    if (str == null) {
                        Object obj = memoryCache$Value.extras.get("coil#is_sampled");
                        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
                        if ((bool != null ? bool.booleanValue() : false) || (!Intrinsics.areEqual(size, Size.ORIGINAL) && precision != Precision.INEXACT)) {
                            int width = image2.getWidth();
                            int height = image2.getHeight();
                            Size size3 = image2 instanceof BitmapImage ? (Size) UriKt.getExtra(imageRequest, ImageRequestsKt.maxBitmapSizeKey) : Size.ORIGINAL;
                            Dimension dimension = size.width;
                            int i2 = dimension instanceof Dimension.Pixels ? ((Dimension.Pixels) dimension).px : Integer.MAX_VALUE;
                            Dimension dimension2 = size3.width;
                            int iMin = Math.min(i2, dimension2 instanceof Dimension.Pixels ? ((Dimension.Pixels) dimension2).px : Integer.MAX_VALUE);
                            Dimension dimension3 = size.height;
                            int i3 = dimension3 instanceof Dimension.Pixels ? ((Dimension.Pixels) dimension3).px : Integer.MAX_VALUE;
                            Dimension dimension4 = size3.height;
                            int iMin2 = Math.min(i3, dimension4 instanceof Dimension.Pixels ? ((Dimension.Pixels) dimension4).px : Integer.MAX_VALUE);
                            double d = ((double) iMin) / ((double) width);
                            double d2 = ((double) iMin2) / ((double) height);
                            int iOrdinal = ((iMin == Integer.MAX_VALUE || iMin2 == Integer.MAX_VALUE) ? Scale.FIT : scale).ordinal();
                            if (iOrdinal != 0) {
                                if (iOrdinal != 1) {
                                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                                    return null;
                                }
                                if (d < d2) {
                                    iAbs = Math.abs(iMin - width);
                                } else {
                                    iAbs = Math.abs(iMin2 - height);
                                    d = d2;
                                }
                            } else if (d > d2) {
                                iAbs = Math.abs(iMin - width);
                            } else {
                                iAbs = Math.abs(iMin2 - height);
                                d = d2;
                            }
                            if (iAbs > 1) {
                                int iOrdinal2 = precision.ordinal();
                                if (iOrdinal2 != 0) {
                                    if (iOrdinal2 != 1) {
                                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                                        return null;
                                    }
                                    if (d <= 1.0d) {
                                    }
                                } else if (d == 1.0d) {
                                }
                            }
                        }
                        return memoryCache$Value;
                    }
                    if (str.equals(size.toString())) {
                        return memoryCache$Value;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.metrolist.innertubex.extraction.TokenProvider
    public TokenProviderCapabilities getCapabilities() {
        return (TokenProviderCapabilities) this.delegate;
    }

    @Override // coil3.request.Disposable
    public Deferred getJob() {
        return (DeferredCoroutine) this.delegate;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.metrolist.innertubex.extraction.TokenProvider
    public Object getPoToken(String str, String str2, Continuation continuation) {
        InnerTubeXPlayer$tokenProvider$1$getPoToken$1 innerTubeXPlayer$tokenProvider$1$getPoToken$1;
        if (continuation instanceof InnerTubeXPlayer$tokenProvider$1$getPoToken$1) {
            innerTubeXPlayer$tokenProvider$1$getPoToken$1 = (InnerTubeXPlayer$tokenProvider$1$getPoToken$1) continuation;
            int i = innerTubeXPlayer$tokenProvider$1$getPoToken$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                innerTubeXPlayer$tokenProvider$1$getPoToken$1.label = i - Integer.MIN_VALUE;
            } else {
                innerTubeXPlayer$tokenProvider$1$getPoToken$1 = new InnerTubeXPlayer$tokenProvider$1$getPoToken$1(this, (ContinuationImpl) continuation);
            }
        } else {
            innerTubeXPlayer$tokenProvider$1$getPoToken$1 = new InnerTubeXPlayer$tokenProvider$1$getPoToken$1(this, (ContinuationImpl) continuation);
        }
        Object webClientPoToken = innerTubeXPlayer$tokenProvider$1$getPoToken$1.result;
        int i2 = innerTubeXPlayer$tokenProvider$1$getPoToken$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(webClientPoToken);
            PoTokenGenerator poTokenGenerator = (PoTokenGenerator) InnerTubeXPlayer.poTokenGenerator$delegate.getValue();
            innerTubeXPlayer$tokenProvider$1$getPoToken$1.L$1 = str2;
            innerTubeXPlayer$tokenProvider$1$getPoToken$1.label = 1;
            webClientPoToken = poTokenGenerator.getWebClientPoToken(str, str2, innerTubeXPlayer$tokenProvider$1$getPoToken$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (webClientPoToken == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str2 = innerTubeXPlayer$tokenProvider$1$getPoToken$1.L$1;
            ResultKt.throwOnFailure(webClientPoToken);
        }
        PoTokenResult poTokenResult = (PoTokenResult) webClientPoToken;
        if (poTokenResult != null) {
            return new com.metrolist.innertubex.extraction.PoTokenResult(poTokenResult.getPlayerRequestPoToken(), poTokenResult.getStreamingDataPoToken(), str2);
        }
        return null;
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    public RealRoutePlanner getRoutePlanner() {
        return (RealRoutePlanner) this.delegate;
    }

    public ScrollAreaOffsets getScrollAreaOffsets(CollectionScrollPadding collectionScrollPadding) {
        long jM162getViewportSizeYbymL2g;
        collectionScrollPadding.getClass();
        float f = collectionScrollPadding.start;
        float f2 = collectionScrollPadding.end;
        LazyListMeasureResult lazyListMeasureResult = (LazyListMeasureResult) this.delegate;
        int iOrdinal = lazyListMeasureResult.orientation.ordinal();
        if (iOrdinal == 0) {
            jM162getViewportSizeYbymL2g = lazyListMeasureResult.m162getViewportSizeYbymL2g() & 4294967295L;
        } else {
            if (iOrdinal != 1) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            }
            jM162getViewportSizeYbymL2g = lazyListMeasureResult.m162getViewportSizeYbymL2g() >> 32;
        }
        return new ScrollAreaOffsets(f, ((int) jM162getViewportSizeYbymL2g) - f2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return ((SupportSQLiteStatement.RowSQLiteStatement) this.delegate).sql;
    }

    public ArrayList getVisibleItemsInfo() {
        LazyListMeasureResult lazyListMeasureResult = (LazyListMeasureResult) this.delegate;
        List list = lazyListMeasureResult.visibleItemsInfo;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new ReorderableLazyListKt$toLazyCollectionItemInfo$1((LazyListMeasuredItem) it.next(), lazyListMeasureResult.orientation));
        }
        return arrayList;
    }

    @Override // androidx.sqlite.SQLiteDriver
    public boolean hasConnectionPool() {
        return true;
    }

    public void integerElement(int i, long j) throws ParserException {
        MatroskaExtractor matroskaExtractor = (MatroskaExtractor) this.delegate;
        if (i == 240) {
            if (matroskaExtractor.sentSeekMap) {
                return;
            }
            matroskaExtractor.assertInCues(i);
            if (matroskaExtractor.currentCueRelativePosition == -1) {
                matroskaExtractor.currentCueRelativePosition = j;
                return;
            }
            return;
        }
        if (i == 241) {
            if (matroskaExtractor.sentSeekMap) {
                return;
            }
            matroskaExtractor.assertInCues(i);
            if (matroskaExtractor.currentCueClusterPosition == -1) {
                matroskaExtractor.currentCueClusterPosition = j;
                return;
            }
            return;
        }
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw ParserException.createForMalformedContainer(null, "ContentEncodingOrder " + j + " not supported");
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw ParserException.createForMalformedContainer(null, "ContentEncodingScope " + j + " not supported");
        }
        switch (i) {
            case 131:
                int i2 = (int) j;
                if (i2 == 1) {
                    matroskaExtractor.assertInTrackEntry(i);
                    matroskaExtractor.currentTrack.type = 2;
                    return;
                }
                if (i2 == 2) {
                    matroskaExtractor.assertInTrackEntry(i);
                    matroskaExtractor.currentTrack.type = 1;
                    return;
                } else if (i2 == 17) {
                    matroskaExtractor.assertInTrackEntry(i);
                    matroskaExtractor.currentTrack.type = 3;
                    return;
                } else if (i2 != 33) {
                    matroskaExtractor.assertInTrackEntry(i);
                    matroskaExtractor.currentTrack.type = -1;
                    return;
                } else {
                    matroskaExtractor.assertInTrackEntry(i);
                    matroskaExtractor.currentTrack.type = 5;
                    return;
                }
            case 136:
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.flagDefault = j == 1;
                return;
            case 155:
                matroskaExtractor.blockDurationUs = matroskaExtractor.scaleTimecodeToUs(j);
                return;
            case 159:
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.channelCount = (int) j;
                return;
            case 176:
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.width = (int) j;
                return;
            case 179:
                if (matroskaExtractor.sentSeekMap) {
                    return;
                }
                matroskaExtractor.assertInCues(i);
                matroskaExtractor.currentCueTimeUs = matroskaExtractor.scaleTimecodeToUs(j);
                return;
            case 186:
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.height = (int) j;
                return;
            case 215:
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.number = (int) j;
                return;
            case 231:
                matroskaExtractor.clusterTimecodeUs = matroskaExtractor.scaleTimecodeToUs(j);
                return;
            case 238:
                matroskaExtractor.blockAdditionalId = (int) j;
                return;
            case 247:
                if (matroskaExtractor.sentSeekMap) {
                    return;
                }
                matroskaExtractor.assertInCues(i);
                matroskaExtractor.currentCueTrackNumber = (int) j;
                return;
            case 251:
                matroskaExtractor.blockHasReferenceBlock = true;
                return;
            case 16871:
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.blockAddIdType = (int) j;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                throw ParserException.createForMalformedContainer(null, "ContentCompAlgo " + j + " not supported");
            case 17029:
                if (j < 1 || j > 2) {
                    throw ParserException.createForMalformedContainer(null, "DocTypeReadVersion " + j + " not supported");
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer(null, "EBMLReadVersion " + j + " not supported");
            case 18401:
                if (j == 5) {
                    return;
                }
                throw ParserException.createForMalformedContainer(null, "ContentEncAlgo " + j + " not supported");
            case 18408:
                if (j == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer(null, "AESSettingsCipherMode " + j + " not supported");
            case 21420:
                matroskaExtractor.seekEntryPosition = j + matroskaExtractor.segmentContentPosition;
                return;
            case 21432:
                int i3 = (int) j;
                matroskaExtractor.assertInTrackEntry(i);
                if (i3 == 0) {
                    matroskaExtractor.currentTrack.stereoMode = 0;
                    return;
                }
                if (i3 == 1) {
                    matroskaExtractor.currentTrack.stereoMode = 2;
                    return;
                } else if (i3 == 3) {
                    matroskaExtractor.currentTrack.stereoMode = 1;
                    return;
                } else {
                    if (i3 != 15) {
                        return;
                    }
                    matroskaExtractor.currentTrack.stereoMode = 3;
                    return;
                }
            case 21680:
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.displayWidth = (int) j;
                return;
            case 21682:
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.displayUnit = (int) j;
                return;
            case 21690:
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.displayHeight = (int) j;
                return;
            case 21930:
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.flagForced = j == 1;
                return;
            case 21938:
                matroskaExtractor.assertInTrackEntry(i);
                MatroskaExtractor.Track track = matroskaExtractor.currentTrack;
                track.hasColorInfo = true;
                track.bitsPerChannel = (int) j;
                return;
            case 21998:
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.maxBlockAdditionId = (int) j;
                return;
            case 22186:
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.codecDelayNs = j;
                return;
            case 22203:
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.seekPreRollNs = j;
                return;
            case 25188:
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.audioBitDepth = (int) j;
                return;
            case 30114:
                matroskaExtractor.blockGroupDiscardPaddingNs = j;
                return;
            case 30321:
                matroskaExtractor.assertInTrackEntry(i);
                int i4 = (int) j;
                if (i4 == 0) {
                    matroskaExtractor.currentTrack.projectionType = 0;
                    return;
                }
                if (i4 == 1) {
                    matroskaExtractor.currentTrack.projectionType = 1;
                    return;
                } else if (i4 == 2) {
                    matroskaExtractor.currentTrack.projectionType = 2;
                    return;
                } else {
                    if (i4 != 3) {
                        return;
                    }
                    matroskaExtractor.currentTrack.projectionType = 3;
                    return;
                }
            case 2352003:
                matroskaExtractor.assertInTrackEntry(i);
                matroskaExtractor.currentTrack.defaultSampleDurationNs = (int) j;
                return;
            case 2807729:
                matroskaExtractor.timecodeScale = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        matroskaExtractor.assertInTrackEntry(i);
                        int i5 = (int) j;
                        if (i5 == 1) {
                            matroskaExtractor.currentTrack.colorRange = 2;
                            return;
                        } else {
                            if (i5 != 2) {
                                return;
                            }
                            matroskaExtractor.currentTrack.colorRange = 1;
                            return;
                        }
                    case 21946:
                        matroskaExtractor.assertInTrackEntry(i);
                        int iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer((int) j);
                        if (iIsoTransferCharacteristicsToColorTransfer != -1) {
                            matroskaExtractor.currentTrack.colorTransfer = iIsoTransferCharacteristicsToColorTransfer;
                            return;
                        }
                        return;
                    case 21947:
                        matroskaExtractor.assertInTrackEntry(i);
                        matroskaExtractor.currentTrack.hasColorInfo = true;
                        int iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace((int) j);
                        if (iIsoColorPrimariesToColorSpace != -1) {
                            matroskaExtractor.currentTrack.colorSpace = iIsoColorPrimariesToColorSpace;
                            return;
                        }
                        return;
                    case 21948:
                        matroskaExtractor.assertInTrackEntry(i);
                        matroskaExtractor.currentTrack.maxContentLuminance = (int) j;
                        return;
                    case 21949:
                        matroskaExtractor.assertInTrackEntry(i);
                        matroskaExtractor.currentTrack.maxFrameAverageLuminance = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x009d  */
    public MemoryCache$Key newCacheKey(ImageRequest imageRequest, Object obj, Options options, coil3.EventListener$Companion$NONE$1 eventListener$Companion$NONE$1) {
        String str;
        String filePath;
        CachePolicy cachePolicy = imageRequest.memoryCachePolicy;
        Map map = imageRequest.memoryCacheKeyExtras;
        if (cachePolicy != CachePolicy.DISABLED) {
            List list = ((RealImageLoader) this.delegate).components.keyers;
            int size = list.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    Pair pair = (Pair) list.get(i);
                    UriKeyer uriKeyer = (UriKeyer) pair.first;
                    if (((KClass) pair.second).isInstance(obj)) {
                        uriKeyer.getClass();
                        switch (uriKeyer.$r8$classId) {
                            case 0:
                                str = ((Uri) obj).data;
                                break;
                            case 1:
                                Uri uri = (Uri) obj;
                                if (!Intrinsics.areEqual(uri.scheme, "android.resource")) {
                                    str = null;
                                } else {
                                    Configuration configuration = options.context.getResources().getConfiguration();
                                    Bitmap.Config[] configArr = Utils_androidKt.VALID_TRANSFORMATION_CONFIGS;
                                    str = uri + ServerSentEventKt.COLON + (configuration.uiMode & 48);
                                }
                                break;
                            default:
                                Uri uri2 = (Uri) obj;
                                String str2 = uri2.scheme;
                                if (!(str2 == null || str2.equals("file")) || uri2.path == null) {
                                    str = null;
                                } else {
                                    Bitmap.Config[] configArr2 = Utils_androidKt.VALID_TRANSFORMATION_CONFIGS;
                                    if ((Intrinsics.areEqual(uri2.scheme, "file") && Intrinsics.areEqual(CollectionsKt.firstOrNull(UriKt.getPathSegments(uri2)), "android_asset")) || !((Boolean) UriKt.getExtra(options, ImageRequestsKt.addLastModifiedToFileCacheKeyKey)).booleanValue() || (filePath = UriKt.getFilePath(uri2)) == null) {
                                        str = null;
                                    } else {
                                        FileSystem fileSystem = options.fileSystem;
                                        String str3 = Path.DIRECTORY_SEPARATOR;
                                        str = uri2 + "-" + ((Long) fileSystem.metadata(Path.Companion.get(filePath)).lastModifiedAtMillis);
                                    }
                                }
                                break;
                        }
                        if (str != null) {
                        }
                    }
                    i++;
                } else {
                    str = null;
                }
            }
            if (str != null) {
                if (((List) UriKt.getExtra(imageRequest, ImageRequestsKt.transformationsKey)).isEmpty()) {
                    return new MemoryCache$Key(str, map);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(map);
                linkedHashMap.put("coil#size", options.size.toString());
                return new MemoryCache$Key(str, linkedHashMap);
            }
        }
        return null;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        ((CancellableContinuationImpl) this.delegate).resumeWith(new Result.Failure(iOException));
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        ((CancellableContinuationImpl) this.delegate).resume(response, CallsKt$await$2$2$onResponse$1.INSTANCE);
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onResultReceived(int i, Object obj) {
        String str;
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
        ((ProfileInstallReceiver) this.delegate).setResultCode(i);
    }

    @Override // androidx.sqlite.SQLiteDriver
    public SQLiteConnection open(String str) {
        str.getClass();
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = (SupportSQLiteOpenHelper) this.delegate;
        String databaseName = supportSQLiteOpenHelper.getDatabaseName();
        if (databaseName == null) {
            if (!str.equals(":memory:")) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("This driver is configured to open an in-memory database but a file-based named '", str, "' was requested."));
                return null;
            }
        } else if (!databaseName.equals(str) && !StringsKt.substringAfterLast('/', databaseName, databaseName).equals(StringsKt.substringAfterLast('/', str, str))) {
            DifferentialMotionFlingController$$ExternalSyntheticLambda0.m$1("This driver is configured to open a database named '", supportSQLiteOpenHelper.getDatabaseName(), "' but '", str, "' was requested.");
            return null;
        }
        return new SupportSQLiteConnection(supportSQLiteOpenHelper.getWritableDatabase());
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonReader
    public int read(char[] cArr, int i, int i2) {
        return ((CharsetReader) this.delegate).read(cArr, i, i2);
    }

    public void startMasterElement(int i, long j, long j2) throws ParserException {
        MatroskaExtractor matroskaExtractor = (MatroskaExtractor) this.delegate;
        matroskaExtractor.extractorOutput.getClass();
        if (i == 160) {
            matroskaExtractor.blockHasReferenceBlock = false;
            matroskaExtractor.blockGroupDiscardPaddingNs = 0L;
            return;
        }
        if (i == 174) {
            MatroskaExtractor.Track track = new MatroskaExtractor.Track();
            track.width = -1;
            track.height = -1;
            track.bitsPerChannel = -1;
            track.displayWidth = -1;
            track.displayHeight = -1;
            track.displayUnit = 0;
            track.projectionType = -1;
            track.projectionPoseYaw = CropImageView.DEFAULT_ASPECT_RATIO;
            track.projectionPosePitch = CropImageView.DEFAULT_ASPECT_RATIO;
            track.projectionPoseRoll = CropImageView.DEFAULT_ASPECT_RATIO;
            track.projectionData = null;
            track.stereoMode = -1;
            track.hasColorInfo = false;
            track.colorSpace = -1;
            track.colorTransfer = -1;
            track.colorRange = -1;
            track.maxContentLuminance = CIOKt.DEFAULT_HTTP_POOL_SIZE;
            track.maxFrameAverageLuminance = 200;
            track.primaryRChromaticityX = -1.0f;
            track.primaryRChromaticityY = -1.0f;
            track.primaryGChromaticityX = -1.0f;
            track.primaryGChromaticityY = -1.0f;
            track.primaryBChromaticityX = -1.0f;
            track.primaryBChromaticityY = -1.0f;
            track.whitePointChromaticityX = -1.0f;
            track.whitePointChromaticityY = -1.0f;
            track.maxMasteringLuminance = -1.0f;
            track.minMasteringLuminance = -1.0f;
            track.channelCount = 1;
            track.audioBitDepth = -1;
            track.sampleRate = 8000;
            track.codecDelayNs = 0L;
            track.seekPreRollNs = 0L;
            track.waitingForDtsAnalysis = false;
            track.flagDefault = true;
            track.language = "eng";
            matroskaExtractor.currentTrack = track;
            track.isWebm = matroskaExtractor.isWebm;
            return;
        }
        if (i == 183) {
            if (matroskaExtractor.sentSeekMap) {
                return;
            }
            matroskaExtractor.assertInCues(i);
            matroskaExtractor.currentCueTrackNumber = -1;
            matroskaExtractor.currentCueClusterPosition = -1L;
            matroskaExtractor.currentCueRelativePosition = -1L;
            return;
        }
        if (i == 187) {
            if (matroskaExtractor.sentSeekMap) {
                return;
            }
            matroskaExtractor.assertInCues(i);
            matroskaExtractor.currentCueTimeUs = -9223372036854775807L;
            return;
        }
        if (i == 19899) {
            matroskaExtractor.seekEntryId = -1;
            matroskaExtractor.seekEntryPosition = -1L;
            return;
        }
        if (i == 20533) {
            matroskaExtractor.assertInTrackEntry(i);
            matroskaExtractor.currentTrack.hasContentEncryption = true;
            return;
        }
        if (i == 21968) {
            matroskaExtractor.assertInTrackEntry(i);
            matroskaExtractor.currentTrack.hasColorInfo = true;
            return;
        }
        if (i == 408125543) {
            long j3 = matroskaExtractor.segmentContentPosition;
            if (j3 != -1 && j3 != j) {
                throw ParserException.createForMalformedContainer(null, "Multiple Segment elements not supported");
            }
            matroskaExtractor.segmentContentPosition = j;
            matroskaExtractor.segmentContentSize = j2;
            return;
        }
        if (i == 475249515) {
            if (matroskaExtractor.sentSeekMap) {
                return;
            }
            matroskaExtractor.inCuesElement = true;
        } else if (i == 524531317 && !matroskaExtractor.sentSeekMap) {
            if (matroskaExtractor.seekForCuesEnabled && matroskaExtractor.cuesContentPosition != -1) {
                matroskaExtractor.seekForCues = true;
            } else {
                matroskaExtractor.extractorOutput.seekMap(new SeekMap.Unseekable(matroskaExtractor.durationUs));
                matroskaExtractor.sentSeekMap = true;
            }
        }
    }

    public void stringElement(int i, String str) throws ParserException {
        MatroskaExtractor matroskaExtractor = (MatroskaExtractor) this.delegate;
        if (i == 134) {
            matroskaExtractor.assertInTrackEntry(i);
            matroskaExtractor.currentTrack.codecId = str;
            return;
        }
        if (i == 17026) {
            if ("webm".equals(str) || "matroska".equals(str)) {
                matroskaExtractor.isWebm = str.equals("webm");
                return;
            }
            throw ParserException.createForMalformedContainer(null, "DocType " + str + " not supported");
        }
        if (i == 21358) {
            matroskaExtractor.assertInTrackEntry(i);
            matroskaExtractor.currentTrack.name = str;
        } else {
            if (i != 2274716) {
                return;
            }
            matroskaExtractor.assertInTrackEntry(i);
            matroskaExtractor.currentTrack.language = str;
        }
    }

    public void tag(String str) {
        str.getClass();
        ConnectionPool[] connectionPoolArr = Timber.treeArray;
        int length = connectionPoolArr.length;
        int i = 0;
        while (i < length) {
            ConnectionPool connectionPool = connectionPoolArr[i];
            i++;
            ((ThreadLocal) connectionPool.delegate).set(str);
        }
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void write(String str) {
        str.getClass();
        Utf8Kt.writeString((Buffer) this.delegate, str, 0, str.length());
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeChar(char c) {
        Utf8Kt.writeCodePointValue((Buffer) this.delegate, c);
    }

    public void writeGroup(int i, Object obj, Schema schema) {
        CodedOutputStream codedOutputStream = (CodedOutputStream) this.delegate;
        codedOutputStream.writeTag(i, 3);
        schema.writeTo((AbstractMessageLite) obj, this);
        codedOutputStream.writeTag(i, 4);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeLong(long j) {
        Buffer buffer = (Buffer) this.delegate;
        byte[] bArr = SinksKt.HEX_DIGIT_BYTES;
        if (j == 0) {
            buffer.writeByte((byte) 48);
            return;
        }
        int i = 0;
        int i2 = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                Utf8Kt.writeString(buffer, "-9223372036854775808", 0, 20);
                return;
            }
            i = 1;
        }
        if (j < 100000000) {
            if (j < 10000) {
                if (j >= 100) {
                    i2 = j < 1000 ? 3 : 4;
                } else if (j >= 10) {
                    i2 = 2;
                }
            } else if (j < 1000000) {
                i2 = j < 100000 ? 5 : 6;
            } else {
                i2 = j < 10000000 ? 7 : 8;
            }
        } else if (j < 1000000000000L) {
            if (j < 10000000000L) {
                i2 = j < 1000000000 ? 9 : 10;
            } else {
                i2 = j < 100000000000L ? 11 : 12;
            }
        } else if (j < 1000000000000000L) {
            if (j < 10000000000000L) {
                i2 = 13;
            } else {
                i2 = j < 100000000000000L ? 14 : 15;
            }
        } else if (j < 100000000000000000L) {
            i2 = j < 10000000000000000L ? 16 : 17;
        } else {
            i2 = j < 1000000000000000000L ? 18 : 19;
        }
        if (i != 0) {
            i2++;
        }
        Segment segmentWritableSegment = buffer.writableSegment(i2);
        byte[] bArr2 = segmentWritableSegment.data;
        int i3 = i2 - 1;
        if (i <= i3) {
            while (true) {
                bArr2[segmentWritableSegment.limit + i3] = SinksKt.HEX_DIGIT_BYTES[(byte) (j % 10)];
                j /= 10;
                if (i3 == i) {
                    break;
                } else {
                    i3--;
                }
            }
        }
        if (i != 0) {
            bArr2[segmentWritableSegment.limit] = 45;
        }
        segmentWritableSegment.limit += i2;
        buffer.sizeMut += (long) i2;
    }

    public void writeMessage(int i, Object obj, Schema schema) {
        AbstractMessageLite abstractMessageLite = (AbstractMessageLite) obj;
        CodedOutputStream codedOutputStream = (CodedOutputStream) this.delegate;
        codedOutputStream.writeTag(i, 2);
        codedOutputStream.writeUInt32NoTag(abstractMessageLite.getSerializedSize(schema));
        schema.writeTo(abstractMessageLite, this);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeQuoted(String str) {
        str.getClass();
        Buffer buffer = (Buffer) this.delegate;
        Utf8Kt.writeCodePointValue(buffer, 34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            String[] strArr = StringOpsKt.ESCAPE_STRINGS;
            if (cCharAt < strArr.length && strArr[cCharAt] != null) {
                Utf8Kt.writeString(buffer, str, i, i2);
                String str2 = strArr[cCharAt];
                str2.getClass();
                Utf8Kt.writeString(buffer, str2, 0, str2.length());
                i = i2 + 1;
            }
        }
        Utf8Kt.writeString(buffer, str, i, str.length());
        Utf8Kt.writeCodePointValue(buffer, 34);
    }

    public ConnectionPool(int i) {
        TimeUnit.MINUTES.getClass();
        TaskRunner taskRunner = TaskRunner.INSTANCE;
        taskRunner.getClass();
        this.delegate = new RealConnectionPool(taskRunner, i);
    }

    public /* synthetic */ ConnectionPool(Object obj) {
        this.delegate = obj;
    }
}

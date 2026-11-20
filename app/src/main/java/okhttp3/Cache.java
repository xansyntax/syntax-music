package okhttp3;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewParent;
import androidx.collection.LongSparseArray;
import androidx.compose.runtime.Latch;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HitPathTracker;
import androidx.compose.ui.input.pointer.InternalPointerEvent;
import androidx.compose.ui.input.pointer.PointerClassification;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.WeakCache;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.widget.NestedScrollView;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.util.AtomicFile$AtomicFileOutputStream;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.cache.CacheFileMetadataIndex;
import androidx.media3.datasource.cache.CachedContent;
import androidx.media3.datasource.cache.CachedContentIndex$Storage;
import androidx.media3.datasource.cache.ContentMetadata;
import androidx.media3.datasource.cache.DefaultContentMetadata;
import androidx.media3.datasource.cache.ReusableBufferedOutputStream;
import coil3.util.AndroidSystemCallbacks$ActivityCallbacks;
import coil3.util.AndroidSystemCallbacks$ComponentCallbacks;
import coil3.util.UtilsKt;
import com.materialkolor.quantize.QuantizerWu;
import dagger.hilt.EntryPoints;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.Buffer.AnonymousClass1;
import okio.BufferedSource;
import okio.ByteString;
import okio.FileSystem;
import okio.ForwardingSource;
import okio.JvmSystemFileSystem;
import okio.Path;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Cache implements Closeable, Flushable {
    public final DiskLruCache cache;

    public Cache(File file) {
        JvmSystemFileSystem jvmSystemFileSystem = FileSystem.SYSTEM;
        String str = Path.DIRECTORY_SEPARATOR;
        Path path = Path.Companion.get$default(file);
        jvmSystemFileSystem.getClass();
        TaskRunner taskRunner = TaskRunner.INSTANCE;
        taskRunner.getClass();
        this.cache = new DiskLruCache(jvmSystemFileSystem, path, taskRunner);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.cache.close();
    }

    @Override // java.io.Flushable
    public final void flush() {
        this.cache.flush();
    }

    public final void remove$okhttp(Request request) {
        request.getClass();
        DiskLruCache diskLruCache = this.cache;
        String strKey = CharsKt.key(request.url);
        synchronized (diskLruCache) {
            strKey.getClass();
            diskLruCache.initialize();
            diskLruCache.checkNotClosed();
            DiskLruCache.validateKey(strKey);
            DiskLruCache.Entry entry = (DiskLruCache.Entry) diskLruCache.lruEntries.get(strKey);
            if (entry == null) {
                return;
            }
            diskLruCache.removeEntry$okhttp(entry);
            if (diskLruCache.size <= diskLruCache.maxSize) {
                diskLruCache.mostRecentTrimFailed = false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CacheResponseBody extends ResponseBody {
        public final RealBufferedSource bodySource;
        public final String contentLength;
        public final String contentType;
        public final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = new RealBufferedSource(new AnonymousClass1((Source) snapshot.sources.get(1), this));
        }

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            String str = this.contentLength;
            if (str == null) {
                return -1L;
            }
            byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // okhttp3.ResponseBody
        public final MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                Regex regex = MediaType.TYPE_SUBTYPE;
                try {
                    return CollectionsKt__IterablesKt.get(str);
                } catch (IllegalArgumentException unused) {
                }
            }
            return null;
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            return this.bodySource;
        }

        /* JADX INFO: renamed from: okhttp3.Cache$CacheResponseBody$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class AnonymousClass1 extends ForwardingSource {
            public final /* synthetic */ byte $r8$classId = 1;
            public Object this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Source source, CacheResponseBody cacheResponseBody) {
                super(source);
                this.this$0 = cacheResponseBody;
            }

            @Override // okio.ForwardingSource, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                switch (this.$r8$classId) {
                    case 0:
                        ((CacheResponseBody) this.this$0).snapshot.close();
                        super.close();
                        break;
                    default:
                        super.close();
                        break;
                }
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws Exception {
                switch (this.$r8$classId) {
                    case 1:
                        try {
                            return super.read(buffer, j);
                        } catch (Exception e) {
                            this.this$0 = e;
                            throw e;
                        }
                    default:
                        return super.read(buffer, j);
                }
            }

            public /* synthetic */ AnonymousClass1(Source source) {
                super(source);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    /* JADX INFO: loaded from: classes.dex */
    public final class RealCacheRequest implements CachedContentIndex$Storage {
        public Object body;
        public Object cacheOut;
        public boolean done;
        public Object editor;
        public Object this$0;

        public static int hashCachedContent(CachedContent cachedContent, int i) {
            int iHashCode = cachedContent.key.hashCode() + (cachedContent.id * 31);
            DefaultContentMetadata defaultContentMetadata = cachedContent.metadata;
            if (i < 2) {
                long contentLength = ContentMetadata.getContentLength(defaultContentMetadata);
                return (iHashCode * 31) + ((int) (contentLength ^ (contentLength >>> 32)));
            }
            return defaultContentMetadata.hashCode() + (iHashCode * 31);
        }

        public static CachedContent readCachedContent(int i, DataInputStream dataInputStream) throws IOException {
            DefaultContentMetadata contentMetadata;
            int i2 = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            if (i < 2) {
                long j = dataInputStream.readLong();
                CacheFileMetadataIndex cacheFileMetadataIndex = new CacheFileMetadataIndex();
                cacheFileMetadataIndex.checkAndSet(Long.valueOf(j), "exo_len");
                contentMetadata = DefaultContentMetadata.EMPTY.copyWithMutationsApplied(cacheFileMetadataIndex);
            } else {
                contentMetadata = QuantizerWu.readContentMetadata(dataInputStream);
            }
            return new CachedContent(i2, utf, contentMetadata);
        }

        public void abort() {
            synchronized (((Cache) this.this$0)) {
                if (this.done) {
                    return;
                }
                this.done = true;
                _UtilCommonKt.closeQuietly((Sink) this.cacheOut);
                try {
                    ((Latch) this.editor).abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
        public void delete() {
            WeakCache weakCache = (WeakCache) this.body;
            ((File) weakCache.values).delete();
            ((File) weakCache.referenceQueue).delete();
        }

        public boolean dispatchNestedScrollInternal(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
            ViewParent nestedScrollingParentForType;
            int i6;
            int i7;
            int[] iArr3;
            NestedScrollView nestedScrollView = (NestedScrollView) this.body;
            if (this.done && (nestedScrollingParentForType = getNestedScrollingParentForType(i5)) != null) {
                if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
                    if (iArr != null) {
                        nestedScrollView.getLocationInWindow(iArr);
                        i6 = iArr[0];
                        i7 = iArr[1];
                    } else {
                        i6 = 0;
                        i7 = 0;
                    }
                    if (iArr2 == null) {
                        int[] iArr4 = (int[]) this.this$0;
                        if (iArr4 == null) {
                            iArr4 = new int[2];
                            this.this$0 = iArr4;
                        }
                        iArr4[0] = 0;
                        iArr4[1] = 0;
                        iArr3 = iArr4;
                    } else {
                        iArr3 = iArr2;
                    }
                    if (nestedScrollingParentForType instanceof NestedScrollingParent3) {
                        ((NestedScrollingParent3) nestedScrollingParentForType).onNestedScroll(nestedScrollView, i, i2, i3, i4, i5, iArr3);
                    } else {
                        iArr3[0] = iArr3[0] + i3;
                        iArr3[1] = iArr3[1] + i4;
                        if (nestedScrollingParentForType instanceof NestedScrollingParent2) {
                            ((NestedScrollingParent2) nestedScrollingParentForType).onNestedScroll(nestedScrollView, i, i2, i3, i4, i5);
                        } else if (i5 == 0) {
                            try {
                                nestedScrollingParentForType.onNestedScroll(nestedScrollView, i, i2, i3, i4);
                            } catch (AbstractMethodError e) {
                                Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onNestedScroll", e);
                            }
                        }
                    }
                    if (iArr != null) {
                        nestedScrollView.getLocationInWindow(iArr);
                        iArr[0] = iArr[0] - i6;
                        iArr[1] = iArr[1] - i7;
                    }
                    return true;
                }
                if (iArr != null) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    return false;
                }
            }
            return false;
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
        public boolean exists() {
            WeakCache weakCache = (WeakCache) this.body;
            return ((File) weakCache.values).exists() || ((File) weakCache.referenceQueue).exists();
        }

        public ViewParent getNestedScrollingParentForType(int i) {
            if (i == 0) {
                return (ViewParent) this.editor;
            }
            if (i != 1) {
                return null;
            }
            return (ViewParent) this.cacheOut;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0058  */
        @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
        public void load(HashMap map, SparseArray sparseArray) throws Throwable {
            DataInputStream dataInputStream;
            UtilsKt.checkState(!this.done);
            Cipher cipher = (Cipher) this.editor;
            WeakCache weakCache = (WeakCache) this.body;
            File file = (File) weakCache.values;
            File file2 = (File) weakCache.values;
            File file3 = (File) weakCache.referenceQueue;
            if (file.exists() || file3.exists()) {
                DataInputStream dataInputStream2 = null;
                try {
                    if (file3.exists()) {
                        file2.delete();
                        file3.renameTo(file2);
                    }
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                    DataInputStream dataInputStream3 = new DataInputStream(bufferedInputStream);
                    try {
                        int i = dataInputStream3.readInt();
                        if (i < 0 || i > 2) {
                            Util.closeQuietly(dataInputStream3);
                        } else {
                            if ((dataInputStream3.readInt() & 1) == 0) {
                                dataInputStream = dataInputStream3;
                            } else if (cipher == null) {
                                Util.closeQuietly(dataInputStream3);
                            } else {
                                byte[] bArr = new byte[16];
                                dataInputStream3.readFully(bArr);
                                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                                try {
                                    SecretKeySpec secretKeySpec = (SecretKeySpec) this.cacheOut;
                                    String str = Util.DEVICE_DEBUG_INFO;
                                    cipher.init(2, secretKeySpec, ivParameterSpec);
                                    dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, cipher));
                                } catch (InvalidAlgorithmParameterException e) {
                                    e = e;
                                    throw new IllegalStateException(e);
                                } catch (InvalidKeyException e2) {
                                    e = e2;
                                    throw new IllegalStateException(e);
                                }
                            }
                            try {
                                int i2 = dataInputStream.readInt();
                                int iHashCachedContent = 0;
                                for (int i3 = 0; i3 < i2; i3++) {
                                    CachedContent cachedContent = readCachedContent(i, dataInputStream);
                                    String str2 = cachedContent.key;
                                    map.put(str2, cachedContent);
                                    sparseArray.put(cachedContent.id, str2);
                                    iHashCachedContent += hashCachedContent(cachedContent, i);
                                }
                                int i4 = dataInputStream.readInt();
                                boolean z = dataInputStream.read() == -1;
                                if (i4 == iHashCachedContent && z) {
                                    Util.closeQuietly(dataInputStream);
                                    return;
                                }
                                Util.closeQuietly(dataInputStream);
                            } catch (IOException unused) {
                                dataInputStream2 = dataInputStream;
                                if (dataInputStream2 != null) {
                                    Util.closeQuietly(dataInputStream2);
                                }
                            } catch (Throwable th) {
                                dataInputStream2 = dataInputStream;
                                th = th;
                                if (dataInputStream2 != null) {
                                    Util.closeQuietly(dataInputStream2);
                                }
                                throw th;
                            }
                        }
                    } catch (IOException unused2) {
                        dataInputStream2 = dataInputStream3;
                    } catch (Throwable th2) {
                        th = th2;
                        dataInputStream2 = dataInputStream3;
                    }
                } catch (IOException unused3) {
                } catch (Throwable th3) {
                    th = th3;
                }
                map.clear();
                sparseArray.clear();
                file2.delete();
                file3.delete();
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
        public void onRemove(CachedContent cachedContent, boolean z) {
            this.done = true;
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
        public void onUpdate(CachedContent cachedContent) {
            this.done = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: process-BIzXfog, reason: not valid java name */
        public int m1908processBIzXfog(EmojiProcessor emojiProcessor, AndroidComposeView androidComposeView, boolean z) {
            int i;
            Object[] objArr;
            int i2;
            int i3;
            HitPathTracker hitPathTracker = (HitPathTracker) this.cacheOut;
            HitTestResult hitTestResult = (HitTestResult) this.this$0;
            if (this.done) {
                return 0;
            }
            try {
                this.done = true;
                InternalPointerEvent internalPointerEventProduce = ((DrawResult) this.body).produce(androidComposeView, emojiProcessor);
                LongSparseArray longSparseArray = internalPointerEventProduce.changes;
                int size = longSparseArray.size();
                while (true) {
                    if (i >= size) {
                        objArr = true;
                        break;
                    }
                    PointerInputChange pointerInputChange = (PointerInputChange) longSparseArray.valueAt(i);
                    i = (pointerInputChange.pressed || pointerInputChange.previousPressed) ? 0 : i + 1;
                    objArr = false;
                    break;
                }
                Object[] objArr2 = internalPointerEventProduce.getActiveGesture() == PointerClassification.Pan ? true : objArr;
                int size2 = longSparseArray.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    PointerInputChange pointerInputChange2 = (PointerInputChange) longSparseArray.valueAt(i4);
                    if (objArr2 != false || PointerIconKt.changedToDownIgnoreConsumed(pointerInputChange2)) {
                        ((LayoutNode) this.editor).m648hitTest6fMxITs$ui(pointerInputChange2.position, hitTestResult, pointerInputChange2.type, true);
                        if (!hitTestResult.values.isEmpty()) {
                            hitPathTracker.m584addHitPathQJqDSyo(pointerInputChange2.id, hitTestResult, PointerIconKt.changedToDownIgnoreConsumed(pointerInputChange2));
                            hitTestResult.clear();
                        }
                    }
                }
                boolean zDispatchChanges = hitPathTracker.dispatchChanges(internalPointerEventProduce, z);
                if (internalPointerEventProduce.suppressMovementConsumption) {
                    i2 = 0;
                    break;
                }
                int size3 = longSparseArray.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size3) {
                        i2 = 0;
                        break;
                    }
                    PointerInputChange pointerInputChange3 = (PointerInputChange) longSparseArray.valueAt(i5);
                    if (!Offset.m434equalsimpl0(PointerIconKt.positionChangeInternal(pointerInputChange3, true), 0L) && pointerInputChange3.isConsumed()) {
                        i2 = 1;
                        break;
                    }
                    i5++;
                }
                int size4 = longSparseArray.size();
                for (int i6 = 0; i6 < size4; i6++) {
                    if (((PointerInputChange) longSparseArray.valueAt(i6)).isConsumed()) {
                        i3 = 1;
                        return (zDispatchChanges ? 1 : 0) | (i2 << 1) | (i3 << 2);
                    }
                }
                i3 = 0;
                return (zDispatchChanges ? 1 : 0) | (i2 << 1) | (i3 << 2);
            } finally {
                this.done = false;
            }
        }

        public synchronized void shutdown() {
            try {
                if (this.done) {
                    return;
                }
                this.done = true;
                Context context = (Context) this.this$0;
                if (context != null) {
                    ((AndroidSystemCallbacks$ActivityCallbacks) this.cacheOut).unregister(context);
                    context.unregisterComponentCallbacks((AndroidSystemCallbacks$ComponentCallbacks) this.body);
                }
                ((WeakReference) this.editor).clear();
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
        public void storeFully(HashMap map) throws Throwable {
            WeakCache weakCache = (WeakCache) this.body;
            DataOutputStream dataOutputStream = null;
            try {
                AtomicFile$AtomicFileOutputStream atomicFile$AtomicFileOutputStreamStartWrite = weakCache.startWrite();
                ReusableBufferedOutputStream reusableBufferedOutputStream = (ReusableBufferedOutputStream) this.this$0;
                if (reusableBufferedOutputStream == null) {
                    this.this$0 = new ReusableBufferedOutputStream(atomicFile$AtomicFileOutputStreamStartWrite);
                } else {
                    reusableBufferedOutputStream.reset(atomicFile$AtomicFileOutputStreamStartWrite);
                }
                DataOutputStream dataOutputStream2 = new DataOutputStream((ReusableBufferedOutputStream) this.this$0);
                try {
                    dataOutputStream2.writeInt(2);
                    dataOutputStream2.writeInt(0);
                    dataOutputStream2.writeInt(map.size());
                    int iHashCachedContent = 0;
                    for (CachedContent cachedContent : map.values()) {
                        dataOutputStream2.writeInt(cachedContent.id);
                        dataOutputStream2.writeUTF(cachedContent.key);
                        QuantizerWu.writeContentMetadata(cachedContent.metadata, dataOutputStream2);
                        iHashCachedContent += hashCachedContent(cachedContent, 2);
                    }
                    dataOutputStream2.writeInt(iHashCachedContent);
                    dataOutputStream2.close();
                    ((File) weakCache.referenceQueue).delete();
                    String str = Util.DEVICE_DEBUG_INFO;
                    this.done = false;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    Util.closeQuietly(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
        public void storeIncremental(HashMap map) throws Throwable {
            if (this.done) {
                storeFully(map);
            }
        }

        @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
        public void initialize(long j) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Entry {
        public static final String RECEIVED_MILLIS;
        public static final String SENT_MILLIS;
        public final int code;
        public final Handshake handshake;
        public final String message;
        public final Protocol protocol;
        public final long receivedResponseMillis;
        public final String requestMethod;
        public final Headers responseHeaders;
        public final long sentRequestMillis;
        public final HttpUrl url;
        public final Headers varyHeaders;

        static {
            Platform platform = Platform.platform;
            Platform.platform.getClass();
            SENT_MILLIS = "OkHttp-Sent-Millis";
            Platform.platform.getClass();
            RECEIVED_MILLIS = "OkHttp-Received-Millis";
        }

        public Entry(Source source) throws IOException {
            HttpUrl httpUrlBuild;
            TlsVersion tlsVersionForJavaName;
            source.getClass();
            try {
                RealBufferedSource realBufferedSource = new RealBufferedSource(source);
                String utf8LineStrict = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
                try {
                    HttpUrl.Builder builder = new HttpUrl.Builder();
                    builder.parse$okhttp(null, utf8LineStrict);
                    httpUrlBuild = builder.build();
                } catch (IllegalArgumentException unused) {
                    httpUrlBuild = null;
                }
                if (httpUrlBuild == null) {
                    IOException iOException = new IOException("Cache corruption for ".concat(utf8LineStrict));
                    Platform platform = Platform.platform;
                    Platform.platform.log(5, "cache corruption", iOException);
                    throw iOException;
                }
                this.url = httpUrlBuild;
                this.requestMethod = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
                Headers.Builder builder2 = new Headers.Builder((byte) 0);
                int int$okhttp = CharsKt.readInt$okhttp(realBufferedSource);
                for (int i = 0; i < int$okhttp; i++) {
                    builder2.addLenient$okhttp(realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE));
                }
                this.varyHeaders = EntryPoints.commonBuild(builder2);
                StatusLine statusLineM1870parse = CollectionsKt__IterablesKt.m1870parse(realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE));
                this.protocol = (Protocol) statusLineM1870parse.protocol;
                this.code = statusLineM1870parse.code;
                this.message = (String) statusLineM1870parse.message;
                Headers.Builder builder3 = new Headers.Builder((byte) 0);
                int int$okhttp2 = CharsKt.readInt$okhttp(realBufferedSource);
                for (int i2 = 0; i2 < int$okhttp2; i2++) {
                    builder3.addLenient$okhttp(realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE));
                }
                String str = SENT_MILLIS;
                String str2 = builder3.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder3.get(str3);
                builder3.removeAll(str);
                builder3.removeAll(str3);
                this.sentRequestMillis = str2 != null ? Long.parseLong(str2) : 0L;
                this.receivedResponseMillis = str4 != null ? Long.parseLong(str4) : 0L;
                this.responseHeaders = EntryPoints.commonBuild(builder3);
                if (this.url.isHttps()) {
                    String utf8LineStrict2 = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
                    if (utf8LineStrict2.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + utf8LineStrict2 + '\"');
                    }
                    CipherSuite cipherSuiteM1909forJavaName = CipherSuite.Companion.m1909forJavaName(realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE));
                    List certificateList = readCertificateList(realBufferedSource);
                    List certificateList2 = readCertificateList(realBufferedSource);
                    if (realBufferedSource.exhausted()) {
                        tlsVersionForJavaName = TlsVersion.SSL_3_0;
                    } else {
                        Protocol.Companion companion = TlsVersion.Companion;
                        String utf8LineStrict3 = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
                        companion.getClass();
                        tlsVersionForJavaName = Protocol.Companion.forJavaName(utf8LineStrict3);
                    }
                    this.handshake = new Handshake(tlsVersionForJavaName, cipherSuiteM1909forJavaName, _UtilJvmKt.toImmutableList(certificateList2), new Url$$ExternalSyntheticLambda0(_UtilJvmKt.toImmutableList(certificateList), (byte) 7));
                } else {
                    this.handshake = null;
                }
                source.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CharsKt.closeFinally(source, th);
                    throw th2;
                }
            }
        }

        public static List readCertificateList(RealBufferedSource realBufferedSource) throws IOException {
            int int$okhttp = CharsKt.readInt$okhttp(realBufferedSource);
            if (int$okhttp == -1) {
                return EmptyList.INSTANCE;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(int$okhttp);
                for (int i = 0; i < int$okhttp; i++) {
                    String utf8LineStrict = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
                    Buffer buffer = new Buffer();
                    ByteString byteString = ByteString.EMPTY;
                    ByteString byteStringDecodeBase64 = Path.Companion.decodeBase64(utf8LineStrict);
                    if (byteStringDecodeBase64 == null) {
                        throw new IOException("Corrupt certificate in cache entry");
                    }
                    buffer.write(byteStringDecodeBase64);
                    arrayList.add(certificateFactory.generateCertificate(buffer.new AnonymousClass1()));
                }
                return arrayList;
            } catch (CertificateException e) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(e.getMessage());
                return null;
            }
        }

        public static void writeCertList(RealBufferedSink realBufferedSink, List list) throws IOException {
            try {
                realBufferedSink.writeDecimalLong(list.size());
                realBufferedSink.writeByte(10);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    byte[] encoded = ((Certificate) it.next()).getEncoded();
                    ByteString byteString = ByteString.EMPTY;
                    encoded.getClass();
                    realBufferedSink.writeUtf8(Path.Companion.of$default(encoded).base64());
                    realBufferedSink.writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(e.getMessage());
            }
        }

        public final void writeTo(Latch latch) {
            Handshake handshake;
            HttpUrl httpUrl = this.url;
            Headers headers = this.responseHeaders;
            Headers headers2 = this.varyHeaders;
            RealBufferedSink realBufferedSink = new RealBufferedSink(latch.newSink(0));
            try {
                realBufferedSink.writeUtf8(httpUrl.url);
                realBufferedSink.writeByte(10);
                realBufferedSink.writeUtf8(this.requestMethod);
                realBufferedSink.writeByte(10);
                realBufferedSink.writeDecimalLong(headers2.size());
                realBufferedSink.writeByte(10);
                int size = headers2.size();
                for (int i = 0; i < size; i++) {
                    realBufferedSink.writeUtf8(EntryPoints.commonName(headers2, i));
                    realBufferedSink.writeUtf8(": ");
                    realBufferedSink.writeUtf8(EntryPoints.commonValue(headers2, i));
                    realBufferedSink.writeByte(10);
                }
                Protocol protocol = this.protocol;
                int i2 = this.code;
                String str = this.message;
                protocol.getClass();
                str.getClass();
                StringBuilder sb = new StringBuilder();
                if (protocol == Protocol.HTTP_1_0) {
                    sb.append("HTTP/1.0");
                } else {
                    sb.append("HTTP/1.1");
                }
                sb.append(' ');
                sb.append(i2);
                sb.append(' ');
                sb.append(str);
                realBufferedSink.writeUtf8(sb.toString());
                realBufferedSink.writeByte(10);
                realBufferedSink.writeDecimalLong(headers.size() + 2);
                realBufferedSink.writeByte(10);
                int size2 = headers.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    realBufferedSink.writeUtf8(EntryPoints.commonName(headers, i3));
                    realBufferedSink.writeUtf8(": ");
                    realBufferedSink.writeUtf8(EntryPoints.commonValue(headers, i3));
                    realBufferedSink.writeByte(10);
                }
                realBufferedSink.writeUtf8(SENT_MILLIS);
                realBufferedSink.writeUtf8(": ");
                realBufferedSink.writeDecimalLong(this.sentRequestMillis);
                realBufferedSink.writeByte(10);
                realBufferedSink.writeUtf8(RECEIVED_MILLIS);
                realBufferedSink.writeUtf8(": ");
                realBufferedSink.writeDecimalLong(this.receivedResponseMillis);
                realBufferedSink.writeByte(10);
                if (httpUrl.isHttps() && (handshake = this.handshake) != null) {
                    realBufferedSink.writeByte(10);
                    realBufferedSink.writeUtf8(handshake.cipherSuite.javaName);
                    realBufferedSink.writeByte(10);
                    writeCertList(realBufferedSink, handshake.peerCertificates());
                    writeCertList(realBufferedSink, handshake.localCertificates);
                    realBufferedSink.writeUtf8(handshake.tlsVersion.javaName);
                    realBufferedSink.writeByte(10);
                }
                realBufferedSink.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CharsKt.closeFinally(realBufferedSink, th);
                    throw th2;
                }
            }
        }

        public Entry(Response response) {
            Headers headers;
            Request request = response.request;
            this.url = request.url;
            Response response2 = response.networkResponse;
            response2.getClass();
            Headers headers2 = response2.request.headers;
            Headers headers3 = response.headers;
            Set setVaryFields = CharsKt.varyFields(headers3);
            if (setVaryFields.isEmpty()) {
                headers = Headers.EMPTY;
            } else {
                ArrayList arrayList = new ArrayList(20);
                int size = headers2.size();
                for (int i = 0; i < size; i++) {
                    String strCommonName = EntryPoints.commonName(headers2, i);
                    if (setVaryFields.contains(strCommonName)) {
                        String strCommonValue = EntryPoints.commonValue(headers2, i);
                        EntryPoints.headersCheckName(strCommonName);
                        EntryPoints.headersCheckValue(strCommonValue, strCommonName);
                        arrayList.add(strCommonName);
                        arrayList.add(StringsKt.trim(strCommonValue).toString());
                    }
                }
                headers = new Headers((String[]) arrayList.toArray(new String[0]));
            }
            this.varyHeaders = headers;
            this.requestMethod = request.method;
            this.protocol = response.protocol;
            this.code = response.code;
            this.message = response.message;
            this.responseHeaders = headers3;
            this.handshake = response.handshake;
            this.sentRequestMillis = response.sentRequestAtMillis;
            this.receivedResponseMillis = response.receivedResponseAtMillis;
        }
    }
}

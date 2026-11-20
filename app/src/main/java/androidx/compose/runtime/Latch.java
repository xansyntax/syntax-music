package androidx.compose.runtime;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.runtime.Latch;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.datastore.core.AtomicInt;
import androidx.media3.common.C;
import androidx.media3.common.audio.AudioBecomingNoisyManager$AudioBecomingNoisyReceiver;
import androidx.media3.common.util.SystemHandlerWrapper;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.drm.MediaDrmCallback$Response;
import androidx.media3.exoplayer.drm.MediaDrmCallbackException;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.extractor.text.SubtitleTranscodingTrackOutput;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableMap;
import com.google.common.net.MediaType;
import io.ktor.http.HttpHeaders;
import io.ktor.util.cio.FileChannelsKt$$ExternalSyntheticLambda1;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache$fileSystem$1;
import okhttp3.internal.cache.FaultHidingSink;
import okio.BlackholeSink;
import okio.Path;
import okio.Sink;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Latch implements ExtractorOutput {
    public boolean _isOpen;
    public Object awaiters;
    public final Object lock;
    public Object spareList;

    public Latch(Context context, Looper looper, Looper looper2, ExoPlayerImpl.ComponentListener componentListener) {
        this.lock = context.getApplicationContext();
        this.spareList = new SystemHandlerWrapper(new Handler(looper, null));
        this.awaiters = new AudioBecomingNoisyManager$AudioBecomingNoisyReceiver(this, new SystemHandlerWrapper(new Handler(looper2, null)), componentListener);
    }

    public void abort() {
        DiskLruCache diskLruCache = (DiskLruCache) this.spareList;
        synchronized (diskLruCache) {
            try {
                if (this._isOpen) {
                    throw new IllegalStateException("Check failed.");
                }
                if (Intrinsics.areEqual(((DiskLruCache.Entry) this.lock).currentEditor, this)) {
                    diskLruCache.completeEdit$okhttp(this, false);
                }
                this._isOpen = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void commit() {
        DiskLruCache diskLruCache = (DiskLruCache) this.spareList;
        synchronized (diskLruCache) {
            try {
                if (this._isOpen) {
                    throw new IllegalStateException("Check failed.");
                }
                if (Intrinsics.areEqual(((DiskLruCache.Entry) this.lock).currentEditor, this)) {
                    diskLruCache.completeEdit$okhttp(this, true);
                }
                this._isOpen = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void complete(boolean z) {
        coil3.disk.DiskLruCache diskLruCache = (coil3.disk.DiskLruCache) this.spareList;
        synchronized (diskLruCache.lock) {
            try {
                if (this._isOpen) {
                    throw new IllegalStateException("editor is closed");
                }
                if (Intrinsics.areEqual(((coil3.disk.DiskLruCache.Entry) this.lock).currentEditor, this)) {
                    diskLruCache.completeEdit(this, z);
                }
                this._isOpen = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void detach$okhttp() {
        DiskLruCache.Entry entry = (DiskLruCache.Entry) this.lock;
        if (Intrinsics.areEqual(entry.currentEditor, this)) {
            DiskLruCache diskLruCache = (DiskLruCache) this.spareList;
            if (diskLruCache.civilizedFileSystem) {
                diskLruCache.completeEdit$okhttp(this, false);
            } else {
                entry.zombie = true;
            }
        }
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void endTracks() {
        SparseArray sparseArray = (SparseArray) this.spareList;
        ((ExtractorOutput) this.lock).endTracks();
        if (this._isOpen) {
            for (int i = 0; i < sparseArray.size(); i++) {
                ((SubtitleTranscodingTrackOutput) sparseArray.valueAt(i)).shouldSuppressParsingErrors = true;
            }
        }
    }

    public MediaDrmCallback$Response executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException {
        String str;
        String str2 = keyRequest.licenseServerUrl;
        if (this._isOpen || TextUtils.isEmpty(str2)) {
            str2 = (String) this.awaiters;
        }
        if (TextUtils.isEmpty(str2)) {
            Map map = Collections.EMPTY_MAP;
            Uri uri = Uri.EMPTY;
            UtilsKt.checkNotNull(uri, "The uri must be set.");
            throw new MediaDrmCallbackException(new DataSpec(uri, 0L, 1, null, map, 0L, -1L, null, 0), uri, RegularImmutableMap.EMPTY, 0L, new IllegalStateException("No license URL"));
        }
        HashMap map2 = new HashMap();
        UUID uuid2 = C.PLAYREADY_UUID;
        if (uuid2.equals(uuid)) {
            str = "text/xml";
        } else {
            str = C.CLEARKEY_UUID.equals(uuid) ? "application/json" : "application/octet-stream";
        }
        map2.put(HttpHeaders.ContentType, str);
        if (uuid2.equals(uuid)) {
            map2.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (((HashMap) this.spareList)) {
            map2.putAll((HashMap) this.spareList);
        }
        return MathKt.executePost(((AtomicInt) this.lock).createDataSource(), str2, keyRequest.data, map2);
    }

    public MediaDrmCallback$Response executeProvisionRequest(ExoMediaDrm.ProvisionRequest provisionRequest) {
        Charset charset = StandardCharsets.UTF_8;
        byte[][] bArr = {"{\"signedRequest\":\"".getBytes(charset), provisionRequest.data, "\"}".getBytes(charset)};
        long length = 0;
        for (int i = 0; i < 3; i++) {
            length += (long) bArr[i].length;
        }
        int i2 = (int) length;
        UtilsKt.checkArgument(length, "the total number of elements (%s) in the arrays must fit in an int", length == ((long) i2));
        byte[] bArr2 = new byte[i2];
        int length2 = 0;
        for (int i3 = 0; i3 < 3; i3++) {
            byte[] bArr3 = bArr[i3];
            System.arraycopy(bArr3, 0, bArr2, length2, bArr3.length);
            length2 += bArr3.length;
        }
        DataSource dataSourceCreateDataSource = ((AtomicInt) this.lock).createDataSource();
        String str = provisionRequest.defaultUrl;
        String string = MediaType.JSON_UTF_8.toString();
        String strValueOf = String.valueOf(i2);
        Maps.checkEntryNotNull(HttpHeaders.ContentLength, strValueOf);
        return MathKt.executePost(dataSourceCreateDataSource, str, bArr2, RegularImmutableMap.create(2, new Object[]{HttpHeaders.ContentType, string, HttpHeaders.ContentLength, strValueOf}, null));
    }

    public Path file(int i) {
        Path path;
        coil3.disk.DiskLruCache diskLruCache = (coil3.disk.DiskLruCache) this.spareList;
        synchronized (diskLruCache.lock) {
            if (this._isOpen) {
                throw new IllegalStateException("editor is closed");
            }
            ((boolean[]) this.awaiters)[i] = true;
            Object obj = ((coil3.disk.DiskLruCache.Entry) this.lock).dirtyFiles.get(i);
            FileSystemsKt.createFile$default(diskLruCache.fileSystem, (Path) obj);
            path = (Path) obj;
        }
        return path;
    }

    public Sink newSink(int i) {
        DiskLruCache diskLruCache = (DiskLruCache) this.spareList;
        synchronized (diskLruCache) {
            try {
                if (this._isOpen) {
                    throw new IllegalStateException("Check failed.");
                }
                if (!Intrinsics.areEqual(((DiskLruCache.Entry) this.lock).currentEditor, this)) {
                    return new BlackholeSink();
                }
                if (!((DiskLruCache.Entry) this.lock).readable) {
                    boolean[] zArr = (boolean[]) this.awaiters;
                    zArr.getClass();
                    zArr[i] = true;
                }
                Path path = (Path) ((DiskLruCache.Entry) this.lock).dirtyFiles.get(i);
                try {
                    DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = diskLruCache.fileSystem;
                    diskLruCache$fileSystem$1.getClass();
                    path.getClass();
                    return new FaultHidingSink(diskLruCache$fileSystem$1.sink(path, false), new FileChannelsKt$$ExternalSyntheticLambda1(diskLruCache, this, (byte) 11));
                } catch (FileNotFoundException unused) {
                    return new BlackholeSink();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        ((ExtractorOutput) this.lock).seekMap(seekMap);
    }

    public void setEnabled(boolean z) {
        if (z == this._isOpen) {
            return;
        }
        SystemHandlerWrapper systemHandlerWrapper = (SystemHandlerWrapper) this.spareList;
        if (z) {
            final byte b = 0;
            systemHandlerWrapper.post(new Runnable(this) { // from class: androidx.media3.common.audio.AudioBecomingNoisyManager$$ExternalSyntheticLambda0
                public final /* synthetic */ Latch f$0;

                {
                    this.f$0 = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    byte b2 = b;
                    Latch latch = this.f$0;
                    switch (b2) {
                        case 0:
                            ((Context) latch.lock).registerReceiver((AudioBecomingNoisyManager$AudioBecomingNoisyReceiver) latch.awaiters, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
                            break;
                        default:
                            ((Context) latch.lock).unregisterReceiver((AudioBecomingNoisyManager$AudioBecomingNoisyReceiver) latch.awaiters);
                            break;
                    }
                }
            });
            this._isOpen = true;
        } else {
            final byte b2 = 1;
            systemHandlerWrapper.post(new Runnable(this) { // from class: androidx.media3.common.audio.AudioBecomingNoisyManager$$ExternalSyntheticLambda0
                public final /* synthetic */ Latch f$0;

                {
                    this.f$0 = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    byte b3 = b2;
                    Latch latch = this.f$0;
                    switch (b3) {
                        case 0:
                            ((Context) latch.lock).registerReceiver((AudioBecomingNoisyManager$AudioBecomingNoisyReceiver) latch.awaiters, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
                            break;
                        default:
                            ((Context) latch.lock).unregisterReceiver((AudioBecomingNoisyManager$AudioBecomingNoisyReceiver) latch.awaiters);
                            break;
                    }
                }
            });
            this._isOpen = false;
        }
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public TrackOutput track(int i, int i2) {
        SparseArray sparseArray = (SparseArray) this.spareList;
        ExtractorOutput extractorOutput = (ExtractorOutput) this.lock;
        if (i2 != 3 && i2 != 5) {
            this._isOpen = true;
        }
        if (i2 != 3) {
            return extractorOutput.track(i, i2);
        }
        SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput = (SubtitleTranscodingTrackOutput) sparseArray.get(i);
        if (subtitleTranscodingTrackOutput != null) {
            return subtitleTranscodingTrackOutput;
        }
        SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput2 = new SubtitleTranscodingTrackOutput(extractorOutput.track(i, i2), (CueDecoder) this.awaiters);
        sparseArray.put(i, subtitleTranscodingTrackOutput2);
        return subtitleTranscodingTrackOutput2;
    }

    public Latch(ExtractorOutput extractorOutput, CueDecoder cueDecoder) {
        this.lock = extractorOutput;
        this.awaiters = cueDecoder;
        this.spareList = new SparseArray();
    }

    public Latch() {
        this.lock = new Object();
        this.awaiters = new ArrayList();
        this.spareList = new ArrayList();
        this._isOpen = true;
    }

    public Latch(String str, boolean z, AtomicInt atomicInt) {
        UtilsKt.checkArgument((z && TextUtils.isEmpty(str)) ? false : true);
        this.lock = atomicInt;
        this.awaiters = str;
        this._isOpen = z;
        this.spareList = new HashMap();
    }

    public Latch(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState, PrefetchScheduler prefetchScheduler) {
        this.lock = lazyLayoutItemContentFactory;
        this.awaiters = subcomposeLayoutState;
        this.spareList = prefetchScheduler;
        this._isOpen = true;
    }

    public Latch(coil3.disk.DiskLruCache diskLruCache, coil3.disk.DiskLruCache.Entry entry) {
        this.spareList = diskLruCache;
        this.lock = entry;
        this.awaiters = new boolean[2];
    }

    public Latch(DiskLruCache diskLruCache, DiskLruCache.Entry entry) {
        boolean[] zArr;
        this.spareList = diskLruCache;
        this.lock = entry;
        if (entry.readable) {
            zArr = null;
        } else {
            diskLruCache.getClass();
            zArr = new boolean[2];
        }
        this.awaiters = zArr;
    }
}

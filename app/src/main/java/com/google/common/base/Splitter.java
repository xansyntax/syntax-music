package com.google.common.base;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.datastore.preferences.PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.ListenerSet$$ExternalSyntheticLambda0;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.VorbisBitArray;
import androidx.media3.extractor.VorbisUtil$Mode;
import androidx.media3.extractor.ts.SectionPayloadReader;
import androidx.media3.extractor.ts.SectionReader;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.extractor.ts.TsPayloadReader;
import androidx.media3.session.IMediaSession;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.legacy.MediaSessionManager$RemoteUserInfoImplBase;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.internal.NavGraphImpl;
import androidx.sqlite.SQLiteConnection;
import coil3.Extras;
import coil3.Image;
import coil3.RealImageLoader;
import coil3.UriKt;
import coil3.compose.AsyncImageKt;
import coil3.compose.AsyncImagePainter;
import coil3.request.CachePolicy;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeKt;
import coil3.target.GenericViewTarget;
import coil3.target.Target;
import coil3.util.HardwareBitmapService;
import coil3.util.HardwareBitmapsKt;
import coil3.util.LimitedFileDescriptorHardwareBitmapService;
import coil3.util.Utils_androidKt;
import com.google.common.collect.Maps$$ExternalSyntheticLambda1;
import com.google.common.math.IntMath;
import com.google.common.util.concurrent.AbstractTransformFuture$TransformFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.metrolist.music.constants.AudioQuality;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import io.ktor.http.HttpHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.time.Instant;
import kotlin.time.InstantFormatException;
import kotlin.time.InstantKt;
import kotlin.time.InstantParseResult;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.io.Utf8Kt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.CacheEntry;
import kotlinx.serialization.internal.SerializerCache;
import kotlinx.serialization.json.internal.InternalJsonReader;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.RealWebSocket$$ExternalSyntheticLambda1;
import okhttp3.internal.ws.WebSocketExtensions;
import okhttp3.internal.ws.WebSocketReader;
import okhttp3.internal.ws.WebSocketWriter;
import okio.FileSystem;
import okio.Okio__OkioKt;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Socket;
import okio.Source;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Splitter implements SectionPayloadReader, BitmapLoader, Target, ReadOnlyProperty, InstantParseResult, SerializerCache, InternalJsonReader, Callback {
    public final /* synthetic */ byte $r8$classId;
    public Object strategy;
    public Object trimmer;

    public Splitter(RealImageLoader realImageLoader) {
        Object limitedFileDescriptorHardwareBitmapService;
        this.$r8$classId = (byte) 8;
        this.trimmer = realImageLoader;
        if (HardwareBitmapsKt.IS_DEVICE_BLOCKED) {
            limitedFileDescriptorHardwareBitmapService = new VorbisUtil$Mode(false);
        } else {
            int i = Build.VERSION.SDK_INT;
            limitedFileDescriptorHardwareBitmapService = (i == 26 || i == 27) ? new LimitedFileDescriptorHardwareBitmapService() : new VorbisUtil$Mode(true);
        }
        this.strategy = limitedFileDescriptorHardwareBitmapService;
    }

    public static Bitmap createFallbackBitmap() {
        return Bitmap.createBitmap(64, 64, Bitmap.Config.ARGB_8888);
    }

    public static Bitmap createIndependentCopy(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            return createFallbackBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (Paint) null);
            return bitmapCreateBitmap;
        } catch (Exception unused) {
            Timber.Forest.tag("CoilBitmapLoader");
            ConnectionPool.w$1(new Object[0]);
            return createFallbackBitmap();
        }
    }

    public static Lifecycle findLifecycle(ImageRequest imageRequest) {
        Target target = imageRequest.target;
        Object context = target instanceof GenericViewTarget ? ((GenericViewTarget) target).getView().getContext() : imageRequest.context;
        while (!(context instanceof LifecycleOwner)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return ((LifecycleOwner) context).getLifecycle();
    }

    public static boolean isConfigValidForHardware(ImageRequest imageRequest, Bitmap.Config config) {
        if (config == Bitmap.Config.HARDWARE) {
            if (!((Boolean) UriKt.getExtra(imageRequest, ImageRequests_androidKt.allowHardwareKey)).booleanValue()) {
                return false;
            }
            Target target = imageRequest.target;
            if (target instanceof GenericViewTarget) {
                View view = ((GenericViewTarget) target).getView();
                if (view.isAttachedToWindow() && !view.isHardwareAccelerated()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // androidx.media3.extractor.ts.SectionPayloadReader
    public void consume(ParsableByteArray parsableByteArray) {
        TsExtractor tsExtractor = (TsExtractor) this.strategy;
        SparseArray sparseArray = tsExtractor.tsPayloadReaders;
        VorbisBitArray vorbisBitArray = (VorbisBitArray) this.trimmer;
        if (parsableByteArray.readUnsignedByte() == 0 && (parsableByteArray.readUnsignedByte() & 128) != 0) {
            parsableByteArray.skipBytes(6);
            int iBytesLeft = parsableByteArray.bytesLeft() / 4;
            for (int i = 0; i < iBytesLeft; i++) {
                parsableByteArray.readBytes(vorbisBitArray.data, 0, 4);
                vorbisBitArray.setPosition(0);
                int bits = vorbisBitArray.readBits(16);
                vorbisBitArray.skipBits(3);
                if (bits == 0) {
                    vorbisBitArray.skipBits(13);
                } else {
                    int bits2 = vorbisBitArray.readBits(13);
                    if (sparseArray.get(bits2) == null) {
                        sparseArray.put(bits2, new SectionReader(new NavGraphImpl(tsExtractor, bits2)));
                        tsExtractor.remainingPmts++;
                    }
                }
            }
            sparseArray.remove(0);
        }
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public ListenableFuture decodeBitmap(byte[] bArr) {
        switch (this.$r8$classId) {
            case 3:
                return AbstractTransformFuture$TransformFuture.create(((BitmapLoader) this.trimmer).decodeBitmap(bArr), new Maps$$ExternalSyntheticLambda1((byte) 3, this));
            default:
                bArr.getClass();
                CoroutineScope coroutineScope = (CoroutineScope) this.strategy;
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                return RegexKt.future$default(coroutineScope, DefaultIoScheduler.INSTANCE, new InterruptibleKt$runInterruptible$2(bArr, this, null, (byte) 13));
        }
    }

    public void flushCommandQueue() {
        MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) this.strategy;
        IMediaSession iMediaSession = mediaControllerImplBase.iSession;
        if (iMediaSession == null || !iMediaSession.asBinder().isBinderAlive()) {
            return;
        }
        try {
            mediaControllerImplBase.iSession.flushCommandQueue(mediaControllerImplBase.controllerStub);
        } catch (RemoteException e) {
            Log.w("MCImplBase", "Error in sending flushCommandQueue", e);
        }
    }

    @Override // kotlinx.serialization.internal.SerializerCache
    public KSerializer get(KClass kClass) {
        Object objPutIfAbsent;
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.strategy;
        Class javaClass = Okio__OkioKt.getJavaClass(kClass);
        Object cacheEntry = concurrentHashMap.get(javaClass);
        if (cacheEntry == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(javaClass, (cacheEntry = new CacheEntry((KSerializer) ((Function1) this.trimmer).invoke(kClass))))) != null) {
            cacheEntry = objPutIfAbsent;
        }
        return ((CacheEntry) cacheEntry).serializer;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public Object getValue(Object obj, KProperty kProperty) {
        kProperty.getClass();
        String str = (String) UtilsKt.get(UtilsKt.getDataStore((Context) this.trimmer), (Preferences$Key) this.strategy);
        AudioQuality audioQuality = AudioQuality.AUTO;
        if (str == null) {
            return audioQuality;
        }
        try {
            return AudioQuality.valueOf(str);
        } catch (IllegalArgumentException unused) {
            return audioQuality;
        }
    }

    public boolean isPermissionGranted(MediaSessionManager$RemoteUserInfoImplBase mediaSessionManager$RemoteUserInfoImplBase, String str) {
        int i = mediaSessionManager$RemoteUserInfoImplBase.pid;
        Context context = (Context) this.trimmer;
        if (i < 0) {
            return context.getPackageManager().checkPermission(str, mediaSessionManager$RemoteUserInfoImplBase.packageName) == 0;
        }
        return context.checkPermission(str, i, mediaSessionManager$RemoteUserInfoImplBase.uid) == 0;
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public ListenableFuture loadBitmap(Uri uri) {
        switch (this.$r8$classId) {
            case 3:
                return AbstractTransformFuture$TransformFuture.create(((BitmapLoader) this.trimmer).loadBitmap(uri), new Maps$$ExternalSyntheticLambda1((byte) 3, this));
            default:
                uri.getClass();
                CoroutineScope coroutineScope = (CoroutineScope) this.strategy;
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                return RegexKt.future$default(coroutineScope, DefaultIoScheduler.INSTANCE, new DataStoreKt$get$1((Object) this, (Object) uri, (Continuation) null, (byte) 20));
        }
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public ListenableFuture loadBitmapFromMetadata(MediaMetadata mediaMetadata) {
        String string;
        switch (this.$r8$classId) {
            case 3:
                ListenableFuture listenableFutureLoadBitmapFromMetadata = ((BitmapLoader) this.trimmer).loadBitmapFromMetadata(mediaMetadata);
                if (listenableFutureLoadBitmapFromMetadata == null) {
                    return null;
                }
                return AbstractTransformFuture$TransformFuture.create(listenableFutureLoadBitmapFromMetadata, new Maps$$ExternalSyntheticLambda1((byte) 3, this));
            default:
                mediaMetadata.getClass();
                byte[] bArr = mediaMetadata.artworkData;
                if (bArr != null) {
                    return decodeBitmap(bArr);
                }
                Uri uri = mediaMetadata.artworkUri;
                if (uri == null) {
                    Bundle bundle = mediaMetadata.extras;
                    uri = (bundle == null || (string = bundle.getString("artwork_uri")) == null) ? null : Uri.parse(string);
                    if (uri == null) {
                        return null;
                    }
                }
                return loadBitmap(uri);
        }
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        RealWebSocket.failWebSocket$default((RealWebSocket) this.trimmer, iOException, null, 6);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        Source source;
        Sink sink;
        int iIntValue;
        String strRemoveSurrounding;
        try {
            Socket socketCheckUpgradeSuccess$okhttp = ((RealWebSocket) this.trimmer).checkUpgradeSuccess$okhttp(response);
            Headers headers = response.headers;
            int size = headers.size();
            int i = 0;
            int i2 = 0;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            Integer intOrNull = null;
            Integer intOrNull2 = null;
            while (i2 < size) {
                if (EntryPoints.commonName(headers, i2).equalsIgnoreCase(HttpHeaders.SecWebSocketExtensions)) {
                    String strCommonValue = EntryPoints.commonValue(headers, i2);
                    int i3 = i;
                    while (i3 < strCommonValue.length()) {
                        headers = headers;
                        int iDelimiterOffset$default = _UtilCommonKt.delimiterOffset$default(strCommonValue, ',', i3, i, 4);
                        int iDelimiterOffset = _UtilCommonKt.delimiterOffset(strCommonValue, i3, iDelimiterOffset$default, ';');
                        int iIndexOfFirstNonAsciiWhitespace = _UtilCommonKt.indexOfFirstNonAsciiWhitespace(i3, iDelimiterOffset, strCommonValue);
                        String strSubstring = strCommonValue.substring(iIndexOfFirstNonAsciiWhitespace, _UtilCommonKt.indexOfLastNonAsciiWhitespace(iIndexOfFirstNonAsciiWhitespace, iDelimiterOffset, strCommonValue));
                        int i4 = iDelimiterOffset + 1;
                        if (strSubstring.equalsIgnoreCase("permessage-deflate")) {
                            if (z) {
                                z4 = true;
                            }
                            i3 = i4;
                            while (i3 < iDelimiterOffset$default) {
                                int iDelimiterOffset2 = _UtilCommonKt.delimiterOffset(strCommonValue, i3, iDelimiterOffset$default, ';');
                                int iDelimiterOffset3 = _UtilCommonKt.delimiterOffset(strCommonValue, i3, iDelimiterOffset2, '=');
                                int iIndexOfFirstNonAsciiWhitespace2 = _UtilCommonKt.indexOfFirstNonAsciiWhitespace(i3, iDelimiterOffset3, strCommonValue);
                                String strSubstring2 = strCommonValue.substring(iIndexOfFirstNonAsciiWhitespace2, _UtilCommonKt.indexOfLastNonAsciiWhitespace(iIndexOfFirstNonAsciiWhitespace2, iDelimiterOffset3, strCommonValue));
                                if (iDelimiterOffset3 < iDelimiterOffset2) {
                                    int iIndexOfFirstNonAsciiWhitespace3 = _UtilCommonKt.indexOfFirstNonAsciiWhitespace(iDelimiterOffset3 + 1, iDelimiterOffset2, strCommonValue);
                                    strRemoveSurrounding = StringsKt.removeSurrounding(strCommonValue.substring(iIndexOfFirstNonAsciiWhitespace3, _UtilCommonKt.indexOfLastNonAsciiWhitespace(iIndexOfFirstNonAsciiWhitespace3, iDelimiterOffset2, strCommonValue)), "\"", "\"");
                                } else {
                                    strRemoveSurrounding = null;
                                }
                                i3 = iDelimiterOffset2 + 1;
                                iDelimiterOffset$default = iDelimiterOffset$default;
                                if (strSubstring2.equalsIgnoreCase("client_max_window_bits")) {
                                    if (intOrNull != null) {
                                        z4 = true;
                                    }
                                    intOrNull = strRemoveSurrounding != null ? StringsKt__StringsJVMKt.toIntOrNull(10, strRemoveSurrounding) : null;
                                    if (intOrNull == null) {
                                        z4 = true;
                                    }
                                } else if (strSubstring2.equalsIgnoreCase("client_no_context_takeover")) {
                                    if (z2) {
                                        z4 = true;
                                    }
                                    if (strRemoveSurrounding != null) {
                                        z4 = true;
                                    }
                                    z2 = true;
                                } else {
                                    if (strSubstring2.equalsIgnoreCase("server_max_window_bits")) {
                                        if (intOrNull2 != null) {
                                            z4 = true;
                                        }
                                        intOrNull2 = strRemoveSurrounding != null ? StringsKt__StringsJVMKt.toIntOrNull(10, strRemoveSurrounding) : null;
                                        if (intOrNull2 == null) {
                                        }
                                    } else if (strSubstring2.equalsIgnoreCase("server_no_context_takeover")) {
                                        if (z3) {
                                            z4 = true;
                                        }
                                        if (strRemoveSurrounding != null) {
                                            z4 = true;
                                        }
                                        z3 = true;
                                    }
                                    z4 = true;
                                }
                            }
                            i = 0;
                            z = true;
                        } else {
                            i3 = i4;
                            i = 0;
                            z4 = true;
                        }
                    }
                }
                i2++;
                headers = headers;
                i = 0;
            }
            ((RealWebSocket) this.trimmer).extensions = new WebSocketExtensions(z, intOrNull, z2, intOrNull2, z3, z4);
            if (z4 || intOrNull != null || (intOrNull2 != null && (8 > (iIntValue = intOrNull2.intValue()) || iIntValue >= 16))) {
                RealWebSocket realWebSocket = (RealWebSocket) this.trimmer;
                synchronized (realWebSocket) {
                    realWebSocket.messageAndCloseQueue.clear();
                    realWebSocket.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
                }
            }
            String str = _UtilJvmKt.okHttpName + " WebSocket " + ((Request) this.strategy).url.redact();
            RealWebSocket realWebSocket2 = (RealWebSocket) this.trimmer;
            NavDeepLinkRequest navDeepLinkRequest = new NavDeepLinkRequest(socketCheckUpgradeSuccess$okhttp);
            WebSocketExtensions webSocketExtensions = realWebSocket2.extensions;
            webSocketExtensions.getClass();
            synchronized (realWebSocket2) {
                try {
                    realWebSocket2.name = str;
                    realWebSocket2.socket = navDeepLinkRequest;
                    realWebSocket2.writer = new WebSocketWriter((RealBufferedSink) navDeepLinkRequest.mimeType, realWebSocket2.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.clientNoContextTakeover, realWebSocket2.minimumDeflateSize);
                    realWebSocket2.writerTask = new RealWebSocket.WriterTask(realWebSocket2);
                    long j = realWebSocket2.pingIntervalMillis;
                    if (j != 0) {
                        long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                        realWebSocket2.taskQueue.schedule(new TaskQueue$execute$1(str.concat(" ping"), new RealWebSocket$$ExternalSyntheticLambda1(realWebSocket2, nanos, (byte) 0)), nanos);
                    }
                    if (!realWebSocket2.messageAndCloseQueue.isEmpty()) {
                        realWebSocket2.runWriter();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            realWebSocket2.reader = new WebSocketReader((RealBufferedSource) navDeepLinkRequest.action, realWebSocket2, webSocketExtensions.perMessageDeflate, webSocketExtensions.serverNoContextTakeover);
            RealWebSocket realWebSocket3 = (RealWebSocket) this.trimmer;
            try {
                realWebSocket3.listener.onOpen(realWebSocket3, response);
                while (realWebSocket3.receivedCloseCode == -1) {
                    WebSocketReader webSocketReader = realWebSocket3.reader;
                    webSocketReader.getClass();
                    webSocketReader.processNextFrame();
                }
            } catch (Exception e) {
                RealWebSocket.failWebSocket$default(realWebSocket3, e, null, 6);
            } finally {
                realWebSocket3.finishReader();
            }
        } catch (IOException e2) {
            RealWebSocket.failWebSocket$default((RealWebSocket) this.trimmer, e2, response, 4);
            _UtilCommonKt.closeQuietly(response);
            Socket socket = response.socket;
            if (socket != null && (sink = socket.getSink()) != null) {
                _UtilCommonKt.closeQuietly(sink);
            }
            Socket socket2 = response.socket;
            if (socket2 == null || (source = socket2.getSource()) == null) {
                return;
            }
            _UtilCommonKt.closeQuietly(source);
        }
    }

    @Override // coil3.target.Target
    public void onStart(Image image) {
        Painter painter;
        ImageRequest imageRequest = (ImageRequest) this.trimmer;
        AsyncImagePainter asyncImagePainter = (AsyncImagePainter) this.strategy;
        Painter painterM852asPainter55t9rM = image != null ? AsyncImageKt.m852asPainter55t9rM(image, imageRequest.context) : null;
        if (painterM852asPainter55t9rM == null && ((Boolean) UriKt.getExtra(imageRequest, AsyncImageKt.useExistingImageAsPlaceholderKey)).booleanValue() && (painter = asyncImagePainter.getPainter()) != null) {
            painterM852asPainter55t9rM = painter;
        }
        asyncImagePainter.updateState(new AsyncImagePainter.State.Loading(painterM852asPainter55t9rM));
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0061  */
    /* JADX WARN: Code duplicated, block: B:14:0x006d  */
    /* JADX WARN: Code duplicated, block: B:17:0x007c  */
    /* JADX WARN: Code duplicated, block: B:19:0x0081  */
    /* JADX WARN: Code duplicated, block: B:22:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:24:0x008a  */
    /* JADX WARN: Code duplicated, block: B:26:0x008e  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d3  */
    public Options options(ImageRequest imageRequest, Size size) {
        Context context;
        boolean z;
        boolean z2;
        Size size2;
        boolean z3;
        boolean z4;
        LinkedHashMap linkedHashMap;
        Context context2 = imageRequest.context;
        Scale scale = imageRequest.scale;
        Precision precision = imageRequest.precision;
        String str = imageRequest.diskCacheKey;
        FileSystem fileSystem = imageRequest.fileSystem;
        CachePolicy cachePolicy = imageRequest.memoryCachePolicy;
        CachePolicy cachePolicy2 = imageRequest.diskCachePolicy;
        CachePolicy cachePolicy3 = imageRequest.networkCachePolicy;
        Extras.Key key = ImageRequests_androidKt.bitmapConfigKey;
        Bitmap.Config config = (Bitmap.Config) UriKt.getExtra(imageRequest, key);
        Extras.Key key2 = ImageRequests_androidKt.allowRgb565Key;
        boolean zBooleanValue = ((Boolean) UriKt.getExtra(imageRequest, key2)).booleanValue();
        Extras.Key key3 = ImageRequestsKt.transformationsKey;
        if (!((List) UriKt.getExtra(imageRequest, key3)).isEmpty()) {
            context = context2;
            if (!ArraysKt.contains(Utils_androidKt.VALID_TRANSFORMATION_CONFIGS, (Bitmap.Config) UriKt.getExtra(imageRequest, key))) {
                z = false;
            }
            z2 = z;
            if (((Bitmap.Config) UriKt.getExtra(imageRequest, key)) == Bitmap.Config.HARDWARE) {
                if (isConfigValidForHardware(imageRequest, (Bitmap.Config) UriKt.getExtra(imageRequest, key))) {
                    size2 = size;
                    if (((HardwareBitmapService) this.strategy).allowHardwareMainThread(size2)) {
                    }
                    if (z2 || !z3) {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    if (zBooleanValue || !((List) UriKt.getExtra(imageRequest, key3)).isEmpty() || config == Bitmap.Config.ALPHA_8) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.plus(imageRequest.defaults.extras.data, imageRequest.extras.data));
                    if (config != ((Bitmap.Config) UriKt.getExtra(imageRequest, key))) {
                        if (config != null) {
                            linkedHashMap.put(key, config);
                        } else {
                            linkedHashMap.remove(key);
                        }
                    }
                    if (z4 != ((Boolean) UriKt.getExtra(imageRequest, key2)).booleanValue()) {
                        linkedHashMap.put(key2, Boolean.valueOf(z4));
                    }
                    return new Options(context, size2, scale, precision, str, fileSystem, cachePolicy, cachePolicy2, cachePolicy3, new Extras(IntMath.toImmutableMap(linkedHashMap)));
                }
                size2 = size;
                z3 = false;
                if (z2) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                if (zBooleanValue) {
                    z4 = false;
                } else {
                    z4 = false;
                }
                linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.plus(imageRequest.defaults.extras.data, imageRequest.extras.data));
                if (config != ((Bitmap.Config) UriKt.getExtra(imageRequest, key))) {
                    if (config != null) {
                        linkedHashMap.put(key, config);
                    } else {
                        linkedHashMap.remove(key);
                    }
                }
                if (z4 != ((Boolean) UriKt.getExtra(imageRequest, key2)).booleanValue()) {
                    linkedHashMap.put(key2, Boolean.valueOf(z4));
                }
                return new Options(context, size2, scale, precision, str, fileSystem, cachePolicy, cachePolicy2, cachePolicy3, new Extras(IntMath.toImmutableMap(linkedHashMap)));
            }
            size2 = size;
            z3 = true;
            if (z2) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.ARGB_8888;
            }
            if (zBooleanValue) {
                z4 = false;
            } else {
                z4 = false;
            }
            linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.plus(imageRequest.defaults.extras.data, imageRequest.extras.data));
            if (config != ((Bitmap.Config) UriKt.getExtra(imageRequest, key))) {
                if (config != null) {
                    linkedHashMap.put(key, config);
                } else {
                    linkedHashMap.remove(key);
                }
            }
            if (z4 != ((Boolean) UriKt.getExtra(imageRequest, key2)).booleanValue()) {
                linkedHashMap.put(key2, Boolean.valueOf(z4));
            }
            return new Options(context, size2, scale, precision, str, fileSystem, cachePolicy, cachePolicy2, cachePolicy3, new Extras(IntMath.toImmutableMap(linkedHashMap)));
        }
        context = context2;
        z = true;
        z2 = z;
        if (((Bitmap.Config) UriKt.getExtra(imageRequest, key)) == Bitmap.Config.HARDWARE) {
            if (isConfigValidForHardware(imageRequest, (Bitmap.Config) UriKt.getExtra(imageRequest, key))) {
                size2 = size;
                if (((HardwareBitmapService) this.strategy).allowHardwareMainThread(size2)) {
                }
                if (z2) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                if (zBooleanValue) {
                    z4 = false;
                } else {
                    z4 = false;
                }
                linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.plus(imageRequest.defaults.extras.data, imageRequest.extras.data));
                if (config != ((Bitmap.Config) UriKt.getExtra(imageRequest, key))) {
                    if (config != null) {
                        linkedHashMap.put(key, config);
                    } else {
                        linkedHashMap.remove(key);
                    }
                }
                if (z4 != ((Boolean) UriKt.getExtra(imageRequest, key2)).booleanValue()) {
                    linkedHashMap.put(key2, Boolean.valueOf(z4));
                }
                return new Options(context, size2, scale, precision, str, fileSystem, cachePolicy, cachePolicy2, cachePolicy3, new Extras(IntMath.toImmutableMap(linkedHashMap)));
            }
            size2 = size;
            z3 = false;
            if (z2) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.ARGB_8888;
            }
            if (zBooleanValue) {
                z4 = false;
            } else {
                z4 = false;
            }
            linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.plus(imageRequest.defaults.extras.data, imageRequest.extras.data));
            if (config != ((Bitmap.Config) UriKt.getExtra(imageRequest, key))) {
                if (config != null) {
                    linkedHashMap.put(key, config);
                } else {
                    linkedHashMap.remove(key);
                }
            }
            if (z4 != ((Boolean) UriKt.getExtra(imageRequest, key2)).booleanValue()) {
                linkedHashMap.put(key2, Boolean.valueOf(z4));
            }
            return new Options(context, size2, scale, precision, str, fileSystem, cachePolicy, cachePolicy2, cachePolicy3, new Extras(IntMath.toImmutableMap(linkedHashMap)));
        }
        size2 = size;
        z3 = true;
        if (z2) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        if (zBooleanValue) {
            z4 = false;
        } else {
            z4 = false;
        }
        linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.plus(imageRequest.defaults.extras.data, imageRequest.extras.data));
        if (config != ((Bitmap.Config) UriKt.getExtra(imageRequest, key))) {
            if (config != null) {
                linkedHashMap.put(key, config);
            } else {
                linkedHashMap.remove(key);
            }
        }
        if (z4 != ((Boolean) UriKt.getExtra(imageRequest, key2)).booleanValue()) {
            linkedHashMap.put(key2, Boolean.valueOf(z4));
        }
        return new Options(context, size2, scale, precision, str, fileSystem, cachePolicy, cachePolicy2, cachePolicy3, new Extras(IntMath.toImmutableMap(linkedHashMap)));
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonReader
    public int read(char[] cArr, int i, int i2) {
        int i3;
        kotlinx.io.Source source = (kotlinx.io.Source) this.strategy;
        Character ch = (Character) this.trimmer;
        if (ch != null) {
            cArr[i] = ch.charValue();
            this.trimmer = null;
            i3 = 1;
        } else {
            i3 = 0;
        }
        while (i3 < i2 && !source.exhausted()) {
            int codePointValue = Utf8Kt.readCodePointValue(source);
            if (codePointValue <= 65535) {
                cArr[i + i3] = (char) codePointValue;
                i3++;
            } else {
                char c = (char) ((codePointValue >>> 10) + 55232);
                char c2 = (char) ((codePointValue & 1023) + 56320);
                cArr[i + i3] = c;
                int i4 = i3 + 1;
                if (i4 < i2) {
                    cArr[i4 + i] = c2;
                    i3 += 2;
                } else {
                    this.trimmer = Character.valueOf(c2);
                    i3 = i4;
                }
            }
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    public List splitToList(CharSequence charSequence) {
        charSequence.getClass();
        Iterator it = new Iterator(this, charSequence, (CharMatcher.Is) ((Splitter$$ExternalSyntheticLambda0) this.strategy).f$0) { // from class: com.google.common.base.Splitter.1
            public String next;
            public final CharSequence toSplit;
            public final CharMatcher trimmer;
            public final /* synthetic */ CharMatcher.Is val$separatorMatcher;
            public int state = 2;
            public int offset = 0;
            public int limit = Integer.MAX_VALUE;

            {
                this.val$separatorMatcher = is;
                this.trimmer = (CharMatcher) this.trimmer;
                this.toSplit = charSequence;
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                String string;
                int i;
                CharMatcher charMatcher;
                coil3.util.UtilsKt.checkState(this.state != 4);
                int iOrdinal = PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility.ordinal(this.state);
                if (iOrdinal == 0) {
                    return true;
                }
                if (iOrdinal != 2) {
                    this.state = 4;
                    int i2 = this.offset;
                    while (true) {
                        int length = this.offset;
                        if (length == -1) {
                            this.state = 3;
                            string = null;
                            break;
                        }
                        CharSequence charSequence2 = this.toSplit;
                        int length2 = charSequence2.length();
                        coil3.util.UtilsKt.checkPositionIndex(length, length2);
                        while (true) {
                            if (length >= length2) {
                                length = -1;
                                break;
                            }
                            if (this.val$separatorMatcher.matches(charSequence2.charAt(length))) {
                                break;
                            }
                            length++;
                        }
                        if (length == -1) {
                            length = charSequence2.length();
                            this.offset = -1;
                            i = -1;
                        } else {
                            i = length + 1;
                            this.offset = i;
                        }
                        if (i != i2) {
                            while (true) {
                                charMatcher = this.trimmer;
                                if (i2 >= length || !charMatcher.matches(charSequence2.charAt(i2))) {
                                    break;
                                }
                                i2++;
                            }
                            while (length > i2 && charMatcher.matches(charSequence2.charAt(length - 1))) {
                                length--;
                            }
                            int i3 = this.limit;
                            if (i3 == 1) {
                                length = charSequence2.length();
                                this.offset = -1;
                                while (length > i2 && charMatcher.matches(charSequence2.charAt(length - 1))) {
                                    length--;
                                }
                            } else {
                                this.limit = i3 - 1;
                            }
                            string = charSequence2.subSequence(i2, length).toString();
                            break;
                        }
                        int i4 = i + 1;
                        this.offset = i4;
                        if (i4 > charSequence2.length()) {
                            this.offset = -1;
                        }
                    }
                    this.next = string;
                    if (this.state != 3) {
                        this.state = 1;
                        return true;
                    }
                }
                return false;
            }

            @Override // java.util.Iterator
            public final Object next() {
                if (!hasNext()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                    return null;
                }
                this.state = 2;
                String str = this.next;
                this.next = null;
                return str;
            }

            @Override // java.util.Iterator
            public final void remove() {
                throw new UnsupportedOperationException();
            }
        };
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // kotlin.time.InstantParseResult
    public Instant toInstant() {
        throw new InstantFormatException(((String) this.trimmer) + " when parsing an Instant from \"" + InstantKt.truncateForErrorMessage(64, (String) this.strategy) + '\"');
    }

    public Options updateOptions(Options options) {
        boolean z;
        Extras extras = options.extras;
        Extras.Key key = ImageRequests_androidKt.bitmapConfigKey;
        if (((Bitmap.Config) UriKt.getExtra(options, key)) != Bitmap.Config.HARDWARE || ((HardwareBitmapService) this.strategy).allowHardwareWorkerThread()) {
            z = false;
        } else {
            extras.getClass();
            LinkedHashMap mutableMap = MapsKt__MapsKt.toMutableMap(extras.data);
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            if (config != null) {
                mutableMap.put(key, config);
            } else {
                mutableMap.remove(key);
            }
            extras = new Extras(IntMath.toImmutableMap(mutableMap));
            z = true;
        }
        return z ? new Options(options.context, options.size, options.scale, options.precision, options.diskCacheKey, options.fileSystem, options.memoryCachePolicy, options.diskCachePolicy, options.networkCachePolicy, extras) : options;
    }

    public void upsert(SQLiteConnection sQLiteConnection, Object obj) {
        try {
            ((SizeKt) this.trimmer).insert(sQLiteConnection, obj);
        } catch (SQLException e) {
            String message = e.getMessage();
            if (message == null) {
                throw e;
            }
            if (!StringsKt.contains(message, "unique", true) && !StringsKt.contains(message, "2067", false) && !StringsKt.contains(message, "1555", false)) {
                throw e;
            }
            ((DatabaseDao_Impl.AnonymousClass17) this.strategy).handle(sQLiteConnection, obj);
        }
    }

    @Override // coil3.target.Target
    public void onError(Image image) {
    }

    @Override // coil3.target.Target
    public void onSuccess(Image image) {
    }

    public Splitter(Context context, Preferences$Key preferences$Key) {
        this.$r8$classId = (byte) 9;
        this.trimmer = context;
        this.strategy = preferences$Key;
    }

    public /* synthetic */ Splitter(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.trimmer = obj;
        this.strategy = obj2;
    }

    public Splitter(MusicService musicService, ContextScope contextScope) {
        this.$r8$classId = (byte) 10;
        contextScope.getClass();
        this.trimmer = musicService;
        this.strategy = contextScope;
    }

    public /* synthetic */ Splitter() {
        this.$r8$classId = (byte) 5;
    }

    public Splitter(kotlinx.io.Source source) {
        this.$r8$classId = (byte) 13;
        this.strategy = source;
    }

    public Splitter(Splitter$$ExternalSyntheticLambda0 splitter$$ExternalSyntheticLambda0) {
        this.$r8$classId = (byte) 0;
        CharMatcher.Any any = CharMatcher.Any.INSTANCE$3;
        this.strategy = splitter$$ExternalSyntheticLambda0;
        this.trimmer = any;
    }

    public Splitter(Function1 function1) {
        this.$r8$classId = (byte) 12;
        this.trimmer = function1;
        this.strategy = new ConcurrentHashMap();
    }

    public Splitter(TsExtractor tsExtractor) {
        this.$r8$classId = (byte) 1;
        this.strategy = tsExtractor;
        this.trimmer = new VorbisBitArray(new byte[4], 4);
    }

    public Splitter(String str, Bundle bundle) {
        this.$r8$classId = (byte) 4;
        if (str != null) {
            this.trimmer = str;
            this.strategy = bundle;
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
            throw null;
        }
    }

    public Splitter(MediaControllerImplBase mediaControllerImplBase, Looper looper) {
        this.$r8$classId = (byte) 2;
        this.strategy = mediaControllerImplBase;
        this.trimmer = new Handler(looper, new ListenerSet$$ExternalSyntheticLambda0((byte) 3, this));
    }

    @Override // androidx.media3.extractor.ts.SectionPayloadReader
    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
    }
}

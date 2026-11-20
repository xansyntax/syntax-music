package androidx.media3.datasource.okhttp;

import android.net.Uri;
import androidx.core.provider.CallbackWrapper;
import androidx.datastore.core.AtomicInt;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.BaseDataSource;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource$HttpDataSourceException;
import androidx.media3.datasource.HttpDataSource$InvalidResponseCodeException;
import androidx.media3.datasource.HttpUtil;
import com.google.common.io.ByteStreams;
import com.google.common.util.concurrent.SettableFuture;
import io.ktor.http.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.RealCall;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OkHttpDataSource extends BaseDataSource {
    public long bytesRead;
    public long bytesToRead;
    public final OkHttpClient callFactory;
    public boolean connectionEstablished;
    public DataSpec dataSpec;
    public final CallbackWrapper defaultRequestProperties;
    public final CallbackWrapper requestProperties;
    public Response response;
    public InputStream responseByteStream;

    static {
        MediaLibraryInfo.registerModule("media3.datasource.okhttp");
    }

    public OkHttpDataSource(OkHttpClient okHttpClient, CallbackWrapper callbackWrapper) {
        super(true);
        this.callFactory = okHttpClient;
        this.defaultRequestProperties = callbackWrapper;
        this.requestProperties = new CallbackWrapper((byte) 17);
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        if (this.connectionEstablished) {
            this.connectionEstablished = false;
            transferEnded();
            closeConnectionQuietly$1();
        }
        this.response = null;
        this.dataSpec = null;
    }

    public final void closeConnectionQuietly$1() {
        Response response = this.response;
        if (response != null) {
            ResponseBody responseBody = response.body;
            responseBody.getClass();
            responseBody.close();
        }
        this.responseByteStream = null;
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map getResponseHeaders() {
        Response response = this.response;
        return response == null ? Collections.EMPTY_MAP : response.headers.toMultimap();
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri getUri() {
        Response response = this.response;
        if (response != null) {
            return Uri.parse(response.request.url.url);
        }
        DataSpec dataSpec = this.dataSpec;
        if (dataSpec != null) {
            return dataSpec.uri;
        }
        return null;
    }

    @Override // androidx.media3.datasource.DataSource
    public final long open(DataSpec dataSpec) throws HttpDataSource$HttpDataSourceException, EOFException {
        HttpUrl httpUrlBuild;
        this.dataSpec = dataSpec;
        this.bytesRead = 0L;
        this.bytesToRead = 0L;
        transferInitializing();
        long j = dataSpec.position;
        byte b = dataSpec.httpMethod;
        long j2 = dataSpec.length;
        String string = dataSpec.uri.toString();
        string.getClass();
        try {
            HttpUrl.Builder builder = new HttpUrl.Builder();
            builder.parse$okhttp(null, string);
            httpUrlBuild = builder.build();
        } catch (IllegalArgumentException unused) {
            httpUrlBuild = null;
        }
        if (httpUrlBuild == null) {
            throw new HttpDataSource$HttpDataSourceException("Malformed URL", 1004);
        }
        Request.Builder builder2 = new Request.Builder();
        builder2.url = httpUrlBuild;
        HashMap map = new HashMap();
        map.putAll(this.defaultRequestProperties.getSnapshot());
        map.putAll(this.requestProperties.getSnapshot());
        map.putAll(dataSpec.httpRequestHeaders);
        for (Map.Entry entry : map.entrySet()) {
            builder2.header((String) entry.getKey(), (String) entry.getValue());
        }
        String strBuildRangeRequestHeader = HttpUtil.buildRangeRequestHeader(j, j2);
        if (strBuildRangeRequestHeader != null) {
            builder2.addHeader(HttpHeaders.Range, strBuildRangeRequestHeader);
        }
        if ((dataSpec.flags & 1) != 1) {
            builder2.addHeader(HttpHeaders.AcceptEncoding, "identity");
        }
        byte[] bArr = dataSpec.httpBody;
        builder2.method(DataSpec.getStringForHttpMethod(b), bArr != null ? RequestBody.create(bArr) : b == 2 ? RequestBody.create(Util.EMPTY_BYTE_ARRAY) : null);
        RealCall realCall = new RealCall(this.callFactory, new Request(builder2), false);
        try {
            SettableFuture settableFuture = new SettableFuture();
            realCall.enqueue(new AtomicInt(settableFuture));
            try {
                Response response = (Response) settableFuture.get();
                this.response = response;
                ResponseBody responseBody = response.body;
                responseBody.getClass();
                this.responseByteStream = responseBody.source().inputStream();
                int i = response.code;
                if (response.isSuccessful) {
                    responseBody.contentType();
                    long j3 = (i != 200 || j == 0) ? 0L : j;
                    if (j2 != -1) {
                        this.bytesToRead = j2;
                    } else {
                        long jContentLength = responseBody.contentLength();
                        this.bytesToRead = jContentLength != -1 ? jContentLength - j3 : -1L;
                    }
                    this.connectionEstablished = true;
                    transferStarted(dataSpec);
                    try {
                        skipFully$1(j3);
                        return this.bytesToRead;
                    } catch (HttpDataSource$HttpDataSourceException e) {
                        closeConnectionQuietly$1();
                        throw e;
                    }
                }
                if (i == 416 && j == HttpUtil.getDocumentSize(response.headers.get(HttpHeaders.ContentRange))) {
                    this.connectionEstablished = true;
                    transferStarted(dataSpec);
                    if (j2 != -1) {
                        return j2;
                    }
                    return 0L;
                }
                try {
                    InputStream inputStream = this.responseByteStream;
                    inputStream.getClass();
                    ByteStreams.toByteArray(inputStream);
                } catch (IOException unused2) {
                    String str = Util.DEVICE_DEBUG_INFO;
                }
                TreeMap multimap = response.headers.toMultimap();
                closeConnectionQuietly$1();
                throw new HttpDataSource$InvalidResponseCodeException(i, i == 416 ? new DataSourceException(2008) : null, multimap);
            } catch (InterruptedException unused3) {
                realCall.cancel();
                throw new InterruptedIOException();
            } catch (ExecutionException e2) {
                throw new IOException(e2);
            }
        } catch (IOException e3) {
            throw HttpDataSource$HttpDataSourceException.createForIOException(e3, 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0028 A[Catch: IOException -> 0x0032, TRY_LEAVE, TryCatch #0 {IOException -> 0x0032, blocks: (B:5:0x0004, B:7:0x000d, B:10:0x0017, B:11:0x001d, B:14:0x0028), top: B:19:0x0004 }] */
    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i, int i2) throws HttpDataSource$HttpDataSourceException {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.bytesToRead;
            if (j != -1) {
                long j2 = j - this.bytesRead;
                if (j2 != 0) {
                    i2 = (int) Math.min(i2, j2);
                    InputStream inputStream = this.responseByteStream;
                    String str = Util.DEVICE_DEBUG_INFO;
                    i3 = inputStream.read(bArr, i, i2);
                    if (i3 != -1) {
                        this.bytesRead += (long) i3;
                        bytesTransferred(i3);
                        return i3;
                    }
                }
            } else {
                InputStream inputStream2 = this.responseByteStream;
                String str2 = Util.DEVICE_DEBUG_INFO;
                i3 = inputStream2.read(bArr, i, i2);
                if (i3 != -1) {
                    this.bytesRead += (long) i3;
                    bytesTransferred(i3);
                    return i3;
                }
            }
            return -1;
        } catch (IOException e) {
            String str3 = Util.DEVICE_DEBUG_INFO;
            throw HttpDataSource$HttpDataSourceException.createForIOException(e, 2);
        }
    }

    public final void skipFully$1(long j) throws HttpDataSource$HttpDataSourceException {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            try {
                int iMin = (int) Math.min(j, 4096L);
                InputStream inputStream = this.responseByteStream;
                String str = Util.DEVICE_DEBUG_INFO;
                int i = inputStream.read(bArr, 0, iMin);
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (i == -1) {
                    throw new HttpDataSource$HttpDataSourceException(2008);
                }
                j -= (long) i;
                bytesTransferred(i);
            } catch (IOException e) {
                if (!(e instanceof HttpDataSource$HttpDataSourceException)) {
                    throw new HttpDataSource$HttpDataSourceException(2000);
                }
                throw ((HttpDataSource$HttpDataSourceException) e);
            }
        }
    }
}

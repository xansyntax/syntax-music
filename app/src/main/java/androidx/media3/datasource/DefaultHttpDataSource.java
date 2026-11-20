package androidx.media3.datasource;

import android.net.TrafficStats;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableMap;
import com.google.common.io.ByteStreams;
import io.ktor.http.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultHttpDataSource extends BaseDataSource {
    public long bytesRead;
    public long bytesToRead;
    public HttpURLConnection connection;
    public DataSpec dataSpec;
    public final CallbackWrapper defaultRequestProperties;
    public InputStream inputStream;
    public final CallbackWrapper requestProperties;
    public int responseCode;
    public boolean transferStarted;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class NullFilteringHeadersMap extends Maps implements Map {
        public final Map headers;

        public NullFilteringHeadersMap(Map map) {
            this.headers = map;
        }

        @Override // java.util.Map
        public final void clear() {
            this.headers.clear();
        }

        @Override // java.util.Map
        public final boolean containsKey(Object obj) {
            return obj != null && this.headers.containsKey(obj);
        }

        @Override // java.util.Map
        public final boolean containsValue(Object obj) {
            Maps.AnonymousClass2 anonymousClass2 = new Maps.AnonymousClass2(entrySet().iterator());
            if (obj == null) {
                while (anonymousClass2.hasNext()) {
                    if (anonymousClass2.next() == null) {
                        return true;
                    }
                }
                return false;
            }
            while (anonymousClass2.hasNext()) {
                if (obj.equals(anonymousClass2.next())) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.Maps
        public final Object delegate() {
            return this.headers;
        }

        @Override // java.util.Map
        public final Set entrySet() {
            return Maps.filter(this.headers.entrySet(), new DefaultHttpDataSource$NullFilteringHeadersMap$$ExternalSyntheticLambda0((byte) 0));
        }

        @Override // java.util.Map
        public final boolean equals(Object obj) {
            return obj != null && Maps.equalsImpl(this, obj);
        }

        @Override // java.util.Map
        public final Object get(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) this.headers.get(obj);
        }

        @Override // java.util.Map
        public final int hashCode() {
            return Maps.hashCodeImpl(entrySet());
        }

        @Override // java.util.Map
        public final boolean isEmpty() {
            Map map = this.headers;
            return map.isEmpty() || (map.size() == 1 && map.containsKey(null));
        }

        @Override // java.util.Map
        public final Set keySet() {
            return Maps.filter(this.headers.keySet(), new DefaultHttpDataSource$NullFilteringHeadersMap$$ExternalSyntheticLambda0((byte) 1));
        }

        @Override // java.util.Map
        public final Object put(Object obj, Object obj2) {
            return this.headers.put(obj, obj2);
        }

        @Override // java.util.Map
        public final void putAll(Map map) {
            this.headers.putAll(map);
        }

        @Override // java.util.Map
        public final Object remove(Object obj) {
            return this.headers.remove(obj);
        }

        @Override // java.util.Map
        public final int size() {
            Map map = this.headers;
            return map.size() - (map.containsKey(null) ? 1 : 0);
        }

        @Override // java.util.Map
        public final Collection values() {
            return this.headers.values();
        }
    }

    public DefaultHttpDataSource(CallbackWrapper callbackWrapper) {
        super(true);
        this.defaultRequestProperties = callbackWrapper;
        this.requestProperties = new CallbackWrapper((byte) 17);
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        try {
            InputStream inputStream = this.inputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    String str = Util.DEVICE_DEBUG_INFO;
                    throw new HttpDataSource$HttpDataSourceException(e, 2000, 3);
                }
            }
            this.inputStream = null;
            closeConnectionQuietly();
            if (this.transferStarted) {
                this.transferStarted = false;
                transferEnded();
            }
            this.connection = null;
            this.dataSpec = null;
            TrafficStats.clearThreadStatsTag();
        } catch (Throwable th) {
            this.inputStream = null;
            closeConnectionQuietly();
            if (this.transferStarted) {
                this.transferStarted = false;
                transferEnded();
            }
            this.connection = null;
            this.dataSpec = null;
            TrafficStats.clearThreadStatsTag();
            throw th;
        }
    }

    public final void closeConnectionQuietly() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.connection;
        return httpURLConnection == null ? RegularImmutableMap.EMPTY : new NullFilteringHeadersMap(httpURLConnection.getHeaderFields());
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        DataSpec dataSpec = this.dataSpec;
        if (dataSpec != null) {
            return dataSpec.uri;
        }
        return null;
    }

    public final HttpURLConnection makeConnection(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map map) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(8000);
        httpURLConnection.setReadTimeout(8000);
        HashMap map2 = new HashMap();
        map2.putAll(this.defaultRequestProperties.getSnapshot());
        map2.putAll(this.requestProperties.getSnapshot());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strBuildRangeRequestHeader = HttpUtil.buildRangeRequestHeader(j, j2);
        if (strBuildRangeRequestHeader != null) {
            httpURLConnection.setRequestProperty(HttpHeaders.Range, strBuildRangeRequestHeader);
        }
        httpURLConnection.setRequestProperty(HttpHeaders.AcceptEncoding, z ? "gzip" : "identity");
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        httpURLConnection.setRequestMethod(DataSpec.getStringForHttpMethod(i));
        if (bArr == null) {
            httpURLConnection.connect();
            return httpURLConnection;
        }
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        httpURLConnection.connect();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.close();
        return httpURLConnection;
    }

    @Override // androidx.media3.datasource.DataSource
    public final long open(DataSpec dataSpec) throws HttpDataSource$HttpDataSourceException {
        long jMax;
        String str;
        this.dataSpec = dataSpec;
        this.bytesRead = 0L;
        this.bytesToRead = 0L;
        transferInitializing();
        try {
            Thread threadCurrentThread = Thread.currentThread();
            TrafficStats.setThreadStatsTag((int) (Build.VERSION.SDK_INT < 36 ? threadCurrentThread.getId() : threadCurrentThread.threadId()));
            HttpURLConnection httpURLConnectionMakeConnection = makeConnection(new URL(dataSpec.uri.toString()), dataSpec.httpMethod, dataSpec.httpBody, dataSpec.position, dataSpec.length, (dataSpec.flags & 1) == 1, true, dataSpec.httpRequestHeaders);
            long j = dataSpec.length;
            long j2 = dataSpec.position;
            this.connection = httpURLConnectionMakeConnection;
            this.responseCode = httpURLConnectionMakeConnection.getResponseCode();
            httpURLConnectionMakeConnection.getResponseMessage();
            int i = this.responseCode;
            if (i < 200 || i > 299) {
                Map<String, List<String>> headerFields = httpURLConnectionMakeConnection.getHeaderFields();
                if (this.responseCode == 416 && j2 == HttpUtil.getDocumentSize(httpURLConnectionMakeConnection.getHeaderField(HttpHeaders.ContentRange))) {
                    this.transferStarted = true;
                    transferStarted(dataSpec);
                    if (j != -1) {
                        return j;
                    }
                    return 0L;
                }
                InputStream errorStream = httpURLConnectionMakeConnection.getErrorStream();
                try {
                    if (errorStream != null) {
                        ByteStreams.toByteArray(errorStream);
                    } else {
                        String str2 = Util.DEVICE_DEBUG_INFO;
                    }
                } catch (IOException unused) {
                    String str3 = Util.DEVICE_DEBUG_INFO;
                }
                closeConnectionQuietly();
                throw new HttpDataSource$InvalidResponseCodeException(this.responseCode, this.responseCode == 416 ? new DataSourceException(2008) : null, headerFields);
            }
            httpURLConnectionMakeConnection.getContentType();
            if (this.responseCode != 200 || j2 == 0) {
                j2 = 0;
            }
            boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(httpURLConnectionMakeConnection.getHeaderField(HttpHeaders.ContentEncoding));
            if (zEqualsIgnoreCase || j != -1) {
                this.bytesToRead = j;
            } else {
                String headerField = httpURLConnectionMakeConnection.getHeaderField(HttpHeaders.ContentLength);
                String headerField2 = httpURLConnectionMakeConnection.getHeaderField(HttpHeaders.ContentRange);
                Pattern pattern = HttpUtil.CONTENT_RANGE_WITH_START_AND_END;
                if (TextUtils.isEmpty(headerField)) {
                    jMax = -1;
                } else {
                    try {
                        jMax = Long.parseLong(headerField);
                    } catch (NumberFormatException unused2) {
                        Log.e("HttpUtil", "Unexpected Content-Length [" + headerField + "]");
                        jMax = -1;
                    }
                }
                if (!TextUtils.isEmpty(headerField2)) {
                    Matcher matcher = HttpUtil.CONTENT_RANGE_WITH_START_AND_END.matcher(headerField2);
                    if (matcher.matches()) {
                        try {
                            String strGroup = matcher.group(2);
                            strGroup.getClass();
                            long j3 = Long.parseLong(strGroup);
                            String strGroup2 = matcher.group(1);
                            strGroup2.getClass();
                            str = "]";
                            long j4 = (j3 - Long.parseLong(strGroup2)) + 1;
                            if (jMax < 0) {
                                jMax = j4;
                            } else if (jMax != j4) {
                                try {
                                    Log.w("HttpUtil", "Inconsistent headers [" + headerField + "] [" + headerField2 + str);
                                    jMax = Math.max(jMax, j4);
                                } catch (NumberFormatException unused3) {
                                    Log.e("HttpUtil", "Unexpected Content-Range [" + headerField2 + str);
                                }
                            }
                        } catch (NumberFormatException unused4) {
                            str = "]";
                        }
                    }
                }
                this.bytesToRead = jMax != -1 ? jMax - j2 : -1L;
            }
            try {
                this.inputStream = httpURLConnectionMakeConnection.getInputStream();
                if (zEqualsIgnoreCase) {
                    this.inputStream = new GZIPInputStream(this.inputStream);
                }
                this.transferStarted = true;
                transferStarted(dataSpec);
                try {
                    skipFully(j2);
                    return this.bytesToRead;
                } catch (IOException e) {
                    closeConnectionQuietly();
                    if (e instanceof HttpDataSource$HttpDataSourceException) {
                        throw ((HttpDataSource$HttpDataSourceException) e);
                    }
                    throw new HttpDataSource$HttpDataSourceException(e, 2000, 1);
                }
            } catch (IOException e2) {
                closeConnectionQuietly();
                throw new HttpDataSource$HttpDataSourceException(e2, 2000, 1);
            }
        } catch (IOException e3) {
            closeConnectionQuietly();
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
                    InputStream inputStream = this.inputStream;
                    String str = Util.DEVICE_DEBUG_INFO;
                    i3 = inputStream.read(bArr, i, i2);
                    if (i3 != -1) {
                        this.bytesRead += (long) i3;
                        bytesTransferred(i3);
                        return i3;
                    }
                }
            } else {
                InputStream inputStream2 = this.inputStream;
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

    public final void skipFully(long j) throws IOException {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            int iMin = (int) Math.min(j, 4096L);
            InputStream inputStream = this.inputStream;
            String str = Util.DEVICE_DEBUG_INFO;
            int i = inputStream.read(bArr, 0, iMin);
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSource$HttpDataSourceException(new InterruptedIOException(), 2000, 1);
            }
            if (i == -1) {
                throw new HttpDataSource$HttpDataSourceException(2008);
            }
            j -= (long) i;
            bytesTransferred(i);
        }
    }
}

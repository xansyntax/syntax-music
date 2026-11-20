package androidx.media3.datasource;

import android.net.Uri;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaLibraryInfo;
import coil3.util.UtilsKt;
import io.ktor.sse.ServerSentEventKt;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataSpec {
    public final byte flags;
    public final byte[] httpBody;
    public final byte httpMethod;
    public final Map httpRequestHeaders;
    public final String key;
    public final long length;
    public final long position;
    public final Uri uri;
    public final long uriPositionOffset;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public byte flags;
        public byte[] httpBody;
        public byte httpMethod;
        public Map httpRequestHeaders;
        public String key;
        public long length;
        public long position;
        public Uri uri;
        public long uriPositionOffset;

        public final DataSpec build() {
            UtilsKt.checkNotNull(this.uri, "The uri must be set.");
            return new DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, this.httpRequestHeaders, this.position, this.length, this.key, this.flags);
        }
    }

    static {
        MediaLibraryInfo.registerModule("media3.datasource");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DataSpec(Uri uri, long j, int i, byte[] bArr, Map map, long j2, long j3, String str, int i2) {
        UtilsKt.checkArgument(j + j2 >= 0);
        UtilsKt.checkArgument(j2 >= 0);
        UtilsKt.checkArgument(j3 > 0 || j3 == -1);
        uri.getClass();
        this.uri = uri;
        this.uriPositionOffset = j;
        this.httpMethod = i;
        this.httpBody = (bArr == null || bArr.length == 0) ? null : bArr;
        this.httpRequestHeaders = Collections.unmodifiableMap(new HashMap(map));
        this.position = j2;
        this.length = j3;
        this.key = str;
        this.flags = i2;
    }

    public static String getStringForHttpMethod(int i) {
        if (i == 1) {
            return "GET";
        }
        if (i == 2) {
            return "POST";
        }
        if (i == 3) {
            return "HEAD";
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m();
        return null;
    }

    public final Builder buildUpon() {
        Builder builder = new Builder();
        builder.uri = this.uri;
        builder.uriPositionOffset = this.uriPositionOffset;
        builder.httpMethod = this.httpMethod;
        builder.httpBody = this.httpBody;
        builder.httpRequestHeaders = this.httpRequestHeaders;
        builder.position = this.position;
        builder.length = this.length;
        builder.key = this.key;
        builder.flags = this.flags;
        return builder;
    }

    public final DataSpec subrange(long j) {
        if (this.length == j) {
            return this;
        }
        return new DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, this.httpRequestHeaders, this.position, j, this.key, this.flags);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DataSpec[");
        sb.append(getStringForHttpMethod(this.httpMethod));
        sb.append(ServerSentEventKt.SPACE);
        sb.append(this.uri);
        sb.append(", ");
        sb.append(this.position);
        sb.append(", ");
        sb.append(this.length);
        sb.append(", ");
        sb.append(this.key);
        sb.append(", ");
        return Fragment$5$$ExternalSyntheticOutline0.m(sb, this.flags, "]");
    }
}

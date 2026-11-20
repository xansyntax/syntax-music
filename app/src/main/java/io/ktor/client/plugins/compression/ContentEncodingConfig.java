package io.ktor.client.plugins.compression;

import io.ktor.util.CaseInsensitiveMap;
import io.ktor.util.ContentEncoder;
import io.ktor.util.DeflateEncoder;
import io.ktor.util.GZipEncoder;
import io.ktor.util.IdentityEncoder;
import io.ktor.utils.io.KtorDsl;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.enums.EnumEntries;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@KtorDsl
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\bJ!\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eR&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b0\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lio/ktor/client/plugins/compression/ContentEncodingConfig;", "", "<init>", "()V", "", "quality", "", "gzip", "(Ljava/lang/Float;)V", "deflate", "identity", "Lio/ktor/util/ContentEncoder;", "encoder", "customEncoder", "(Lio/ktor/util/ContentEncoder;Ljava/lang/Float;)V", "", "", "encoders", "Ljava/util/Map;", "getEncoders$ktor_client_encoding", "()Ljava/util/Map;", "qualityValues", "getQualityValues$ktor_client_encoding", "Lio/ktor/client/plugins/compression/ContentEncodingConfig$Mode;", "mode", "Lio/ktor/client/plugins/compression/ContentEncodingConfig$Mode;", "getMode", "()Lio/ktor/client/plugins/compression/ContentEncodingConfig$Mode;", "setMode", "(Lio/ktor/client/plugins/compression/ContentEncodingConfig$Mode;)V", "Mode", "ktor-client-encoding"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContentEncodingConfig {
    private final Map<String, ContentEncoder> encoders = new CaseInsensitiveMap();
    private final Map<String, Float> qualityValues = new CaseInsensitiveMap();
    private Mode mode = Mode.DecompressResponse;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lio/ktor/client/plugins/compression/ContentEncodingConfig$Mode;", "", "", "request", "response", "<init>", "(Ljava/lang/String;IZZ)V", "Z", "getRequest$ktor_client_encoding", "()Z", "getResponse$ktor_client_encoding", "CompressRequest", "DecompressResponse", "All", "ktor-client-encoding"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum Mode {
        CompressRequest(true, false),
        DecompressResponse(false, true),
        All(true, true);

        private static final /* synthetic */ EnumEntries $ENTRIES = CollectionsKt__IterablesKt.enumEntries(values());
        private final boolean request;
        private final boolean response;

        Mode(boolean z, boolean z2) {
            this.request = z;
            this.response = z2;
        }

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }

        /* JADX INFO: renamed from: getRequest$ktor_client_encoding, reason: from getter */
        public final boolean getRequest() {
            return this.request;
        }

        /* JADX INFO: renamed from: getResponse$ktor_client_encoding, reason: from getter */
        public final boolean getResponse() {
            return this.response;
        }
    }

    public static /* synthetic */ void customEncoder$default(ContentEncodingConfig contentEncodingConfig, ContentEncoder contentEncoder, Float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = null;
        }
        contentEncodingConfig.customEncoder(contentEncoder, f);
    }

    public static /* synthetic */ void deflate$default(ContentEncodingConfig contentEncodingConfig, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = null;
        }
        contentEncodingConfig.deflate(f);
    }

    public static /* synthetic */ void gzip$default(ContentEncodingConfig contentEncodingConfig, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = null;
        }
        contentEncodingConfig.gzip(f);
    }

    public static /* synthetic */ void identity$default(ContentEncodingConfig contentEncodingConfig, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = null;
        }
        contentEncodingConfig.identity(f);
    }

    public final void customEncoder(ContentEncoder encoder, Float quality) {
        encoder.getClass();
        String name = encoder.getName();
        Map<String, ContentEncoder> map = this.encoders;
        String lowerCase = name.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        map.put(lowerCase, encoder);
        Map<String, Float> map2 = this.qualityValues;
        if (quality == null) {
            map2.remove(name);
        } else {
            map2.put(name, quality);
        }
    }

    public final void deflate(Float quality) {
        customEncoder(DeflateEncoder.INSTANCE, quality);
    }

    public final Map<String, ContentEncoder> getEncoders$ktor_client_encoding() {
        return this.encoders;
    }

    public final Mode getMode() {
        return this.mode;
    }

    public final Map<String, Float> getQualityValues$ktor_client_encoding() {
        return this.qualityValues;
    }

    public final void gzip(Float quality) {
        customEncoder(GZipEncoder.INSTANCE, quality);
    }

    public final void identity(Float quality) {
        customEncoder(IdentityEncoder.INSTANCE, quality);
    }

    public final void setMode(Mode mode) {
        mode.getClass();
        this.mode = mode;
    }
}

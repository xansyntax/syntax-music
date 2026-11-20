package com.google.common.net;

import androidx.media3.common.Format$$ExternalSyntheticLambda1;
import coil3.util.LifecyclesKt;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter$$ExternalSyntheticLambda0;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.EmptyImmutableListMultimap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps$TransformedEntriesListMultimap;
import com.google.common.collect.RegularImmutableList;
import io.ktor.http.ContentType;
import io.ktor.http.auth.HttpAuthHeader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import okhttp3.ConnectionPool;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaType {
    public static final MediaType JSON_UTF_8;
    public static final ConnectionPool PARAMETER_JOINER;
    public static final CharMatcher.And TOKEN_MATCHER;
    public static final ImmutableListMultimap UTF_8_CONSTANT_PARAMETERS;
    public static final HashMap knownTypes;
    public int hashCode;
    public final ImmutableListMultimap parameters;
    public final String subtype;
    public String toString;
    public final String type;

    static {
        ImmutableListMultimap immutableListMultimap;
        String lowerCase = LifecyclesKt.toLowerCase(StandardCharsets.UTF_8.name());
        Maps.checkEntryNotNull(HttpAuthHeader.Parameters.Charset, lowerCase);
        CompactHashMap compactHashMap = new CompactHashMap();
        compactHashMap.init(3);
        ImmutableCollection.Builder builder = (ImmutableCollection.Builder) compactHashMap.get(HttpAuthHeader.Parameters.Charset);
        if (builder == null) {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            Maps.checkNonnegative(4, "expectedSize");
            builder = new ImmutableList.Builder(4);
            compactHashMap.put(HttpAuthHeader.Parameters.Charset, builder);
        }
        builder.add(lowerCase);
        CompactHashMap.KeySetView<Map.Entry> keySetView = new CompactHashMap.KeySetView(compactHashMap, (byte) 1);
        if (keySetView.isEmpty()) {
            immutableListMultimap = EmptyImmutableListMultimap.INSTANCE;
        } else {
            StatusLine statusLine = new StatusLine(compactHashMap.size());
            int i = 0;
            for (Map.Entry entry : keySetView) {
                Object key = entry.getKey();
                RegularImmutableList regularImmutableListBuild = ((ImmutableList.Builder) entry.getValue()).build();
                statusLine.put(key, regularImmutableListBuild);
                i += regularImmutableListBuild.size;
            }
            immutableListMultimap = new ImmutableListMultimap(statusLine.build(true), i);
        }
        UTF_8_CONSTANT_PARAMETERS = immutableListMultimap;
        CharMatcher.Any any = CharMatcher.Any.INSTANCE$1;
        CharMatcher.Any any2 = CharMatcher.Any.INSTANCE$2;
        any2.getClass();
        CharMatcher.NegatedFastMatcher negatedFastMatcher = new CharMatcher.NegatedFastMatcher(any2);
        any.getClass();
        TOKEN_MATCHER = new CharMatcher.And(new CharMatcher.And(new CharMatcher.And(any, negatedFastMatcher), new CharMatcher.Is(' ', (byte) 1)), CharMatcher.anyOf("()<>@,;:\\\"/[]?=").negate());
        CharMatcher.anyOf("\"\\\r").negate().getClass();
        CharMatcher.anyOf(" \t\r\n");
        knownTypes = new HashMap();
        createConstant("*", "*");
        createConstant(ContentType.Text.TYPE, "*");
        createConstant(ContentType.Image.TYPE, "*");
        createConstant(ContentType.Audio.TYPE, "*");
        createConstant(ContentType.Video.TYPE, "*");
        createConstant(ContentType.Application.TYPE, "*");
        createConstant(ContentType.Font.TYPE, "*");
        createConstantUtf8(ContentType.Text.TYPE, "cache-manifest");
        createConstantUtf8(ContentType.Text.TYPE, "css");
        createConstantUtf8(ContentType.Text.TYPE, "csv");
        createConstantUtf8(ContentType.Text.TYPE, "html");
        createConstantUtf8(ContentType.Text.TYPE, "calendar");
        createConstantUtf8(ContentType.Text.TYPE, "markdown");
        createConstantUtf8(ContentType.Text.TYPE, "plain");
        createConstantUtf8(ContentType.Text.TYPE, "javascript");
        createConstantUtf8(ContentType.Text.TYPE, "tab-separated-values");
        createConstantUtf8(ContentType.Text.TYPE, "vcard");
        createConstantUtf8(ContentType.Text.TYPE, "vnd.wap.wml");
        createConstantUtf8(ContentType.Text.TYPE, "xml");
        createConstantUtf8(ContentType.Text.TYPE, "vtt");
        createConstant(ContentType.Image.TYPE, "bmp");
        createConstant(ContentType.Image.TYPE, "x-canon-crw");
        createConstant(ContentType.Image.TYPE, "gif");
        createConstant(ContentType.Image.TYPE, "vnd.microsoft.icon");
        createConstant(ContentType.Image.TYPE, "jpeg");
        createConstant(ContentType.Image.TYPE, "png");
        createConstant(ContentType.Image.TYPE, "vnd.adobe.photoshop");
        createConstantUtf8(ContentType.Image.TYPE, "svg+xml");
        createConstant(ContentType.Image.TYPE, "tiff");
        createConstant(ContentType.Image.TYPE, "avif");
        createConstant(ContentType.Image.TYPE, "webp");
        createConstant(ContentType.Image.TYPE, "heif");
        createConstant(ContentType.Image.TYPE, "jp2");
        createConstant(ContentType.Audio.TYPE, "mp4");
        createConstant(ContentType.Audio.TYPE, "mpeg");
        createConstant(ContentType.Audio.TYPE, "ogg");
        createConstant(ContentType.Audio.TYPE, "webm");
        createConstant(ContentType.Audio.TYPE, "l16");
        createConstant(ContentType.Audio.TYPE, "l24");
        createConstant(ContentType.Audio.TYPE, "basic");
        createConstant(ContentType.Audio.TYPE, "aac");
        createConstant(ContentType.Audio.TYPE, "vorbis");
        createConstant(ContentType.Audio.TYPE, "x-ms-wma");
        createConstant(ContentType.Audio.TYPE, "x-ms-wax");
        createConstant(ContentType.Audio.TYPE, "vnd.rn-realaudio");
        createConstant(ContentType.Audio.TYPE, "vnd.wave");
        createConstant(ContentType.Video.TYPE, "mp4");
        createConstant(ContentType.Video.TYPE, "mpeg");
        createConstant(ContentType.Video.TYPE, "ogg");
        createConstant(ContentType.Video.TYPE, "quicktime");
        createConstant(ContentType.Video.TYPE, "webm");
        createConstant(ContentType.Video.TYPE, "x-ms-wmv");
        createConstant(ContentType.Video.TYPE, "x-flv");
        createConstant(ContentType.Video.TYPE, "3gpp");
        createConstant(ContentType.Video.TYPE, "3gpp2");
        createConstantUtf8(ContentType.Application.TYPE, "xml");
        createConstantUtf8(ContentType.Application.TYPE, "atom+xml");
        createConstant(ContentType.Application.TYPE, "x-bzip2");
        createConstantUtf8(ContentType.Application.TYPE, "dart");
        createConstant(ContentType.Application.TYPE, "vnd.apple.pkpass");
        createConstant(ContentType.Application.TYPE, "vnd.ms-fontobject");
        createConstant(ContentType.Application.TYPE, "epub+zip");
        createConstant(ContentType.Application.TYPE, "x-www-form-urlencoded");
        createConstant(ContentType.Application.TYPE, "pkcs12");
        createConstant(ContentType.Application.TYPE, "binary");
        createConstant(ContentType.Application.TYPE, "cbor");
        createConstant(ContentType.Application.TYPE, "geo+json");
        createConstant(ContentType.Application.TYPE, "x-gzip");
        createConstant(ContentType.Application.TYPE, "hal+json");
        createConstantUtf8(ContentType.Application.TYPE, "javascript");
        createConstant(ContentType.Application.TYPE, "jose");
        createConstant(ContentType.Application.TYPE, "jose+json");
        JSON_UTF_8 = createConstantUtf8(ContentType.Application.TYPE, "json");
        createConstant(ContentType.Application.TYPE, "jwt");
        createConstantUtf8(ContentType.Application.TYPE, "manifest+json");
        createConstant(ContentType.Application.TYPE, "vnd.google-earth.kml+xml");
        createConstant(ContentType.Application.TYPE, "vnd.google-earth.kmz");
        createConstant(ContentType.Application.TYPE, "mbox");
        createConstant(ContentType.Application.TYPE, "x-apple-aspen-config");
        createConstant(ContentType.Application.TYPE, "vnd.ms-excel");
        createConstant(ContentType.Application.TYPE, "vnd.ms-outlook");
        createConstant(ContentType.Application.TYPE, "vnd.ms-powerpoint");
        createConstant(ContentType.Application.TYPE, "msword");
        createConstant(ContentType.Application.TYPE, "dash+xml");
        createConstant(ContentType.Application.TYPE, "wasm");
        createConstant(ContentType.Application.TYPE, "x-nacl");
        createConstant(ContentType.Application.TYPE, "x-pem-file");
        createConstant(ContentType.Application.TYPE, "x-pnacl");
        createConstant(ContentType.Application.TYPE, "octet-stream");
        createConstant(ContentType.Application.TYPE, "ogg");
        createConstant(ContentType.Application.TYPE, "vnd.openxmlformats-officedocument.wordprocessingml.document");
        createConstant(ContentType.Application.TYPE, "vnd.openxmlformats-officedocument.presentationml.presentation");
        createConstant(ContentType.Application.TYPE, "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        createConstant(ContentType.Application.TYPE, "vnd.oasis.opendocument.graphics");
        createConstant(ContentType.Application.TYPE, "vnd.oasis.opendocument.presentation");
        createConstant(ContentType.Application.TYPE, "vnd.oasis.opendocument.spreadsheet");
        createConstant(ContentType.Application.TYPE, "vnd.oasis.opendocument.text");
        createConstantUtf8(ContentType.Application.TYPE, "opensearchdescription+xml");
        createConstant(ContentType.Application.TYPE, "pdf");
        createConstant(ContentType.Application.TYPE, "postscript");
        createConstant(ContentType.Application.TYPE, "protobuf");
        createConstantUtf8(ContentType.Application.TYPE, "rdf+xml");
        createConstantUtf8(ContentType.Application.TYPE, "rtf");
        createConstant(ContentType.Application.TYPE, "font-sfnt");
        createConstant(ContentType.Application.TYPE, "x-shockwave-flash");
        createConstant(ContentType.Application.TYPE, "vnd.sketchup.skp");
        createConstantUtf8(ContentType.Application.TYPE, "soap+xml");
        createConstant(ContentType.Application.TYPE, "x-tar");
        createConstant(ContentType.Application.TYPE, "font-woff");
        createConstant(ContentType.Application.TYPE, "font-woff2");
        createConstantUtf8(ContentType.Application.TYPE, "xhtml+xml");
        createConstantUtf8(ContentType.Application.TYPE, "xrd+xml");
        createConstant(ContentType.Application.TYPE, "zip");
        createConstant(ContentType.Font.TYPE, "collection");
        createConstant(ContentType.Font.TYPE, "otf");
        createConstant(ContentType.Font.TYPE, "sfnt");
        createConstant(ContentType.Font.TYPE, "ttf");
        createConstant(ContentType.Font.TYPE, "woff");
        createConstant(ContentType.Font.TYPE, "woff2");
        createConstant(ContentType.Application.TYPE, "yaml");
        PARAMETER_JOINER = new ConnectionPool(new Joiner("; "));
    }

    public MediaType(String str, String str2, ImmutableListMultimap immutableListMultimap) {
        this.type = str;
        this.subtype = str2;
        this.parameters = immutableListMultimap;
    }

    public static void createConstant(String str, String str2) {
        MediaType mediaType = new MediaType(str, str2, EmptyImmutableListMultimap.INSTANCE);
        knownTypes.put(mediaType, mediaType);
    }

    public static MediaType createConstantUtf8(String str, String str2) {
        MediaType mediaType = new MediaType(str, str2, UTF_8_CONSTANT_PARAMETERS);
        knownTypes.put(mediaType, mediaType);
        StandardCharsets.UTF_8.getClass();
        return mediaType;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MediaType)) {
            return false;
        }
        MediaType mediaType = (MediaType) obj;
        return this.type.equals(mediaType.type) && this.subtype.equals(mediaType.subtype) && parametersAsMap().equals(mediaType.parametersAsMap());
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHash = Objects.hash(this.type, this.subtype, parametersAsMap());
        this.hashCode = iHash;
        return iHash;
    }

    public final Maps.TransformedEntriesMap parametersAsMap() {
        return new Maps.TransformedEntriesMap(this.parameters.asMap(), new Splitter$$ExternalSyntheticLambda0((byte) 5, new Format$$ExternalSyntheticLambda1((byte) 20)));
    }

    public final String toString() {
        String str = this.toString;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.type);
        sb.append('/');
        sb.append(this.subtype);
        ImmutableListMultimap immutableListMultimap = this.parameters;
        if (immutableListMultimap.size() != 0) {
            sb.append("; ");
            Collection collectionEntries = new Multimaps$TransformedEntriesListMultimap(immutableListMultimap, new Splitter$$ExternalSyntheticLambda0((byte) 6, new Format$$ExternalSyntheticLambda1((byte) 19))).entries();
            ConnectionPool connectionPool = PARAMETER_JOINER;
            connectionPool.getClass();
            try {
                connectionPool.appendTo(sb, collectionEntries.iterator());
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
        String string = sb.toString();
        this.toString = string;
        return string;
    }
}

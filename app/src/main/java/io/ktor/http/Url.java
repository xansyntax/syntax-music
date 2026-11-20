package io.ktor.http;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.utils.io.JvmSerializable_jvmKt;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b:\b\u0007\u0018\u0000 P2\u00060\u0001j\u0002`\u0002:\u0001PBe\b\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0005H\u0096\u0080\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0019\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0096\u0082\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010\u0016R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010\u001cR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\r\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b&\u0010\u0016R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b'\u0010\u0016R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b(\u0010\u0016R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b*\u0010+R\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001fR&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010,\u0012\u0004\b/\u00100\u001a\u0004\b-\u0010.R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u0010.R!\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010.R\u0019\u00107\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u00108\u001a\u0004\b;\u0010:R\u0011\u0010=\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b<\u0010\u001cR\u001b\u0010@\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u00104\u001a\u0004\b?\u0010\u0016R\u001b\u0010C\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u00104\u001a\u0004\bB\u0010\u0016R\u001b\u0010F\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u00104\u001a\u0004\bE\u0010\u0016R\u001d\u0010I\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u00104\u001a\u0004\bH\u0010\u0016R\u001d\u0010L\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u00104\u001a\u0004\bK\u0010\u0016R\u001b\u0010O\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u00104\u001a\u0004\bN\u0010\u0016¨\u0006Q"}, d2 = {"Lio/ktor/http/Url;", "Ljava/io/Serializable;", "Lio/ktor/utils/io/JvmSerializable;", "Lio/ktor/http/URLProtocol;", "protocol", "", "host", "", "specifiedPort", "", "pathSegments", "Lio/ktor/http/Parameters;", "parameters", "fragment", "user", "password", "", "trailingQuery", "urlString", "<init>", "(Lio/ktor/http/URLProtocol;Ljava/lang/String;ILjava/util/List;Lio/ktor/http/Parameters;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "writeReplace", "()Ljava/lang/Object;", "Ljava/lang/String;", "getHost", "I", "getSpecifiedPort", "Lio/ktor/http/Parameters;", "getParameters", "()Lio/ktor/http/Parameters;", "getFragment", "getUser", "getPassword", "Z", "getTrailingQuery", "()Z", "Ljava/util/List;", "getPathSegments", "()Ljava/util/List;", "getPathSegments$annotations", "()V", "rawSegments", "getRawSegments", "segments$delegate", "Lkotlin/Lazy;", "getSegments", "segments", "protocolOrNull", "Lio/ktor/http/URLProtocol;", "getProtocolOrNull", "()Lio/ktor/http/URLProtocol;", "getProtocol", "getPort", "port", "encodedPath$delegate", "getEncodedPath", "encodedPath", "encodedQuery$delegate", "getEncodedQuery", "encodedQuery", "encodedPathAndQuery$delegate", "getEncodedPathAndQuery", "encodedPathAndQuery", "encodedUser$delegate", "getEncodedUser", "encodedUser", "encodedPassword$delegate", "getEncodedPassword", "encodedPassword", "encodedFragment$delegate", "getEncodedFragment", "encodedFragment", "Companion", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = UrlSerializer.class)
public final class Url implements java.io.Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: encodedFragment$delegate, reason: from kotlin metadata */
    private final Lazy encodedFragment;

    /* JADX INFO: renamed from: encodedPassword$delegate, reason: from kotlin metadata */
    private final Lazy encodedPassword;

    /* JADX INFO: renamed from: encodedPath$delegate, reason: from kotlin metadata */
    private final Lazy encodedPath;

    /* JADX INFO: renamed from: encodedPathAndQuery$delegate, reason: from kotlin metadata */
    private final Lazy encodedPathAndQuery;

    /* JADX INFO: renamed from: encodedQuery$delegate, reason: from kotlin metadata */
    private final Lazy encodedQuery;

    /* JADX INFO: renamed from: encodedUser$delegate, reason: from kotlin metadata */
    private final Lazy encodedUser;
    private final String fragment;
    private final String host;
    private final Parameters parameters;
    private final String password;
    private final List<String> pathSegments;
    private final URLProtocol protocol;
    private final URLProtocol protocolOrNull;
    private final List<String> rawSegments;

    /* JADX INFO: renamed from: segments$delegate, reason: from kotlin metadata */
    private final Lazy segments;
    private final int specifiedPort;
    private final boolean trailingQuery;
    private final String urlString;
    private final String user;

    public Url(URLProtocol uRLProtocol, String str, int i, List<String> list, Parameters parameters, String str2, String str3, String str4, boolean z, String str5) {
        str.getClass();
        list.getClass();
        parameters.getClass();
        str2.getClass();
        str5.getClass();
        this.host = str;
        this.specifiedPort = i;
        this.parameters = parameters;
        this.fragment = str2;
        this.user = str3;
        this.password = str4;
        this.trailingQuery = z;
        this.urlString = str5;
        if (i < 0 || i >= 65536) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Port must be between 0 and 65535, or 0 if not set. Provided: "));
            throw null;
        }
        this.pathSegments = list;
        this.rawSegments = list;
        final byte b = 0;
        this.segments = new SynchronizedLazyImpl(new Url$$ExternalSyntheticLambda0(list, b));
        this.protocolOrNull = uRLProtocol;
        this.protocol = uRLProtocol == null ? URLProtocol.INSTANCE.getHTTP() : uRLProtocol;
        this.encodedPath = new SynchronizedLazyImpl(new Url$$ExternalSyntheticLambda1(list, this, b));
        this.encodedQuery = new SynchronizedLazyImpl(new Function0(this) { // from class: io.ktor.http.Url$$ExternalSyntheticLambda2
            public final /* synthetic */ Url f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b2 = b;
                Url url = this.f$0;
                switch (b2) {
                    case 0:
                        return Url.encodedQuery_delegate$lambda$0(url);
                    case 1:
                        return Url.encodedPathAndQuery_delegate$lambda$0(url);
                    case 2:
                        return Url.encodedUser_delegate$lambda$0(url);
                    case 3:
                        return Url.encodedPassword_delegate$lambda$0(url);
                    default:
                        return Url.encodedFragment_delegate$lambda$0(url);
                }
            }
        });
        final byte b2 = 1;
        this.encodedPathAndQuery = new SynchronizedLazyImpl(new Function0(this) { // from class: io.ktor.http.Url$$ExternalSyntheticLambda2
            public final /* synthetic */ Url f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b3 = b2;
                Url url = this.f$0;
                switch (b3) {
                    case 0:
                        return Url.encodedQuery_delegate$lambda$0(url);
                    case 1:
                        return Url.encodedPathAndQuery_delegate$lambda$0(url);
                    case 2:
                        return Url.encodedUser_delegate$lambda$0(url);
                    case 3:
                        return Url.encodedPassword_delegate$lambda$0(url);
                    default:
                        return Url.encodedFragment_delegate$lambda$0(url);
                }
            }
        });
        final byte b3 = 2;
        this.encodedUser = new SynchronizedLazyImpl(new Function0(this) { // from class: io.ktor.http.Url$$ExternalSyntheticLambda2
            public final /* synthetic */ Url f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b4 = b3;
                Url url = this.f$0;
                switch (b4) {
                    case 0:
                        return Url.encodedQuery_delegate$lambda$0(url);
                    case 1:
                        return Url.encodedPathAndQuery_delegate$lambda$0(url);
                    case 2:
                        return Url.encodedUser_delegate$lambda$0(url);
                    case 3:
                        return Url.encodedPassword_delegate$lambda$0(url);
                    default:
                        return Url.encodedFragment_delegate$lambda$0(url);
                }
            }
        });
        final byte b4 = 3;
        this.encodedPassword = new SynchronizedLazyImpl(new Function0(this) { // from class: io.ktor.http.Url$$ExternalSyntheticLambda2
            public final /* synthetic */ Url f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b5 = b4;
                Url url = this.f$0;
                switch (b5) {
                    case 0:
                        return Url.encodedQuery_delegate$lambda$0(url);
                    case 1:
                        return Url.encodedPathAndQuery_delegate$lambda$0(url);
                    case 2:
                        return Url.encodedUser_delegate$lambda$0(url);
                    case 3:
                        return Url.encodedPassword_delegate$lambda$0(url);
                    default:
                        return Url.encodedFragment_delegate$lambda$0(url);
                }
            }
        });
        final byte b5 = 4;
        this.encodedFragment = new SynchronizedLazyImpl(new Function0(this) { // from class: io.ktor.http.Url$$ExternalSyntheticLambda2
            public final /* synthetic */ Url f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b6 = b5;
                Url url = this.f$0;
                switch (b6) {
                    case 0:
                        return Url.encodedQuery_delegate$lambda$0(url);
                    case 1:
                        return Url.encodedPathAndQuery_delegate$lambda$0(url);
                    case 2:
                        return Url.encodedUser_delegate$lambda$0(url);
                    case 3:
                        return Url.encodedPassword_delegate$lambda$0(url);
                    default:
                        return Url.encodedFragment_delegate$lambda$0(url);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedFragment_delegate$lambda$0(Url url) {
        int iIndexOf$default = StringsKt.indexOf$default(url.urlString, '#', 0, 6) + 1;
        return iIndexOf$default == 0 ? "" : url.urlString.substring(iIndexOf$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedPassword_delegate$lambda$0(Url url) {
        String str = url.password;
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        return url.urlString.substring(StringsKt.indexOf$default(url.urlString, ':', url.protocol.getName().length() + 3, 4) + 1, StringsKt.indexOf$default(url.urlString, '@', 0, 6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedPathAndQuery_delegate$lambda$0(Url url) {
        int iIndexOf$default = StringsKt.indexOf$default(url.urlString, '/', url.protocol.getName().length() + 3, 4);
        if (iIndexOf$default == -1) {
            return "";
        }
        int iIndexOf$default2 = StringsKt.indexOf$default(url.urlString, '#', iIndexOf$default, 4);
        String str = url.urlString;
        return iIndexOf$default2 == -1 ? str.substring(iIndexOf$default) : str.substring(iIndexOf$default, iIndexOf$default2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedPath_delegate$lambda$0(List list, Url url) {
        int iIndexOf$default;
        if (list.isEmpty() || (iIndexOf$default = StringsKt.indexOf$default(url.urlString, '/', url.protocol.getName().length() + 3, 4)) == -1) {
            return "";
        }
        int iIndexOfAny = StringsKt.indexOfAny(url.urlString, new char[]{'?', '#'}, iIndexOf$default, false);
        String str = url.urlString;
        return iIndexOfAny == -1 ? str.substring(iIndexOf$default) : str.substring(iIndexOf$default, iIndexOfAny);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedQuery_delegate$lambda$0(Url url) {
        int iIndexOf$default = StringsKt.indexOf$default(url.urlString, '?', 0, 6) + 1;
        if (iIndexOf$default == 0) {
            return "";
        }
        int iIndexOf$default2 = StringsKt.indexOf$default(url.urlString, '#', iIndexOf$default, 4);
        String str = url.urlString;
        return iIndexOf$default2 == -1 ? str.substring(iIndexOf$default) : str.substring(iIndexOf$default, iIndexOf$default2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedUser_delegate$lambda$0(Url url) {
        String str = url.user;
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        int length = url.protocol.getName().length() + 3;
        return url.urlString.substring(length, StringsKt.indexOfAny(url.urlString, new char[]{':', '@'}, length, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List segments_delegate$lambda$0(List list) {
        if (list.isEmpty()) {
            return EmptyList.INSTANCE;
        }
        return list.subList((((CharSequence) CollectionsKt.first(list)).length() != 0 || list.size() <= 1) ? 0 : 1, ((CharSequence) CollectionsKt.last(list)).length() == 0 ? list.size() - 1 : list.size());
    }

    private final Object writeReplace() {
        return JvmSerializable_jvmKt.JvmSerializerReplacement(UrlJvmSerializer.INSTANCE, this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || Url.class != other.getClass()) {
            return false;
        }
        return Intrinsics.areEqual(this.urlString, ((Url) other).urlString);
    }

    public final String getEncodedFragment() {
        return (String) this.encodedFragment.getValue();
    }

    public final String getEncodedPassword() {
        return (String) this.encodedPassword.getValue();
    }

    public final String getEncodedPath() {
        return (String) this.encodedPath.getValue();
    }

    public final String getEncodedPathAndQuery() {
        return (String) this.encodedPathAndQuery.getValue();
    }

    public final String getEncodedQuery() {
        return (String) this.encodedQuery.getValue();
    }

    public final String getEncodedUser() {
        return (String) this.encodedUser.getValue();
    }

    public final String getFragment() {
        return this.fragment;
    }

    public final String getHost() {
        return this.host;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final String getPassword() {
        return this.password;
    }

    public final List<String> getPathSegments() {
        return this.pathSegments;
    }

    public final int getPort() {
        Integer numValueOf = Integer.valueOf(this.specifiedPort);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : this.protocol.getDefaultPort();
    }

    public final URLProtocol getProtocol() {
        return this.protocol;
    }

    public final URLProtocol getProtocolOrNull() {
        return this.protocolOrNull;
    }

    public final List<String> getRawSegments() {
        return this.rawSegments;
    }

    public final List<String> getSegments() {
        return (List) this.segments.getValue();
    }

    public final int getSpecifiedPort() {
        return this.specifiedPort;
    }

    public final boolean getTrailingQuery() {
        return this.trailingQuery;
    }

    public final String getUser() {
        return this.user;
    }

    public int hashCode() {
        return this.urlString.hashCode();
    }

    /* JADX INFO: renamed from: toString, reason: from getter */
    public String getUrlString() {
        return this.urlString;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/http/Url$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/http/Url;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return UrlSerializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public static /* synthetic */ void getPathSegments$annotations() {
    }
}

package io.ktor.http;

import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a)\u0010\u0005\u001a\u00028\u0000\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u000b\u001a\u00020\n*\u00060\u0000j\u0002`\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\u000e\u001a\u00020\n*\u00060\u0000j\u0002`\u00012\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\f\u001a\u001f\u0010\u000f\u001a\u00020\n*\u00060\u0000j\u0002`\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0011\u0010\u0011\u001a\u00020\u0003*\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012\u001a)\u0010\u0017\u001a\u00020\u0003*\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018\u001a/\u0010\u0017\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0019\"\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u001b\u001a%\u0010\u001c\u001a\u00020\n*\u00020\u00032\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0019\"\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010\u001e\u001a\u00020\u0003*\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010\u001e\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0019\"\u00020\u0007¢\u0006\u0004\b\u001e\u0010 \u001a\u0019\u0010!\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0002¢\u0006\u0004\b!\u0010\"\u001aW\u0010(\u001a\u00020\n*\u00020\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0&¢\u0006\u0004\b(\u0010)\u001a'\u0010*\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0019\"\u00020\u0007H\u0007¢\u0006\u0004\b*\u0010 \u001a!\u0010*\u001a\u00020\u0003*\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0007¢\u0006\u0004\b*\u0010\u001f\"\u0014\u0010+\u001a\u00020$8\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010,\"\u0018\u0010/\u001a\u00020\u0007*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u0015\u00101\u001a\u00020\u0007*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010.\"(\u0010\r\u001a\u00020\u0007*\u00020\u00032\u0006\u00102\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010.\"\u0004\b4\u00105¨\u00066"}, d2 = {"Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "A", "Lio/ktor/http/URLBuilder;", "out", "appendTo", "(Lio/ktor/http/URLBuilder;Ljava/lang/Appendable;)Ljava/lang/Appendable;", "", "encodedUser", "host", "", "appendMailto", "(Ljava/lang/Appendable;Ljava/lang/String;Ljava/lang/String;)V", "encodedPath", "appendFile", "appendPayload", "(Ljava/lang/Appendable;Ljava/lang/String;)V", "clone", "(Lio/ktor/http/URLBuilder;)Lio/ktor/http/URLBuilder;", "", "segments", "", "encodeSlash", "appendPathSegments", "(Lio/ktor/http/URLBuilder;Ljava/util/List;Z)Lio/ktor/http/URLBuilder;", "", "components", "(Lio/ktor/http/URLBuilder;[Ljava/lang/String;Z)Lio/ktor/http/URLBuilder;", "path", "(Lio/ktor/http/URLBuilder;[Ljava/lang/String;)V", "appendEncodedPathSegments", "(Lio/ktor/http/URLBuilder;Ljava/util/List;)Lio/ktor/http/URLBuilder;", "(Lio/ktor/http/URLBuilder;[Ljava/lang/String;)Lio/ktor/http/URLBuilder;", "joinPath", "(Ljava/util/List;)Ljava/lang/String;", "scheme", "", "port", "Lkotlin/Function1;", "block", "set", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "pathComponents", "DEFAULT_PORT", "I", "getEncodedUserAndPassword", "(Lio/ktor/http/URLBuilder;)Ljava/lang/String;", "encodedUserAndPassword", "getAuthority", "authority", "value", "getEncodedPath", "setEncodedPath", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;)V", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class URLBuilderKt {
    public static final int DEFAULT_PORT = 0;

    public static final URLBuilder appendEncodedPathSegments(URLBuilder uRLBuilder, List<String> list) {
        ArrayList arrayListPlus;
        uRLBuilder.getClass();
        list.getClass();
        boolean z = false;
        boolean z2 = uRLBuilder.getEncodedPathSegments().size() > 1 && ((CharSequence) CollectionsKt.last(uRLBuilder.getEncodedPathSegments())).length() == 0 && !list.isEmpty();
        if (list.size() > 1 && ((CharSequence) CollectionsKt.first((List) list)).length() == 0 && !uRLBuilder.getEncodedPathSegments().isEmpty()) {
            z = true;
        }
        if (z2 && z) {
            arrayListPlus = CollectionsKt.plus((Iterable) CollectionsKt.drop(list, 1), (Collection) CollectionsKt.dropLast(1, uRLBuilder.getEncodedPathSegments()));
        } else if (z2) {
            arrayListPlus = CollectionsKt.plus((Iterable) list, (Collection) CollectionsKt.dropLast(1, uRLBuilder.getEncodedPathSegments()));
        } else if (z) {
            arrayListPlus = CollectionsKt.plus((Iterable) CollectionsKt.drop(list, 1), (Collection) uRLBuilder.getEncodedPathSegments());
        } else {
            arrayListPlus = CollectionsKt.plus((Iterable) list, (Collection) uRLBuilder.getEncodedPathSegments());
        }
        uRLBuilder.setEncodedPathSegments(arrayListPlus);
        return uRLBuilder;
    }

    private static final void appendFile(Appendable appendable, String str, String str2) throws IOException {
        appendable.append("://");
        appendable.append(str);
        if (!StringsKt.startsWith$default(str2, '/')) {
            appendable.append('/');
        }
        appendable.append(str2);
    }

    private static final void appendMailto(Appendable appendable, String str, String str2) throws IOException {
        appendable.append(ServerSentEventKt.COLON);
        appendable.append(str);
        appendable.append(str2);
    }

    public static final URLBuilder appendPathSegments(URLBuilder uRLBuilder, List<String> list, boolean z) {
        uRLBuilder.getClass();
        list.getClass();
        if (!z) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                CollectionsKt__MutableCollectionsKt.addAll(StringsKt.split$default((String) it.next(), new char[]{'/'}), arrayList);
            }
            list = arrayList;
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(CodecsKt.encodeURLPathPart((String) it2.next()));
        }
        appendEncodedPathSegments(uRLBuilder, arrayList2);
        return uRLBuilder;
    }

    public static /* synthetic */ URLBuilder appendPathSegments$default(URLBuilder uRLBuilder, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return appendPathSegments(uRLBuilder, (List<String>) list, z);
    }

    private static final void appendPayload(Appendable appendable, String str) throws IOException {
        appendable.append(ServerSentEventKt.COLON);
        appendable.append(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0079  */
    /* JADX WARN: Code duplicated, block: B:29:0x009e  */
    public static final <A extends Appendable> A appendTo(URLBuilder uRLBuilder, A a) throws IOException {
        a.append(uRLBuilder.getProtocol().getName());
        String name = uRLBuilder.getProtocol().getName();
        switch (name) {
            case "mailto":
                appendMailto(a, getEncodedUserAndPassword(uRLBuilder), uRLBuilder.getHost());
                break;
            case "tel":
                appendPayload(a, uRLBuilder.getHost());
                break;
            case "data":
                appendPayload(a, uRLBuilder.getHost());
                break;
            case "file":
                appendFile(a, uRLBuilder.getHost(), getEncodedPath(uRLBuilder));
                URLUtilsKt.appendUrlFullPath(a, "", uRLBuilder.getEncodedParameters(), uRLBuilder.getTrailingQuery());
            case "about":
                appendPayload(a, uRLBuilder.getHost());
                break;
            default:
                if (name.equals("mailto")) {
                    appendMailto(a, getEncodedUserAndPassword(uRLBuilder), uRLBuilder.getHost());
                    break;
                }
                a.append("://");
                a.append(getAuthority(uRLBuilder));
                URLUtilsKt.appendUrlFullPath(a, getEncodedPath(uRLBuilder), uRLBuilder.getEncodedParameters(), uRLBuilder.getTrailingQuery());
                if (uRLBuilder.getEncodedFragment().length() > 0) {
                    a.append('#');
                    a.append(uRLBuilder.getEncodedFragment());
                    break;
                }
                break;
        }
        return a;
    }

    public static final URLBuilder clone(URLBuilder uRLBuilder) {
        uRLBuilder.getClass();
        return URLUtilsKt.takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), uRLBuilder);
    }

    public static final String getAuthority(URLBuilder uRLBuilder) {
        uRLBuilder.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(getEncodedUserAndPassword(uRLBuilder));
        sb.append(uRLBuilder.getHost());
        if (uRLBuilder.getPort() != 0 && uRLBuilder.getPort() != uRLBuilder.getProtocol().getDefaultPort()) {
            sb.append(ServerSentEventKt.COLON);
            sb.append(String.valueOf(uRLBuilder.getPort()));
        }
        return sb.toString();
    }

    public static final String getEncodedPath(URLBuilder uRLBuilder) {
        uRLBuilder.getClass();
        return joinPath(uRLBuilder.getEncodedPathSegments());
    }

    public static final String getEncodedUserAndPassword(URLBuilder uRLBuilder) {
        uRLBuilder.getClass();
        StringBuilder sb = new StringBuilder();
        URLUtilsKt.appendUserAndPassword(sb, uRLBuilder.getEncodedUser(), uRLBuilder.getEncodedPassword());
        return sb.toString();
    }

    private static final String joinPath(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        if (list.size() == 1) {
            return ((CharSequence) CollectionsKt.first((List) list)).length() == 0 ? "/" : (String) CollectionsKt.first((List) list);
        }
        return CollectionsKt.joinToString$default(list, "/", null, null, null, 62);
    }

    public static final void path(URLBuilder uRLBuilder, String... strArr) {
        uRLBuilder.getClass();
        strArr.getClass();
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(CodecsKt.encodeURLPath$default(str, false, false, 3, null));
        }
        uRLBuilder.setEncodedPathSegments(arrayList);
    }

    @Deprecated
    public static final URLBuilder pathComponents(URLBuilder uRLBuilder, String... strArr) {
        uRLBuilder.getClass();
        strArr.getClass();
        return appendPathSegments$default(uRLBuilder, ArraysKt.toList(strArr), false, 2, (Object) null);
    }

    public static final void set(URLBuilder uRLBuilder, String str, String str2, Integer num, String str3, Function1 function1) {
        uRLBuilder.getClass();
        function1.getClass();
        if (str != null) {
            uRLBuilder.setProtocol(URLProtocol.INSTANCE.createOrDefault(str));
        }
        if (str2 != null) {
            uRLBuilder.setHost(str2);
        }
        if (num != null) {
            uRLBuilder.setPort(num.intValue());
        }
        if (str3 != null) {
            setEncodedPath(uRLBuilder, str3);
        }
        function1.invoke(uRLBuilder);
    }

    public static /* synthetic */ void set$default(URLBuilder uRLBuilder, String str, String str2, Integer num, String str3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 3);
        }
        set(uRLBuilder, str, str2, num, str3, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit set$lambda$0(URLBuilder uRLBuilder) {
        uRLBuilder.getClass();
        return Unit.INSTANCE;
    }

    public static final void setEncodedPath(URLBuilder uRLBuilder, String str) {
        List<String> root_path;
        uRLBuilder.getClass();
        str.getClass();
        if (StringsKt.isBlank(str)) {
            root_path = EmptyList.INSTANCE;
        } else {
            root_path = str.equals("/") ? URLParserKt.getROOT_PATH() : new ArrayList(StringsKt.split$default(str, new char[]{'/'}));
        }
        uRLBuilder.setEncodedPathSegments(root_path);
    }

    public static /* synthetic */ URLBuilder appendPathSegments$default(URLBuilder uRLBuilder, String[] strArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return appendPathSegments(uRLBuilder, strArr, z);
    }

    @Deprecated
    public static final URLBuilder pathComponents(URLBuilder uRLBuilder, List<String> list) {
        uRLBuilder.getClass();
        list.getClass();
        return appendPathSegments$default(uRLBuilder, (List) list, false, 2, (Object) null);
    }

    public static final URLBuilder appendPathSegments(URLBuilder uRLBuilder, String[] strArr, boolean z) {
        uRLBuilder.getClass();
        strArr.getClass();
        return appendPathSegments(uRLBuilder, (List<String>) ArraysKt.toList(strArr), z);
    }

    public static final URLBuilder appendEncodedPathSegments(URLBuilder uRLBuilder, String... strArr) {
        uRLBuilder.getClass();
        strArr.getClass();
        return appendEncodedPathSegments(uRLBuilder, (List<String>) ArraysKt.toList(strArr));
    }
}

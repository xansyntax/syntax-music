package io.ktor.http;

import io.ktor.client.utils.CIOKt;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0002\u001a+\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a3\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000b\u001a%\u0010\u000e\u001a\u00020\u0000*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\r0\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a1\u0010\u0014\u001a\u00020\u0013*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\r0\f2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0011\u0010\u000e\u001a\u00020\u0000*\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u0016\u001a\u001d\u0010\u0014\u001a\u00020\u0013*\u00020\u00062\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011¢\u0006\u0004\b\u0014\u0010\u0017\u001a\u001f\u0010\u0014\u001a\u00020\u0013*\u00020\u00182\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0019\u001a7\u0010\u0014\u001a\u00020\u0013*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f0\u001b0\u001a2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u001c¨\u0006\u001d"}, d2 = {"", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "defaultEncoding", "", "limit", "Lio/ktor/http/Parameters;", "parseUrlEncodedParameters", "(Ljava/lang/String;Ljava/nio/charset/Charset;I)Lio/ktor/http/Parameters;", "", "plusIsSpace", "(Ljava/lang/String;Ljava/nio/charset/Charset;IZ)Lio/ktor/http/Parameters;", "", "Lkotlin/Pair;", "formUrlEncode", "(Ljava/util/List;)Ljava/lang/String;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "", "formUrlEncodeTo", "(Ljava/util/List;Ljava/lang/Appendable;)V", "(Lio/ktor/http/Parameters;)Ljava/lang/String;", "(Lio/ktor/http/Parameters;Ljava/lang/Appendable;)V", "Lio/ktor/http/ParametersBuilder;", "(Lio/ktor/http/ParametersBuilder;Ljava/lang/Appendable;)V", "", "", "(Ljava/util/Set;Ljava/lang/Appendable;)V", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpUrlEncodedKt {
    public static final String formUrlEncode(Parameters parameters) {
        parameters.getClass();
        Set<Map.Entry<String, List<String>>> setEntries = parameters.entries();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new Pair(entry.getKey(), (String) it2.next()));
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, arrayList);
        }
        return formUrlEncode(arrayList);
    }

    public static final void formUrlEncodeTo(Set<? extends Map.Entry<String, ? extends List<String>>> set, Appendable appendable) throws IOException {
        List listListOf;
        set.getClass();
        appendable.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.isEmpty()) {
                listListOf = CollectionsKt__IterablesKt.listOf(new Pair(str, null));
            } else {
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new Pair(str, (String) it2.next()));
                }
                listListOf = arrayList2;
            }
            CollectionsKt__MutableCollectionsKt.addAll(listListOf, arrayList);
        }
        formUrlEncodeTo(arrayList, appendable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence formUrlEncodeTo$lambda$0(Pair pair) {
        pair.getClass();
        String strEncodeURLParameter = CodecsKt.encodeURLParameter((String) pair.first, true);
        Object obj = pair.second;
        if (obj == null) {
            return strEncodeURLParameter;
        }
        return strEncodeURLParameter + '=' + CodecsKt.encodeURLParameterValue(String.valueOf(obj));
    }

    public static final Parameters parseUrlEncodedParameters(String str, Charset charset, int i, boolean z) {
        Object obj;
        String name;
        str.getClass();
        charset.getClass();
        List<String> listSplit$default = StringsKt.split$default(str, new String[]{"&"}, i, 2);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
        for (String str2 : listSplit$default) {
            arrayList.add(new Pair(StringsKt.substringBefore$default(str2, "="), StringsKt.substringAfter(str2, "=", "")));
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        do {
            if (i3 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i3);
            i3++;
        } while (!Intrinsics.areEqual(((Pair) obj).first, "_charset_"));
        Pair pair = (Pair) obj;
        if (pair == null || (name = (String) pair.second) == null) {
            name = CharsetJVMKt.getName(charset);
        }
        Charset charsetForName = CharsetJVMKt.forName(Charsets.INSTANCE, name);
        Parameters.Companion companion = Parameters.INSTANCE;
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        int size2 = arrayList.size();
        while (i2 < size2) {
            Object obj2 = arrayList.get(i2);
            i2++;
            Pair pair2 = (Pair) obj2;
            boolean z2 = z;
            parametersBuilderParametersBuilder$default.append(CodecsKt.decodeURLQueryComponent$default((String) pair2.first, 0, 0, z2, charsetForName, 3, null), CodecsKt.decodeURLQueryComponent$default((String) pair2.second, 0, 0, z2, charsetForName, 3, null));
            z = z2;
        }
        return parametersBuilderParametersBuilder$default.build();
    }

    public static /* synthetic */ Parameters parseUrlEncodedParameters$default(String str, Charset charset, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = CIOKt.DEFAULT_HTTP_POOL_SIZE;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return parseUrlEncodedParameters(str, charset, i, z);
    }

    public static /* synthetic */ Parameters parseUrlEncodedParameters$default(String str, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = CIOKt.DEFAULT_HTTP_POOL_SIZE;
        }
        return parseUrlEncodedParameters(str, charset, i);
    }

    public static final String formUrlEncode(List<Pair> list) throws IOException {
        list.getClass();
        StringBuilder sb = new StringBuilder();
        formUrlEncodeTo(list, sb);
        return sb.toString();
    }

    public static final void formUrlEncodeTo(Parameters parameters, Appendable appendable) throws IOException {
        parameters.getClass();
        appendable.getClass();
        formUrlEncodeTo(parameters.entries(), appendable);
    }

    public static final void formUrlEncodeTo(ParametersBuilder parametersBuilder, Appendable appendable) throws IOException {
        parametersBuilder.getClass();
        appendable.getClass();
        formUrlEncodeTo(parametersBuilder.entries(), appendable);
    }

    public static final void formUrlEncodeTo(List<Pair> list, Appendable appendable) throws IOException {
        list.getClass();
        appendable.getClass();
        CollectionsKt.joinTo$default(list, appendable, "&", new URLUtilsKt$$ExternalSyntheticLambda0((byte) 1), 60);
    }

    @Deprecated
    public static final /* synthetic */ Parameters parseUrlEncodedParameters(String str, Charset charset, int i) {
        str.getClass();
        charset.getClass();
        return parseUrlEncodedParameters$default(str, charset, i, false, 4, null);
    }
}

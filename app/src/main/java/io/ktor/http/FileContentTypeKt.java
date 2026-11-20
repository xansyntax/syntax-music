package io.ktor.http;

import io.ktor.events.Events$$ExternalSyntheticLambda0;
import io.ktor.util.CharsetKt;
import io.ktor.util.CollectionsKt;
import io.ktor.util.TextKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.TransformingSequence;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\r\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\n\u001a\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\b*\u00020\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\u000f\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0012\u001a\u00020\u0011*\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0013\u0010\u0014\u001a\u00020\u0003*\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001aC\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u001a\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\u0017*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00190\u0018H\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0013\u0010\u001d\u001a\u00020\u0003*\u00020\u0001H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\"-\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"-\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"¨\u0006'"}, d2 = {"Lio/ktor/http/ContentType$Companion;", "", "extension", "Lio/ktor/http/ContentType;", "defaultForFileExtension", "(Lio/ktor/http/ContentType$Companion;Ljava/lang/String;)Lio/ktor/http/ContentType;", "path", "defaultForFilePath", "", "fromFilePath", "(Lio/ktor/http/ContentType$Companion;Ljava/lang/String;)Ljava/util/List;", "ext", "fromFileExtension", "fileExtensions", "(Lio/ktor/http/ContentType;)Ljava/util/List;", "selectDefault", "(Ljava/util/List;)Lio/ktor/http/ContentType;", "", "matchApplicationTypeWithCharset", "(Lio/ktor/http/ContentType;)Z", "withCharsetUTF8IfNeeded", "(Lio/ktor/http/ContentType;)Lio/ktor/http/ContentType;", "A", "B", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "", "groupByPairs", "(Lkotlin/sequences/Sequence;)Ljava/util/Map;", "toContentType", "(Ljava/lang/String;)Lio/ktor/http/ContentType;", "contentTypesByExtensions$delegate", "Lkotlin/Lazy;", "getContentTypesByExtensions", "()Ljava/util/Map;", "contentTypesByExtensions", "extensionsByContentType$delegate", "getExtensionsByContentType", "extensionsByContentType", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FileContentTypeKt {
    private static final Lazy contentTypesByExtensions$delegate = new SynchronizedLazyImpl(new Cookie$$ExternalSyntheticLambda1(14));
    private static final Lazy extensionsByContentType$delegate = new SynchronizedLazyImpl(new Cookie$$ExternalSyntheticLambda1(15));

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map contentTypesByExtensions_delegate$lambda$0() {
        Map mapCaseInsensitiveMap = CollectionsKt.caseInsensitiveMap();
        mapCaseInsensitiveMap.putAll(groupByPairs(kotlin.collections.CollectionsKt.asSequence(MimesKt.getMimes())));
        return mapCaseInsensitiveMap;
    }

    public static final ContentType defaultForFileExtension(ContentType.Companion companion, String str) {
        companion.getClass();
        str.getClass();
        return selectDefault(fromFileExtension(ContentType.INSTANCE, str));
    }

    public static final ContentType defaultForFilePath(ContentType.Companion companion, String str) {
        companion.getClass();
        str.getClass();
        return selectDefault(fromFilePath(ContentType.INSTANCE, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map extensionsByContentType_delegate$lambda$0() {
        return groupByPairs(new TransformingSequence(kotlin.collections.CollectionsKt.asSequence(MimesKt.getMimes()), new Events$$ExternalSyntheticLambda0((byte) 29)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair extensionsByContentType_delegate$lambda$0$0(Pair pair) {
        pair.getClass();
        return new Pair((ContentType) pair.second, (String) pair.first);
    }

    public static final List<String> fileExtensions(ContentType contentType) {
        contentType.getClass();
        List<String> list = getExtensionsByContentType().get(contentType);
        if (list != null) {
            return list;
        }
        List<String> list2 = getExtensionsByContentType().get(contentType.withoutParameters());
        return list2 == null ? EmptyList.INSTANCE : list2;
    }

    public static final List<ContentType> fromFileExtension(ContentType.Companion companion, String str) {
        companion.getClass();
        str.getClass();
        for (String lowerCasePreservingASCIIRules = TextKt.toLowerCasePreservingASCIIRules(StringsKt.removePrefix(str, ".")); lowerCasePreservingASCIIRules.length() > 0; lowerCasePreservingASCIIRules = StringsKt.substringAfter(lowerCasePreservingASCIIRules, ".", "")) {
            List<ContentType> list = getContentTypesByExtensions().get(lowerCasePreservingASCIIRules);
            if (list != null) {
                return list;
            }
        }
        return EmptyList.INSTANCE;
    }

    public static final List<ContentType> fromFilePath(ContentType.Companion companion, String str) {
        companion.getClass();
        str.getClass();
        int iIndexOf$default = StringsKt.indexOf$default(str, '.', StringsKt.lastIndexOfAny(str, CharsetKt.toCharArray("/\\"), str.length() - 1) + 1, 4);
        return iIndexOf$default == -1 ? EmptyList.INSTANCE : fromFileExtension(companion, str.substring(iIndexOf$default + 1));
    }

    private static final Map<String, List<ContentType>> getContentTypesByExtensions() {
        return (Map) contentTypesByExtensions$delegate.getValue();
    }

    private static final Map<ContentType, List<String>> getExtensionsByContentType() {
        return (Map) extensionsByContentType$delegate.getValue();
    }

    public static final <A, B> Map<A, List<B>> groupByPairs(Sequence sequence) {
        sequence.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : sequence) {
            Object obj2 = ((Pair) obj).first;
            Object arrayList = linkedHashMap.get(obj2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(obj2, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Pair) it.next()).second);
            }
            linkedHashMap2.put(key, arrayList2);
        }
        return linkedHashMap2;
    }

    private static final boolean matchApplicationTypeWithCharset(ContentType contentType) {
        ContentType.Application application = ContentType.Application.INSTANCE;
        if (contentType.match(application.getAny())) {
            return contentType.match(application.getAtom()) || contentType.match(application.getJavaScript()) || contentType.match(application.getRss()) || contentType.match(application.getXml()) || contentType.match(application.getXml_Dtd());
        }
        return false;
    }

    public static final ContentType selectDefault(List<ContentType> list) {
        list.getClass();
        ContentType octetStream = (ContentType) kotlin.collections.CollectionsKt.firstOrNull((List) list);
        if (octetStream == null) {
            octetStream = ContentType.Application.INSTANCE.getOctetStream();
        }
        if (octetStream.match(ContentType.Text.INSTANCE.getAny())) {
            return withCharsetUTF8IfNeeded(octetStream);
        }
        if (octetStream.match(ContentType.Image.INSTANCE.getSVG())) {
            return withCharsetUTF8IfNeeded(octetStream);
        }
        return matchApplicationTypeWithCharset(octetStream) ? withCharsetUTF8IfNeeded(octetStream) : octetStream;
    }

    public static final ContentType toContentType(String str) {
        str.getClass();
        try {
            return ContentType.INSTANCE.parse(str);
        } catch (Throwable th) {
            throw new IllegalArgumentException("Failed to parse ".concat(str), th);
        }
    }

    private static final ContentType withCharsetUTF8IfNeeded(ContentType contentType) {
        return ContentTypesKt.charset(contentType) != null ? contentType : ContentTypesKt.withCharset(contentType, Charsets.UTF_8);
    }
}

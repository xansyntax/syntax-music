package io.ktor.util;

import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\f0\tH&¢\u0006\u0004\b\r\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0012J/\u0010\u0016\u001a\u00020\u00142\u001e\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000eH&¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Lio/ktor/util/StringValues;", "", "", ContentDisposition.Parameters.Name, "get", "(Ljava/lang/String;)Ljava/lang/String;", "", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "", "names", "()Ljava/util/Set;", "", "entries", "", "contains", "(Ljava/lang/String;)Z", "value", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lkotlin/Function2;", "", "body", "forEach", "(Lkotlin/jvm/functions/Function2;)V", "isEmpty", "()Z", "getCaseInsensitiveName", "caseInsensitiveName", "Companion", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface StringValues {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2 = {"Lio/ktor/util/StringValues$Companion;", "", "<init>", "()V", "", "caseInsensitiveName", "Lkotlin/Function1;", "Lio/ktor/util/StringValuesBuilder;", "", "builder", "Lio/ktor/util/StringValues;", "build", "(ZLkotlin/jvm/functions/Function1;)Lio/ktor/util/StringValues;", "Empty", "Lio/ktor/util/StringValues;", "getEmpty", "()Lio/ktor/util/StringValues;", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final StringValues Empty = new StringValuesImpl(false, null, 3, 0 == true ? 1 : 0);

        private Companion() {
        }

        public static /* synthetic */ StringValues build$default(Companion companion, boolean z, Function1 function1, int i, Object obj) {
            int i2 = i & 1;
            int i3 = 0;
            if (i2 != 0) {
                z = false;
            }
            function1.getClass();
            StringValuesBuilderImpl stringValuesBuilderImpl = new StringValuesBuilderImpl(z, i3, 2, null);
            function1.invoke(stringValuesBuilderImpl);
            return stringValuesBuilderImpl.build();
        }

        public final StringValues build(boolean caseInsensitiveName, Function1 builder) {
            builder.getClass();
            StringValuesBuilderImpl stringValuesBuilderImpl = new StringValuesBuilderImpl(caseInsensitiveName, 0, 2, null);
            builder.invoke(stringValuesBuilderImpl);
            return stringValuesBuilderImpl.build();
        }

        public final StringValues getEmpty() {
            return Empty;
        }
    }

    default boolean contains(String name, String value) {
        name.getClass();
        value.getClass();
        List<String> all = getAll(name);
        if (all != null) {
            return all.contains(value);
        }
        return false;
    }

    Set<Map.Entry<String, List<String>>> entries();

    default void forEach(Function2 body) {
        body.getClass();
        Iterator<T> it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            body.invoke((String) entry.getKey(), (List) entry.getValue());
        }
    }

    default String get(String name) {
        name.getClass();
        List<String> all = getAll(name);
        if (all != null) {
            return (String) kotlin.collections.CollectionsKt.firstOrNull((List) all);
        }
        return null;
    }

    List<String> getAll(String name);

    boolean getCaseInsensitiveName();

    boolean isEmpty();

    Set<String> names();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean contains(StringValues stringValues, String str, String str2) {
            str.getClass();
            str2.getClass();
            return StringValues.super.contains(str, str2);
        }

        @Deprecated
        public static void forEach(StringValues stringValues, Function2 function2) {
            function2.getClass();
            StringValues.super.forEach(function2);
        }

        @Deprecated
        public static String get(StringValues stringValues, String str) {
            str.getClass();
            return StringValues.super.get(str);
        }

        @Deprecated
        public static boolean contains(StringValues stringValues, String str) {
            str.getClass();
            return StringValues.super.contains(str);
        }
    }

    default boolean contains(String name) {
        name.getClass();
        return getAll(name) != null;
    }
}

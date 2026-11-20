package io.ktor.util;

import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010&\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u00160\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0013J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001aJ\u0017\u0010 \u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\"\u0010!J%\u0010 \u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0#H\u0016¢\u0006\u0004\b \u0010%J%\u0010\"\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0#H\u0016¢\u0006\u0004\b\"\u0010%J\u0017\u0010&\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0018H\u0016¢\u0006\u0004\b(\u0010)J\u001f\u0010&\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010\u0010J\u000f\u0010*\u001a\u00020\u0018H\u0016¢\u0006\u0004\b*\u0010)J\u000f\u0010+\u001a\u00020\u001eH\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b-\u0010'J\u0017\u0010.\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\bH\u0014¢\u0006\u0004\b.\u0010'J\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\b0/2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b0\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u0010\u0015R,\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0/038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b$\u00104\u001a\u0004\b5\u00106¨\u00067"}, d2 = {"Lio/ktor/util/StringValuesBuilderImpl;", "Lio/ktor/util/StringValuesBuilder;", "", "caseInsensitiveName", "", ContentDisposition.Parameters.Size, "<init>", "(ZI)V", "", ContentDisposition.Parameters.Name, "", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "contains", "(Ljava/lang/String;)Z", "value", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "names", "()Ljava/util/Set;", "isEmpty", "()Z", "", "entries", "", "set", "(Ljava/lang/String;Ljava/lang/String;)V", "get", "(Ljava/lang/String;)Ljava/lang/String;", "append", "Lio/ktor/util/StringValues;", "stringValues", "appendAll", "(Lio/ktor/util/StringValues;)V", "appendMissing", "", "values", "(Ljava/lang/String;Ljava/lang/Iterable;)V", "remove", "(Ljava/lang/String;)V", "removeKeysWithNoEntries", "()V", "clear", "build", "()Lio/ktor/util/StringValues;", "validateName", "validateValue", "", "ensureListForKey", "Z", "getCaseInsensitiveName", "", "Ljava/util/Map;", "getValues", "()Ljava/util/Map;", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class StringValuesBuilderImpl implements StringValuesBuilder {
    private final boolean caseInsensitiveName;
    private final Map<String, List<String>> values;

    public StringValuesBuilderImpl(boolean z, int i) {
        this.caseInsensitiveName = z;
        this.values = z ? CollectionsKt.caseInsensitiveMap() : new LinkedHashMap<>(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appendAll$lambda$0(StringValuesBuilderImpl stringValuesBuilderImpl, String str, List list) {
        str.getClass();
        list.getClass();
        stringValuesBuilderImpl.appendAll(str, list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appendMissing$lambda$0(StringValuesBuilderImpl stringValuesBuilderImpl, String str, List list) {
        str.getClass();
        list.getClass();
        stringValuesBuilderImpl.appendMissing(str, list);
        return Unit.INSTANCE;
    }

    private final List<String> ensureListForKey(String name) {
        List<String> list = this.values.get(name);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        validateName(name);
        this.values.put(name, arrayList);
        return arrayList;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void append(String name, String value) {
        name.getClass();
        value.getClass();
        validateValue(value);
        ensureListForKey(name).add(value);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendAll(String name, Iterable<String> values) {
        name.getClass();
        values.getClass();
        List<String> listEnsureListForKey = ensureListForKey(name);
        Iterator<String> it = values.iterator();
        while (it.hasNext()) {
            validateValue(it.next());
        }
        CollectionsKt__MutableCollectionsKt.addAll(values, listEnsureListForKey);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendMissing(String name, Iterable<String> values) {
        name.getClass();
        values.getClass();
        List<String> list = this.values.get(name);
        Set set = list != null ? kotlin.collections.CollectionsKt.toSet(list) : EmptySet.INSTANCE;
        ArrayList arrayList = new ArrayList();
        for (String str : values) {
            if (!set.contains(str)) {
                arrayList.add(str);
            }
        }
        appendAll(name, arrayList);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public StringValues build() {
        return new StringValuesImpl(this.caseInsensitiveName, this.values);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void clear() {
        this.values.clear();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean contains(String name, String value) {
        name.getClass();
        value.getClass();
        List<String> list = this.values.get(name);
        if (list != null) {
            return list.contains(value);
        }
        return false;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set<Map.Entry<String, List<String>>> entries() {
        return CollectionsJvmKt.unmodifiable(this.values.entrySet());
    }

    @Override // io.ktor.util.StringValuesBuilder
    public String get(String name) {
        name.getClass();
        List<String> all = getAll(name);
        if (all != null) {
            return (String) kotlin.collections.CollectionsKt.firstOrNull((List) all);
        }
        return null;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public List<String> getAll(String name) {
        name.getClass();
        return this.values.get(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    public final Map<String, List<String>> getValues() {
        return this.values;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set<String> names() {
        return this.values.keySet();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean remove(String name, String value) {
        name.getClass();
        value.getClass();
        List<String> list = this.values.get(name);
        if (list != null) {
            return list.remove(value);
        }
        return false;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void removeKeysWithNoEntries() {
        Map<String, List<String>> map = this.values;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().isEmpty()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            remove((String) ((Map.Entry) it.next()).getKey());
        }
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void set(String name, String value) {
        name.getClass();
        value.getClass();
        validateValue(value);
        List<String> listEnsureListForKey = ensureListForKey(name);
        listEnsureListForKey.clear();
        listEnsureListForKey.add(value);
    }

    public void validateName(String name) {
        name.getClass();
    }

    public void validateValue(String value) {
        value.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StringValuesBuilderImpl() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public /* synthetic */ StringValuesBuilderImpl(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 8 : i);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean contains(String name) {
        name.getClass();
        return this.values.containsKey(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void remove(String name) {
        name.getClass();
        this.values.remove(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendAll(StringValues stringValues) {
        stringValues.getClass();
        stringValues.forEach(new StringValuesBuilderImpl$$ExternalSyntheticLambda0(this, (byte) 1));
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendMissing(StringValues stringValues) {
        stringValues.getClass();
        stringValues.forEach(new StringValuesBuilderImpl$$ExternalSyntheticLambda0(this, (byte) 0));
    }
}

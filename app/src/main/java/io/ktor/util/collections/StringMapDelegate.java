package io.ktor.util.collections;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\tR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lio/ktor/util/collections/StringMapDelegate;", "Lio/ktor/util/collections/StringMap;", "", "key", "value", "", "set", "(Ljava/lang/String;Ljava/lang/String;)V", "get", "(Ljava/lang/String;)Ljava/lang/String;", "remove", "", "getMap", "()Ljava/util/Map;", "map", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface StringMapDelegate extends StringMap {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String get(StringMapDelegate stringMapDelegate, String str) {
            str.getClass();
            return StringMapDelegate.super.get(str);
        }

        @Deprecated
        public static String remove(StringMapDelegate stringMapDelegate, String str) {
            str.getClass();
            return StringMapDelegate.super.remove(str);
        }

        @Deprecated
        public static void set(StringMapDelegate stringMapDelegate, String str, String str2) {
            str.getClass();
            str2.getClass();
            StringMapDelegate.super.set(str, str2);
        }
    }

    @Override // io.ktor.util.collections.StringMap
    default String get(String key) {
        key.getClass();
        return getMap().get(key);
    }

    Map<String, String> getMap();

    @Override // io.ktor.util.collections.StringMap
    default String remove(String key) {
        key.getClass();
        return getMap().remove(key);
    }

    @Override // io.ktor.util.collections.StringMap
    default void set(String key, String value) {
        key.getClass();
        value.getClass();
        getMap().put(key, value);
    }
}

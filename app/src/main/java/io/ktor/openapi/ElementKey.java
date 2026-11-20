package io.ktor.openapi;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lio/ktor/openapi/ElementKey;", "", "Root", "Property", "Lio/ktor/openapi/ElementKey$Property;", "Lio/ktor/openapi/ElementKey$Root;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ElementKey {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0083\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\u000fHÖ\u0081\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u0012\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2 = {"Lio/ktor/openapi/ElementKey$Property;", "Lio/ktor/openapi/ElementKey;", "", "key", "<init>", "(Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "copy", "(Ljava/lang/String;)Lio/ktor/openapi/ElementKey$Property;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getKey", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Property implements ElementKey {
        private final String key;

        public Property(String str) {
            str.getClass();
            this.key = str;
        }

        public static /* synthetic */ Property copy$default(Property property, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = property.key;
            }
            return property.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        public final Property copy(String key) {
            key.getClass();
            return new Property(key);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Property) && Intrinsics.areEqual(this.key, ((Property) other).key);
        }

        public final String getKey() {
            return this.key;
        }

        public int hashCode() {
            return this.key.hashCode();
        }

        public String toString() {
            return Format$$ExternalSyntheticOutline0.m(new StringBuilder("Property(key="), this.key, ')');
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/openapi/ElementKey$Root;", "Lio/ktor/openapi/ElementKey;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Root implements ElementKey {
        public static final Root INSTANCE = new Root();

        private Root() {
        }
    }
}

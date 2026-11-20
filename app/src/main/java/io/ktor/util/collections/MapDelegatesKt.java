package io.ktor.util.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a*\u0010\u0005\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0087\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a2\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0000H\u0087\u0002¢\u0006\u0004\b\t\u0010\n\u001a6\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0087\u0002¢\u0006\u0004\b\u0005\u0010\r\u001a>\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000H\u0087\u0002¢\u0006\u0004\b\t\u0010\u000e\u001a\u0019\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f*\u00020\u0000H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f*\u00020\u0000H\u0007¢\u0006\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"", "Lio/ktor/util/collections/StringMap;", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Ljava/lang/String;Lio/ktor/util/collections/StringMap;Lkotlin/reflect/KProperty;)Ljava/lang/String;", "value", "", "setValue", "(Ljava/lang/String;Lio/ktor/util/collections/StringMap;Lkotlin/reflect/KProperty;Ljava/lang/String;)V", "T", "Lio/ktor/util/collections/SerializedMapValue;", "(Lio/ktor/util/collections/SerializedMapValue;Lio/ktor/util/collections/StringMap;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "(Lio/ktor/util/collections/SerializedMapValue;Lio/ktor/util/collections/StringMap;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "", "asBoolean", "(Ljava/lang/String;)Lio/ktor/util/collections/SerializedMapValue;", "asPresenceBoolean", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MapDelegatesKt {

    /* JADX INFO: renamed from: io.ktor.util.collections.MapDelegatesKt$asBoolean$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1 {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1, StringsKt.class, "toBoolean", "toBoolean(Ljava/lang/String;)Z", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(String str) {
            str.getClass();
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
    }

    public static final SerializedMapValue<Boolean> asBoolean(String str) {
        str.getClass();
        return new SerializedMapValue<>(str, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE);
    }

    public static final SerializedMapValue<Boolean> asPresenceBoolean(String str) {
        str.getClass();
        return new SerializedMapValue<>(str, new InstantKt$$ExternalSyntheticLambda0((byte) 7), new InstantKt$$ExternalSyntheticLambda0((byte) 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String asPresenceBoolean$lambda$0(Boolean bool) {
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            return null;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean asPresenceBoolean$lambda$1(String str) {
        str.getClass();
        return Boolean.TRUE;
    }

    public static final <T> T getValue(SerializedMapValue<T> serializedMapValue, StringMap stringMap, KProperty<?> kProperty) {
        serializedMapValue.getClass();
        stringMap.getClass();
        kProperty.getClass();
        String str = stringMap.get(serializedMapValue.getKey());
        if (str != null) {
            return (T) serializedMapValue.getDeserialize().invoke(str);
        }
        return null;
    }

    public static final <T> void setValue(SerializedMapValue<T> serializedMapValue, StringMap stringMap, KProperty<?> kProperty, T t) {
        serializedMapValue.getClass();
        stringMap.getClass();
        kProperty.getClass();
        String str = t != null ? (String) serializedMapValue.getSerialize().invoke(t) : null;
        if (str == null) {
            stringMap.remove(serializedMapValue.getKey());
        } else {
            stringMap.set(serializedMapValue.getKey(), str);
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.collections.MapDelegatesKt$asBoolean$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1, Boolean.TYPE, "toString", "toString()Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Boolean) obj).booleanValue());
        }

        public final String invoke(boolean z) {
            return String.valueOf(z);
        }
    }

    public static final String getValue(String str, StringMap stringMap, KProperty<?> kProperty) {
        str.getClass();
        stringMap.getClass();
        kProperty.getClass();
        return stringMap.get(str);
    }

    public static final void setValue(String str, StringMap stringMap, KProperty<?> kProperty, String str2) {
        str.getClass();
        stringMap.getClass();
        kProperty.getClass();
        if (str2 == null) {
            stringMap.remove(str);
        } else {
            stringMap.set(str, str2);
        }
    }
}

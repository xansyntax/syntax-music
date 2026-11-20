package kotlin.jvm.internal;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KVariance;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeReference implements KType {
    public final List arguments;
    public final KClassifier classifier;
    public final int flags;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TypeReference(KClassifier kClassifier, List list, int i) {
        kClassifier.getClass();
        list.getClass();
        this.classifier = kClassifier;
        this.arguments = list;
        this.flags = i;
    }

    public final String asString(boolean z) {
        String name;
        KClassifier kClassifier = this.classifier;
        KClass kClass = kClassifier instanceof KClass ? (KClass) kClassifier : null;
        Class javaClass = kClass != null ? Okio__OkioKt.getJavaClass(kClass) : null;
        if (javaClass == null) {
            name = kClassifier.toString();
        } else if ((this.flags & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (!javaClass.isArray()) {
            name = (z && javaClass.isPrimitive()) ? Okio__OkioKt.getJavaObjectType((KClass) kClassifier).getName() : javaClass.getName();
        } else if (javaClass.equals(boolean[].class)) {
            name = "kotlin.BooleanArray";
        } else if (javaClass.equals(char[].class)) {
            name = "kotlin.CharArray";
        } else if (javaClass.equals(byte[].class)) {
            name = "kotlin.ByteArray";
        } else if (javaClass.equals(short[].class)) {
            name = "kotlin.ShortArray";
        } else if (javaClass.equals(int[].class)) {
            name = "kotlin.IntArray";
        } else if (javaClass.equals(float[].class)) {
            name = "kotlin.FloatArray";
        } else if (javaClass.equals(long[].class)) {
            name = "kotlin.LongArray";
        } else {
            name = javaClass.equals(double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
        }
        return Fragment$5$$ExternalSyntheticOutline0.m(name, this.arguments.isEmpty() ? "" : CollectionsKt.joinToString$default(this.arguments, ", ", "<", ">", new InstantKt$$ExternalSyntheticLambda0(this), 24), isMarkedNullable() ? "?" : "");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TypeReference)) {
            return false;
        }
        TypeReference typeReference = (TypeReference) obj;
        return Intrinsics.areEqual(this.classifier, typeReference.classifier) && Intrinsics.areEqual(this.arguments, typeReference.arguments) && this.flags == typeReference.flags;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public final List getAnnotations() {
        return EmptyList.INSTANCE;
    }

    @Override // kotlin.reflect.KType
    public final List getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.KType
    public final KClassifier getClassifier() {
        return this.classifier;
    }

    public final int hashCode() {
        return Integer.hashCode(this.flags) + Fragment$5$$ExternalSyntheticOutline0.m(this.classifier.hashCode() * 31, 31, this.arguments);
    }

    @Override // kotlin.reflect.KType
    public final boolean isMarkedNullable() {
        return (this.flags & 1) != 0;
    }

    public final String toString() {
        return asString(false).concat(" (Kotlin reflection is not available)");
    }
}

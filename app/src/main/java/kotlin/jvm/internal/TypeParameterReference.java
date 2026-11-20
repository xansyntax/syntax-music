package kotlin.jvm.internal;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import okio.internal.ResourceFileSystem$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeParameterReference implements KTypeParameter {
    public volatile List bounds;
    public final ClassReference container;
    public final Lazy javaContainingDeclaration$delegate;
    public final String name;
    public final KVariance variance;

    public TypeParameterReference(ClassReference classReference, KVariance kVariance) {
        kVariance.getClass();
        this.container = classReference;
        this.javaContainingDeclaration$delegate = ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ResourceFileSystem$$ExternalSyntheticLambda0((byte) 2, this));
        this.name = "PluginConfigT";
        this.variance = kVariance;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TypeParameterReference)) {
            return false;
        }
        TypeParameterReference typeParameterReference = (TypeParameterReference) obj;
        return Intrinsics.areEqual(this.name, typeParameterReference.name) && this.container.equals(typeParameterReference.container);
    }

    @Override // kotlin.reflect.KTypeParameter
    public final String getName() {
        return this.name;
    }

    @Override // kotlin.reflect.KTypeParameter
    public final List getUpperBounds() {
        List list = this.bounds;
        if (list != null) {
            return list;
        }
        List listListOf = CollectionsKt__IterablesKt.listOf(Reflection.nullableTypeOf(Object.class));
        this.bounds = listListOf;
        return listListOf;
    }

    @Override // kotlin.reflect.KTypeParameter
    public final KVariance getVariance() {
        return this.variance;
    }

    public final int hashCode() {
        return this.name.hashCode() + (this.container.hashCode() * 31);
    }

    @Override // kotlin.reflect.KTypeParameter
    public final boolean isReified() {
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i = TypeParameterReference$Companion$WhenMappings.$EnumSwitchMapping$0[getVariance().ordinal()];
        if (i != 1) {
            if (i == 2) {
                sb.append("in ");
            } else {
                if (i != 3) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                sb.append("out ");
            }
        }
        sb.append(getName());
        return sb.toString();
    }
}

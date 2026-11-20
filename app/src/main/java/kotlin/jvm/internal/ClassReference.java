package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutinesInternalError;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ClassReference implements KClass, ClassBasedDeclarationContainer, KotlinGenericDeclaration {
    public static final Map FUNCTION_CLASSES;
    public final Class jClass;

    static {
        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listListOf, 10));
        int i = 0;
        for (Object obj : listListOf) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            arrayList.add(new Pair((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        FUNCTION_CLASSES = MapsKt__MapsKt.toMap(arrayList);
    }

    public ClassReference(Class cls) {
        cls.getClass();
        this.jClass = cls;
    }

    public static void error() {
        throw new CoroutinesInternalError();
    }

    @Override // kotlin.reflect.KClass
    public final boolean equals(Object obj) {
        return (obj instanceof ClassReference) && Okio__OkioKt.getJavaObjectType(this).equals(Okio__OkioKt.getJavaObjectType((KClass) obj));
    }

    @Override // kotlin.jvm.internal.KotlinGenericDeclaration
    public final GenericDeclaration findJavaDeclaration() {
        return this.jClass;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public final List getAnnotations() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final Collection getConstructors() {
        error();
        throw null;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public final Class getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    public final Collection getMembers() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final Collection getNestedClasses() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final Object getObjectInstance() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final String getQualifiedName() {
        String strClassFqNameOf;
        Class cls = this.jClass;
        cls.getClass();
        String strConcat = null;
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return null;
        }
        if (!cls.isArray()) {
            String strClassFqNameOf2 = TypeIntrinsics.classFqNameOf(cls.getName());
            return strClassFqNameOf2 == null ? cls.getCanonicalName() : strClassFqNameOf2;
        }
        Class<?> componentType = cls.getComponentType();
        if (componentType.isPrimitive() && (strClassFqNameOf = TypeIntrinsics.classFqNameOf(componentType.getName())) != null) {
            strConcat = strClassFqNameOf.concat("Array");
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    @Override // kotlin.reflect.KClass
    public final List getSealedSubclasses() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final String getSimpleName() {
        String strSimpleNameOf;
        Class cls = this.jClass;
        cls.getClass();
        String strConcat = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (!cls.isLocalClass()) {
            if (!cls.isArray()) {
                String strSimpleNameOf2 = TypeIntrinsics.simpleNameOf(cls.getName());
                return strSimpleNameOf2 == null ? cls.getSimpleName() : strSimpleNameOf2;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (strSimpleNameOf = TypeIntrinsics.simpleNameOf(componentType.getName())) != null) {
                strConcat = strSimpleNameOf.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            return StringsKt.substringAfter(simpleName, enclosingMethod.getName() + '$', simpleName);
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            return StringsKt.substringAfter('$', simpleName, simpleName);
        }
        return StringsKt.substringAfter(simpleName, enclosingConstructor.getName() + '$', simpleName);
    }

    @Override // kotlin.reflect.KClass
    public final List getSupertypes() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final List getTypeParameters() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final KVisibility getVisibility() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final int hashCode() {
        return Okio__OkioKt.getJavaObjectType(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public final boolean isAbstract() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isCompanion() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isData() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isFinal() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isFun() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isInner() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isInstance(Object obj) {
        Class javaObjectType = this.jClass;
        javaObjectType.getClass();
        Map map = FUNCTION_CLASSES;
        map.getClass();
        Integer num = (Integer) map.get(javaObjectType);
        if (num != null) {
            return TypeIntrinsics.isFunctionOfArity(num.intValue(), obj);
        }
        if (javaObjectType.isPrimitive()) {
            javaObjectType = Okio__OkioKt.getJavaObjectType(Reflection.getOrCreateKotlinClass(javaObjectType));
        }
        return javaObjectType.isInstance(obj);
    }

    @Override // kotlin.reflect.KClass
    public final boolean isOpen() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isSealed() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public final boolean isValue() {
        error();
        throw null;
    }

    public final String toString() {
        return this.jClass.toString() + " (Kotlin reflection is not available)";
    }
}

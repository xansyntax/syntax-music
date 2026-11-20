package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CallableReference implements KCallable, Serializable, KotlinGenericDeclaration {
    public static final Object NO_RECEIVER = NoReceiver.INSTANCE;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient KCallable reflected;
    private final String signature;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class NoReceiver implements Serializable {
        public static final NoReceiver INSTANCE = new NoReceiver();
    }

    public CallableReference(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    @Override // kotlin.reflect.KCallable
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // kotlin.reflect.KCallable
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public KCallable compute() {
        KCallable kCallable = this.reflected;
        if (kCallable != null) {
            return kCallable;
        }
        KCallable kCallableComputeReflected = computeReflected();
        this.reflected = kCallableComputeReflected;
        return kCallableComputeReflected;
    }

    public KCallable computeReflected() {
        Reflection.factory.getClass();
        return this;
    }

    @Override // kotlin.jvm.internal.KotlinGenericDeclaration
    public GenericDeclaration findJavaDeclaration() {
        KDeclarationContainer owner = getOwner();
        String signature = getSignature();
        signature.getClass();
        if (!(owner instanceof ClassBasedDeclarationContainer)) {
            return null;
        }
        String strSubstringBefore$default = StringsKt.substringBefore$default(signature, '(');
        if (strSubstringBefore$default.equals("<init>")) {
            throw new UnsupportedOperationException("Generic Java constructors are not supported: " + owner + '/' + signature);
        }
        Method[] declaredMethods = ((ClassBasedDeclarationContainer) owner).getJClass().getDeclaredMethods();
        declaredMethods.getClass();
        for (Method method : declaredMethods) {
            if (Intrinsics.areEqual(method.getName(), strSubstringBefore$default)) {
                StringBuilder sb = new StringBuilder();
                sb.append(method.getName());
                sb.append("(");
                Class<?>[] parameterTypes = method.getParameterTypes();
                parameterTypes.getClass();
                for (Class<?> cls : parameterTypes) {
                    cls.getClass();
                    Intrinsics.Kotlin.appendClass(sb, cls);
                }
                sb.append(")");
                Class<?> returnType = method.getReturnType();
                returnType.getClass();
                Intrinsics.Kotlin.appendClass(sb, returnType);
                if (sb.toString().equals(signature)) {
                    return method;
                }
            }
        }
        return null;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.name;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (!this.isTopLevel) {
            return Reflection.getOrCreateKotlinClass(cls);
        }
        Reflection.factory.getClass();
        return new PackageReference(cls);
    }

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        return getReflected().getParameters();
    }

    public abstract KCallable getReflected();

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}

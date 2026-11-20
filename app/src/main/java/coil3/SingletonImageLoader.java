package coil3;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SingletonImageLoader {
    public static final /* synthetic */ AtomicReference reference = new AtomicReference(null);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Factory {
        RealImageLoader newImageLoader(Context context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final RealImageLoader get(Context context) {
        RealImageLoader realImageLoader;
        RealImageLoader realImageLoader2;
        Factory factory;
        Factory factory2;
        Factory factory3;
        Factory factory4;
        AtomicReference atomicReference = reference;
        Object obj = atomicReference.get();
        RealImageLoader realImageLoader3 = obj instanceof RealImageLoader ? (RealImageLoader) obj : null;
        if (realImageLoader3 != null) {
            return realImageLoader3;
        }
        RealImageLoader realImageLoaderNewImageLoader = null;
        while (true) {
            Object obj2 = atomicReference.get();
            if (obj2 instanceof RealImageLoader) {
                realImageLoader = (RealImageLoader) obj2;
                realImageLoader2 = realImageLoaderNewImageLoader;
            } else {
                if (realImageLoaderNewImageLoader == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (obj2 instanceof Factory) {
                        factory4 = (Factory) obj2;
                    } else {
                        factory = null;
                    }
                    if (factory != null) {
                        factory = factory4;
                        realImageLoaderNewImageLoader = factory.newImageLoader(applicationContext);
                    } else {
                        if (applicationContext instanceof Factory) {
                            factory3 = (Factory) applicationContext;
                        } else {
                            factory2 = null;
                        }
                        if (factory2 != null) {
                            factory = factory4;
                            factory = factory4;
                            factory2 = factory3;
                            realImageLoaderNewImageLoader = factory2.newImageLoader(applicationContext);
                        } else {
                            factory = factory4;
                            factory = factory4;
                            factory2 = factory3;
                            realImageLoaderNewImageLoader = SingletonImageLoaderKt.DefaultSingletonImageLoaderFactory.newImageLoader(applicationContext);
                        }
                    }
                }
                realImageLoader = realImageLoaderNewImageLoader;
                realImageLoader2 = realImageLoader;
            }
            while (!atomicReference.compareAndSet(obj2, realImageLoader)) {
                if (atomicReference.get() != obj2) {
                    realImageLoaderNewImageLoader = realImageLoader2;
                }
            }
            return realImageLoader;
        }
    }
}

package kotlinx.serialization.modules;

import kotlin.reflect.KClass;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SerializersModule {
    public static void getContextual$default(SerializersModule serializersModule, KClass kClass) {
        ((SerialModuleImpl) serializersModule).getClass();
        kClass.getClass();
    }
}

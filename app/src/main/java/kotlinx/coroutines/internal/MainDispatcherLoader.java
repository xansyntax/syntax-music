package kotlinx.coroutines.internal;

import android.os.Looper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.android.AndroidDispatcherFactory;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MainDispatcherLoader {
    public static final HandlerContext dispatcher;

    static {
        String property;
        int i = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        Object next = null;
        try {
            property = System.getProperty("kotlinx.coroutines.fast.service.loader");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null) {
            Boolean.parseBoolean(property);
        }
        try {
            Iterator it = SequencesKt.toList(SequencesKt.asSequence(Arrays.asList(new AndroidDispatcherFactory()).iterator())).iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    ((AndroidDispatcherFactory) next).getClass();
                    do {
                        ((AndroidDispatcherFactory) it.next()).getClass();
                    } while (it.hasNext());
                }
            }
            if (((AndroidDispatcherFactory) next) == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
                return;
            }
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                dispatcher = new HandlerContext(HandlerDispatcherKt.asHandler(mainLooper));
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("The main looper is not available");
            }
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}

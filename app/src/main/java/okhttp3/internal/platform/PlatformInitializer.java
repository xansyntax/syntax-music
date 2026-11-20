package okhttp3.internal.platform;

import android.content.Context;
import androidx.startup.Initializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/platform/PlatformInitializer;", "Landroidx/startup/Initializer;", "Lokhttp3/internal/platform/Platform;", "<init>", "()V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlatformInitializer implements Initializer {
    @Override // androidx.startup.Initializer
    public final Object create(Context context) {
        context.getClass();
        Platform platform = Platform.platform;
        Object obj = Platform.platform;
        ContextAwarePlatform contextAwarePlatform = obj != null ? (ContextAwarePlatform) obj : null;
        if (contextAwarePlatform != null) {
            contextAwarePlatform.setApplicationContext(context);
        }
        return Platform.platform;
    }

    @Override // androidx.startup.Initializer
    public final List dependencies() {
        return EmptyList.INSTANCE;
    }
}

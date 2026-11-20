package androidx.datastore.preferences;

import android.content.Context;
import androidx.collection.internal.Lock;
import androidx.datastore.core.AtomicInt;
import androidx.datastore.core.DataStoreImpl;
import androidx.datastore.core.FileStorage;
import com.metrolist.music.App$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.component.PlayingIndicatorKt$PlayingIndicator$1$1;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Handshake$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceDataStoreSingletonDelegate implements ReadOnlyProperty {
    public volatile AtomicInt INSTANCE;
    public final Object lock = new Object();
    public final Function1 produceMigrations;
    public final CoroutineScope scope;

    public PreferenceDataStoreSingletonDelegate(Function1 function1, CoroutineScope coroutineScope) {
        this.produceMigrations = function1;
        this.scope = coroutineScope;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object obj, KProperty kProperty) {
        AtomicInt atomicInt;
        Context context = (Context) obj;
        AtomicInt atomicInt2 = this.INSTANCE;
        if (atomicInt2 != null) {
            return atomicInt2;
        }
        synchronized (this.lock) {
            try {
                if (this.INSTANCE == null) {
                    Context applicationContext = context.getApplicationContext();
                    Function1 function1 = this.produceMigrations;
                    applicationContext.getClass();
                    List list = (List) function1.invoke(applicationContext);
                    CoroutineScope coroutineScope = this.scope;
                    App$$ExternalSyntheticLambda0 app$$ExternalSyntheticLambda0 = new App$$ExternalSyntheticLambda0(applicationContext, this);
                    list.getClass();
                    this.INSTANCE = new AtomicInt(new AtomicInt(new DataStoreImpl(new FileStorage(new Handshake$$ExternalSyntheticLambda0(app$$ExternalSyntheticLambda0, (byte) 7)), CollectionsKt__IterablesKt.listOf(new PlayingIndicatorKt$PlayingIndicator$1$1(list, null, (byte) 1)), new Lock((byte) 12), coroutineScope)));
                }
                atomicInt = this.INSTANCE;
                atomicInt.getClass();
            } catch (Throwable th) {
                throw th;
            }
        }
        return atomicInt;
    }
}

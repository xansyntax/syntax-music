package androidx.navigation;

import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import coil3.network.NetworkHeaders;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavControllerViewModelKt {
    public static final InitializerViewModelFactory FACTORY;

    static {
        NetworkHeaders.Builder builder = new NetworkHeaders.Builder((byte) 2);
        builder.addInitializer(Reflection.getOrCreateKotlinClass(NavControllerViewModel.class), new RoomDatabase$$ExternalSyntheticLambda2((byte) 6));
        FACTORY = builder.build();
    }
}

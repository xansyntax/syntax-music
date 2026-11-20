package coil3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.disk.RealDiskCache;
import coil3.disk.UtilsKt;
import coil3.disk.UtilsKt$$ExternalSyntheticLambda0;
import coil3.network.NetworkFetcher;
import coil3.network.okhttp.internal.OkHttpNetworkFetcherServiceLoaderTarget;
import coil3.util.ServiceLoaderComponentRegistry;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RealImageLoaderKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ RealImageLoaderKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object[] objArr = 0;
        switch (this.$r8$classId) {
            case 0:
                List list = (List) ServiceLoaderComponentRegistry.fetchers$delegate.getValue();
                final Object[] objArr2 = objArr == true ? 1 : 0;
                List listSortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: coil3.RealImageLoaderKt$addServiceLoaderComponents$lambda$0$$inlined$sortedByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        switch (objArr2) {
                            case 0:
                                ((OkHttpNetworkFetcherServiceLoaderTarget) obj2).getClass();
                                Integer num = 2;
                                ((OkHttpNetworkFetcherServiceLoaderTarget) obj).getClass();
                                return num.compareTo(num);
                            default:
                                throw IntIntPair$$ExternalSyntheticOutline0.m(obj2);
                        }
                    }
                });
                ArrayList arrayList = new ArrayList();
                int size = listSortedWith.size();
                for (int i = 0; i < size; i++) {
                    ((OkHttpNetworkFetcherServiceLoaderTarget) listSortedWith.get(i)).getClass();
                    arrayList.add(new Pair(new NetworkFetcher.Factory(new UtilsKt$$ExternalSyntheticLambda0((byte) 22)), Reflection.getOrCreateKotlinClass(Uri.class)));
                }
                return arrayList;
            case 1:
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                return MainDispatcherLoader.dispatcher.immediate;
            case 2:
                return (RealDiskCache) UtilsKt.instance$delegate.getValue();
            default:
                final byte b = 1;
                List listSortedWith2 = CollectionsKt.sortedWith((List) ServiceLoaderComponentRegistry.decoders$delegate.getValue(), new Comparator() { // from class: coil3.RealImageLoaderKt$addServiceLoaderComponents$lambda$0$$inlined$sortedByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        switch (b) {
                            case 0:
                                ((OkHttpNetworkFetcherServiceLoaderTarget) obj2).getClass();
                                Integer num = 2;
                                ((OkHttpNetworkFetcherServiceLoaderTarget) obj).getClass();
                                return num.compareTo(num);
                            default:
                                throw IntIntPair$$ExternalSyntheticOutline0.m(obj2);
                        }
                    }
                });
                ArrayList arrayList2 = new ArrayList();
                if (listSortedWith2.size() <= 0) {
                    return arrayList2;
                }
                listSortedWith2.get(0).getClass();
                PathKt$$ExternalSyntheticBUOutline0.m();
                return null;
        }
    }
}

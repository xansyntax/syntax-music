package coil3;

import java.util.ArrayList;
import java.util.List;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentRegistry {
    public final SynchronizedLazyImpl decoderFactories$delegate;
    public final SynchronizedLazyImpl fetcherFactories$delegate;
    public final List interceptors;
    public final List keyers;
    public List lazyDecoderFactories;
    public List lazyFetcherFactories;
    public final List mappers;

    public ComponentRegistry(List list, List list2, List list3, List list4, List list5) {
        this.interceptors = list;
        this.mappers = list2;
        this.keyers = list3;
        this.lazyFetcherFactories = list4;
        this.lazyDecoderFactories = list5;
        final byte b = 0;
        this.fetcherFactories$delegate = new SynchronizedLazyImpl(new Function0(this) { // from class: coil3.ComponentRegistry$$ExternalSyntheticLambda0
            public final /* synthetic */ ComponentRegistry f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b2 = b;
                EmptyList emptyList = EmptyList.INSTANCE;
                int i = 0;
                ComponentRegistry componentRegistry = this.f$0;
                switch (b2) {
                    case 0:
                        List list6 = componentRegistry.lazyFetcherFactories;
                        ArrayList arrayList = new ArrayList();
                        int size = list6.size();
                        while (i < size) {
                            CollectionsKt__MutableCollectionsKt.addAll((List) ((Function0) list6.get(i)).invoke(), arrayList);
                            i++;
                        }
                        componentRegistry.lazyFetcherFactories = emptyList;
                        return arrayList;
                    default:
                        List list7 = componentRegistry.lazyDecoderFactories;
                        ArrayList arrayList2 = new ArrayList();
                        int size2 = list7.size();
                        while (i < size2) {
                            CollectionsKt__MutableCollectionsKt.addAll((List) ((Function0) list7.get(i)).invoke(), arrayList2);
                            i++;
                        }
                        componentRegistry.lazyDecoderFactories = emptyList;
                        return arrayList2;
                }
            }
        });
        final byte b2 = 1;
        this.decoderFactories$delegate = new SynchronizedLazyImpl(new Function0(this) { // from class: coil3.ComponentRegistry$$ExternalSyntheticLambda0
            public final /* synthetic */ ComponentRegistry f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b3 = b2;
                EmptyList emptyList = EmptyList.INSTANCE;
                int i = 0;
                ComponentRegistry componentRegistry = this.f$0;
                switch (b3) {
                    case 0:
                        List list6 = componentRegistry.lazyFetcherFactories;
                        ArrayList arrayList = new ArrayList();
                        int size = list6.size();
                        while (i < size) {
                            CollectionsKt__MutableCollectionsKt.addAll((List) ((Function0) list6.get(i)).invoke(), arrayList);
                            i++;
                        }
                        componentRegistry.lazyFetcherFactories = emptyList;
                        return arrayList;
                    default:
                        List list7 = componentRegistry.lazyDecoderFactories;
                        ArrayList arrayList2 = new ArrayList();
                        int size2 = list7.size();
                        while (i < size2) {
                            CollectionsKt__MutableCollectionsKt.addAll((List) ((Function0) list7.get(i)).invoke(), arrayList2);
                            i++;
                        }
                        componentRegistry.lazyDecoderFactories = emptyList;
                        return arrayList2;
                }
            }
        });
    }
}

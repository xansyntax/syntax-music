package androidx.core.view;

import android.os.Build;
import android.view.ScrollFeedbackProvider;
import androidx.collection.internal.Lock;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollFeedbackProviderCompat {
    public final ScrollFeedbackProviderImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ScrollFeedbackProviderApi35Impl implements ScrollFeedbackProviderImpl {
        public final ScrollFeedbackProvider mProvider;

        public ScrollFeedbackProviderApi35Impl(NestedScrollView nestedScrollView) {
            this.mProvider = ScrollFeedbackProvider.createProvider(nestedScrollView);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public final void onScrollLimit(int i, int i2, int i3, boolean z) {
            this.mProvider.onScrollLimit(i, i2, i3, z);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public final void onScrollProgress(int i, int i2, int i3, int i4) {
            this.mProvider.onScrollProgress(i, i2, i3, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ScrollFeedbackProviderImpl {
        void onScrollLimit(int i, int i2, int i3, boolean z);

        void onScrollProgress(int i, int i2, int i3, int i4);
    }

    public ScrollFeedbackProviderCompat(NestedScrollView nestedScrollView) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.mImpl = new ScrollFeedbackProviderApi35Impl(nestedScrollView);
        } else {
            this.mImpl = new Lock((byte) 11);
        }
    }
}

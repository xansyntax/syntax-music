package androidx.compose.ui.viewinterop;

import android.os.Parcelable;
import android.util.SparseArray;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidViewHolder$$ExternalSyntheticLambda7 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ViewFactoryHolder f$0;

    public /* synthetic */ AndroidViewHolder$$ExternalSyntheticLambda7(ViewFactoryHolder viewFactoryHolder, byte b) {
        this.$r8$classId = b;
        this.f$0 = viewFactoryHolder;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ViewFactoryHolder viewFactoryHolder = this.f$0;
        switch (b) {
            case 0:
                AndroidViewHolder.runUpdate$lambda$0(viewFactoryHolder);
                return unit;
            case 1:
                viewFactoryHolder.layoutNode.invalidateLayer$ui();
                return unit;
            case 2:
                SparseArray<Parcelable> sparseArray = new SparseArray<>();
                viewFactoryHolder.typedView.saveHierarchyState(sparseArray);
                return sparseArray;
            case 3:
                ViewFactoryHolder._set_releaseBlock_$lambda$0(viewFactoryHolder);
                return unit;
            case 4:
                viewFactoryHolder.resetBlock.invoke(viewFactoryHolder.typedView);
                return unit;
            default:
                viewFactoryHolder.updateBlock.invoke(viewFactoryHolder.typedView);
                return unit;
        }
    }
}

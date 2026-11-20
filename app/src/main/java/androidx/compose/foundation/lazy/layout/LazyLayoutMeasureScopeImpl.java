package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutMeasureScopeImpl implements MeasureScope {
    public final LazyLayoutItemContentFactory itemContentFactory;
    public final LazyLayoutItemProvider itemProvider;
    public final MutableIntObjectMap measurablesCache;
    public final SubcomposeMeasureScope subcomposeMeasureScope;

    public LazyLayoutMeasureScopeImpl(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeMeasureScope subcomposeMeasureScope) {
        this.itemContentFactory = lazyLayoutItemContentFactory;
        this.subcomposeMeasureScope = subcomposeMeasureScope;
        this.itemProvider = (LazyLayoutItemProvider) lazyLayoutItemContentFactory.itemProvider.invoke();
        IntObjectMapKt.mutableIntObjectMapOf();
        this.measurablesCache = new MutableIntObjectMap();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final List compose(int i) {
        MutableIntObjectMap mutableIntObjectMap = this.measurablesCache;
        List list = (List) mutableIntObjectMap.get(i);
        if (list != null) {
            return list;
        }
        LazyLayoutItemProvider lazyLayoutItemProvider = this.itemProvider;
        Object key = lazyLayoutItemProvider.getKey(i);
        List listSubcompose = this.subcomposeMeasureScope.subcompose(key, this.itemContentFactory.getContent(i, key, lazyLayoutItemProvider.getContentType(i)));
        mutableIntObjectMap.set(i, listSubcompose);
        return listSubcompose;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.subcomposeMeasureScope.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.subcomposeMeasureScope.getFontScale();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public final LayoutDirection getLayoutDirection() {
        return this.subcomposeMeasureScope.getLayoutDirection();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public final boolean isLookingAhead() {
        return this.subcomposeMeasureScope.isLookingAhead();
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public final MeasureResult layout(int i, int i2, Map map, Function1 function1) {
        return this.subcomposeMeasureScope.layout(i, i2, map, function1);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public final int mo74roundToPxR2X_6o(long j) {
        return this.subcomposeMeasureScope.mo74roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public final int mo75roundToPx0680j_4(float f) {
        return this.subcomposeMeasureScope.mo75roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public final float mo76toDpGaN1DYA(long j) {
        return this.subcomposeMeasureScope.mo76toDpGaN1DYA(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo78toDpu2uoSUM(int i) {
        return this.subcomposeMeasureScope.mo78toDpu2uoSUM(i);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public final long mo79toDpSizekrfVVM(long j) {
        return this.subcomposeMeasureScope.mo79toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public final float mo80toPxR2X_6o(long j) {
        return this.subcomposeMeasureScope.mo80toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public final float mo81toPx0680j_4(float f) {
        return this.subcomposeMeasureScope.mo81toPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public final long mo82toSizeXkaWNTQ(long j) {
        return this.subcomposeMeasureScope.mo82toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public final long mo83toSp0xMU5do(float f) {
        return this.subcomposeMeasureScope.mo83toSp0xMU5do(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final long mo84toSpkPz2Gy4(float f) {
        return this.subcomposeMeasureScope.mo84toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public final MeasureResult layout(int i, int i2, Map map, Function1 function1, Function1 function2) {
        return this.subcomposeMeasureScope.layout(i, i2, map, function1, function2);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo77toDpu2uoSUM(float f) {
        return this.subcomposeMeasureScope.mo77toDpu2uoSUM(f);
    }
}

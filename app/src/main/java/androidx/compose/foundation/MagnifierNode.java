package androidx.compose.foundation;

import android.view.View;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda8;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import coil3.size.SizeKt;
import com.metrolist.music.viewmodels.ArtistViewModel;
import dagger.hilt.EntryPoints;
import kotlin.Unit;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferedChannel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MagnifierNode extends Modifier.Node implements GlobalPositionAwareModifierNode, DrawModifierNode, SemanticsModifierNode, ObserverModifierNode {
    public DerivedSnapshotState anchorPositionInRootState;
    public Density density;
    public BufferedChannel drawSignalChannel;
    public PlatformMagnifier magnifier;
    public TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4 onSizeChanged;
    public PlatformMagnifierFactory platformMagnifierFactory;
    public IntSize previousSize;
    public AppBarKt$$ExternalSyntheticLambda8 sourceCenter;
    public View view;
    public float zoom = Float.NaN;
    public boolean useTextDefault = true;
    public long size = 9205357640488583168L;
    public float cornerRadius = Float.NaN;
    public float elevation = Float.NaN;
    public boolean clippingEnabled = true;
    public final ParcelableSnapshotMutableState layoutCoordinates$delegate = new ParcelableSnapshotMutableState(null, NeverEqualPolicy.INSTANCE);
    public long sourceCenterInRoot = 9205357640488583168L;

    public MagnifierNode(AppBarKt$$ExternalSyntheticLambda8 appBarKt$$ExternalSyntheticLambda8, TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4 textFieldSelectionManager_androidKt$$ExternalSyntheticLambda4, PlatformMagnifierFactory platformMagnifierFactory) {
        this.sourceCenter = appBarKt$$ExternalSyntheticLambda8;
        this.onSizeChanged = textFieldSelectionManager_androidKt$$ExternalSyntheticLambda4;
        this.platformMagnifierFactory = platformMagnifierFactory;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(Magnifier_androidKt.MagnifierPositionInRoot, new MagnifierNode$$ExternalSyntheticLambda0(this, (byte) 1));
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        layoutNodeDrawScope.drawContent();
        BufferedChannel bufferedChannel = this.drawSignalChannel;
        if (bufferedChannel != null) {
            bufferedChannel.mo1712trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: getAnchorPositionInRoot-F1C5BW0, reason: not valid java name */
    public final long m51getAnchorPositionInRootF1C5BW0() {
        DerivedSnapshotState derivedSnapshotStateDerivedStateOf = this.anchorPositionInRootState;
        if (derivedSnapshotStateDerivedStateOf == null) {
            derivedSnapshotStateDerivedStateOf = SnapshotStateKt__DerivedStateKt.derivedStateOf(new MagnifierNode$$ExternalSyntheticLambda0(this, (byte) 2));
            this.anchorPositionInRootState = derivedSnapshotStateDerivedStateOf;
        }
        return ((Offset) derivedSnapshotStateDerivedStateOf.getValue()).packedValue;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        onObservedReadsChanged();
        this.drawSignalChannel = EntryPoints.Channel$default(0, 7, null);
        AwaitKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new ArtistViewModel.AnonymousClass1(this, null, (byte) 1), 1);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            ((PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl) platformMagnifier).dismiss();
        }
        this.magnifier = null;
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        this.layoutCoordinates$delegate.setValue(nodeCoordinator);
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        HitTestResultKt.observeReads(this, new MagnifierNode$$ExternalSyntheticLambda0(this, (byte) 0));
    }

    public final void recreateMagnifier() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            ((PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl) platformMagnifier).dismiss();
        }
        View viewRequireView = this.view;
        if (viewRequireView == null) {
            viewRequireView = HitTestResultKt.requireView(this);
        }
        View view = viewRequireView;
        this.view = view;
        Density density = this.density;
        if (density == null) {
            density = HitTestResultKt.requireLayoutNode(this).density;
        }
        Density density2 = density;
        this.density = density2;
        this.magnifier = this.platformMagnifierFactory.mo54createnHHXs2Y(view, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, density2, this.zoom);
        updateSizeIfNecessary();
    }

    public final void updateMagnifier() {
        Density density = this.density;
        if (density == null) {
            density = HitTestResultKt.requireLayoutNode(this).density;
            this.density = density;
        }
        long j = ((Offset) this.sourceCenter.invoke(density)).packedValue;
        if ((j & 9223372034707292159L) == 9205357640488583168L || (9223372034707292159L & m51getAnchorPositionInRootF1C5BW0()) == 9205357640488583168L) {
            this.sourceCenterInRoot = 9205357640488583168L;
            PlatformMagnifier platformMagnifier = this.magnifier;
            if (platformMagnifier != null) {
                ((PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl) platformMagnifier).dismiss();
                return;
            }
            return;
        }
        this.sourceCenterInRoot = Offset.m439plusMKHz9U(m51getAnchorPositionInRootF1C5BW0(), j);
        if (this.magnifier == null) {
            recreateMagnifier();
        }
        PlatformMagnifier platformMagnifier2 = this.magnifier;
        if (platformMagnifier2 != null) {
            platformMagnifier2.mo53updateWko1d7g(this.sourceCenterInRoot, 9205357640488583168L, this.zoom);
        }
        updateSizeIfNecessary();
    }

    public final void updateSizeIfNecessary() {
        Density density;
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier == null || (density = this.density) == null) {
            return;
        }
        PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl platformMagnifierImpl = (PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl) platformMagnifier;
        long jM55getSizeYbymL2g = platformMagnifierImpl.m55getSizeYbymL2g();
        IntSize intSize = this.previousSize;
        if (intSize != null && jM55getSizeYbymL2g == intSize.packedValue) {
            return;
        }
        TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4 textFieldSelectionManager_androidKt$$ExternalSyntheticLambda4 = this.onSizeChanged;
        if (textFieldSelectionManager_androidKt$$ExternalSyntheticLambda4 != null) {
            long jMo79toDpSizekrfVVM = density.mo79toDpSizekrfVVM(SizeKt.m876toSizeozmzZPI(platformMagnifierImpl.m55getSizeYbymL2g()));
            Density density2 = textFieldSelectionManager_androidKt$$ExternalSyntheticLambda4.f$0;
            textFieldSelectionManager_androidKt$$ExternalSyntheticLambda4.f$1.setValue(new IntSize((((long) density2.mo75roundToPx0680j_4(DpSize.m802getWidthD9Ej5fM(jMo79toDpSizekrfVVM))) << 32) | (((long) density2.mo75roundToPx0680j_4(DpSize.m801getHeightD9Ej5fM(jMo79toDpSizekrfVVM))) & 4294967295L)));
        }
        this.previousSize = new IntSize(platformMagnifierImpl.m55getSizeYbymL2g());
    }
}

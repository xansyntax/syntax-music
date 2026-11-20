package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1$1;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.ui.draw.CacheDrawModifierNodeImpl;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.unit.Dp;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IndicatorLineNode extends DelegatingNode implements CompositionLocalConsumerModifierNode {
    public TextFieldColors _colors;
    public Shape _shape;
    public Animatable colorAnimatable;
    public final CacheDrawModifierNodeImpl drawWithCacheModifierNode;
    public boolean enabled;
    public boolean focused;
    public InteractionSource interactionSource;
    public StandaloneCoroutine trackFocusStateJob;
    public final Animatable widthAnimatable;
    public float focusedIndicatorWidth = 2.0f;
    public float unfocusedIndicatorWidth = 1.0f;

    public IndicatorLineNode(boolean z, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape) {
        this.enabled = z;
        this.interactionSource = interactionSource;
        this._colors = textFieldColors;
        this._shape = shape;
        this.widthAnimatable = new Animatable(new Dp((this.focused && z) ? 2.0f : 1.0f), ArcSplineKt.DpToVector, (Object) null, 12);
        CacheDrawModifierNodeImpl cacheDrawModifierNodeImpl = new CacheDrawModifierNodeImpl(new CacheDrawScope(), new TextKt$$ExternalSyntheticLambda2((byte) 3, this));
        delegate(cacheDrawModifierNodeImpl);
        this.drawWithCacheModifierNode = cacheDrawModifierNodeImpl;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    public final void invalidateIndicator() {
        Continuation continuation = null;
        AwaitKt.launch$default(getCoroutineScope(), null, null, new IndicatorLineNode$update$1(this, continuation, (byte) 1), 3);
        AwaitKt.launch$default(getCoroutineScope(), null, null, new IndicatorLineNode$update$1(this, continuation, (byte) 2), 3);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        this.trackFocusStateJob = AwaitKt.launch$default(getCoroutineScope(), null, null, new IndicatorLineNode$update$1(this, null, (byte) 3), 3);
        if (this.colorAnimatable == null) {
            TextFieldColors textFieldColorsDefaultTextFieldColors$material3 = this._colors;
            if (textFieldColorsDefaultTextFieldColors$material3 == null) {
                textFieldColorsDefaultTextFieldColors$material3 = TextFieldDefaults.defaultTextFieldColors$material3(((MaterialTheme$Values) HitTestResultKt.currentValueOf(this, MaterialThemeKt._localMaterialTheme)).colorScheme, (TextSelectionColors) HitTestResultKt.currentValueOf(this, TextSelectionColorsKt.LocalTextSelectionColors));
            }
            long jM345indicatorColorXeAY9LY = textFieldColorsDefaultTextFieldColors$material3.m345indicatorColorXeAY9LY(this.enabled, this.focused);
            this.colorAnimatable = new Animatable(new Color(jM345indicatorColorXeAY9LY), new TwoWayConverterImpl(ColorVectorConverterKt$ColorToVector$1$1.INSTANCE, new CallsKt$await$2$1((byte) 1, Color.m483getColorSpaceimpl(jM345indicatorColorXeAY9LY))), (Object) null, 12);
        }
    }

    public final Object trackFocusState(SuspendLambda suspendLambda) {
        this.focused = false;
        Object objCollect = this.interactionSource.getInteractions().collect(new ThumbNode$onAttach$1$1(new ArrayList(), this, (byte) 1), suspendLambda);
        return objCollect == CoroutineSingletons.COROUTINE_SUSPENDED ? objCollect : Unit.INSTANCE;
    }
}

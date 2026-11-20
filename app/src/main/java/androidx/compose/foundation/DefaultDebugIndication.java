package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.view.CropImageView;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultDebugIndication implements IndicationNodeFactory {
    public static final DefaultDebugIndication INSTANCE = new DefaultDebugIndication();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DefaultDebugIndicationInstance extends Modifier.Node implements DrawModifierNode {
        public final InteractionSource interactionSource;
        public boolean isFocused;
        public boolean isHovered;
        public boolean isPressed;

        public DefaultDebugIndicationInstance(InteractionSource interactionSource) {
            this.interactionSource = interactionSource;
        }

        @Override // androidx.compose.ui.node.DrawModifierNode
        public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
            layoutNodeDrawScope.drawContent();
            CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
            if (this.isPressed) {
                DrawScope.m550drawRectnJ9OG0$default(layoutNodeDrawScope, ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), 0.3f, Color.m483getColorSpaceimpl(-72057594037927936L)), 0L, canvasDrawScope.mo556getSizeNHjbRc(), CropImageView.DEFAULT_ASPECT_RATIO, 0, 122);
            } else if (this.isHovered || this.isFocused) {
                DrawScope.m550drawRectnJ9OG0$default(layoutNodeDrawScope, ColorKt.Color(Color.m485getRedimpl(-72057594037927936L), Color.m484getGreenimpl(-72057594037927936L), Color.m482getBlueimpl(-72057594037927936L), 0.1f, Color.m483getColorSpaceimpl(-72057594037927936L)), 0L, canvasDrawScope.mo556getSizeNHjbRc(), CropImageView.DEFAULT_ASPECT_RATIO, 0, 122);
            }
        }

        @Override // androidx.compose.ui.Modifier.Node
        public final void onAttach() {
            AwaitKt.launch$default(getCoroutineScope(), null, null, new SyncUtils.AnonymousClass2(this, null, (byte) 2), 3);
        }
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public final DelegatableNode create(InteractionSource interactionSource) {
        return new DefaultDebugIndicationInstance(interactionSource);
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public final int hashCode() {
        return -1;
    }
}

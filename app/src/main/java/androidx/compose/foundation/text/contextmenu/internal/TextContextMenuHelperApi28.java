package androidx.compose.foundation.text.contextmenu.internal;

import android.app.RemoteAction;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.textclassifier.TextClassification;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextContextMenuHelperApi28 {
    public static final TextContextMenuHelperApi28 INSTANCE = new TextContextMenuHelperApi28();

    public static void textClassificationItem(ContextMenuScope contextMenuScope, Context context, TextContextMenuTextClassificationItem textContextMenuTextClassificationItem) {
        if (context == null) {
            return;
        }
        int i = textContextMenuTextClassificationItem.index;
        TextClassification textClassification = textContextMenuTextClassificationItem.textClassification;
        Drawable drawable = textContextMenuTextClassificationItem.icon;
        if (i < 0) {
            ContextMenuScope.item$default(contextMenuScope, new ComposerKt$$ExternalSyntheticLambda0((byte) 11, textClassification), drawable != null ? new ComposableLambdaImpl(true, -1123224187, new TextContextMenuHelperApi28$textClassificationItem$2$1((byte) 0, drawable)) : null, new Recomposer$$ExternalSyntheticLambda6(context, textClassification, (byte) 15), 6);
        } else {
            RemoteAction remoteAction = textClassification.getActions().get(i);
            ContextMenuScope.item$default(contextMenuScope, new ComposerKt$$ExternalSyntheticLambda0((byte) 12, remoteAction), drawable != null ? new ComposableLambdaImpl(true, 1106162332, new TextContextMenuHelperApi28$textClassificationItem$2$1((byte) 1, drawable)) : null, new SliderState$$ExternalSyntheticLambda0((byte) 18, remoteAction), 6);
        }
    }

    public final void IconBox(Drawable drawable, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(257732500);
        int i2 = (gapComposer.changedInstance(drawable) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, ContextMenuSpec.IconSize);
            boolean zChangedInstance = gapComposer.changedInstance(drawable);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new ScrollState$$ExternalSyntheticLambda0((byte) 23, drawable);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            BoxKt.Box(ClipKt.drawBehind(modifierM151size3ABfNKs, (Function1) objRememberedValue), gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda1(this, drawable, i, (byte) 15);
        }
    }
}

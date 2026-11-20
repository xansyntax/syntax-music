package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda6;
import androidx.emoji2.text.EmojiProcessor;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewFactoryHolder extends AndroidViewHolder {
    public final NestedScrollDispatcher dispatcher;
    public Function1 releaseBlock;
    public Function1 resetBlock;
    public SaveableStateRegistry.Entry savableRegistryEntry;
    public final View typedView;
    public Function1 updateBlock;

    public ViewFactoryHolder(Context context, Function1 function1, GapComposer.CompositionContextImpl compositionContextImpl, SaveableStateRegistry saveableStateRegistry, int i, Owner owner) {
        View view = (View) function1.invoke(context);
        NestedScrollDispatcher nestedScrollDispatcher = new NestedScrollDispatcher();
        super(context, compositionContextImpl, i, nestedScrollDispatcher, view, owner);
        this.typedView = view;
        this.dispatcher = nestedScrollDispatcher;
        setClipChildren(false);
        String strValueOf = String.valueOf(i);
        Object objConsumeRestored = saveableStateRegistry != null ? saveableStateRegistry.consumeRestored(strValueOf) : null;
        SparseArray<Parcelable> sparseArray = objConsumeRestored instanceof SparseArray ? (SparseArray) objConsumeRestored : null;
        if (sparseArray != null) {
            view.restoreHierarchyState(sparseArray);
        }
        if (saveableStateRegistry != null) {
            setSavableRegistryEntry(saveableStateRegistry.registerProvider(strValueOf, new AndroidViewHolder$$ExternalSyntheticLambda7(this, (byte) 2)));
        }
        SaversKt$$ExternalSyntheticLambda6 saversKt$$ExternalSyntheticLambda6 = AndroidView_androidKt.NoOpUpdate;
        this.updateBlock = saversKt$$ExternalSyntheticLambda6;
        this.resetBlock = saversKt$$ExternalSyntheticLambda6;
        this.releaseBlock = saversKt$$ExternalSyntheticLambda6;
    }

    public static final void _set_releaseBlock_$lambda$0(ViewFactoryHolder viewFactoryHolder) {
        viewFactoryHolder.releaseBlock.invoke(viewFactoryHolder.typedView);
        viewFactoryHolder.setSavableRegistryEntry(null);
    }

    private final void setSavableRegistryEntry(SaveableStateRegistry.Entry entry) {
        SaveableStateRegistry.Entry entry2 = this.savableRegistryEntry;
        if (entry2 != null) {
            ((EmojiProcessor) entry2).unregister();
        }
        this.savableRegistryEntry = entry;
    }

    public final NestedScrollDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final Function1 getReleaseBlock() {
        return this.releaseBlock;
    }

    public final Function1 getResetBlock() {
        return this.resetBlock;
    }

    public /* bridge */ /* synthetic */ AbstractComposeView getSubCompositionView() {
        return null;
    }

    public final Function1 getUpdateBlock() {
        return this.updateBlock;
    }

    public final void setReleaseBlock(Function1 function1) {
        this.releaseBlock = function1;
        setRelease(new AndroidViewHolder$$ExternalSyntheticLambda7(this, (byte) 3));
    }

    public final void setResetBlock(Function1 function1) {
        this.resetBlock = function1;
        setReset(new AndroidViewHolder$$ExternalSyntheticLambda7(this, (byte) 4));
    }

    public final void setUpdateBlock(Function1 function1) {
        this.updateBlock = function1;
        setUpdate(new AndroidViewHolder$$ExternalSyntheticLambda7(this, (byte) 5));
    }

    public View getViewRoot() {
        return this;
    }
}

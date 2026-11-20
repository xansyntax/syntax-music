package androidx.compose.ui;

import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposedModifier implements Modifier.Element {
    public final Function3 factory;

    public ComposedModifier(Function3 function3) {
        this.factory = function3;
    }
}

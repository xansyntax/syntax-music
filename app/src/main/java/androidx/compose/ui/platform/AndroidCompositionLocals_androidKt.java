package androidx.compose.ui.platform;

import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.ComputedProvidableCompositionLocal;
import androidx.compose.runtime.GapPending$keyMap$2;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidCompositionLocals_androidKt {
    public static final StaticProvidableCompositionLocal LocalConfiguration = new StaticProvidableCompositionLocal(new TextKt$$ExternalSyntheticLambda3(26), (byte) 1);
    public static final StaticProvidableCompositionLocal LocalContext = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 1, "LocalContext"), (byte) 0);
    public static final ComputedProvidableCompositionLocal LocalResources = new ComputedProvidableCompositionLocal(new ComposedModifierKt$$ExternalSyntheticLambda0(28));
    public static final StaticProvidableCompositionLocal LocalImageVectorCache = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 1, "LocalImageVectorCache"), (byte) 0);
    public static final StaticProvidableCompositionLocal LocalResourceIdCache = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 1, "LocalResourceIdCache"), (byte) 0);
    public static final StaticProvidableCompositionLocal LocalView = new StaticProvidableCompositionLocal(new GapPending$keyMap$2((byte) 1, "LocalView"), (byte) 0);

    public static final void noLocalProvidedFor(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }
}

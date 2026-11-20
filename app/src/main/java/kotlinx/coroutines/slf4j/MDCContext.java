package kotlinx.coroutines.slf4j;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlinx.coroutines.ThreadContextElement;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MDCContext extends AbstractCoroutineContextElement implements ThreadContextElement {
    public static final Path.Companion Key = new Path.Companion((byte) 12);
}

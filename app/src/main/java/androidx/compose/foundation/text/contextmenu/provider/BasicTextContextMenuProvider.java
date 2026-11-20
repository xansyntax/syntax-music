package androidx.compose.foundation.text.contextmenu.provider;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.innertubex.InnerTube$executeMutation$2$1;
import dagger.hilt.EntryPoints;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferedChannel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BasicTextContextMenuProvider implements TextContextMenuProvider {
    public final ComposableLambdaImpl contextMenuBlock;
    public final MutatorMutex mutatorMutex = new MutatorMutex();
    public final ParcelableSnapshotMutableState session$delegate = Stack.mutableStateOf$default(null);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SessionImpl implements TextContextMenuSession {
        public final BufferedChannel channel = EntryPoints.Channel$default(0, 7, null);
        public final TextContextMenuDataProvider dataProvider;

        public SessionImpl(TextContextMenuDataProvider textContextMenuDataProvider) {
            this.dataProvider = textContextMenuDataProvider;
        }

        @Override // androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession
        public final void close() {
            this.channel.mo1712trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    public BasicTextContextMenuProvider(ComposableLambdaImpl composableLambdaImpl) {
        this.contextMenuBlock = composableLambdaImpl;
    }

    public final void ContextMenu(final Function0 function0, Composer composer, final int i) {
        final Function0 function1;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(723898654);
        int i2 = (gapComposer.changed(this) ? 32 : 16) | i;
        final byte b = 0;
        final byte b2 = 1;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            SessionImpl sessionImpl = (SessionImpl) this.session$delegate.getValue();
            if (sessionImpl == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2(this, function0, i, b) { // from class: androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider$$ExternalSyntheticLambda0
                        public final /* synthetic */ byte $r8$classId;
                        public final /* synthetic */ BasicTextContextMenuProvider f$0;
                        public final /* synthetic */ Function0 f$1;

                        {
                            this.$r8$classId = b;
                            this.f$0 = this;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            byte b3 = this.$r8$classId;
                            Unit unit = Unit.INSTANCE;
                            Function0 function2 = this.f$1;
                            BasicTextContextMenuProvider basicTextContextMenuProvider = this.f$0;
                            Composer composer2 = (Composer) obj;
                            ((Integer) obj2).getClass();
                            switch (b3) {
                                case 0:
                                    basicTextContextMenuProvider.ContextMenu(function2, composer2, Stack.updateChangedFlags(7));
                                    break;
                                default:
                                    basicTextContextMenuProvider.ContextMenu(function2, composer2, Stack.updateChangedFlags(7));
                                    break;
                            }
                            return unit;
                        }
                    };
                    return;
                }
                return;
            }
            function1 = function0;
            this.contextMenuBlock.invoke((Object) sessionImpl, (Object) sessionImpl.dataProvider, (Object) function1, (Object) gapComposer, (Object) 384);
        } else {
            function1 = function0;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            recomposeScopeImplEndRestartGroup2.block = new Function2(this, function1, i, b2) { // from class: androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider$$ExternalSyntheticLambda0
                public final /* synthetic */ byte $r8$classId;
                public final /* synthetic */ BasicTextContextMenuProvider f$0;
                public final /* synthetic */ Function0 f$1;

                {
                    this.$r8$classId = b2;
                    this.f$0 = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    byte b3 = this.$r8$classId;
                    Unit unit = Unit.INSTANCE;
                    Function0 function2 = this.f$1;
                    BasicTextContextMenuProvider basicTextContextMenuProvider = this.f$0;
                    Composer composer2 = (Composer) obj;
                    ((Integer) obj2).getClass();
                    switch (b3) {
                        case 0:
                            basicTextContextMenuProvider.ContextMenu(function2, composer2, Stack.updateChangedFlags(7));
                            break;
                        default:
                            basicTextContextMenuProvider.ContextMenu(function2, composer2, Stack.updateChangedFlags(7));
                            break;
                    }
                    return unit;
                }
            };
        }
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider
    public final Object showTextContextMenu(TextContextMenuDataProvider textContextMenuDataProvider, SuspendLambda suspendLambda) {
        Object objMutate = this.mutatorMutex.mutate(MutatePriority.Default, new InnerTube$executeMutation$2$1(this, new SessionImpl(textContextMenuDataProvider), null, (byte) 3), suspendLambda);
        return objMutate == CoroutineSingletons.COROUTINE_SUSPENDED ? objMutate : Unit.INSTANCE;
    }
}

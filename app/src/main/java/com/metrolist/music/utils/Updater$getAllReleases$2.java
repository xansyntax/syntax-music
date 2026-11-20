package com.metrolist.music.utils;

import androidx.compose.foundation.lazy.grid.LazyGridState;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.listentogether.ListenTogetherClient;
import com.metrolist.music.viewmodels.LocalPlaylistViewModel;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Updater$getAllReleases$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId = 2;
    public int I$0;
    public int I$1;
    public /* synthetic */ Object L$0;
    public Object L$2;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Updater$getAllReleases$2(MusicDatabase musicDatabase, LocalPlaylistViewModel localPlaylistViewModel, int i, int i2, Continuation continuation) {
        super(2, continuation);
        this.L$2 = musicDatabase;
        this.L$0 = localPlaylistViewModel;
        this.I$0 = i;
        this.I$1 = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                Updater$getAllReleases$2 updater$getAllReleases$2 = new Updater$getAllReleases$2(2, continuation);
                updater$getAllReleases$2.L$0 = obj;
                return updater$getAllReleases$2;
            case 1:
                return new Updater$getAllReleases$2((ListenTogetherClient) this.L$0, continuation);
            case 2:
                return new Updater$getAllReleases$2(this.I$1, (ArrayList) this.L$2, (LazyGridState) this.L$0, continuation);
            default:
                return new Updater$getAllReleases$2((MusicDatabase) this.L$2, (LocalPlaylistViewModel) this.L$0, this.I$0, this.I$1, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                return ((Updater$getAllReleases$2) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 1:
                ((Updater$getAllReleases$2) create(coroutineScope, continuation)).invokeSuspend(unit);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            case 2:
                return ((Updater$getAllReleases$2) create(coroutineScope, continuation)).invokeSuspend(unit);
            default:
                return ((Updater$getAllReleases$2) create(coroutineScope, continuation)).invokeSuspend(unit);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ed A[Catch: all -> 0x023b, LOOP:1: B:99:0x01eb->B:100:0x01ed, LOOP_END, TryCatch #0 {all -> 0x023b, blocks: (B:73:0x0142, B:95:0x01d7, B:102:0x0238, B:98:0x01e6, B:100:0x01ed, B:101:0x0231, B:87:0x017c, B:91:0x01be, B:77:0x015a, B:80:0x0163, B:82:0x016b, B:83:0x016f), top: B:108:0x0134 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0178  */
    /* JADX WARN: Code duplicated, block: B:89:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:90:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:93:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:94:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:98:0x01e6 A[Catch: all -> 0x023b, TryCatch #0 {all -> 0x023b, blocks: (B:73:0x0142, B:95:0x01d7, B:102:0x0238, B:98:0x01e6, B:100:0x01ed, B:101:0x0231, B:87:0x017c, B:91:0x01be, B:77:0x015a, B:80:0x0163, B:82:0x016b, B:83:0x016f), top: B:108:0x0134 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x010d -> B:64:0x0112). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x01d2 -> B:95:0x01d7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instruction units count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.utils.Updater$getAllReleases$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public /* synthetic */ Updater$getAllReleases$2(int i, Continuation continuation) {
        super(i, continuation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Updater$getAllReleases$2(int i, ArrayList arrayList, LazyGridState lazyGridState, Continuation continuation) {
        super(2, continuation);
        this.I$1 = i;
        this.L$2 = arrayList;
        this.L$0 = lazyGridState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Updater$getAllReleases$2(ListenTogetherClient listenTogetherClient, Continuation continuation) {
        super(2, continuation);
        this.L$0 = listenTogetherClient;
    }
}

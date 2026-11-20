package com.metrolist.music.ui.screens;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.navigation.NavHostController;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.viewmodels.BackupRestoreViewModel;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NewReleaseScreenKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ State f$5;
    public final /* synthetic */ State f$6;
    public final /* synthetic */ Object f$7;

    public /* synthetic */ NewReleaseScreenKt$$ExternalSyntheticLambda1(MutableState mutableState, HapticFeedback hapticFeedback, MenuState menuState, CoroutineScope coroutineScope, PlayerConnection playerConnection, NavHostController navHostController, MutableState mutableState2, MutableState mutableState3) {
        this.f$7 = mutableState;
        this.f$1 = hapticFeedback;
        this.f$2 = menuState;
        this.f$4 = coroutineScope;
        this.f$0 = playerConnection;
        this.f$3 = navHostController;
        this.f$5 = mutableState2;
        this.f$6 = mutableState3;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:14:0x005c
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // kotlin.jvm.functions.Function1
    public final java.lang.Object invoke(java.lang.Object r31) {
        /*
            Method dump skipped, instruction units count: 954
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.ui.screens.NewReleaseScreenKt$$ExternalSyntheticLambda1.invoke(java.lang.Object):java.lang.Object");
    }

    public /* synthetic */ NewReleaseScreenKt$$ExternalSyntheticLambda1(ComposableLambdaImpl composableLambdaImpl, NavHostController navHostController, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MenuState menuState, MusicDatabase musicDatabase) {
        this.f$0 = composableLambdaImpl;
        this.f$3 = navHostController;
        this.f$5 = mutableState;
        this.f$6 = mutableState2;
        this.f$1 = mutableState3;
        this.f$4 = mutableState4;
        this.f$2 = menuState;
        this.f$7 = musicDatabase;
    }

    public /* synthetic */ NewReleaseScreenKt$$ExternalSyntheticLambda1(BackupRestoreViewModel backupRestoreViewModel, Context context, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        this.f$0 = backupRestoreViewModel;
        this.f$1 = context;
        this.f$4 = coroutineScope;
        this.f$7 = mutableState;
        this.f$2 = mutableState2;
        this.f$3 = mutableState3;
        this.f$5 = mutableState4;
        this.f$6 = mutableState5;
    }

    public /* synthetic */ NewReleaseScreenKt$$ExternalSyntheticLambda1(List list, ComposableLambdaImpl composableLambdaImpl, ComposableLambdaImpl composableLambdaImpl2, MutableState mutableState, MenuState menuState, CoroutineScope coroutineScope, MutableState mutableState2, MutableState mutableState3) {
        this.f$0 = list;
        this.f$1 = composableLambdaImpl;
        this.f$3 = composableLambdaImpl2;
        this.f$7 = mutableState;
        this.f$2 = menuState;
        this.f$4 = coroutineScope;
        this.f$5 = mutableState2;
        this.f$6 = mutableState3;
    }

    public /* synthetic */ NewReleaseScreenKt$$ExternalSyntheticLambda1(List list, HapticFeedback hapticFeedback, MenuState menuState, NavHostController navHostController, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        this.f$0 = list;
        this.f$1 = hapticFeedback;
        this.f$2 = menuState;
        this.f$3 = navHostController;
        this.f$4 = coroutineScope;
        this.f$5 = mutableState;
        this.f$6 = mutableState2;
        this.f$7 = mutableState3;
    }
}

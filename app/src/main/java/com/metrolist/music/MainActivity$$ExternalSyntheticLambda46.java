package com.metrolist.music;

import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.screens.Screens;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda46 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ BottomSheetState f$0;
    public final /* synthetic */ NavHostController f$1;
    public final /* synthetic */ CoroutineScope f$2;
    public final /* synthetic */ NavDeepLinkRequest f$3;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda46(BottomSheetState bottomSheetState, NavHostController navHostController, CoroutineScope coroutineScope, NavDeepLinkRequest navDeepLinkRequest, byte b) {
        this.$r8$classId = b;
        this.f$0 = bottomSheetState;
        this.f$1 = navHostController;
        this.f$2 = coroutineScope;
        this.f$3 = navDeepLinkRequest;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        NavBackStackEntry backStackEntry;
        SavedStateHandle savedStateHandle;
        SavedStateHandle savedStateHandle2;
        SavedStateHandle savedStateHandle3;
        Integer num;
        NavDestination navDestination;
        SavedStateHandle savedStateHandle4;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NavDeepLinkRequest navDeepLinkRequest = this.f$3;
        CoroutineScope coroutineScope = this.f$2;
        NavHostController navHostController = this.f$1;
        BottomSheetState bottomSheetState = this.f$0;
        Screens screens = (Screens) obj;
        boolean zBooleanValue = ((Boolean) obj2).booleanValue();
        switch (b) {
            case 0:
                int i = MainActivity.$r8$clinit;
                screens.getClass();
                if (bottomSheetState.isExpanded()) {
                    bottomSheetState.collapseSoft();
                }
                if (!zBooleanValue) {
                    navHostController.navigate(screens.route, new MainActivity$$ExternalSyntheticLambda62(navHostController, (byte) 0));
                } else {
                    try {
                        NavBackStackEntry currentBackStackEntry$navigation_runtime_release = navHostController.impl.getCurrentBackStackEntry$navigation_runtime_release();
                        String str = (currentBackStackEntry$navigation_runtime_release == null || (navDestination = currentBackStackEntry$navigation_runtime_release.destination) == null) ? null : (String) navDestination.impl.layoutNodes;
                        backStackEntry = (Intrinsics.areEqual(str, "search/{query}") || Intrinsics.areEqual(str, "search_input")) ? navHostController.getBackStackEntry() : navHostController.impl.getCurrentBackStackEntry$navigation_runtime_release();
                    } catch (Exception unused) {
                        backStackEntry = null;
                    }
                    if (screens.equals(Screens.Search.INSTANCE)) {
                        int iIntValue = (backStackEntry == null || (savedStateHandle3 = backStackEntry.getSavedStateHandle()) == null || (num = (Integer) savedStateHandle3.get("scrollToTopCount")) == null) ? 0 : num.intValue();
                        if (backStackEntry != null && (savedStateHandle2 = backStackEntry.getSavedStateHandle()) != null) {
                            savedStateHandle2.set(Integer.valueOf(iIntValue + 1), "scrollToTopCount");
                        }
                    } else if (backStackEntry != null && (savedStateHandle = backStackEntry.getSavedStateHandle()) != null) {
                        savedStateHandle.set(Boolean.TRUE, "scrollToTop");
                    }
                    AwaitKt.launch$default(coroutineScope, null, null, new MainActivity$MetrolistApp$6$1$1$10$3$onNavItemClick$1$1$1(navDeepLinkRequest, null, (byte) 0), 3);
                }
                break;
            default:
                int i2 = MainActivity.$r8$clinit;
                screens.getClass();
                if (bottomSheetState.isExpanded()) {
                    bottomSheetState.collapseSoft();
                }
                if (!zBooleanValue) {
                    navHostController.navigate(screens.route, new MainActivity$$ExternalSyntheticLambda62(navHostController, (byte) 1));
                } else {
                    NavBackStackEntry currentBackStackEntry$navigation_runtime_release2 = navHostController.impl.getCurrentBackStackEntry$navigation_runtime_release();
                    if (currentBackStackEntry$navigation_runtime_release2 != null && (savedStateHandle4 = currentBackStackEntry$navigation_runtime_release2.getSavedStateHandle()) != null) {
                        savedStateHandle4.set(Boolean.TRUE, "scrollToTop");
                    }
                    AwaitKt.launch$default(coroutineScope, null, null, new MainActivity$MetrolistApp$6$1$1$10$3$onNavItemClick$1$1$1(navDeepLinkRequest, null, (byte) 1), 3);
                }
                break;
        }
        return unit;
    }
}

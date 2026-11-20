package com.metrolist.music;

import android.net.Uri;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import com.metrolist.shazamkit.models.RecognitionResult;
import io.ktor.sse.ServerSentEventKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda62 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ NavHostController f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda62(NavHostController navHostController, byte b) {
        this.$r8$classId = b;
        this.f$0 = navHostController;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NavHostController navHostController = this.f$0;
        switch (b) {
            case 0:
                NavOptionsBuilder navOptionsBuilder = (NavOptionsBuilder) obj;
                int i = MainActivity.$r8$clinit;
                navOptionsBuilder.getClass();
                navOptionsBuilder.popUpToId = navHostController.impl.getGraph$navigation_runtime_release().impl.startDestId;
                navOptionsBuilder.inclusive = false;
                navOptionsBuilder.saveState = true;
                navOptionsBuilder.launchSingleTop = true;
                navOptionsBuilder.restoreState = true;
                break;
            case 1:
                NavOptionsBuilder navOptionsBuilder2 = (NavOptionsBuilder) obj;
                int i2 = MainActivity.$r8$clinit;
                navOptionsBuilder2.getClass();
                navOptionsBuilder2.popUpToId = navHostController.impl.getGraph$navigation_runtime_release().impl.startDestId;
                navOptionsBuilder2.inclusive = false;
                navOptionsBuilder2.saveState = true;
                navOptionsBuilder2.launchSingleTop = true;
                navOptionsBuilder2.restoreState = true;
                break;
            default:
                RecognitionResult recognitionResult = (RecognitionResult) obj;
                recognitionResult.getClass();
                Format$$ExternalSyntheticOutline0.m("search/", Uri.encode("__metrolist_search_query__".concat(recognitionResult.getTitle() + ServerSentEventKt.SPACE + recognitionResult.getArtist())), navHostController);
                break;
        }
        return unit;
    }
}

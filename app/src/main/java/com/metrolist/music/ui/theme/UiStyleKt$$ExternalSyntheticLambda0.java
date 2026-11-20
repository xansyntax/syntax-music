package com.metrolist.music.ui.theme;

import android.content.Context;
import androidx.compose.runtime.Stack;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.discord.DiscordRpcManager;
import com.metrolist.music.utils.InnerTubeXPlayer;
import com.metrolist.music.utils.potoken.PoTokenGenerator;
import com.metrolist.paxsenix.models.AppleMusicResources;
import com.metrolist.paxsenix.models.AppleMusicSongDetail$$serializer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class UiStyleKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ UiStyleKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return UiStyle.EDITORIAL;
            case 1:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 2:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 3:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 4:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 5:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 6:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 7:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 8:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 9:
                return Unit.INSTANCE;
            case 10:
                DiscordRpcManager.INSTANCE.clearLastError();
                return Unit.INSTANCE;
            case 11:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 13:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 14:
                return Stack.mutableStateOf$default(null);
            case 15:
                return Stack.mutableStateOf$default("");
            case 16:
                return Stack.mutableStateOf$default("");
            case 17:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 18:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 19:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 20:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 21:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 22:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 23:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 24:
                return Stack.mutableStateOf$default(Boolean.FALSE);
            case 25:
                return Stack.mutableStateOf$default("");
            case 26:
                return Unit.INSTANCE;
            case 27:
                Context context = InnerTubeXPlayer.applicationContext;
                if (context != null) {
                    return new InnerTubeXPlayer.AndroidPlayerConfigRepository(context);
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("InnerTubeXPlayer is not initialized");
                return null;
            case 28:
                Context context2 = InnerTubeXPlayer.applicationContext;
                if (context2 != null) {
                    return new PoTokenGenerator(context2);
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("InnerTubeXPlayer is not initialized");
                return null;
            default:
                AppleMusicResources.Companion companion = AppleMusicResources.Companion;
                return new HashMapSerializer(StringSerializer.INSTANCE, AppleMusicSongDetail$$serializer.INSTANCE, (byte) 1);
        }
    }
}

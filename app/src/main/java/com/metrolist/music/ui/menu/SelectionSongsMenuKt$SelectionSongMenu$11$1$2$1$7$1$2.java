package com.metrolist.music.ui.menu;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.entities.Song;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionSongsMenuKt$SelectionSongMenu$11$1$2$1$7$1$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ArrayList $songSelection;
    public Iterator L$1;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectionSongsMenuKt$SelectionSongMenu$11$1$2$1$7$1$2(ArrayList arrayList, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$songSelection = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        ArrayList arrayList = this.$songSelection;
        switch (b) {
            case 0:
                return new SelectionSongsMenuKt$SelectionSongMenu$11$1$2$1$7$1$2(arrayList, continuation, (byte) 0);
            case 1:
                return new SelectionSongsMenuKt$SelectionSongMenu$11$1$2$1$7$1$2(arrayList, continuation, (byte) 1);
            case 2:
                return new SelectionSongsMenuKt$SelectionSongMenu$11$1$2$1$7$1$2(arrayList, continuation, (byte) 2);
            default:
                return new SelectionSongsMenuKt$SelectionSongMenu$11$1$2$1$7$1$2(arrayList, continuation, (byte) 3);
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
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return ((SelectionSongsMenuKt$SelectionSongMenu$11$1$2$1$7$1$2) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Iterator it;
        Iterator it2;
        Iterator it3;
        Iterator it4;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = 0;
        ArrayList arrayList = this.$songSelection;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    it = arrayList.iterator();
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    it = this.L$1;
                    ResultKt.throwOnFailure(obj);
                    Object obj2 = ((Result) obj).value;
                }
                while (it.hasNext()) {
                    Song song = (Song) it.next();
                    YouTube youTube = YouTube.INSTANCE;
                    String str = song.song.id;
                    this.L$1 = it;
                    this.label = true;
                    if (youTube.m1044toggleSongLibrary0E7RQCE(str, false, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return unit;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    while (i < size) {
                        Object obj3 = arrayList.get(i);
                        i++;
                        if (((Song) obj3).song.inLibrary == null) {
                            arrayList2.add(obj3);
                        }
                    }
                    it2 = arrayList2.iterator();
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    it2 = this.L$1;
                    ResultKt.throwOnFailure(obj);
                    Object obj4 = ((Result) obj).value;
                }
                while (it2.hasNext()) {
                    Song song2 = (Song) it2.next();
                    YouTube youTube2 = YouTube.INSTANCE;
                    String str2 = song2.song.id;
                    this.L$1 = it2;
                    this.label = true;
                    if (youTube2.m1044toggleSongLibrary0E7RQCE(str2, true, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return unit;
            case 2:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    it3 = arrayList.iterator();
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    it3 = this.L$1;
                    ResultKt.throwOnFailure(obj);
                    Object obj5 = ((Result) obj).value;
                }
                while (it3.hasNext()) {
                    SongItem songItem = (SongItem) it3.next();
                    YouTube youTube3 = YouTube.INSTANCE;
                    String str3 = songItem.id;
                    this.L$1 = it3;
                    this.label = true;
                    if (youTube3.m1044toggleSongLibrary0E7RQCE(str3, false, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return unit;
            default:
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList3 = new ArrayList();
                    int size2 = arrayList.size();
                    while (i < size2) {
                        Object obj6 = arrayList.get(i);
                        i++;
                        HexFormatKt.toMediaMetadata((SongItem) obj6);
                        arrayList3.add(obj6);
                    }
                    it4 = arrayList3.iterator();
                } else {
                    if (!z4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    it4 = this.L$1;
                    ResultKt.throwOnFailure(obj);
                    Object obj7 = ((Result) obj).value;
                }
                while (it4.hasNext()) {
                    SongItem songItem2 = (SongItem) it4.next();
                    YouTube youTube4 = YouTube.INSTANCE;
                    String str4 = songItem2.id;
                    this.L$1 = it4;
                    this.label = true;
                    if (youTube4.m1044toggleSongLibrary0E7RQCE(str4, true, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return unit;
        }
    }
}

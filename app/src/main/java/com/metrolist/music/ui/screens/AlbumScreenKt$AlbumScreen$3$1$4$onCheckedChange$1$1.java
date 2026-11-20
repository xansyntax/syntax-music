package com.metrolist.music.ui.screens;

import com.metrolist.music.db.entities.Song;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumScreenKt$AlbumScreen$3$1$4$onCheckedChange$1$1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List $selection;
    public final /* synthetic */ Song $song;

    public /* synthetic */ AlbumScreenKt$AlbumScreen$3$1$4$onCheckedChange$1$1(List list, Song song, byte b) {
        this.$r8$classId = b;
        this.$selection = list;
        this.$song = song;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        List list = this.$selection;
        Song song = this.$song;
        switch (b) {
            case 0:
                if (!((Boolean) obj).booleanValue()) {
                    list.remove(song.song.id);
                } else {
                    list.add(song.song.id);
                }
                break;
            case 1:
                if (!((Boolean) obj).booleanValue()) {
                    list.remove(song.song.id);
                } else {
                    list.add(song.song.id);
                }
                break;
            case 2:
                if (!((Boolean) obj).booleanValue()) {
                    list.remove(song.song.id);
                } else {
                    list.add(song.song.id);
                }
                break;
            default:
                if (!((Boolean) obj).booleanValue()) {
                    list.remove(song.song.id);
                } else {
                    list.add(song.song.id);
                }
                break;
        }
        return unit;
    }
}

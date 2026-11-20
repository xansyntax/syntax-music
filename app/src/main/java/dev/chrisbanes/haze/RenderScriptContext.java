package dev.chrisbanes.haze;

import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.renderscript.Type;
import com.valentinilk.shimmer.ShimmerModifierKt$shimmer$1$1;
import dagger.hilt.EntryPoints;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RenderScriptContext {
    public final ScriptIntrinsicBlur blurScript;
    public final BufferedChannel channel;
    public final Allocation inputAlloc;
    public boolean isDestroyed;
    public final Allocation outputAlloc;
    public final Bitmap outputBitmap;
    public final RenderScript rs;
    public final long size;

    public RenderScriptContext(RenderScript renderScript, long j) {
        renderScript.getClass();
        this.rs = renderScript;
        this.size = j;
        this.channel = EntryPoints.Channel$default(-1, 6, null);
        int i = (int) (j >> 32);
        int i2 = (i % 4) + i;
        int i3 = (int) (j & 4294967295L);
        int i4 = (i3 % 4) + i3;
        Allocation allocationCreateTyped = Allocation.createTyped(renderScript, new Type.Builder(renderScript, Element.U8_4(renderScript)).setX(i2).setY(i4).create(), 33);
        allocationCreateTyped.getClass();
        this.inputAlloc = allocationCreateTyped;
        allocationCreateTyped.setOnBufferAvailableListener(new Allocation.OnBufferAvailableListener() { // from class: dev.chrisbanes.haze.RenderScriptContext$$ExternalSyntheticLambda0
            @Override // android.renderscript.Allocation.OnBufferAvailableListener
            public final void onBufferAvailable(Allocation allocation) {
                RenderScriptContext renderScriptContext = this.f$0;
                if (renderScriptContext.isDestroyed) {
                    return;
                }
                allocation.ioReceive();
                BufferedChannel bufferedChannel = renderScriptContext.channel;
                Object objMo1712trySendJP2dKIU = bufferedChannel.mo1712trySendJP2dKIU(Unit.INSTANCE);
                if (!(objMo1712trySendJP2dKIU instanceof ChannelResult.Failed)) {
                    return;
                }
                Object obj = ((ChannelResult) AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new ShimmerModifierKt$shimmer$1$1(bufferedChannel, null, (byte) 5))).holder;
            }
        });
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i4, Bitmap.Config.ARGB_8888);
        this.outputBitmap = bitmapCreateBitmap;
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScript, bitmapCreateBitmap);
        allocationCreateFromBitmap.getClass();
        this.outputAlloc = allocationCreateFromBitmap;
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        scriptIntrinsicBlurCreate.getClass();
        this.blurScript = scriptIntrinsicBlurCreate;
        scriptIntrinsicBlurCreate.setInput(allocationCreateTyped);
    }
}

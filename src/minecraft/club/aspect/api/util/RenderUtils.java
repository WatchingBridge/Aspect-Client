package club.aspect.api.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class RenderUtils {
    public static float deltaTime;

    public static void drawImg(ResourceLocation loc, double posX, double posY, double width, double height) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(loc);
        float f = 1.0F / (float)width;
        float f1 = 1.0F / (float)height;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(posX, posY + height, 0.0D).tex((double)(0.0F * f), (double)((0.0F + (float)height) * f1)).endVertex();
        worldrenderer.pos(posX + width, posY + height, 0.0D).tex((double)((0.0F + (float)width) * f), (double)((0.0F + (float)height) * f1)).endVertex();
        worldrenderer.pos(posX + width, posY, 0.0D).tex((double)((0.0F + (float)width) * f), (double)(0.0F * f1)).endVertex();
        worldrenderer.pos(posX, posY, 0.0D).tex((double)(0.0F * f), (double)(0.0F * f1)).endVertex();
        tessellator.draw();
    }
}

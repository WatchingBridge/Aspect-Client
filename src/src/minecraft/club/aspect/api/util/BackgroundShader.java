package club.aspect.api.util;


import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL20;

public class BackgroundShader extends Shader {


    public final static BackgroundShader BackgroundShader = new BackgroundShader();

    private float time;

    public BackgroundShader() {
        super("test2.frag");
    }

    @Override
    public void setupUniforms() {
        setupUniform("time");
        setupUniform("resolution");
    }

    @Override
    public void updateUniforms() {
        final ScaledResolution scaledResolution = new ScaledResolution(mc);

        final int resolutionID = getUniform("resolution");
        if(resolutionID > -1)
            GL20.glUniform2f(resolutionID, (float) scaledResolution.getScaledWidth() * 2, (float) scaledResolution.getScaledHeight() * 2);

        final int timeID = getUniform("time");
        if(timeID > -1) GL20.glUniform1f(timeID, time);

        time += 0.0015F * RenderUtils.deltaTime;
    }
}

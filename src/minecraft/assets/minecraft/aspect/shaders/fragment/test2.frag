/*
 * Original shader from: https://www.shadertoy.com/view/sl23Rw
 */

#ifdef GL_ES
precision mediump float;
#endif

// glslsandbox uniforms
uniform float time;
uniform vec2 resolution;

// shadertoy emulation
#define iTime time
#define iResolution resolution

// --------[ Original ShaderToy begins here ]---------- //
/*

Noise value. https://www.youtube.com/watch?v=zXsWftRdsvU&t=285s

all credits to: https://www.youtube.com/channel/UCcAlTqd9zID6aNX3TzwxJXg

*/

float R21 (vec2 p) {
    return fract(sin(dot(p.xy, vec2(2.3245,5.234)))*123.5632145);
}

float NoiseValue (vec2 uv) {
    vec2 gv = fract(uv);
    vec2 id = floor(uv);

    gv = gv * gv * (3. - 2. * gv);

    float a = R21(id);
    float b = R21(id + vec2(1., 0.));
    float c = R21(id + vec2(0., 1.));
    float d = R21(id + vec2(1., 1.));

    return mix(a, b, gv.x) + (c - a)* gv.y * (1. - gv.x) + (d - b) * gv.x * gv.y;
}

float SmoothNoise (vec2 uv) {

    float value = 0.;
    float amplitude = .5;

    for (int i = 0; i < 8; i++) {
        value += NoiseValue(uv) * amplitude;
        uv *= 2.;
        amplitude *= .5;
    }

    return value;
}

void mainImage( out vec4 fragColor, in vec2 fragCoord ) {
    vec2 uv = (fragCoord- 1.*iResolution.xy)/iResolution.y; //-.5 <> .5

    vec3 col = vec3(0.);

    vec2 r = vec2(1.);
    //r.x = SmoothNoise( uv + 0.00*iTime);
    //r.y = SmoothNoise( uv + vec2(1.0));

    vec2 rn = vec2(0.);
    rn.x = SmoothNoise(uv + 1.984 * r + vec2(1.7,9.2)+ 0.158*iTime );
    rn.y = SmoothNoise(uv + 1. * r + vec2(8.3,2.8)+ 0.126*iTime);

    col += SmoothNoise(uv+rn*2.5);

    fragColor = vec4(col,1.0);
}

// --------[ Original ShaderToy ends here ]---------- //

void main(void)
{
    mainImage(gl_FragColor, gl_FragCoord.xy);
}
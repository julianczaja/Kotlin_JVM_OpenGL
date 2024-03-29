#version 330 core

layout (location = 0) in vec3 inPos;
layout (location = 1) in vec3 inCol;

//out vec3 fragmentPos;
//out vec3 color;

out VS_OUT {
    vec3 fragmentPos;
    vec3 color;
} vs_out;

uniform mat4 m;
uniform mat4 v;
uniform mat4 p;


void main()
{
    gl_Position = p * v * m * vec4(inPos.xyz, 1.0f);

    vs_out.fragmentPos = vec3(m * vec4(inPos.xyz, 1.0f));
    vs_out.color = inCol;
}

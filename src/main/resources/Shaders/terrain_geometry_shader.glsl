#version 330 core

layout (triangles) in;
layout (triangle_strip, max_vertices=3) out;

in VS_OUT {
    vec3 _fragmentPos;
    vec3 _color;
} gs_in[];

out vec3 fragmentPos;
out vec3 faceNormal;
out vec3 color;

// https://www.khronos.org/opengl/wiki/Calculating_a_Surface_Normal
vec3 calculateFaceNormal() {
    // U = p2 - p1
    // V = p3 - p1
    vec3 u = gs_in[1]._fragmentPos.xyz - gs_in[0]._fragmentPos.xyz;
    vec3 v = gs_in[2]._fragmentPos.xyz - gs_in[0]._fragmentPos.xyz;

    // Nx = UyVz - UzVy
    // Ny = UzVx - UxVz
    // Nz = UxVy - UyVx
    return normalize(vec3((u.x*v.z)-(u.z*v.y), (u.z*v.x)-(u.x*v.z), (u.x*v.y)-(u.y*v.x)));
}

// Geometry shader that calculates terrain mesh normals
void main()
{
    for (int i = 0; i < gl_in.length(); i++)
    {
        gl_Position = gl_in[i].gl_Position;

        fragmentPos = gs_in[i]._fragmentPos;
        faceNormal = calculateFaceNormal();
        color = gs_in[i]._color;

        EmitVertex();
    }
    EndPrimitive();
}

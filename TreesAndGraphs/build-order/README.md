# 3.4.7. Build order
| **Question** | **Solution** |
|--------------|--------------|
| You are given a kist of projects and a list of dependencies (which is a list of pairs of projects, where the second project is dependent on the first project). All of a project's dependencies must be build before the project is. Find a build order that will allow the projects to be built. If there is no valid build order, return an error.<br>EXAMPLE:<br>Input:<br>  _projects:_ _a,b,c,d,e,f_ <br>  _dependencies:_ _(a,d), (f,b), (b,d), (f,a), (d,c)_ <br>Output: <br> _f, e, a, b, d, c_ | [Build order](./) |
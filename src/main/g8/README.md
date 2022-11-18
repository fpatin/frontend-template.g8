# Frontend Template

Based on
* [Scala JS](https://www.scala-js.org/)
* [Laminar](https://laminar.dev/)
* [Waypoint](https://github.com/raquo/Waypoint)
* [Animus](https://github.com/kitlangton/animus)
* [ZIO Json](https://github.com/zio/zio-json)
* [scala-java-time](http://cquiroz.github.io/scala-java-time/)

## Pre install

```shell
npm install
```

## Dev 
Use Vite to run the dev server
```shell
npm run dev
```
In a `sbt` shell, automatically build your code
```sbt
~publicDev
```
## Build
```shell
npm run build
```

```shell
docker build -t <image_name> .
```

```shell
docker run -it -p 80:80 --name <container_name> <image_name>
```

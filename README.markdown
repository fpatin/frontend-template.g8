A [Giter8](http://www.foundweekends.org/giter8/index.html) template for HTTP Scala backend!

### Prerequisite

* sbt
* node
* npm

### Usage
```shell
g8 git@github.com:fpatin/frontend-template.g8.git
```

```shell
sbt new git@github.com:fpatin/frontend-template.g8
```

### After creation

* Install node dependencies
```shell
npm install
```

* Compile scala project
```shell
sbt compile
```

* Launch HTTP server
```shell
npm run dev
```

* Build production distribution
```shell
npm run build
```

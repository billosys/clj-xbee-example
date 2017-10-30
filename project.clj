(defproject systems.billo/clj-xbee-example "0.1.0-SNAPSHOT"
  :description "An Example Application Built with the clj-xbee Wrapper Library"
  :url "https://github.com/billosys/clj-xbee-example"
  :license {
    :name "Apache License Version 2.0"
    :url "https://www.apache.org/licenses/LICENSE-2.0"}
  :exclusions [
    [org.clojure/clojure]
    [org.rxtx/rxtx]]
  :dependencies [
    [clojusc/twig "0.3.2"]
    [org.clojure/clojure "1.8.0"]
    [systems.billo/clj-xbee "0.1.0-SNAPSHOT"]]
  :resource-paths ["resources/RXTXcomm.jar"]
  :main xbee-example.core
  :java-opts ["-Djava.library.path=lib"]
  :profiles {
    :ubercompile {:aot :all}
    :test {
      :plugins [
        [lein-ancient "0.6.14"]
        [jonase/eastwood "0.2.5"]
        [lein-bikeshed "0.5.0" :exclusions [org.clojure/tools.namespace]]
        [lein-kibit "0.1.5"]
        [venantius/yagni "0.1.4"]]}}
  :aliases {
    "repl"
      ["with-profile" "+test,+custom-repl" "repl"]
    "check-deps"
      ^{:doc (str "Check if any deps have out-of-date versions")}
      ["with-profile" "+test" "ancient" "check" ":all"]
    "lint"
      ^{:doc (str "Perform lint checking")}
      ["with-profile" "+test" "kibit"]
    "ubercompile"
      ["with-profile" "+ubercompile" "compile"]
    "build"
      ^{:doc (str "Perform build tasks for CI/CD & releases\n\n"
                 "Additional aliases:")}
      ["with-profile" "+test" "do"
        ["check-deps"]
        ["lint"]
        ["test"]
        ["compile"]
        ["uberjar"]]})

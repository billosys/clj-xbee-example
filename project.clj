(defproject systems.billo/clj-xbee-example "0.1.0-SNAPSHOT"
  :description "An Example Application Built with the clj-xbee Wrapper Library"
  :url "https://github.com/billosys/clj-xbee-example"
  :license {
    :name "Apache License Version 2.0"
    :url "https://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [
    [clojusc/twig "0.3.2"]
    [org.clojure/clojure "1.8.0"]
    [systems.billo/clj-xbee "0.1.0-SNAPSHOT"]]
  :main xbee-example.core
  :java-opts ["-Djava.library.path=lib"])

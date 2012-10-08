(defproject cljs-fiddle "0.0.1"
  :description "A simple web application for trying out ClojureScript"
  ; Source path for Leiningen 1.x:
  :source-path "src/clj"
  ; Source paths for Leiningen 2.x:
  :source-paths ["src/clj"]
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [noir "1.3.0-beta10"]
                 [hiccup "1.0.0"]
                 [tentacles "0.2.2"]
                 [jayq "0.1.0-alpha3"]
                 [crate "0.2.1"]]
  :plugins [[lein-cljsbuild "0.2.7"]]
  :cljsbuild {
    :builds [{:source-path "src/cljs"
              :compiler {:output-to "resources/public/js/main.js"
                         :optimizations :simple
                         :pretty-print true}}]}
  :main fiddle.server)

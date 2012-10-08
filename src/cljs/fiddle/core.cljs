(ns fiddle.core
  (:use [jayq.core :only [$ attr xhr]]
        [fiddle.views.navigation :only [init-navigation]])
  (:use-macros [jayq.macros :only [ready]]))

(defn init-editor [elem]
  (let [editor (.edit js/ace (first elem))
        session (.getSession editor)]
    (.setTheme editor "ace/theme/solarized_light")
    (.setMode session "ace/mode/clojure")))

(ready
  (init-editor ($ ".editor"))
  (init-navigation ($ ".navigation")))
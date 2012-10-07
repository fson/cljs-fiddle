(ns fiddle.core
  (:use [jayq.core :only [$ attr xhr]]
        [fiddle.util :only [log]])
  (:use-macros [jayq.macros :only [ready]]))

(defn init-editor [elem]
  (let [editor (.edit js/ace (first elem))
        session (.getSession editor)]
    (.setTheme editor "ace/theme/solarized_light")
    (.setMode session "ace/mode/clojure")))

(defn init-preview [elem]
  (attr elem "src" "/js/main.js"))

(.ajaxError ($ js/document) (partial log "Error"))

(ready
  (init-editor ($ ".editor"))
  (init-preview ($ ".preview"))

  (xhr [:GET "/"] {:message "Hello"} (partial log "Success")))
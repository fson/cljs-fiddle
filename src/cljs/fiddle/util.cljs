(ns fiddle.util
  (:use [jayq.util :only [clj->js]]
        [jayq.core :only [on data $]]))

(defn log [& args]
  (.apply js/console.log js/console (clj->js args)))

(defn act [handler]
  (fn [e]
      (let [action (data ($ (.-currentTarget e)) :action)]
        (handler action))))

(defn react-on [$elem events handler]
  (on $elem events "[data-action]" data (act handler)))

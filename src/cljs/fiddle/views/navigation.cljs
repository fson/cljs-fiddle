(ns fiddle.views.navigation
  (:use [jayq.core :only [on bind data $]]
        [fiddle.util :only [log]]
        [fiddle.views.load :only [init-load]]))

(defmulti react-to keyword)

(defmethod react-to :load [_]
  (init-load))

(defn init-navigation [elem]
  (on elem :click "button[data-action]"
    (fn [e]
      (let [action (data ($ (.-currentTarget e)) :action)]
        (react-to action)))))
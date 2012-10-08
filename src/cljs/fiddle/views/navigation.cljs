(ns fiddle.views.navigation
  (:use [jayq.core :only [on $]]
        [fiddle.util :only [log react-on]]
        [fiddle.views.load :only [init-load]]))

(defmulti handler keyword)

(defmethod handler :load [_]
  (init-load))

(defn init-navigation [elem]
  (react-on elem :click handler))
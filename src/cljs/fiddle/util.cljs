(ns fiddle.util
  (:use [jayq.util :only [clj->js]]))

(defn log [& args]
  (.apply js/console.log js/console (clj->js args)))